package com.tencent.mobileqq.ar.view;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARGLSurfaceView;
import com.tencent.mobileqq.ar.ARGLSurfaceView.OnEglContextDestoryListener;
import com.tencent.mobileqq.ar.arengine.ARCamera;
import com.tencent.mobileqq.ar.model.CameraProxy;
import com.tencent.mobileqq.ar.model.CameraProxy.CameraOperationStatusCallBack;
import com.tencent.mobileqq.ar.model.CameraProxy.OnCameraPreviewCallback;
import com.tencent.mobileqq.ar.model.UniformGLRenderManager;
import com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import javax.microedition.khronos.opengles.GL10;
import mqq.os.MqqHandler;

@TargetApi(14)
public abstract class ScanGLRenderBaseFragment
  extends BaseFragment
  implements ARGLSurfaceView.OnEglContextDestoryListener, CameraProxy.CameraOperationStatusCallBack, CameraProxy.OnCameraPreviewCallback, GLRenderStatusCallBack
{
  protected ARGLSurfaceView a;
  protected UniformGLRenderManager b = new UniformGLRenderManagerImpl();
  protected CameraProxy c;
  protected int d;
  protected boolean e = false;
  protected int f;
  protected int g;
  int h = 0;
  private SurfaceTexture i;
  
  private void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OpenCamera mCameraOpend:");
    localStringBuilder.append(this.c.f());
    QLog.i("AREngine_ScanGLRenderFragment", 1, localStringBuilder.toString());
    this.c.a(paramInt);
  }
  
  private void d()
  {
    a(this.h);
    e();
  }
  
  private void e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startCameraPreview mSurfaceReady:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(";sCameraProxy.isCameraOpened()=");
    localStringBuilder.append(this.c.f());
    QLog.i("AREngine_ScanGLRenderFragment", 1, localStringBuilder.toString());
    if (this.e) {
      this.c.a(this.i);
    }
  }
  
  private void f()
  {
    QLog.i("AREngine_ScanGLRenderFragment", 1, "closeCamera");
    this.c.k();
  }
  
  public void a()
  {
    QLog.i("AREngine_ScanGLRenderFragment", 1, "onEglContextDestory");
    this.e = false;
    UniformGLRenderManager localUniformGLRenderManager = this.b;
    if (localUniformGLRenderManager != null) {
      localUniformGLRenderManager.f();
    }
  }
  
  public void a(GL10 paramGL10)
  {
    QLog.i("AREngine_ScanGLRenderFragment", 1, "onSurfaceCreate");
    this.e = false;
    this.d = GlUtil.createTexture(36197);
    this.i = new SurfaceTexture(this.d);
  }
  
  public void a(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    QLog.i("AREngine_ScanGLRenderFragment", 1, "onSurfaceChange");
    this.f = paramInt1;
    this.g = paramInt2;
    this.e = true;
    d();
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = this.b;
    paramArrayOfByte.a(paramArrayOfByte.k() + 1L);
    paramArrayOfByte = this.b;
    paramArrayOfByte.b(paramArrayOfByte.k());
    paramArrayOfByte = this.a;
    if (paramArrayOfByte != null) {
      paramArrayOfByte.requestRender();
    }
    return true;
  }
  
  public void b()
  {
    if (this.b != null)
    {
      int j = this.c.h();
      int k = this.c.i();
      this.b.a(this.d, this.i, j, k, this.f, this.g);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStartPreviewSuccess imageWidth:");
      localStringBuilder.append(j);
      localStringBuilder.append(",imageHeight:");
      localStringBuilder.append(k);
      localStringBuilder.append(",");
      QLog.i("AREngine_ScanGLRenderFragment", 1, localStringBuilder.toString());
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Camera operation success stage:");
    localStringBuilder.append(paramInt1);
    QLog.i("AREngine_ScanGLRenderFragment", 1, localStringBuilder.toString());
    boolean bool = isResumed();
    paramInt2 = 0;
    paramInt1 = paramInt2;
    if (bool) {
      if ((this.h != 1) && (Camera.getNumberOfCameras() > 1))
      {
        int j = ARCamera.b(1);
        paramInt1 = paramInt2;
        if (j == 1)
        {
          this.h = j;
          d();
          paramInt1 = 1;
        }
      }
      else
      {
        this.h = 0;
        paramInt1 = paramInt2;
      }
    }
    if (paramInt1 == 0) {
      ThreadManager.getUIHandler().post(new ScanGLRenderBaseFragment.1(this));
    }
  }
  
  public UniformGLRenderManager c()
  {
    return this.b;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreate  this=");
      localStringBuilder.append(this);
      QLog.d("AREngine_ScanGLRenderFragment", 2, localStringBuilder.toString());
    }
    super.onCreate(paramBundle);
    this.c = CameraProxy.a();
    this.c.a(this);
    this.c.a(this);
    if (QLog.isColorLevel()) {
      QLog.i("AREngine_ScanGLRenderFragment", 2, String.format("onCreate time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = new ARGLSurfaceView(getQBaseActivity(), null, null);
    paramLayoutInflater.setOnEglContextDestoryListener(this);
    paramViewGroup = paramLayoutInflater.getParent();
    if (paramViewGroup != null)
    {
      QLog.d("AREngine_ScanGLRenderFragment", 1, String.format("onCreateView glSurfaceView has a parent? viewParent=%s", new Object[] { paramViewGroup }));
      if ((paramViewGroup instanceof ViewGroup)) {
        ((ViewGroup)paramViewGroup).removeView(paramLayoutInflater);
      }
    }
    this.a = paramLayoutInflater;
    this.b.a(this.a, getQBaseActivity());
    this.b.a(this);
    this.a.setRenderer(this.b);
    this.a.setRenderMode(0);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  @TargetApi(18)
  public void onDestroy()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onDestroy start.  this=");
    ((StringBuilder)localObject).append(this);
    QLog.i("AREngine_ScanGLRenderFragment", 1, ((StringBuilder)localObject).toString());
    localObject = this.b;
    if (localObject != null) {
      ((UniformGLRenderManager)localObject).g();
    }
    this.c.b(this);
    this.c.l();
    super.onDestroy();
  }
  
  public void onPause()
  {
    QLog.i("AREngine_ScanGLRenderFragment", 1, "onPause");
    ARGLSurfaceView localARGLSurfaceView = this.a;
    if (localARGLSurfaceView != null) {
      localARGLSurfaceView.onPause();
    }
    f();
    super.onPause();
  }
  
  public void onResume()
  {
    QLog.i("AREngine_ScanGLRenderFragment", 1, "onResume");
    super.onResume();
    ARGLSurfaceView localARGLSurfaceView = this.a;
    if (localARGLSurfaceView != null) {
      localARGLSurfaceView.onResume();
    }
    d();
  }
  
  public void onStart()
  {
    QLog.i("AREngine_ScanGLRenderFragment", 1, "onStart");
    super.onStart();
    UniformGLRenderManager localUniformGLRenderManager = this.b;
    if (localUniformGLRenderManager != null) {
      localUniformGLRenderManager.e();
    }
  }
  
  public void onStop()
  {
    QLog.i("AREngine_ScanGLRenderFragment", 1, "onStop");
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ScanGLRenderBaseFragment
 * JD-Core Version:    0.7.0.1
 */