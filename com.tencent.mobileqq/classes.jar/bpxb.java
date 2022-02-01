import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.reflect.Field;

public class bpxb
  extends Scroller
{
  private int a = 750;
  
  public bpxb(Context paramContext)
  {
    super(paramContext);
  }
  
  public bpxb(Context paramContext, Interpolator paramInterpolator)
  {
    super(paramContext, paramInterpolator);
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(ViewPager paramViewPager)
  {
    try
    {
      Field localField = ViewPager.class.getDeclaredField("mScroller");
      localField.setAccessible(true);
      localField.set(paramViewPager, this);
      return;
    }
    catch (Exception paramViewPager)
    {
      paramViewPager.printStackTrace();
    }
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.a);
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpxb
 * JD-Core Version:    0.7.0.1
 */