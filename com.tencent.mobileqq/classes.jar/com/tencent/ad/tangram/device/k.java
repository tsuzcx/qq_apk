package com.tencent.ad.tangram.device;

import android.content.Context;

final class k
  extends f
{
  protected int getEventId()
  {
    return 1116;
  }
  
  protected String getId(Context paramContext, boolean paramBoolean)
  {
    return c.getImei(paramContext, paramBoolean);
  }
  
  protected String getIdCache(Context paramContext)
  {
    return c.getImei(paramContext);
  }
  
  protected String getIdHash(String paramString)
  {
    return g.getDeviceIdMD5Digest(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.device.k
 * JD-Core Version:    0.7.0.1
 */