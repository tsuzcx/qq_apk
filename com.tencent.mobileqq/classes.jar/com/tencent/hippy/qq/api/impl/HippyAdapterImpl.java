package com.tencent.hippy.qq.api.impl;

import com.tencent.hippy.qq.adapter.HippyQQEngineMonitorAdapter;
import com.tencent.hippy.qq.adapter.HippyQQFontAdapter;
import com.tencent.hippy.qq.adapter.HippyQQHttpAdapter;
import com.tencent.hippy.qq.adapter.HippyQQImageLoader;
import com.tencent.hippy.qq.adapter.HippyQQThirdPartyAdapter;
import com.tencent.hippy.qq.api.IHippyAdapter;
import com.tencent.mtt.hippy.adapter.font.HippyFontScaleAdapter;
import com.tencent.mtt.hippy.adapter.http.HippyHttpAdapter;
import com.tencent.mtt.hippy.adapter.image.HippyImageLoader;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter;
import com.tencent.mtt.hippy.adapter.thirdparty.HippyThirdPartyAdapter;

public class HippyAdapterImpl
  implements IHippyAdapter
{
  public HippyImageLoader creatImageLoader()
  {
    return new HippyQQImageLoader();
  }
  
  public HippyEngineMonitorAdapter createEngineMonitorAdapter()
  {
    return new HippyQQEngineMonitorAdapter();
  }
  
  public HippyFontScaleAdapter createFontScaleAdapter()
  {
    return new HippyQQFontAdapter();
  }
  
  public HippyHttpAdapter createHttpAdapter()
  {
    return new HippyQQHttpAdapter();
  }
  
  public HippyThirdPartyAdapter createThirdPartyAdapter()
  {
    return new HippyQQThirdPartyAdapter();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.api.impl.HippyAdapterImpl
 * JD-Core Version:    0.7.0.1
 */