import com.tencent.mobileqq.search.util.SearchConfigManager;
import java.util.Comparator;
import java.util.Map;

public final class bclk
  implements Comparator<bcmb>
{
  public int a(bcmb parambcmb1, bcmb parambcmb2)
  {
    parambcmb2 = (Integer)SearchConfigManager.searchEngineOrder.get(parambcmb2.a);
    if (parambcmb2 == null) {
      parambcmb2 = Integer.valueOf(0);
    }
    for (;;)
    {
      Integer localInteger = (Integer)SearchConfigManager.searchEngineOrder.get(parambcmb1.a);
      parambcmb1 = localInteger;
      if (localInteger == null) {
        parambcmb1 = Integer.valueOf(0);
      }
      return Integer.signum(parambcmb2.intValue() - parambcmb1.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bclk
 * JD-Core Version:    0.7.0.1
 */