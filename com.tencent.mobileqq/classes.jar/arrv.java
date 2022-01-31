import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment;

public class arrv
  implements DialogInterface.OnDismissListener
{
  public arrv(ListenTogetherOverlayFragment paramListenTogetherOverlayFragment, arss paramarss) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Arss.b(false);
    this.jdField_a_of_type_Arss.d = false;
    if (!ListenTogetherOverlayFragment.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherFragmentListenTogetherOverlayFragment).isFinishing()) {
      ListenTogetherOverlayFragment.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherFragmentListenTogetherOverlayFragment).finish();
    }
    if (this.jdField_a_of_type_Arss.e) {
      this.jdField_a_of_type_Arss.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arrv
 * JD-Core Version:    0.7.0.1
 */