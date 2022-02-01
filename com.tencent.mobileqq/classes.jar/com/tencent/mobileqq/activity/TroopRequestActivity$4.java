package com.tencent.mobileqq.activity;

import bfkb;
import bfkc;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.os.MqqHandler;

class TroopRequestActivity$4
  implements Runnable
{
  TroopRequestActivity$4(TroopRequestActivity paramTroopRequestActivity, TroopInfo paramTroopInfo) {}
  
  public void run()
  {
    bfkb localbfkb = bfkc.a(BaseApplication.getContext()).a(this.this$0, Long.toString(this.a.dwGroupClassExt));
    if (localbfkb != null)
    {
      this.this$0.j = localbfkb.a();
      ThreadManager.getUIHandler().post(new TroopRequestActivity.4.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity.4
 * JD-Core Version:    0.7.0.1
 */