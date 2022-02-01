package com.tencent.mobileqq.activity.contact.troop;

import android.os.Message;
import com.tencent.mobileqq.activity.contact.recommendtroop.base.CommonAdapter;
import mqq.os.MqqHandler;

class TroopSuspiciousFragment$10
  extends MqqHandler
{
  TroopSuspiciousFragment$10(TroopSuspiciousFragment paramTroopSuspiciousFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 1013: 
    default: 
    case 1012: 
      do
      {
        return;
      } while (TroopSuspiciousFragment.a(this.a) == null);
      TroopSuspiciousFragment.a(this.a).notifyDataSetChanged();
      return;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopSuspiciousFragment.10
 * JD-Core Version:    0.7.0.1
 */