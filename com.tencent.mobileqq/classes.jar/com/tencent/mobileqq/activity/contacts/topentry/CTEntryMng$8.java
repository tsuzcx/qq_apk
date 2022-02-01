package com.tencent.mobileqq.activity.contacts.topentry;

import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.qphone.base.util.QLog;

class CTEntryMng$8
  extends FriendListObserver
{
  CTEntryMng$8(CTEntryMng paramCTEntryMng) {}
  
  protected void onMayKnowEntryStateChanged(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onMayKnowEntryStateChanged isSuccess=");
      paramBundle.append(paramBoolean);
      QLog.d("CTEntryMng", 2, paramBundle.toString());
    }
    if (paramBoolean)
    {
      CTEntryMng.a(this.a, true);
      CTEntryMng.d(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng.8
 * JD-Core Version:    0.7.0.1
 */