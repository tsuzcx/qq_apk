import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bgkz
  implements View.OnClickListener
{
  bgkz(bgkx parambgkx) {}
  
  public void onClick(View paramView)
  {
    if (bgkx.a(this.a) != null)
    {
      bgkx.a(this.a).a(paramView);
      if (bgkx.a(this.a) != null) {
        bgkx.a(this.a).b(paramView, 0);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgkz
 * JD-Core Version:    0.7.0.1
 */