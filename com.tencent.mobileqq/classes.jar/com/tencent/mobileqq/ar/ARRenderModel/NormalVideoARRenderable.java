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
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initMedia, mHasMediaInit=");
    ((StringBuilder)localObject).append(this.jdField_d_of_type_Boolean);
    QLog.d("AREngine_ARVideoRenderable", 1, ((StringBuilder)localObject).toString());
    if (this.jdField_d_of_type_Boolean) {
      return;
    }
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
      this.jdField_a_of_type_AndroidMediaMediaPlayer = new ReportMediaPlayer();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(this);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(this);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnBufferingUpdateListener(this);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(this);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnInfoListener(this);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(false);
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.jdField_d_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
      localObject = new Surface(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setSurface((Surface)localObject);
      ((Surface)localObject).release();
      this.jdField_d_of_type_Boolean = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init, throwable t = ");
      localStringBuilder.append(localThrowable.getMessage());
      QLog.d("AREngine_ARVideoRenderable", 1, localStringBuilder.toString());
      if (QLog.isColorLevel()) {
        localThrowable.printStackTrace();
      }
    }
  }
  
  private void b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initGl, mHasMediaInit=");
    ((StringBuilder)localObject).append(this.jdField_d_of_type_Boolean);
    QLog.d("AREngine_ARVideoRenderable", 1, ((StringBuilder)localObject).toString());
    Matrix.setIdentityM(this.jdField_b_of_type_ArrayOfFloat, 0);
    localObject = new int[1];
    GLES20.glGenTextures(1, (int[])localObject, 0);
    this.jdField_d_of_type_Int = localObject[0];
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initGl, mTextureID=");
    ((StringBuilder)localObject).append(this.jdField_d_of_type_Int);
    QLog.d("AREngine_ARVideoRenderable", 1, ((StringBuilder)localObject).toString());
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isColorLevel, mLoopCount=");
      localStringBuilder.append(this.jdField_c_of_type_Int);
      localStringBuilder.append(", mCurPlayCount=");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      QLog.d("AREngine_ARVideoRenderable", 2, localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(ARRenerArumentManager.DrawFrameParements paramDrawFrameParements)
  {
    a((float[])paramDrawFrameParements.a("TARGET_SIZE"), (float[])paramDrawFrameParements.a("POSE"), (float[])paramDrawFrameParements.a("CAMERA_MATRIX"), (float[])paramDrawFrameParements.a("CAMERA_POSITION"));
  }
  
  public void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4)
  {
    if ((this.jdField_e_of_type_Boolean) && (paramArrayOfFloat2 != null) && (paramArrayOfFloat3 != null) && (paramArrayOfFloat4 != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelNormalVideoARResourceInfo == null) {
        return;
      }
      GLES20.glBlendFunc(770, 771);
      GLES20.glEnable(3042);
      if (this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase == null) {
        g();
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelNormalVideoARResourceInfo;
      int k;
      if ((localObject != null) && (((NormalVideoARResourceInfo)localObject).jdField_b_of_type_Int == 1))
      {
        paramArrayOfFloat2 = this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase;
        if (paramArrayOfFloat2 != null)
        {
          k = this.jdField_d_of_type_Int;
          localObject = this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingParams;
          paramArrayOfFloat1 = a(paramArrayOfFloat1, paramArrayOfFloat3, paramArrayOfFloat4);
          paramArrayOfFloat3 = this.jdField_b_of_type_ArrayOfFloat;
          paramArrayOfFloat2.a(new int[] { k }, (KeyingParams)localObject, paramArrayOfFloat1, paramArrayOfFloat3);
        }
      }
      else
      {
        paramArrayOfFloat3 = this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase;
        if (paramArrayOfFloat3 != null)
        {
          k = this.jdField_d_of_type_Int;
          localObject = this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingParams;
          paramArrayOfFloat1 = a(paramArrayOfFloat1, paramArrayOfFloat2, paramArrayOfFloat4);
          paramArrayOfFloat2 = this.jdField_b_of_type_ArrayOfFloat;
          paramArrayOfFloat3.a(new int[] { k }, (KeyingParams)localObject, paramArrayOfFloat1, paramArrayOfFloat2);
        }
      }
      GLES20.glDisable(3042);
      GLES20.glBindTexture(36197, 0);
      if (this.j) {
        this.j = false;
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
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelNormalVideoARResourceInfo.jdField_c_of_type_Int != 1) {
        Matrix.scaleM(this.jdField_a_of_type_ArrayOfFloat, 0, paramArrayOfFloat1[0], paramArrayOfFloat1[1], 1.0F);
      }
      paramArrayOfFloat1 = this.jdField_a_of_type_ArrayOfFloat;
      Matrix.multiplyMM(paramArrayOfFloat1, 0, paramArrayOfFloat2, 0, paramArrayOfFloat1, 0);
      paramArrayOfFloat1 = this.jdField_a_of_type_ArrayOfFloat;
      Matrix.multiplyMM(paramArrayOfFloat1, 0, paramArrayOfFloat3, 0, paramArrayOfFloat1, 0);
    }
    return this.jdField_a_of_type_ArrayOfFloat;
  }
  
  public int b()
  {
    NormalVideoARResourceInfo localNormalVideoARResourceInfo = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelNormalVideoARResourceInfo;
    if (localNormalVideoARResourceInfo != null) {
      return localNormalVideoARResourceInfo.jdField_a_of_type_Int;
    }
    return 2;
  }
  
  public int c()
  {
    NormalVideoARResourceInfo localNormalVideoARResourceInfo = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelNormalVideoARResourceInfo;
    if (localNormalVideoARResourceInfo != null) {
      return localNormalVideoARResourceInfo.jdField_b_of_type_Int;
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
    //   0: ldc 160
    //   2: iconst_1
    //   3: ldc_w 386
    //   6: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +35 -> 47
    //   15: new 148	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   22: astore_2
    //   23: aload_2
    //   24: ldc_w 388
    //   27: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload_2
    //   32: aload_0
    //   33: invokevirtual 391	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: ldc 160
    //   39: iconst_2
    //   40: aload_2
    //   41: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   47: aload_0
    //   48: getfield 53	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:jdField_b_of_type_Boolean	Z
    //   51: ifne +403 -> 454
    //   54: aload_0
    //   55: getfield 51	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   58: astore_2
    //   59: aload_2
    //   60: ifnull +394 -> 454
    //   63: aload_2
    //   64: invokevirtual 394	android/media/MediaPlayer:isPlaying	()Z
    //   67: ifeq +6 -> 73
    //   70: goto +384 -> 454
    //   73: aload_0
    //   74: iconst_0
    //   75: putfield 71	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:h	Z
    //   78: aload_0
    //   79: iconst_0
    //   80: putfield 65	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:jdField_e_of_type_Boolean	Z
    //   83: aconst_null
    //   84: astore 4
    //   86: aconst_null
    //   87: astore 5
    //   89: aconst_null
    //   90: astore_2
    //   91: new 396	java/io/FileInputStream
    //   94: dup
    //   95: new 177	java/io/File
    //   98: dup
    //   99: aload_0
    //   100: getfield 109	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   103: invokespecial 180	java/io/File:<init>	(Ljava/lang/String;)V
    //   106: invokespecial 399	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   109: astore_3
    //   110: aload_3
    //   111: invokevirtual 403	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   114: astore_2
    //   115: aload_0
    //   116: getfield 51	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   119: aload_2
    //   120: invokevirtual 407	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   123: aload_0
    //   124: iconst_1
    //   125: putfield 57	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:jdField_b_of_type_Int	I
    //   128: aload_0
    //   129: getfield 51	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   132: astore_2
    //   133: aload_0
    //   134: getfield 59	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:jdField_c_of_type_Int	I
    //   137: ifne +376 -> 513
    //   140: iconst_1
    //   141: istore_1
    //   142: goto +3 -> 145
    //   145: aload_2
    //   146: iload_1
    //   147: invokevirtual 215	android/media/MediaPlayer:setLooping	(Z)V
    //   150: aload_0
    //   151: iconst_1
    //   152: putfield 69	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:g	Z
    //   155: aload_0
    //   156: getfield 51	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   159: invokevirtual 410	android/media/MediaPlayer:prepare	()V
    //   162: aload_0
    //   163: iconst_0
    //   164: putfield 67	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:f	Z
    //   167: aload_0
    //   168: getfield 51	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   171: invokevirtual 412	android/media/MediaPlayer:start	()V
    //   174: aload_0
    //   175: iconst_1
    //   176: putfield 53	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:jdField_b_of_type_Boolean	Z
    //   179: aload_0
    //   180: getfield 101	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback	Lcom/tencent/mobileqq/ar/ARRenderModel/ARRenderMangerInnerCallback;
    //   183: ifnull +17 -> 200
    //   186: aload_0
    //   187: getfield 101	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback	Lcom/tencent/mobileqq/ar/ARRenderModel/ARRenderMangerInnerCallback;
    //   190: iconst_0
    //   191: aload_0
    //   192: getfield 59	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:jdField_c_of_type_Int	I
    //   195: invokeinterface 416 3 0
    //   200: aload_3
    //   201: invokevirtual 419	java/io/FileInputStream:close	()V
    //   204: return
    //   205: astore_2
    //   206: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   209: ifeq +220 -> 429
    //   212: aload_2
    //   213: invokevirtual 247	java/lang/Throwable:printStackTrace	()V
    //   216: return
    //   217: astore 4
    //   219: aload_3
    //   220: astore_2
    //   221: aload 4
    //   223: astore_3
    //   224: goto +206 -> 430
    //   227: astore 4
    //   229: goto +19 -> 248
    //   232: astore 4
    //   234: goto +107 -> 341
    //   237: astore_3
    //   238: goto +192 -> 430
    //   241: astore_2
    //   242: aload 4
    //   244: astore_3
    //   245: aload_2
    //   246: astore 4
    //   248: aload_3
    //   249: astore_2
    //   250: new 148	java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   257: astore 5
    //   259: aload_3
    //   260: astore_2
    //   261: aload 5
    //   263: ldc_w 421
    //   266: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: pop
    //   270: aload_3
    //   271: astore_2
    //   272: aload 5
    //   274: aload 4
    //   276: invokevirtual 241	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   279: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: aload_3
    //   284: astore_2
    //   285: ldc 160
    //   287: iconst_2
    //   288: aload 5
    //   290: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   296: aload_3
    //   297: astore_2
    //   298: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   301: ifeq +10 -> 311
    //   304: aload_3
    //   305: astore_2
    //   306: aload 4
    //   308: invokevirtual 247	java/lang/Throwable:printStackTrace	()V
    //   311: aload_3
    //   312: astore_2
    //   313: aload_0
    //   314: invokevirtual 423	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:f	()V
    //   317: aload_3
    //   318: ifnull +111 -> 429
    //   321: aload_3
    //   322: invokevirtual 419	java/io/FileInputStream:close	()V
    //   325: return
    //   326: astore_2
    //   327: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   330: ifeq +99 -> 429
    //   333: goto -121 -> 212
    //   336: astore 4
    //   338: aload 5
    //   340: astore_3
    //   341: aload_3
    //   342: astore_2
    //   343: new 148	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   350: astore 5
    //   352: aload_3
    //   353: astore_2
    //   354: aload 5
    //   356: ldc_w 425
    //   359: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: pop
    //   363: aload_3
    //   364: astore_2
    //   365: aload 5
    //   367: aload 4
    //   369: invokevirtual 426	java/io/IOException:getMessage	()Ljava/lang/String;
    //   372: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload_3
    //   377: astore_2
    //   378: ldc 160
    //   380: iconst_2
    //   381: aload 5
    //   383: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   386: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   389: aload_3
    //   390: astore_2
    //   391: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   394: ifeq +10 -> 404
    //   397: aload_3
    //   398: astore_2
    //   399: aload 4
    //   401: invokevirtual 427	java/io/IOException:printStackTrace	()V
    //   404: aload_3
    //   405: astore_2
    //   406: aload_0
    //   407: invokevirtual 423	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:f	()V
    //   410: aload_3
    //   411: ifnull +18 -> 429
    //   414: aload_3
    //   415: invokevirtual 419	java/io/FileInputStream:close	()V
    //   418: return
    //   419: astore_2
    //   420: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   423: ifeq +6 -> 429
    //   426: goto -214 -> 212
    //   429: return
    //   430: aload_2
    //   431: ifnull +21 -> 452
    //   434: aload_2
    //   435: invokevirtual 419	java/io/FileInputStream:close	()V
    //   438: goto +14 -> 452
    //   441: astore_2
    //   442: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   445: ifeq +7 -> 452
    //   448: aload_2
    //   449: invokevirtual 247	java/lang/Throwable:printStackTrace	()V
    //   452: aload_3
    //   453: athrow
    //   454: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   457: ifeq +55 -> 512
    //   460: new 148	java/lang/StringBuilder
    //   463: dup
    //   464: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   467: astore_2
    //   468: aload_2
    //   469: ldc_w 429
    //   472: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: pop
    //   476: aload_2
    //   477: aload_0
    //   478: getfield 53	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:jdField_b_of_type_Boolean	Z
    //   481: invokevirtual 158	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   484: pop
    //   485: aload_2
    //   486: ldc_w 431
    //   489: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: pop
    //   493: aload_2
    //   494: aload_0
    //   495: getfield 51	com/tencent/mobileqq/ar/ARRenderModel/NormalVideoARRenderable:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   498: invokevirtual 391	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   501: pop
    //   502: ldc 160
    //   504: iconst_2
    //   505: aload_2
    //   506: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   512: return
    //   513: iconst_0
    //   514: istore_1
    //   515: goto -370 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	518	0	this	NormalVideoARRenderable
    //   141	374	1	bool	boolean
    //   22	124	2	localObject1	Object
    //   205	8	2	localThrowable1	Throwable
    //   220	1	2	localObject2	Object
    //   241	5	2	localThrowable2	Throwable
    //   249	64	2	localObject3	Object
    //   326	1	2	localThrowable3	Throwable
    //   342	64	2	localObject4	Object
    //   419	16	2	localThrowable4	Throwable
    //   441	8	2	localThrowable5	Throwable
    //   467	39	2	localStringBuilder1	StringBuilder
    //   109	115	3	localObject5	Object
    //   237	1	3	localObject6	Object
    //   244	209	3	localObject7	Object
    //   84	1	4	localObject8	Object
    //   217	5	4	localObject9	Object
    //   227	1	4	localThrowable6	Throwable
    //   232	11	4	localIOException1	java.io.IOException
    //   246	61	4	localThrowable7	Throwable
    //   336	64	4	localIOException2	java.io.IOException
    //   87	295	5	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   200	204	205	java/lang/Throwable
    //   110	140	217	finally
    //   145	200	217	finally
    //   110	140	227	java/lang/Throwable
    //   145	200	227	java/lang/Throwable
    //   110	140	232	java/io/IOException
    //   145	200	232	java/io/IOException
    //   91	110	237	finally
    //   250	259	237	finally
    //   261	270	237	finally
    //   272	283	237	finally
    //   285	296	237	finally
    //   298	304	237	finally
    //   306	311	237	finally
    //   313	317	237	finally
    //   343	352	237	finally
    //   354	363	237	finally
    //   365	376	237	finally
    //   378	389	237	finally
    //   391	397	237	finally
    //   399	404	237	finally
    //   406	410	237	finally
    //   91	110	241	java/lang/Throwable
    //   321	325	326	java/lang/Throwable
    //   91	110	336	java/io/IOException
    //   414	418	419	java/lang/Throwable
    //   434	438	441	java/lang/Throwable
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
    Object localObject = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if (localObject != null) {
      try
      {
        boolean bool = ((MediaPlayer)localObject).isPlaying();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onDestroy, isPlaying=");
          ((StringBuilder)localObject).append(bool);
          ((StringBuilder)localObject).append(", isLooping=");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidMediaMediaPlayer.isLooping());
          QLog.d("HSRender", 2, ((StringBuilder)localObject).toString());
        }
        if (bool) {
          this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
        }
        this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onDestroy, exception, e=");
        localStringBuilder.append(localException.getMessage());
        QLog.d("AREngine_ARVideoRenderable", 1, localStringBuilder.toString());
      }
    }
    this.jdField_e_of_type_Boolean = false;
    KeyingBase localKeyingBase = this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase;
    if (localKeyingBase != null)
    {
      localKeyingBase.b();
      this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase = null;
    }
    this.jdField_b_of_type_Int = 0;
    this.g = false;
    this.f = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramMediaPlayer = new StringBuilder();
      paramMediaPlayer.append("onBufferingUpdate, percent=");
      paramMediaPlayer.append(paramInt);
      QLog.d("AREngine_ARVideoRenderable", 2, paramMediaPlayer.toString());
    }
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARVideoRenderable", 2, "onCompletion");
    }
    paramMediaPlayer = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback;
    if (paramMediaPlayer != null) {
      paramMediaPlayer.b(2, this.jdField_c_of_type_Int - this.jdField_b_of_type_Int);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCompletion, exception=");
      localStringBuilder.append(paramMediaPlayer);
      localStringBuilder.append(", msg=");
      localStringBuilder.append(paramMediaPlayer.getMessage());
      QLog.d("AREngine_ARVideoRenderable", 1, localStringBuilder.toString());
      f();
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onError, what=");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", extra");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.d("AREngine_ARVideoRenderable", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback;
    if (localObject != null) {
      ((ARRenderMangerInnerCallback)localObject).a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelNormalVideoARResourceInfo.jdField_a_of_type_JavaLangString);
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
    } else {
      this.h = true;
    }
    if ((!this.g) && (Build.MODEL.equalsIgnoreCase("MI 6")))
    {
      QLog.d("AREngine_ARVideoRenderable", 1, "onFrameAvailable mIsLooping ");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      paramMediaPlayer = new StringBuilder();
      paramMediaPlayer.append("onInfo, what=");
      paramMediaPlayer.append(paramInt1);
      paramMediaPlayer.append(", extra=");
      paramMediaPlayer.append(paramInt2);
      QLog.d("AREngine_ARVideoRenderable", 2, paramMediaPlayer.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.NormalVideoARRenderable
 * JD-Core Version:    0.7.0.1
 */