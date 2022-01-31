import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

class avht
  implements Comparator<avnl>
{
  avht(avhs paramavhs) {}
  
  public int a(avnl paramavnl1, avnl paramavnl2)
  {
    int i = paramavnl2.a[2] - paramavnl1.a[2];
    if (i != 0) {}
    int j;
    do
    {
      return i;
      j = paramavnl1.a[0] - paramavnl2.a[0];
      i = j;
    } while (j != 0);
    paramavnl1 = paramavnl1.c.substring(paramavnl1.a[0] + paramavnl1.a[1]);
    paramavnl2 = paramavnl2.c.substring(paramavnl2.a[0] + paramavnl2.a[1]);
    return ChnToSpell.a(paramavnl1, 2).compareTo(ChnToSpell.a(paramavnl2, 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avht
 * JD-Core Version:    0.7.0.1
 */