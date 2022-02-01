package com.tencent.mobileqq.activity.troop.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IBizTroopInfoService;
import com.tencent.mobileqq.troop.api.config.AbsTroopSurveyHandlerProcessor;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xb36.oidb_cmd0xb36.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopSurveyHandlerProcessor
  extends AbsTroopSurveyHandlerProcessor
{
  public void a(@NonNull AppInterface paramAppInterface, @NonNull ToServiceMsg paramToServiceMsg, String paramString, @NonNull oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    paramToServiceMsg = new oidb_cmd0xb36.RspBody();
    try
    {
      paramToServiceMsg.mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
      ((IBizTroopInfoService)paramAppInterface.getRuntimeService(IBizTroopInfoService.class, "")).updateTroopSurveyList(paramToServiceMsg);
      return;
    }
    catch (Exception paramAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.survey", 2, "handle_oidb_0xb36_1:", paramAppInterface);
      }
    }
  }
  
  public void a(@NonNull String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      try
      {
        ((IArkAPIService)QRoute.api(IArkAPIService.class)).postArkNotify("com.tencent.test.groupDragon", "UpdateDragonTitle", localJSONObject.toString());
        ((IArkAPIService)QRoute.api(IArkAPIService.class)).postArkNotify("com.tencent.groupDragon", "UpdateDragonTitle", localJSONObject.toString());
        return;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        QLog.e(".troop.survey", 2, "Error: arkNotify com.tencent.groupDragon error, .so notloaded", localUnsatisfiedLinkError);
        return;
      }
      StringBuilder localStringBuilder;
      return;
    }
    catch (JSONException localJSONException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Error: json decode error, string is ");
      localStringBuilder.append(paramString);
      QLog.e(".troop.survey", 2, localStringBuilder.toString(), localJSONException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.config.TroopSurveyHandlerProcessor
 * JD-Core Version:    0.7.0.1
 */