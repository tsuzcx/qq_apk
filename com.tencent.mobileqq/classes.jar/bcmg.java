import com.tencent.mobileqq.search.searchengine.MiniProgramSearchEngine;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class bcmg
  implements Comparator<bcfw>
{
  public bcmg(MiniProgramSearchEngine paramMiniProgramSearchEngine) {}
  
  public int a(bcfw parambcfw1, bcfw parambcfw2)
  {
    int i = parambcfw2.a[2] - parambcfw1.a[2];
    if (i != 0) {}
    int j;
    do
    {
      return i;
      j = parambcfw1.a[0] - parambcfw2.a[0];
      i = j;
    } while (j != 0);
    parambcfw1 = parambcfw1.c().substring(parambcfw1.a[0] + parambcfw1.a[1]);
    parambcfw2 = parambcfw2.c().substring(parambcfw2.a[0] + parambcfw2.a[1]);
    return ChnToSpell.a(parambcfw1, 2).compareTo(ChnToSpell.a(parambcfw2, 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcmg
 * JD-Core Version:    0.7.0.1
 */