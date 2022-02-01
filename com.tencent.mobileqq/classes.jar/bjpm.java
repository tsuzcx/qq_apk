import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.model.AccountManage.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;

public class bjpm
{
  private static bjpm jdField_a_of_type_Bjpm;
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getApplication();
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
  private WtloginManager jdField_a_of_type_MqqManagerWtloginManager = (WtloginManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(1);
  
  public static bjpm a()
  {
    try
    {
      if (jdField_a_of_type_Bjpm == null) {
        jdField_a_of_type_Bjpm = new bjpm();
      }
      bjpm localbjpm = jdField_a_of_type_Bjpm;
      return localbjpm;
    }
    finally {}
  }
  
  private void a(String paramString, SSOAccountObserver paramSSOAccountObserver, int paramInt, Bundle paramBundle)
  {
    QLog.d("open_log", 1, "-->delegateGetTicketNoPasswd--refresh=" + paramInt);
    Bundle localBundle;
    TicketManager localTicketManager;
    if (paramBundle != null)
    {
      localBundle = new Bundle(paramBundle);
      localTicketManager = (TicketManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(2);
      Object localObject2 = localTicketManager.getSkey(paramString);
      if ((bjmq.a(paramString)) || (paramInt != 1)) {
        break label432;
      }
      Object localObject1 = null;
      paramBundle = null;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        QLog.d("open_log", 1, "ticketqq valid");
        localObject1 = localTicketManager.getSt(paramString, 16);
        paramBundle = localTicketManager.getStkey(paramString, 16);
      }
      Object localObject4;
      Object localObject3;
      if (localObject1 != null)
      {
        localObject4 = paramBundle;
        localObject3 = localObject1;
        if (paramBundle != null) {}
      }
      else
      {
        QLog.d("open_log", 1, "st == null || stKey == null appid = 16");
        String str = localTicketManager.getOpenSdkKey(paramString, 4096);
        localObject4 = paramBundle;
        localObject3 = localObject1;
        localObject2 = str;
        if (!TextUtils.isEmpty(str))
        {
          QLog.d("open_log", 1, "ticket opensdk valid");
          localObject3 = localTicketManager.getSt(paramString, 1600001540);
          localObject4 = localTicketManager.getStkey(paramString, 1600001540);
          localObject2 = str;
        }
      }
      if ((localObject3 == null) || (localObject4 == null)) {
        break label432;
      }
      QLog.d("open_log", 1, "delegateGetTicketNoPasswd fake SSOAccountObserver success.");
      paramBundle = new Bundle();
      paramBundle.putBoolean("fake_callback", true);
      paramBundle.putByteArray("st_temp", (byte[])localObject3);
      paramBundle.putByteArray("st_temp_key", (byte[])localObject4);
      localObject1 = new WeakReference(paramSSOAccountObserver);
      this.jdField_a_of_type_AndroidOsHandler.post(new AccountManage.1(this, (WeakReference)localObject1, paramString, (String)localObject2, paramBundle));
    }
    label432:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        if (TextUtils.isEmpty(localTicketManager.getSkey(paramString)))
        {
          QLog.d("open_log", 1, "delegateGetTicketNoPasswd appid=16 sKey empty");
          localBundle.putLong("dwSrcAppid", 1600001540L);
          localBundle.putLong("dwDstAppid", 1600001540L);
        }
        if ((3 == paramInt) && (bjhh.a(this.jdField_a_of_type_MqqAppAppRuntime, paramString)))
        {
          QLog.d("open_log", 1, "delegateGetTicketNoPasswd 110509 and use540Ticket");
          localBundle.putLong("dwSrcAppid", 1600001540L);
          localBundle.putLong("dwDstAppid", 1600001540L);
        }
        this.jdField_a_of_type_MqqAppAppRuntime.ssoGetTicketNoPasswd(paramString, 4096, new bjpn(this, paramSSOAccountObserver), localBundle);
      }
      return;
      localBundle = new Bundle();
      break;
    }
  }
  
  public void a(String paramString1, SSOAccountObserver paramSSOAccountObserver, String paramString2, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("connect_data", bjhh.a(paramString2));
    a(paramString1, paramSSOAccountObserver, paramInt, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjpm
 * JD-Core Version:    0.7.0.1
 */