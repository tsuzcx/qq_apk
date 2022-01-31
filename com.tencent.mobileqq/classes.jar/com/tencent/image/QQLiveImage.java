package com.tencent.image;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnDownloadCallbackListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnPreAdListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoOutputFrameListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class QQLiveImage
  implements TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnDownloadCallbackListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnInfoListener, TVK_IMediaPlayer.OnPreAdListener, TVK_IMediaPlayer.OnSeekCompleteListener, TVK_IMediaPlayer.OnVideoOutputFrameListener, TVK_IMediaPlayer.OnVideoPreparedListener
{
  static final int MSG_TYPE_REFRESH = 1;
  public static final long SD_CACHE_LIMIT = 524288000L;
  public static final String TAG = QQLiveImage.class.getSimpleName() + "_";
  public static final String TencentVideoSdkAppKey = "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==";
  private static AtomicBoolean mInstallProgress = new AtomicBoolean(false);
  public static boolean mIsDebugEnable;
  static ReentrantLock mLockForImageList;
  private static boolean mSDKInited;
  private static boolean sAllPaused;
  private static volatile int sCurFgActivityHash;
  private static volatile boolean sEnableUSRLog = false;
  private static volatile ArrayList<QQLiveImage> sImageList;
  private static volatile boolean sIsForeground;
  protected int ID = 0;
  long lastPosi = 0L;
  protected Canvas mCanvas;
  private URLDrawable mCover;
  protected WeakReference<Bitmap> mCoverBitmapRef;
  protected volatile Bitmap mCurFrameBitmap;
  private long mCurPosi;
  private int mDensity = 160;
  protected QQLiveDrawable.OnDownloadListener mDownloadListener;
  private Vector<WeakReference<QQLiveDrawable>> mDrawableList = new Vector();
  private QQLiveDrawable.ErrorInfo mErrorInfo = new QQLiveDrawable.ErrorInfo();
  int mFrameIndex = 0;
  protected Handler mHandler = new QQLiveImage.EventHandler(this, Looper.getMainLooper());
  private long mLastPlayerReleaseTime;
  ReentrantLock mLock = new ReentrantLock();
  protected QQLiveDrawable.OnLoopBackListener mLoopBackListener;
  protected Matrix mMatrix;
  protected WeakReference<QQLiveDrawable.OnStateListener> mOnStateListener;
  protected QQLiveDrawable.QQLiveDrawableParams mParams;
  private volatile boolean mPaused = false;
  private boolean mPlayCompleted = false;
  private int mPlayPostionWhenRecyle = -1;
  private TVK_PlayerVideoInfo mPlayerinfo = null;
  private long mPrepareTime;
  private boolean mPrepared = false;
  private volatile boolean mReclyed = false;
  protected Bitmap mRotatedBitmap;
  protected int mRotation;
  private long mStartPlayTime;
  AtomicInteger mState = new AtomicInteger(0);
  private String mUrlStr;
  private TVK_UserInfo mUserinfo = null;
  private volatile TVK_IMediaPlayer mVideoPlayer = null;
  private TVK_IProxyFactory mfactory = null;
  
  static
  {
    mLockForImageList = new ReentrantLock();
    mSDKInited = false;
    mIsDebugEnable = true;
  }
  
  public QQLiveImage(String paramString, Object paramObject)
  {
    this.mUrlStr = paramString;
    this.ID = paramString.hashCode();
    if (!paramString.startsWith("qqlive")) {
      throw new IllegalStateException("Wrong format url! str=" + paramString);
    }
    if ((paramObject != null) && ((paramObject instanceof QQLiveDrawable.QQLiveDrawableParams)))
    {
      this.mParams = ((QQLiveDrawable.QQLiveDrawableParams)paramObject);
      setOnStateListener(this.mParams.mListener);
      setOnDownloadListener(this.mParams.mDownloadListener);
      setOnLoopBackListener(this.mParams.mLoopBackListener);
    }
    initCover(this.mParams.mCoverUrl);
    addToList(this);
    QLog.d(TAG + this.ID, 1, "QQLiveVideo(): url = " + paramString + ", mParams=" + this.mParams.toString());
    if ((sAllPaused) && (!this.mPaused))
    {
      pause();
      if (QLog.isColorLevel()) {
        QLog.d(TAG + this.ID, 2, "QQLiveVideo(): 全局已经暂停，但是实例创建未暂停，这里主动停一下 ");
      }
    }
  }
  
  private static void addToList(QQLiveImage paramQQLiveImage)
  {
    if (paramQQLiveImage == null) {
      return;
    }
    bool2 = false;
    bool1 = false;
    try
    {
      mLockForImageList.lock();
      if (sImageList == null) {
        sImageList = new ArrayList();
      }
      if (!sImageList.contains(paramQQLiveImage))
      {
        sImageList.add(paramQQLiveImage);
        bool1 = true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(TAG, 2, "addToList()", localException);
        }
        mLockForImageList.unlock();
        bool1 = bool2;
      }
    }
    finally
    {
      mLockForImageList.unlock();
    }
    QLog.i(TAG, 1, "addToList().... addSuccess: " + bool1 + ", ID: " + paramQQLiveImage.ID);
  }
  
  private void asyncReleasePlayer(boolean paramBoolean)
  {
    this.mState.set(10);
    if (this.mVideoPlayer != null) {
      try
      {
        if (this.mVideoPlayer != null)
        {
          this.mVideoPlayer.removeAllListener();
          ThreadManagerV2.executeOnFileThread(new QQLiveImage.ReleaseTask(this, this.mVideoPlayer, paramBoolean));
          this.mVideoPlayer = null;
        }
        return;
      }
      finally {}
    }
  }
  
  private void changeStateAndNotify(int paramInt, Object paramObject)
  {
    if (paramInt != this.mState.get())
    {
      if ((QLog.isColorLevel()) || (sEnableUSRLog)) {
        QLog.d(TAG + this.ID, 2, "changeStateAndNotify(): " + getStateStr(this.mState.get()) + " ===> " + getStateStr(paramInt) + ", extra = " + paramObject);
      }
      this.mState.set(paramInt);
      this.mHandler.post(new QQLiveImage.3(this, paramInt, paramObject));
    }
  }
  
  static Context getApplicationContext()
  {
    return BaseApplication.getContext();
  }
  
  public static ArrayList<QQLiveImage> getImageList()
  {
    return sImageList;
  }
  
  public static String getStateStr(int paramInt)
  {
    switch (paramInt)
    {
    case 7: 
    default: 
      return "STATE_UNKNOW";
    case 0: 
      return "STATE_IDLE";
    case 1: 
      return "STATE_PREPARED";
    case 2: 
      return "STATE_PLAYING";
    case 3: 
      return "STATE_BUFFERING";
    case 4: 
      return "STATE_PAUSE";
    case 5: 
      return "STATE_ERROR";
    case 6: 
      return "STATE_COMPLETE";
    case 8: 
      return "STATE_INITIALIZED";
    }
    return "STATE_PREPARING";
  }
  
  private void initCover(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      if ((this.mCoverBitmapRef == null) || (this.mCoverBitmapRef.get() == null)) {
        try
        {
          this.mCover = URLDrawable.getDrawable(paramString, this.mParams.mCoverWidth, this.mParams.mCoverHeight, this.mParams.mCoverLoadingDrawable, this.mParams.mCoverLoadingDrawable);
          if ((this.mCover.getStatus() == 1) && ((this.mCover.getCurrDrawable() instanceof RegionDrawable)))
          {
            this.mCoverBitmapRef = new WeakReference(((RegionDrawable)this.mCover.getCurrDrawable()).getBitmap());
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d(TAG + this.ID, 2, "initCover(): mCover is loaded: ");
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.e(TAG + this.ID, 2, "initCover(): getDrawable Exception: imgUrl=" + paramString, localException);
          }
          this.mCover = null;
          return;
        }
      }
    }
    this.mCover.setURLDrawableListener(new QQLiveImage.1(this));
    this.mCover.startDownload();
  }
  
  public static boolean isAllPaused()
  {
    return sAllPaused;
  }
  
  public static void onBackground(Activity paramActivity)
  {
    if ((paramActivity != null) && (sCurFgActivityHash != 0) && (paramActivity.hashCode() != sCurFgActivityHash)) {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "onBackground() , curActivityHash = " + paramActivity.hashCode() + ", sCurFgActivityHash = " + sCurFgActivityHash);
      }
    }
    while (!sIsForeground) {
      return;
    }
    sIsForeground = false;
    QLog.d(TAG, 1, "onBackground()......<==");
    ThreadManagerV2.executeOnSubThread(new QQLiveImage.5());
  }
  
  public static void onForeground(Activity paramActivity)
  {
    if (paramActivity != null)
    {
      sCurFgActivityHash = paramActivity.hashCode();
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "onForeground() , sCurFgActivityHash = " + sCurFgActivityHash);
      }
    }
    if (!sIsForeground)
    {
      sIsForeground = true;
      QLog.d(TAG, 1, "onForeground()......==>");
    }
  }
  
  public static void pauseAll(Activity paramActivity)
  {
    if ((paramActivity != null) && (sCurFgActivityHash != 0) && (paramActivity.hashCode() != sCurFgActivityHash)) {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "pauseAll() , curActivityHash = " + paramActivity.hashCode() + ", sCurFgActivityHash = " + sCurFgActivityHash);
      }
    }
    while (sAllPaused) {
      return;
    }
    sAllPaused = true;
    QLog.i(TAG, 1, "do pauseAll");
    ThreadManagerV2.executeOnSubThread(new QQLiveImage.7());
  }
  
  public static void releaseAll(Activity paramActivity)
  {
    if ((paramActivity != null) && (sCurFgActivityHash != 0) && (paramActivity.hashCode() != sCurFgActivityHash))
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "releaseAll() , curActivityHash = " + paramActivity.hashCode() + ", sCurFgActivityHash = " + sCurFgActivityHash);
      }
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        mLockForImageList.lock();
        if (sImageList != null)
        {
          i = 0;
          if (i < sImageList.size())
          {
            paramActivity = (QQLiveImage)sImageList.get(i);
            if (paramActivity == null) {
              break label212;
            }
            paramActivity.release();
            QLog.d(TAG, 1, "release liveImage, index = " + i + ", ID = " + paramActivity.ID);
            break label212;
          }
          sImageList.clear();
          sImageList = null;
        }
      }
      catch (Exception paramActivity)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(TAG, 2, "release liveImage", paramActivity);
        mLockForImageList.unlock();
        continue;
      }
      finally
      {
        mLockForImageList.unlock();
      }
      sAllPaused = false;
      return;
      label212:
      i += 1;
    }
  }
  
  public static void resumeAll(Activity paramActivity)
  {
    if (paramActivity != null)
    {
      sCurFgActivityHash = paramActivity.hashCode();
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "resumeAll() , sCurFgActivityHash = " + sCurFgActivityHash);
      }
    }
    if (sAllPaused)
    {
      sAllPaused = false;
      QLog.i(TAG, 1, "resumeAll() ");
      ThreadManagerV2.executeOnSubThread(new QQLiveImage.6());
    }
  }
  
  public static int scaleFromDensity(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) || (paramInt2 == paramInt3)) {
      return paramInt1;
    }
    return (paramInt1 * paramInt3 + (paramInt2 >> 1)) / paramInt2;
  }
  
  public static void setDebugEnable(boolean paramBoolean)
  {
    mIsDebugEnable = paramBoolean;
  }
  
  public static void setUSRLogEnable(boolean paramBoolean)
  {
    sEnableUSRLog = paramBoolean;
  }
  
  private static void tryReycleFramesUseless(QQLiveImage paramQQLiveImage)
  {
    if (mLockForImageList.tryLock()) {}
    try
    {
      if (sImageList != null)
      {
        int i = 0;
        while (i < sImageList.size())
        {
          QQLiveImage localQQLiveImage = (QQLiveImage)sImageList.get(i);
          if ((localQQLiveImage != null) && (localQQLiveImage.isRecycled()) && (localQQLiveImage != paramQQLiveImage)) {
            localQQLiveImage.recycleCurFrame();
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception paramQQLiveImage)
    {
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, "tryReycleFramesUseless()", paramQQLiveImage);
      }
      return;
    }
    finally
    {
      mLockForImageList.unlock();
    }
  }
  
  public void OnDownloadCallback(String paramString)
  {
    if (this.mDownloadListener != null) {
      this.mDownloadListener.OnDownload(this.mUrlStr, this.mParams, paramString);
    }
  }
  
  public void OnVideoOutputFrame(TVK_IMediaPlayer paramTVK_IMediaPlayer, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramTVK_IMediaPlayer != this.mVideoPlayer) {
      if (QLog.isColorLevel()) {
        QLog.e(TAG + this.ID, 1, "[TVK_IMediaPlayer] OnVideoOutputFrame: mediaPlayer not current player..just return.  mediaPlayer=" + paramTVK_IMediaPlayer);
      }
    }
    label738:
    label747:
    do
    {
      return;
      if (this.mPaused)
      {
        paramTVK_IMediaPlayer.pause();
        QLog.e(TAG + this.ID, 1, "[TVK_IMediaPlayer] OnVideoOutputFrame: paused = true，try pause..");
        return;
      }
      if (this.mPlayCompleted)
      {
        QLog.e(TAG + this.ID, 1, "[TVK_IMediaPlayer] OnVideoOutputFrame: mPlayCompleted = true, return");
        return;
      }
      if (!sIsForeground)
      {
        ThreadManagerV2.executeOnSubThread(new QQLiveImage.8(this));
        return;
      }
      long l;
      if ((this.mParams != null) && (this.mVideoPlayer != null))
      {
        l = this.mVideoPlayer.getCurrentPostion();
        this.mCurPosi = l;
        if (this.mParams.mMaxPlayTimeMs <= 0) {
          break label747;
        }
        if (l >= this.mParams.mMaxPlayTimeMs + this.mParams.mStartPosi)
        {
          if (!this.mParams.mLoopback) {
            break label738;
          }
          QLog.d(TAG + this.ID, 2, "[TVK_IMediaPlayer] OnVideoOutputFrame: mLoopback is true, seekTo startPosi , " + this.mParams.mStartPosi);
          this.mVideoPlayer.seekTo(this.mParams.mStartPosi);
          if (this.mLoopBackListener != null)
          {
            this.mLoopBackListener.onLoopBack(this.mParams, l);
            if (QLog.isColorLevel()) {
              QLog.d(TAG + this.ID, 2, "[TVK_IMediaPlayer] OnVideoOutputFrame: on loopBack ");
            }
          }
        }
        this.lastPosi = l;
      }
      else
      {
        if (paramArrayOfByte == null) {
          continue;
        }
        System.currentTimeMillis();
        paramTVK_IMediaPlayer = ByteBuffer.wrap(paramArrayOfByte);
        this.mLock.lock();
      }
      for (;;)
      {
        try
        {
          if (this.mCurFrameBitmap == null)
          {
            this.mCurFrameBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.RGB_565);
            this.mRotation = paramInt3;
            tryReycleFramesUseless(this);
            if (QLog.isColorLevel()) {
              QLog.i(TAG + this.ID, 2, "[TVK_IMediaPlayer] OnVideoOutputFrame():createBitmap  width = " + paramInt1 + ", height = " + paramInt2 + ", arg3 = " + paramInt3 + ",arg4=" + paramInt4);
            }
          }
          this.mCurFrameBitmap.copyPixelsFromBuffer(paramTVK_IMediaPlayer);
          if (this.mRotation != 0)
          {
            if (this.mRotatedBitmap == null)
            {
              if ((this.mRotation != 90) && (this.mRotation != 270)) {
                continue;
              }
              this.mRotatedBitmap = Bitmap.createBitmap(paramInt2, paramInt1, Bitmap.Config.RGB_565);
            }
            if (this.mCanvas == null) {
              this.mCanvas = new Canvas(this.mRotatedBitmap);
            }
            if (this.mMatrix == null)
            {
              this.mMatrix = new Matrix();
              paramInt1 = this.mCurFrameBitmap.getWidth();
              paramInt2 = this.mCurFrameBitmap.getHeight();
              this.mMatrix.postRotate(this.mRotation, paramInt1 / 2, paramInt2 / 2);
              this.mMatrix.postTranslate((this.mRotatedBitmap.getWidth() - paramInt1) / 2.0F, (this.mRotatedBitmap.getHeight() - paramInt2) / 2.0F);
            }
            if (this.mCurFrameBitmap != null) {
              this.mCanvas.drawBitmap(this.mCurFrameBitmap, this.mMatrix, null);
            }
          }
          this.mFrameIndex += 1;
        }
        catch (Exception paramTVK_IMediaPlayer)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e(TAG + this.ID, 2, "[TVK_IMediaPlayer] OnVideoOutputFrame: exception happens... ", paramTVK_IMediaPlayer);
          this.mLock.unlock();
          continue;
        }
        catch (OutOfMemoryError paramTVK_IMediaPlayer)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e(TAG + this.ID, 2, "[TVK_IMediaPlayer] OnVideoOutputFrame: Catch OutOfMemoryError... ");
          this.mLock.unlock();
          continue;
        }
        finally
        {
          this.mLock.unlock();
        }
        System.currentTimeMillis();
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessage(1);
        changeStateAndNotify(2, null);
        return;
        onCompletion(this.mVideoPlayer);
        return;
        if ((!this.mParams.mLoopback) || (this.mLoopBackListener == null) || (this.mVideoPlayer.getDuration() <= 0L) || (l >= this.lastPosi) || (this.lastPosi / 1000L < this.mVideoPlayer.getDuration() / 1000L)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(TAG + this.ID, 2, "[TVK_IMediaPlayer] OnVideoOutputFrame  on loopBack ");
        }
        this.mLoopBackListener.onLoopBack(this.mParams, this.lastPosi);
        break;
        this.mRotatedBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.RGB_565);
      }
    } while (!QLog.isColorLevel());
    QLog.e(TAG + this.ID, 2, "[TVK_IMediaPlayer] OnVideoOutputFrame: data = null");
  }
  
  public void attachDrawable(QQLiveDrawable paramQQLiveDrawable)
  {
    if (paramQQLiveDrawable != null) {
      synchronized (this.mDrawableList)
      {
        if (!this.mDrawableList.contains(paramQQLiveDrawable)) {
          this.mDrawableList.add(new WeakReference(paramQQLiveDrawable));
        }
        return;
      }
    }
  }
  
  public void detachDrawable(QQLiveDrawable paramQQLiveDrawable)
  {
    if (paramQQLiveDrawable != null)
    {
      Vector localVector = this.mDrawableList;
      int i = 0;
      for (;;)
      {
        try
        {
          if (i < this.mDrawableList.size())
          {
            Object localObject = (WeakReference)this.mDrawableList.get(i);
            if ((localObject == null) || (((WeakReference)localObject).get() == paramQQLiveDrawable))
            {
              localObject = this.mDrawableList;
              int j = i - 1;
              ((Vector)localObject).remove(i);
              i = j;
            }
            else if (((WeakReference)localObject).get() == paramQQLiveDrawable)
            {
              this.mDrawableList.remove(i);
            }
          }
          else
          {
            return;
          }
        }
        finally {}
        i += 1;
      }
    }
  }
  
  protected void draw(Canvas paramCanvas, Rect paramRect, Paint paramPaint)
  {
    if ((this.mCurFrameBitmap != null) || (this.mRotatedBitmap != null)) {
      if ((this.mRotation != 0) && (this.mRotatedBitmap != null)) {
        paramCanvas.drawBitmap(this.mRotatedBitmap, null, paramRect, paramPaint);
      }
    }
    do
    {
      while ((this.mVideoPlayer == null) && (this.mParams != null) && (!this.mPaused) && (!this.mPlayCompleted) && (this.mState.get() != 5))
      {
        initAndStartPlayer(this.mParams.mStartPosi);
        return;
        if (this.mCurFrameBitmap != null)
        {
          paramCanvas.drawBitmap(this.mCurFrameBitmap, null, paramRect, paramPaint);
          continue;
          if ((this.mCoverBitmapRef != null) && (this.mCoverBitmapRef.get() != null))
          {
            paramCanvas.drawBitmap((Bitmap)this.mCoverBitmapRef.get(), null, paramRect, paramPaint);
          }
          else if ((this.mParams != null) && (this.mParams.mCoverLoadingDrawable != null))
          {
            if (!this.mParams.mCoverLoadingDrawable.getBounds().equals(paramRect)) {
              this.mParams.mCoverLoadingDrawable.setBounds(paramRect);
            }
            this.mParams.mCoverLoadingDrawable.draw(paramCanvas);
          }
          else if (QLog.isColorLevel())
          {
            QLog.w(TAG + this.ID, 2, "draw(): nothing to draw");
          }
        }
      }
    } while ((!QLog.isColorLevel()) || (this.mVideoPlayer != null));
    QLog.w(TAG + this.ID, 2, "draw(): mVideoPlayer == null, mPaused = " + this.mPaused + ", mPlayCompleted = " + this.mPlayCompleted + ",mState=" + getStateStr(this.mState.get()));
  }
  
  protected void finalize()
  {
    if (this.mVideoPlayer != null) {
      release();
    }
  }
  
  public int getByteSize()
  {
    if (this.mCoverBitmapRef != null) {}
    for (int i = Utils.getBitmapSize((Bitmap)this.mCoverBitmapRef.get()) + 0;; i = 0) {
      return i + Utils.getBitmapSize(this.mCurFrameBitmap);
    }
  }
  
  public long getCurrentPosition()
  {
    for (long l1 = -1L;; l1 = l2)
    {
      try
      {
        if (this.mVideoPlayer == null) {
          break label78;
        }
        l2 = this.mVideoPlayer.getCurrentPostion();
        l1 = l2;
      }
      catch (Throwable localThrowable)
      {
        long l2;
        label23:
        label78:
        break label23;
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG + this.ID, 2, "getCurrentPosition() curPosi = " + l1);
      }
      return l1;
      l2 = this.mCurPosi;
    }
  }
  
  public int getHeight()
  {
    if (this.mCurFrameBitmap != null)
    {
      if ((this.mRotation == 0) || (this.mRotation == 180)) {
        return this.mCurFrameBitmap.getHeight();
      }
      return this.mCurFrameBitmap.getWidth();
    }
    if ((this.mCoverBitmapRef != null) && (this.mCoverBitmapRef.get() != null)) {
      return ((Bitmap)this.mCoverBitmapRef.get()).getHeight();
    }
    if (this.mParams != null) {
      return this.mParams.mPreviewHeight;
    }
    return 0;
  }
  
  public long getMsgUniseq()
  {
    if (this.mParams != null) {
      return this.mParams.msgUniseq;
    }
    return 0L;
  }
  
  public int getPlayState()
  {
    return this.mState.get();
  }
  
  public int getScaledHeight(int paramInt)
  {
    return scaleFromDensity(getHeight(), this.mDensity, paramInt);
  }
  
  public int getScaledWidth(int paramInt)
  {
    return scaleFromDensity(getWidth(), this.mDensity, paramInt);
  }
  
  public int getWidth()
  {
    if (this.mCurFrameBitmap != null)
    {
      if ((this.mRotation == 0) || (this.mRotation == 180)) {
        return this.mCurFrameBitmap.getWidth();
      }
      return this.mCurFrameBitmap.getHeight();
    }
    if ((this.mCoverBitmapRef != null) && (this.mCoverBitmapRef.get() != null)) {
      return ((Bitmap)this.mCoverBitmapRef.get()).getWidth();
    }
    if (this.mParams != null) {
      return this.mParams.mPreviewWidth;
    }
    return 0;
  }
  
  protected void initAndStartPlayer(int paramInt)
  {
    if (this.mPaused) {
      if (QLog.isColorLevel()) {
        QLog.d(TAG + this.ID, 2, "initAndStartPlayer(): paused, just return");
      }
    }
    do
    {
      return;
      if ((this.mState.get() != 9) && (this.mState.get() != 8)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w(TAG + this.ID, 2, "initAndStartPlayer(): initialed or preparing, just return");
    return;
    changeStateAndNotify(3, null);
    ThreadManagerV2.excute(new QQLiveImage.4(this, getApplicationContext(), paramInt), 64, null, false);
  }
  
  protected void invalidateSelf()
  {
    Vector localVector = this.mDrawableList;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.mDrawableList.size())
        {
          Object localObject1 = (WeakReference)this.mDrawableList.get(i);
          if ((localObject1 == null) || (((WeakReference)localObject1).get() == null))
          {
            localObject1 = this.mDrawableList;
            int j = i - 1;
            ((Vector)localObject1).remove(i);
            i = j;
          }
          else
          {
            ((QQLiveDrawable)((WeakReference)localObject1).get()).invalidateSelf();
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public boolean isPaused()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG + this.ID, 2, "isPaused(): mPaused = " + this.mPaused);
    }
    return this.mPaused;
  }
  
  public boolean isRecycled()
  {
    return this.mReclyed;
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG + this.ID, 2, "[TVK_IMediaPlayer] onCompletion(): ");
    }
    asyncReleasePlayer(false);
    this.mPrepared = false;
    this.mPlayCompleted = true;
    changeStateAndNotify(6, null);
  }
  
  public void onDetachedFromWindow()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG + this.ID, 2, "onDetachedFromWindow() ");
    }
    if (this.mParams != null)
    {
      this.mParams.mListener = null;
      this.mParams.mDownloadListener = null;
      this.mParams.mLoopBackListener = null;
    }
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    this.mErrorInfo.model = paramInt1;
    this.mErrorInfo.what = paramInt2;
    this.mErrorInfo.extra = paramInt3;
    this.mErrorInfo.detailInfo = paramString;
    this.mErrorInfo.info = paramObject;
    if (QLog.isColorLevel())
    {
      paramString = TAG + this.ID;
      paramObject = new StringBuilder().append("[TVK_IMediaPlayer] onError(): \n").append(this.mErrorInfo.toString()).append("\n");
      if (this.mParams != null) {
        break label152;
      }
    }
    label152:
    for (paramTVK_IMediaPlayer = "mParams=null";; paramTVK_IMediaPlayer = this.mParams.toString())
    {
      QLog.e(paramString, 2, paramTVK_IMediaPlayer);
      asyncReleasePlayer(false);
      this.mPrepared = false;
      changeStateAndNotify(5, this.mErrorInfo);
      return false;
    }
  }
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d(TAG + this.ID, 2, "[TVK_IMediaPlayer] onInfo(): 视频开始缓冲==>");
      }
      changeStateAndNotify(3, null);
      continue;
      if (QLog.isColorLevel()) {
        QLog.d(TAG + this.ID, 2, "[TVK_IMediaPlayer] onInfo(): 视频缓冲结束<==");
      }
      if (this.mPaused) {
        changeStateAndNotify(4, null);
      } else {
        changeStateAndNotify(2, null);
      }
    }
  }
  
  public void onPreAdPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG + this.ID, 2, "[TVK_IMediaPlayer] onPreAdPrepared(): adDuration = " + paramLong);
    }
    this.mVideoPlayer.start();
  }
  
  public void onPreAdPreparing(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG + this.ID, 2, "[TVK_IMediaPlayer] onPreAdPreparing(): ");
    }
  }
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (!this.mPaused)
    {
      if (this.mVideoPlayer != null) {
        this.mVideoPlayer.start();
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG + this.ID, 2, "[TVK_IMediaPlayer] onSeekComplete, start ");
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e(TAG + this.ID, 2, "[TVK_IMediaPlayer] onSeekComplete, paused, just return.");
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.mPrepared = true;
    if (!this.mPaused)
    {
      changeStateAndNotify(1, null);
      if (this.mState.get() == 10)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "mState.get() == OnStateListener.STATE_RELEASED");
        }
        asyncReleasePlayer(false);
      }
      if (this.mVideoPlayer != null) {
        this.mVideoPlayer.start();
      }
      int i = paramTVK_IMediaPlayer.getVideoWidth();
      int j = paramTVK_IMediaPlayer.getVideoHeight();
      if (this.mStartPlayTime > 0L) {
        this.mPrepareTime = (SystemClock.uptimeMillis() - this.mStartPlayTime);
      }
      StringBuilder localStringBuilder = new StringBuilder(256);
      localStringBuilder.append("prepareTime:").append(this.mPrepareTime).append("\n");
      localStringBuilder.append("width:").append(i).append("\n");
      localStringBuilder.append("height:").append(j).append("\n");
      paramTVK_IMediaPlayer = paramTVK_IMediaPlayer.getPlayDetailsTime();
      if (paramTVK_IMediaPlayer != null)
      {
        Iterator localIterator = paramTVK_IMediaPlayer.keySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject = localIterator.next();
          localStringBuilder.append(localObject).append(" ：").append(paramTVK_IMediaPlayer.get(localObject)).append("\n");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i(TAG + this.ID, 2, "[TVK_IMediaPlayer] onVideoPrepared():  " + localStringBuilder.toString());
      }
      return;
    }
    paramTVK_IMediaPlayer.pause();
    QLog.e(TAG + this.ID, 1, "[TVK_IMediaPlayer] onVideoPrepared(): But paused, try pause! ");
  }
  
  public void pause()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((!this.mPaused) && (!this.mPlayCompleted) && (this.mState.get() != 6) && (this.mState.get() != 5)) {
      if (this.mVideoPlayer == null) {
        break label227;
      }
    }
    for (;;)
    {
      try
      {
        if (this.mVideoPlayer == null) {
          break label216;
        }
        if (this.mVideoPlayer.isPlaying())
        {
          localStringBuilder.append("step: mVideoPlayer.isPlaying, pause;");
          this.mVideoPlayer.pause();
          this.mPaused = true;
          changeStateAndNotify(4, null);
          QLog.d(TAG + this.ID, 1, "pause():  " + localStringBuilder.toString());
          return;
        }
        if (this.mVideoPlayer.isPauseing())
        {
          localStringBuilder.append("step: mVideoPlayer.isPauseing, do nothing;");
          continue;
        }
        localObject.append("step: player unknow status，prepared=" + this.mPrepared);
      }
      finally {}
      continue;
      label216:
      localObject.append("step: player = null.");
      continue;
      label227:
      localObject.append("step: player = null.");
    }
  }
  
  public void recycleCurFrame()
  {
    if (this.mLock.tryLock())
    {
      this.mCurFrameBitmap = null;
      this.mLock.unlock();
      if (QLog.isColorLevel()) {
        QLog.d(TAG + this.ID, 2, "recycleCurFrame()");
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w(TAG + this.ID, 2, "recycleCurFrame() failed by can't accqure lock ");
  }
  
  public void recyleAndKeepPostion()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.mVideoPlayer;
    if (this.mVideoPlayer != null)
    {
      this.mPlayPostionWhenRecyle = ((int)this.mVideoPlayer.getCurrentPostion());
      asyncReleasePlayer(true);
      this.mLastPlayerReleaseTime = SystemClock.uptimeMillis();
    }
    this.mReclyed = true;
    this.mOnStateListener = null;
    this.mDownloadListener = null;
    this.mLoopBackListener = null;
    this.mPrepared = false;
    this.mPrepareTime = 0L;
    this.mStartPlayTime = 0L;
    QLog.d(TAG + this.ID, 1, "recyleAndKeepPostion()：mPlayPostionWhenRecyle = " + this.mPlayPostionWhenRecyle + ", mReclyed = " + this.mReclyed + ", mVideoPlayer=" + localTVK_IMediaPlayer);
  }
  
  public void recyleAndNotKeepPosition()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.mVideoPlayer;
    if (this.mVideoPlayer != null)
    {
      asyncReleasePlayer(false);
      this.mLastPlayerReleaseTime = SystemClock.uptimeMillis();
    }
    if (this.mParams != null) {
      this.mParams.mStartPosi = 0;
    }
    this.mPlayPostionWhenRecyle = 0;
    this.mReclyed = true;
    this.mPrepared = false;
    this.mPrepareTime = 0L;
    this.mStartPlayTime = 0L;
    this.mPlayCompleted = false;
    QLog.d(TAG + this.ID, 1, " recyleForOnItemSelect()：mPlayPostionWhenRecyle = " + this.mPlayPostionWhenRecyle + ", mReclyed = " + this.mReclyed + ", mVideoPlayer=" + localTVK_IMediaPlayer + " this=" + this);
  }
  
  public void recyleFor2Background()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.mVideoPlayer;
    if (this.mVideoPlayer != null)
    {
      this.mPlayPostionWhenRecyle = ((int)this.mVideoPlayer.getCurrentPostion());
      asyncReleasePlayer(true);
      this.mLastPlayerReleaseTime = SystemClock.uptimeMillis();
    }
    this.mReclyed = true;
    this.mPrepared = false;
    this.mPrepareTime = 0L;
    this.mStartPlayTime = 0L;
    QLog.d(TAG + this.ID, 1, "recyleFor2Background()：mPlayPostionWhenRecyle = " + this.mPlayPostionWhenRecyle + ", mReclyed = " + this.mReclyed + ", mVideoPlayer=" + localTVK_IMediaPlayer);
  }
  
  public void release()
  {
    try
    {
      mLockForImageList.lock();
      if (sImageList != null) {
        sImageList.remove(this);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException = localException;
        if (QLog.isColorLevel()) {
          QLog.e(TAG, 2, "release()", localException);
        }
        mLockForImageList.unlock();
      }
    }
    finally
    {
      mLockForImageList.unlock();
    }
    asyncReleasePlayer(false);
    if (this.mLock.tryLock())
    {
      this.mCurFrameBitmap = null;
      this.mLock.unlock();
    }
    this.mRotatedBitmap = null;
    this.mCover = null;
    this.mCoverBitmapRef = null;
    this.mOnStateListener = null;
    this.mDownloadListener = null;
    this.mLoopBackListener = null;
    if (this.mParams == null) {}
  }
  
  public void replay()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((this.mState.get() == 6) && (this.mPlayCompleted) && (this.mVideoPlayer == null))
    {
      this.mParams.mStartPosi = 0;
      this.mPlayCompleted = false;
      localStringBuilder.append(" mPlayCompleted, replay!");
      invalidateSelf();
      changeStateAndNotify(3, null);
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG + this.ID, 2, "replay(): " + localStringBuilder.toString());
    }
  }
  
  public void resume()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((this.mState.get() != 5) && (this.mState.get() != 6) && (!this.mPlayCompleted)) {
      if (this.mVideoPlayer == null) {}
    }
    for (;;)
    {
      try
      {
        if (this.mVideoPlayer != null)
        {
          if (this.mVideoPlayer.isPlaying()) {
            localStringBuilder.append("step: mVideoPlayer.isPlaying, do nothing;");
          }
        }
        else
        {
          this.mPaused = false;
          QLog.d(TAG + this.ID, 1, " resume(): " + localStringBuilder.toString() + "this=" + this);
          return;
        }
        if (this.mVideoPlayer.isPauseing())
        {
          this.mVideoPlayer.start();
          localStringBuilder.append("step: mVideoPlayer.isPauseing, start;");
          continue;
        }
        localObject.append("step: #player unknow status#").append(", playState=" + getStateStr(this.mState.get()));
      }
      finally {}
      if (this.mPrepared)
      {
        this.mVideoPlayer.start();
        localObject.append(" prepared. start;");
      }
      else
      {
        localObject.append(" not prepared. wait buffering;");
        changeStateAndNotify(3, null);
        continue;
        localObject.append("step: player = null.");
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
          invalidateSelf();
        }
        for (;;)
        {
          changeStateAndNotify(3, null);
          if ((!this.mReclyed) || (this.mPlayPostionWhenRecyle <= -1) || (this.mParams == null)) {
            break;
          }
          localObject.append("step: mReclyed, mPlayPostionWhenRecyle:").append(this.mPlayPostionWhenRecyle);
          this.mReclyed = false;
          this.mParams.mStartPosi = this.mPlayPostionWhenRecyle;
          this.mPlayPostionWhenRecyle = -1;
          break;
          this.mHandler.removeMessages(1);
          this.mHandler.sendEmptyMessage(1);
        }
        if (this.mState.get() == 5)
        {
          changeStateAndNotify(5, null);
          localObject.append("step: STATE_ERROR, just notify");
        }
      }
    }
  }
  
  public void resumeFromPosi(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((this.mState.get() != 5) && (this.mState.get() != 6) && (!this.mPlayCompleted))
    {
      if (this.mVideoPlayer == null) {
        break label277;
      }
      if (!this.mVideoPlayer.isPlaying()) {
        break label155;
      }
      localStringBuilder.append("step: mVideoPlayer.isPlaying, seekto");
      this.mVideoPlayer.seekTo(paramInt);
    }
    label277:
    for (;;)
    {
      this.mPaused = false;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(TAG + this.ID, 2, "resumeFromPosi(): " + localStringBuilder.toString() + ", position = " + paramInt);
      return;
      label155:
      if (this.mVideoPlayer.isPauseing())
      {
        localStringBuilder.append("step: mVideoPlayer.isPauseing, seekto;");
        this.mVideoPlayer.seekTo(paramInt);
      }
      else
      {
        localStringBuilder.append("step: #player unknow status#").append(", playState=" + getStateStr(this.mState.get()));
        if (this.mPrepared)
        {
          this.mVideoPlayer.seekTo(paramInt);
          localStringBuilder.append(" prepared. seekTo;");
        }
        else
        {
          localStringBuilder.append(" not prepared. reset, wait buffering;");
          invalidateSelf();
          changeStateAndNotify(3, null);
          continue;
          localStringBuilder.append("step: player = null.");
          this.mPrepared = false;
          invalidateSelf();
          changeStateAndNotify(3, null);
          if ((this.mReclyed) && (this.mParams != null))
          {
            localStringBuilder.append("step: mReclyed, mPlayPostionWhenRecyle:").append(this.mPlayPostionWhenRecyle);
            this.mReclyed = false;
          }
        }
      }
    }
  }
  
  public void seek(int paramInt)
  {
    if (this.mVideoPlayer != null) {
      this.mVideoPlayer.seekTo(paramInt);
    }
  }
  
  protected void setOnDownloadListener(QQLiveDrawable.OnDownloadListener paramOnDownloadListener)
  {
    this.mDownloadListener = paramOnDownloadListener;
  }
  
  protected void setOnLoopBackListener(QQLiveDrawable.OnLoopBackListener paramOnLoopBackListener)
  {
    this.mLoopBackListener = paramOnLoopBackListener;
  }
  
  protected void setOnStateListener(QQLiveDrawable.OnStateListener paramOnStateListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG + this.ID, 2, "setOnStateListener(): mState = " + getStateStr(this.mState.get()) + ", AndNotify");
    }
    this.mOnStateListener = new WeakReference(paramOnStateListener);
    int i = this.mState.get();
    this.mHandler.post(new QQLiveImage.2(this, i));
  }
  
  public void start()
  {
    if (this.mVideoPlayer != null) {
      this.mVideoPlayer.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.QQLiveImage
 * JD-Core Version:    0.7.0.1
 */