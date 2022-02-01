package com.tencent.mobileqq.activity;

import acvv;
import aezm;
import aiej;
import bbko;
import bcef;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public final class ChatActivityFacade$8
  implements Runnable
{
  public ChatActivityFacade$8(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, JSONObject paramJSONObject, boolean paramBoolean) {}
  
  public void run()
  {
    String str;
    if (acvv.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false))
    {
      str = this.jdField_a_of_type_OrgJsonJSONObject.optString("fromuin");
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin.equals(str)) {
        break label246;
      }
      long l = this.jdField_a_of_type_OrgJsonJSONObject.optLong("time");
      QLog.i("ChatActivityFacade.QCircleFeeds", 1, "add new feeds publishTime:" + l);
      if (this.jdField_a_of_type_Boolean) {
        ((aiej)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).a(this.jdField_a_of_type_OrgJsonJSONObject.toString(), str);
      }
    }
    else
    {
      return;
    }
    aezm localaezm = (aezm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(282);
    BeancurdMsg localBeancurdMsg = new BeancurdMsg();
    localBeancurdMsg.buffer = this.jdField_a_of_type_OrgJsonJSONObject.toString();
    localBeancurdMsg.busiid = 12;
    localBeancurdMsg.frienduin = str;
    localBeancurdMsg.isNeedDelHistory = true;
    localBeancurdMsg.startTime = bbko.a();
    localBeancurdMsg.validTime = 604800L;
    if (QLog.isColorLevel()) {
      QLog.i("ChatActivityFacade.QCircleFeeds", 2, "addQCircleFeedMessageV2 receiveBeancurd:" + localBeancurdMsg);
    }
    localaezm.a(localBeancurdMsg);
    bcef.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "0X800B279", "0X800B279", 0, 0, "", "", "", "");
    return;
    label246:
    QLog.e("ChatActivityFacade.QCircleFeeds", 1, "当前获取到的feeds的发表人不匹配，忽略不插入");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.8
 * JD-Core Version:    0.7.0.1
 */