import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

class awvd
  implements Comparator<awoe>
{
  awvd(awvc paramawvc) {}
  
  public int a(awoe paramawoe1, awoe paramawoe2)
  {
    int i = -1;
    Object localObject = (askn)this.a.a.getManager(11);
    paramawoe1 = ((askn)localObject).c(((awna)paramawoe1).e());
    paramawoe2 = ((askn)localObject).c(((awna)paramawoe2).e());
    if ((paramawoe1 == null) || (paramawoe2 == null)) {
      if ((paramawoe1 == null) && (paramawoe2 == null)) {
        i = 0;
      }
    }
    boolean bool2;
    do
    {
      do
      {
        return i;
        if (paramawoe2 == null) {}
        for (i = -1;; i = 1) {
          return i;
        }
        if ((paramawoe1.uin.equals("0")) && (paramawoe2.uin.equals("0"))) {
          break;
        }
        if ((!paramawoe1.uin.equals("0")) && (!paramawoe2.uin.equals("0"))) {
          return 0;
        }
      } while (!paramawoe2.uin.equals("0"));
      return 1;
      if (!paramawoe1.uin.equals("0")) {
        break;
      }
      localObject = (ajxl)this.a.a.getManager(51);
      boolean bool1 = ((ajxl)localObject).a(paramawoe1.unifiedCode, true);
      bool2 = ((ajxl)localObject).a(paramawoe2.unifiedCode, true);
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
 * Qualified Name:     awvd
 * JD-Core Version:    0.7.0.1
 */