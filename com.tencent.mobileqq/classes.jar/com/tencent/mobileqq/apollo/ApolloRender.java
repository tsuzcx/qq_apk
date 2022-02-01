package com.tencent.mobileqq.apollo;

import adad;
import adai;
import amme;
import amni;
import amnj;
import amnk;
import amnl;
import amnm;
import amnn;
import amno;
import amnp;
import amnq;
import amnr;
import amns;
import amnt;
import amnu;
import ampw;
import ampy;
import amrj;
import amrm;
import amro;
import amwn;
import amyo;
import amzv;
import anbo;
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
import androidx.annotation.Keep;
import anhm;
import anhn;
import anka;
import anmj;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.data.ApolloDevInfo;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.portal.StrokeTextView;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.widget.QQToast;
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
import java.net.Socket;
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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import mqq.os.MqqHandler;

public class ApolloRender
  implements GLSurfaceView.Renderer
{
  public static final String ACTION_RES_NONE_PREFIX = "Action:";
  public static final String ACTION_RES_PREFIX = "ActionRes:";
  public static final int APOLLO_CMD_CHANNEL_CLASS = 2;
  public static final int APOLLO_RENDER_CLASS = 1;
  private static final String BASE_JS_PREFIX = "BaseJs:";
  public static String CMSHOW_FILE_PATH = AppConstants.SDCARD_PATH + "cmshow";
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
  public static final int QZONE_BUBBLE_FONT_SIZE = 40;
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
  private static amzv mGyroSensorEventListener;
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
  public List<amrm> mBoundingList = new CopyOnWriteArrayList();
  private int mCallBackCode;
  private WeakReference<ampy> mCallbackRef;
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
  private boolean mIsOffscreen;
  private boolean mIsReadyNotify;
  private ReentrantLock mLock;
  private StringBuilder mLogBuffer = new StringBuilder(100);
  private int mLogCount;
  private int mLongCostCount;
  private long mNativeTickerCost;
  public List<amrj> mNioList = new ArrayList();
  private List<IApolloRunnableTask> mOnDrawQueue = Collections.synchronizedList(new ArrayList());
  private boolean mPreLoadFlag;
  private volatile boolean mPreLoadListLocked;
  private List<IApolloRunnableTask> mPreLoadQueue = Collections.synchronizedList(new ArrayList());
  private boolean mPreLoadStart;
  private WeakReference<ampw> mRenderCallbackRef;
  private ApolloEngine mSavaWrapper = new ApolloEngine();
  private float mScale;
  public boolean mShowEditWindow;
  private boolean mSnapShot;
  private amnu mSnapShotCallback;
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
  
  public ApolloRender(float paramFloat, ampy paramampy, int paramInt)
  {
    float f = FontSettingManager.getFontLevel() / 16.0F;
    if (f != 0.0F) {}
    for (this.mScale = (paramFloat / f);; this.mScale = paramFloat)
    {
      this.mType = paramInt;
      this.mCallbackRef = new WeakReference(paramampy);
      this.mLock = anhn.a().a();
      this.mApolloTicker = this.mSavaWrapper.a();
      if (QLog.isColorLevel()) {
        QLog.d("sava_ApolloRender", 2, "[ApolloRender] threadId:" + Thread.currentThread().getId());
      }
      return;
    }
  }
  
  public static void AABBCallback(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, String paramString1, String paramString2, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, int paramInt)
  {
    setAABBCallBack(getRenderByThreadId(), paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramString1, paramString2, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, paramFloat11, paramFloat12, paramInt);
  }
  
  public static void AABBCallback(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, String paramString1, String paramString2, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, int paramInt)
  {
    QLog.w("sava_ApolloRender", 1, "old AABBCallback is called.");
    AABBCallback(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramString1, paramString2, paramFloat5, paramFloat6, paramFloat7, paramFloat8, 0.0F, 0.0F, 0.0F, 0.0F, paramInt);
  }
  
  public static void AABBCallback(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, String paramString1, String paramString2, String paramString3, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, float paramFloat16, float paramFloat17, float paramFloat18, float paramFloat19, float paramFloat20, int paramInt)
  {
    setAABBCallBack(getRenderByThreadId(), paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramString1, paramString2, paramString3, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, paramFloat11, paramFloat12, paramFloat13, paramFloat14, paramFloat15, paramFloat16, paramFloat17, paramFloat18, paramFloat19, paramFloat20, paramInt);
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
        localObject = amwn.a(paramInt);
      } while (localObject == null);
      localObject = ((amyo)localObject).a();
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
    //   0: new 455	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 456	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: iconst_1
    //   10: putfield 459	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   13: aload_2
    //   14: iconst_0
    //   15: putfield 462	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   18: aload_2
    //   19: getstatic 468	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   22: putfield 471	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   25: aload_0
    //   26: iconst_0
    //   27: iload_1
    //   28: aload_2
    //   29: invokestatic 477	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   32: astore_3
    //   33: aload_3
    //   34: invokevirtual 483	android/graphics/Bitmap:getWidth	()I
    //   37: aload_3
    //   38: invokevirtual 486	android/graphics/Bitmap:getHeight	()I
    //   41: getstatic 468	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   44: invokestatic 490	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   47: astore_0
    //   48: aload_0
    //   49: astore_2
    //   50: new 492	android/graphics/Canvas
    //   53: dup
    //   54: aload_0
    //   55: invokespecial 495	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   58: astore 4
    //   60: aload_0
    //   61: astore_2
    //   62: aload 4
    //   64: aload_3
    //   65: fconst_0
    //   66: fconst_0
    //   67: aconst_null
    //   68: invokevirtual 499	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   71: aload_0
    //   72: astore_2
    //   73: aload 4
    //   75: invokevirtual 502	android/graphics/Canvas:save	()I
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
    //   93: invokestatic 306	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   96: ifeq -14 -> 82
    //   99: aload_0
    //   100: astore_2
    //   101: ldc 63
    //   103: iconst_2
    //   104: aload_3
    //   105: invokevirtual 505	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   108: invokestatic 325	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: aload_0
    //   112: areturn
    //   113: aload_0
    //   114: astore_2
    //   115: aload_3
    //   116: invokevirtual 508	java/lang/Exception:printStackTrace	()V
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
    if (amme.jdField_c_of_type_JavaLangString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("sava_ApolloRender", 2, "decryptTEA but stkey = null,return null");
      }
      return null;
    }
    return new Cryptor().decrypt(paramArrayOfByte, amme.jdField_c_of_type_JavaLangString.getBytes());
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
  public static Bitmap drawTextOnBitmap(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2, String paramString3, int paramInt5)
  {
    // Byte code:
    //   0: invokestatic 306	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +157 -> 160
    //   6: ldc 63
    //   8: iconst_2
    //   9: iconst_3
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: new 178	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   22: ldc_w 547
    //   25: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: fload_0
    //   29: invokevirtual 550	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   32: ldc_w 552
    //   35: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: fload_1
    //   39: invokevirtual 550	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   42: ldc_w 554
    //   45: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: fload_2
    //   49: invokevirtual 550	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   52: ldc_w 556
    //   55: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: fload_3
    //   59: invokevirtual 550	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   62: ldc_w 558
    //   65: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: iload 4
    //   70: invokevirtual 561	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   73: ldc_w 563
    //   76: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: iload 5
    //   81: invokevirtual 561	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   84: ldc_w 565
    //   87: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload 8
    //   92: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: ldc_w 567
    //   98: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload 9
    //   103: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: ldc_w 569
    //   109: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: iload 6
    //   114: invokevirtual 561	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   117: ldc_w 571
    //   120: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: iload 7
    //   125: invokevirtual 561	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   128: ldc_w 573
    //   131: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload 10
    //   136: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: aastore
    //   143: dup
    //   144: iconst_1
    //   145: ldc_w 575
    //   148: aastore
    //   149: dup
    //   150: iconst_2
    //   151: iload 11
    //   153: invokestatic 580	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   156: aastore
    //   157: invokestatic 583	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   160: aload 9
    //   162: invokestatic 589	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   165: ifne +25 -> 190
    //   168: ldc_w 591
    //   171: aload 9
    //   173: invokevirtual 595	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   176: ifne +31 -> 207
    //   179: ldc_w 597
    //   182: aload 9
    //   184: invokevirtual 595	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   187: ifne +20 -> 207
    //   190: invokestatic 306	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +12 -> 205
    //   196: ldc 63
    //   198: iconst_2
    //   199: ldc_w 599
    //   202: invokestatic 325	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: aconst_null
    //   206: areturn
    //   207: iload 11
    //   209: invokestatic 605	com/tencent/mobileqq/apollo/utils/ApolloUtil:g	(I)Z
    //   212: ifeq +27 -> 239
    //   215: fload_0
    //   216: fload_1
    //   217: fload_2
    //   218: fload_3
    //   219: iload 4
    //   221: iload 5
    //   223: iload 6
    //   225: iload 7
    //   227: aload 8
    //   229: aload 9
    //   231: aload 10
    //   233: iload 11
    //   235: invokestatic 608	com/tencent/mobileqq/apollo/ApolloRender:drawTextOnBitmapForQZone	(FFFFIIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   238: areturn
    //   239: aload 10
    //   241: invokestatic 589	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   244: ifeq +681 -> 925
    //   247: iconst_0
    //   248: istore 13
    //   250: aconst_null
    //   251: astore 14
    //   253: new 178	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   260: ldc_w 610
    //   263: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: iload 4
    //   268: invokevirtual 561	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   271: ldc_w 612
    //   274: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: iload 5
    //   279: invokevirtual 561	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   282: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: astore 16
    //   287: getstatic 618	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   290: ifnull +66 -> 356
    //   293: getstatic 618	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   296: aload 16
    //   298: invokevirtual 621	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   301: checkcast 479	android/graphics/Bitmap
    //   304: astore 15
    //   306: aload 15
    //   308: astore 14
    //   310: aload 15
    //   312: ifnull +44 -> 356
    //   315: aload 15
    //   317: astore 14
    //   319: invokestatic 306	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   322: ifeq +34 -> 356
    //   325: ldc 63
    //   327: iconst_2
    //   328: new 178	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   335: ldc_w 623
    //   338: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: aload 16
    //   343: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokestatic 325	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   352: aload 15
    //   354: astore 14
    //   356: aload 14
    //   358: astore 15
    //   360: aload 14
    //   362: ifnonnull +40 -> 402
    //   365: iload 4
    //   367: iload 5
    //   369: getstatic 468	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   372: invokestatic 490	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   375: astore 14
    //   377: aload 14
    //   379: astore 15
    //   381: getstatic 618	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   384: ifnull +18 -> 402
    //   387: getstatic 618	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   390: aload 16
    //   392: aload 14
    //   394: invokevirtual 627	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   397: pop
    //   398: aload 14
    //   400: astore 15
    //   402: new 629	android/widget/TextView
    //   405: dup
    //   406: invokestatic 633	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   409: invokespecial 636	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   412: astore 17
    //   414: new 638	android/graphics/Paint$FontMetricsInt
    //   417: dup
    //   418: invokespecial 639	android/graphics/Paint$FontMetricsInt:<init>	()V
    //   421: astore 14
    //   423: aload 17
    //   425: invokevirtual 643	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   428: aload 14
    //   430: invokevirtual 649	android/text/TextPaint:getFontMetricsInt	(Landroid/graphics/Paint$FontMetricsInt;)I
    //   433: pop
    //   434: aload 14
    //   436: getfield 652	android/graphics/Paint$FontMetricsInt:ascent	I
    //   439: aload 14
    //   441: getfield 655	android/graphics/Paint$FontMetricsInt:top	I
    //   444: isub
    //   445: istore 5
    //   447: iload 5
    //   449: ifne +1142 -> 1591
    //   452: fconst_2
    //   453: getstatic 660	com/tencent/mobileqq/utils/DeviceInfoUtil:density	F
    //   456: fmul
    //   457: f2i
    //   458: istore 5
    //   460: invokestatic 290	anhn:a	()Lanhn;
    //   463: getfield 663	anhn:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   466: invokevirtual 667	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   469: istore 4
    //   471: invokestatic 671	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   474: invokevirtual 675	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   477: astore 16
    //   479: aload 16
    //   481: instanceof 677
    //   484: ifeq +1104 -> 1588
    //   487: aload 16
    //   489: checkcast 677	com/tencent/mobileqq/app/QQAppInterface
    //   492: astore 14
    //   494: getstatic 204	com/tencent/mobileqq/apollo/ApolloRender:mBubbleType	I
    //   497: iconst_m1
    //   498: if_icmpeq +1090 -> 1588
    //   501: getstatic 204	com/tencent/mobileqq/apollo/ApolloRender:mBubbleType	I
    //   504: istore 4
    //   506: invokestatic 306	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   509: ifeq +30 -> 539
    //   512: ldc 63
    //   514: iconst_2
    //   515: new 178	java/lang/StringBuilder
    //   518: dup
    //   519: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   522: ldc_w 679
    //   525: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: iload 4
    //   530: invokevirtual 561	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   533: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   536: invokestatic 325	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   539: aload 8
    //   541: astore 14
    //   543: aload 8
    //   545: invokestatic 589	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   548: ifne +52 -> 600
    //   551: iload 4
    //   553: ifeq +13 -> 566
    //   556: aload 8
    //   558: astore 14
    //   560: iconst_1
    //   561: iload 4
    //   563: if_icmpne +37 -> 600
    //   566: aload 8
    //   568: ldc_w 681
    //   571: invokevirtual 684	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   574: iconst_0
    //   575: invokestatic 690	bhcu:decode	([BI)[B
    //   578: astore 18
    //   580: aload 8
    //   582: astore 14
    //   584: aload 18
    //   586: ifnull +14 -> 600
    //   589: new 526	java/lang/String
    //   592: dup
    //   593: aload 18
    //   595: invokespecial 693	java/lang/String:<init>	([B)V
    //   598: astore 14
    //   600: iload 13
    //   602: ifne +467 -> 1069
    //   605: iload 4
    //   607: ifeq +27 -> 634
    //   610: iconst_1
    //   611: iload 4
    //   613: if_icmpne +14 -> 627
    //   616: ldc_w 591
    //   619: aload 9
    //   621: invokevirtual 595	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   624: ifne +10 -> 634
    //   627: bipush 8
    //   629: iload 4
    //   631: if_icmpne +438 -> 1069
    //   634: aload 17
    //   636: bipush 17
    //   638: invokevirtual 696	android/widget/TextView:setGravity	(I)V
    //   641: aload 17
    //   643: ldc_w 697
    //   646: invokevirtual 700	android/widget/TextView:setTextColor	(I)V
    //   649: aload 17
    //   651: ldc_w 701
    //   654: getstatic 660	com/tencent/mobileqq/utils/DeviceInfoUtil:density	F
    //   657: fdiv
    //   658: invokevirtual 705	android/widget/TextView:setTextSize	(F)V
    //   661: iconst_3
    //   662: istore 4
    //   664: aload 17
    //   666: fload_2
    //   667: f2i
    //   668: invokevirtual 708	android/widget/TextView:setWidth	(I)V
    //   671: aload 17
    //   673: fload_3
    //   674: f2i
    //   675: iload 5
    //   677: iadd
    //   678: invokevirtual 711	android/widget/TextView:setHeight	(I)V
    //   681: aload 17
    //   683: aload 17
    //   685: invokevirtual 643	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   688: fload_2
    //   689: aload 14
    //   691: iload 4
    //   693: invokestatic 714	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	(Landroid/graphics/Paint;FLjava/lang/String;I)Ljava/lang/String;
    //   696: invokevirtual 718	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   699: aload 17
    //   701: iconst_0
    //   702: iconst_0
    //   703: invokestatic 724	android/view/View$MeasureSpec:makeMeasureSpec	(II)I
    //   706: iconst_0
    //   707: iconst_0
    //   708: invokestatic 724	android/view/View$MeasureSpec:makeMeasureSpec	(II)I
    //   711: invokevirtual 728	android/widget/TextView:measure	(II)V
    //   714: aload 17
    //   716: invokevirtual 731	android/widget/TextView:getMeasuredWidth	()I
    //   719: istore 6
    //   721: aload 17
    //   723: iconst_0
    //   724: iconst_0
    //   725: iload 6
    //   727: aload 17
    //   729: invokevirtual 734	android/widget/TextView:getMeasuredHeight	()I
    //   732: invokevirtual 738	android/widget/TextView:layout	(IIII)V
    //   735: invokestatic 306	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   738: ifeq +33 -> 771
    //   741: ldc 63
    //   743: iconst_2
    //   744: new 178	java/lang/StringBuilder
    //   747: dup
    //   748: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   751: ldc_w 740
    //   754: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: aload 17
    //   759: invokevirtual 743	android/widget/TextView:getLineHeight	()I
    //   762: invokevirtual 561	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   765: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   768: invokestatic 325	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   771: aload 17
    //   773: invokevirtual 746	android/widget/TextView:getLineCount	()I
    //   776: ifne +708 -> 1484
    //   779: aload 17
    //   781: ldc_w 747
    //   784: aload 17
    //   786: invokevirtual 743	android/widget/TextView:getLineHeight	()I
    //   789: i2f
    //   790: fsub
    //   791: ldc_w 748
    //   794: invokevirtual 752	android/widget/TextView:setLineSpacing	(FF)V
    //   797: new 492	android/graphics/Canvas
    //   800: dup
    //   801: aload 15
    //   803: invokespecial 495	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   806: astore 8
    //   808: new 754	android/graphics/Matrix
    //   811: dup
    //   812: invokespecial 755	android/graphics/Matrix:<init>	()V
    //   815: astore 9
    //   817: iconst_1
    //   818: iload 7
    //   820: if_icmpne +738 -> 1558
    //   823: aload 9
    //   825: bipush 9
    //   827: newarray float
    //   829: dup
    //   830: iconst_0
    //   831: ldc_w 756
    //   834: fastore
    //   835: dup
    //   836: iconst_1
    //   837: fconst_0
    //   838: fastore
    //   839: dup
    //   840: iconst_2
    //   841: fconst_0
    //   842: fastore
    //   843: dup
    //   844: iconst_3
    //   845: fconst_0
    //   846: fastore
    //   847: dup
    //   848: iconst_4
    //   849: fconst_1
    //   850: fastore
    //   851: dup
    //   852: iconst_5
    //   853: fconst_0
    //   854: fastore
    //   855: dup
    //   856: bipush 6
    //   858: fconst_0
    //   859: fastore
    //   860: dup
    //   861: bipush 7
    //   863: fconst_0
    //   864: fastore
    //   865: dup
    //   866: bipush 8
    //   868: fconst_1
    //   869: fastore
    //   870: invokevirtual 760	android/graphics/Matrix:setValues	([F)V
    //   873: aload 9
    //   875: fload_2
    //   876: fconst_0
    //   877: invokevirtual 764	android/graphics/Matrix:postTranslate	(FF)Z
    //   880: pop
    //   881: iconst_m1
    //   882: istore 4
    //   884: aload 9
    //   886: iload 4
    //   888: i2f
    //   889: fload_2
    //   890: iload 6
    //   892: i2f
    //   893: fsub
    //   894: fmul
    //   895: fconst_2
    //   896: fdiv
    //   897: fload_0
    //   898: fadd
    //   899: fload_1
    //   900: iload 5
    //   902: i2f
    //   903: fsub
    //   904: invokevirtual 764	android/graphics/Matrix:postTranslate	(FF)Z
    //   907: pop
    //   908: aload 8
    //   910: aload 9
    //   912: invokevirtual 768	android/graphics/Canvas:setMatrix	(Landroid/graphics/Matrix;)V
    //   915: aload 17
    //   917: aload 8
    //   919: invokevirtual 772	android/widget/TextView:draw	(Landroid/graphics/Canvas;)V
    //   922: aload 15
    //   924: areturn
    //   925: aload 10
    //   927: ldc_w 774
    //   930: invokevirtual 777	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   933: istore 13
    //   935: goto -685 -> 250
    //   938: astore 8
    //   940: invokestatic 306	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   943: ifeq +33 -> 976
    //   946: ldc 63
    //   948: iconst_2
    //   949: new 178	java/lang/StringBuilder
    //   952: dup
    //   953: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   956: ldc_w 779
    //   959: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   962: aload 8
    //   964: invokevirtual 505	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   967: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   970: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   973: invokestatic 325	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   976: aconst_null
    //   977: areturn
    //   978: astore 8
    //   980: invokestatic 306	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   983: ifeq +33 -> 1016
    //   986: ldc 63
    //   988: iconst_2
    //   989: new 178	java/lang/StringBuilder
    //   992: dup
    //   993: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   996: ldc_w 779
    //   999: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1002: aload 8
    //   1004: invokevirtual 512	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1007: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1010: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1013: invokestatic 325	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1016: aconst_null
    //   1017: areturn
    //   1018: astore 18
    //   1020: aload 8
    //   1022: astore 14
    //   1024: invokestatic 306	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1027: ifeq -427 -> 600
    //   1030: ldc 63
    //   1032: iconst_2
    //   1033: aload 18
    //   1035: invokevirtual 505	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   1038: invokestatic 325	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1041: aload 8
    //   1043: astore 14
    //   1045: goto -445 -> 600
    //   1048: astore 14
    //   1050: ldc 63
    //   1052: iconst_1
    //   1053: aload 14
    //   1055: iconst_0
    //   1056: anewarray 4	java/lang/Object
    //   1059: invokestatic 782	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1062: aload 8
    //   1064: astore 14
    //   1066: goto -466 -> 600
    //   1069: iconst_1
    //   1070: iload 4
    //   1072: if_icmpeq +8 -> 1080
    //   1075: iload 13
    //   1077: ifeq +219 -> 1296
    //   1080: ldc_w 597
    //   1083: aload 9
    //   1085: invokevirtual 595	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1088: ifeq +208 -> 1296
    //   1091: aload 16
    //   1093: instanceof 677
    //   1096: ifeq +483 -> 1579
    //   1099: aload 16
    //   1101: checkcast 677	com/tencent/mobileqq/app/QQAppInterface
    //   1104: astore 9
    //   1106: aload 9
    //   1108: getstatic 787	com/tencent/mobileqq/app/QQManagerFactory:APOLLO_MANAGER	I
    //   1111: invokevirtual 791	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1114: checkcast 516	amme
    //   1117: astore 8
    //   1119: aload 10
    //   1121: astore 16
    //   1123: aload 10
    //   1125: invokestatic 589	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1128: ifne +33 -> 1161
    //   1131: aload 10
    //   1133: astore 16
    //   1135: aload 10
    //   1137: ldc_w 793
    //   1140: invokevirtual 797	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1143: ifeq +18 -> 1161
    //   1146: aload 10
    //   1148: iconst_0
    //   1149: aload 10
    //   1151: invokevirtual 800	java/lang/String:length	()I
    //   1154: iconst_1
    //   1155: isub
    //   1156: invokevirtual 804	java/lang/String:substring	(II)Ljava/lang/String;
    //   1159: astore 16
    //   1161: iload 13
    //   1163: ifeq +46 -> 1209
    //   1166: ldc_w 805
    //   1169: istore 4
    //   1171: fload_2
    //   1172: fstore 12
    //   1174: aload 17
    //   1176: bipush 17
    //   1178: invokevirtual 696	android/widget/TextView:setGravity	(I)V
    //   1181: aload 17
    //   1183: iload 4
    //   1185: invokevirtual 700	android/widget/TextView:setTextColor	(I)V
    //   1188: aload 17
    //   1190: ldc_w 806
    //   1193: getstatic 660	com/tencent/mobileqq/utils/DeviceInfoUtil:density	F
    //   1196: fdiv
    //   1197: invokevirtual 705	android/widget/TextView:setTextSize	(F)V
    //   1200: iconst_1
    //   1201: istore 4
    //   1203: fload 12
    //   1205: fstore_2
    //   1206: goto -542 -> 664
    //   1209: aload 8
    //   1211: ifnull +76 -> 1287
    //   1214: aload 16
    //   1216: invokestatic 589	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1219: ifne +68 -> 1287
    //   1222: aload 8
    //   1224: aload 16
    //   1226: invokevirtual 809	amme:b	(Ljava/lang/String;)Z
    //   1229: ifeq +341 -> 1570
    //   1232: ldc_w 810
    //   1235: istore 6
    //   1237: iload 6
    //   1239: istore 4
    //   1241: fload_2
    //   1242: fstore 12
    //   1244: aload 9
    //   1246: ifnull -72 -> 1174
    //   1249: iload 6
    //   1251: istore 4
    //   1253: fload_2
    //   1254: fstore 12
    //   1256: aload 16
    //   1258: aload 9
    //   1260: invokevirtual 813	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1263: invokevirtual 595	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1266: ifeq -92 -> 1174
    //   1269: fload_2
    //   1270: fconst_2
    //   1271: getstatic 660	com/tencent/mobileqq/utils/DeviceInfoUtil:density	F
    //   1274: fmul
    //   1275: f2i
    //   1276: i2f
    //   1277: fadd
    //   1278: fstore 12
    //   1280: iload 6
    //   1282: istore 4
    //   1284: goto -110 -> 1174
    //   1287: iconst_m1
    //   1288: istore 4
    //   1290: fload_2
    //   1291: fstore 12
    //   1293: goto -119 -> 1174
    //   1296: iconst_2
    //   1297: iload 4
    //   1299: if_icmpne +36 -> 1335
    //   1302: aload 17
    //   1304: bipush 17
    //   1306: invokevirtual 696	android/widget/TextView:setGravity	(I)V
    //   1309: aload 17
    //   1311: ldc_w 697
    //   1314: invokevirtual 700	android/widget/TextView:setTextColor	(I)V
    //   1317: aload 17
    //   1319: ldc_w 814
    //   1322: getstatic 660	com/tencent/mobileqq/utils/DeviceInfoUtil:density	F
    //   1325: fdiv
    //   1326: invokevirtual 705	android/widget/TextView:setTextSize	(F)V
    //   1329: iconst_3
    //   1330: istore 4
    //   1332: goto -668 -> 664
    //   1335: iconst_3
    //   1336: iload 4
    //   1338: if_icmpne +36 -> 1374
    //   1341: aload 17
    //   1343: bipush 19
    //   1345: invokevirtual 696	android/widget/TextView:setGravity	(I)V
    //   1348: aload 17
    //   1350: ldc_w 697
    //   1353: invokevirtual 700	android/widget/TextView:setTextColor	(I)V
    //   1356: aload 17
    //   1358: ldc_w 815
    //   1361: getstatic 660	com/tencent/mobileqq/utils/DeviceInfoUtil:density	F
    //   1364: fdiv
    //   1365: invokevirtual 705	android/widget/TextView:setTextSize	(F)V
    //   1368: iconst_2
    //   1369: istore 4
    //   1371: goto -707 -> 664
    //   1374: iconst_4
    //   1375: iload 4
    //   1377: if_icmpeq +9 -> 1386
    //   1380: iconst_5
    //   1381: iload 4
    //   1383: if_icmpne +37 -> 1420
    //   1386: aload 17
    //   1388: bipush 17
    //   1390: invokevirtual 696	android/widget/TextView:setGravity	(I)V
    //   1393: aload 17
    //   1395: ldc_w 816
    //   1398: invokevirtual 700	android/widget/TextView:setTextColor	(I)V
    //   1401: aload 17
    //   1403: ldc_w 817
    //   1406: getstatic 660	com/tencent/mobileqq/utils/DeviceInfoUtil:density	F
    //   1409: fdiv
    //   1410: invokevirtual 705	android/widget/TextView:setTextSize	(F)V
    //   1413: bipush 6
    //   1415: istore 4
    //   1417: goto -753 -> 664
    //   1420: bipush 6
    //   1422: iload 4
    //   1424: if_icmpeq +17 -> 1441
    //   1427: bipush 7
    //   1429: iload 4
    //   1431: if_icmpeq +10 -> 1441
    //   1434: bipush 9
    //   1436: iload 4
    //   1438: if_icmpne +126 -> 1564
    //   1441: aload 17
    //   1443: bipush 17
    //   1445: invokevirtual 696	android/widget/TextView:setGravity	(I)V
    //   1448: aload 17
    //   1450: ldc_w 697
    //   1453: invokevirtual 700	android/widget/TextView:setTextColor	(I)V
    //   1456: aload 17
    //   1458: ldc_w 818
    //   1461: getstatic 660	com/tencent/mobileqq/utils/DeviceInfoUtil:density	F
    //   1464: fdiv
    //   1465: invokevirtual 705	android/widget/TextView:setTextSize	(F)V
    //   1468: aload 17
    //   1470: iconst_0
    //   1471: iload 5
    //   1473: iconst_0
    //   1474: iconst_0
    //   1475: invokevirtual 821	android/widget/TextView:setPadding	(IIII)V
    //   1478: iconst_2
    //   1479: istore 4
    //   1481: goto -817 -> 664
    //   1484: aload 17
    //   1486: iload 5
    //   1488: i2f
    //   1489: fload_3
    //   1490: fadd
    //   1491: aload 17
    //   1493: invokevirtual 746	android/widget/TextView:getLineCount	()I
    //   1496: i2f
    //   1497: fdiv
    //   1498: aload 17
    //   1500: invokevirtual 743	android/widget/TextView:getLineHeight	()I
    //   1503: i2f
    //   1504: fsub
    //   1505: ldc_w 748
    //   1508: invokevirtual 752	android/widget/TextView:setLineSpacing	(FF)V
    //   1511: goto -714 -> 797
    //   1514: astore 8
    //   1516: invokestatic 306	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1519: ifeq +14 -> 1533
    //   1522: ldc 63
    //   1524: iconst_2
    //   1525: aload 8
    //   1527: invokevirtual 505	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   1530: invokestatic 325	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1533: aconst_null
    //   1534: astore 8
    //   1536: goto -728 -> 808
    //   1539: astore 8
    //   1541: invokestatic 306	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1544: ifeq +12 -> 1556
    //   1547: ldc 63
    //   1549: iconst_2
    //   1550: ldc_w 823
    //   1553: invokestatic 325	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1556: aconst_null
    //   1557: areturn
    //   1558: iconst_1
    //   1559: istore 4
    //   1561: goto -677 -> 884
    //   1564: iconst_3
    //   1565: istore 4
    //   1567: goto -903 -> 664
    //   1570: iconst_m1
    //   1571: istore 4
    //   1573: fload_2
    //   1574: fstore 12
    //   1576: goto -402 -> 1174
    //   1579: aconst_null
    //   1580: astore 9
    //   1582: aconst_null
    //   1583: astore 8
    //   1585: goto -466 -> 1119
    //   1588: goto -1082 -> 506
    //   1591: goto -1131 -> 460
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1594	0	paramFloat1	float
    //   0	1594	1	paramFloat2	float
    //   0	1594	2	paramFloat3	float
    //   0	1594	3	paramFloat4	float
    //   0	1594	4	paramInt1	int
    //   0	1594	5	paramInt2	int
    //   0	1594	6	paramInt3	int
    //   0	1594	7	paramInt4	int
    //   0	1594	8	paramString1	String
    //   0	1594	9	paramString2	String
    //   0	1594	10	paramString3	String
    //   0	1594	11	paramInt5	int
    //   1172	403	12	f	float
    //   248	914	13	bool	boolean
    //   251	793	14	localObject1	Object
    //   1048	6	14	localThrowable	Throwable
    //   1064	1	14	str	String
    //   304	619	15	localObject2	Object
    //   285	972	16	localObject3	Object
    //   412	1087	17	localTextView	TextView
    //   578	16	18	arrayOfByte	byte[]
    //   1018	16	18	localOutOfMemoryError	OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   365	377	938	java/lang/OutOfMemoryError
    //   381	398	938	java/lang/OutOfMemoryError
    //   365	377	978	java/lang/Exception
    //   381	398	978	java/lang/Exception
    //   543	551	1018	java/lang/OutOfMemoryError
    //   566	580	1018	java/lang/OutOfMemoryError
    //   589	600	1018	java/lang/OutOfMemoryError
    //   543	551	1048	java/lang/Throwable
    //   566	580	1048	java/lang/Throwable
    //   589	600	1048	java/lang/Throwable
    //   797	808	1514	java/lang/OutOfMemoryError
    //   797	808	1539	java/lang/Exception
  }
  
  /* Error */
  public static Bitmap drawTextOnBitmapForQZone(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2, String paramString3, int paramInt5)
  {
    // Byte code:
    //   0: invokestatic 306	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +157 -> 160
    //   6: ldc 63
    //   8: iconst_2
    //   9: iconst_3
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: new 178	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   22: ldc_w 825
    //   25: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: fload_0
    //   29: invokevirtual 550	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   32: ldc_w 552
    //   35: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: fload_1
    //   39: invokevirtual 550	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   42: ldc_w 554
    //   45: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: fload_2
    //   49: invokevirtual 550	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   52: ldc_w 556
    //   55: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: fload_3
    //   59: invokevirtual 550	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   62: ldc_w 558
    //   65: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: iload 4
    //   70: invokevirtual 561	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   73: ldc_w 563
    //   76: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: iload 5
    //   81: invokevirtual 561	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   84: ldc_w 565
    //   87: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload 8
    //   92: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: ldc_w 567
    //   98: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload 9
    //   103: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: ldc_w 569
    //   109: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: iload 6
    //   114: invokevirtual 561	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   117: ldc_w 571
    //   120: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: iload 7
    //   125: invokevirtual 561	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   128: ldc_w 573
    //   131: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload 10
    //   136: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: aastore
    //   143: dup
    //   144: iconst_1
    //   145: ldc_w 575
    //   148: aastore
    //   149: dup
    //   150: iconst_2
    //   151: iload 11
    //   153: invokestatic 580	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   156: aastore
    //   157: invokestatic 583	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   160: aload 9
    //   162: invokestatic 589	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   165: ifne +25 -> 190
    //   168: ldc_w 591
    //   171: aload 9
    //   173: invokevirtual 595	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   176: ifne +31 -> 207
    //   179: ldc_w 597
    //   182: aload 9
    //   184: invokevirtual 595	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   187: ifne +20 -> 207
    //   190: invokestatic 306	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +12 -> 205
    //   196: ldc 63
    //   198: iconst_2
    //   199: ldc_w 599
    //   202: invokestatic 325	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: aconst_null
    //   206: areturn
    //   207: aconst_null
    //   208: astore 9
    //   210: new 178	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   217: ldc_w 610
    //   220: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: iload 4
    //   225: invokevirtual 561	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   228: ldc_w 612
    //   231: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: iload 5
    //   236: invokevirtual 561	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   239: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: astore 12
    //   244: getstatic 618	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   247: ifnull +66 -> 313
    //   250: getstatic 618	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   253: aload 12
    //   255: invokevirtual 621	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   258: checkcast 479	android/graphics/Bitmap
    //   261: astore 10
    //   263: aload 10
    //   265: astore 9
    //   267: aload 10
    //   269: ifnull +44 -> 313
    //   272: aload 10
    //   274: astore 9
    //   276: invokestatic 306	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   279: ifeq +34 -> 313
    //   282: ldc 63
    //   284: iconst_2
    //   285: new 178	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   292: ldc_w 623
    //   295: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: aload 12
    //   300: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: invokestatic 325	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   309: aload 10
    //   311: astore 9
    //   313: aload 9
    //   315: astore 10
    //   317: aload 9
    //   319: ifnonnull +40 -> 359
    //   322: iload 4
    //   324: iload 5
    //   326: getstatic 468	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   329: invokestatic 490	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   332: astore 9
    //   334: aload 9
    //   336: astore 10
    //   338: getstatic 618	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   341: ifnull +18 -> 359
    //   344: getstatic 618	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   347: aload 12
    //   349: aload 9
    //   351: invokevirtual 627	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   354: pop
    //   355: aload 9
    //   357: astore 10
    //   359: new 629	android/widget/TextView
    //   362: dup
    //   363: invokestatic 633	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   366: invokespecial 636	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   369: astore 12
    //   371: invokestatic 290	anhn:a	()Lanhn;
    //   374: getfield 663	anhn:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   377: invokevirtual 667	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   380: istore 5
    //   382: iload 5
    //   384: istore 4
    //   386: invokestatic 671	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   389: invokevirtual 675	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   392: instanceof 677
    //   395: ifeq +19 -> 414
    //   398: iload 5
    //   400: istore 4
    //   402: getstatic 204	com/tencent/mobileqq/apollo/ApolloRender:mBubbleType	I
    //   405: iconst_m1
    //   406: if_icmpeq +8 -> 414
    //   409: getstatic 204	com/tencent/mobileqq/apollo/ApolloRender:mBubbleType	I
    //   412: istore 4
    //   414: invokestatic 306	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   417: ifeq +30 -> 447
    //   420: ldc 63
    //   422: iconst_2
    //   423: new 178	java/lang/StringBuilder
    //   426: dup
    //   427: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   430: ldc_w 827
    //   433: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: iload 4
    //   438: invokevirtual 561	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   441: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 325	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   447: aload 8
    //   449: astore 9
    //   451: aload 8
    //   453: invokestatic 589	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   456: ifne +52 -> 508
    //   459: iload 4
    //   461: ifeq +13 -> 474
    //   464: aload 8
    //   466: astore 9
    //   468: iconst_1
    //   469: iload 4
    //   471: if_icmpne +37 -> 508
    //   474: aload 8
    //   476: ldc_w 681
    //   479: invokevirtual 684	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   482: iconst_0
    //   483: invokestatic 690	bhcu:decode	([BI)[B
    //   486: astore 13
    //   488: aload 8
    //   490: astore 9
    //   492: aload 13
    //   494: ifnull +14 -> 508
    //   497: new 526	java/lang/String
    //   500: dup
    //   501: aload 13
    //   503: invokespecial 693	java/lang/String:<init>	([B)V
    //   506: astore 9
    //   508: aload 12
    //   510: bipush 17
    //   512: invokevirtual 696	android/widget/TextView:setGravity	(I)V
    //   515: aload 12
    //   517: iconst_m1
    //   518: invokevirtual 700	android/widget/TextView:setTextColor	(I)V
    //   521: aload 12
    //   523: ldc_w 828
    //   526: getstatic 660	com/tencent/mobileqq/utils/DeviceInfoUtil:density	F
    //   529: fdiv
    //   530: invokevirtual 705	android/widget/TextView:setTextSize	(F)V
    //   533: new 638	android/graphics/Paint$FontMetricsInt
    //   536: dup
    //   537: invokespecial 639	android/graphics/Paint$FontMetricsInt:<init>	()V
    //   540: astore 8
    //   542: aload 12
    //   544: invokevirtual 643	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   547: aload 8
    //   549: invokevirtual 649	android/text/TextPaint:getFontMetricsInt	(Landroid/graphics/Paint$FontMetricsInt;)I
    //   552: pop
    //   553: aload 8
    //   555: getfield 652	android/graphics/Paint$FontMetricsInt:ascent	I
    //   558: aload 8
    //   560: getfield 655	android/graphics/Paint$FontMetricsInt:top	I
    //   563: isub
    //   564: iconst_3
    //   565: imul
    //   566: istore 5
    //   568: iload 5
    //   570: istore 4
    //   572: iload 5
    //   574: ifne +11 -> 585
    //   577: fconst_2
    //   578: getstatic 660	com/tencent/mobileqq/utils/DeviceInfoUtil:density	F
    //   581: fmul
    //   582: f2i
    //   583: istore 4
    //   585: aload 12
    //   587: iconst_0
    //   588: iload 4
    //   590: iconst_0
    //   591: iconst_0
    //   592: invokevirtual 821	android/widget/TextView:setPadding	(IIII)V
    //   595: aload 12
    //   597: fload_2
    //   598: f2i
    //   599: invokevirtual 708	android/widget/TextView:setWidth	(I)V
    //   602: aload 12
    //   604: fload_3
    //   605: f2i
    //   606: iload 4
    //   608: iadd
    //   609: invokevirtual 711	android/widget/TextView:setHeight	(I)V
    //   612: aload 12
    //   614: aload 12
    //   616: invokevirtual 643	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   619: fload_2
    //   620: aload 9
    //   622: iconst_3
    //   623: invokestatic 830	com/tencent/mobileqq/apollo/utils/ApolloUtil:b	(Landroid/graphics/Paint;FLjava/lang/String;I)Ljava/lang/String;
    //   626: invokevirtual 718	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   629: aload 12
    //   631: iconst_0
    //   632: iconst_0
    //   633: invokestatic 724	android/view/View$MeasureSpec:makeMeasureSpec	(II)I
    //   636: iconst_0
    //   637: iconst_0
    //   638: invokestatic 724	android/view/View$MeasureSpec:makeMeasureSpec	(II)I
    //   641: invokevirtual 728	android/widget/TextView:measure	(II)V
    //   644: aload 12
    //   646: invokevirtual 731	android/widget/TextView:getMeasuredWidth	()I
    //   649: istore 6
    //   651: aload 12
    //   653: iconst_0
    //   654: iconst_0
    //   655: iload 6
    //   657: aload 12
    //   659: invokevirtual 734	android/widget/TextView:getMeasuredHeight	()I
    //   662: invokevirtual 738	android/widget/TextView:layout	(IIII)V
    //   665: invokestatic 306	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   668: ifeq +33 -> 701
    //   671: ldc 63
    //   673: iconst_2
    //   674: new 178	java/lang/StringBuilder
    //   677: dup
    //   678: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   681: ldc_w 832
    //   684: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: aload 12
    //   689: invokevirtual 743	android/widget/TextView:getLineHeight	()I
    //   692: invokevirtual 561	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   695: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   698: invokestatic 325	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   701: aload 12
    //   703: invokevirtual 746	android/widget/TextView:getLineCount	()I
    //   706: ifne +280 -> 986
    //   709: aload 12
    //   711: ldc_w 747
    //   714: aload 12
    //   716: invokevirtual 743	android/widget/TextView:getLineHeight	()I
    //   719: i2f
    //   720: fsub
    //   721: ldc_w 833
    //   724: invokevirtual 752	android/widget/TextView:setLineSpacing	(FF)V
    //   727: new 492	android/graphics/Canvas
    //   730: dup
    //   731: aload 10
    //   733: invokespecial 495	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   736: astore 8
    //   738: new 754	android/graphics/Matrix
    //   741: dup
    //   742: invokespecial 755	android/graphics/Matrix:<init>	()V
    //   745: astore 9
    //   747: iconst_1
    //   748: iload 7
    //   750: if_icmpne +310 -> 1060
    //   753: aload 9
    //   755: bipush 9
    //   757: newarray float
    //   759: dup
    //   760: iconst_0
    //   761: ldc_w 756
    //   764: fastore
    //   765: dup
    //   766: iconst_1
    //   767: fconst_0
    //   768: fastore
    //   769: dup
    //   770: iconst_2
    //   771: fconst_0
    //   772: fastore
    //   773: dup
    //   774: iconst_3
    //   775: fconst_0
    //   776: fastore
    //   777: dup
    //   778: iconst_4
    //   779: fconst_1
    //   780: fastore
    //   781: dup
    //   782: iconst_5
    //   783: fconst_0
    //   784: fastore
    //   785: dup
    //   786: bipush 6
    //   788: fconst_0
    //   789: fastore
    //   790: dup
    //   791: bipush 7
    //   793: fconst_0
    //   794: fastore
    //   795: dup
    //   796: bipush 8
    //   798: fconst_1
    //   799: fastore
    //   800: invokevirtual 760	android/graphics/Matrix:setValues	([F)V
    //   803: aload 9
    //   805: fload_2
    //   806: fconst_0
    //   807: invokevirtual 764	android/graphics/Matrix:postTranslate	(FF)Z
    //   810: pop
    //   811: iconst_m1
    //   812: istore 5
    //   814: aload 9
    //   816: iload 5
    //   818: i2f
    //   819: fload_2
    //   820: iload 6
    //   822: i2f
    //   823: fsub
    //   824: fmul
    //   825: fconst_2
    //   826: fdiv
    //   827: fload_0
    //   828: fadd
    //   829: fload_1
    //   830: iload 4
    //   832: i2f
    //   833: fsub
    //   834: invokevirtual 764	android/graphics/Matrix:postTranslate	(FF)Z
    //   837: pop
    //   838: aload 8
    //   840: aload 9
    //   842: invokevirtual 768	android/graphics/Canvas:setMatrix	(Landroid/graphics/Matrix;)V
    //   845: aload 12
    //   847: aload 8
    //   849: invokevirtual 772	android/widget/TextView:draw	(Landroid/graphics/Canvas;)V
    //   852: aload 10
    //   854: areturn
    //   855: astore 8
    //   857: invokestatic 306	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   860: ifeq +33 -> 893
    //   863: ldc 63
    //   865: iconst_2
    //   866: new 178	java/lang/StringBuilder
    //   869: dup
    //   870: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   873: ldc_w 779
    //   876: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: aload 8
    //   881: invokevirtual 505	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   884: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   887: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   890: invokestatic 325	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   893: aconst_null
    //   894: areturn
    //   895: astore 8
    //   897: invokestatic 306	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   900: ifeq +33 -> 933
    //   903: ldc 63
    //   905: iconst_2
    //   906: new 178	java/lang/StringBuilder
    //   909: dup
    //   910: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   913: ldc_w 779
    //   916: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   919: aload 8
    //   921: invokevirtual 512	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   924: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   927: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   930: invokestatic 325	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   933: aconst_null
    //   934: areturn
    //   935: astore 13
    //   937: aload 8
    //   939: astore 9
    //   941: invokestatic 306	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   944: ifeq -436 -> 508
    //   947: ldc 63
    //   949: iconst_2
    //   950: aload 13
    //   952: invokevirtual 505	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   955: invokestatic 325	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   958: aload 8
    //   960: astore 9
    //   962: goto -454 -> 508
    //   965: astore 9
    //   967: ldc 63
    //   969: iconst_1
    //   970: aload 9
    //   972: iconst_0
    //   973: anewarray 4	java/lang/Object
    //   976: invokestatic 782	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   979: aload 8
    //   981: astore 9
    //   983: goto -475 -> 508
    //   986: aload 12
    //   988: iload 4
    //   990: i2f
    //   991: fload_3
    //   992: fadd
    //   993: aload 12
    //   995: invokevirtual 746	android/widget/TextView:getLineCount	()I
    //   998: i2f
    //   999: fdiv
    //   1000: aload 12
    //   1002: invokevirtual 743	android/widget/TextView:getLineHeight	()I
    //   1005: i2f
    //   1006: fsub
    //   1007: ldc_w 833
    //   1010: invokevirtual 752	android/widget/TextView:setLineSpacing	(FF)V
    //   1013: goto -286 -> 727
    //   1016: astore 8
    //   1018: invokestatic 306	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1021: ifeq +14 -> 1035
    //   1024: ldc 63
    //   1026: iconst_2
    //   1027: aload 8
    //   1029: invokevirtual 505	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   1032: invokestatic 325	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1035: aconst_null
    //   1036: astore 8
    //   1038: goto -300 -> 738
    //   1041: astore 8
    //   1043: invokestatic 306	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1046: ifeq +12 -> 1058
    //   1049: ldc 63
    //   1051: iconst_2
    //   1052: ldc_w 823
    //   1055: invokestatic 325	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1058: aconst_null
    //   1059: areturn
    //   1060: iconst_1
    //   1061: istore 5
    //   1063: goto -249 -> 814
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1066	0	paramFloat1	float
    //   0	1066	1	paramFloat2	float
    //   0	1066	2	paramFloat3	float
    //   0	1066	3	paramFloat4	float
    //   0	1066	4	paramInt1	int
    //   0	1066	5	paramInt2	int
    //   0	1066	6	paramInt3	int
    //   0	1066	7	paramInt4	int
    //   0	1066	8	paramString1	String
    //   0	1066	9	paramString2	String
    //   0	1066	10	paramString3	String
    //   0	1066	11	paramInt5	int
    //   242	759	12	localObject	Object
    //   486	16	13	arrayOfByte	byte[]
    //   935	16	13	localOutOfMemoryError	OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   322	334	855	java/lang/OutOfMemoryError
    //   338	355	855	java/lang/OutOfMemoryError
    //   322	334	895	java/lang/Exception
    //   338	355	895	java/lang/Exception
    //   451	459	935	java/lang/OutOfMemoryError
    //   474	488	935	java/lang/OutOfMemoryError
    //   497	508	935	java/lang/OutOfMemoryError
    //   451	459	965	java/lang/Throwable
    //   474	488	965	java/lang/Throwable
    //   497	508	965	java/lang/Throwable
    //   727	738	1016	java/lang/OutOfMemoryError
    //   727	738	1041	java/lang/Exception
  }
  
  @Keep
  public static void driveFirstFrame(long paramLong)
  {
    QLog.d("sava_ApolloRender", 1, "FrameRecorder driveFirstFrame");
    ApolloTicker localApolloTicker = getApolloTicker(paramLong);
    if (localApolloTicker != null) {
      localApolloTicker.nativeCallbackTicker(paramLong, System.currentTimeMillis(), 0.01666666666666667D);
    }
  }
  
  @Keep
  public static void driveForOffScreen(long paramLong, float paramFloat)
  {
    QLog.e("sava_ApolloRender", 1, "FrameRecorder, java driveForOffScreen, ticker=" + paramLong + ", interval=" + paramFloat);
    ApolloRender localApolloRender = getRenderByThreadId();
    ApolloTicker localApolloTicker = getApolloTicker(paramLong);
    if ((localApolloTicker != null) && (localApolloRender != null) && (localApolloRender.getSavaWrapper() != null))
    {
      localApolloTicker.setOffscreenFrameInterval(paramFloat);
      localApolloTicker.driveOffScreenFrame(localApolloRender.getSavaWrapper().jdField_a_of_type_Long);
    }
  }
  
  public static byte[] encryptTEA(byte[] paramArrayOfByte)
  {
    if (amme.jdField_c_of_type_JavaLangString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("sava_ApolloRender", 2, "encryptTEA but stkey = null,return null");
      }
      return null;
    }
    return new Cryptor().encrypt(paramArrayOfByte, amme.jdField_c_of_type_JavaLangString.getBytes());
  }
  
  private void exeEngineJs(boolean paramBoolean)
  {
    if (TextUtils.isEmpty(amme.d)) {
      amme.f();
    }
    Iterator localIterator;
    if ((paramBoolean) || (TextUtils.isEmpty(amme.d)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("sava_ApolloRender", 2, "setupDirector load so script");
      }
      localIterator = amme.a.entrySet().iterator();
    }
    while (localIterator.hasNext())
    {
      String str = (String)((Map.Entry)localIterator.next()).getValue();
      this.mSavaWrapper.a(str);
      continue;
      this.mSavaWrapper.a(amme.d);
      if (QLog.isColorLevel()) {
        anmj.b("exeBase");
      }
    }
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
  
  private static ApolloTicker getApolloTicker(long paramLong)
  {
    Object localObject = getRenderByThreadId();
    if (localObject != null) {
      return ((ApolloRender)localObject).mApolloTicker;
    }
    localObject = (WeakReference)sTickerMap.get(Long.valueOf(Thread.currentThread().getId()));
    if (localObject != null) {
      return (ApolloTicker)((WeakReference)localObject).get();
    }
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
    Object localObject = amwn.a(Thread.currentThread().getId());
    int i = j;
    if (localObject != null)
    {
      localObject = ((amyo)localObject).a();
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
      adai.a();
      getLocationDoLocation((View)localObject, adai.a(localActivity, 5, paramString), paramLong, paramInt, paramString);
      i = 0;
    }
    getLocationLogin(paramLong, paramInt, paramString);
  }
  
  public static void getLocationCity(View paramView, adad paramadad, long paramLong, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
  {
    paramadad.a("getCity", null, new amnp(paramView, paramadad, paramLong, paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6));
  }
  
  public static void getLocationDoLocation(View paramView, adad paramadad, long paramLong, int paramInt, String paramString)
  {
    paramadad.a("getLocation", null, new amnq(paramView, paramadad, paramLong, paramInt));
  }
  
  public static void getLocationLogin(long paramLong, int paramInt, String paramString)
  {
    View localView = getRenderViewByThreadId();
    if (localView == null) {
      return;
    }
    Object localObject = (Activity)localView.getContext();
    adai.a();
    localObject = adai.a((Activity)localObject, 5, paramString);
    ((adad)localObject).a("login", null, new amnr(localView, (adad)localObject, paramLong, paramInt, paramString));
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
      localStringBuilder.append(anka.jdField_a_of_type_JavaLangString);
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
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo");
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
      localObject = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/" + ((ApolloRender)localObject).mGameId + "/sandbox");
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
      File localFile = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/" + paramInt + "/sandbox");
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return localFile.getAbsolutePath() + "/" + paramString;
    }
    return "NOT_SAND_PATH";
  }
  
  public static byte[] getTEASt()
  {
    if (amme.jdField_b_of_type_JavaLangString == null) {
      return null;
    }
    return HexUtil.hexStr2Bytes(amme.jdField_b_of_type_JavaLangString);
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
        int i = (int)(2.0F * DeviceInfoUtil.density);
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
        float f = (float)(d * 1.0D / DeviceInfoUtil.density);
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
      int i = (int)(2.0F * DeviceInfoUtil.density);
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
    float f = (float)(paramInt1 * 1.0D / DeviceInfoUtil.density);
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
    Object localObject = amwn.a();
    long l = 0L;
    if (localObject != null) {
      l = ((AppInterface)localObject).getLongAccountUin();
    }
    localObject = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/storage/" + l);
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
    ThreadManager.post(new ApolloRender.10(paramString2, paramString1, paramArrayOfString, new amnt(localView, paramLong), paramBoolean, paramString3, paramString4, paramString5), 5, null, true);
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
    ThreadManager.post(new ApolloRender.8(paramString2, paramString1, paramArrayOfByte, paramArrayOfString, new amns(paramString3, paramLong)), 5, null, true);
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
    localObject = ((Class)localObject).getDeclaredMethod(paramString1, amwn.a(paramString2)).getReturnType();
    paramString2 = amwn.a(paramString2);
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
    //   0: new 455	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 456	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: iconst_1
    //   10: putfield 459	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   13: aload_2
    //   14: iconst_0
    //   15: putfield 462	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   18: aload_2
    //   19: getstatic 468	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   22: putfield 471	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   25: aload_0
    //   26: aload_2
    //   27: invokestatic 933	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   30: astore_3
    //   31: aload_3
    //   32: invokevirtual 483	android/graphics/Bitmap:getWidth	()I
    //   35: aload_3
    //   36: invokevirtual 486	android/graphics/Bitmap:getHeight	()I
    //   39: getstatic 468	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   42: invokestatic 490	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   45: astore_0
    //   46: aload_0
    //   47: astore_2
    //   48: new 492	android/graphics/Canvas
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 495	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   56: astore 4
    //   58: aload_0
    //   59: astore_2
    //   60: aload 4
    //   62: aload_3
    //   63: fconst_0
    //   64: fconst_0
    //   65: aconst_null
    //   66: invokevirtual 499	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   69: aload_0
    //   70: astore_2
    //   71: aload 4
    //   73: invokevirtual 502	android/graphics/Canvas:save	()I
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
    //   91: invokestatic 306	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq -14 -> 80
    //   97: aload_0
    //   98: astore_2
    //   99: ldc 63
    //   101: iconst_2
    //   102: aload_3
    //   103: invokevirtual 505	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   106: invokestatic 325	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: aload_0
    //   110: areturn
    //   111: aload_0
    //   112: astore_2
    //   113: aload_3
    //   114: invokevirtual 508	java/lang/Exception:printStackTrace	()V
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
  
  public static void locationEnd(View paramView, adad paramadad, long paramLong, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, String paramString1, int paramInt, String paramString2)
  {
    paramadad.b();
    ((ApolloSurfaceView)paramView).getRender().getSavaWrapper().a(paramLong, paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6, paramString1, paramInt, paramString2);
  }
  
  @Keep
  public static boolean onRecordFrame(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return anbo.a(paramLong, paramArrayOfByte, paramInt1, paramInt2, getRenderByThreadId());
  }
  
  @Keep
  public static boolean onRecordFrameEnd(long paramLong, boolean paramBoolean)
  {
    return anbo.a(paramLong, true);
  }
  
  @Keep
  public static boolean onRecordFrameStart(long paramLong, float paramFloat)
  {
    return anbo.a(paramLong, paramFloat);
  }
  
  public static void printNativeLog(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    amro localamro;
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
      localamro = amwn.a();
      if ((paramInt2 < 0) || (paramInt1 > 0))
      {
        paramString1 = ApolloUtil.e(paramString1);
        paramString2 = ApolloUtil.e(paramString2);
        paramString3 = ApolloUtil.e(paramString3);
        QLog.e("sava_native_log", 1, new Object[] { "level:", Integer.valueOf(paramInt1), ",code:", Integer.valueOf(paramInt2), ",info1:", paramString1, ",info2:", paramString2, ",info3:", paramString3 });
        if (localamro == null) {
          return;
        }
        localamro.a("sava_native_log", 2, new Object[] { "level:", Integer.valueOf(paramInt1), ",code:", Integer.valueOf(paramInt2), ",info1:", paramString1, ",info2:", paramString2, ",info3:", paramString3 });
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
      if (localamro != null) {
        localamro.a("sava_native_log", 1, new Object[] { "level:", Integer.valueOf(paramInt1), ",code:", Integer.valueOf(paramInt2), ",info1:", paramString1, ",info2:", paramString2, ",info3:", paramString3 });
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
    localApolloDevInfo.model = DeviceInfoUtil.getModel();
    localApolloDevInfo.platform = "android";
    localApolloDevInfo.version = DeviceInfoUtil.getDeviceOSVersion();
    localApolloDevInfo.QQVersion = DeviceInfoUtil.getQQVersion();
    localApolloDevInfo.pixelRatio = DeviceInfoUtil.getDesity();
    localApolloDevInfo.screenHeight = ((float)DeviceInfoUtil.getHeight());
    localApolloDevInfo.screenWidth = ((float)DeviceInfoUtil.getWidth());
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
    //   12: new 1480	java/io/ByteArrayOutputStream
    //   15: dup
    //   16: invokespecial 1481	java/io/ByteArrayOutputStream:<init>	()V
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
    //   34: invokevirtual 1487	java/io/InputStream:read	([B)I
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
    //   50: invokevirtual 1491	java/io/ByteArrayOutputStream:write	([BII)V
    //   53: goto -24 -> 29
    //   56: astore 4
    //   58: aload_3
    //   59: astore_2
    //   60: ldc 63
    //   62: iconst_1
    //   63: aload 4
    //   65: iconst_0
    //   66: anewarray 4	java/lang/Object
    //   69: invokestatic 782	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   72: aload_0
    //   73: ifnull +7 -> 80
    //   76: aload_0
    //   77: invokevirtual 1494	java/io/InputStream:close	()V
    //   80: aload 5
    //   82: astore_0
    //   83: aload_3
    //   84: ifnull -74 -> 10
    //   87: aload_3
    //   88: invokevirtual 1495	java/io/ByteArrayOutputStream:close	()V
    //   91: aconst_null
    //   92: areturn
    //   93: astore_0
    //   94: ldc 63
    //   96: iconst_1
    //   97: aload_0
    //   98: iconst_0
    //   99: anewarray 4	java/lang/Object
    //   102: invokestatic 782	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   105: aconst_null
    //   106: areturn
    //   107: aload_3
    //   108: astore_2
    //   109: aload_3
    //   110: invokevirtual 1498	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   113: astore 4
    //   115: aload 4
    //   117: astore_2
    //   118: aload_0
    //   119: ifnull +7 -> 126
    //   122: aload_0
    //   123: invokevirtual 1494	java/io/InputStream:close	()V
    //   126: aload_2
    //   127: astore_0
    //   128: aload_3
    //   129: ifnull -119 -> 10
    //   132: aload_3
    //   133: invokevirtual 1495	java/io/ByteArrayOutputStream:close	()V
    //   136: aload_2
    //   137: areturn
    //   138: astore_0
    //   139: ldc 63
    //   141: iconst_1
    //   142: aload_0
    //   143: iconst_0
    //   144: anewarray 4	java/lang/Object
    //   147: invokestatic 782	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   150: aload_2
    //   151: areturn
    //   152: astore_0
    //   153: ldc 63
    //   155: iconst_1
    //   156: aload_0
    //   157: iconst_0
    //   158: anewarray 4	java/lang/Object
    //   161: invokestatic 782	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   164: goto -38 -> 126
    //   167: astore_0
    //   168: ldc 63
    //   170: iconst_1
    //   171: aload_0
    //   172: iconst_0
    //   173: anewarray 4	java/lang/Object
    //   176: invokestatic 782	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   179: goto -99 -> 80
    //   182: astore_3
    //   183: aconst_null
    //   184: astore_2
    //   185: aload_0
    //   186: ifnull +7 -> 193
    //   189: aload_0
    //   190: invokevirtual 1494	java/io/InputStream:close	()V
    //   193: aload_2
    //   194: ifnull +7 -> 201
    //   197: aload_2
    //   198: invokevirtual 1495	java/io/ByteArrayOutputStream:close	()V
    //   201: aload_3
    //   202: athrow
    //   203: astore_0
    //   204: ldc 63
    //   206: iconst_1
    //   207: aload_0
    //   208: iconst_0
    //   209: anewarray 4	java/lang/Object
    //   212: invokestatic 782	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   215: goto -22 -> 193
    //   218: astore_0
    //   219: ldc 63
    //   221: iconst_1
    //   222: aload_0
    //   223: iconst_0
    //   224: anewarray 4	java/lang/Object
    //   227: invokestatic 782	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
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
    //   3: invokevirtual 1503	java/io/File:isDirectory	()Z
    //   6: ifeq +91 -> 97
    //   9: aload_2
    //   10: ldc_w 1042
    //   13: invokevirtual 595	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16: ifeq +40 -> 56
    //   19: aload_1
    //   20: invokevirtual 1504	java/io/File:getName	()Ljava/lang/String;
    //   23: astore_2
    //   24: aload_1
    //   25: invokevirtual 1508	java/io/File:listFiles	()[Ljava/io/File;
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
    //   56: new 178	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   63: aload_2
    //   64: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: getstatic 1511	java/io/File:separator	Ljava/lang/String;
    //   70: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_1
    //   74: invokevirtual 1504	java/io/File:getName	()Ljava/lang/String;
    //   77: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: astore_2
    //   84: goto -60 -> 24
    //   87: aload_0
    //   88: aload 5
    //   90: aload_2
    //   91: invokestatic 1513	com/tencent/mobileqq/apollo/ApolloRender:recursionZip	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;)V
    //   94: goto -45 -> 49
    //   97: sipush 4096
    //   100: newarray byte
    //   102: astore 6
    //   104: new 1515	java/io/BufferedInputStream
    //   107: dup
    //   108: new 1517	java/io/FileInputStream
    //   111: dup
    //   112: aload_1
    //   113: invokespecial 1520	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   116: invokespecial 1523	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   119: astore 5
    //   121: aload_2
    //   122: ldc_w 1042
    //   125: invokevirtual 595	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   128: ifeq +62 -> 190
    //   131: aload_1
    //   132: invokevirtual 1504	java/io/File:getName	()Ljava/lang/String;
    //   135: astore_1
    //   136: aload_0
    //   137: new 1525	java/util/zip/ZipEntry
    //   140: dup
    //   141: aload_1
    //   142: invokespecial 1526	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   145: invokevirtual 1532	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   148: aload 5
    //   150: aload 6
    //   152: invokevirtual 1487	java/io/InputStream:read	([B)I
    //   155: istore_3
    //   156: iload_3
    //   157: iconst_m1
    //   158: if_icmpeq +63 -> 221
    //   161: aload_0
    //   162: aload 6
    //   164: iconst_0
    //   165: iload_3
    //   166: invokevirtual 1533	java/util/zip/ZipOutputStream:write	([BII)V
    //   169: goto -21 -> 148
    //   172: astore_0
    //   173: invokestatic 306	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   176: ifeq +13 -> 189
    //   179: ldc 63
    //   181: iconst_2
    //   182: aload_0
    //   183: invokevirtual 505	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   186: invokestatic 325	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: return
    //   190: new 178	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   197: aload_2
    //   198: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: getstatic 1511	java/io/File:separator	Ljava/lang/String;
    //   204: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload_1
    //   208: invokevirtual 1504	java/io/File:getName	()Ljava/lang/String;
    //   211: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: astore_1
    //   218: goto -82 -> 136
    //   221: aload 5
    //   223: invokevirtual 1494	java/io/InputStream:close	()V
    //   226: return
    //   227: astore_0
    //   228: aload 5
    //   230: astore_1
    //   231: aload_1
    //   232: ifnull +7 -> 239
    //   235: aload_1
    //   236: invokevirtual 1494	java/io/InputStream:close	()V
    //   239: aload_0
    //   240: invokevirtual 508	java/lang/Exception:printStackTrace	()V
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
    if (paramGL10 == null) {}
    int i;
    do
    {
      return;
      i = amwn.a(getSavaWrapper().a());
    } while (-1 == i);
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
    ThreadManager.post(new ApolloRender.14(paramString1, paramString2, paramArrayOfString, paramArrayOfByte, new amni(localView, paramLong, paramString1, paramString2, localApolloRender), new amnj(localView, localApolloRender, paramLong), new amnk(localView, localApolloRender, paramLong)), 5, null, true);
  }
  
  public static void setAABBCallBack(ApolloRender paramApolloRender, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, String paramString1, String paramString2, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, int paramInt)
  {
    setAABBCallBack(paramApolloRender, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramString1, paramString2, null, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, paramFloat11, paramFloat12, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, paramInt);
  }
  
  public static void setAABBCallBack(ApolloRender paramApolloRender, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, String paramString1, String paramString2, String paramString3, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, float paramFloat16, float paramFloat17, float paramFloat18, float paramFloat19, float paramFloat20, int paramInt)
  {
    List localList;
    int i;
    if (paramApolloRender != null)
    {
      localList = paramApolloRender.mBoundingList;
      i = paramApolloRender.mBoundingList.size() - 1;
      if (i < 0) {
        break label189;
      }
      paramApolloRender = (amrm)localList.get(i);
      if (!paramApolloRender.jdField_a_of_type_JavaLangString.equals(paramString1)) {
        break label180;
      }
      if (paramInt != 0) {
        break label168;
      }
      paramApolloRender.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, paramFloat11, paramFloat12, paramFloat13, paramFloat14, paramFloat15, paramFloat16, paramFloat17, paramFloat18, paramFloat19, paramFloat20, paramString3);
    }
    label101:
    for (paramInt = 0;; paramInt = 1)
    {
      if (paramInt != 0) {
        localList.add(new amrm(paramString1, paramString2, paramString3, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, paramFloat11, paramFloat12, paramFloat13, paramFloat14, paramFloat15, paramFloat16, paramFloat17, paramFloat18, paramFloat19, paramFloat20));
      }
      return;
      localList.remove(paramApolloRender);
      break label101;
      i -= 1;
      break;
    }
  }
  
  public static void setEditorBtnClick(ApolloSurfaceView paramApolloSurfaceView, ApolloRender paramApolloRender)
  {
    if (paramApolloRender.mEditorBtn != null) {
      paramApolloRender.mEditorBtn.setOnClickListener(new amnm(paramApolloRender, paramApolloSurfaceView));
    }
  }
  
  public static void setEditorWatcher(ApolloSurfaceView paramApolloSurfaceView, ApolloRender paramApolloRender)
  {
    if (paramApolloRender.mEditorPop != null) {
      paramApolloRender.mEditorPop.addTextChangedListener(new amnn(paramApolloSurfaceView, paramApolloRender));
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
        Object localObject = (RelativeLayout)LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(2131558691, null);
        paramApolloRender.mEditWindow.setContentView((View)localObject);
        paramApolloRender.mEditorPop = ((EditText)((RelativeLayout)localObject).findViewById(2131362776));
        ((RelativeLayout)localObject).requestLayout();
        ((RelativeLayout)localObject).post(new ApolloRender.18(paramApolloRender, (RelativeLayout)localObject));
        paramApolloRender.mEditorBtn = ((Button)((RelativeLayout)localObject).findViewById(2131362777));
        paramApolloRender.mEditorBtn.setWidth((int)(50.0F * DeviceInfoUtil.density));
        paramApolloRender.mEditWindow.setOutsideTouchable(false);
        paramApolloRender.mEditWindow.setFocusable(true);
        if (paramApolloRender.mEditorDefaultText != null)
        {
          paramApolloRender.mEditorPop.setText(paramApolloRender.mEditorDefaultText);
          paramApolloRender.mEditorPop.setSelection(paramApolloRender.mEditorDefaultText.length());
        }
        localObject = BaseApplicationImpl.getContext().getResources().getDrawable(2130849853);
        paramApolloRender.mEditWindow.setBackgroundDrawable((Drawable)localObject);
      }
      setEditorWatcher((ApolloSurfaceView)paramView, paramApolloRender);
      setEditorBtnClick((ApolloSurfaceView)paramView, paramApolloRender);
      i = (int)(55.0F * DeviceInfoUtil.density);
      if (paramApolloRender.mEditWindow != null)
      {
        paramApolloRender.mEditWindow.setWidth(-1);
        paramApolloRender.mEditWindow.setHeight(i);
      }
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
          break label207;
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
    anmj.a("setupDirector_mPreLoadFlag");
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
      this.mSavaWrapper.a(0L, 0, 0, this.mScale, 0, amme.a());
    }
    for (;;)
    {
      QLog.i("sava_ApolloRender", 1, "TraceReport CmShowStatUtil setupDirector createGLContext:");
      this.mSavaWrapper.a(this.mScale);
      anmj.b("setupDirector_mPreLoadFlag");
      return;
      this.mSavaWrapper.a(0L, 0, 0, this.mScale);
    }
    label207:
    this.mSavaWrapper.a(0L, 0, 0, this.mScale, 0, amme.a());
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
      localView.getViewTreeObserver().addOnGlobalLayoutListener(new amno(localApolloRender, localView));
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
        QQToast.a(localBaseActivity, paramString, i).a();
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
      Object localObject = amwn.a(paramInt1);
      if (localObject == null)
      {
        amwn.a().callbackFromRequest(paramLong, 3, "cs.xy_device_gyro_sensor_start.local", "{}");
        return;
      }
      localObject = ((amyo)localObject).a();
      if (localObject == null)
      {
        amwn.a().callbackFromRequest(paramLong, 3, "cs.xy_device_gyro_sensor_start.local", "{}");
        return;
      }
      localObject = ((Activity)localObject).getBaseContext();
      if (localObject == null)
      {
        amwn.a().callbackFromRequest(paramLong, 3, "cs.xy_device_gyro_sensor_start.local", "{}");
        QLog.e("sava_ApolloRender", 1, "context is null");
        return;
      }
      mGyroSensorEventListener = new amzv((Context)localObject, paramLong, paramInt2);
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
    FaceStatus[] arrayOfFaceStatus = localApolloRender.mDetector.doTrack(paramArrayOfByte, paramInt1, paramInt2, true);
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
    //   8: ldc_w 2048
    //   11: invokevirtual 777	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +7 -> 21
    //   17: iconst_0
    //   18: istore_3
    //   19: iload_3
    //   20: ireturn
    //   21: new 1517	java/io/FileInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 2049	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   29: astore 7
    //   31: new 2051	com/tencent/commonsdk/zip/QZipInputStream
    //   34: dup
    //   35: new 1515	java/io/BufferedInputStream
    //   38: dup
    //   39: aload 7
    //   41: invokespecial 1523	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   44: invokespecial 2052	com/tencent/commonsdk/zip/QZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   47: astore 8
    //   49: aload 8
    //   51: invokevirtual 2056	com/tencent/commonsdk/zip/QZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   54: astore_0
    //   55: aload_0
    //   56: ifnull +309 -> 365
    //   59: ldc_w 2058
    //   62: new 178	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   69: ldc_w 2060
    //   72: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_0
    //   76: invokevirtual 1321	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 2064	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   85: pop
    //   86: aload_0
    //   87: invokevirtual 2065	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   90: astore_0
    //   91: new 178	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   98: aload_1
    //   99: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: getstatic 1511	java/io/File:separator	Ljava/lang/String;
    //   105: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload_0
    //   109: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: astore 5
    //   117: aload_0
    //   118: ifnull -69 -> 49
    //   121: aload_0
    //   122: ldc_w 2048
    //   125: invokevirtual 777	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   128: ifne -79 -> 49
    //   131: aload 5
    //   133: ldc_w 2048
    //   136: invokevirtual 777	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   139: ifne -90 -> 49
    //   142: new 1102	java/io/File
    //   145: dup
    //   146: new 178	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   153: aload_1
    //   154: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: getstatic 1511	java/io/File:separator	Ljava/lang/String;
    //   160: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload_0
    //   164: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokespecial 1108	java/io/File:<init>	(Ljava/lang/String;)V
    //   173: astore_0
    //   174: new 1102	java/io/File
    //   177: dup
    //   178: aload_0
    //   179: invokevirtual 2068	java/io/File:getParent	()Ljava/lang/String;
    //   182: invokespecial 1108	java/io/File:<init>	(Ljava/lang/String;)V
    //   185: astore 5
    //   187: aload 5
    //   189: invokevirtual 1111	java/io/File:exists	()Z
    //   192: ifne +9 -> 201
    //   195: aload 5
    //   197: invokevirtual 1114	java/io/File:mkdirs	()Z
    //   200: pop
    //   201: sipush 4096
    //   204: newarray byte
    //   206: astore 6
    //   208: new 2070	java/io/FileOutputStream
    //   211: dup
    //   212: aload_0
    //   213: invokespecial 2071	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   216: astore_0
    //   217: new 2073	java/io/BufferedOutputStream
    //   220: dup
    //   221: aload_0
    //   222: sipush 4096
    //   225: invokespecial 2076	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   228: astore 5
    //   230: aload 8
    //   232: aload 6
    //   234: iconst_0
    //   235: sipush 4096
    //   238: invokevirtual 2079	com/tencent/commonsdk/zip/QZipInputStream:read	([BII)I
    //   241: istore_2
    //   242: iload_2
    //   243: iconst_m1
    //   244: if_icmpeq +67 -> 311
    //   247: aload 5
    //   249: aload 6
    //   251: iconst_0
    //   252: iload_2
    //   253: invokevirtual 2080	java/io/BufferedOutputStream:write	([BII)V
    //   256: goto -26 -> 230
    //   259: astore_0
    //   260: invokestatic 306	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   263: ifeq +13 -> 276
    //   266: ldc 63
    //   268: iconst_2
    //   269: aload_0
    //   270: invokevirtual 505	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   273: invokestatic 325	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   276: iconst_1
    //   277: istore_2
    //   278: aload 7
    //   280: invokevirtual 2081	java/io/FileInputStream:close	()V
    //   283: aload 8
    //   285: invokevirtual 2082	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   288: iload_2
    //   289: ireturn
    //   290: astore_0
    //   291: iload_2
    //   292: istore_3
    //   293: invokestatic 306	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   296: ifeq -277 -> 19
    //   299: ldc 63
    //   301: iconst_2
    //   302: aload_0
    //   303: invokevirtual 505	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   306: invokestatic 325	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   309: iload_2
    //   310: ireturn
    //   311: aload 5
    //   313: invokevirtual 2085	java/io/BufferedOutputStream:flush	()V
    //   316: aload 5
    //   318: invokevirtual 2086	java/io/BufferedOutputStream:close	()V
    //   321: aload_0
    //   322: invokevirtual 2087	java/io/FileOutputStream:close	()V
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
    //   343: invokevirtual 2087	java/io/FileOutputStream:close	()V
    //   346: aload 4
    //   348: ifnull +8 -> 356
    //   351: aload 4
    //   353: invokevirtual 2086	java/io/BufferedOutputStream:close	()V
    //   356: aload_0
    //   357: invokevirtual 508	java/lang/Exception:printStackTrace	()V
    //   360: iconst_0
    //   361: istore_2
    //   362: goto -84 -> 278
    //   365: iconst_1
    //   366: istore_2
    //   367: goto -89 -> 278
    //   370: astore_0
    //   371: aload_0
    //   372: invokevirtual 508	java/lang/Exception:printStackTrace	()V
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
    Object localObject = amwn.a(paramInt1);
    if (localObject == null) {
      return;
    }
    localObject = ((amyo)localObject).a();
    if (localObject == null)
    {
      amwn.a().callbackFromRequest(paramLong, 1, "cs.xy_device_vibrate.local", "{}");
      return;
    }
    localObject = (Vibrator)((Activity)localObject).getSystemService("vibrator");
    if (localObject == null)
    {
      QLog.e("sava_ApolloRender", 1, "Vibrator service is null");
      amwn.a().callbackFromRequest(paramLong, 2, "cs.xy_device_vibrate.local", "{}");
      return;
    }
    if (!((Vibrator)localObject).hasVibrator())
    {
      amwn.a().callbackFromRequest(paramLong, 3, "cs.xy_device_vibrate.local", "{}");
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
      amwn.a().callbackFromRequest(paramLong, 0, "cs.xy_device_vibrate.local", "{}");
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
          if (((amrj)localApolloRender.mNioList.get(i)).jdField_a_of_type_Long == paramLong)
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
  
  /* Error */
  public static int websocketConnect(long paramLong, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: invokestatic 331	com/tencent/mobileqq/apollo/ApolloRender:getRenderByThreadId	()Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   3: astore 11
    //   5: getstatic 219	com/tencent/mobileqq/apollo/ApolloRender:mSSLSocketMap	Ljava/util/Map;
    //   8: lload_0
    //   9: invokestatic 438	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   12: invokeinterface 444 2 0
    //   17: checkcast 2101	javax/net/ssl/SSLSocket
    //   20: astore 8
    //   22: invokestatic 980	com/tencent/mobileqq/apollo/ApolloRender:getRenderViewByThreadId	()Landroid/view/View;
    //   25: ifnonnull +16 -> 41
    //   28: ldc 63
    //   30: ldc_w 2119
    //   33: invokestatic 2121	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   36: pop
    //   37: iconst_m1
    //   38: istore_3
    //   39: iload_3
    //   40: ireturn
    //   41: aload 8
    //   43: ifnonnull +173 -> 216
    //   46: new 2123	java/net/InetSocketAddress
    //   49: dup
    //   50: aload_2
    //   51: iload_3
    //   52: invokespecial 2126	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   55: astore 12
    //   57: aconst_null
    //   58: astore 9
    //   60: aconst_null
    //   61: astore 8
    //   63: invokestatic 2132	java/nio/channels/SocketChannel:open	()Ljava/nio/channels/SocketChannel;
    //   66: astore 10
    //   68: aload 10
    //   70: astore 8
    //   72: aload 10
    //   74: astore 9
    //   76: aload 10
    //   78: iconst_0
    //   79: invokevirtual 2136	java/nio/channels/SocketChannel:configureBlocking	(Z)Ljava/nio/channels/SelectableChannel;
    //   82: pop
    //   83: aload 10
    //   85: astore 8
    //   87: aload 10
    //   89: astore 9
    //   91: aload 10
    //   93: aload 12
    //   95: invokevirtual 2140	java/nio/channels/SocketChannel:connect	(Ljava/net/SocketAddress;)Z
    //   98: pop
    //   99: aload 10
    //   101: astore 8
    //   103: aload 10
    //   105: astore 9
    //   107: new 2110	amrj
    //   110: dup
    //   111: lload_0
    //   112: aload_2
    //   113: iload_3
    //   114: iload 4
    //   116: aload 6
    //   118: aload 7
    //   120: aload 10
    //   122: invokespecial 2143	amrj:<init>	(JLjava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/nio/channels/SocketChannel;)V
    //   125: astore_2
    //   126: aload 10
    //   128: astore 8
    //   130: aload 10
    //   132: astore 9
    //   134: aload 11
    //   136: getfield 237	com/tencent/mobileqq/apollo/ApolloRender:mNioList	Ljava/util/List;
    //   139: aload_2
    //   140: invokeinterface 1690 2 0
    //   145: pop
    //   146: aload 10
    //   148: ifnull +8 -> 156
    //   151: aload 10
    //   153: invokevirtual 2144	java/nio/channels/SocketChannel:close	()V
    //   156: iconst_0
    //   157: ireturn
    //   158: astore_2
    //   159: aload 8
    //   161: astore 9
    //   163: ldc 63
    //   165: iconst_2
    //   166: iconst_2
    //   167: anewarray 4	java/lang/Object
    //   170: dup
    //   171: iconst_0
    //   172: ldc_w 2146
    //   175: aastore
    //   176: dup
    //   177: iconst_1
    //   178: aload_2
    //   179: invokevirtual 2147	java/io/IOException:getMessage	()Ljava/lang/String;
    //   182: aastore
    //   183: invokestatic 1403	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   186: iconst_0
    //   187: istore_3
    //   188: aload 8
    //   190: ifnull -151 -> 39
    //   193: aload 8
    //   195: invokevirtual 2144	java/nio/channels/SocketChannel:close	()V
    //   198: iconst_0
    //   199: ireturn
    //   200: astore_2
    //   201: iconst_0
    //   202: ireturn
    //   203: astore_2
    //   204: aload 9
    //   206: ifnull +8 -> 214
    //   209: aload 9
    //   211: invokevirtual 2144	java/nio/channels/SocketChannel:close	()V
    //   214: aload_2
    //   215: athrow
    //   216: ldc 63
    //   218: iconst_2
    //   219: ldc_w 2149
    //   222: invokestatic 325	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   225: iconst_0
    //   226: ireturn
    //   227: astore_2
    //   228: goto -72 -> 156
    //   231: astore 6
    //   233: goto -19 -> 214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	paramLong	long
    //   0	236	2	paramString1	String
    //   0	236	3	paramInt1	int
    //   0	236	4	paramInt2	int
    //   0	236	5	paramInt3	int
    //   0	236	6	paramString2	String
    //   0	236	7	paramString3	String
    //   20	174	8	localObject1	Object
    //   58	152	9	localObject2	Object
    //   66	86	10	localSocketChannel	SocketChannel
    //   3	132	11	localApolloRender	ApolloRender
    //   55	39	12	localInetSocketAddress	java.net.InetSocketAddress
    // Exception table:
    //   from	to	target	type
    //   63	68	158	java/io/IOException
    //   76	83	158	java/io/IOException
    //   91	99	158	java/io/IOException
    //   107	126	158	java/io/IOException
    //   134	146	158	java/io/IOException
    //   193	198	200	java/lang/Throwable
    //   63	68	203	finally
    //   76	83	203	finally
    //   91	99	203	finally
    //   107	126	203	finally
    //   134	146	203	finally
    //   163	186	203	finally
    //   151	156	227	java/lang/Throwable
    //   209	214	231	java/lang/Throwable
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
        paramString1.close();
        return 0;
      }
      paramString1.setUseClientMode(true);
      paramString1.setKeepAlive(true);
      if ((paramString3 != null) && (!paramString3.equals(""))) {
        paramString1.setEnabledProtocols(new String[] { paramString3 });
      }
      paramString1.addHandshakeCompletedListener(new amnl(localView, paramLong));
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
    //   39: getstatic 468	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   42: invokestatic 490	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   45: astore 7
    //   47: aload 7
    //   49: aload 6
    //   51: invokestatic 2242	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   54: invokevirtual 2245	android/graphics/Bitmap:copyPixelsFromBuffer	(Ljava/nio/Buffer;)V
    //   57: invokestatic 331	com/tencent/mobileqq/apollo/ApolloRender:getRenderByThreadId	()Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   60: astore_0
    //   61: aload_0
    //   62: ifnull +10 -> 72
    //   65: aload_0
    //   66: invokevirtual 863	com/tencent/mobileqq/apollo/ApolloRender:getSavaWrapper	()Lcom/tencent/mobileqq/apollo/ApolloEngine;
    //   69: ifnonnull +4 -> 73
    //   72: return
    //   73: aload_0
    //   74: invokevirtual 863	com/tencent/mobileqq/apollo/ApolloRender:getSavaWrapper	()Lcom/tencent/mobileqq/apollo/ApolloEngine;
    //   77: invokevirtual 1537	com/tencent/mobileqq/apollo/ApolloEngine:a	()J
    //   80: invokestatic 1540	amwn:a	(J)I
    //   83: aload_3
    //   84: invokestatic 2247	com/tencent/mobileqq/apollo/ApolloRender:getSandBoxPath	(ILjava/lang/String;)Ljava/lang/String;
    //   87: astore_0
    //   88: aload_0
    //   89: ifnull -17 -> 72
    //   92: new 1102	java/io/File
    //   95: dup
    //   96: aload_0
    //   97: invokespecial 1108	java/io/File:<init>	(Ljava/lang/String;)V
    //   100: astore_0
    //   101: aload_0
    //   102: invokevirtual 1111	java/io/File:exists	()Z
    //   105: ifeq +8 -> 113
    //   108: aload_0
    //   109: invokevirtual 2250	java/io/File:delete	()Z
    //   112: pop
    //   113: new 2070	java/io/FileOutputStream
    //   116: dup
    //   117: aload_0
    //   118: invokespecial 2071	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   121: astore_0
    //   122: aload_0
    //   123: astore 6
    //   125: aload_3
    //   126: ldc_w 1084
    //   129: invokevirtual 797	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   132: ifne +362 -> 494
    //   135: aload_0
    //   136: astore 6
    //   138: aload_3
    //   139: ldc_w 2252
    //   142: invokevirtual 797	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   145: ifne +349 -> 494
    //   148: aload_0
    //   149: astore 6
    //   151: aload_3
    //   152: ldc_w 2254
    //   155: invokevirtual 797	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   158: ifne +336 -> 494
    //   161: aload_0
    //   162: astore 6
    //   164: aload_3
    //   165: ldc_w 2256
    //   168: invokevirtual 797	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   171: ifeq +6 -> 177
    //   174: goto +320 -> 494
    //   177: aload_0
    //   178: astore 6
    //   180: iload 5
    //   182: invokestatic 2261	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   185: invokevirtual 2264	java/lang/Boolean:booleanValue	()Z
    //   188: ifeq +62 -> 250
    //   191: aload_0
    //   192: astore 6
    //   194: aload 7
    //   196: getstatic 2270	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   199: bipush 50
    //   201: aload_0
    //   202: invokevirtual 2274	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   205: ifeq +18 -> 223
    //   208: aload_0
    //   209: astore 6
    //   211: aload_0
    //   212: invokevirtual 2275	java/io/FileOutputStream:flush	()V
    //   215: aload_0
    //   216: astore 6
    //   218: aload 7
    //   220: invokevirtual 2278	android/graphics/Bitmap:recycle	()V
    //   223: aload_0
    //   224: ifnull -152 -> 72
    //   227: aload_0
    //   228: invokevirtual 2087	java/io/FileOutputStream:close	()V
    //   231: return
    //   232: astore_0
    //   233: invokestatic 306	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   236: ifeq -164 -> 72
    //   239: ldc 63
    //   241: iconst_2
    //   242: aload_0
    //   243: invokevirtual 505	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   246: invokestatic 325	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   249: return
    //   250: aload_0
    //   251: astore 6
    //   253: aload 7
    //   255: getstatic 2281	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   258: bipush 100
    //   260: aload_0
    //   261: invokevirtual 2274	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   264: ifeq -41 -> 223
    //   267: aload_0
    //   268: astore 6
    //   270: aload_0
    //   271: invokevirtual 2275	java/io/FileOutputStream:flush	()V
    //   274: aload_0
    //   275: astore 6
    //   277: aload 7
    //   279: invokevirtual 2278	android/graphics/Bitmap:recycle	()V
    //   282: goto -59 -> 223
    //   285: astore_3
    //   286: aload_3
    //   287: invokevirtual 2282	java/io/FileNotFoundException:printStackTrace	()V
    //   290: aload_0
    //   291: ifnull -219 -> 72
    //   294: aload_0
    //   295: invokevirtual 2087	java/io/FileOutputStream:close	()V
    //   298: return
    //   299: astore_0
    //   300: invokestatic 306	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   303: ifeq -231 -> 72
    //   306: ldc 63
    //   308: iconst_2
    //   309: aload_0
    //   310: invokevirtual 505	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   313: invokestatic 325	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   316: return
    //   317: astore_0
    //   318: aload_0
    //   319: invokevirtual 2283	java/io/IOException:printStackTrace	()V
    //   322: return
    //   323: astore_0
    //   324: aload_0
    //   325: invokevirtual 2283	java/io/IOException:printStackTrace	()V
    //   328: return
    //   329: astore_0
    //   330: aconst_null
    //   331: astore_0
    //   332: aload_0
    //   333: ifnull -261 -> 72
    //   336: aload_0
    //   337: invokevirtual 2087	java/io/FileOutputStream:close	()V
    //   340: return
    //   341: astore_0
    //   342: invokestatic 306	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   345: ifeq -273 -> 72
    //   348: ldc 63
    //   350: iconst_2
    //   351: aload_0
    //   352: invokevirtual 505	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   355: invokestatic 325	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   358: return
    //   359: astore_0
    //   360: aload_0
    //   361: invokevirtual 2283	java/io/IOException:printStackTrace	()V
    //   364: return
    //   365: astore_3
    //   366: aconst_null
    //   367: astore_0
    //   368: aload_0
    //   369: astore 6
    //   371: invokestatic 306	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   374: ifeq +16 -> 390
    //   377: aload_0
    //   378: astore 6
    //   380: ldc 63
    //   382: iconst_2
    //   383: aload_3
    //   384: invokevirtual 505	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   387: invokestatic 325	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   390: aload_0
    //   391: ifnull -319 -> 72
    //   394: aload_0
    //   395: invokevirtual 2087	java/io/FileOutputStream:close	()V
    //   398: return
    //   399: astore_0
    //   400: invokestatic 306	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   403: ifeq -331 -> 72
    //   406: ldc 63
    //   408: iconst_2
    //   409: aload_0
    //   410: invokevirtual 505	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   413: invokestatic 325	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   416: return
    //   417: astore_0
    //   418: aload_0
    //   419: invokevirtual 2283	java/io/IOException:printStackTrace	()V
    //   422: return
    //   423: astore_0
    //   424: aconst_null
    //   425: astore 6
    //   427: aload 6
    //   429: ifnull +8 -> 437
    //   432: aload 6
    //   434: invokevirtual 2087	java/io/FileOutputStream:close	()V
    //   437: aload_0
    //   438: athrow
    //   439: astore_3
    //   440: invokestatic 306	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   443: ifeq -6 -> 437
    //   446: ldc 63
    //   448: iconst_2
    //   449: aload_3
    //   450: invokevirtual 505	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   453: invokestatic 325	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   456: goto -19 -> 437
    //   459: astore_3
    //   460: aload_3
    //   461: invokevirtual 2283	java/io/IOException:printStackTrace	()V
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
    //   5: new 1528	java/util/zip/ZipOutputStream
    //   8: dup
    //   9: new 2070	java/io/FileOutputStream
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 2285	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   17: invokespecial 2286	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   20: astore 6
    //   22: aload 6
    //   24: astore_1
    //   25: new 1102	java/io/File
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 1108	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: astore_0
    //   34: aload_0
    //   35: ifnull +101 -> 136
    //   38: aload 6
    //   40: astore_1
    //   41: aload_0
    //   42: invokevirtual 1111	java/io/File:exists	()Z
    //   45: ifeq +91 -> 136
    //   48: aload 6
    //   50: astore_1
    //   51: aload_0
    //   52: invokevirtual 1503	java/io/File:isDirectory	()Z
    //   55: ifeq +69 -> 124
    //   58: aload 6
    //   60: astore_1
    //   61: aload_0
    //   62: invokevirtual 1508	java/io/File:listFiles	()[Ljava/io/File;
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
    //   85: ldc_w 1042
    //   88: invokestatic 1513	com/tencent/mobileqq/apollo/ApolloRender:recursionZip	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;)V
    //   91: goto +147 -> 238
    //   94: astore_0
    //   95: aload 6
    //   97: astore_1
    //   98: invokestatic 306	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   101: ifeq +16 -> 117
    //   104: aload 6
    //   106: astore_1
    //   107: ldc 63
    //   109: iconst_2
    //   110: aload_0
    //   111: invokevirtual 505	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   114: invokestatic 325	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   117: aload 6
    //   119: invokevirtual 2287	java/util/zip/ZipOutputStream:close	()V
    //   122: iload_3
    //   123: ireturn
    //   124: aload 6
    //   126: astore_1
    //   127: aload 6
    //   129: aload_0
    //   130: ldc_w 1042
    //   133: invokestatic 1513	com/tencent/mobileqq/apollo/ApolloRender:recursionZip	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;)V
    //   136: aload 6
    //   138: invokevirtual 2287	java/util/zip/ZipOutputStream:close	()V
    //   141: iconst_1
    //   142: ireturn
    //   143: astore_0
    //   144: iload 4
    //   146: istore_2
    //   147: iload_2
    //   148: istore_3
    //   149: invokestatic 306	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   152: ifeq -30 -> 122
    //   155: ldc 63
    //   157: iconst_2
    //   158: aload_0
    //   159: invokevirtual 505	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   162: invokestatic 325	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: iload_2
    //   166: ireturn
    //   167: astore_0
    //   168: aconst_null
    //   169: astore 6
    //   171: aload 6
    //   173: astore_1
    //   174: aload_0
    //   175: invokevirtual 508	java/lang/Exception:printStackTrace	()V
    //   178: aload 6
    //   180: invokevirtual 2287	java/util/zip/ZipOutputStream:close	()V
    //   183: iconst_0
    //   184: ireturn
    //   185: astore_0
    //   186: aconst_null
    //   187: astore_1
    //   188: aload_1
    //   189: invokevirtual 2287	java/util/zip/ZipOutputStream:close	()V
    //   192: aload_0
    //   193: athrow
    //   194: astore_0
    //   195: aload_0
    //   196: invokevirtual 508	java/lang/Exception:printStackTrace	()V
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
    ampw localampw;
    if (paramInt1 == 0) {
      if (this.mRenderCallbackRef != null)
      {
        localampw = (ampw)this.mRenderCallbackRef.get();
        if (localampw != null) {
          localampw.a(paramInt2, paramString);
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
        localampw = (ampw)this.mRenderCallbackRef.get();
      } while (localampw == null);
      localampw.a(paramInt2, 0, paramString);
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
      localStringBuilder.append(anka.I);
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
          localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo");
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
        localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo");
        localStringBuilder.append("/role/");
        break;
      }
      if (paramString1.startsWith("Dress:"))
      {
        str = paramString1.substring("Dress:".length() + "//".length());
        localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo");
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
        localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo");
        localStringBuilder.append("/extension/");
        break;
      }
      if (paramString1.startsWith("SlaveAction"))
      {
        str = paramString1.substring("SlaveAction".length() + "//".length());
        new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo", "slave");
        localStringBuilder.append(anka.jdField_a_of_type_JavaLangString).append("/def/role/0/script/slave/");
        break;
      }
      if (paramString1.startsWith("GameRes:"))
      {
        str = paramString1.substring("GameRes:".length() + "//".length());
        localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo");
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
        paramString2 = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/" + this.mGameId + "/sandbox");
        if (!paramString2.exists()) {
          paramString2.mkdirs();
        }
        return paramString2.getAbsolutePath() + "/" + paramString1;
      }
      if ((paramString1.contains("game")) || (paramString1.contains("def")))
      {
        localStringBuilder.append(anka.jdField_a_of_type_JavaLangString);
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
        localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo");
        localStringBuilder.append("/role/");
        break;
      }
      if (paramString1.startsWith("action"))
      {
        str = paramString1.substring("action/".length());
        localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo");
        localStringBuilder.append("/action/");
        break;
      }
      str = paramString1;
      if (!paramString1.startsWith("dress")) {
        break;
      }
      str = paramString1.substring("dress/".length());
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo");
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
  
  public boolean isOffscreen()
  {
    return this.mIsOffscreen;
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
      localObject2 = amwn.a();
      if (localObject2 != null)
      {
        localObject2 = ((AppInterface)localObject2).getCurrentAccountUin();
        StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance((String)localObject2, "light_game_draw_cost_report", true, 0L, 0L, localHashMap, "", true);
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
    if (this.mIsOffscreen)
    {
      if ((this.mApolloTicker != null) && (getSavaWrapper() != null)) {
        this.mApolloTicker.driveOffScreenFrame(getSavaWrapper().jdField_a_of_type_Long);
      }
      paramGL10 = getRenderViewByThreadId();
      if ((paramGL10 != null) && ((paramGL10 instanceof ApolloTextureView))) {
        this.mSavaWrapper.a(anhm.b());
      }
      if ((paramGL10 != null) && ((paramGL10 instanceof ApolloSurfaceView)) && (!((ApolloSurfaceView)paramGL10).isGameMode())) {
        this.mSavaWrapper.a(anhm.b());
      }
      if (!(paramGL10 instanceof ApolloSurfaceView)) {
        break label1365;
      }
    }
    label675:
    label687:
    label1076:
    label1365:
    for (paramGL10 = ((ApolloSurfaceView)paramGL10).getUIState();; paramGL10 = null)
    {
      if (this.mPreLoadFlag) {
        ??? = this.mOnDrawQueue;
      }
      Object localObject3;
      while (!((List)???).isEmpty())
      {
        if ((paramGL10 != null) && (paramGL10.get() != 0)) {
          break label248;
        }
        localObject3 = (IApolloRunnableTask)((List)???).remove(0);
        if (localObject3 != null)
        {
          this.mDrawTaskRunning = true;
          if (((IApolloRunnableTask)localObject3).a() == 4)
          {
            QLog.i("sava_ApolloRender", 1, "onDrawFrame2 dispose preload task continue");
            continue;
            ??? = this.mEventQueue;
          }
          else
          {
            System.currentTimeMillis();
            ((IApolloRunnableTask)localObject3).run();
            if ((((IApolloRunnableTask)localObject3).a()) && (this.mAddOnInitViewTask != null)) {
              this.mAddOnInitViewTask.run();
            }
            System.currentTimeMillis();
          }
        }
      }
      break;
      label248:
      QLog.e("sava_ApolloRender", 1, "onDrawFrame Runnable return ! UIState:" + paramGL10.get() + " runnableList:" + ((List)???).size());
      return;
      long l2 = System.currentTimeMillis();
      long l3 = l2 - this.lastFrame;
      this.lastFrame = l2;
      long l1;
      if ((BaseApplicationImpl.sProcessId != 1) || (!QLog.isColorLevel()))
      {
        l1 = System.currentTimeMillis();
        if (!this.mPreLoadFlag) {
          break label746;
        }
        if (!this.mEventQueue.isEmpty())
        {
          this.mOnDrawQueue.addAll(this.mEventQueue);
          this.mEventQueue.removeAll(this.mOnDrawQueue);
        }
      }
      for (;;)
      {
        synchronized (this.LOCK_PRELOAD_LIST)
        {
          if ((this.mDestroyed) || (this.mPreLoadQueue.isEmpty())) {
            break label743;
          }
          localObject3 = (IApolloRunnableTask)this.mPreLoadQueue.remove(0);
          if (localObject3 == null) {
            continue;
          }
          anmj.a("onDrawFrame" + ((IApolloRunnableTask)localObject3).a());
          if (!((IApolloRunnableTask)localObject3).b()) {
            break label687;
          }
          if (!this.mSavaWrapper.a(((IApolloRunnableTask)localObject3).a())) {
            break label675;
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
        this.mSavaWrapper.a(((IApolloRunnableTask)localObject3).a());
        if (((IApolloRunnableTask)localObject3).a() == 4)
        {
          QLog.i("sava_ApolloRender", 1, "onDrawFrame dispose preload task continue");
        }
        else
        {
          ((IApolloRunnableTask)localObject3).run();
          anmj.b("onDrawFrame" + ((IApolloRunnableTask)localObject3).a());
        }
      }
      label743:
      label746:
      View localView = getRenderViewByThreadId();
      if ((localView != null) && ((localView instanceof ApolloTextureView))) {
        this.mSavaWrapper.a(anhm.b());
      }
      boolean bool;
      if ((localView != null) && ((localView instanceof ApolloSurfaceView)))
      {
        bool = ((ApolloSurfaceView)localView).isGameMode();
        if (!bool) {
          this.mSavaWrapper.a(anhm.b());
        }
      }
      for (;;)
      {
        if ((localView instanceof ApolloSurfaceView)) {}
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
            break label1076;
          }
        }
        bool = false;
      }
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
        ??? = (ampy)this.mCallbackRef.get();
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
    anmj.b("onSurfaceCreated");
    long l1 = System.currentTimeMillis();
    long l2 = Thread.currentThread().getId();
    if ((WeakReference)sRenderMap.get(Long.valueOf(l2)) == null) {
      sRenderMap.put(Long.valueOf(l2), new WeakReference(this));
    }
    if ((WeakReference)sTickerMap.get(Long.valueOf(l2)) == null) {
      sTickerMap.put(Long.valueOf(l2), new WeakReference(this.mApolloTicker));
    }
    this.mGameId = amwn.a(getSavaWrapper().a());
    paramEGLConfig = amwn.a();
    boolean bool;
    if ((paramEGLConfig != null) && (this.mGameId > 0))
    {
      if (paramEGLConfig.getLongAccountUin() % 10L != 1L) {
        break label301;
      }
      bool = true;
    }
    for (;;)
    {
      this.mIsNeedReport = bool;
      setupDirector();
      if ((this.mApolloTicker != null) && (this.mSavaWrapper != null) && (this.mIsOffscreen)) {}
      try
      {
        this.mApolloTicker.nativeSetRecorderMode(this.mSavaWrapper.jdField_a_of_type_Long, true);
        this.mIsReadyNotify = false;
        paramEGLConfig = new int[1];
        paramGL10.glGetIntegerv(3379, paramEGLConfig, 0);
        QLog.i("sava_ApolloRender", 1, "onSurfaceCreated  GL_MAX_TEXTURE_SIZE: " + paramEGLConfig[0]);
        if (QLog.isColorLevel()) {
          QLog.d("sava_ApolloRender", 2, " TextureView onSurfaceCreated use:" + (System.currentTimeMillis() - l1));
        }
        reportDeviceInfoTo644(paramGL10);
        return;
        label301:
        bool = false;
      }
      catch (Throwable paramEGLConfig)
      {
        for (;;)
        {
          QLog.e("sava_ApolloRender", 1, "nativeSetRecorderMode error=", paramEGLConfig);
        }
      }
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
  
  public void setOffscreen(boolean paramBoolean)
  {
    this.mIsOffscreen = paramBoolean;
  }
  
  public void setQtaTestResult(String paramString)
  {
    qtaTestResult = paramString;
  }
  
  public void setRenderCallback(ampw paramampw)
  {
    this.mRenderCallbackRef = new WeakReference(paramampw);
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
  
  public void snapShotOnce(amnu paramamnu, int paramInt, long paramLong)
  {
    this.mSnapShotCallback = paramamnu;
    this.mSnapShot = true;
    this.mSnapShotSeq = paramLong;
    this.mCallBackCode = paramInt;
  }
  
  public void stopRecord(int paramInt, boolean paramBoolean)
  {
    QLog.d("sava_ApolloRender", 1, "FrameRecorder stopRecord");
    if (this.mSavaWrapper != null) {
      this.mSavaWrapper.a("stopFrameRecord(" + paramInt + "," + paramBoolean + ");");
    }
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
        amrj localamrj1;
        if ((i < 0) || (i < 0)) {
          continue;
        }
        localamrj2 = (amrj)this.mNioList.get(i);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        try
        {
          localamrj1 = (amrj)this.mNioList.get(i);
          if ((localamrj1 == null) || (localamrj1.jdField_c_of_type_Int == 1) || (!localamrj1.jdField_a_of_type_JavaNioChannelsSocketChannel.finishConnect())) {
            break label201;
          }
          localamrj1.jdField_c_of_type_Int = 1;
          getSavaWrapper().a(localamrj1.jdField_a_of_type_Long, 2);
          websocketShakeHand(localamrj1.jdField_a_of_type_Long, localamrj1.jdField_a_of_type_JavaLangString, localamrj1.jdField_a_of_type_Int, localamrj1.jdField_b_of_type_Int, 0, localamrj1.jdField_b_of_type_JavaLangString, localamrj1.jdField_c_of_type_JavaLangString, localamrj1.jdField_a_of_type_JavaNioChannelsSocketChannel.socket());
          this.mNioList.remove(localamrj1);
        }
        catch (Exception localException2)
        {
          int i;
          amrj localamrj2;
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
      getSavaWrapper().a(localamrj2.jdField_a_of_type_Long, 3);
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