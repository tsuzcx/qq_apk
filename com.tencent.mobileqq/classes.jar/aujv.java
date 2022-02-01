import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aujv
  implements View.OnClickListener
{
  aujv(aujr paramaujr) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a.a() != null) {
      this.a.a.a().a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aujv
 * JD-Core Version:    0.7.0.1
 */