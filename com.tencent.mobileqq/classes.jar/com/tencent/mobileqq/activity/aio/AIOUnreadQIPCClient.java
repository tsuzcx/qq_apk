package com.tencent.mobileqq.activity.aio;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AIOUnreadQIPCClient
  extends QIPCModule
{
  private List<AIOUnreadListener> a = new ArrayList();
  
  private AIOUnreadQIPCClient(String paramString)
  {
    super(paramString);
  }
  
  public static AIOUnreadQIPCClient a()
  {
    return AIOUnreadQIPCClient.AIOClientClass.a();
  }
  
  private void a(int paramInt1, String paramString, int paramInt2)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((AIOUnreadListener)localIterator.next()).a(paramInt1, paramString, paramInt2);
    }
  }
  
  public static void b()
  {
    try
    {
      QIPCClientHelper.getInstance().register(a());
      if (QLog.isColorLevel())
      {
        QLog.d("AIOUnreadQIPCClient", 2, "register AIOUnreadQIPCClient");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("AIOUnreadQIPCClient", 1, "register ipc module error.", localException);
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCall main server action=");
      localStringBuilder.append(paramString);
      QLog.d("AIOUnreadQIPCClient", 2, localStringBuilder.toString());
    }
    if (("action_sync_single_con_unread_count".equals(paramString)) && (paramBundle != null))
    {
      paramString = paramBundle.getString("param_proc_uin");
      paramInt = paramBundle.getInt("param_proc_uin_type");
      int i = paramBundle.getInt("param_proc_single_con_badge_count");
      a(paramInt, paramString, i);
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("AIOUnreadQIPCClient, uin = ");
        paramBundle.append(paramString);
        paramBundle.append("; type= ");
        paramBundle.append(paramInt);
        paramBundle.append("; num= ");
        paramBundle.append(i);
        QLog.d("AIOUnreadQIPCClient", 2, paramBundle.toString());
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOUnreadQIPCClient
 * JD-Core Version:    0.7.0.1
 */