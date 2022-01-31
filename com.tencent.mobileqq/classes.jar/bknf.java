import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;

public class bknf
  extends Handler
{
  public bknf(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1000: 
      for (;;)
      {
        super.handleMessage(paramMessage);
        return;
        QIMEffectCameraCaptureUnit.d(this.a).setVisibility(8);
        if (((paramMessage.obj instanceof Boolean)) && (((Boolean)paramMessage.obj).booleanValue()))
        {
          QIMEffectCameraCaptureUnit.f(this.a, false);
          this.a.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.z();
        }
      }
    }
    boolean bool1;
    label104:
    boolean bool2;
    label134:
    Object localObject;
    if (paramMessage.arg1 == 1)
    {
      bool1 = true;
      if ((!this.a.u) || (this.a.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.a() == 0) || (!bool1)) {
        break label237;
      }
      bool2 = true;
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView;
      if (!bool2) {
        break label243;
      }
      i = 0;
      label150:
      ((RedDotImageView)localObject).setVisibility(i);
      localObject = this.a.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager;
      if (!bool1) {
        break label248;
      }
    }
    label237:
    label243:
    label248:
    for (int i = 0;; i = 4)
    {
      ((VideoFilterViewPager)localObject).setVisibility(i);
      this.a.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.setEnabled(bool1);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QIMEffectCameraCaptureUnit", 2, new Object[] { "checkEffectButton ", Boolean.valueOf(bool2), " filter So exists:", Boolean.valueOf(bool1) });
      break;
      bool1 = false;
      break label104;
      bool2 = false;
      break label134;
      i = 4;
      break label150;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bknf
 * JD-Core Version:    0.7.0.1
 */