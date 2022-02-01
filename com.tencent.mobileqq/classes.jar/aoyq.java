import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aoyq
  implements View.OnClickListener
{
  aoyq(aoyp paramaoyp) {}
  
  public void onClick(View paramView)
  {
    if ((aoyp.a(this.a) != null) && (aoyp.a(this.a).isShowing())) {
      aoyp.a(this.a).dismiss();
    }
    aoyp.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoyq
 * JD-Core Version:    0.7.0.1
 */