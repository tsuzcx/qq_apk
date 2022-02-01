import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bhes
  implements View.OnClickListener
{
  bhes(bheh parambheh) {}
  
  public void onClick(View paramView)
  {
    if ((bheh.a(this.a) != null) && (bheh.a(this.a).isShowing())) {
      bheh.a(this.a).dismiss();
    }
    bheh.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhes
 * JD-Core Version:    0.7.0.1
 */