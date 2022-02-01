import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.interestTag.InterestTagItemView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ayaz
  implements View.OnClickListener
{
  public ayaz(InterestTagItemView paramInterestTagItemView) {}
  
  public void onClick(View paramView)
  {
    if ((paramView == InterestTagItemView.a(this.a)) || (paramView == this.a))
    {
      InterestTagItemView.a(this.a).a(InterestTagItemView.a(this.a));
      this.a.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayaz
 * JD-Core Version:    0.7.0.1
 */