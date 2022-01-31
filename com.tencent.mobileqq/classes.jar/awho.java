import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

class awho
  implements Comparator<awng>
{
  awho(awhn paramawhn) {}
  
  public int a(awng paramawng1, awng paramawng2)
  {
    int i = paramawng2.a[2] - paramawng1.a[2];
    if (i != 0) {}
    int j;
    do
    {
      return i;
      j = paramawng1.a[0] - paramawng2.a[0];
      i = j;
    } while (j != 0);
    paramawng1 = paramawng1.c.substring(paramawng1.a[0] + paramawng1.a[1]);
    paramawng2 = paramawng2.c.substring(paramawng2.a[0] + paramawng2.a[1]);
    return ChnToSpell.a(paramawng1, 2).compareTo(ChnToSpell.a(paramawng2, 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awho
 * JD-Core Version:    0.7.0.1
 */