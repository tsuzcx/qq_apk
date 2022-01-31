import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

final class ayqi
  implements Comparator<ayjh>
{
  private final aloz jdField_a_of_type_Aloz;
  private final aubm jdField_a_of_type_Aubm;
  
  ayqi(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Aubm = ((aubm)paramQQAppInterface.getManager(11));
    this.jdField_a_of_type_Aloz = ((aloz)paramQQAppInterface.getManager(51));
  }
  
  public int a(ayjh paramayjh1, ayjh paramayjh2)
  {
    int i = -1;
    paramayjh1 = this.jdField_a_of_type_Aubm.c(((ayid)paramayjh1).e());
    paramayjh2 = this.jdField_a_of_type_Aubm.c(((ayid)paramayjh2).e());
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
        do
        {
          do
          {
            return i;
          } while (paramayjh2 == null);
          return 1;
          if ((paramayjh1.uin.equals("0")) && (paramayjh2.uin.equals("0"))) {
            break;
          }
          if ((!paramayjh1.uin.equals("0")) && (!paramayjh2.uin.equals("0"))) {
            return 0;
          }
        } while (!paramayjh2.uin.equals("0"));
        return 1;
        bool1 = this.jdField_a_of_type_Aloz.a(paramayjh1.unifiedCode, true);
        bool2 = this.jdField_a_of_type_Aloz.a(paramayjh2.unifiedCode, true);
        if ((!bool1) && (!bool2)) {
          break;
        }
        if ((bool1) && (bool2)) {
          return 0;
        }
      } while (bool2);
      return 1;
      boolean bool1 = TextUtils.isEmpty(paramayjh1.pinyinFirst);
      bool2 = TextUtils.isEmpty(paramayjh2.pinyinFirst);
      if ((!bool1) && (!bool2)) {
        break;
      }
      if ((bool1) && (bool2)) {
        return 0;
      }
    } while (bool2);
    return 1;
    return paramayjh1.pinyinFirst.toLowerCase().charAt(0) - paramayjh2.pinyinFirst.toLowerCase().charAt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayqi
 * JD-Core Version:    0.7.0.1
 */