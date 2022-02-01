import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class bdjr
{
  public static String a = "";
  
  private static String a(String paramString1, String paramString2, String paramString3, bdjs parambdjs, int paramInt)
  {
    QLog.e("AVShortVideoReportController", 1, "getReportingDetail");
    paramString1 = new StringBuilder(64);
    paramString1.append(paramString2).append('|');
    paramString1.append(paramString3).append('|');
    paramString1.append("${count_unknown}").append('|');
    paramString1.append(parambdjs.a).append('|');
    paramString1.append(parambdjs.b).append('|');
    paramString1.append(parambdjs.c).append('|');
    paramString1.append(parambdjs.d).append('|');
    paramString1.append(parambdjs.e).append('|');
    paramString1.append(parambdjs.f).append('|');
    paramString1.append(parambdjs.g).append('|');
    paramString1.append(parambdjs.h).append('|');
    paramString1.append(parambdjs.i).append('|');
    paramString1.append(parambdjs.j).append('|');
    paramString1.append(parambdjs.k).append('|');
    paramString1.append(parambdjs.l).append('|');
    paramString1.append(parambdjs.m).append('|');
    paramString1.append(parambdjs.n).append('|');
    paramString1.append(parambdjs.o).append('|');
    paramString1.append(parambdjs.p).append('|');
    paramString1.append(parambdjs.q).append('|');
    paramString1.append(parambdjs.r).append('|');
    paramString1.append(parambdjs.s).append('|');
    paramString1.append(parambdjs.t).append('|');
    paramString1.append(parambdjs.u).append('|');
    paramString1.append(parambdjs.v).append('|');
    return paramString1.toString();
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, bdjs parambdjs)
  {
    paramString1 = a(paramString2, paramString1, paramString3, parambdjs, 1);
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
 * Qualified Name:     bdjr
 * JD-Core Version:    0.7.0.1
 */