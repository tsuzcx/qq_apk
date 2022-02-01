package com.tencent.gathererga.ad.internal;

import com.tencent.gathererga.ad.AdDeviceInfoService;

public final class AdDeviceInfoServiceImpl
  implements AdDeviceInfoService
{
  public String a(Integer paramInteger, String paramString)
  {
    int i = paramInteger.intValue();
    if (i != 115)
    {
      if (i != 307)
      {
        switch (i)
        {
        default: 
          return null;
        }
        return AdDeviceIdMD5Digest.a(String.valueOf(paramString));
      }
      return AdMacAddressMD5Digest.a(String.valueOf(paramString));
    }
    return AdAndroidIdMD5Digest.a(String.valueOf(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.ad.internal.AdDeviceInfoServiceImpl
 * JD-Core Version:    0.7.0.1
 */