import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

class bbts
  implements Comparator<bbmu>
{
  bbts(bbtr parambbtr) {}
  
  public int a(bbmu parambbmu1, bbmu parambbmu2)
  {
    int i = -1;
    Object localObject = (awmz)this.a.a.getManager(11);
    parambbmu1 = ((awmz)localObject).c(((bblq)parambbmu1).e());
    parambbmu2 = ((awmz)localObject).c(((bblq)parambbmu2).e());
    if ((parambbmu1 == null) || (parambbmu2 == null)) {
      if ((parambbmu1 == null) && (parambbmu2 == null)) {
        i = 0;
      }
    }
    boolean bool2;
    do
    {
      do
      {
        return i;
        if (parambbmu2 == null) {}
        for (i = -1;; i = 1) {
          return i;
        }
        if ((parambbmu1.uin.equals("0")) && (parambbmu2.uin.equals("0"))) {
          break;
        }
        if ((!parambbmu1.uin.equals("0")) && (!parambbmu2.uin.equals("0"))) {
          return 0;
        }
      } while (!parambbmu2.uin.equals("0"));
      return 1;
      if (!parambbmu1.uin.equals("0")) {
        break;
      }
      localObject = (anmw)this.a.a.getManager(51);
      boolean bool1 = ((anmw)localObject).a(parambbmu1.unifiedCode, true);
      bool2 = ((anmw)localObject).a(parambbmu2.unifiedCode, true);
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
 * Qualified Name:     bbts
 * JD-Core Version:    0.7.0.1
 */