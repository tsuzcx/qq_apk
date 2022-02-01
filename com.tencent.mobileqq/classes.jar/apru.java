import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.ark.setting.ArkAppListActivity;
import com.tencent.mobileqq.ark.setting.ArkAuthorityInfoActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class apru
  implements View.OnClickListener
{
  public apru(ArkAppListActivity paramArkAppListActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqArkSettingArkAppListActivity, ArkAuthorityInfoActivity.class);
    localIntent.putExtra("intent_extra_authority_app_name", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqArkSettingArkAppListActivity.startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apru
 * JD-Core Version:    0.7.0.1
 */