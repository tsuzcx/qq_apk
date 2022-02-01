import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.troop.activity.TroopCreateBaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bezy
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 0;
  TroopCreateBaseActivity jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateBaseActivity = null;
  String jdField_a_of_type_JavaLangString;
  
  public bezy(TroopCreateBaseActivity paramTroopCreateBaseActivity, int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateBaseActivity = paramTroopCreateBaseActivity;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateBaseActivity == null)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      if (this.jdField_a_of_type_Int == 0) {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateBaseActivity.b();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateBaseActivity.a(this.jdField_a_of_type_Int);
      break;
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateBaseActivity.c();
      }
      else if (this.jdField_a_of_type_Int == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateBaseActivity.d();
        continue;
        CustomWebView localCustomWebView = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateBaseActivity.a;
        if (localCustomWebView != null) {
          localCustomWebView.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "" });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bezy
 * JD-Core Version:    0.7.0.1
 */