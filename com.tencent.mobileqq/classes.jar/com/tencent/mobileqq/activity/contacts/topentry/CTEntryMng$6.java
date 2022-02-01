package com.tencent.mobileqq.activity.contacts.topentry;

import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

class CTEntryMng$6
  extends ExpandObserver
{
  CTEntryMng$6(CTEntryMng paramCTEntryMng) {}
  
  protected void a(boolean paramBoolean)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng.6
 * JD-Core Version:    0.7.0.1
 */