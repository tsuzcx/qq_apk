package com.tencent.biz.qqcircle.richframework.preload.coldboot;

import android.os.Handler;
import com.tencent.biz.qqcircle.helpers.QCircleVideoPreloadHelper;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.coldboot.IPreloadTask;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class QCircleColdBootPreloadFeedManager
  implements IPreloadResultCallback, SimpleEventReceiver
{
  private static final String TAG = "QCircleColdBootPreloadFeedManager";
  private static volatile QCircleColdBootPreloadFeedManager sInstance;
  private volatile boolean mIsLocked;
  private final QCircleVideoPreloadHelper mPreloadHelper = new QCircleVideoPreloadHelper(RFApplication.getApplication().hashCode());
  private volatile ConcurrentHashMap<Integer, IPreloadTask> mPreloadMap = new ConcurrentHashMap();
  private final Runnable mPreloadRunnable = new QCircleColdBootPreloadFeedManager.1(this);
  
  private QCircleColdBootPreloadFeedManager()
  {
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  private void clear(int paramInt)
  {
    IPreloadTask localIPreloadTask = (IPreloadTask)this.mPreloadMap.remove(Integer.valueOf(paramInt));
    if (localIPreloadTask != null) {
      localIPreloadTask.removePreloadData();
    }
  }
  
  private void destroy()
  {
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public static void doClear(int paramInt)
  {
    QLog.d("QCircleColdBootPreloadFeedManager", 1, new Object[] { "doClear,source: ", Integer.valueOf(paramInt) });
    getInstance().clear(paramInt);
  }
  
  public static boolean doGetIsAvailable(int paramInt)
  {
    if (!isSupportPreload(paramInt))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("don't support input source: ");
      localStringBuilder.append(paramInt);
      QLog.e("QCircleColdBootPreloadFeedManager", 1, localStringBuilder.toString());
      return false;
    }
    if (!QCircleConfigHelper.bq())
    {
      QLog.e("QCircleColdBootPreloadFeedManager", 1, new Object[] { "preload switch is close,source: ", Integer.valueOf(paramInt) });
      return false;
    }
    return getInstance().isAvailable(paramInt);
  }
  
  public static IPreloadTask doGetTask(int paramInt)
  {
    if (!isSupportPreload(paramInt))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("don't support input source: ");
      localStringBuilder.append(paramInt);
      QLog.e("QCircleColdBootPreloadFeedManager", 1, localStringBuilder.toString());
      return null;
    }
    return getInstance().getTask(paramInt);
  }
  
  public static void doLock()
  {
    QLog.d("QCircleColdBootPreloadFeedManager", 1, "doLock");
    getInstance().lock();
  }
  
  public static void doPreload(int paramInt)
  {
    StringBuilder localStringBuilder;
    if (!QCircleConfigHelper.bg())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("don't support scene source: ");
      localStringBuilder.append(paramInt);
      QLog.e("QCircleColdBootPreloadFeedManager", 1, localStringBuilder.toString());
      return;
    }
    if (!isSupportPreload(paramInt))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("don't support input source: ");
      localStringBuilder.append(paramInt);
      QLog.e("QCircleColdBootPreloadFeedManager", 1, localStringBuilder.toString());
      return;
    }
    if (!QCircleConfigHelper.bq())
    {
      QLog.e("QCircleColdBootPreloadFeedManager", 1, new Object[] { "preload switch is close,source: ", Integer.valueOf(paramInt) });
      return;
    }
    if (getInstance().isLocked())
    {
      QLog.e("QCircleColdBootPreloadFeedManager", 1, new Object[] { "preload is locked in use,source: ", Integer.valueOf(paramInt) });
      return;
    }
    getInstance().preloadFeed(paramInt);
  }
  
  public static void doPrepare()
  {
    getInstance().prepare();
  }
  
  private void doPrepareInner()
  {
    RFThreadManager.getSerialThreadHandler().removeCallbacks(this.mPreloadRunnable);
    RFThreadManager.getSerialThreadHandler().post(this.mPreloadRunnable);
  }
  
  public static void doUnlock()
  {
    QLog.d("QCircleColdBootPreloadFeedManager", 1, "doUnlock");
    getInstance().unlock();
  }
  
  public static QCircleColdBootPreloadFeedManager getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new QCircleColdBootPreloadFeedManager();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  private IPreloadTask getTask(int paramInt)
  {
    if (!this.mPreloadMap.containsKey(Integer.valueOf(paramInt)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getTask failed,source: ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.e("QCircleColdBootPreloadFeedManager", 1, ((StringBuilder)localObject).toString());
      return null;
    }
    QLog.d("QCircleColdBootPreloadFeedManager", 1, new Object[] { "getTask success,source: ", Integer.valueOf(paramInt) });
    Object localObject = (IPreloadTask)this.mPreloadMap.remove(Integer.valueOf(paramInt));
    if (localObject != null) {
      ((IPreloadTask)localObject).removePreloadData();
    }
    return localObject;
  }
  
  private static boolean isSupportPreload(int paramInt)
  {
    return paramInt == 10;
  }
  
  private void lock()
  {
    this.mIsLocked = true;
  }
  
  private void preloadFeed(int paramInt)
  {
    if (!this.mPreloadMap.containsKey(Integer.valueOf(paramInt))) {
      this.mPreloadMap.put(Integer.valueOf(paramInt), new QCircleColdBootPreloadTask(paramInt, this));
    }
    IPreloadTask localIPreloadTask = (IPreloadTask)this.mPreloadMap.get(Integer.valueOf(paramInt));
    if (localIPreloadTask != null) {
      localIPreloadTask.preloadFeed();
    }
  }
  
  private void prepare()
  {
    if (!QQVideoPlaySDKManager.isSDKReady())
    {
      QQVideoPlaySDKManager.initSDKAsync(RFApplication.getApplication(), new QCircleColdBootPreloadFeedManager.2(this));
      QLog.d("QCircleColdBootPreloadFeedManager", 1, "QQVideoPlaySDK is not ready,need install sdk first！");
      return;
    }
    doPrepareInner();
  }
  
  public static void releaseInstance()
  {
    if (sInstance != null) {
      try
      {
        if (sInstance != null)
        {
          sInstance.destroy();
          sInstance = null;
        }
        return;
      }
      finally {}
    }
  }
  
  private void unlock()
  {
    this.mIsLocked = false;
  }
  
  public void doPreloadImage(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doPreloadImage url:");
    localStringBuilder.append(paramStFeed.cover.picUrl.get());
    QLog.d("QCircleColdBootPreloadFeedManager", 1, localStringBuilder.toString());
    paramStFeed = new Option().setUrl(paramStFeed.cover.picUrl.get());
    QCircleFeedPicLoader.g().loadImage(paramStFeed, null);
  }
  
  public void doPreloadVideo(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doPreloadVideo url:");
    localStringBuilder.append(paramStFeed.video.playUrl.get());
    QLog.d("QCircleColdBootPreloadFeedManager", 1, localStringBuilder.toString());
    this.mPreloadHelper.a(paramStFeed);
  }
  
  public ArrayList<Class> getEventClass()
  {
    return new ArrayList();
  }
  
  public boolean isAvailable(int paramInt)
  {
    Object localObject = (IPreloadTask)this.mPreloadMap.get(Integer.valueOf(paramInt));
    if (localObject != null) {
      return ((IPreloadTask)localObject).hasPreloadData();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("is unavailable,source: ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.e("QCircleColdBootPreloadFeedManager", 1, ((StringBuilder)localObject).toString());
    return false;
  }
  
  public boolean isLocked()
  {
    return this.mIsLocked;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.preload.coldboot.QCircleColdBootPreloadFeedManager
 * JD-Core Version:    0.7.0.1
 */