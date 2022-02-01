import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendCampusFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class asoh
  implements View.OnClickListener
{
  public asoh(ExtendFriendCampusFragment paramExtendFriendCampusFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null)
    {
      this.a.a.a();
      assw.a().b(3);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asoh
 * JD-Core Version:    0.7.0.1
 */