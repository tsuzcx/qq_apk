import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class asto
  implements View.OnClickListener
{
  asto(Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    bdla.b(null, "dc00898", "", "", "kuolie", "0X80097DF", 0, 0, "", "", "", "");
    if ((this.a != null) && (this.a.isShowing())) {
      this.a.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asto
 * JD-Core Version:    0.7.0.1
 */