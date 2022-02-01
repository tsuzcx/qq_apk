package com.tencent.mobileqq.activity;

import afgv;
import android.os.Handler;
import android.os.Message;
import bgss;
import bgst;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.BaseApplication;

public class TroopRequestActivity$12$1
  implements Runnable
{
  public TroopRequestActivity$12$1(afgv paramafgv, TroopInfo paramTroopInfo) {}
  
  public void run()
  {
    bgss localbgss = bgst.a(BaseApplication.getContext()).a(this.jdField_a_of_type_Afgv.a, Long.toString(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.dwGroupClassExt));
    if (localbgss != null)
    {
      Message localMessage = new Message();
      localMessage.what = 2;
      localMessage.obj = localbgss.a();
      this.jdField_a_of_type_Afgv.a.a.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity.12.1
 * JD-Core Version:    0.7.0.1
 */