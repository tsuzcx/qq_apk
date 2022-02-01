package com.tencent.ad.tangram.device;

import android.content.Context;

final class n
  extends f
{
  protected int getEventId()
  {
    return 1119;
  }
  
  protected String getId(Context paramContext, boolean paramBoolean)
  {
    return c.getMeid(paramContext, paramBoolean);
  }
  
  protected String getIdCache(Context paramContext)
  {
    return c.getMeidCache(paramContext);
  }
  
  protected String getIdHash(String paramString)
  {
    return g.getDeviceIdMD5Digest(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.device.n
 * JD-Core Version:    0.7.0.1
 */