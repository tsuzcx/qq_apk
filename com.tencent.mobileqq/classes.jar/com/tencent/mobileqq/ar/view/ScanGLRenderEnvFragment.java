package com.tencent.mobileqq.ar.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.ar.ARArguments;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl;
import com.tencent.mobileqq.ar.ARRecord.VideoEncoderUtils;
import com.tencent.mobileqq.ar.ARRecord.VideoRecordController;
import com.tencent.mobileqq.ar.model.UniformGLRenderManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

public class ScanGLRenderEnvFragment
  extends ScanGLRenderBaseFragment
{
  private VideoRecordController i;
  
  public static ScanGLRenderEnvFragment a(ARArguments paramARArguments)
  {
    ScanGLRenderEnvFragment localScanGLRenderEnvFragment = new ScanGLRenderEnvFragment();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("AR_ARGUMENTS", paramARArguments);
    localScanGLRenderEnvFragment.setArguments(localBundle);
    return localScanGLRenderEnvFragment;
  }
  
  private void d()
  {
    boolean bool = VideoEncoderUtils.a();
    QLog.d("AREngine_ScanGLRenderEnvFragment", 2, String.format("initVideoRecord support=%s", new Object[] { Boolean.valueOf(bool) }));
    if (bool)
    {
      if (this.i == null)
      {
        this.i = new VideoRecordController(getQBaseActivity());
        ARVideoRecordUIControllerImpl.a().a(this.i);
      }
      UniformGLRenderManager localUniformGLRenderManager = this.b;
      if (localUniformGLRenderManager != null) {
        localUniformGLRenderManager.a(this.i);
      }
    }
  }
  
  private void e()
  {
    boolean bool = VideoEncoderUtils.a();
    QLog.d("AREngine_ScanGLRenderEnvFragment", 2, String.format("unInitVideoRecord support=%s", new Object[] { Boolean.valueOf(bool) }));
    if (bool)
    {
      UniformGLRenderManager localUniformGLRenderManager = this.b;
      if (localUniformGLRenderManager != null) {
        localUniformGLRenderManager.a(null);
      }
      ARVideoRecordUIControllerImpl.a().b(this.i);
      if (this.i != null) {
        this.i = null;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    d();
    paramLayoutInflater = this.a;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    QLog.i("AREngine_ScanGLRenderEnvFragment", 1, "onResume");
    e();
    super.onDestroy();
  }
  
  public void onPause()
  {
    QLog.i("AREngine_ScanGLRenderEnvFragment", 1, "onPause");
    super.onPause();
  }
  
  public void onResume()
  {
    QLog.i("AREngine_ScanGLRenderEnvFragment", 1, "onResume");
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ScanGLRenderEnvFragment
 * JD-Core Version:    0.7.0.1
 */