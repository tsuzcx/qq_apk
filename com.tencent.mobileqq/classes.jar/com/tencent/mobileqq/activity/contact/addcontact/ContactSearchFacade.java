package com.tencent.mobileqq.activity.contact.addcontact;

import android.os.SystemClock;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.PhoneCodeUtils;
import com.tencent.qphone.base.util.QLog;
import wfc;

public class ContactSearchFacade
{
  public static final String a;
  private static int[] jdField_a_of_type_ArrayOfInt = { 80000000 };
  private static int[] jdField_b_of_type_ArrayOfInt = { 80000001 };
  private static int[] jdField_c_of_type_ArrayOfInt = { 80000002 };
  private static int[] d = { 80000003 };
  private static int[] e = { 80000000, 80000001, 80000002, 80000004, 80000003 };
  private static int[] f = { 80000002, 80000003 };
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ContactSearchFacade.ISearchListener jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade$ISearchListener;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new wfc(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private int jdField_b_of_type_Int;
  public String b;
  private String jdField_c_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_JavaLangString = ContactSearchFacade.class.getName();
  }
  
  public ContactSearchFacade(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_c_of_type_JavaLangString = PhoneCodeUtils.a(paramQQAppInterface.getApplication());
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  final void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver, true);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(ContactSearchFacade.ISearchListener paramISearchListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade$ISearchListener = paramISearchListener;
  }
  
  public void a(String paramString, int[] paramArrayOfInt, double paramDouble1, double paramDouble2, boolean paramBoolean, int paramInt)
  {
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(paramString, this.jdField_c_of_type_JavaLangString, 3, this.jdField_a_of_type_Int, paramArrayOfInt, paramDouble1, paramDouble2, paramBoolean, paramInt, this.jdField_a_of_type_Long);
  }
  
  public boolean a(String paramString)
  {
    a();
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(paramString, this.jdField_c_of_type_JavaLangString, 2, 0, null, 0.0D, 0.0D, true, 0L);
    return true;
  }
  
  public boolean a(String paramString, int paramInt1, double paramDouble1, double paramDouble2, int paramInt2)
  {
    a();
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = paramInt1;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    switch (paramInt1)
    {
    default: 
      localObject1 = localObject2;
    }
    while (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "warning! wrong request type = " + paramInt1);
      }
      return false;
      localObject1 = jdField_a_of_type_ArrayOfInt;
      continue;
      localObject1 = jdField_b_of_type_ArrayOfInt;
      continue;
      localObject1 = jdField_c_of_type_ArrayOfInt;
      continue;
      localObject1 = d;
      continue;
      localObject1 = e;
      continue;
      localObject1 = f;
    }
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(paramString, this.jdField_c_of_type_JavaLangString, 3, this.jdField_a_of_type_Int, (int[])localObject1, paramDouble1, paramDouble2, true, paramInt2, this.jdField_a_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "searchFriend nextPage = " + this.jdField_a_of_type_Int);
    }
    return true;
  }
  
  public final void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade$ISearchListener = null;
    this.jdField_a_of_type_Int = 0;
    b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ContactSearchFacade
 * JD-Core Version:    0.7.0.1
 */