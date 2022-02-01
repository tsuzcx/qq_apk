package com.tencent.component.media.gif;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.utils.ImageManagerLog;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class NewGifDrawable
  extends Drawable
  implements Animatable, GifPlayerControl
{
  public static final int MODEL_NORMAL_LOOP = 1;
  public static final int MODEL_REVERSE_LOOP = 2;
  public static final int MODEL_WAIT = 3;
  public static final int MODEL_WAIT_FILE = 4;
  public static final int STATE_PLAYING = 2;
  public static final int STATE_PLAY_ANY_CASE = 0;
  public static final int STATE_PLAY_END = 3;
  public static final int STATE_PLAY_START = 1;
  private static final String TAG = "NewGifDrawable";
  private volatile int curPlayCount;
  private NewGifDrawable.GifPlayListener gifPlayListener;
  public boolean isEndDownload = false;
  public Bitmap mBuffer;
  private long mCreateTime;
  private Handler mCtrlHandler = new Handler(ImageManagerEnv.g().getDispatcher());
  private int mCurrentModel = 1;
  private long mDrawCounts;
  private final Rect mDstRect = new Rect();
  final ScheduledThreadPoolExecutor mExecutor;
  private float mFactor = 1.0F;
  private float mFrameRate;
  private boolean mFrameRateReported;
  NewGifDecoder mGifDecoder;
  public int mHashcode = 0;
  final InvalidationHandler mInvalidationHandler;
  protected boolean mIsRenderingTriggeredOnDraw = true;
  private volatile boolean mIsResetting;
  volatile boolean mIsRunning = true;
  private boolean mIsSharpp;
  final ConcurrentLinkedQueue<AnimationListener> mListeners = new ConcurrentLinkedQueue();
  public final Object mLock4Bmp = new Object();
  private float mMaxFrameRate;
  long mNextFrameRenderTime = -9223372036854775808L;
  protected final Paint mPaint = new Paint(6);
  private final RenderTask mRenderTask;
  ScheduledFuture<?> mSchedule;
  private final Rect mSrcRect;
  private long mStartTimeStamp;
  private NewGifDrawable.StopRunnable mStopTask;
  private int mTaskType;
  private ColorStateList mTint;
  private PorterDuffColorFilter mTintFilter;
  private PorterDuff.Mode mTintMode;
  private int sHeight = 0;
  private int sWidth = 0;
  private Object tag;
  public String url;
  
  public NewGifDrawable(ContentResolver paramContentResolver, Uri paramUri)
  {
    this(GifInfoHandle.openUri(paramContentResolver, paramUri, false, null), null, null, true, null);
  }
  
  public NewGifDrawable(AssetFileDescriptor paramAssetFileDescriptor)
  {
    this(GifInfoHandle.openAssetFileDescriptor(paramAssetFileDescriptor, false, null), null, null, true, null);
  }
  
  public NewGifDrawable(AssetManager paramAssetManager, String paramString)
  {
    this(paramAssetManager.openFd(paramString));
  }
  
  public NewGifDrawable(Resources paramResources, int paramInt)
  {
    this(paramResources.openRawResourceFd(paramInt));
  }
  
  NewGifDrawable(GifInfoHandle paramGifInfoHandle, NewGifDrawable paramNewGifDrawable, ScheduledThreadPoolExecutor paramScheduledThreadPoolExecutor, boolean paramBoolean, NewGifDecoder.Options paramOptions)
  {
    this(new GenericNewGifDecoder(paramGifInfoHandle), paramNewGifDrawable, paramScheduledThreadPoolExecutor, paramBoolean, 1, paramOptions);
  }
  
  public NewGifDrawable(NewGifDecoder paramNewGifDecoder)
  {
    this(paramNewGifDecoder, null, null, true, 1, null);
  }
  
  public NewGifDrawable(NewGifDecoder paramNewGifDecoder, NewGifDecoder.Options paramOptions)
  {
    this(paramNewGifDecoder, null, null, true, 1, paramOptions);
  }
  
  private NewGifDrawable(NewGifDecoder paramNewGifDecoder, NewGifDrawable paramNewGifDrawable, ScheduledThreadPoolExecutor paramScheduledThreadPoolExecutor, boolean paramBoolean, int paramInt1, int paramInt2, NewGifDecoder.Options paramOptions)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    this.mStopTask = new NewGifDrawable.StopRunnable(this, null);
    this.mIsRenderingTriggeredOnDraw = paramBoolean;
    if (paramScheduledThreadPoolExecutor == null) {
      paramScheduledThreadPoolExecutor = GifRenderingExecutor.getInstance();
    }
    this.mExecutor = paramScheduledThreadPoolExecutor;
    this.mHashcode = paramInt2;
    this.mGifDecoder = paramNewGifDecoder;
    if (paramInt1 == 1)
    {
      this.mGifDecoder.setLoopCount(0);
      setCurrentModel(paramInt1);
    }
    else
    {
      this.mGifDecoder.setLoopCount(1);
      setCurrentModel(paramInt1);
    }
    if ((paramNewGifDecoder instanceof SharpPNewGifDecoder)) {
      this.mIsSharpp = true;
    }
    if ((ImageManagerEnv.g().isPreferNewGifDecodeTask()) && (!this.mIsSharpp) && (!isSupportGifPlaying()))
    {
      this.mRenderTask = new PrepareAndRenderTask(this);
      this.mTaskType = 2;
    }
    else
    {
      this.mRenderTask = new RenderTask(this);
      this.mTaskType = 1;
    }
    paramNewGifDecoder = localObject2;
    if (paramNewGifDrawable != null)
    {
      paramScheduledThreadPoolExecutor = paramNewGifDrawable.mLock4Bmp;
      paramNewGifDecoder = localObject1;
      try
      {
        if (!paramNewGifDrawable.mGifDecoder.isRecycled())
        {
          paramNewGifDecoder = localObject1;
          if (paramNewGifDrawable.mGifDecoder.getHeight() >= this.mGifDecoder.getHeight())
          {
            paramNewGifDecoder = localObject1;
            if (paramNewGifDrawable.mGifDecoder.getWidth() >= this.mGifDecoder.getWidth())
            {
              paramNewGifDrawable.shutdown();
              paramNewGifDecoder = paramNewGifDrawable.mBuffer;
              paramNewGifDecoder.eraseColor(0);
            }
          }
        }
      }
      finally {}
    }
    if (paramNewGifDecoder == null)
    {
      paramNewGifDrawable = Bitmap.Config.ARGB_8888;
      paramNewGifDecoder = paramNewGifDrawable;
      if (ImageManagerEnv.g().isGifSupport565())
      {
        paramNewGifDecoder = paramNewGifDrawable;
        if (!isSupportGifPlaying())
        {
          paramNewGifDecoder = paramNewGifDrawable;
          if (!this.mIsSharpp) {
            if ((paramOptions != null) && (paramOptions.inPreferredConfig == Bitmap.Config.ARGB_8888))
            {
              ImageManagerLog.w("NewGifDrawable", "prefer to decode as 8888");
              paramNewGifDecoder = paramNewGifDrawable;
            }
            else
            {
              paramNewGifDecoder = this.mGifDecoder.getAcceptableConfig();
            }
          }
        }
      }
      this.mBuffer = Bitmap.createBitmap(this.mGifDecoder.getWidth(), this.mGifDecoder.getHeight(), paramNewGifDecoder);
      if (paramNewGifDecoder == Bitmap.Config.ARGB_8888) {
        this.mBuffer.eraseColor(0);
      } else {
        this.mBuffer.eraseColor(Color.parseColor("#DFDFDF"));
      }
    }
    else
    {
      this.mBuffer = paramNewGifDecoder;
    }
    this.mSrcRect = new Rect(0, 0, this.mGifDecoder.getWidth(), this.mGifDecoder.getHeight());
    this.mInvalidationHandler = new InvalidationHandler(this);
    if (!isSupportGifPlaying()) {
      reset();
    }
  }
  
  private NewGifDrawable(NewGifDecoder paramNewGifDecoder, NewGifDrawable paramNewGifDrawable, ScheduledThreadPoolExecutor paramScheduledThreadPoolExecutor, boolean paramBoolean, int paramInt, NewGifDecoder.Options paramOptions)
  {
    this(paramNewGifDecoder, null, null, false, paramInt, 0, paramOptions);
  }
  
  public NewGifDrawable(NewGifDecoder paramNewGifDecoder, String paramString)
  {
    this(paramNewGifDecoder, null, null, true, 1, null);
    this.url = paramString;
  }
  
  public NewGifDrawable(File paramFile)
  {
    this(GifInfoHandle.openFile(paramFile.getPath(), false, null), null, null, true, null);
  }
  
  public NewGifDrawable(File paramFile, int paramInt)
  {
    this(new GenericNewGifDecoder(GifInfoHandle.openFileForGifPlaying(paramFile.getPath(), false, null)), null, null, false, paramInt, null);
  }
  
  public NewGifDrawable(FileDescriptor paramFileDescriptor)
  {
    this(GifInfoHandle.openFd(paramFileDescriptor, 0L, false, null), null, null, true, null);
  }
  
  public NewGifDrawable(InputStream paramInputStream)
  {
    this(GifInfoHandle.openMarkableInputStream(paramInputStream, false, null), null, null, true, null);
  }
  
  public NewGifDrawable(String paramString)
  {
    this(GifInfoHandle.openFile(paramString, false, null), null, null, true, null);
  }
  
  public NewGifDrawable(String paramString, int paramInt1, NewGifDecoder.Options paramOptions, int paramInt2)
  {
    this(new GenericNewGifDecoder(GifInfoHandle.openFileForGifPlaying(paramString, false, paramOptions)), null, null, false, paramInt1, paramInt2, paramOptions);
  }
  
  public NewGifDrawable(String paramString, NewGifDecoder.Options paramOptions)
  {
    this(GifInfoHandle.openFile(paramString, false, paramOptions), null, null, true, paramOptions);
  }
  
  public NewGifDrawable(String paramString1, NewGifDecoder.Options paramOptions, String paramString2)
  {
    this(GifInfoHandle.openFile(paramString1, false, paramOptions), null, null, true, paramOptions);
    this.url = paramString2;
  }
  
  public NewGifDrawable(ByteBuffer paramByteBuffer)
  {
    this(GifInfoHandle.openDirectByteBuffer(paramByteBuffer, false, null), null, null, true, null);
  }
  
  public NewGifDrawable(byte[] paramArrayOfByte)
  {
    this(GifInfoHandle.openByteArray(paramArrayOfByte, false, null), null, null, true, null);
  }
  
  private void addDrawCount()
  {
    try
    {
      if (this.mStartTimeStamp != 0L) {
        this.mDrawCounts += 1L;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static NewGifDrawable createFromResource(Resources paramResources, int paramInt)
  {
    try
    {
      paramResources = new NewGifDrawable(paramResources, paramInt);
      return paramResources;
    }
    catch (IOException paramResources)
    {
      label12:
      break label12;
    }
    return null;
  }
  
  private void endFrameRateStat()
  {
    try
    {
      if ((!isSupportGifPlaying()) && (!this.mIsSharpp))
      {
        long l1 = System.currentTimeMillis() - this.mStartTimeStamp;
        long l2 = this.mRenderTask.getFrameDelay();
        if ((!this.mFrameRateReported) && (this.mDrawCounts > 0L) && (l1 > 2000L) && (l2 > 0L))
        {
          this.mFrameRate = ((float)(this.mDrawCounts * 1000L / l1));
          if (this.mMaxFrameRate == 0.0F) {
            this.mMaxFrameRate = ((float)(1000L / l2));
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("frameRate:");
          localStringBuilder.append(this.mFrameRate);
          localStringBuilder.append(",maxFrameRate:");
          localStringBuilder.append(this.mMaxFrameRate);
          ImageManagerLog.i("NewGifDrawable", localStringBuilder.toString());
          ImageManagerEnv.g().reportGifFrameRate(this.mTaskType, this.mFrameRate, this.mMaxFrameRate);
          this.mFrameRateReported = true;
        }
        this.mStartTimeStamp = 0L;
        return;
      }
      return;
    }
    finally {}
  }
  
  private boolean isSupportGifPlaying()
  {
    int i = this.mCurrentModel;
    return (i == 4) || (i == 3);
  }
  
  private void shutdown()
  {
    this.mIsRunning = false;
    this.gifPlayListener = null;
    this.mInvalidationHandler.removeMessages(0);
    this.mGifDecoder.recycle();
  }
  
  private void startFrameRateStat()
  {
    try
    {
      if ((!isSupportGifPlaying()) && (!this.mIsSharpp))
      {
        this.mStartTimeStamp = System.currentTimeMillis();
        this.mDrawCounts = 0L;
        return;
      }
      return;
    }
    finally {}
  }
  
  private PorterDuffColorFilter updateTintFilter(ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    if ((paramColorStateList != null) && (paramMode != null)) {
      return new PorterDuffColorFilter(paramColorStateList.getColorForState(getState(), 0), paramMode);
    }
    return null;
  }
  
  private void waitForPendingRenderTask()
  {
    ScheduledFuture localScheduledFuture = this.mSchedule;
    if (localScheduledFuture != null) {}
    try
    {
      localScheduledFuture.get();
      this.mRenderTask.waitFinish();
      label23:
      this.mInvalidationHandler.removeMessages(0);
      return;
    }
    catch (InterruptedException|ExecutionException localInterruptedException)
    {
      break label23;
    }
  }
  
  public void addAnimationListener(AnimationListener paramAnimationListener)
  {
    this.mListeners.add(paramAnimationListener);
  }
  
  public boolean canPause()
  {
    return true;
  }
  
  public boolean canSeekBackward()
  {
    return getNumberOfFrames() > 1;
  }
  
  public boolean canSeekForward()
  {
    return getNumberOfFrames() > 1;
  }
  
  public void changeFile(String paramString)
  {
    waitForPendingRenderTask();
    this.mGifDecoder.changeFile(paramString);
    this.mSchedule = this.mExecutor.schedule(this.mRenderTask, 0L, TimeUnit.MILLISECONDS);
  }
  
  public void draw(Canvas paramCanvas)
  {
    addDrawCount();
    int i = 1;
    handlePlayCallBack(1);
    if ((this.mTintFilter != null) && (this.mPaint.getColorFilter() == null)) {
      this.mPaint.setColorFilter(this.mTintFilter);
    } else {
      i = 0;
    }
    if (this.mPaint.getShader() == null) {
      synchronized (this.mLock4Bmp)
      {
        if (!this.mBuffer.isRecycled())
        {
          handlePlayCallBack(2);
          paramCanvas.drawBitmap(this.mBuffer, this.mSrcRect, this.mDstRect, this.mPaint);
        }
      }
    }
    paramCanvas.drawRect(this.mDstRect, this.mPaint);
    if (i != 0) {
      this.mPaint.setColorFilter(null);
    }
    if ((this.mIsRenderingTriggeredOnDraw) && (this.mIsRunning))
    {
      long l = this.mNextFrameRenderTime;
      if (l != -9223372036854775808L)
      {
        l = Math.max(0L, l - SystemClock.uptimeMillis());
        this.mNextFrameRenderTime = -9223372036854775808L;
        this.mExecutor.remove(this.mRenderTask);
        this.mSchedule = this.mExecutor.schedule(this.mRenderTask, l, TimeUnit.MILLISECONDS);
      }
    }
    handlePlayCallBack(3);
  }
  
  public void finalize()
  {
    try
    {
      if (!isRecycled()) {
        recycle();
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  @TargetApi(19)
  public long getAllocationByteCount()
  {
    long l = this.mGifDecoder.getAllocationByteCount();
    int i;
    if (Build.VERSION.SDK_INT >= 19) {
      i = this.mBuffer.getAllocationByteCount();
    } else {
      i = this.mBuffer.getRowBytes() * this.mBuffer.getHeight();
    }
    return l + i;
  }
  
  public int getAlpha()
  {
    return this.mPaint.getAlpha();
  }
  
  public Bitmap.Config getBitmapConfig()
  {
    Bitmap localBitmap = this.mBuffer;
    if (localBitmap != null) {
      return localBitmap.getConfig();
    }
    return this.mGifDecoder.getAcceptableConfig();
  }
  
  public int getBufferPercentage()
  {
    return 100;
  }
  
  public ColorFilter getColorFilter()
  {
    return this.mPaint.getColorFilter();
  }
  
  public String getComment()
  {
    return this.mGifDecoder.getComment();
  }
  
  public int getCurPlayCount()
  {
    return this.curPlayCount;
  }
  
  public Bitmap getCurrentFrame()
  {
    synchronized (this.mLock4Bmp)
    {
      Bitmap localBitmap = this.mBuffer.copy(this.mBuffer.getConfig(), this.mBuffer.isMutable());
      return localBitmap;
    }
  }
  
  public int getCurrentFrameIndex()
  {
    return this.mGifDecoder.getCurrentFrameIndex();
  }
  
  public int getCurrentLoop()
  {
    return this.mGifDecoder.getCurrentLoop();
  }
  
  public int getCurrentModel()
  {
    return this.mCurrentModel;
  }
  
  public int getCurrentPosition()
  {
    return this.mGifDecoder.getCurrentPosition();
  }
  
  public int getDuration()
  {
    return this.mGifDecoder.getDuration();
  }
  
  public GifError getError()
  {
    return GifError.fromCode(this.mGifDecoder.getError());
  }
  
  public Bitmap getFrame(int paramInt)
  {
    if (paramInt >= 0) {
      synchronized (this.mLock4Bmp)
      {
        this.mBuffer = this.mGifDecoder.seekToFrame(paramInt, this.mBuffer);
        Bitmap localBitmap = getCurrentFrame();
        return localBitmap;
      }
    }
    throw new IndexOutOfBoundsException("Frame index is not positive");
  }
  
  public int getFrameByteCount()
  {
    return this.mBuffer.getRowBytes() * this.mBuffer.getHeight();
  }
  
  public int getFrameDuration(int paramInt)
  {
    return this.mGifDecoder.getFrameDuration(paramInt);
  }
  
  public NewGifDrawable.GifPlayListener getGifPlayListener()
  {
    return this.gifPlayListener;
  }
  
  public int getImageCount()
  {
    return this.mGifDecoder.getImageCount();
  }
  
  public long getInputSourceByteCount()
  {
    return this.mGifDecoder.getSourceLength();
  }
  
  public int getIntrinsicHeight()
  {
    int j = this.sHeight;
    int i = j;
    if (j == 0) {
      i = this.mGifDecoder.getHeight();
    }
    return i;
  }
  
  public int getIntrinsicWidth()
  {
    int j = this.sWidth;
    int i = j;
    if (j == 0) {
      i = this.mGifDecoder.getWidth();
    }
    return i;
  }
  
  public int getLoopCount()
  {
    return this.mGifDecoder.getLoopCount();
  }
  
  public int getMinimumHeight()
  {
    return this.mGifDecoder.getHeight();
  }
  
  public int getMinimumWidth()
  {
    return this.mGifDecoder.getWidth();
  }
  
  public int getNumberOfFrames()
  {
    return this.mGifDecoder.getFrameCount();
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public final Paint getPaint()
  {
    return this.mPaint;
  }
  
  public int getPixel(int paramInt1, int paramInt2)
  {
    if (paramInt1 < this.mGifDecoder.getWidth())
    {
      if (paramInt2 < this.mGifDecoder.getHeight()) {
        synchronized (this.mLock4Bmp)
        {
          this.mBuffer.getPixel(paramInt1, paramInt2);
          return 0;
        }
      }
      throw new IllegalArgumentException("y must be < height");
    }
    throw new IllegalArgumentException("x must be < width");
  }
  
  public void getPixels(int[] paramArrayOfInt)
  {
    synchronized (this.mLock4Bmp)
    {
      this.mBuffer.getPixels(paramArrayOfInt, 0, this.mGifDecoder.getWidth(), 0, 0, this.mGifDecoder.getWidth(), this.mGifDecoder.getHeight());
      return;
    }
  }
  
  public float getSpeedFactor()
  {
    float f = this.mFactor;
    if (f > 0.0F) {
      return f;
    }
    return 1.0F;
  }
  
  public Object getTag()
  {
    return this.tag;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public int getsHeight()
  {
    return this.mGifDecoder.getHeight();
  }
  
  public int getsWidth()
  {
    return this.mGifDecoder.getWidth();
  }
  
  protected void handlePlayCallBack(int paramInt)
  {
    if (this.gifPlayListener != null)
    {
      int i = getCurrentFrameIndex();
      int j = getNumberOfFrames();
      int k = getLoopCount();
      if (((paramInt == 3) || (paramInt == 0)) && (i == j - 1)) {
        this.curPlayCount += 1;
      }
      if (((paramInt == 1) || (paramInt == 0)) && ((this.curPlayCount == 0) || (k == 0)) && (i == 0)) {
        this.gifPlayListener.onGifStartPlay(this);
      }
      if (((paramInt == 2) || (paramInt == 0)) && (i > 0) && (i < j - 1) && ((this.curPlayCount < k) || (k == 0))) {
        this.gifPlayListener.onGifPlaying(this);
      }
      if (((paramInt == 3) || (paramInt == 0)) && (i == j - 1) && ((this.curPlayCount == k) || (k == 0)))
      {
        this.gifPlayListener.onGifStopPlay(this);
        if (this.curPlayCount >= 2147483647) {
          this.curPlayCount = 0;
        }
      }
    }
  }
  
  public boolean isAnimationCompleted()
  {
    return this.mGifDecoder.isAnimationCompleted();
  }
  
  public void isEndDownload()
  {
    this.mGifDecoder.setLoopCount(0);
    this.isEndDownload = true;
  }
  
  public boolean isPlaying()
  {
    return this.mIsRunning;
  }
  
  public boolean isRecycled()
  {
    try
    {
      NewGifDecoder localNewGifDecoder = this.mGifDecoder;
      if (localNewGifDecoder == null) {
        return true;
      }
      boolean bool = this.mGifDecoder.isRecycled();
      return bool;
    }
    finally {}
  }
  
  public boolean isRunning()
  {
    return this.mIsRunning;
  }
  
  public boolean isStateful()
  {
    if (!super.isStateful())
    {
      ColorStateList localColorStateList = this.mTint;
      if ((localColorStateList == null) || (!localColorStateList.isStateful())) {
        return false;
      }
    }
    return true;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.mDstRect.set(paramRect);
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    paramArrayOfInt = this.mTint;
    if (paramArrayOfInt != null)
    {
      PorterDuff.Mode localMode = this.mTintMode;
      if (localMode != null)
      {
        this.mTintFilter = updateTintFilter(paramArrayOfInt, localMode);
        return true;
      }
    }
    return false;
  }
  
  public void pause()
  {
    stop();
  }
  
  public void recycle()
  {
    try
    {
      shutdown();
      if (ImageManagerEnv.g().isNeedRecycle()) {
        synchronized (this.mLock4Bmp)
        {
          this.mBuffer.recycle();
        }
      }
      return;
    }
    finally {}
  }
  
  public void recycleForGifPlay()
  {
    ImageManagerLog.e("NewGifDrawable", "NewGifDrawable recycleForGifPlay");
    this.curPlayCount = 0;
    this.mIsRunning = false;
    waitForPendingRenderTask();
    try
    {
      this.mGifDecoder.stop();
      recycle();
      return;
    }
    catch (Throwable localThrowable)
    {
      ImageManagerLog.e("NewGifDrawable", localThrowable.getMessage());
    }
  }
  
  public boolean removeAnimationListener(AnimationListener paramAnimationListener)
  {
    return this.mListeners.remove(paramAnimationListener);
  }
  
  public void reset()
  {
    try
    {
      if (this.mIsResetting)
      {
        ImageManagerLog.w("NewGifDrawable", "it is resetting");
        return;
      }
      endFrameRateStat();
      this.mIsResetting = true;
      this.curPlayCount = 0;
      this.mIsRunning = false;
      this.mCtrlHandler.post(new NewGifDrawable.1(this));
      return;
    }
    finally {}
  }
  
  public void seekTo(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.mExecutor.execute(new NewGifDrawable.2(this, this, paramInt));
      return;
    }
    throw new IllegalArgumentException("Position is not positive");
  }
  
  public void seekToFrame(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.mExecutor.execute(new NewGifDrawable.3(this, this, paramInt));
      return;
    }
    throw new IndexOutOfBoundsException("Frame index is not positive");
  }
  
  public Bitmap seekToFrameAndGet(int paramInt)
  {
    if (paramInt >= 0) {
      synchronized (this.mLock4Bmp)
      {
        this.mBuffer = this.mGifDecoder.seekToFrame(paramInt, this.mBuffer);
        Bitmap localBitmap = getCurrentFrame();
        if (!this.mInvalidationHandler.hasMessages(0)) {
          this.mInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
        }
        return localBitmap;
      }
    }
    throw new IndexOutOfBoundsException("Frame index is not positive");
  }
  
  public Bitmap seekToPositionAndGet(int paramInt)
  {
    if (paramInt >= 0) {
      synchronized (this.mLock4Bmp)
      {
        this.mBuffer = this.mGifDecoder.seekToTime(paramInt, this.mBuffer);
        Bitmap localBitmap = getCurrentFrame();
        if (!this.mInvalidationHandler.hasMessages(0)) {
          this.mInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
        }
        return localBitmap;
      }
    }
    throw new IllegalArgumentException("Position is not positive");
  }
  
  public void setAlpha(int paramInt)
  {
    this.mPaint.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
  }
  
  public void setCurPlayCount(int paramInt)
  {
    this.curPlayCount = paramInt;
  }
  
  public void setCurrentModel(int paramInt)
  {
    this.mCurrentModel = paramInt;
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.mPaint.setDither(paramBoolean);
    invalidateSelf();
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.mPaint.setFilterBitmap(paramBoolean);
    invalidateSelf();
  }
  
  public void setGifPlayListener(NewGifDrawable.GifPlayListener paramGifPlayListener)
  {
    this.gifPlayListener = paramGifPlayListener;
  }
  
  public void setIntrinsicHeight(int paramInt)
  {
    if (this.sHeight == 0) {
      this.sHeight = paramInt;
    }
  }
  
  public void setIntrinsicWidth(int paramInt)
  {
    if (this.sWidth == 0) {
      this.sWidth = paramInt;
    }
  }
  
  public void setLoopCount(int paramInt)
  {
    this.mGifDecoder.setLoopCount(paramInt);
  }
  
  public void setSpeed(float paramFloat)
  {
    try
    {
      this.mGifDecoder.setSpeed(paramFloat);
      this.mFactor = paramFloat;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      ImageManagerLog.e("NewGifDrawable", Log.getStackTraceString(localUnsatisfiedLinkError));
    }
  }
  
  public void setSrcRect(Rect paramRect)
  {
    if (paramRect != null) {
      this.mSrcRect.set(paramRect);
    }
  }
  
  public void setTag(Object paramObject)
  {
    this.tag = paramObject;
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    this.mTint = paramColorStateList;
    this.mTintFilter = updateTintFilter(paramColorStateList, this.mTintMode);
    invalidateSelf();
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    this.mTintMode = paramMode;
    this.mTintFilter = updateTintFilter(this.mTint, paramMode);
    invalidateSelf();
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    paramBoolean2 = super.setVisible(paramBoolean1, paramBoolean2);
    if (paramBoolean1)
    {
      start();
      return paramBoolean2;
    }
    if (paramBoolean2) {
      stop();
    }
    return paramBoolean2;
  }
  
  public void setmCreateTime(long paramLong)
  {
    this.mCreateTime = paramLong;
  }
  
  public void start()
  {
    this.mIsRunning = true;
    long l = this.mGifDecoder.start();
    if (isSupportGifPlaying()) {
      startAnimation(0L);
    } else {
      startAnimation(l);
    }
    startFrameRateStat();
  }
  
  void startAnimation(long paramLong)
  {
    if (this.mIsRenderingTriggeredOnDraw)
    {
      this.mNextFrameRenderTime = 0L;
      if (!this.mInvalidationHandler.hasMessages(0))
      {
        this.mInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
        return;
      }
      ImageManagerLog.d("NewGifDrawable", "startAnimation: already has one message");
      return;
    }
    NewGifDrawable.WaitRunnable localWaitRunnable = new NewGifDrawable.WaitRunnable(this, paramLong);
    this.mCtrlHandler.post(localWaitRunnable);
  }
  
  public void stop()
  {
    endFrameRateStat();
    this.curPlayCount = 0;
    this.mIsRunning = false;
    this.mCtrlHandler.post(this.mStopTask);
  }
  
  public String toString()
  {
    return String.format(Locale.US, "GIF: size: %dx%d, frames: %d, error: %d", new Object[] { Integer.valueOf(this.mGifDecoder.getWidth()), Integer.valueOf(this.mGifDecoder.getHeight()), Integer.valueOf(this.mGifDecoder.getFrameCount()), Integer.valueOf(this.mGifDecoder.getError()) });
  }
  
  public void updateFile(String paramString)
  {
    waitForPendingRenderTask();
    this.mGifDecoder.updateFile(paramString);
    this.mSchedule = this.mExecutor.schedule(this.mRenderTask, 0L, TimeUnit.MILLISECONDS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.gif.NewGifDrawable
 * JD-Core Version:    0.7.0.1
 */