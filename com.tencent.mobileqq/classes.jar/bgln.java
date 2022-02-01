import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bgln
  implements View.OnClickListener
{
  bgln(bglm parambglm) {}
  
  public void onClick(View paramView)
  {
    if (bglm.a(this.a).isShowing()) {
      this.a.d();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgln
 * JD-Core Version:    0.7.0.1
 */