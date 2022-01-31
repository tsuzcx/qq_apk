import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Comparator;

class awvn
  implements Comparator<awoe>
{
  awvn(awvm paramawvm) {}
  
  public int a(awoe paramawoe1, awoe paramawoe2)
  {
    int i = -1;
    paramawoe1 = (awps)paramawoe1;
    paramawoe2 = (awps)paramawoe2;
    ajxl localajxl = (ajxl)this.a.a.getManager(51);
    boolean bool1 = localajxl.b((String)paramawoe1.a());
    boolean bool2 = localajxl.b((String)paramawoe2.a());
    if ((!bool1) && (!bool2))
    {
      bool1 = localajxl.d((String)paramawoe1.a());
      bool2 = localajxl.d((String)paramawoe2.a());
      if ((!bool1) && (!bool2)) {
        return paramawoe2.f() - paramawoe1.f();
      }
      if (bool1 != bool2)
      {
        if (bool2) {
          return -1;
        }
        return 1;
      }
      return paramawoe2.f() - paramawoe1.f();
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
    return paramawoe2.f() - paramawoe1.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awvn
 * JD-Core Version:    0.7.0.1
 */