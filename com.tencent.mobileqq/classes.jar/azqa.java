import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.utils.preference.PreferenceManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class azqa
{
  public static boolean a = false;
  public static boolean b;
  public static boolean c;
  private static boolean d;
  
  public static void a()
  {
    if (Build.VERSION.SDK_INT > 28) {}
    for (;;)
    {
      return;
      if (!c)
      {
        if (!PreferenceManager.getDefaultGlobalPreference(BaseApplicationImpl.getContext()).getBoolean("saveIDA", false)) {
          d();
        }
        c = true;
      }
      if (b) {
        continue;
      }
      Object localObject = aeow.a;
      if ((localObject == null) || (((aeov)localObject).f != 1)) {
        continue;
      }
      b = true;
      localObject = PreferenceManager.getDefaultGlobalPreference(BaseApplicationImpl.getContext());
      if (((SharedPreferences)localObject).getBoolean("FightReporter_deviceid", false)) {
        continue;
      }
      ((SharedPreferences)localObject).edit().putBoolean("FightReporter_deviceid", true).apply();
      String str2 = bhsp.a("0");
      try
      {
        localObject = Settings.Secure.getString(BaseApplicationImpl.getContext().getContentResolver(), "android_id");
        HashMap localHashMap = new HashMap();
        localHashMap.put("imei", str2);
        localHashMap.put("androidID", localObject);
        String str3 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        azri.a(BaseApplicationImpl.getContext()).a(str3, "FightReporter_deviceid", true, 0L, 0L, localHashMap, null);
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.d("FightReporter_", 2, "rYU.i.A.report real...IMEI = " + str2 + ",androidID = " + (String)localObject);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          String str1 = "";
        }
      }
    }
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    try
    {
      if (paramMessageRecord.msgtype == -2011)
      {
        paramMessageRecord = (MessageForStructing)paramMessageRecord;
        if (paramMessageRecord.structingMsg != null)
        {
          int i = paramMessageRecord.structingMsg.mMsgServiceID;
          a(paramMessageRecord.structingMsg);
        }
      }
      return;
    }
    catch (Throwable paramMessageRecord)
    {
      QLog.d("FightReporter_", 1, paramMessageRecord, new Object[0]);
    }
  }
  
  public static void a(AbsStructMsg paramAbsStructMsg)
  {
    aeov localaeov1;
    do
    {
      try
      {
        int i = paramAbsStructMsg.mMsgServiceID;
        if ((i < 0) || (i > 6)) {
          break;
        }
        aeov localaeov2 = aeow.a;
        localaeov1 = localaeov2;
        if (!a) {
          continue;
        }
        localaeov1 = localaeov2;
        if (localaeov2 != null) {
          continue;
        }
        localaeov1 = new aeov();
        localaeov1.a = 1;
        localaeov1.b = 1;
        localaeov1.c = 5;
      }
      catch (Throwable paramAbsStructMsg)
      {
        QLog.d("FightReporter_", 1, paramAbsStructMsg, new Object[0]);
        return;
      }
      if (localaeov1.a == 0) {
        break;
      }
      a("FightReporter_structMsgServiceID", paramAbsStructMsg.getXml());
      return;
    } while (localaeov1 != null);
  }
  
  public static void a(String paramString)
  {
    azpo.a(new Throwable(paramString));
  }
  
  public static void a(String paramString1, String paramString2)
  {
    azpo.a(new Throwable(paramString1), paramString2);
  }
  
  public static void b()
  {
    if (d) {}
    do
    {
      return;
      d = true;
      localObject = PreferenceManager.getDefaultGlobalPreference(BaseApplicationImpl.getContext());
    } while (((SharedPreferences)localObject).getBoolean("FightReporter_cpu_abi", false));
    ((SharedPreferences)localObject).edit().putBoolean("FightReporter_cpu_abi", true).apply();
    HashMap localHashMap = new HashMap();
    if (Build.VERSION.SDK_INT >= 21) {}
    for (Object localObject = Build.SUPPORTED_ABIS[0];; localObject = Build.CPU_ABI)
    {
      localHashMap.put("cpu_abi", localObject);
      localHashMap.put("sdk", Build.VERSION.SDK_INT + "");
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      azri.a(BaseApplicationImpl.getContext()).a(str, "FightReporter_cpu_abi", true, 0L, 0L, localHashMap, null);
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("FightReporter_", 2, "rYU.i.A.report real...cpu abi = " + (String)localObject + ",sdk = " + Build.VERSION.SDK_INT);
      return;
    }
  }
  
  public static void c()
  {
    aeov localaeov = aeow.a;
    if ((localaeov != null) && (localaeov.e == 1)) {
      a("FightReporter_openthirdappnullinfo");
    }
  }
  
  public static void d()
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultGlobalPreference(BaseApplicationImpl.getContext());
    String str3 = SecurityUtile.a("d_iemi");
    String str2 = SecurityUtile.a("d_idandroid");
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    String str4 = bhsp.a("0");
    Object localObject = "";
    try
    {
      str1 = Settings.Secure.getString(BaseApplicationImpl.getContext().getContentResolver(), "android_id");
      localObject = str1;
    }
    catch (Exception localException)
    {
      String str1;
      label52:
      break label52;
    }
    str1 = SecurityUtile.a(str4);
    localObject = SecurityUtile.a((String)localObject);
    localEditor.putString(str3, str1);
    localEditor.putString(str2, (String)localObject);
    localEditor.putBoolean("saveIDA", true);
    localEditor.apply();
    if (QLog.isDevelopLevel())
    {
      localObject = localSharedPreferences.getString(str3, "");
      str1 = localSharedPreferences.getString(str2, "");
      QLog.d("FightReporter_", 4, "has save suc,spIMStr = " + (String)localObject + ", imei = " + SecurityUtile.a((String)localObject) + ",androidid = " + SecurityUtile.a(str1));
    }
  }
  
  public static void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azqa
 * JD-Core Version:    0.7.0.1
 */