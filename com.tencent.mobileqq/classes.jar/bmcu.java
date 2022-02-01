import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bmcu
  implements View.OnClickListener
{
  bmcu(bmct parambmct) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a.a != null) && (!this.a.a.a.isFinishing())) {
      this.a.a.a.finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmcu
 * JD-Core Version:    0.7.0.1
 */