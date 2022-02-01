package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Comparator;

public class ContactSorter$NamePriorityComparator
  implements Comparator<DiscussionMemberInfo>
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public ContactSorter$NamePriorityComparator(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Boolean = paramString2.equals(paramString1);
  }
  
  public int a(DiscussionMemberInfo paramDiscussionMemberInfo1, DiscussionMemberInfo paramDiscussionMemberInfo2)
  {
    boolean bool = paramDiscussionMemberInfo1.memberUin.equals(this.jdField_a_of_type_JavaLangString);
    int i = -1;
    if (bool)
    {
      if (this.jdField_a_of_type_Boolean) {
        i = 1;
      }
      return i;
    }
    if (paramDiscussionMemberInfo2.memberUin.equals(this.jdField_a_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_Boolean) {
        return -1;
      }
      return 1;
    }
    paramDiscussionMemberInfo1 = ContactUtils.a(paramDiscussionMemberInfo1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramDiscussionMemberInfo2 = ContactUtils.a(paramDiscussionMemberInfo2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((paramDiscussionMemberInfo1 != null) && (paramDiscussionMemberInfo1.length() != 0))
    {
      if ((paramDiscussionMemberInfo2 != null) && (paramDiscussionMemberInfo2.length() != 0))
      {
        if ((!Character.isDigit(paramDiscussionMemberInfo1.charAt(0))) && (!Character.isDigit(paramDiscussionMemberInfo2.charAt(0))))
        {
          String str1 = ChnToSpell.a(paramDiscussionMemberInfo1, 1);
          String str2 = ChnToSpell.a(paramDiscussionMemberInfo2, 1);
          if ((str1.length() != 0) && (str2.length() != 0))
          {
            if (str1.charAt(0) == str2.charAt(0))
            {
              if ((StringUtil.b(paramDiscussionMemberInfo1.charAt(0))) && (StringUtil.b(paramDiscussionMemberInfo2.charAt(0)))) {
                return paramDiscussionMemberInfo1.charAt(0) - paramDiscussionMemberInfo2.charAt(0);
              }
              if (Character.isLetter(paramDiscussionMemberInfo1.charAt(0))) {
                return 1;
              }
              if (Character.isLetter(paramDiscussionMemberInfo2.charAt(0))) {
                return -1;
              }
              return str1.compareTo(str2);
            }
            return str1.charAt(0) - str2.charAt(0);
          }
          return -str1.compareTo(str2);
        }
        if ((Character.isDigit(paramDiscussionMemberInfo1.charAt(0))) && (Character.isDigit(paramDiscussionMemberInfo2.charAt(0)))) {
          return paramDiscussionMemberInfo1.charAt(0) - paramDiscussionMemberInfo2.charAt(0);
        }
        if (Character.isDigit(paramDiscussionMemberInfo1.charAt(0))) {
          return 1;
        }
        return -1;
      }
      if (QLog.isColorLevel()) {
        QLog.e("ContactUtils", 2, "rhsName is null");
      }
      throw new NullPointerException("com.tencent.mobileqq.utils.ContactUtils  int compare rhsName is null for check ");
    }
    if (QLog.isColorLevel()) {
      QLog.e("ContactUtils", 2, "lhsName is null");
    }
    throw new NullPointerException("com.tencent.mobileqq.utils.ContactUtils int compare lhsName is null for check ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.ContactSorter.NamePriorityComparator
 * JD-Core Version:    0.7.0.1
 */