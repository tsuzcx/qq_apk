import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

final class bcmn
  implements Comparator<bcfn>
{
  private final anyw jdField_a_of_type_Anyw;
  private final axfr jdField_a_of_type_Axfr;
  
  bcmn(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Axfr = ((axfr)paramQQAppInterface.getManager(11));
    this.jdField_a_of_type_Anyw = ((anyw)paramQQAppInterface.getManager(51));
  }
  
  public int a(bcfn parambcfn1, bcfn parambcfn2)
  {
    int i = -1;
    parambcfn1 = this.jdField_a_of_type_Axfr.c(((bcej)parambcfn1).e());
    parambcfn2 = this.jdField_a_of_type_Axfr.c(((bcej)parambcfn2).e());
    if ((parambcfn1 == null) || (parambcfn2 == null)) {
      if ((parambcfn1 == null) && (parambcfn2 == null)) {
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
          } while (parambcfn2 == null);
          return 1;
          if ((parambcfn1.uin.equals("0")) && (parambcfn2.uin.equals("0"))) {
            break;
          }
          if ((!parambcfn1.uin.equals("0")) && (!parambcfn2.uin.equals("0"))) {
            return 0;
          }
        } while (!parambcfn2.uin.equals("0"));
        return 1;
        bool1 = this.jdField_a_of_type_Anyw.a(parambcfn1.unifiedCode, true);
        bool2 = this.jdField_a_of_type_Anyw.a(parambcfn2.unifiedCode, true);
        if ((!bool1) && (!bool2)) {
          break;
        }
        if ((bool1) && (bool2)) {
          return 0;
        }
      } while (bool2);
      return 1;
      boolean bool1 = TextUtils.isEmpty(parambcfn1.pinyinFirst);
      bool2 = TextUtils.isEmpty(parambcfn2.pinyinFirst);
      if ((!bool1) && (!bool2)) {
        break;
      }
      if ((bool1) && (bool2)) {
        return 0;
      }
    } while (bool2);
    return 1;
    return parambcfn1.pinyinFirst.toLowerCase().charAt(0) - parambcfn2.pinyinFirst.toLowerCase().charAt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcmn
 * JD-Core Version:    0.7.0.1
 */