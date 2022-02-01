import com.tencent.mobileqq.multiaio.widget.MultiAIOViewPager;
import com.tencent.mobileqq.multicard.MultiCardFragment;
import com.tencent.mobileqq.multicard.MultiCardPageIndicator;
import com.tencent.qphone.base.util.QLog;

public class axgs
  implements axfs
{
  public axgs(MultiCardFragment paramMultiCardFragment) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardFragment", 2, "onActionUpNotFling() called with: initialVelocity = [" + paramInt + "]");
    }
    if (MultiCardFragment.a(this.a) != null) {
      MultiCardFragment.a(this.a).setViewPagerBusy(true);
    }
    if (MultiCardFragment.a(this.a) != null)
    {
      MultiCardFragment.a(this.a).c(paramInt);
      if ((MultiCardFragment.a(this.a).c() == 0) && (MultiCardFragment.a(this.a) != null)) {
        MultiCardFragment.a(this.a).setViewPagerBusy(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axgs
 * JD-Core Version:    0.7.0.1
 */