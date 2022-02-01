import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bbgb
  implements View.OnClickListener
{
  bbgb(bbfs parambbfs) {}
  
  public void onClick(View paramView)
  {
    ViewPager localViewPager;
    if (bbfs.a(this.a).getCurrentItem() != 0)
    {
      localViewPager = bbfs.a(this.a);
      if (bbfs.a(this.a)) {
        break label84;
      }
    }
    label84:
    for (boolean bool = true;; bool = false)
    {
      localViewPager.setCurrentItem(0, bool);
      this.a.d();
      this.a.a(0);
      this.a.a(this.a.a.getResources().getString(2131717137));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbgb
 * JD-Core Version:    0.7.0.1
 */