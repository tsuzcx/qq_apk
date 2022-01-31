import com.tencent.mobileqq.search.mostused.MostUsedSearch;
import java.util.Comparator;

final class aypi
  implements Comparator<MostUsedSearch>
{
  public int a(MostUsedSearch paramMostUsedSearch1, MostUsedSearch paramMostUsedSearch2)
  {
    return Long.signum(paramMostUsedSearch2.latestUsedTime - paramMostUsedSearch1.latestUsedTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aypi
 * JD-Core Version:    0.7.0.1
 */