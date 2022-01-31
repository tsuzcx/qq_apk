import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.qphone.base.util.QLog;

class biwi
  implements ViewPager.OnPageChangeListener
{
  biwi(biwh parambiwh) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    QLog.d("AEVideoStoryCaptureModePart", 1, "onPageScrollStateChanged");
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    QLog.d("AEVideoStoryCaptureModePart", 1, "onPageScrolled");
  }
  
  public void onPageSelected(int paramInt)
  {
    QLog.d("AEVideoStoryCaptureModePart", 1, "onPageSelected");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biwi
 * JD-Core Version:    0.7.0.1
 */