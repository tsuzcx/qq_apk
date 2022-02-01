import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bgna
  implements View.OnClickListener
{
  bgna(bgmp parambgmp) {}
  
  public void onClick(View paramView)
  {
    if ((bgmp.a(this.a) != null) && (bgmp.a(this.a).isShowing())) {
      bgmp.a(this.a).dismiss();
    }
    bgmp.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bgna
 * JD-Core Version:    0.7.0.1
 */