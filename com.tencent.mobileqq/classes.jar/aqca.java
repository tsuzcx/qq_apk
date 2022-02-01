import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.setting.ArkAuthorityInfoActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aqca
  implements CompoundButton.OnCheckedChangeListener
{
  public aqca(ArkAuthorityInfoActivity paramArkAuthorityInfoActivity, int paramInt) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    String str1 = ArkAuthorityInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqArkSettingArkAuthorityInfoActivity);
    String str2 = ArkAuthorityInfoActivity.a()[this.jdField_a_of_type_Int];
    String str3 = this.jdField_a_of_type_ComTencentMobileqqArkSettingArkAuthorityInfoActivity.app.getCurrentAccountUin();
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      apsm.a(str1, str2, str3, i);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqca
 * JD-Core Version:    0.7.0.1
 */