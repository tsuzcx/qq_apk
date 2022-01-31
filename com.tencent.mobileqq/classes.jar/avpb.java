import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.tencent.mobileqq.nearby.widget.AvatarWallViewPager;
import com.tencent.mobileqq.nearby.widget.AvatarWallViewPager.RollViewPager;
import java.lang.reflect.Field;

public class avpb
  extends Scroller
{
  public avpb(AvatarWallViewPager paramAvatarWallViewPager, Context paramContext, Interpolator paramInterpolator)
  {
    super(paramContext, paramInterpolator);
  }
  
  public void a()
  {
    try
    {
      Field localField = AvatarWallViewPager.RollViewPager.class.getDeclaredField("mScroller");
      localField.setAccessible(true);
      localField.set(this.a.a, this);
      localField.setAccessible(false);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.a.d);
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.a.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avpb
 * JD-Core Version:    0.7.0.1
 */