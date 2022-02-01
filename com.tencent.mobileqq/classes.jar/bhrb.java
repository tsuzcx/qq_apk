import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.open.agent.BindGroupFragment;

public class bhrb
  implements DialogInterface.OnClickListener
{
  public bhrb(BindGroupFragment paramBindGroupFragment, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      BindGroupFragment.a(this.jdField_a_of_type_ComTencentOpenAgentBindGroupFragment, amtj.a(2131700265));
      ((anca)BindGroupFragment.a(this.jdField_a_of_type_ComTencentOpenAgentBindGroupFragment).getBusinessHandler(20)).a(Integer.valueOf(BindGroupFragment.a(this.jdField_a_of_type_ComTencentOpenAgentBindGroupFragment)).intValue(), Integer.valueOf(BindGroupFragment.b(this.jdField_a_of_type_ComTencentOpenAgentBindGroupFragment)).intValue(), Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), BindGroupFragment.c(this.jdField_a_of_type_ComTencentOpenAgentBindGroupFragment));
    }
    while (paramInt != 0) {
      return;
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhrb
 * JD-Core Version:    0.7.0.1
 */