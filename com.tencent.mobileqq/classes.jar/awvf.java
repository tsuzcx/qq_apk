import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

final class awvf
  implements Comparator<awoe>
{
  private final ajxl jdField_a_of_type_Ajxl;
  private final askn jdField_a_of_type_Askn;
  
  awvf(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Askn = ((askn)paramQQAppInterface.getManager(11));
    this.jdField_a_of_type_Ajxl = ((ajxl)paramQQAppInterface.getManager(51));
  }
  
  public int a(awoe paramawoe1, awoe paramawoe2)
  {
    int i = -1;
    paramawoe1 = this.jdField_a_of_type_Askn.c(((awna)paramawoe1).e());
    paramawoe2 = this.jdField_a_of_type_Askn.c(((awna)paramawoe2).e());
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
        do
        {
          do
          {
            return i;
          } while (paramawoe2 == null);
          return 1;
          if ((paramawoe1.uin.equals("0")) && (paramawoe2.uin.equals("0"))) {
            break;
          }
          if ((!paramawoe1.uin.equals("0")) && (!paramawoe2.uin.equals("0"))) {
            return 0;
          }
        } while (!paramawoe2.uin.equals("0"));
        return 1;
        bool1 = this.jdField_a_of_type_Ajxl.a(paramawoe1.unifiedCode, true);
        bool2 = this.jdField_a_of_type_Ajxl.a(paramawoe2.unifiedCode, true);
        if ((!bool1) && (!bool2)) {
          break;
        }
        if ((bool1) && (bool2)) {
          return 0;
        }
      } while (bool2);
      return 1;
      boolean bool1 = TextUtils.isEmpty(paramawoe1.pinyinFirst);
      bool2 = TextUtils.isEmpty(paramawoe2.pinyinFirst);
      if ((!bool1) && (!bool2)) {
        break;
      }
      if ((bool1) && (bool2)) {
        return 0;
      }
    } while (bool2);
    return 1;
    return paramawoe1.pinyinFirst.toLowerCase().charAt(0) - paramawoe2.pinyinFirst.toLowerCase().charAt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awvf
 * JD-Core Version:    0.7.0.1
 */