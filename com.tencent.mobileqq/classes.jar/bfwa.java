import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bfwa
  implements View.OnClickListener
{
  bfwa(bfvp parambfvp) {}
  
  public void onClick(View paramView)
  {
    if ((bfvp.a(this.a) != null) && (bfvp.a(this.a).isShowing())) {
      bfvp.a(this.a).dismiss();
    }
    bfvp.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bfwa
 * JD-Core Version:    0.7.0.1
 */