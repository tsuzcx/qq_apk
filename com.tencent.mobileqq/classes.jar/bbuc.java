import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Comparator;

class bbuc
  implements Comparator<bbmu>
{
  bbuc(bbub parambbub) {}
  
  public int a(bbmu parambbmu1, bbmu parambbmu2)
  {
    int i = -1;
    parambbmu1 = (bboi)parambbmu1;
    parambbmu2 = (bboi)parambbmu2;
    anmw localanmw = (anmw)this.a.a.getManager(51);
    boolean bool1 = localanmw.b((String)parambbmu1.a());
    boolean bool2 = localanmw.b((String)parambbmu2.a());
    if ((!bool1) && (!bool2))
    {
      bool1 = localanmw.d((String)parambbmu1.a());
      bool2 = localanmw.d((String)parambbmu2.a());
      if ((!bool1) && (!bool2)) {
        return parambbmu2.f() - parambbmu1.f();
      }
      if (bool1 != bool2)
      {
        if (bool2) {
          return -1;
        }
        return 1;
      }
      return parambbmu2.f() - parambbmu1.f();
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
    return parambbmu2.f() - parambbmu1.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbuc
 * JD-Core Version:    0.7.0.1
 */