package com.tencent.ad.tangram.device;

import android.content.Context;

final class l
  extends f
{
  private static final int SLOT_INDEX = 0;
  
  protected int getEventId()
  {
    return 1120;
  }
  
  protected String getId(Context paramContext, boolean paramBoolean)
  {
    return c.getMeid(paramContext, 0, paramBoolean);
  }
  
  protected String getIdCache(Context paramContext)
  {
    return c.getMeidCache(paramContext, 0);
  }
  
  protected String getIdHash(String paramString)
  {
    return g.getDeviceIdMD5Digest(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.device.l
 * JD-Core Version:    0.7.0.1
 */