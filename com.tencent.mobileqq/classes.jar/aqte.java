import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aqte
  implements View.OnClickListener
{
  aqte(aqtc paramaqtc) {}
  
  public void onClick(View paramView)
  {
    aqsy.a(this.a.a).setVisibility(8);
    aqsy.a(this.a.a, null);
    if (aqsy.a(this.a.a).getItemCount() == 0) {
      aqsy.a(this.a.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqte
 * JD-Core Version:    0.7.0.1
 */