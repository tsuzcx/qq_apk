import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.qphone.base.util.QLog;

class bbyq
  implements ViewPager.OnPageChangeListener
{
  bbyq(bbyl parambbyl) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    QLog.d("HotWordRecommendPagerModel", 1, "onPageScrollStateChanged");
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    QLog.d("HotWordRecommendPagerModel", 1, "onPageScrolled");
  }
  
  public void onPageSelected(int paramInt)
  {
    QLog.d("HotWordRecommendPagerModel", 1, "onPageSelected");
    if (paramInt == 0) {
      this.a.d();
    }
    for (;;)
    {
      this.a.a(paramInt);
      return;
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbyq
 * JD-Core Version:    0.7.0.1
 */