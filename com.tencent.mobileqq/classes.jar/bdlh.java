import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;

class bdlh
  implements View.OnClickListener
{
  bdlh(bdle parambdle, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = (ResultRecord)paramView.getTag();
    this.jdField_a_of_type_Bdle.hideSoftInputFromWindow();
    MiniChatActivity.a(this.jdField_a_of_type_AndroidAppActivity, paramView.a(), paramView.a, paramView.b, 0.86F, this.jdField_a_of_type_Bdle.a(this.jdField_a_of_type_AndroidAppActivity, 0.78F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdlh
 * JD-Core Version:    0.7.0.1
 */