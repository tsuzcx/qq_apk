package com.tencent.ad.tangram.device;

import android.content.Context;

final class j
  extends f
{
  private static final int SLOT_INDEX = 1;
  
  protected int getEventId()
  {
    return 1118;
  }
  
  protected String getId(Context paramContext, boolean paramBoolean)
  {
    return c.getImei(paramContext, 1, paramBoolean);
  }
  
  protected String getIdCache(Context paramContext)
  {
    return c.getImeiCache(paramContext, 1);
  }
  
  protected String getIdHash(String paramString)
  {
    return g.getDeviceIdMD5Digest(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.device.j
 * JD-Core Version:    0.7.0.1
 */