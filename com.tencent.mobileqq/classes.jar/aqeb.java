import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aqeb
  implements View.OnClickListener
{
  aqeb(aqdz paramaqdz) {}
  
  public void onClick(View paramView)
  {
    aqdv.a(this.a.a).setVisibility(8);
    aqdv.a(this.a.a, null);
    if (aqdv.a(this.a.a).getItemCount() == 0) {
      aqdv.a(this.a.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqeb
 * JD-Core Version:    0.7.0.1
 */