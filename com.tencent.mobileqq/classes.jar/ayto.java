import com.tencent.mobileqq.search.util.SearchConfigManager;
import java.util.Comparator;
import java.util.Map;

public final class ayto
  implements Comparator<ayuf>
{
  public int a(ayuf paramayuf1, ayuf paramayuf2)
  {
    paramayuf2 = (Integer)SearchConfigManager.searchEngineOrder.get(paramayuf2.a);
    if (paramayuf2 == null) {
      paramayuf2 = Integer.valueOf(0);
    }
    for (;;)
    {
      Integer localInteger = (Integer)SearchConfigManager.searchEngineOrder.get(paramayuf1.a);
      paramayuf1 = localInteger;
      if (localInteger == null) {
        paramayuf1 = Integer.valueOf(0);
      }
      return Integer.signum(paramayuf2.intValue() - paramayuf1.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayto
 * JD-Core Version:    0.7.0.1
 */