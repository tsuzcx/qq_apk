import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment;

public class arrw
  implements DialogInterface.OnCancelListener
{
  public arrw(ListenTogetherOverlayFragment paramListenTogetherOverlayFragment, arss paramarss) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Arss.b(false);
    if (!ListenTogetherOverlayFragment.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherFragmentListenTogetherOverlayFragment).isFinishing()) {
      ListenTogetherOverlayFragment.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherFragmentListenTogetherOverlayFragment).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arrw
 * JD-Core Version:    0.7.0.1
 */