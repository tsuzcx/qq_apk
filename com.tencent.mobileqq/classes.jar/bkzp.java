import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bkzp
  implements View.OnClickListener
{
  bkzp(bkzi parambkzi) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    if (bkzi.a(this.a) != null) {
      bkzi.a(this.a).onDismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkzp
 * JD-Core Version:    0.7.0.1
 */