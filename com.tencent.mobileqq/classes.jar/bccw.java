import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class bccw
{
  public static String a = "";
  
  private static String a(String paramString1, String paramString2, String paramString3, bccx parambccx, int paramInt)
  {
    QLog.e("AVShortVideoReportController", 1, "getReportingDetail");
    paramString1 = new StringBuilder(64);
    paramString1.append(paramString2).append('|');
    paramString1.append(paramString3).append('|');
    paramString1.append("${count_unknown}").append('|');
    paramString1.append(parambccx.a).append('|');
    paramString1.append(parambccx.b).append('|');
    paramString1.append(parambccx.c).append('|');
    paramString1.append(parambccx.d).append('|');
    paramString1.append(parambccx.e).append('|');
    paramString1.append(parambccx.f).append('|');
    paramString1.append(parambccx.g).append('|');
    paramString1.append(parambccx.h).append('|');
    paramString1.append(parambccx.i).append('|');
    paramString1.append(parambccx.j).append('|');
    paramString1.append(parambccx.k).append('|');
    paramString1.append(parambccx.l).append('|');
    paramString1.append(parambccx.m).append('|');
    paramString1.append(parambccx.n).append('|');
    paramString1.append(parambccx.o).append('|');
    paramString1.append(parambccx.p).append('|');
    paramString1.append(parambccx.q).append('|');
    paramString1.append(parambccx.r).append('|');
    paramString1.append(parambccx.s).append('|');
    paramString1.append(parambccx.t).append('|');
    paramString1.append(parambccx.u).append('|');
    paramString1.append(parambccx.v).append('|');
    return paramString1.toString();
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, bccx parambccx)
  {
    paramString1 = a(paramString2, paramString1, paramString3, parambccx, 1);
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
 * Qualified Name:     bccw
 * JD-Core Version:    0.7.0.1
 */