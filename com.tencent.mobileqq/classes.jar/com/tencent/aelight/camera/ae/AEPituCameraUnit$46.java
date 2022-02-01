package com.tencent.aelight.camera.ae;

import android.app.Activity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class AEPituCameraUnit$46
  implements Runnable
{
  AEPituCameraUnit$46(AEPituCameraUnit paramAEPituCameraUnit, int paramInt) {}
  
  public void run()
  {
    switch (this.a)
    {
    default: 
      return;
    case 103: 
      QQToast.a(BaseApplicationImpl.getContext(), HardCodeUtil.a(2064515099), 0).a();
      return;
    case 102: 
      QQToast.a(BaseApplicationImpl.getContext(), HardCodeUtil.a(2064515101), 0).a();
      this.this$0.R();
      return;
    }
    QQToast.a(BaseApplicationImpl.getApplication(), HardCodeUtil.a(2064515100), 1).a();
    Activity localActivity = this.this$0.a();
    if ((localActivity != null) && (!localActivity.isFinishing())) {
      localActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.46
 * JD-Core Version:    0.7.0.1
 */