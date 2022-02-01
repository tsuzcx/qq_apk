package com.tencent.ad.tangram.device;

import android.content.Context;
import android.support.annotation.Keep;

@Keep
public final class AdDeviceIdBuilder
  extends f
{
  protected int getEventId()
  {
    return 1040;
  }
  
  protected String getId(Context paramContext, boolean paramBoolean)
  {
    return c.getDeviceId(paramContext, paramBoolean);
  }
  
  protected String getIdCache(Context paramContext)
  {
    return c.getDeviceIdCache(paramContext);
  }
  
  protected String getIdHash(String paramString)
  {
    return g.getDeviceIdMD5Digest(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.device.AdDeviceIdBuilder
 * JD-Core Version:    0.7.0.1
 */