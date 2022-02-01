import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class bcrk
{
  public static String a = "";
  
  private static String a(String paramString1, String paramString2, String paramString3, bcrl parambcrl, int paramInt)
  {
    QLog.e("AVShortVideoReportController", 1, "getReportingDetail");
    paramString1 = new StringBuilder(64);
    paramString1.append(paramString2).append('|');
    paramString1.append(paramString3).append('|');
    paramString1.append("${count_unknown}").append('|');
    paramString1.append(parambcrl.a).append('|');
    paramString1.append(parambcrl.b).append('|');
    paramString1.append(parambcrl.c).append('|');
    paramString1.append(parambcrl.d).append('|');
    paramString1.append(parambcrl.e).append('|');
    paramString1.append(parambcrl.f).append('|');
    paramString1.append(parambcrl.g).append('|');
    paramString1.append(parambcrl.h).append('|');
    paramString1.append(parambcrl.i).append('|');
    paramString1.append(parambcrl.j).append('|');
    paramString1.append(parambcrl.k).append('|');
    paramString1.append(parambcrl.l).append('|');
    paramString1.append(parambcrl.m).append('|');
    paramString1.append(parambcrl.n).append('|');
    paramString1.append(parambcrl.o).append('|');
    paramString1.append(parambcrl.p).append('|');
    paramString1.append(parambcrl.q).append('|');
    paramString1.append(parambcrl.r).append('|');
    paramString1.append(parambcrl.s).append('|');
    paramString1.append(parambcrl.t).append('|');
    paramString1.append(parambcrl.u).append('|');
    paramString1.append(parambcrl.v).append('|');
    return paramString1.toString();
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, bcrl parambcrl)
  {
    paramString1 = a(paramString2, paramString1, paramString3, parambcrl, 1);
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
 * Qualified Name:     bcrk
 * JD-Core Version:    0.7.0.1
 */