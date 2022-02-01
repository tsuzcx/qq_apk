import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;

final class bfmg
  implements DialogInterface.OnClickListener
{
  bfmg(QQAppInterface paramQQAppInterface, String paramString, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    TroopInfo localTroopInfo;
    if (paramDialogInterface != null)
    {
      localTroopInfo = paramDialogInterface.b(this.jdField_a_of_type_JavaLangString);
      if (localTroopInfo != null)
      {
        if (!localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          break label124;
        }
        paramDialogInterface = "0";
      }
    }
    for (;;)
    {
      paramDialogInterface = bfmf.jdField_a_of_type_JavaLangString.replace("$GCODE$", this.jdField_a_of_type_JavaLangString).replace("$UIN$", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).replace("$ROLE$", paramDialogInterface);
      MiniAppLauncher.startMiniApp(this.jdField_a_of_type_AndroidAppActivity, paramDialogInterface, 2016, bguq.a(localTroopInfo, this.jdField_a_of_type_JavaLangString), null);
      bdll.b(null, "dc00898", "", "", "0X800B223", "0X800B223", 0, 0, "", "", "", "");
      return;
      label124:
      if (localTroopInfo.isAdmin()) {
        paramDialogInterface = "1";
      } else {
        paramDialogInterface = "2";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfmg
 * JD-Core Version:    0.7.0.1
 */