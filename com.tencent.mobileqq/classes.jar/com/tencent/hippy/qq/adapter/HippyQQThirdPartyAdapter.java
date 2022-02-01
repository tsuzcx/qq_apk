package com.tencent.hippy.qq.adapter;

import com.tencent.mtt.hippy.adapter.thirdparty.HippyThirdPartyAdapter;

public class HippyQQThirdPartyAdapter
  extends HippyThirdPartyAdapter
{
  protected String mPageUrl;
  
  public HippyQQThirdPartyAdapter() {}
  
  public HippyQQThirdPartyAdapter(Object paramObject)
  {
    super(paramObject);
  }
  
  public void SetHippyBridgeId(long paramLong) {}
  
  public String getAppVersion()
  {
    return "8.4.5";
  }
  
  public String getPackageName()
  {
    return "mqq";
  }
  
  public String getPageUrl()
  {
    return this.mPageUrl;
  }
  
  public void setPageUrl(String paramString)
  {
    this.mPageUrl = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.adapter.HippyQQThirdPartyAdapter
 * JD-Core Version:    0.7.0.1
 */