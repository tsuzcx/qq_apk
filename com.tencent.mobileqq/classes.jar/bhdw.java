import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class bhdw
  implements View.OnClickListener
{
  bhdw(QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(View paramView)
  {
    if (this.a != null) {
      this.a.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhdw
 * JD-Core Version:    0.7.0.1
 */