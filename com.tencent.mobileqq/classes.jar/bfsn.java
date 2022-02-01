import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bfsn
  implements View.OnClickListener
{
  public bfsn(ReciteFragment paramReciteFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.m();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfsn
 * JD-Core Version:    0.7.0.1
 */