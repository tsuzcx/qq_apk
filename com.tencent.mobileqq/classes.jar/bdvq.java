import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.troop.utils.TroopUtils;

final class bdvq
  implements DialogInterface.OnClickListener
{
  bdvq(QQAppInterface paramQQAppInterface, String paramString, Activity paramActivity) {}
  
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
      paramDialogInterface = bdvp.jdField_a_of_type_JavaLangString.replace("$GCODE$", this.jdField_a_of_type_JavaLangString).replace("$UIN$", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).replace("$ROLE$", paramDialogInterface);
      MiniAppLauncher.startMiniApp(this.jdField_a_of_type_AndroidAppActivity, paramDialogInterface, 2016, TroopUtils.createEntryModel(localTroopInfo, this.jdField_a_of_type_JavaLangString), null);
      bcef.b(null, "dc00898", "", "", "0X800B223", "0X800B223", 0, 0, "", "", "", "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdvq
 * JD-Core Version:    0.7.0.1
 */