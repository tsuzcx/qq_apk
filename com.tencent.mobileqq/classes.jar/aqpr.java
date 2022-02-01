import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aqpr
  implements View.OnClickListener
{
  aqpr(aqpp paramaqpp) {}
  
  public void onClick(View paramView)
  {
    aqpl.a(this.a.a).setVisibility(8);
    aqpl.a(this.a.a, null);
    if (aqpl.a(this.a.a).getItemCount() == 0) {
      aqpl.a(this.a.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqpr
 * JD-Core Version:    0.7.0.1
 */