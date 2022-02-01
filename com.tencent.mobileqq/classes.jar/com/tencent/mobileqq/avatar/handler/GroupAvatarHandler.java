package com.tencent.mobileqq.avatar.handler;

import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.avatar.observer.GroupAvatarObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class GroupAvatarHandler
  extends BusinessHandler
{
  public GroupAvatarHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    notifyUI(1, paramBoolean1, Pair.create(Boolean.valueOf(paramBoolean2), paramString));
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return GroupAvatarObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.handler.GroupAvatarHandler
 * JD-Core Version:    0.7.0.1
 */