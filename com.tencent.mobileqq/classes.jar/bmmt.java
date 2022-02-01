import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bmmt
  implements View.OnClickListener
{
  bmmt(bmms parambmms) {}
  
  public void onClick(View paramView)
  {
    bmbc.a().y();
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmmt
 * JD-Core Version:    0.7.0.1
 */