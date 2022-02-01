import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class atzd
  implements View.OnClickListener
{
  atzd(atzb paramatzb) {}
  
  public void onClick(View paramView)
  {
    int i = this.a.a.h();
    if ((i == 2) || (i == 3))
    {
      i = aufd.b(this.a.a.e());
      bdla.b(null, "dc00898", "", "", "0X800A688", "0X800A688", 0, 0, i + "", "", "", "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atzd
 * JD-Core Version:    0.7.0.1
 */