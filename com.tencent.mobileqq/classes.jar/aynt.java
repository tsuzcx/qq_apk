import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.report.ReportModel;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class aynt
{
  public static final String a = aynt.class.getSimpleName();
  public static String b = "";
  
  public static String a()
  {
    return "old_search";
  }
  
  public static String a(int paramInt)
  {
    if (paramInt == 1) {
      return "message";
    }
    if (paramInt == 2) {
      return "contact";
    }
    if ((paramInt == 21) || (paramInt == 3)) {
      return "dongtai";
    }
    if ((paramInt == 25) || (paramInt == 10)) {
      return "kandian";
    }
    return "unknown";
  }
  
  public static void a(int paramInt1, int paramInt2, ayis paramayis)
  {
    if ((paramayis == null) || (paramayis.a() == null)) {}
    do
    {
      do
      {
        return;
      } while (!paramayis.a());
      if (paramayis.a().equals(ayiy.a)) {
        a(null, 0, paramInt2, "0X8009D4E", 0, 0, null, null);
      }
      if (paramayis.a().equals(ayiv.a)) {
        a(null, 0, paramInt2, "0X8009D38", 0, 0, null, null);
      }
      if (paramayis.a().equals(ayix.a)) {
        a(null, 0, paramInt2, "0X8009D3C", 0, 0, null, null);
      }
    } while (!paramayis.a().equals(alpo.a(2131716288)));
    a(null, 0, paramInt2, "0X8009D52", 0, 0, null, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, String paramString2)
  {
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = BaseApplicationImpl.getApplication().getRuntime();
      if (!(paramQQAppInterface instanceof QQAppInterface))
      {
        QLog.e(a, 1, "app is null");
        return;
      }
      paramQQAppInterface = (QQAppInterface)paramQQAppInterface;
    }
    for (;;)
    {
      int i = 0;
      if (paramInt1 != 0) {
        switch (paramInt1)
        {
        default: 
          paramInt1 = i;
        }
      }
      for (;;)
      {
        String str2 = "" + paramInt3;
        String str1 = "" + paramInt4;
        try
        {
          Integer.valueOf(str2);
          azmj.b(paramQQAppInterface, "dc00898", "", "", "qqsearch", paramString1, paramInt1, 0, str2, str1, paramString2, "");
          return;
        }
        catch (Exception localException)
        {
          azmj.b(paramQQAppInterface, "dc00898", "", "", "qqsearch", paramString1, paramInt1, 0, "0", str1, paramString2, "");
          return;
        }
        paramInt1 = 1;
        continue;
        paramInt1 = 2;
        continue;
        paramInt1 = 3;
        continue;
        switch (paramInt2)
        {
        default: 
          paramInt1 = 0;
          break;
        case 1: 
          paramInt1 = 1;
          break;
        case 2: 
          paramInt1 = 2;
          break;
        case 21: 
          paramInt1 = 3;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, String paramString2, String paramString3)
  {
    int i = 0;
    if (paramInt1 != 0) {
      switch (paramInt1)
      {
      default: 
        if (paramString2 == null) {
          paramString2 = "";
        }
        break;
      }
    }
    for (;;)
    {
      if (paramString3 == null) {
        paramString3 = "";
      }
      for (;;)
      {
        azmj.b(paramQQAppInterface, "dc00898", "", "", "qqsearch", paramString1, i, 0, paramInt3 + "", paramInt4 + "", paramString2, paramString3);
        QLog.d("searchReportClick898", 2, " source: " + paramInt1 + " from: " + paramInt2 + "  sopName: " + paramString1 + " r1: " + paramInt3 + " r2: " + paramInt4 + " r3: " + paramString2 + " r4: " + paramString3);
        return;
        i = 1;
        break;
        i = 2;
        break;
        i = 3;
        break;
        if (paramInt2 != 0) {}
        switch (paramInt2)
        {
        default: 
          i = 0;
          break;
        case 1: 
          i = 1;
          break;
        case 2: 
          i = 2;
          break;
        case 21: 
          i = 3;
          break;
        case 25: 
          i = 4;
          break;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ReportModelDC02528 paramReportModelDC02528)
  {
    a("dc02528", paramQQAppInterface, paramReportModelDC02528);
    if (QLog.isColorLevel()) {}
  }
  
  public static void a(Object paramObject, String paramString, int paramInt)
  {
    if ((paramObject instanceof ayis)) {
      a(0, paramInt, (ayis)paramObject);
    }
    if ((paramObject instanceof ayjb)) {
      a(null, 0, paramInt, "0X8009D30", 0, 0, null, null);
    }
    Object localObject;
    int i;
    label137:
    label270:
    label533:
    if ((paramObject instanceof ayiv))
    {
      localObject = (ayiv)paramObject;
      if (((ayiv)localObject).a() == null) {
        break label611;
      }
      i = ((ayiv)localObject).a().size();
      if (i > ((ayiv)localObject).a())
      {
        i = ((ayiv)localObject).a();
        ayrd.a("all_result", "exp_contact", new String[] { "" + paramString, "" + i });
        a(null, 0, paramInt, "0X8009D36", 0, 0, null, null);
      }
    }
    else
    {
      if ((paramObject instanceof ayix)) {
        a(null, 0, paramInt, "0X8009D3A", 0, 0, null, null);
      }
      if ((paramObject instanceof ayhd))
      {
        localObject = (ayhd)paramObject;
        if (((ayhd)localObject).a() == null) {
          break label655;
        }
        i = ((ayhd)localObject).a().size();
        if (i <= ((ayhd)localObject).a()) {
          break label652;
        }
        i = ((ayhd)localObject).a();
        label215:
        ayrd.a("all_result", "exp_talk", new String[] { "" + paramString, "" + i });
        a(null, 0, paramInt, "0X8009D4C", 0, 0, null, null);
      }
      if ((paramObject instanceof biru))
      {
        localObject = (biru)paramObject;
        if (((biru)localObject).a() == null) {
          break label699;
        }
        i = ((biru)localObject).a().size();
        if (i <= ((biru)localObject).a()) {
          break label696;
        }
        i = ((biru)localObject).a();
        label329:
        ayrd.a("all_result", "exp_collect", new String[] { "" + paramString, "" + i });
      }
      if ((paramObject instanceof aqyn))
      {
        localObject = (aqyn)paramObject;
        if (((aqyn)localObject).a() == null) {
          break label743;
        }
        i = ((aqyn)localObject).a().size();
        if (i <= ((aqyn)localObject).a()) {
          break label740;
        }
        i = ((aqyn)localObject).a();
        label431:
        ayrd.a("all_result", "exp_file", new String[] { "" + paramString, "" + i });
      }
      label486:
      if ((paramObject instanceof ayjc))
      {
        localObject = (ayjc)paramObject;
        if (((ayjc)localObject).a() == null) {
          break label787;
        }
        i = ((ayjc)localObject).a().size();
        if (i <= ((ayjc)localObject).a()) {
          break label784;
        }
        i = ((ayjc)localObject).a();
        ayrd.a("all_result", "exp_discuss", new String[] { "" + paramString, "" + i });
      }
    }
    for (;;)
    {
      label384:
      if ((paramObject instanceof ayjd)) {
        a(null, 0, paramInt, "0X8009D50", 0, 0, null, null);
      }
      return;
      break;
      label611:
      ayrd.a("all_result", "exp_contact", new String[] { "" + paramString, "0" });
      break label137;
      label652:
      break label215;
      label655:
      ayrd.a("all_result", "exp_talk", new String[] { "" + paramString, "0" });
      break label270;
      label696:
      break label329;
      label699:
      ayrd.a("all_result", "exp_collect", new String[] { "" + paramString, "0" });
      break label384;
      label740:
      break label431;
      label743:
      ayrd.a("all_result", "exp_file", new String[] { "" + paramString, "0" });
      break label486;
      label784:
      break label533;
      label787:
      ayrd.a("all_result", "exp_discuss", new String[] { "" + paramString, "0" });
    }
  }
  
  public static void a(String paramString, QQAppInterface paramQQAppInterface, ReportModel paramReportModel)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (!QLog.isColorLevel()) {}
    }
    do
    {
      return;
      if (paramReportModel != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    return;
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
      paramQQAppInterface = new Intent();
      paramQQAppInterface.setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
      paramQQAppInterface.putExtra("reporting_tag", paramString);
      paramQQAppInterface.putExtra("reporting_detail", paramReportModel);
      paramQQAppInterface.putExtra("reporting_count", paramReportModel.report_count);
      paramQQAppInterface.putExtra("is_runtime", 1);
      BaseApplicationImpl.getApplication().sendBroadcast(paramQQAppInterface);
      return;
    }
    b(paramString, localQQAppInterface, paramReportModel);
  }
  
  protected static void b(String paramString, QQAppInterface paramQQAppInterface, ReportModel paramReportModel)
  {
    if ((paramReportModel == null) || (paramQQAppInterface == null)) {
      if (!QLog.isColorLevel()) {}
    }
    do
    {
      return;
      paramReportModel.uin = paramQQAppInterface.getCurrentAccountUin();
      paramReportModel.version = "8.3.3";
      NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), ayxz.class);
      localNewIntent.putExtra("sendType", 2);
      localNewIntent.putExtra("tag", paramString);
      localNewIntent.putExtra("content", paramReportModel.toReportString());
      localNewIntent.setWithouLogin(true);
      paramQQAppInterface.startServlet(localNewIntent);
    } while (!QLog.isColorLevel());
    QLog.d(a, 2, "reportEventRuntime, tag = " + paramString + ", model = " + paramReportModel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aynt
 * JD-Core Version:    0.7.0.1
 */