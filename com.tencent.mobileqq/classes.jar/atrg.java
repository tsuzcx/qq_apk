import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class atrg
  implements View.OnClickListener
{
  atrg(atrf paramatrf) {}
  
  public void onClick(View paramView)
  {
    int i = atwt.b(this.a.a.e());
    bcst.b(null, "dc00898", "", "", "0X800A689", "0X800A689", 0, 0, i + "", "", "", "");
    this.a.a.g();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atrg
 * JD-Core Version:    0.7.0.1
 */