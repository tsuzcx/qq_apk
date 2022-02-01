import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bpjs
  implements View.OnClickListener
{
  bpjs(bpjo parambpjo) {}
  
  public void onClick(View paramView)
  {
    this.a.a(false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpjs
 * JD-Core Version:    0.7.0.1
 */