import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.homework.entry.ui.view.ComplexGuidViewPager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bfbo
  implements View.OnClickListener
{
  public bfbo(ComplexGuidViewPager paramComplexGuidViewPager) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null) {
      this.a.a.b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfbo
 * JD-Core Version:    0.7.0.1
 */