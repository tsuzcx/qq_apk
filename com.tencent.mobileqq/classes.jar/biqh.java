import android.support.v4.view.ViewPager.OnPageChangeListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.FaceViewPager;
import java.util.Iterator;
import java.util.List;

public class biqh
  implements ViewPager.OnPageChangeListener
{
  public biqh(FaceViewPager paramFaceViewPager) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    Iterator localIterator = FaceViewPager.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((biqi)localIterator.next()).e(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    Iterator localIterator = FaceViewPager.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((biqi)localIterator.next()).a(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    Iterator localIterator = FaceViewPager.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((biqi)localIterator.next()).c(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biqh
 * JD-Core Version:    0.7.0.1
 */