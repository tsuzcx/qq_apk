import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amox
  implements CompoundButton.OnCheckedChangeListener
{
  amox(amow paramamow, RedTouch paramRedTouch, arsh paramarsh) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!AppSetting.c) {
      amow.a(this.jdField_a_of_type_Amow, this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, this.jdField_a_of_type_Arsh, paramBoolean);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amox
 * JD-Core Version:    0.7.0.1
 */