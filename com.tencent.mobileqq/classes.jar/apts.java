import android.content.Context;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

final class apts
  implements aubp<EmoticonPackage>
{
  apts(Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, apnf paramapnf, SessionInfo paramSessionInfo) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    boolean bool;
    if ((paramEmoticonPackage != null) && ((2 != paramEmoticonPackage.status) || (!paramEmoticonPackage.valid))) {
      if (paramEmoticonPackage.jobType == 4)
      {
        bool = true;
        EmojiHomeUiPlugin.openEmojiDetailPage(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 8, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, false, bool);
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005C13", 0, 0, "", "", "", "");
      }
    }
    label194:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        if (!this.jdField_a_of_type_Apnf.c()) {
          break label237;
        }
        if (!this.jdField_a_of_type_Apnf.b(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, true, true)) {
          break label194;
        }
        if (this.jdField_a_of_type_Apnf.b())
        {
          aptm.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbFasong", "MbZidongBofang", 0, 0, "", "", "", "");
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("PicEmoticonInfo", 2, "not support h5magic ");
      return;
      ChatActivityUtils.a(this.jdField_a_of_type_AndroidContentContext, 2131690020, 0);
      paramEmoticonPackage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
    } while (paramEmoticonPackage == null);
    paramEmoticonPackage.obtainMessage(10).sendToTarget();
    paramEmoticonPackage.obtainMessage(21).sendToTarget();
    return;
    label237:
    ChatActivityUtils.a(this.jdField_a_of_type_AndroidContentContext, 2131690039);
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005C16", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apts
 * JD-Core Version:    0.7.0.1
 */