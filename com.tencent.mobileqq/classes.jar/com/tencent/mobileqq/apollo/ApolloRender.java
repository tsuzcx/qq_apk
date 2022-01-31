package com.tencent.mobileqq.apollo;

import aifg;
import aigf;
import aigg;
import aigh;
import aigi;
import aigj;
import aigk;
import aigl;
import aigm;
import aign;
import aigo;
import aigp;
import aigq;
import aigr;
import aiij;
import aiil;
import aijw;
import aijz;
import aikb;
import aing;
import aipj;
import aiqq;
import aiwi;
import aiwj;
import aiys;
import ajas;
import ajed;
import ajia;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.MQLruCache;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import awrn;
import babp;
import bach;
import bbmy;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.data.ApolloDevInfo;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.portal.StrokeTextView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.util.youtu.VideoFaceDetector;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketImpl;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.SocketChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import mqq.os.MqqHandler;
import zrw;
import zsb;

public class ApolloRender
  implements GLSurfaceView.Renderer
{
  public static final String ACTION_RES_NONE_PREFIX = "Action:";
  public static final String ACTION_RES_PREFIX = "ActionRes:";
  public static final int APOLLO_CMD_CHANNEL_CLASS = 2;
  public static final int APOLLO_RENDER_CLASS = 1;
  private static final String BASE_JS_PREFIX = "BaseJs:";
  public static String CMSHOW_FILE_PATH = ajed.aU + "cmshow";
  public static final String DRESS_RES_PREFIX = "Dress:";
  public static final int ENGINE_TYPE_ACTION = 0;
  public static final int ENGINE_TYPE_GAME = 1;
  private static final String EXTENSION_RES_PREFIX = "Extension:";
  public static final String GAME_RES_PREFIX = "GameRes:";
  public static final String GAME_SAND_BOX_PREFIX = "GameSandBox:";
  public static final String HTTP_COOKIE = "Cookie";
  public static final String HTTP_REFERER = "Referer";
  public static final int LONG_DRAW_COST = 100;
  public static final String POST_BODY = "Postbody";
  public static final String ROLE_RES_PREFIX = "Role:";
  private static final String SLAVE_RES_PREFIX = "SlaveAction";
  public static final int SP_ATLAS_RGBA4444 = 4;
  public static final int SP_ATLAS_RGBA8888 = 6;
  public static final String TAG = "sava_ApolloRender";
  private static final long TIME_OUT_PRELOAD = 5000L;
  private static File cmshow_photofile_file;
  private static Map gTTFMap;
  private static long g_imageselector;
  private static int mBubbleType;
  public static Map<Long, BufferedInputStream> mBufferinputMap = Collections.synchronizedMap(new HashMap());
  public static Map<Long, BufferedOutputStream> mBufferoutputMap;
  private static aiqq mGyroSensorEventListener;
  public static Map<Long, SSLSocket> mSSLSocketMap = Collections.synchronizedMap(new HashMap());
  static int max_image_height;
  static int max_image_width = 1024;
  private static String qtaTestResult;
  public static boolean sIsDownLoadingSo;
  public static boolean sIsKeyBoardDissmiss;
  public static boolean sIsKeyBoardShow;
  public static String sNativeVersion;
  public static Map<Long, WeakReference<ApolloRender>> sRenderMap = Collections.synchronizedMap(new HashMap());
  public static int sScreenMode;
  public static Map<Long, WeakReference<ApolloTicker>> sTickerMap = Collections.synchronizedMap(new HashMap());
  private static int vibrateFlag;
  private final byte[] LOCK_CREATE_DIRECTOR = new byte[0];
  private final byte[] LOCK_PRELOAD_LIST = new byte[0];
  public boolean isRunning = true;
  long lastFrame;
  long lastFrameCost;
  private IApolloRunnableTask mAddOnInitViewTask;
  public ApolloTicker mApolloTicker;
  private WeakReference<View> mApolloViewRef;
  public List<aijz> mBoundingList = new CopyOnWriteArrayList();
  private int mCallBackCode;
  private WeakReference<aiil> mCallbackRef;
  private volatile boolean mDestroyed;
  public VideoFaceDetector mDetector;
  private volatile boolean mDrawTaskRunning;
  public double mDuration;
  public PopupWindow mEditWindow;
  public long mEditorAddr;
  public Button mEditorBtn;
  public String mEditorDefaultText;
  public EditText mEditorPop;
  private List<IApolloRunnableTask> mEventQueue = Collections.synchronizedList(new ArrayList());
  private int mFinalRequestHeight;
  private int mFinalRequestWidth;
  public int mGameId = -1;
  private String mGameName;
  private int mHeight;
  public boolean mIsFrameMode;
  public boolean mIsInitWhiteFace;
  private boolean mIsNeedReport;
  private boolean mIsReadyNotify;
  private ReentrantLock mLock;
  private StringBuilder mLogBuffer = new StringBuilder(100);
  private int mLogCount;
  private int mLongCostCount;
  private long mNativeTickerCost;
  public List<aijw> mNioList = new ArrayList();
  private List<IApolloRunnableTask> mOnDrawQueue = Collections.synchronizedList(new ArrayList());
  private boolean mPreLoadFlag;
  private volatile boolean mPreLoadListLocked;
  private List<IApolloRunnableTask> mPreLoadQueue = Collections.synchronizedList(new ArrayList());
  private boolean mPreLoadStart;
  private WeakReference<aiij> mRenderCallbackRef;
  private ApolloEngine mSavaWrapper = new ApolloEngine();
  private float mScale;
  public boolean mShowEditWindow;
  private boolean mSnapShot;
  private aigr mSnapShotCallback;
  private long mSnapShotSeq;
  private volatile boolean mSurfaceReady;
  public long mThreadId;
  private int mTotalDrawCost;
  private int mTotalFrameCount;
  private int mType;
  private int mWidth;
  public int needRender = 1;
  public boolean needRenderFrame;
  public int needRenderNum;
  
  static
  {
    max_image_height = 1024;
    mBubbleType = -1;
    mBufferoutputMap = Collections.synchronizedMap(new HashMap());
  }
  
  public ApolloRender(float paramFloat, aiil paramaiil, int paramInt)
  {
    float f = ajia.a() / 16.0F;
    if (f != 0.0F) {}
    for (this.mScale = (paramFloat / f);; this.mScale = paramFloat)
    {
      this.mType = paramInt;
      this.mCallbackRef = new WeakReference(paramaiil);
      this.mLock = aiwj.a().a();
      this.mApolloTicker = this.mSavaWrapper.a();
      if (QLog.isColorLevel()) {
        QLog.d("sava_ApolloRender", 2, "[ApolloRender] threadId:" + Thread.currentThread().getId());
      }
      return;
    }
  }
  
  public static void AABBCallback(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, String paramString1, String paramString2, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, int paramInt)
  {
    Object localObject = getRenderByThreadId();
    List localList;
    int i;
    if (localObject != null)
    {
      localList = ((ApolloRender)localObject).mBoundingList;
      i = ((ApolloRender)localObject).mBoundingList.size() - 1;
      if (i < 0) {
        break label163;
      }
      localObject = (aijz)localList.get(i);
      if (!((aijz)localObject).jdField_a_of_type_JavaLangString.equals(paramString1)) {
        break label154;
      }
      if (paramInt != 0) {
        break label141;
      }
      ((aijz)localObject).a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, paramFloat11, paramFloat12);
    }
    label93:
    for (paramInt = 0;; paramInt = 1)
    {
      if (paramInt != 0) {
        localList.add(new aijz(paramString1, paramString2, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, paramFloat11, paramFloat12));
      }
      return;
      localList.remove(localObject);
      break label93;
      i -= 1;
      break;
    }
  }
  
  public static void AABBCallback(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, String paramString1, String paramString2, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, int paramInt)
  {
    QLog.w("sava_ApolloRender", 1, "old AABBCallback is called.");
    AABBCallback(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramString1, paramString2, paramFloat5, paramFloat6, paramFloat7, paramFloat8, 0.0F, 0.0F, 0.0F, 0.0F, paramInt);
  }
  
  public static void callbackFromJniStatic(int paramInt1, int paramInt2, String paramString)
  {
    ApolloRender localApolloRender = getRenderByThreadId();
    if (localApolloRender == null) {
      return;
    }
    localApolloRender.callbackFromJni(paramInt1, paramInt2, paramString);
  }
  
  public static void cancelVibrate(int paramInt)
  {
    if (vibrateFlag == 0) {}
    do
    {
      do
      {
        return;
        localObject = aing.a(paramInt);
      } while (localObject == null);
      localObject = ((aipj)localObject).a();
    } while (localObject == null);
    Object localObject = (Vibrator)((Activity)localObject).getSystemService("vibrator");
    if (localObject == null)
    {
      QLog.e("sava_ApolloRender", 1, "Vibrator service is null");
      return;
    }
    if (!((Vibrator)localObject).hasVibrator())
    {
      QLog.e("sava_ApolloRender", 1, "Vibrator is not support");
      return;
    }
    ((Vibrator)localObject).cancel();
    vibrateFlag = 0;
  }
  
  public static void createTicker(long paramLong)
  {
    Object localObject = getRenderByThreadId();
    if (localObject != null) {
      if (((ApolloRender)localObject).mApolloTicker != null) {
        ((ApolloRender)localObject).mApolloTicker.createTicker(paramLong);
      }
    }
    do
    {
      do
      {
        return;
        localObject = (WeakReference)sTickerMap.get(Long.valueOf(Thread.currentThread().getId()));
      } while (localObject == null);
      localObject = (ApolloTicker)((WeakReference)localObject).get();
    } while (localObject == null);
    ((ApolloTicker)localObject).createTicker(paramLong);
  }
  
  /* Error */
  public static Bitmap decodeGifBuffer(byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: new 474	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 475	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: iconst_1
    //   10: putfield 478	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   13: aload_2
    //   14: iconst_0
    //   15: putfield 481	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   18: aload_2
    //   19: getstatic 487	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   22: putfield 490	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   25: aload_0
    //   26: iconst_0
    //   27: iload_1
    //   28: aload_2
    //   29: invokestatic 496	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   32: astore_3
    //   33: aload_3
    //   34: invokevirtual 501	android/graphics/Bitmap:getWidth	()I
    //   37: aload_3
    //   38: invokevirtual 504	android/graphics/Bitmap:getHeight	()I
    //   41: getstatic 487	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   44: invokestatic 508	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   47: astore_0
    //   48: aload_0
    //   49: astore_2
    //   50: new 510	android/graphics/Canvas
    //   53: dup
    //   54: aload_0
    //   55: invokespecial 513	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   58: astore 4
    //   60: aload_0
    //   61: astore_2
    //   62: aload 4
    //   64: aload_3
    //   65: fconst_0
    //   66: fconst_0
    //   67: aconst_null
    //   68: invokevirtual 517	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   71: aload_0
    //   72: astore_2
    //   73: aload 4
    //   75: invokevirtual 520	android/graphics/Canvas:save	()I
    //   78: pop
    //   79: aload_0
    //   80: astore 4
    //   82: aload 4
    //   84: areturn
    //   85: astore_3
    //   86: aconst_null
    //   87: astore_0
    //   88: aload_0
    //   89: astore 4
    //   91: aload_0
    //   92: astore_2
    //   93: invokestatic 302	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   96: ifeq -14 -> 82
    //   99: aload_0
    //   100: astore_2
    //   101: ldc 61
    //   103: iconst_2
    //   104: aload_3
    //   105: invokevirtual 523	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   108: invokestatic 321	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: aload_0
    //   112: areturn
    //   113: aload_0
    //   114: astore_2
    //   115: aload_3
    //   116: invokevirtual 526	java/lang/Exception:printStackTrace	()V
    //   119: aload_0
    //   120: areturn
    //   121: astore_0
    //   122: aconst_null
    //   123: areturn
    //   124: astore_3
    //   125: goto -12 -> 113
    //   128: astore_3
    //   129: goto -41 -> 88
    //   132: astore_0
    //   133: aload_2
    //   134: areturn
    //   135: astore_3
    //   136: aconst_null
    //   137: astore_0
    //   138: goto -25 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramArrayOfByte	byte[]
    //   0	141	1	paramInt	int
    //   7	127	2	localObject1	Object
    //   32	33	3	localBitmap	Bitmap
    //   85	31	3	localOutOfMemoryError1	OutOfMemoryError
    //   124	1	3	localException1	Exception
    //   128	1	3	localOutOfMemoryError2	OutOfMemoryError
    //   135	1	3	localException2	Exception
    //   58	32	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	48	85	java/lang/OutOfMemoryError
    //   0	48	121	finally
    //   50	60	124	java/lang/Exception
    //   62	71	124	java/lang/Exception
    //   73	79	124	java/lang/Exception
    //   50	60	128	java/lang/OutOfMemoryError
    //   62	71	128	java/lang/OutOfMemoryError
    //   73	79	128	java/lang/OutOfMemoryError
    //   50	60	132	finally
    //   62	71	132	finally
    //   73	79	132	finally
    //   93	99	132	finally
    //   101	111	132	finally
    //   115	119	132	finally
    //   0	48	135	java/lang/Exception
  }
  
  public static Bitmap decodeJpgBuffer(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inSampleSize = 1;
      localOptions.inJustDecodeBounds = false;
      paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramInt, localOptions);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      QLog.e("sava_ApolloRender", 1, "BitmapFactory.decodeBuffer failed:" + paramArrayOfByte.getMessage());
    }
    return null;
  }
  
  public static byte[] decryptTEA(byte[] paramArrayOfByte)
  {
    if (aifg.jdField_c_of_type_JavaLangString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("sava_ApolloRender", 2, "decryptTEA but stkey = null,return null");
      }
      return null;
    }
    return new Cryptor().decrypt(paramArrayOfByte, aifg.jdField_c_of_type_JavaLangString.getBytes());
  }
  
  public static void disposeTicker(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("sava_ApolloRender", 2, "disposeTicker ticker = " + paramLong + ",thread=" + Thread.currentThread().getId());
    }
    Object localObject = getRenderByThreadId();
    if (localObject != null) {
      if (((ApolloRender)localObject).mApolloTicker != null) {
        ((ApolloRender)localObject).mApolloTicker.disposeTicker(paramLong);
      }
    }
    do
    {
      do
      {
        return;
        localObject = (WeakReference)sTickerMap.get(Long.valueOf(Thread.currentThread().getId()));
      } while (localObject == null);
      localObject = (ApolloTicker)((WeakReference)localObject).get();
    } while (localObject == null);
    ((ApolloTicker)localObject).disposeTicker(paramLong);
  }
  
  /* Error */
  public static Bitmap drawTextOnBitmap(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: invokestatic 302	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +136 -> 139
    //   6: ldc 61
    //   8: iconst_2
    //   9: new 175	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 563
    //   19: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: fload_0
    //   23: invokevirtual 566	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   26: ldc_w 568
    //   29: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: fload_1
    //   33: invokevirtual 566	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   36: ldc_w 570
    //   39: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: fload_2
    //   43: invokevirtual 566	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   46: ldc_w 572
    //   49: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: fload_3
    //   53: invokevirtual 566	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   56: ldc_w 574
    //   59: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: iload 4
    //   64: invokevirtual 577	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   67: ldc_w 579
    //   70: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: iload 5
    //   75: invokevirtual 577	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   78: ldc_w 581
    //   81: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload 8
    //   86: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc_w 583
    //   92: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload 9
    //   97: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: ldc_w 585
    //   103: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: iload 6
    //   108: invokevirtual 577	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   111: ldc_w 587
    //   114: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: iload 7
    //   119: invokevirtual 577	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   122: ldc_w 589
    //   125: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload 10
    //   130: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 321	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: aload 9
    //   141: invokestatic 595	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   144: ifne +25 -> 169
    //   147: ldc_w 597
    //   150: aload 9
    //   152: invokevirtual 347	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   155: ifne +31 -> 186
    //   158: ldc_w 599
    //   161: aload 9
    //   163: invokevirtual 347	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   166: ifne +20 -> 186
    //   169: invokestatic 302	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   172: ifeq +12 -> 184
    //   175: ldc 61
    //   177: iconst_2
    //   178: ldc_w 601
    //   181: invokestatic 321	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: aconst_null
    //   185: areturn
    //   186: aload 10
    //   188: invokestatic 595	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   191: ifeq +681 -> 872
    //   194: iconst_0
    //   195: istore 11
    //   197: aconst_null
    //   198: astore 12
    //   200: new 175	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   207: ldc_w 603
    //   210: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: iload 4
    //   215: invokevirtual 577	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   218: ldc_w 605
    //   221: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: iload 5
    //   226: invokevirtual 577	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   229: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: astore 14
    //   234: getstatic 611	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   237: ifnull +66 -> 303
    //   240: getstatic 611	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   243: aload 14
    //   245: invokevirtual 614	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   248: checkcast 498	android/graphics/Bitmap
    //   251: astore 13
    //   253: aload 13
    //   255: astore 12
    //   257: aload 13
    //   259: ifnull +44 -> 303
    //   262: aload 13
    //   264: astore 12
    //   266: invokestatic 302	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq +34 -> 303
    //   272: ldc 61
    //   274: iconst_2
    //   275: new 175	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   282: ldc_w 616
    //   285: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: aload 14
    //   290: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokestatic 321	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   299: aload 13
    //   301: astore 12
    //   303: aload 12
    //   305: astore 13
    //   307: aload 12
    //   309: ifnonnull +40 -> 349
    //   312: iload 4
    //   314: iload 5
    //   316: getstatic 487	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   319: invokestatic 508	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   322: astore 12
    //   324: aload 12
    //   326: astore 13
    //   328: getstatic 611	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   331: ifnull +18 -> 349
    //   334: getstatic 611	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   337: aload 14
    //   339: aload 12
    //   341: invokevirtual 620	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   344: pop
    //   345: aload 12
    //   347: astore 13
    //   349: new 622	android/widget/TextView
    //   352: dup
    //   353: invokestatic 626	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   356: invokespecial 629	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   359: astore 14
    //   361: new 631	android/graphics/Paint$FontMetricsInt
    //   364: dup
    //   365: invokespecial 632	android/graphics/Paint$FontMetricsInt:<init>	()V
    //   368: astore 12
    //   370: aload 14
    //   372: invokevirtual 636	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   375: aload 12
    //   377: invokevirtual 642	android/text/TextPaint:getFontMetricsInt	(Landroid/graphics/Paint$FontMetricsInt;)I
    //   380: pop
    //   381: aload 12
    //   383: getfield 645	android/graphics/Paint$FontMetricsInt:ascent	I
    //   386: aload 12
    //   388: getfield 648	android/graphics/Paint$FontMetricsInt:top	I
    //   391: isub
    //   392: istore 5
    //   394: iload 5
    //   396: ifne +1073 -> 1469
    //   399: fconst_2
    //   400: getstatic 652	babp:a	F
    //   403: fmul
    //   404: f2i
    //   405: istore 5
    //   407: invokestatic 286	aiwj:a	()Laiwj;
    //   410: getfield 655	aiwj:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   413: invokevirtual 659	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   416: istore 4
    //   418: invokestatic 663	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   421: invokevirtual 667	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   424: astore 15
    //   426: aload 15
    //   428: instanceof 669
    //   431: ifeq +1035 -> 1466
    //   434: aload 15
    //   436: checkcast 669	com/tencent/mobileqq/app/QQAppInterface
    //   439: astore 12
    //   441: getstatic 201	com/tencent/mobileqq/apollo/ApolloRender:mBubbleType	I
    //   444: iconst_m1
    //   445: if_icmpeq +1021 -> 1466
    //   448: getstatic 201	com/tencent/mobileqq/apollo/ApolloRender:mBubbleType	I
    //   451: istore 4
    //   453: invokestatic 302	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   456: ifeq +30 -> 486
    //   459: ldc 61
    //   461: iconst_2
    //   462: new 175	java/lang/StringBuilder
    //   465: dup
    //   466: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   469: ldc_w 671
    //   472: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: iload 4
    //   477: invokevirtual 577	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   480: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: invokestatic 321	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   486: aload 8
    //   488: astore 12
    //   490: aload 8
    //   492: invokestatic 595	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   495: ifne +52 -> 547
    //   498: iload 4
    //   500: ifeq +13 -> 513
    //   503: aload 8
    //   505: astore 12
    //   507: iconst_1
    //   508: iload 4
    //   510: if_icmpne +37 -> 547
    //   513: aload 8
    //   515: ldc_w 673
    //   518: invokevirtual 676	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   521: iconst_0
    //   522: invokestatic 682	baaw:decode	([BI)[B
    //   525: astore 16
    //   527: aload 8
    //   529: astore 12
    //   531: aload 16
    //   533: ifnull +14 -> 547
    //   536: new 343	java/lang/String
    //   539: dup
    //   540: aload 16
    //   542: invokespecial 685	java/lang/String:<init>	([B)V
    //   545: astore 12
    //   547: iload 11
    //   549: ifne +467 -> 1016
    //   552: iload 4
    //   554: ifeq +27 -> 581
    //   557: iconst_1
    //   558: iload 4
    //   560: if_icmpne +14 -> 574
    //   563: ldc_w 597
    //   566: aload 9
    //   568: invokevirtual 347	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   571: ifne +10 -> 581
    //   574: bipush 8
    //   576: iload 4
    //   578: if_icmpne +438 -> 1016
    //   581: aload 14
    //   583: bipush 17
    //   585: invokevirtual 688	android/widget/TextView:setGravity	(I)V
    //   588: aload 14
    //   590: ldc_w 689
    //   593: invokevirtual 692	android/widget/TextView:setTextColor	(I)V
    //   596: aload 14
    //   598: ldc_w 693
    //   601: getstatic 652	babp:a	F
    //   604: fdiv
    //   605: invokevirtual 697	android/widget/TextView:setTextSize	(F)V
    //   608: iconst_3
    //   609: istore 4
    //   611: aload 14
    //   613: fload_2
    //   614: f2i
    //   615: invokevirtual 700	android/widget/TextView:setWidth	(I)V
    //   618: aload 14
    //   620: fload_3
    //   621: f2i
    //   622: iload 5
    //   624: iadd
    //   625: invokevirtual 703	android/widget/TextView:setHeight	(I)V
    //   628: aload 14
    //   630: aload 14
    //   632: invokevirtual 636	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   635: fload_2
    //   636: aload 12
    //   638: iload 4
    //   640: invokestatic 708	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	(Landroid/graphics/Paint;FLjava/lang/String;I)Ljava/lang/String;
    //   643: invokevirtual 712	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   646: aload 14
    //   648: iconst_0
    //   649: iconst_0
    //   650: invokestatic 718	android/view/View$MeasureSpec:makeMeasureSpec	(II)I
    //   653: iconst_0
    //   654: iconst_0
    //   655: invokestatic 718	android/view/View$MeasureSpec:makeMeasureSpec	(II)I
    //   658: invokevirtual 722	android/widget/TextView:measure	(II)V
    //   661: aload 14
    //   663: invokevirtual 725	android/widget/TextView:getMeasuredWidth	()I
    //   666: istore 6
    //   668: aload 14
    //   670: iconst_0
    //   671: iconst_0
    //   672: iload 6
    //   674: aload 14
    //   676: invokevirtual 728	android/widget/TextView:getMeasuredHeight	()I
    //   679: invokevirtual 732	android/widget/TextView:layout	(IIII)V
    //   682: invokestatic 302	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   685: ifeq +33 -> 718
    //   688: ldc 61
    //   690: iconst_2
    //   691: new 175	java/lang/StringBuilder
    //   694: dup
    //   695: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   698: ldc_w 734
    //   701: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: aload 14
    //   706: invokevirtual 737	android/widget/TextView:getLineHeight	()I
    //   709: invokevirtual 577	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   712: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   715: invokestatic 321	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   718: aload 14
    //   720: invokevirtual 740	android/widget/TextView:getLineCount	()I
    //   723: ifne +651 -> 1374
    //   726: aload 14
    //   728: ldc_w 741
    //   731: aload 14
    //   733: invokevirtual 737	android/widget/TextView:getLineHeight	()I
    //   736: i2f
    //   737: fsub
    //   738: ldc_w 742
    //   741: invokevirtual 746	android/widget/TextView:setLineSpacing	(FF)V
    //   744: new 510	android/graphics/Canvas
    //   747: dup
    //   748: aload 13
    //   750: invokespecial 513	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   753: astore 8
    //   755: new 748	android/graphics/Matrix
    //   758: dup
    //   759: invokespecial 749	android/graphics/Matrix:<init>	()V
    //   762: astore 9
    //   764: iconst_1
    //   765: iload 7
    //   767: if_icmpne +681 -> 1448
    //   770: aload 9
    //   772: bipush 9
    //   774: newarray float
    //   776: dup
    //   777: iconst_0
    //   778: ldc_w 750
    //   781: fastore
    //   782: dup
    //   783: iconst_1
    //   784: fconst_0
    //   785: fastore
    //   786: dup
    //   787: iconst_2
    //   788: fconst_0
    //   789: fastore
    //   790: dup
    //   791: iconst_3
    //   792: fconst_0
    //   793: fastore
    //   794: dup
    //   795: iconst_4
    //   796: fconst_1
    //   797: fastore
    //   798: dup
    //   799: iconst_5
    //   800: fconst_0
    //   801: fastore
    //   802: dup
    //   803: bipush 6
    //   805: fconst_0
    //   806: fastore
    //   807: dup
    //   808: bipush 7
    //   810: fconst_0
    //   811: fastore
    //   812: dup
    //   813: bipush 8
    //   815: fconst_1
    //   816: fastore
    //   817: invokevirtual 754	android/graphics/Matrix:setValues	([F)V
    //   820: aload 9
    //   822: fload_2
    //   823: fconst_0
    //   824: invokevirtual 758	android/graphics/Matrix:postTranslate	(FF)Z
    //   827: pop
    //   828: iconst_m1
    //   829: istore 4
    //   831: aload 9
    //   833: iload 4
    //   835: i2f
    //   836: fload_2
    //   837: iload 6
    //   839: i2f
    //   840: fsub
    //   841: fmul
    //   842: fconst_2
    //   843: fdiv
    //   844: fload_0
    //   845: fadd
    //   846: fload_1
    //   847: iload 5
    //   849: i2f
    //   850: fsub
    //   851: invokevirtual 758	android/graphics/Matrix:postTranslate	(FF)Z
    //   854: pop
    //   855: aload 8
    //   857: aload 9
    //   859: invokevirtual 762	android/graphics/Canvas:setMatrix	(Landroid/graphics/Matrix;)V
    //   862: aload 14
    //   864: aload 8
    //   866: invokevirtual 766	android/widget/TextView:draw	(Landroid/graphics/Canvas;)V
    //   869: aload 13
    //   871: areturn
    //   872: aload 10
    //   874: ldc_w 768
    //   877: invokevirtual 771	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   880: istore 11
    //   882: goto -685 -> 197
    //   885: astore 8
    //   887: invokestatic 302	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   890: ifeq +33 -> 923
    //   893: ldc 61
    //   895: iconst_2
    //   896: new 175	java/lang/StringBuilder
    //   899: dup
    //   900: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   903: ldc_w 773
    //   906: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   909: aload 8
    //   911: invokevirtual 523	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   914: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   917: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   920: invokestatic 321	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   923: aconst_null
    //   924: areturn
    //   925: astore 8
    //   927: invokestatic 302	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   930: ifeq +33 -> 963
    //   933: ldc 61
    //   935: iconst_2
    //   936: new 175	java/lang/StringBuilder
    //   939: dup
    //   940: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   943: ldc_w 773
    //   946: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   949: aload 8
    //   951: invokevirtual 530	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   954: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   957: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   960: invokestatic 321	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   963: aconst_null
    //   964: areturn
    //   965: astore 16
    //   967: aload 8
    //   969: astore 12
    //   971: invokestatic 302	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   974: ifeq -427 -> 547
    //   977: ldc 61
    //   979: iconst_2
    //   980: aload 16
    //   982: invokevirtual 523	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   985: invokestatic 321	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   988: aload 8
    //   990: astore 12
    //   992: goto -445 -> 547
    //   995: astore 12
    //   997: ldc 61
    //   999: iconst_1
    //   1000: aload 12
    //   1002: iconst_0
    //   1003: anewarray 4	java/lang/Object
    //   1006: invokestatic 776	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1009: aload 8
    //   1011: astore 12
    //   1013: goto -466 -> 547
    //   1016: iconst_1
    //   1017: iload 4
    //   1019: if_icmpeq +8 -> 1027
    //   1022: iload 11
    //   1024: ifeq +162 -> 1186
    //   1027: ldc_w 599
    //   1030: aload 9
    //   1032: invokevirtual 347	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1035: ifeq +151 -> 1186
    //   1038: aconst_null
    //   1039: astore 8
    //   1041: aload 15
    //   1043: instanceof 669
    //   1046: ifeq +19 -> 1065
    //   1049: aload 15
    //   1051: checkcast 669	com/tencent/mobileqq/app/QQAppInterface
    //   1054: sipush 153
    //   1057: invokevirtual 780	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1060: checkcast 534	aifg
    //   1063: astore 8
    //   1065: aload 10
    //   1067: astore 9
    //   1069: aload 10
    //   1071: invokestatic 595	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1074: ifne +33 -> 1107
    //   1077: aload 10
    //   1079: astore 9
    //   1081: aload 10
    //   1083: ldc_w 782
    //   1086: invokevirtual 786	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1089: ifeq +18 -> 1107
    //   1092: aload 10
    //   1094: iconst_0
    //   1095: aload 10
    //   1097: invokevirtual 789	java/lang/String:length	()I
    //   1100: iconst_1
    //   1101: isub
    //   1102: invokevirtual 793	java/lang/String:substring	(II)Ljava/lang/String;
    //   1105: astore 9
    //   1107: iload 11
    //   1109: ifeq +40 -> 1149
    //   1112: ldc_w 794
    //   1115: istore 4
    //   1117: aload 14
    //   1119: bipush 17
    //   1121: invokevirtual 688	android/widget/TextView:setGravity	(I)V
    //   1124: aload 14
    //   1126: iload 4
    //   1128: invokevirtual 692	android/widget/TextView:setTextColor	(I)V
    //   1131: aload 14
    //   1133: ldc_w 795
    //   1136: getstatic 652	babp:a	F
    //   1139: fdiv
    //   1140: invokevirtual 697	android/widget/TextView:setTextSize	(F)V
    //   1143: iconst_1
    //   1144: istore 4
    //   1146: goto -535 -> 611
    //   1149: aload 8
    //   1151: ifnull +29 -> 1180
    //   1154: aload 9
    //   1156: invokestatic 595	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1159: ifne +21 -> 1180
    //   1162: aload 8
    //   1164: aload 9
    //   1166: invokevirtual 797	aifg:a	(Ljava/lang/String;)Z
    //   1169: ifeq +291 -> 1460
    //   1172: ldc_w 798
    //   1175: istore 4
    //   1177: goto -60 -> 1117
    //   1180: iconst_m1
    //   1181: istore 4
    //   1183: goto -66 -> 1117
    //   1186: iconst_2
    //   1187: iload 4
    //   1189: if_icmpne +36 -> 1225
    //   1192: aload 14
    //   1194: bipush 17
    //   1196: invokevirtual 688	android/widget/TextView:setGravity	(I)V
    //   1199: aload 14
    //   1201: ldc_w 689
    //   1204: invokevirtual 692	android/widget/TextView:setTextColor	(I)V
    //   1207: aload 14
    //   1209: ldc_w 799
    //   1212: getstatic 652	babp:a	F
    //   1215: fdiv
    //   1216: invokevirtual 697	android/widget/TextView:setTextSize	(F)V
    //   1219: iconst_3
    //   1220: istore 4
    //   1222: goto -611 -> 611
    //   1225: iconst_3
    //   1226: iload 4
    //   1228: if_icmpne +36 -> 1264
    //   1231: aload 14
    //   1233: bipush 19
    //   1235: invokevirtual 688	android/widget/TextView:setGravity	(I)V
    //   1238: aload 14
    //   1240: ldc_w 689
    //   1243: invokevirtual 692	android/widget/TextView:setTextColor	(I)V
    //   1246: aload 14
    //   1248: ldc_w 800
    //   1251: getstatic 652	babp:a	F
    //   1254: fdiv
    //   1255: invokevirtual 697	android/widget/TextView:setTextSize	(F)V
    //   1258: iconst_2
    //   1259: istore 4
    //   1261: goto -650 -> 611
    //   1264: iconst_4
    //   1265: iload 4
    //   1267: if_icmpeq +9 -> 1276
    //   1270: iconst_5
    //   1271: iload 4
    //   1273: if_icmpne +37 -> 1310
    //   1276: aload 14
    //   1278: bipush 17
    //   1280: invokevirtual 688	android/widget/TextView:setGravity	(I)V
    //   1283: aload 14
    //   1285: ldc_w 801
    //   1288: invokevirtual 692	android/widget/TextView:setTextColor	(I)V
    //   1291: aload 14
    //   1293: ldc_w 802
    //   1296: getstatic 652	babp:a	F
    //   1299: fdiv
    //   1300: invokevirtual 697	android/widget/TextView:setTextSize	(F)V
    //   1303: bipush 6
    //   1305: istore 4
    //   1307: goto -696 -> 611
    //   1310: bipush 6
    //   1312: iload 4
    //   1314: if_icmpeq +17 -> 1331
    //   1317: bipush 7
    //   1319: iload 4
    //   1321: if_icmpeq +10 -> 1331
    //   1324: bipush 9
    //   1326: iload 4
    //   1328: if_icmpne +126 -> 1454
    //   1331: aload 14
    //   1333: bipush 17
    //   1335: invokevirtual 688	android/widget/TextView:setGravity	(I)V
    //   1338: aload 14
    //   1340: ldc_w 689
    //   1343: invokevirtual 692	android/widget/TextView:setTextColor	(I)V
    //   1346: aload 14
    //   1348: ldc_w 803
    //   1351: getstatic 652	babp:a	F
    //   1354: fdiv
    //   1355: invokevirtual 697	android/widget/TextView:setTextSize	(F)V
    //   1358: aload 14
    //   1360: iconst_0
    //   1361: iload 5
    //   1363: iconst_0
    //   1364: iconst_0
    //   1365: invokevirtual 806	android/widget/TextView:setPadding	(IIII)V
    //   1368: iconst_2
    //   1369: istore 4
    //   1371: goto -760 -> 611
    //   1374: aload 14
    //   1376: iload 5
    //   1378: i2f
    //   1379: fload_3
    //   1380: fadd
    //   1381: aload 14
    //   1383: invokevirtual 740	android/widget/TextView:getLineCount	()I
    //   1386: i2f
    //   1387: fdiv
    //   1388: aload 14
    //   1390: invokevirtual 737	android/widget/TextView:getLineHeight	()I
    //   1393: i2f
    //   1394: fsub
    //   1395: ldc_w 742
    //   1398: invokevirtual 746	android/widget/TextView:setLineSpacing	(FF)V
    //   1401: goto -657 -> 744
    //   1404: astore 8
    //   1406: invokestatic 302	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1409: ifeq +14 -> 1423
    //   1412: ldc 61
    //   1414: iconst_2
    //   1415: aload 8
    //   1417: invokevirtual 523	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   1420: invokestatic 321	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1423: aconst_null
    //   1424: astore 8
    //   1426: goto -671 -> 755
    //   1429: astore 8
    //   1431: invokestatic 302	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1434: ifeq +12 -> 1446
    //   1437: ldc 61
    //   1439: iconst_2
    //   1440: ldc_w 808
    //   1443: invokestatic 321	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1446: aconst_null
    //   1447: areturn
    //   1448: iconst_1
    //   1449: istore 4
    //   1451: goto -620 -> 831
    //   1454: iconst_3
    //   1455: istore 4
    //   1457: goto -846 -> 611
    //   1460: iconst_m1
    //   1461: istore 4
    //   1463: goto -346 -> 1117
    //   1466: goto -1013 -> 453
    //   1469: goto -1062 -> 407
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1472	0	paramFloat1	float
    //   0	1472	1	paramFloat2	float
    //   0	1472	2	paramFloat3	float
    //   0	1472	3	paramFloat4	float
    //   0	1472	4	paramInt1	int
    //   0	1472	5	paramInt2	int
    //   0	1472	6	paramInt3	int
    //   0	1472	7	paramInt4	int
    //   0	1472	8	paramString1	String
    //   0	1472	9	paramString2	String
    //   0	1472	10	paramString3	String
    //   195	913	11	bool	boolean
    //   198	793	12	localObject1	Object
    //   995	6	12	localThrowable	Throwable
    //   1011	1	12	str	String
    //   251	619	13	localObject2	Object
    //   232	1157	14	localObject3	Object
    //   424	626	15	localAppRuntime	mqq.app.AppRuntime
    //   525	16	16	arrayOfByte	byte[]
    //   965	16	16	localOutOfMemoryError	OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   312	324	885	java/lang/OutOfMemoryError
    //   328	345	885	java/lang/OutOfMemoryError
    //   312	324	925	java/lang/Exception
    //   328	345	925	java/lang/Exception
    //   490	498	965	java/lang/OutOfMemoryError
    //   513	527	965	java/lang/OutOfMemoryError
    //   536	547	965	java/lang/OutOfMemoryError
    //   490	498	995	java/lang/Throwable
    //   513	527	995	java/lang/Throwable
    //   536	547	995	java/lang/Throwable
    //   744	755	1404	java/lang/OutOfMemoryError
    //   744	755	1429	java/lang/Exception
  }
  
  public static byte[] encryptTEA(byte[] paramArrayOfByte)
  {
    if (aifg.jdField_c_of_type_JavaLangString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("sava_ApolloRender", 2, "encryptTEA but stkey = null,return null");
      }
      return null;
    }
    return new Cryptor().encrypt(paramArrayOfByte, aifg.jdField_c_of_type_JavaLangString.getBytes());
  }
  
  private void exeEngineJs(boolean paramBoolean)
  {
    if ((paramBoolean) || (TextUtils.isEmpty(aifg.d)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("sava_ApolloRender", 2, "setupDirector load so script");
      }
      this.mSavaWrapper.a(aifg.g);
      this.mSavaWrapper.a(aifg.f);
      this.mSavaWrapper.a(aifg.h);
      this.mSavaWrapper.a(aifg.i);
    }
    do
    {
      return;
      this.mSavaWrapper.a(aifg.d);
    } while (!QLog.isColorLevel());
    ajas.b("exeBase");
  }
  
  public static Bitmap getApolloBitmap(String paramString, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (QLog.isColorLevel()) {
      QLog.d("sava_ApolloRender", 2, "[getApolloBitmap], path:" + paramString + ",format:" + paramInt);
    }
    if (TextUtils.isEmpty(paramString))
    {
      paramString = (String)localObject1;
      if (QLog.isColorLevel())
      {
        QLog.d("sava_ApolloRender", 2, "errInfo-> path is NULL.");
        paramString = (String)localObject1;
      }
    }
    label232:
    do
    {
      for (;;)
      {
        return paramString;
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        if (4 == paramInt) {
          localOptions.inPreferredConfig = Bitmap.Config.ARGB_4444;
        }
        try
        {
          for (;;)
          {
            Bitmap localBitmap = BitmapFactory.decodeFile(paramString, localOptions);
            return localBitmap;
            if (6 == paramInt) {
              localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
            } else {
              localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
            }
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          localOptions.inJustDecodeBounds = true;
          try
          {
            localObject1 = BitmapFactory.decodeFile(paramString, localOptions);
            localObject2 = localObject1;
            paramInt = localOptions.outWidth;
          }
          catch (OutOfMemoryError paramString)
          {
            try
            {
              int i = localOptions.outHeight;
              paramString = (String)localObject1;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("sava_ApolloRender", 2, "errInfo2->oom->" + localOutOfMemoryError.getMessage() + ",h:" + i + ",w:" + paramInt);
              return localObject1;
            }
            catch (OutOfMemoryError paramString)
            {
              break label232;
            }
            paramString = paramString;
            paramInt = 0;
            localObject1 = localObject2;
          }
          paramString = (String)localObject1;
          if (QLog.isColorLevel())
          {
            QLog.d("sava_ApolloRender", 2, "errInfo1->oom->" + localOutOfMemoryError.getMessage() + ",h:" + 0 + ",w:" + paramInt);
            return localObject1;
          }
        }
        catch (Exception localException)
        {
          paramString = (String)localObject1;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("sava_ApolloRender", 2, "errInfo3->exception->" + localException.getMessage());
    return null;
  }
  
  private static Bitmap getImageBitmap(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = null;
    for (;;)
    {
      try
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(paramString, localOptions);
        int i = localOptions.outWidth;
        int j = localOptions.outHeight;
        if ((i <= paramInt1) && (j <= paramInt2)) {
          break label147;
        }
        paramInt1 = Math.min(Math.round(i / paramInt1), Math.round(j / paramInt2));
        localOptions.inSampleSize = paramInt1;
        localOptions.inJustDecodeBounds = false;
        paramString = BitmapFactory.decodeFile(paramString, localOptions);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        paramString = localObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("sava_ApolloRender", 2, localOutOfMemoryError.getMessage());
        return null;
      }
      catch (Exception paramString)
      {
        QLog.e("sava_ApolloRender", 1, "BitmapFactory.decodeFile failed:" + paramString.getMessage());
        return null;
      }
      return paramString;
      label147:
      paramInt1 = 1;
    }
  }
  
  public static void getLocation(long paramLong, int paramInt) {}
  
  public static void getLocation(long paramLong, int paramInt, String paramString)
  {
    int j = 1;
    Object localObject = aing.a(Thread.currentThread().getId());
    int i = j;
    if (localObject != null)
    {
      localObject = ((aipj)localObject).a();
      i = j;
      if (localObject != null)
      {
        i = j;
        if (((CmGameInitParams)localObject).accessTokenRet == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("sava_ApolloRender", 2, "getlocation, NOT need login.");
          }
          localObject = getRenderViewByThreadId();
          if (localObject != null) {}
        }
      }
    }
    while (i == 0)
    {
      return;
      Activity localActivity = (Activity)((View)localObject).getContext();
      zsb.a();
      getLocationDoLocation((View)localObject, zsb.a(localActivity, 5, paramString), paramLong, paramInt, paramString);
      i = 0;
    }
    getLocationLogin(paramLong, paramInt, paramString);
  }
  
  public static void getLocationCity(View paramView, zrw paramzrw, long paramLong, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
  {
    paramzrw.a("getCity", null, new aigm(paramView, paramzrw, paramLong, paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6));
  }
  
  public static void getLocationDoLocation(View paramView, zrw paramzrw, long paramLong, int paramInt, String paramString)
  {
    paramzrw.a("getLocation", null, new aign(paramView, paramzrw, paramLong, paramInt));
  }
  
  public static void getLocationLogin(long paramLong, int paramInt, String paramString)
  {
    View localView = getRenderViewByThreadId();
    if (localView == null) {
      return;
    }
    Object localObject = (Activity)localView.getContext();
    zsb.a();
    localObject = zsb.a((Activity)localObject, 5, paramString);
    ((zrw)localObject).a("login", null, new aigo(localView, (zrw)localObject, paramLong, paramInt, paramString));
  }
  
  public static ApolloRender getRenderByThreadId()
  {
    Object localObject1;
    if (sRenderMap == null) {
      localObject1 = null;
    }
    ApolloRender localApolloRender;
    do
    {
      return localObject1;
      try
      {
        long l = Thread.currentThread().getId();
        localObject1 = (WeakReference)sRenderMap.get(Long.valueOf(l));
        if (localObject1 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("sava_ApolloRender", 1, "[getRenderByThreadId], errInfo->renderRef is null");
          }
          return null;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        return null;
      }
      localApolloRender = (ApolloRender)localOutOfMemoryError.get();
      Object localObject2 = localApolloRender;
    } while (localApolloRender != null);
    if (QLog.isColorLevel()) {
      QLog.i("sava_ApolloRender", 1, "[getRenderByThreadId], errInfo->renderObj is null");
    }
    return null;
  }
  
  public static View getRenderViewByThreadId()
  {
    try
    {
      Object localObject = getRenderByThreadId();
      if (localObject != null)
      {
        if (((ApolloRender)localObject).mApolloViewRef == null) {
          return null;
        }
        localObject = (View)((ApolloRender)localObject).mApolloViewRef.get();
        return localObject;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("sava_ApolloRender", 1, "[getRenderViewByThreadId], errInfo->", localOutOfMemoryError);
    }
    return null;
  }
  
  public static String getRscPathStatic(String paramString1, String paramString2)
  {
    ApolloRender localApolloRender = getRenderByThreadId();
    if (localApolloRender == null) {
      return "";
    }
    return localApolloRender.getRscPath(paramString1, paramString2);
  }
  
  public static String getRscStaticPath(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("sava_ApolloRender", 2, "[getRscStaticPath], name:" + paramString1 + ",type:" + paramString2);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(96);
    if ((paramString1.contains("game")) || (paramString1.contains("def")))
    {
      localStringBuilder.append(aiys.jdField_c_of_type_JavaLangString);
      if (!localStringBuilder.toString().endsWith("/")) {
        localStringBuilder.append("/");
      }
      localStringBuilder.append(paramString1);
      if (!"json".equals(paramString2)) {
        break label215;
      }
      localStringBuilder.append(".json");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("sava_ApolloRender", 2, "getRscStaticPath ret:" + localStringBuilder.toString());
      }
      return localStringBuilder.toString();
      localStringBuilder.append(aiys.jdField_a_of_type_JavaLangString);
      if (localStringBuilder.toString().endsWith("/")) {
        break;
      }
      localStringBuilder.append("/");
      break;
      label215:
      if ("atlas".equals(paramString2)) {
        localStringBuilder.append(".atlas");
      } else if ("lua".equals(paramString2)) {
        localStringBuilder.append(".lua");
      } else if ("png".equals(paramString2)) {
        localStringBuilder.append(".png");
      } else if ("jpg".equals(paramString2)) {
        localStringBuilder.append(".jpg");
      } else if ("shp".equals(paramString2)) {
        localStringBuilder.append(".shp");
      }
    }
  }
  
  public static String getSandBoxPath(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = getRenderByThreadId();
    if (localObject == null)
    {
      QLog.w("sava_ApolloRender", 1, "render is null.");
      return null;
    }
    if (paramString.startsWith("GameSandBox:"))
    {
      paramString = paramString.substring("GameSandBox:".length() + "//".length());
      localObject = new File(aiys.s + ((ApolloRender)localObject).mGameId + "/sandbox");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      return ((File)localObject).getAbsolutePath() + "/" + paramString;
    }
    return "NOT_SAND_PATH";
  }
  
  public static String getSandBoxPathByRealGameId(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (paramString.startsWith("GameSandBox:"))
    {
      paramString = paramString.substring("GameSandBox:".length() + "//".length());
      File localFile = new File(aiys.s + paramInt + "/sandbox");
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return localFile.getAbsolutePath() + "/" + paramString;
    }
    return "NOT_SAND_PATH";
  }
  
  public static byte[] getTEASt()
  {
    if (aifg.jdField_b_of_type_JavaLangString == null) {
      return null;
    }
    return bach.a(aifg.jdField_b_of_type_JavaLangString);
  }
  
  public static Bitmap getTextViewBitmap(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    try
    {
      localTextView = new TextView(BaseApplicationImpl.getContext());
      paramString1 = new Paint.FontMetricsInt();
      localTextView.getPaint().getFontMetricsInt(paramString1);
      if (paramString1.ascent - paramString1.top == 0) {
        int i = (int)(2.0F * babp.a);
      }
      localTextView.setWidth(paramInt3);
      localTextView.setHeight(paramInt4);
      if (paramInt5 != 0) {
        break label329;
      }
      localTextView.setGravity(3);
    }
    catch (OutOfMemoryError paramString1)
    {
      for (;;)
      {
        try
        {
          String str;
          paramString1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
          paramString2 = paramString1;
          if (BaseApplicationImpl.sImageCache != null)
          {
            BaseApplicationImpl.sImageCache.put(str, paramString1);
            paramString2 = paramString1;
          }
          localTextView.draw(new Canvas(paramString2));
          return paramString2;
        }
        catch (OutOfMemoryError paramString1)
        {
          TextView localTextView;
          if (!QLog.isColorLevel()) {
            break label476;
          }
          QLog.d("sava_ApolloRender", 2, "errInfo->" + paramString1.getMessage());
        }
        catch (Exception paramString1)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("sava_ApolloRender", 2, "errInfo->" + paramString1.getMessage());
          return null;
        }
        paramString1 = paramString1;
        if (QLog.isColorLevel()) {
          QLog.d("sava_ApolloRender", 2, paramString1.getMessage());
        }
        return null;
        if (paramInt5 != 1) {
          continue;
        }
        localTextView.setGravity(17);
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        QLog.e("sava_ApolloRender", 2, "getTextBitMapException e=" + paramString1.toString());
        continue;
        if (paramInt5 == 2) {
          localTextView.setGravity(5);
        }
      }
    }
    localTextView.setTextColor(paramInt2);
    localTextView.setTextSize(paramInt1);
    localTextView.setText(paramString2);
    localTextView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    paramInt1 = localTextView.getMeasuredWidth();
    paramInt2 = localTextView.getMeasuredHeight();
    localTextView.layout(0, 0, paramInt1, paramInt2);
    paramString1 = null;
    str = "group_brand_" + paramInt1 + "_" + paramInt2;
    if (BaseApplicationImpl.sImageCache != null)
    {
      paramString2 = (Bitmap)BaseApplicationImpl.sImageCache.get(str);
      paramString1 = paramString2;
      if (paramString2 != null)
      {
        paramString1 = paramString2;
        if (QLog.isColorLevel())
        {
          QLog.d("sava_ApolloRender", 2, "group brand ----> get bitmap from cache key: " + str);
          paramString1 = paramString2;
        }
      }
    }
    paramString2 = paramString1;
    if (paramString1 == null) {}
    label329:
    label476:
    return null;
  }
  
  public static Bitmap getTextViewBitmap(int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString2, int paramInt7, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt8)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    double d = paramInt1;
    label516:
    for (;;)
    {
      try
      {
        float f = (float)(d * 1.0D / babp.a);
        localStrokeTextView = new StrokeTextView(BaseApplicationImpl.getContext(), null);
        localStrokeTextView.setIncludeFontPadding(false);
        localStrokeTextView.setWidth(paramInt3);
        localStrokeTextView.setHeight(paramInt4);
        if (paramInt5 == 0)
        {
          localStrokeTextView.setGravity(3);
          Object localObject2 = null;
          localObject1 = localObject2;
          if (paramString2 != null)
          {
            localObject1 = localObject2;
            if (!paramString2.equals(""))
            {
              if (gTTFMap == null) {
                gTTFMap = new HashMap();
              }
              if (!gTTFMap.containsKey(paramString2)) {
                break label493;
              }
              localObject1 = (Typeface)gTTFMap.get(paramString2);
            }
          }
          if (paramInt6 != 1) {
            break label516;
          }
          localStrokeTextView.setTypeface((Typeface)localObject1, 1);
          if ((paramFloat1 != 0.0F) && (paramFloat1 != (0.0F / 0.0F)))
          {
            localStrokeTextView.setStrokeEnable(true);
            localStrokeTextView.setStrokeSize((int)paramFloat1);
            localStrokeTextView.setStrokeColor(paramInt7);
          }
          if ((paramFloat2 != 0.0F) && (paramFloat2 != (0.0F / 0.0F))) {
            localStrokeTextView.setShadow(paramFloat2, paramFloat3, paramFloat4, paramInt8);
          }
          localStrokeTextView.setInnerTextColor(paramInt2);
          localStrokeTextView.setTextSize(f);
          localStrokeTextView.setText(paramString1);
          localStrokeTextView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
          paramInt1 = localStrokeTextView.getMeasuredWidth();
          paramInt2 = localStrokeTextView.getMeasuredHeight();
          localStrokeTextView.layout(0, 0, paramInt1, paramInt2);
          paramString1 = null;
          localObject1 = "group_brand_" + paramInt1 + "_" + paramInt2;
          if (BaseApplicationImpl.sImageCache != null)
          {
            paramString2 = (Bitmap)BaseApplicationImpl.sImageCache.get(localObject1);
            paramString1 = paramString2;
            if (paramString2 != null)
            {
              paramString1 = paramString2;
              if (QLog.isColorLevel())
              {
                QLog.d("sava_ApolloRender", 2, "group brand ----> get bitmap from cache key: " + (String)localObject1);
                paramString1 = paramString2;
              }
            }
          }
          paramString2 = paramString1;
          if (paramString1 != null) {}
        }
        if (paramInt5 != 1) {
          break label478;
        }
      }
      catch (Exception paramString1)
      {
        try
        {
          paramString1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
          paramString2 = paramString1;
          if (BaseApplicationImpl.sImageCache != null)
          {
            BaseApplicationImpl.sImageCache.put(localObject1, paramString1);
            paramString2 = paramString1;
          }
          localStrokeTextView.draw(new Canvas(paramString2));
          return paramString2;
        }
        catch (OutOfMemoryError paramString1)
        {
          StrokeTextView localStrokeTextView;
          Object localObject1;
          if (!QLog.isColorLevel()) {
            break label627;
          }
          QLog.d("sava_ApolloRender", 2, "errInfo->" + paramString1.getMessage());
        }
        catch (Exception paramString1)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("sava_ApolloRender", 2, "errInfo->" + paramString1.getMessage());
          return null;
        }
        paramString1 = paramString1;
        QLog.e("sava_ApolloRender", 2, "getTextBitMapException e=" + paramString1.toString());
        return null;
      }
      localStrokeTextView.setGravity(17);
      continue;
      label478:
      if (paramInt5 == 2)
      {
        localStrokeTextView.setGravity(5);
        continue;
        label493:
        localObject1 = Typeface.createFromFile(paramString2);
        gTTFMap.put(paramString2, localObject1);
        continue;
        if (paramInt6 == 2) {
          localStrokeTextView.setTypeface((Typeface)localObject1, 2);
        } else if (paramInt6 == 3) {
          localStrokeTextView.setTypeface((Typeface)localObject1, 3);
        }
      }
    }
    label627:
    return null;
  }
  
  public static int[] getTextViewSize(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    paramString1 = new TextView(BaseApplicationImpl.getContext());
    Paint.FontMetricsInt localFontMetricsInt = new Paint.FontMetricsInt();
    paramString1.getPaint().getFontMetricsInt(localFontMetricsInt);
    if (localFontMetricsInt.ascent - localFontMetricsInt.top == 0) {
      int i = (int)(2.0F * babp.a);
    }
    paramString1.setGravity(17);
    paramString1.setTextSize(paramInt1);
    paramString1.setText(paramString2);
    if (paramInt2 != 0) {
      paramString1.setMaxWidth(paramInt2);
    }
    paramString1.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    paramInt1 = paramString1.getMeasuredWidth();
    paramInt2 = paramString1.getMeasuredHeight();
    paramString1.layout(0, 0, paramInt1, paramInt2);
    return new int[] { paramInt1, paramInt2 };
  }
  
  public static int[] getTextViewSize(int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString2, int paramInt8, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt9)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    float f = (float)(paramInt1 * 1.0D / babp.a);
    StrokeTextView localStrokeTextView = new StrokeTextView(BaseApplicationImpl.getContext(), null);
    localStrokeTextView.setIncludeFontPadding(false);
    Object localObject1;
    if (paramInt6 == 0)
    {
      localStrokeTextView.setGravity(3);
      Object localObject2 = null;
      localObject1 = localObject2;
      if (paramString2 != null)
      {
        localObject1 = localObject2;
        if (!paramString2.equals(""))
        {
          if (gTTFMap == null) {
            gTTFMap = new HashMap();
          }
          if (!gTTFMap.containsKey(paramString2)) {
            break label361;
          }
          localObject1 = (Typeface)gTTFMap.get(paramString2);
        }
      }
      label123:
      if (paramInt7 != 1) {
        break label384;
      }
      localStrokeTextView.setTypeface((Typeface)localObject1, 1);
    }
    for (;;)
    {
      localStrokeTextView.setTextSize(f);
      localStrokeTextView.setText(paramString1);
      if (paramInt4 != 0) {
        localStrokeTextView.setMaxWidth(paramInt4);
      }
      if (paramInt5 != 0) {
        localStrokeTextView.setMaxHeight(paramInt5);
      }
      if (paramFloat1 != 0.0F)
      {
        localStrokeTextView.setStrokeEnable(true);
        localStrokeTextView.setStrokeSize((int)paramFloat1);
        localStrokeTextView.setStrokeColor(paramInt8);
      }
      if (paramFloat2 != 0.0F) {
        localStrokeTextView.setShadow(paramFloat2, paramFloat3, paramFloat4, paramInt9);
      }
      localStrokeTextView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      paramInt6 = localStrokeTextView.getMeasuredWidth();
      paramInt5 = localStrokeTextView.getMeasuredHeight();
      paramInt4 = paramInt5;
      paramInt1 = paramInt6;
      if (paramFloat2 != 0.0F)
      {
        paramInt1 = Math.max(paramInt6, (int)paramFloat3 + paramInt6);
        paramInt4 = Math.max(paramInt5, (int)paramFloat4 + paramInt5);
      }
      paramString1 = new int[4];
      paramString1[0] = paramInt1;
      paramString1[1] = paramInt4;
      paramString1[2] = paramInt1;
      paramString1[3] = paramInt4;
      if (paramInt2 != 0) {
        paramString1[0] = paramInt2;
      }
      if (paramInt3 != 0) {
        paramString1[1] = paramInt3;
      }
      return paramString1;
      if (paramInt6 == 1)
      {
        localStrokeTextView.setGravity(17);
        break;
      }
      if (paramInt6 != 2) {
        break;
      }
      localStrokeTextView.setGravity(5);
      break;
      label361:
      localObject1 = Typeface.createFromFile(paramString2);
      gTTFMap.put(paramString2, localObject1);
      break label123;
      label384:
      if (paramInt7 == 2) {
        localStrokeTextView.setTypeface((Typeface)localObject1, 2);
      } else if (paramInt7 == 3) {
        localStrokeTextView.setTypeface((Typeface)localObject1, 3);
      }
    }
  }
  
  public static String getUserPath(int paramInt)
  {
    Object localObject = aing.a();
    long l = 0L;
    if (localObject != null) {
      l = ((AppInterface)localObject).getLongAccountUin();
    }
    localObject = new File(aiys.jdField_a_of_type_JavaLangString + "/storage/" + l);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return ((File)localObject).getAbsolutePath() + "/" + paramInt;
  }
  
  public static int getfd(Socket paramSocket)
  {
    int i;
    try
    {
      localObject = Socket.class.getDeclaredField("impl");
      ((Field)localObject).setAccessible(true);
      paramSocket = (SocketImpl)((Field)localObject).get(paramSocket);
      localObject = SocketImpl.class.getDeclaredField("fd");
      ((Field)localObject).setAccessible(true);
      localObject = (FileDescriptor)((Field)localObject).get(paramSocket);
      paramSocket = null;
      arrayOfField = FileDescriptor.class.getDeclaredFields();
      i = 0;
    }
    catch (OutOfMemoryError paramSocket)
    {
      Object localObject;
      Field[] arrayOfField;
      int j;
      boolean bool;
      if (!QLog.isColorLevel()) {
        break label170;
      }
      QLog.d("sava_ApolloRender", 2, paramSocket.getMessage());
      return 0;
    }
    catch (Exception paramSocket)
    {
      label170:
      label205:
      do
      {
        for (;;)
        {
          QLog.e("sava_ApolloRender", 2, "socket exception e=" + paramSocket.toString());
          continue;
          i += 1;
        }
      } while (paramSocket != null);
      i = 0;
    }
    if (i < arrayOfField.length)
    {
      if ("descriptor".equals(arrayOfField[i].getName())) {
        paramSocket = FileDescriptor.class.getDeclaredField("descriptor");
      }
      if ("fd".equals(arrayOfField[i].getName()))
      {
        paramSocket = FileDescriptor.class.getDeclaredField("fd");
        break label205;
        paramSocket.setAccessible(true);
        j = paramSocket.getInt(localObject);
        bool = QLog.isColorLevel();
        i = j;
        if (!bool) {
          return i;
        }
        return j;
      }
    }
    return i;
  }
  
  public static void hideKeyBoard(long paramLong)
  {
    ApolloRender localApolloRender = getRenderByThreadId();
    localApolloRender.mEditorAddr = paramLong;
    ThreadManager.getUIHandler().post(new ApolloRender.23(localApolloRender));
  }
  
  public static void hideLoading() {}
  
  public static void hideToast() {}
  
  @Deprecated
  public static void httpRequest(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String[] paramArrayOfString, boolean paramBoolean)
  {
    View localView = getRenderViewByThreadId();
    if (localView == null) {
      return;
    }
    if ((paramString2 == null) || ("".equals(paramString2)))
    {
      QLog.e("sava_ApolloRender", 2, "httpLog  httpRequest method null ");
      return;
    }
    ThreadManager.post(new ApolloRender.10(paramString2, paramString1, paramArrayOfString, new aigq(localView, paramLong), paramBoolean, paramString3, paramString4, paramString5), 5, null, true);
  }
  
  @Deprecated
  public static void httpRequestData(long paramLong, String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3, String paramString4, String[] paramArrayOfString, boolean paramBoolean)
  {
    paramString3 = getRenderViewByThreadId();
    if (paramString3 == null) {
      return;
    }
    if ((paramString2 == null) || ("".equals(paramString2)))
    {
      QLog.e("sava_ApolloRender", 2, "httpLog  httpRequest method null ");
      return;
    }
    ThreadManager.post(new ApolloRender.8(paramString2, paramString1, paramArrayOfByte, paramArrayOfString, new aigp(paramString3, paramLong)), 5, null, true);
  }
  
  public static boolean isGameMode()
  {
    View localView = getRenderViewByThreadId();
    return (localView != null) && ((localView instanceof ApolloSurfaceView)) && (((ApolloSurfaceView)localView).isGameMode());
  }
  
  public static boolean isJavaMethodExist(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("sava_ApolloRender", 2, new Object[] { "[isJavaMethodExist], name:", paramString1, ",classType:", Integer.valueOf(paramInt), "paramType:", paramString2 });
    }
    long l = System.currentTimeMillis();
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    Object localObject = null;
    if (1 == paramInt) {
      localObject = ApolloRender.class;
    }
    while (localObject == null)
    {
      try
      {
        QLog.w("sava_ApolloRender", 2, "unknown class type.");
        return false;
      }
      catch (Throwable paramString2)
      {
        QLog.e("sava_ApolloRender", 1, "method NOT exists, name:" + paramString1 + "," + paramString2);
        return false;
      }
      if (2 == paramInt) {
        localObject = ApolloCmdChannel.class;
      }
    }
    localObject = ((Class)localObject).getDeclaredMethod(paramString1, aing.a(paramString2)).getReturnType();
    paramString2 = aing.a(paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("sava_ApolloRender", 2, new Object[] { "reflect cost:", Long.valueOf(System.currentTimeMillis() - l) });
    }
    if ((localObject != null) && (paramString2 != null) && (((Class)localObject).getName() != null) && (((Class)localObject).getName().equals(paramString2.getName()))) {
      return true;
    }
    QLog.w("sava_ApolloRender", 1, "method NOT exists, different return type");
    return false;
  }
  
  protected static byte[] jsha1(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject = null;
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = localMessageDigest.digest();
      return paramArrayOfByte;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      do
      {
        paramArrayOfByte = localObject;
      } while (!QLog.isColorLevel());
      QLog.d("sava_ApolloRender", 2, localOutOfMemoryError.getMessage());
      return null;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      QLog.e("sava_ApolloRender", 2, "java sha1  Error:" + paramArrayOfByte.getMessage());
    }
    return null;
  }
  
  /* Error */
  public static Bitmap loadGif(String paramString, int paramInt)
  {
    // Byte code:
    //   0: new 474	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 475	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: iconst_1
    //   10: putfield 478	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   13: aload_2
    //   14: iconst_0
    //   15: putfield 481	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   18: aload_2
    //   19: getstatic 487	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   22: putfield 490	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   25: aload_0
    //   26: aload_2
    //   27: invokestatic 855	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   30: astore_3
    //   31: aload_3
    //   32: invokevirtual 501	android/graphics/Bitmap:getWidth	()I
    //   35: aload_3
    //   36: invokevirtual 504	android/graphics/Bitmap:getHeight	()I
    //   39: getstatic 487	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   42: invokestatic 508	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   45: astore_0
    //   46: aload_0
    //   47: astore_2
    //   48: new 510	android/graphics/Canvas
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 513	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   56: astore 4
    //   58: aload_0
    //   59: astore_2
    //   60: aload 4
    //   62: aload_3
    //   63: fconst_0
    //   64: fconst_0
    //   65: aconst_null
    //   66: invokevirtual 517	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   69: aload_0
    //   70: astore_2
    //   71: aload 4
    //   73: invokevirtual 520	android/graphics/Canvas:save	()I
    //   76: pop
    //   77: aload_0
    //   78: astore 4
    //   80: aload 4
    //   82: areturn
    //   83: astore_3
    //   84: aconst_null
    //   85: astore_0
    //   86: aload_0
    //   87: astore 4
    //   89: aload_0
    //   90: astore_2
    //   91: invokestatic 302	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq -14 -> 80
    //   97: aload_0
    //   98: astore_2
    //   99: ldc 61
    //   101: iconst_2
    //   102: aload_3
    //   103: invokevirtual 523	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   106: invokestatic 321	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: aload_0
    //   110: areturn
    //   111: aload_0
    //   112: astore_2
    //   113: aload_3
    //   114: invokevirtual 526	java/lang/Exception:printStackTrace	()V
    //   117: aload_0
    //   118: areturn
    //   119: astore_0
    //   120: aconst_null
    //   121: areturn
    //   122: astore_3
    //   123: goto -12 -> 111
    //   126: astore_3
    //   127: goto -41 -> 86
    //   130: astore_0
    //   131: aload_2
    //   132: areturn
    //   133: astore_3
    //   134: aconst_null
    //   135: astore_0
    //   136: goto -25 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	paramString	String
    //   0	139	1	paramInt	int
    //   7	125	2	localObject1	Object
    //   30	33	3	localBitmap	Bitmap
    //   83	31	3	localOutOfMemoryError1	OutOfMemoryError
    //   122	1	3	localException1	Exception
    //   126	1	3	localOutOfMemoryError2	OutOfMemoryError
    //   133	1	3	localException2	Exception
    //   56	32	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	46	83	java/lang/OutOfMemoryError
    //   0	46	119	finally
    //   48	58	122	java/lang/Exception
    //   60	69	122	java/lang/Exception
    //   71	77	122	java/lang/Exception
    //   48	58	126	java/lang/OutOfMemoryError
    //   60	69	126	java/lang/OutOfMemoryError
    //   71	77	126	java/lang/OutOfMemoryError
    //   48	58	130	finally
    //   60	69	130	finally
    //   71	77	130	finally
    //   91	97	130	finally
    //   99	109	130	finally
    //   113	117	130	finally
    //   0	46	133	java/lang/Exception
  }
  
  public static Bitmap loadImage(String paramString, int paramInt)
  {
    return getImageBitmap(paramString, max_image_width * 2, max_image_height * 2);
  }
  
  public static void locationEnd(View paramView, zrw paramzrw, long paramLong, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, String paramString1, int paramInt, String paramString2)
  {
    paramzrw.b();
    ((ApolloSurfaceView)paramView).getRender().getSavaWrapper().a(paramLong, paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6, paramString1, paramInt, paramString2);
  }
  
  public static void printNativeLog(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    aikb localaikb;
    try
    {
      if ("FROM_PIPE".equals(paramString3))
      {
        if (paramInt1 > 0)
        {
          QLog.e("sava_native_log", 1, new Object[] { "read log from Pipe:", paramString1 });
          return;
        }
        QLog.d("sava_native_log", 2, new Object[] { "read log from Pipe:", paramString1 });
        return;
      }
    }
    catch (OutOfMemoryError paramString1)
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("sava_ApolloRender", 2, paramString1.getMessage());
      return;
      localaikb = aing.a();
      if ((paramInt2 < 0) || (paramInt1 > 0))
      {
        paramString1 = ApolloUtil.e(paramString1);
        paramString2 = ApolloUtil.e(paramString2);
        paramString3 = ApolloUtil.e(paramString3);
        QLog.e("sava_native_log", 1, new Object[] { "level:", Integer.valueOf(paramInt1), ",code:", Integer.valueOf(paramInt2), ",info1:", paramString1, ",info2:", paramString2, ",info3:", paramString3 });
        if (localaikb == null) {
          return;
        }
        localaikb.a("sava_native_log", 2, new Object[] { "level:", Integer.valueOf(paramInt1), ",code:", Integer.valueOf(paramInt2), ",info1:", paramString1, ",info2:", paramString2, ",info3:", paramString3 });
        return;
      }
    }
    catch (Throwable paramString1)
    {
      QLog.e("sava_ApolloRender", 1, "[printNativeLog]", paramString1);
      return;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("sava_native_log", 2, new Object[] { "level:", Integer.valueOf(paramInt1), ",code:", Integer.valueOf(paramInt2), ",info1:", paramString1, ",info2:", paramString2, ",info3:", paramString3 });
      if (localaikb != null) {
        localaikb.a("sava_native_log", 1, new Object[] { "level:", Integer.valueOf(paramInt1), ",code:", Integer.valueOf(paramInt2), ",info1:", paramString1, ",info2:", paramString2, ",info3:", paramString3 });
      }
    }
  }
  
  public static void printNativeVersion(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("sava_ApolloRender", 2, new Object[] { "version:", paramString });
    }
    sNativeVersion = paramString;
  }
  
  public static ApolloDevInfo queryDevInfo()
  {
    ApolloDevInfo localApolloDevInfo = new ApolloDevInfo();
    localApolloDevInfo.model = babp.i();
    localApolloDevInfo.platform = "android";
    localApolloDevInfo.version = babp.e();
    localApolloDevInfo.QQVersion = babp.c();
    localApolloDevInfo.pixelRatio = babp.a();
    localApolloDevInfo.screenHeight = ((float)babp.l());
    localApolloDevInfo.screenWidth = ((float)babp.k());
    return localApolloDevInfo;
  }
  
  /* Error */
  public static byte[] readStream(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: ifnonnull +8 -> 12
    //   7: aload 5
    //   9: astore_0
    //   10: aload_0
    //   11: areturn
    //   12: new 1398	java/io/ByteArrayOutputStream
    //   15: dup
    //   16: invokespecial 1399	java/io/ByteArrayOutputStream:<init>	()V
    //   19: astore_3
    //   20: aload_3
    //   21: astore_2
    //   22: sipush 1024
    //   25: newarray byte
    //   27: astore 4
    //   29: aload_3
    //   30: astore_2
    //   31: aload_0
    //   32: aload 4
    //   34: invokevirtual 1405	java/io/InputStream:read	([B)I
    //   37: istore_1
    //   38: iload_1
    //   39: iconst_m1
    //   40: if_icmpeq +67 -> 107
    //   43: aload_3
    //   44: astore_2
    //   45: aload_3
    //   46: aload 4
    //   48: iconst_0
    //   49: iload_1
    //   50: invokevirtual 1409	java/io/ByteArrayOutputStream:write	([BII)V
    //   53: goto -24 -> 29
    //   56: astore 4
    //   58: aload_3
    //   59: astore_2
    //   60: ldc 61
    //   62: iconst_1
    //   63: aload 4
    //   65: iconst_0
    //   66: anewarray 4	java/lang/Object
    //   69: invokestatic 776	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   72: aload_0
    //   73: ifnull +7 -> 80
    //   76: aload_0
    //   77: invokevirtual 1412	java/io/InputStream:close	()V
    //   80: aload 5
    //   82: astore_0
    //   83: aload_3
    //   84: ifnull -74 -> 10
    //   87: aload_3
    //   88: invokevirtual 1413	java/io/ByteArrayOutputStream:close	()V
    //   91: aconst_null
    //   92: areturn
    //   93: astore_0
    //   94: ldc 61
    //   96: iconst_1
    //   97: aload_0
    //   98: iconst_0
    //   99: anewarray 4	java/lang/Object
    //   102: invokestatic 776	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   105: aconst_null
    //   106: areturn
    //   107: aload_3
    //   108: astore_2
    //   109: aload_3
    //   110: invokevirtual 1416	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   113: astore 4
    //   115: aload 4
    //   117: astore_2
    //   118: aload_0
    //   119: ifnull +7 -> 126
    //   122: aload_0
    //   123: invokevirtual 1412	java/io/InputStream:close	()V
    //   126: aload_2
    //   127: astore_0
    //   128: aload_3
    //   129: ifnull -119 -> 10
    //   132: aload_3
    //   133: invokevirtual 1413	java/io/ByteArrayOutputStream:close	()V
    //   136: aload_2
    //   137: areturn
    //   138: astore_0
    //   139: ldc 61
    //   141: iconst_1
    //   142: aload_0
    //   143: iconst_0
    //   144: anewarray 4	java/lang/Object
    //   147: invokestatic 776	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   150: aload_2
    //   151: areturn
    //   152: astore_0
    //   153: ldc 61
    //   155: iconst_1
    //   156: aload_0
    //   157: iconst_0
    //   158: anewarray 4	java/lang/Object
    //   161: invokestatic 776	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   164: goto -38 -> 126
    //   167: astore_0
    //   168: ldc 61
    //   170: iconst_1
    //   171: aload_0
    //   172: iconst_0
    //   173: anewarray 4	java/lang/Object
    //   176: invokestatic 776	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   179: goto -99 -> 80
    //   182: astore_3
    //   183: aconst_null
    //   184: astore_2
    //   185: aload_0
    //   186: ifnull +7 -> 193
    //   189: aload_0
    //   190: invokevirtual 1412	java/io/InputStream:close	()V
    //   193: aload_2
    //   194: ifnull +7 -> 201
    //   197: aload_2
    //   198: invokevirtual 1413	java/io/ByteArrayOutputStream:close	()V
    //   201: aload_3
    //   202: athrow
    //   203: astore_0
    //   204: ldc 61
    //   206: iconst_1
    //   207: aload_0
    //   208: iconst_0
    //   209: anewarray 4	java/lang/Object
    //   212: invokestatic 776	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   215: goto -22 -> 193
    //   218: astore_0
    //   219: ldc 61
    //   221: iconst_1
    //   222: aload_0
    //   223: iconst_0
    //   224: anewarray 4	java/lang/Object
    //   227: invokestatic 776	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   230: goto -29 -> 201
    //   233: astore_3
    //   234: goto -49 -> 185
    //   237: astore 4
    //   239: aconst_null
    //   240: astore_3
    //   241: goto -183 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	paramInputStream	java.io.InputStream
    //   37	13	1	i	int
    //   21	177	2	localObject1	Object
    //   19	114	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   182	20	3	localObject2	Object
    //   233	1	3	localObject3	Object
    //   240	1	3	localObject4	Object
    //   27	20	4	arrayOfByte1	byte[]
    //   56	8	4	localException1	Exception
    //   113	3	4	arrayOfByte2	byte[]
    //   237	1	4	localException2	Exception
    //   1	80	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   22	29	56	java/lang/Exception
    //   31	38	56	java/lang/Exception
    //   45	53	56	java/lang/Exception
    //   109	115	56	java/lang/Exception
    //   87	91	93	java/io/IOException
    //   132	136	138	java/io/IOException
    //   122	126	152	java/io/IOException
    //   76	80	167	java/io/IOException
    //   12	20	182	finally
    //   189	193	203	java/io/IOException
    //   197	201	218	java/io/IOException
    //   22	29	233	finally
    //   31	38	233	finally
    //   45	53	233	finally
    //   60	72	233	finally
    //   109	115	233	finally
    //   12	20	237	java/lang/Exception
  }
  
  /* Error */
  private static void recursionZip(java.util.zip.ZipOutputStream paramZipOutputStream, File paramFile, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_1
    //   3: invokevirtual 1421	java/io/File:isDirectory	()Z
    //   6: ifeq +91 -> 97
    //   9: aload_2
    //   10: ldc_w 963
    //   13: invokevirtual 347	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16: ifeq +40 -> 56
    //   19: aload_1
    //   20: invokevirtual 1422	java/io/File:getName	()Ljava/lang/String;
    //   23: astore_2
    //   24: aload_1
    //   25: invokevirtual 1426	java/io/File:listFiles	()[Ljava/io/File;
    //   28: astore_1
    //   29: aload_1
    //   30: arraylength
    //   31: istore 4
    //   33: iload_3
    //   34: iload 4
    //   36: if_icmpge +153 -> 189
    //   39: aload_1
    //   40: iload_3
    //   41: aaload
    //   42: astore 5
    //   44: aload 5
    //   46: ifnonnull +41 -> 87
    //   49: iload_3
    //   50: iconst_1
    //   51: iadd
    //   52: istore_3
    //   53: goto -20 -> 33
    //   56: new 175	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   63: aload_2
    //   64: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: getstatic 1429	java/io/File:separator	Ljava/lang/String;
    //   70: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_1
    //   74: invokevirtual 1422	java/io/File:getName	()Ljava/lang/String;
    //   77: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: astore_2
    //   84: goto -60 -> 24
    //   87: aload_0
    //   88: aload 5
    //   90: aload_2
    //   91: invokestatic 1431	com/tencent/mobileqq/apollo/ApolloRender:recursionZip	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;)V
    //   94: goto -45 -> 49
    //   97: sipush 4096
    //   100: newarray byte
    //   102: astore 6
    //   104: new 1433	java/io/BufferedInputStream
    //   107: dup
    //   108: new 1435	java/io/FileInputStream
    //   111: dup
    //   112: aload_1
    //   113: invokespecial 1438	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   116: invokespecial 1441	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   119: astore 5
    //   121: aload_2
    //   122: ldc_w 963
    //   125: invokevirtual 347	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   128: ifeq +62 -> 190
    //   131: aload_1
    //   132: invokevirtual 1422	java/io/File:getName	()Ljava/lang/String;
    //   135: astore_1
    //   136: aload_0
    //   137: new 1443	java/util/zip/ZipEntry
    //   140: dup
    //   141: aload_1
    //   142: invokespecial 1444	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   145: invokevirtual 1450	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   148: aload 5
    //   150: aload 6
    //   152: invokevirtual 1405	java/io/InputStream:read	([B)I
    //   155: istore_3
    //   156: iload_3
    //   157: iconst_m1
    //   158: if_icmpeq +63 -> 221
    //   161: aload_0
    //   162: aload 6
    //   164: iconst_0
    //   165: iload_3
    //   166: invokevirtual 1451	java/util/zip/ZipOutputStream:write	([BII)V
    //   169: goto -21 -> 148
    //   172: astore_0
    //   173: invokestatic 302	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   176: ifeq +13 -> 189
    //   179: ldc 61
    //   181: iconst_2
    //   182: aload_0
    //   183: invokevirtual 523	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   186: invokestatic 321	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: return
    //   190: new 175	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   197: aload_2
    //   198: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: getstatic 1429	java/io/File:separator	Ljava/lang/String;
    //   204: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload_1
    //   208: invokevirtual 1422	java/io/File:getName	()Ljava/lang/String;
    //   211: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: astore_1
    //   218: goto -82 -> 136
    //   221: aload 5
    //   223: invokevirtual 1412	java/io/InputStream:close	()V
    //   226: return
    //   227: astore_0
    //   228: aload 5
    //   230: astore_1
    //   231: aload_1
    //   232: ifnull +7 -> 239
    //   235: aload_1
    //   236: invokevirtual 1412	java/io/InputStream:close	()V
    //   239: aload_0
    //   240: invokevirtual 526	java/lang/Exception:printStackTrace	()V
    //   243: return
    //   244: astore_0
    //   245: aconst_null
    //   246: astore_1
    //   247: goto -16 -> 231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	paramZipOutputStream	java.util.zip.ZipOutputStream
    //   0	250	1	paramFile	File
    //   0	250	2	paramString	String
    //   1	165	3	i	int
    //   31	6	4	j	int
    //   42	187	5	localObject	Object
    //   102	61	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   104	121	172	java/lang/OutOfMemoryError
    //   121	136	172	java/lang/OutOfMemoryError
    //   136	148	172	java/lang/OutOfMemoryError
    //   148	156	172	java/lang/OutOfMemoryError
    //   161	169	172	java/lang/OutOfMemoryError
    //   190	218	172	java/lang/OutOfMemoryError
    //   221	226	172	java/lang/OutOfMemoryError
    //   121	136	227	java/lang/Exception
    //   136	148	227	java/lang/Exception
    //   148	156	227	java/lang/Exception
    //   161	169	227	java/lang/Exception
    //   190	218	227	java/lang/Exception
    //   221	226	227	java/lang/Exception
    //   104	121	244	java/lang/Exception
  }
  
  private void reportDeviceInfoTo644(GL10 paramGL10)
  {
    int i = aing.a(getSavaWrapper().a());
    if (-1 == i) {
      return;
    }
    String str1 = paramGL10.glGetString(7936);
    String str2 = paramGL10.glGetString(7937);
    ThreadManager.post(new ApolloRender.4(this, str1, paramGL10.glGetString(7938), str2, i), 5, null, true);
  }
  
  public static void requestRenderView() {}
  
  protected static void selectPhoto(long paramLong, int paramInt1, int paramInt2)
  {
    View localView = getRenderViewByThreadId();
    ApolloRender localApolloRender = getRenderByThreadId();
    if (localView == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new ApolloRender.26(paramLong, paramInt1, localView, localApolloRender));
  }
  
  public static void selectPhotoFromSystem(int paramInt1, int paramInt2, Intent paramIntent)
  {
    QLog.e("sava_ApolloRender", 2, "imageselector selectPhotoFromSystem");
    View localView = getRenderViewByThreadId();
    getRenderByThreadId();
    if (localView == null)
    {
      QLog.e("sava_ApolloRender", 2, "imageselector view Null                 Error");
      return;
    }
    if (g_imageselector == 0L)
    {
      QLog.e("sava_ApolloRender", 2, "imageselector g_imageselector == 0             Error");
      return;
    }
    Object localObject;
    if ((localView instanceof ApolloSurfaceView))
    {
      if (QLog.isColorLevel()) {
        QLog.e("sava_ApolloRender", 2, "imageselector selectimagecallback ");
      }
      if (paramInt2 == -1)
      {
        localObject = null;
        if (paramInt1 == 14005)
        {
          localObject = getImageBitmap(cmshow_photofile_file.getAbsolutePath(), max_image_width, max_image_height);
          cmshow_photofile_file = null;
          if (localObject == null) {
            break label301;
          }
          paramIntent = ByteBuffer.allocate(((Bitmap)localObject).getByteCount());
          paramInt1 = ((Bitmap)localObject).getWidth();
          int i = ((Bitmap)localObject).getHeight();
          ((Bitmap)localObject).copyPixelsToBuffer(paramIntent);
          paramIntent = paramIntent.array();
          QLog.e("sava_ApolloRender", 2, "imageselector selectimageallback surfaceView  " + paramInt2 + " data: ");
          ((ApolloSurfaceView)localView).getRender().getSavaWrapper().a(g_imageselector, 1, paramInt1, i, paramIntent);
        }
      }
    }
    for (;;)
    {
      QLog.e("sava_ApolloRender", 2, "imageselector selectPhotoFromSystem  111111111111111111");
      return;
      if (paramInt1 != 14006) {
        break;
      }
      localObject = paramIntent.getData();
      paramIntent = new String[1];
      paramIntent[0] = "_data";
      localObject = localView.getContext().getContentResolver().query((Uri)localObject, paramIntent, null, null, null);
      ((Cursor)localObject).moveToFirst();
      paramIntent = ((Cursor)localObject).getString(((Cursor)localObject).getColumnIndex(paramIntent[0]));
      ((Cursor)localObject).close();
      localObject = getImageBitmap(paramIntent, 1024, 1024);
      break;
      label301:
      ((ApolloSurfaceView)localView).getRender().getSavaWrapper().a(g_imageselector, 2, 0, 0, null);
      continue;
      if (paramInt2 == 0)
      {
        ((ApolloSurfaceView)localView).getRender().getSavaWrapper().a(g_imageselector, 3, 0, 0, null);
      }
      else
      {
        ((ApolloSurfaceView)localView).getRender().getSavaWrapper().a(g_imageselector, 2, 0, 0, null);
        continue;
        if ((localView instanceof ApolloTextureView)) {
          ((ApolloTextureView)localView).queueEvent(new ApolloRender.27(paramInt2, paramIntent, localView));
        } else {
          QLog.e("sava_ApolloRender", 2, "imageselector view type else ");
        }
      }
    }
  }
  
  public static void sendHttpRequest(long paramLong, @NonNull String paramString1, @NonNull String paramString2, @NonNull String[] paramArrayOfString, @Nullable byte[] paramArrayOfByte)
  {
    View localView = getRenderViewByThreadId();
    if (localView == null) {}
    ApolloRender localApolloRender;
    do
    {
      return;
      if (TextUtils.isEmpty(paramString1))
      {
        QLog.e("sava_ApolloRender", 1, "sendHttpRequest url is empty");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("sava_ApolloRender", 2, new Object[] { "ApolloHttpUtil sendHttpRequest http:", Long.valueOf(paramLong), " url:", paramString1, " method:", paramString2 });
      }
      localApolloRender = getRenderByThreadId();
    } while (localApolloRender == null);
    ThreadManager.post(new ApolloRender.14(paramString1, paramString2, paramArrayOfString, paramArrayOfByte, new aigf(localView, paramLong, paramString1, paramString2, localApolloRender), new aigg(localView, localApolloRender, paramLong), new aigh(localView, localApolloRender, paramLong)), 5, null, true);
  }
  
  public static void setEditorBtnClick(ApolloSurfaceView paramApolloSurfaceView, ApolloRender paramApolloRender)
  {
    if (paramApolloRender.mEditorBtn != null) {
      paramApolloRender.mEditorBtn.setOnClickListener(new aigj(paramApolloRender, paramApolloSurfaceView));
    }
  }
  
  public static void setEditorWatcher(ApolloSurfaceView paramApolloSurfaceView, ApolloRender paramApolloRender)
  {
    if (paramApolloRender.mEditorPop != null) {
      paramApolloRender.mEditorPop.addTextChangedListener(new aigk(paramApolloSurfaceView, paramApolloRender));
    }
  }
  
  public static void setIntervalTicker(long paramLong, int paramInt)
  {
    Object localObject = getRenderByThreadId();
    if (localObject != null) {
      if (((ApolloRender)localObject).mApolloTicker != null) {
        ((ApolloRender)localObject).mApolloTicker.setInterval(paramLong, paramInt);
      }
    }
    do
    {
      do
      {
        return;
        localObject = (WeakReference)sTickerMap.get(Long.valueOf(Thread.currentThread().getId()));
      } while (localObject == null);
      localObject = (ApolloTicker)((WeakReference)localObject).get();
    } while (localObject == null);
    ((ApolloTicker)localObject).setInterval(paramLong, paramInt);
  }
  
  public static void setKeepScreenOn(int paramInt)
  {
    View localView = getRenderViewByThreadId();
    if (localView == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new ApolloRender.28(localView, paramInt));
  }
  
  public static void setKeyBoardText(long paramLong, String paramString)
  {
    ApolloRender localApolloRender = getRenderByThreadId();
    localApolloRender.mEditorAddr = paramLong;
    if (localApolloRender.mEditWindow == null)
    {
      localApolloRender.mEditorDefaultText = paramString;
      return;
    }
    ThreadManager.getUIHandler().post(new ApolloRender.24(localApolloRender, paramString));
  }
  
  public static void setRenderMode(int paramInt)
  {
    Object localObject = getRenderViewByThreadId();
    if ((localObject != null) && ((localObject instanceof ApolloSurfaceView)))
    {
      ((ApolloSurfaceView)localObject).mRenderMode = paramInt;
      ((ApolloSurfaceView)localObject).setRenderMode(paramInt);
      localObject = getRenderByThreadId();
      if ((localObject != null) && (((ApolloRender)localObject).mApolloTicker != null))
      {
        if (paramInt != 0) {
          break label61;
        }
        tickerResume(((ApolloRender)localObject).mApolloTicker.ticker);
      }
    }
    label61:
    while (paramInt != 1) {
      return;
    }
    tickerPause(((ApolloRender)localObject).mApolloTicker.ticker);
  }
  
  public static void setVisiblePopEidtor(View paramView, ApolloRender paramApolloRender)
  {
    if (paramApolloRender == null) {}
    do
    {
      return;
      if (paramApolloRender.mEditWindow == null)
      {
        paramApolloRender.mEditWindow = new PopupWindow(paramView.getContext());
        Object localObject = (RelativeLayout)LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(2131493059, null);
        paramApolloRender.mEditWindow.setContentView((View)localObject);
        paramApolloRender.mEditorPop = ((EditText)((RelativeLayout)localObject).findViewById(2131297063));
        ((RelativeLayout)localObject).requestLayout();
        ((RelativeLayout)localObject).post(new ApolloRender.18(paramApolloRender, (RelativeLayout)localObject));
        paramApolloRender.mEditorBtn = ((Button)((RelativeLayout)localObject).findViewById(2131297064));
        paramApolloRender.mEditorBtn.setWidth((int)(50.0F * babp.a));
        paramApolloRender.mEditWindow.setOutsideTouchable(false);
        paramApolloRender.mEditWindow.setFocusable(true);
        if (paramApolloRender.mEditorDefaultText != null)
        {
          paramApolloRender.mEditorPop.setText(paramApolloRender.mEditorDefaultText);
          paramApolloRender.mEditorPop.setSelection(paramApolloRender.mEditorDefaultText.length());
        }
        localObject = BaseApplicationImpl.getContext().getResources().getDrawable(2130848528);
        paramApolloRender.mEditWindow.setBackgroundDrawable((Drawable)localObject);
      }
      setEditorWatcher((ApolloSurfaceView)paramView, paramApolloRender);
      setEditorBtnClick((ApolloSurfaceView)paramView, paramApolloRender);
      paramApolloRender.mEditWindow.setWidth(-1);
      i = (int)(55.0F * babp.a);
      paramApolloRender.mEditWindow.setHeight(i);
      i = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0).getInt("sp_key_apollo_keyboard_height", 0);
      if (i > 0)
      {
        paramView.getRootView().postDelayed(new ApolloRender.19(paramApolloRender, paramView, i), 1000L);
        return;
      }
    } while ((paramApolloRender == null) || (paramApolloRender.mEditWindow == null) || (paramView == null));
    int i = ((ApolloSurfaceView)paramView).getHeight();
    paramApolloRender.mEditWindow.showAtLocation(paramView.getRootView(), 0, 0, i - paramApolloRender.mEditWindow.getHeight());
    paramApolloRender.mEditWindow.update(0, i - paramApolloRender.mEditWindow.getHeight(), paramApolloRender.mEditWindow.getWidth(), paramApolloRender.mEditWindow.getHeight());
  }
  
  private void setupDirector()
  {
    if ((!ApolloEngine.a()) || (this.mLock == null) || (this.mSavaWrapper == null)) {}
    do
    {
      return;
      try
      {
        if (!this.mPreLoadFlag) {
          break label204;
        }
        if (!this.mDestroyed) {
          break;
        }
        QLog.i("sava_ApolloRender", 1, "setupDirector mDestroyed, return");
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError) {}
    } while (!QLog.isColorLevel());
    QLog.d("sava_ApolloRender", 2, localOutOfMemoryError.getMessage());
    return;
    ajas.a("setupDirector_mPreLoadFlag");
    synchronized (this.LOCK_CREATE_DIRECTOR)
    {
      if (this.mDestroyed)
      {
        QLog.i("sava_ApolloRender", 1, "setupDirector inner mDestroyed, return");
        return;
      }
    }
    QLog.i("sava_ApolloRender", 1, "TraceReport CmShowStatUtil setupDirector mHadInitDirector:" + this.mSavaWrapper.b());
    if (!this.mSavaWrapper.b()) {
      this.mSavaWrapper.a(0L, 0, 0, this.mScale, 0);
    }
    for (;;)
    {
      QLog.i("sava_ApolloRender", 1, "TraceReport CmShowStatUtil setupDirector createGLContext:");
      this.mSavaWrapper.a(this.mScale);
      ajas.b("setupDirector_mPreLoadFlag");
      return;
      this.mSavaWrapper.a(0L, 0, 0, this.mScale);
    }
    label204:
    this.mSavaWrapper.a(0L, 0, 0, this.mScale, 0);
    exeEngineJs(isGameMode());
    this.mSavaWrapper.a(this.mScale);
  }
  
  public static void showDialog() {}
  
  @TargetApi(17)
  public static void showKeyBorad(long paramLong)
  {
    ApolloRender localApolloRender = getRenderByThreadId();
    localApolloRender.mEditorAddr = paramLong;
    View localView = getRenderViewByThreadId();
    if (localView == null) {
      return;
    }
    sIsKeyBoardDissmiss = false;
    sIsKeyBoardShow = false;
    if (localApolloRender.mEditWindow == null) {
      localView.getViewTreeObserver().addOnGlobalLayoutListener(new aigl(localApolloRender, localView));
    }
    ThreadManager.getUIHandler().post(new ApolloRender.21(localApolloRender, localView));
    ThreadManager.getUIHandler().postDelayed(new ApolloRender.22(), 500L);
  }
  
  public static void showLoading() {}
  
  public static void showToast(String paramString, long paramLong)
  {
    try
    {
      BaseActivity localBaseActivity;
      if ((BaseActivity.sTopActivity != null) && (!BaseActivity.sTopActivity.isFinishing()) && (paramString != null) && (paramString.length() < 1024))
      {
        localBaseActivity = BaseActivity.sTopActivity;
        if (paramLong < 1L) {
          break label54;
        }
      }
      label54:
      for (int i = 1;; i = 0)
      {
        bbmy.a(localBaseActivity, paramString, i).a();
        return;
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("sava_ApolloRender", 1, paramString, new Object[0]);
    }
  }
  
  private boolean snapShot(GL10 paramGL10)
  {
    if ((this.mSnapShot) && (this.mSnapShotCallback != null) && (this.mWidth > 0) && (this.mHeight > 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("sava_ApolloRender", 2, "snapShot Request:");
      }
    }
    try
    {
      int[] arrayOfInt = new int[this.mWidth * this.mHeight];
      IntBuffer localIntBuffer = IntBuffer.wrap(arrayOfInt);
      localIntBuffer.position(0);
      paramGL10.glReadPixels(0, 0, this.mWidth, this.mHeight, 6408, 5121, localIntBuffer);
      this.mSnapShotCallback.a(arrayOfInt, this.mWidth, this.mHeight, this.mCallBackCode, this.mSnapShotSeq);
      return true;
    }
    catch (Exception paramGL10)
    {
      if (QLog.isColorLevel()) {
        QLog.d("sava_ApolloRender", 2, paramGL10.getMessage());
      }
      return false;
    }
    catch (OutOfMemoryError paramGL10)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("sava_ApolloRender", 2, paramGL10.getMessage());
        }
        this.mSnapShot = false;
        this.mSnapShotCallback = null;
      }
    }
    finally
    {
      this.mSnapShot = false;
      this.mSnapShotCallback = null;
    }
  }
  
  public static void startGyroSensor(int paramInt1, long paramLong, int paramInt2)
  {
    if (mGyroSensorEventListener == null)
    {
      Object localObject = aing.a(paramInt1);
      if (localObject == null)
      {
        aing.a().callbackFromRequest(paramLong, 3, "cs.xy_device_gyro_sensor_start.local", "{}");
        return;
      }
      localObject = ((aipj)localObject).a();
      if (localObject == null)
      {
        aing.a().callbackFromRequest(paramLong, 3, "cs.xy_device_gyro_sensor_start.local", "{}");
        return;
      }
      localObject = ((Activity)localObject).getBaseContext();
      if (localObject == null)
      {
        aing.a().callbackFromRequest(paramLong, 3, "cs.xy_device_gyro_sensor_start.local", "{}");
        QLog.e("sava_ApolloRender", 1, "context is null");
        return;
      }
      mGyroSensorEventListener = new aiqq((Context)localObject, paramLong, paramInt2);
    }
    for (;;)
    {
      mGyroSensorEventListener.a();
      return;
      mGyroSensorEventListener.a(paramLong);
    }
  }
  
  public static void stopGyroSensor()
  {
    if (mGyroSensorEventListener != null) {
      mGyroSensorEventListener.b();
    }
  }
  
  public static void tickerPause(long paramLong)
  {
    Object localObject = getRenderByThreadId();
    if (localObject != null) {
      if (((ApolloRender)localObject).mApolloTicker != null) {
        ((ApolloRender)localObject).mApolloTicker.pauseTicker(paramLong);
      }
    }
    do
    {
      do
      {
        return;
        localObject = (WeakReference)sTickerMap.get(Long.valueOf(Thread.currentThread().getId()));
      } while (localObject == null);
      localObject = (ApolloTicker)((WeakReference)localObject).get();
    } while (localObject == null);
    ((ApolloTicker)localObject).pauseTicker(paramLong);
  }
  
  public static void tickerResume(long paramLong)
  {
    Object localObject = getRenderByThreadId();
    if (localObject != null) {
      if (((ApolloRender)localObject).mApolloTicker != null) {
        ((ApolloRender)localObject).mApolloTicker.resumeTicker(paramLong);
      }
    }
    do
    {
      do
      {
        return;
        localObject = (WeakReference)sTickerMap.get(Long.valueOf(Thread.currentThread().getId()));
      } while (localObject == null);
      localObject = (ApolloTicker)((WeakReference)localObject).get();
    } while (localObject == null);
    ((ApolloTicker)localObject).resumeTicker(paramLong);
  }
  
  public static FaceStatus[] trackAndDetectFace(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    ApolloRender localApolloRender = getRenderByThreadId();
    if ((sIsDownLoadingSo) || (localApolloRender.mDetector == null)) {
      return null;
    }
    FaceStatus[] arrayOfFaceStatus = localApolloRender.mDetector.doTrack(paramArrayOfByte, paramInt1, paramInt2);
    ThreadManagerV2.executeOnSubThread(new ApolloRender.25(localApolloRender, paramArrayOfByte, paramInt1, paramInt2));
    return arrayOfFaceStatus;
  }
  
  /* Error */
  private static int unZip(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_1
    //   4: ifnull +13 -> 17
    //   7: aload_1
    //   8: ldc_w 1941
    //   11: invokevirtual 771	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +7 -> 21
    //   17: iconst_0
    //   18: istore_3
    //   19: iload_3
    //   20: ireturn
    //   21: new 1435	java/io/FileInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 1942	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   29: astore 7
    //   31: new 1944	com/tencent/commonsdk/zip/QZipInputStream
    //   34: dup
    //   35: new 1433	java/io/BufferedInputStream
    //   38: dup
    //   39: aload 7
    //   41: invokespecial 1441	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   44: invokespecial 1945	com/tencent/commonsdk/zip/QZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   47: astore 8
    //   49: aload 8
    //   51: invokevirtual 1949	com/tencent/commonsdk/zip/QZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   54: astore_0
    //   55: aload_0
    //   56: ifnull +309 -> 365
    //   59: ldc_w 1951
    //   62: new 175	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   69: ldc_w 1953
    //   72: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_0
    //   76: invokevirtual 1253	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 1957	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   85: pop
    //   86: aload_0
    //   87: invokevirtual 1958	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   90: astore_0
    //   91: new 175	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   98: aload_1
    //   99: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: getstatic 1429	java/io/File:separator	Ljava/lang/String;
    //   105: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload_0
    //   109: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: astore 5
    //   117: aload_0
    //   118: ifnull -69 -> 49
    //   121: aload_0
    //   122: ldc_w 1941
    //   125: invokevirtual 771	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   128: ifne -79 -> 49
    //   131: aload 5
    //   133: ldc_w 1941
    //   136: invokevirtual 771	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   139: ifne -90 -> 49
    //   142: new 1021	java/io/File
    //   145: dup
    //   146: new 175	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   153: aload_1
    //   154: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: getstatic 1429	java/io/File:separator	Ljava/lang/String;
    //   160: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload_0
    //   164: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokespecial 1028	java/io/File:<init>	(Ljava/lang/String;)V
    //   173: astore_0
    //   174: new 1021	java/io/File
    //   177: dup
    //   178: aload_0
    //   179: invokevirtual 1961	java/io/File:getParent	()Ljava/lang/String;
    //   182: invokespecial 1028	java/io/File:<init>	(Ljava/lang/String;)V
    //   185: astore 5
    //   187: aload 5
    //   189: invokevirtual 1031	java/io/File:exists	()Z
    //   192: ifne +9 -> 201
    //   195: aload 5
    //   197: invokevirtual 1034	java/io/File:mkdirs	()Z
    //   200: pop
    //   201: sipush 4096
    //   204: newarray byte
    //   206: astore 6
    //   208: new 1963	java/io/FileOutputStream
    //   211: dup
    //   212: aload_0
    //   213: invokespecial 1964	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   216: astore_0
    //   217: new 1966	java/io/BufferedOutputStream
    //   220: dup
    //   221: aload_0
    //   222: sipush 4096
    //   225: invokespecial 1969	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   228: astore 5
    //   230: aload 8
    //   232: aload 6
    //   234: iconst_0
    //   235: sipush 4096
    //   238: invokevirtual 1972	com/tencent/commonsdk/zip/QZipInputStream:read	([BII)I
    //   241: istore_2
    //   242: iload_2
    //   243: iconst_m1
    //   244: if_icmpeq +67 -> 311
    //   247: aload 5
    //   249: aload 6
    //   251: iconst_0
    //   252: iload_2
    //   253: invokevirtual 1973	java/io/BufferedOutputStream:write	([BII)V
    //   256: goto -26 -> 230
    //   259: astore_0
    //   260: invokestatic 302	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   263: ifeq +13 -> 276
    //   266: ldc 61
    //   268: iconst_2
    //   269: aload_0
    //   270: invokevirtual 523	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   273: invokestatic 321	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   276: iconst_1
    //   277: istore_2
    //   278: aload 7
    //   280: invokevirtual 1974	java/io/FileInputStream:close	()V
    //   283: aload 8
    //   285: invokevirtual 1975	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   288: iload_2
    //   289: ireturn
    //   290: astore_0
    //   291: iload_2
    //   292: istore_3
    //   293: invokestatic 302	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   296: ifeq -277 -> 19
    //   299: ldc 61
    //   301: iconst_2
    //   302: aload_0
    //   303: invokevirtual 523	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   306: invokestatic 321	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   309: iload_2
    //   310: ireturn
    //   311: aload 5
    //   313: invokevirtual 1978	java/io/BufferedOutputStream:flush	()V
    //   316: aload 5
    //   318: invokevirtual 1979	java/io/BufferedOutputStream:close	()V
    //   321: aload_0
    //   322: invokevirtual 1980	java/io/FileOutputStream:close	()V
    //   325: goto -276 -> 49
    //   328: astore 5
    //   330: aconst_null
    //   331: astore 4
    //   333: aload_0
    //   334: astore_1
    //   335: aload 5
    //   337: astore_0
    //   338: aload_1
    //   339: ifnull +7 -> 346
    //   342: aload_1
    //   343: invokevirtual 1980	java/io/FileOutputStream:close	()V
    //   346: aload 4
    //   348: ifnull +8 -> 356
    //   351: aload 4
    //   353: invokevirtual 1979	java/io/BufferedOutputStream:close	()V
    //   356: aload_0
    //   357: invokevirtual 526	java/lang/Exception:printStackTrace	()V
    //   360: iconst_0
    //   361: istore_2
    //   362: goto -84 -> 278
    //   365: iconst_1
    //   366: istore_2
    //   367: goto -89 -> 278
    //   370: astore_0
    //   371: aload_0
    //   372: invokevirtual 526	java/lang/Exception:printStackTrace	()V
    //   375: iconst_0
    //   376: ireturn
    //   377: astore_0
    //   378: iconst_1
    //   379: istore_2
    //   380: goto -89 -> 291
    //   383: astore_0
    //   384: iconst_0
    //   385: istore_2
    //   386: goto -95 -> 291
    //   389: astore_0
    //   390: aconst_null
    //   391: astore 5
    //   393: aload 4
    //   395: astore_1
    //   396: aload 5
    //   398: astore 4
    //   400: goto -62 -> 338
    //   403: astore 6
    //   405: aload_0
    //   406: astore_1
    //   407: aload 5
    //   409: astore 4
    //   411: aload 6
    //   413: astore_0
    //   414: goto -76 -> 338
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	417	0	paramString1	String
    //   0	417	1	paramString2	String
    //   241	145	2	i	int
    //   18	275	3	j	int
    //   1	409	4	localObject1	Object
    //   115	202	5	localObject2	Object
    //   328	8	5	localException1	Exception
    //   391	17	5	localObject3	Object
    //   206	44	6	arrayOfByte	byte[]
    //   403	9	6	localException2	Exception
    //   29	250	7	localFileInputStream	java.io.FileInputStream
    //   47	237	8	localQZipInputStream	com.tencent.commonsdk.zip.QZipInputStream
    // Exception table:
    //   from	to	target	type
    //   49	55	259	java/lang/OutOfMemoryError
    //   59	117	259	java/lang/OutOfMemoryError
    //   121	201	259	java/lang/OutOfMemoryError
    //   201	217	259	java/lang/OutOfMemoryError
    //   217	230	259	java/lang/OutOfMemoryError
    //   230	242	259	java/lang/OutOfMemoryError
    //   247	256	259	java/lang/OutOfMemoryError
    //   311	321	259	java/lang/OutOfMemoryError
    //   321	325	259	java/lang/OutOfMemoryError
    //   278	288	290	java/lang/OutOfMemoryError
    //   217	230	328	java/lang/Exception
    //   321	325	328	java/lang/Exception
    //   21	49	370	java/lang/Exception
    //   260	276	370	java/lang/Exception
    //   278	288	370	java/lang/Exception
    //   342	346	370	java/lang/Exception
    //   351	356	370	java/lang/Exception
    //   356	360	370	java/lang/Exception
    //   21	49	377	java/lang/OutOfMemoryError
    //   260	276	377	java/lang/OutOfMemoryError
    //   342	346	377	java/lang/OutOfMemoryError
    //   351	356	377	java/lang/OutOfMemoryError
    //   356	360	383	java/lang/OutOfMemoryError
    //   49	55	389	java/lang/Exception
    //   59	117	389	java/lang/Exception
    //   121	201	389	java/lang/Exception
    //   201	217	389	java/lang/Exception
    //   230	242	403	java/lang/Exception
    //   247	256	403	java/lang/Exception
    //   311	321	403	java/lang/Exception
  }
  
  public static void vibrate(int paramInt1, long paramLong, long[] paramArrayOfLong, int paramInt2)
  {
    Object localObject = aing.a(paramInt1);
    if (localObject == null) {
      return;
    }
    localObject = ((aipj)localObject).a();
    if (localObject == null)
    {
      aing.a().callbackFromRequest(paramLong, 1, "cs.xy_device_vibrate.local", "{}");
      return;
    }
    localObject = (Vibrator)((Activity)localObject).getSystemService("vibrator");
    if (localObject == null)
    {
      QLog.e("sava_ApolloRender", 1, "Vibrator service is null");
      aing.a().callbackFromRequest(paramLong, 2, "cs.xy_device_vibrate.local", "{}");
      return;
    }
    if (!((Vibrator)localObject).hasVibrator())
    {
      aing.a().callbackFromRequest(paramLong, 3, "cs.xy_device_vibrate.local", "{}");
      QLog.e("sava_ApolloRender", 1, "Vibrator is not support");
      return;
    }
    if (paramArrayOfLong.length > 1)
    {
      vibrateFlag = 1;
      ((Vibrator)localObject).vibrate(paramArrayOfLong, paramInt2);
    }
    for (;;)
    {
      aing.a().callbackFromRequest(paramLong, 0, "cs.xy_device_vibrate.local", "{}");
      return;
      if (paramArrayOfLong.length == 1)
      {
        vibrateFlag = 1;
        ((Vibrator)localObject).vibrate(paramArrayOfLong[0]);
      }
      else
      {
        QLog.e("sava_ApolloRender", 1, "Vibrator effect error!");
      }
    }
  }
  
  protected static int websocketClose(long paramLong)
  {
    ApolloRender localApolloRender = getRenderByThreadId();
    SSLSocket localSSLSocket = (SSLSocket)mSSLSocketMap.get(Long.valueOf(paramLong));
    if (localSSLSocket == null) {}
    for (;;)
    {
      return 0;
      BufferedInputStream localBufferedInputStream = (BufferedInputStream)mBufferinputMap.get(Long.valueOf(paramLong));
      BufferedOutputStream localBufferedOutputStream = (BufferedOutputStream)mBufferoutputMap.get(Long.valueOf(paramLong));
      if (localSSLSocket.isClosed())
      {
        mSSLSocketMap.remove(Long.valueOf(paramLong));
        mBufferinputMap.remove(Long.valueOf(paramLong));
        mBufferoutputMap.remove(Long.valueOf(paramLong));
        return 0;
      }
      try
      {
        localBufferedInputStream.close();
        localBufferedOutputStream.close();
        localSSLSocket.close();
        mSSLSocketMap.remove(Long.valueOf(paramLong));
        mBufferinputMap.remove(Long.valueOf(paramLong));
        mBufferoutputMap.remove(Long.valueOf(paramLong));
        i = 0;
        if (i < localApolloRender.mNioList.size()) {
          if (((aijw)localApolloRender.mNioList.get(i)).jdField_a_of_type_Long == paramLong)
          {
            localApolloRender.mNioList.remove(i);
            return 0;
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        int i;
        while (QLog.isColorLevel())
        {
          QLog.d("sava_ApolloRender", 2, localOutOfMemoryError.getMessage());
          return 0;
          i += 1;
        }
      }
      catch (Exception localException)
      {
        QLog.e("sava_ApolloRender", 2, "websocket ssl close Error:" + localException.getMessage());
      }
    }
    return 0;
  }
  
  public static int websocketConnect(long paramLong, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    ApolloRender localApolloRender = getRenderByThreadId();
    Object localObject = (SSLSocket)mSSLSocketMap.get(Long.valueOf(paramLong));
    if (getRenderViewByThreadId() == null)
    {
      Log.d("sava_ApolloRender", "websocketConnect: view is null");
      return -1;
    }
    if (localObject == null)
    {
      localObject = new InetSocketAddress(paramString1, paramInt1);
      SocketChannel localSocketChannel = SocketChannel.open();
      localSocketChannel.configureBlocking(false);
      localSocketChannel.connect((SocketAddress)localObject);
      paramString1 = new aijw(paramLong, paramString1, paramInt1, paramInt2, paramString2, paramString3, localSocketChannel);
      localApolloRender.mNioList.add(paramString1);
      return 0;
    }
    QLog.d("sava_ApolloRender", 2, "do not handshake agagin");
    return 0;
  }
  
  @TargetApi(14)
  protected static byte[] websocketRecv(long paramLong, int paramInt)
  {
    if ((SSLSocket)mSSLSocketMap.get(Long.valueOf(paramLong)) == null) {
      return null;
    }
    Object localObject = (BufferedInputStream)mBufferinputMap.get(Long.valueOf(paramLong));
    if ((localObject != null) && (paramInt > 0)) {}
    try
    {
      byte[] arrayOfByte = new byte[paramInt];
      paramInt = ((BufferedInputStream)localObject).read(arrayOfByte, 0, paramInt);
      if (paramInt > 0)
      {
        localObject = Arrays.copyOf(arrayOfByte, paramInt);
        return localObject;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.d("sava_ApolloRender", 2, localOutOfMemoryError.getMessage());
      }
      return null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("sava_ApolloRender", 2, "websocket ssl recv Error:" + localException.getMessage());
      }
    }
  }
  
  protected static int websocketSend(long paramLong, byte[] paramArrayOfByte)
  {
    getRenderByThreadId();
    new String(paramArrayOfByte);
    if ((SSLSocket)mSSLSocketMap.get(Long.valueOf(paramLong)) == null) {
      return 0;
    }
    BufferedOutputStream localBufferedOutputStream = (BufferedOutputStream)mBufferoutputMap.get(Long.valueOf(paramLong));
    BufferedInputStream localBufferedInputStream = (BufferedInputStream)mBufferinputMap.get(Long.valueOf(paramLong));
    if (localBufferedOutputStream != null) {}
    try
    {
      localBufferedOutputStream.write(paramArrayOfByte);
      localBufferedOutputStream.flush();
      int i = paramArrayOfByte.length;
      return i;
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("sava_ApolloRender", 2, paramArrayOfByte.getMessage());
      }
      return 0;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        QLog.e("sava_ApolloRender", 2, "websocket ssl send Error:" + paramArrayOfByte.getMessage());
      }
    }
  }
  
  protected static int websocketShakeHand(long paramLong, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, Socket paramSocket)
  {
    getRenderByThreadId();
    View localView = getRenderViewByThreadId();
    if (localView == null)
    {
      Log.d("sava_ApolloRender", "websocketShakeHand: view is null");
      return 0;
    }
    if (paramInt2 > 0) {}
    try
    {
      ((ApolloSurfaceView)localView).getRender().getSavaWrapper().a(paramLong, 4);
      if ((paramString2 != null) && (!paramString2.equals(""))) {}
      for (paramString2 = SSLContext.getInstance(paramString2);; paramString2 = SSLContext.getInstance("SSL"))
      {
        paramString2.init(null, null, null);
        paramString1 = (SSLSocket)paramString2.getSocketFactory().createSocket(paramSocket, paramString1, paramInt1, true);
        if (paramString1.isConnected()) {
          break;
        }
        ((ApolloSurfaceView)localView).getRender().getSavaWrapper().a(paramLong, 6);
        QLog.e("sava_ApolloRender", 2, "ssl handshake failed: sslsocket is not connected");
        return 0;
      }
      paramString1.setUseClientMode(true);
      paramString1.setKeepAlive(true);
      if ((paramString3 != null) && (!paramString3.equals(""))) {
        paramString1.setEnabledProtocols(new String[] { paramString3 });
      }
      paramString1.addHandshakeCompletedListener(new aigi(localView, paramLong));
      paramString1.startHandshake();
      paramInt1 = getfd(paramSocket);
      ((ApolloSurfaceView)localView).getRender().getSavaWrapper().b(paramLong, paramInt1);
      mSSLSocketMap.put(Long.valueOf(paramLong), paramString1);
      paramString2 = new BufferedInputStream(paramString1.getInputStream());
      mBufferinputMap.put(Long.valueOf(paramLong), paramString2);
      paramString1 = new BufferedOutputStream(paramString1.getOutputStream());
      mBufferoutputMap.put(Long.valueOf(paramLong), paramString1);
    }
    catch (OutOfMemoryError paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("sava_ApolloRender", 2, paramString1.getMessage());
        }
      }
    }
    catch (Exception paramString1)
    {
      ((ApolloSurfaceView)localView).getRender().getSavaWrapper().a(paramLong, 6);
      QLog.e("sava_ApolloRender", 2, "handshake Error:" + paramString1.getMessage());
    }
    return 0;
    return 0;
  }
  
  /* Error */
  public static void writeTexToDist(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_0
    //   4: arraylength
    //   5: newarray byte
    //   7: astore 6
    //   9: iconst_0
    //   10: istore 4
    //   12: iload 4
    //   14: aload_0
    //   15: arraylength
    //   16: if_icmpge +21 -> 37
    //   19: aload 6
    //   21: iload 4
    //   23: aload_0
    //   24: iload 4
    //   26: baload
    //   27: bastore
    //   28: iload 4
    //   30: iconst_1
    //   31: iadd
    //   32: istore 4
    //   34: goto -22 -> 12
    //   37: iload_1
    //   38: iload_2
    //   39: getstatic 487	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   42: invokestatic 508	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   45: astore 7
    //   47: aload 7
    //   49: aload 6
    //   51: invokestatic 2132	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   54: invokevirtual 2135	android/graphics/Bitmap:copyPixelsFromBuffer	(Ljava/nio/Buffer;)V
    //   57: invokestatic 327	com/tencent/mobileqq/apollo/ApolloRender:getRenderByThreadId	()Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   60: astore_0
    //   61: aload_0
    //   62: ifnull +10 -> 72
    //   65: aload_0
    //   66: invokevirtual 1311	com/tencent/mobileqq/apollo/ApolloRender:getSavaWrapper	()Lcom/tencent/mobileqq/apollo/ApolloEngine;
    //   69: ifnonnull +4 -> 73
    //   72: return
    //   73: aload_0
    //   74: invokevirtual 1311	com/tencent/mobileqq/apollo/ApolloRender:getSavaWrapper	()Lcom/tencent/mobileqq/apollo/ApolloEngine;
    //   77: invokevirtual 1455	com/tencent/mobileqq/apollo/ApolloEngine:a	()J
    //   80: invokestatic 1458	aing:a	(J)I
    //   83: aload_3
    //   84: invokestatic 2137	com/tencent/mobileqq/apollo/ApolloRender:getSandBoxPath	(ILjava/lang/String;)Ljava/lang/String;
    //   87: astore_0
    //   88: aload_0
    //   89: ifnull -17 -> 72
    //   92: new 1021	java/io/File
    //   95: dup
    //   96: aload_0
    //   97: invokespecial 1028	java/io/File:<init>	(Ljava/lang/String;)V
    //   100: astore_0
    //   101: aload_0
    //   102: invokevirtual 1031	java/io/File:exists	()Z
    //   105: ifeq +8 -> 113
    //   108: aload_0
    //   109: invokevirtual 2140	java/io/File:delete	()Z
    //   112: pop
    //   113: new 1963	java/io/FileOutputStream
    //   116: dup
    //   117: aload_0
    //   118: invokespecial 1964	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   121: astore_0
    //   122: aload_0
    //   123: astore 6
    //   125: aload_3
    //   126: ldc_w 1003
    //   129: invokevirtual 786	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   132: ifne +362 -> 494
    //   135: aload_0
    //   136: astore 6
    //   138: aload_3
    //   139: ldc_w 2142
    //   142: invokevirtual 786	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   145: ifne +349 -> 494
    //   148: aload_0
    //   149: astore 6
    //   151: aload_3
    //   152: ldc_w 2144
    //   155: invokevirtual 786	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   158: ifne +336 -> 494
    //   161: aload_0
    //   162: astore 6
    //   164: aload_3
    //   165: ldc_w 2146
    //   168: invokevirtual 786	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   171: ifeq +6 -> 177
    //   174: goto +320 -> 494
    //   177: aload_0
    //   178: astore 6
    //   180: iload 5
    //   182: invokestatic 2151	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   185: invokevirtual 2154	java/lang/Boolean:booleanValue	()Z
    //   188: ifeq +62 -> 250
    //   191: aload_0
    //   192: astore 6
    //   194: aload 7
    //   196: getstatic 2160	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   199: bipush 50
    //   201: aload_0
    //   202: invokevirtual 2164	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   205: ifeq +18 -> 223
    //   208: aload_0
    //   209: astore 6
    //   211: aload_0
    //   212: invokevirtual 2165	java/io/FileOutputStream:flush	()V
    //   215: aload_0
    //   216: astore 6
    //   218: aload 7
    //   220: invokevirtual 2168	android/graphics/Bitmap:recycle	()V
    //   223: aload_0
    //   224: ifnull -152 -> 72
    //   227: aload_0
    //   228: invokevirtual 1980	java/io/FileOutputStream:close	()V
    //   231: return
    //   232: astore_0
    //   233: invokestatic 302	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   236: ifeq -164 -> 72
    //   239: ldc 61
    //   241: iconst_2
    //   242: aload_0
    //   243: invokevirtual 523	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   246: invokestatic 321	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   249: return
    //   250: aload_0
    //   251: astore 6
    //   253: aload 7
    //   255: getstatic 2171	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   258: bipush 100
    //   260: aload_0
    //   261: invokevirtual 2164	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   264: ifeq -41 -> 223
    //   267: aload_0
    //   268: astore 6
    //   270: aload_0
    //   271: invokevirtual 2165	java/io/FileOutputStream:flush	()V
    //   274: aload_0
    //   275: astore 6
    //   277: aload 7
    //   279: invokevirtual 2168	android/graphics/Bitmap:recycle	()V
    //   282: goto -59 -> 223
    //   285: astore_3
    //   286: aload_3
    //   287: invokevirtual 2172	java/io/FileNotFoundException:printStackTrace	()V
    //   290: aload_0
    //   291: ifnull -219 -> 72
    //   294: aload_0
    //   295: invokevirtual 1980	java/io/FileOutputStream:close	()V
    //   298: return
    //   299: astore_0
    //   300: invokestatic 302	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   303: ifeq -231 -> 72
    //   306: ldc 61
    //   308: iconst_2
    //   309: aload_0
    //   310: invokevirtual 523	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   313: invokestatic 321	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   316: return
    //   317: astore_0
    //   318: aload_0
    //   319: invokevirtual 2173	java/io/IOException:printStackTrace	()V
    //   322: return
    //   323: astore_0
    //   324: aload_0
    //   325: invokevirtual 2173	java/io/IOException:printStackTrace	()V
    //   328: return
    //   329: astore_0
    //   330: aconst_null
    //   331: astore_0
    //   332: aload_0
    //   333: ifnull -261 -> 72
    //   336: aload_0
    //   337: invokevirtual 1980	java/io/FileOutputStream:close	()V
    //   340: return
    //   341: astore_0
    //   342: invokestatic 302	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   345: ifeq -273 -> 72
    //   348: ldc 61
    //   350: iconst_2
    //   351: aload_0
    //   352: invokevirtual 523	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   355: invokestatic 321	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   358: return
    //   359: astore_0
    //   360: aload_0
    //   361: invokevirtual 2173	java/io/IOException:printStackTrace	()V
    //   364: return
    //   365: astore_3
    //   366: aconst_null
    //   367: astore_0
    //   368: aload_0
    //   369: astore 6
    //   371: invokestatic 302	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   374: ifeq +16 -> 390
    //   377: aload_0
    //   378: astore 6
    //   380: ldc 61
    //   382: iconst_2
    //   383: aload_3
    //   384: invokevirtual 523	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   387: invokestatic 321	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   390: aload_0
    //   391: ifnull -319 -> 72
    //   394: aload_0
    //   395: invokevirtual 1980	java/io/FileOutputStream:close	()V
    //   398: return
    //   399: astore_0
    //   400: invokestatic 302	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   403: ifeq -331 -> 72
    //   406: ldc 61
    //   408: iconst_2
    //   409: aload_0
    //   410: invokevirtual 523	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   413: invokestatic 321	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   416: return
    //   417: astore_0
    //   418: aload_0
    //   419: invokevirtual 2173	java/io/IOException:printStackTrace	()V
    //   422: return
    //   423: astore_0
    //   424: aconst_null
    //   425: astore 6
    //   427: aload 6
    //   429: ifnull +8 -> 437
    //   432: aload 6
    //   434: invokevirtual 1980	java/io/FileOutputStream:close	()V
    //   437: aload_0
    //   438: athrow
    //   439: astore_3
    //   440: invokestatic 302	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   443: ifeq -6 -> 437
    //   446: ldc 61
    //   448: iconst_2
    //   449: aload_3
    //   450: invokevirtual 523	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   453: invokestatic 321	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   456: goto -19 -> 437
    //   459: astore_3
    //   460: aload_3
    //   461: invokevirtual 2173	java/io/IOException:printStackTrace	()V
    //   464: goto -27 -> 437
    //   467: astore_0
    //   468: goto -41 -> 427
    //   471: astore_3
    //   472: aload_0
    //   473: astore 6
    //   475: aload_3
    //   476: astore_0
    //   477: goto -50 -> 427
    //   480: astore_3
    //   481: goto -113 -> 368
    //   484: astore_3
    //   485: goto -153 -> 332
    //   488: astore_3
    //   489: aconst_null
    //   490: astore_0
    //   491: goto -205 -> 286
    //   494: iconst_1
    //   495: istore 5
    //   497: goto -320 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	500	0	paramArrayOfByte	byte[]
    //   0	500	1	paramInt1	int
    //   0	500	2	paramInt2	int
    //   0	500	3	paramString	String
    //   10	23	4	i	int
    //   1	495	5	bool	boolean
    //   7	467	6	arrayOfByte	byte[]
    //   45	233	7	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   227	231	232	java/lang/OutOfMemoryError
    //   125	135	285	java/io/FileNotFoundException
    //   138	148	285	java/io/FileNotFoundException
    //   151	161	285	java/io/FileNotFoundException
    //   164	174	285	java/io/FileNotFoundException
    //   180	191	285	java/io/FileNotFoundException
    //   194	208	285	java/io/FileNotFoundException
    //   211	215	285	java/io/FileNotFoundException
    //   218	223	285	java/io/FileNotFoundException
    //   253	267	285	java/io/FileNotFoundException
    //   270	274	285	java/io/FileNotFoundException
    //   277	282	285	java/io/FileNotFoundException
    //   294	298	299	java/lang/OutOfMemoryError
    //   227	231	317	java/io/IOException
    //   294	298	323	java/io/IOException
    //   113	122	329	java/io/IOException
    //   336	340	341	java/lang/OutOfMemoryError
    //   336	340	359	java/io/IOException
    //   113	122	365	java/lang/OutOfMemoryError
    //   394	398	399	java/lang/OutOfMemoryError
    //   394	398	417	java/io/IOException
    //   113	122	423	finally
    //   432	437	439	java/lang/OutOfMemoryError
    //   432	437	459	java/io/IOException
    //   125	135	467	finally
    //   138	148	467	finally
    //   151	161	467	finally
    //   164	174	467	finally
    //   180	191	467	finally
    //   194	208	467	finally
    //   211	215	467	finally
    //   218	223	467	finally
    //   253	267	467	finally
    //   270	274	467	finally
    //   277	282	467	finally
    //   371	377	467	finally
    //   380	390	467	finally
    //   286	290	471	finally
    //   125	135	480	java/lang/OutOfMemoryError
    //   138	148	480	java/lang/OutOfMemoryError
    //   151	161	480	java/lang/OutOfMemoryError
    //   164	174	480	java/lang/OutOfMemoryError
    //   180	191	480	java/lang/OutOfMemoryError
    //   194	208	480	java/lang/OutOfMemoryError
    //   211	215	480	java/lang/OutOfMemoryError
    //   218	223	480	java/lang/OutOfMemoryError
    //   253	267	480	java/lang/OutOfMemoryError
    //   270	274	480	java/lang/OutOfMemoryError
    //   277	282	480	java/lang/OutOfMemoryError
    //   125	135	484	java/io/IOException
    //   138	148	484	java/io/IOException
    //   151	161	484	java/io/IOException
    //   164	174	484	java/io/IOException
    //   180	191	484	java/io/IOException
    //   194	208	484	java/io/IOException
    //   211	215	484	java/io/IOException
    //   218	223	484	java/io/IOException
    //   253	267	484	java/io/IOException
    //   270	274	484	java/io/IOException
    //   277	282	484	java/io/IOException
    //   113	122	488	java/io/FileNotFoundException
  }
  
  /* Error */
  public static int zip(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: iconst_1
    //   4: istore_3
    //   5: new 1446	java/util/zip/ZipOutputStream
    //   8: dup
    //   9: new 1963	java/io/FileOutputStream
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 2175	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   17: invokespecial 2176	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   20: astore 6
    //   22: aload 6
    //   24: astore_1
    //   25: new 1021	java/io/File
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 1028	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: astore_0
    //   34: aload_0
    //   35: ifnull +101 -> 136
    //   38: aload 6
    //   40: astore_1
    //   41: aload_0
    //   42: invokevirtual 1031	java/io/File:exists	()Z
    //   45: ifeq +91 -> 136
    //   48: aload 6
    //   50: astore_1
    //   51: aload_0
    //   52: invokevirtual 1421	java/io/File:isDirectory	()Z
    //   55: ifeq +69 -> 124
    //   58: aload 6
    //   60: astore_1
    //   61: aload_0
    //   62: invokevirtual 1426	java/io/File:listFiles	()[Ljava/io/File;
    //   65: astore_0
    //   66: aload 6
    //   68: astore_1
    //   69: aload_0
    //   70: arraylength
    //   71: istore 5
    //   73: iconst_0
    //   74: istore_2
    //   75: goto +147 -> 222
    //   78: aload 6
    //   80: astore_1
    //   81: aload 6
    //   83: aload 7
    //   85: ldc_w 963
    //   88: invokestatic 1431	com/tencent/mobileqq/apollo/ApolloRender:recursionZip	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;)V
    //   91: goto +147 -> 238
    //   94: astore_0
    //   95: aload 6
    //   97: astore_1
    //   98: invokestatic 302	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   101: ifeq +16 -> 117
    //   104: aload 6
    //   106: astore_1
    //   107: ldc 61
    //   109: iconst_2
    //   110: aload_0
    //   111: invokevirtual 523	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   114: invokestatic 321	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   117: aload 6
    //   119: invokevirtual 2177	java/util/zip/ZipOutputStream:close	()V
    //   122: iload_3
    //   123: ireturn
    //   124: aload 6
    //   126: astore_1
    //   127: aload 6
    //   129: aload_0
    //   130: ldc_w 963
    //   133: invokestatic 1431	com/tencent/mobileqq/apollo/ApolloRender:recursionZip	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;)V
    //   136: aload 6
    //   138: invokevirtual 2177	java/util/zip/ZipOutputStream:close	()V
    //   141: iconst_1
    //   142: ireturn
    //   143: astore_0
    //   144: iload 4
    //   146: istore_2
    //   147: iload_2
    //   148: istore_3
    //   149: invokestatic 302	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   152: ifeq -30 -> 122
    //   155: ldc 61
    //   157: iconst_2
    //   158: aload_0
    //   159: invokevirtual 523	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   162: invokestatic 321	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: iload_2
    //   166: ireturn
    //   167: astore_0
    //   168: aconst_null
    //   169: astore 6
    //   171: aload 6
    //   173: astore_1
    //   174: aload_0
    //   175: invokevirtual 526	java/lang/Exception:printStackTrace	()V
    //   178: aload 6
    //   180: invokevirtual 2177	java/util/zip/ZipOutputStream:close	()V
    //   183: iconst_0
    //   184: ireturn
    //   185: astore_0
    //   186: aconst_null
    //   187: astore_1
    //   188: aload_1
    //   189: invokevirtual 2177	java/util/zip/ZipOutputStream:close	()V
    //   192: aload_0
    //   193: athrow
    //   194: astore_0
    //   195: aload_0
    //   196: invokevirtual 526	java/lang/Exception:printStackTrace	()V
    //   199: iconst_0
    //   200: ireturn
    //   201: astore_0
    //   202: iconst_0
    //   203: istore_2
    //   204: goto -57 -> 147
    //   207: astore_0
    //   208: goto -20 -> 188
    //   211: astore_0
    //   212: goto -41 -> 171
    //   215: astore_0
    //   216: aconst_null
    //   217: astore 6
    //   219: goto -124 -> 95
    //   222: iload_2
    //   223: iload 5
    //   225: if_icmpge -89 -> 136
    //   228: aload_0
    //   229: iload_2
    //   230: aaload
    //   231: astore 7
    //   233: aload 7
    //   235: ifnonnull -157 -> 78
    //   238: iload_2
    //   239: iconst_1
    //   240: iadd
    //   241: istore_2
    //   242: goto -20 -> 222
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	paramString1	String
    //   0	245	1	paramString2	String
    //   74	168	2	i	int
    //   4	145	3	j	int
    //   1	144	4	k	int
    //   71	155	5	m	int
    //   20	198	6	localZipOutputStream	java.util.zip.ZipOutputStream
    //   83	151	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   25	34	94	java/lang/OutOfMemoryError
    //   41	48	94	java/lang/OutOfMemoryError
    //   51	58	94	java/lang/OutOfMemoryError
    //   61	66	94	java/lang/OutOfMemoryError
    //   69	73	94	java/lang/OutOfMemoryError
    //   81	91	94	java/lang/OutOfMemoryError
    //   127	136	94	java/lang/OutOfMemoryError
    //   117	122	143	java/lang/OutOfMemoryError
    //   136	141	143	java/lang/OutOfMemoryError
    //   188	194	143	java/lang/OutOfMemoryError
    //   5	22	167	java/lang/Exception
    //   5	22	185	finally
    //   117	122	194	java/lang/Exception
    //   136	141	194	java/lang/Exception
    //   178	183	194	java/lang/Exception
    //   188	194	194	java/lang/Exception
    //   178	183	201	java/lang/OutOfMemoryError
    //   25	34	207	finally
    //   41	48	207	finally
    //   51	58	207	finally
    //   61	66	207	finally
    //   69	73	207	finally
    //   81	91	207	finally
    //   98	104	207	finally
    //   107	117	207	finally
    //   127	136	207	finally
    //   174	178	207	finally
    //   25	34	211	java/lang/Exception
    //   41	48	211	java/lang/Exception
    //   51	58	211	java/lang/Exception
    //   61	66	211	java/lang/Exception
    //   69	73	211	java/lang/Exception
    //   81	91	211	java/lang/Exception
    //   127	136	211	java/lang/Exception
    //   5	22	215	java/lang/OutOfMemoryError
  }
  
  public native void bkDirectorChangeScreenMode(int paramInt);
  
  public void callbackFromJni(int paramInt1, int paramInt2, String paramString)
  {
    aiij localaiij;
    if (paramInt1 == 0) {
      if (this.mRenderCallbackRef != null)
      {
        localaiij = (aiij)this.mRenderCallbackRef.get();
        if (localaiij != null) {
          localaiij.a(paramInt2, paramString);
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (2 != paramInt1) {
            break;
          }
        } while (this.mRenderCallbackRef == null);
        localaiij = (aiij)this.mRenderCallbackRef.get();
      } while (localaiij == null);
      localaiij.a(paramInt2, 0, paramString);
      return;
    } while (1 != paramInt1);
  }
  
  public void doOnDrawFrame()
  {
    if ((this.mSavaWrapper != null) && (this.mLock != null) && (this.mSavaWrapper.jdField_a_of_type_Long != -1L))
    {
      if (!this.mIsFrameMode)
      {
        long l = System.currentTimeMillis();
        double d2 = Math.min(l - this.lastFrame, 50L) / 1000.0D;
        double d1 = d2;
        if (this.mSnapShot)
        {
          d1 = d2;
          if (this.mSnapShotCallback != null)
          {
            d1 = d2;
            if (this.mWidth > 0)
            {
              d1 = d2;
              if (this.mHeight > 0) {
                d1 = 0.0D;
              }
            }
          }
        }
        this.mDuration = d1;
        this.lastFrame = l;
      }
      this.mLock.lock();
    }
    try
    {
      this.mSavaWrapper.a(this.mDuration, this.mType);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.d("sava_ApolloRender", 2, localOutOfMemoryError.getMessage());
      }
      return;
    }
    finally
    {
      this.mLock.unlock();
    }
  }
  
  public String getQtaTestResult()
  {
    return qtaTestResult;
  }
  
  public String getRscPath(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(96);
    String str;
    if (paramString1.startsWith("BaseJs:"))
    {
      str = paramString1.substring("BaseJs:".length() + "//".length());
      localStringBuilder.append(aiys.av);
      paramString1 = new StringBuilder(200);
      paramString1.append(str);
      if (!"json".equals(paramString2)) {
        break label943;
      }
      paramString1.append(".json");
    }
    for (;;)
    {
      localStringBuilder.append(paramString1.toString());
      return localStringBuilder.toString();
      if ((paramString1.startsWith("ActionRes:")) || (paramString1.startsWith("Action:")))
      {
        if (paramString1.startsWith("ActionRes:")) {}
        for (int i = "ActionRes:".length();; i = "Action:".length())
        {
          str = paramString1.substring(i + "//".length());
          localStringBuilder.append(aiys.jdField_a_of_type_JavaLangString);
          if (!str.startsWith("role/")) {
            break label211;
          }
          str = str.substring("role/".length());
          localStringBuilder.append("/role/");
          break;
        }
        label211:
        if (str.startsWith("drawer_action/"))
        {
          str = str.substring("drawer_action/".length());
          localStringBuilder.append("/drawer_action/");
          break;
        }
        localStringBuilder.append("/action/");
        break;
      }
      if (paramString1.startsWith("Role:"))
      {
        str = paramString1.substring("Role:".length() + "//".length());
        localStringBuilder.append(aiys.jdField_a_of_type_JavaLangString);
        localStringBuilder.append("/role/");
        break;
      }
      if (paramString1.startsWith("Dress:"))
      {
        str = paramString1.substring("Dress:".length() + "//".length());
        localStringBuilder.append(aiys.jdField_a_of_type_JavaLangString);
        if (str.startsWith("role/"))
        {
          str = str.substring("role/".length());
          localStringBuilder.append("/role/");
          break;
        }
        localStringBuilder.append("/dress/");
        break;
      }
      if (paramString1.startsWith("Extension:"))
      {
        str = paramString1.substring("Extension:".length() + "//".length());
        localStringBuilder.append(aiys.jdField_a_of_type_JavaLangString);
        localStringBuilder.append("/extension/");
        break;
      }
      if (paramString1.startsWith("SlaveAction"))
      {
        str = paramString1.substring("SlaveAction".length() + "//".length());
        new File(aiys.jdField_a_of_type_JavaLangString, "slave");
        localStringBuilder.append(aiys.jdField_c_of_type_JavaLangString).append("/def/role/0/script/slave/");
        break;
      }
      if (paramString1.startsWith("GameRes:"))
      {
        str = paramString1.substring("GameRes:".length() + "//".length());
        localStringBuilder.append(aiys.jdField_a_of_type_JavaLangString);
        localStringBuilder.append("/game/");
        if (TextUtils.isEmpty(this.mGameName))
        {
          QLog.d("sava_ApolloRender", 2, "getRscPath, mGameName is empty, name:" + str);
          break;
        }
        localStringBuilder.append(this.mGameName);
        localStringBuilder.append("/");
        break;
      }
      if (paramString1.startsWith("GameSandBox:"))
      {
        paramString1 = paramString1.substring("GameSandBox:".length() + "//".length());
        paramString2 = new File(aiys.s + this.mGameId + "/sandbox");
        if (!paramString2.exists()) {
          paramString2.mkdirs();
        }
        return paramString2.getAbsolutePath() + "/" + paramString1;
      }
      if ((paramString1.contains("game")) || (paramString1.contains("def")))
      {
        localStringBuilder.append(aiys.jdField_c_of_type_JavaLangString);
        str = paramString1;
        if (localStringBuilder.toString().endsWith("/")) {
          break;
        }
        localStringBuilder.append("/");
        str = paramString1;
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e("sava_ApolloRender", 2, "getRscPath err name:" + paramString1 + ",type:" + paramString2);
      }
      if (paramString1.startsWith("role"))
      {
        str = paramString1.substring("role/".length());
        localStringBuilder.append(aiys.jdField_a_of_type_JavaLangString);
        localStringBuilder.append("/role/");
        break;
      }
      if (paramString1.startsWith("action"))
      {
        str = paramString1.substring("action/".length());
        localStringBuilder.append(aiys.jdField_a_of_type_JavaLangString);
        localStringBuilder.append("/action/");
        break;
      }
      str = paramString1;
      if (!paramString1.startsWith("dress")) {
        break;
      }
      str = paramString1.substring("dress/".length());
      localStringBuilder.append(aiys.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("/dress/");
      break;
      label943:
      if ("atlas".equals(paramString2)) {
        paramString1.append(".atlas");
      } else if ("lua".equals(paramString2)) {
        paramString1.append(".lua");
      } else if ("png".equals(paramString2)) {
        paramString1.append(".png");
      } else if ("jpg".equals(paramString2)) {
        paramString1.append(".jpg");
      } else if (".js".equals(paramString2)) {
        paramString1.append(".js");
      } else if ("shp".equals(paramString2)) {
        paramString1.append(".shp");
      } else if ("bin".equals(paramString2)) {
        paramString1.append(".bin");
      }
    }
  }
  
  public ApolloEngine getSavaWrapper()
  {
    return this.mSavaWrapper;
  }
  
  public boolean isDrawTaskRunning()
  {
    return this.mDrawTaskRunning;
  }
  
  public native void nativePreviewCallback(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString);
  
  public native void nativeRemotePreviewCallback(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString);
  
  public void onDestroy()
  {
    QLog.i("sava_ApolloRender", 1, "[onDestroy]");
    this.mPreLoadFlag = false;
    this.mDestroyed = true;
    if ((this.mLock == null) || (this.mSavaWrapper == null)) {
      return;
    }
    this.mLock.lock();
    try
    {
      if (this.mSavaWrapper != null) {
        this.mSavaWrapper.a();
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        long l;
        float f;
        HashMap localHashMap;
        Object localObject2;
        if (QLog.isColorLevel()) {
          QLog.d("sava_ApolloRender", 2, localOutOfMemoryError.getMessage());
        }
        this.mLock.unlock();
      }
    }
    finally
    {
      this.mLock.unlock();
    }
    this.mIsReadyNotify = false;
    l = Thread.currentThread().getId();
    if ((sRenderMap != null) && (sRenderMap.containsKey(Long.valueOf(l))))
    {
      sRenderMap.remove(Long.valueOf(l));
      if (QLog.isColorLevel()) {
        QLog.d("sava_ApolloRender", 2, "remove renderObj from map, id:" + l);
      }
    }
    if ((sTickerMap != null) && (sTickerMap.containsKey(Long.valueOf(l))))
    {
      sTickerMap.remove(Long.valueOf(l));
      if (QLog.isColorLevel()) {
        QLog.d("sava_ApolloRender", 2, "remove sTickerMap from map, id:" + l);
      }
    }
    if (this.mIsNeedReport)
    {
      f = this.mTotalDrawCost / this.mTotalFrameCount;
      if (QLog.isColorLevel()) {
        QLog.d("sava_ApolloRender", 2, new Object[] { ",mTotalCost:", Integer.valueOf(this.mTotalDrawCost), ",mTotalFrameCount:", Integer.valueOf(this.mTotalFrameCount), ",mLongCostCount:", Integer.valueOf(this.mLongCostCount), ",avgCost:", Float.valueOf(f) });
      }
      localHashMap = new HashMap();
      localHashMap.put("gameId", Integer.toString(this.mGameId));
      localHashMap.put("avgDrawCost", Float.toString(f));
      localHashMap.put("longCostCount", Integer.toString(this.mLongCostCount));
      localHashMap.put("totalFrameCount", Integer.toString(this.mTotalFrameCount));
      localObject2 = aing.a();
      if (localObject2 != null)
      {
        localObject2 = ((AppInterface)localObject2).getCurrentAccountUin();
        awrn.a(BaseApplicationImpl.getContext()).a((String)localObject2, "light_game_draw_cost_report", true, 0L, 0L, localHashMap, "", true);
      }
    }
    sNativeVersion = null;
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if (this.mDestroyed)
    {
      QLog.i("sava_ApolloRender", 1, "onDrawFrame mDestroyed, return");
      return;
    }
    long l2 = System.currentTimeMillis();
    long l3 = l2 - this.lastFrame;
    this.lastFrame = l2;
    long l1;
    if ((BaseApplicationImpl.sProcessId != 1) || (!QLog.isColorLevel()))
    {
      l1 = System.currentTimeMillis();
      if (!this.mPreLoadFlag) {
        break label469;
      }
      if (!this.mEventQueue.isEmpty())
      {
        this.mOnDrawQueue.addAll(this.mEventQueue);
        this.mEventQueue.removeAll(this.mOnDrawQueue);
      }
    }
    Object localObject3;
    for (;;)
    {
      synchronized (this.LOCK_PRELOAD_LIST)
      {
        if ((this.mDestroyed) || (this.mPreLoadQueue.isEmpty())) {
          break label466;
        }
        localObject3 = (IApolloRunnableTask)this.mPreLoadQueue.remove(0);
        if (localObject3 == null) {
          continue;
        }
        ajas.a("onDrawFrame" + ((IApolloRunnableTask)localObject3).a());
        if (!((IApolloRunnableTask)localObject3).b()) {
          break label410;
        }
        if (!this.mSavaWrapper.a(((IApolloRunnableTask)localObject3).a())) {
          break label398;
        }
        QLog.i("sava_ApolloRender", 1, "onDrawFrame continue script isLoaded:" + ((IApolloRunnableTask)localObject3).a());
      }
      this.mLogCount += 1;
      if (this.mLogCount == 1)
      {
        this.mLogBuffer.append("onDrawFrame now:").append(l2).append(",").append("mInterval:");
        this.mLogBuffer.append(this.mApolloTicker.mInterval);
        this.mLogBuffer.append(" ");
      }
      this.mLogBuffer.append(l3).append(",").append(this.lastFrameCost).append(",").append(this.mNativeTickerCost).append("|");
      if (this.mLogCount != 30) {
        break;
      }
      QLog.d("sava_ApolloRender", 1, this.mLogBuffer.toString());
      this.mLogBuffer.delete(0, this.mLogBuffer.length());
      this.mLogCount = 0;
      break;
      label398:
      this.mSavaWrapper.a(((IApolloRunnableTask)localObject3).a());
      label410:
      if (((IApolloRunnableTask)localObject3).a() == 4)
      {
        QLog.i("sava_ApolloRender", 1, "onDrawFrame dispose preload task continue");
      }
      else
      {
        ((IApolloRunnableTask)localObject3).run();
        ajas.b("onDrawFrame" + ((IApolloRunnableTask)localObject3).a());
      }
    }
    label466:
    label469:
    View localView = getRenderViewByThreadId();
    if ((localView != null) && ((localView instanceof ApolloTextureView))) {
      this.mSavaWrapper.a(aiwi.b());
    }
    boolean bool;
    if ((localView != null) && ((localView instanceof ApolloSurfaceView)))
    {
      bool = ((ApolloSurfaceView)localView).isGameMode();
      if (!bool) {
        this.mSavaWrapper.a(aiwi.b());
      }
    }
    for (;;)
    {
      if ((localView instanceof ApolloSurfaceView)) {}
      label799:
      Object localObject2;
      for (??? = ((ApolloSurfaceView)localView).getUIState();; localObject2 = null)
      {
        if (this.mPreLoadFlag) {
          localObject3 = this.mOnDrawQueue;
        }
        while (!((List)localObject3).isEmpty()) {
          if ((??? == null) || (((AtomicInteger)???).get() == 0))
          {
            IApolloRunnableTask localIApolloRunnableTask = (IApolloRunnableTask)((List)localObject3).remove(0);
            if (localIApolloRunnableTask != null)
            {
              this.mDrawTaskRunning = true;
              if (localIApolloRunnableTask.a() == 4)
              {
                QLog.i("sava_ApolloRender", 1, "onDrawFrame2 dispose preload task continue");
                continue;
                localObject3 = this.mEventQueue;
              }
              else
              {
                System.currentTimeMillis();
                localIApolloRunnableTask.run();
                if ((localIApolloRunnableTask.a()) && (this.mAddOnInitViewTask != null)) {
                  this.mAddOnInitViewTask.run();
                }
                System.currentTimeMillis();
              }
            }
          }
          else
          {
            QLog.e("sava_ApolloRender", 1, "onDrawFrame Runnable return ! UIState:" + ((AtomicInteger)???).get() + " runnableList:" + ((List)localObject3).size());
            return;
          }
        }
        long l4;
        if (((localView instanceof ApolloSurfaceView)) && (((ApolloSurfaceView)localView).mRenderMode == 1) && (l3 < this.mApolloTicker.getInterval(this.mApolloTicker.ticker) * 16)) {
          l4 = this.mApolloTicker.getInterval(this.mApolloTicker.ticker) * 16;
        }
        try
        {
          Thread.sleep(l4 - l3);
          if ((this.mIsNeedReport) && (l3 < l2) && (l3 > 0L))
          {
            this.mTotalDrawCost = ((int)(this.mTotalDrawCost + l3));
            this.mTotalFrameCount += 1;
            if (l3 > 100L) {
              this.mLongCostCount += 1;
            }
          }
          if ((??? != null) && (((AtomicInteger)???).get() != 0))
          {
            QLog.e("sava_ApolloRender", 1, "onDrawFrame draw Runnable return ! UIState:" + ((AtomicInteger)???).get());
            return;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("sava_ApolloRender", 2, localOutOfMemoryError2.getMessage());
            }
          }
          if (bool) {}
          try
          {
            updateNioSocket();
            if ((this.mDestroyed) || (!this.mSavaWrapper.a("onDrawFrame")))
            {
              QLog.i("sava_ApolloRender", 1, "mDestroyed || !mSavaWrapper.readyDraw, return");
              return;
            }
          }
          catch (OutOfMemoryError localOutOfMemoryError1)
          {
            if (QLog.isColorLevel()) {
              QLog.d("sava_ApolloRender", 2, localOutOfMemoryError1.getMessage());
            }
            for (;;)
            {
              this.lastFrameCost = (System.currentTimeMillis() - l1);
              snapShot(paramGL10);
              this.mDrawTaskRunning = false;
              return;
              l2 = System.currentTimeMillis();
              this.mApolloTicker.nativeCallbackTicker(this.mApolloTicker.ticker, l1, this.mApolloTicker.getDuration(this.mApolloTicker.ticker));
              this.mNativeTickerCost = (System.currentTimeMillis() - l2);
            }
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              QLog.e("sava_ApolloRender", 1, "[onDrawFrame]");
            }
          }
        }
        catch (Exception localException)
        {
          break label799;
        }
      }
      bool = false;
    }
  }
  
  public void onSurfaceChanged(GL10 arg1, int paramInt1, int paramInt2)
  {
    if (this.mDestroyed)
    {
      QLog.i("sava_ApolloRender", 1, "onSurfaceChanged mDestroyed, return");
      return;
    }
    this.mSurfaceReady = true;
    if (this.mPreLoadListLocked) {
      if (QLog.isColorLevel()) {
        QLog.i("sava_ApolloRender", 1, "TraceReport_CmShowStatUtil onSurfaceChanged mPreLoadListLocked! notifyAll");
      }
    }
    for (;;)
    {
      synchronized (this.LOCK_PRELOAD_LIST)
      {
        this.LOCK_PRELOAD_LIST.notifyAll();
        if (this.mSavaWrapper != null)
        {
          if ((this.mFinalRequestWidth <= 0) || (this.mFinalRequestHeight <= 0) || (this.mFinalRequestWidth * this.mScale < paramInt1) || (this.mFinalRequestHeight * this.mScale < paramInt2)) {
            break label297;
          }
          this.mSavaWrapper.a(this.mFinalRequestWidth, this.mFinalRequestHeight);
          if (QLog.isColorLevel()) {
            QLog.d("sava_ApolloRender", 2, "[onSurfaceChanged] mFinalRequestWidth:" + this.mFinalRequestWidth + ",mFinalRequestHeight:" + this.mFinalRequestHeight + ",mSavaWrapper:" + this.mSavaWrapper);
          }
          this.needRenderFrame = true;
          if (this.mPreLoadFlag)
          {
            if (QLog.isColorLevel()) {
              QLog.d("sava_ApolloRender", 2, "addOnCommonScript task");
            }
            this.mAddOnInitViewTask = new ApolloRender.5(this, paramInt1, paramInt2);
          }
        }
        this.mWidth = paramInt1;
        this.mHeight = paramInt2;
        if ((this.mCallbackRef == null) || (this.mIsReadyNotify)) {
          break;
        }
        ??? = (aiil)this.mCallbackRef.get();
        this.mIsReadyNotify = true;
        ThreadManager.post(new ApolloRender.6(this, ???, paramInt1, paramInt2), 5, null, true);
        return;
      }
      label297:
      this.mSavaWrapper.a((int)Math.ceil(paramInt1 / this.mScale), (int)Math.ceil(paramInt2 / this.mScale));
      this.needRenderFrame = true;
      if (QLog.isColorLevel()) {
        QLog.d("sava_ApolloRender", 2, "[onSurfaceChanged] width:" + paramInt1 + ",height:" + paramInt2 + ",mSavaWrapper:" + this.mSavaWrapper);
      }
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (this.mDestroyed)
    {
      QLog.i("sava_ApolloRender", 1, "onSurfaceCreated mDestroyed, return");
      return;
    }
    ajas.b("onSurfaceCreated");
    long l1 = System.currentTimeMillis();
    long l2 = Thread.currentThread().getId();
    if ((WeakReference)sRenderMap.get(Long.valueOf(l2)) == null) {
      sRenderMap.put(Long.valueOf(l2), new WeakReference(this));
    }
    if ((WeakReference)sTickerMap.get(Long.valueOf(l2)) == null) {
      sTickerMap.put(Long.valueOf(l2), new WeakReference(this.mApolloTicker));
    }
    this.mGameId = aing.a(getSavaWrapper().a());
    paramEGLConfig = aing.a();
    if ((paramEGLConfig != null) && (this.mGameId > 0)) {
      if (paramEGLConfig.getLongAccountUin() % 10L != 1L) {
        break label265;
      }
    }
    label265:
    for (boolean bool = true;; bool = false)
    {
      this.mIsNeedReport = bool;
      setupDirector();
      this.mIsReadyNotify = false;
      paramEGLConfig = new int[1];
      paramGL10.glGetIntegerv(3379, paramEGLConfig, 0);
      QLog.i("sava_ApolloRender", 1, "onSurfaceCreated  GL_MAX_TEXTURE_SIZE: " + paramEGLConfig[0]);
      if (QLog.isColorLevel()) {
        QLog.d("sava_ApolloRender", 2, " TextureView onSurfaceCreated use:" + (System.currentTimeMillis() - l1));
      }
      reportDeviceInfoTo644(paramGL10);
      return;
    }
  }
  
  public void preLoadDirector()
  {
    if (this.mPreLoadStart)
    {
      QLog.i("sava_ApolloRender", 1, "preLoadDirector mPreLoadStart!");
      return;
    }
    this.mPreLoadStart = true;
    this.mPreLoadFlag = true;
    this.mPreLoadQueue.add(new ApolloRender.2(this));
    ThreadManagerV2.newFreeThread(new ApolloRender.3(this), "Apollo_PreLoad_Engine", 10).start();
  }
  
  public void queueDestroy()
  {
    queueRenderTask(new ApolloRender.1(this));
  }
  
  public void queueRenderTask(IApolloRunnableTask paramIApolloRunnableTask)
  {
    if (paramIApolloRunnableTask == null)
    {
      QLog.e("sava_ApolloRender", 1, "queueRenderTask runnableTask == null");
      return;
    }
    if (this.mPreLoadFlag)
    {
      QLog.d("sava_ApolloRender", 1, new Object[] { "queueRenderTask getTaskName:" + this.mPreLoadFlag + " ", paramIApolloRunnableTask.a() });
      if (paramIApolloRunnableTask.b())
      {
        if (this.mPreLoadListLocked)
        {
          if (QLog.isColorLevel()) {
            QLog.i("sava_ApolloRender", 1, "TraceReport_CmShowStatUtil queueRenderTask mPreLoadListLocked! notifyAll");
          }
          synchronized (this.LOCK_PRELOAD_LIST)
          {
            this.mPreLoadQueue.add(paramIApolloRunnableTask);
            this.LOCK_PRELOAD_LIST.notifyAll();
            return;
          }
        }
        this.mPreLoadQueue.add(paramIApolloRunnableTask);
        return;
      }
      this.mEventQueue.add(paramIApolloRunnableTask);
      return;
    }
    this.mEventQueue.add(paramIApolloRunnableTask);
  }
  
  public void setBubbleType(int paramInt)
  {
    mBubbleType = paramInt;
  }
  
  public void setGameName(String paramString)
  {
    this.mGameName = paramString;
  }
  
  public void setQtaTestResult(String paramString)
  {
    qtaTestResult = paramString;
  }
  
  public void setRenderCallback(aiij paramaiij)
  {
    this.mRenderCallbackRef = new WeakReference(paramaiij);
  }
  
  public void setRenderView(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.mApolloViewRef = new WeakReference(paramView);
    this.mApolloTicker.setRenderView(paramView);
  }
  
  public void setRenderWidthAndHeight(int paramInt1, int paramInt2)
  {
    this.mFinalRequestWidth = ((int)Math.ceil(paramInt1 / this.mScale));
    this.mFinalRequestHeight = ((int)Math.ceil(paramInt2 / this.mScale));
  }
  
  public void setUseGlobalTimer(boolean paramBoolean)
  {
    this.mApolloTicker.mTickerUseGlobalTimer = paramBoolean;
  }
  
  public void snapShotOnce(aigr paramaigr, int paramInt, long paramLong)
  {
    this.mSnapShotCallback = paramaigr;
    this.mSnapShot = true;
    this.mSnapShotSeq = paramLong;
    this.mCallBackCode = paramInt;
  }
  
  public void updateNioSocket()
  {
    label145:
    label201:
    for (;;)
    {
      try
      {
        i = this.mNioList.size();
        i -= 1;
        aijw localaijw1;
        if ((i < 0) || (i < 0)) {
          continue;
        }
        localaijw2 = (aijw)this.mNioList.get(i);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        try
        {
          localaijw1 = (aijw)this.mNioList.get(i);
          if ((localaijw1 == null) || (localaijw1.jdField_c_of_type_Int == 1) || (!localaijw1.jdField_a_of_type_JavaNioChannelsSocketChannel.finishConnect())) {
            break label201;
          }
          localaijw1.jdField_c_of_type_Int = 1;
          getSavaWrapper().a(localaijw1.jdField_a_of_type_Long, 2);
          websocketShakeHand(localaijw1.jdField_a_of_type_Long, localaijw1.jdField_a_of_type_JavaLangString, localaijw1.jdField_a_of_type_Int, localaijw1.jdField_b_of_type_Int, 0, localaijw1.jdField_b_of_type_JavaLangString, localaijw1.jdField_c_of_type_JavaLangString, localaijw1.jdField_a_of_type_JavaNioChannelsSocketChannel.socket());
          this.mNioList.remove(localaijw1);
        }
        catch (Exception localException2)
        {
          int i;
          aijw localaijw2;
          break label145;
          i -= 1;
        }
        localOutOfMemoryError = localOutOfMemoryError;
        if (QLog.isColorLevel()) {
          QLog.d("sava_ApolloRender", 2, localOutOfMemoryError.getMessage());
        }
        return;
      }
      catch (Exception localException1)
      {
        i = -1;
      }
      getSavaWrapper().a(localaijw2.jdField_a_of_type_Long, 3);
      this.mNioList.remove(i);
      QLog.e("nioCmGame", 2, " exception socket");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender
 * JD-Core Version:    0.7.0.1
 */