package com.tencent.biz.pubaccount.util.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.mp.mobileqq_mp.JSApiWebServerResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

class PublicAccountH5AbilityPluginImpl$16
  implements BusinessObserver
{
  PublicAccountH5AbilityPluginImpl$16(PublicAccountH5AbilityPluginImpl paramPublicAccountH5AbilityPluginImpl, boolean paramBoolean, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = paramBundle.getByteArray("data");
      if (localObject == null) {
        break label983;
      }
    }
    for (paramBundle = new mobileqq_mp.JSApiWebServerResponse();; paramBundle = "")
    {
      try
      {
        paramBundle.mergeFrom((byte[])localObject);
        localObject = (mobileqq_mp.RetInfo)paramBundle.ret_info.get();
        paramBundle = paramBundle.body.get();
        int i = ((mobileqq_mp.RetInfo)localObject).ret_code.get();
        localObject = ((mobileqq_mp.RetInfo)localObject).err_info.get();
        new JSONObject();
        if (i == 0)
        {
          paramBundle = new JSONObject(paramBundle);
          i = paramBundle.optInt("ret");
          localObject = paramBundle.optString("msg");
          if (i == 0)
          {
            localObject = paramBundle.optString("mediaid");
            i = paramBundle.optInt("subcmd");
            int j = paramBundle.optInt("type");
            if (j == 2)
            {
              paramBundle = paramBundle.optString("url");
            }
            else
            {
              if (j != 4) {
                continue;
              }
              paramBundle = paramBundle.optString("file_uuid");
            }
            StringBuilder localStringBuilder;
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("sendUuidForMediaIdRequest mediaId = ");
              localStringBuilder.append((String)localObject);
              localStringBuilder.append(" type=");
              localStringBuilder.append(paramInt);
              localStringBuilder.append(" serverId:");
              localStringBuilder.append(paramBundle);
              localStringBuilder.append(" subCom=");
              localStringBuilder.append(i);
              QLog.i("PublicAccountH5AbilityPlugin", 2, localStringBuilder.toString());
            }
            paramBundle = new JSONObject();
            try
            {
              if ("".equals(localObject))
              {
                paramBundle.put("retCode", -1);
                paramBundle.put("msg", "uuid for mediaid error");
                if (this.jdField_a_of_type_Boolean) {
                  ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D27", "0X8005D27", 0, -1, "1", "", "", "", false);
                } else {
                  ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D30", "0X8005D30", 0, -1, "1", "", "", "");
                }
              }
              else
              {
                paramBundle.put("retCode", 0);
                localStringBuilder = new StringBuilder();
                localStringBuilder.append(HardCodeUtil.a(2131708745));
                localStringBuilder.append((String)localObject);
                paramBundle.put("msg", localStringBuilder.toString());
                if (this.jdField_a_of_type_Boolean) {
                  ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D27", "0X8005D27", 0, 0, "1", "", "", "", false);
                } else {
                  ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D30", "0X8005D30", 0, 0, "1", "", "", "");
                }
              }
              paramBundle.put("serverId", localObject);
            }
            catch (JSONException localJSONException1)
            {
              localJSONException1.printStackTrace();
            }
            this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountH5AbilityPluginImpl.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramBundle.toString() });
            return;
          }
          if (QLog.isColorLevel())
          {
            paramBundle = new StringBuilder();
            paramBundle.append("sendUuidForMediaIdRequest errorMsg = ");
            paramBundle.append(localJSONException1);
            QLog.i("PublicAccountH5AbilityPlugin", 2, paramBundle.toString());
          }
          paramBundle = new JSONObject();
          try
          {
            paramBundle.put("retCode", -1);
            paramBundle.put("msg", "uuid for mediaid error");
          }
          catch (JSONException localJSONException2)
          {
            localJSONException2.printStackTrace();
          }
          this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountH5AbilityPluginImpl.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramBundle.toString() });
          if (this.jdField_a_of_type_Boolean)
          {
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D27", "0X8005D27", 0, -1, "1", "", "", "", false);
            return;
          }
          ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D30", "0X8005D30", 0, -1, "1", "", "", "");
          return;
        }
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("sendUuidForMediaIdRequest errorMsg = ");
          paramBundle.append(localJSONException2);
          QLog.i("PublicAccountH5AbilityPlugin", 2, paramBundle.toString());
        }
        paramBundle = new JSONObject();
        try
        {
          paramBundle.put("retCode", -1);
          paramBundle.put("msg", "uuid for mediaid error");
        }
        catch (JSONException localJSONException3)
        {
          localJSONException3.printStackTrace();
        }
        this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountH5AbilityPluginImpl.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramBundle.toString() });
        if (this.jdField_a_of_type_Boolean)
        {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D27", "0X8005D27", 0, -1, "1", "", "", "", false);
          return;
        }
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D30", "0X8005D30", 0, -1, "1", "", "", "");
        return;
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
      try
      {
        paramBundle = new JSONObject();
        paramBundle.put("retCode", -1);
        paramBundle.put("msg", "uuid for mediaid error");
        this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountH5AbilityPluginImpl.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramBundle.toString() });
        if (this.jdField_a_of_type_Boolean)
        {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D27", "0X8005D27", 0, -1, "1", "", "", "", false);
          return;
        }
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D30", "0X8005D30", 0, -1, "1", "", "", "");
        return;
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
      }
      label983:
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl.16
 * JD-Core Version:    0.7.0.1
 */