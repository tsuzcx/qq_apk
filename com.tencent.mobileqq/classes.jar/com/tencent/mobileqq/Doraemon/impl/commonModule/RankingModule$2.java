package com.tencent.mobileqq.Doraemon.impl.commonModule;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.APIParam;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class RankingModule$2
  extends ProtoUtils.TroopProtocolObserver
{
  RankingModule$2(RankingModule paramRankingModule, UserInfoModule.LoginInfo paramLoginInfo, JSONObject paramJSONObject, APICallback paramAPICallback) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = RankingModule.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResult appid=");
      localStringBuilder.append(RankingModule.b(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleRankingModule).a);
      localStringBuilder.append(", openid=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule$LoginInfo.a);
      localStringBuilder.append(", openkey=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule$LoginInfo.b);
      localStringBuilder.append(", code=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", req param=");
      localStringBuilder.append(this.jdField_a_of_type_OrgJsonJSONObject);
      QLog.i(paramBundle, 2, localStringBuilder.toString());
    }
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, APIParam.jdField_a_of_type_OrgJsonJSONObject);
      return;
    }
    DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, paramInt, "reportScore result error, try again");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.commonModule.RankingModule.2
 * JD-Core Version:    0.7.0.1
 */