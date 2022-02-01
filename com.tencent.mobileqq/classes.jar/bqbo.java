import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.view.PressDarkImageButton;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bqbo
  implements View.OnClickListener
{
  bqbo(bqbn parambqbn) {}
  
  public void onClick(View paramView)
  {
    if (bqbn.a(this.a))
    {
      bqbn.a(this.a, false);
      bqbn.a(this.a).setChecked(false);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bqbn.a(this.a, true);
      bqbn.a(this.a).setChecked(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqbo
 * JD-Core Version:    0.7.0.1
 */