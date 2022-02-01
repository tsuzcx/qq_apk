import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment;

public class awmt
  implements DialogInterface.OnDismissListener
{
  public awmt(ListenTogetherOverlayFragment paramListenTogetherOverlayFragment, awnq paramawnq) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Awnq.b(false);
    this.jdField_a_of_type_Awnq.d = false;
    if (!ListenTogetherOverlayFragment.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherFragmentListenTogetherOverlayFragment).isFinishing()) {
      ListenTogetherOverlayFragment.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherFragmentListenTogetherOverlayFragment).finish();
    }
    if (this.jdField_a_of_type_Awnq.e) {
      this.jdField_a_of_type_Awnq.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awmt
 * JD-Core Version:    0.7.0.1
 */