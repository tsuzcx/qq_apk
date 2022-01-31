import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class amnl
  extends QIPCModule
{
  private static amnl a;
  
  public amnl(String paramString)
  {
    super(paramString);
  }
  
  public static amnl a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new amnl("PublicAccountModule");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountModule", 2, new Object[] { "PublicAccountModule : " + paramString + ", " + paramBundle.toString(), ", " + paramInt });
    }
    String str;
    boolean bool;
    if ("ACTION_REPORT_PUBLIC_ACCOUNT_FOLLOW_INFO_IN_WEBVIEW".equalsIgnoreCase(paramString))
    {
      paramInt = paramBundle.getInt("BUNDLE_KEY_REPORT_INFO_SOURCE", -1);
      str = paramBundle.getString("BUNDLE_KEY_REPORT_INFO_PUIN", "");
      bool = paramBundle.getBoolean("BUNDLE_KEY_REPORT_INFO_IS_FOLLOW", false);
      if ((paramInt != -1) && (!TextUtils.isEmpty(str))) {
        break label161;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountModule", 2, new Object[] { "empty error: source=", Integer.valueOf(paramInt), " uin=", str });
      }
    }
    return null;
    label161:
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {}
    for (paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();; paramString = null)
    {
      if (paramString == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("PublicAccountModule", 2, "app is null!");
        return null;
      }
      amnm.a(paramString, bool, str, paramInt);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amnl
 * JD-Core Version:    0.7.0.1
 */