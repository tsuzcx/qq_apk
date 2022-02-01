import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.troop.activity.ExtendGridView;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import java.util.ArrayList;

public class bejy
  implements Animation.AnimationListener
{
  public bejy(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    boolean bool = false;
    paramAnimation = this.a;
    paramAnimation.jdField_q_of_type_Int -= 1;
    if (this.a.jdField_q_of_type_Int == 0)
    {
      this.a.jdField_q_of_type_Boolean = false;
      int i = 0;
      while (i < this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.getCount())
      {
        paramAnimation = this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.getChildAt(i);
        if (paramAnimation != null) {
          paramAnimation.clearAnimation();
        }
        i += 1;
      }
      this.a.c.clearAnimation();
      this.a.jdField_a_of_type_JavaUtilArrayList.remove(this.a.r);
      paramAnimation = this.a.jdField_a_of_type_Beji;
      if (this.a.jdField_a_of_type_JavaUtilArrayList.size() < this.a.s) {
        bool = true;
      }
      paramAnimation.a(bool, true);
      this.a.jdField_a_of_type_Beji.a(this.a.jdField_a_of_type_JavaUtilArrayList);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bejy
 * JD-Core Version:    0.7.0.1
 */