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
  protected int a;
  private SurfaceTexture a;
  protected ARGLSurfaceView a;
  protected CameraProxy a;
  protected UniformGLRenderManager a;
  protected boolean a;
  protected int b;
  protected int c;
  int d = 0;
  
  public ScanGLRenderBaseFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager = new UniformGLRenderManagerImpl();
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OpenCamera mCameraOpend:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqArModelCameraProxy.a());
    QLog.i("AREngine_ScanGLRenderFragment", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqArModelCameraProxy.a(paramInt);
  }
  
  private void c()
  {
    a(this.d);
    d();
  }
  
  private void d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startCameraPreview mSurfaceReady:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(";sCameraProxy.isCameraOpened()=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqArModelCameraProxy.a());
    QLog.i("AREngine_ScanGLRenderFragment", 1, localStringBuilder.toString());
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqArModelCameraProxy.a(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
    }
  }
  
  private void e()
  {
    QLog.i("AREngine_ScanGLRenderFragment", 1, "closeCamera");
    this.jdField_a_of_type_ComTencentMobileqqArModelCameraProxy.e();
  }
  
  public UniformGLRenderManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager;
  }
  
  public void a()
  {
    QLog.i("AREngine_ScanGLRenderFragment", 1, "onEglContextDestory");
    this.jdField_a_of_type_Boolean = false;
    UniformGLRenderManager localUniformGLRenderManager = this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager;
    if (localUniformGLRenderManager != null) {
      localUniformGLRenderManager.b();
    }
  }
  
  public void a(GL10 paramGL10)
  {
    QLog.i("AREngine_ScanGLRenderFragment", 1, "onSurfaceCreate");
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = GlUtil.createTexture(36197);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.jdField_a_of_type_Int);
  }
  
  public void a(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    QLog.i("AREngine_ScanGLRenderFragment", 1, "onSurfaceChange");
    this.b = paramInt1;
    this.c = paramInt2;
    this.jdField_a_of_type_Boolean = true;
    c();
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager;
    paramArrayOfByte.a(paramArrayOfByte.a() + 1L);
    paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager;
    paramArrayOfByte.b(paramArrayOfByte.a());
    paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView;
    if (paramArrayOfByte != null) {
      paramArrayOfByte.requestRender();
    }
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager != null)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqArModelCameraProxy.a();
      int j = this.jdField_a_of_type_ComTencentMobileqqArModelCameraProxy.b();
      this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidGraphicsSurfaceTexture, i, j, this.b, this.c);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStartPreviewSuccess imageWidth:");
      localStringBuilder.append(i);
      localStringBuilder.append(",imageHeight:");
      localStringBuilder.append(j);
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
      if ((this.d != 1) && (Camera.getNumberOfCameras() > 1))
      {
        int i = ARCamera.b(1);
        paramInt1 = paramInt2;
        if (i == 1)
        {
          this.d = i;
          c();
          paramInt1 = 1;
        }
      }
      else
      {
        this.d = 0;
        paramInt1 = paramInt2;
      }
    }
    if (paramInt1 == 0) {
      ThreadManager.getUIHandler().post(new ScanGLRenderBaseFragment.1(this));
    }
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
    this.jdField_a_of_type_ComTencentMobileqqArModelCameraProxy = CameraProxy.a();
    this.jdField_a_of_type_ComTencentMobileqqArModelCameraProxy.a(this);
    this.jdField_a_of_type_ComTencentMobileqqArModelCameraProxy.a(this);
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
    this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView = paramLayoutInflater;
    this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.a(this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView, getQBaseActivity());
    this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.setRenderer(this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager);
    this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.setRenderMode(0);
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
    localObject = this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager;
    if (localObject != null) {
      ((UniformGLRenderManager)localObject).c();
    }
    this.jdField_a_of_type_ComTencentMobileqqArModelCameraProxy.b(this);
    this.jdField_a_of_type_ComTencentMobileqqArModelCameraProxy.f();
    super.onDestroy();
  }
  
  public void onPause()
  {
    QLog.i("AREngine_ScanGLRenderFragment", 1, "onPause");
    ARGLSurfaceView localARGLSurfaceView = this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView;
    if (localARGLSurfaceView != null) {
      localARGLSurfaceView.onPause();
    }
    e();
    super.onPause();
  }
  
  public void onResume()
  {
    QLog.i("AREngine_ScanGLRenderFragment", 1, "onResume");
    super.onResume();
    ARGLSurfaceView localARGLSurfaceView = this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView;
    if (localARGLSurfaceView != null) {
      localARGLSurfaceView.onResume();
    }
    c();
  }
  
  public void onStart()
  {
    QLog.i("AREngine_ScanGLRenderFragment", 1, "onStart");
    super.onStart();
    UniformGLRenderManager localUniformGLRenderManager = this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager;
    if (localUniformGLRenderManager != null) {
      localUniformGLRenderManager.a();
    }
  }
  
  public void onStop()
  {
    QLog.i("AREngine_ScanGLRenderFragment", 1, "onStop");
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ScanGLRenderBaseFragment
 * JD-Core Version:    0.7.0.1
 */