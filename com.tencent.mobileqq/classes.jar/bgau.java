import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.homework.entry.ui.SubmitHomeWorkFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bgau
  implements View.OnClickListener
{
  public bgau(SubmitHomeWorkFragment paramSubmitHomeWorkFragment) {}
  
  public void onClick(View paramView)
  {
    blgx.b(paramView);
    this.a.f();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgau
 * JD-Core Version:    0.7.0.1
 */