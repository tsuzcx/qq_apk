package com.tencent.biz.pubaccount.util.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.mp.mobileqq_mp.JSApiWebServerResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

class PublicAccountH5AbilityPluginImpl$17
  implements BusinessObserver
{
  PublicAccountH5AbilityPluginImpl$17(PublicAccountH5AbilityPluginImpl paramPublicAccountH5AbilityPluginImpl, String paramString1, int paramInt, boolean paramBoolean, String paramString2) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = paramBundle.getByteArray("data");
      if (localObject == null) {}
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
          localObject = new JSONObject(paramBundle);
          int j = ((JSONObject)localObject).optInt("ret");
          paramBundle = ((JSONObject)localObject).optString("msg");
          i = ((JSONObject)localObject).optInt("subcmd");
          if (j == 0)
          {
            j = ((JSONObject)localObject).optInt("type");
            if (j == 2)
            {
              paramBundle = ((JSONObject)localObject).optString("url");
              localObject = ((JSONObject)localObject).optString("mediaid");
              if (paramBundle.equals(""))
              {
                JSONObject localJSONObject = new JSONObject();
                try
                {
                  localJSONObject.put("retCode", -1);
                  localJSONObject.put("msg", "mediaId for serverId error");
                }
                catch (JSONException localJSONException4)
                {
                  localJSONException4.printStackTrace();
                }
                this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountH5AbilityPluginImpl.callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
                this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountH5AbilityPluginImpl.startNextDownloadTask((String)localObject);
                ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D28", "0X8005D28", 0, -1, "1", "", "", "");
              }
              else
              {
                this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountH5AbilityPluginImpl.startDownload(this.jdField_a_of_type_Int, paramBundle, (String)localObject, true, this.jdField_a_of_type_JavaLangString);
              }
            }
            else
            {
              if (j != 4) {
                continue;
              }
              paramBundle = ((JSONObject)localObject).optString("file_uuid");
              if (paramBundle.equals(""))
              {
                localObject = new JSONObject();
                try
                {
                  ((JSONObject)localObject).put("retCode", -1);
                  ((JSONObject)localObject).put("msg", "mediaId for serverId error");
                }
                catch (JSONException localJSONException3)
                {
                  localJSONException3.printStackTrace();
                }
                this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountH5AbilityPluginImpl.callJs(this.jdField_a_of_type_JavaLangString, new String[] { ((JSONObject)localObject).toString() });
                ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D31", "0X8005D31", 0, -1, "1", "", "", "");
              }
              else
              {
                localObject = ((JSONObject)localObject).optString("mediaid");
                this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountH5AbilityPluginImpl.startDownload(this.jdField_a_of_type_Int, paramBundle, (String)localObject, false, this.jdField_a_of_type_JavaLangString);
              }
            }
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("sendMediaIdForUuidRequest serverId = ");
              ((StringBuilder)localObject).append(paramBundle);
              ((StringBuilder)localObject).append("  type = ");
              ((StringBuilder)localObject).append(paramInt);
              ((StringBuilder)localObject).append(" subCom=");
              ((StringBuilder)localObject).append(i);
              QLog.i("PublicAccountH5AbilityPlugin", 2, ((StringBuilder)localObject).toString());
            }
          }
          else
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("sendMediaIdForUuidRequest errorMsg = ");
              ((StringBuilder)localObject).append(paramBundle);
              QLog.i("PublicAccountH5AbilityPlugin", 2, ((StringBuilder)localObject).toString());
            }
            paramBundle = new JSONObject();
            try
            {
              paramBundle.put("retCode", -1);
              paramBundle.put("msg", "mediaId for serverId error");
            }
            catch (JSONException localJSONException1)
            {
              localJSONException1.printStackTrace();
            }
            this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountH5AbilityPluginImpl.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramBundle.toString() });
            if (this.jdField_a_of_type_Boolean)
            {
              this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountH5AbilityPluginImpl.startNextDownloadTask(this.b);
              ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D28", "0X8005D28", 0, -1, "1", "", "", "");
              return;
            }
            ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D31", "0X8005D31", 0, -1, "1", "", "", "");
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            paramBundle = new StringBuilder();
            paramBundle.append("sendMediaIdForUuidRequest errorMsg = ");
            paramBundle.append(localJSONException1);
            QLog.i("PublicAccountH5AbilityPlugin", 2, paramBundle.toString());
          }
          paramBundle = new JSONObject();
          try
          {
            paramBundle.put("retCode", -1);
            paramBundle.put("msg", "mediaId for serverId error");
          }
          catch (JSONException localJSONException2)
          {
            localJSONException2.printStackTrace();
          }
          this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountH5AbilityPluginImpl.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramBundle.toString() });
          if (this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountH5AbilityPluginImpl.startNextDownloadTask(this.b);
            ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D28", "0X8005D28", 0, -1, "1", "", "", "");
            return;
          }
          ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D31", "0X8005D31", 0, -1, "1", "", "", "");
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl.17
 * JD-Core Version:    0.7.0.1
 */