package com.tencent.mobileqq.activity.contact.newfriend;

import com.tencent.mobileqq.model.PhoneContactManager.IPhoneContactListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;

class NewFriendManager$5
  implements PhoneContactManager.IPhoneContactListener
{
  NewFriendManager$5(NewFriendManager paramNewFriendManager) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendManager", 2, "onBindStateChanged = " + paramInt);
    }
    this.a.d();
  }
  
  public void a(long paramLong) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendManager", 2, "onRecommendCountChanged = " + paramInt);
    }
    this.a.d();
  }
  
  public void b(int paramInt) {}
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendManager", 2, "onUpdateContactList = " + paramInt);
    }
    if ((paramInt & 0x1) != 0) {
      synchronized (NewFriendManager.a(this.a))
      {
        Iterator localIterator = NewFriendManager.a(this.a).iterator();
        if (localIterator.hasNext()) {
          ((NewFriendManager.INewFriendListener)localIterator.next()).b();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager.5
 * JD-Core Version:    0.7.0.1
 */