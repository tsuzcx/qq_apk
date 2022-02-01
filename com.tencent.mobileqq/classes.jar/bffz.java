import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class bffz
  implements Animation.AnimationListener
{
  bffz(bffw parambffw, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (bffw.a(this.jdField_a_of_type_Bffw) != null)
    {
      bffw.a(this.jdField_a_of_type_Bffw).a.clearAnimation();
      bffw.a(this.jdField_a_of_type_Bffw).a.setVisibility(8);
    }
    bffw.a(this.jdField_a_of_type_Bffw, false);
    bffw.a(this.jdField_a_of_type_Bffw, null);
    bffw.a(this.jdField_a_of_type_Bffw, null);
    bffw.a(this.jdField_a_of_type_Bffw, -1);
    if ((!this.jdField_a_of_type_Boolean) && (!bffw.b(this.jdField_a_of_type_Bffw)))
    {
      ThreadManager.getUIHandler().post(bffw.a(this.jdField_a_of_type_Bffw));
      bffw.b(this.jdField_a_of_type_Bffw, true);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bffz
 * JD-Core Version:    0.7.0.1
 */