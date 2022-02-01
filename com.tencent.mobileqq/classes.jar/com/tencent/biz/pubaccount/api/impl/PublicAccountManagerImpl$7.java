package com.tencent.biz.pubaccount.api.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import mqq.os.MqqHandler;

class PublicAccountManagerImpl$7
  extends BroadcastReceiver
{
  PublicAccountManagerImpl$7(PublicAccountManagerImpl paramPublicAccountManagerImpl, boolean paramBoolean, MqqHandler paramMqqHandler) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("com.tencent.biz.pubaccount.scanResultData");
    int i = paramIntent.getIntExtra("com.tencent.biz.pubaccount.scanResultType", 0);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountManagerImpl.reportEventTypeMenuEvent(str, i, 12, -1, null);
      if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(19);
      }
    }
    try
    {
      for (;;)
      {
        paramContext.unregisterReceiver(this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountManagerImpl.scanResultReceiver);
        label65:
        this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountManagerImpl.scanResultReceiver = null;
        return;
        this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountManagerImpl.reportEventTypeMenuEvent(str, i, 11, -1, null);
      }
    }
    catch (Exception paramContext)
    {
      break label65;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountManagerImpl.7
 * JD-Core Version:    0.7.0.1
 */