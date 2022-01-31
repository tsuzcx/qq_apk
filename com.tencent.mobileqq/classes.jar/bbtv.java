import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.agent.AuthorityAccountView;
import com.tencent.open.agent.AuthorityAccountView.DelAccountRunnable;

public class bbtv
  implements DialogInterface.OnClickListener
{
  public bbtv(AuthorityAccountView paramAuthorityAccountView, String paramString) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbtv
 * JD-Core Version:    0.7.0.1
 */