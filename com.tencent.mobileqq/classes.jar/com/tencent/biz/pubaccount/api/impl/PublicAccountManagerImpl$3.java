package com.tencent.biz.pubaccount.api.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.SendMenuEventResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

class PublicAccountManagerImpl$3
  implements BusinessObserver
{
  PublicAccountManagerImpl$3(PublicAccountManagerImpl paramPublicAccountManagerImpl, NewIntent paramNewIntent, Context paramContext, String paramString, BusinessObserver paramBusinessObserver, AppInterface paramAppInterface) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    if (!paramBoolean) {
      return;
    }
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      localSendMenuEventResponse = new mobileqq_mp.SendMenuEventResponse();
    }
    catch (Exception paramBundle)
    {
      SharedPreferences localSharedPreferences;
      label177:
      label179:
      break label177;
    }
    try
    {
      localSendMenuEventResponse.mergeFrom(paramBundle);
      localSharedPreferences = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("menuEventSharePre", 0);
      paramBundle = localSendMenuEventResponse;
      if (!localSharedPreferences.contains(this.jdField_a_of_type_JavaLangString)) {
        break label179;
      }
      paramBundle = localSendMenuEventResponse;
      if (!localSendMenuEventResponse.seqno.has()) {
        break label179;
      }
      paramBundle = localSendMenuEventResponse;
      if (localSendMenuEventResponse.seqno.get() == localSharedPreferences.getInt(this.jdField_a_of_type_JavaLangString, 0)) {
        break label179;
      }
      if (this.jdField_a_of_type_MqqObserverBusinessObserver != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountManagerImpl.getMenuSetting(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverBusinessObserver, true);
      }
      paramBundle = localSharedPreferences.edit();
      paramBundle.putInt(this.jdField_a_of_type_JavaLangString, localSendMenuEventResponse.seqno.get());
      paramBundle.commit();
      paramBundle = localSendMenuEventResponse;
    }
    catch (Exception paramBundle)
    {
      paramBundle = localSendMenuEventResponse;
      break label179;
    }
    paramBundle = null;
    if (paramBundle == null) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountManagerImpl.3
 * JD-Core Version:    0.7.0.1
 */