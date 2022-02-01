import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.QLog;
import java.util.Comparator;

public class anvs
  implements Comparator<DiscussionMemberInfo>
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public anvs(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Boolean = paramString2.equals(paramString1);
  }
  
  public int a(DiscussionMemberInfo paramDiscussionMemberInfo1, DiscussionMemberInfo paramDiscussionMemberInfo2)
  {
    int i = -1;
    if (paramDiscussionMemberInfo1.memberUin.equals(this.jdField_a_of_type_JavaLangString)) {
      if (!this.jdField_a_of_type_Boolean) {}
    }
    String str1;
    String str2;
    do
    {
      do
      {
        return 1;
        return -1;
        if (paramDiscussionMemberInfo2.memberUin.equals(this.jdField_a_of_type_JavaLangString))
        {
          if (this.jdField_a_of_type_Boolean) {}
          for (;;)
          {
            return i;
            i = 1;
          }
        }
        paramDiscussionMemberInfo1 = bhlg.a(paramDiscussionMemberInfo1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        paramDiscussionMemberInfo2 = bhlg.a(paramDiscussionMemberInfo2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if ((paramDiscussionMemberInfo1 == null) || (paramDiscussionMemberInfo1.length() == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.e("ContactUtils", 2, "lhsName is null");
          }
          throw new NullPointerException("com.tencent.mobileqq.utils.ContactUtils int compare lhsName is null for check ");
        }
        if ((paramDiscussionMemberInfo2 == null) || (paramDiscussionMemberInfo2.length() == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.e("ContactUtils", 2, "rhsName is null");
          }
          throw new NullPointerException("com.tencent.mobileqq.utils.ContactUtils  int compare rhsName is null for check ");
        }
        if ((!Character.isDigit(paramDiscussionMemberInfo1.charAt(0))) && (!Character.isDigit(paramDiscussionMemberInfo2.charAt(0)))) {
          break;
        }
        if ((Character.isDigit(paramDiscussionMemberInfo1.charAt(0))) && (Character.isDigit(paramDiscussionMemberInfo2.charAt(0)))) {
          return paramDiscussionMemberInfo1.charAt(0) - paramDiscussionMemberInfo2.charAt(0);
        }
      } while (Character.isDigit(paramDiscussionMemberInfo1.charAt(0)));
      return -1;
      str1 = ChnToSpell.a(paramDiscussionMemberInfo1, 1);
      str2 = ChnToSpell.a(paramDiscussionMemberInfo2, 1);
      if ((str1.length() == 0) || (str2.length() == 0)) {
        return -str1.compareTo(str2);
      }
      if (str1.charAt(0) != str2.charAt(0)) {
        break;
      }
      if ((bhsr.b(paramDiscussionMemberInfo1.charAt(0))) && (bhsr.b(paramDiscussionMemberInfo2.charAt(0)))) {
        return paramDiscussionMemberInfo1.charAt(0) - paramDiscussionMemberInfo2.charAt(0);
      }
    } while (Character.isLetter(paramDiscussionMemberInfo1.charAt(0)));
    if (Character.isLetter(paramDiscussionMemberInfo2.charAt(0))) {
      return -1;
    }
    return str1.compareTo(str2);
    return str1.charAt(0) - str2.charAt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anvs
 * JD-Core Version:    0.7.0.1
 */