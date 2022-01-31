import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Comparator;

class awvl
  implements Comparator<awoc>
{
  awvl(awvk paramawvk) {}
  
  public int a(awoc paramawoc1, awoc paramawoc2)
  {
    int i = -1;
    paramawoc1 = (awpq)paramawoc1;
    paramawoc2 = (awpq)paramawoc2;
    ajxn localajxn = (ajxn)this.a.a.getManager(51);
    boolean bool1 = localajxn.b((String)paramawoc1.a());
    boolean bool2 = localajxn.b((String)paramawoc2.a());
    if ((!bool1) && (!bool2))
    {
      bool1 = localajxn.d((String)paramawoc1.a());
      bool2 = localajxn.d((String)paramawoc2.a());
      if ((!bool1) && (!bool2)) {
        return paramawoc2.f() - paramawoc1.f();
      }
      if (bool1 != bool2)
      {
        if (bool2) {
          return -1;
        }
        return 1;
      }
      return paramawoc2.f() - paramawoc1.f();
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
    return paramawoc2.f() - paramawoc1.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awvl
 * JD-Core Version:    0.7.0.1
 */