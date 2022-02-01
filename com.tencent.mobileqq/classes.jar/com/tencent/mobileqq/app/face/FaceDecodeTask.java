package com.tencent.mobileqq.app.face;

import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.opt.threadpriority.ThreadOptimizer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public abstract class FaceDecodeTask
{
  protected static int EVENT_TASK_COMPLETED = 111;
  protected static int MAX_THREAD_COUNT = 6;
  private static final String TAG = "Q.qqhead.FaceDecodeTask";
  protected static MqqHandler handler;
  protected static Object initlock = new Object();
  protected static ArrayList<FaceDecodeTask> mDecodeQueue;
  protected static FaceDecodeTask.FaceDecodeRunnable[] mDecodeRunnables;
  protected static Thread[] mDecodeThreads;
  private static FaceDecodeTask.FaceDecodeThreadInfo mThreadInfo;
  protected static Looper mainLooper;
  public static ArrayList<FaceDecodeTask> sPendingResultList = new ArrayList(100);
  private AppInterface app;
  protected Bitmap bitmap = null;
  protected FaceInfo faceInfo = null;
  protected WeakReference<DecodeCompletionListener> mDecodeCompletionListenerWrf;
  protected boolean needDownload;
  
  public FaceDecodeTask(AppInterface paramAppInterface, FaceInfo paramFaceInfo, DecodeCompletionListener paramDecodeCompletionListener)
  {
    this.faceInfo = paramFaceInfo;
    this.mDecodeCompletionListenerWrf = new WeakReference(paramDecodeCompletionListener);
    this.needDownload = false;
    this.app = paramAppInterface;
  }
  
  public static void closeFaceDecodeThread()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.FaceDecodeTask", 2, "closeFaceDecodeThread");
    }
    for (;;)
    {
      int i;
      synchronized (initlock)
      {
        if (sPendingResultList != null) {
          sPendingResultList.clear();
        }
        if (handler != null) {
          handler.removeMessages(EVENT_TASK_COMPLETED);
        }
        if (mDecodeRunnables != null)
        {
          i = 0;
          if (i < mDecodeRunnables.length)
          {
            if (mDecodeRunnables[i] != null) {
              mDecodeRunnables[i].close();
            }
          }
          else
          {
            mDecodeRunnables = null;
            mDecodeThreads = null;
          }
        }
        else
        {
          if (mDecodeQueue != null) {}
          synchronized (mDecodeQueue)
          {
            mDecodeQueue.clear();
            mDecodeQueue.notifyAll();
            mDecodeQueue = null;
            mainLooper = null;
            handler = null;
            return;
          }
        }
      }
      i += 1;
    }
  }
  
  public static void execute(FaceDecodeTask paramFaceDecodeTask)
  {
    if ((paramFaceDecodeTask == null) || (paramFaceDecodeTask.isExpired()))
    {
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder().append("execute, decodeTaskInfo is expired, type=");
        if (paramFaceDecodeTask == null) {
          break label57;
        }
      }
      label57:
      for (paramFaceDecodeTask = paramFaceDecodeTask.getClass().getSimpleName();; paramFaceDecodeTask = "")
      {
        QLog.w("Q.qqhead.FaceDecodeTask", 2, paramFaceDecodeTask);
        return;
      }
    }
    initFaceDecodeThread();
    synchronized (mDecodeQueue)
    {
      mDecodeQueue.add(paramFaceDecodeTask);
      mDecodeQueue.notify();
      return;
    }
  }
  
  public static void executeTask(AppInterface paramAppInterface, FaceInfo paramFaceInfo, DecodeCompletionListener paramDecodeCompletionListener)
  {
    execute(getFaceDecodeTask(paramAppInterface, paramFaceInfo, paramDecodeCompletionListener));
  }
  
  public static FaceDecodeTask getFaceDecodeTask(AppInterface paramAppInterface, FaceInfo paramFaceInfo, DecodeCompletionListener paramDecodeCompletionListener)
  {
    if (paramAppInterface == null) {
      return null;
    }
    if ("module_nearby".equals(paramAppInterface.getModuleId())) {
      return new NearByFaceDecodeTask(paramAppInterface, paramFaceInfo, paramDecodeCompletionListener);
    }
    return new FaceDecodeTaskImpl(paramAppInterface, paramFaceInfo, paramDecodeCompletionListener);
  }
  
  public static FaceDecodeTask.FaceDecodeThreadInfo getNearbyFaceDecodeThreadInfo()
  {
    FaceDecodeTask.FaceDecodeThreadInfo localFaceDecodeThreadInfo = new FaceDecodeTask.FaceDecodeThreadInfo();
    int i = Runtime.getRuntime().availableProcessors();
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.FaceDecodeTask", 2, "processor count:" + i);
    }
    if (i >= 4) {}
    do
    {
      return localFaceDecodeThreadInfo;
      localFaceDecodeThreadInfo.maxThreadCount = (i + 1);
    } while (i > 2);
    localFaceDecodeThreadInfo.priority = 10;
    return localFaceDecodeThreadInfo;
  }
  
  private static void initFaceDecodeThread()
  {
    if (mDecodeThreads == null) {
      for (;;)
      {
        synchronized (initlock)
        {
          if (mDecodeThreads == null)
          {
            initHandler();
            String str = BaseApplication.processName;
            initFaceDecodeThreadInfo();
            if (mThreadInfo.maxThreadCount != -2147483648) {
              MAX_THREAD_COUNT = mThreadInfo.maxThreadCount;
            }
            if ((!TextUtils.isEmpty(str)) && (str.equals("com.tencent.mobileqq"))) {
              MAX_THREAD_COUNT = 2;
            }
            mDecodeQueue = new ArrayList();
            mDecodeThreads = new Thread[MAX_THREAD_COUNT];
            mDecodeRunnables = new FaceDecodeTask.FaceDecodeRunnable[MAX_THREAD_COUNT];
            int i = 0;
            try
            {
              if (i < mDecodeThreads.length)
              {
                mDecodeRunnables[i] = new FaceDecodeTask.FaceDecodeRunnable(null);
                mDecodeThreads[i] = ThreadManager.newFreeThread(mDecodeRunnables[i], "FaceDecodeThread", 5);
                if (ThreadOptimizer.a().c()) {
                  mDecodeThreads[i].setPriority(1);
                }
                if (mDecodeThreads[i].getState() != Thread.State.NEW) {
                  break label238;
                }
                mDecodeThreads[i].start();
                bool = true;
                if (QLog.isColorLevel()) {
                  QLog.i("Q.qqhead.FaceDecodeTask", 2, "initFaceDecodeThread, thread isStatusNew=" + bool);
                }
                i += 1;
                continue;
              }
            }
            catch (Throwable localThrowable)
            {
              QLog.e("Q.qqhead.FaceDecodeTask", 1, "initFaceDecodeThread", localThrowable);
              return;
            }
          }
          return;
        }
        label238:
        boolean bool = false;
      }
    }
  }
  
  private static void initFaceDecodeThreadInfo()
  {
    if (TextUtils.isEmpty(BaseApplication.processName)) {}
    for (;;)
    {
      return;
      if (BaseApplication.processName.equals("com.tencent.mobileqq:tool")) {}
      for (mThreadInfo = getNearbyFaceDecodeThreadInfo(); QLog.isColorLevel(); mThreadInfo = new FaceDecodeTask.FaceDecodeThreadInfo())
      {
        QLog.i("Q.qqhead.FaceDecodeTask", 2, "initFaceDecodeThreadInfo, maxThreadCount=" + mThreadInfo.maxThreadCount + ",priority=" + mThreadInfo.priority);
        return;
      }
    }
  }
  
  private static void initHandler()
  {
    mainLooper = Looper.getMainLooper();
    handler = new FaceDecodeTask.1(mainLooper);
  }
  
  protected abstract void doDecodeBitmap();
  
  protected abstract boolean isExpired();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceDecodeTask
 * JD-Core Version:    0.7.0.1
 */