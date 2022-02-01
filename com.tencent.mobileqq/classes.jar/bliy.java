import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bliy
  implements View.OnClickListener
{
  bliy(blir paramblir) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    if (blir.a(this.a) != null) {
      blir.a(this.a).onDismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bliy
 * JD-Core Version:    0.7.0.1
 */