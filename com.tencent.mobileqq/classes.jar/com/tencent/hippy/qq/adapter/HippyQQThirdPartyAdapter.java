package com.tencent.hippy.qq.adapter;

import com.tencent.mtt.hippy.adapter.thirdparty.HippyThirdPartyAdapter;
import org.json.JSONObject;

public class HippyQQThirdPartyAdapter
  extends HippyThirdPartyAdapter
{
  protected JSONObject mExtraData;
  protected String mPageUrl;
  
  public String getAppVersion()
  {
    return "8.8.17";
  }
  
  public JSONObject getExtraData()
  {
    return this.mExtraData;
  }
  
  public String getPackageName()
  {
    return "mqq";
  }
  
  public String getPageUrl()
  {
    return this.mPageUrl;
  }
  
  public void onRuntimeDestroy() {}
  
  public void onRuntimeInit(long paramLong) {}
  
  public void setExtraData(JSONObject paramJSONObject)
  {
    this.mExtraData = paramJSONObject;
  }
  
  public void setPageUrl(String paramString)
  {
    this.mPageUrl = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.adapter.HippyQQThirdPartyAdapter
 * JD-Core Version:    0.7.0.1
 */