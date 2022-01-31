import com.tencent.mobileqq.multiaio.MultiAIOFragment;
import com.tencent.mobileqq.multiaio.widget.MultiAIOViewPager;
import com.tencent.mobileqq.multiaio.widget.TabPageIndicator;
import com.tencent.qphone.base.util.QLog;

public class aspj
  implements asrc
{
  public aspj(MultiAIOFragment paramMultiAIOFragment) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, "onActionUpNotFling() called with: initialVelocity = [" + paramInt + "]");
    }
    MultiAIOFragment.a(this.a).setViewPagerBusy(true);
    MultiAIOFragment.a(this.a).c(paramInt);
    if (MultiAIOFragment.a(this.a).c() == 0) {
      MultiAIOFragment.a(this.a).setViewPagerBusy(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aspj
 * JD-Core Version:    0.7.0.1
 */