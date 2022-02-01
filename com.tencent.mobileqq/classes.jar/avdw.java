import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.fragment.DeleteFaceFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class avdw
  extends ayxn
{
  private final FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity = this.jdField_a_of_type_ComTencentMobileqqFragmentDeleteFaceFragment.getActivity();
  
  public avdw(DeleteFaceFragment paramDeleteFaceFragment, String paramString) {}
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (DeleteFaceFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentDeleteFaceFragment))
    {
      QLog.e("DeleteFaceFragment", 1, "onFailedResponse, activity is null");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFragmentDeleteFaceFragment.b();
    QLog.e("DeleteFaceFragment", 1, new Object[] { "sendGetTmpKeyRequest error, ", paramString2 });
    QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramString2, 0).a();
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (DeleteFaceFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentDeleteFaceFragment))
    {
      QLog.e("DeleteFaceFragment", 1, "getTmpKeySuccess, activity is null");
      return;
    }
    DeleteFaceFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentDeleteFaceFragment, paramString2, this.jdField_a_of_type_JavaLangString, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avdw
 * JD-Core Version:    0.7.0.1
 */