import com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine;
import java.util.Comparator;

public final class awvg
  implements Comparator<awpm>
{
  public int a(awpm paramawpm1, awpm paramawpm2)
  {
    int j = Long.signum(paramawpm2.b() - paramawpm1.b());
    int i = j;
    if (j == 0) {
      i = PublicAccountSearchEngine.a(paramawpm1, paramawpm2);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awvg
 * JD-Core Version:    0.7.0.1
 */