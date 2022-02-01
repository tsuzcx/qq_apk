import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Comparator;

class bcmv
  implements Comparator<bcfn>
{
  bcmv(bcmu parambcmu) {}
  
  public int a(bcfn parambcfn1, bcfn parambcfn2)
  {
    int i = -1;
    parambcfn1 = (bchb)parambcfn1;
    parambcfn2 = (bchb)parambcfn2;
    anyw localanyw = (anyw)this.a.a.getManager(51);
    boolean bool1 = localanyw.b((String)parambcfn1.a());
    boolean bool2 = localanyw.b((String)parambcfn2.a());
    if ((!bool1) && (!bool2))
    {
      bool1 = localanyw.d((String)parambcfn1.a());
      bool2 = localanyw.d((String)parambcfn2.a());
      if ((!bool1) && (!bool2)) {
        return parambcfn2.f() - parambcfn1.f();
      }
      if (bool1 != bool2)
      {
        if (bool2) {
          return -1;
        }
        return 1;
      }
      return parambcfn2.f() - parambcfn1.f();
    }
    if (bool1 != bool2)
    {
      if (bool2) {}
      for (;;)
      {
        return i;
        i = 1;
      }
    }
    return parambcfn2.f() - parambcfn1.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcmv
 * JD-Core Version:    0.7.0.1
 */