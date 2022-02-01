package com.tencent.hippy.qq.app;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.hippy.TkdAdHippyViewCreator;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class TKDHippyEngine
  extends HippyQQEngine
{
  public TKDHippyEngine(Fragment paramFragment, String paramString1, String paramString2)
  {
    super(paramFragment, paramString1, paramString2);
    this.providers.add(new TKDApiProvider());
    this.viewCreator = new TkdAdHippyViewCreator();
  }
  
  protected void initJsBundleTypeFromUrl()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.app.TKDHippyEngine
 * JD-Core Version:    0.7.0.1
 */