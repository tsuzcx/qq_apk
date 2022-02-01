import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.av.share.ShareChat;
import com.tencent.mobileqq.mini.utils.MiniAppReportShareUtil;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;

class auqc
  implements DialogInterface.OnClickListener
{
  auqc(aupt paramaupt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool1 = this.a.jdField_a_of_type_AndroidOsBundle.getBoolean("needShareCallBack");
    paramInt = this.a.jdField_a_of_type_AndroidOsBundle.getInt("miniAppShareFrom");
    boolean bool2 = this.a.jdField_a_of_type_AndroidOsBundle.getBoolean("miniAppNeedOnlyPreview", false);
    if (bool2) {
      QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_direct_share_suc", null, null);
    }
    label185:
    do
    {
      do
      {
        break label185;
        break label185;
        int k;
        String str;
        for (;;)
        {
          aupt.a(this.a, paramInt);
          paramDialogInterface = this.a.jdField_a_of_type_AndroidOsBundle.getString("miniAppShareAppid");
          paramInt = this.a.jdField_a_of_type_AndroidOsBundle.getInt("miniAppShareAppType");
          int i = this.a.jdField_a_of_type_AndroidOsBundle.getInt("miniAppShareScene");
          int j = this.a.jdField_a_of_type_AndroidOsBundle.getInt("miniAppShareType");
          k = this.a.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
          str = this.a.jdField_a_of_type_AndroidOsBundle.getString("uin");
          MiniAppReportShareUtil.getInstance().reportShare(paramDialogInterface, paramInt, i, j, k, str);
          if (!bool2) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardBaseOption", 2, "deal OnClickListener return by needOnlyPreview");
          }
          return;
          if (bool1) {
            QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_suc", null, null);
          }
        }
        if (this.a.jdField_a_of_type_AndroidOsBundle.getBoolean("avgame_share_callback_key", false)) {
          aojq.a().a(this.a.jdField_a_of_type_AndroidAppActivity, true);
        }
        if ((!"com.tencent.qqavchat".equalsIgnoreCase(this.a.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_name"))) || (this.a.i()) || (!ShareChat.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_meta"), str, k))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ForwardOption.ForwardBaseOption", 2, "deal OnClickListener return by ark message");
      return;
      if (this.a.i())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardBaseOption", 2, "deal OnClickListener doing isMultiTarget2Send");
        }
        if (!this.a.j()) {
          aupt.a(this.a);
        }
      }
      while (aupt.a(this.a, paramDialogInterface)) {
        for (;;)
        {
          if ((this.a.jdField_a_of_type_AndroidOsBundle != null) && (this.a.jdField_a_of_type_AndroidOsBundle.getBoolean("k_forward_show_direct_share_tips", false))) {
            bdla.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A4A2", "0X800A4A2", 0, 0, "0", "", "", "");
          }
          aupt.b(this.a);
          if (!"caller_aecamera".equals(this.a.f)) {
            break;
          }
          aupt.c(this.a);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardBaseOption", 2, "deal OnClickListener doing nothing from isMultiTarget2Send");
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("ForwardOption.ForwardBaseOption", 2, "sendToSingleTarget return false");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     auqc
 * JD-Core Version:    0.7.0.1
 */