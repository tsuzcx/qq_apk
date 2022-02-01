import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class blom
  implements View.OnClickListener
{
  blom(blol paramblol) {}
  
  public void onClick(View paramView)
  {
    if (this.a.isShowing()) {
      this.a.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blom
 * JD-Core Version:    0.7.0.1
 */