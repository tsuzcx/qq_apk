package com.tencent.biz.pubaccount.readinjoy.engine;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class KandianDailyManager$2
  implements ReadInJoyUserInfoModule.RefreshUserInfoCallBack
{
  KandianDailyManager$2(KandianDailyManager paramKandianDailyManager) {}
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2) {}
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.a();
    if (localQQAppInterface == null) {}
    QQMessageFacade localQQMessageFacade;
    MessageForStructing localMessageForStructing;
    String str1;
    String str2;
    do
    {
      do
      {
        do
        {
          return;
          localQQMessageFacade = localQQAppInterface.getMessageFacade();
          localMessageForStructing = (MessageForStructing)localQQMessageFacade.b(AppConstants.KANDIAN_DAILY_UIN, 1008);
        } while (localMessageForStructing == null);
        if (!localMessageForStructing.mIsParsed) {
          localMessageForStructing.parse();
        }
      } while (localMessageForStructing.structingMsg == null);
      str1 = localMessageForStructing.getExtInfoFromExtStr("puin");
      str2 = localMessageForStructing.structingMsg.mMsgBrief;
    } while ((!localMessageForStructing.isread) || (TextUtils.isEmpty(str2)) || (!str2.contains(ReadInJoyUserInfoModule.a())) || (!TextUtils.equals(str1, paramString)));
    localMessageForStructing.structingMsg.mMsgBrief = str2.replace(ReadInJoyUserInfoModule.a(), paramReadInJoyUserInfo.nick);
    localMessageForStructing.createMessageUniseq();
    localMessageForStructing.doPrewrite();
    localQQMessageFacade.a(localMessageForStructing.frienduin, localMessageForStructing.istroop, localMessageForStructing.uniseq, localMessageForStructing.msgData);
    paramReadInJoyUserInfo = localQQAppInterface.getHandler(Conversation.class);
    if (paramReadInJoyUserInfo != null) {
      paramReadInJoyUserInfo.sendEmptyMessage(1009);
    }
    QLog.d("KandianDailyManager", 2, "update msg bref, uin : " + paramString + ", msg : " + localMessageForStructing);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager.2
 * JD-Core Version:    0.7.0.1
 */