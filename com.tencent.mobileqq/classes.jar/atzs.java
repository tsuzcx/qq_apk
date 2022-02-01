import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class atzs
  implements View.OnClickListener
{
  atzs(atzr paramatzr) {}
  
  public void onClick(View paramView)
  {
    int i = aufd.b(this.a.a.e());
    bdla.b(null, "dc00898", "", "", "0X800A689", "0X800A689", 0, 0, i + "", "", "", "");
    this.a.a.g();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atzs
 * JD-Core Version:    0.7.0.1
 */