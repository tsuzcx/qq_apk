import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

class ayqg
  implements Comparator<ayjh>
{
  ayqg(ayqf paramayqf) {}
  
  public int a(ayjh paramayjh1, ayjh paramayjh2)
  {
    int i = -1;
    Object localObject = (aubm)this.a.a.getManager(11);
    paramayjh1 = ((aubm)localObject).c(((ayid)paramayjh1).e());
    paramayjh2 = ((aubm)localObject).c(((ayid)paramayjh2).e());
    if ((paramayjh1 == null) || (paramayjh2 == null)) {
      if ((paramayjh1 == null) && (paramayjh2 == null)) {
        i = 0;
      }
    }
    boolean bool2;
    do
    {
      do
      {
        return i;
        if (paramayjh2 == null) {}
        for (i = -1;; i = 1) {
          return i;
        }
        if ((paramayjh1.uin.equals("0")) && (paramayjh2.uin.equals("0"))) {
          break;
        }
        if ((!paramayjh1.uin.equals("0")) && (!paramayjh2.uin.equals("0"))) {
          return 0;
        }
      } while (!paramayjh2.uin.equals("0"));
      return 1;
      if (!paramayjh1.uin.equals("0")) {
        break;
      }
      localObject = (aloz)this.a.a.getManager(51);
      boolean bool1 = ((aloz)localObject).a(paramayjh1.unifiedCode, true);
      bool2 = ((aloz)localObject).a(paramayjh2.unifiedCode, true);
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
 * Qualified Name:     ayqg
 * JD-Core Version:    0.7.0.1
 */