import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.troop.activity.TroopCreateBaseActivity;

public class ayhl
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 0;
  TroopCreateBaseActivity jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateBaseActivity = null;
  String jdField_a_of_type_JavaLangString;
  
  public ayhl(TroopCreateBaseActivity paramTroopCreateBaseActivity, int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateBaseActivity = paramTroopCreateBaseActivity;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateBaseActivity == null) {
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
      return;
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateBaseActivity.c();
      }
      else if (this.jdField_a_of_type_Int == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateBaseActivity.d();
        continue;
        paramView = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateBaseActivity.a;
        if (paramView != null) {
          paramView.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "" });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayhl
 * JD-Core Version:    0.7.0.1
 */