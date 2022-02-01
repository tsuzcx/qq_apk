package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class ChatActivityFacade$7
  implements Runnable
{
  ChatActivityFacade$7(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, JSONObject paramJSONObject, boolean paramBoolean, boolean[] paramArrayOfBoolean, long[] paramArrayOfLong) {}
  
  public void run()
  {
    long l1;
    if (ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false))
    {
      l1 = this.jdField_a_of_type_OrgJsonJSONObject.optLong("fromuin");
      if (!String.valueOf(l1).equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) {
        break label251;
      }
      long l2 = this.jdField_a_of_type_OrgJsonJSONObject.optLong("time");
      QLog.i("ChatActivityFacade.QZoneFeeds", 1, "add new feeds publishTime:" + l2);
      if (this.jdField_a_of_type_Boolean) {
        ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).a(this.jdField_a_of_type_OrgJsonJSONObject.toString(), String.valueOf(l1));
      }
    }
    else
    {
      return;
    }
    BeancurdManager localBeancurdManager = (BeancurdManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
    BeancurdMsg localBeancurdMsg = new BeancurdMsg();
    localBeancurdMsg.buffer = this.jdField_a_of_type_OrgJsonJSONObject.toString();
    localBeancurdMsg.busiid = 2;
    localBeancurdMsg.frienduin = String.valueOf(l1);
    localBeancurdMsg.isNeedDelHistory = true;
    localBeancurdMsg.ispush = this.jdField_a_of_type_ArrayOfBoolean[0];
    localBeancurdMsg.startTime = MessageCache.a();
    localBeancurdMsg.validTime = 604800L;
    localBeancurdMsg.token = this.jdField_a_of_type_ArrayOfLong[0];
    if (QLog.isColorLevel()) {
      QLog.i("ChatActivityFacade.QZoneFeeds", 2, "addQzoneFeedMessageV2l receiveBeancurd:" + String.valueOf(localBeancurdMsg));
    }
    localBeancurdManager.a(localBeancurdMsg);
    return;
    label251:
    QLog.e("ChatActivityFacade.QZoneFeeds", 1, "当前获取到的feeds的发表人不匹配，忽略不插入");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.7
 * JD-Core Version:    0.7.0.1
 */