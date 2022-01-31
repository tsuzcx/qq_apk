import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class azla
{
  public static String a = "";
  
  private static String a(String paramString1, String paramString2, String paramString3, azlb paramazlb, int paramInt)
  {
    QLog.e("AVShortVideoReportController", 1, "getReportingDetail");
    paramString1 = new StringBuilder(64);
    paramString1.append(paramString2).append('|');
    paramString1.append(paramString3).append('|');
    paramString1.append("${count_unknown}").append('|');
    paramString1.append(paramazlb.a).append('|');
    paramString1.append(paramazlb.b).append('|');
    paramString1.append(paramazlb.c).append('|');
    paramString1.append(paramazlb.d).append('|');
    paramString1.append(paramazlb.e).append('|');
    paramString1.append(paramazlb.f).append('|');
    paramString1.append(paramazlb.g).append('|');
    paramString1.append(paramazlb.h).append('|');
    paramString1.append(paramazlb.i).append('|');
    paramString1.append(paramazlb.j).append('|');
    paramString1.append(paramazlb.k).append('|');
    paramString1.append(paramazlb.l).append('|');
    paramString1.append(paramazlb.m).append('|');
    paramString1.append(paramazlb.n).append('|');
    paramString1.append(paramazlb.o).append('|');
    paramString1.append(paramazlb.p).append('|');
    paramString1.append(paramazlb.q).append('|');
    paramString1.append(paramazlb.r).append('|');
    paramString1.append(paramazlb.s).append('|');
    paramString1.append(paramazlb.t).append('|');
    paramString1.append(paramazlb.u).append('|');
    paramString1.append(paramazlb.v).append('|');
    return paramString1.toString();
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, azlb paramazlb)
  {
    paramString1 = a(paramString2, paramString1, paramString3, paramazlb, 1);
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
 * Qualified Name:     azla
 * JD-Core Version:    0.7.0.1
 */