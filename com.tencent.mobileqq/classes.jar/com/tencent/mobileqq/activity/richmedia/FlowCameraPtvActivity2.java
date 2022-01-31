package com.tencent.mobileqq.activity.richmedia;

import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraAbility;
import com.tencent.qphone.base.util.QLog;

public class FlowCameraPtvActivity2
  extends FlowCameraActivity2
{
  protected void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    if (QLog.isColorLevel()) {
      QLog.d("FlowCameraActivity", 2, "onCreateView");
    }
    if (!CameraAbility.a()) {}
  }
  
  boolean b()
  {
    return true;
  }
  
  void d()
  {
    super.d();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = false;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public void x()
  {
    super.x();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.FlowCameraPtvActivity2
 * JD-Core Version:    0.7.0.1
 */