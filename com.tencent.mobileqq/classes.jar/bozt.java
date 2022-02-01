import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.view.PressDarkImageButton;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bozt
  implements View.OnClickListener
{
  bozt(bozs parambozs) {}
  
  public void onClick(View paramView)
  {
    if (bozs.a(this.a))
    {
      bozs.a(this.a, false);
      bozs.a(this.a).setChecked(false);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bozs.a(this.a, true);
      bozs.a(this.a).setChecked(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bozt
 * JD-Core Version:    0.7.0.1
 */