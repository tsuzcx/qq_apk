import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.open.agent.TroopAbilityPreVerificationFragment;

public class bdea
  implements DialogInterface.OnClickListener
{
  public bdea(TroopAbilityPreVerificationFragment paramTroopAbilityPreVerificationFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.jdField_a_of_type_Bbgu == paramDialogInterface)
    {
      if (paramInt != 1) {
        break label99;
      }
      paramDialogInterface = new Intent(this.a.getActivity(), LoginActivity.class);
      paramDialogInterface.putExtra("key_params", this.a.jdField_a_of_type_AndroidOsBundle);
      paramDialogInterface.putExtra("is_change_account", true);
      paramDialogInterface.putExtra("fromThirdAppByOpenSDK", true);
      paramDialogInterface.addFlags(268435456);
      paramDialogInterface.addFlags(67108864);
      this.a.getActivity().startActivity(paramDialogInterface);
      this.a.getActivity().finish();
    }
    label99:
    while (paramInt != 0) {
      return;
    }
    this.a.getActivity().setResult(0);
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdea
 * JD-Core Version:    0.7.0.1
 */