package com.tencent.mobileqq.activity.recent.msgbox.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.friend.observer.IFriendObserver;
import com.tencent.mobileqq.msg.api.IConversationFacade;

class TempMsgBoxManagerImpl$1
  implements IFriendObserver
{
  TempMsgBoxManagerImpl$1(TempMsgBoxManagerImpl paramTempMsgBoxManagerImpl) {}
  
  protected void a(String paramString)
  {
    ((IConversationFacade)TempMsgBoxManagerImpl.access$000(this.a).getRuntimeService(IConversationFacade.class, "")).increaseUnread(String.valueOf(paramString), 0, 0);
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramInt == 62) && (paramBoolean) && ((paramObject instanceof String))) {
      a((String)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.api.impl.TempMsgBoxManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */