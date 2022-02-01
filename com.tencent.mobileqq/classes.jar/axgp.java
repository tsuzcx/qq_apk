import com.tencent.mobileqq.multiaio.widget.MultiAIOViewPager;
import com.tencent.mobileqq.multicard.MultiCardFragment;
import com.tencent.mobileqq.multicard.MultiCardFragment.ReportRunnable;
import com.tencent.mobileqq.multicard.MultiCardPageIndicator;
import com.tencent.qphone.base.util.QLog;

public class axgp
  extends axfg
{
  public axgp(MultiCardFragment paramMultiCardFragment) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardFragment", 2, "onPageSelected() called with: position = [" + paramInt + "]");
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardFragment", 2, "ViewPager onPageScrollStateChanged() called with: state = [" + paramInt + "]");
    }
    switch (paramInt)
    {
    default: 
    case 0: 
    case 1: 
      do
      {
        do
        {
          return;
          MultiCardFragment.a(this.a);
          MultiCardFragment.a(this.a, true);
          if ((MultiCardFragment.a(this.a) != null) && (MultiCardFragment.a(this.a).a() > MultiCardFragment.a(this.a).a()))
          {
            MultiCardFragment.a(this.a).b(MultiCardFragment.a(this.a).a());
            MultiCardFragment.a(this.a).a();
          }
        } while (MultiCardFragment.a(this.a) == null);
        MultiCardFragment.a(this.a).setViewPagerBusy(false);
        return;
        MultiCardFragment.b(this.a, true);
        MultiCardFragment.a(this.a, false);
      } while (MultiCardFragment.a(this.a) == null);
      MultiCardFragment.a(this.a, MultiCardFragment.a(this.a).a());
      return;
    }
    MultiCardFragment.b(this.a, true);
    MultiCardFragment.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axgp
 * JD-Core Version:    0.7.0.1
 */