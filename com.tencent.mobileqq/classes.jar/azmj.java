import android.content.Intent;
import android.telephony.TelephonyManager;
import android.view.MotionEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AuthDevUgActivity;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.ROMUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class azmj
{
  public static final HashMap<String, azml> a = new HashMap();
  
  static
  {
    a.put("dc01160", new oun());
  }
  
  private static String a()
  {
    int i = bdcb.b();
    long l = bdcb.d() / 1024L / 1024L;
    long[] arrayOfLong = bdcb.a();
    String str2 = ((TelephonyManager)BaseApplicationImpl.getContext().getSystemService("phone")).getNetworkOperator();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    str2 = String.format("%.2f", new Object[] { Double.valueOf(bdcb.a()) });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i).append(";").append(l).append(";").append(arrayOfLong[0]).append(";").append(arrayOfLong[1]).append(";").append(str1.replaceAll(";", "")).append(";").append(str2).append(";").append(bnoa.a).append(";").append(bnoa.b).append(";");
    str1 = localStringBuilder.toString();
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "getExtraDeviceInfo=" + str1);
    }
    return str1;
  }
  
  private static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, int paramInt3, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      localStringBuilder.append(paramString2).append('|');
    }
    if (paramString1.equals("dc01440")) {
      localStringBuilder.append("0").append('|');
    }
    localStringBuilder.append(paramString3).append('|');
    localStringBuilder.append(paramString4).append('|');
    localStringBuilder.append(paramString5).append('|');
    localStringBuilder.append(paramString6).append('|');
    localStringBuilder.append(paramInt1).append('|');
    localStringBuilder.append("${count_unknown}").append('|');
    localStringBuilder.append(paramInt3).append('|');
    localStringBuilder.append(paramString7).append('|');
    localStringBuilder.append(paramString8).append('|');
    localStringBuilder.append(paramString9).append('|');
    localStringBuilder.append(paramString10).append('|');
    return localStringBuilder.toString();
  }
  
  private static String a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14)
  {
    String str = "";
    if (paramBoolean) {
      str = NetConnInfoCenter.getSystemNetStateString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(NetConnInfoCenter.getServerTime()).append("|").append(AppSetting.a()).append("|").append("android").append("|").append(paramString1).append("|").append(paramString2).append("|").append(paramString3).append("|").append(paramString4).append("|").append(paramString5).append("|").append(paramInt).append("|").append(paramString6).append("|").append(bdcb.a()).append("|").append("|").append(bdcb.h()).append("|").append(bdcb.i()).append("|").append(str).append("|").append(bdcb.e()).append("|").append(ROMUtil.getRomDetailInfo()).append("|").append(paramString7).append("|").append(paramString8).append("|").append(paramString9).append("|").append(paramString10).append("|").append(paramString11).append("|").append(paramString12).append("|").append(paramString13).append("|").append(paramString14).append("|");
    paramString1 = localStringBuilder.toString();
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "getDC04272ReportDetail=" + paramString1);
    }
    return paramString1;
  }
  
  public static void a(MotionEvent paramMotionEvent)
  {
    babd.a().a(paramMotionEvent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "stopReportLooper");
    }
    paramQQAppInterface = paramQQAppInterface.a();
    if (paramQQAppInterface != null) {
      paramQQAppInterface.b();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    Object localObject = paramString2;
    if (paramString2.contains("${uin_unknown}"))
    {
      String str = paramQQAppInterface.getCurrentAccountUin();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localObject = paramString2.replace("${uin_unknown}", (CharSequence)localObject);
    }
    paramString2 = ((String)localObject).replace("${count_unknown}", Integer.toString(paramInt));
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "ReportRuntime: " + paramString1 + ", " + paramString2);
    }
    for (;;)
    {
      localObject = new NewIntent(paramQQAppInterface.getApplication(), ayxz.class);
      ((NewIntent)localObject).putExtra("sendType", 2);
      ((NewIntent)localObject).putExtra("tag", paramString1);
      ((NewIntent)localObject).putExtra("content", paramString2);
      ((NewIntent)localObject).setWithouLogin(true);
      paramQQAppInterface.startServlet((NewIntent)localObject);
      return;
      if (!paramQQAppInterface.isLogin()) {
        QLog.d("ReportController", 1, "ReportRuntime: " + paramString1 + ", " + paramString2);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    a(paramQQAppInterface, paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, "", "", "", "", "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    b(paramQQAppInterface, paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, a(), paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    QQAppInterface localQQAppInterface = paramQQAppInterface;
    if (paramQQAppInterface == null)
    {
      localQQAppInterface = paramQQAppInterface;
      if (BaseApplicationImpl.sProcessId == 1)
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
        localQQAppInterface = paramQQAppInterface;
        if (localAppRuntime != null)
        {
          localQQAppInterface = paramQQAppInterface;
          if ((localAppRuntime instanceof QQAppInterface)) {
            localQQAppInterface = (QQAppInterface)localAppRuntime;
          }
        }
      }
    }
    if (localQQAppInterface == null)
    {
      paramQQAppInterface = a(true, "${uin_unknown}", paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13);
      paramString1 = new Intent();
      paramString1.setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
      paramString1.putExtra("reporting_tag", "dc04272");
      paramString1.putExtra("reporting_detail", paramQQAppInterface);
      paramString1.putExtra("reporting_count", paramInt);
      paramString1.putExtra("is_runtime", 1);
      BaseApplicationImpl.getApplication().sendBroadcast(paramString1);
      return;
    }
    a(localQQAppInterface, "dc04272", a(true, localQQAppInterface.getCurrentAccountUin(), paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13), paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    QQAppInterface localQQAppInterface = paramQQAppInterface;
    Object localObject;
    if (paramQQAppInterface == null)
    {
      localQQAppInterface = paramQQAppInterface;
      if (BaseApplicationImpl.sProcessId == 1)
      {
        localObject = BaseApplicationImpl.getApplication().peekAppRuntime();
        localQQAppInterface = paramQQAppInterface;
        if (localObject != null)
        {
          localQQAppInterface = paramQQAppInterface;
          if ((localObject instanceof QQAppInterface)) {
            localQQAppInterface = (QQAppInterface)localObject;
          }
        }
      }
    }
    if (localQQAppInterface == null)
    {
      paramQQAppInterface = a(paramString1, paramString2, "${uin_unknown}", paramString3, paramString4, paramString5, paramInt1, paramInt3, paramInt2, paramString6, paramString7, paramString8, paramString9);
      paramString2 = new Intent();
      paramString2.setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
      paramString2.putExtra("reporting_tag", paramString1);
      paramString2.putExtra("reporting_detail", paramQQAppInterface);
      paramString2.putExtra("reporting_count", paramInt3);
      paramString2.putExtra("is_runtime", 1);
      BaseApplicationImpl.getApplication().sendBroadcast(paramString2);
      if (!"CliOper".equals(paramString1)) {
        bjxs.a().a(paramString4, paramQQAppInterface);
      }
      return;
    }
    if ((NotificationActivity.a.contains(paramString4)) || (AuthDevUgActivity.a.contains(paramString4))) {
      paramQQAppInterface = "";
    }
    for (;;)
    {
      paramQQAppInterface = a(paramString1, paramString2, paramString3, paramQQAppInterface, paramString4, paramString5, paramInt1, paramInt3, paramInt2, paramString6, paramString7, paramString8, paramString9);
      a(localQQAppInterface, paramString1, paramQQAppInterface, paramInt3);
      if ("CliOper".equals(paramString1)) {
        break;
      }
      bjxs.a().a(paramString4, paramQQAppInterface);
      return;
      localObject = localQQAppInterface.getCurrentAccountUin();
      paramQQAppInterface = paramString3;
      paramString3 = (String)localObject;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    a(paramQQAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, 1, paramString6, paramString7, paramString8, paramString9);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    QQAppInterface localQQAppInterface = paramQQAppInterface;
    if (paramQQAppInterface == null)
    {
      localQQAppInterface = paramQQAppInterface;
      if (BaseApplicationImpl.sProcessId == 1)
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
        localQQAppInterface = paramQQAppInterface;
        if (localAppRuntime != null)
        {
          localQQAppInterface = paramQQAppInterface;
          if ((localAppRuntime instanceof QQAppInterface)) {
            localQQAppInterface = (QQAppInterface)localAppRuntime;
          }
        }
      }
    }
    if (localQQAppInterface == null)
    {
      paramQQAppInterface = a(paramBoolean, "${uin_unknown}", paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13);
      paramString1 = new Intent();
      paramString1.setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
      paramString1.putExtra("reporting_tag", "dc04272");
      paramString1.putExtra("reporting_detail", paramQQAppInterface);
      paramString1.putExtra("reporting_count", paramInt);
      paramString1.putExtra("is_runtime", 1);
      BaseApplicationImpl.getApplication().sendBroadcast(paramString1);
      return;
    }
    a(localQQAppInterface, "dc04272", a(paramBoolean, localQQAppInterface.getCurrentAccountUin(), paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13), paramInt);
  }
  
  public static void a(PluginRuntime paramPluginRuntime)
  {
    paramPluginRuntime.setClickEventReportor(new azmk());
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "startReportLooper");
    }
    paramQQAppInterface = paramQQAppInterface.a();
    if (paramQQAppInterface != null) {
      if (paramBoolean) {
        break label37;
      }
    }
    label37:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramQQAppInterface.a(paramBoolean);
      return true;
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool = false;
    if (("P_CliOper".equals(paramString)) || ("CliOper".equals(paramString)) || ("on_off".equals(paramString)) || ("CliStatus".equals(paramString))) {
      bool = true;
    }
    return bool;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (paramString2 != null)
    {
      azmj localazmj = paramQQAppInterface.a();
      if (localazmj != null)
      {
        String str = paramString2;
        if (paramString2.contains("${uin_unknown}")) {
          str = paramString2.replace("${uin_unknown}", paramQQAppInterface.getCurrentAccountUin());
        }
        localazmj.a(paramString1, str, paramInt);
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    a(paramQQAppInterface, paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, a(), "", "", "", "", "", "", "");
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    QQAppInterface localQQAppInterface = paramQQAppInterface;
    if (paramQQAppInterface == null)
    {
      localQQAppInterface = paramQQAppInterface;
      if (BaseApplicationImpl.sProcessId == 1)
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
        localQQAppInterface = paramQQAppInterface;
        if (localAppRuntime != null)
        {
          localQQAppInterface = paramQQAppInterface;
          if ((localAppRuntime instanceof QQAppInterface)) {
            localQQAppInterface = (QQAppInterface)localAppRuntime;
          }
        }
      }
    }
    if (localQQAppInterface == null)
    {
      paramQQAppInterface = a(true, "${uin_unknown}", paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13);
      paramString1 = new Intent();
      paramString1.setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
      paramString1.putExtra("reporting_tag", "dc04272");
      paramString1.putExtra("reporting_detail", paramQQAppInterface);
      paramString1.putExtra("reporting_count", paramInt);
      paramString1.putExtra("is_runtime", 0);
      BaseApplicationImpl.getApplication().sendBroadcast(paramString1);
      return;
    }
    b(localQQAppInterface, "dc04272", a(true, localQQAppInterface.getCurrentAccountUin(), paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13), paramInt);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    QQAppInterface localQQAppInterface = paramQQAppInterface;
    if (paramQQAppInterface == null)
    {
      localQQAppInterface = paramQQAppInterface;
      if (BaseApplicationImpl.sProcessId == 1)
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
        localQQAppInterface = paramQQAppInterface;
        if (localAppRuntime != null)
        {
          localQQAppInterface = paramQQAppInterface;
          if ((localAppRuntime instanceof QQAppInterface)) {
            localQQAppInterface = (QQAppInterface)localAppRuntime;
          }
        }
      }
    }
    if (localQQAppInterface == null)
    {
      paramQQAppInterface = a(paramString1, paramString2, "${uin_unknown}", paramString3, paramString4, paramString5, paramInt1, paramInt2, paramInt3, paramString6, paramString7, paramString8, paramString9);
      paramString2 = new Intent();
      paramString2.setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
      paramString2.putExtra("reporting_tag", paramString1);
      paramString2.putExtra("reporting_detail", paramQQAppInterface);
      paramString2.putExtra("reporting_count", paramInt2);
      paramString2.putExtra("is_runtime", 0);
      BaseApplicationImpl.getApplication().sendBroadcast(paramString2);
      if (!"CliOper".equals(paramString1)) {
        bjxs.a().a(paramString4, paramQQAppInterface);
      }
    }
    do
    {
      return;
      paramQQAppInterface = a(paramString1, paramString2, localQQAppInterface.getCurrentAccountUin(), paramString3, paramString4, paramString5, paramInt1, paramInt2, paramInt3, paramString6, paramString7, paramString8, paramString9);
      b(localQQAppInterface, paramString1, paramQQAppInterface, paramInt2);
    } while ("CliOper".equals(paramString1));
    bjxs.a().a(paramString4, paramQQAppInterface);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    b(paramQQAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, 1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  protected azml a(String paramString)
  {
    if (a.containsKey(paramString)) {
      return (azml)a.get(paramString);
    }
    return null;
  }
  
  protected void a()
  {
    Iterator localIterator = a.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (azml)a.get(localObject);
      if (localObject != null) {
        ((azml)localObject).a();
      }
    }
  }
  
  protected void a(String paramString1, String paramString2, int paramInt) {}
  
  protected void a(boolean paramBoolean) {}
  
  protected void b() {}
  
  protected boolean b(String paramString)
  {
    if ("dc01160".equals(paramString)) {
      return otv.a();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     azmj
 * JD-Core Version:    0.7.0.1
 */