import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendCampusFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class asxu
  implements View.OnClickListener
{
  public asxu(ExtendFriendCampusFragment paramExtendFriendCampusFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null)
    {
      this.a.a.a();
      atci.a().b(3);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asxu
 * JD-Core Version:    0.7.0.1
 */