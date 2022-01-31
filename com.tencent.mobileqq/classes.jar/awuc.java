import com.tencent.mobileqq.search.util.SearchConfigManager;
import java.util.Comparator;
import java.util.Map;

public final class awuc
  implements Comparator<awut>
{
  public int a(awut paramawut1, awut paramawut2)
  {
    paramawut2 = (Integer)SearchConfigManager.searchEngineOrder.get(paramawut2.a);
    if (paramawut2 == null) {
      paramawut2 = Integer.valueOf(0);
    }
    for (;;)
    {
      Integer localInteger = (Integer)SearchConfigManager.searchEngineOrder.get(paramawut1.a);
      paramawut1 = localInteger;
      if (localInteger == null) {
        paramawut1 = Integer.valueOf(0);
      }
      return Integer.signum(paramawut2.intValue() - paramawut1.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awuc
 * JD-Core Version:    0.7.0.1
 */