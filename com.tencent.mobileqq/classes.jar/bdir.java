import com.google.gson.Gson;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.tfm.metrics.api.MetricsLogBean;
import com.tencent.tfm.metrics.api.Reporter;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class bdir
  implements Reporter
{
  private Gson jdField_a_of_type_ComGoogleGsonGson = new Gson();
  private StatisticCollector jdField_a_of_type_ComTencentMobileqqStatisticsStatisticCollector;
  private String jdField_a_of_type_JavaLangString;
  
  public bdir(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.jdField_a_of_type_ComTencentMobileqqStatisticsStatisticCollector = StatisticCollector.getInstance(paramBaseApplicationImpl);
    this.jdField_a_of_type_JavaLangString = paramBaseApplicationImpl.getRuntime().getAccount();
  }
  
  public void report(MetricsLogBean paramMetricsLogBean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("monitor", this.jdField_a_of_type_ComGoogleGsonGson.toJson(paramMetricsLogBean) + ";");
    this.jdField_a_of_type_ComTencentMobileqqStatisticsStatisticCollector.collectPerformance(this.jdField_a_of_type_JavaLangString, "rqd_tfm_metrics", true, 0L, 0L, localHashMap, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdir
 * JD-Core Version:    0.7.0.1
 */