import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager;

public class awtv
  implements awtb
{
  public static float a = 0.85F;
  private static float b = 1.0F;
  private static float c = 0.75F;
  private float d = 3.4028235E+38F;
  private float e = 3.4028235E+38F;
  
  public void a(@NonNull View paramView, float paramFloat)
  {
    paramView.getWidth();
    paramView.getHeight();
    Object localObject1 = (MultiAIOBaseViewPager)paramView.getParent();
    int i = ((MultiAIOBaseViewPager)localObject1).getMeasuredWidth() - ((MultiAIOBaseViewPager)localObject1).getPaddingLeft() - ((MultiAIOBaseViewPager)localObject1).getPaddingRight();
    float f1 = ((MultiAIOBaseViewPager)localObject1).getPaddingLeft() / i;
    float f2 = (((MultiAIOBaseViewPager)localObject1).getPaddingLeft() - i - ((MultiAIOBaseViewPager)localObject1).b()) / i;
    int j = ((MultiAIOBaseViewPager)localObject1).getPaddingLeft();
    float f3 = (((MultiAIOBaseViewPager)localObject1).b() + (j + i)) / i;
    if (paramFloat < f2)
    {
      paramFloat = this.d;
      f1 = this.e;
    }
    for (;;)
    {
      paramView.setScaleX(paramFloat);
      paramView.setScaleY(paramFloat);
      Object localObject2 = paramView.getTag(2131371428);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = paramView.findViewById(2131371428);
        paramView.setTag(2131371428, localObject1);
      }
      paramView = (View)localObject1;
      paramView.setAlpha(1.0F - f1);
      paramView.setBackgroundColor(-16777216);
      return;
      if (paramFloat <= f3)
      {
        f1 = Math.abs(paramFloat - f1);
        paramFloat = (float)(a + Math.cos(f1 * 1.570796326794897D) * (b - a));
        this.d = Math.min(paramFloat, this.d);
        f1 = (float)(c + Math.cos(f1 * 1.570796326794897D) * (1.0F - c));
        this.e = Math.min(f1, this.e);
      }
      else
      {
        paramFloat = this.d;
        f1 = this.e;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awtv
 * JD-Core Version:    0.7.0.1
 */