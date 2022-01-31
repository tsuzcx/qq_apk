import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class awpp
{
  public static String a = "";
  
  private static String a(String paramString1, String paramString2, String paramString3, awpq paramawpq, int paramInt)
  {
    QLog.e("AVShortVideoReportController", 1, "getReportingDetail");
    paramString1 = new StringBuilder(64);
    paramString1.append(paramString2).append('|');
    paramString1.append(paramString3).append('|');
    paramString1.append("${count_unknown}").append('|');
    paramString1.append(paramawpq.a).append('|');
    paramString1.append(paramawpq.b).append('|');
    paramString1.append(paramawpq.c).append('|');
    paramString1.append(paramawpq.d).append('|');
    paramString1.append(paramawpq.e).append('|');
    paramString1.append(paramawpq.f).append('|');
    paramString1.append(paramawpq.g).append('|');
    paramString1.append(paramawpq.h).append('|');
    paramString1.append(paramawpq.i).append('|');
    paramString1.append(paramawpq.j).append('|');
    paramString1.append(paramawpq.k).append('|');
    paramString1.append(paramawpq.l).append('|');
    paramString1.append(paramawpq.m).append('|');
    paramString1.append(paramawpq.n).append('|');
    paramString1.append(paramawpq.o).append('|');
    paramString1.append(paramawpq.p).append('|');
    paramString1.append(paramawpq.q).append('|');
    paramString1.append(paramawpq.r).append('|');
    paramString1.append(paramawpq.s).append('|');
    paramString1.append(paramawpq.t).append('|');
    paramString1.append(paramawpq.u).append('|');
    paramString1.append(paramawpq.v).append('|');
    return paramString1.toString();
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, awpq paramawpq)
  {
    paramString1 = a(paramString2, paramString1, paramString3, paramawpq, 1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     awpp
 * JD-Core Version:    0.7.0.1
 */