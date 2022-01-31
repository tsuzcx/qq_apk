import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

class ayct
  implements Comparator<ayij>
{
  ayct(aycr paramaycr) {}
  
  public int a(ayij paramayij1, ayij paramayij2)
  {
    paramayij1 = paramayij1.c;
    paramayij2 = paramayij2.c;
    return ChnToSpell.a(paramayij1, 2).compareTo(ChnToSpell.a(paramayij2, 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayct
 * JD-Core Version:    0.7.0.1
 */