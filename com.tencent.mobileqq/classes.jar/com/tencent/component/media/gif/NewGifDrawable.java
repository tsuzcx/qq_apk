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
  private NewGifDrawable.StopRunnable mStopTask = new NewGifDrawable.StopRunnable(this, null);
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
    this.mIsRenderingTriggeredOnDraw = paramBoolean;
    if (paramScheduledThreadPoolExecutor != null)
    {
      this.mExecutor = paramScheduledThreadPoolExecutor;
      this.mHashcode = paramInt2;
      this.mGifDecoder = paramNewGifDecoder;
      if (paramInt1 != 1) {
        break label492;
      }
      this.mGifDecoder.setLoopCount(0);
      setCurrentModel(paramInt1);
      label181:
      if ((paramNewGifDecoder instanceof SharpPNewGifDecoder)) {
        this.mIsSharpp = true;
      }
      if ((!ImageManagerEnv.g().isPreferNewGifDecodeTask()) || (this.mIsSharpp) || (isSupportGifPlaying())) {
        break label511;
      }
      this.mRenderTask = new PrepareAndRenderTask(this);
      this.mTaskType = 2;
      label233:
      paramNewGifDecoder = localObject2;
      if (paramNewGifDrawable != null)
      {
        paramScheduledThreadPoolExecutor = paramNewGifDrawable.mLock4Bmp;
        paramNewGifDecoder = localObject1;
      }
    }
    for (;;)
    {
      label492:
      label511:
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
        if (paramNewGifDecoder != null) {
          break label565;
        }
        paramNewGifDrawable = Bitmap.Config.ARGB_8888;
        paramNewGifDecoder = paramNewGifDrawable;
        if (ImageManagerEnv.g().isGifSupport565())
        {
          paramNewGifDecoder = paramNewGifDrawable;
          if (!isSupportGifPlaying())
          {
            paramNewGifDecoder = paramNewGifDrawable;
            if (!this.mIsSharpp)
            {
              if ((paramOptions == null) || (paramOptions.inPreferredConfig != Bitmap.Config.ARGB_8888)) {
                break label536;
              }
              ImageManagerLog.w("NewGifDrawable", "prefer to decode as 8888");
              paramNewGifDecoder = paramNewGifDrawable;
            }
          }
        }
        this.mBuffer = Bitmap.createBitmap(this.mGifDecoder.getWidth(), this.mGifDecoder.getHeight(), paramNewGifDecoder);
        if (paramNewGifDecoder != Bitmap.Config.ARGB_8888) {
          break label549;
        }
        this.mBuffer.eraseColor(0);
        this.mSrcRect = new Rect(0, 0, this.mGifDecoder.getWidth(), this.mGifDecoder.getHeight());
        this.mInvalidationHandler = new InvalidationHandler(this);
        if (!isSupportGifPlaying()) {
          reset();
        }
        return;
      }
      finally {}
      paramScheduledThreadPoolExecutor = GifRenderingExecutor.getInstance();
      break;
      this.mGifDecoder.setLoopCount(1);
      setCurrentModel(paramInt1);
      break label181;
      this.mRenderTask = new RenderTask(this);
      this.mTaskType = 1;
      break label233;
      label536:
      paramNewGifDecoder = this.mGifDecoder.getAcceptableConfig();
      continue;
      label549:
      this.mBuffer.eraseColor(Color.parseColor("#DFDFDF"));
      continue;
      label565:
      this.mBuffer = paramNewGifDecoder;
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
    catch (IOException paramResources) {}
    return null;
  }
  
  /* Error */
  private void endFrameRateStat()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 221	com/tencent/component/media/gif/NewGifDrawable:isSupportGifPlaying	()Z
    //   6: ifne +12 -> 18
    //   9: aload_0
    //   10: getfield 214	com/tencent/component/media/gif/NewGifDrawable:mIsSharpp	Z
    //   13: istore_1
    //   14: iload_1
    //   15: ifeq +6 -> 21
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: invokestatic 383	java/lang/System:currentTimeMillis	()J
    //   24: aload_0
    //   25: getfield 368	com/tencent/component/media/gif/NewGifDrawable:mStartTimeStamp	J
    //   28: lsub
    //   29: lstore_2
    //   30: aload_0
    //   31: getfield 228	com/tencent/component/media/gif/NewGifDrawable:mRenderTask	Lcom/tencent/component/media/gif/RenderTask;
    //   34: invokevirtual 386	com/tencent/component/media/gif/RenderTask:getFrameDelay	()J
    //   37: lstore 4
    //   39: aload_0
    //   40: getfield 388	com/tencent/component/media/gif/NewGifDrawable:mFrameRateReported	Z
    //   43: ifne +126 -> 169
    //   46: aload_0
    //   47: getfield 370	com/tencent/component/media/gif/NewGifDrawable:mDrawCounts	J
    //   50: lconst_0
    //   51: lcmp
    //   52: ifle +117 -> 169
    //   55: lload_2
    //   56: ldc2_w 389
    //   59: lcmp
    //   60: ifle +109 -> 169
    //   63: lload 4
    //   65: lconst_0
    //   66: lcmp
    //   67: ifle +102 -> 169
    //   70: aload_0
    //   71: aload_0
    //   72: getfield 370	com/tencent/component/media/gif/NewGifDrawable:mDrawCounts	J
    //   75: ldc2_w 391
    //   78: lmul
    //   79: lload_2
    //   80: ldiv
    //   81: l2f
    //   82: putfield 394	com/tencent/component/media/gif/NewGifDrawable:mFrameRate	F
    //   85: aload_0
    //   86: getfield 396	com/tencent/component/media/gif/NewGifDrawable:mMaxFrameRate	F
    //   89: fconst_0
    //   90: fcmpl
    //   91: ifne +14 -> 105
    //   94: aload_0
    //   95: ldc2_w 391
    //   98: lload 4
    //   100: ldiv
    //   101: l2f
    //   102: putfield 396	com/tencent/component/media/gif/NewGifDrawable:mMaxFrameRate	F
    //   105: ldc 26
    //   107: new 398	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   114: ldc_w 401
    //   117: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_0
    //   121: getfield 394	com/tencent/component/media/gif/NewGifDrawable:mFrameRate	F
    //   124: invokevirtual 408	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   127: ldc_w 410
    //   130: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload_0
    //   134: getfield 396	com/tencent/component/media/gif/NewGifDrawable:mMaxFrameRate	F
    //   137: invokevirtual 408	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   140: invokevirtual 413	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 416	com/tencent/component/media/utils/ImageManagerLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: invokestatic 182	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   149: aload_0
    //   150: getfield 230	com/tencent/component/media/gif/NewGifDrawable:mTaskType	I
    //   153: aload_0
    //   154: getfield 394	com/tencent/component/media/gif/NewGifDrawable:mFrameRate	F
    //   157: aload_0
    //   158: getfield 396	com/tencent/component/media/gif/NewGifDrawable:mMaxFrameRate	F
    //   161: invokevirtual 420	com/tencent/component/media/ImageManagerEnv:reportGifFrameRate	(IFF)V
    //   164: aload_0
    //   165: iconst_1
    //   166: putfield 388	com/tencent/component/media/gif/NewGifDrawable:mFrameRateReported	Z
    //   169: aload_0
    //   170: lconst_0
    //   171: putfield 368	com/tencent/component/media/gif/NewGifDrawable:mStartTimeStamp	J
    //   174: goto -156 -> 18
    //   177: astore 6
    //   179: aload_0
    //   180: monitorexit
    //   181: aload 6
    //   183: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	NewGifDrawable
    //   13	2	1	bool	boolean
    //   29	51	2	l1	long
    //   37	62	4	l2	long
    //   177	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	177	finally
    //   21	55	177	finally
    //   70	105	177	finally
    //   105	169	177	finally
    //   169	174	177	finally
  }
  
  private boolean isSupportGifPlaying()
  {
    return (this.mCurrentModel == 4) || (this.mCurrentModel == 3);
  }
  
  private void shutdown()
  {
    this.mIsRunning = false;
    this.gifPlayListener = null;
    this.mInvalidationHandler.removeMessages(0);
    this.mGifDecoder.recycle();
  }
  
  /* Error */
  private void startFrameRateStat()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 221	com/tencent/component/media/gif/NewGifDrawable:isSupportGifPlaying	()Z
    //   6: ifne +12 -> 18
    //   9: aload_0
    //   10: getfield 214	com/tencent/component/media/gif/NewGifDrawable:mIsSharpp	Z
    //   13: istore_1
    //   14: iload_1
    //   15: ifeq +6 -> 21
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: invokestatic 383	java/lang/System:currentTimeMillis	()J
    //   25: putfield 368	com/tencent/component/media/gif/NewGifDrawable:mStartTimeStamp	J
    //   28: aload_0
    //   29: lconst_0
    //   30: putfield 370	com/tencent/component/media/gif/NewGifDrawable:mDrawCounts	J
    //   33: goto -15 -> 18
    //   36: astore_2
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_2
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	NewGifDrawable
    //   13	2	1	bool	boolean
    //   36	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	36	finally
    //   21	33	36	finally
  }
  
  private PorterDuffColorFilter updateTintFilter(ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    if ((paramColorStateList == null) || (paramMode == null)) {
      return null;
    }
    return new PorterDuffColorFilter(paramColorStateList.getColorForState(getState(), 0), paramMode);
  }
  
  private void waitForPendingRenderTask()
  {
    if (this.mSchedule != null) {}
    try
    {
      this.mSchedule.get();
      this.mRenderTask.waitFinish();
      label24:
      this.mInvalidationHandler.removeMessages(0);
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      break label24;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label24;
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
    int i = 1;
    addDrawCount();
    handlePlayCallBack(1);
    if ((this.mTintFilter != null) && (this.mPaint.getColorFilter() == null))
    {
      this.mPaint.setColorFilter(this.mTintFilter);
      if (this.mPaint.getShader() != null) {
        break label203;
      }
    }
    for (;;)
    {
      synchronized (this.mLock4Bmp)
      {
        if (!this.mBuffer.isRecycled())
        {
          handlePlayCallBack(2);
          paramCanvas.drawBitmap(this.mBuffer, this.mSrcRect, this.mDstRect, this.mPaint);
        }
        if (i != 0) {
          this.mPaint.setColorFilter(null);
        }
        if ((this.mIsRenderingTriggeredOnDraw) && (this.mIsRunning) && (this.mNextFrameRenderTime != -9223372036854775808L))
        {
          long l = Math.max(0L, this.mNextFrameRenderTime - SystemClock.uptimeMillis());
          this.mNextFrameRenderTime = -9223372036854775808L;
          this.mExecutor.remove(this.mRenderTask);
          this.mSchedule = this.mExecutor.schedule(this.mRenderTask, l, TimeUnit.MILLISECONDS);
        }
        handlePlayCallBack(3);
        return;
        i = 0;
      }
      label203:
      paramCanvas.drawRect(this.mDstRect, this.mPaint);
    }
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
    if (Build.VERSION.SDK_INT >= 19) {
      return l + this.mBuffer.getAllocationByteCount();
    }
    return l + this.mBuffer.getRowBytes() * this.mBuffer.getHeight();
  }
  
  public int getAlpha()
  {
    return this.mPaint.getAlpha();
  }
  
  public Bitmap.Config getBitmapConfig()
  {
    if (this.mBuffer != null) {
      return this.mBuffer.getConfig();
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
    if (paramInt < 0) {
      throw new IndexOutOfBoundsException("Frame index is not positive");
    }
    synchronized (this.mLock4Bmp)
    {
      this.mBuffer = this.mGifDecoder.seekToFrame(paramInt, this.mBuffer);
      Bitmap localBitmap = getCurrentFrame();
      return localBitmap;
    }
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
    if (this.sHeight == 0) {
      return this.mGifDecoder.getHeight();
    }
    return this.sHeight;
  }
  
  public int getIntrinsicWidth()
  {
    if (this.sWidth == 0) {
      return this.mGifDecoder.getWidth();
    }
    return this.sWidth;
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
    if (paramInt1 >= this.mGifDecoder.getWidth()) {
      throw new IllegalArgumentException("x must be < width");
    }
    if (paramInt2 >= this.mGifDecoder.getHeight()) {
      throw new IllegalArgumentException("y must be < height");
    }
    synchronized (this.mLock4Bmp)
    {
      this.mBuffer.getPixel(paramInt1, paramInt2);
      return 0;
    }
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
    if (this.mFactor > 0.0F) {
      return this.mFactor;
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
      if (((paramInt == 2) || (paramInt == 0)) && (i < 0) && (i < j - 1) && ((this.curPlayCount < k) || (k == 0))) {
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
  
  /* Error */
  public boolean isRecycled()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 202	com/tencent/component/media/gif/NewGifDrawable:mGifDecoder	Lcom/tencent/component/media/gif/NewGifDecoder;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +9 -> 17
    //   11: iconst_1
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 202	com/tencent/component/media/gif/NewGifDrawable:mGifDecoder	Lcom/tencent/component/media/gif/NewGifDecoder;
    //   21: invokeinterface 233 1 0
    //   26: istore_1
    //   27: goto -14 -> 13
    //   30: astore_2
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_2
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	NewGifDrawable
    //   12	15	1	bool	boolean
    //   6	2	2	localNewGifDecoder	NewGifDecoder
    //   30	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	30	finally
    //   17	27	30	finally
  }
  
  public boolean isRunning()
  {
    return this.mIsRunning;
  }
  
  public boolean isStateful()
  {
    return (super.isStateful()) || ((this.mTint != null) && (this.mTint.isStateful()));
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.mDstRect.set(paramRect);
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    if ((this.mTint != null) && (this.mTintMode != null))
    {
      this.mTintFilter = updateTintFilter(this.mTint, this.mTintMode);
      return true;
    }
    return false;
  }
  
  public void pause()
  {
    stop();
  }
  
  /* Error */
  public void recycle()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 243	com/tencent/component/media/gif/NewGifDrawable:shutdown	()V
    //   6: invokestatic 182	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   9: invokevirtual 712	com/tencent/component/media/ImageManagerEnv:isNeedRecycle	()Z
    //   12: ifeq +19 -> 31
    //   15: aload_0
    //   16: getfield 172	com/tencent/component/media/gif/NewGifDrawable:mLock4Bmp	Ljava/lang/Object;
    //   19: astore_1
    //   20: aload_1
    //   21: monitorenter
    //   22: aload_0
    //   23: getfield 245	com/tencent/component/media/gif/NewGifDrawable:mBuffer	Landroid/graphics/Bitmap;
    //   26: invokevirtual 713	android/graphics/Bitmap:recycle	()V
    //   29: aload_1
    //   30: monitorexit
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: astore_2
    //   35: aload_1
    //   36: monitorexit
    //   37: aload_2
    //   38: athrow
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	NewGifDrawable
    //   39	4	1	localObject2	Object
    //   34	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   22	31	34	finally
    //   35	37	34	finally
    //   2	22	39	finally
    //   37	39	39	finally
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
  
  /* Error */
  public void reset()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 363	com/tencent/component/media/gif/NewGifDrawable:mIsResetting	Z
    //   6: ifeq +14 -> 20
    //   9: ldc 26
    //   11: ldc_w 731
    //   14: invokestatic 272	com/tencent/component/media/utils/ImageManagerLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: invokespecial 733	com/tencent/component/media/gif/NewGifDrawable:endFrameRateStat	()V
    //   24: aload_0
    //   25: iconst_1
    //   26: putfield 363	com/tencent/component/media/gif/NewGifDrawable:mIsResetting	Z
    //   29: aload_0
    //   30: iconst_0
    //   31: putfield 572	com/tencent/component/media/gif/NewGifDrawable:curPlayCount	I
    //   34: aload_0
    //   35: iconst_0
    //   36: putfield 134	com/tencent/component/media/gif/NewGifDrawable:mIsRunning	Z
    //   39: aload_0
    //   40: getfield 191	com/tencent/component/media/gif/NewGifDrawable:mCtrlHandler	Landroid/os/Handler;
    //   43: new 735	com/tencent/component/media/gif/NewGifDrawable$1
    //   46: dup
    //   47: aload_0
    //   48: invokespecial 736	com/tencent/component/media/gif/NewGifDrawable$1:<init>	(Lcom/tencent/component/media/gif/NewGifDrawable;)V
    //   51: invokevirtual 739	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   54: pop
    //   55: goto -38 -> 17
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	NewGifDrawable
    //   58	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	58	finally
    //   20	55	58	finally
  }
  
  public void seekTo(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("Position is not positive");
    }
    this.mExecutor.execute(new NewGifDrawable.2(this, this, paramInt));
  }
  
  public void seekToFrame(int paramInt)
  {
    if (paramInt < 0) {
      throw new IndexOutOfBoundsException("Frame index is not positive");
    }
    this.mExecutor.execute(new NewGifDrawable.3(this, this, paramInt));
  }
  
  public Bitmap seekToFrameAndGet(int paramInt)
  {
    if (paramInt < 0) {
      throw new IndexOutOfBoundsException("Frame index is not positive");
    }
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
  
  public Bitmap seekToPositionAndGet(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("Position is not positive");
    }
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
    if (paramBoolean1) {
      start();
    }
    while (!paramBoolean2) {
      return paramBoolean2;
    }
    stop();
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
    }
    for (;;)
    {
      startFrameRateStat();
      return;
      startAnimation(l);
    }
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