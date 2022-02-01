import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment;

public class awnb
  implements DialogInterface.OnClickListener
{
  public awnb(ListenTogetherOverlayFragment paramListenTogetherOverlayFragment, ListenTogetherManager paramListenTogetherManager, awnq paramawnq) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.c();
    this.jdField_a_of_type_Awnq.b(false);
    if (!ListenTogetherOverlayFragment.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherFragmentListenTogetherOverlayFragment).isFinishing()) {
      ListenTogetherOverlayFragment.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherFragmentListenTogetherOverlayFragment).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awnb
 * JD-Core Version:    0.7.0.1
 */