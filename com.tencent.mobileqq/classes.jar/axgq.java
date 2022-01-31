import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.mobileqq.widget.TabBarView;

public class axgq
  implements ViewPager.OnPageChangeListener
{
  public axgq(ReceiptMessageReadMemberListContainerFragment paramReceiptMessageReadMemberListContainerFragment) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    ReceiptMessageReadMemberListContainerFragment.a(this.a).setSelectedTab(paramInt, true);
    if (paramInt == 0)
    {
      ReceiptMessageReadMemberListContainerFragment.a(this.a).a(false);
      return;
    }
    ReceiptMessageReadMemberListContainerFragment.a(this.a).a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axgq
 * JD-Core Version:    0.7.0.1
 */