import com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine;
import java.util.Comparator;

public final class ayus
  implements Comparator<ayoy>
{
  public int a(ayoy paramayoy1, ayoy paramayoy2)
  {
    int j = Long.signum(paramayoy2.b() - paramayoy1.b());
    int i = j;
    if (j == 0) {
      i = PublicAccountSearchEngine.a(paramayoy1, paramayoy2);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayus
 * JD-Core Version:    0.7.0.1
 */