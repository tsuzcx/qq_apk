package com.tencent.mobileqq.activity.recent.msgbox.businesshandler;

import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountChatMsgData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;

public class PublicAccountMsgBoxHandler
  implements ITempMsgBoxBusinessHandler
{
  public String a(AppInterface paramAppInterface, String paramString)
  {
    IPublicAccountDataManager localIPublicAccountDataManager = (IPublicAccountDataManager)paramAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
    paramAppInterface = RecentItemPublicAccountChatMsgData.a((QQAppInterface)paramAppInterface, localIPublicAccountDataManager, paramString);
    if (paramAppInterface != null) {
      return paramAppInterface.name;
    }
    return "";
  }
  
  public void a(AppInterface paramAppInterface, int paramInt, String paramString) {}
  
  public void a(AppInterface paramAppInterface, Message paramMessage, int paramInt, MsgSummary paramMsgSummary) {}
  
  public void a(AppInterface paramAppInterface, Object paramObject) {}
  
  public boolean a(AppInterface paramAppInterface, int paramInt)
  {
    return false;
  }
  
  public boolean b(AppInterface paramAppInterface, String paramString)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.businesshandler.PublicAccountMsgBoxHandler
 * JD-Core Version:    0.7.0.1
 */