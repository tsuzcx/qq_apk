import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

class bbfn
  implements Comparator<bayp>
{
  bbfn(bbfm parambbfm) {}
  
  public int a(bayp parambayp1, bayp parambayp2)
  {
    int i = -1;
    Object localObject = (avsy)this.a.a.getManager(11);
    parambayp1 = ((avsy)localObject).c(((baxl)parambayp1).e());
    parambayp2 = ((avsy)localObject).c(((baxl)parambayp2).e());
    if ((parambayp1 == null) || (parambayp2 == null)) {
      if ((parambayp1 == null) && (parambayp2 == null)) {
        i = 0;
      }
    }
    boolean bool2;
    do
    {
      do
      {
        return i;
        if (parambayp2 == null) {}
        for (i = -1;; i = 1) {
          return i;
        }
        if ((parambayp1.uin.equals("0")) && (parambayp2.uin.equals("0"))) {
          break;
        }
        if ((!parambayp1.uin.equals("0")) && (!parambayp2.uin.equals("0"))) {
          return 0;
        }
      } while (!parambayp2.uin.equals("0"));
      return 1;
      if (!parambayp1.uin.equals("0")) {
        break;
      }
      localObject = (amsw)this.a.a.getManager(51);
      boolean bool1 = ((amsw)localObject).a(parambayp1.unifiedCode, true);
      bool2 = ((amsw)localObject).a(parambayp2.unifiedCode, true);
      if ((!bool1) && (!bool2)) {
        break;
      }
      if ((bool1) && (bool2)) {
        return 0;
      }
    } while (bool2);
    return 1;
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbfn
 * JD-Core Version:    0.7.0.1
 */