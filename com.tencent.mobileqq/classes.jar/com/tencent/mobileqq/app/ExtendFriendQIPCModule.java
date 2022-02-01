package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.network.IExpandHandler;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class ExtendFriendQIPCModule
  extends QIPCModule
{
  private static volatile ExtendFriendQIPCModule a;
  
  public ExtendFriendQIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static ExtendFriendQIPCModule a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new ExtendFriendQIPCModule("ExtendFriendQIPCModule");
        }
      }
      finally {}
    }
    return a;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof QQAppInterface)) {
      return null;
    }
    localObject = (QQAppInterface)localObject;
    boolean bool;
    if ("notifyCampusFriendCertificateResult".equals(paramString))
    {
      bool = paramBundle.getBoolean("key_result");
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("onCall ACTION_NOTIFY_CAMPUS_FRIEND_CERTIFICATE_RESULT ,result = ");
        paramString.append(bool);
        QLog.d("ExtendFriendQIPCModule", 2, paramString.toString());
      }
      paramString = (IExpandManager)((QQAppInterface)localObject).getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      if (paramString != null)
      {
        if (bool) {
          paramInt = 2;
        } else {
          paramInt = 3;
        }
        paramString.a(paramInt, 1);
        ((IExpandHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).notifyUI(20, true, new Object[] { Integer.valueOf(2) });
        return null;
      }
    }
    else if ("notifyUploadSutudentIDResult".equals(paramString))
    {
      bool = paramBundle.getBoolean("key_result");
      paramString = (IExpandManager)((QQAppInterface)localObject).getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      if (bool)
      {
        paramString.a(1, 2);
        ((IExpandHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).notifyUI(20, true, new Object[] { Integer.valueOf(2) });
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("onCall ACTION_NOTIFY_STUDENTID_UPLOAD_RESULT ,result = ");
        paramString.append(bool);
        QLog.d("ExtendFriendQIPCModule", 2, paramString.toString());
        return null;
      }
    }
    else if ("notifyUpdateSchoolInfo".equals(paramString))
    {
      paramString = paramBundle.getString("name", "");
      paramInt = paramBundle.getInt("category", 0);
      String str1 = paramBundle.getString("schoolid", "");
      int i = paramBundle.getInt("idx", 0);
      IExpandManager localIExpandManager = (IExpandManager)((QQAppInterface)localObject).getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      String str2 = localIExpandManager.j();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onCall ACTION_NOTIFY_SCHOOL_INFO_UPDATE ，schoolName = ");
        localStringBuilder.append(paramString);
        localStringBuilder.append("，oldSchoolName = ");
        localStringBuilder.append(str2);
        QLog.d("ExtendFriendQIPCModule", 2, localStringBuilder.toString());
      }
      if (!paramString.equals(str2)) {
        localIExpandManager.a(0, -1);
      }
      localIExpandManager.a(i, paramString, str1, paramInt);
      ((IExpandHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).notifyUI(22, true, paramBundle);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.ExtendFriendQIPCModule
 * JD-Core Version:    0.7.0.1
 */