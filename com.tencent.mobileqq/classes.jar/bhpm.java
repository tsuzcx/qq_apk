import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.agent.AuthorityAccountView;
import com.tencent.open.agent.AuthorityAccountView.DelAccountRunnable;

public class bhpm
  implements DialogInterface.OnClickListener
{
  public bhpm(AuthorityAccountView paramAuthorityAccountView, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1) {
      ThreadManager.executeOnSubThread(new AuthorityAccountView.DelAccountRunnable(this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView, this.jdField_a_of_type_JavaLangString));
    }
    while ((paramInt != 0) || (this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView.a == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView.a.dismiss();
    this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhpm
 * JD-Core Version:    0.7.0.1
 */