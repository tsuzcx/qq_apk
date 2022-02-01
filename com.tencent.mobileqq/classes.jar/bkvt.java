import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bkvt
  implements View.OnClickListener
{
  bkvt(bkvr parambkvr) {}
  
  public void onClick(View paramView)
  {
    if (bkvr.a(this.a))
    {
      if (bkvr.b(this.a)) {
        this.a.dismiss();
      }
      if (bkvr.b(this.a) != null) {
        bkvr.b(this.a).onClick(paramView);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkvt
 * JD-Core Version:    0.7.0.1
 */