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
      paramBundle = RankingModule.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResult appid=");
      localStringBuilder.append(RankingModule.b(this.d).b);
      localStringBuilder.append(", openid=");
      localStringBuilder.append(this.a.a);
      localStringBuilder.append(", openkey=");
      localStringBuilder.append(this.a.b);
      localStringBuilder.append(", code=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", req param=");
      localStringBuilder.append(this.b);
      QLog.i(paramBundle, 2, localStringBuilder.toString());
    }
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      DoraemonUtil.a(this.c, APIParam.a);
      return;
    }
    DoraemonUtil.a(this.c, paramInt, "reportScore result error, try again");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.commonModule.RankingModule.2
 * JD-Core Version:    0.7.0.1
 */