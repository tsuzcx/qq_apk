import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class befa
  implements View.OnClickListener
{
  befa(beez parambeez) {}
  
  public void onClick(View paramView)
  {
    if (beez.a(this.a).isShowing()) {
      beez.a(this.a).dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     befa
 * JD-Core Version:    0.7.0.1
 */