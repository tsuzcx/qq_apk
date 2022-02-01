import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class auan
  implements View.OnClickListener
{
  auan(auai paramauai) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a.a() != null) {
      this.a.a.a().a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auan
 * JD-Core Version:    0.7.0.1
 */