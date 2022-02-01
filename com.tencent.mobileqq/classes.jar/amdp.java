import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.selectmember.FriendTabView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class amdp
  implements View.OnClickListener
{
  public amdp(FriendTabView paramFriendTabView) {}
  
  public void onClick(View paramView)
  {
    this.a.a.a(1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amdp
 * JD-Core Version:    0.7.0.1
 */