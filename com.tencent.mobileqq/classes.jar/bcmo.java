import com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine;
import java.util.Comparator;

public final class bcmo
  implements Comparator<bcgv>
{
  public int a(bcgv parambcgv1, bcgv parambcgv2)
  {
    int j = Long.signum(parambcgv2.b() - parambcgv1.b());
    int i = j;
    if (j == 0) {
      i = PublicAccountSearchEngine.a(parambcgv1, parambcgv2);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcmo
 * JD-Core Version:    0.7.0.1
 */