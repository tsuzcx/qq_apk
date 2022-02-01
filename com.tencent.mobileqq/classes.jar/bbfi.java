import com.tencent.mobileqq.search.searchengine.MiniProgramSearchEngine;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class bbfi
  implements Comparator<bayy>
{
  public bbfi(MiniProgramSearchEngine paramMiniProgramSearchEngine) {}
  
  public int a(bayy parambayy1, bayy parambayy2)
  {
    int i = parambayy2.a[2] - parambayy1.a[2];
    if (i != 0) {}
    int j;
    do
    {
      return i;
      j = parambayy1.a[0] - parambayy2.a[0];
      i = j;
    } while (j != 0);
    parambayy1 = parambayy1.c().substring(parambayy1.a[0] + parambayy1.a[1]);
    parambayy2 = parambayy2.c().substring(parambayy2.a[0] + parambayy2.a[1]);
    return ChnToSpell.a(parambayy1, 2).compareTo(ChnToSpell.a(parambayy2, 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbfi
 * JD-Core Version:    0.7.0.1
 */