import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class bnrk
  extends RemoteCommand
{
  private QQAppInterface a;
  
  public void a()
  {
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if ((localPluginCommunicationHandler != null) && (localPluginCommunicationHandler.containsCmd("com.tencent.qqreadinjoy.readinjoyremotecommand"))) {
      localPluginCommunicationHandler.unregister("com.tencent.qqreadinjoy.readinjoyremotecommand");
    }
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    boolean bool = true;
    int i = paramBundle.getInt("param_data_type", 0);
    paramOnInvokeFinishLinstener = new Bundle();
    switch (i)
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      do
      {
        do
        {
          Object localObject;
          do
          {
            SharedPreferences localSharedPreferences;
            do
            {
              do
              {
                return paramOnInvokeFinishLinstener;
                localObject = paramBundle.getString("param_sp_key");
                paramBundle = paramBundle.getString("param_sp_value_type");
                localSharedPreferences = bnrf.a(this.a, 1);
              } while (localSharedPreferences == null);
              try
              {
                if (paramBundle.equals("long"))
                {
                  paramOnInvokeFinishLinstener.putString("result_key", Long.toString(localSharedPreferences.getLong((String)localObject, 0L)));
                  return paramOnInvokeFinishLinstener;
                }
              }
              catch (ClassCastException paramBundle)
              {
                paramBundle.printStackTrace();
                return paramOnInvokeFinishLinstener;
              }
              if (paramBundle.equals("boolean"))
              {
                paramOnInvokeFinishLinstener.putString("result_key", Boolean.toString(localSharedPreferences.getBoolean((String)localObject, false)));
                return paramOnInvokeFinishLinstener;
              }
              if (paramBundle.equals("int"))
              {
                paramOnInvokeFinishLinstener.putString("result_key", Integer.toString(localSharedPreferences.getInt((String)localObject, 0)));
                return paramOnInvokeFinishLinstener;
              }
            } while (!paramBundle.equals("String"));
            paramOnInvokeFinishLinstener.putString("result_key", localSharedPreferences.getString((String)localObject, null));
            return paramOnInvokeFinishLinstener;
            paramBundle = paramBundle.getString("param_uin");
            bhlg.h(this.a, paramBundle);
            paramOnInvokeFinishLinstener.putString("result_key", bhlg.j(this.a, paramBundle));
            return paramOnInvokeFinishLinstener;
            paramBundle = paramBundle.getString("param_uin");
            paramOnInvokeFinishLinstener.putParcelable("result_key", this.a.a(paramBundle, true));
            return paramOnInvokeFinishLinstener;
            paramBundle = paramBundle.getString("param_uin");
            localObject = (anyw)this.a.getManager(51);
          } while ((localObject == null) || (TextUtils.isEmpty(paramBundle)));
          paramBundle = ((anyw)localObject).b(paramBundle);
        } while (paramBundle == null);
        paramOnInvokeFinishLinstener.putString("result_key", Short.toString(paramBundle.shGender));
        return paramOnInvokeFinishLinstener;
        paramBundle = paramBundle.getString("param_uin");
      } while (TextUtils.isEmpty(paramBundle));
      paramOnInvokeFinishLinstener.putString("result_key", Boolean.toString(ppo.a(paramBundle, null)));
      return paramOnInvokeFinishLinstener;
    case 6: 
      paramBundle = bnrf.a(this.a);
      if ((paramBundle != null) && (paramBundle.a == 0)) {}
      for (;;)
      {
        paramOnInvokeFinishLinstener.putString("result_key", Boolean.toString(bool));
        return paramOnInvokeFinishLinstener;
        bool = false;
      }
    case 7: 
      paramOnInvokeFinishLinstener.putString("result_key", ozs.d());
      return paramOnInvokeFinishLinstener;
    }
    paramBundle = paramBundle.getString("param_uin");
    new oco(this.a, paramBundle, this.a.getApp().getApplicationContext()).a();
    QLog.e("ReadInJoyRemoteCommand", 2, "handle remote unfollow public account request ! puin : " + paramBundle);
    paramOnInvokeFinishLinstener.putBoolean("result_key", true);
    return paramOnInvokeFinishLinstener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnrk
 * JD-Core Version:    0.7.0.1
 */