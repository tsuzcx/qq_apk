import com.tencent.mobileqq.multiaio.MultiAIOFragment;
import com.tencent.mobileqq.multiaio.widget.MultiAIOViewPager;
import com.tencent.mobileqq.multiaio.widget.TabPageIndicator;
import com.tencent.qphone.base.util.QLog;

public class augh
  extends auhr
{
  public augh(MultiAIOFragment paramMultiAIOFragment) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, "onPageSelected() called with: position = [" + paramInt + "]");
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, "ViewPager onPageScrollStateChanged() called with: state = [" + paramInt + "]");
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      MultiAIOFragment.a(this.a, MultiAIOFragment.a(this.a).a());
      MultiAIOFragment.a(this.a).setViewPagerBusy(false);
      return;
    case 1: 
      MultiAIOFragment.b(this.a);
      return;
    }
    MultiAIOFragment.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     augh
 * JD-Core Version:    0.7.0.1
 */