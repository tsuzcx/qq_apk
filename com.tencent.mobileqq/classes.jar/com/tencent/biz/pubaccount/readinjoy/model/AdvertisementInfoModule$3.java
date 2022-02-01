package com.tencent.biz.pubaccount.readinjoy.model;

import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.kandian.biz.ad.IRIJAdvertisementRequestProxy;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngineFactory;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONObject;

class AdvertisementInfoModule$3
  implements BusinessObserver
{
  AdvertisementInfoModule$3(AdvertisementInfoModule paramAdvertisementInfoModule, AdvertisementInfo paramAdvertisementInfo) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("type = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" is success:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("AdvertisementInfoModule", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          localObject = new WebSsoBody.WebSsoResponseBody();
          ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
          paramBoolean = ((WebSsoBody.WebSsoResponseBody)localObject).ret.has();
          int i = -1;
          if (!paramBoolean) {
            break label312;
          }
          paramInt = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
          if (paramInt == 0)
          {
            paramBundle = ((WebSsoBody.WebSsoResponseBody)localObject).data.get();
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("back json ");
              ((StringBuilder)localObject).append(paramBundle);
              QLog.d("AdvertisementInfoModule", 2, ((StringBuilder)localObject).toString());
            }
            paramBundle = new JSONObject(paramBundle);
            paramInt = i;
            if (paramBundle.has("ret")) {
              paramInt = paramBundle.getInt("ret");
            }
            if (paramInt == 0)
            {
              paramBundle = paramBundle.optJSONArray("data");
              if ((paramBundle != null) && (paramBundle.length() > 0))
              {
                this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdAppJson = paramBundle.getJSONObject(0).toString();
                if (QLog.isColorLevel())
                {
                  paramBundle = new StringBuilder();
                  paramBundle.append("back  data json ");
                  paramBundle.append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdAppJson);
                  QLog.d("AdvertisementInfoModule", 2, paramBundle.toString());
                }
                ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
                return;
              }
            }
          }
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
      return;
      label312:
      paramInt = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.AdvertisementInfoModule.3
 * JD-Core Version:    0.7.0.1
 */