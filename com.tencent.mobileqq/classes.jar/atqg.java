import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class atqg
  implements View.OnClickListener
{
  atqg(atqe paramatqe) {}
  
  public void onClick(View paramView)
  {
    int i = atwt.b(this.a.a.e());
    bcst.b(null, "dc00898", "", "", "0X800A688", "0X800A688", 0, 0, i + "", "", "", "");
    atnd localatnd = this.a.a.a();
    if (localatnd != null) {
      localatnd.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atqg
 * JD-Core Version:    0.7.0.1
 */