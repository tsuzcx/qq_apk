import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

final class bbfp
  implements Comparator<bayp>
{
  private final amsw jdField_a_of_type_Amsw;
  private final avsy jdField_a_of_type_Avsy;
  
  bbfp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Avsy = ((avsy)paramQQAppInterface.getManager(11));
    this.jdField_a_of_type_Amsw = ((amsw)paramQQAppInterface.getManager(51));
  }
  
  public int a(bayp parambayp1, bayp parambayp2)
  {
    int i = -1;
    parambayp1 = this.jdField_a_of_type_Avsy.c(((baxl)parambayp1).e());
    parambayp2 = this.jdField_a_of_type_Avsy.c(((baxl)parambayp2).e());
    if ((parambayp1 == null) || (parambayp2 == null)) {
      if ((parambayp1 == null) && (parambayp2 == null)) {
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
          } while (parambayp2 == null);
          return 1;
          if ((parambayp1.uin.equals("0")) && (parambayp2.uin.equals("0"))) {
            break;
          }
          if ((!parambayp1.uin.equals("0")) && (!parambayp2.uin.equals("0"))) {
            return 0;
          }
        } while (!parambayp2.uin.equals("0"));
        return 1;
        bool1 = this.jdField_a_of_type_Amsw.a(parambayp1.unifiedCode, true);
        bool2 = this.jdField_a_of_type_Amsw.a(parambayp2.unifiedCode, true);
        if ((!bool1) && (!bool2)) {
          break;
        }
        if ((bool1) && (bool2)) {
          return 0;
        }
      } while (bool2);
      return 1;
      boolean bool1 = TextUtils.isEmpty(parambayp1.pinyinFirst);
      bool2 = TextUtils.isEmpty(parambayp2.pinyinFirst);
      if ((!bool1) && (!bool2)) {
        break;
      }
      if ((bool1) && (bool2)) {
        return 0;
      }
    } while (bool2);
    return 1;
    return parambayp1.pinyinFirst.toLowerCase().charAt(0) - parambayp2.pinyinFirst.toLowerCase().charAt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbfp
 * JD-Core Version:    0.7.0.1
 */