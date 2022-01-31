import android.os.Bundle;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class bdkx
{
  private static bdkx jdField_a_of_type_Bdkx;
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  
  public static bdkx a()
  {
    if (jdField_a_of_type_Bdkx == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Bdkx == null) {
        jdField_a_of_type_Bdkx = new bdkx();
      }
      return jdField_a_of_type_Bdkx;
    }
  }
  
  public void a(String paramString, Bundle paramBundle, bdkz parambdkz)
  {
    int j = 2;
    int i = -1;
    if (TextUtils.isEmpty(paramString)) {}
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
              do
              {
                do
                {
                  return;
                  bdnw.b("MiniAppCmdServlet", "sendCmd cmd=" + paramString);
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
                    bdoa.a().a(new bdky(this, parambdkz, paramString));
                    return;
                  }
                  if (!"cmd_upload_ark_share_image".equals(paramString)) {
                    break;
                  }
                } while (paramBundle != null);
                bdnw.d("MiniAppCmdServlet", "onMiniAppCmd cmd = " + paramString + ", bundle is null");
                return;
                if (!"cmd_share_ark_async_message".equals(paramString)) {
                  break;
                }
              } while (paramBundle != null);
              bdnw.d("MiniAppCmdServlet", "onMiniAppCmd cmd = " + paramString + ", bundle is null");
              return;
            } while ("cmd_dc_report_log_key_data".equals(paramString));
            if (!"cmd_rebind_engine_channel".equals(paramString)) {
              break;
            }
            if (paramBundle != null) {
              i = paramBundle.getInt("bundle_key_app_type", -1);
            }
            bdnw.b("MiniAppCmdServlet", "[MiniEng] CMD_RELOAD_ENGINE_CHANNEL appType:" + i);
          } while ((i != 0) && (i != 1));
          paramBundle = new Bundle();
          localObject = bdom.a();
          if (i == 1) {}
          for (i = 2;; i = 3)
          {
            paramBundle.putParcelable("engineChannel", ((bdom)localObject).a(i));
            if (parambdkz == null) {
              break;
            }
            try
            {
              parambdkz.a(true, paramBundle);
              return;
            }
            catch (RemoteException paramBundle)
            {
              bdnw.d("MiniAppCmdServlet", "cmd response exception. cmd=" + paramString, paramBundle);
              return;
            }
          }
          if (!"cmd_rebind_engine_channel_new".equals(paramString)) {
            break;
          }
          if (paramBundle != null) {
            i = paramBundle.getInt("bundle_key_app_type", -1);
          }
          bdnw.b("MiniAppCmdServlet", "[MiniEng] CMD_RELOAD_ENGINE_CHANNEL appType:" + i);
        } while ((i != 0) && (i != 1));
        paramBundle = new Bundle();
        localObject = bdom.a();
        if (i == 1) {}
        for (i = j;; i = 3)
        {
          paramBundle.putParcelable("engineChannel", ((bdom)localObject).a(i));
          if (parambdkz == null) {
            break;
          }
          try
          {
            parambdkz.a(true, paramBundle);
            return;
          }
          catch (RemoteException paramBundle)
          {
            bdnw.d("MiniAppCmdServlet", "cmd response exception. cmd=" + paramString, paramBundle);
            return;
          }
        }
        if (!"cmd_update_pull_down_entry_list".equals(paramString)) {
          break;
        }
      } while (paramBundle != null);
      bdnw.d("MiniAppCmdServlet", "onMiniAppCmd cmd = " + paramString + ", bundle is null");
      return;
    } while (!"launch_report2".equals(paramString));
    if (paramBundle != null)
    {
      paramBundle.setClassLoader(bdsc.class.getClassLoader());
      paramString = (MiniAppInfo)paramBundle.getParcelable("app_config");
      parambdkz = paramBundle.getString("sub_action");
      localObject = paramBundle.getString("path");
      bdsc.a(parambdkz, paramBundle.getString("reserves"), (String)localObject, paramString);
      return;
    }
    bdnw.d("MiniAppCmdServlet", "onMiniAppCmd cmd = " + paramString + ", bundle is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdkx
 * JD-Core Version:    0.7.0.1
 */