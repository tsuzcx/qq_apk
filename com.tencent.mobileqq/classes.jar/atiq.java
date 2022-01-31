import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment;

public class atiq
  implements DialogInterface.OnDismissListener
{
  public atiq(ListenTogetherOverlayFragment paramListenTogetherOverlayFragment, atjn paramatjn) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Atjn.b(false);
    this.jdField_a_of_type_Atjn.d = false;
    if (!ListenTogetherOverlayFragment.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherFragmentListenTogetherOverlayFragment).isFinishing()) {
      ListenTogetherOverlayFragment.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherFragmentListenTogetherOverlayFragment).finish();
    }
    if (this.jdField_a_of_type_Atjn.e) {
      this.jdField_a_of_type_Atjn.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atiq
 * JD-Core Version:    0.7.0.1
 */