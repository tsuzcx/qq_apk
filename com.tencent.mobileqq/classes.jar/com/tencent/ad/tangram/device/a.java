package com.tencent.ad.tangram.device;

import android.content.Context;

final class a
  extends f
{
  protected int getEventId()
  {
    return 1042;
  }
  
  protected String getId(Context paramContext, boolean paramBoolean)
  {
    return c.getAndroidId(paramContext);
  }
  
  protected String getIdCache(Context paramContext)
  {
    return c.getAndroidIdCache(paramContext);
  }
  
  protected String getIdHash(String paramString)
  {
    return g.getAndroidIdMD5Digest(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.device.a
 * JD-Core Version:    0.7.0.1
 */