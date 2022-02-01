import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amrh
  implements View.OnClickListener
{
  amrh(amrg paramamrg) {}
  
  public void onClick(View paramView)
  {
    amrg.a(this.a, true);
    this.a.a();
    amrg.a(this.a, -1, -1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amrh
 * JD-Core Version:    0.7.0.1
 */