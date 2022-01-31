import com.tencent.mobileqq.search.searchengine.MiniProgramSearchEngine;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class awuy
  implements Comparator<awon>
{
  public awuy(MiniProgramSearchEngine paramMiniProgramSearchEngine) {}
  
  public int a(awon paramawon1, awon paramawon2)
  {
    int i = paramawon2.a[2] - paramawon1.a[2];
    if (i != 0) {}
    int j;
    do
    {
      return i;
      j = paramawon1.a[0] - paramawon2.a[0];
      i = j;
    } while (j != 0);
    paramawon1 = paramawon1.c().substring(paramawon1.a[0] + paramawon1.a[1]);
    paramawon2 = paramawon2.c().substring(paramawon2.a[0] + paramawon2.a[1]);
    return ChnToSpell.a(paramawon1, 2).compareTo(ChnToSpell.a(paramawon2, 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awuy
 * JD-Core Version:    0.7.0.1
 */