package com.tencent.aelight.camera.ae;

import android.app.Activity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class AEPituCameraUnit$54
  implements Runnable
{
  AEPituCameraUnit$54(AEPituCameraUnit paramAEPituCameraUnit, int paramInt) {}
  
  public void run()
  {
    switch (this.a)
    {
    default: 
      return;
    case 103: 
      QQToast.makeText(BaseApplicationImpl.getContext(), HardCodeUtil.a(2064187431), 0).show();
      return;
    case 102: 
      QQToast.makeText(BaseApplicationImpl.getContext(), HardCodeUtil.a(2064187433), 0).show();
      this.this$0.au();
      return;
    }
    QQToast.makeText(BaseApplicationImpl.getApplication(), HardCodeUtil.a(2064187432), 1).show();
    Activity localActivity = this.this$0.s();
    if ((localActivity != null) && (!localActivity.isFinishing())) {
      localActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.54
 * JD-Core Version:    0.7.0.1
 */