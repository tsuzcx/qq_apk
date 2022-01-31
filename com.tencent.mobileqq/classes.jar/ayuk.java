import com.tencent.mobileqq.search.searchengine.MiniProgramSearchEngine;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class ayuk
  implements Comparator<aynz>
{
  public ayuk(MiniProgramSearchEngine paramMiniProgramSearchEngine) {}
  
  public int a(aynz paramaynz1, aynz paramaynz2)
  {
    int i = paramaynz2.a[2] - paramaynz1.a[2];
    if (i != 0) {}
    int j;
    do
    {
      return i;
      j = paramaynz1.a[0] - paramaynz2.a[0];
      i = j;
    } while (j != 0);
    paramaynz1 = paramaynz1.c().substring(paramaynz1.a[0] + paramaynz1.a[1]);
    paramaynz2 = paramaynz2.c().substring(paramaynz2.a[0] + paramaynz2.a[1]);
    return ChnToSpell.a(paramaynz1, 2).compareTo(ChnToSpell.a(paramaynz2, 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayuk
 * JD-Core Version:    0.7.0.1
 */