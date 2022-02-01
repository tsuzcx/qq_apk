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
  public static int[] b = { 80000001 };
  private static int[] g = { 80000000 };
  private static int[] h = { 80000002 };
  private static int[] i = { 80000003 };
  private static int[] j = { 80000000, 80000001, 80000002, 80000004, 80000003 };
  private static int[] k = { 80000002, 80000003 };
  String c = null;
  FriendListObserver d = new ContactSearchFacade.1(this);
  private ContactSearchFacade.ISearchListener e;
  private long f = 0L;
  private QQAppInterface l;
  private String m;
  private int n;
  private int o;
  
  public ContactSearchFacade(QQAppInterface paramQQAppInterface)
  {
    this.l = paramQQAppInterface;
    this.m = PhoneCodeUtils.a(paramQQAppInterface.getApplication());
  }
  
  final void a()
  {
    QQAppInterface localQQAppInterface = this.l;
    if (localQQAppInterface != null) {
      localQQAppInterface.addObserver(this.d, true);
    }
  }
  
  public void a(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void a(ContactSearchFacade.ISearchListener paramISearchListener)
  {
    this.e = paramISearchListener;
  }
  
  public void a(String paramString, int[] paramArrayOfInt, double paramDouble1, double paramDouble2, boolean paramBoolean, int paramInt)
  {
    ((FriendListHandler)this.l.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).searchFriend(paramString, this.m, 3, this.n, paramArrayOfInt, paramDouble1, paramDouble2, paramBoolean, paramInt, this.f);
  }
  
  public boolean a(String paramString, int paramInt1, double paramDouble1, double paramDouble2, int paramInt2)
  {
    a();
    this.c = paramString;
    this.o = paramInt1;
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
      localObject = k;
      continue;
      localObject = j;
      continue;
      localObject = i;
      continue;
      localObject = h;
      continue;
      localObject = b;
      continue;
      localObject = g;
    }
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        paramString = a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("warning! wrong request type = ");
        ((StringBuilder)localObject).append(paramInt1);
        QLog.d(paramString, 2, ((StringBuilder)localObject).toString());
      }
      return false;
    }
    ((FriendListHandler)this.l.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).searchFriend(paramString, this.m, 3, this.n, (int[])localObject, paramDouble1, paramDouble2, true, paramInt2, this.f);
    if (QLog.isColorLevel())
    {
      paramString = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("searchFriend nextPage = ");
      ((StringBuilder)localObject).append(this.n);
      QLog.d(paramString, 2, ((StringBuilder)localObject).toString());
    }
    return true;
  }
  
  final void b()
  {
    QQAppInterface localQQAppInterface = this.l;
    if (localQQAppInterface != null) {
      localQQAppInterface.removeObserver(this.d);
    }
  }
  
  public void c()
  {
    this.n = 0;
    this.f = SystemClock.uptimeMillis();
  }
  
  public int d()
  {
    return this.n;
  }
  
  public void e()
  {
    this.e = null;
    this.n = 0;
    b();
    this.l = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ContactSearchFacade
 * JD-Core Version:    0.7.0.1
 */