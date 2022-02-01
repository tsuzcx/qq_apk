package com.tencent.mobileqq.activity;

import bhap;
import bhaq;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.os.MqqHandler;

class TroopRequestActivity$3
  implements Runnable
{
  TroopRequestActivity$3(TroopRequestActivity paramTroopRequestActivity, TroopInfo paramTroopInfo) {}
  
  public void run()
  {
    bhap localbhap = bhaq.a(BaseApplication.getContext()).a(this.this$0, Long.toString(this.a.dwGroupClassExt));
    if (localbhap != null)
    {
      this.this$0.i = localbhap.a();
      ThreadManager.getUIHandler().post(new TroopRequestActivity.3.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity.3
 * JD-Core Version:    0.7.0.1
 */