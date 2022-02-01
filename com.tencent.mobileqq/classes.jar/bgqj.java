import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bgqj
  implements View.OnClickListener
{
  bgqj(bgqg parambgqg, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    ResultRecord localResultRecord = (ResultRecord)paramView.getTag();
    this.jdField_a_of_type_Bgqg.hideSoftInputFromWindow();
    MiniChatActivity.a(this.jdField_a_of_type_AndroidAppActivity, localResultRecord.a(), localResultRecord.a, localResultRecord.b, 0.86F, this.jdField_a_of_type_Bgqg.a(this.jdField_a_of_type_AndroidAppActivity, 0.78F));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bgqj
 * JD-Core Version:    0.7.0.1
 */