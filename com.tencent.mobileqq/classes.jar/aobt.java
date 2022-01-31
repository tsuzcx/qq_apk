import android.content.Context;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

final class aobt
  implements askq<EmoticonPackage>
{
  aobt(Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, anvx paramanvx, SessionInfo paramSessionInfo, EmojiStickerManager.StickerInfo paramStickerInfo) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    boolean bool;
    if ((paramEmoticonPackage != null) && ((2 != paramEmoticonPackage.status) || (!paramEmoticonPackage.valid))) {
      if (paramEmoticonPackage.jobType == 4)
      {
        bool = true;
        EmojiHomeUiPlugin.openEmojiDetailPage(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 8, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, false, bool);
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005C13", 0, 0, "", "", "", "");
      }
    }
    do
    {
      return;
      bool = false;
      break;
      if (!this.jdField_a_of_type_Anvx.c()) {
        break label483;
      }
      if (this.jdField_a_of_type_Anvx.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, Boolean.valueOf(false))) {
        break label170;
      }
      ChatActivityUtils.a(this.jdField_a_of_type_AndroidContentContext, 2131689973, 0);
      paramEmoticonPackage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
    } while (paramEmoticonPackage == null);
    paramEmoticonPackage.obtainMessage(10).sendToTarget();
    paramEmoticonPackage.obtainMessage(21).sendToTarget();
    return;
    label170:
    Object localObject = asdj.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon, 0);
    if ((localObject != null) && (((ascr)localObject).a))
    {
      if (asea.a())
      {
        ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon, 0, null, false);
        ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().a().a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.magicValue = "value=1";
    }
    do
    {
      aobp.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon, this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerInfo);
      return;
      int j = ascl.a(asdj.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon, 0));
      int i = 0;
      if (paramEmoticonPackage != null) {
        i = paramEmoticonPackage.rscType;
      }
      paramEmoticonPackage = "rscType?" + i + ";value=" + j;
      this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.magicValue = paramEmoticonPackage;
      if (QLog.isColorLevel()) {
        QLog.d("PicEmoticonInfo", 2, "before play,magicvalue:" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.magicValue);
      }
      if ((localObject != null) && (!((ascr)localObject).c))
      {
        aanz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X800579D", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, "", "", "");
        return;
      }
      localObject = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
    } while (localObject == null);
    ((ChatFragment)localObject).a().a().a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon, new aobu(this, paramEmoticonPackage));
    return;
    label483:
    ChatActivityUtils.a(this.jdField_a_of_type_AndroidContentContext, 2131689992);
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005C16", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aobt
 * JD-Core Version:    0.7.0.1
 */