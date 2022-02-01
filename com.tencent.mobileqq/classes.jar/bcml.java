import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

class bcml
  implements Comparator<bcfn>
{
  bcml(bcmk parambcmk) {}
  
  public int a(bcfn parambcfn1, bcfn parambcfn2)
  {
    int i = -1;
    Object localObject = (axfr)this.a.a.getManager(11);
    parambcfn1 = ((axfr)localObject).c(((bcej)parambcfn1).e());
    parambcfn2 = ((axfr)localObject).c(((bcej)parambcfn2).e());
    if ((parambcfn1 == null) || (parambcfn2 == null)) {
      if ((parambcfn1 == null) && (parambcfn2 == null)) {
        i = 0;
      }
    }
    boolean bool2;
    do
    {
      do
      {
        return i;
        if (parambcfn2 == null) {}
        for (i = -1;; i = 1) {
          return i;
        }
        if ((parambcfn1.uin.equals("0")) && (parambcfn2.uin.equals("0"))) {
          break;
        }
        if ((!parambcfn1.uin.equals("0")) && (!parambcfn2.uin.equals("0"))) {
          return 0;
        }
      } while (!parambcfn2.uin.equals("0"));
      return 1;
      if (!parambcfn1.uin.equals("0")) {
        break;
      }
      localObject = (anyw)this.a.a.getManager(51);
      boolean bool1 = ((anyw)localObject).a(parambcfn1.unifiedCode, true);
      bool2 = ((anyw)localObject).a(parambcfn2.unifiedCode, true);
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
 * Qualified Name:     bcml
 * JD-Core Version:    0.7.0.1
 */