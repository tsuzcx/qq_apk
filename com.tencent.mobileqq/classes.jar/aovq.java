import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aovq
  implements View.OnClickListener
{
  aovq(aovn paramaovn) {}
  
  public void onClick(View paramView)
  {
    bdll.b(null, "dc00898", "", "", "0X8009ACD", "0X8009ACD", 0, 0, "", "", "", "");
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aovq
 * JD-Core Version:    0.7.0.1
 */