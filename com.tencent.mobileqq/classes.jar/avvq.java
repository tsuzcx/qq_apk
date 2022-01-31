import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Comparator;

class avvq
  implements Comparator<avoj>
{
  avvq(avvp paramavvp) {}
  
  public int a(avoj paramavoj1, avoj paramavoj2)
  {
    int i = -1;
    paramavoj1 = (avpx)paramavoj1;
    paramavoj2 = (avpx)paramavoj2;
    ajjj localajjj = (ajjj)this.a.a.getManager(51);
    boolean bool1 = localajjj.b((String)paramavoj1.a());
    boolean bool2 = localajjj.b((String)paramavoj2.a());
    if ((!bool1) && (!bool2))
    {
      bool1 = localajjj.d((String)paramavoj1.a());
      bool2 = localajjj.d((String)paramavoj2.a());
      if ((!bool1) && (!bool2)) {
        return paramavoj2.f() - paramavoj1.f();
      }
      if (bool1 != bool2)
      {
        if (bool2) {
          return -1;
        }
        return 1;
      }
      return paramavoj2.f() - paramavoj1.f();
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
    return paramavoj2.f() - paramavoj1.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avvq
 * JD-Core Version:    0.7.0.1
 */