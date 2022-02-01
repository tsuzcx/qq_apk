package com.tencent.ad.tangram;

import android.support.annotation.Keep;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp.AdInfo;

@Keep
public abstract interface AdBuilderAdapter
{
  public abstract Ad build(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.AdBuilderAdapter
 * JD-Core Version:    0.7.0.1
 */