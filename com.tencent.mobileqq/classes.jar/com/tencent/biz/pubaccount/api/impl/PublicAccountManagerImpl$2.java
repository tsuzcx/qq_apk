package com.tencent.biz.pubaccount.api.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountMenuResponse;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

class PublicAccountManagerImpl$2
  implements BusinessObserver
{
  PublicAccountManagerImpl$2(PublicAccountManagerImpl paramPublicAccountManagerImpl, NewIntent paramNewIntent, AppInterface paramAppInterface, String paramString, Context paramContext, BusinessObserver paramBusinessObserver) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    boolean bool = QLog.isColorLevel();
    int k = 2;
    Object localObject1;
    if (bool)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("success:");
      ((StringBuilder)localObject1).append(String.valueOf(paramBoolean));
      QLog.i("PublicAccountManager", 2, ((StringBuilder)localObject1).toString());
    }
    if (!paramBoolean) {
      return;
    }
    label142:
    label582:
    label585:
    try
    {
      localObject1 = paramBundle.getByteArray("data");
      localGetPublicAccountMenuResponse = new mobileqq_mp.GetPublicAccountMenuResponse();
    }
    catch (Exception localException1)
    {
      label118:
      Object localObject3;
      mobileqq_mp.ButtonInfo localButtonInfo;
      label377:
      break label582;
    }
    try
    {
      localGetPublicAccountMenuResponse.mergeFrom((byte[])localObject1);
      if (!localGetPublicAccountMenuResponse.uin.has()) {
        break label622;
      }
      l = localGetPublicAccountMenuResponse.uin.get() & 0xFFFFFFFF;
    }
    catch (Exception localException2)
    {
      Object localObject2 = localGetPublicAccountMenuResponse;
      break label585;
      l = 0L;
      break label118;
      i = 0;
      break label142;
      j = -1;
      break label377;
    }
    if (localGetPublicAccountMenuResponse.seqno.has())
    {
      i = localGetPublicAccountMenuResponse.seqno.get();
      if (((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).isWeatherPA(String.valueOf(l)))
      {
        localObject3 = localGetPublicAccountMenuResponse.button_info.get();
        if ((localObject3 == null) || (((List)localObject3).size() == 0))
        {
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = new ArrayList();
          }
          localObject3 = new mobileqq_mp.ButtonInfo();
          ((mobileqq_mp.ButtonInfo)localObject3).id.set(1);
          ((mobileqq_mp.ButtonInfo)localObject3).name.set(HardCodeUtil.a(2131708766));
          ((mobileqq_mp.ButtonInfo)localObject3).event_id.set(1000001);
          ((mobileqq_mp.ButtonInfo)localObject3).type.set(3);
          localButtonInfo = new mobileqq_mp.ButtonInfo();
          localButtonInfo.id.set(2);
          localButtonInfo.name.set(HardCodeUtil.a(2131708741));
          localButtonInfo.event_id.set(1000002);
          localButtonInfo.type.set(3);
          ((List)localObject1).add(localObject3);
          ((List)localObject1).add(localButtonInfo);
          localGetPublicAccountMenuResponse.button_info.set((List)localObject1);
        }
      }
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountManagerImpl.getLocalPublicAccountMenuSetting(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString);
      if (!localGetPublicAccountMenuResponse.update_internal.has()) {
        break label634;
      }
      j = localGetPublicAccountMenuResponse.update_internal.get();
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("update_internal(s):");
        ((StringBuilder)localObject3).append(j);
        QLog.d("PublicAccountManager-Menu", 2, ((StringBuilder)localObject3).toString());
      }
      if (j > 0)
      {
        localObject3 = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("menuEventSharePre", 0).edit();
        ((SharedPreferences.Editor)localObject3).putLong("menuCacheTime", j * 1000);
        ((SharedPreferences.Editor)localObject3).commit();
      }
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        j = k;
        if (localGetPublicAccountMenuResponse.update_type.has()) {
          j = localGetPublicAccountMenuResponse.update_type.get();
        }
        paramBundle.putInt("update_type", j);
      }
      else
      {
        paramBundle.putInt("update_type", 1);
      }
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountManagerImpl;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(l);
      j = ((PublicAccountManagerImpl)localObject1).getMenusettingLocalSeqno(((StringBuilder)localObject3).toString());
      localObject1 = localGetPublicAccountMenuResponse;
      if (i == j)
      {
        return;
        localObject1 = null;
      }
      if (localObject1 == null) {
        return;
      }
      ThreadManager.executeOnSubThread(new PublicAccountManagerImpl.2.1(this, (mobileqq_mp.GetPublicAccountMenuResponse)localObject1, paramInt, paramBoolean, paramBundle));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */