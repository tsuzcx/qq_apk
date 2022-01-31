import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

final class avvk
  implements Comparator<avoj>
{
  private final ajjj jdField_a_of_type_Ajjj;
  private final aroh jdField_a_of_type_Aroh;
  
  avvk(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Aroh = ((aroh)paramQQAppInterface.getManager(11));
    this.jdField_a_of_type_Ajjj = ((ajjj)paramQQAppInterface.getManager(51));
  }
  
  public int a(avoj paramavoj1, avoj paramavoj2)
  {
    int i = -1;
    paramavoj1 = this.jdField_a_of_type_Aroh.c(((avnf)paramavoj1).e());
    paramavoj2 = this.jdField_a_of_type_Aroh.c(((avnf)paramavoj2).e());
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
        do
        {
          do
          {
            return i;
          } while (paramavoj2 == null);
          return 1;
          if ((paramavoj1.uin.equals("0")) && (paramavoj2.uin.equals("0"))) {
            break;
          }
          if ((!paramavoj1.uin.equals("0")) && (!paramavoj2.uin.equals("0"))) {
            return 0;
          }
        } while (!paramavoj2.uin.equals("0"));
        return 1;
        bool1 = this.jdField_a_of_type_Ajjj.a(paramavoj1.unifiedCode, true);
        bool2 = this.jdField_a_of_type_Ajjj.a(paramavoj2.unifiedCode, true);
        if ((!bool1) && (!bool2)) {
          break;
        }
        if ((bool1) && (bool2)) {
          return 0;
        }
      } while (bool2);
      return 1;
      boolean bool1 = TextUtils.isEmpty(paramavoj1.pinyinFirst);
      bool2 = TextUtils.isEmpty(paramavoj2.pinyinFirst);
      if ((!bool1) && (!bool2)) {
        break;
      }
      if ((bool1) && (bool2)) {
        return 0;
      }
    } while (bool2);
    return 1;
    return paramavoj1.pinyinFirst.toLowerCase().charAt(0) - paramavoj2.pinyinFirst.toLowerCase().charAt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avvk
 * JD-Core Version:    0.7.0.1
 */