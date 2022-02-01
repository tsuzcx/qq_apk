import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

class bcmf
  implements Comparator<bcff>
{
  bcmf(bcme parambcme) {}
  
  public int a(bcff parambcff1, bcff parambcff2)
  {
    int i = -1;
    Object localObject = (awyz)this.a.a.getManager(QQManagerFactory.CONTACT_MANAGER);
    parambcff1 = ((awyz)localObject).c(((bceb)parambcff1).e());
    parambcff2 = ((awyz)localObject).c(((bceb)parambcff2).e());
    if ((parambcff1 == null) || (parambcff2 == null)) {
      if ((parambcff1 == null) && (parambcff2 == null)) {
        i = 0;
      }
    }
    boolean bool2;
    do
    {
      do
      {
        return i;
        if (parambcff2 == null) {}
        for (i = -1;; i = 1) {
          return i;
        }
        if ((parambcff1.uin.equals("0")) && (parambcff2.uin.equals("0"))) {
          break;
        }
        if ((!parambcff1.uin.equals("0")) && (!parambcff2.uin.equals("0"))) {
          return 0;
        }
      } while (!parambcff2.uin.equals("0"));
      return 1;
      if (!parambcff1.uin.equals("0")) {
        break;
      }
      localObject = (anvk)this.a.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
      boolean bool1 = ((anvk)localObject).a(parambcff1.unifiedCode, true);
      bool2 = ((anvk)localObject).a(parambcff2.unifiedCode, true);
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
 * Qualified Name:     bcmf
 * JD-Core Version:    0.7.0.1
 */