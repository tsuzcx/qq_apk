import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

class ayhb
  implements Comparator<ayms>
{
  ayhb(ayha paramayha) {}
  
  public int a(ayms paramayms1, ayms paramayms2)
  {
    int i = paramayms2.a[2] - paramayms1.a[2];
    if (i != 0) {}
    int j;
    do
    {
      return i;
      j = paramayms1.a[0] - paramayms2.a[0];
      i = j;
    } while (j != 0);
    paramayms1 = paramayms1.c.substring(paramayms1.a[0] + paramayms1.a[1]);
    paramayms2 = paramayms2.c.substring(paramayms2.a[0] + paramayms2.a[1]);
    return ChnToSpell.a(paramayms1, 2).compareTo(ChnToSpell.a(paramayms2, 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayhb
 * JD-Core Version:    0.7.0.1
 */