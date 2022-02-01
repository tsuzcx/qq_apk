package com.tencent.biz.pubaccount.weishi_new.request;

import UserGrowth.stGetAllABTestPolicyReq;
import UserGrowth.stGetAllABTestPolicyRsp;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.BaseApplicationImpl;

public class WSGetABTestPolicyRequest
  extends WeishiRequest<stGetAllABTestPolicyRsp>
{
  public WSGetABTestPolicyRequest(String paramString)
  {
    super("GetAllABTestPolicy", 10009);
    stGetAllABTestPolicyReq localstGetAllABTestPolicyReq = new stGetAllABTestPolicyReq();
    localstGetAllABTestPolicyReq.uin = paramString;
    localstGetAllABTestPolicyReq.hasInstalledWeishi = WeishiGuideUtils.a(BaseApplicationImpl.getApplication());
    this.a = localstGetAllABTestPolicyReq;
    WSLog.e("WSGetABTestPolicyRequest", "[WSGetABTestPolicyRequest] uin:" + localstGetAllABTestPolicyReq.uin + ", hasInstalledWeishi:" + localstGetAllABTestPolicyReq.hasInstalledWeishi);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.WSGetABTestPolicyRequest
 * JD-Core Version:    0.7.0.1
 */