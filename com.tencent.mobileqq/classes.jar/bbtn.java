import com.tencent.mobileqq.search.searchengine.MiniProgramSearchEngine;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class bbtn
  implements Comparator<bbnd>
{
  public bbtn(MiniProgramSearchEngine paramMiniProgramSearchEngine) {}
  
  public int a(bbnd parambbnd1, bbnd parambbnd2)
  {
    int i = parambbnd2.a[2] - parambbnd1.a[2];
    if (i != 0) {}
    int j;
    do
    {
      return i;
      j = parambbnd1.a[0] - parambbnd2.a[0];
      i = j;
    } while (j != 0);
    parambbnd1 = parambbnd1.c().substring(parambbnd1.a[0] + parambbnd1.a[1]);
    parambbnd2 = parambbnd2.c().substring(parambbnd2.a[0] + parambbnd2.a[1]);
    return ChnToSpell.a(parambbnd1, 2).compareTo(ChnToSpell.a(parambbnd2, 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbtn
 * JD-Core Version:    0.7.0.1
 */