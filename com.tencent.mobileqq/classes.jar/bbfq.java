import com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine;
import java.util.Comparator;

public final class bbfq
  implements Comparator<bazx>
{
  public int a(bazx parambazx1, bazx parambazx2)
  {
    int j = Long.signum(parambazx2.b() - parambazx1.b());
    int i = j;
    if (j == 0) {
      i = PublicAccountSearchEngine.a(parambazx1, parambazx2);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbfq
 * JD-Core Version:    0.7.0.1
 */