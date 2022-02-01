import com.tencent.mobileqq.search.searchengine.MiniProgramSearchEngine;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class bcma
  implements Comparator<bcfo>
{
  public bcma(MiniProgramSearchEngine paramMiniProgramSearchEngine) {}
  
  public int a(bcfo parambcfo1, bcfo parambcfo2)
  {
    int i = parambcfo2.a[2] - parambcfo1.a[2];
    if (i != 0) {}
    int j;
    do
    {
      return i;
      j = parambcfo1.a[0] - parambcfo2.a[0];
      i = j;
    } while (j != 0);
    parambcfo1 = parambcfo1.c().substring(parambcfo1.a[0] + parambcfo1.a[1]);
    parambcfo2 = parambcfo2.c().substring(parambcfo2.a[0] + parambcfo2.a[1]);
    return ChnToSpell.a(parambcfo1, 2).compareTo(ChnToSpell.a(parambcfo2, 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcma
 * JD-Core Version:    0.7.0.1
 */