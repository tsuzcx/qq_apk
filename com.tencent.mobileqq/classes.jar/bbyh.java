import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.manager.AccountManager;
import mqq.manager.WtloginManager;

public class bbyh
{
  private AppRuntime a;
  
  public bbyh(AppRuntime paramAppRuntime)
  {
    this.a = paramAppRuntime;
  }
  
  public void a(Intent paramIntent, String paramString, bbyk parambbyk)
  {
    if ((paramIntent == null) || (TextUtils.isEmpty(paramString))) {
      if (parambbyk != null) {
        parambbyk.a(paramIntent, false, paramString, null, null);
      }
    }
    for (;;)
    {
      return;
      if (QLog.isDevelopLevel()) {
        bbyl.a("LHLoginMng -- lockLH", paramIntent);
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
        paramIntent = new bbyj(paramIntent, paramString, parambbyk);
        ((WtloginManager)this.a.getManager(1)).RegGetSMSVerifyLoginAccountWithLH(((String)localObject1).getBytes(), ((String)localObject2).getBytes(), paramString, "8.3.0", paramIntent);
      }
      while (QLog.isColorLevel())
      {
        QLog.i("LHLoginMng", 2, String.format(Locale.getDefault(), "lockLH, lhUin: %s, isBindPhoneNum: %s", new Object[] { paramString, Boolean.valueOf(bool) }));
        return;
        paramIntent = new bbyi(paramIntent, paramString, parambbyk);
        parambbyk = (AccountManager)this.a.getManager(0);
        aumk.a().a(this.a, false);
        parambbyk.sendRegisterBySetPassWithLH((String)localObject3, (String)localObject2, (String)localObject1, paramString, false, "8.3.0", paramIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbyh
 * JD-Core Version:    0.7.0.1
 */