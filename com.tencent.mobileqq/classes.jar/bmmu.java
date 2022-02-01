import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bmmu
  implements View.OnClickListener
{
  bmmu(bmms parambmms) {}
  
  public void onClick(View paramView)
  {
    bmbc.a().z();
    bmms.a(this.a);
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmmu
 * JD-Core Version:    0.7.0.1
 */