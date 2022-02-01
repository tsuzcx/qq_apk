package com.tencent.hippy.qq.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.adapter.font.HippyFontScaleAdapter;
import com.tencent.mtt.hippy.adapter.http.HippyHttpAdapter;
import com.tencent.mtt.hippy.adapter.image.HippyImageLoader;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter;
import com.tencent.mtt.hippy.adapter.thirdparty.HippyThirdPartyAdapter;

@QAPI(process={"all"})
public abstract interface IHippyAdapter
  extends QRouteApi
{
  public abstract HippyImageLoader creatImageLoader();
  
  public abstract HippyEngineMonitorAdapter createEngineMonitorAdapter();
  
  public abstract HippyFontScaleAdapter createFontScaleAdapter();
  
  public abstract HippyHttpAdapter createHttpAdapter();
  
  public abstract HippyThirdPartyAdapter createThirdPartyAdapter();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.api.IHippyAdapter
 * JD-Core Version:    0.7.0.1
 */