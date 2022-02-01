import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

class bbym
  implements Comparator<bceh>
{
  bbym(bbyl parambbyl) {}
  
  public int a(bceh parambceh1, bceh parambceh2)
  {
    int i = parambceh2.a[2] - parambceh1.a[2];
    if (i != 0) {}
    int j;
    do
    {
      return i;
      j = parambceh1.a[0] - parambceh2.a[0];
      i = j;
    } while (j != 0);
    parambceh1 = parambceh1.c.substring(parambceh1.a[0] + parambceh1.a[1]);
    parambceh2 = parambceh2.c.substring(parambceh2.a[0] + parambceh2.a[1]);
    return ChnToSpell.a(parambceh1, 2).compareTo(ChnToSpell.a(parambceh2, 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbym
 * JD-Core Version:    0.7.0.1
 */