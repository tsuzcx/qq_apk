import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;

public class bphp
  implements View.OnClickListener
{
  public bphp(HorizontalSelectColorLayout paramHorizontalSelectColorLayout) {}
  
  public void onClick(View paramView)
  {
    if (HorizontalSelectColorLayout.a(this.a) > System.currentTimeMillis()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.a != null) {
        this.a.a.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bphp
 * JD-Core Version:    0.7.0.1
 */