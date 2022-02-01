import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bjod
  implements View.OnClickListener
{
  bjod(bjnw parambjnw) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    if (bjnw.a(this.a) != null) {
      bjnw.a(this.a).onDismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjod
 * JD-Core Version:    0.7.0.1
 */