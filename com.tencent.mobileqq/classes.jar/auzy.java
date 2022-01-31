import android.graphics.PointF;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.mobileqq.widget.RatioLayout.LayoutParams;

public class auzy
  implements auyz
{
  public auzy(ProfileTagView paramProfileTagView) {}
  
  public void a()
  {
    Object localObject1;
    if (this.a.jdField_b_of_type_AndroidGraphicsPointF != null)
    {
      localObject1 = this.a.jdField_a_of_type_ArrayOfAndroidViewView;
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
            localLayoutParams.a = this.a.jdField_b_of_type_AndroidGraphicsPointF.x;
            localLayoutParams.b = this.a.jdField_b_of_type_AndroidGraphicsPointF.y;
            localObject2.setLayoutParams(localLayoutParams);
          }
        }
        i += 1;
      }
      this.a.e();
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      localObject1 = (FrameLayout)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(16908290);
      if (localObject1 != null)
      {
        this.a.jdField_b_of_type_AndroidGraphicsDrawableDrawable = ((FrameLayout)localObject1).getBackground();
        if (!bbsl.a(this.a.jdField_b_of_type_AndroidGraphicsDrawableDrawable)) {
          ((FrameLayout)localObject1).setBackgroundDrawable(null);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auzy
 * JD-Core Version:    0.7.0.1
 */