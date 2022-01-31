package com.tencent.biz.pubaccount.readinjoy.model;

import akup;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import aukn;
import bhvh;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import osm;
import pbh;
import pbo;
import pbp;
import pcp;
import pou;
import pow;
import tencent.im.oidb.cmd0xdc0.oidb_0xdc0.GroupInfo;
import tencent.im.oidb.cmd0xdc0.oidb_0xdc0.LocationInfo;
import tencent.im.oidb.cmd0xdc0.oidb_0xdc0.LocationList;
import tencent.im.oidb.cmd0xdc0.oidb_0xdc0.ReqBody;
import tencent.im.oidb.cmd0xdc0.oidb_0xdc0.RspBody;

public class SelectPositionModule
  extends pbh
{
  private volatile long jdField_a_of_type_Long;
  private akup jdField_a_of_type_Akup;
  private volatile SelectPositionModule.PositionData jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData;
  private volatile List<pcp> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private pbp jdField_a_of_type_Pbp;
  private volatile SelectPositionModule.PositionData b;
  
  public SelectPositionModule(AppInterface paramAppInterface, aukn paramaukn, ExecutorService paramExecutorService, pou parampou, Handler paramHandler)
  {
    super(paramAppInterface, paramaukn, paramExecutorService, parampou, paramHandler);
  }
  
  private SelectPositionModule.PositionData a(String paramString)
  {
    Object localObject = bhvh.a(BaseApplicationImpl.getApplication().getRuntime(), true, false);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).getString(paramString, "");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        try
        {
          JSONObject localJSONObject = new JSONObject((String)localObject);
          SelectPositionModule.PositionData localPositionData = new SelectPositionModule.PositionData();
          localPositionData.country = localJSONObject.getString("key_country");
          localPositionData.province = localJSONObject.getString("key_province");
          localPositionData.city = localJSONObject.getString("key_city");
          localPositionData.cityCode = localJSONObject.getString("key_citycode");
          if (QLog.isColorLevel()) {
            QLog.d("SelectPositionModule", 2, "getPositionDataByKey position = " + localPositionData + " key = " + paramString);
          }
          return localPositionData;
        }
        catch (JSONException localJSONException)
        {
          QLog.e("SelectPositionModule", 2, "getSelectedPositionData positionJson = " + (String)localObject + " exception = " + localJSONException + " key = " + paramString);
        }
      }
    }
    return null;
  }
  
  private void a(SelectPositionModule.PositionData paramPositionData, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("key_country", paramPositionData.country);
      localJSONObject.put("key_province", paramPositionData.province);
      localJSONObject.put("key_city", paramPositionData.city);
      localJSONObject.put("key_citycode", paramPositionData.cityCode);
      Object localObject = bhvh.a(BaseApplicationImpl.getApplication().getRuntime(), true, false);
      if (localObject != null)
      {
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString(paramString, localJSONObject.toString());
        ((SharedPreferences.Editor)localObject).commit();
        if (QLog.isColorLevel()) {
          QLog.d("SelectPositionModule", 2, "save position = " + localJSONObject + " key = " + paramString);
        }
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.d("SelectPositionModule", 2, "saveSelectedPositionData error positionData = " + paramPositionData + " ,error = " + localJSONException + " key = " + paramString);
    }
  }
  
  private void a(String paramString)
  {
    Object localObject = bhvh.a(BaseApplicationImpl.getApplication().getRuntime(), true, false);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString(paramString, "");
      ((SharedPreferences.Editor)localObject).commit();
      if (QLog.isColorLevel()) {
        QLog.d("SelectPositionModule", 2, "clearPositionDataByKey key = " + paramString);
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = new oidb_0xdc0.ReqBody();
    ((oidb_0xdc0.ReqBody)localObject).uint32_req_type.set(1);
    localObject = pow.a("OidbSvc.0xdc0", 3520, 0, ((oidb_0xdc0.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putBoolean("need_check_local_city_changed", paramBoolean);
    a((ToServiceMsg)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("SelectPositionModule", 2, "requestCityWhiteListListFromServer needCheckLocalCityChanged = " + paramBoolean);
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = new oidb_0xdc0.RspBody();
    int i = pow.a(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    QLog.d("SelectPositionModule", 2, new Object[] { "handle0xdc0WhiteList result = ", Integer.valueOf(i) });
    if (i == 0)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      paramFromServiceMsg = new ArrayList();
      if (((oidb_0xdc0.RspBody)localObject).msg_location_list.has())
      {
        paramObject = (oidb_0xdc0.LocationList)((oidb_0xdc0.RspBody)localObject).msg_location_list.get();
        if ((paramObject.rpt_group_list.has()) && (paramObject.rpt_group_list.size() > 0))
        {
          i = 0;
          while (i < paramObject.rpt_group_list.size())
          {
            localObject = (oidb_0xdc0.GroupInfo)paramObject.rpt_group_list.get(i);
            if (((oidb_0xdc0.GroupInfo)localObject).bytes_name.has()) {
              paramFromServiceMsg.add(new pcp(((oidb_0xdc0.GroupInfo)localObject).bytes_name.get().toStringUtf8()));
            }
            if ((((oidb_0xdc0.GroupInfo)localObject).rpt_location_list.has()) && (((oidb_0xdc0.GroupInfo)localObject).rpt_location_list.size() > 0))
            {
              int j = 0;
              if (j < ((oidb_0xdc0.GroupInfo)localObject).rpt_location_list.size())
              {
                oidb_0xdc0.LocationInfo localLocationInfo = (oidb_0xdc0.LocationInfo)((oidb_0xdc0.GroupInfo)localObject).rpt_location_list.get(j);
                if ((localLocationInfo.bytes_city.has()) && (localLocationInfo.bytes_city_code.has()))
                {
                  if ((!localLocationInfo.bytes_province.has()) || (!localLocationInfo.bytes_country.has())) {
                    break label329;
                  }
                  paramFromServiceMsg.add(new pcp(localLocationInfo.bytes_country.get().toStringUtf8(), localLocationInfo.bytes_province.get().toStringUtf8(), localLocationInfo.bytes_city.get().toStringUtf8(), localLocationInfo.bytes_city_code.get().toStringUtf8()));
                }
                for (;;)
                {
                  j += 1;
                  break;
                  label329:
                  paramFromServiceMsg.add(new pcp("", "", localLocationInfo.bytes_city.get().toStringUtf8(), localLocationInfo.bytes_city_code.get().toStringUtf8()));
                }
              }
            }
            i += 1;
          }
        }
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramFromServiceMsg);
      if (QLog.isColorLevel())
      {
        if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
        {
          i = 0;
          while (i < this.jdField_a_of_type_JavaUtilList.size())
          {
            QLog.i("SelectPositionModule", 2, "handle0xdc0WhiteList result, City = " + this.jdField_a_of_type_JavaUtilList.get(i));
            i += 1;
          }
        }
        QLog.i("SelectPositionModule", 2, "handle0xdc0WhiteList result, mCityWhiteList is empty");
      }
      if (this.jdField_a_of_type_Pbp != null) {
        this.jdField_a_of_type_Pbp.a(this.jdField_a_of_type_JavaUtilList);
      }
      if (paramToServiceMsg.extraData.getBoolean("need_check_local_city_changed", true)) {
        d();
      }
    }
  }
  
  private void c(SelectPositionModule.PositionData paramPositionData)
  {
    SelectPositionModule.PositionData localPositionData = e();
    if (paramPositionData.equals(localPositionData)) {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPositionModule", 2, "handleLocalChannel currentGPSPosition.equals(lastGPSPosition) lastGPSPosition = " + localPositionData);
      }
    }
    do
    {
      return;
      this.b = c();
      if (!paramPositionData.equals(this.b)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SelectPositionModule", 2, "handleLocalChannel currentGPSPosition.equals(lastGPSPosition) currentGPSPosition = " + paramPositionData);
    return;
    if ((System.currentTimeMillis() - this.jdField_a_of_type_Long >= 86400000L) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPositionModule", 2, "handleLocalChannel currentGPSPosition.equals(lastGPSPosition) currentGPSPosition = " + paramPositionData);
      }
      a(true);
      return;
    }
    d();
  }
  
  private SelectPositionModule.PositionData d()
  {
    return a("key_selected_position");
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SelectPositionModule", 2, "checkNeedChangeLocalCity checkNeedChangeLocalCity mGPSPositionData = " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData);
    }
    SelectPositionModule.PositionData localPositionData;
    if (this.b != null)
    {
      localPositionData = this.b;
      if (!a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData)) {
        break label174;
      }
      b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData);
      if ((!a(localPositionData)) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData.equals(localPositionData))) {
        break label137;
      }
      osm.a().a(1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData);
      if (QLog.isColorLevel()) {
        QLog.i("SelectPositionModule", 2, "checkNeedChangeLocalCity changeCity lastPositionData = " + localPositionData);
      }
    }
    label137:
    label174:
    do
    {
      do
      {
        do
        {
          return;
          localPositionData = e();
          break;
          b();
        } while (!QLog.isColorLevel());
        QLog.i("SelectPositionModule", 2, "checkNeedChangeLocalCity clearSelectedPositionData mSelectedPositionData = " + localPositionData);
        return;
      } while (!a(localPositionData));
      osm.a().a(2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData);
    } while (!QLog.isColorLevel());
    QLog.i("SelectPositionModule", 2, "checkNeedChangeLocalCity reserveCity mSelectedPositionData = " + localPositionData);
  }
  
  private void d(SelectPositionModule.PositionData paramPositionData)
  {
    a(paramPositionData, "key_gps_position");
  }
  
  private SelectPositionModule.PositionData e()
  {
    return a("key_gps_position");
  }
  
  public SelectPositionModule.PositionData a()
  {
    if (this.b != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SelectPositionModule", 2, "positionData = " + this.b);
      }
      return this.b;
    }
    this.b = d();
    if (QLog.isColorLevel()) {
      QLog.i("SelectPositionModule", 2, "getSelectedPositionDataLastTime = " + this.b);
    }
    if (this.b != null) {
      return this.b;
    }
    return b();
  }
  
  public List<pcp> a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPositionModule", 2, "getCityWhiteList mCityWhiteList is not empty");
      }
      return this.jdField_a_of_type_JavaUtilList;
    }
    a(false);
    if (QLog.isColorLevel()) {
      QLog.d("SelectPositionModule", 2, "getCityWhiteList mCityWhiteList is empty");
    }
    return null;
  }
  
  public void a()
  {
    QLog.d("SelectPositionModule", 2, "requestCurrentLoction");
    if (this.jdField_a_of_type_Akup == null) {
      this.jdField_a_of_type_Akup = new pbo(this, 3, true, true, 0L, false, false, "readinjoy_position");
    }
    SosoInterface.a(this.jdField_a_of_type_Akup);
  }
  
  public void a(SelectPositionModule.PositionData paramPositionData)
  {
    if (paramPositionData == null) {
      QLog.i("SelectPositionModule", 2, "saveSelectedPositionData positionData == null");
    }
    this.b = paramPositionData;
    a(paramPositionData, "key_selected_position");
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xdc0")) {
      ThreadManager.getUIHandler().post(new SelectPositionModule.2(this, paramToServiceMsg, paramFromServiceMsg, paramObject));
    }
  }
  
  public void a(pbp parampbp)
  {
    this.jdField_a_of_type_Pbp = parampbp;
  }
  
  public boolean a(SelectPositionModule.PositionData paramPositionData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelectPositionModule", 2, "checkPositionInCityWhiteList currentPosition = " + paramPositionData);
    }
    if (paramPositionData == null) {
      QLog.e("SelectPositionModule", 2, "checkPositionInCityWhiteList currentPosition == null");
    }
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        pcp localpcp = (pcp)this.jdField_a_of_type_JavaUtilList.get(i);
        if (paramPositionData.cityCode.equals(localpcp.e))
        {
          if (QLog.isColorLevel()) {
            QLog.d("SelectPositionModule", 2, "checkPositionInCityWhiteList true currentPosition = " + paramPositionData);
          }
          return true;
        }
        i += 1;
      }
    }
  }
  
  public SelectPositionModule.PositionData b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SelectPositionModule", 2, "getGPSPositionData mGPSPositionData = " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData = e();
      if (QLog.isColorLevel()) {
        QLog.i("SelectPositionModule", 2, "getGPSPositionDataLastTime mGPSPositionData = " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData);
      }
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData;
  }
  
  public void b()
  {
    a("key_selected_position");
  }
  
  public void b(SelectPositionModule.PositionData paramPositionData)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      pcp localpcp = (pcp)this.jdField_a_of_type_JavaUtilList.get(i);
      if (paramPositionData.cityCode.equals(localpcp.e)) {
        paramPositionData.city = localpcp.b;
      }
      i += 1;
    }
  }
  
  public SelectPositionModule.PositionData c()
  {
    if (this.b == null) {
      this.b = d();
    }
    if (QLog.isColorLevel()) {
      QLog.d("SelectPositionModule", 2, "getSelectedPositionData mSelectedPositionData = " + this.b);
    }
    return this.b;
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule
 * JD-Core Version:    0.7.0.1
 */