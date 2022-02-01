package com.tencent.biz.pubaccount.readinjoyAd.ad.hippy;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.qphone.base.util.QLog;

public class TkdAdHippyEngine
  extends HippyQQEngine
{
  public TkdAdHippyEngine(Fragment paramFragment, String paramString1, String paramString2)
  {
    super(paramFragment, paramString1, paramString2);
    a(paramString1);
  }
  
  public void a(String paramString)
  {
    if (paramString.equals("TKDMiniGame")) {
      this.viewCreator = new TkdAdHippyViewCreator();
    }
  }
  
  public void initJsBundleTypeFromUrl()
  {
    super.initJsBundleTypeFromUrl();
    try
    {
      String str = Uri.parse(this.mUrl).getQueryParameter("component");
      if (!TextUtils.isEmpty(str)) {
        this.componentName = str;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("HippyQQEngine", 2, "error : " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.hippy.TkdAdHippyEngine
 * JD-Core Version:    0.7.0.1
 */