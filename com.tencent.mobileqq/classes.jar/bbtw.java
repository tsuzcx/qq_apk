import com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine;
import java.util.Comparator;

public final class bbtw
  implements Comparator<bboc>
{
  public int a(bboc parambboc1, bboc parambboc2)
  {
    int j = Long.signum(parambboc2.b() - parambboc1.b());
    int i = j;
    if (j == 0) {
      i = Long.signum(parambboc2.a() - parambboc1.a());
    }
    j = i;
    if (i == 0) {
      j = PublicAccountSearchEngine.a(parambboc1, parambboc2);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbtw
 * JD-Core Version:    0.7.0.1
 */