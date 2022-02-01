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
      String str = this.jdField_a_of_type_ComTencentMttHippyCommonHippyMap.getString("title");
      if (!TextUtils.isEmpty(str)) {
        ((TextView)((Activity)this.jdField_a_of_type_ComTencentMttHippyHippyEngineContext.getGlobalConfigs().getContext()).findViewById(2131369534)).setText(str);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d(TkdAdModuleImpl.a, 2, "setTitle error:" + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.hippy.TkdAdModuleImpl.3
 * JD-Core Version:    0.7.0.1
 */