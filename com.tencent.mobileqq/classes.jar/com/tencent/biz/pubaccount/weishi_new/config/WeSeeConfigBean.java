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
    if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length <= 0)) {
      return false;
    }
    int j = paramArrayOfQConfItem.length;
    if (i < j)
    {
      Object localObject = paramArrayOfQConfItem[i];
      WSLog.e("WeSeeConfigBean", "content:" + ((QConfItem)localObject).a);
      localObject = a(((QConfItem)localObject).a);
      if (localObject == null) {}
      for (;;)
      {
        i += 1;
        break;
        String str = ((JSONObject)localObject).optString("task_id");
        WSLog.a("WeSeeConfigBean", "taskId:" + str);
        if (TextUtils.equals(str, "0002")) {
          this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newConfigWeSeeWnsConfigInfo = WeSeeWnsConfigInfo.a(((JSONObject)localObject).optJSONObject("wsgzh_req_cmd_strategy"));
        } else {
          a((JSONObject)localObject);
        }
      }
    }
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("WeSeeConfigBean{mPluginConfigInfo=").append(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newConfigWeSeeVideoPluginConfigInfo).append(", mStrategyConfig=");
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newConfigWeSeeStrategyConfigInfo != null) {}
    for (String str = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newConfigWeSeeStrategyConfigInfo.a;; str = "null") {
      return str + "mBeaconConfigInfo=" + this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newConfigWeSeeBeaconReportConfigInfo + "mWeSeeWnsConfigInfo=" + this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newConfigWeSeeWnsConfigInfo + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.config.WeSeeConfigBean
 * JD-Core Version:    0.7.0.1
 */