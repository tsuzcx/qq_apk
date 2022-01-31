import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

class awvb
  implements Comparator<awoc>
{
  awvb(awva paramawva) {}
  
  public int a(awoc paramawoc1, awoc paramawoc2)
  {
    int i = -1;
    Object localObject = (askl)this.a.a.getManager(11);
    paramawoc1 = ((askl)localObject).c(((awmy)paramawoc1).e());
    paramawoc2 = ((askl)localObject).c(((awmy)paramawoc2).e());
    if ((paramawoc1 == null) || (paramawoc2 == null)) {
      if ((paramawoc1 == null) && (paramawoc2 == null)) {
        i = 0;
      }
    }
    boolean bool2;
    do
    {
      do
      {
        return i;
        if (paramawoc2 == null) {}
        for (i = -1;; i = 1) {
          return i;
        }
        if ((paramawoc1.uin.equals("0")) && (paramawoc2.uin.equals("0"))) {
          break;
        }
        if ((!paramawoc1.uin.equals("0")) && (!paramawoc2.uin.equals("0"))) {
          return 0;
        }
      } while (!paramawoc2.uin.equals("0"));
      return 1;
      if (!paramawoc1.uin.equals("0")) {
        break;
      }
      localObject = (ajxn)this.a.a.getManager(51);
      boolean bool1 = ((ajxn)localObject).a(paramawoc1.unifiedCode, true);
      bool2 = ((ajxn)localObject).a(paramawoc2.unifiedCode, true);
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
 * Qualified Name:     awvb
 * JD-Core Version:    0.7.0.1
 */