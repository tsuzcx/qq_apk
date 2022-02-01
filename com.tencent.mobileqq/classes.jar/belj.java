import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.homework.entry.ui.BeginnerGuideFragment;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class belj
  implements View.OnClickListener
{
  public belj(ReciteFragment paramReciteFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.m();
    BeginnerGuideFragment.b(ReciteFragment.a(this.a), null, 4);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     belj
 * JD-Core Version:    0.7.0.1
 */