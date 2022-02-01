import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.loginwelcome.LoginUserGuideHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class awwf
  implements View.OnClickListener
{
  awwf(awwb paramawwb, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    LoginUserGuideHelper.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Awwb.a.a, awwb.a(this.jdField_a_of_type_Awwb));
    this.jdField_a_of_type_Awwb.g();
    bdll.b(this.jdField_a_of_type_Awwb.a.a, "dc00898", "", "", "0X8009F4A", "0X8009F4A", 1, 0, "1", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awwf
 * JD-Core Version:    0.7.0.1
 */