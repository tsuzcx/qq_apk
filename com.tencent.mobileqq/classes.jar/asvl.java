import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class asvl
  implements View.OnClickListener
{
  asvl(asvk paramasvk) {}
  
  public void onClick(View paramView)
  {
    int i = ataw.b(this.a.a.e());
    bcef.b(null, "dc00898", "", "", "0X800A689", "0X800A689", 0, 0, i + "", "", "", "");
    this.a.a.g();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asvl
 * JD-Core Version:    0.7.0.1
 */