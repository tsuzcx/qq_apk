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
  private int A = 0;
  private KeyingBase B;
  private KeyingBase C;
  private KeyingParams D;
  private KeyingBase.UserInterface E = new OnlineVideoARRenderable.1(this);
  private Runnable F = new OnlineVideoARRenderable.2(this);
  private int G = -1;
  private int H = -1;
  private int I = -1;
  private IntBuffer[] J = new IntBuffer[3];
  private ByteBuffer[] K = new ByteBuffer[3];
  private int[] L = new int[3];
  private boolean M = true;
  private final boolean a = false;
  private float[] b = new float[16];
  private ARRenderMangerInnerCallback c;
  private OnlineVideoARRenderableInfo d;
  private float[] e = new float[16];
  private Surface f;
  private SurfaceTexture g;
  private int h = 0;
  private int i;
  private volatile ISuperPlayer j;
  private boolean k = false;
  private boolean l = false;
  private boolean m = false;
  private boolean n = false;
  private boolean o = false;
  private boolean p = false;
  private int q = 0;
  private boolean r = false;
  private boolean s = false;
  private boolean t = false;
  private long u = -1L;
  private String v = null;
  private boolean w = false;
  private int x = 0;
  private int y = 1;
  private boolean z = false;
  
  public OnlineVideoARRenderable(ARRenderMangerInnerCallback paramARRenderMangerInnerCallback, OnlineVideoARRenderableInfo paramOnlineVideoARRenderableInfo)
  {
    this.c = paramARRenderMangerInnerCallback;
    this.d = paramOnlineVideoARRenderableInfo;
    this.y = paramOnlineVideoARRenderableInfo.m;
    this.x = paramOnlineVideoARRenderableInfo.i;
    this.D = paramOnlineVideoARRenderableInfo.n;
    this.v = paramOnlineVideoARRenderableInfo.j;
    this.u = paramOnlineVideoARRenderableInfo.k;
    boolean bool = ARVideoUtil.a();
    if (QLog.isColorLevel())
    {
      paramARRenderMangerInnerCallback = new StringBuilder();
      paramARRenderMangerInnerCallback.append("Construction mSoftwarePlayConfig:false  isRubbishDevice:");
      paramARRenderMangerInnerCallback.append(bool);
      paramARRenderMangerInnerCallback.append("  isSoftPlay:");
      paramARRenderMangerInnerCallback.append(this.d.l);
      QLog.d("AREngine_OnlineVideoARRenderable", 2, paramARRenderMangerInnerCallback.toString());
    }
  }
  
  private int a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    paramInt1 -= 1;
    IntBuffer[] arrayOfIntBuffer = this.J;
    if (arrayOfIntBuffer[0] == null)
    {
      arrayOfIntBuffer[0] = IntBuffer.allocate(1);
      this.J[1] = IntBuffer.allocate(1);
      this.J[2] = IntBuffer.allocate(1);
    }
    this.J[paramInt1].clear();
    GLES20.glGenTextures(1, this.J[paramInt1]);
    int i1 = this.J[paramInt1].get();
    GLES20.glBindTexture(3553, i1);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    if ((this.K[paramInt1] == null) || (this.L[paramInt1] != paramArrayOfByte.length)) {
      try
      {
        this.K[paramInt1] = ByteBuffer.allocateDirect(paramArrayOfByte.length);
        this.K[paramInt1].order(ByteOrder.nativeOrder());
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
    this.L[paramInt1] = paramArrayOfByte.length;
    this.K[paramInt1].put(paramArrayOfByte);
    this.K[paramInt1].position(0);
    GLES20.glTexImage2D(3553, 0, 6409, paramInt2, paramInt3, 0, 6409, 5121, this.K[paramInt1]);
    return i1;
  }
  
  private void a()
  {
    QLog.d("AREngine_OnlineVideoARRenderable", 1, "initGl");
    Matrix.setIdentityM(this.e, 0);
    Object localObject = new int[1];
    GLES20.glGenTextures(1, (int[])localObject, 0);
    this.h = localObject[0];
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initGl, mTextureID=");
    ((StringBuilder)localObject).append(this.h);
    QLog.d("AREngine_OnlineVideoARRenderable", 1, ((StringBuilder)localObject).toString());
    if (this.h == 0) {
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
    this.j.openMediaPlayer(BaseApplicationImpl.getContext(), paramString, 0L, localSuperPlayerOption);
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
      if (this.C == null)
      {
        this.C = KeyingManager.a(this.D, 3);
        this.C.a(ARVideoUtil.b, ARVideoUtil.c);
        this.C.a("uniform int uDisplayType;\n", null, "    if(uDisplayType == 1){\n        // 需要渲染成圆形\n        float x = vTextureCoord.x;\n        float y = vTextureCoord.y;\n        // 圆心(0.5, 0.5), 0.25=0.5*0.5\n        if(pow(abs(x-0.5), 2.0) + pow(abs(y-0.5), 2.0) >= 0.25) {\n            gl_FragColor[3] = 0.0;\n        }\n    }\n", this.E);
        this.C.a(this.d.e, this.d.f, this.d.g, this.d.h);
      }
    }
    else if (this.B == null)
    {
      this.B = KeyingManager.a(this.D, 1);
      this.B.a(ARVideoUtil.a, ARVideoUtil.c);
      this.B.a("uniform int uDisplayType;\n", null, "    if(uDisplayType == 1){\n        // 需要渲染成圆形\n        float x = vTextureCoord.x;\n        float y = vTextureCoord.y;\n        // 圆心(0.5, 0.5), 0.25=0.5*0.5\n        if(pow(abs(x-0.5), 2.0) + pow(abs(y-0.5), 2.0) >= 0.25) {\n            gl_FragColor[3] = 0.0;\n        }\n    }\n", this.E);
      this.B.a(this.d.e, this.d.f, this.d.g, this.d.h);
    }
  }
  
  public void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4)
  {
    if ((this.n) && (paramArrayOfFloat2 != null))
    {
      if (this.d == null) {
        return;
      }
      GLES20.glBlendFunc(770, 771);
      GLES20.glEnable(3042);
      if (this.d.d == 1) {
        paramArrayOfFloat1 = a(paramArrayOfFloat1, paramArrayOfFloat3, paramArrayOfFloat4);
      } else {
        paramArrayOfFloat1 = a(paramArrayOfFloat1, paramArrayOfFloat2, paramArrayOfFloat4);
      }
      boolean bool = this.s;
      int i1;
      if (!bool)
      {
        if (this.B == null) {
          a(bool);
        }
        paramArrayOfFloat2 = this.B;
        if (paramArrayOfFloat2 != null)
        {
          i1 = this.h;
          paramArrayOfFloat3 = this.D;
          paramArrayOfFloat4 = this.e;
          paramArrayOfFloat2.a(new int[] { i1 }, paramArrayOfFloat3, paramArrayOfFloat1, paramArrayOfFloat4);
        }
      }
      else
      {
        if (this.C == null) {
          a(bool);
        }
        Matrix.setIdentityM(this.e, 0);
        paramArrayOfFloat2 = this.C;
        if (paramArrayOfFloat2 != null)
        {
          i1 = this.G;
          int i2 = this.H;
          int i3 = this.I;
          paramArrayOfFloat3 = this.D;
          paramArrayOfFloat4 = this.e;
          paramArrayOfFloat2.a(new int[] { i1, i2, i3 }, paramArrayOfFloat3, paramArrayOfFloat1, paramArrayOfFloat4);
        }
      }
      GLES20.glDisable(3042);
      GLES20.glBindTexture(3553, 0);
      GLES20.glBindTexture(36197, 0);
      if (this.M) {
        this.M = false;
      }
    }
  }
  
  public float[] a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3)
  {
    Matrix.setIdentityM(this.b, 0);
    if (q() == 2)
    {
      if (this.d.o != null)
      {
        Matrix.scaleM(this.b, 0, this.d.o.c * paramArrayOfFloat1[0], this.d.o.d * paramArrayOfFloat1[1], 1.0F);
        Matrix.translateM(this.b, 0, this.d.o.e, this.d.o.f, this.d.o.g);
      }
    }
    else if ((paramArrayOfFloat2 != null) && (paramArrayOfFloat3 != null))
    {
      if (this.d.e != 1) {
        Matrix.scaleM(this.b, 0, paramArrayOfFloat1[0], paramArrayOfFloat1[1], 1.0F);
      }
      paramArrayOfFloat1 = this.b;
      Matrix.multiplyMM(paramArrayOfFloat1, 0, paramArrayOfFloat2, 0, paramArrayOfFloat1, 0);
      paramArrayOfFloat1 = this.b;
      Matrix.multiplyMM(paramArrayOfFloat1, 0, paramArrayOfFloat3, 0, paramArrayOfFloat1, 0);
    }
    else
    {
      this.b = new float[16];
    }
    return this.b;
  }
  
  @TargetApi(11)
  public void i()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("init, mHasSDKInit=");
    localStringBuilder.append(this.k);
    QLog.d("AREngine_OnlineVideoARRenderable", 1, localStringBuilder.toString());
    if (this.k) {
      return;
    }
    a();
    QLog.d("AREngine_OnlineVideoARRenderable", 1, "initSDK");
    this.g = new SurfaceTexture(this.h);
    this.g.setOnFrameAvailableListener(this);
    this.f = new Surface(this.g);
    this.j = SuperPlayerFactory.createMediaPlayer(BaseApplicationImpl.getContext(), 108, null);
    this.j.setSurface(this.f);
    this.j.setOnVideoPreparedListener(this);
    this.j.setOnInfoListener(this);
    this.j.setOnErrorListener(this);
    this.j.setOnDefinitionInfoListener(this);
    this.j.setOnCompletionListener(this);
    this.j.setOnSeekCompleteListener(this);
    this.k = true;
  }
  
  public void j()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start, arResourceInfo=");
      ((StringBuilder)localObject).append(this.d);
      QLog.d("AREngine_OnlineVideoARRenderable", 2, ((StringBuilder)localObject).toString());
    }
    if ((!this.t) && (this.j != null) && (!this.j.isPlaying()))
    {
      if ((this.u >= 0L) && (!TextUtils.isEmpty(this.v)))
      {
        if (!this.k)
        {
          QLog.d("AREngine_OnlineVideoARRenderable", 1, "init failed");
          return;
        }
        this.l = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = 1;
        this.A = 0;
        this.z = false;
        this.m = true;
        this.t = true;
        localObject = AROnlineVideoUtil.a(this.v);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("start, video dir=");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(", mSoftwarePlayConfig=");
          localStringBuilder.append(false);
          QLog.d("AREngine_OnlineVideoARRenderable", 2, localStringBuilder.toString());
        }
        a(this.v);
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
  
  public void k() {}
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_OnlineVideoARRenderable", 2, "onDestroy");
    }
    this.m = false;
    this.l = false;
    this.m = false;
    this.n = false;
    this.o = false;
    this.p = false;
    this.s = false;
    this.q = 1;
    this.t = false;
    this.r = false;
    if (this.j != null) {
      try
      {
        this.j.stop();
        this.j.release();
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
        localObject = this.c;
        if (localObject != null) {
          ((ARRenderMangerInnerCallback)localObject).a(this.d.a);
        }
      }
    }
    Object localObject = this.B;
    if (localObject != null)
    {
      ((KeyingBase)localObject).c();
      this.B = null;
    }
    localObject = this.C;
    if (localObject != null)
    {
      ((KeyingBase)localObject).c();
      this.C = null;
    }
    localObject = new HashMap();
    ((HashMap)localObject).put("decode_type", String.valueOf(this.A));
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "immersed_ar_decode_type", true, 0L, 0L, (HashMap)localObject, "", false);
  }
  
  public int m()
  {
    OnlineVideoARRenderableInfo localOnlineVideoARRenderableInfo = this.d;
    if (localOnlineVideoARRenderableInfo != null) {
      return localOnlineVideoARRenderableInfo.b;
    }
    return 4;
  }
  
  public String n()
  {
    return this.d.a;
  }
  
  public boolean o()
  {
    return (this.k) && (this.l) && (this.j != null) && ((this.o) || (this.p) || (this.j.isPlaying()));
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_OnlineVideoARRenderable", 2, "onCompletion");
    }
    paramISuperPlayer = this.c;
    if (paramISuperPlayer != null) {
      paramISuperPlayer.b(2, this.y - this.q);
    }
    if (this.q >= this.y)
    {
      this.o = true;
      this.p = false;
      return;
    }
    paramISuperPlayer = new OnlineVideoARRenderable.5(this);
    ARRenderMangerInnerCallback localARRenderMangerInnerCallback = this.c;
    if (localARRenderMangerInnerCallback != null) {
      localARRenderMangerInnerCallback.a(paramISuperPlayer);
    }
  }
  
  public void onDefinitionInfoUpdate(ISuperPlayer paramISuperPlayer, String paramString, ArrayList<String> paramArrayList) {}
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    paramISuperPlayer = this.c;
    if (paramISuperPlayer != null) {
      paramISuperPlayer.a(this.d.a);
    }
    l();
    return false;
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    this.n = true;
    this.c.a(this.F);
    if (!this.z)
    {
      this.z = true;
      this.A = 1;
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
      paramISuperPlayer.append(this.m);
      QLog.d("AREngine_OnlineVideoARRenderable", 2, paramISuperPlayer.toString());
    }
    if (!this.m) {
      return;
    }
    if (this.r)
    {
      this.r = false;
      this.j.start();
      return;
    }
    this.l = true;
    try
    {
      this.j.start();
      this.p = true;
      if (this.c != null)
      {
        this.c.b(0, this.y);
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
      l();
    }
  }
  
  public boolean p()
  {
    return this.n;
  }
  
  public int q()
  {
    OnlineVideoARRenderableInfo localOnlineVideoARRenderableInfo = this.d;
    if (localOnlineVideoARRenderableInfo != null) {
      return localOnlineVideoARRenderableInfo.d;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.OnlineVideoARRenderable
 * JD-Core Version:    0.7.0.1
 */