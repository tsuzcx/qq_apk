import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bbgc
  implements View.OnClickListener
{
  bbgc(bbfs parambbfs) {}
  
  public void onClick(View paramView)
  {
    ViewPager localViewPager;
    if (bbfs.a(this.a).getCurrentItem() != 1)
    {
      localViewPager = bbfs.a(this.a);
      if (bbfs.a(this.a)) {
        break label85;
      }
    }
    label85:
    for (boolean bool = true;; bool = false)
    {
      localViewPager.setCurrentItem(1, bool);
      this.a.c();
      this.a.a(1);
      this.a.a(this.a.a.getResources().getString(2131708844));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbgc
 * JD-Core Version:    0.7.0.1
 */