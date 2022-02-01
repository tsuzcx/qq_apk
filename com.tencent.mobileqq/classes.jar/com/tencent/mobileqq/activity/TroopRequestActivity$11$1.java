package com.tencent.mobileqq.activity;

import afwp;
import android.os.Handler;
import android.os.Message;
import bhap;
import bhaq;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.BaseApplication;

public class TroopRequestActivity$11$1
  implements Runnable
{
  public TroopRequestActivity$11$1(afwp paramafwp, TroopInfo paramTroopInfo) {}
  
  public void run()
  {
    bhap localbhap = bhaq.a(BaseApplication.getContext()).a(this.jdField_a_of_type_Afwp.a, Long.toString(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupClassExt));
    if (localbhap != null)
    {
      Message localMessage = new Message();
      localMessage.what = 2;
      localMessage.obj = localbhap.a();
      this.jdField_a_of_type_Afwp.a.a.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity.11.1
 * JD-Core Version:    0.7.0.1
 */