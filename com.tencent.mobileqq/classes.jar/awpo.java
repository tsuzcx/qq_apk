import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.loginwelcome.LoginUserGuideHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class awpo
  implements View.OnClickListener
{
  awpo(awpl paramawpl, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    LoginUserGuideHelper.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Awpl.a.a, awpl.a(this.jdField_a_of_type_Awpl));
    this.jdField_a_of_type_Awpl.g();
    bdla.b(this.jdField_a_of_type_Awpl.a.a, "dc00898", "", "", "0X8009F4A", "0X8009F4A", 2, 0, "2", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awpo
 * JD-Core Version:    0.7.0.1
 */