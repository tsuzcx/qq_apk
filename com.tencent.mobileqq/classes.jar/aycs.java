import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

class aycs
  implements Comparator<ayij>
{
  aycs(aycr paramaycr) {}
  
  public int a(ayij paramayij1, ayij paramayij2)
  {
    int i = paramayij2.a[2] - paramayij1.a[2];
    if (i != 0) {}
    int j;
    do
    {
      return i;
      j = paramayij1.a[0] - paramayij2.a[0];
      i = j;
    } while (j != 0);
    paramayij1 = paramayij1.c.substring(paramayij1.a[0] + paramayij1.a[1]);
    paramayij2 = paramayij2.c.substring(paramayij2.a[0] + paramayij2.a[1]);
    return ChnToSpell.a(paramayij1, 2).compareTo(ChnToSpell.a(paramayij2, 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aycs
 * JD-Core Version:    0.7.0.1
 */