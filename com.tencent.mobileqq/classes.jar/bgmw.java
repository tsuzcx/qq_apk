import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import cooperation.qlink.QlAndQQInterface.WorkState;
import java.util.ArrayList;

class bgmw
  implements DialogInterface.OnClickListener
{
  bgmw(bgmt parambgmt, ArrayList paramArrayList, Activity paramActivity, int paramInt, boolean paramBoolean) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Bgmt.a("0X8004855", 1);
    this.jdField_a_of_type_Bgmt.a(bgmt.a(this.jdField_a_of_type_Bgmt).mPeerUin, this.jdField_a_of_type_JavaUtilArrayList);
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("string_filepaths", this.jdField_a_of_type_JavaUtilArrayList);
    localBundle.putBoolean("STRING_CONTINUE_SEND_TO_", true);
    bgmt.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, localBundle);
    paramDialogInterface.dismiss();
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bgmw
 * JD-Core Version:    0.7.0.1
 */