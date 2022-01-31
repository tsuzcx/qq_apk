import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.qqmini.sdk.ui.MoreFragment;

public class bhmj
  implements Animation.AnimationListener
{
  public bhmj(MoreFragment paramMoreFragment, int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = MoreFragment.a(this.jdField_a_of_type_ComTencentQqminiSdkUiMoreFragment);
    if (paramAnimation != null)
    {
      paramAnimation.putExtra("miniAppID", MoreFragment.a(this.jdField_a_of_type_ComTencentQqminiSdkUiMoreFragment));
      paramAnimation.putExtra("more_item_id", this.jdField_a_of_type_Int);
      paramAnimation.putExtra("share_in_mini_process", this.jdField_a_of_type_Boolean);
      if (this.jdField_a_of_type_AndroidOsBundle != null) {
        paramAnimation.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      }
      if (this.jdField_a_of_type_ComTencentQqminiSdkUiMoreFragment.getActivity() != null)
      {
        this.jdField_a_of_type_ComTencentQqminiSdkUiMoreFragment.getActivity().setResult(-1, paramAnimation);
        this.jdField_a_of_type_ComTencentQqminiSdkUiMoreFragment.getActivity().finish();
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhmj
 * JD-Core Version:    0.7.0.1
 */