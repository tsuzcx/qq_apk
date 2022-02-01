import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class awok
  implements View.OnClickListener
{
  awok(awoj paramawoj) {}
  
  public void onClick(View paramView)
  {
    if (awoj.a(this.a) != null) {
      awoj.a(this.a).a(awoj.a(this.a));
    }
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awok
 * JD-Core Version:    0.7.0.1
 */