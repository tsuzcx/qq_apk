package com.tencent.ad.tangram.device;

import android.content.Context;

final class p
  extends f
{
  protected int getEventId()
  {
    return 1122;
  }
  
  protected String getId(Context paramContext, boolean paramBoolean)
  {
    return o.getSubscriberId(paramContext, paramBoolean);
  }
  
  protected String getIdCache(Context paramContext)
  {
    return o.getSubscriberIdCache(paramContext);
  }
  
  protected String getIdHash(String paramString)
  {
    return g.getDeviceIdMD5Digest(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.device.p
 * JD-Core Version:    0.7.0.1
 */