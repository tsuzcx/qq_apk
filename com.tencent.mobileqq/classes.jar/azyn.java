import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;

public class azyn
{
  public static void a(View paramView, int paramInt, String paramString, BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface)
  {
    bbwx.a(paramBaseActivity, bbwx.a(paramInt, paramString), -1);
    paramView.setVisibility(8);
    azru.a().b(paramQQAppInterface);
    bdla.b(null, "dc00898", "", "", "0X800A4D5", "0X800A4D5", 0, 0, "1", "0", "", "");
  }
  
  public static void a(azrb paramazrb, BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface)
  {
    if (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
      bhiw.a(paramBaseActivity, paramQQAppInterface, 0, "signature_ziliaoka");
    }
    while (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      bdla.b(paramQQAppInterface, "CliOper", "", "", "0X8006A79", "0X8006A79", 0, 0, "", "", "", "");
      return;
      Intent localIntent = new Intent(paramBaseActivity, PublicFragmentActivity.class);
      localIntent.putExtra("key_uin", paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("key_uin_name", paramazrb.jdField_a_of_type_Bgvk.a.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("key_open_via", "history-kerentaiziliaoka");
      aeow.a(paramBaseActivity, localIntent, PublicFragmentActivity.class, SignatureHistoryFragment.class);
    }
    bdla.b(paramQQAppInterface, "CliOper", "", "", "0X8006A8D", "0X8006A8D", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azyn
 * JD-Core Version:    0.7.0.1
 */