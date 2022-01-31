package com.tencent.mobileqq.ar.view;

import amup;
import amva;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ange;
import com.tencent.mobileqq.ar.ARArguments;
import com.tencent.mobileqq.ar.ARRecord.VideoRecordController;
import com.tencent.qphone.base.util.QLog;

public class ScanGLRenderEnvFragment
  extends ScanGLRenderBaseFragment
{
  private VideoRecordController a;
  
  public static ScanGLRenderEnvFragment a(ARArguments paramARArguments)
  {
    ScanGLRenderEnvFragment localScanGLRenderEnvFragment = new ScanGLRenderEnvFragment();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("AR_ARGUMENTS", paramARArguments);
    localScanGLRenderEnvFragment.setArguments(localBundle);
    return localScanGLRenderEnvFragment;
  }
  
  private void c()
  {
    boolean bool = amva.a();
    QLog.d("AREngine_ScanGLRenderEnvFragment", 2, String.format("initVideoRecord support=%s", new Object[] { Boolean.valueOf(bool) }));
    if (bool)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController = new VideoRecordController(getActivity());
        amup.a().a(this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController);
      }
      ange localange = this.jdField_a_of_type_Ange;
      if (localange != null) {
        localange.a(this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController);
      }
    }
  }
  
  private void d()
  {
    boolean bool = amva.a();
    QLog.d("AREngine_ScanGLRenderEnvFragment", 2, String.format("unInitVideoRecord support=%s", new Object[] { Boolean.valueOf(bool) }));
    if (bool)
    {
      ange localange = this.jdField_a_of_type_Ange;
      if (localange != null) {
        localange.a(null);
      }
      amup.a().b(this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController);
      if (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController != null) {
        this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController = null;
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
    c();
    return this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView;
  }
  
  public void onDestroy()
  {
    QLog.i("AREngine_ScanGLRenderEnvFragment", 1, "onResume");
    d();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ScanGLRenderEnvFragment
 * JD-Core Version:    0.7.0.1
 */