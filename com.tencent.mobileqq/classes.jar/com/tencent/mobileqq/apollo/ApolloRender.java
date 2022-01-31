package com.tencent.mobileqq.apollo;

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
import android.location.LocationManager;
import android.net.Uri;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Handler;
import android.os.HandlerThread;
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
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.DoraemonOpenAPI;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.data.ApolloDevInfo;
import com.tencent.mobileqq.apollo.data.ApolloNioSocketInfo;
import com.tencent.mobileqq.apollo.data.ApolloSkeletonBounding;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.portal.StrokeTextView;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoPrefsUtil;
import com.tencent.ttpic.util.youtu.VideoFaceDetector;
import eipc.EIPCResultCallback;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.InputStream;
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
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import mqq.os.MqqHandler;
import yrc;
import yrd;
import yre;
import yrf;
import yrg;
import yrh;
import yri;
import yrj;
import yrk;
import yrl;
import yrm;
import yrn;
import yrp;
import yrq;
import yrr;
import yrs;
import yrt;
import yru;
import yrw;
import yrx;
import yrz;
import ysb;
import ysd;

public class ApolloRender
  implements GLSurfaceView.Renderer
{
  private static final String ACTION_RES_PREFIX = "ActionRes:";
  public static final int APOLLO_CMD_CHANNEL_CLASS = 2;
  public static final int APOLLO_RENDER_CLASS = 1;
  private static final String BASE_JS_PREFIX = "BaseJs:";
  public static String CMSHOW_FILE_PATH = AppConstants.aK + "cmshow";
  public static final int ENGINE_TYPE_ACTION = 0;
  public static final int ENGINE_TYPE_GAME = 1;
  public static final String GAME_RES_PREFIX = "GameRes:";
  public static final String GAME_SAND_BOX_PREFIX = "GameSandBox:";
  public static final String HTTP_COOKIE = "Cookie";
  public static final String HTTP_REFERER = "Referer";
  public static final int LONG_DRAW_COST = 100;
  public static final String POST_BODY = "Postbody";
  private static final String SLAVE_RES_PREFIX = "SlaveAction";
  public static final int SP_ATLAS_RGBA4444 = 4;
  public static final int SP_ATLAS_RGBA8888 = 6;
  public static final String TAG = "ApolloRender";
  private static File cmshow_photofile_file;
  private static int gLocationCurrentTimes;
  private static LocationManager gLocationManager;
  private static String gLocationProvider;
  private static int gLocationTotalTimes;
  private static long gNativeLocationManager;
  private static long g_imageselector;
  public static HandlerThread ht;
  private static int mBubbleType;
  public static Handler mDetectorThreadHandler = new Handler(ht.getLooper());
  static int max_image_height;
  static int max_image_width = 1024;
  public static boolean sIsDownLoadingSo;
  public static boolean sIsKeyBoardDissmiss;
  public static boolean sIsKeyBoardShow;
  public static HashMap sRenderMap;
  public static int sScreenMode;
  public boolean isRunning = true;
  long lastFrame;
  public ApolloTicker mApolloTicker;
  private WeakReference mApolloViewRef;
  public List mBoundingList = new CopyOnWriteArrayList();
  public HashMap mBufferinputMap = new HashMap();
  public HashMap mBufferoutputMap = new HashMap();
  private int mCallBackCode;
  private WeakReference mCallbackRef;
  public VideoFaceDetector mDetector;
  public double mDuration;
  public PopupWindow mEditWindow;
  public long mEditorAddr;
  public Button mEditorBtn;
  public String mEditorDefaultText;
  public EditText mEditorPop;
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
  private int mLongCostCount;
  public List mNioList = new ArrayList();
  private WeakReference mRenderCallbackRef;
  public HashMap mSSLSocketMap = new HashMap();
  private ApolloEngine mSavaWrapper = new ApolloEngine();
  private float mScale;
  public boolean mShowEditWindow;
  private boolean mSnapShot;
  private ApolloRender.ISnapShotCallback mSnapShotCallback;
  private long mSnapShotSeq;
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
    sRenderMap = new HashMap();
    ht = new HandlerThread("VideoPreviewFaceOutlineDetector");
    ht.start();
  }
  
  public ApolloRender(float paramFloat, OnApolloViewListener paramOnApolloViewListener, int paramInt)
  {
    float f = FontSettingManager.a() / 16.0F;
    if (f != 0.0F) {}
    for (this.mScale = (paramFloat / f);; this.mScale = paramFloat)
    {
      this.mType = paramInt;
      this.mCallbackRef = new WeakReference(paramOnApolloViewListener);
      this.mLock = ApolloActionManager.a().a();
      this.mApolloTicker = new ApolloTicker();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloRender", 2, "[ApolloRender] threadId:" + Thread.currentThread().getId());
      }
      return;
    }
  }
  
  public static void AABBCallback(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, String paramString, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, int paramInt)
  {
    Object localObject = getRenderByThreadId();
    List localList;
    int i;
    if (localObject != null)
    {
      localList = ((ApolloRender)localObject).mBoundingList;
      i = ((ApolloRender)localObject).mBoundingList.size() - 1;
      if (i < 0) {
        break label145;
      }
      localObject = (ApolloSkeletonBounding)localList.get(i);
      if (!((ApolloSkeletonBounding)localObject).jdField_a_of_type_JavaLangString.equals(paramString)) {
        break label136;
      }
      if (paramInt != 0) {
        break label123;
      }
      ((ApolloSkeletonBounding)localObject).a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8);
    }
    label85:
    for (paramInt = 0;; paramInt = 1)
    {
      if (paramInt != 0) {
        localList.add(new ApolloSkeletonBounding(paramString, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8));
      }
      return;
      label123:
      localList.remove(localObject);
      break label85;
      i -= 1;
      break;
    }
  }
  
  public static void callbackFromJniStatic(int paramInt1, int paramInt2, String paramString)
  {
    ApolloRender localApolloRender = getRenderByThreadId();
    if (localApolloRender == null) {
      return;
    }
    localApolloRender.callbackFromJni(paramInt1, paramInt2, paramString);
  }
  
  public static void createAIFaceDetector(long paramLong)
  {
    Object localObject = getRenderByThreadId();
    if ((!PtvFilterSoLoad.a(BaseApplicationImpl.getContext())) && (!sIsDownLoadingSo))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloRender", 2, "createAIFaceDetecor download");
      }
      localObject = new yrj((ApolloRender)localObject);
      QIPCClientHelper.getInstance().callServer("cm_game_module", "action_loadyoutu", null, (EIPCResultCallback)localObject);
    }
    do
    {
      return;
      VideoPrefsUtil.init(BaseApplicationImpl.getContext());
      VideoGlobalContext.setContext(BaseApplicationImpl.getContext());
    } while (!PtvFilterSoLoad.a(BaseApplicationImpl.getContext(), false));
    ((ApolloRender)localObject).mDetector = new VideoFaceDetector(PtvFilterSoLoad.a(BaseApplicationImpl.getContext(), null));
    ((ApolloRender)localObject).mDetector.init();
  }
  
  public static void createTicker(long paramLong)
  {
    ApolloRender localApolloRender = getRenderByThreadId();
    if (localApolloRender == null) {}
    while (localApolloRender.mApolloTicker == null) {
      return;
    }
    localApolloRender.mApolloTicker.createTicker(paramLong);
  }
  
  /* Error */
  public static Bitmap decodeGifBuffer(byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: new 400	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 401	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: iconst_1
    //   10: putfield 404	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   13: aload_2
    //   14: iconst_0
    //   15: putfield 407	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   18: aload_2
    //   19: getstatic 413	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   22: putfield 416	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   25: aload_0
    //   26: iconst_0
    //   27: iload_1
    //   28: aload_2
    //   29: invokestatic 422	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   32: astore_3
    //   33: aload_3
    //   34: invokevirtual 427	android/graphics/Bitmap:getWidth	()I
    //   37: aload_3
    //   38: invokevirtual 430	android/graphics/Bitmap:getHeight	()I
    //   41: getstatic 413	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   44: invokestatic 434	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   47: astore_0
    //   48: aload_0
    //   49: astore_2
    //   50: new 436	android/graphics/Canvas
    //   53: dup
    //   54: aload_0
    //   55: invokespecial 439	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   58: astore 4
    //   60: aload_0
    //   61: astore_2
    //   62: aload 4
    //   64: aload_3
    //   65: fconst_0
    //   66: fconst_0
    //   67: aconst_null
    //   68: invokevirtual 443	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   71: aload_0
    //   72: astore_2
    //   73: aload 4
    //   75: invokevirtual 446	android/graphics/Canvas:save	()I
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
    //   93: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   96: ifeq -14 -> 82
    //   99: aload_0
    //   100: astore_2
    //   101: ldc 49
    //   103: iconst_2
    //   104: aload_3
    //   105: invokevirtual 449	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   108: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: aload_0
    //   112: areturn
    //   113: aload_0
    //   114: astore_2
    //   115: aload_3
    //   116: invokevirtual 452	java/lang/Exception:printStackTrace	()V
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
      QLog.e("ApolloRender", 1, "BitmapFactory.decodeBuffer failed:" + paramArrayOfByte.getMessage());
    }
    return null;
  }
  
  public static byte[] decryptTEA(byte[] paramArrayOfByte)
  {
    if (ApolloManager.jdField_c_of_type_JavaLangString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloRender", 2, "decryptTEA but stkey = null,return null");
      }
      return null;
    }
    return new Cryptor().decrypt(paramArrayOfByte, ApolloManager.jdField_c_of_type_JavaLangString.getBytes());
  }
  
  public static void disposeTicker(long paramLong)
  {
    ApolloRender localApolloRender = getRenderByThreadId();
    if (localApolloRender == null) {}
    while (localApolloRender.mApolloTicker == null) {
      return;
    }
    localApolloRender.mApolloTicker.disposeTicker(paramLong);
  }
  
  /* Error */
  public static Bitmap drawTextOnBitmap(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +136 -> 139
    //   6: ldc 49
    //   8: iconst_2
    //   9: new 133	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 488
    //   19: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: fload_0
    //   23: invokevirtual 491	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   26: ldc_w 493
    //   29: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: fload_1
    //   33: invokevirtual 491	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   36: ldc_w 495
    //   39: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: fload_2
    //   43: invokevirtual 491	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   46: ldc_w 497
    //   49: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: fload_3
    //   53: invokevirtual 491	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   56: ldc_w 499
    //   59: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: iload 4
    //   64: invokevirtual 502	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   67: ldc_w 504
    //   70: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: iload 5
    //   75: invokevirtual 502	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   78: ldc_w 506
    //   81: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload 8
    //   86: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc_w 508
    //   92: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload 9
    //   97: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: ldc_w 510
    //   103: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: iload 6
    //   108: invokevirtual 502	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   111: ldc_w 512
    //   114: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: iload 7
    //   119: invokevirtual 502	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   122: ldc_w 514
    //   125: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload 10
    //   130: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: aload 9
    //   141: invokestatic 520	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   144: ifne +25 -> 169
    //   147: ldc_w 522
    //   150: aload 9
    //   152: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   155: ifne +31 -> 186
    //   158: ldc_w 524
    //   161: aload 9
    //   163: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   166: ifne +20 -> 186
    //   169: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   172: ifeq +12 -> 184
    //   175: ldc 49
    //   177: iconst_2
    //   178: ldc_w 526
    //   181: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: aconst_null
    //   185: areturn
    //   186: aload 10
    //   188: invokestatic 520	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   191: ifeq +681 -> 872
    //   194: iconst_0
    //   195: istore 11
    //   197: aconst_null
    //   198: astore 12
    //   200: new 133	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   207: ldc_w 528
    //   210: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: iload 4
    //   215: invokevirtual 502	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   218: ldc_w 530
    //   221: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: iload 5
    //   226: invokevirtual 502	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   229: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: astore 14
    //   234: getstatic 534	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   237: ifnull +66 -> 303
    //   240: getstatic 534	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   243: aload 14
    //   245: invokevirtual 539	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   248: checkcast 424	android/graphics/Bitmap
    //   251: astore 13
    //   253: aload 13
    //   255: astore 12
    //   257: aload 13
    //   259: ifnull +44 -> 303
    //   262: aload 13
    //   264: astore 12
    //   266: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq +34 -> 303
    //   272: ldc 49
    //   274: iconst_2
    //   275: new 133	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   282: ldc_w 541
    //   285: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: aload 14
    //   290: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   299: aload 13
    //   301: astore 12
    //   303: aload 12
    //   305: astore 13
    //   307: aload 12
    //   309: ifnonnull +40 -> 349
    //   312: iload 4
    //   314: iload 5
    //   316: getstatic 413	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   319: invokestatic 434	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   322: astore 12
    //   324: aload 12
    //   326: astore 13
    //   328: getstatic 534	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   331: ifnull +18 -> 349
    //   334: getstatic 534	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   337: aload 14
    //   339: aload 12
    //   341: invokevirtual 545	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   344: pop
    //   345: aload 12
    //   347: astore 13
    //   349: new 547	android/widget/TextView
    //   352: dup
    //   353: invokestatic 337	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   356: invokespecial 549	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   359: astore 14
    //   361: new 551	android/graphics/Paint$FontMetricsInt
    //   364: dup
    //   365: invokespecial 552	android/graphics/Paint$FontMetricsInt:<init>	()V
    //   368: astore 12
    //   370: aload 14
    //   372: invokevirtual 556	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   375: aload 12
    //   377: invokevirtual 562	android/text/TextPaint:getFontMetricsInt	(Landroid/graphics/Paint$FontMetricsInt;)I
    //   380: pop
    //   381: aload 12
    //   383: getfield 565	android/graphics/Paint$FontMetricsInt:ascent	I
    //   386: aload 12
    //   388: getfield 568	android/graphics/Paint$FontMetricsInt:top	I
    //   391: isub
    //   392: istore 5
    //   394: iload 5
    //   396: ifne +1018 -> 1414
    //   399: fconst_2
    //   400: getstatic 572	com/tencent/mobileqq/utils/DeviceInfoUtil:a	F
    //   403: fmul
    //   404: f2i
    //   405: istore 5
    //   407: invokestatic 240	com/tencent/mobileqq/apollo/task/ApolloActionManager:a	()Lcom/tencent/mobileqq/apollo/task/ApolloActionManager;
    //   410: getfield 575	com/tencent/mobileqq/apollo/task/ApolloActionManager:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   413: invokevirtual 579	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   416: istore 4
    //   418: invokestatic 583	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   421: invokevirtual 587	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   424: astore 15
    //   426: aload 15
    //   428: instanceof 589
    //   431: ifeq +980 -> 1411
    //   434: aload 15
    //   436: checkcast 589	com/tencent/mobileqq/app/QQAppInterface
    //   439: astore 12
    //   441: getstatic 159	com/tencent/mobileqq/apollo/ApolloRender:mBubbleType	I
    //   444: iconst_m1
    //   445: if_icmpeq +966 -> 1411
    //   448: getstatic 159	com/tencent/mobileqq/apollo/ApolloRender:mBubbleType	I
    //   451: istore 4
    //   453: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   456: ifeq +30 -> 486
    //   459: ldc 49
    //   461: iconst_2
    //   462: new 133	java/lang/StringBuilder
    //   465: dup
    //   466: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   469: ldc_w 591
    //   472: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: iload 4
    //   477: invokevirtual 502	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   480: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   486: aload 8
    //   488: astore 12
    //   490: aload 8
    //   492: invokestatic 520	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   495: ifne +52 -> 547
    //   498: iload 4
    //   500: ifeq +13 -> 513
    //   503: aload 8
    //   505: astore 12
    //   507: iconst_1
    //   508: iload 4
    //   510: if_icmpne +37 -> 547
    //   513: aload 8
    //   515: ldc_w 593
    //   518: invokevirtual 596	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   521: iconst_0
    //   522: invokestatic 602	com/tencent/mobileqq/utils/Base64Util:decode	([BI)[B
    //   525: astore 16
    //   527: aload 8
    //   529: astore 12
    //   531: aload 16
    //   533: ifnull +14 -> 547
    //   536: new 297	java/lang/String
    //   539: dup
    //   540: aload 16
    //   542: invokespecial 605	java/lang/String:<init>	([B)V
    //   545: astore 12
    //   547: iload 11
    //   549: ifne +467 -> 1016
    //   552: iload 4
    //   554: ifeq +27 -> 581
    //   557: iconst_1
    //   558: iload 4
    //   560: if_icmpne +14 -> 574
    //   563: ldc_w 522
    //   566: aload 9
    //   568: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   571: ifne +10 -> 581
    //   574: bipush 8
    //   576: iload 4
    //   578: if_icmpne +438 -> 1016
    //   581: aload 14
    //   583: bipush 17
    //   585: invokevirtual 609	android/widget/TextView:setGravity	(I)V
    //   588: aload 14
    //   590: ldc_w 610
    //   593: invokevirtual 613	android/widget/TextView:setTextColor	(I)V
    //   596: aload 14
    //   598: ldc_w 614
    //   601: getstatic 572	com/tencent/mobileqq/utils/DeviceInfoUtil:a	F
    //   604: fdiv
    //   605: invokevirtual 618	android/widget/TextView:setTextSize	(F)V
    //   608: iconst_3
    //   609: istore 4
    //   611: aload 14
    //   613: fload_2
    //   614: f2i
    //   615: invokevirtual 621	android/widget/TextView:setWidth	(I)V
    //   618: aload 14
    //   620: fload_3
    //   621: f2i
    //   622: iload 5
    //   624: iadd
    //   625: invokevirtual 624	android/widget/TextView:setHeight	(I)V
    //   628: aload 14
    //   630: aload 14
    //   632: invokevirtual 556	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   635: fload_2
    //   636: aload 12
    //   638: iload 4
    //   640: invokestatic 629	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	(Landroid/graphics/Paint;FLjava/lang/String;I)Ljava/lang/String;
    //   643: invokevirtual 633	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   646: aload 14
    //   648: iconst_0
    //   649: iconst_0
    //   650: invokestatic 639	android/view/View$MeasureSpec:makeMeasureSpec	(II)I
    //   653: iconst_0
    //   654: iconst_0
    //   655: invokestatic 639	android/view/View$MeasureSpec:makeMeasureSpec	(II)I
    //   658: invokevirtual 643	android/widget/TextView:measure	(II)V
    //   661: aload 14
    //   663: invokevirtual 646	android/widget/TextView:getMeasuredWidth	()I
    //   666: istore 6
    //   668: aload 14
    //   670: iconst_0
    //   671: iconst_0
    //   672: iload 6
    //   674: aload 14
    //   676: invokevirtual 649	android/widget/TextView:getMeasuredHeight	()I
    //   679: invokevirtual 653	android/widget/TextView:layout	(IIII)V
    //   682: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   685: ifeq +33 -> 718
    //   688: ldc 49
    //   690: iconst_2
    //   691: new 133	java/lang/StringBuilder
    //   694: dup
    //   695: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   698: ldc_w 655
    //   701: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: aload 14
    //   706: invokevirtual 658	android/widget/TextView:getLineHeight	()I
    //   709: invokevirtual 502	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   712: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   715: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   718: aload 14
    //   720: invokevirtual 661	android/widget/TextView:getLineCount	()I
    //   723: ifne +602 -> 1325
    //   726: aload 14
    //   728: ldc_w 662
    //   731: aload 14
    //   733: invokevirtual 658	android/widget/TextView:getLineHeight	()I
    //   736: i2f
    //   737: fsub
    //   738: ldc_w 663
    //   741: invokevirtual 667	android/widget/TextView:setLineSpacing	(FF)V
    //   744: new 436	android/graphics/Canvas
    //   747: dup
    //   748: aload 13
    //   750: invokespecial 439	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   753: astore 8
    //   755: new 669	android/graphics/Matrix
    //   758: dup
    //   759: invokespecial 670	android/graphics/Matrix:<init>	()V
    //   762: astore 9
    //   764: iconst_1
    //   765: iload 7
    //   767: if_icmpne +632 -> 1399
    //   770: aload 9
    //   772: bipush 9
    //   774: newarray float
    //   776: dup
    //   777: iconst_0
    //   778: ldc_w 671
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
    //   817: invokevirtual 675	android/graphics/Matrix:setValues	([F)V
    //   820: aload 9
    //   822: fload_2
    //   823: fconst_0
    //   824: invokevirtual 679	android/graphics/Matrix:postTranslate	(FF)Z
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
    //   851: invokevirtual 679	android/graphics/Matrix:postTranslate	(FF)Z
    //   854: pop
    //   855: aload 8
    //   857: aload 9
    //   859: invokevirtual 683	android/graphics/Canvas:setMatrix	(Landroid/graphics/Matrix;)V
    //   862: aload 14
    //   864: aload 8
    //   866: invokevirtual 687	android/widget/TextView:draw	(Landroid/graphics/Canvas;)V
    //   869: aload 13
    //   871: areturn
    //   872: aload 10
    //   874: ldc_w 689
    //   877: invokevirtual 693	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   880: istore 11
    //   882: goto -685 -> 197
    //   885: astore 8
    //   887: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   890: ifeq +33 -> 923
    //   893: ldc 49
    //   895: iconst_2
    //   896: new 133	java/lang/StringBuilder
    //   899: dup
    //   900: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   903: ldc_w 695
    //   906: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   909: aload 8
    //   911: invokevirtual 449	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   914: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   917: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   920: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   923: aconst_null
    //   924: areturn
    //   925: astore 8
    //   927: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   930: ifeq +33 -> 963
    //   933: ldc 49
    //   935: iconst_2
    //   936: new 133	java/lang/StringBuilder
    //   939: dup
    //   940: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   943: ldc_w 695
    //   946: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   949: aload 8
    //   951: invokevirtual 456	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   954: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   957: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   960: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   963: aconst_null
    //   964: areturn
    //   965: astore 16
    //   967: aload 8
    //   969: astore 12
    //   971: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   974: ifeq -427 -> 547
    //   977: ldc 49
    //   979: iconst_2
    //   980: aload 16
    //   982: invokevirtual 449	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   985: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   988: aload 8
    //   990: astore 12
    //   992: goto -445 -> 547
    //   995: astore 12
    //   997: ldc 49
    //   999: iconst_1
    //   1000: aload 12
    //   1002: iconst_0
    //   1003: anewarray 4	java/lang/Object
    //   1006: invokestatic 698	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1009: aload 8
    //   1011: astore 12
    //   1013: goto -466 -> 547
    //   1016: iconst_1
    //   1017: iload 4
    //   1019: if_icmpeq +8 -> 1027
    //   1022: iload 11
    //   1024: ifeq +120 -> 1144
    //   1027: ldc_w 524
    //   1030: aload 9
    //   1032: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1035: ifeq +109 -> 1144
    //   1038: aconst_null
    //   1039: astore 8
    //   1041: aload 15
    //   1043: instanceof 589
    //   1046: ifeq +19 -> 1065
    //   1049: aload 15
    //   1051: checkcast 589	com/tencent/mobileqq/app/QQAppInterface
    //   1054: sipush 152
    //   1057: invokevirtual 702	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1060: checkcast 463	com/tencent/mobileqq/apollo/ApolloManager
    //   1063: astore 8
    //   1065: iload 11
    //   1067: ifeq +40 -> 1107
    //   1070: ldc_w 703
    //   1073: istore 4
    //   1075: aload 14
    //   1077: bipush 17
    //   1079: invokevirtual 609	android/widget/TextView:setGravity	(I)V
    //   1082: aload 14
    //   1084: iload 4
    //   1086: invokevirtual 613	android/widget/TextView:setTextColor	(I)V
    //   1089: aload 14
    //   1091: ldc_w 704
    //   1094: getstatic 572	com/tencent/mobileqq/utils/DeviceInfoUtil:a	F
    //   1097: fdiv
    //   1098: invokevirtual 618	android/widget/TextView:setTextSize	(F)V
    //   1101: iconst_1
    //   1102: istore 4
    //   1104: goto -493 -> 611
    //   1107: aload 8
    //   1109: ifnull +29 -> 1138
    //   1112: aload 10
    //   1114: invokestatic 520	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1117: ifne +21 -> 1138
    //   1120: aload 8
    //   1122: aload 10
    //   1124: invokevirtual 706	com/tencent/mobileqq/apollo/ApolloManager:a	(Ljava/lang/String;)Z
    //   1127: ifeq +11 -> 1138
    //   1130: ldc_w 707
    //   1133: istore 4
    //   1135: goto -60 -> 1075
    //   1138: iconst_m1
    //   1139: istore 4
    //   1141: goto -66 -> 1075
    //   1144: iconst_2
    //   1145: iload 4
    //   1147: if_icmpne +36 -> 1183
    //   1150: aload 14
    //   1152: bipush 17
    //   1154: invokevirtual 609	android/widget/TextView:setGravity	(I)V
    //   1157: aload 14
    //   1159: ldc_w 610
    //   1162: invokevirtual 613	android/widget/TextView:setTextColor	(I)V
    //   1165: aload 14
    //   1167: ldc_w 708
    //   1170: getstatic 572	com/tencent/mobileqq/utils/DeviceInfoUtil:a	F
    //   1173: fdiv
    //   1174: invokevirtual 618	android/widget/TextView:setTextSize	(F)V
    //   1177: iconst_3
    //   1178: istore 4
    //   1180: goto -569 -> 611
    //   1183: iconst_3
    //   1184: iload 4
    //   1186: if_icmpne +36 -> 1222
    //   1189: aload 14
    //   1191: bipush 19
    //   1193: invokevirtual 609	android/widget/TextView:setGravity	(I)V
    //   1196: aload 14
    //   1198: ldc_w 610
    //   1201: invokevirtual 613	android/widget/TextView:setTextColor	(I)V
    //   1204: aload 14
    //   1206: ldc_w 709
    //   1209: getstatic 572	com/tencent/mobileqq/utils/DeviceInfoUtil:a	F
    //   1212: fdiv
    //   1213: invokevirtual 618	android/widget/TextView:setTextSize	(F)V
    //   1216: iconst_2
    //   1217: istore 4
    //   1219: goto -608 -> 611
    //   1222: iconst_4
    //   1223: iload 4
    //   1225: if_icmpeq +9 -> 1234
    //   1228: iconst_5
    //   1229: iload 4
    //   1231: if_icmpne +37 -> 1268
    //   1234: aload 14
    //   1236: bipush 17
    //   1238: invokevirtual 609	android/widget/TextView:setGravity	(I)V
    //   1241: aload 14
    //   1243: ldc_w 710
    //   1246: invokevirtual 613	android/widget/TextView:setTextColor	(I)V
    //   1249: aload 14
    //   1251: ldc_w 711
    //   1254: getstatic 572	com/tencent/mobileqq/utils/DeviceInfoUtil:a	F
    //   1257: fdiv
    //   1258: invokevirtual 618	android/widget/TextView:setTextSize	(F)V
    //   1261: bipush 6
    //   1263: istore 4
    //   1265: goto -654 -> 611
    //   1268: bipush 6
    //   1270: iload 4
    //   1272: if_icmpeq +10 -> 1282
    //   1275: bipush 7
    //   1277: iload 4
    //   1279: if_icmpne +126 -> 1405
    //   1282: aload 14
    //   1284: bipush 17
    //   1286: invokevirtual 609	android/widget/TextView:setGravity	(I)V
    //   1289: aload 14
    //   1291: ldc_w 610
    //   1294: invokevirtual 613	android/widget/TextView:setTextColor	(I)V
    //   1297: aload 14
    //   1299: ldc_w 712
    //   1302: getstatic 572	com/tencent/mobileqq/utils/DeviceInfoUtil:a	F
    //   1305: fdiv
    //   1306: invokevirtual 618	android/widget/TextView:setTextSize	(F)V
    //   1309: aload 14
    //   1311: iconst_0
    //   1312: iload 5
    //   1314: iconst_0
    //   1315: iconst_0
    //   1316: invokevirtual 715	android/widget/TextView:setPadding	(IIII)V
    //   1319: iconst_2
    //   1320: istore 4
    //   1322: goto -711 -> 611
    //   1325: aload 14
    //   1327: iload 5
    //   1329: i2f
    //   1330: fload_3
    //   1331: fadd
    //   1332: aload 14
    //   1334: invokevirtual 661	android/widget/TextView:getLineCount	()I
    //   1337: i2f
    //   1338: fdiv
    //   1339: aload 14
    //   1341: invokevirtual 658	android/widget/TextView:getLineHeight	()I
    //   1344: i2f
    //   1345: fsub
    //   1346: ldc_w 663
    //   1349: invokevirtual 667	android/widget/TextView:setLineSpacing	(FF)V
    //   1352: goto -608 -> 744
    //   1355: astore 8
    //   1357: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1360: ifeq +14 -> 1374
    //   1363: ldc 49
    //   1365: iconst_2
    //   1366: aload 8
    //   1368: invokevirtual 449	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   1371: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1374: aconst_null
    //   1375: astore 8
    //   1377: goto -622 -> 755
    //   1380: astore 8
    //   1382: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1385: ifeq +12 -> 1397
    //   1388: ldc 49
    //   1390: iconst_2
    //   1391: ldc_w 717
    //   1394: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1397: aconst_null
    //   1398: areturn
    //   1399: iconst_1
    //   1400: istore 4
    //   1402: goto -571 -> 831
    //   1405: iconst_3
    //   1406: istore 4
    //   1408: goto -797 -> 611
    //   1411: goto -958 -> 453
    //   1414: goto -1007 -> 407
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1417	0	paramFloat1	float
    //   0	1417	1	paramFloat2	float
    //   0	1417	2	paramFloat3	float
    //   0	1417	3	paramFloat4	float
    //   0	1417	4	paramInt1	int
    //   0	1417	5	paramInt2	int
    //   0	1417	6	paramInt3	int
    //   0	1417	7	paramInt4	int
    //   0	1417	8	paramString1	String
    //   0	1417	9	paramString2	String
    //   0	1417	10	paramString3	String
    //   195	871	11	bool	boolean
    //   198	793	12	localObject1	Object
    //   995	6	12	localThrowable	Throwable
    //   1011	1	12	str	String
    //   251	619	13	localObject2	Object
    //   232	1108	14	localObject3	Object
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
    //   744	755	1355	java/lang/OutOfMemoryError
    //   744	755	1380	java/lang/Exception
  }
  
  public static byte[] encryptTEA(byte[] paramArrayOfByte)
  {
    if (ApolloManager.jdField_c_of_type_JavaLangString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloRender", 2, "encryptTEA but stkey = null,return null");
      }
      return null;
    }
    return new Cryptor().encrypt(paramArrayOfByte, ApolloManager.jdField_c_of_type_JavaLangString.getBytes());
  }
  
  public static Bitmap getApolloBitmap(String paramString, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRender", 2, "[getApolloBitmap], path:" + paramString + ",format:" + paramInt);
    }
    if (TextUtils.isEmpty(paramString))
    {
      paramString = (String)localObject1;
      if (QLog.isColorLevel())
      {
        QLog.d("ApolloRender", 2, "errInfo-> path is NULL.");
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
              QLog.d("ApolloRender", 2, "errInfo2->oom->" + localOutOfMemoryError.getMessage() + ",h:" + i + ",w:" + paramInt);
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
            QLog.d("ApolloRender", 2, "errInfo1->oom->" + localOutOfMemoryError.getMessage() + ",h:" + 0 + ",w:" + paramInt);
            return localObject1;
          }
        }
        catch (Exception localException)
        {
          paramString = (String)localObject1;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloRender", 2, "errInfo3->exception->" + localException.getMessage());
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
        QLog.d("ApolloRender", 2, localOutOfMemoryError.getMessage());
        return null;
      }
      catch (Exception paramString)
      {
        QLog.e("ApolloRender", 1, "BitmapFactory.decodeFile failed:" + paramString.getMessage());
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
    getLocationLogin(paramLong, paramInt, paramString);
  }
  
  public static void getLocationCity(View paramView, DoraemonAPIManager paramDoraemonAPIManager, long paramLong, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
  {
    paramDoraemonAPIManager.a("getCity", null, new yrq(paramView, paramDoraemonAPIManager, paramLong, paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6));
  }
  
  public static void getLocationDoLocation(View paramView, DoraemonAPIManager paramDoraemonAPIManager, long paramLong, int paramInt, String paramString)
  {
    paramDoraemonAPIManager.a("getLocation", null, new yrr(paramView, paramDoraemonAPIManager, paramLong, paramInt));
  }
  
  public static void getLocationLogin(long paramLong, int paramInt, String paramString)
  {
    View localView = getRenderViewByThreadId();
    if (localView == null) {
      return;
    }
    Object localObject = (Activity)localView.getContext();
    DoraemonOpenAPI.a();
    localObject = DoraemonOpenAPI.a((Activity)localObject, 5, paramString);
    ((DoraemonAPIManager)localObject).a("login", null, new yrs(localView, (DoraemonAPIManager)localObject, paramLong, paramInt, paramString));
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
            QLog.i("ApolloRender", 1, "[getRenderByThreadId], errInfo->renderRef is null");
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
      QLog.i("ApolloRender", 1, "[getRenderByThreadId], errInfo->renderObj is null");
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
      QLog.e("ApolloRender", 1, "[getRenderViewByThreadId], errInfo->", localOutOfMemoryError);
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
      QLog.d("ApolloRender", 2, "[getRscStaticPath], name:" + paramString1 + ",type:" + paramString2);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(96);
    if ((paramString1.contains("game")) || (paramString1.contains("def")))
    {
      localStringBuilder.append(ApolloConstant.jdField_b_of_type_JavaLangString);
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
        QLog.d("ApolloRender", 2, "getRscStaticPath ret:" + localStringBuilder.toString());
      }
      return localStringBuilder.toString();
      localStringBuilder.append(ApolloConstant.jdField_a_of_type_JavaLangString);
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
      QLog.w("ApolloRender", 1, "render is null.");
      return null;
    }
    if (paramString.startsWith("GameSandBox:"))
    {
      paramString = paramString.substring("GameSandBox:".length() + "//".length());
      localObject = new File(ApolloConstant.n + ((ApolloRender)localObject).mGameId + "/sandbox");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      return ((File)localObject).getAbsolutePath() + "/" + paramString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRender", 2, new Object[] { "NOT start with right prefix, path:", paramString });
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
      File localFile = new File(ApolloConstant.n + paramInt + "/sandbox");
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return localFile.getAbsolutePath() + "/" + paramString;
    }
    return "NOT_SAND_PATH";
  }
  
  public static byte[] getTEASt()
  {
    if (ApolloManager.jdField_b_of_type_JavaLangString == null) {
      return null;
    }
    return HexUtil.a(ApolloManager.jdField_b_of_type_JavaLangString);
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
        int i = (int)(2.0F * DeviceInfoUtil.a);
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
          QLog.d("ApolloRender", 2, "errInfo->" + paramString1.getMessage());
        }
        catch (Exception paramString1)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ApolloRender", 2, "errInfo->" + paramString1.getMessage());
          return null;
        }
        paramString1 = paramString1;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloRender", 2, paramString1.getMessage());
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
        QLog.e("ApolloRender", 2, "getTextBitMapException e=" + paramString1.toString());
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
          QLog.d("ApolloRender", 2, "group brand ----> get bitmap from cache key: " + str);
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
  
  /* Error */
  public static Bitmap getTextViewBitmap(int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString2, int paramInt7, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt8)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 520	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: iload_0
    //   10: i2f
    //   11: f2d
    //   12: dstore 14
    //   14: dload 14
    //   16: dconst_1
    //   17: dmul
    //   18: getstatic 572	com/tencent/mobileqq/utils/DeviceInfoUtil:a	F
    //   21: f2d
    //   22: ddiv
    //   23: d2f
    //   24: fstore 16
    //   26: new 953	com/tencent/mobileqq/portal/StrokeTextView
    //   29: dup
    //   30: invokestatic 337	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   33: aconst_null
    //   34: invokespecial 956	com/tencent/mobileqq/portal/StrokeTextView:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   37: astore 17
    //   39: aload 17
    //   41: iconst_0
    //   42: invokevirtual 960	com/tencent/mobileqq/portal/StrokeTextView:setIncludeFontPadding	(Z)V
    //   45: aload 17
    //   47: iload_3
    //   48: invokevirtual 961	com/tencent/mobileqq/portal/StrokeTextView:setWidth	(I)V
    //   51: aload 17
    //   53: iload 4
    //   55: invokevirtual 962	com/tencent/mobileqq/portal/StrokeTextView:setHeight	(I)V
    //   58: iload 5
    //   60: ifne +379 -> 439
    //   63: aload 17
    //   65: iconst_3
    //   66: invokevirtual 963	com/tencent/mobileqq/portal/StrokeTextView:setGravity	(I)V
    //   69: iconst_0
    //   70: istore_3
    //   71: iload_3
    //   72: istore_0
    //   73: aload 7
    //   75: ifnull +39 -> 114
    //   78: iload_3
    //   79: istore_0
    //   80: aload 7
    //   82: ldc_w 844
    //   85: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   88: ifne +26 -> 114
    //   91: aload 7
    //   93: invokestatic 969	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   96: astore 7
    //   98: iload_3
    //   99: istore_0
    //   100: aload 7
    //   102: ifnull +12 -> 114
    //   105: iconst_1
    //   106: istore_0
    //   107: aload 17
    //   109: aload 7
    //   111: invokevirtual 973	com/tencent/mobileqq/portal/StrokeTextView:setTypeface	(Landroid/graphics/Typeface;)V
    //   114: iload_0
    //   115: ifne +16 -> 131
    //   118: iload 6
    //   120: iconst_1
    //   121: if_icmpne +349 -> 470
    //   124: aload 17
    //   126: aconst_null
    //   127: iconst_1
    //   128: invokevirtual 976	com/tencent/mobileqq/portal/StrokeTextView:setTypeface	(Landroid/graphics/Typeface;I)V
    //   131: fload 9
    //   133: fconst_0
    //   134: fcmpl
    //   135: ifeq +33 -> 168
    //   138: fload 9
    //   140: ldc_w 977
    //   143: fcmpl
    //   144: ifeq +24 -> 168
    //   147: aload 17
    //   149: iconst_1
    //   150: invokevirtual 980	com/tencent/mobileqq/portal/StrokeTextView:setStrokeEnable	(Z)V
    //   153: aload 17
    //   155: fload 9
    //   157: f2i
    //   158: invokevirtual 983	com/tencent/mobileqq/portal/StrokeTextView:setStrokeSize	(I)V
    //   161: aload 17
    //   163: iload 8
    //   165: invokevirtual 986	com/tencent/mobileqq/portal/StrokeTextView:setStrokeColor	(I)V
    //   168: fload 10
    //   170: fconst_0
    //   171: fcmpl
    //   172: ifeq +25 -> 197
    //   175: fload 10
    //   177: ldc_w 977
    //   180: fcmpl
    //   181: ifeq +16 -> 197
    //   184: aload 17
    //   186: fload 10
    //   188: fload 11
    //   190: fload 12
    //   192: iload 13
    //   194: invokevirtual 990	com/tencent/mobileqq/portal/StrokeTextView:setShadow	(FFFI)V
    //   197: aload 17
    //   199: iload_1
    //   200: invokevirtual 993	com/tencent/mobileqq/portal/StrokeTextView:setInnerTextColor	(I)V
    //   203: aload 17
    //   205: fload 16
    //   207: invokevirtual 994	com/tencent/mobileqq/portal/StrokeTextView:setTextSize	(F)V
    //   210: aload 17
    //   212: aload_2
    //   213: invokevirtual 995	com/tencent/mobileqq/portal/StrokeTextView:setText	(Ljava/lang/CharSequence;)V
    //   216: aload 17
    //   218: iconst_0
    //   219: iconst_0
    //   220: invokestatic 639	android/view/View$MeasureSpec:makeMeasureSpec	(II)I
    //   223: iconst_0
    //   224: iconst_0
    //   225: invokestatic 639	android/view/View$MeasureSpec:makeMeasureSpec	(II)I
    //   228: invokevirtual 996	com/tencent/mobileqq/portal/StrokeTextView:measure	(II)V
    //   231: aload 17
    //   233: invokevirtual 997	com/tencent/mobileqq/portal/StrokeTextView:getMeasuredWidth	()I
    //   236: istore_0
    //   237: aload 17
    //   239: invokevirtual 998	com/tencent/mobileqq/portal/StrokeTextView:getMeasuredHeight	()I
    //   242: istore_1
    //   243: aload 17
    //   245: iconst_0
    //   246: iconst_0
    //   247: iload_0
    //   248: iload_1
    //   249: invokevirtual 999	com/tencent/mobileqq/portal/StrokeTextView:layout	(IIII)V
    //   252: aconst_null
    //   253: astore_2
    //   254: new 133	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   261: ldc_w 528
    //   264: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: iload_0
    //   268: invokevirtual 502	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   271: ldc_w 530
    //   274: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: iload_1
    //   278: invokevirtual 502	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   281: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: astore 18
    //   286: getstatic 534	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   289: ifnull +63 -> 352
    //   292: getstatic 534	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   295: aload 18
    //   297: invokevirtual 539	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   300: checkcast 424	android/graphics/Bitmap
    //   303: astore 7
    //   305: aload 7
    //   307: astore_2
    //   308: aload 7
    //   310: ifnull +42 -> 352
    //   313: aload 7
    //   315: astore_2
    //   316: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   319: ifeq +33 -> 352
    //   322: ldc 49
    //   324: iconst_2
    //   325: new 133	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   332: ldc_w 541
    //   335: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: aload 18
    //   340: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   349: aload 7
    //   351: astore_2
    //   352: aload_2
    //   353: astore 7
    //   355: aload_2
    //   356: ifnonnull +34 -> 390
    //   359: iload_0
    //   360: iload_1
    //   361: getstatic 413	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   364: invokestatic 434	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   367: astore_2
    //   368: aload_2
    //   369: astore 7
    //   371: getstatic 534	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   374: ifnull +16 -> 390
    //   377: getstatic 534	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   380: aload 18
    //   382: aload_2
    //   383: invokevirtual 545	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   386: pop
    //   387: aload_2
    //   388: astore 7
    //   390: aload 17
    //   392: new 436	android/graphics/Canvas
    //   395: dup
    //   396: aload 7
    //   398: invokespecial 439	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   401: invokevirtual 1000	com/tencent/mobileqq/portal/StrokeTextView:draw	(Landroid/graphics/Canvas;)V
    //   404: aload 7
    //   406: areturn
    //   407: astore_2
    //   408: ldc 49
    //   410: iconst_2
    //   411: new 133	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   418: ldc_w 949
    //   421: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: aload_2
    //   425: invokevirtual 950	java/lang/Exception:toString	()Ljava/lang/String;
    //   428: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   434: invokestatic 459	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   437: aconst_null
    //   438: areturn
    //   439: iload 5
    //   441: iconst_1
    //   442: if_icmpne +13 -> 455
    //   445: aload 17
    //   447: bipush 17
    //   449: invokevirtual 963	com/tencent/mobileqq/portal/StrokeTextView:setGravity	(I)V
    //   452: goto -383 -> 69
    //   455: iload 5
    //   457: iconst_2
    //   458: if_icmpne -389 -> 69
    //   461: aload 17
    //   463: iconst_5
    //   464: invokevirtual 963	com/tencent/mobileqq/portal/StrokeTextView:setGravity	(I)V
    //   467: goto -398 -> 69
    //   470: iload 6
    //   472: iconst_2
    //   473: if_icmpne +13 -> 486
    //   476: aload 17
    //   478: aconst_null
    //   479: iconst_2
    //   480: invokevirtual 976	com/tencent/mobileqq/portal/StrokeTextView:setTypeface	(Landroid/graphics/Typeface;I)V
    //   483: goto -352 -> 131
    //   486: iload 6
    //   488: iconst_3
    //   489: if_icmpne -358 -> 131
    //   492: aload 17
    //   494: aconst_null
    //   495: iconst_3
    //   496: invokevirtual 976	com/tencent/mobileqq/portal/StrokeTextView:setTypeface	(Landroid/graphics/Typeface;I)V
    //   499: goto -368 -> 131
    //   502: astore_2
    //   503: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   506: ifeq +73 -> 579
    //   509: ldc 49
    //   511: iconst_2
    //   512: new 133	java/lang/StringBuilder
    //   515: dup
    //   516: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   519: ldc_w 695
    //   522: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: aload_2
    //   526: invokevirtual 449	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   529: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   535: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   538: goto +41 -> 579
    //   541: astore_2
    //   542: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   545: ifeq +32 -> 577
    //   548: ldc 49
    //   550: iconst_2
    //   551: new 133	java/lang/StringBuilder
    //   554: dup
    //   555: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   558: ldc_w 695
    //   561: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: aload_2
    //   565: invokevirtual 456	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   568: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   574: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   577: aconst_null
    //   578: areturn
    //   579: aconst_null
    //   580: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	581	0	paramInt1	int
    //   0	581	1	paramInt2	int
    //   0	581	2	paramString1	String
    //   0	581	3	paramInt3	int
    //   0	581	4	paramInt4	int
    //   0	581	5	paramInt5	int
    //   0	581	6	paramInt6	int
    //   0	581	7	paramString2	String
    //   0	581	8	paramInt7	int
    //   0	581	9	paramFloat1	float
    //   0	581	10	paramFloat2	float
    //   0	581	11	paramFloat3	float
    //   0	581	12	paramFloat4	float
    //   0	581	13	paramInt8	int
    //   12	3	14	d	double
    //   24	182	16	f	float
    //   37	456	17	localStrokeTextView	StrokeTextView
    //   284	97	18	str	String
    // Exception table:
    //   from	to	target	type
    //   14	58	407	java/lang/Exception
    //   63	69	407	java/lang/Exception
    //   80	98	407	java/lang/Exception
    //   107	114	407	java/lang/Exception
    //   124	131	407	java/lang/Exception
    //   147	168	407	java/lang/Exception
    //   184	197	407	java/lang/Exception
    //   197	252	407	java/lang/Exception
    //   254	286	407	java/lang/Exception
    //   286	305	407	java/lang/Exception
    //   316	349	407	java/lang/Exception
    //   390	404	407	java/lang/Exception
    //   445	452	407	java/lang/Exception
    //   461	467	407	java/lang/Exception
    //   476	483	407	java/lang/Exception
    //   492	499	407	java/lang/Exception
    //   503	538	407	java/lang/Exception
    //   542	577	407	java/lang/Exception
    //   359	368	502	java/lang/OutOfMemoryError
    //   371	387	502	java/lang/OutOfMemoryError
    //   359	368	541	java/lang/Exception
    //   371	387	541	java/lang/Exception
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
      int i = (int)(2.0F * DeviceInfoUtil.a);
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
    if (TextUtils.isEmpty(paramString1))
    {
      paramString1 = null;
      return paramString1;
    }
    float f = (float)(paramInt1 * 1.0D / DeviceInfoUtil.a);
    StrokeTextView localStrokeTextView = new StrokeTextView(BaseApplicationImpl.getContext(), null);
    localStrokeTextView.setIncludeFontPadding(false);
    if (paramInt6 == 0)
    {
      localStrokeTextView.setGravity(3);
      label54:
      paramInt6 = 0;
      paramInt1 = paramInt6;
      if (paramString2 != null)
      {
        paramInt1 = paramInt6;
        if (!paramString2.equals(""))
        {
          paramString2 = Typeface.createFromFile(paramString2);
          paramInt1 = paramInt6;
          if (paramString2 != null)
          {
            paramInt1 = 1;
            localStrokeTextView.setTypeface(paramString2);
          }
        }
      }
      if (paramInt1 == 0)
      {
        if (paramInt7 != 1) {
          break label328;
        }
        localStrokeTextView.setTypeface(null, 1);
      }
      label120:
      localStrokeTextView.setTextSize(f);
      localStrokeTextView.setText(paramString1);
      if (paramInt4 != 0) {
        localStrokeTextView.setMaxWidth(paramInt4);
      }
      if (paramInt5 != 0) {
        localStrokeTextView.setMaxHeight(paramInt5);
      }
      if (paramInt7 != 1) {
        break label360;
      }
      localStrokeTextView.setTypeface(null, 1);
    }
    for (;;)
    {
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
      paramInt1 = localStrokeTextView.getMeasuredWidth();
      paramInt4 = localStrokeTextView.getMeasuredHeight();
      paramString2 = new int[4];
      paramString2[0] = paramInt1;
      paramString2[1] = paramInt4;
      paramString2[2] = paramInt1;
      paramString2[3] = paramInt4;
      if (paramInt2 != 0) {
        paramString2[0] = paramInt2;
      }
      paramString1 = paramString2;
      if (paramInt3 == 0) {
        break;
      }
      paramString2[1] = paramInt3;
      return paramString2;
      if (paramInt6 == 1)
      {
        localStrokeTextView.setGravity(17);
        break label54;
      }
      if (paramInt6 != 2) {
        break label54;
      }
      localStrokeTextView.setGravity(5);
      break label54;
      label328:
      if (paramInt7 == 2)
      {
        localStrokeTextView.setTypeface(null, 2);
        break label120;
      }
      if (paramInt7 != 3) {
        break label120;
      }
      localStrokeTextView.setTypeface(null, 3);
      break label120;
      label360:
      if (paramInt7 == 2) {
        localStrokeTextView.setTypeface(null, 2);
      } else if (paramInt7 == 3) {
        localStrokeTextView.setTypeface(null, 3);
      }
    }
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
      QLog.d("ApolloRender", 2, paramSocket.getMessage());
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
          QLog.e("ApolloRender", 2, "socket exception e=" + paramSocket.toString());
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
    ThreadManager.getUIHandler().post(new yrh(localApolloRender));
  }
  
  public static void httpRequest(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String[] paramArrayOfString, boolean paramBoolean)
  {
    View localView = getRenderViewByThreadId();
    if (localView == null) {
      return;
    }
    if ((paramString2 == null) || ("".equals(paramString2)))
    {
      QLog.e("ApolloRender", 2, "httpLog  httpRequest method null ");
      return;
    }
    ThreadManager.post(new yrw(paramString2, paramString1, paramArrayOfString, new yru(localView, paramLong), paramBoolean, paramString3, paramString4, paramString5), 5, null, true);
  }
  
  public static void httpRequestData(long paramLong, String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3, String paramString4, String[] paramArrayOfString, boolean paramBoolean)
  {
    paramString3 = getRenderViewByThreadId();
    if (paramString3 == null) {
      return;
    }
    if ((paramString2 == null) || ("".equals(paramString2)))
    {
      QLog.e("ApolloRender", 2, "httpLog  httpRequest method null ");
      return;
    }
    ThreadManager.post(new yrt(paramString2, paramString1, paramArrayOfByte, paramArrayOfString, new yrn(paramString3, paramLong)), 5, null, true);
  }
  
  public static boolean isJavaMethodExist(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRender", 2, new Object[] { "[isJavaMethodExist], name:", paramString1, ",classType:", Integer.valueOf(paramInt) });
    }
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
        QLog.w("ApolloRender", 2, "unknown class type.");
        return false;
      }
      catch (Throwable paramString2)
      {
        QLog.e("ApolloRender", 1, "method NOT exists, name:" + paramString1 + "," + paramString2);
        return false;
      }
      if (2 == paramInt) {
        localObject = ApolloCmdChannel.class;
      }
    }
    localObject = ((Class)localObject).getDeclaredMethod(paramString1, CmGameUtil.a(paramString2)).getReturnType();
    paramString2 = CmGameUtil.a(paramString2);
    if ((localObject != null) && (paramString2 != null) && (((Class)localObject).getName() != null) && (((Class)localObject).getName().equals(paramString2.getName()))) {
      return true;
    }
    QLog.w("ApolloRender", 1, "method NOT exists, different return type");
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
      QLog.d("ApolloRender", 2, localOutOfMemoryError.getMessage());
      return null;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      QLog.e("ApolloRender", 2, "java sha1  Error:" + paramArrayOfByte.getMessage());
    }
    return null;
  }
  
  /* Error */
  public static Bitmap loadGif(String paramString, int paramInt)
  {
    // Byte code:
    //   0: new 400	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 401	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: iconst_1
    //   10: putfield 404	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   13: aload_2
    //   14: iconst_0
    //   15: putfield 407	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   18: aload_2
    //   19: getstatic 413	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   22: putfield 416	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   25: aload_0
    //   26: aload_2
    //   27: invokestatic 738	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   30: astore_3
    //   31: aload_3
    //   32: invokevirtual 427	android/graphics/Bitmap:getWidth	()I
    //   35: aload_3
    //   36: invokevirtual 430	android/graphics/Bitmap:getHeight	()I
    //   39: getstatic 413	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   42: invokestatic 434	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   45: astore_0
    //   46: aload_0
    //   47: astore_2
    //   48: new 436	android/graphics/Canvas
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 439	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   56: astore 4
    //   58: aload_0
    //   59: astore_2
    //   60: aload 4
    //   62: aload_3
    //   63: fconst_0
    //   64: fconst_0
    //   65: aconst_null
    //   66: invokevirtual 443	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   69: aload_0
    //   70: astore_2
    //   71: aload 4
    //   73: invokevirtual 446	android/graphics/Canvas:save	()I
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
    //   91: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq -14 -> 80
    //   97: aload_0
    //   98: astore_2
    //   99: ldc 49
    //   101: iconst_2
    //   102: aload_3
    //   103: invokevirtual 449	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   106: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: aload_0
    //   110: areturn
    //   111: aload_0
    //   112: astore_2
    //   113: aload_3
    //   114: invokevirtual 452	java/lang/Exception:printStackTrace	()V
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
  
  public static void locationEnd(View paramView, DoraemonAPIManager paramDoraemonAPIManager, long paramLong, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, String paramString1, int paramInt, String paramString2)
  {
    paramDoraemonAPIManager.a();
    ((ApolloSurfaceView)paramView).getRender().getSavaWrapper().a(paramLong, paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6, paramString1, paramInt, paramString2);
  }
  
  public static void printNativeLog(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    if ((paramInt2 < 0) || (paramInt1 > 0)) {}
    try
    {
      QLog.e("sava_native_log", 1, new Object[] { "level:", Integer.valueOf(paramInt1), ",code:", Integer.valueOf(paramInt2), ",info1:", ApolloUtil.e(paramString1), ",info2:", ApolloUtil.e(paramString2), ",info3:", ApolloUtil.e(paramString3) });
      return;
    }
    catch (OutOfMemoryError paramString1)
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("ApolloRender", 2, paramString1.getMessage());
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("ApolloRender", 1, "[printNativeLog]", paramString1);
    }
    if (QLog.isColorLevel())
    {
      QLog.d("sava_native_log", 2, new Object[] { "level:", Integer.valueOf(paramInt1), ",code:", Integer.valueOf(paramInt2), ",info1:", paramString1, ",info2:", paramString2, ",info3:", paramString3 });
      return;
    }
  }
  
  public static ApolloDevInfo queryDevInfo()
  {
    ApolloDevInfo localApolloDevInfo = new ApolloDevInfo();
    localApolloDevInfo.model = DeviceInfoUtil.j();
    localApolloDevInfo.platform = "android";
    localApolloDevInfo.version = DeviceInfoUtil.f();
    localApolloDevInfo.QQVersion = DeviceInfoUtil.d();
    localApolloDevInfo.pixelRatio = DeviceInfoUtil.a();
    localApolloDevInfo.screenHeight = ((float)DeviceInfoUtil.m());
    localApolloDevInfo.screenWidth = ((float)DeviceInfoUtil.l());
    return localApolloDevInfo;
  }
  
  public static byte[] readStream(InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    localByteArrayOutputStream.close();
    paramInputStream.close();
    return localByteArrayOutputStream.toByteArray();
  }
  
  /* Error */
  private static void recursionZip(java.util.zip.ZipOutputStream paramZipOutputStream, File paramFile, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_1
    //   3: invokevirtual 1266	java/io/File:isDirectory	()Z
    //   6: ifeq +73 -> 79
    //   9: new 133	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   16: aload_2
    //   17: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: getstatic 1269	java/io/File:separator	Ljava/lang/String;
    //   23: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_1
    //   27: invokevirtual 1270	java/io/File:getName	()Ljava/lang/String;
    //   30: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore_2
    //   37: aload_1
    //   38: invokevirtual 1274	java/io/File:listFiles	()[Ljava/io/File;
    //   41: astore_1
    //   42: aload_1
    //   43: arraylength
    //   44: istore 4
    //   46: iload_3
    //   47: iload 4
    //   49: if_icmpge +133 -> 182
    //   52: aload_1
    //   53: iload_3
    //   54: aaload
    //   55: astore 5
    //   57: aload 5
    //   59: ifnonnull +10 -> 69
    //   62: iload_3
    //   63: iconst_1
    //   64: iadd
    //   65: istore_3
    //   66: goto -20 -> 46
    //   69: aload_0
    //   70: aload 5
    //   72: aload_2
    //   73: invokestatic 1276	com/tencent/mobileqq/apollo/ApolloRender:recursionZip	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;)V
    //   76: goto -14 -> 62
    //   79: sipush 4096
    //   82: newarray byte
    //   84: astore 6
    //   86: new 1278	java/io/BufferedInputStream
    //   89: dup
    //   90: new 1280	java/io/FileInputStream
    //   93: dup
    //   94: aload_1
    //   95: invokespecial 1283	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   98: invokespecial 1286	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   101: astore 5
    //   103: aload_0
    //   104: new 1288	java/util/zip/ZipEntry
    //   107: dup
    //   108: new 133	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   115: aload_2
    //   116: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: getstatic 1269	java/io/File:separator	Ljava/lang/String;
    //   122: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_1
    //   126: invokevirtual 1270	java/io/File:getName	()Ljava/lang/String;
    //   129: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokespecial 1289	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   138: invokevirtual 1295	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   141: aload 5
    //   143: aload 6
    //   145: invokevirtual 1250	java/io/InputStream:read	([B)I
    //   148: istore_3
    //   149: iload_3
    //   150: iconst_m1
    //   151: if_icmpeq +32 -> 183
    //   154: aload_0
    //   155: aload 6
    //   157: iconst_0
    //   158: iload_3
    //   159: invokevirtual 1296	java/util/zip/ZipOutputStream:write	([BII)V
    //   162: goto -21 -> 141
    //   165: astore_0
    //   166: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   169: ifeq +13 -> 182
    //   172: ldc 49
    //   174: iconst_2
    //   175: aload_0
    //   176: invokevirtual 449	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   179: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   182: return
    //   183: aload 5
    //   185: invokevirtual 1258	java/io/InputStream:close	()V
    //   188: return
    //   189: astore_0
    //   190: aload 5
    //   192: astore_1
    //   193: aload_1
    //   194: ifnull +7 -> 201
    //   197: aload_1
    //   198: invokevirtual 1258	java/io/InputStream:close	()V
    //   201: aload_0
    //   202: invokevirtual 452	java/lang/Exception:printStackTrace	()V
    //   205: return
    //   206: astore_0
    //   207: aconst_null
    //   208: astore_1
    //   209: goto -16 -> 193
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	paramZipOutputStream	java.util.zip.ZipOutputStream
    //   0	212	1	paramFile	File
    //   0	212	2	paramString	String
    //   1	158	3	i	int
    //   44	6	4	j	int
    //   55	136	5	localObject	Object
    //   84	72	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   86	103	165	java/lang/OutOfMemoryError
    //   103	141	165	java/lang/OutOfMemoryError
    //   141	149	165	java/lang/OutOfMemoryError
    //   154	162	165	java/lang/OutOfMemoryError
    //   183	188	165	java/lang/OutOfMemoryError
    //   103	141	189	java/lang/Exception
    //   141	149	189	java/lang/Exception
    //   154	162	189	java/lang/Exception
    //   183	188	189	java/lang/Exception
    //   86	103	206	java/lang/Exception
  }
  
  public static void requestRenderView()
  {
    View localView = getRenderViewByThreadId();
    ApolloRender localApolloRender = getRenderByThreadId();
    if ((localView != null) && (localApolloRender != null))
    {
      if ((!(localView instanceof ApolloSurfaceView)) || (((ApolloSurfaceView)localView).mRenderMode != 0)) {
        break label54;
      }
      localApolloRender.needRender = 0;
      localApolloRender.getSavaWrapper().a(0);
      ((ApolloSurfaceView)localView).requestRender();
    }
    label54:
    while (!(localView instanceof ApolloTextureView)) {
      return;
    }
    ((ApolloTextureView)localView).requestRender();
  }
  
  protected static void selectPhoto(long paramLong, int paramInt1, int paramInt2)
  {
    View localView = getRenderViewByThreadId();
    ApolloRender localApolloRender = getRenderByThreadId();
    if (localView == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new yrl(paramLong, paramInt1, localView, localApolloRender));
  }
  
  public static void selectPhotoFromSystem(int paramInt1, int paramInt2, Intent paramIntent)
  {
    QLog.e("ApolloRender", 2, "imageselector selectPhotoFromSystem");
    View localView = getRenderViewByThreadId();
    getRenderByThreadId();
    if (localView == null)
    {
      QLog.e("ApolloRender", 2, "imageselector view Null                 Error");
      return;
    }
    if (g_imageselector == 0L)
    {
      QLog.e("ApolloRender", 2, "imageselector g_imageselector == 0             Error");
      return;
    }
    Object localObject;
    if ((localView instanceof ApolloSurfaceView))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ApolloRender", 2, "imageselector selectimagecallback ");
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
          QLog.e("ApolloRender", 2, "imageselector selectimageallback surfaceView  " + paramInt2 + " data: ");
          ((ApolloSurfaceView)localView).getRender().getSavaWrapper().a(g_imageselector, 1, paramInt1, i, paramIntent);
        }
      }
    }
    for (;;)
    {
      QLog.e("ApolloRender", 2, "imageselector selectPhotoFromSystem  111111111111111111");
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
          ((ApolloTextureView)localView).queueEvent(new yrm(paramInt2, paramIntent, localView));
        } else {
          QLog.e("ApolloRender", 2, "imageselector view type else ");
        }
      }
    }
  }
  
  public static void setEditorBtnClick(ApolloSurfaceView paramApolloSurfaceView, ApolloRender paramApolloRender)
  {
    if (paramApolloRender.mEditorBtn != null) {
      paramApolloRender.mEditorBtn.setOnClickListener(new yrz(paramApolloRender, paramApolloSurfaceView));
    }
  }
  
  public static void setEditorWatcher(ApolloSurfaceView paramApolloSurfaceView, ApolloRender paramApolloRender)
  {
    if (paramApolloRender.mEditorPop != null) {
      paramApolloRender.mEditorPop.addTextChangedListener(new ysb(paramApolloSurfaceView, paramApolloRender));
    }
  }
  
  public static void setIntervalTicker(long paramLong, int paramInt)
  {
    ApolloRender localApolloRender = getRenderByThreadId();
    if (localApolloRender == null) {}
    while (localApolloRender.mApolloTicker == null) {
      return;
    }
    localApolloRender.mApolloTicker.setInterval(paramLong, paramInt);
  }
  
  public static void setKeepScreenOn(int paramInt)
  {
    View localView = getRenderViewByThreadId();
    if (localView == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new yrp(localView, paramInt));
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
    ThreadManager.getUIHandler().post(new yri(localApolloRender, paramString));
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
        Object localObject = (RelativeLayout)LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(2130968685, null);
        paramApolloRender.mEditWindow.setContentView((View)localObject);
        paramApolloRender.mEditorPop = ((EditText)((RelativeLayout)localObject).findViewById(2131363193));
        ((RelativeLayout)localObject).requestLayout();
        ((RelativeLayout)localObject).post(new ysd(paramApolloRender, (RelativeLayout)localObject));
        paramApolloRender.mEditorBtn = ((Button)((RelativeLayout)localObject).findViewById(2131363194));
        paramApolloRender.mEditorBtn.setWidth((int)(50.0F * DeviceInfoUtil.a));
        paramApolloRender.mEditWindow.setOutsideTouchable(false);
        paramApolloRender.mEditWindow.setFocusable(true);
        if (paramApolloRender.mEditorDefaultText != null)
        {
          paramApolloRender.mEditorPop.setText(paramApolloRender.mEditorDefaultText);
          paramApolloRender.mEditorPop.setSelection(paramApolloRender.mEditorDefaultText.length());
        }
        localObject = BaseApplicationImpl.getContext().getResources().getDrawable(2130845717);
        paramApolloRender.mEditWindow.setBackgroundDrawable((Drawable)localObject);
      }
      setEditorWatcher((ApolloSurfaceView)paramView, paramApolloRender);
      setEditorBtnClick((ApolloSurfaceView)paramView, paramApolloRender);
      paramApolloRender.mEditWindow.setWidth(-1);
      i = (int)(55.0F * DeviceInfoUtil.a);
      paramApolloRender.mEditWindow.setHeight(i);
      i = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0).getInt("sp_key_apollo_keyboard_height", 0);
      if (i > 0)
      {
        paramView.getRootView().postDelayed(new yrd(paramApolloRender, paramView, i), 1000L);
        return;
      }
    } while ((paramApolloRender == null) || (paramApolloRender.mEditWindow == null) || (paramView == null));
    int i = ((ApolloSurfaceView)paramView).getHeight();
    paramApolloRender.mEditWindow.showAtLocation(paramView.getRootView(), 0, 0, i - paramApolloRender.mEditWindow.getHeight());
    paramApolloRender.mEditWindow.update(0, i - paramApolloRender.mEditWindow.getHeight(), paramApolloRender.mEditWindow.getWidth(), paramApolloRender.mEditWindow.getHeight());
  }
  
  /* Error */
  private void setupDirector()
  {
    // Byte code:
    //   0: invokestatic 1567	com/tencent/mobileqq/apollo/ApolloEngine:a	()Z
    //   3: ifeq +17 -> 20
    //   6: aload_0
    //   7: getfield 245	com/tencent/mobileqq/apollo/ApolloRender:mLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   10: ifnull +10 -> 20
    //   13: aload_0
    //   14: getfield 217	com/tencent/mobileqq/apollo/ApolloRender:mSavaWrapper	Lcom/tencent/mobileqq/apollo/ApolloEngine;
    //   17: ifnonnull +4 -> 21
    //   20: return
    //   21: aload_0
    //   22: getfield 245	com/tencent/mobileqq/apollo/ApolloRender:mLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   25: invokevirtual 1572	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   28: aload_0
    //   29: getfield 217	com/tencent/mobileqq/apollo/ApolloRender:mSavaWrapper	Lcom/tencent/mobileqq/apollo/ApolloEngine;
    //   32: lconst_0
    //   33: iconst_0
    //   34: iconst_0
    //   35: aload_0
    //   36: getfield 226	com/tencent/mobileqq/apollo/ApolloRender:mScale	F
    //   39: invokevirtual 1575	com/tencent/mobileqq/apollo/ApolloEngine:a	(JIIF)J
    //   42: lconst_0
    //   43: lcmp
    //   44: ifle +79 -> 123
    //   47: aload_0
    //   48: getfield 217	com/tencent/mobileqq/apollo/ApolloRender:mSavaWrapper	Lcom/tencent/mobileqq/apollo/ApolloEngine;
    //   51: aload_0
    //   52: ldc_w 1577
    //   55: ldc_w 1579
    //   58: invokevirtual 847	com/tencent/mobileqq/apollo/ApolloRender:getRscPath	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   61: invokevirtual 1581	com/tencent/mobileqq/apollo/ApolloEngine:b	(Ljava/lang/String;)V
    //   64: aload_0
    //   65: getfield 217	com/tencent/mobileqq/apollo/ApolloRender:mSavaWrapper	Lcom/tencent/mobileqq/apollo/ApolloEngine;
    //   68: getstatic 1583	com/tencent/mobileqq/apollo/ApolloManager:e	Ljava/lang/String;
    //   71: invokevirtual 1585	com/tencent/mobileqq/apollo/ApolloEngine:a	(Ljava/lang/String;)V
    //   74: aload_0
    //   75: getfield 217	com/tencent/mobileqq/apollo/ApolloRender:mSavaWrapper	Lcom/tencent/mobileqq/apollo/ApolloEngine;
    //   78: getstatic 1587	com/tencent/mobileqq/apollo/ApolloManager:d	Ljava/lang/String;
    //   81: invokevirtual 1585	com/tencent/mobileqq/apollo/ApolloEngine:a	(Ljava/lang/String;)V
    //   84: aload_0
    //   85: getfield 217	com/tencent/mobileqq/apollo/ApolloRender:mSavaWrapper	Lcom/tencent/mobileqq/apollo/ApolloEngine;
    //   88: getstatic 1589	com/tencent/mobileqq/apollo/ApolloManager:f	Ljava/lang/String;
    //   91: invokevirtual 1585	com/tencent/mobileqq/apollo/ApolloEngine:a	(Ljava/lang/String;)V
    //   94: aload_0
    //   95: getfield 217	com/tencent/mobileqq/apollo/ApolloRender:mSavaWrapper	Lcom/tencent/mobileqq/apollo/ApolloEngine;
    //   98: getstatic 1592	com/tencent/mobileqq/apollo/ApolloManager:g	Ljava/lang/String;
    //   101: invokevirtual 1585	com/tencent/mobileqq/apollo/ApolloEngine:a	(Ljava/lang/String;)V
    //   104: aload_0
    //   105: getfield 217	com/tencent/mobileqq/apollo/ApolloRender:mSavaWrapper	Lcom/tencent/mobileqq/apollo/ApolloEngine;
    //   108: aload_0
    //   109: getfield 226	com/tencent/mobileqq/apollo/ApolloRender:mScale	F
    //   112: invokevirtual 1594	com/tencent/mobileqq/apollo/ApolloEngine:a	(F)V
    //   115: aload_0
    //   116: getfield 245	com/tencent/mobileqq/apollo/ApolloRender:mLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   119: invokevirtual 1597	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   122: return
    //   123: ldc 49
    //   125: iconst_1
    //   126: ldc_w 1599
    //   129: invokestatic 459	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: goto -17 -> 115
    //   135: astore_1
    //   136: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   139: ifeq +13 -> 152
    //   142: ldc 49
    //   144: iconst_2
    //   145: aload_1
    //   146: invokevirtual 449	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   149: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: aload_0
    //   153: getfield 245	com/tencent/mobileqq/apollo/ApolloRender:mLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   156: invokevirtual 1597	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   159: return
    //   160: astore_1
    //   161: aload_0
    //   162: getfield 245	com/tencent/mobileqq/apollo/ApolloRender:mLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   165: invokevirtual 1597	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   168: aload_1
    //   169: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	ApolloRender
    //   135	11	1	localOutOfMemoryError	OutOfMemoryError
    //   160	9	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   28	115	135	java/lang/OutOfMemoryError
    //   123	132	135	java/lang/OutOfMemoryError
    //   28	115	160	finally
    //   123	132	160	finally
    //   136	152	160	finally
  }
  
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
      localView.getViewTreeObserver().addOnGlobalLayoutListener(new yre(localApolloRender, localView));
    }
    ThreadManager.getUIHandler().post(new yrf(localApolloRender, localView));
    ThreadManager.getUIHandler().postDelayed(new yrg(), 500L);
  }
  
  private boolean snapShot(GL10 paramGL10)
  {
    if ((this.mSnapShot) && (this.mSnapShotCallback != null) && (this.mWidth > 0) && (this.mHeight > 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloRender", 2, "snapShot Request:");
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
        QLog.d("ApolloRender", 2, paramGL10.getMessage());
      }
      return false;
    }
    catch (OutOfMemoryError paramGL10)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloRender", 2, paramGL10.getMessage());
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
  
  public static void tickerPause(long paramLong)
  {
    ApolloRender localApolloRender = getRenderByThreadId();
    if (localApolloRender == null) {}
    while (localApolloRender.mApolloTicker == null) {
      return;
    }
    localApolloRender.mApolloTicker.pauseTicker(paramLong);
  }
  
  public static void tickerResume(long paramLong)
  {
    ApolloRender localApolloRender = getRenderByThreadId();
    if (localApolloRender == null) {}
    while (localApolloRender.mApolloTicker == null) {
      return;
    }
    localApolloRender.mApolloTicker.resumeTicker(paramLong);
  }
  
  public static FaceStatus[] trackAndDetectFace(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    ApolloRender localApolloRender = getRenderByThreadId();
    if ((sIsDownLoadingSo) || (localApolloRender.mDetector == null)) {
      return null;
    }
    FaceStatus[] arrayOfFaceStatus = localApolloRender.mDetector.doTrack(paramArrayOfByte, paramInt1, paramInt2);
    mDetectorThreadHandler.post(new yrk(localApolloRender, paramArrayOfByte, paramInt1, paramInt2));
    return arrayOfFaceStatus;
  }
  
  /* Error */
  private static int unZip(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 1280	java/io/FileInputStream
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 1685	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   11: astore 7
    //   13: new 1687	com/tencent/commonsdk/zip/QZipInputStream
    //   16: dup
    //   17: new 1278	java/io/BufferedInputStream
    //   20: dup
    //   21: aload 7
    //   23: invokespecial 1286	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   26: invokespecial 1688	com/tencent/commonsdk/zip/QZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   29: astore 8
    //   31: aload 8
    //   33: invokevirtual 1692	com/tencent/commonsdk/zip/QZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   36: astore_0
    //   37: aload_0
    //   38: ifnull +239 -> 277
    //   41: ldc_w 1694
    //   44: new 133	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   51: ldc_w 1696
    //   54: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_0
    //   58: invokevirtual 1114	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 1700	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   67: pop
    //   68: sipush 4096
    //   71: newarray byte
    //   73: astore 6
    //   75: aload_0
    //   76: invokevirtual 1701	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   79: astore_0
    //   80: new 916	java/io/File
    //   83: dup
    //   84: new 133	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   91: aload_1
    //   92: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: getstatic 1269	java/io/File:separator	Ljava/lang/String;
    //   98: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload_0
    //   102: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokespecial 922	java/io/File:<init>	(Ljava/lang/String;)V
    //   111: astore_0
    //   112: new 916	java/io/File
    //   115: dup
    //   116: aload_0
    //   117: invokevirtual 1704	java/io/File:getParent	()Ljava/lang/String;
    //   120: invokespecial 922	java/io/File:<init>	(Ljava/lang/String;)V
    //   123: astore 5
    //   125: aload 5
    //   127: invokevirtual 925	java/io/File:exists	()Z
    //   130: ifne +9 -> 139
    //   133: aload 5
    //   135: invokevirtual 928	java/io/File:mkdirs	()Z
    //   138: pop
    //   139: new 1706	java/io/FileOutputStream
    //   142: dup
    //   143: aload_0
    //   144: invokespecial 1707	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   147: astore_0
    //   148: new 1709	java/io/BufferedOutputStream
    //   151: dup
    //   152: aload_0
    //   153: sipush 4096
    //   156: invokespecial 1712	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   159: astore 5
    //   161: aload 8
    //   163: aload 6
    //   165: iconst_0
    //   166: sipush 4096
    //   169: invokevirtual 1715	com/tencent/commonsdk/zip/QZipInputStream:read	([BII)I
    //   172: istore_2
    //   173: iload_2
    //   174: iconst_m1
    //   175: if_icmpeq +48 -> 223
    //   178: aload 5
    //   180: aload 6
    //   182: iconst_0
    //   183: iload_2
    //   184: invokevirtual 1716	java/io/BufferedOutputStream:write	([BII)V
    //   187: goto -26 -> 161
    //   190: astore_0
    //   191: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   194: ifeq +13 -> 207
    //   197: ldc 49
    //   199: iconst_2
    //   200: aload_0
    //   201: invokevirtual 449	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   204: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: iconst_1
    //   208: istore_2
    //   209: aload 7
    //   211: invokevirtual 1717	java/io/FileInputStream:close	()V
    //   214: aload 8
    //   216: invokevirtual 1718	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   219: iload_2
    //   220: istore_3
    //   221: iload_3
    //   222: ireturn
    //   223: aload 5
    //   225: invokevirtual 1721	java/io/BufferedOutputStream:flush	()V
    //   228: aload 5
    //   230: invokevirtual 1722	java/io/BufferedOutputStream:close	()V
    //   233: aload_0
    //   234: invokevirtual 1723	java/io/FileOutputStream:close	()V
    //   237: goto -206 -> 31
    //   240: astore 5
    //   242: aconst_null
    //   243: astore 4
    //   245: aload_0
    //   246: astore_1
    //   247: aload 5
    //   249: astore_0
    //   250: aload_1
    //   251: ifnull +7 -> 258
    //   254: aload_1
    //   255: invokevirtual 1723	java/io/FileOutputStream:close	()V
    //   258: aload 4
    //   260: ifnull +8 -> 268
    //   263: aload 4
    //   265: invokevirtual 1722	java/io/BufferedOutputStream:close	()V
    //   268: aload_0
    //   269: invokevirtual 452	java/lang/Exception:printStackTrace	()V
    //   272: iconst_0
    //   273: istore_2
    //   274: goto -65 -> 209
    //   277: iconst_1
    //   278: istore_2
    //   279: goto -70 -> 209
    //   282: astore_0
    //   283: iconst_1
    //   284: istore_2
    //   285: iload_2
    //   286: istore_3
    //   287: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   290: ifeq -69 -> 221
    //   293: ldc 49
    //   295: iconst_2
    //   296: aload_0
    //   297: invokevirtual 449	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   300: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   303: iload_2
    //   304: ireturn
    //   305: astore_0
    //   306: aload_0
    //   307: invokevirtual 452	java/lang/Exception:printStackTrace	()V
    //   310: iconst_0
    //   311: ireturn
    //   312: astore_0
    //   313: iconst_0
    //   314: istore_2
    //   315: goto -30 -> 285
    //   318: astore_0
    //   319: goto -34 -> 285
    //   322: astore_0
    //   323: aconst_null
    //   324: astore 5
    //   326: aload 4
    //   328: astore_1
    //   329: aload 5
    //   331: astore 4
    //   333: goto -83 -> 250
    //   336: astore 6
    //   338: aload_0
    //   339: astore_1
    //   340: aload 5
    //   342: astore 4
    //   344: aload 6
    //   346: astore_0
    //   347: goto -97 -> 250
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	350	0	paramString1	String
    //   0	350	1	paramString2	String
    //   172	143	2	i	int
    //   220	67	3	j	int
    //   1	342	4	localObject1	Object
    //   123	106	5	localObject2	Object
    //   240	8	5	localException1	Exception
    //   324	17	5	localObject3	Object
    //   73	108	6	arrayOfByte	byte[]
    //   336	9	6	localException2	Exception
    //   11	199	7	localFileInputStream	java.io.FileInputStream
    //   29	186	8	localQZipInputStream	com.tencent.commonsdk.zip.QZipInputStream
    // Exception table:
    //   from	to	target	type
    //   31	37	190	java/lang/OutOfMemoryError
    //   41	139	190	java/lang/OutOfMemoryError
    //   139	148	190	java/lang/OutOfMemoryError
    //   148	161	190	java/lang/OutOfMemoryError
    //   161	173	190	java/lang/OutOfMemoryError
    //   178	187	190	java/lang/OutOfMemoryError
    //   223	233	190	java/lang/OutOfMemoryError
    //   233	237	190	java/lang/OutOfMemoryError
    //   148	161	240	java/lang/Exception
    //   233	237	240	java/lang/Exception
    //   3	31	282	java/lang/OutOfMemoryError
    //   191	207	282	java/lang/OutOfMemoryError
    //   254	258	282	java/lang/OutOfMemoryError
    //   263	268	282	java/lang/OutOfMemoryError
    //   3	31	305	java/lang/Exception
    //   191	207	305	java/lang/Exception
    //   209	219	305	java/lang/Exception
    //   254	258	305	java/lang/Exception
    //   263	268	305	java/lang/Exception
    //   268	272	305	java/lang/Exception
    //   268	272	312	java/lang/OutOfMemoryError
    //   209	219	318	java/lang/OutOfMemoryError
    //   31	37	322	java/lang/Exception
    //   41	139	322	java/lang/Exception
    //   139	148	322	java/lang/Exception
    //   161	173	336	java/lang/Exception
    //   178	187	336	java/lang/Exception
    //   223	233	336	java/lang/Exception
  }
  
  protected static int websocketClose(long paramLong)
  {
    ApolloRender localApolloRender = getRenderByThreadId();
    SSLSocket localSSLSocket = (SSLSocket)localApolloRender.mSSLSocketMap.get(Long.valueOf(paramLong));
    if (localSSLSocket == null) {}
    for (;;)
    {
      return 0;
      BufferedInputStream localBufferedInputStream = (BufferedInputStream)localApolloRender.mBufferinputMap.get(Long.valueOf(paramLong));
      BufferedOutputStream localBufferedOutputStream = (BufferedOutputStream)localApolloRender.mBufferoutputMap.get(Long.valueOf(paramLong));
      if (localSSLSocket.isClosed())
      {
        localApolloRender.mSSLSocketMap.remove(Long.valueOf(paramLong));
        localApolloRender.mBufferinputMap.remove(Long.valueOf(paramLong));
        localApolloRender.mBufferoutputMap.remove(Long.valueOf(paramLong));
        return 0;
      }
      try
      {
        localBufferedInputStream.close();
        localBufferedOutputStream.close();
        localSSLSocket.close();
        localApolloRender.mSSLSocketMap.remove(Long.valueOf(paramLong));
        localApolloRender.mBufferinputMap.remove(Long.valueOf(paramLong));
        localApolloRender.mBufferoutputMap.remove(Long.valueOf(paramLong));
        i = 0;
        if (i < localApolloRender.mNioList.size()) {
          if (((ApolloNioSocketInfo)localApolloRender.mNioList.get(i)).jdField_a_of_type_Long == paramLong)
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
          QLog.d("ApolloRender", 2, localOutOfMemoryError.getMessage());
          return 0;
          i += 1;
        }
      }
      catch (Exception localException)
      {
        QLog.e("ApolloRender", 2, "websocket ssl close Error:" + localException.getMessage());
      }
    }
    return 0;
  }
  
  public static int websocketConnect(long paramLong, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    ApolloRender localApolloRender = getRenderByThreadId();
    Object localObject = (SSLSocket)localApolloRender.mSSLSocketMap.get(Long.valueOf(paramLong));
    if (getRenderViewByThreadId() == null)
    {
      Log.d("ApolloRender", "websocketConnect: view is null");
      return -1;
    }
    if (localObject == null)
    {
      localObject = new InetSocketAddress(paramString1, paramInt1);
      SocketChannel localSocketChannel = SocketChannel.open();
      localSocketChannel.configureBlocking(false);
      localSocketChannel.connect((SocketAddress)localObject);
      paramString1 = new ApolloNioSocketInfo(paramLong, paramString1, paramInt1, paramInt2, paramString2, paramString3, localSocketChannel);
      localApolloRender.mNioList.add(paramString1);
      return 0;
    }
    QLog.d("ApolloRender", 2, "do not handshake agagin");
    return 0;
  }
  
  @TargetApi(14)
  protected static byte[] websocketRecv(long paramLong, int paramInt)
  {
    Object localObject = getRenderByThreadId();
    if ((SSLSocket)((ApolloRender)localObject).mSSLSocketMap.get(Long.valueOf(paramLong)) == null) {
      return null;
    }
    localObject = (BufferedInputStream)((ApolloRender)localObject).mBufferinputMap.get(Long.valueOf(paramLong));
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
        QLog.d("ApolloRender", 2, localOutOfMemoryError.getMessage());
      }
      return null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ApolloRender", 2, "websocket ssl recv Error:" + localException.getMessage());
      }
    }
  }
  
  protected static int websocketSend(long paramLong, byte[] paramArrayOfByte)
  {
    Object localObject = getRenderByThreadId();
    new String(paramArrayOfByte);
    if ((SSLSocket)((ApolloRender)localObject).mSSLSocketMap.get(Long.valueOf(paramLong)) == null) {
      return 0;
    }
    BufferedOutputStream localBufferedOutputStream = (BufferedOutputStream)((ApolloRender)localObject).mBufferoutputMap.get(Long.valueOf(paramLong));
    localObject = (BufferedInputStream)((ApolloRender)localObject).mBufferinputMap.get(Long.valueOf(paramLong));
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
        QLog.d("ApolloRender", 2, paramArrayOfByte.getMessage());
      }
      return 0;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        QLog.e("ApolloRender", 2, "websocket ssl send Error:" + paramArrayOfByte.getMessage());
      }
    }
  }
  
  protected static int websocketShakeHand(long paramLong, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, Socket paramSocket)
  {
    ApolloRender localApolloRender = getRenderByThreadId();
    View localView = getRenderViewByThreadId();
    if (localView == null)
    {
      Log.d("ApolloRender", "websocketShakeHand: view is null");
      return 0;
    }
    if (paramInt2 > 0) {
      try
      {
        ((ApolloSurfaceView)localView).getRender().getSavaWrapper().a(paramLong, 4);
        if ((paramString2 != null) && (!paramString2.equals(""))) {}
        for (paramString2 = SSLContext.getInstance(paramString2);; paramString2 = SSLContext.getInstance("SSL"))
        {
          paramString2.init(null, null, null);
          paramString1 = (SSLSocket)paramString2.getSocketFactory().createSocket(paramSocket, paramString1, paramInt1, true);
          paramString1.setUseClientMode(true);
          paramString1.setKeepAlive(true);
          if ((paramString3 != null) && (!paramString3.equals(""))) {
            paramString1.setEnabledProtocols(new String[] { paramString3 });
          }
          paramString1.addHandshakeCompletedListener(new yrx(localView, paramLong));
          paramString1.startHandshake();
          paramInt1 = getfd(paramSocket);
          ((ApolloSurfaceView)localView).getRender().getSavaWrapper().b(paramLong, paramInt1);
          localApolloRender.mSSLSocketMap.put(Long.valueOf(paramLong), paramString1);
          paramString2 = new BufferedInputStream(paramString1.getInputStream());
          localApolloRender.mBufferinputMap.put(Long.valueOf(paramLong), paramString2);
          paramString1 = new BufferedOutputStream(paramString1.getOutputStream());
          localApolloRender.mBufferoutputMap.put(Long.valueOf(paramLong), paramString1);
          break;
        }
        return 0;
      }
      catch (OutOfMemoryError paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloRender", 2, paramString1.getMessage());
        }
      }
      catch (Exception paramString1)
      {
        ((ApolloSurfaceView)localView).getRender().getSavaWrapper().a(paramLong, 6);
        QLog.e("ApolloRender", 2, "handshake Error:" + paramString1.getMessage());
        return 0;
      }
    }
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
    //   39: getstatic 413	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   42: invokestatic 434	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   45: astore 7
    //   47: aload 7
    //   49: aload 6
    //   51: invokestatic 1865	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   54: invokevirtual 1868	android/graphics/Bitmap:copyPixelsFromBuffer	(Ljava/nio/Buffer;)V
    //   57: invokestatic 281	com/tencent/mobileqq/apollo/ApolloRender:getRenderByThreadId	()Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   60: astore_0
    //   61: aload_0
    //   62: ifnull +10 -> 72
    //   65: aload_0
    //   66: invokevirtual 1172	com/tencent/mobileqq/apollo/ApolloRender:getSavaWrapper	()Lcom/tencent/mobileqq/apollo/ApolloEngine;
    //   69: ifnonnull +4 -> 73
    //   72: return
    //   73: aload_0
    //   74: invokevirtual 1172	com/tencent/mobileqq/apollo/ApolloRender:getSavaWrapper	()Lcom/tencent/mobileqq/apollo/ApolloEngine;
    //   77: invokevirtual 1870	com/tencent/mobileqq/apollo/ApolloEngine:a	()J
    //   80: invokestatic 1872	com/tencent/mobileqq/apollo/process/CmGameUtil:a	(J)I
    //   83: aload_3
    //   84: invokestatic 1874	com/tencent/mobileqq/apollo/ApolloRender:getSandBoxPath	(ILjava/lang/String;)Ljava/lang/String;
    //   87: astore_0
    //   88: aload_0
    //   89: ifnull -17 -> 72
    //   92: new 916	java/io/File
    //   95: dup
    //   96: aload_0
    //   97: invokespecial 922	java/io/File:<init>	(Ljava/lang/String;)V
    //   100: astore_0
    //   101: aload_0
    //   102: invokevirtual 925	java/io/File:exists	()Z
    //   105: ifeq +8 -> 113
    //   108: aload_0
    //   109: invokevirtual 1877	java/io/File:delete	()Z
    //   112: pop
    //   113: new 1706	java/io/FileOutputStream
    //   116: dup
    //   117: aload_0
    //   118: invokespecial 1707	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   121: astore_0
    //   122: aload_0
    //   123: astore 6
    //   125: aload_3
    //   126: ldc_w 891
    //   129: invokevirtual 693	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   132: ifne +362 -> 494
    //   135: aload_0
    //   136: astore 6
    //   138: aload_3
    //   139: ldc_w 1879
    //   142: invokevirtual 693	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   145: ifne +349 -> 494
    //   148: aload_0
    //   149: astore 6
    //   151: aload_3
    //   152: ldc_w 1881
    //   155: invokevirtual 693	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   158: ifne +336 -> 494
    //   161: aload_0
    //   162: astore 6
    //   164: aload_3
    //   165: ldc_w 1883
    //   168: invokevirtual 693	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   171: ifeq +6 -> 177
    //   174: goto +320 -> 494
    //   177: aload_0
    //   178: astore 6
    //   180: iload 5
    //   182: invokestatic 1888	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   185: invokevirtual 1891	java/lang/Boolean:booleanValue	()Z
    //   188: ifeq +62 -> 250
    //   191: aload_0
    //   192: astore 6
    //   194: aload 7
    //   196: getstatic 1897	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   199: bipush 50
    //   201: aload_0
    //   202: invokevirtual 1901	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   205: ifeq +18 -> 223
    //   208: aload_0
    //   209: astore 6
    //   211: aload_0
    //   212: invokevirtual 1902	java/io/FileOutputStream:flush	()V
    //   215: aload_0
    //   216: astore 6
    //   218: aload 7
    //   220: invokevirtual 1905	android/graphics/Bitmap:recycle	()V
    //   223: aload_0
    //   224: ifnull -152 -> 72
    //   227: aload_0
    //   228: invokevirtual 1723	java/io/FileOutputStream:close	()V
    //   231: return
    //   232: astore_0
    //   233: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   236: ifeq -164 -> 72
    //   239: ldc 49
    //   241: iconst_2
    //   242: aload_0
    //   243: invokevirtual 449	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   246: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   249: return
    //   250: aload_0
    //   251: astore 6
    //   253: aload 7
    //   255: getstatic 1908	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   258: bipush 100
    //   260: aload_0
    //   261: invokevirtual 1901	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   264: ifeq -41 -> 223
    //   267: aload_0
    //   268: astore 6
    //   270: aload_0
    //   271: invokevirtual 1902	java/io/FileOutputStream:flush	()V
    //   274: aload_0
    //   275: astore 6
    //   277: aload 7
    //   279: invokevirtual 1905	android/graphics/Bitmap:recycle	()V
    //   282: goto -59 -> 223
    //   285: astore_3
    //   286: aload_3
    //   287: invokevirtual 1909	java/io/FileNotFoundException:printStackTrace	()V
    //   290: aload_0
    //   291: ifnull -219 -> 72
    //   294: aload_0
    //   295: invokevirtual 1723	java/io/FileOutputStream:close	()V
    //   298: return
    //   299: astore_0
    //   300: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   303: ifeq -231 -> 72
    //   306: ldc 49
    //   308: iconst_2
    //   309: aload_0
    //   310: invokevirtual 449	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   313: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   316: return
    //   317: astore_0
    //   318: aload_0
    //   319: invokevirtual 1910	java/io/IOException:printStackTrace	()V
    //   322: return
    //   323: astore_0
    //   324: aload_0
    //   325: invokevirtual 1910	java/io/IOException:printStackTrace	()V
    //   328: return
    //   329: astore_0
    //   330: aconst_null
    //   331: astore_0
    //   332: aload_0
    //   333: ifnull -261 -> 72
    //   336: aload_0
    //   337: invokevirtual 1723	java/io/FileOutputStream:close	()V
    //   340: return
    //   341: astore_0
    //   342: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   345: ifeq -273 -> 72
    //   348: ldc 49
    //   350: iconst_2
    //   351: aload_0
    //   352: invokevirtual 449	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   355: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   358: return
    //   359: astore_0
    //   360: aload_0
    //   361: invokevirtual 1910	java/io/IOException:printStackTrace	()V
    //   364: return
    //   365: astore_3
    //   366: aconst_null
    //   367: astore_0
    //   368: aload_0
    //   369: astore 6
    //   371: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   374: ifeq +16 -> 390
    //   377: aload_0
    //   378: astore 6
    //   380: ldc 49
    //   382: iconst_2
    //   383: aload_3
    //   384: invokevirtual 449	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   387: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   390: aload_0
    //   391: ifnull -319 -> 72
    //   394: aload_0
    //   395: invokevirtual 1723	java/io/FileOutputStream:close	()V
    //   398: return
    //   399: astore_0
    //   400: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   403: ifeq -331 -> 72
    //   406: ldc 49
    //   408: iconst_2
    //   409: aload_0
    //   410: invokevirtual 449	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   413: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   416: return
    //   417: astore_0
    //   418: aload_0
    //   419: invokevirtual 1910	java/io/IOException:printStackTrace	()V
    //   422: return
    //   423: astore_0
    //   424: aconst_null
    //   425: astore 6
    //   427: aload 6
    //   429: ifnull +8 -> 437
    //   432: aload 6
    //   434: invokevirtual 1723	java/io/FileOutputStream:close	()V
    //   437: aload_0
    //   438: athrow
    //   439: astore_3
    //   440: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   443: ifeq -6 -> 437
    //   446: ldc 49
    //   448: iconst_2
    //   449: aload_3
    //   450: invokevirtual 449	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   453: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   456: goto -19 -> 437
    //   459: astore_3
    //   460: aload_3
    //   461: invokevirtual 1910	java/io/IOException:printStackTrace	()V
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
    //   5: new 1291	java/util/zip/ZipOutputStream
    //   8: dup
    //   9: new 1706	java/io/FileOutputStream
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 1912	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   17: invokespecial 1913	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   20: astore 6
    //   22: aload 6
    //   24: astore_1
    //   25: new 916	java/io/File
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 922	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: astore_0
    //   34: aload_0
    //   35: ifnull +101 -> 136
    //   38: aload 6
    //   40: astore_1
    //   41: aload_0
    //   42: invokevirtual 925	java/io/File:exists	()Z
    //   45: ifeq +91 -> 136
    //   48: aload 6
    //   50: astore_1
    //   51: aload_0
    //   52: invokevirtual 1266	java/io/File:isDirectory	()Z
    //   55: ifeq +69 -> 124
    //   58: aload 6
    //   60: astore_1
    //   61: aload_0
    //   62: invokevirtual 1274	java/io/File:listFiles	()[Ljava/io/File;
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
    //   85: ldc_w 844
    //   88: invokestatic 1276	com/tencent/mobileqq/apollo/ApolloRender:recursionZip	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;)V
    //   91: goto +147 -> 238
    //   94: astore_0
    //   95: aload 6
    //   97: astore_1
    //   98: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   101: ifeq +16 -> 117
    //   104: aload 6
    //   106: astore_1
    //   107: ldc 49
    //   109: iconst_2
    //   110: aload_0
    //   111: invokevirtual 449	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   114: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   117: aload 6
    //   119: invokevirtual 1914	java/util/zip/ZipOutputStream:close	()V
    //   122: iload_3
    //   123: ireturn
    //   124: aload 6
    //   126: astore_1
    //   127: aload 6
    //   129: aload_0
    //   130: ldc_w 844
    //   133: invokestatic 1276	com/tencent/mobileqq/apollo/ApolloRender:recursionZip	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;)V
    //   136: aload 6
    //   138: invokevirtual 1914	java/util/zip/ZipOutputStream:close	()V
    //   141: iconst_1
    //   142: ireturn
    //   143: astore_0
    //   144: iload 4
    //   146: istore_2
    //   147: iload_2
    //   148: istore_3
    //   149: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   152: ifeq -30 -> 122
    //   155: ldc 49
    //   157: iconst_2
    //   158: aload_0
    //   159: invokevirtual 449	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   162: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: iload_2
    //   166: ireturn
    //   167: astore_0
    //   168: aconst_null
    //   169: astore 6
    //   171: aload 6
    //   173: astore_1
    //   174: aload_0
    //   175: invokevirtual 452	java/lang/Exception:printStackTrace	()V
    //   178: aload 6
    //   180: invokevirtual 1914	java/util/zip/ZipOutputStream:close	()V
    //   183: iconst_0
    //   184: ireturn
    //   185: astore_0
    //   186: aconst_null
    //   187: astore_1
    //   188: aload_1
    //   189: invokevirtual 1914	java/util/zip/ZipOutputStream:close	()V
    //   192: aload_0
    //   193: athrow
    //   194: astore_0
    //   195: aload_0
    //   196: invokevirtual 452	java/lang/Exception:printStackTrace	()V
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
    IRenderCallback localIRenderCallback;
    if (paramInt1 == 0) {
      if (this.mRenderCallbackRef != null)
      {
        localIRenderCallback = (IRenderCallback)this.mRenderCallbackRef.get();
        if (localIRenderCallback != null) {
          localIRenderCallback.a(paramInt2, paramString);
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
        localIRenderCallback = (IRenderCallback)this.mRenderCallbackRef.get();
      } while (localIRenderCallback == null);
      localIRenderCallback.a(paramInt2, 0, paramString);
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
        QLog.d("ApolloRender", 2, localOutOfMemoryError.getMessage());
      }
      return;
    }
    finally
    {
      this.mLock.unlock();
    }
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
      paramString1 = ApolloConstant.jdField_a_of_type_JavaLangString + "/" + str;
      if (!TextUtils.isEmpty(paramString2)) {
        new StringBuilder().append(paramString1).append(".").append(paramString2).toString();
      }
      localStringBuilder.append(ApolloConstant.jdField_b_of_type_JavaLangString);
      localStringBuilder.append("/def/role/0/script/coreJs/");
      paramString1 = new StringBuilder(200);
      paramString1.append(str);
      if (!"json".equals(paramString2)) {
        break label587;
      }
      paramString1.append(".json");
    }
    for (;;)
    {
      localStringBuilder.append(paramString1.toString());
      return localStringBuilder.toString();
      if (paramString1.startsWith("ActionRes:"))
      {
        str = paramString1.substring("ActionRes:".length() + "//".length());
        localStringBuilder.append(ApolloConstant.jdField_a_of_type_JavaLangString);
        localStringBuilder.append("/action/");
        break;
      }
      if (paramString1.startsWith("SlaveAction"))
      {
        str = paramString1.substring("SlaveAction".length() + "//".length());
        new File(ApolloConstant.jdField_a_of_type_JavaLangString, "slave");
        localStringBuilder.append(ApolloConstant.jdField_b_of_type_JavaLangString).append("/def/role/0/script/slave/");
        break;
      }
      if (paramString1.startsWith("GameRes:"))
      {
        str = paramString1.substring("GameRes:".length() + "//".length());
        localStringBuilder.append(ApolloConstant.jdField_a_of_type_JavaLangString);
        localStringBuilder.append("/game/");
        if (TextUtils.isEmpty(this.mGameName))
        {
          QLog.d("ApolloRender", 2, "getRscPath, mGameName is empty, name:" + str);
          break;
        }
        localStringBuilder.append(this.mGameName);
        localStringBuilder.append("/");
        break;
      }
      if (paramString1.startsWith("GameSandBox:"))
      {
        paramString1 = paramString1.substring("GameSandBox:".length() + "//".length());
        paramString2 = new File(ApolloConstant.n + this.mGameId + "/sandbox");
        if (!paramString2.exists()) {
          paramString2.mkdirs();
        }
        return paramString2.getAbsolutePath() + "/" + paramString1;
      }
      if ((paramString1.contains("game")) || (paramString1.contains("def")))
      {
        localStringBuilder.append(ApolloConstant.jdField_b_of_type_JavaLangString);
        str = paramString1;
        if (localStringBuilder.toString().endsWith("/")) {
          break;
        }
        localStringBuilder.append("/");
        str = paramString1;
        break;
      }
      localStringBuilder.append(ApolloConstant.jdField_a_of_type_JavaLangString);
      str = paramString1;
      if (localStringBuilder.toString().endsWith("/")) {
        break;
      }
      localStringBuilder.append("/");
      str = paramString1;
      break;
      label587:
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
      }
    }
  }
  
  public ApolloEngine getSavaWrapper()
  {
    return this.mSavaWrapper;
  }
  
  public native void nativePreviewCallback(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString);
  
  public native void nativeRemotePreviewCallback(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString);
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRender", 2, "[onDestroy]");
    }
    if ((this.mLock == null) || (this.mSavaWrapper == null)) {}
    do
    {
      do
      {
        return;
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
              QLog.d("ApolloRender", 2, localOutOfMemoryError.getMessage());
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
            QLog.d("ApolloRender", 2, "remove renderObj from map, id:" + l);
          }
        }
      } while (!this.mIsNeedReport);
      f = this.mTotalDrawCost / this.mTotalFrameCount;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloRender", 2, new Object[] { ",mTotalCost:", Integer.valueOf(this.mTotalDrawCost), ",mTotalFrameCount:", Integer.valueOf(this.mTotalFrameCount), ",mLongCostCount:", Integer.valueOf(this.mLongCostCount), ",avgCost:", Float.valueOf(f) });
      }
      localHashMap = new HashMap();
      localHashMap.put("gameId", Integer.toString(this.mGameId));
      localHashMap.put("avgDrawCost", Float.toString(f));
      localHashMap.put("longCostCount", Integer.toString(this.mLongCostCount));
      localHashMap.put("totalFrameCount", Integer.toString(this.mTotalFrameCount));
      localObject2 = CmGameUtil.a();
    } while (localObject2 == null);
    localObject2 = ((AppInterface)localObject2).getCurrentAccountUin();
    StatisticCollector.a(BaseApplicationImpl.getContext()).a((String)localObject2, "light_game_draw_cost_report", true, 0L, 0L, localHashMap, "", true);
  }
  
  /* Error */
  public void onDrawFrame(GL10 paramGL10)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 2040	com/tencent/mobileqq/apollo/ApolloRender:needRenderFrame	Z
    //   4: ifeq +50 -> 54
    //   7: getstatic 2045	android/os/Build$VERSION:SDK_INT	I
    //   10: istore_2
    //   11: aload_0
    //   12: getfield 217	com/tencent/mobileqq/apollo/ApolloRender:mSavaWrapper	Lcom/tencent/mobileqq/apollo/ApolloEngine;
    //   15: ldc_w 2047
    //   18: invokevirtual 1585	com/tencent/mobileqq/apollo/ApolloEngine:a	(Ljava/lang/String;)V
    //   21: iload_2
    //   22: bipush 26
    //   24: if_icmplt +202 -> 226
    //   27: aload_0
    //   28: getfield 2049	com/tencent/mobileqq/apollo/ApolloRender:needRenderNum	I
    //   31: iconst_1
    //   32: if_icmpne +181 -> 213
    //   35: aload_0
    //   36: iconst_0
    //   37: putfield 2040	com/tencent/mobileqq/apollo/ApolloRender:needRenderFrame	Z
    //   40: aload_0
    //   41: iconst_0
    //   42: putfield 2049	com/tencent/mobileqq/apollo/ApolloRender:needRenderNum	I
    //   45: ldc 49
    //   47: iconst_2
    //   48: ldc_w 2051
    //   51: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: invokestatic 1935	java/lang/System:currentTimeMillis	()J
    //   57: lstore_3
    //   58: lload_3
    //   59: aload_0
    //   60: getfield 1937	com/tencent/mobileqq/apollo/ApolloRender:lastFrame	J
    //   63: lsub
    //   64: lstore 5
    //   66: aload_0
    //   67: lload_3
    //   68: putfield 1937	com/tencent/mobileqq/apollo/ApolloRender:lastFrame	J
    //   71: invokestatic 796	com/tencent/mobileqq/apollo/ApolloRender:getRenderViewByThreadId	()Landroid/view/View;
    //   74: astore 9
    //   76: aload 9
    //   78: instanceof 1165
    //   81: ifeq +125 -> 206
    //   84: aload 9
    //   86: checkcast 1165	com/tencent/mobileqq/apollo/ApolloSurfaceView
    //   89: getfield 1300	com/tencent/mobileqq/apollo/ApolloSurfaceView:mRenderMode	I
    //   92: iconst_1
    //   93: if_icmpne +113 -> 206
    //   96: invokestatic 1935	java/lang/System:currentTimeMillis	()J
    //   99: lstore 7
    //   101: lload 5
    //   103: ldc2_w 2052
    //   106: lcmp
    //   107: ifge +12 -> 119
    //   110: ldc2_w 2052
    //   113: lload 5
    //   115: lsub
    //   116: invokestatic 2056	java/lang/Thread:sleep	(J)V
    //   119: aload_0
    //   120: getfield 1986	com/tencent/mobileqq/apollo/ApolloRender:mIsNeedReport	Z
    //   123: ifeq +59 -> 182
    //   126: lload 5
    //   128: lload_3
    //   129: lcmp
    //   130: ifge +52 -> 182
    //   133: lload 5
    //   135: lconst_0
    //   136: lcmp
    //   137: ifle +45 -> 182
    //   140: aload_0
    //   141: aload_0
    //   142: getfield 1988	com/tencent/mobileqq/apollo/ApolloRender:mTotalDrawCost	I
    //   145: i2l
    //   146: lload 5
    //   148: ladd
    //   149: l2i
    //   150: putfield 1988	com/tencent/mobileqq/apollo/ApolloRender:mTotalDrawCost	I
    //   153: aload_0
    //   154: aload_0
    //   155: getfield 1990	com/tencent/mobileqq/apollo/ApolloRender:mTotalFrameCount	I
    //   158: iconst_1
    //   159: iadd
    //   160: putfield 1990	com/tencent/mobileqq/apollo/ApolloRender:mTotalFrameCount	I
    //   163: lload 5
    //   165: ldc2_w 2057
    //   168: lcmp
    //   169: ifle +13 -> 182
    //   172: aload_0
    //   173: aload_0
    //   174: getfield 1998	com/tencent/mobileqq/apollo/ApolloRender:mLongCostCount	I
    //   177: iconst_1
    //   178: iadd
    //   179: putfield 1998	com/tencent/mobileqq/apollo/ApolloRender:mLongCostCount	I
    //   182: aload_0
    //   183: invokevirtual 2061	com/tencent/mobileqq/apollo/ApolloRender:updateNioSocket	()V
    //   186: aload_0
    //   187: getfield 250	com/tencent/mobileqq/apollo/ApolloRender:mApolloTicker	Lcom/tencent/mobileqq/apollo/ApolloTicker;
    //   190: aload_0
    //   191: getfield 250	com/tencent/mobileqq/apollo/ApolloRender:mApolloTicker	Lcom/tencent/mobileqq/apollo/ApolloTicker;
    //   194: getfield 1449	com/tencent/mobileqq/apollo/ApolloTicker:ticker	J
    //   197: lload 7
    //   199: l2d
    //   200: ldc2_w 2062
    //   203: invokevirtual 2067	com/tencent/mobileqq/apollo/ApolloTicker:nativeCallbackTicker	(JDD)V
    //   206: aload_0
    //   207: aload_1
    //   208: invokespecial 2069	com/tencent/mobileqq/apollo/ApolloRender:snapShot	(Ljavax/microedition/khronos/opengles/GL10;)Z
    //   211: pop
    //   212: return
    //   213: aload_0
    //   214: aload_0
    //   215: getfield 2049	com/tencent/mobileqq/apollo/ApolloRender:needRenderNum	I
    //   218: iconst_1
    //   219: iadd
    //   220: putfield 2049	com/tencent/mobileqq/apollo/ApolloRender:needRenderNum	I
    //   223: goto -178 -> 45
    //   226: aload_0
    //   227: iconst_0
    //   228: putfield 2040	com/tencent/mobileqq/apollo/ApolloRender:needRenderFrame	Z
    //   231: goto -186 -> 45
    //   234: astore 9
    //   236: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   239: ifeq -120 -> 119
    //   242: ldc 49
    //   244: iconst_2
    //   245: aload 9
    //   247: invokevirtual 449	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   250: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: goto -134 -> 119
    //   256: astore 9
    //   258: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   261: ifeq -55 -> 206
    //   264: ldc 49
    //   266: iconst_2
    //   267: aload 9
    //   269: invokevirtual 449	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   272: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   275: goto -69 -> 206
    //   278: astore 9
    //   280: ldc 49
    //   282: iconst_1
    //   283: ldc_w 2071
    //   286: invokestatic 459	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   289: goto -83 -> 206
    //   292: astore 9
    //   294: goto -175 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	297	0	this	ApolloRender
    //   0	297	1	paramGL10	GL10
    //   10	15	2	i	int
    //   57	72	3	l1	long
    //   64	100	5	l2	long
    //   99	99	7	l3	long
    //   74	11	9	localView	View
    //   234	12	9	localOutOfMemoryError1	OutOfMemoryError
    //   256	12	9	localOutOfMemoryError2	OutOfMemoryError
    //   278	1	9	localThrowable	Throwable
    //   292	1	9	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   110	119	234	java/lang/OutOfMemoryError
    //   182	206	256	java/lang/OutOfMemoryError
    //   182	206	278	java/lang/Throwable
    //   110	119	292	java/lang/Exception
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if (this.mSavaWrapper != null)
    {
      if ((this.mFinalRequestWidth <= 0) || (this.mFinalRequestHeight <= 0) || (this.mFinalRequestWidth * this.mScale < paramInt1) || (this.mFinalRequestHeight * this.mScale < paramInt2)) {
        break label194;
      }
      this.mSavaWrapper.a(this.mFinalRequestWidth, this.mFinalRequestHeight);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloRender", 2, "[onSurfaceChanged] mFinalRequestWidth:" + this.mFinalRequestWidth + ",mFinalRequestHeight:" + this.mFinalRequestHeight + ",mSavaWrapper:" + this.mSavaWrapper);
      }
      this.needRenderFrame = true;
    }
    for (;;)
    {
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
      if ((this.mCallbackRef != null) && (!this.mIsReadyNotify))
      {
        paramGL10 = (OnApolloViewListener)this.mCallbackRef.get();
        this.mIsReadyNotify = true;
        ThreadManager.post(new yrc(this, paramGL10, paramInt1, paramInt2), 5, null, true);
      }
      return;
      label194:
      this.mSavaWrapper.a((int)Math.ceil(paramInt1 / this.mScale), (int)Math.ceil(paramInt2 / this.mScale));
      this.needRenderFrame = true;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloRender", 2, "[onSurfaceChanged] width:" + paramInt1 + ",height:" + paramInt2 + ",mSavaWrapper:" + this.mSavaWrapper);
      }
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    long l1 = System.currentTimeMillis();
    long l2 = Thread.currentThread().getId();
    if ((WeakReference)sRenderMap.get(Long.valueOf(l2)) == null) {
      sRenderMap.put(Long.valueOf(l2), new WeakReference(this));
    }
    this.mGameId = CmGameUtil.a(getSavaWrapper().a());
    paramEGLConfig = CmGameUtil.a();
    if ((paramEGLConfig != null) && (this.mGameId > 0)) {
      if (paramEGLConfig.getLongAccountUin() % 10L != 1L) {
        break label189;
      }
    }
    label189:
    for (boolean bool = true;; bool = false)
    {
      this.mIsNeedReport = bool;
      setupDirector();
      this.mIsReadyNotify = false;
      paramEGLConfig = new int[1];
      paramGL10.glGetIntegerv(3379, paramEGLConfig, 0);
      QLog.i("ApolloRender", 1, "onSurfaceCreated  GL_MAX_TEXTURE_SIZE: " + paramEGLConfig[0]);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloRender", 2, " TextureView onSurfaceCreated use:" + (System.currentTimeMillis() - l1));
      }
      return;
    }
  }
  
  public void setBubbleType(int paramInt)
  {
    mBubbleType = paramInt;
  }
  
  public void setGameName(String paramString)
  {
    this.mGameName = paramString;
  }
  
  public void setRenderCallback(IRenderCallback paramIRenderCallback)
  {
    this.mRenderCallbackRef = new WeakReference(paramIRenderCallback);
  }
  
  public void setRenderView(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.mApolloViewRef = new WeakReference(paramView);
  }
  
  public void setRenderWidthAndHeight(int paramInt1, int paramInt2)
  {
    this.mFinalRequestWidth = ((int)Math.ceil(paramInt1 / this.mScale));
    this.mFinalRequestHeight = ((int)Math.ceil(paramInt2 / this.mScale));
  }
  
  public void snapShotOnce(ApolloRender.ISnapShotCallback paramISnapShotCallback, int paramInt, long paramLong)
  {
    this.mSnapShotCallback = paramISnapShotCallback;
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
        ApolloNioSocketInfo localApolloNioSocketInfo1;
        if ((i < 0) || (i < 0)) {
          continue;
        }
        localApolloNioSocketInfo2 = (ApolloNioSocketInfo)this.mNioList.get(i);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        try
        {
          localApolloNioSocketInfo1 = (ApolloNioSocketInfo)this.mNioList.get(i);
          if ((localApolloNioSocketInfo1 == null) || (localApolloNioSocketInfo1.jdField_c_of_type_Int == 1) || (!localApolloNioSocketInfo1.jdField_a_of_type_JavaNioChannelsSocketChannel.finishConnect())) {
            break label201;
          }
          localApolloNioSocketInfo1.jdField_c_of_type_Int = 1;
          getSavaWrapper().a(localApolloNioSocketInfo1.jdField_a_of_type_Long, 2);
          websocketShakeHand(localApolloNioSocketInfo1.jdField_a_of_type_Long, localApolloNioSocketInfo1.jdField_a_of_type_JavaLangString, localApolloNioSocketInfo1.jdField_a_of_type_Int, localApolloNioSocketInfo1.jdField_b_of_type_Int, 0, localApolloNioSocketInfo1.jdField_b_of_type_JavaLangString, localApolloNioSocketInfo1.jdField_c_of_type_JavaLangString, localApolloNioSocketInfo1.jdField_a_of_type_JavaNioChannelsSocketChannel.socket());
          this.mNioList.remove(localApolloNioSocketInfo1);
        }
        catch (Exception localException2)
        {
          int i;
          ApolloNioSocketInfo localApolloNioSocketInfo2;
          break label145;
          i -= 1;
        }
        localOutOfMemoryError = localOutOfMemoryError;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloRender", 2, localOutOfMemoryError.getMessage());
        }
        return;
      }
      catch (Exception localException1)
      {
        i = -1;
      }
      getSavaWrapper().a(localApolloNioSocketInfo2.jdField_a_of_type_Long, 3);
      this.mNioList.remove(i);
      QLog.e("nioCmGame", 2, " exception socket");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender
 * JD-Core Version:    0.7.0.1
 */