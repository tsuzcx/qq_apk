package com.tencent.ad.tangram.device;

import android.text.TextUtils;
import com.tencent.ad.tangram.json.AdJSON;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.protocol.qq_common.DeviceExt.UUID;
import com.tencent.ad.tangram.util.d;
import java.util.UUID;
import org.json.JSONObject;

public final class r
{
  private static final String TAG = "AdUUIDInfo";
  private qq_common.DeviceExt.UUID info;
  
  private r(qq_common.DeviceExt.UUID paramUUID)
  {
    this.info = paramUUID;
  }
  
  public static r create(r.a parama)
  {
    if ((parama == null) || (!parama.isValid()))
    {
      AdLog.e("AdUUIDInfo", "create error");
      return null;
    }
    UUID localUUID = UUID.randomUUID();
    qq_common.DeviceExt.UUID localUUID1 = new qq_common.DeviceExt.UUID();
    localUUID1.v = parama.getVersion();
    localUUID1.u = localUUID.toString();
    localUUID1.t = System.currentTimeMillis();
    localUUID1.m = generateSignature(parama, localUUID1.u, localUUID1.t);
    return new r(localUUID1);
  }
  
  public static r fromString(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      if ((paramString == null) || (JSONObject.NULL.equals(paramString)))
      {
        AdLog.e("AdUUIDInfo", "fromString error");
        return null;
      }
      paramString = new r((qq_common.DeviceExt.UUID)qq_common.DeviceExt.UUID.class.cast(AdJSON.toObject(paramString, qq_common.DeviceExt.UUID.class)));
      return paramString;
    }
    catch (Throwable paramString)
    {
      AdLog.e("AdUUIDInfo", "fromString", paramString);
    }
    return null;
  }
  
  private static String generateSignature(r.a parama, String paramString, long paramLong)
  {
    if ((parama == null) || (!parama.isValid())) {}
    for (;;)
    {
      parama = null;
      do
      {
        return parama;
        if ((paramLong == -2147483648L) || (TextUtils.isEmpty(paramString))) {
          break;
        }
        parama = String.format("%s%d%d%s", new Object[] { paramString, Integer.valueOf(parama.getVersion()), Long.valueOf(paramLong), parama.getValue() });
        if (TextUtils.isEmpty(parama)) {
          break;
        }
        parama = d.md5(parama, "UTF-8");
        if (TextUtils.isEmpty(parama)) {
          break;
        }
        paramString = parama.toUpperCase();
        parama = paramString;
      } while (!TextUtils.isEmpty(paramString));
    }
  }
  
  private boolean isValid()
  {
    return (this.info != null) && (this.info.v > 0) && (this.info.t > 0L) && (!TextUtils.isEmpty(this.info.u)) && (!TextUtils.isEmpty(this.info.m));
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof r))) {}
    do
    {
      return false;
      paramObject = (r)r.class.cast(paramObject);
      if ((this.info == null) && (paramObject.info == null)) {
        return true;
      }
    } while ((this.info == null) || (paramObject.info == null));
    if ((this.info.v == paramObject.info.v) && (this.info.t == paramObject.info.t) && (TextUtils.equals(this.info.u, paramObject.info.u)) && (TextUtils.equals(this.info.m, paramObject.info.m))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public qq_common.DeviceExt.UUID getInfo()
  {
    if (isValid()) {
      return this.info;
    }
    return null;
  }
  
  public boolean isValid(r.a parama)
  {
    if (!isValid()) {}
    while ((UUID.fromString(this.info.u) == null) || (parama == null) || (!parama.isValid()) || (parama.getVersion() != this.info.v)) {
      return false;
    }
    parama = generateSignature(parama, this.info.u, this.info.t);
    return TextUtils.equals(this.info.m, parama);
  }
  
  public String toString()
  {
    if (!isValid()) {
      AdLog.e("AdUUIDInfo", "toString error");
    }
    for (;;)
    {
      return null;
      try
      {
        Object localObject = AdJSON.fromObject(this.info);
        if ((localObject != null) && (!JSONObject.NULL.equals(localObject)))
        {
          localObject = localObject.toString();
          return localObject;
        }
      }
      catch (Throwable localThrowable)
      {
        AdLog.e("AdUUIDInfo", "toString", localThrowable);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.device.r
 * JD-Core Version:    0.7.0.1
 */