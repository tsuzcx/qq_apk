import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

class bbyc
  implements Comparator<bcep>
{
  bbyc(bbyb parambbyb) {}
  
  public int a(bcep parambcep1, bcep parambcep2)
  {
    int i = parambcep2.a[2] - parambcep1.a[2];
    if (i != 0) {}
    int j;
    do
    {
      return i;
      j = parambcep1.a[0] - parambcep2.a[0];
      i = j;
    } while (j != 0);
    parambcep1 = parambcep1.c.substring(parambcep1.a[0] + parambcep1.a[1]);
    parambcep2 = parambcep2.c.substring(parambcep2.a[0] + parambcep2.a[1]);
    return ChnToSpell.a(parambcep1, 2).compareTo(ChnToSpell.a(parambcep2, 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbyc
 * JD-Core Version:    0.7.0.1
 */