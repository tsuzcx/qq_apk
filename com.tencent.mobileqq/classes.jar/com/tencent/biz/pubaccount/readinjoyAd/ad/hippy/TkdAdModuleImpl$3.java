package com.tencent.biz.pubaccount.readinjoyAd.ad.hippy;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyGlobalConfigs;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import uhe;

public class TkdAdModuleImpl$3
  implements Runnable
{
  public TkdAdModuleImpl$3(uhe paramuhe, HippyMap paramHippyMap, HippyEngineContext paramHippyEngineContext) {}
  
  public void run()
  {
    try
    {
      String str = this.jdField_a_of_type_ComTencentMttHippyCommonHippyMap.getString("title");
      if (!TextUtils.isEmpty(str)) {
        ((TextView)((Activity)this.jdField_a_of_type_ComTencentMttHippyHippyEngineContext.getGlobalConfigs().getContext()).findViewById(2131369278)).setText(str);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d(uhe.a, 2, "setTitle error:" + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.hippy.TkdAdModuleImpl.3
 * JD-Core Version:    0.7.0.1
 */