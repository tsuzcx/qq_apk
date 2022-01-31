import com.tencent.mobileqq.search.util.SearchConfigManager;
import java.util.Comparator;
import java.util.Map;

public final class avuh
  implements Comparator<avuy>
{
  public int a(avuy paramavuy1, avuy paramavuy2)
  {
    paramavuy2 = (Integer)SearchConfigManager.searchEngineOrder.get(paramavuy2.a);
    if (paramavuy2 == null) {
      paramavuy2 = Integer.valueOf(0);
    }
    for (;;)
    {
      Integer localInteger = (Integer)SearchConfigManager.searchEngineOrder.get(paramavuy1.a);
      paramavuy1 = localInteger;
      if (localInteger == null) {
        paramavuy1 = Integer.valueOf(0);
      }
      return Integer.signum(paramavuy2.intValue() - paramavuy1.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avuh
 * JD-Core Version:    0.7.0.1
 */