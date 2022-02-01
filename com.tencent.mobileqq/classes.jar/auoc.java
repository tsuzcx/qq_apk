import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.intervideo.huayang.HuayangOpenHelper.1;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class auoc
{
  public static void a(Context paramContext, String paramString)
  {
    if (paramString == null) {}
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    do
    {
      return;
      while (!paramContext.hasNext())
      {
        do
        {
          paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
        } while ((paramContext == null) || (paramContext.size() == 0));
        paramContext = paramContext.iterator();
      }
      localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
    } while (!paramString.equals(localRunningAppProcessInfo.processName));
    if (QLog.isColorLevel()) {
      QLog.d("HuayangOpenHelper", 2, "杀死进程：" + paramString);
    }
    Process.killProcess(localRunningAppProcessInfo.pid);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HuayangOpenHelper", 2, String.format("appType = %s,openType = %s, fromId = %s, uri = %s ，action = %s,pkgName = %s", new Object[] { paramString1, paramString2, paramString4, paramString3, paramString5, paramString6 }));
    }
    auok.a(paramQQAppInterface.getApp(), paramString1);
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString6)))
    {
      if (!"slientDownload".equals(paramString5)) {
        break label156;
      }
      auoj.a("2587808");
      paramString7 = IVPluginInfo.a(paramString7);
      paramString4 = paramString7;
      if (paramString7.size() == 0) {
        paramString4 = IVPluginInfo.a();
      }
      if (!TextUtils.isEmpty(paramString1)) {
        break label209;
      }
      paramString1 = "hy_sixgod";
    }
    label156:
    label209:
    for (;;)
    {
      ThreadManagerV2.executeOnSubThread(new HuayangOpenHelper.1(paramString1, aunt.a(paramQQAppInterface.getApp(), paramString6, paramString1), paramQQAppInterface, paramString3, paramString5, paramString4));
      a(paramString2, paramString2);
      return;
      if (!"download".equals(paramString5)) {
        break;
      }
      if (aunx.a(paramString6))
      {
        auoj.a("2691701");
        break;
      }
      if (aunx.b(paramString6))
      {
        auoj.a("2597718");
        break;
      }
      auok.b(paramQQAppInterface.getApp(), paramString1);
      break;
    }
  }
  
  private static void a(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "HyProxy";
    }
    xwa.a("huayang", "openHy", 0, 0, new String[] { str, paramString2 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auoc
 * JD-Core Version:    0.7.0.1
 */