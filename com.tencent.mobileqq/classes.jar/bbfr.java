import com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine;
import java.util.Comparator;

public final class bbfr
  implements Comparator<bazx>
{
  public int a(bazx parambazx1, bazx parambazx2)
  {
    int j = Long.signum(parambazx2.b() - parambazx1.b());
    int i = j;
    if (j == 0) {
      i = Long.signum(parambazx2.a() - parambazx1.a());
    }
    j = i;
    if (i == 0) {
      j = PublicAccountSearchEngine.a(parambazx1, parambazx2);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbfr
 * JD-Core Version:    0.7.0.1
 */