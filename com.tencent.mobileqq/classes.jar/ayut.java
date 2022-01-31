import com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine;
import java.util.Comparator;

public final class ayut
  implements Comparator<ayoy>
{
  public int a(ayoy paramayoy1, ayoy paramayoy2)
  {
    int j = Long.signum(paramayoy2.b() - paramayoy1.b());
    int i = j;
    if (j == 0) {
      i = Long.signum(paramayoy2.a() - paramayoy1.a());
    }
    j = i;
    if (i == 0) {
      j = PublicAccountSearchEngine.a(paramayoy1, paramayoy2);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayut
 * JD-Core Version:    0.7.0.1
 */