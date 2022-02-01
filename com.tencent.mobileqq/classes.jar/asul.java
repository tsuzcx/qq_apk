import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class asul
  implements View.OnClickListener
{
  asul(asuj paramasuj) {}
  
  public void onClick(View paramView)
  {
    int i = ataw.b(this.a.a.e());
    bcef.b(null, "dc00898", "", "", "0X800A688", "0X800A688", 0, 0, i + "", "", "", "");
    asri localasri = this.a.a.a();
    if (localasri != null) {
      localasri.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asul
 * JD-Core Version:    0.7.0.1
 */