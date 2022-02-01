import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class biaz
  implements View.OnClickListener
{
  biaz(biay parambiay) {}
  
  public void onClick(View paramView)
  {
    biay.a(this.a).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biaz
 * JD-Core Version:    0.7.0.1
 */