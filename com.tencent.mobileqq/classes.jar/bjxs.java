import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bjxs
  implements View.OnClickListener
{
  public bjxs(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  public void onClick(View paramView)
  {
    bhaa.a(this.a, this.a.jdField_a_of_type_AndroidWidgetImageView, this.a.jdField_a_of_type_Azrb.a.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjxs
 * JD-Core Version:    0.7.0.1
 */