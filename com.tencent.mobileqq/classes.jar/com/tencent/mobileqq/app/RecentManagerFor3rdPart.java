package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import mqq.manager.Manager;

public class RecentManagerFor3rdPart
  implements Manager
{
  private QQAppInterface a;
  
  public RecentManagerFor3rdPart(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      this.a = paramQQAppInterface;
      return;
    }
    throw new NullPointerException("RecentManagerFor3rdPart, app is null");
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2, long paramLong1, long paramLong2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    Object localObject = this.a;
    if ((localObject != null) && (((QQAppInterface)localObject).isAccLoginSuccess()))
    {
      localObject = this.a.getProxyManager().a();
      RecentUser localRecentUser = ((RecentUserProxy)localObject).a(paramString1, paramInt);
      localRecentUser.uin = paramString1;
      localRecentUser.setType(paramInt);
      localRecentUser.displayName = paramString2;
      localRecentUser.lastmsgtime = paramLong1;
      localRecentUser.lastmsgdrafttime = paramLong2;
      ((RecentUserProxy)localObject).b(localRecentUser);
    }
    return true;
  }
  
  public void onDestroy()
  {
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.RecentManagerFor3rdPart
 * JD-Core Version:    0.7.0.1
 */