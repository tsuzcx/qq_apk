package com.tencent.ilivesdk.beautyfilterservice_interface;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilive.beautyfilter.imp.BeautyFilterInterface;
import com.tencent.ilive.beautyfilter.imp.BeautyFilterSDKInitInterface;

public abstract interface BeautyFilterServiceInterface
  extends ServiceBaseInterface
{
  public abstract BeautyFilterInterface getBeautyFilter();
  
  public abstract BeautyFilterSDKInitInterface getBeautyFilterInit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.beautyfilterservice_interface.BeautyFilterServiceInterface
 * JD-Core Version:    0.7.0.1
 */