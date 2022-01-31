import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.agent.OpenAuthorityAccountView;
import com.tencent.open.agent.OpenAuthorityAccountView.DelAccountRunnable;

public class bfez
  implements DialogInterface.OnClickListener
{
  public bfez(OpenAuthorityAccountView paramOpenAuthorityAccountView, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1) {
      ThreadManager.executeOnSubThread(new OpenAuthorityAccountView.DelAccountRunnable(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView, this.jdField_a_of_type_JavaLangString));
    }
    while ((paramInt != 0) || (this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.a == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.a.dismiss();
    this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfez
 * JD-Core Version:    0.7.0.1
 */