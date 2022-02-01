import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class auzg
  implements View.OnClickListener
{
  public auzg(ForwardFileOption paramForwardFileOption) {}
  
  public void onClick(View paramView)
  {
    this.a.F();
    ForwardFileOption.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auzg
 * JD-Core Version:    0.7.0.1
 */