package com.tencent.livesdk.servicefactory.builder.beautyfilter;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.beautyfilter.utils.LogUtils;
import com.tencent.ilivesdk.beautyfilterservice.BeautyFilterService;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class BeautyFilterServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    BeautyFilterService localBeautyFilterService = new BeautyFilterService();
    paramServiceAccessor = (LogInterface)paramServiceAccessor.getService(LogInterface.class);
    LogUtils.getLogger().init(new BeautyFilterServiceBuilder.1(this, paramServiceAccessor));
    return localBeautyFilterService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.beautyfilter.BeautyFilterServiceBuilder
 * JD-Core Version:    0.7.0.1
 */