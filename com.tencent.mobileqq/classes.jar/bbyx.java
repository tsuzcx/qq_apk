import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bbyx
  implements View.OnClickListener
{
  bbyx(bbyl parambbyl) {}
  
  public void onClick(View paramView)
  {
    if (bbyl.a(this.a).getCurrentItem() != 1)
    {
      bbyl.a(this.a).setCurrentItem(1, bbyl.a(this.a));
      this.a.c();
      this.a.a(1);
      this.a.a(this.a.a.getResources().getString(2131708953));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbyx
 * JD-Core Version:    0.7.0.1
 */