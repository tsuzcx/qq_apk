import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aomn
  implements View.OnClickListener
{
  aomn(aomk paramaomk, Activity paramActivity, String paramString, boolean paramBoolean, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
    if (aomk.a(this.jdField_a_of_type_Aomk) == null)
    {
      aomk.a(this.jdField_a_of_type_Aomk, new aomq(null));
      localObject = new IntentFilter("com.tencent.mobileqq.InvitationWebViewPlugin.accountIdentityNotify");
      this.jdField_a_of_type_AndroidAppActivity.registerReceiver(aomk.a(this.jdField_a_of_type_Aomk), (IntentFilter)localObject);
    }
    if (this.jdField_a_of_type_Boolean) {}
    for (localObject = "0X800B277";; localObject = "0X800B274")
    {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aomn
 * JD-Core Version:    0.7.0.1
 */