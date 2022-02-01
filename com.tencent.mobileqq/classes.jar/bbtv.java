import com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine;
import java.util.Comparator;

public final class bbtv
  implements Comparator<bboc>
{
  public int a(bboc parambboc1, bboc parambboc2)
  {
    int j = Long.signum(parambboc2.b() - parambboc1.b());
    int i = j;
    if (j == 0) {
      i = PublicAccountSearchEngine.a(parambboc1, parambboc2);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbtv
 * JD-Core Version:    0.7.0.1
 */