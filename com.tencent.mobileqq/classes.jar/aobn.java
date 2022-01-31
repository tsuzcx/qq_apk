import android.support.v4.view.ViewPager.OnPageChangeListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.FaceViewPager;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.FaceViewPager.PageChangedObserver;
import java.util.Iterator;
import java.util.List;

public class aobn
  implements ViewPager.OnPageChangeListener
{
  public aobn(FaceViewPager paramFaceViewPager) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    Iterator localIterator = FaceViewPager.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((FaceViewPager.PageChangedObserver)localIterator.next()).c(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aobn
 * JD-Core Version:    0.7.0.1
 */