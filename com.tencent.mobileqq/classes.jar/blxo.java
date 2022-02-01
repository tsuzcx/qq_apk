import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class blxo
  implements View.OnClickListener
{
  blxo(blxk paramblxk) {}
  
  public void onClick(View paramView)
  {
    blxk.a(this.a).a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blxo
 * JD-Core Version:    0.7.0.1
 */