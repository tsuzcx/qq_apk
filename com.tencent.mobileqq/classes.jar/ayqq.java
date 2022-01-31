import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Comparator;

class ayqq
  implements Comparator<ayjh>
{
  ayqq(ayqp paramayqp) {}
  
  public int a(ayjh paramayjh1, ayjh paramayjh2)
  {
    int i = -1;
    paramayjh1 = (aykv)paramayjh1;
    paramayjh2 = (aykv)paramayjh2;
    aloz localaloz = (aloz)this.a.a.getManager(51);
    boolean bool1 = localaloz.b((String)paramayjh1.a());
    boolean bool2 = localaloz.b((String)paramayjh2.a());
    if ((!bool1) && (!bool2))
    {
      bool1 = localaloz.d((String)paramayjh1.a());
      bool2 = localaloz.d((String)paramayjh2.a());
      if ((!bool1) && (!bool2)) {
        return paramayjh2.f() - paramayjh1.f();
      }
      if (bool1 != bool2)
      {
        if (bool2) {
          return -1;
        }
        return 1;
      }
      return paramayjh2.f() - paramayjh1.f();
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
    return paramayjh2.f() - paramayjh1.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayqq
 * JD-Core Version:    0.7.0.1
 */