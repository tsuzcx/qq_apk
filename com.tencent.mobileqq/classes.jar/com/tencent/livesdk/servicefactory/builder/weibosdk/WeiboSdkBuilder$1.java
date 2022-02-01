package com.tencent.livesdk.servicefactory.builder.weibosdk;

import com.tencent.falco.base.libapi.imageloader.ImageLoaderInterface;
import com.tencent.falco.base.weibosdk.WeiboSdkAdapter;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class WeiboSdkBuilder$1
  implements WeiboSdkAdapter
{
  WeiboSdkBuilder$1(WeiboSdkBuilder paramWeiboSdkBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public ImageLoaderInterface getImageLoader()
  {
    return (ImageLoaderInterface)this.val$serviceManager.getService(ImageLoaderInterface.class);
  }
  
  public String getWeiboAppKey()
  {
    return "3971957189";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.weibosdk.WeiboSdkBuilder.1
 * JD-Core Version:    0.7.0.1
 */