import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bkhl
  implements View.OnClickListener
{
  public bkhl(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  public void onClick(View paramView)
  {
    bhhz.a(this.a, this.a.jdField_a_of_type_AndroidWidgetImageView, this.a.jdField_a_of_type_Azxr.a.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkhl
 * JD-Core Version:    0.7.0.1
 */