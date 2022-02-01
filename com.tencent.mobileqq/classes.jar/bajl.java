import android.graphics.PointF;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView;
import com.tencent.mobileqq.widget.RatioLayout.LayoutParams;

public class bajl
  implements babz
{
  public bajl(VasProfileTagView paramVasProfileTagView) {}
  
  public void a()
  {
    Object localObject1;
    if (VasProfileTagView.a(this.a) != null)
    {
      localObject1 = VasProfileTagView.a(this.a);
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if ((localObject2 != null) && (localObject2.getVisibility() != 8))
        {
          RatioLayout.LayoutParams localLayoutParams = (RatioLayout.LayoutParams)localObject2.getLayoutParams();
          if (localLayoutParams != null)
          {
            localLayoutParams.a = VasProfileTagView.a(this.a).x;
            localLayoutParams.b = VasProfileTagView.a(this.a).y;
            localObject2.setLayoutParams(localLayoutParams);
          }
        }
        i += 1;
      }
      this.a.f();
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      localObject1 = (FrameLayout)VasProfileTagView.c(this.a).findViewById(16908290);
      if (localObject1 != null)
      {
        VasProfileTagView.a(this.a, ((FrameLayout)localObject1).getBackground());
        if (!bicd.a(VasProfileTagView.a(this.a))) {
          ((FrameLayout)localObject1).setBackgroundDrawable(null);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bajl
 * JD-Core Version:    0.7.0.1
 */