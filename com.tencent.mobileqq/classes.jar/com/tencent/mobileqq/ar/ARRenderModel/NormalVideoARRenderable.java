package com.tencent.mobileqq.ar.ARRenderModel;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ARVideoUtil;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo.ARVideoLayout;
import com.tencent.mobileqq.ar.keying.KeyingBase;
import com.tencent.mobileqq.ar.keying.KeyingBase.UserInterface;
import com.tencent.mobileqq.ar.keying.KeyingManager;
import com.tencent.mobileqq.ar.keying.KeyingParams;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

@TargetApi(14)
class NormalVideoARRenderable
  implements SurfaceTexture.OnFrameAvailableListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, ARBaseRender
{
  private int jdField_a_of_type_Int = 0;
  public long a;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer = null;
  ARRenderMangerInnerCallback jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback;
  NormalVideoARResourceInfo jdField_a_of_type_ComTencentMobileqqArARRenderModelNormalVideoARResourceInfo;
  private KeyingBase.UserInterface jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase$UserInterface = new NormalVideoARRenderable.1(this);
  private KeyingBase jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase;
  private KeyingParams jdField_a_of_type_ComTencentMobileqqArKeyingKeyingParams;
  private Runnable jdField_a_of_type_JavaLangRunnable = new NormalVideoARRenderable.3(this);
  private String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  public float[] a;
  private int jdField_b_of_type_Int = 0;
  public long b;
  private boolean jdField_b_of_type_Boolean = false;
  private float[] jdField_b_of_type_ArrayOfFloat = new float[16];
  private int jdField_c_of_type_Int = 1;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 0;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean = false;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  private boolean j = true;
  
  public NormalVideoARRenderable(ARRenderMangerInnerCallback paramARRenderMangerInnerCallback, NormalVideoARResourceInfo paramNormalVideoARResourceInfo)
  {
    this.jdField_a_of_type_ArrayOfFloat = new float[16];
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback = paramARRenderMangerInnerCallback;
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelNormalVideoARResourceInfo = paramNormalVideoARResourceInfo;
    this.jdField_a_of_type_JavaLangString = paramNormalVideoARResourceInfo.jdField_b_of_type_JavaLangString;
    this.jdField_c_of_type_Int = paramNormalVideoARResourceInfo.jdField_e_of_type_Int;
    this.jdField_a_of_type_Int = paramNormalVideoARResourceInfo.jdField_d_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingParams = paramNormalVideoARResourceInfo.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingParams;
    paramARRenderMangerInnerCallback = Build.MODEL.toLowerCase();
    if ((Build.MANUFACTURER.toLowerCase().contains("meizu")) && (paramARRenderMangerInnerCallback.contains("m040"))) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  private void a()
  {
    QLog.d("AREngine_ARVideoRenderable", 1, "initMedia, mHasMediaInit=" + this.jdField_d_of_type_Boolean);
    if (this.jdField_d_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_d_of_type_Boolean = true;
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        QLog.d("AREngine_ARVideoRenderable", 1, "initMedia failed, mVideoPath is empty");
        return;
      }
      if (!new File(this.jdField_a_of_type_JavaLangString).exists())
      {
        QLog.d("AREngine_ARVideoRenderable", 1, "initMedia failed, file not exist");
        return;
      }
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(this);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(this);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnBufferingUpdateListener(this);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(this);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnInfoListener(this);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(false);
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.jdField_d_of_type_Int);
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
        Surface localSurface = new Surface(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setSurface(localSurface);
        localSurface.release();
        this.jdField_d_of_type_Boolean = true;
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.d("AREngine_ARVideoRenderable", 1, "init, throwable t = " + localThrowable.getMessage());
      }
    } while (!QLog.isColorLevel());
    localThrowable.printStackTrace();
  }
  
  private void b()
  {
    QLog.d("AREngine_ARVideoRenderable", 1, "initGl, mHasMediaInit=" + this.jdField_d_of_type_Boolean);
    Matrix.setIdentityM(this.jdField_b_of_type_ArrayOfFloat, 0);
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    this.jdField_d_of_type_Int = arrayOfInt[0];
    QLog.d("AREngine_ARVideoRenderable", 1, "initGl, mTextureID=" + this.jdField_d_of_type_Int);
    if (this.jdField_d_of_type_Int == 0) {
      return;
    }
    g();
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase = KeyingManager.a(this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingParams, 1);
      this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase.a(ARVideoUtil.jdField_a_of_type_ArrayOfFloat, ARVideoUtil.jdField_a_of_type_ArrayOfShort);
      this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase.a("uniform int uDisplayType;\n", null, "    if(uDisplayType == 1){\n        // 需要渲染成圆形\n        float x = vTextureCoord.x;\n        float y = vTextureCoord.y;\n        // 圆心(0.5, 0.5), 0.25=0.5*0.5\n        if(pow(abs(x-0.5), 2.0) + pow(abs(y-0.5), 2.0) >= 0.25) {\n            gl_FragColor[3] = 0.0;\n        }\n    }\n", this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase$UserInterface);
      this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelNormalVideoARResourceInfo.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqArARRenderModelNormalVideoARResourceInfo.jdField_a_of_type_Float, this.jdField_a_of_type_ComTencentMobileqqArARRenderModelNormalVideoARResourceInfo.jdField_b_of_type_Float, this.jdField_a_of_type_ComTencentMobileqqArARRenderModelNormalVideoARResourceInfo.jdField_c_of_type_Float);
    }
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARVideoRenderable", 2, "isColorLevel, mLoopCount=" + this.jdField_c_of_type_Int + ", mCurPlayCount=" + this.jdField_b_of_type_Int);
    }
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(ARRenerArumentManager.DrawFrameParements paramDrawFrameParements)
  {
    a((float[])paramDrawFrameParements.a("TARGET_SIZE"), (float[])paramDrawFrameParements.a("POSE"), (float[])paramDrawFrameParements.a("CAMERA_MATRIX"), (float[])paramDrawFrameParements.a("CAMERA_POSITION"));
  }
  
  public void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4)
  {
    if ((!this.jdField_e_of_type_Boolean) || (paramArrayOfFloat2 == null) || (paramArrayOfFloat3 == null) || (paramArrayOfFloat4 == null) || (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelNormalVideoARResourceInfo == null)) {
      return;
    }
    GLES20.glBlendFunc(770, 771);
    GLES20.glEnable(3042);
    if (this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase == null) {
      g();
    }
    int k;
    KeyingParams localKeyingParams;
    if ((this.jdField_a_of_type_ComTencentMobileqqArARRenderModelNormalVideoARResourceInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelNormalVideoARResourceInfo.jdField_b_of_type_Int == 1)) {
      if (this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase != null)
      {
        paramArrayOfFloat2 = this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase;
        k = this.jdField_d_of_type_Int;
        localKeyingParams = this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingParams;
        paramArrayOfFloat1 = a(paramArrayOfFloat1, paramArrayOfFloat3, paramArrayOfFloat4);
        paramArrayOfFloat3 = this.jdField_b_of_type_ArrayOfFloat;
        paramArrayOfFloat2.a(new int[] { k }, localKeyingParams, paramArrayOfFloat1, paramArrayOfFloat3);
      }
    }
    for (;;)
    {
      GLES20.glDisable(3042);
      GLES20.glBindTexture(36197, 0);
      if (!this.j) {
        break;
      }
      this.j = false;
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase != null)
      {
        paramArrayOfFloat3 = this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase;
        k = this.jdField_d_of_type_Int;
        localKeyingParams = this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingParams;
        paramArrayOfFloat1 = a(paramArrayOfFloat1, paramArrayOfFloat2, paramArrayOfFloat4);
        paramArrayOfFloat2 = this.jdField_b_of_type_ArrayOfFloat;
        paramArrayOfFloat3.a(new int[] { k }, localKeyingParams, paramArrayOfFloat1, paramArrayOfFloat2);
      }
    }
  }
  
  public float[] a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3)
  {
    Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
    if (c() == 2)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelNormalVideoARResourceInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$ARVideoLayout != null)
      {
        Matrix.scaleM(this.jdField_a_of_type_ArrayOfFloat, 0, this.jdField_a_of_type_ComTencentMobileqqArARRenderModelNormalVideoARResourceInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$ARVideoLayout.jdField_a_of_type_Float * paramArrayOfFloat1[0], this.jdField_a_of_type_ComTencentMobileqqArARRenderModelNormalVideoARResourceInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$ARVideoLayout.jdField_b_of_type_Float * paramArrayOfFloat1[1], 1.0F);
        Matrix.translateM(this.jdField_a_of_type_ArrayOfFloat, 0, this.jdField_a_of_type_ComTencentMobileqqArARRenderModelNormalVideoARResourceInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$ARVideoLayout.jdField_c_of_type_Float, this.jdField_a_of_type_ComTencentMobileqqArARRenderModelNormalVideoARResourceInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$ARVideoLayout.d, this.jdField_a_of_type_ComTencentMobileqqArARRenderModelNormalVideoARResourceInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$ARVideoLayout.e);
      }
      return this.jdField_a_of_type_ArrayOfFloat;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelNormalVideoARResourceInfo.jdField_c_of_type_Int == 1) {}
    for (;;)
    {
      Matrix.multiplyMM(this.jdField_a_of_type_ArrayOfFloat, 0, paramArrayOfFloat2, 0, this.jdField_a_of_type_ArrayOfFloat, 0);
      Matrix.multiplyMM(this.jdField_a_of_type_ArrayOfFloat, 0, paramArrayOfFloat3, 0, this.jdField_a_of_type_ArrayOfFloat, 0);
      break;
      Matrix.scaleM(this.jdField_a_of_type_ArrayOfFloat, 0, paramArrayOfFloat1[0], paramArrayOfFloat1[1], 1.0F);
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelNormalVideoARResourceInfo != null) {
      return this.jdField_a_of_type_ComTencentMobileqqArARRenderModelNormalVideoARResourceInfo.jdField_a_of_type_Int;
    }
    return 2;
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelNormalVideoARResourceInfo != null) {
      return this.jdField_a_of_type_ComTencentMobileqqArARRenderModelNormalVideoARResourceInfo.jdField_b_of_type_Int;
    }
    return 0;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArARRenderModelNormalVideoARResourceInfo.jdField_a_of_type_JavaLangString;
  }
  
  public void c()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    QLog.d("AREngine_ARVideoRenderable", 1, "init");
    b();
    a();
  }
  
  /* Error */
  public void d()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc 148
    //   4: iconst_1
    //   5: ldc_w 384
    //   8: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14: ifeq +29 -> 43
    //   17: ldc 148
    //   19: iconst_2
    //   20: new 150	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   27: ldc_w 386
    //   30: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_0
    //   34: invokevirtual 389	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: aload_0
    //   44: getfield 53	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:jdField_b_of_type_Boolean	Z
    //   47: ifne +20 -> 67
    //   50: aload_0
    //   51: getfield 51	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   54: ifnull +13 -> 67
    //   57: aload_0
    //   58: getfield 51	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   61: invokevirtual 392	android/media/MediaPlayer:isPlaying	()Z
    //   64: ifeq +52 -> 116
    //   67: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   70: ifeq +45 -> 115
    //   73: ldc 148
    //   75: iconst_2
    //   76: new 150	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   83: ldc_w 394
    //   86: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_0
    //   90: getfield 53	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:jdField_b_of_type_Boolean	Z
    //   93: invokevirtual 160	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   96: ldc_w 396
    //   99: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_0
    //   103: getfield 51	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   106: invokevirtual 389	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   115: return
    //   116: aload_0
    //   117: iconst_0
    //   118: putfield 71	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:h	Z
    //   121: aload_0
    //   122: iconst_0
    //   123: putfield 65	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:jdField_e_of_type_Boolean	Z
    //   126: new 398	java/io/FileInputStream
    //   129: dup
    //   130: new 177	java/io/File
    //   133: dup
    //   134: aload_0
    //   135: getfield 109	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   138: invokespecial 180	java/io/File:<init>	(Ljava/lang/String;)V
    //   141: invokespecial 401	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   144: astore_3
    //   145: aload_3
    //   146: astore_2
    //   147: aload_3
    //   148: invokevirtual 405	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   151: astore 4
    //   153: aload_3
    //   154: astore_2
    //   155: aload_0
    //   156: getfield 51	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   159: aload 4
    //   161: invokevirtual 409	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   164: aload_3
    //   165: astore_2
    //   166: aload_0
    //   167: iconst_1
    //   168: putfield 57	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:jdField_b_of_type_Int	I
    //   171: aload_3
    //   172: astore_2
    //   173: aload_0
    //   174: getfield 51	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   177: astore 4
    //   179: aload_3
    //   180: astore_2
    //   181: aload_0
    //   182: getfield 59	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:jdField_c_of_type_Int	I
    //   185: ifne +96 -> 281
    //   188: aload_3
    //   189: astore_2
    //   190: aload 4
    //   192: iload_1
    //   193: invokevirtual 213	android/media/MediaPlayer:setLooping	(Z)V
    //   196: aload_3
    //   197: astore_2
    //   198: aload_0
    //   199: iconst_1
    //   200: putfield 69	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:g	Z
    //   203: aload_3
    //   204: astore_2
    //   205: aload_0
    //   206: getfield 51	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   209: invokevirtual 412	android/media/MediaPlayer:prepare	()V
    //   212: aload_3
    //   213: astore_2
    //   214: aload_0
    //   215: iconst_0
    //   216: putfield 67	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:f	Z
    //   219: aload_3
    //   220: astore_2
    //   221: aload_0
    //   222: getfield 51	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   225: invokevirtual 414	android/media/MediaPlayer:start	()V
    //   228: aload_3
    //   229: astore_2
    //   230: aload_0
    //   231: iconst_1
    //   232: putfield 53	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:jdField_b_of_type_Boolean	Z
    //   235: aload_3
    //   236: astore_2
    //   237: aload_0
    //   238: getfield 101	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback	Lcom/tencent/mobileqq/ar/ARRenderModel/ARRenderMangerInnerCallback;
    //   241: ifnull +19 -> 260
    //   244: aload_3
    //   245: astore_2
    //   246: aload_0
    //   247: getfield 101	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback	Lcom/tencent/mobileqq/ar/ARRenderModel/ARRenderMangerInnerCallback;
    //   250: iconst_0
    //   251: aload_0
    //   252: getfield 59	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:jdField_c_of_type_Int	I
    //   255: invokeinterface 418 3 0
    //   260: aload_3
    //   261: ifnull -146 -> 115
    //   264: aload_3
    //   265: invokevirtual 421	java/io/FileInputStream:close	()V
    //   268: return
    //   269: astore_2
    //   270: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   273: ifeq -158 -> 115
    //   276: aload_2
    //   277: invokevirtual 245	java/lang/Throwable:printStackTrace	()V
    //   280: return
    //   281: iconst_0
    //   282: istore_1
    //   283: goto -95 -> 188
    //   286: astore 4
    //   288: aconst_null
    //   289: astore_3
    //   290: aload_3
    //   291: astore_2
    //   292: ldc 148
    //   294: iconst_2
    //   295: new 150	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   302: ldc_w 423
    //   305: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: aload 4
    //   310: invokevirtual 424	java/io/IOException:getMessage	()Ljava/lang/String;
    //   313: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   322: aload_3
    //   323: astore_2
    //   324: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   327: ifeq +10 -> 337
    //   330: aload_3
    //   331: astore_2
    //   332: aload 4
    //   334: invokevirtual 425	java/io/IOException:printStackTrace	()V
    //   337: aload_3
    //   338: astore_2
    //   339: aload_0
    //   340: invokevirtual 427	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:f	()V
    //   343: aload_3
    //   344: ifnull -229 -> 115
    //   347: aload_3
    //   348: invokevirtual 421	java/io/FileInputStream:close	()V
    //   351: return
    //   352: astore_2
    //   353: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   356: ifeq -241 -> 115
    //   359: aload_2
    //   360: invokevirtual 245	java/lang/Throwable:printStackTrace	()V
    //   363: return
    //   364: astore 4
    //   366: aconst_null
    //   367: astore_3
    //   368: aload_3
    //   369: astore_2
    //   370: ldc 148
    //   372: iconst_2
    //   373: new 150	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   380: ldc_w 429
    //   383: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: aload 4
    //   388: invokevirtual 239	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   391: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   400: aload_3
    //   401: astore_2
    //   402: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   405: ifeq +10 -> 415
    //   408: aload_3
    //   409: astore_2
    //   410: aload 4
    //   412: invokevirtual 245	java/lang/Throwable:printStackTrace	()V
    //   415: aload_3
    //   416: astore_2
    //   417: aload_0
    //   418: invokevirtual 427	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:f	()V
    //   421: aload_3
    //   422: ifnull -307 -> 115
    //   425: aload_3
    //   426: invokevirtual 421	java/io/FileInputStream:close	()V
    //   429: return
    //   430: astore_2
    //   431: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   434: ifeq -319 -> 115
    //   437: aload_2
    //   438: invokevirtual 245	java/lang/Throwable:printStackTrace	()V
    //   441: return
    //   442: astore_3
    //   443: aconst_null
    //   444: astore_2
    //   445: aload_2
    //   446: ifnull +7 -> 453
    //   449: aload_2
    //   450: invokevirtual 421	java/io/FileInputStream:close	()V
    //   453: aload_3
    //   454: athrow
    //   455: astore_2
    //   456: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   459: ifeq -6 -> 453
    //   462: aload_2
    //   463: invokevirtual 245	java/lang/Throwable:printStackTrace	()V
    //   466: goto -13 -> 453
    //   469: astore_3
    //   470: goto -25 -> 445
    //   473: astore 4
    //   475: goto -107 -> 368
    //   478: astore 4
    //   480: goto -190 -> 290
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	483	0	this	NormalVideoARRenderable
    //   1	282	1	bool	boolean
    //   146	100	2	localFileInputStream1	java.io.FileInputStream
    //   269	8	2	localThrowable1	Throwable
    //   291	48	2	localFileInputStream2	java.io.FileInputStream
    //   352	8	2	localThrowable2	Throwable
    //   369	48	2	localFileInputStream3	java.io.FileInputStream
    //   430	8	2	localThrowable3	Throwable
    //   444	6	2	localObject1	Object
    //   455	8	2	localThrowable4	Throwable
    //   144	282	3	localFileInputStream4	java.io.FileInputStream
    //   442	12	3	localObject2	Object
    //   469	1	3	localObject3	Object
    //   151	40	4	localObject4	Object
    //   286	47	4	localIOException1	java.io.IOException
    //   364	47	4	localThrowable5	Throwable
    //   473	1	4	localThrowable6	Throwable
    //   478	1	4	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   264	268	269	java/lang/Throwable
    //   126	145	286	java/io/IOException
    //   347	351	352	java/lang/Throwable
    //   126	145	364	java/lang/Throwable
    //   425	429	430	java/lang/Throwable
    //   126	145	442	finally
    //   449	453	455	java/lang/Throwable
    //   147	153	469	finally
    //   155	164	469	finally
    //   166	171	469	finally
    //   173	179	469	finally
    //   181	188	469	finally
    //   190	196	469	finally
    //   198	203	469	finally
    //   205	212	469	finally
    //   214	219	469	finally
    //   221	228	469	finally
    //   230	235	469	finally
    //   237	244	469	finally
    //   246	260	469	finally
    //   292	322	469	finally
    //   324	330	469	finally
    //   332	337	469	finally
    //   339	343	469	finally
    //   370	400	469	finally
    //   402	408	469	finally
    //   410	415	469	finally
    //   417	421	469	finally
    //   147	153	473	java/lang/Throwable
    //   155	164	473	java/lang/Throwable
    //   166	171	473	java/lang/Throwable
    //   173	179	473	java/lang/Throwable
    //   181	188	473	java/lang/Throwable
    //   190	196	473	java/lang/Throwable
    //   198	203	473	java/lang/Throwable
    //   205	212	473	java/lang/Throwable
    //   214	219	473	java/lang/Throwable
    //   221	228	473	java/lang/Throwable
    //   230	235	473	java/lang/Throwable
    //   237	244	473	java/lang/Throwable
    //   246	260	473	java/lang/Throwable
    //   147	153	478	java/io/IOException
    //   155	164	478	java/io/IOException
    //   166	171	478	java/io/IOException
    //   173	179	478	java/io/IOException
    //   181	188	478	java/io/IOException
    //   190	196	478	java/io/IOException
    //   198	203	478	java/io/IOException
    //   205	212	478	java/io/IOException
    //   214	219	478	java/io/IOException
    //   221	228	478	java/io/IOException
    //   230	235	478	java/io/IOException
    //   237	244	478	java/io/IOException
    //   246	260	478	java/io/IOException
  }
  
  public boolean d()
  {
    return (!this.jdField_a_of_type_Boolean) && (this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && ((this.f) || (this.jdField_b_of_type_Boolean) || (this.g));
  }
  
  public void e() {}
  
  public boolean e()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public void f()
  {
    QLog.d("AREngine_ARVideoRenderable", 1, "onDestroy");
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {}
    try
    {
      boolean bool = this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying();
      if (QLog.isColorLevel()) {
        QLog.d("HSRender", 2, "onDestroy, isPlaying=" + bool + ", isLooping=" + this.jdField_a_of_type_AndroidMediaMediaPlayer.isLooping());
      }
      if (bool) {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
        QLog.d("AREngine_ARVideoRenderable", 1, "onDestroy, exception, e=" + localException.getMessage());
      }
    }
    this.jdField_e_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase.b();
      this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase = null;
    }
    this.jdField_b_of_type_Int = 0;
    this.g = false;
    this.f = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARVideoRenderable", 2, "onBufferingUpdate, percent=" + paramInt);
    }
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARVideoRenderable", 2, "onCompletion");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.b(2, this.jdField_c_of_type_Int - this.jdField_b_of_type_Int);
    }
    if (this.jdField_b_of_type_Int >= this.jdField_c_of_type_Int)
    {
      this.f = true;
      this.g = false;
      return;
    }
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      this.jdField_b_of_type_Int += 1;
      h();
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      if (QLog.isColorLevel()) {
        paramMediaPlayer.printStackTrace();
      }
      QLog.d("AREngine_ARVideoRenderable", 1, "onCompletion, exception=" + paramMediaPlayer + ", msg=" + paramMediaPlayer.getMessage());
      f();
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    QLog.d("AREngine_ARVideoRenderable", 1, "onError, what=" + paramInt1 + ", extra" + paramInt2);
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelNormalVideoARResourceInfo.jdField_a_of_type_JavaLangString);
    }
    if (paramMediaPlayer != null) {
      paramMediaPlayer.release();
    }
    paramMediaPlayer = new HashMap();
    paramMediaPlayer.put("param_FailCode", String.valueOf(paramInt1));
    paramMediaPlayer.put("extra", String.valueOf(paramInt2));
    paramMediaPlayer.put("url", this.jdField_a_of_type_ComTencentMobileqqArARRenderModelNormalVideoARResourceInfo.jdField_a_of_type_JavaLangString);
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "immersed_ar_on_error", true, 0L, 0L, paramMediaPlayer, "", false);
    f();
    return false;
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    if (this.h) {
      this.jdField_e_of_type_Boolean = true;
    }
    while ((!this.g) && (Build.MODEL.equalsIgnoreCase("MI 6")))
    {
      QLog.d("AREngine_ARVideoRenderable", 1, "onFrameAvailable mIsLooping ");
      return;
      this.h = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARVideoRenderable", 2, "onInfo, what=" + paramInt1 + ", extra=" + paramInt2);
    }
    return false;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARVideoRenderable", 2, "onPrepared");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.NormalVideoARRenderable
 * JD-Core Version:    0.7.0.1
 */