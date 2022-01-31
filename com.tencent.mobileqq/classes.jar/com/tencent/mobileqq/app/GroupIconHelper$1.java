package com.tencent.mobileqq.app;

public class GroupIconHelper$1
  implements Runnable
{
  GroupIconHelper$1(GroupIconHelper paramGroupIconHelper, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    this.a.addObserver(this.this$0);
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.a.getManager(11);
    if (localPhoneContactManagerImp != null) {
      localPhoneContactManagerImp.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.GroupIconHelper.1
 * JD-Core Version:    0.7.0.1
 */