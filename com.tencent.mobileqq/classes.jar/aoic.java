import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aoic
  implements View.OnClickListener
{
  aoic(aohz paramaohz) {}
  
  public void onClick(View paramView)
  {
    bcst.b(null, "dc00898", "", "", "0X8009ACD", "0X8009ACD", 0, 0, "", "", "", "");
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoic
 * JD-Core Version:    0.7.0.1
 */