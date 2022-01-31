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
import android.graphics.Matrix;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.net.Uri;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build.VERSION;
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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.DoraemonOpenAPI;
import com.tencent.mobileqq.apollo.data.ApolloDevInfo;
import com.tencent.mobileqq.apollo.data.ApolloNioSocketInfo;
import com.tencent.mobileqq.apollo.data.ApolloSkeletonBounding;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.portal.StrokeTextView;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.utils.Base64Util;
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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
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
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import yhr;
import yhs;
import yht;
import yhu;
import yhv;
import yhw;
import yhx;
import yhy;
import yhz;
import yia;
import yib;
import yic;
import yie;
import yif;
import yig;
import yih;
import yii;
import yij;
import yil;
import yim;
import yio;
import yiq;
import yis;

public class ApolloRender
  implements GLSurfaceView.Renderer
{
  private static final String ACTION_RES_PREFIX = "ActionRes:";
  private static final String BASE_JS_PREFIX = "BaseJs:";
  public static String CMSHOW_FILE_PATH = AppConstants.aJ + "cmshow";
  public static final int ENGINE_TYPE_ACTION = 0;
  public static final int ENGINE_TYPE_GAME = 1;
  private static final String GAME_RES_PREFIX = "GameRes:";
  private static final String GAME_SAND_BOX_PREFIX = "GameSandBox:";
  public static final String HTTP_COOKIE = "Cookie";
  public static final String HTTP_REFERER = "Referer";
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
  private boolean mIsReadyNotify;
  private ReentrantLock mLock;
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
    if ((!PtvFilterSoLoad.b(BaseApplicationImpl.getContext())) && (!sIsDownLoadingSo))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloRender", 2, "createAIFaceDetecor download");
      }
      localObject = new yhy((ApolloRender)localObject);
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
  
  public static Bitmap drawTextOnBitmap(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRender", 2, "[drawTextOnBitmap], l:" + paramFloat1 + ",t:" + paramFloat2 + "w:" + paramFloat3 + ",h:" + paramFloat4 + ",bWidth:" + paramInt1 + ",bHeight:" + paramInt2 + ",text:" + paramString1 + ",slotName:" + paramString2 + ",rotate:" + paramInt3 + ",flip:" + paramInt4 + ",roleName:" + paramString3);
    }
    if ((TextUtils.isEmpty(paramString2)) || ((!"Bubble_Word".equals(paramString2)) && (!"Bubble_Name_Word".equals(paramString2))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloRender", 2, "errInfo->wrong slotName.");
      }
      return null;
    }
    boolean bool;
    Object localObject1;
    Object localObject3;
    Object localObject2;
    if (TextUtils.isEmpty(paramString3))
    {
      bool = false;
      localObject1 = null;
      localObject3 = "group_brand_" + paramInt1 + "_" + paramInt2;
      if (BaseApplicationImpl.sImageCache != null)
      {
        localObject2 = (Bitmap)BaseApplicationImpl.sImageCache.get(localObject3);
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d("ApolloRender", 2, "group brand ----> get bitmap from cache key: " + (String)localObject3);
            localObject1 = localObject2;
          }
        }
      }
      localObject2 = localObject1;
      if (localObject1 != null) {}
    }
    label1038:
    label1080:
    label1117:
    for (;;)
    {
      AppRuntime localAppRuntime;
      try
      {
        localObject1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        localObject2 = localObject1;
        if (BaseApplicationImpl.sImageCache != null)
        {
          BaseApplicationImpl.sImageCache.put(localObject3, localObject1);
          localObject2 = localObject1;
        }
        localObject3 = new TextView(BaseApplicationImpl.getContext());
        localObject1 = new Paint.FontMetricsInt();
        ((TextView)localObject3).getPaint().getFontMetricsInt((Paint.FontMetricsInt)localObject1);
        paramInt2 = ((Paint.FontMetricsInt)localObject1).ascent - ((Paint.FontMetricsInt)localObject1).top;
        if (paramInt2 != 0) {
          break label1356;
        }
        paramInt2 = (int)(2.0F * DeviceInfoUtil.a);
        paramInt1 = ApolloActionManager.a().a.get();
        localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        if (!(localAppRuntime instanceof QQAppInterface)) {
          break label1353;
        }
        localObject1 = (QQAppInterface)localAppRuntime;
        if (mBubbleType == -1) {
          break label1353;
        }
        paramInt1 = mBubbleType;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloRender", 2, "bubbleType:" + paramInt1);
        }
        localObject1 = paramString1;
      }
      catch (OutOfMemoryError paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloRender", 2, "errInfo->" + paramString1.getMessage());
        }
        return null;
      }
      catch (Exception paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloRender", 2, "errInfo->" + paramString1.getMessage());
        }
        return null;
      }
      try
      {
        if (!TextUtils.isEmpty(paramString1)) {
          if (paramInt1 != 0)
          {
            localObject1 = paramString1;
            if (1 != paramInt1) {}
          }
          else
          {
            byte[] arrayOfByte = Base64Util.decode(paramString1.getBytes("utf-8"), 0);
            localObject1 = paramString1;
            if (arrayOfByte != null) {
              localObject1 = new String(arrayOfByte);
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("ApolloRender", 1, localThrowable, new Object[0]);
        str = paramString1;
        continue;
        if (((1 != paramInt1) && (!bool)) || (!"Bubble_Name_Word".equals(paramString2))) {
          break label1117;
        }
        paramString1 = null;
        if (!(localAppRuntime instanceof QQAppInterface)) {
          break label1038;
        }
        paramString1 = (ApolloManager)((QQAppInterface)localAppRuntime).getManager(152);
        if (!bool) {
          break label1080;
        }
        paramInt1 = -6578766;
        for (;;)
        {
          ((TextView)localObject3).setGravity(17);
          ((TextView)localObject3).setTextColor(paramInt1);
          ((TextView)localObject3).setTextSize(42.0F / DeviceInfoUtil.a);
          paramInt1 = 1;
          break;
          if ((paramString1 != null) && (!TextUtils.isEmpty(paramString3)) && (paramString1.a(paramString3))) {
            paramInt1 = -8892195;
          } else {
            paramInt1 = -1;
          }
        }
        if (2 != paramInt1) {
          break label1156;
        }
        ((TextView)localObject3).setGravity(17);
        ((TextView)localObject3).setTextColor(-16777216);
        ((TextView)localObject3).setTextSize(30.0F / DeviceInfoUtil.a);
        paramInt1 = 3;
        continue;
        if (3 != paramInt1) {
          break label1195;
        }
        ((TextView)localObject3).setGravity(19);
        ((TextView)localObject3).setTextColor(-16777216);
        ((TextView)localObject3).setTextSize(21.0F / DeviceInfoUtil.a);
        paramInt1 = 2;
        continue;
        if ((4 != paramInt1) && (5 != paramInt1)) {
          break label1241;
        }
        ((TextView)localObject3).setGravity(17);
        ((TextView)localObject3).setTextColor(-7645212);
        ((TextView)localObject3).setTextSize(24.0F / DeviceInfoUtil.a);
        paramInt1 = 6;
        continue;
        if ((6 != paramInt1) && (7 != paramInt1)) {
          break label1347;
        }
        ((TextView)localObject3).setGravity(17);
        ((TextView)localObject3).setTextColor(-16777216);
        ((TextView)localObject3).setTextSize(27.0F / DeviceInfoUtil.a);
        ((TextView)localObject3).setPadding(0, paramInt2, 0, 0);
        paramInt1 = 2;
        continue;
        ((TextView)localObject3).setLineSpacing((paramInt2 + paramFloat4) / ((TextView)localObject3).getLineCount() - ((TextView)localObject3).getLineHeight(), 0.9F);
        continue;
        paramInt1 = 3;
        continue;
      }
      if ((!bool) && ((paramInt1 == 0) || ((1 == paramInt1) && ("Bubble_Word".equals(paramString2))) || (8 == paramInt1)))
      {
        ((TextView)localObject3).setGravity(17);
        ((TextView)localObject3).setTextColor(-16777216);
        ((TextView)localObject3).setTextSize(51.0F / DeviceInfoUtil.a);
        paramInt1 = 3;
        ((TextView)localObject3).setWidth((int)paramFloat3);
        ((TextView)localObject3).setHeight((int)paramFloat4 + paramInt2);
        ((TextView)localObject3).setText(ApolloUtil.a(((TextView)localObject3).getPaint(), paramFloat3, (String)localObject1, paramInt1));
        ((TextView)localObject3).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        paramInt3 = ((TextView)localObject3).getMeasuredWidth();
        ((TextView)localObject3).layout(0, 0, paramInt3, ((TextView)localObject3).getMeasuredHeight());
        if (QLog.isColorLevel()) {
          QLog.d("ApolloRender", 2, "lineHeight" + ((TextView)localObject3).getLineHeight());
        }
        if (((TextView)localObject3).getLineCount() != 0) {
          break label1298;
        }
        ((TextView)localObject3).setLineSpacing(59.0F - ((TextView)localObject3).getLineHeight(), 0.9F);
        paramInt1 = 1;
      }
      try
      {
        paramString1 = new Canvas((Bitmap)localObject2);
        paramString2 = new Matrix();
        if (1 == paramInt4)
        {
          paramString2.setValues(new float[] { -1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F });
          paramString2.postTranslate(paramFloat3, 0.0F);
          paramInt1 = -1;
        }
        paramString2.postTranslate(paramInt1 * (paramFloat3 - paramInt3) / 2.0F + paramFloat1, paramFloat2 - paramInt2);
        paramString1.setMatrix(paramString2);
        ((TextView)localObject3).draw(paramString1);
        return localObject2;
      }
      catch (Exception paramString1)
      {
        String str;
        if (!QLog.isColorLevel()) {
          break label1345;
        }
        QLog.d("ApolloRender", 2, "errInfo->canvas failure.");
        return null;
      }
      bool = paramString3.endsWith("pet");
      break;
    }
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
    for (;;)
    {
      try
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(paramString, localOptions);
        int i = localOptions.outWidth;
        int j = localOptions.outHeight;
        if ((i > paramInt1) || (j > paramInt2))
        {
          paramInt1 = Math.min(Math.round(i / paramInt1), Math.round(j / paramInt2));
          localOptions.inSampleSize = paramInt1;
          localOptions.inJustDecodeBounds = false;
          paramString = BitmapFactory.decodeFile(paramString, localOptions);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("ApolloRender", 1, "BitmapFactory.decodeFile failed:" + paramString.getMessage());
        return null;
      }
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
    paramDoraemonAPIManager.a("getCity", null, new yif(paramView, paramDoraemonAPIManager, paramLong, paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6));
  }
  
  public static void getLocationDoLocation(View paramView, DoraemonAPIManager paramDoraemonAPIManager, long paramLong, int paramInt, String paramString)
  {
    paramDoraemonAPIManager.a("getLocation", null, new yig(paramView, paramDoraemonAPIManager, paramLong, paramInt));
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
    ((DoraemonAPIManager)localObject).a("login", null, new yih(localView, (DoraemonAPIManager)localObject, paramLong, paramInt, paramString));
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
      for (;;)
      {
        return ((File)localObject).getAbsolutePath() + "/" + paramString;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloRender", 2, new Object[] { "file not exist, sandboxPath:", localObject });
        }
      }
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
  
  /* Error */
  public static Bitmap getTextViewBitmap(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload 6
    //   2: invokestatic 449	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5: ifeq +5 -> 10
    //   8: aconst_null
    //   9: areturn
    //   10: new 488	android/widget/TextView
    //   13: dup
    //   14: invokestatic 328	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   17: invokespecial 490	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   20: astore 8
    //   22: new 492	android/graphics/Paint$FontMetricsInt
    //   25: dup
    //   26: invokespecial 493	android/graphics/Paint$FontMetricsInt:<init>	()V
    //   29: astore 5
    //   31: aload 8
    //   33: invokevirtual 497	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   36: aload 5
    //   38: invokevirtual 503	android/text/TextPaint:getFontMetricsInt	(Landroid/graphics/Paint$FontMetricsInt;)I
    //   41: pop
    //   42: aload 5
    //   44: getfield 506	android/graphics/Paint$FontMetricsInt:ascent	I
    //   47: aload 5
    //   49: getfield 509	android/graphics/Paint$FontMetricsInt:top	I
    //   52: isub
    //   53: ifne +11 -> 64
    //   56: fconst_2
    //   57: getstatic 513	com/tencent/mobileqq/utils/DeviceInfoUtil:a	F
    //   60: fmul
    //   61: f2i
    //   62: istore 7
    //   64: aload 8
    //   66: iload_2
    //   67: invokevirtual 562	android/widget/TextView:setWidth	(I)V
    //   70: aload 8
    //   72: iload_3
    //   73: invokevirtual 565	android/widget/TextView:setHeight	(I)V
    //   76: iload 4
    //   78: ifne +264 -> 342
    //   81: aload 8
    //   83: iconst_3
    //   84: invokevirtual 550	android/widget/TextView:setGravity	(I)V
    //   87: aload 8
    //   89: iload_1
    //   90: invokevirtual 554	android/widget/TextView:setTextColor	(I)V
    //   93: aload 8
    //   95: iload_0
    //   96: i2f
    //   97: invokevirtual 559	android/widget/TextView:setTextSize	(F)V
    //   100: aload 8
    //   102: aload 6
    //   104: invokevirtual 574	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   107: aload 8
    //   109: iconst_0
    //   110: iconst_0
    //   111: invokestatic 580	android/view/View$MeasureSpec:makeMeasureSpec	(II)I
    //   114: iconst_0
    //   115: iconst_0
    //   116: invokestatic 580	android/view/View$MeasureSpec:makeMeasureSpec	(II)I
    //   119: invokevirtual 584	android/widget/TextView:measure	(II)V
    //   122: aload 8
    //   124: invokevirtual 587	android/widget/TextView:getMeasuredWidth	()I
    //   127: istore_0
    //   128: aload 8
    //   130: invokevirtual 590	android/widget/TextView:getMeasuredHeight	()I
    //   133: istore_1
    //   134: aload 8
    //   136: iconst_0
    //   137: iconst_0
    //   138: iload_0
    //   139: iload_1
    //   140: invokevirtual 594	android/widget/TextView:layout	(IIII)V
    //   143: aconst_null
    //   144: astore 5
    //   146: new 124	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   153: ldc_w 457
    //   156: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: iload_0
    //   160: invokevirtual 431	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   163: ldc_w 459
    //   166: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: iload_1
    //   170: invokevirtual 431	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   173: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: astore 9
    //   178: getstatic 463	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   181: ifnull +66 -> 247
    //   184: getstatic 463	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   187: aload 9
    //   189: invokevirtual 468	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   192: checkcast 470	android/graphics/Bitmap
    //   195: astore 6
    //   197: aload 6
    //   199: astore 5
    //   201: aload 6
    //   203: ifnull +44 -> 247
    //   206: aload 6
    //   208: astore 5
    //   210: invokestatic 247	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   213: ifeq +34 -> 247
    //   216: ldc 44
    //   218: iconst_2
    //   219: new 124	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   226: ldc_w 472
    //   229: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: aload 9
    //   234: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 266	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: aload 6
    //   245: astore 5
    //   247: aload 5
    //   249: astore 6
    //   251: aload 5
    //   253: ifnonnull +38 -> 291
    //   256: iload_0
    //   257: iload_1
    //   258: getstatic 478	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   261: invokestatic 482	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   264: astore 5
    //   266: aload 5
    //   268: astore 6
    //   270: getstatic 463	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   273: ifnull +18 -> 291
    //   276: getstatic 463	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   279: aload 9
    //   281: aload 5
    //   283: invokevirtual 486	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   286: pop
    //   287: aload 5
    //   289: astore 6
    //   291: aload 8
    //   293: new 610	android/graphics/Canvas
    //   296: dup
    //   297: aload 6
    //   299: invokespecial 613	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   302: invokevirtual 633	android/widget/TextView:draw	(Landroid/graphics/Canvas;)V
    //   305: aload 6
    //   307: areturn
    //   308: astore 5
    //   310: ldc 44
    //   312: iconst_2
    //   313: new 124	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   320: ldc_w 917
    //   323: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: aload 5
    //   328: invokevirtual 918	java/lang/Exception:toString	()Ljava/lang/String;
    //   331: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   337: invokestatic 732	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   340: aconst_null
    //   341: areturn
    //   342: iload 4
    //   344: iconst_1
    //   345: if_icmpne +13 -> 358
    //   348: aload 8
    //   350: bipush 17
    //   352: invokevirtual 550	android/widget/TextView:setGravity	(I)V
    //   355: goto -268 -> 87
    //   358: iload 4
    //   360: iconst_2
    //   361: if_icmpne -274 -> 87
    //   364: aload 8
    //   366: iconst_5
    //   367: invokevirtual 550	android/widget/TextView:setGravity	(I)V
    //   370: goto -283 -> 87
    //   373: astore 5
    //   375: invokestatic 247	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   378: ifeq +76 -> 454
    //   381: ldc 44
    //   383: iconst_2
    //   384: new 124	java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   391: ldc_w 641
    //   394: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: aload 5
    //   399: invokevirtual 644	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   402: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokestatic 266	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   411: goto +43 -> 454
    //   414: astore 5
    //   416: invokestatic 247	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   419: ifeq +33 -> 452
    //   422: ldc 44
    //   424: iconst_2
    //   425: new 124	java/lang/StringBuilder
    //   428: dup
    //   429: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   432: ldc_w 641
    //   435: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: aload 5
    //   440: invokevirtual 645	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   443: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   449: invokestatic 266	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   452: aconst_null
    //   453: areturn
    //   454: aconst_null
    //   455: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	456	0	paramInt1	int
    //   0	456	1	paramInt2	int
    //   0	456	2	paramInt3	int
    //   0	456	3	paramInt4	int
    //   0	456	4	paramInt5	int
    //   0	456	5	paramString1	String
    //   0	456	6	paramString2	String
    //   62	1	7	i	int
    //   20	345	8	localTextView	TextView
    //   176	104	9	str	String
    // Exception table:
    //   from	to	target	type
    //   10	64	308	java/lang/Exception
    //   64	76	308	java/lang/Exception
    //   81	87	308	java/lang/Exception
    //   87	143	308	java/lang/Exception
    //   146	178	308	java/lang/Exception
    //   178	197	308	java/lang/Exception
    //   210	243	308	java/lang/Exception
    //   291	305	308	java/lang/Exception
    //   348	355	308	java/lang/Exception
    //   364	370	308	java/lang/Exception
    //   375	411	308	java/lang/Exception
    //   416	452	308	java/lang/Exception
    //   256	266	373	java/lang/OutOfMemoryError
    //   270	287	373	java/lang/OutOfMemoryError
    //   256	266	414	java/lang/Exception
    //   270	287	414	java/lang/Exception
  }
  
  /* Error */
  public static Bitmap getTextViewBitmap(int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString2, int paramInt7, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt8)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 449	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
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
    //   18: getstatic 513	com/tencent/mobileqq/utils/DeviceInfoUtil:a	F
    //   21: f2d
    //   22: ddiv
    //   23: d2f
    //   24: fstore 16
    //   26: new 921	com/tencent/mobileqq/portal/StrokeTextView
    //   29: dup
    //   30: invokestatic 328	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   33: aconst_null
    //   34: invokespecial 924	com/tencent/mobileqq/portal/StrokeTextView:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   37: astore 17
    //   39: aload 17
    //   41: iconst_0
    //   42: invokevirtual 928	com/tencent/mobileqq/portal/StrokeTextView:setIncludeFontPadding	(Z)V
    //   45: aload 17
    //   47: iload_3
    //   48: invokevirtual 929	com/tencent/mobileqq/portal/StrokeTextView:setWidth	(I)V
    //   51: aload 17
    //   53: iload 4
    //   55: invokevirtual 930	com/tencent/mobileqq/portal/StrokeTextView:setHeight	(I)V
    //   58: iload 5
    //   60: ifne +379 -> 439
    //   63: aload 17
    //   65: iconst_3
    //   66: invokevirtual 931	com/tencent/mobileqq/portal/StrokeTextView:setGravity	(I)V
    //   69: iconst_0
    //   70: istore_3
    //   71: iload_3
    //   72: istore_0
    //   73: aload 7
    //   75: ifnull +39 -> 114
    //   78: iload_3
    //   79: istore_0
    //   80: aload 7
    //   82: ldc_w 811
    //   85: invokevirtual 292	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   88: ifne +26 -> 114
    //   91: aload 7
    //   93: invokestatic 937	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   96: astore 7
    //   98: iload_3
    //   99: istore_0
    //   100: aload 7
    //   102: ifnull +12 -> 114
    //   105: iconst_1
    //   106: istore_0
    //   107: aload 17
    //   109: aload 7
    //   111: invokevirtual 941	com/tencent/mobileqq/portal/StrokeTextView:setTypeface	(Landroid/graphics/Typeface;)V
    //   114: iload_0
    //   115: ifne +16 -> 131
    //   118: iload 6
    //   120: iconst_1
    //   121: if_icmpne +349 -> 470
    //   124: aload 17
    //   126: aconst_null
    //   127: iconst_1
    //   128: invokevirtual 944	com/tencent/mobileqq/portal/StrokeTextView:setTypeface	(Landroid/graphics/Typeface;I)V
    //   131: fload 9
    //   133: fconst_0
    //   134: fcmpl
    //   135: ifeq +33 -> 168
    //   138: fload 9
    //   140: ldc_w 945
    //   143: fcmpl
    //   144: ifeq +24 -> 168
    //   147: aload 17
    //   149: iconst_1
    //   150: invokevirtual 948	com/tencent/mobileqq/portal/StrokeTextView:setStrokeEnable	(Z)V
    //   153: aload 17
    //   155: fload 9
    //   157: f2i
    //   158: invokevirtual 951	com/tencent/mobileqq/portal/StrokeTextView:setStrokeSize	(I)V
    //   161: aload 17
    //   163: iload 8
    //   165: invokevirtual 954	com/tencent/mobileqq/portal/StrokeTextView:setStrokeColor	(I)V
    //   168: fload 10
    //   170: fconst_0
    //   171: fcmpl
    //   172: ifeq +25 -> 197
    //   175: fload 10
    //   177: ldc_w 945
    //   180: fcmpl
    //   181: ifeq +16 -> 197
    //   184: aload 17
    //   186: fload 10
    //   188: fload 11
    //   190: fload 12
    //   192: iload 13
    //   194: invokevirtual 958	com/tencent/mobileqq/portal/StrokeTextView:setShadow	(FFFI)V
    //   197: aload 17
    //   199: iload_1
    //   200: invokevirtual 961	com/tencent/mobileqq/portal/StrokeTextView:setInnerTextColor	(I)V
    //   203: aload 17
    //   205: fload 16
    //   207: invokevirtual 962	com/tencent/mobileqq/portal/StrokeTextView:setTextSize	(F)V
    //   210: aload 17
    //   212: aload_2
    //   213: invokevirtual 963	com/tencent/mobileqq/portal/StrokeTextView:setText	(Ljava/lang/CharSequence;)V
    //   216: aload 17
    //   218: iconst_0
    //   219: iconst_0
    //   220: invokestatic 580	android/view/View$MeasureSpec:makeMeasureSpec	(II)I
    //   223: iconst_0
    //   224: iconst_0
    //   225: invokestatic 580	android/view/View$MeasureSpec:makeMeasureSpec	(II)I
    //   228: invokevirtual 964	com/tencent/mobileqq/portal/StrokeTextView:measure	(II)V
    //   231: aload 17
    //   233: invokevirtual 965	com/tencent/mobileqq/portal/StrokeTextView:getMeasuredWidth	()I
    //   236: istore_0
    //   237: aload 17
    //   239: invokevirtual 966	com/tencent/mobileqq/portal/StrokeTextView:getMeasuredHeight	()I
    //   242: istore_1
    //   243: aload 17
    //   245: iconst_0
    //   246: iconst_0
    //   247: iload_0
    //   248: iload_1
    //   249: invokevirtual 967	com/tencent/mobileqq/portal/StrokeTextView:layout	(IIII)V
    //   252: aconst_null
    //   253: astore_2
    //   254: new 124	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   261: ldc_w 457
    //   264: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: iload_0
    //   268: invokevirtual 431	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   271: ldc_w 459
    //   274: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: iload_1
    //   278: invokevirtual 431	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   281: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: astore 18
    //   286: getstatic 463	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   289: ifnull +63 -> 352
    //   292: getstatic 463	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   295: aload 18
    //   297: invokevirtual 468	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   300: checkcast 470	android/graphics/Bitmap
    //   303: astore 7
    //   305: aload 7
    //   307: astore_2
    //   308: aload 7
    //   310: ifnull +42 -> 352
    //   313: aload 7
    //   315: astore_2
    //   316: invokestatic 247	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   319: ifeq +33 -> 352
    //   322: ldc 44
    //   324: iconst_2
    //   325: new 124	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   332: ldc_w 472
    //   335: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: aload 18
    //   340: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: invokestatic 266	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   349: aload 7
    //   351: astore_2
    //   352: aload_2
    //   353: astore 7
    //   355: aload_2
    //   356: ifnonnull +34 -> 390
    //   359: iload_0
    //   360: iload_1
    //   361: getstatic 478	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   364: invokestatic 482	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   367: astore_2
    //   368: aload_2
    //   369: astore 7
    //   371: getstatic 463	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   374: ifnull +16 -> 390
    //   377: getstatic 463	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   380: aload 18
    //   382: aload_2
    //   383: invokevirtual 486	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   386: pop
    //   387: aload_2
    //   388: astore 7
    //   390: aload 17
    //   392: new 610	android/graphics/Canvas
    //   395: dup
    //   396: aload 7
    //   398: invokespecial 613	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   401: invokevirtual 968	com/tencent/mobileqq/portal/StrokeTextView:draw	(Landroid/graphics/Canvas;)V
    //   404: aload 7
    //   406: areturn
    //   407: astore_2
    //   408: ldc 44
    //   410: iconst_2
    //   411: new 124	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   418: ldc_w 917
    //   421: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: aload_2
    //   425: invokevirtual 918	java/lang/Exception:toString	()Ljava/lang/String;
    //   428: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   434: invokestatic 732	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   437: aconst_null
    //   438: areturn
    //   439: iload 5
    //   441: iconst_1
    //   442: if_icmpne +13 -> 455
    //   445: aload 17
    //   447: bipush 17
    //   449: invokevirtual 931	com/tencent/mobileqq/portal/StrokeTextView:setGravity	(I)V
    //   452: goto -383 -> 69
    //   455: iload 5
    //   457: iconst_2
    //   458: if_icmpne -389 -> 69
    //   461: aload 17
    //   463: iconst_5
    //   464: invokevirtual 931	com/tencent/mobileqq/portal/StrokeTextView:setGravity	(I)V
    //   467: goto -398 -> 69
    //   470: iload 6
    //   472: iconst_2
    //   473: if_icmpne +13 -> 486
    //   476: aload 17
    //   478: aconst_null
    //   479: iconst_2
    //   480: invokevirtual 944	com/tencent/mobileqq/portal/StrokeTextView:setTypeface	(Landroid/graphics/Typeface;I)V
    //   483: goto -352 -> 131
    //   486: iload 6
    //   488: iconst_3
    //   489: if_icmpne -358 -> 131
    //   492: aload 17
    //   494: aconst_null
    //   495: iconst_3
    //   496: invokevirtual 944	com/tencent/mobileqq/portal/StrokeTextView:setTypeface	(Landroid/graphics/Typeface;I)V
    //   499: goto -368 -> 131
    //   502: astore_2
    //   503: invokestatic 247	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   506: ifeq +73 -> 579
    //   509: ldc 44
    //   511: iconst_2
    //   512: new 124	java/lang/StringBuilder
    //   515: dup
    //   516: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   519: ldc_w 641
    //   522: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: aload_2
    //   526: invokevirtual 644	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   529: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   535: invokestatic 266	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   538: goto +41 -> 579
    //   541: astore_2
    //   542: invokestatic 247	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   545: ifeq +32 -> 577
    //   548: ldc 44
    //   550: iconst_2
    //   551: new 124	java/lang/StringBuilder
    //   554: dup
    //   555: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   558: ldc_w 641
    //   561: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: aload_2
    //   565: invokevirtual 645	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   568: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   574: invokestatic 266	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    label185:
    do
    {
      for (;;)
      {
        try
        {
          localObject = Socket.class.getDeclaredField("impl");
          ((Field)localObject).setAccessible(true);
          paramSocket = (SocketImpl)((Field)localObject).get(paramSocket);
          localObject = SocketImpl.class.getDeclaredField("fd");
          ((Field)localObject).setAccessible(true);
          localObject = (FileDescriptor)((Field)localObject).get(paramSocket);
          paramSocket = null;
          Field[] arrayOfField = FileDescriptor.class.getDeclaredFields();
          i = 0;
          if (i >= arrayOfField.length) {
            break;
          }
          if ("descriptor".equals(arrayOfField[i].getName())) {
            paramSocket = FileDescriptor.class.getDeclaredField("descriptor");
          }
          if (!"fd".equals(arrayOfField[i].getName())) {
            break label185;
          }
          paramSocket = FileDescriptor.class.getDeclaredField("fd");
        }
        catch (Exception paramSocket)
        {
          Object localObject;
          int j;
          boolean bool;
          QLog.e("ApolloRender", 2, "socket exception e=" + paramSocket.toString());
          return 0;
        }
        paramSocket.setAccessible(true);
        j = paramSocket.getInt(localObject);
        bool = QLog.isColorLevel();
        i = j;
        if (!bool) {
          return i;
        }
        return j;
        i += 1;
      }
    } while (paramSocket != null);
    int i = 0;
    return i;
  }
  
  public static void hideKeyBoard(long paramLong)
  {
    ApolloRender localApolloRender = getRenderByThreadId();
    localApolloRender.mEditorAddr = paramLong;
    ThreadManager.getUIHandler().post(new yhw(localApolloRender));
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
    ThreadManager.post(new yil(paramString2, paramString1, paramArrayOfString, new yij(localView, paramLong), paramBoolean, paramString3, paramString4, paramString5), 5, null, true);
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
    ThreadManager.post(new yii(paramString2, paramString1, paramArrayOfByte, paramArrayOfString, new yic(paramString3, paramLong)), 5, null, true);
  }
  
  protected static byte[] jsha1(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = localMessageDigest.digest();
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      QLog.e("ApolloRender", 2, "java sha1  Error:" + paramArrayOfByte.getMessage());
    }
    return null;
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
  
  private static void recursionZip(ZipOutputStream paramZipOutputStream, File paramFile, String paramString)
  {
    int i = 0;
    Object localObject;
    byte[] arrayOfByte;
    if (paramFile.isDirectory())
    {
      paramString = paramString + File.separator + paramFile.getName();
      paramFile = paramFile.listFiles();
      int j = paramFile.length;
      if (i < j)
      {
        localObject = paramFile[i];
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          recursionZip(paramZipOutputStream, (File)localObject, paramString);
        }
      }
    }
    else
    {
      arrayOfByte = new byte[4096];
    }
    try
    {
      localObject = new BufferedInputStream(new FileInputStream(paramFile));
      try
      {
        paramZipOutputStream.putNextEntry(new ZipEntry(paramString + File.separator + paramFile.getName()));
        for (;;)
        {
          i = ((InputStream)localObject).read(arrayOfByte);
          if (i == -1) {
            break;
          }
          paramZipOutputStream.write(arrayOfByte, 0, i);
        }
        if (paramFile == null) {
          break label177;
        }
      }
      catch (Exception paramZipOutputStream)
      {
        paramFile = (File)localObject;
      }
    }
    catch (Exception paramZipOutputStream)
    {
      for (;;)
      {
        label177:
        paramFile = null;
      }
    }
    paramFile.close();
    paramZipOutputStream.printStackTrace();
    return;
    ((InputStream)localObject).close();
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
    ThreadManager.getUIHandler().post(new yia(paramLong, paramInt1, localView, localApolloRender));
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
          ((ApolloTextureView)localView).queueEvent(new yib(paramInt2, paramIntent, localView));
        } else {
          QLog.e("ApolloRender", 2, "imageselector view type else ");
        }
      }
    }
  }
  
  public static void setEditorBtnClick(ApolloSurfaceView paramApolloSurfaceView, ApolloRender paramApolloRender)
  {
    if (paramApolloRender.mEditorBtn != null) {
      paramApolloRender.mEditorBtn.setOnClickListener(new yio(paramApolloRender, paramApolloSurfaceView));
    }
  }
  
  public static void setEditorWatcher(ApolloSurfaceView paramApolloSurfaceView, ApolloRender paramApolloRender)
  {
    if (paramApolloRender.mEditorPop != null) {
      paramApolloRender.mEditorPop.addTextChangedListener(new yiq(paramApolloSurfaceView, paramApolloRender));
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
    ThreadManager.getUIHandler().post(new yie(localView, paramInt));
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
    ThreadManager.getUIHandler().post(new yhx(localApolloRender, paramString));
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
        paramApolloRender.mEditorPop = ((EditText)((RelativeLayout)localObject).findViewById(2131363171));
        ((RelativeLayout)localObject).requestLayout();
        ((RelativeLayout)localObject).post(new yis(paramApolloRender, (RelativeLayout)localObject));
        paramApolloRender.mEditorBtn = ((Button)((RelativeLayout)localObject).findViewById(2131363172));
        paramApolloRender.mEditorBtn.setWidth((int)(50.0F * DeviceInfoUtil.a));
        paramApolloRender.mEditWindow.setOutsideTouchable(false);
        paramApolloRender.mEditWindow.setFocusable(true);
        if (paramApolloRender.mEditorDefaultText != null)
        {
          paramApolloRender.mEditorPop.setText(paramApolloRender.mEditorDefaultText);
          paramApolloRender.mEditorPop.setSelection(paramApolloRender.mEditorDefaultText.length());
        }
        localObject = BaseApplicationImpl.getContext().getResources().getDrawable(2130845508);
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
        paramView.getRootView().postDelayed(new yhs(paramApolloRender, paramView, i), 1000L);
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
    //   0: invokestatic 1505	com/tencent/mobileqq/apollo/ApolloEngine:a	()Z
    //   3: ifeq +17 -> 20
    //   6: aload_0
    //   7: getfield 236	com/tencent/mobileqq/apollo/ApolloRender:mLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   10: ifnull +10 -> 20
    //   13: aload_0
    //   14: getfield 208	com/tencent/mobileqq/apollo/ApolloRender:mSavaWrapper	Lcom/tencent/mobileqq/apollo/ApolloEngine;
    //   17: ifnonnull +4 -> 21
    //   20: return
    //   21: aload_0
    //   22: getfield 236	com/tencent/mobileqq/apollo/ApolloRender:mLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   25: invokevirtual 1510	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   28: aload_0
    //   29: getfield 208	com/tencent/mobileqq/apollo/ApolloRender:mSavaWrapper	Lcom/tencent/mobileqq/apollo/ApolloEngine;
    //   32: lconst_0
    //   33: iconst_0
    //   34: iconst_0
    //   35: aload_0
    //   36: getfield 217	com/tencent/mobileqq/apollo/ApolloRender:mScale	F
    //   39: invokevirtual 1513	com/tencent/mobileqq/apollo/ApolloEngine:a	(JIIF)J
    //   42: lconst_0
    //   43: lcmp
    //   44: ifle +79 -> 123
    //   47: aload_0
    //   48: getfield 208	com/tencent/mobileqq/apollo/ApolloRender:mSavaWrapper	Lcom/tencent/mobileqq/apollo/ApolloEngine;
    //   51: aload_0
    //   52: ldc_w 1515
    //   55: ldc_w 1517
    //   58: invokevirtual 814	com/tencent/mobileqq/apollo/ApolloRender:getRscPath	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   61: invokevirtual 1519	com/tencent/mobileqq/apollo/ApolloEngine:b	(Ljava/lang/String;)V
    //   64: aload_0
    //   65: getfield 208	com/tencent/mobileqq/apollo/ApolloRender:mSavaWrapper	Lcom/tencent/mobileqq/apollo/ApolloEngine;
    //   68: getstatic 1522	com/tencent/mobileqq/apollo/ApolloManager:h	Ljava/lang/String;
    //   71: invokevirtual 1524	com/tencent/mobileqq/apollo/ApolloEngine:a	(Ljava/lang/String;)V
    //   74: aload_0
    //   75: getfield 208	com/tencent/mobileqq/apollo/ApolloRender:mSavaWrapper	Lcom/tencent/mobileqq/apollo/ApolloEngine;
    //   78: getstatic 1527	com/tencent/mobileqq/apollo/ApolloManager:g	Ljava/lang/String;
    //   81: invokevirtual 1524	com/tencent/mobileqq/apollo/ApolloEngine:a	(Ljava/lang/String;)V
    //   84: aload_0
    //   85: getfield 208	com/tencent/mobileqq/apollo/ApolloRender:mSavaWrapper	Lcom/tencent/mobileqq/apollo/ApolloEngine;
    //   88: getstatic 1529	com/tencent/mobileqq/apollo/ApolloManager:i	Ljava/lang/String;
    //   91: invokevirtual 1524	com/tencent/mobileqq/apollo/ApolloEngine:a	(Ljava/lang/String;)V
    //   94: aload_0
    //   95: getfield 208	com/tencent/mobileqq/apollo/ApolloRender:mSavaWrapper	Lcom/tencent/mobileqq/apollo/ApolloEngine;
    //   98: getstatic 1531	com/tencent/mobileqq/apollo/ApolloManager:j	Ljava/lang/String;
    //   101: invokevirtual 1524	com/tencent/mobileqq/apollo/ApolloEngine:a	(Ljava/lang/String;)V
    //   104: aload_0
    //   105: getfield 208	com/tencent/mobileqq/apollo/ApolloRender:mSavaWrapper	Lcom/tencent/mobileqq/apollo/ApolloEngine;
    //   108: aload_0
    //   109: getfield 217	com/tencent/mobileqq/apollo/ApolloRender:mScale	F
    //   112: invokevirtual 1533	com/tencent/mobileqq/apollo/ApolloEngine:a	(F)V
    //   115: aload_0
    //   116: getfield 236	com/tencent/mobileqq/apollo/ApolloRender:mLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   119: invokevirtual 1536	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   122: return
    //   123: ldc 44
    //   125: iconst_1
    //   126: ldc_w 1538
    //   129: invokestatic 732	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: goto -17 -> 115
    //   135: astore_1
    //   136: aload_0
    //   137: getfield 236	com/tencent/mobileqq/apollo/ApolloRender:mLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   140: invokevirtual 1536	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   143: aload_1
    //   144: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	ApolloRender
    //   135	9	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   28	115	135	finally
    //   123	132	135	finally
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
      localView.getViewTreeObserver().addOnGlobalLayoutListener(new yht(localApolloRender, localView));
    }
    ThreadManager.getUIHandler().post(new yhu(localApolloRender, localView));
    ThreadManager.getUIHandler().postDelayed(new yhv(), 500L);
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
    mDetectorThreadHandler.post(new yhz(localApolloRender, paramArrayOfByte, paramInt1, paramInt2));
    return arrayOfFaceStatus;
  }
  
  private static int unZip(String paramString1, String paramString2)
  {
    localObject1 = null;
    int j = 1;
    for (;;)
    {
      try
      {
        localFileInputStream = new FileInputStream(paramString1);
        localZipInputStream = new ZipInputStream(new BufferedInputStream(localFileInputStream));
      }
      catch (Exception paramString1)
      {
        FileInputStream localFileInputStream;
        ZipInputStream localZipInputStream;
        int i;
        byte[] arrayOfByte;
        Object localObject2;
        paramString1.printStackTrace();
        return 0;
      }
      try
      {
        paramString1 = localZipInputStream.getNextEntry();
        i = j;
        if (paramString1 != null)
        {
          Log.i("Unzip: ", "=" + paramString1);
          arrayOfByte = new byte[4096];
          paramString1 = paramString1.getName();
          paramString1 = new File(paramString2 + File.separator + paramString1);
          localObject2 = new File(paramString1.getParent());
          if (!((File)localObject2).exists()) {
            ((File)localObject2).mkdirs();
          }
          paramString1 = new FileOutputStream(paramString1);
        }
      }
      catch (Exception paramString1)
      {
        Object localObject3 = null;
        paramString2 = localObject1;
        localObject1 = localObject3;
        continue;
      }
      try
      {
        localObject2 = new BufferedOutputStream(paramString1, 4096);
        try
        {
          i = localZipInputStream.read(arrayOfByte, 0, 4096);
          if (i == -1) {
            continue;
          }
          ((BufferedOutputStream)localObject2).write(arrayOfByte, 0, i);
          continue;
          if (paramString2 == null) {
            continue;
          }
        }
        catch (Exception localException2)
        {
          localObject1 = localObject2;
          paramString2 = paramString1;
          paramString1 = localException2;
        }
      }
      catch (Exception localException1)
      {
        localObject1 = null;
        paramString2 = paramString1;
        paramString1 = localException1;
        continue;
      }
      paramString2.close();
      if (localObject1 != null) {
        localObject1.close();
      }
      paramString1.printStackTrace();
      i = 0;
      localFileInputStream.close();
      localZipInputStream.close();
      return i;
      ((BufferedOutputStream)localObject2).flush();
      ((BufferedOutputStream)localObject2).close();
      paramString1.close();
    }
  }
  
  protected static int websocketClose(long paramLong)
  {
    ApolloRender localApolloRender = getRenderByThreadId();
    SSLSocket localSSLSocket = (SSLSocket)localApolloRender.mSSLSocketMap.get(Long.valueOf(paramLong));
    if (localSSLSocket == null) {
      return 0;
    }
    BufferedInputStream localBufferedInputStream = (BufferedInputStream)localApolloRender.mBufferinputMap.get(Long.valueOf(paramLong));
    BufferedOutputStream localBufferedOutputStream = (BufferedOutputStream)localApolloRender.mBufferoutputMap.get(Long.valueOf(paramLong));
    if (localSSLSocket.isClosed())
    {
      localApolloRender.mSSLSocketMap.remove(Long.valueOf(paramLong));
      localApolloRender.mBufferinputMap.remove(Long.valueOf(paramLong));
      localApolloRender.mBufferoutputMap.remove(Long.valueOf(paramLong));
      return 0;
    }
    for (;;)
    {
      int i;
      try
      {
        localBufferedInputStream.close();
        localBufferedOutputStream.close();
        localSSLSocket.close();
        localApolloRender.mSSLSocketMap.remove(Long.valueOf(paramLong));
        localApolloRender.mBufferinputMap.remove(Long.valueOf(paramLong));
        localApolloRender.mBufferoutputMap.remove(Long.valueOf(paramLong));
        i = 0;
        if (i >= localApolloRender.mNioList.size()) {
          break;
        }
        if (((ApolloNioSocketInfo)localApolloRender.mNioList.get(i)).jdField_a_of_type_Long == paramLong)
        {
          localApolloRender.mNioList.remove(i);
          return 0;
        }
      }
      catch (Exception localException)
      {
        QLog.e("ApolloRender", 2, "websocket ssl close Error:" + localException.getMessage());
        return 0;
      }
      i += 1;
    }
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
    if ((localObject != null) && (paramInt > 0)) {
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
      catch (Exception localException)
      {
        QLog.e("ApolloRender", 2, "websocket ssl recv Error:" + localException.getMessage());
      }
    }
    return null;
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
    if (localBufferedOutputStream != null) {
      try
      {
        localBufferedOutputStream.write(paramArrayOfByte);
        localBufferedOutputStream.flush();
        int i = paramArrayOfByte.length;
        return i;
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.e("ApolloRender", 2, "websocket ssl send Error:" + paramArrayOfByte.getMessage());
      }
    }
    return 0;
  }
  
  protected static int websocketShakeHand(long paramLong, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, Socket paramSocket)
  {
    ApolloRender localApolloRender = getRenderByThreadId();
    View localView = getRenderViewByThreadId();
    if (localView == null) {
      Log.d("ApolloRender", "websocketShakeHand: view is null");
    }
    while (paramInt2 <= 0) {
      return 0;
    }
    for (;;)
    {
      try
      {
        ((ApolloSurfaceView)localView).getRender().getSavaWrapper().a(paramLong, 4);
        if ((paramString2 != null) && (!paramString2.equals("")))
        {
          paramString2 = SSLContext.getInstance(paramString2);
          paramString2.init(null, null, null);
          paramString1 = (SSLSocket)paramString2.getSocketFactory().createSocket(paramSocket, paramString1, paramInt1, true);
          paramString1.setUseClientMode(true);
          paramString1.setKeepAlive(true);
          if ((paramString3 != null) && (!paramString3.equals(""))) {
            paramString1.setEnabledProtocols(new String[] { paramString3 });
          }
          paramString1.addHandshakeCompletedListener(new yim(localView, paramLong));
          paramString1.startHandshake();
          paramInt1 = getfd(paramSocket);
          ((ApolloSurfaceView)localView).getRender().getSavaWrapper().b(paramLong, paramInt1);
          localApolloRender.mSSLSocketMap.put(Long.valueOf(paramLong), paramString1);
          paramString2 = new BufferedInputStream(paramString1.getInputStream());
          localApolloRender.mBufferinputMap.put(Long.valueOf(paramLong), paramString2);
          paramString1 = new BufferedOutputStream(paramString1.getOutputStream());
          localApolloRender.mBufferoutputMap.put(Long.valueOf(paramLong), paramString1);
          return 0;
        }
      }
      catch (Exception paramString1)
      {
        ((ApolloSurfaceView)localView).getRender().getSavaWrapper().a(paramLong, 6);
        QLog.e("ApolloRender", 2, "handshake Error:" + paramString1.getMessage());
        return 0;
      }
      paramString2 = SSLContext.getInstance("SSL");
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
    //   7: astore 7
    //   9: iconst_0
    //   10: istore 4
    //   12: iload 4
    //   14: aload_0
    //   15: arraylength
    //   16: if_icmpge +21 -> 37
    //   19: aload 7
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
    //   39: getstatic 478	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   42: invokestatic 482	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   45: astore 6
    //   47: aload 6
    //   49: aload 7
    //   51: invokestatic 1807	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   54: invokevirtual 1810	android/graphics/Bitmap:copyPixelsFromBuffer	(Ljava/nio/Buffer;)V
    //   57: invokestatic 272	com/tencent/mobileqq/apollo/ApolloRender:getRenderByThreadId	()Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   60: astore_0
    //   61: aload_0
    //   62: ifnull +10 -> 72
    //   65: aload_0
    //   66: invokevirtual 1096	com/tencent/mobileqq/apollo/ApolloRender:getSavaWrapper	()Lcom/tencent/mobileqq/apollo/ApolloEngine;
    //   69: ifnonnull +4 -> 73
    //   72: return
    //   73: aload_0
    //   74: invokevirtual 1096	com/tencent/mobileqq/apollo/ApolloRender:getSavaWrapper	()Lcom/tencent/mobileqq/apollo/ApolloEngine;
    //   77: invokevirtual 1812	com/tencent/mobileqq/apollo/ApolloEngine:a	()J
    //   80: invokestatic 1816	com/tencent/mobileqq/apollo/process/CmGameUtil:a	(J)I
    //   83: aload_3
    //   84: invokestatic 1818	com/tencent/mobileqq/apollo/ApolloRender:getSandBoxPath	(ILjava/lang/String;)Ljava/lang/String;
    //   87: astore_0
    //   88: aload_0
    //   89: ifnull -17 -> 72
    //   92: new 882	java/io/File
    //   95: dup
    //   96: aload_0
    //   97: invokespecial 888	java/io/File:<init>	(Ljava/lang/String;)V
    //   100: astore_0
    //   101: aload_0
    //   102: invokevirtual 891	java/io/File:exists	()Z
    //   105: ifeq +8 -> 113
    //   108: aload_0
    //   109: invokevirtual 1821	java/io/File:delete	()Z
    //   112: pop
    //   113: new 1648	java/io/FileOutputStream
    //   116: dup
    //   117: aload_0
    //   118: invokespecial 1649	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   121: astore_0
    //   122: aload_3
    //   123: ldc_w 857
    //   126: invokevirtual 639	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   129: ifne +188 -> 317
    //   132: aload_3
    //   133: ldc_w 1823
    //   136: invokevirtual 639	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   139: ifne +178 -> 317
    //   142: aload_3
    //   143: ldc_w 1825
    //   146: invokevirtual 639	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   149: ifne +168 -> 317
    //   152: aload_3
    //   153: ldc_w 1827
    //   156: invokevirtual 639	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   159: ifeq +6 -> 165
    //   162: goto +155 -> 317
    //   165: iload 5
    //   167: invokestatic 1832	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   170: invokevirtual 1835	java/lang/Boolean:booleanValue	()Z
    //   173: ifeq +41 -> 214
    //   176: aload 6
    //   178: getstatic 1841	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   181: bipush 50
    //   183: aload_0
    //   184: invokevirtual 1845	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   187: ifeq +12 -> 199
    //   190: aload_0
    //   191: invokevirtual 1846	java/io/FileOutputStream:flush	()V
    //   194: aload 6
    //   196: invokevirtual 1849	android/graphics/Bitmap:recycle	()V
    //   199: aload_0
    //   200: ifnull -128 -> 72
    //   203: aload_0
    //   204: invokevirtual 1659	java/io/FileOutputStream:close	()V
    //   207: return
    //   208: astore_0
    //   209: aload_0
    //   210: invokevirtual 1850	java/io/IOException:printStackTrace	()V
    //   213: return
    //   214: aload 6
    //   216: getstatic 1853	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   219: bipush 100
    //   221: aload_0
    //   222: invokevirtual 1845	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   225: ifeq -26 -> 199
    //   228: aload_0
    //   229: invokevirtual 1846	java/io/FileOutputStream:flush	()V
    //   232: aload 6
    //   234: invokevirtual 1849	android/graphics/Bitmap:recycle	()V
    //   237: goto -38 -> 199
    //   240: astore_3
    //   241: aload_3
    //   242: invokevirtual 1854	java/io/FileNotFoundException:printStackTrace	()V
    //   245: aload_0
    //   246: ifnull -174 -> 72
    //   249: aload_0
    //   250: invokevirtual 1659	java/io/FileOutputStream:close	()V
    //   253: return
    //   254: astore_0
    //   255: aload_0
    //   256: invokevirtual 1850	java/io/IOException:printStackTrace	()V
    //   259: return
    //   260: astore_0
    //   261: aconst_null
    //   262: astore_0
    //   263: aload_0
    //   264: ifnull -192 -> 72
    //   267: aload_0
    //   268: invokevirtual 1659	java/io/FileOutputStream:close	()V
    //   271: return
    //   272: astore_0
    //   273: aload_0
    //   274: invokevirtual 1850	java/io/IOException:printStackTrace	()V
    //   277: return
    //   278: astore_3
    //   279: aconst_null
    //   280: astore_0
    //   281: aload_0
    //   282: ifnull +7 -> 289
    //   285: aload_0
    //   286: invokevirtual 1659	java/io/FileOutputStream:close	()V
    //   289: aload_3
    //   290: athrow
    //   291: astore_0
    //   292: aload_0
    //   293: invokevirtual 1850	java/io/IOException:printStackTrace	()V
    //   296: goto -7 -> 289
    //   299: astore_3
    //   300: goto -19 -> 281
    //   303: astore_3
    //   304: goto -23 -> 281
    //   307: astore_3
    //   308: goto -45 -> 263
    //   311: astore_3
    //   312: aconst_null
    //   313: astore_0
    //   314: goto -73 -> 241
    //   317: iconst_1
    //   318: istore 5
    //   320: goto -155 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	paramArrayOfByte	byte[]
    //   0	323	1	paramInt1	int
    //   0	323	2	paramInt2	int
    //   0	323	3	paramString	String
    //   10	23	4	i	int
    //   1	318	5	bool	boolean
    //   45	188	6	localBitmap	Bitmap
    //   7	43	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   203	207	208	java/io/IOException
    //   122	152	240	java/io/FileNotFoundException
    //   152	162	240	java/io/FileNotFoundException
    //   165	199	240	java/io/FileNotFoundException
    //   214	237	240	java/io/FileNotFoundException
    //   249	253	254	java/io/IOException
    //   113	122	260	java/io/IOException
    //   267	271	272	java/io/IOException
    //   113	122	278	finally
    //   285	289	291	java/io/IOException
    //   122	152	299	finally
    //   152	162	299	finally
    //   165	199	299	finally
    //   214	237	299	finally
    //   241	245	303	finally
    //   122	152	307	java/io/IOException
    //   152	162	307	java/io/IOException
    //   165	199	307	java/io/IOException
    //   214	237	307	java/io/IOException
    //   113	122	311	java/io/FileNotFoundException
  }
  
  /* Error */
  public static int zip(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 1220	java/util/zip/ZipOutputStream
    //   3: dup
    //   4: new 1648	java/io/FileOutputStream
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 1856	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   12: invokespecial 1857	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   15: astore 4
    //   17: aload 4
    //   19: astore_1
    //   20: new 882	java/io/File
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 888	java/io/File:<init>	(Ljava/lang/String;)V
    //   28: astore_0
    //   29: aload_0
    //   30: ifnull +90 -> 120
    //   33: aload 4
    //   35: astore_1
    //   36: aload_0
    //   37: invokevirtual 891	java/io/File:exists	()Z
    //   40: ifeq +80 -> 120
    //   43: aload 4
    //   45: astore_1
    //   46: aload_0
    //   47: invokevirtual 1195	java/io/File:isDirectory	()Z
    //   50: ifeq +58 -> 108
    //   53: aload 4
    //   55: astore_1
    //   56: aload_0
    //   57: invokevirtual 1203	java/io/File:listFiles	()[Ljava/io/File;
    //   60: astore_0
    //   61: aload 4
    //   63: astore_1
    //   64: aload_0
    //   65: arraylength
    //   66: istore_3
    //   67: iconst_0
    //   68: istore_2
    //   69: goto +85 -> 154
    //   72: aload 4
    //   74: astore_1
    //   75: aload 4
    //   77: aload 5
    //   79: ldc_w 811
    //   82: invokestatic 1205	com/tencent/mobileqq/apollo/ApolloRender:recursionZip	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;)V
    //   85: goto +84 -> 169
    //   88: astore_1
    //   89: aload 4
    //   91: astore_0
    //   92: aload_1
    //   93: astore 4
    //   95: aload_0
    //   96: astore_1
    //   97: aload 4
    //   99: invokevirtual 1228	java/lang/Exception:printStackTrace	()V
    //   102: aload_0
    //   103: invokevirtual 1858	java/util/zip/ZipOutputStream:close	()V
    //   106: iconst_0
    //   107: ireturn
    //   108: aload 4
    //   110: astore_1
    //   111: aload 4
    //   113: aload_0
    //   114: ldc_w 811
    //   117: invokestatic 1205	com/tencent/mobileqq/apollo/ApolloRender:recursionZip	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;)V
    //   120: aload 4
    //   122: invokevirtual 1858	java/util/zip/ZipOutputStream:close	()V
    //   125: iconst_1
    //   126: ireturn
    //   127: astore_0
    //   128: aload_0
    //   129: invokevirtual 1228	java/lang/Exception:printStackTrace	()V
    //   132: iconst_0
    //   133: ireturn
    //   134: astore_0
    //   135: aconst_null
    //   136: astore_1
    //   137: aload_1
    //   138: invokevirtual 1858	java/util/zip/ZipOutputStream:close	()V
    //   141: aload_0
    //   142: athrow
    //   143: astore_0
    //   144: goto -7 -> 137
    //   147: astore 4
    //   149: aconst_null
    //   150: astore_0
    //   151: goto -56 -> 95
    //   154: iload_2
    //   155: iload_3
    //   156: if_icmpge -36 -> 120
    //   159: aload_0
    //   160: iload_2
    //   161: aaload
    //   162: astore 5
    //   164: aload 5
    //   166: ifnonnull -94 -> 72
    //   169: iload_2
    //   170: iconst_1
    //   171: iadd
    //   172: istore_2
    //   173: goto -19 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	paramString1	String
    //   0	176	1	paramString2	String
    //   68	105	2	i	int
    //   66	91	3	j	int
    //   15	106	4	localObject	Object
    //   147	1	4	localException	Exception
    //   77	88	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   20	29	88	java/lang/Exception
    //   36	43	88	java/lang/Exception
    //   46	53	88	java/lang/Exception
    //   56	61	88	java/lang/Exception
    //   64	67	88	java/lang/Exception
    //   75	85	88	java/lang/Exception
    //   111	120	88	java/lang/Exception
    //   102	106	127	java/lang/Exception
    //   120	125	127	java/lang/Exception
    //   137	143	127	java/lang/Exception
    //   0	17	134	finally
    //   20	29	143	finally
    //   36	43	143	finally
    //   46	53	143	finally
    //   56	61	143	finally
    //   64	67	143	finally
    //   75	85	143	finally
    //   97	102	143	finally
    //   111	120	143	finally
    //   0	17	147	java/lang/Exception
  }
  
  public native void bkDirectorChangeScreenMode(int paramInt);
  
  public void callbackFromJni(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRender", 2, "[callbackFromJni], eventCode:" + paramInt1 + ",roleName:" + paramString + ",taskId:" + paramInt2 + ",mSavaWrapper:" + this.mSavaWrapper);
    }
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
    finally
    {
      this.mLock.unlock();
    }
  }
  
  public String getRscPath(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRender", 2, "[getRscPath], name:" + paramString1 + ",type:" + paramString2);
    }
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
        break label665;
      }
      paramString1.append(".json");
    }
    for (;;)
    {
      localStringBuilder.append(paramString1.toString());
      if (QLog.isColorLevel()) {
        QLog.d("ApolloRender", 2, "ret:" + localStringBuilder.toString());
      }
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
      label665:
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
    for (;;)
    {
      return;
      this.mLock.lock();
      try
      {
        if (this.mSavaWrapper != null) {
          this.mSavaWrapper.a();
        }
        this.mLock.unlock();
        this.mIsReadyNotify = false;
        long l = Thread.currentThread().getId();
        if ((sRenderMap == null) || (!sRenderMap.containsKey(Long.valueOf(l)))) {
          continue;
        }
        sRenderMap.remove(Long.valueOf(l));
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ApolloRender", 2, "remove renderObj from map, id:" + l);
        return;
      }
      finally
      {
        this.mLock.unlock();
      }
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if (this.needRenderFrame)
    {
      int i = Build.VERSION.SDK_INT;
      this.mSavaWrapper.a("if(BK.Director.root){BK.Render.clear(0,0,0,0);BK.Render.treeRender( BK.Director.root,0);}");
      if (i < 26) {
        break label163;
      }
      if (this.needRenderNum != 1) {
        break label150;
      }
      this.needRenderFrame = false;
      this.needRenderNum = 0;
    }
    for (;;)
    {
      QLog.d("ApolloRender", 2, "onDrawFrame needRender");
      long l2 = System.currentTimeMillis();
      long l1 = l2 - this.lastFrame;
      this.lastFrame = l2;
      View localView = getRenderViewByThreadId();
      if (((localView instanceof ApolloSurfaceView)) && (((ApolloSurfaceView)localView).mRenderMode == 1))
      {
        l2 = System.currentTimeMillis();
        if (l1 >= 16L) {}
      }
      try
      {
        Thread.sleep(16L - l1);
        try
        {
          label119:
          updateNioSocket();
          this.mApolloTicker.nativeCallbackTicker(this.mApolloTicker.ticker, l2, 0.01666666666666667D);
          snapShot(paramGL10);
          return;
          label150:
          this.needRenderNum += 1;
          continue;
          label163:
          this.needRenderFrame = false;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            QLog.e("ApolloRender", 1, "[onDrawFrame]");
          }
        }
      }
      catch (Exception localException)
      {
        break label119;
      }
    }
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
        ThreadManager.post(new yhr(this, paramGL10, paramInt1, paramInt2), 5, null, true);
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
    setupDirector();
    this.mIsReadyNotify = false;
    paramEGLConfig = new int[1];
    paramGL10.glGetIntegerv(3379, paramEGLConfig, 0);
    QLog.i("ApolloRender", 1, "onSurfaceCreated  GL_MAX_TEXTURE_SIZE: " + paramEGLConfig[0]);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRender", 2, " TextureView onSurfaceCreated use:" + (System.currentTimeMillis() - l1));
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
    try
    {
      i = this.mNioList.size();
      i -= 1;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        ApolloNioSocketInfo localApolloNioSocketInfo2;
        int i = -1;
        continue;
        label183:
        i -= 1;
      }
    }
    if (i >= 0)
    {
      try
      {
        ApolloNioSocketInfo localApolloNioSocketInfo1 = (ApolloNioSocketInfo)this.mNioList.get(i);
        if ((localApolloNioSocketInfo1 == null) || (localApolloNioSocketInfo1.jdField_c_of_type_Int == 1) || (!localApolloNioSocketInfo1.jdField_a_of_type_JavaNioChannelsSocketChannel.finishConnect())) {
          break label183;
        }
        localApolloNioSocketInfo1.jdField_c_of_type_Int = 1;
        getSavaWrapper().a(localApolloNioSocketInfo1.jdField_a_of_type_Long, 2);
        websocketShakeHand(localApolloNioSocketInfo1.jdField_a_of_type_Long, localApolloNioSocketInfo1.jdField_a_of_type_JavaLangString, localApolloNioSocketInfo1.jdField_a_of_type_Int, localApolloNioSocketInfo1.jdField_b_of_type_Int, 0, localApolloNioSocketInfo1.jdField_b_of_type_JavaLangString, localApolloNioSocketInfo1.jdField_c_of_type_JavaLangString, localApolloNioSocketInfo1.jdField_a_of_type_JavaNioChannelsSocketChannel.socket());
        this.mNioList.remove(localApolloNioSocketInfo1);
      }
      catch (Exception localException1) {}
      if (i >= 0)
      {
        localApolloNioSocketInfo2 = (ApolloNioSocketInfo)this.mNioList.get(i);
        getSavaWrapper().a(localApolloNioSocketInfo2.jdField_a_of_type_Long, 3);
        this.mNioList.remove(i);
        QLog.e("nioCmGame", 2, " exception socket");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender
 * JD-Core Version:    0.7.0.1
 */