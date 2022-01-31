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
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import pko;
import pkp;
import pkq;
import pkr;
import pkt;

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
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int = 0;
  public long a;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private PorterDuff.Mode jdField_a_of_type_AndroidGraphicsPorterDuff$Mode;
  private PorterDuffColorFilter jdField_a_of_type_AndroidGraphicsPorterDuffColorFilter;
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ImageManagerEnv.g().getDispatcher());
  public final InvalidationHandler a;
  public NewGifDecoder a;
  private NewGifDrawable.GifPlayListener jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable$GifPlayListener;
  private Object jdField_a_of_type_JavaLangObject;
  public final ConcurrentLinkedQueue a;
  public ScheduledFuture a;
  public final ScheduledThreadPoolExecutor a;
  private pkq jdField_a_of_type_Pkq = new pkq(this, null);
  private final pkt jdField_a_of_type_Pkt;
  public volatile boolean a;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long;
  private final Rect jdField_b_of_type_AndroidGraphicsRect;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private volatile int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 1;
  private long jdField_d_of_type_Long;
  private volatile boolean jdField_d_of_type_Boolean;
  private int e;
  public boolean isEndDownload = false;
  public Bitmap mBuffer;
  public int mHashcode = 0;
  public boolean mIsRenderingTriggeredOnDraw = true;
  public final Object mLock4Bmp = new Object();
  protected final Paint mPaint = new Paint(6);
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
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = -9223372036854775808L;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.mIsRenderingTriggeredOnDraw = paramBoolean;
    if (paramScheduledThreadPoolExecutor != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor = paramScheduledThreadPoolExecutor;
      this.mHashcode = paramInt2;
      this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder = paramNewGifDecoder;
      if (paramInt1 != 1) {
        break label491;
      }
      this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.setLoopCount(0);
      setCurrentModel(paramInt1);
      label181:
      if ((paramNewGifDecoder instanceof SharpPNewGifDecoder)) {
        this.jdField_b_of_type_Boolean = true;
      }
      if ((!ImageManagerEnv.g().isPreferNewGifDecodeTask()) || (this.jdField_b_of_type_Boolean) || (a())) {
        break label510;
      }
      this.jdField_a_of_type_Pkt = new PrepareAndRenderTask(this);
      this.e = 2;
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
      label491:
      label510:
      try
      {
        if (!paramNewGifDrawable.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.isRecycled())
        {
          paramNewGifDecoder = localObject1;
          if (paramNewGifDrawable.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.getHeight() >= this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.getHeight())
          {
            paramNewGifDecoder = localObject1;
            if (paramNewGifDrawable.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.getWidth() >= this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.getWidth())
            {
              paramNewGifDrawable.a();
              paramNewGifDecoder = paramNewGifDrawable.mBuffer;
              paramNewGifDecoder.eraseColor(0);
            }
          }
        }
        if (paramNewGifDecoder != null) {
          break label564;
        }
        paramNewGifDrawable = Bitmap.Config.ARGB_8888;
        paramNewGifDecoder = paramNewGifDrawable;
        if (ImageManagerEnv.g().isGifSupport565())
        {
          paramNewGifDecoder = paramNewGifDrawable;
          if (!a())
          {
            paramNewGifDecoder = paramNewGifDrawable;
            if (!this.jdField_b_of_type_Boolean)
            {
              if ((paramOptions == null) || (paramOptions.inPreferredConfig != Bitmap.Config.ARGB_8888)) {
                break label535;
              }
              ImageManagerLog.w("NewGifDrawable", "prefer to decode as 8888");
              paramNewGifDecoder = paramNewGifDrawable;
            }
          }
        }
        this.mBuffer = Bitmap.createBitmap(this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.getWidth(), this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.getHeight(), paramNewGifDecoder);
        if (paramNewGifDecoder != Bitmap.Config.ARGB_8888) {
          break label548;
        }
        this.mBuffer.eraseColor(0);
        this.jdField_b_of_type_AndroidGraphicsRect = new Rect(0, 0, this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.getWidth(), this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.getHeight());
        this.jdField_a_of_type_ComTencentComponentMediaGifInvalidationHandler = new InvalidationHandler(this);
        if (!a()) {
          reset();
        }
        return;
      }
      finally {}
      paramScheduledThreadPoolExecutor = GifRenderingExecutor.getInstance();
      break;
      this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.setLoopCount(1);
      setCurrentModel(paramInt1);
      break label181;
      this.jdField_a_of_type_Pkt = new pkt(this);
      this.e = 1;
      break label233;
      label535:
      paramNewGifDecoder = this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.getAcceptableConfig();
      continue;
      label548:
      this.mBuffer.eraseColor(Color.parseColor("#DFDFDF"));
      continue;
      label564:
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
  
  private PorterDuffColorFilter a(ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    if ((paramColorStateList == null) || (paramMode == null)) {
      return null;
    }
    return new PorterDuffColorFilter(paramColorStateList.getColorForState(getState(), 0), paramMode);
  }
  
  private void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable$GifPlayListener = null;
    this.jdField_a_of_type_ComTencentComponentMediaGifInvalidationHandler.removeMessages(0);
    this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.recycle();
  }
  
  private boolean a()
  {
    return (this.jdField_d_of_type_Int == 4) || (this.jdField_d_of_type_Int == 3);
  }
  
  private void b()
  {
    boolean bool = this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor.remove(this.jdField_a_of_type_Pkt);
    ImageManagerLog.e("NewGifDrawable", "waitForPendingRenderTask isRemove:" + bool + " queue size:" + this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor.getQueue().size());
    if (this.jdField_a_of_type_JavaUtilConcurrentScheduledFuture != null) {}
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentScheduledFuture.get();
      this.jdField_a_of_type_Pkt.waitFinish();
      label82:
      this.jdField_a_of_type_ComTencentComponentMediaGifInvalidationHandler.removeMessages(0);
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      break label82;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label82;
    }
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 189	com/tencent/component/media/gif/NewGifDrawable:a	()Z
    //   6: ifne +12 -> 18
    //   9: aload_0
    //   10: getfield 183	com/tencent/component/media/gif/NewGifDrawable:jdField_b_of_type_Boolean	Z
    //   13: istore_1
    //   14: iload_1
    //   15: ifeq +6 -> 21
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: invokestatic 412	java/lang/System:currentTimeMillis	()J
    //   25: putfield 414	com/tencent/component/media/gif/NewGifDrawable:jdField_b_of_type_Long	J
    //   28: aload_0
    //   29: lconst_0
    //   30: putfield 416	com/tencent/component/media/gif/NewGifDrawable:jdField_c_of_type_Long	J
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
  private void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 189	com/tencent/component/media/gif/NewGifDrawable:a	()Z
    //   6: ifne +12 -> 18
    //   9: aload_0
    //   10: getfield 183	com/tencent/component/media/gif/NewGifDrawable:jdField_b_of_type_Boolean	Z
    //   13: istore_1
    //   14: iload_1
    //   15: ifeq +6 -> 21
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: invokestatic 412	java/lang/System:currentTimeMillis	()J
    //   24: aload_0
    //   25: getfield 414	com/tencent/component/media/gif/NewGifDrawable:jdField_b_of_type_Long	J
    //   28: lsub
    //   29: lstore_2
    //   30: aload_0
    //   31: getfield 196	com/tencent/component/media/gif/NewGifDrawable:jdField_a_of_type_Pkt	Lpkt;
    //   34: invokevirtual 425	pkt:getFrameDelay	()J
    //   37: lstore 4
    //   39: aload_0
    //   40: getfield 427	com/tencent/component/media/gif/NewGifDrawable:jdField_c_of_type_Boolean	Z
    //   43: ifne +126 -> 169
    //   46: aload_0
    //   47: getfield 416	com/tencent/component/media/gif/NewGifDrawable:jdField_c_of_type_Long	J
    //   50: lconst_0
    //   51: lcmp
    //   52: ifle +117 -> 169
    //   55: lload_2
    //   56: ldc2_w 428
    //   59: lcmp
    //   60: ifle +109 -> 169
    //   63: lload 4
    //   65: lconst_0
    //   66: lcmp
    //   67: ifle +102 -> 169
    //   70: aload_0
    //   71: aload_0
    //   72: getfield 416	com/tencent/component/media/gif/NewGifDrawable:jdField_c_of_type_Long	J
    //   75: ldc2_w 430
    //   78: lmul
    //   79: lload_2
    //   80: ldiv
    //   81: l2f
    //   82: putfield 433	com/tencent/component/media/gif/NewGifDrawable:jdField_b_of_type_Float	F
    //   85: aload_0
    //   86: getfield 435	com/tencent/component/media/gif/NewGifDrawable:jdField_c_of_type_Float	F
    //   89: fconst_0
    //   90: fcmpl
    //   91: ifne +14 -> 105
    //   94: aload_0
    //   95: ldc2_w 430
    //   98: lload 4
    //   100: ldiv
    //   101: l2f
    //   102: putfield 435	com/tencent/component/media/gif/NewGifDrawable:jdField_c_of_type_Float	F
    //   105: ldc 233
    //   107: new 366	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   114: ldc_w 437
    //   117: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_0
    //   121: getfield 433	com/tencent/component/media/gif/NewGifDrawable:jdField_b_of_type_Float	F
    //   124: invokevirtual 440	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   127: ldc_w 442
    //   130: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload_0
    //   134: getfield 435	com/tencent/component/media/gif/NewGifDrawable:jdField_c_of_type_Float	F
    //   137: invokevirtual 440	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   140: invokevirtual 393	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 445	com/tencent/component/media/utils/ImageManagerLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: invokestatic 151	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   149: aload_0
    //   150: getfield 198	com/tencent/component/media/gif/NewGifDrawable:e	I
    //   153: aload_0
    //   154: getfield 433	com/tencent/component/media/gif/NewGifDrawable:jdField_b_of_type_Float	F
    //   157: aload_0
    //   158: getfield 435	com/tencent/component/media/gif/NewGifDrawable:jdField_c_of_type_Float	F
    //   161: invokevirtual 449	com/tencent/component/media/ImageManagerEnv:reportGifFrameRate	(IFF)V
    //   164: aload_0
    //   165: iconst_1
    //   166: putfield 427	com/tencent/component/media/gif/NewGifDrawable:jdField_c_of_type_Boolean	Z
    //   169: aload_0
    //   170: lconst_0
    //   171: putfield 414	com/tencent/component/media/gif/NewGifDrawable:jdField_b_of_type_Long	J
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
  
  private void e()
  {
    try
    {
      if (this.jdField_b_of_type_Long != 0L) {
        this.jdField_c_of_type_Long += 1L;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void a(long paramLong)
  {
    if (this.mIsRenderingTriggeredOnDraw)
    {
      this.jdField_a_of_type_Long = 0L;
      if (!this.jdField_a_of_type_ComTencentComponentMediaGifInvalidationHandler.hasMessages(0))
      {
        this.jdField_a_of_type_ComTencentComponentMediaGifInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
        return;
      }
      ImageManagerLog.d("NewGifDrawable", "startAnimation: already has one message");
      return;
    }
    pkr localpkr = new pkr(this, paramLong);
    this.jdField_a_of_type_AndroidOsHandler.post(localpkr);
  }
  
  public void addAnimationListener(AnimationListener paramAnimationListener)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramAnimationListener);
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
    b();
    this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.changeFile(paramString);
    this.jdField_a_of_type_JavaUtilConcurrentScheduledFuture = this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor.schedule(this.jdField_a_of_type_Pkt, 0L, TimeUnit.MILLISECONDS);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = 1;
    e();
    handlePlayCallBack(1);
    if ((this.jdField_a_of_type_AndroidGraphicsPorterDuffColorFilter != null) && (this.mPaint.getColorFilter() == null))
    {
      this.mPaint.setColorFilter(this.jdField_a_of_type_AndroidGraphicsPorterDuffColorFilter);
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
          paramCanvas.drawBitmap(this.mBuffer, this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsRect, this.mPaint);
        }
        if (i != 0) {
          this.mPaint.setColorFilter(null);
        }
        if ((this.mIsRenderingTriggeredOnDraw) && (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Long != -9223372036854775808L))
        {
          long l = Math.max(0L, this.jdField_a_of_type_Long - SystemClock.uptimeMillis());
          this.jdField_a_of_type_Long = -9223372036854775808L;
          this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor.remove(this.jdField_a_of_type_Pkt);
          this.jdField_a_of_type_JavaUtilConcurrentScheduledFuture = this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor.schedule(this.jdField_a_of_type_Pkt, l, TimeUnit.MILLISECONDS);
        }
        handlePlayCallBack(3);
        return;
        i = 0;
      }
      label203:
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.mPaint);
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
    long l = this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.getAllocationByteCount();
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
    return this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.getAcceptableConfig();
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
    return this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.getComment();
  }
  
  public int getCurPlayCount()
  {
    return this.jdField_c_of_type_Int;
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
    return this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.getCurrentFrameIndex();
  }
  
  public int getCurrentLoop()
  {
    return this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.getCurrentLoop();
  }
  
  public int getCurrentModel()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public int getCurrentPosition()
  {
    return this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.getCurrentPosition();
  }
  
  public int getDuration()
  {
    return this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.getDuration();
  }
  
  public GifError getError()
  {
    return GifError.a(this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.getError());
  }
  
  public Bitmap getFrame(int paramInt)
  {
    if (paramInt < 0) {
      throw new IndexOutOfBoundsException("Frame index is not positive");
    }
    synchronized (this.mLock4Bmp)
    {
      this.mBuffer = this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.seekToFrame(paramInt, this.mBuffer);
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
    return this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.getFrameDuration(paramInt);
  }
  
  public NewGifDrawable.GifPlayListener getGifPlayListener()
  {
    return this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable$GifPlayListener;
  }
  
  public int getImageCount()
  {
    return this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.getImageCount();
  }
  
  public long getInputSourceByteCount()
  {
    return this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.getSourceLength();
  }
  
  public int getIntrinsicHeight()
  {
    if (this.jdField_b_of_type_Int == 0) {
      return this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.getHeight();
    }
    return this.jdField_b_of_type_Int;
  }
  
  public int getIntrinsicWidth()
  {
    if (this.jdField_a_of_type_Int == 0) {
      return this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.getWidth();
    }
    return this.jdField_a_of_type_Int;
  }
  
  public int getLoopCount()
  {
    return this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.getLoopCount();
  }
  
  public int getMinimumHeight()
  {
    return this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.getHeight();
  }
  
  public int getMinimumWidth()
  {
    return this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.getWidth();
  }
  
  public int getNumberOfFrames()
  {
    return this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.getFrameCount();
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
    if (paramInt1 >= this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.getWidth()) {
      throw new IllegalArgumentException("x must be < width");
    }
    if (paramInt2 >= this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.getHeight()) {
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
      this.mBuffer.getPixels(paramArrayOfInt, 0, this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.getWidth(), 0, 0, this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.getWidth(), this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.getHeight());
      return;
    }
  }
  
  public float getSpeedFactor()
  {
    if (this.jdField_a_of_type_Float > 0.0F) {
      return this.jdField_a_of_type_Float;
    }
    return 1.0F;
  }
  
  public Object getTag()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public int getsHeight()
  {
    return this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.getHeight();
  }
  
  public int getsWidth()
  {
    return this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.getWidth();
  }
  
  protected void handlePlayCallBack(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable$GifPlayListener != null)
    {
      int i = getCurrentFrameIndex();
      int j = getNumberOfFrames();
      int k = getLoopCount();
      if (((paramInt == 3) || (paramInt == 0)) && (i == j - 1)) {
        this.jdField_c_of_type_Int += 1;
      }
      if (((paramInt == 1) || (paramInt == 0)) && ((this.jdField_c_of_type_Int == 0) || (k == 0)) && (i == 0)) {
        this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable$GifPlayListener.onGifStartPlay(this);
      }
      if (((paramInt == 2) || (paramInt == 0)) && (i < 0) && (i < j - 1) && ((this.jdField_c_of_type_Int < k) || (k == 0))) {
        this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable$GifPlayListener.onGifPlaying(this);
      }
      if (((paramInt == 3) || (paramInt == 0)) && (i == j - 1) && ((this.jdField_c_of_type_Int == k) || (k == 0)))
      {
        this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable$GifPlayListener.onGifStopPlay(this);
        if (this.jdField_c_of_type_Int >= 2147483647) {
          this.jdField_c_of_type_Int = 0;
        }
      }
    }
  }
  
  public boolean isAnimationCompleted()
  {
    return this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.isAnimationCompleted();
  }
  
  public void isEndDownload()
  {
    this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.setLoopCount(0);
    this.isEndDownload = true;
  }
  
  public boolean isPlaying()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  /* Error */
  public boolean isRecycled()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 171	com/tencent/component/media/gif/NewGifDrawable:jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder	Lcom/tencent/component/media/gif/NewGifDecoder;
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
    //   18: getfield 171	com/tencent/component/media/gif/NewGifDrawable:jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder	Lcom/tencent/component/media/gif/NewGifDecoder;
    //   21: invokeinterface 201 1 0
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
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean isStateful()
  {
    return (super.isStateful()) || ((this.jdField_a_of_type_AndroidContentResColorStateList != null) && (this.jdField_a_of_type_AndroidContentResColorStateList.isStateful()));
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.jdField_a_of_type_AndroidGraphicsRect.set(paramRect);
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    if ((this.jdField_a_of_type_AndroidContentResColorStateList != null) && (this.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode != null))
    {
      this.jdField_a_of_type_AndroidGraphicsPorterDuffColorFilter = a(this.jdField_a_of_type_AndroidContentResColorStateList, this.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode);
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
    //   3: invokespecial 210	com/tencent/component/media/gif/NewGifDrawable:a	()V
    //   6: invokestatic 151	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   9: invokevirtual 714	com/tencent/component/media/ImageManagerEnv:isNeedRecycle	()Z
    //   12: ifeq +19 -> 31
    //   15: aload_0
    //   16: getfield 141	com/tencent/component/media/gif/NewGifDrawable:mLock4Bmp	Ljava/lang/Object;
    //   19: astore_1
    //   20: aload_1
    //   21: monitorenter
    //   22: aload_0
    //   23: getfield 212	com/tencent/component/media/gif/NewGifDrawable:mBuffer	Landroid/graphics/Bitmap;
    //   26: invokevirtual 715	android/graphics/Bitmap:recycle	()V
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
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    b();
    try
    {
      this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.stop();
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
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.remove(paramAnimationListener);
  }
  
  /* Error */
  public void reset()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 354	com/tencent/component/media/gif/NewGifDrawable:jdField_d_of_type_Boolean	Z
    //   6: ifeq +14 -> 20
    //   9: ldc 233
    //   11: ldc_w 730
    //   14: invokestatic 241	com/tencent/component/media/utils/ImageManagerLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: invokespecial 732	com/tencent/component/media/gif/NewGifDrawable:d	()V
    //   24: aload_0
    //   25: iconst_1
    //   26: putfield 354	com/tencent/component/media/gif/NewGifDrawable:jdField_d_of_type_Boolean	Z
    //   29: aload_0
    //   30: iconst_0
    //   31: putfield 575	com/tencent/component/media/gif/NewGifDrawable:jdField_c_of_type_Int	I
    //   34: aload_0
    //   35: iconst_0
    //   36: putfield 103	com/tencent/component/media/gif/NewGifDrawable:jdField_a_of_type_Boolean	Z
    //   39: aload_0
    //   40: getfield 160	com/tencent/component/media/gif/NewGifDrawable:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   43: new 734	pkm
    //   46: dup
    //   47: aload_0
    //   48: invokespecial 735	pkm:<init>	(Lcom/tencent/component/media/gif/NewGifDrawable;)V
    //   51: invokevirtual 470	android/os/Handler:post	(Ljava/lang/Runnable;)Z
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
    this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor.execute(new pko(this, this, paramInt));
  }
  
  public void seekToFrame(int paramInt)
  {
    if (paramInt < 0) {
      throw new IndexOutOfBoundsException("Frame index is not positive");
    }
    this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor.execute(new pkp(this, this, paramInt));
  }
  
  public Bitmap seekToFrameAndGet(int paramInt)
  {
    if (paramInt < 0) {
      throw new IndexOutOfBoundsException("Frame index is not positive");
    }
    synchronized (this.mLock4Bmp)
    {
      this.mBuffer = this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.seekToFrame(paramInt, this.mBuffer);
      Bitmap localBitmap = getCurrentFrame();
      if (!this.jdField_a_of_type_ComTencentComponentMediaGifInvalidationHandler.hasMessages(0)) {
        this.jdField_a_of_type_ComTencentComponentMediaGifInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
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
      this.mBuffer = this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.seekToTime(paramInt, this.mBuffer);
      Bitmap localBitmap = getCurrentFrame();
      if (!this.jdField_a_of_type_ComTencentComponentMediaGifInvalidationHandler.hasMessages(0)) {
        this.jdField_a_of_type_ComTencentComponentMediaGifInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
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
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void setCurrentModel(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
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
    this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable$GifPlayListener = paramGifPlayListener;
  }
  
  public void setIntrinsicHeight(int paramInt)
  {
    if (this.jdField_b_of_type_Int == 0) {
      this.jdField_b_of_type_Int = paramInt;
    }
  }
  
  public void setIntrinsicWidth(int paramInt)
  {
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_Int = paramInt;
    }
  }
  
  public void setLoopCount(int paramInt)
  {
    this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.setLoopCount(paramInt);
  }
  
  public void setSpeed(float paramFloat)
  {
    try
    {
      this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.setSpeed(paramFloat);
      this.jdField_a_of_type_Float = paramFloat;
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
      this.jdField_b_of_type_AndroidGraphicsRect.set(paramRect);
    }
  }
  
  public void setTag(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
    this.jdField_a_of_type_AndroidGraphicsPorterDuffColorFilter = a(paramColorStateList, this.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode);
    invalidateSelf();
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    this.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode = paramMode;
    this.jdField_a_of_type_AndroidGraphicsPorterDuffColorFilter = a(this.jdField_a_of_type_AndroidContentResColorStateList, paramMode);
    invalidateSelf();
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    ImageManagerLog.e("NewGifDrawable", "setVisible changed:" + bool + " visible:" + paramBoolean1 + " restart:" + paramBoolean2 + " mIsRenderingTriggeredOnDraw:" + this.mIsRenderingTriggeredOnDraw);
    if (paramBoolean1)
    {
      ImageManagerLog.e("NewGifDrawable", "setVisible start");
      start();
    }
    while (!bool) {
      return bool;
    }
    ImageManagerLog.e("NewGifDrawable", "setVisible stop");
    stop();
    return bool;
  }
  
  public void setmCreateTime(long paramLong)
  {
    this.jdField_d_of_type_Long = paramLong;
  }
  
  public void start()
  {
    this.jdField_a_of_type_Boolean = true;
    long l = this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.start();
    ImageManagerLog.e("NewGifDrawable", "isSupportGifPlaying():" + a() + " lastFrameRemainder:" + l + " mIsRenderingTriggeredOnDraw:" + this.mIsRenderingTriggeredOnDraw);
    if (a()) {
      a(0L);
    }
    for (;;)
    {
      c();
      return;
      a(l);
    }
  }
  
  public void stop()
  {
    d();
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_Pkq);
  }
  
  public String toString()
  {
    return String.format(Locale.US, "GIF: size: %dx%d, frames: %d, error: %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.getWidth()), Integer.valueOf(this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.getHeight()), Integer.valueOf(this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.getFrameCount()), Integer.valueOf(this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.getError()) });
  }
  
  public void updateFile(String paramString)
  {
    b();
    this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.updateFile(paramString);
    this.jdField_a_of_type_JavaUtilConcurrentScheduledFuture = this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor.schedule(this.jdField_a_of_type_Pkt, 0L, TimeUnit.MILLISECONDS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.gif.NewGifDrawable
 * JD-Core Version:    0.7.0.1
 */