import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.mini.utils.MiniAppReportShareUtil;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;

class augg
  implements DialogInterface.OnClickListener
{
  augg(aufz paramaufz) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool1 = this.a.jdField_a_of_type_AndroidOsBundle.getBoolean("needShareCallBack");
    paramInt = this.a.jdField_a_of_type_AndroidOsBundle.getInt("miniAppShareFrom");
    boolean bool2 = this.a.jdField_a_of_type_AndroidOsBundle.getBoolean("miniAppNeedOnlyPreview", false);
    if (bool2) {
      QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_direct_share_suc", null, null);
    }
    do
    {
      for (;;)
      {
        aufz.a(this.a, paramInt);
        paramDialogInterface = this.a.jdField_a_of_type_AndroidOsBundle.getString("miniAppShareAppid");
        paramInt = this.a.jdField_a_of_type_AndroidOsBundle.getInt("miniAppShareAppType");
        int i = this.a.jdField_a_of_type_AndroidOsBundle.getInt("miniAppShareScene");
        int j = this.a.jdField_a_of_type_AndroidOsBundle.getInt("miniAppShareType");
        int k = this.a.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
        String str = this.a.jdField_a_of_type_AndroidOsBundle.getString("uin");
        MiniAppReportShareUtil.getInstance().reportShare(paramDialogInterface, paramInt, i, j, k, str);
        if (!bool2) {
          break;
        }
        return;
        if (bool1) {
          QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_suc", null, null);
        }
      }
      if (this.a.jdField_a_of_type_AndroidOsBundle.getBoolean("avgame_share_callback_key", false)) {
        aobd.a().a(this.a.jdField_a_of_type_AndroidAppActivity, true);
      }
      if (this.a.g()) {
        aufz.a(this.a);
      }
      while (aufz.a(this.a, paramDialogInterface))
      {
        if ((this.a.jdField_a_of_type_AndroidOsBundle != null) && (this.a.jdField_a_of_type_AndroidOsBundle.getBoolean("k_forward_show_direct_share_tips", false))) {
          bcst.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A4A2", "0X800A4A2", 0, 0, "0", "", "", "");
        }
        aufz.b(this.a);
        if (!"caller_aecamera".equals(this.a.f)) {
          break;
        }
        aufz.c(this.a);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ForwardOption.ForwardBaseOption", 2, "sendToSingleTarget return false");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     augg
 * JD-Core Version:    0.7.0.1
 */