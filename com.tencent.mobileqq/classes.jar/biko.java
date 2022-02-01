import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.open.agent.BindGroupFragment;

public class biko
  implements DialogInterface.OnClickListener
{
  public biko(BindGroupFragment paramBindGroupFragment, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      BindGroupFragment.a(this.jdField_a_of_type_ComTencentOpenAgentBindGroupFragment, anni.a(2131699923));
      ((anwd)BindGroupFragment.a(this.jdField_a_of_type_ComTencentOpenAgentBindGroupFragment).a(20)).a(Integer.valueOf(BindGroupFragment.a(this.jdField_a_of_type_ComTencentOpenAgentBindGroupFragment)).intValue(), Integer.valueOf(BindGroupFragment.b(this.jdField_a_of_type_ComTencentOpenAgentBindGroupFragment)).intValue(), Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), BindGroupFragment.c(this.jdField_a_of_type_ComTencentOpenAgentBindGroupFragment));
    }
    while (paramInt != 0) {
      return;
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biko
 * JD-Core Version:    0.7.0.1
 */