import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class bfpm
  implements Animation.AnimationListener
{
  bfpm(bfpj parambfpj, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (bfpj.a(this.jdField_a_of_type_Bfpj) != null)
    {
      bfpj.a(this.jdField_a_of_type_Bfpj).a.clearAnimation();
      bfpj.a(this.jdField_a_of_type_Bfpj).a.setVisibility(8);
    }
    bfpj.a(this.jdField_a_of_type_Bfpj, false);
    bfpj.a(this.jdField_a_of_type_Bfpj, null);
    bfpj.a(this.jdField_a_of_type_Bfpj, null);
    bfpj.a(this.jdField_a_of_type_Bfpj, -1);
    if ((!this.jdField_a_of_type_Boolean) && (!bfpj.b(this.jdField_a_of_type_Bfpj)))
    {
      ThreadManager.getUIHandler().post(bfpj.a(this.jdField_a_of_type_Bfpj));
      bfpj.b(this.jdField_a_of_type_Bfpj, true);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfpm
 * JD-Core Version:    0.7.0.1
 */