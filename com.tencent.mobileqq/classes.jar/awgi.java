import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment;

public class awgi
  implements DialogInterface.OnClickListener
{
  public awgi(ListenTogetherOverlayFragment paramListenTogetherOverlayFragment, ListenTogetherManager paramListenTogetherManager, awgx paramawgx) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.c();
    this.jdField_a_of_type_Awgx.b(false);
    if (!ListenTogetherOverlayFragment.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherFragmentListenTogetherOverlayFragment).isFinishing()) {
      ListenTogetherOverlayFragment.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherFragmentListenTogetherOverlayFragment).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awgi
 * JD-Core Version:    0.7.0.1
 */