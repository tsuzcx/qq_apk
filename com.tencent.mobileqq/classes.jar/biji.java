import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.manager.AccountManager;
import mqq.manager.WtloginManager;

public class biji
{
  private AppRuntime a;
  
  public biji(AppRuntime paramAppRuntime)
  {
    this.a = paramAppRuntime;
  }
  
  public void a(Intent paramIntent, String paramString, bijl parambijl)
  {
    if ((paramIntent == null) || (TextUtils.isEmpty(paramString))) {
      if (parambijl != null) {
        parambijl.a(paramIntent, false, paramString, null, null);
      }
    }
    for (;;)
    {
      return;
      if (QLog.isDevelopLevel()) {
        bijm.a("LHLoginMng -- lockLH", paramIntent);
      }
      Object localObject2 = paramIntent.getStringExtra("key_register_smscode");
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      Object localObject3 = paramIntent.getStringExtra("key_register_nick");
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      String str = paramIntent.getStringExtra("key_register_password");
      localObject3 = str;
      if (str == null) {
        localObject3 = "";
      }
      boolean bool = paramIntent.getBooleanExtra("key_register_chose_bind_phone", false);
      if (bool)
      {
        paramIntent = new bijk(paramIntent, paramString, parambijl);
        ((WtloginManager)this.a.getManager(1)).regGetSMSVerifyLoginAccountWithLH(((String)localObject1).getBytes(), ((String)localObject2).getBytes(), paramString, "8.4.5", paramIntent);
      }
      while (QLog.isColorLevel())
      {
        QLog.i("LHLoginMng", 2, String.format(Locale.getDefault(), "lockLH, lhUin: %s, isBindPhoneNum: %s", new Object[] { paramString, Boolean.valueOf(bool) }));
        return;
        paramIntent = new bijj(paramIntent, paramString, parambijl);
        parambijl = (AccountManager)this.a.getManager(0);
        azoz.a().a(this.a, false);
        parambijl.sendRegisterBySetPassWithLH((String)localObject3, (String)localObject2, (String)localObject1, paramString, false, "8.4.5", paramIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biji
 * JD-Core Version:    0.7.0.1
 */