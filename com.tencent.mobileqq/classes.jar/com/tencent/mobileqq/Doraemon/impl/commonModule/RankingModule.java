package com.tencent.mobileqq.Doraemon.impl.commonModule;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.DoraemonAPIModule;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xb85.Oidb_0xb85.GetRankListReqBody;
import tencent.im.oidb.cmd0xb85.Oidb_0xb85.ReportScoreReqBody;
import tencent.im.oidb.cmd0xb85.Oidb_0xb85.ReqBody;
import tencent.im.oidb.ranklist_comm.ranklist_comm.ExtraParam;
import tencent.im.oidb.ranklist_comm.ranklist_comm.ReportItem;

public class RankingModule
  extends DoraemonAPIModule
{
  public static final String a;
  private final String b = "OidbSvc.0xb85";
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DoraemonOpenAPI.");
    localStringBuilder.append(RankingModule.class.getSimpleName());
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  private void a(JSONObject paramJSONObject, APICallback paramAPICallback)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append(".getRankingList");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("params = ");
      ((StringBuilder)localObject2).append(paramJSONObject);
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    int i = paramJSONObject.optInt("rankingID", 0);
    int j = paramJSONObject.optInt("topCount", 10);
    Object localObject1 = paramJSONObject.optString("rankKey", "");
    int k = paramJSONObject.optInt("rankValueType", 0);
    int m = paramJSONObject.optInt("rankOrderType", 0);
    if (i <= 0)
    {
      DoraemonUtil.a(paramAPICallback, -100, "rankingID must be bigger than 0");
      return;
    }
    Object localObject3 = (UserInfoModule)this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a(UserInfoModule.class, false);
    if (localObject3 == null)
    {
      DoraemonUtil.a(paramAPICallback, -10, "internal error, try again.");
      return;
    }
    Object localObject2 = new Oidb_0xb85.ReqBody();
    localObject3 = ((UserInfoModule)localObject3).a();
    ((Oidb_0xb85.ReqBody)localObject2).appid.set(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.jdField_a_of_type_JavaLangString).intValue());
    ((Oidb_0xb85.ReqBody)localObject2).service_id.set(this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.jdField_a_of_type_Int);
    ((Oidb_0xb85.ReqBody)localObject2).openid.set(((UserInfoModule.LoginInfo)localObject3).jdField_a_of_type_JavaLangString);
    ((Oidb_0xb85.ReqBody)localObject2).openkey.set(((UserInfoModule.LoginInfo)localObject3).b);
    Oidb_0xb85.GetRankListReqBody localGetRankListReqBody = new Oidb_0xb85.GetRankListReqBody();
    localGetRankListReqBody.ranklist_id.set(i);
    localGetRankListReqBody.top_count.set(j);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      localGetRankListReqBody.rank_key.set((String)localObject1);
    }
    localGetRankListReqBody.rank_value_type.set(k);
    localGetRankListReqBody.rank_order_type.set(m);
    ((Oidb_0xb85.ReqBody)localObject2).get_ranklist_req.set(localGetRankListReqBody);
    ProtoUtils.a(BaseApplicationImpl.getApplication().getRuntime(), new RankingModule.1(this, (UserInfoModule.LoginInfo)localObject3, paramJSONObject, paramAPICallback), ((Oidb_0xb85.ReqBody)localObject2).toByteArray(), "OidbSvc.0xb85", 2949, 2, null, 0L);
  }
  
  private void b(JSONObject paramJSONObject, APICallback paramAPICallback)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append(".reportScore");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("params = ");
      ((StringBuilder)localObject2).append(paramJSONObject);
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    int i = paramJSONObject.optInt("rankingID", 0);
    Object localObject1 = paramJSONObject.optJSONArray("scoreList");
    if (i <= 0)
    {
      DoraemonUtil.a(paramAPICallback, -100, "rankingID 没有传或者值小于等于0");
      return;
    }
    Object localObject3 = (UserInfoModule)this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a(UserInfoModule.class, false);
    if (localObject3 == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "reportScore, getAPIModule UserInfoModule return null");
      return;
    }
    Object localObject2 = new Oidb_0xb85.ReqBody();
    localObject3 = ((UserInfoModule)localObject3).a();
    ((Oidb_0xb85.ReqBody)localObject2).appid.set(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.jdField_a_of_type_JavaLangString).intValue());
    ((Oidb_0xb85.ReqBody)localObject2).service_id.set(this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.jdField_a_of_type_Int);
    ((Oidb_0xb85.ReqBody)localObject2).openid.set(((UserInfoModule.LoginInfo)localObject3).jdField_a_of_type_JavaLangString);
    ((Oidb_0xb85.ReqBody)localObject2).openkey.set(((UserInfoModule.LoginInfo)localObject3).b);
    Oidb_0xb85.ReportScoreReqBody localReportScoreReqBody = new Oidb_0xb85.ReportScoreReqBody();
    localReportScoreReqBody.ranklist_id.set(i);
    try
    {
      i = ((JSONArray)localObject1).length();
      int k = 0;
      while (k < i)
      {
        Object localObject4 = ((JSONArray)localObject1).getJSONObject(k);
        ranklist_comm.ReportItem localReportItem = new ranklist_comm.ReportItem();
        localReportItem.openid.set(((JSONObject)localObject4).getString("openid"));
        localReportItem.score.set(((JSONObject)localObject4).getInt("score"));
        localObject4 = ((JSONObject)localObject4).optJSONArray("extraList");
        int j = i;
        if (localObject4 != null)
        {
          int n = ((JSONArray)localObject4).length();
          int m = 0;
          for (;;)
          {
            j = i;
            if (m >= n) {
              break;
            }
            JSONObject localJSONObject = ((JSONArray)localObject4).getJSONObject(m);
            ranklist_comm.ExtraParam localExtraParam = new ranklist_comm.ExtraParam();
            localExtraParam.param_key.set(localJSONObject.getString("key"));
            localExtraParam.param_value.set(localJSONObject.getInt("value"));
            localExtraParam.param_type.set(localJSONObject.getInt("type"));
            localReportItem.rpt_extra_param.add(localExtraParam);
            m += 1;
          }
        }
        localReportScoreReqBody.rpt_report_item.add(localReportItem);
        k += 1;
        i = j;
      }
      ((Oidb_0xb85.ReqBody)localObject2).report_score_req.set(localReportScoreReqBody);
      ProtoUtils.a(BaseApplicationImpl.getApplication().getRuntime(), new RankingModule.2(this, (UserInfoModule.LoginInfo)localObject3, paramJSONObject, paramAPICallback), ((Oidb_0xb85.ReqBody)localObject2).toByteArray(), "OidbSvc.0xb85", 2949, 1, null, 0L);
      return;
    }
    catch (Exception paramJSONObject)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("参数处理错误, 是否是类型不对? 查看一下文档吧. \nerrorMsg: ");
      ((StringBuilder)localObject1).append(paramJSONObject.getMessage());
      DoraemonUtil.a(paramAPICallback, -101, ((StringBuilder)localObject1).toString());
    }
  }
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull APICallback paramAPICallback)
  {
    if (paramInt != 8)
    {
      if (paramInt != 24) {
        return false;
      }
      b(paramJSONObject, paramAPICallback);
    }
    else
    {
      a(paramJSONObject, paramAPICallback);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.commonModule.RankingModule
 * JD-Core Version:    0.7.0.1
 */