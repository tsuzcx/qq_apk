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
      paramIntent = this.jdField_a_of_type_MqqOsMqqHandler;
      if (paramIntent != null) {
        paramIntent.sendEmptyMessage(19);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountManagerImpl.reportEventTypeMenuEvent(str, i, 11, -1, null);
    }
    try
    {
      paramContext.unregisterReceiver(this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountManagerImpl.scanResultReceiver);
      label81:
      this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountManagerImpl.scanResultReceiver = null;
      return;
    }
    catch (Exception paramContext)
    {
      break label81;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountManagerImpl.7
 * JD-Core Version:    0.7.0.1
 */