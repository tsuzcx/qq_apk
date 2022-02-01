import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.widget.bounce.BounceViewPager;
import java.util.Iterator;
import java.util.List;

public class bhkk
  implements ViewPager.OnPageChangeListener
{
  private bhkk(BounceViewPager paramBounceViewPager) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 0) {
      BounceViewPager.a(this.a, 0.0F);
    }
    Iterator localIterator = BounceViewPager.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bhkl)localIterator.next()).b(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    this.a.a = paramInt1;
    BounceViewPager.a(this.a, paramFloat);
    this.a.a();
    Iterator localIterator = BounceViewPager.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bhkl)localIterator.next()).a(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    Iterator localIterator = BounceViewPager.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bhkl)localIterator.next()).a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhkk
 * JD-Core Version:    0.7.0.1
 */