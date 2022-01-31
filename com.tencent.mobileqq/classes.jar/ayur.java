import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

final class ayur
  implements Comparator<aynq>
{
  private final alto jdField_a_of_type_Alto;
  private final aufv jdField_a_of_type_Aufv;
  
  ayur(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Aufv = ((aufv)paramQQAppInterface.getManager(11));
    this.jdField_a_of_type_Alto = ((alto)paramQQAppInterface.getManager(51));
  }
  
  public int a(aynq paramaynq1, aynq paramaynq2)
  {
    int i = -1;
    paramaynq1 = this.jdField_a_of_type_Aufv.c(((aymm)paramaynq1).e());
    paramaynq2 = this.jdField_a_of_type_Aufv.c(((aymm)paramaynq2).e());
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
        do
        {
          do
          {
            return i;
          } while (paramaynq2 == null);
          return 1;
          if ((paramaynq1.uin.equals("0")) && (paramaynq2.uin.equals("0"))) {
            break;
          }
          if ((!paramaynq1.uin.equals("0")) && (!paramaynq2.uin.equals("0"))) {
            return 0;
          }
        } while (!paramaynq2.uin.equals("0"));
        return 1;
        bool1 = this.jdField_a_of_type_Alto.a(paramaynq1.unifiedCode, true);
        bool2 = this.jdField_a_of_type_Alto.a(paramaynq2.unifiedCode, true);
        if ((!bool1) && (!bool2)) {
          break;
        }
        if ((bool1) && (bool2)) {
          return 0;
        }
      } while (bool2);
      return 1;
      boolean bool1 = TextUtils.isEmpty(paramaynq1.pinyinFirst);
      bool2 = TextUtils.isEmpty(paramaynq2.pinyinFirst);
      if ((!bool1) && (!bool2)) {
        break;
      }
      if ((bool1) && (bool2)) {
        return 0;
      }
    } while (bool2);
    return 1;
    return paramaynq1.pinyinFirst.toLowerCase().charAt(0) - paramaynq2.pinyinFirst.toLowerCase().charAt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayur
 * JD-Core Version:    0.7.0.1
 */