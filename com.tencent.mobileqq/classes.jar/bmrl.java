import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bmrl
  implements View.OnClickListener
{
  bmrl(bmrk parambmrk) {}
  
  public void onClick(View paramView)
  {
    if (bmrk.a(this.a))
    {
      if (bmrk.b(this.a)) {
        this.a.dismiss();
      }
      if (bmrk.a(this.a) != null) {
        bmrk.a(this.a).onClick(paramView);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmrl
 * JD-Core Version:    0.7.0.1
 */