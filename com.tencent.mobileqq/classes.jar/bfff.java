import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import cooperation.qlink.QlAndQQInterface.WorkState;
import java.util.ArrayList;

class bfff
  implements DialogInterface.OnClickListener
{
  bfff(bffc parambffc, ArrayList paramArrayList, Activity paramActivity, int paramInt, boolean paramBoolean) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Bffc.a("0X8004855", 1);
    this.jdField_a_of_type_Bffc.a(bffc.a(this.jdField_a_of_type_Bffc).mPeerUin, this.jdField_a_of_type_JavaUtilArrayList);
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("string_filepaths", this.jdField_a_of_type_JavaUtilArrayList);
    localBundle.putBoolean("STRING_CONTINUE_SEND_TO_", true);
    bffc.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, localBundle);
    paramDialogInterface.dismiss();
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bfff
 * JD-Core Version:    0.7.0.1
 */