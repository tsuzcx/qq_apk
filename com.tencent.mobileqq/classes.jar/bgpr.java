import android.app.Activity;
import android.os.Bundle;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.CmdProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.ILaunchManager;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.log.QMLog;

public class bgpr
{
  private static bgpr jdField_a_of_type_Bgpr;
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  
  public static bgpr a()
  {
    if (jdField_a_of_type_Bgpr == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Bgpr == null) {
        jdField_a_of_type_Bgpr = new bgpr();
      }
      return jdField_a_of_type_Bgpr;
    }
  }
  
  public void a(String paramString, Bundle paramBundle, MiniCmdCallback paramMiniCmdCallback)
  {
    int j = 2;
    int i = -1;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    QMLog.i("MiniAppCmdServlet", "sendCmd cmd=" + paramString);
    if ((paramBundle == null) || ("cmd_exit_qq".equals(paramString))) {
      Process.killProcess(Process.myPid());
    }
    for (;;)
    {
      Object localObject1 = (CmdProxy)ProxyManager.get(CmdProxy.class);
      if (localObject1 == null) {
        break;
      }
      ((CmdProxy)localObject1).handleMiniAppCmd(paramString, paramBundle, paramMiniCmdCallback);
      return;
      if ("cmd_update_baselib".equals(paramString))
      {
        if (paramBundle != null) {
          paramBundle.getString("version");
        }
        bgrl.a().b(new bgps(this, paramMiniCmdCallback, paramString));
      }
      else if ("cmd_upload_ark_share_image".equals(paramString))
      {
        if (paramBundle == null) {
          QMLog.e("MiniAppCmdServlet", "onMiniAppCmd cmd = " + paramString + ", bundle is null");
        }
      }
      else if ("cmd_share_ark_async_message".equals(paramString))
      {
        if (paramBundle == null) {
          QMLog.e("MiniAppCmdServlet", "onMiniAppCmd cmd = " + paramString + ", bundle is null");
        }
      }
      else if ("cmd_dc_report_log_key_data".equals(paramString))
      {
        bgxv.a(paramBundle);
      }
      else
      {
        Object localObject3;
        if ("cmd_rebind_engine_channel".equals(paramString))
        {
          if (paramBundle != null) {
            i = paramBundle.getInt("bundle_key_app_type", -1);
          }
          QMLog.i("MiniAppCmdServlet", "[MiniEng] CMD_RELOAD_ENGINE_CHANNEL appType:" + i);
          if ((i == 0) || (i == 1))
          {
            localObject1 = new Bundle();
            localObject3 = bgrx.a();
            if (i == 1) {}
            for (i = 2;; i = 3)
            {
              for (;;)
              {
                ((Bundle)localObject1).putParcelable("engineChannel", ((bgrx)localObject3).a(i));
                if (paramMiniCmdCallback == null) {
                  break;
                }
                try
                {
                  paramMiniCmdCallback.onCmdResult(true, (Bundle)localObject1);
                }
                catch (RemoteException localRemoteException1)
                {
                  QMLog.e("MiniAppCmdServlet", "cmd response exception. cmd=" + paramString, localRemoteException1);
                }
              }
              break;
            }
          }
        }
        else if ("cmd_rebind_engine_channel_new".equals(paramString))
        {
          if (paramBundle != null) {
            i = paramBundle.getInt("bundle_key_app_type", -1);
          }
          QMLog.i("MiniAppCmdServlet", "[MiniEng] CMD_RELOAD_ENGINE_CHANNEL appType:" + i);
          if ((i == 0) || (i == 1))
          {
            Bundle localBundle = new Bundle();
            localObject3 = bgrx.a();
            if (i == 1) {}
            for (i = j;; i = 3)
            {
              for (;;)
              {
                localBundle.putParcelable("engineChannel", ((bgrx)localObject3).a(i));
                if (paramMiniCmdCallback == null) {
                  break;
                }
                try
                {
                  paramMiniCmdCallback.onCmdResult(true, localBundle);
                }
                catch (RemoteException localRemoteException2)
                {
                  QMLog.e("MiniAppCmdServlet", "cmd response exception. cmd=" + paramString, localRemoteException2);
                }
              }
              break;
            }
          }
        }
        else if ("cmd_update_pull_down_entry_list".equals(paramString))
        {
          if (paramBundle == null) {
            QMLog.e("MiniAppCmdServlet", "onMiniAppCmd cmd = " + paramString + ", bundle is null");
          }
        }
        else
        {
          String str1;
          if ("launch_report".equals(paramString))
          {
            if (paramBundle != null) {
              try
              {
                paramBundle.setClassLoader(bgyg.class.getClassLoader());
                MiniAppInfo localMiniAppInfo1 = (MiniAppInfo)paramBundle.getParcelable("app_config");
                localObject3 = paramBundle.getString("sub_action");
                str1 = paramBundle.getString("path");
                String str2 = paramBundle.getString("reserves");
                String str3 = paramBundle.getString("reserves2");
                bgyg.a(localMiniAppInfo1, paramBundle.getString("app_type"), str1, paramBundle.getString("action_type"), (String)localObject3, str2, str3, null, null, null, null);
              }
              catch (Exception localException1) {}
            }
          }
          else if ("launch_report2".equals(paramString))
          {
            if (paramBundle != null)
            {
              paramBundle.setClassLoader(bgxl.class.getClassLoader());
              MiniAppInfo localMiniAppInfo2 = (MiniAppInfo)paramBundle.getParcelable("app_config");
              localObject3 = paramBundle.getString("sub_action");
              str1 = paramBundle.getString("path");
              bgxl.a((String)localObject3, paramBundle.getString("reserves"), str1, localMiniAppInfo2);
            }
            else
            {
              QMLog.e("MiniAppCmdServlet", "onMiniAppCmd cmd = " + paramString + ", bundle is null");
            }
          }
          else if ("record_duration".equals(paramString))
          {
            if (paramBundle != null) {
              try
              {
                paramBundle.setClassLoader(bgyg.class.getClassLoader());
                bgyg.a((MiniAppInfo)paramBundle.getParcelable("app_config"), paramBundle.getLong("add_duration_ms"));
              }
              catch (Exception localException2) {}
            }
          }
          else
          {
            Object localObject2;
            if ("cmd_update_app_for_mini_game".equals(paramString))
            {
              QMLog.d("MiniAppCmdServlet", "handleUpdateAppForMiniGame() called with: bundle = [" + paramBundle + "]");
              if (paramBundle == null) {
                break;
              }
              localObject2 = (MiniAppInfo)paramBundle.getParcelable("key_app_info");
              if ((localObject2 != null) && (AppLoaderFactory.g().getMiniAppEnv().getContext() != null) && ((AppLoaderFactory.g().getMiniAppEnv().getContext() instanceof Activity)))
              {
                AppLoaderFactory.g().getLaunchManager().stopMiniApp((MiniAppInfo)localObject2);
                AppLoaderFactory.g().getLaunchManager().startMiniApp((Activity)AppLoaderFactory.g().getMiniAppEnv().getContext(), (MiniAppInfo)localObject2, null, null);
                continue;
              }
              QMLog.e("MiniAppCmdServlet", "handleUpdateAppForMiniGame miniAppInfo = " + localObject2 + " activity = " + AppLoaderFactory.g().getMiniAppEnv().getContext());
              continue;
            }
            if (("cmd_on_preload_game_baselib".equals(paramString)) && (paramBundle != null))
            {
              localObject2 = paramBundle.getString("bundle_key_process_name", null);
              localObject3 = paramBundle.getString("bundle_key_preload_game_baselib_version", null);
              AppLoaderFactory.g().getLaunchManager().onPreloadBaseLib((String)localObject2, (String)localObject3);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgpr
 * JD-Core Version:    0.7.0.1
 */