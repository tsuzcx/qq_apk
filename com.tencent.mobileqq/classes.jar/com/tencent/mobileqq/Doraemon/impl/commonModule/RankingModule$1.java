package com.tencent.mobileqq.Doraemon.impl.commonModule;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xb85.Oidb_0xb85.GetRankListRspBody;
import tencent.im.oidb.cmd0xb85.Oidb_0xb85.RspBody;
import tencent.im.oidb.ranklist_comm.ranklist_comm.RankItem;

class RankingModule$1
  extends ProtoUtils.TroopProtocolObserver
{
  RankingModule$1(RankingModule paramRankingModule, UserInfoModule.LoginInfo paramLoginInfo, JSONObject paramJSONObject, APICallback paramAPICallback) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      paramBundle = RankingModule.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResult appid=");
      ((StringBuilder)localObject).append(RankingModule.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleRankingModule).a);
      ((StringBuilder)localObject).append(", openid=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule$LoginInfo.a);
      ((StringBuilder)localObject).append(", openkey=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule$LoginInfo.b);
      ((StringBuilder)localObject).append(", code=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", req param=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_OrgJsonJSONObject);
      QLog.i(paramBundle, 2, ((StringBuilder)localObject).toString());
    }
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      paramBundle = new Oidb_0xb85.RspBody();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = paramBundle;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = null;
      }
      if (paramArrayOfByte != null)
      {
        paramBundle = new JSONObject();
        try
        {
          localObject = new JSONArray();
          paramArrayOfByte = (Oidb_0xb85.GetRankListRspBody)paramArrayOfByte.get_ranklist_rsp.get();
          Iterator localIterator = paramArrayOfByte.rpt_rank_item.get().iterator();
          for (;;)
          {
            boolean bool = localIterator.hasNext();
            if (!bool) {
              break;
            }
            ranklist_comm.RankItem localRankItem = (ranklist_comm.RankItem)localIterator.next();
            JSONObject localJSONObject = new JSONObject();
            try
            {
              localJSONObject.put("nickName", localRankItem.nick.get());
              localJSONObject.put("avatarUrl", localRankItem.figure.get());
              localJSONObject.put("score", localRankItem.value.get());
              localJSONObject.put("rank", localRankItem.rank.get());
              ((JSONArray)localObject).put(localJSONObject);
            }
            catch (JSONException localJSONException) {}
            if (QLog.isColorLevel()) {
              QLog.e(RankingModule.a, 2, localJSONException.getMessage(), localJSONException);
            }
          }
          paramBundle.put("rankingList", localObject);
          localObject = new JSONObject();
          paramArrayOfByte = (ranklist_comm.RankItem)paramArrayOfByte.self_rank_item.get();
          ((JSONObject)localObject).put("nickName", paramArrayOfByte.nick.get());
          ((JSONObject)localObject).put("avatarUrl", paramArrayOfByte.figure.get());
          ((JSONObject)localObject).put("score", paramArrayOfByte.value.get());
          ((JSONObject)localObject).put("rank", paramArrayOfByte.rank.get());
          paramBundle.put("selfRank", localObject);
        }
        catch (JSONException paramArrayOfByte)
        {
          if (QLog.isColorLevel()) {
            QLog.e(RankingModule.a, 2, paramArrayOfByte.getMessage(), paramArrayOfByte);
          }
        }
        if (QLog.isDevelopLevel())
        {
          paramArrayOfByte = RankingModule.a;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("result is, ");
          ((StringBuilder)localObject).append(paramBundle.toString());
          QLog.i(paramArrayOfByte, 2, ((StringBuilder)localObject).toString());
        }
        DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, paramBundle);
        return;
      }
      DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, -1, "parse result error, try again");
      return;
    }
    DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, paramInt, "getRankingList result error, try again");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.commonModule.RankingModule.1
 * JD-Core Version:    0.7.0.1
 */