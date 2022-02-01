import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.forward.ForwardShortVideoOption;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class auku
  implements View.OnClickListener
{
  public auku(ForwardShortVideoOption paramForwardShortVideoOption) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null) {
      ForwardShortVideoOption.a(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auku
 * JD-Core Version:    0.7.0.1
 */