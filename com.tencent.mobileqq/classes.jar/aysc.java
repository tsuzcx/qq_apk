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

public class aysc
{
  public static final String a = aysc.class.getSimpleName();
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
  
  public static void a(int paramInt1, int paramInt2, aynb paramaynb)
  {
    if ((paramaynb == null) || (paramaynb.a() == null)) {}
    do
    {
      do
      {
        return;
      } while (!paramaynb.a());
      if (paramaynb.a().equals(aynh.a)) {
        a(null, 0, paramInt2, "0X8009D4E", 0, 0, null, null);
      }
      if (paramaynb.a().equals(ayne.a)) {
        a(null, 0, paramInt2, "0X8009D38", 0, 0, null, null);
      }
      if (paramaynb.a().equals(ayng.a)) {
        a(null, 0, paramInt2, "0X8009D3C", 0, 0, null, null);
      }
    } while (!paramaynb.a().equals(alud.a(2131716300)));
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
          azqs.b(paramQQAppInterface, "dc00898", "", "", "qqsearch", paramString1, paramInt1, 0, str2, str1, paramString2, "");
          return;
        }
        catch (Exception localException)
        {
          azqs.b(paramQQAppInterface, "dc00898", "", "", "qqsearch", paramString1, paramInt1, 0, "0", str1, paramString2, "");
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
        azqs.b(paramQQAppInterface, "dc00898", "", "", "qqsearch", paramString1, i, 0, paramInt3 + "", paramInt4 + "", paramString2, paramString3);
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
    if ((paramObject instanceof aynb)) {
      a(0, paramInt, (aynb)paramObject);
    }
    if ((paramObject instanceof aynk)) {
      a(null, 0, paramInt, "0X8009D30", 0, 0, null, null);
    }
    Object localObject;
    int i;
    label137:
    label270:
    label533:
    if ((paramObject instanceof ayne))
    {
      localObject = (ayne)paramObject;
      if (((ayne)localObject).a() == null) {
        break label611;
      }
      i = ((ayne)localObject).a().size();
      if (i > ((ayne)localObject).a())
      {
        i = ((ayne)localObject).a();
        ayvm.a("all_result", "exp_contact", new String[] { "" + paramString, "" + i });
        a(null, 0, paramInt, "0X8009D36", 0, 0, null, null);
      }
    }
    else
    {
      if ((paramObject instanceof ayng)) {
        a(null, 0, paramInt, "0X8009D3A", 0, 0, null, null);
      }
      if ((paramObject instanceof aylm))
      {
        localObject = (aylm)paramObject;
        if (((aylm)localObject).a() == null) {
          break label655;
        }
        i = ((aylm)localObject).a().size();
        if (i <= ((aylm)localObject).a()) {
          break label652;
        }
        i = ((aylm)localObject).a();
        label215:
        ayvm.a("all_result", "exp_talk", new String[] { "" + paramString, "" + i });
        a(null, 0, paramInt, "0X8009D4C", 0, 0, null, null);
      }
      if ((paramObject instanceof biwb))
      {
        localObject = (biwb)paramObject;
        if (((biwb)localObject).a() == null) {
          break label699;
        }
        i = ((biwb)localObject).a().size();
        if (i <= ((biwb)localObject).a()) {
          break label696;
        }
        i = ((biwb)localObject).a();
        label329:
        ayvm.a("all_result", "exp_collect", new String[] { "" + paramString, "" + i });
      }
      if ((paramObject instanceof arcw))
      {
        localObject = (arcw)paramObject;
        if (((arcw)localObject).a() == null) {
          break label743;
        }
        i = ((arcw)localObject).a().size();
        if (i <= ((arcw)localObject).a()) {
          break label740;
        }
        i = ((arcw)localObject).a();
        label431:
        ayvm.a("all_result", "exp_file", new String[] { "" + paramString, "" + i });
      }
      label486:
      if ((paramObject instanceof aynl))
      {
        localObject = (aynl)paramObject;
        if (((aynl)localObject).a() == null) {
          break label787;
        }
        i = ((aynl)localObject).a().size();
        if (i <= ((aynl)localObject).a()) {
          break label784;
        }
        i = ((aynl)localObject).a();
        ayvm.a("all_result", "exp_discuss", new String[] { "" + paramString, "" + i });
      }
    }
    for (;;)
    {
      label384:
      if ((paramObject instanceof aynm)) {
        a(null, 0, paramInt, "0X8009D50", 0, 0, null, null);
      }
      return;
      break;
      label611:
      ayvm.a("all_result", "exp_contact", new String[] { "" + paramString, "0" });
      break label137;
      label652:
      break label215;
      label655:
      ayvm.a("all_result", "exp_talk", new String[] { "" + paramString, "0" });
      break label270;
      label696:
      break label329;
      label699:
      ayvm.a("all_result", "exp_collect", new String[] { "" + paramString, "0" });
      break label384;
      label740:
      break label431;
      label743:
      ayvm.a("all_result", "exp_file", new String[] { "" + paramString, "0" });
      break label486;
      label784:
      break label533;
      label787:
      ayvm.a("all_result", "exp_discuss", new String[] { "" + paramString, "0" });
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
      paramReportModel.version = "8.3.5";
      NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), azci.class);
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
 * Qualified Name:     aysc
 * JD-Core Version:    0.7.0.1
 */