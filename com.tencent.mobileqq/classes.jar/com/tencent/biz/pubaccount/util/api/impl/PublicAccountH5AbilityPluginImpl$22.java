package com.tencent.biz.pubaccount.util.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import org.json.JSONException;
import org.json.JSONObject;

class PublicAccountH5AbilityPluginImpl$22
  implements ITroopMemberApiClientApi.Callback
{
  PublicAccountH5AbilityPluginImpl$22(PublicAccountH5AbilityPluginImpl paramPublicAccountH5AbilityPluginImpl, String paramString, boolean paramBoolean) {}
  
  public void callback(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountH5AbilityPluginImpl.activity != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountH5AbilityPluginImpl.cancleProgressDailog();
      }
      String str = paramBundle.getString("pic_server_id");
      this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountH5AbilityPluginImpl.startNextUploadTask(paramBundle);
      if ("-1".equals(str))
      {
        paramBundle = new JSONObject();
        try
        {
          paramBundle.put("retCode", -1);
          paramBundle.put("msg", "fail");
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
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
      this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountH5AbilityPluginImpl.sendUuidForMediaIdRequest(localJSONException, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl.22
 * JD-Core Version:    0.7.0.1
 */