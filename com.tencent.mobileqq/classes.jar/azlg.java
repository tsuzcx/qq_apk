import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.troop.createNewTroop.AbsNewTroopBaseView;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCreateActivity;

public class azlg
  extends AnimatorListenerAdapter
{
  public azlg(NewTroopCreateActivity paramNewTroopCreateActivity) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView.a(this.a.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azlg
 * JD-Core Version:    0.7.0.1
 */