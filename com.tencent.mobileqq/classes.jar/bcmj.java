import com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine;
import java.util.Comparator;

public final class bcmj
  implements Comparator<bcgn>
{
  public int a(bcgn parambcgn1, bcgn parambcgn2)
  {
    int j = Long.signum(parambcgn2.b() - parambcgn1.b());
    int i = j;
    if (j == 0) {
      i = Long.signum(parambcgn2.a() - parambcgn1.a());
    }
    j = i;
    if (i == 0) {
      j = PublicAccountSearchEngine.a(parambcgn1, parambcgn2);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcmj
 * JD-Core Version:    0.7.0.1
 */