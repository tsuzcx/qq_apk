import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bbyw
  implements View.OnClickListener
{
  bbyw(bbyl parambbyl) {}
  
  public void onClick(View paramView)
  {
    if (bbyl.a(this.a).getCurrentItem() != 0)
    {
      bbyl.a(this.a).setCurrentItem(0, bbyl.a(this.a));
      this.a.d();
      this.a.a(0);
      this.a.a(this.a.a.getResources().getString(2131717254));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbyw
 * JD-Core Version:    0.7.0.1
 */