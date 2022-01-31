import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

class ayup
  implements Comparator<aynq>
{
  ayup(ayuo paramayuo) {}
  
  public int a(aynq paramaynq1, aynq paramaynq2)
  {
    int i = -1;
    Object localObject = (aufv)this.a.a.getManager(11);
    paramaynq1 = ((aufv)localObject).c(((aymm)paramaynq1).e());
    paramaynq2 = ((aufv)localObject).c(((aymm)paramaynq2).e());
    if ((paramaynq1 == null) || (paramaynq2 == null)) {
      if ((paramaynq1 == null) && (paramaynq2 == null)) {
        i = 0;
      }
    }
    boolean bool2;
    do
    {
      do
      {
        return i;
        if (paramaynq2 == null) {}
        for (i = -1;; i = 1) {
          return i;
        }
        if ((paramaynq1.uin.equals("0")) && (paramaynq2.uin.equals("0"))) {
          break;
        }
        if ((!paramaynq1.uin.equals("0")) && (!paramaynq2.uin.equals("0"))) {
          return 0;
        }
      } while (!paramaynq2.uin.equals("0"));
      return 1;
      if (!paramaynq1.uin.equals("0")) {
        break;
      }
      localObject = (alto)this.a.a.getManager(51);
      boolean bool1 = ((alto)localObject).a(paramaynq1.unifiedCode, true);
      bool2 = ((alto)localObject).a(paramaynq2.unifiedCode, true);
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
 * Qualified Name:     ayup
 * JD-Core Version:    0.7.0.1
 */