import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class asuw
  implements View.OnClickListener
{
  asuw(asuu paramasuu) {}
  
  public void onClick(View paramView)
  {
    int i = this.a.a.h();
    if ((i == 2) || (i == 3))
    {
      i = ataw.b(this.a.a.e());
      bcef.b(null, "dc00898", "", "", "0X800A688", "0X800A688", 0, 0, i + "", "", "", "");
      if (this.a.a.a() != null) {
        this.a.a.a().a();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((i == 1) && (this.a.a.a() != null)) {
        this.a.a.a().a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asuw
 * JD-Core Version:    0.7.0.1
 */