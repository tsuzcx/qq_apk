import com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine;
import java.util.Comparator;

public final class avvl
  implements Comparator<avpr>
{
  public int a(avpr paramavpr1, avpr paramavpr2)
  {
    int j = Long.signum(paramavpr2.b() - paramavpr1.b());
    int i = j;
    if (j == 0) {
      i = PublicAccountSearchEngine.a(paramavpr1, paramavpr2);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avvl
 * JD-Core Version:    0.7.0.1
 */