import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.debug.EnvSwitchActivity;
import com.tencent.mobileqq.emoticonview.CameraEmoticonInfo;
import com.tencent.mobileqq.qipc.QIPCModule;
import dov.com.qq.im.ae.SessionWrap;
import eipc.EIPCResult;

public class bmba
  extends QIPCModule
{
  public bmba()
  {
    super("AECameraGetInfoServer");
  }
  
  public static bmba a()
  {
    return bmbb.a;
  }
  
  private QQAppInterface a()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    return null;
  }
  
  private String a(@NonNull String paramString)
  {
    if (paramString.contains("14.18.180.90")) {
      return "IPv4";
    }
    if (paramString.contains("240e:e1:a900:50::18")) {
      return "IPv6";
    }
    return "Unknown";
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (a() == null) {
      return null;
    }
    Object localObject;
    if ("ACTION_GET_ENV_INFO".equals(paramString))
    {
      paramBundle = new Bundle();
      if (EnvSwitchActivity.isTestEnvironment())
      {
        localObject = EnvSwitchActivity.loadTestEnvironment()[0];
        paramString = "Unknown";
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramString = a((String)localObject);
        }
        paramBundle.putString("KEY_ENV_INFO", "Test Env: " + paramString);
      }
      for (;;)
      {
        paramString = EIPCResult.createSuccessResult(paramBundle);
        callbackResult(paramInt, paramString);
        return paramString;
        paramBundle.putString("KEY_ENV_INFO", "Prod Env");
      }
    }
    if ("ACTION_SEND_GIF".equals(paramString)) {
      if (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
        break label251;
      }
    }
    label251:
    for (paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();; paramString = null)
    {
      if (paramString == null) {
        return null;
      }
      localObject = new SessionWrap(paramBundle.getString("curFriendUin"), paramBundle.getString("curFriendNick"), paramBundle.getInt("curType"), paramBundle.getString("troopUin"));
      CameraEmoticonInfo localCameraEmoticonInfo = new CameraEmoticonInfo();
      localCameraEmoticonInfo.path = paramBundle.getString("ARG_GIF_PATH");
      localCameraEmoticonInfo.url = localCameraEmoticonInfo.path;
      localCameraEmoticonInfo.contextKey = paramBundle.getString("forward_summary_extra", "");
      localCameraEmoticonInfo.templateId = paramBundle.getString("widgetinfo", "");
      localCameraEmoticonInfo.send(paramString, BaseApplicationImpl.getContext(), null, ((SessionWrap)localObject).a());
      return null;
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmba
 * JD-Core Version:    0.7.0.1
 */