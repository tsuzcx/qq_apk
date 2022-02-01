import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ankd
  implements View.OnClickListener
{
  ankd(anjz paramanjz, Activity paramActivity, boolean paramBoolean, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - anjz.a(this.jdField_a_of_type_Anjz) < 1000L)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    anjz.a(this.jdField_a_of_type_Anjz, System.currentTimeMillis());
    Object localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, PhoneUnityBindInfoActivity.class);
    this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
    if (this.jdField_a_of_type_Boolean) {}
    for (localObject = "0X800B3E7";; localObject = "0X800B3E4")
    {
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ankd
 * JD-Core Version:    0.7.0.1
 */