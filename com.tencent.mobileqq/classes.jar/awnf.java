import android.os.Bundle;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ipc.ListenTogetherIPCModuleMainServer.1;
import com.tencent.mobileqq.listentogether.ipc.ListenTogetherIPCModuleMainServer.2;
import com.tencent.mobileqq.listentogether.ipc.ListenTogetherIPCModuleMainServer.3;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.music.QzoneMusicHelper;
import eipc.EIPCResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class awnf
  extends QIPCModule
{
  private awnf()
  {
    super("ListenTogetherIPCModuleMainServer");
  }
  
  public static awnf a()
  {
    return awng.a();
  }
  
  private EIPCResult a(String paramString, Bundle paramBundle, int paramInt)
  {
    if ((!"action_status_changed".equals(paramString)) || (paramBundle == null)) {}
    for (;;)
    {
      return null;
      paramBundle = paramBundle.getString("data");
      try
      {
        paramBundle = new JSONObject(paramBundle);
        if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
        {
          localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          if (QLog.isColorLevel()) {
            QLog.d("ListenTogetherIPCModuleMainServer", 2, "statusChanged action:" + paramString + " data=" + paramBundle + " app:" + localQQAppInterface);
          }
          if ((localQQAppInterface == null) || (paramBundle == null)) {
            continue;
          }
          ((ListenTogetherManager)localQQAppInterface.getManager(331)).a(paramBundle);
          paramString = new EIPCResult();
          paramString.code = 0;
          return paramString;
        }
      }
      catch (JSONException paramBundle)
      {
        for (;;)
        {
          QLog.i("ListenTogetherIPCModuleMainServer", 1, "statusChanged error:" + paramBundle.getMessage());
          paramBundle = null;
          continue;
          QQAppInterface localQQAppInterface = null;
        }
      }
    }
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    boolean bool = QIPCServerHelper.getInstance().isProcessRunning("com.tencent.mobileqq:tool");
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogetherIPCModuleMainServer", 2, "callWebClientStatusChanged data:" + paramJSONObject + "  isToolRunning:" + bool);
    }
    if (bool)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("data", paramJSONObject.toString());
      QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "ListenTogetherIPCModuleWebClient", "action_status_changed", localBundle, null);
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    boolean bool2 = false;
    int i = 0;
    boolean bool1 = false;
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogetherIPCModuleMainServer", 2, "onCall, params=" + paramBundle + ", action=" + paramString + ", callBackId=" + paramInt);
    }
    if (paramBundle == null) {
      QLog.d("ListenTogetherIPCModuleMainServer", 1, "onCall, param is null, action=" + paramString + ", callBackId=" + paramInt);
    }
    for (;;)
    {
      return null;
      if ("action_status_changed".equals(paramString)) {
        return a(paramString, paramBundle, paramInt);
      }
      if ("isOpener".equals(paramString))
      {
        paramString = new Bundle();
        paramString.putBoolean("result", behz.a().a());
        paramString = EIPCResult.createResult(0, paramString);
        if (paramInt > 0)
        {
          callbackResult(paramInt, paramString);
          return null;
        }
      }
      else if ("isShowAtmosphere".equals(paramString))
      {
        try
        {
          paramString = new JSONObject(paramBundle.getString("data")).optString("uin");
          paramBundle = new Bundle();
          if ((behz.a().a()) || (behz.a().a(paramString))) {
            break label609;
          }
          label220:
          paramBundle.putBoolean("result", bool1);
          paramString = EIPCResult.createResult(0, paramBundle);
          if (paramInt > 0)
          {
            callbackResult(paramInt, paramString);
            return null;
          }
        }
        catch (JSONException paramString)
        {
          QLog.e("ListenTogetherIPCModuleMainServer", 1, "METHOD_IS_SHOW_ATMOSPHERE: ", paramString);
          return null;
        }
      }
    }
    if ("setPlayerId".equals(paramString)) {
      try
      {
        paramInt = new JSONObject(paramBundle.getString("data")).optInt("id");
        beic.a().a(paramInt);
        return null;
      }
      catch (JSONException paramString)
      {
        QLog.e("ListenTogetherIPCModuleMainServer", 1, "METHOD_SET_PLAYERID: ", paramString);
        return null;
      }
    }
    if ("setThemeEnabled".equals(paramString)) {
      try
      {
        paramBundle = new JSONObject(paramBundle.getString("data"));
        paramString = paramBundle.optString("uin");
        paramInt = paramBundle.optInt("id");
        paramBundle = behz.a();
        bool1 = bool2;
        if (paramInt == 1) {
          bool1 = true;
        }
        paramBundle.a(paramString, bool1);
        return null;
      }
      catch (JSONException paramString)
      {
        QLog.e("ListenTogetherIPCModuleMainServer", 1, "METHOD_SET_THEME_ENABLED: ", paramString);
        return null;
      }
    }
    if ("showFloatView".equals(paramString)) {
      try
      {
        paramBundle = new JSONObject(paramBundle.getString("data"));
        paramString = paramBundle.optString("uin");
        paramBundle = paramBundle.optString("coverUrl");
        ThreadManagerV2.getUIHandlerV2().post(new ListenTogetherIPCModuleMainServer.1(this, paramString, paramBundle));
        return null;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
    }
    if ("pauseFloatView".equals(paramString))
    {
      ThreadManagerV2.getUIHandlerV2().post(new ListenTogetherIPCModuleMainServer.2(this));
      return null;
    }
    if ("changeMusicList".equals(paramString)) {}
    for (;;)
    {
      SongInfo localSongInfo;
      try
      {
        paramString = new JSONObject(paramBundle.getString("data"));
        int j = paramString.optInt("playType");
        int k = paramString.optInt("index");
        paramString = paramString.getJSONArray("songList");
        paramBundle = new SongInfo[paramString.length()];
        paramInt = i;
        if (paramInt < paramString.length())
        {
          localSongInfo = QzoneMusicHelper.convertSongInfo(paramString.getJSONObject(paramInt));
          if (localSongInfo.a != 0L) {
            break label615;
          }
          localSongInfo.a = paramInt;
          break label615;
        }
        QQPlayerService.a(paramBundle, j, k);
        return null;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      if (!"stopMusicBox".equals(paramString)) {
        break;
      }
      ThreadManagerV2.getUIHandlerV2().post(new ListenTogetherIPCModuleMainServer.3(this));
      return null;
      label609:
      bool1 = true;
      break label220;
      label615:
      paramBundle[paramInt] = localSongInfo;
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awnf
 * JD-Core Version:    0.7.0.1
 */