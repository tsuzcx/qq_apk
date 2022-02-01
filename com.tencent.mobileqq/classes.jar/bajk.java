import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView;
import com.tencent.mobileqq.widget.RatioLayout;

public class bajk
  implements ValueAnimator.AnimatorUpdateListener
{
  public bajk(VasProfileTagView paramVasProfileTagView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    Object localObject = VasProfileTagView.a(this.a).getLayoutParams();
    if (localObject != null)
    {
      ((ViewGroup.LayoutParams)localObject).height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
      VasProfileTagView.a(this.a).setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = (FrameLayout)VasProfileTagView.b(this.a).findViewById(16908290);
        if ((localObject != null) && (((FrameLayout)localObject).getChildCount() > 0))
        {
          localObject = ((FrameLayout)localObject).getChildAt(0);
          if (localObject != null)
          {
            localObject = ((View)localObject).getBackground();
            if ((localObject instanceof BitmapDrawable))
            {
              int j = (int)(255.0F * paramValueAnimator.getAnimatedFraction());
              int i = j;
              if (paramValueAnimator == VasProfileTagView.a(this.a)) {
                i = 255 - j;
              }
              ((Drawable)localObject).setAlpha(i);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bajk
 * JD-Core Version:    0.7.0.1
 */