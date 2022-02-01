package com.tencent.mobileqq.ar.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import aoai;
import aoat;
import aoav;
import aoly;
import com.tencent.mobileqq.ar.ARArguments;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;

public class ScanGLRenderEnvFragment
  extends ScanGLRenderBaseFragment
{
  private aoav a;
  
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
    boolean bool = aoat.a();
    QLog.d("AREngine_ScanGLRenderEnvFragment", 2, String.format("initVideoRecord support=%s", new Object[] { Boolean.valueOf(bool) }));
    if (bool)
    {
      if (this.jdField_a_of_type_Aoav == null)
      {
        this.jdField_a_of_type_Aoav = new aoav(getActivity());
        aoai.a().a(this.jdField_a_of_type_Aoav);
      }
      aoly localaoly = this.jdField_a_of_type_Aoly;
      if (localaoly != null) {
        localaoly.a(this.jdField_a_of_type_Aoav);
      }
    }
  }
  
  private void d()
  {
    boolean bool = aoat.a();
    QLog.d("AREngine_ScanGLRenderEnvFragment", 2, String.format("unInitVideoRecord support=%s", new Object[] { Boolean.valueOf(bool) }));
    if (bool)
    {
      aoly localaoly = this.jdField_a_of_type_Aoly;
      if (localaoly != null) {
        localaoly.a(null);
      }
      aoai.a().b(this.jdField_a_of_type_Aoav);
      if (this.jdField_a_of_type_Aoav != null) {
        this.jdField_a_of_type_Aoav = null;
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
    paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ScanGLRenderEnvFragment
 * JD-Core Version:    0.7.0.1
 */