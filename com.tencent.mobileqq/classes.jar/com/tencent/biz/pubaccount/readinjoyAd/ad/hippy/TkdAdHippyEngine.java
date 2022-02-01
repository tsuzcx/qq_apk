package com.tencent.biz.pubaccount.readinjoyAd.ad.hippy;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.kandian.biz.hippy.api.ITKDHippyBridge;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class TkdAdHippyEngine
  extends HippyQQEngine
{
  public TkdAdHippyEngine(QBaseFragment paramQBaseFragment, String paramString1, String paramString2)
  {
    super(paramQBaseFragment, paramString1, paramString2);
    a(paramString1);
  }
  
  public void a(String paramString)
  {
    if (paramString.equals("TKDMiniGame"))
    {
      this.viewCreator = new TkdAdHippyViewCreator();
      this.providers.add(((ITKDHippyBridge)QRoute.api(ITKDHippyBridge.class)).getTKDApiProvider());
    }
  }
  
  protected void initJsBundleTypeFromUrl()
  {
    super.initJsBundleTypeFromUrl();
    try
    {
      String str = Uri.parse(this.mUrl).getQueryParameter("component");
      if (!TextUtils.isEmpty(str))
      {
        this.componentName = str;
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("error : ");
      localStringBuilder.append(localException.getMessage());
      QLog.d("HippyQQEngine", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.hippy.TkdAdHippyEngine
 * JD-Core Version:    0.7.0.1
 */