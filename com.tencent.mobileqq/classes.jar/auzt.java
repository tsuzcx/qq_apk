import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.profile.view.BreatheEffectView;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.qphone.base.util.QLog;

public class auzt
  extends GestureDetector.SimpleOnGestureListener
{
  public auzt(ProfileTagView paramProfileTagView) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "onScroll invoked");
    }
    this.a.d = true;
    paramFloat1 = paramFloat2;
    if (paramMotionEvent1 != null)
    {
      paramFloat1 = paramFloat2;
      if (paramMotionEvent2 != null) {
        paramFloat1 = paramMotionEvent1.getY() - paramMotionEvent2.getY();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "onScroll distance = " + paramFloat1);
    }
    if (Math.abs(paramFloat1) > ProfileTagView.a(this.a))
    {
      if ((paramFloat1 > 0.0F) && (this.a.jdField_a_of_type_Boolean)) {
        if (this.a.a())
        {
          this.a.f();
          this.a.jdField_a_of_type_ComTencentMobileqqProfileViewBreatheEffectView.b(null);
        }
      }
      while ((paramFloat1 >= 0.0F) || (this.a.jdField_a_of_type_Boolean)) {
        return true;
      }
      this.a.a();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auzt
 * JD-Core Version:    0.7.0.1
 */