package com.tencent.mobileqq.ar.ARRenderModel;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ARVideoUtil;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo.ARVideoLayout;
import com.tencent.mobileqq.ar.keying.KeyingBase;
import com.tencent.mobileqq.ar.keying.KeyingBase.UserInterface;
import com.tencent.mobileqq.ar.keying.KeyingManager;
import com.tencent.mobileqq.ar.keying.KeyingParams;
import com.tencent.mobileqq.ar.online_video.AROnlineVideoUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;
import com.tencent.superplayer.api.ISuperPlayer.OnDefinitionInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer.OnInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerOption;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashMap;

@TargetApi(11)
class OnlineVideoARRenderable
  implements SurfaceTexture.OnFrameAvailableListener, ARBaseRender, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnDefinitionInfoListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnVideoPreparedListener
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = -1L;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private ARRenderMangerInnerCallback jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback;
  private OnlineVideoARRenderableInfo jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo;
  private KeyingBase.UserInterface jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase$UserInterface = new OnlineVideoARRenderable.1(this);
  private KeyingBase jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase;
  private KeyingParams jdField_a_of_type_ComTencentMobileqqArKeyingKeyingParams;
  private volatile ISuperPlayer jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
  private Runnable jdField_a_of_type_JavaLangRunnable = new OnlineVideoARRenderable.2(this);
  private String jdField_a_of_type_JavaLangString = null;
  private final boolean jdField_a_of_type_Boolean = false;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private int[] jdField_a_of_type_ArrayOfInt = new int[3];
  private ByteBuffer[] jdField_a_of_type_ArrayOfJavaNioByteBuffer = new ByteBuffer[3];
  private IntBuffer[] jdField_a_of_type_ArrayOfJavaNioIntBuffer = new IntBuffer[3];
  private int jdField_b_of_type_Int;
  private KeyingBase jdField_b_of_type_ComTencentMobileqqArKeyingKeyingBase;
  private boolean jdField_b_of_type_Boolean = false;
  private float[] jdField_b_of_type_ArrayOfFloat = new float[16];
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 0;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 1;
  private boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int = 0;
  private boolean jdField_f_of_type_Boolean = false;
  private int jdField_g_of_type_Int = -1;
  private boolean jdField_g_of_type_Boolean = false;
  private int jdField_h_of_type_Int = -1;
  private boolean jdField_h_of_type_Boolean = false;
  private int jdField_i_of_type_Int = -1;
  private boolean jdField_i_of_type_Boolean = false;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;
  private boolean m = true;
  
  public OnlineVideoARRenderable(ARRenderMangerInnerCallback paramARRenderMangerInnerCallback, OnlineVideoARRenderableInfo paramOnlineVideoARRenderableInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback = paramARRenderMangerInnerCallback;
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo = paramOnlineVideoARRenderableInfo;
    this.jdField_e_of_type_Int = paramOnlineVideoARRenderableInfo.jdField_e_of_type_Int;
    this.jdField_d_of_type_Int = paramOnlineVideoARRenderableInfo.jdField_d_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingParams = paramOnlineVideoARRenderableInfo.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingParams;
    this.jdField_a_of_type_JavaLangString = paramOnlineVideoARRenderableInfo.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_Long = paramOnlineVideoARRenderableInfo.jdField_b_of_type_Long;
    boolean bool = ARVideoUtil.a();
    if (QLog.isColorLevel())
    {
      paramARRenderMangerInnerCallback = new StringBuilder();
      paramARRenderMangerInnerCallback.append("Construction mSoftwarePlayConfig:false  isRubbishDevice:");
      paramARRenderMangerInnerCallback.append(bool);
      paramARRenderMangerInnerCallback.append("  isSoftPlay:");
      paramARRenderMangerInnerCallback.append(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_a_of_type_Boolean);
      QLog.d("AREngine_OnlineVideoARRenderable", 2, paramARRenderMangerInnerCallback.toString());
    }
  }
  
  private int a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    paramInt1 -= 1;
    IntBuffer[] arrayOfIntBuffer = this.jdField_a_of_type_ArrayOfJavaNioIntBuffer;
    if (arrayOfIntBuffer[0] == null)
    {
      arrayOfIntBuffer[0] = IntBuffer.allocate(1);
      this.jdField_a_of_type_ArrayOfJavaNioIntBuffer[1] = IntBuffer.allocate(1);
      this.jdField_a_of_type_ArrayOfJavaNioIntBuffer[2] = IntBuffer.allocate(1);
    }
    this.jdField_a_of_type_ArrayOfJavaNioIntBuffer[paramInt1].clear();
    GLES20.glGenTextures(1, this.jdField_a_of_type_ArrayOfJavaNioIntBuffer[paramInt1]);
    int n = this.jdField_a_of_type_ArrayOfJavaNioIntBuffer[paramInt1].get();
    GLES20.glBindTexture(3553, n);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    if ((this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[paramInt1] == null) || (this.jdField_a_of_type_ArrayOfInt[paramInt1] != paramArrayOfByte.length)) {
      try
      {
        this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[paramInt1] = ByteBuffer.allocateDirect(paramArrayOfByte.length);
        this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[paramInt1].order(ByteOrder.nativeOrder());
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("textureYUV, exception=");
          localStringBuilder.append(localThrowable.getMessage());
          QLog.d("AREngine_OnlineVideoARRenderable", 2, localStringBuilder.toString());
          localThrowable.printStackTrace();
        }
      }
    }
    this.jdField_a_of_type_ArrayOfInt[paramInt1] = paramArrayOfByte.length;
    this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[paramInt1].put(paramArrayOfByte);
    this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[paramInt1].position(0);
    GLES20.glTexImage2D(3553, 0, 6409, paramInt2, paramInt3, 0, 6409, 5121, this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[paramInt1]);
    return n;
  }
  
  private void a()
  {
    QLog.d("AREngine_OnlineVideoARRenderable", 1, "initGl");
    Matrix.setIdentityM(this.jdField_b_of_type_ArrayOfFloat, 0);
    Object localObject = new int[1];
    GLES20.glGenTextures(1, (int[])localObject, 0);
    this.jdField_a_of_type_Int = localObject[0];
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initGl, mTextureID=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    QLog.d("AREngine_OnlineVideoARRenderable", 1, ((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_Int == 0) {
      return;
    }
    a(false);
  }
  
  private void a(String paramString)
  {
    paramString = SuperPlayerFactory.createVideoInfoForUrl(paramString, 101, MD5Utils.toMD5(paramString));
    SuperPlayerOption localSuperPlayerOption = SuperPlayerOption.obtain();
    localSuperPlayerOption.enableCodecReuse = false;
    localSuperPlayerOption.isPrePlay = false;
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.openMediaPlayer(BaseApplicationImpl.getContext(), paramString, 0L, localSuperPlayerOption);
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(ARRenerArumentManager.DrawFrameParements paramDrawFrameParements)
  {
    a((float[])paramDrawFrameParements.a("TARGET_SIZE"), (float[])paramDrawFrameParements.a("POSE"), (float[])paramDrawFrameParements.a("CAMERA_MATRIX"), (float[])paramDrawFrameParements.a("CAMERA_POSITION"));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqArKeyingKeyingBase == null)
      {
        this.jdField_b_of_type_ComTencentMobileqqArKeyingKeyingBase = KeyingManager.a(this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingParams, 3);
        this.jdField_b_of_type_ComTencentMobileqqArKeyingKeyingBase.a(ARVideoUtil.jdField_b_of_type_ArrayOfFloat, ARVideoUtil.jdField_a_of_type_ArrayOfShort);
        this.jdField_b_of_type_ComTencentMobileqqArKeyingKeyingBase.a("uniform int uDisplayType;\n", null, "    if(uDisplayType == 1){\n        // 需要渲染成圆形\n        float x = vTextureCoord.x;\n        float y = vTextureCoord.y;\n        // 圆心(0.5, 0.5), 0.25=0.5*0.5\n        if(pow(abs(x-0.5), 2.0) + pow(abs(y-0.5), 2.0) >= 0.25) {\n            gl_FragColor[3] = 0.0;\n        }\n    }\n", this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase$UserInterface);
        this.jdField_b_of_type_ComTencentMobileqqArKeyingKeyingBase.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_a_of_type_Float, this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_b_of_type_Float, this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_c_of_type_Float);
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase = KeyingManager.a(this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingParams, 1);
      this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase.a(ARVideoUtil.jdField_a_of_type_ArrayOfFloat, ARVideoUtil.jdField_a_of_type_ArrayOfShort);
      this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase.a("uniform int uDisplayType;\n", null, "    if(uDisplayType == 1){\n        // 需要渲染成圆形\n        float x = vTextureCoord.x;\n        float y = vTextureCoord.y;\n        // 圆心(0.5, 0.5), 0.25=0.5*0.5\n        if(pow(abs(x-0.5), 2.0) + pow(abs(y-0.5), 2.0) >= 0.25) {\n            gl_FragColor[3] = 0.0;\n        }\n    }\n", this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase$UserInterface);
      this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_a_of_type_Float, this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_b_of_type_Float, this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_c_of_type_Float);
    }
  }
  
  public void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4)
  {
    if ((this.jdField_e_of_type_Boolean) && (paramArrayOfFloat2 != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo == null) {
        return;
      }
      GLES20.glBlendFunc(770, 771);
      GLES20.glEnable(3042);
      if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_b_of_type_Int == 1) {
        paramArrayOfFloat1 = a(paramArrayOfFloat1, paramArrayOfFloat3, paramArrayOfFloat4);
      } else {
        paramArrayOfFloat1 = a(paramArrayOfFloat1, paramArrayOfFloat2, paramArrayOfFloat4);
      }
      boolean bool = this.jdField_i_of_type_Boolean;
      int n;
      if (!bool)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase == null) {
          a(bool);
        }
        paramArrayOfFloat2 = this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase;
        if (paramArrayOfFloat2 != null)
        {
          n = this.jdField_a_of_type_Int;
          paramArrayOfFloat3 = this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingParams;
          paramArrayOfFloat4 = this.jdField_b_of_type_ArrayOfFloat;
          paramArrayOfFloat2.a(new int[] { n }, paramArrayOfFloat3, paramArrayOfFloat1, paramArrayOfFloat4);
        }
      }
      else
      {
        if (this.jdField_b_of_type_ComTencentMobileqqArKeyingKeyingBase == null) {
          a(bool);
        }
        Matrix.setIdentityM(this.jdField_b_of_type_ArrayOfFloat, 0);
        paramArrayOfFloat2 = this.jdField_b_of_type_ComTencentMobileqqArKeyingKeyingBase;
        if (paramArrayOfFloat2 != null)
        {
          n = this.jdField_g_of_type_Int;
          int i1 = this.jdField_h_of_type_Int;
          int i2 = this.jdField_i_of_type_Int;
          paramArrayOfFloat3 = this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingParams;
          paramArrayOfFloat4 = this.jdField_b_of_type_ArrayOfFloat;
          paramArrayOfFloat2.a(new int[] { n, i1, i2 }, paramArrayOfFloat3, paramArrayOfFloat1, paramArrayOfFloat4);
        }
      }
      GLES20.glDisable(3042);
      GLES20.glBindTexture(3553, 0);
      GLES20.glBindTexture(36197, 0);
      if (this.m) {
        this.m = false;
      }
    }
  }
  
  public float[] a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3)
  {
    Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
    if (c() == 2)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$ARVideoLayout != null)
      {
        Matrix.scaleM(this.jdField_a_of_type_ArrayOfFloat, 0, this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$ARVideoLayout.jdField_a_of_type_Float * paramArrayOfFloat1[0], this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$ARVideoLayout.jdField_b_of_type_Float * paramArrayOfFloat1[1], 1.0F);
        Matrix.translateM(this.jdField_a_of_type_ArrayOfFloat, 0, this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$ARVideoLayout.jdField_c_of_type_Float, this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$ARVideoLayout.d, this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$ARVideoLayout.e);
      }
    }
    else if ((paramArrayOfFloat2 != null) && (paramArrayOfFloat3 != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_c_of_type_Int != 1) {
        Matrix.scaleM(this.jdField_a_of_type_ArrayOfFloat, 0, paramArrayOfFloat1[0], paramArrayOfFloat1[1], 1.0F);
      }
      paramArrayOfFloat1 = this.jdField_a_of_type_ArrayOfFloat;
      Matrix.multiplyMM(paramArrayOfFloat1, 0, paramArrayOfFloat2, 0, paramArrayOfFloat1, 0);
      paramArrayOfFloat1 = this.jdField_a_of_type_ArrayOfFloat;
      Matrix.multiplyMM(paramArrayOfFloat1, 0, paramArrayOfFloat3, 0, paramArrayOfFloat1, 0);
    }
    else
    {
      this.jdField_a_of_type_ArrayOfFloat = new float[16];
    }
    return this.jdField_a_of_type_ArrayOfFloat;
  }
  
  public int b()
  {
    OnlineVideoARRenderableInfo localOnlineVideoARRenderableInfo = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo;
    if (localOnlineVideoARRenderableInfo != null) {
      return localOnlineVideoARRenderableInfo.jdField_a_of_type_Int;
    }
    return 4;
  }
  
  public int c()
  {
    OnlineVideoARRenderableInfo localOnlineVideoARRenderableInfo = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo;
    if (localOnlineVideoARRenderableInfo != null) {
      return localOnlineVideoARRenderableInfo.jdField_b_of_type_Int;
    }
    return 0;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_a_of_type_JavaLangString;
  }
  
  @TargetApi(11)
  public void c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("init, mHasSDKInit=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    QLog.d("AREngine_OnlineVideoARRenderable", 1, localStringBuilder.toString());
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    a();
    QLog.d("AREngine_OnlineVideoARRenderable", 1, "initSDK");
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
    this.jdField_a_of_type_AndroidViewSurface = new Surface(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer = SuperPlayerFactory.createMediaPlayer(BaseApplicationImpl.getContext(), 108, null);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setSurface(this.jdField_a_of_type_AndroidViewSurface);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnVideoPreparedListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnInfoListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnErrorListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnDefinitionInfoListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnCompletionListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnSeekCompleteListener(this);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void d()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start, arResourceInfo=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo);
      QLog.d("AREngine_OnlineVideoARRenderable", 2, ((StringBuilder)localObject).toString());
    }
    if ((!this.j) && (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) && (!this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.isPlaying()))
    {
      if ((this.jdField_a_of_type_Long >= 0L) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
      {
        if (!this.jdField_b_of_type_Boolean)
        {
          QLog.d("AREngine_OnlineVideoARRenderable", 1, "init failed");
          return;
        }
        this.jdField_c_of_type_Boolean = false;
        this.jdField_e_of_type_Boolean = false;
        this.jdField_f_of_type_Boolean = false;
        this.jdField_g_of_type_Boolean = false;
        this.jdField_c_of_type_Int = 1;
        this.jdField_f_of_type_Int = 0;
        this.l = false;
        this.jdField_d_of_type_Boolean = true;
        this.j = true;
        localObject = AROnlineVideoUtil.a(this.jdField_a_of_type_JavaLangString);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("start, video dir=");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(", mSoftwarePlayConfig=");
          localStringBuilder.append(false);
          QLog.d("AREngine_OnlineVideoARRenderable", 2, localStringBuilder.toString());
        }
        a(this.jdField_a_of_type_JavaLangString);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_OnlineVideoARRenderable", 2, "start, mVideoSize < 0 || TextUtils.isEmpty(mVideoUrl)");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_OnlineVideoARRenderable", 2, "start, mMediaPlayer == null || mMediaPlayer.isPlaying()");
    }
  }
  
  public boolean d()
  {
    return (this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) && ((this.jdField_f_of_type_Boolean) || (this.jdField_g_of_type_Boolean) || (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.isPlaying()));
  }
  
  public void e() {}
  
  public boolean e()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_OnlineVideoARRenderable", 2, "onDestroy");
    }
    this.jdField_d_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 1;
    this.j = false;
    this.jdField_h_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      try
      {
        this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.stop();
        this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.release();
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onDestroy exception, msg=");
        localStringBuilder.append(localException.getMessage());
        QLog.d("AREngine_OnlineVideoARRenderable", 1, localStringBuilder.toString());
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback;
        if (localObject != null) {
          ((ARRenderMangerInnerCallback)localObject).a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_a_of_type_JavaLangString);
        }
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase;
    if (localObject != null)
    {
      ((KeyingBase)localObject).b();
      this.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingBase = null;
    }
    localObject = this.jdField_b_of_type_ComTencentMobileqqArKeyingKeyingBase;
    if (localObject != null)
    {
      ((KeyingBase)localObject).b();
      this.jdField_b_of_type_ComTencentMobileqqArKeyingKeyingBase = null;
    }
    localObject = new HashMap();
    ((HashMap)localObject).put("decode_type", String.valueOf(this.jdField_f_of_type_Int));
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "immersed_ar_decode_type", true, 0L, 0L, (HashMap)localObject, "", false);
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_OnlineVideoARRenderable", 2, "onCompletion");
    }
    paramISuperPlayer = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback;
    if (paramISuperPlayer != null) {
      paramISuperPlayer.b(2, this.jdField_e_of_type_Int - this.jdField_c_of_type_Int);
    }
    if (this.jdField_c_of_type_Int >= this.jdField_e_of_type_Int)
    {
      this.jdField_f_of_type_Boolean = true;
      this.jdField_g_of_type_Boolean = false;
      return;
    }
    paramISuperPlayer = new OnlineVideoARRenderable.5(this);
    ARRenderMangerInnerCallback localARRenderMangerInnerCallback = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback;
    if (localARRenderMangerInnerCallback != null) {
      localARRenderMangerInnerCallback.a(paramISuperPlayer);
    }
  }
  
  public void onDefinitionInfoUpdate(ISuperPlayer paramISuperPlayer, String paramString, ArrayList<String> paramArrayList) {}
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    paramISuperPlayer = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback;
    if (paramISuperPlayer != null) {
      paramISuperPlayer.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelOnlineVideoARRenderableInfo.jdField_a_of_type_JavaLangString);
    }
    f();
    return false;
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(this.jdField_a_of_type_JavaLangRunnable);
    if (!this.l)
    {
      this.l = true;
      this.jdField_f_of_type_Int = 1;
    }
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    return false;
  }
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    QLog.d("AREngine_OnlineVideoARRenderable", 1, "onSeekComplete");
    paramISuperPlayer.start();
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    if (QLog.isColorLevel())
    {
      paramISuperPlayer = new StringBuilder();
      paramISuperPlayer.append("onVideoPrepared. mCanPlay=");
      paramISuperPlayer.append(this.jdField_d_of_type_Boolean);
      QLog.d("AREngine_OnlineVideoARRenderable", 2, paramISuperPlayer.toString());
    }
    if (!this.jdField_d_of_type_Boolean) {
      return;
    }
    if (this.jdField_h_of_type_Boolean)
    {
      this.jdField_h_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.start();
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    try
    {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.start();
      this.jdField_g_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.b(0, this.jdField_e_of_type_Int);
        return;
      }
    }
    catch (Exception paramISuperPlayer)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onVideoPrepared, exception=");
      localStringBuilder.append(paramISuperPlayer.getMessage());
      QLog.d("AREngine_OnlineVideoARRenderable", 1, localStringBuilder.toString());
      if (QLog.isColorLevel()) {
        paramISuperPlayer.printStackTrace();
      }
      f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.OnlineVideoARRenderable
 * JD-Core Version:    0.7.0.1
 */