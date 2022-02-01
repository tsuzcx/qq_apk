package com.tencent.ad.tangram.device;

import android.content.Context;

final class i
  extends f
{
  private static final int SLOT_INDEX = 0;
  
  protected int getEventId()
  {
    return 1117;
  }
  
  protected String getId(Context paramContext, boolean paramBoolean)
  {
    return c.getImei(paramContext, 0, paramBoolean);
  }
  
  protected String getIdCache(Context paramContext)
  {
    return c.getImeiCache(paramContext, 0);
  }
  
  protected String getIdHash(String paramString)
  {
    return g.getDeviceIdMD5Digest(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.device.i
 * JD-Core Version:    0.7.0.1
 */