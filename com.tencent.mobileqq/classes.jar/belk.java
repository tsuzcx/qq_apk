import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class belk
  implements View.OnClickListener
{
  public belk(ReciteFragment paramReciteFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.m();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     belk
 * JD-Core Version:    0.7.0.1
 */