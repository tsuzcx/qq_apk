import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class badj
  extends QIPCModule
{
  private static badj a;
  
  private badj()
  {
    super("TeamWorkModule");
  }
  
  public static badj a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new badj();
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TeamWorkModule", 2, "[onCall] action = " + paramString + ", params = " + paramBundle + ", callbackId=" + paramInt);
    }
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if (!QQAppInterface.class.isInstance(localObject)) {
      if (QLog.isColorLevel()) {
        QLog.e("TeamWorkModule", 2, "[onCall] get app failed.");
      }
    }
    do
    {
      String str1;
      String str2;
      do
      {
        return null;
        if (!"send_to_chat_msg".equals(paramString)) {
          break;
        }
        paramString = azqu.a(paramBundle);
        paramInt = paramBundle.getInt("uin_type");
        str1 = paramBundle.getString("to_uin");
        str2 = paramBundle.getString("docs_gray_tips_info_json");
        paramBundle = paramBundle.getString("detail_url");
      } while ((localObject == null) || (paramString == null));
      paramString.mExtraData = "aioPlusPanelTencentDoc";
      bdir.a((QQAppInterface)localObject, str1, paramInt, paramString, null, str2, paramBundle);
      return null;
    } while (!"action_download_export_file".equals(paramString));
    boolean bool = paramBundle.getBoolean("isSuccess");
    paramString = paramBundle.getString("docUrl");
    localObject = (baci)((QQAppInterface)localObject).a(142);
    if (bool)
    {
      ((baci)localObject).notifyUI(2, true, new Object[] { paramBundle.getString("url"), paramBundle.getString("fileName"), paramString, paramBundle.getString("cookie") });
      return null;
    }
    ((baci)localObject).notifyUI(1, true, new Object[] { alpo.a(2131715157), paramString });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     badj
 * JD-Core Version:    0.7.0.1
 */