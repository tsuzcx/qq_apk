import com.tencent.mobileqq.search.searchengine.MiniProgramSearchEngine;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class awuw
  implements Comparator<awol>
{
  public awuw(MiniProgramSearchEngine paramMiniProgramSearchEngine) {}
  
  public int a(awol paramawol1, awol paramawol2)
  {
    int i = paramawol2.a[2] - paramawol1.a[2];
    if (i != 0) {}
    int j;
    do
    {
      return i;
      j = paramawol1.a[0] - paramawol2.a[0];
      i = j;
    } while (j != 0);
    paramawol1 = paramawol1.c().substring(paramawol1.a[0] + paramawol1.a[1]);
    paramawol2 = paramawol2.c().substring(paramawol2.a[0] + paramawol2.a[1]);
    return ChnToSpell.a(paramawol1, 2).compareTo(ChnToSpell.a(paramawol2, 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awuw
 * JD-Core Version:    0.7.0.1
 */