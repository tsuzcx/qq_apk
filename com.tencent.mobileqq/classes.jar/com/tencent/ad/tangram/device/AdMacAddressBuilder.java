package com.tencent.ad.tangram.device;

import android.content.Context;
import android.support.annotation.Keep;

@Keep
public final class AdMacAddressBuilder
  extends f
{
  protected int getEventId()
  {
    return 1041;
  }
  
  protected String getId(Context paramContext, boolean paramBoolean)
  {
    return l.get(paramContext, paramBoolean);
  }
  
  protected String getIdCache(Context paramContext)
  {
    return l.getMacAddressCache(paramContext);
  }
  
  protected String getIdHash(String paramString)
  {
    return g.getMacAddressMD5Digest(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.device.AdMacAddressBuilder
 * JD-Core Version:    0.7.0.1
 */