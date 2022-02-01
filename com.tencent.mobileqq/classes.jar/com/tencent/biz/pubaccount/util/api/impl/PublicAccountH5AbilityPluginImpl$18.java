package com.tencent.biz.pubaccount.util.api.impl;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.mp.mobileqq_mp.JSApiWebServerResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class PublicAccountH5AbilityPluginImpl$18
  implements BusinessObserver
{
  PublicAccountH5AbilityPluginImpl$18(PublicAccountH5AbilityPluginImpl paramPublicAccountH5AbilityPluginImpl, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject1;
    if (paramBoolean)
    {
      localObject1 = paramBundle.getByteArray("data");
      if (localObject1 != null) {
        paramBundle = new mobileqq_mp.JSApiWebServerResponse();
      }
    }
    for (;;)
    {
      try
      {
        paramBundle.mergeFrom((byte[])localObject1);
        localObject1 = (mobileqq_mp.RetInfo)paramBundle.ret_info.get();
        Object localObject2 = paramBundle.body.get();
        int i = ((mobileqq_mp.RetInfo)localObject1).ret_code.get();
        paramBundle = ((mobileqq_mp.RetInfo)localObject1).err_info.get();
        localObject1 = new JSONObject();
        paramInt = i;
        if (i == 0)
        {
          localObject2 = new JSONObject((String)localObject2);
          i = ((JSONObject)localObject2).optInt("ret");
          paramBundle = ((JSONObject)localObject2).optString("msg");
          this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountH5AbilityPluginImpl.pUin = ((JSONObject)localObject2).optString("puin");
          if (i == -1)
          {
            paramInt = ((JSONObject)localObject2).optInt("refuseSec");
            if (paramInt > 0)
            {
              this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountH5AbilityPluginImpl.refuseConfig = true;
              PublicAccountH5AbilityPluginImpl.access$100(this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountH5AbilityPluginImpl).sendEmptyMessageDelayed(1000, paramInt * 1000);
            }
          }
          localObject2 = ((JSONObject)localObject2).optJSONArray("bitmap");
          Object localObject3 = new ArrayList();
          if (localObject2 != null)
          {
            paramInt = 0;
            if (paramInt < ((JSONArray)localObject2).length())
            {
              ((ArrayList)localObject3).add(Integer.valueOf(((JSONArray)localObject2).getInt(paramInt)));
              paramInt += 1;
              continue;
            }
          }
          localObject2 = new ArrayList();
          localObject3 = ((ArrayList)localObject3).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = PublicAccountH5AbilityPluginImpl.intToCharArray(((Integer)((Iterator)localObject3).next()).intValue());
            int j = localObject4.length;
            paramInt = 0;
            if (paramInt < j)
            {
              ((ArrayList)localObject2).add(Integer.valueOf(localObject4[paramInt]));
              paramInt += 1;
              continue;
            }
            continue;
          }
          localObject3 = new ArrayList();
          Object localObject4 = (ArrayList)PublicAccountH5AbilityPluginImpl.needAuthorizedLists.get(this.jdField_a_of_type_JavaLangString);
          paramInt = 0;
          if (paramInt < ((ArrayList)localObject2).size())
          {
            String str = (String)PublicAccountH5AbilityPluginImpl.map.get(Integer.valueOf(paramInt));
            if ((str == null) || (((Integer)((ArrayList)localObject2).get(paramInt)).intValue() != 1) || (!this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountH5AbilityPluginImpl.contains((ArrayList)localObject4, str))) {
              break label584;
            }
            ((ArrayList)localObject3).add(str);
            break label584;
          }
          PublicAccountH5AbilityPluginImpl.authorizedLists.put(this.jdField_a_of_type_JavaLangString, localObject3);
          PublicAccountH5AbilityPluginImpl.needAuthorizedLists.remove(this.jdField_a_of_type_JavaLangString);
          localObject2 = new ArrayList();
          if (localObject4 != null)
          {
            paramInt = 0;
            if (paramInt < ((ArrayList)localObject4).size())
            {
              if (this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountH5AbilityPluginImpl.contains((ArrayList)localObject3, (String)((ArrayList)localObject4).get(paramInt))) {
                break label591;
              }
              ((ArrayList)localObject2).add(Integer.valueOf(paramInt));
              break label591;
            }
          }
          ((JSONObject)localObject1).put("forbidden", new JSONArray((Collection)localObject2));
          paramInt = i;
        }
        ((JSONObject)localObject1).put("msg", paramBundle);
        ((JSONObject)localObject1).put("retCode", paramInt);
        paramBundle = ((JSONObject)localObject1).toString();
        if (this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountH5AbilityPluginImpl.authCallback != null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountH5AbilityPluginImpl.callJs(this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountH5AbilityPluginImpl.authCallback, new String[] { paramBundle });
          return;
        }
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        paramBundle.printStackTrace();
      }
      return;
      label584:
      paramInt += 1;
      continue;
      label591:
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl.18
 * JD-Core Version:    0.7.0.1
 */