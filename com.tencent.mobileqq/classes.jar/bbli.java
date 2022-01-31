import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class bbli
  implements Animation.AnimationListener
{
  bbli(bblf parambblf, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (bblf.a(this.jdField_a_of_type_Bblf) != null)
    {
      bblf.a(this.jdField_a_of_type_Bblf).a.clearAnimation();
      bblf.a(this.jdField_a_of_type_Bblf).a.setVisibility(8);
    }
    bblf.a(this.jdField_a_of_type_Bblf, false);
    bblf.a(this.jdField_a_of_type_Bblf, null);
    bblf.a(this.jdField_a_of_type_Bblf, null);
    bblf.a(this.jdField_a_of_type_Bblf, -1);
    if ((!this.jdField_a_of_type_Boolean) && (!bblf.b(this.jdField_a_of_type_Bblf)))
    {
      ThreadManager.getUIHandler().post(bblf.a(this.jdField_a_of_type_Bblf));
      bblf.b(this.jdField_a_of_type_Bblf, true);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbli
 * JD-Core Version:    0.7.0.1
 */