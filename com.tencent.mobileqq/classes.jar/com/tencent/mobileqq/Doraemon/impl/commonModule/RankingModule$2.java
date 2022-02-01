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
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i(RankingModule.a, 2, "onResult appid=" + RankingModule.b(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleRankingModule).a + ", openid=" + this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule$LoginInfo.a + ", openkey=" + this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule$LoginInfo.b + ", code=" + paramInt + ", req param=" + this.jdField_a_of_type_OrgJsonJSONObject);
    }
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, paramInt, "reportScore result error, try again");
      return;
    }
    DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, APIParam.jdField_a_of_type_OrgJsonJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.commonModule.RankingModule.2
 * JD-Core Version:    0.7.0.1
 */