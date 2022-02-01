import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment;

public class awga
  implements DialogInterface.OnDismissListener
{
  public awga(ListenTogetherOverlayFragment paramListenTogetherOverlayFragment, awgx paramawgx) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Awgx.b(false);
    this.jdField_a_of_type_Awgx.d = false;
    if (!ListenTogetherOverlayFragment.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherFragmentListenTogetherOverlayFragment).isFinishing()) {
      ListenTogetherOverlayFragment.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherFragmentListenTogetherOverlayFragment).finish();
    }
    if (this.jdField_a_of_type_Awgx.e) {
      this.jdField_a_of_type_Awgx.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awga
 * JD-Core Version:    0.7.0.1
 */