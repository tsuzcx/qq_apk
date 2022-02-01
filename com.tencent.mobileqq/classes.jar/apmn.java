import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class apmn
  implements View.OnClickListener
{
  apmn(apml paramapml) {}
  
  public void onClick(View paramView)
  {
    apmh.a(this.a.a).setVisibility(8);
    apmh.a(this.a.a, null);
    if (apmh.a(this.a.a).getItemCount() == 0) {
      apmh.a(this.a.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apmn
 * JD-Core Version:    0.7.0.1
 */