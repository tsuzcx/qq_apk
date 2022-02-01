import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class bdkc
{
  public static String a = "";
  
  private static String a(String paramString1, String paramString2, String paramString3, bdkd parambdkd, int paramInt)
  {
    QLog.e("AVShortVideoReportController", 1, "getReportingDetail");
    paramString1 = new StringBuilder(64);
    paramString1.append(paramString2).append('|');
    paramString1.append(paramString3).append('|');
    paramString1.append("${count_unknown}").append('|');
    paramString1.append(parambdkd.a).append('|');
    paramString1.append(parambdkd.b).append('|');
    paramString1.append(parambdkd.c).append('|');
    paramString1.append(parambdkd.d).append('|');
    paramString1.append(parambdkd.e).append('|');
    paramString1.append(parambdkd.f).append('|');
    paramString1.append(parambdkd.g).append('|');
    paramString1.append(parambdkd.h).append('|');
    paramString1.append(parambdkd.i).append('|');
    paramString1.append(parambdkd.j).append('|');
    paramString1.append(parambdkd.k).append('|');
    paramString1.append(parambdkd.l).append('|');
    paramString1.append(parambdkd.m).append('|');
    paramString1.append(parambdkd.n).append('|');
    paramString1.append(parambdkd.o).append('|');
    paramString1.append(parambdkd.p).append('|');
    paramString1.append(parambdkd.q).append('|');
    paramString1.append(parambdkd.r).append('|');
    paramString1.append(parambdkd.s).append('|');
    paramString1.append(parambdkd.t).append('|');
    paramString1.append(parambdkd.u).append('|');
    paramString1.append(parambdkd.v).append('|');
    return paramString1.toString();
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, bdkd parambdkd)
  {
    paramString1 = a(paramString2, paramString1, paramString3, parambdkd, 1);
    if (QLog.isColorLevel()) {
      QLog.i("AVShortVideoReportController", 2, "POST getReportingDetail=" + paramString1);
    }
    paramString3 = new Intent();
    paramString3.setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
    paramString3.putExtra("reporting_tag", paramString2);
    paramString3.putExtra("reporting_detail", paramString1);
    paramString3.putExtra("reporting_count", 1);
    paramString3.putExtra("is_runtime", 0);
    BaseApplicationImpl.getApplication().sendBroadcast(paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdkc
 * JD-Core Version:    0.7.0.1
 */