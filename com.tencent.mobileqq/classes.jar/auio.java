import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class auio
  implements View.OnClickListener
{
  auio(auik paramauik) {}
  
  public void onClick(View paramView)
  {
    int i = auoo.b(this.a.a.e());
    bdll.b(null, "dc00898", "", "", "0X800A688", "0X800A688", 0, 0, i + "", "", "", "");
    auey localauey = this.a.a.a();
    if (localauey != null) {
      localauey.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auio
 * JD-Core Version:    0.7.0.1
 */