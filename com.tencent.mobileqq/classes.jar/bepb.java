import android.app.Activity;
import android.os.Bundle;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class bepb
{
  private static bepb jdField_a_of_type_Bepb;
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  
  public static bepb a()
  {
    if (jdField_a_of_type_Bepb == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Bepb == null) {
        jdField_a_of_type_Bepb = new bepb();
      }
      return jdField_a_of_type_Bepb;
    }
  }
  
  public void a(String paramString, Bundle paramBundle, bepd parambepd)
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
                  besl.b("MiniAppCmdServlet", "sendCmd cmd=" + paramString);
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
                    besn.a().b(new bepc(this, parambepd, paramString));
                    return;
                  }
                  if (!"cmd_upload_ark_share_image".equals(paramString)) {
                    break;
                  }
                } while (paramBundle != null);
                besl.d("MiniAppCmdServlet", "onMiniAppCmd cmd = " + paramString + ", bundle is null");
                return;
                if (!"cmd_share_ark_async_message".equals(paramString)) {
                  break;
                }
              } while (paramBundle != null);
              besl.d("MiniAppCmdServlet", "onMiniAppCmd cmd = " + paramString + ", bundle is null");
              return;
              if ("cmd_dc_report_log_key_data".equals(paramString))
              {
                beyj.a(paramBundle);
                return;
              }
              if (!"cmd_rebind_engine_channel".equals(paramString)) {
                break;
              }
              if (paramBundle != null) {
                i = paramBundle.getInt("bundle_key_app_type", -1);
              }
              besl.b("MiniAppCmdServlet", "[MiniEng] CMD_RELOAD_ENGINE_CHANNEL appType:" + i);
            } while ((i != 0) && (i != 1));
            paramBundle = new Bundle();
            localObject = besz.a();
            if (i == 1) {}
            for (i = 2;; i = 3)
            {
              paramBundle.putParcelable("engineChannel", ((besz)localObject).a(i));
              if (parambepd == null) {
                break;
              }
              try
              {
                parambepd.a(true, paramBundle);
                return;
              }
              catch (RemoteException paramBundle)
              {
                besl.d("MiniAppCmdServlet", "cmd response exception. cmd=" + paramString, paramBundle);
                return;
              }
            }
            if (!"cmd_rebind_engine_channel_new".equals(paramString)) {
              break;
            }
            if (paramBundle != null) {
              i = paramBundle.getInt("bundle_key_app_type", -1);
            }
            besl.b("MiniAppCmdServlet", "[MiniEng] CMD_RELOAD_ENGINE_CHANNEL appType:" + i);
          } while ((i != 0) && (i != 1));
          paramBundle = new Bundle();
          localObject = besz.a();
          if (i == 1) {}
          for (i = j;; i = 3)
          {
            paramBundle.putParcelable("engineChannel", ((besz)localObject).a(i));
            if (parambepd == null) {
              break;
            }
            try
            {
              parambepd.a(true, paramBundle);
              return;
            }
            catch (RemoteException paramBundle)
            {
              besl.d("MiniAppCmdServlet", "cmd response exception. cmd=" + paramString, paramBundle);
              return;
            }
          }
          if (!"cmd_update_pull_down_entry_list".equals(paramString)) {
            break;
          }
        } while (paramBundle != null);
        besl.d("MiniAppCmdServlet", "onMiniAppCmd cmd = " + paramString + ", bundle is null");
        return;
        if ("launch_report2".equals(paramString))
        {
          if (paramBundle != null)
          {
            paramBundle.setClassLoader(bexz.class.getClassLoader());
            paramString = (MiniAppInfo)paramBundle.getParcelable("app_config");
            parambepd = paramBundle.getString("sub_action");
            localObject = paramBundle.getString("path");
            bexz.a(parambepd, paramBundle.getString("reserves"), (String)localObject, paramString);
            return;
          }
          besl.d("MiniAppCmdServlet", "onMiniAppCmd cmd = " + paramString + ", bundle is null");
          return;
        }
      } while (!"cmd_update_app_for_mini_game".equals(paramString));
      besl.a("MiniAppCmdServlet", "handleUpdateAppForMiniGame() called with: bundle = [" + paramBundle + "]");
    } while (paramBundle == null);
    paramString = (MiniAppInfo)paramBundle.getParcelable("key_app_info");
    if ((paramString != null) && (MiniAppEnv.g().getContext() != null) && ((MiniAppEnv.g().getContext() instanceof Activity)))
    {
      bepk.a().a().stopMiniApp(paramString);
      bepk.a().a().startMiniApp((Activity)MiniAppEnv.g().getContext(), paramString, null, null);
      return;
    }
    besl.d("MiniAppCmdServlet", "handleUpdateAppForMiniGame miniAppInfo = " + paramString + " activity = " + MiniAppEnv.g().getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bepb
 * JD-Core Version:    0.7.0.1
 */