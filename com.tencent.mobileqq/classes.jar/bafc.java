import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;

public class bafc
{
  public static void a(View paramView, int paramInt, String paramString, BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface)
  {
    bbwn.a(paramBaseActivity, bbwn.a(paramInt, paramString), -1);
    paramView.setVisibility(8);
    azyk.a().b(paramQQAppInterface);
    bdll.b(null, "dc00898", "", "", "0X800A4D5", "0X800A4D5", 0, 0, "1", "0", "", "");
  }
  
  public static void a(azxr paramazxr, BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface)
  {
    if (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
      bhto.a(paramBaseActivity, paramQQAppInterface, 0, "signature_ziliaoka");
    }
    while (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      bdll.b(paramQQAppInterface, "CliOper", "", "", "0X8006A79", "0X8006A79", 0, 0, "", "", "", "");
      return;
      Intent localIntent = new Intent(paramBaseActivity, PublicFragmentActivity.class);
      localIntent.putExtra("key_uin", paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("key_uin_name", paramazxr.jdField_a_of_type_Bhdh.a.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("key_open_via", "history-kerentaiziliaoka");
      afez.a(paramBaseActivity, localIntent, PublicFragmentActivity.class, SignatureHistoryFragment.class);
    }
    bdll.b(paramQQAppInterface, "CliOper", "", "", "0X8006A8D", "0X8006A8D", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bafc
 * JD-Core Version:    0.7.0.1
 */