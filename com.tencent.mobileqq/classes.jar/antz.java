import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class antz
  extends QIPCModule
{
  private static volatile antz a;
  
  public antz(String paramString)
  {
    super(paramString);
  }
  
  public static antz a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new antz("ExtendFriendQIPCModule");
      }
      return a;
    }
    finally {}
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
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendQIPCModule", 2, "onCall ACTION_NOTIFY_CAMPUS_FRIEND_CERTIFICATE_RESULT ,result = " + bool);
      }
      paramString = (aslo)((QQAppInterface)localObject).getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      if (paramString != null)
      {
        if (!bool) {
          break label133;
        }
        paramInt = 2;
        paramString.a(paramInt, 1);
        ((aslm)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).notifyUI(20, true, new Object[] { Integer.valueOf(2) });
      }
    }
    for (;;)
    {
      return null;
      label133:
      paramInt = 3;
      break;
      if ("notifyUploadSutudentIDResult".equals(paramString))
      {
        bool = paramBundle.getBoolean("key_result");
        paramString = (aslo)((QQAppInterface)localObject).getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
        if (bool)
        {
          paramString.a(1, 2);
          ((aslm)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).notifyUI(20, true, new Object[] { Integer.valueOf(2) });
        }
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendQIPCModule", 2, "onCall ACTION_NOTIFY_STUDENTID_UPLOAD_RESULT ,result = " + bool);
        }
      }
      else if ("notifyUpdateSchoolInfo".equals(paramString))
      {
        paramString = paramBundle.getString("name", "");
        paramInt = paramBundle.getInt("category", 0);
        String str1 = paramBundle.getString("schoolid", "");
        int i = paramBundle.getInt("idx", 0);
        aslo localaslo = (aslo)((QQAppInterface)localObject).getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
        String str2 = localaslo.g();
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendQIPCModule", 2, "onCall ACTION_NOTIFY_SCHOOL_INFO_UPDATE ，schoolName = " + paramString + "，oldSchoolName = " + str2);
        }
        if (!paramString.equals(str2)) {
          localaslo.a(0, -1);
        }
        localaslo.a(i, paramString, str1, paramInt);
        ((aslm)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).notifyUI(22, true, paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     antz
 * JD-Core Version:    0.7.0.1
 */