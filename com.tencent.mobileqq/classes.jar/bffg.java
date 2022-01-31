import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.qqmini.sdk.ui.MoreFragment;

public class bffg
  implements Animation.AnimationListener
{
  public bffg(MoreFragment paramMoreFragment, int paramInt, Bundle paramBundle) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = MoreFragment.a(this.jdField_a_of_type_ComTencentQqminiSdkUiMoreFragment);
    paramAnimation.putExtra("miniAppID", MoreFragment.a(this.jdField_a_of_type_ComTencentQqminiSdkUiMoreFragment));
    paramAnimation.putExtra("more_item_id", this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      paramAnimation.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    }
    this.jdField_a_of_type_ComTencentQqminiSdkUiMoreFragment.getActivity().setResult(-1, paramAnimation);
    this.jdField_a_of_type_ComTencentQqminiSdkUiMoreFragment.getActivity().finish();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bffg
 * JD-Core Version:    0.7.0.1
 */