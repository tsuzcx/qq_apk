import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class atzf
  implements View.OnClickListener
{
  atzf(atzb paramatzb) {}
  
  public void onClick(View paramView)
  {
    int i = aufd.b(this.a.a.e());
    bdla.b(null, "dc00898", "", "", "0X800A688", "0X800A688", 0, 0, i + "", "", "", "");
    atvp localatvp = this.a.a.a();
    if (localatvp != null) {
      localatvp.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atzf
 * JD-Core Version:    0.7.0.1
 */