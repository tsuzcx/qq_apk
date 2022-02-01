import com.tencent.mobileqq.search.util.SearchConfigManager;
import java.util.Comparator;
import java.util.Map;

public final class bbsr
  implements Comparator<bbti>
{
  public int a(bbti parambbti1, bbti parambbti2)
  {
    parambbti2 = (Integer)SearchConfigManager.searchEngineOrder.get(parambbti2.a);
    if (parambbti2 == null) {
      parambbti2 = Integer.valueOf(0);
    }
    for (;;)
    {
      Integer localInteger = (Integer)SearchConfigManager.searchEngineOrder.get(parambbti1.a);
      parambbti1 = localInteger;
      if (localInteger == null) {
        parambbti1 = Integer.valueOf(0);
      }
      return Integer.signum(parambbti2.intValue() - parambbti1.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbsr
 * JD-Core Version:    0.7.0.1
 */