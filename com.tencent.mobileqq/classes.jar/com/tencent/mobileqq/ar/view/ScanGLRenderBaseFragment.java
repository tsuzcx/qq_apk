package com.tencent.mobileqq.ar.view;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import apeq;
import apmp;
import apsa;
import apsb;
import apsd;
import apsl;
import apsm;
import apts;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARGLSurfaceView;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import javax.microedition.khronos.opengles.GL10;
import mqq.os.MqqHandler;

@TargetApi(14)
public abstract class ScanGLRenderBaseFragment
  extends ReportV4Fragment
  implements apeq, apsb, apsd, apts
{
  protected int a;
  private SurfaceTexture a;
  protected apsa a;
  protected apsl a;
  protected ARGLSurfaceView a;
  protected boolean a;
  protected int b;
  protected int c;
  int d = 0;
  
  public ScanGLRenderBaseFragment()
  {
    this.jdField_a_of_type_Apsl = new apsm();
  }
  
  private void a(int paramInt)
  {
    QLog.i("AREngine_ScanGLRenderFragment", 1, "OpenCamera mCameraOpend:" + this.jdField_a_of_type_Apsa.a());
    this.jdField_a_of_type_Apsa.a(paramInt);
  }
  
  private void c()
  {
    a(this.d);
    d();
  }
  
  private void d()
  {
    QLog.i("AREngine_ScanGLRenderFragment", 1, "startCameraPreview mSurfaceReady:" + this.jdField_a_of_type_Boolean + ";sCameraProxy.isCameraOpened()=" + this.jdField_a_of_type_Apsa.a());
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Apsa.a(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
    }
  }
  
  private void e()
  {
    QLog.i("AREngine_ScanGLRenderFragment", 1, "closeCamera");
    this.jdField_a_of_type_Apsa.e();
  }
  
  public apsl a()
  {
    return this.jdField_a_of_type_Apsl;
  }
  
  public void a()
  {
    QLog.i("AREngine_ScanGLRenderFragment", 1, "onEglContextDestory");
    this.jdField_a_of_type_Boolean = false;
    e();
    if (this.jdField_a_of_type_Apsl != null) {
      this.jdField_a_of_type_Apsl.b();
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
    this.jdField_a_of_type_Apsl.a(this.jdField_a_of_type_Apsl.a() + 1L);
    this.jdField_a_of_type_Apsl.b(this.jdField_a_of_type_Apsl.a());
    if (this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.requestRender();
    }
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Apsl != null)
    {
      int i = this.jdField_a_of_type_Apsa.a();
      int j = this.jdField_a_of_type_Apsa.b();
      this.jdField_a_of_type_Apsl.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidGraphicsSurfaceTexture, i, j, this.b, this.c);
      QLog.i("AREngine_ScanGLRenderFragment", 1, "onStartPreviewSuccess imageWidth:" + i + ",imageHeight:" + j + ",");
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    int i = 0;
    paramInt2 = 1;
    QLog.i("AREngine_ScanGLRenderFragment", 1, "Camera operation success stage:" + paramInt1);
    paramInt1 = i;
    if (isResumed())
    {
      if ((this.d == 1) || (Camera.getNumberOfCameras() <= 1)) {
        break label94;
      }
      paramInt1 = apmp.b(1);
      if (paramInt1 != 1) {
        break label104;
      }
      this.d = paramInt1;
      c();
      paramInt1 = paramInt2;
    }
    for (;;)
    {
      if (paramInt1 == 0) {
        ThreadManager.getUIHandler().post(new ScanGLRenderBaseFragment.1(this));
      }
      return;
      label94:
      this.d = 0;
      paramInt1 = i;
      continue;
      label104:
      paramInt1 = 0;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ScanGLRenderFragment", 2, "onCreate  this=" + this);
    }
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Apsa = apsa.a();
    this.jdField_a_of_type_Apsa.a(this);
    this.jdField_a_of_type_Apsa.a(this);
    if (QLog.isColorLevel()) {
      QLog.i("AREngine_ScanGLRenderFragment", 2, String.format("onCreate time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = new ARGLSurfaceView(getActivity(), null, null);
    paramLayoutInflater.setOnEglContextDestoryListener(this);
    if (paramLayoutInflater != null)
    {
      paramViewGroup = paramLayoutInflater.getParent();
      if (paramViewGroup != null)
      {
        QLog.d("AREngine_ScanGLRenderFragment", 1, String.format("onCreateView glSurfaceView has a parent? viewParent=%s", new Object[] { paramViewGroup }));
        if ((paramViewGroup instanceof ViewGroup)) {
          ((ViewGroup)paramViewGroup).removeView(paramLayoutInflater);
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView = paramLayoutInflater;
    this.jdField_a_of_type_Apsl.a(this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView, getActivity());
    this.jdField_a_of_type_Apsl.a(this);
    this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.setRenderer(this.jdField_a_of_type_Apsl);
    this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.setRenderMode(0);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  @TargetApi(18)
  public void onDestroy()
  {
    QLog.i("AREngine_ScanGLRenderFragment", 1, "onDestroy start.  this=" + this);
    if (this.jdField_a_of_type_Apsl != null) {
      this.jdField_a_of_type_Apsl.c();
    }
    this.jdField_a_of_type_Apsa.b(this);
    this.jdField_a_of_type_Apsa.f();
    super.onDestroy();
  }
  
  public void onPause()
  {
    QLog.i("AREngine_ScanGLRenderFragment", 1, "onPause");
    if (this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.onPause();
    }
    e();
    super.onPause();
  }
  
  public void onResume()
  {
    QLog.i("AREngine_ScanGLRenderFragment", 1, "onResume");
    super.onResume();
    if (this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.onResume();
    }
    c();
  }
  
  public void onStart()
  {
    QLog.i("AREngine_ScanGLRenderFragment", 1, "onStart");
    super.onStart();
    if (this.jdField_a_of_type_Apsl != null) {
      this.jdField_a_of_type_Apsl.a();
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