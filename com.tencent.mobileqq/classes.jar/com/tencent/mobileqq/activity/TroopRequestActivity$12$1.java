package com.tencent.mobileqq.activity;

import aepk;
import android.os.Handler;
import android.os.Message;
import bfkb;
import bfkc;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.BaseApplication;

public class TroopRequestActivity$12$1
  implements Runnable
{
  public TroopRequestActivity$12$1(aepk paramaepk, TroopInfo paramTroopInfo) {}
  
  public void run()
  {
    bfkb localbfkb = bfkc.a(BaseApplication.getContext()).a(this.jdField_a_of_type_Aepk.a, Long.toString(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.dwGroupClassExt));
    if (localbfkb != null)
    {
      Message localMessage = new Message();
      localMessage.what = 2;
      localMessage.obj = localbfkb.a();
      this.jdField_a_of_type_Aepk.a.a.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity.12.1
 * JD-Core Version:    0.7.0.1
 */