import com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine;
import java.util.Comparator;

public final class awvh
  implements Comparator<awpm>
{
  public int a(awpm paramawpm1, awpm paramawpm2)
  {
    int j = Long.signum(paramawpm2.b() - paramawpm1.b());
    int i = j;
    if (j == 0) {
      i = Long.signum(paramawpm2.a() - paramawpm1.a());
    }
    j = i;
    if (i == 0) {
      j = PublicAccountSearchEngine.a(paramawpm1, paramawpm2);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awvh
 * JD-Core Version:    0.7.0.1
 */