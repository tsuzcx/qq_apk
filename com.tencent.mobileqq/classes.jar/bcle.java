import com.tencent.mobileqq.search.util.SearchConfigManager;
import java.util.Comparator;
import java.util.Map;

public final class bcle
  implements Comparator<bclv>
{
  public int a(bclv parambclv1, bclv parambclv2)
  {
    parambclv2 = (Integer)SearchConfigManager.searchEngineOrder.get(parambclv2.a);
    if (parambclv2 == null) {
      parambclv2 = Integer.valueOf(0);
    }
    for (;;)
    {
      Integer localInteger = (Integer)SearchConfigManager.searchEngineOrder.get(parambclv1.a);
      parambclv1 = localInteger;
      if (localInteger == null) {
        parambclv1 = Integer.valueOf(0);
      }
      return Integer.signum(parambclv2.intValue() - parambclv1.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcle
 * JD-Core Version:    0.7.0.1
 */