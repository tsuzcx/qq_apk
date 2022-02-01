import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

final class bcmh
  implements Comparator<bcff>
{
  private final anvk jdField_a_of_type_Anvk;
  private final awyz jdField_a_of_type_Awyz;
  
  bcmh(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Awyz = ((awyz)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER));
    this.jdField_a_of_type_Anvk = ((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
  }
  
  public int a(bcff parambcff1, bcff parambcff2)
  {
    int i = -1;
    parambcff1 = this.jdField_a_of_type_Awyz.c(((bceb)parambcff1).e());
    parambcff2 = this.jdField_a_of_type_Awyz.c(((bceb)parambcff2).e());
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
        do
        {
          do
          {
            return i;
          } while (parambcff2 == null);
          return 1;
          if ((parambcff1.uin.equals("0")) && (parambcff2.uin.equals("0"))) {
            break;
          }
          if ((!parambcff1.uin.equals("0")) && (!parambcff2.uin.equals("0"))) {
            return 0;
          }
        } while (!parambcff2.uin.equals("0"));
        return 1;
        bool1 = this.jdField_a_of_type_Anvk.a(parambcff1.unifiedCode, true);
        bool2 = this.jdField_a_of_type_Anvk.a(parambcff2.unifiedCode, true);
        if ((!bool1) && (!bool2)) {
          break;
        }
        if ((bool1) && (bool2)) {
          return 0;
        }
      } while (bool2);
      return 1;
      boolean bool1 = TextUtils.isEmpty(parambcff1.pinyinFirst);
      bool2 = TextUtils.isEmpty(parambcff2.pinyinFirst);
      if ((!bool1) && (!bool2)) {
        break;
      }
      if ((bool1) && (bool2)) {
        return 0;
      }
    } while (bool2);
    return 1;
    return parambcff1.pinyinFirst.toLowerCase().charAt(0) - parambcff2.pinyinFirst.toLowerCase().charAt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcmh
 * JD-Core Version:    0.7.0.1
 */