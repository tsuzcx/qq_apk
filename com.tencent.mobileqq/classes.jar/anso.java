import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Comparator;

public class anso
  implements Comparator<String>
{
  public int a(String paramString1, String paramString2)
  {
    int i = 1;
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ContactUtils.PhoneNameComparator", 2, "lhsName is null");
      }
      throw new NullPointerException("com.tencent.mobileqq.utils.ContactUtils int compare lhsName is null for check ");
    }
    if ((paramString2 == null) || (paramString2.length() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ContactUtils.PhoneNameComparator", 2, "rhsName is null");
      }
      throw new NullPointerException("com.tencent.mobileqq.utils.ContactUtils  int compare rhsName is null for check ");
    }
    if ((Character.isDigit(paramString1.charAt(0))) || (Character.isDigit(paramString2.charAt(0)))) {
      if ((Character.isDigit(paramString1.charAt(0))) && (Character.isDigit(paramString2.charAt(0)))) {
        i = paramString1.charAt(0) - paramString2.charAt(0);
      }
    }
    String str1;
    String str2;
    do
    {
      do
      {
        return i;
      } while (Character.isDigit(paramString1.charAt(0)));
      return -1;
      str1 = ChnToSpell.a(paramString1, 1);
      str2 = ChnToSpell.a(paramString2, 1);
      if ((str1.length() == 0) || (str2.length() == 0)) {
        return -str1.compareTo(str2);
      }
      if (str1.charAt(0) != str2.charAt(0)) {
        break;
      }
      if ((StringUtil.isAsciiAlpha(paramString1.charAt(0))) && (StringUtil.isAsciiAlpha(paramString2.charAt(0)))) {
        return paramString1.charAt(0) - paramString2.charAt(0);
      }
    } while (Character.isLetter(paramString1.charAt(0)));
    if (Character.isLetter(paramString2.charAt(0))) {
      return -1;
    }
    return str1.compareTo(str2);
    return str1.charAt(0) - str2.charAt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anso
 * JD-Core Version:    0.7.0.1
 */