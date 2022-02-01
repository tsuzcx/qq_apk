package com.tencent.ad.tangram.device;

import android.text.TextUtils;
import com.tencent.ad.tangram.json.AdJSON;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.protocol.qq_common.DeviceExt.UUID;
import com.tencent.ad.tangram.util.d;
import java.util.UUID;
import org.json.JSONObject;

public final class q
{
  private static final String TAG = "AdUUIDInfo";
  private qq_common.DeviceExt.UUID info;
  
  private q(qq_common.DeviceExt.UUID paramUUID)
  {
    this.info = paramUUID;
  }
  
  public static q create(q.a parama)
  {
    if ((parama != null) && (parama.isValid()))
    {
      UUID localUUID = UUID.randomUUID();
      qq_common.DeviceExt.UUID localUUID1 = new qq_common.DeviceExt.UUID();
      localUUID1.v = parama.getVersion();
      localUUID1.u = localUUID.toString();
      localUUID1.t = System.currentTimeMillis();
      localUUID1.m = generateSignature(parama, localUUID1.u, localUUID1.t);
      return new q(localUUID1);
    }
    AdLog.e("AdUUIDInfo", "create error");
    return null;
  }
  
  public static q fromString(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      if (JSONObject.NULL.equals(paramString))
      {
        AdLog.e("AdUUIDInfo", "fromString error");
        return null;
      }
      paramString = new q((qq_common.DeviceExt.UUID)qq_common.DeviceExt.UUID.class.cast(AdJSON.toObject(paramString, qq_common.DeviceExt.UUID.class)));
      return paramString;
    }
    catch (Throwable paramString)
    {
      AdLog.e("AdUUIDInfo", "fromString", paramString);
    }
    return null;
  }
  
  private static String generateSignature(q.a parama, String paramString, long paramLong)
  {
    if ((parama != null) && (parama.isValid()) && (paramLong != -2147483648L) && (!TextUtils.isEmpty(paramString)))
    {
      parama = String.format("%s%d%d%s", new Object[] { paramString, Integer.valueOf(parama.getVersion()), Long.valueOf(paramLong), parama.getValue() });
      if (!TextUtils.isEmpty(parama))
      {
        parama = d.md5(parama, "UTF-8");
        if (!TextUtils.isEmpty(parama))
        {
          parama = parama.toUpperCase();
          if (!TextUtils.isEmpty(parama)) {
            return parama;
          }
        }
      }
    }
    return null;
  }
  
  private boolean isValid()
  {
    qq_common.DeviceExt.UUID localUUID = this.info;
    return (localUUID != null) && (localUUID.v > 0) && (this.info.t > 0L) && (!TextUtils.isEmpty(this.info.u)) && (!TextUtils.isEmpty(this.info.m));
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      if (!(paramObject instanceof q)) {
        return false;
      }
      paramObject = (q)q.class.cast(paramObject);
      if ((this.info == null) && (paramObject.info == null)) {
        return true;
      }
      qq_common.DeviceExt.UUID localUUID = this.info;
      bool1 = bool2;
      if (localUUID != null)
      {
        if (paramObject.info == null) {
          return false;
        }
        bool1 = bool2;
        if (localUUID.v == paramObject.info.v)
        {
          bool1 = bool2;
          if (this.info.t == paramObject.info.t)
          {
            bool1 = bool2;
            if (TextUtils.equals(this.info.u, paramObject.info.u))
            {
              bool1 = bool2;
              if (TextUtils.equals(this.info.m, paramObject.info.m)) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public qq_common.DeviceExt.UUID getInfo()
  {
    if (isValid()) {
      return this.info;
    }
    return null;
  }
  
  public boolean isValid(q.a parama)
  {
    if (isValid()) {
      try
      {
        UUID localUUID = UUID.fromString(this.info.u);
        if ((localUUID != null) && (parama != null) && (parama.isValid()) && (parama.getVersion() == this.info.v))
        {
          parama = generateSignature(parama, this.info.u, this.info.t);
          return TextUtils.equals(this.info.m, parama);
        }
      }
      catch (Throwable parama)
      {
        AdLog.e("AdUUIDInfo", "isValid", parama);
      }
    }
    return false;
  }
  
  public String toString()
  {
    boolean bool = isValid();
    Object localObject2 = null;
    if (!bool)
    {
      AdLog.e("AdUUIDInfo", "toString error");
      return null;
    }
    try
    {
      Object localObject3 = AdJSON.fromObject(this.info);
      Object localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (!JSONObject.NULL.equals(localObject3)) {
          localObject1 = localObject3.toString();
        }
      }
      return localObject1;
    }
    catch (Throwable localThrowable)
    {
      AdLog.e("AdUUIDInfo", "toString", localThrowable);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.device.q
 * JD-Core Version:    0.7.0.1
 */