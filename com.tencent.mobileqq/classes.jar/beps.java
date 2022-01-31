import android.app.Activity;
import android.os.Bundle;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class beps
{
  private static beps jdField_a_of_type_Beps;
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  
  public static beps a()
  {
    if (jdField_a_of_type_Beps == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Beps == null) {
        jdField_a_of_type_Beps = new beps();
      }
      return jdField_a_of_type_Beps;
    }
  }
  
  public void a(String paramString, Bundle paramBundle, bepu parambepu)
  {
    int j = 2;
    int i = -1;
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        Object localObject;
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  betc.b("MiniAppCmdServlet", "sendCmd cmd=" + paramString);
                  if ((paramBundle == null) || ("cmd_exit_qq".equals(paramString)))
                  {
                    Process.killProcess(Process.myPid());
                    return;
                  }
                  if ("cmd_update_baselib".equals(paramString))
                  {
                    if (paramBundle != null) {
                      paramBundle.getString("version");
                    }
                    bete.a().b(new bept(this, parambepu, paramString));
                    return;
                  }
                  if (!"cmd_upload_ark_share_image".equals(paramString)) {
                    break;
                  }
                } while (paramBundle != null);
                betc.d("MiniAppCmdServlet", "onMiniAppCmd cmd = " + paramString + ", bundle is null");
                return;
                if (!"cmd_share_ark_async_message".equals(paramString)) {
                  break;
                }
              } while (paramBundle != null);
              betc.d("MiniAppCmdServlet", "onMiniAppCmd cmd = " + paramString + ", bundle is null");
              return;
              if ("cmd_dc_report_log_key_data".equals(paramString))
              {
                beza.a(paramBundle);
                return;
              }
              if (!"cmd_rebind_engine_channel".equals(paramString)) {
                break;
              }
              if (paramBundle != null) {
                i = paramBundle.getInt("bundle_key_app_type", -1);
              }
              betc.b("MiniAppCmdServlet", "[MiniEng] CMD_RELOAD_ENGINE_CHANNEL appType:" + i);
            } while ((i != 0) && (i != 1));
            paramBundle = new Bundle();
            localObject = betq.a();
            if (i == 1) {}
            for (i = 2;; i = 3)
            {
              paramBundle.putParcelable("engineChannel", ((betq)localObject).a(i));
              if (parambepu == null) {
                break;
              }
              try
              {
                parambepu.a(true, paramBundle);
                return;
              }
              catch (RemoteException paramBundle)
              {
                betc.d("MiniAppCmdServlet", "cmd response exception. cmd=" + paramString, paramBundle);
                return;
              }
            }
            if (!"cmd_rebind_engine_channel_new".equals(paramString)) {
              break;
            }
            if (paramBundle != null) {
              i = paramBundle.getInt("bundle_key_app_type", -1);
            }
            betc.b("MiniAppCmdServlet", "[MiniEng] CMD_RELOAD_ENGINE_CHANNEL appType:" + i);
          } while ((i != 0) && (i != 1));
          paramBundle = new Bundle();
          localObject = betq.a();
          if (i == 1) {}
          for (i = j;; i = 3)
          {
            paramBundle.putParcelable("engineChannel", ((betq)localObject).a(i));
            if (parambepu == null) {
              break;
            }
            try
            {
              parambepu.a(true, paramBundle);
              return;
            }
            catch (RemoteException paramBundle)
            {
              betc.d("MiniAppCmdServlet", "cmd response exception. cmd=" + paramString, paramBundle);
              return;
            }
          }
          if (!"cmd_update_pull_down_entry_list".equals(paramString)) {
            break;
          }
        } while (paramBundle != null);
        betc.d("MiniAppCmdServlet", "onMiniAppCmd cmd = " + paramString + ", bundle is null");
        return;
        if ("launch_report2".equals(paramString))
        {
          if (paramBundle != null)
          {
            paramBundle.setClassLoader(beyq.class.getClassLoader());
            paramString = (MiniAppInfo)paramBundle.getParcelable("app_config");
            parambepu = paramBundle.getString("sub_action");
            localObject = paramBundle.getString("path");
            beyq.a(parambepu, paramBundle.getString("reserves"), (String)localObject, paramString);
            return;
          }
          betc.d("MiniAppCmdServlet", "onMiniAppCmd cmd = " + paramString + ", bundle is null");
          return;
        }
      } while (!"cmd_update_app_for_mini_game".equals(paramString));
      betc.a("MiniAppCmdServlet", "handleUpdateAppForMiniGame() called with: bundle = [" + paramBundle + "]");
    } while (paramBundle == null);
    paramString = (MiniAppInfo)paramBundle.getParcelable("key_app_info");
    if ((paramString != null) && (MiniAppEnv.g().getContext() != null) && ((MiniAppEnv.g().getContext() instanceof Activity)))
    {
      beqb.a().a().stopMiniApp(paramString);
      beqb.a().a().startMiniApp((Activity)MiniAppEnv.g().getContext(), paramString, null, null);
      return;
    }
    betc.d("MiniAppCmdServlet", "handleUpdateAppForMiniGame miniAppInfo = " + paramString + " activity = " + MiniAppEnv.g().getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beps
 * JD-Core Version:    0.7.0.1
 */