import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class azpj
{
  public static String a = "";
  
  private static String a(String paramString1, String paramString2, String paramString3, azpk paramazpk, int paramInt)
  {
    QLog.e("AVShortVideoReportController", 1, "getReportingDetail");
    paramString1 = new StringBuilder(64);
    paramString1.append(paramString2).append('|');
    paramString1.append(paramString3).append('|');
    paramString1.append("${count_unknown}").append('|');
    paramString1.append(paramazpk.a).append('|');
    paramString1.append(paramazpk.b).append('|');
    paramString1.append(paramazpk.c).append('|');
    paramString1.append(paramazpk.d).append('|');
    paramString1.append(paramazpk.e).append('|');
    paramString1.append(paramazpk.f).append('|');
    paramString1.append(paramazpk.g).append('|');
    paramString1.append(paramazpk.h).append('|');
    paramString1.append(paramazpk.i).append('|');
    paramString1.append(paramazpk.j).append('|');
    paramString1.append(paramazpk.k).append('|');
    paramString1.append(paramazpk.l).append('|');
    paramString1.append(paramazpk.m).append('|');
    paramString1.append(paramazpk.n).append('|');
    paramString1.append(paramazpk.o).append('|');
    paramString1.append(paramazpk.p).append('|');
    paramString1.append(paramazpk.q).append('|');
    paramString1.append(paramazpk.r).append('|');
    paramString1.append(paramazpk.s).append('|');
    paramString1.append(paramazpk.t).append('|');
    paramString1.append(paramazpk.u).append('|');
    paramString1.append(paramazpk.v).append('|');
    return paramString1.toString();
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, azpk paramazpk)
  {
    paramString1 = a(paramString2, paramString1, paramString3, paramazpk, 1);
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
 * Qualified Name:     azpj
 * JD-Core Version:    0.7.0.1
 */