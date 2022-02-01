import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.StatisticCollector.Proxy;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

public final class bdig
  implements IMCoreProxyRoute.StatisticCollector.Proxy
{
  public void collectPerformance(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3)
  {
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap, paramString3);
  }
  
  public void collectPerformance(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3, boolean paramBoolean2)
  {
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(paramString1, paramString2, paramBoolean1, paramLong1, paramLong2, paramHashMap, paramString3, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdig
 * JD-Core Version:    0.7.0.1
 */