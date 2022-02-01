import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

final class bbtu
  implements Comparator<bbmu>
{
  private final anmw jdField_a_of_type_Anmw;
  private final awmz jdField_a_of_type_Awmz;
  
  bbtu(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Awmz = ((awmz)paramQQAppInterface.getManager(11));
    this.jdField_a_of_type_Anmw = ((anmw)paramQQAppInterface.getManager(51));
  }
  
  public int a(bbmu parambbmu1, bbmu parambbmu2)
  {
    int i = -1;
    parambbmu1 = this.jdField_a_of_type_Awmz.c(((bblq)parambbmu1).e());
    parambbmu2 = this.jdField_a_of_type_Awmz.c(((bblq)parambbmu2).e());
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
        do
        {
          do
          {
            return i;
          } while (parambbmu2 == null);
          return 1;
          if ((parambbmu1.uin.equals("0")) && (parambbmu2.uin.equals("0"))) {
            break;
          }
          if ((!parambbmu1.uin.equals("0")) && (!parambbmu2.uin.equals("0"))) {
            return 0;
          }
        } while (!parambbmu2.uin.equals("0"));
        return 1;
        bool1 = this.jdField_a_of_type_Anmw.a(parambbmu1.unifiedCode, true);
        bool2 = this.jdField_a_of_type_Anmw.a(parambbmu2.unifiedCode, true);
        if ((!bool1) && (!bool2)) {
          break;
        }
        if ((bool1) && (bool2)) {
          return 0;
        }
      } while (bool2);
      return 1;
      boolean bool1 = TextUtils.isEmpty(parambbmu1.pinyinFirst);
      bool2 = TextUtils.isEmpty(parambbmu2.pinyinFirst);
      if ((!bool1) && (!bool2)) {
        break;
      }
      if ((bool1) && (bool2)) {
        return 0;
      }
    } while (bool2);
    return 1;
    return parambbmu1.pinyinFirst.toLowerCase().charAt(0) - parambbmu2.pinyinFirst.toLowerCase().charAt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbtu
 * JD-Core Version:    0.7.0.1
 */