import com.tencent.mobileqq.search.searchengine.MiniProgramSearchEngine;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class avvd
  implements Comparator<avos>
{
  public avvd(MiniProgramSearchEngine paramMiniProgramSearchEngine) {}
  
  public int a(avos paramavos1, avos paramavos2)
  {
    int i = paramavos2.a[2] - paramavos1.a[2];
    if (i != 0) {}
    int j;
    do
    {
      return i;
      j = paramavos1.a[0] - paramavos2.a[0];
      i = j;
    } while (j != 0);
    paramavos1 = paramavos1.c().substring(paramavos1.a[0] + paramavos1.a[1]);
    paramavos2 = paramavos2.c().substring(paramavos2.a[0] + paramavos2.a[1]);
    return ChnToSpell.a(paramavos1, 2).compareTo(ChnToSpell.a(paramavos2, 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avvd
 * JD-Core Version:    0.7.0.1
 */