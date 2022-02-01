import com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine;
import java.util.Comparator;

public final class bcmi
  implements Comparator<bcgn>
{
  public int a(bcgn parambcgn1, bcgn parambcgn2)
  {
    int j = Long.signum(parambcgn2.b() - parambcgn1.b());
    int i = j;
    if (j == 0) {
      i = PublicAccountSearchEngine.a(parambcgn1, parambcgn2);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcmi
 * JD-Core Version:    0.7.0.1
 */