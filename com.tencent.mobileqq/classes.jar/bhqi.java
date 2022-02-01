import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bhqi
  implements View.OnClickListener
{
  bhqi(bhqg parambhqg) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null) {
      this.a.a.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhqi
 * JD-Core Version:    0.7.0.1
 */