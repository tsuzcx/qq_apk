package com.tencent.mobileqq.activity;

import aecp;
import android.os.Handler;
import android.os.Message;
import bcru;
import bcrv;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.BaseApplication;

public class TroopRequestActivity$11$1
  implements Runnable
{
  public TroopRequestActivity$11$1(aecp paramaecp, TroopInfo paramTroopInfo) {}
  
  public void run()
  {
    bcru localbcru = bcrv.a(BaseApplication.getContext()).a(this.jdField_a_of_type_Aecp.a, Long.toString(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupClassExt));
    if (localbcru != null)
    {
      Message localMessage = new Message();
      localMessage.what = 2;
      localMessage.obj = localbcru.a();
      this.jdField_a_of_type_Aecp.a.a.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity.11.1
 * JD-Core Version:    0.7.0.1
 */