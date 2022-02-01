import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bcir
  implements View.OnClickListener
{
  bcir(bciq parambciq) {}
  
  public void onClick(View paramView)
  {
    bciq.a(this.a).a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcir
 * JD-Core Version:    0.7.0.1
 */