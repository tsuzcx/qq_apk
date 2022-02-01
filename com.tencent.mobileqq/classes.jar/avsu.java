import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoLoadingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class avsu
  implements View.OnClickListener
{
  private avsu(GroupVideoLoadingFragment paramGroupVideoLoadingFragment) {}
  
  public void onClick(View paramView)
  {
    GroupVideoLoadingFragment.a(this.a).a(anvx.a(2131704879), anvx.a(2131704883));
    GroupVideoLoadingFragment.a(this.a).c();
    GroupVideoLoadingFragment.a(this.a, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avsu
 * JD-Core Version:    0.7.0.1
 */