import com.tencent.mobileqq.search.searchengine.MiniProgramSearchEngine;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class ayqb
  implements Comparator<ayjq>
{
  public ayqb(MiniProgramSearchEngine paramMiniProgramSearchEngine) {}
  
  public int a(ayjq paramayjq1, ayjq paramayjq2)
  {
    int i = paramayjq2.a[2] - paramayjq1.a[2];
    if (i != 0) {}
    int j;
    do
    {
      return i;
      j = paramayjq1.a[0] - paramayjq2.a[0];
      i = j;
    } while (j != 0);
    paramayjq1 = paramayjq1.c().substring(paramayjq1.a[0] + paramayjq1.a[1]);
    paramayjq2 = paramayjq2.c().substring(paramayjq2.a[0] + paramayjq2.a[1]);
    return ChnToSpell.a(paramayjq1, 2).compareTo(ChnToSpell.a(paramayjq2, 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayqb
 * JD-Core Version:    0.7.0.1
 */