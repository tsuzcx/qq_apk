import com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine;
import java.util.Comparator;

public final class bcmp
  implements Comparator<bcgv>
{
  public int a(bcgv parambcgv1, bcgv parambcgv2)
  {
    int j = Long.signum(parambcgv2.b() - parambcgv1.b());
    int i = j;
    if (j == 0) {
      i = Long.signum(parambcgv2.a() - parambcgv1.a());
    }
    j = i;
    if (i == 0) {
      j = PublicAccountSearchEngine.a(parambcgv1, parambcgv2);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcmp
 * JD-Core Version:    0.7.0.1
 */