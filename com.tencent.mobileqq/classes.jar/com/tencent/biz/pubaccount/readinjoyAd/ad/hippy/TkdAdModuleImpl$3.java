package com.tencent.biz.pubaccount.readinjoyAd.ad.hippy;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyGlobalConfigs;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;

class TkdAdModuleImpl$3
  implements Runnable
{
  TkdAdModuleImpl$3(TkdAdModuleImpl paramTkdAdModuleImpl, HippyMap paramHippyMap, HippyEngineContext paramHippyEngineContext) {}
  
  public void run()
  {
    try
    {
      String str1 = this.a.getString("title");
      if (!TextUtils.isEmpty(str1))
      {
        ((TextView)((Activity)this.b.getGlobalConfigs().getContext()).findViewById(2131436227)).setText(str1);
        return;
      }
    }
    catch (Exception localException)
    {
      String str2 = TkdAdModuleImpl.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setTitle error:");
      localStringBuilder.append(localException.getMessage());
      QLog.d(str2, 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.hippy.TkdAdModuleImpl.3
 * JD-Core Version:    0.7.0.1
 */