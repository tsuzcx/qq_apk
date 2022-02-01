package com.tencent.mobileqq.activity.contacts.topentry;

import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

class CTEntryMng$6
  extends ExtendFriendObserver
{
  CTEntryMng$6(CTEntryMng paramCTEntryMng) {}
  
  public void onResourceStateUpdate(boolean paramBoolean)
  {
    CTEntry localCTEntry = this.a.a(2);
    localCTEntry.jdField_a_of_type_JavaLangObject = Boolean.valueOf(paramBoolean);
    if ((localCTEntry.c) && (paramBoolean)) {
      CTEntryMng.a(this.a);
    }
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onResourceStateUpdate [id: %s, canBeShown: %s, isReady: %s]", new Object[] { Integer.valueOf(localCTEntry.jdField_a_of_type_Int), Boolean.valueOf(localCTEntry.c), Boolean.valueOf(paramBoolean) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng.6
 * JD-Core Version:    0.7.0.1
 */