import com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine;
import java.util.Comparator;

public final class awvf
  implements Comparator<awpk>
{
  public int a(awpk paramawpk1, awpk paramawpk2)
  {
    int j = Long.signum(paramawpk2.b() - paramawpk1.b());
    int i = j;
    if (j == 0) {
      i = Long.signum(paramawpk2.a() - paramawpk1.a());
    }
    j = i;
    if (i == 0) {
      j = PublicAccountSearchEngine.a(paramawpk1, paramawpk2);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awvf
 * JD-Core Version:    0.7.0.1
 */