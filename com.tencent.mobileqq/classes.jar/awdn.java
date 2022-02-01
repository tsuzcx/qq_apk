import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.loginwelcome.LoginUserGuideHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class awdn
  implements View.OnClickListener
{
  awdn(awdj paramawdj, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    LoginUserGuideHelper.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Awdj.a.a, awdj.a(this.jdField_a_of_type_Awdj));
    this.jdField_a_of_type_Awdj.g();
    bcst.b(this.jdField_a_of_type_Awdj.a.a, "dc00898", "", "", "0X8009F4A", "0X8009F4A", 1, 0, "1", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awdn
 * JD-Core Version:    0.7.0.1
 */