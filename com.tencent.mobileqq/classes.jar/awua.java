import com.tencent.mobileqq.search.util.SearchConfigManager;
import java.util.Comparator;
import java.util.Map;

public final class awua
  implements Comparator<awur>
{
  public int a(awur paramawur1, awur paramawur2)
  {
    paramawur2 = (Integer)SearchConfigManager.searchEngineOrder.get(paramawur2.a);
    if (paramawur2 == null) {
      paramawur2 = Integer.valueOf(0);
    }
    for (;;)
    {
      Integer localInteger = (Integer)SearchConfigManager.searchEngineOrder.get(paramawur1.a);
      paramawur1 = localInteger;
      if (localInteger == null) {
        paramawur1 = Integer.valueOf(0);
      }
      return Integer.signum(paramawur2.intValue() - paramawur1.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awua
 * JD-Core Version:    0.7.0.1
 */