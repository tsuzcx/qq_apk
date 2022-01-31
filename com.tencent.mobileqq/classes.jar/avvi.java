import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

class avvi
  implements Comparator<avoj>
{
  avvi(avvh paramavvh) {}
  
  public int a(avoj paramavoj1, avoj paramavoj2)
  {
    int i = -1;
    Object localObject = (aroh)this.a.a.getManager(11);
    paramavoj1 = ((aroh)localObject).c(((avnf)paramavoj1).e());
    paramavoj2 = ((aroh)localObject).c(((avnf)paramavoj2).e());
    if ((paramavoj1 == null) || (paramavoj2 == null)) {
      if ((paramavoj1 == null) && (paramavoj2 == null)) {
        i = 0;
      }
    }
    boolean bool2;
    do
    {
      do
      {
        return i;
        if (paramavoj2 == null) {}
        for (i = -1;; i = 1) {
          return i;
        }
        if ((paramavoj1.uin.equals("0")) && (paramavoj2.uin.equals("0"))) {
          break;
        }
        if ((!paramavoj1.uin.equals("0")) && (!paramavoj2.uin.equals("0"))) {
          return 0;
        }
      } while (!paramavoj2.uin.equals("0"));
      return 1;
      if (!paramavoj1.uin.equals("0")) {
        break;
      }
      localObject = (ajjj)this.a.a.getManager(51);
      boolean bool1 = ((ajjj)localObject).a(paramavoj1.unifiedCode, true);
      bool2 = ((ajjj)localObject).a(paramavoj2.unifiedCode, true);
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
 * Qualified Name:     avvi
 * JD-Core Version:    0.7.0.1
 */