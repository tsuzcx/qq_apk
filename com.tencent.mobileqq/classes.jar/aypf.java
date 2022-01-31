import com.tencent.mobileqq.search.util.SearchConfigManager;
import java.util.Comparator;
import java.util.Map;

public final class aypf
  implements Comparator<aypw>
{
  public int a(aypw paramaypw1, aypw paramaypw2)
  {
    paramaypw2 = (Integer)SearchConfigManager.searchEngineOrder.get(paramaypw2.a);
    if (paramaypw2 == null) {
      paramaypw2 = Integer.valueOf(0);
    }
    for (;;)
    {
      Integer localInteger = (Integer)SearchConfigManager.searchEngineOrder.get(paramaypw1.a);
      paramaypw1 = localInteger;
      if (localInteger == null) {
        paramaypw1 = Integer.valueOf(0);
      }
      return Integer.signum(paramaypw2.intValue() - paramaypw1.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aypf
 * JD-Core Version:    0.7.0.1
 */