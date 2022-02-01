package com.tencent.mobileqq.app;

import com.tencent.mobileqq.util.FetchBuddyAndTroopNameHelper;
import mqq.manager.Manager;

public class ContactFacade
  implements Manager
{
  public Object a = new Object();
  private QQAppInterface b;
  private FetchBuddyAndTroopNameHelper c;
  
  public ContactFacade(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
  }
  
  public FetchBuddyAndTroopNameHelper a()
  {
    if (this.c == null) {
      synchronized (this.a)
      {
        if (this.c == null) {
          this.c = new FetchBuddyAndTroopNameHelper(this.b);
        }
      }
    }
    return this.c;
  }
  
  public void onDestroy()
  {
    FetchBuddyAndTroopNameHelper localFetchBuddyAndTroopNameHelper = this.c;
    if (localFetchBuddyAndTroopNameHelper != null) {
      localFetchBuddyAndTroopNameHelper.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ContactFacade
 * JD-Core Version:    0.7.0.1
 */