import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

final class awvd
  implements Comparator<awoc>
{
  private final ajxn jdField_a_of_type_Ajxn;
  private final askl jdField_a_of_type_Askl;
  
  awvd(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Askl = ((askl)paramQQAppInterface.getManager(11));
    this.jdField_a_of_type_Ajxn = ((ajxn)paramQQAppInterface.getManager(51));
  }
  
  public int a(awoc paramawoc1, awoc paramawoc2)
  {
    int i = -1;
    paramawoc1 = this.jdField_a_of_type_Askl.c(((awmy)paramawoc1).e());
    paramawoc2 = this.jdField_a_of_type_Askl.c(((awmy)paramawoc2).e());
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
        do
        {
          do
          {
            return i;
          } while (paramawoc2 == null);
          return 1;
          if ((paramawoc1.uin.equals("0")) && (paramawoc2.uin.equals("0"))) {
            break;
          }
          if ((!paramawoc1.uin.equals("0")) && (!paramawoc2.uin.equals("0"))) {
            return 0;
          }
        } while (!paramawoc2.uin.equals("0"));
        return 1;
        bool1 = this.jdField_a_of_type_Ajxn.a(paramawoc1.unifiedCode, true);
        bool2 = this.jdField_a_of_type_Ajxn.a(paramawoc2.unifiedCode, true);
        if ((!bool1) && (!bool2)) {
          break;
        }
        if ((bool1) && (bool2)) {
          return 0;
        }
      } while (bool2);
      return 1;
      boolean bool1 = TextUtils.isEmpty(paramawoc1.pinyinFirst);
      bool2 = TextUtils.isEmpty(paramawoc2.pinyinFirst);
      if ((!bool1) && (!bool2)) {
        break;
      }
      if ((bool1) && (bool2)) {
        return 0;
      }
    } while (bool2);
    return 1;
    return paramawoc1.pinyinFirst.toLowerCase().charAt(0) - paramawoc2.pinyinFirst.toLowerCase().charAt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awvd
 * JD-Core Version:    0.7.0.1
 */