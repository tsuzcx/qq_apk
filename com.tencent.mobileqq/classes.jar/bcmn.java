import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import java.util.Comparator;

class bcmn
  implements Comparator<bcff>
{
  bcmn(bcmm parambcmm) {}
  
  public int a(bcff parambcff1, bcff parambcff2)
  {
    int i = -1;
    parambcff1 = (bcgt)parambcff1;
    parambcff2 = (bcgt)parambcff2;
    anvk localanvk = (anvk)this.a.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
    boolean bool1 = localanvk.b((String)parambcff1.a());
    boolean bool2 = localanvk.b((String)parambcff2.a());
    if ((!bool1) && (!bool2))
    {
      bool1 = localanvk.d((String)parambcff1.a());
      bool2 = localanvk.d((String)parambcff2.a());
      if ((!bool1) && (!bool2)) {
        return parambcff2.f() - parambcff1.f();
      }
      if (bool1 != bool2)
      {
        if (bool2) {
          return -1;
        }
        return 1;
      }
      return parambcff2.f() - parambcff1.f();
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
    return parambcff2.f() - parambcff1.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcmn
 * JD-Core Version:    0.7.0.1
 */