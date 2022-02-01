import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.videoplatform.api.IReport;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class azjt
  implements IReport
{
  public void report(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3)
  {
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azjt
 * JD-Core Version:    0.7.0.1
 */