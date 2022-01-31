import com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine;
import java.util.Comparator;

public final class avvm
  implements Comparator<avpr>
{
  public int a(avpr paramavpr1, avpr paramavpr2)
  {
    int j = Long.signum(paramavpr2.b() - paramavpr1.b());
    int i = j;
    if (j == 0) {
      i = Long.signum(paramavpr2.a() - paramavpr1.a());
    }
    j = i;
    if (i == 0) {
      j = PublicAccountSearchEngine.a(paramavpr1, paramavpr2);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avvm
 * JD-Core Version:    0.7.0.1
 */