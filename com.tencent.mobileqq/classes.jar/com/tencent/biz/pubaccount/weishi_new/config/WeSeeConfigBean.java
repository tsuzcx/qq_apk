package com.tencent.biz.pubaccount.weishi_new.config;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.config.QConfItem;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class WeSeeConfigBean
{
  public WeSeeBeaconReportConfigInfo a;
  public WeSeeStrategyConfigInfo a;
  public WeSeeVideoPluginConfigInfo a;
  public WeSeeWnsConfigInfo a;
  
  public WeSeeConfigBean()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newConfigWeSeeVideoPluginConfigInfo = new WeSeeVideoPluginConfigInfo(null);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newConfigWeSeeStrategyConfigInfo = new WeSeeStrategyConfigInfo(null);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newConfigWeSeeBeaconReportConfigInfo = new WeSeeBeaconReportConfigInfo(null);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newConfigWeSeeWnsConfigInfo = new WeSeeWnsConfigInfo(null);
  }
  
  private static JSONObject a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        return paramString;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  private void a(@NotNull JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newConfigWeSeeVideoPluginConfigInfo = WeSeeVideoPluginConfigInfo.a(paramJSONObject.optJSONObject("video_plugin_threshold"));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newConfigWeSeeStrategyConfigInfo = WeSeeStrategyConfigInfo.a(paramJSONObject.optJSONObject("trends_tab_strategy"));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newConfigWeSeeBeaconReportConfigInfo = WeSeeBeaconReportConfigInfo.a(paramJSONObject.optJSONObject("beacon_report_strategy"));
  }
  
  public boolean a(QConfItem[] paramArrayOfQConfItem)
  {
    int i = 0;
    if (paramArrayOfQConfItem != null)
    {
      if (paramArrayOfQConfItem.length <= 0) {
        return false;
      }
      int j = paramArrayOfQConfItem.length;
      while (i < j)
      {
        Object localObject1 = paramArrayOfQConfItem[i];
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("content:");
        ((StringBuilder)localObject2).append(((QConfItem)localObject1).a);
        WSLog.e("WeSeeConfigBean", ((StringBuilder)localObject2).toString());
        localObject1 = a(((QConfItem)localObject1).a);
        if (localObject1 != null)
        {
          localObject2 = ((JSONObject)localObject1).optString("task_id");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("taskId:");
          localStringBuilder.append((String)localObject2);
          WSLog.a("WeSeeConfigBean", localStringBuilder.toString());
          if (TextUtils.equals((CharSequence)localObject2, "0002")) {
            this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newConfigWeSeeWnsConfigInfo = WeSeeWnsConfigInfo.a(((JSONObject)localObject1).optJSONObject("wsgzh_req_cmd_strategy"));
          } else {
            a((JSONObject)localObject1);
          }
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WeSeeConfigBean{mPluginConfigInfo=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newConfigWeSeeVideoPluginConfigInfo);
    localStringBuilder.append(", mStrategyConfig=");
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newConfigWeSeeStrategyConfigInfo;
    if (localObject != null) {
      localObject = ((WeSeeStrategyConfigInfo)localObject).a;
    } else {
      localObject = "null";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("mBeaconConfigInfo=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newConfigWeSeeBeaconReportConfigInfo);
    localStringBuilder.append("mWeSeeWnsConfigInfo=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newConfigWeSeeWnsConfigInfo);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.config.WeSeeConfigBean
 * JD-Core Version:    0.7.0.1
 */