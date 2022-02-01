package com.tencent.mobileqq.activity;

import afnl;
import android.os.Handler;
import android.os.Message;
import bgao;
import bgap;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.BaseApplication;

public class TroopRequestActivity$11$1
  implements Runnable
{
  public TroopRequestActivity$11$1(afnl paramafnl, TroopInfo paramTroopInfo) {}
  
  public void run()
  {
    bgao localbgao = bgap.a(BaseApplication.getContext()).a(this.jdField_a_of_type_Afnl.a, Long.toString(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupClassExt));
    if (localbgao != null)
    {
      Message localMessage = new Message();
      localMessage.what = 2;
      localMessage.obj = localbgao.a();
      this.jdField_a_of_type_Afnl.a.a.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity.11.1
 * JD-Core Version:    0.7.0.1
 */