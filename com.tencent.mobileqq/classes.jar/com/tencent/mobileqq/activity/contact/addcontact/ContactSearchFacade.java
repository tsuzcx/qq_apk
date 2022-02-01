package com.tencent.mobileqq.activity.contact.addcontact;

import android.os.SystemClock;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.PhoneCodeUtils;
import com.tencent.qphone.base.util.QLog;

public class ContactSearchFacade
{
  public static final String a = "com.tencent.mobileqq.activity.contact.addcontact.ContactSearchFacade";
  public static int[] a;
  private static int[] jdField_b_of_type_ArrayOfInt = { 80000000 };
  private static int[] jdField_c_of_type_ArrayOfInt = { 80000002 };
  private static int[] d = { 80000003 };
  private static int[] e = { 80000000, 80000001, 80000002, 80000004, 80000003 };
  private static int[] f = { 80000002, 80000003 };
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private ContactSearchFacade.ISearchListener jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade$ISearchListener;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ContactSearchFacade.1(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString = null;
  private String jdField_c_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 80000001 };
  }
  
  public ContactSearchFacade(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_c_of_type_JavaLangString = PhoneCodeUtils.a(paramQQAppInterface.getApplication());
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  final void a()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null) {
      localQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver, true);
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
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).searchFriend(paramString, this.jdField_c_of_type_JavaLangString, 3, this.jdField_a_of_type_Int, paramArrayOfInt, paramDouble1, paramDouble2, paramBoolean, paramInt, this.jdField_a_of_type_Long);
  }
  
  public boolean a(String paramString, int paramInt1, double paramDouble1, double paramDouble2, int paramInt2)
  {
    a();
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = paramInt1;
    Object localObject;
    switch (paramInt1)
    {
    case 80000004: 
    default: 
      localObject = null;
    }
    for (;;)
    {
      break;
      localObject = f;
      continue;
      localObject = e;
      continue;
      localObject = d;
      continue;
      localObject = jdField_c_of_type_ArrayOfInt;
      continue;
      localObject = jdField_a_of_type_ArrayOfInt;
      continue;
      localObject = jdField_b_of_type_ArrayOfInt;
    }
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        paramString = jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("warning! wrong request type = ");
        ((StringBuilder)localObject).append(paramInt1);
        QLog.d(paramString, 2, ((StringBuilder)localObject).toString());
      }
      return false;
    }
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).searchFriend(paramString, this.jdField_c_of_type_JavaLangString, 3, this.jdField_a_of_type_Int, (int[])localObject, paramDouble1, paramDouble2, true, paramInt2, this.jdField_a_of_type_Long);
    if (QLog.isColorLevel())
    {
      paramString = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("searchFriend nextPage = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.d(paramString, 2, ((StringBuilder)localObject).toString());
    }
    return true;
  }
  
  final void b()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null) {
      localQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ContactSearchFacade
 * JD-Core Version:    0.7.0.1
 */