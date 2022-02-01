import android.os.Build;
import android.os.Bundle;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.WtloginManagerImpl;
import mqq.manager.WtloginManager;
import oicq.wlogin_sdk.tools.util;

public class avpl
  extends QIPCModule
{
  private static volatile avpl a;
  
  public avpl(String paramString)
  {
    super(paramString);
  }
  
  public static avpl a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new avpl("DeviceProtectQIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  private EIPCResult a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("DeviceProtectQIPCModule", 1, "handleGetDeviceInfo error: QQAppInterface is null");
      return EIPCResult.createResult(-102, null);
    }
    Bundle localBundle = new Bundle();
    for (;;)
    {
      int i;
      try
      {
        Object localObject = (WtloginManagerImpl)paramQQAppInterface.getManager(1);
        String str4;
        String str3;
        String str1;
        if (localObject != null)
        {
          paramQQAppInterface = BaseApplication.getContext();
          str4 = util.buf_to_string(((WtloginManagerImpl)localObject).getGUID());
          str3 = UserAction.getQIMEI();
          i = AppSetting.a();
          str1 = Build.BRAND;
          localObject = Build.MODEL;
          if (HwNetworkUtil.getSystemNetwork(paramQQAppInterface) == 1)
          {
            paramQQAppInterface = HwNetworkUtil.getCurrentWifiBSSID(paramQQAppInterface);
            break label338;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("guid:").append(str4).append("qimei:").append(str3).append("subappid:").append(str5).append("platform:").append(str2).append("brand:").append(str1).append("model:").append((String)localObject).append("bssid:").append(paramQQAppInterface);
            QLog.d("DeviceProtectQIPCModule", 1, "handleGetDeviceInfo info: " + localStringBuilder);
            localBundle.putString("guid", str4);
            localBundle.putString("qimei", str3);
            localBundle.putString("subappid", str5);
            localBundle.putString("platform", str2);
            localBundle.putString("brand", str1);
            localBundle.putString("model", (String)localObject);
            localBundle.putString("bssid", paramQQAppInterface);
            return EIPCResult.createResult(0, localBundle);
          }
        }
        else
        {
          QLog.e("DeviceProtectQIPCModule", 1, "handleGetDeviceInfo error: wtLoginManager is null");
          paramQQAppInterface = "";
          localObject = "";
          str1 = "";
          str2 = "";
          str5 = "";
          str3 = "";
          str4 = "";
          continue;
        }
        paramQQAppInterface = "";
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("DeviceProtectQIPCModule", 1, "handleGetDeviceInfo error: " + paramQQAppInterface.getMessage());
        return EIPCResult.createResult(-102, null);
      }
      label338:
      String str2 = "Android";
      String str5 = String.valueOf(i);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("DeviceProtectQIPCModule", 1, "handleGetGuidInfo error: QQAppInterface is null");
      callbackResult(paramInt, EIPCResult.createResult(-102, null));
      return;
    }
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("guid", util.buf_to_string(((WtloginManager)paramQQAppInterface.getManager(1)).getGUID()));
      QLog.d("DeviceProtectQIPCModule", 1, "handleGetGuidInfo success");
      callbackResult(paramInt, EIPCResult.createResult(0, localBundle));
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("DeviceProtectQIPCModule", 1, "handleGetGuidInfo error: " + paramQQAppInterface.getMessage());
      callbackResult(paramInt, EIPCResult.createResult(-102, null));
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    paramBundle = BaseApplicationImpl.getApplication().getRuntime();
    if (!(paramBundle instanceof QQAppInterface)) {
      return null;
    }
    paramBundle = (QQAppInterface)paramBundle;
    if ("ACTION_GET_DEVICE_INFO".equals(paramString)) {
      return a(paramBundle);
    }
    if ("ACTION_GET_GUID_INFO".equals(paramString)) {
      a(paramBundle, paramInt);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avpl
 * JD-Core Version:    0.7.0.1
 */