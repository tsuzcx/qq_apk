import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bbje
  implements View.OnClickListener
{
  bbje(bbjd parambbjd) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a.isShowing())
    {
      this.a.a.cancel();
      this.a.a.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbje
 * JD-Core Version:    0.7.0.1
 */