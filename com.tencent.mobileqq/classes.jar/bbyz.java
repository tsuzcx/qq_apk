import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.troop.homework.arithmetic.ui.DotStyleNavBar;

public class bbyz
  implements ViewPager.OnPageChangeListener
{
  public bbyz(DotStyleNavBar paramDotStyleNavBar) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (DotStyleNavBar.a(this.a) != null) {
      DotStyleNavBar.a(this.a).onPageScrollStateChanged(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (DotStyleNavBar.a(this.a) != null) {
      DotStyleNavBar.a(this.a).onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    this.a.setCurrent(paramInt);
    if (DotStyleNavBar.a(this.a) != null) {
      DotStyleNavBar.a(this.a).onPageSelected(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbyz
 * JD-Core Version:    0.7.0.1
 */