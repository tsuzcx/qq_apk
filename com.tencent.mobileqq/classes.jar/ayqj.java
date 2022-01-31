import com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine;
import java.util.Comparator;

public final class ayqj
  implements Comparator<aykp>
{
  public int a(aykp paramaykp1, aykp paramaykp2)
  {
    int j = Long.signum(paramaykp2.b() - paramaykp1.b());
    int i = j;
    if (j == 0) {
      i = PublicAccountSearchEngine.a(paramaykp1, paramaykp2);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayqj
 * JD-Core Version:    0.7.0.1
 */