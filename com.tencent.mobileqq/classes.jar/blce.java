import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import com.tencent.image.ApngImage;
import dov.com.qq.im.ae.play.AEPlayShowTabView;

class blce
  extends ViewPager.SimpleOnPageChangeListener
{
  blce(blcc paramblcc) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 0)
    {
      ApngImage.resumeAll();
      return;
    }
    ApngImage.pauseAll();
  }
  
  public void onPageSelected(int paramInt)
  {
    blcc.a(this.a).a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blce
 * JD-Core Version:    0.7.0.1
 */