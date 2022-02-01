package com.tencent.mobileqq.ark.api.impl;

import com.tencent.mobileqq.ark.api.IArkSecure;
import com.tencent.mobileqq.ark.secure.ArkSecureUtil;
import com.tencent.mobileqq.ark.secure.CheckShareUrlResult;

public class ArkSecureImpl
  implements IArkSecure
{
  public void checkShareUrl(String paramString1, String paramString2, String paramString3, CheckShareUrlResult paramCheckShareUrlResult)
  {
    ArkSecureUtil.a(paramString1, paramString2, paramString3, paramCheckShareUrlResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.impl.ArkSecureImpl
 * JD-Core Version:    0.7.0.1
 */