import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aswf
  implements View.OnClickListener
{
  aswf(aswb paramaswb) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a.a() != null) {
      this.a.a.a().a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aswf
 * JD-Core Version:    0.7.0.1
 */