import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Handler;
import com.tencent.mobileqq.activity.specialcare.QQSpecialFriendSettingActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;

class amjk
  implements DialogInterface.OnDismissListener
{
  amjk(amjj paramamjj, aovn paramaovn) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "finish all settings when dialog dismiss");
    }
    if (bhnv.g(this.jdField_a_of_type_Amjj.a))
    {
      boolean bool1 = QQSpecialFriendSettingActivity.a(this.jdField_a_of_type_Amjj.a).a();
      boolean bool2 = QQSpecialFriendSettingActivity.b(this.jdField_a_of_type_Amjj.a).a();
      paramDialogInterface = QQSpecialFriendSettingActivity.a(this.jdField_a_of_type_Amjj.a);
      String str = QQSpecialFriendSettingActivity.a(this.jdField_a_of_type_Amjj.a);
      int i = QQSpecialFriendSettingActivity.a(this.jdField_a_of_type_Amjj.a);
      paramDialogInterface.a(str, new int[] { 2, 3 }, new boolean[] { bool1, bool2 }, new String[] { String.valueOf(i), null });
      paramDialogInterface = this.jdField_a_of_type_Amjj.a.a.obtainMessage(8193);
      paramDialogInterface.obj = this.jdField_a_of_type_Amjj.a.getString(2131698421);
      this.jdField_a_of_type_Amjj.a.a.sendMessage(paramDialogInterface);
      if ((bool1) && (bool2))
      {
        paramDialogInterface = "0";
        bdll.b(null, "CliOper", "", "", "0X80050E2", "0X80050E2", 0, 0, paramDialogInterface, "", "", "");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Aovn.a();
      return;
      paramDialogInterface = "1";
      break;
      paramDialogInterface = this.jdField_a_of_type_Amjj.a.a.obtainMessage(8195);
      paramDialogInterface.arg1 = 0;
      paramDialogInterface.arg2 = 2131691989;
      this.jdField_a_of_type_Amjj.a.a.sendMessage(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amjk
 * JD-Core Version:    0.7.0.1
 */