import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aolc
  implements View.OnClickListener
{
  aolc(aolb paramaolb) {}
  
  public void onClick(View paramView)
  {
    if ((aolb.a(this.a) != null) && (aolb.a(this.a).isShowing())) {
      aolb.a(this.a).dismiss();
    }
    aolb.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aolc
 * JD-Core Version:    0.7.0.1
 */