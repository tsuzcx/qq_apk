import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import cooperation.thirdpay.ThirdPayGate;

public class anew
  implements DialogInterface.OnClickListener
{
  public anew(ThirdPayGate paramThirdPayGate, Bundle paramBundle, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("isactivityfinish")) {
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anew
 * JD-Core Version:    0.7.0.1
 */