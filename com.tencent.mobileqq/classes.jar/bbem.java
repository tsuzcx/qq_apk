import com.tencent.mobileqq.search.util.SearchConfigManager;
import java.util.Comparator;
import java.util.Map;

public final class bbem
  implements Comparator<bbfd>
{
  public int a(bbfd parambbfd1, bbfd parambbfd2)
  {
    parambbfd2 = (Integer)SearchConfigManager.searchEngineOrder.get(parambbfd2.a);
    if (parambbfd2 == null) {
      parambbfd2 = Integer.valueOf(0);
    }
    for (;;)
    {
      Integer localInteger = (Integer)SearchConfigManager.searchEngineOrder.get(parambbfd1.a);
      parambbfd1 = localInteger;
      if (localInteger == null) {
        parambbfd1 = Integer.valueOf(0);
      }
      return Integer.signum(parambbfd2.intValue() - parambbfd1.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbem
 * JD-Core Version:    0.7.0.1
 */