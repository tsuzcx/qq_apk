import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Comparator;

class bbfx
  implements Comparator<bayp>
{
  bbfx(bbfw parambbfw) {}
  
  public int a(bayp parambayp1, bayp parambayp2)
  {
    int i = -1;
    parambayp1 = (bbad)parambayp1;
    parambayp2 = (bbad)parambayp2;
    amsw localamsw = (amsw)this.a.a.getManager(51);
    boolean bool1 = localamsw.b((String)parambayp1.a());
    boolean bool2 = localamsw.b((String)parambayp2.a());
    if ((!bool1) && (!bool2))
    {
      bool1 = localamsw.d((String)parambayp1.a());
      bool2 = localamsw.d((String)parambayp2.a());
      if ((!bool1) && (!bool2)) {
        return parambayp2.f() - parambayp1.f();
      }
      if (bool1 != bool2)
      {
        if (bool2) {
          return -1;
        }
        return 1;
      }
      return parambayp2.f() - parambayp1.f();
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
    return parambayp2.f() - parambayp1.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbfx
 * JD-Core Version:    0.7.0.1
 */