package com.tencent.mobileqq.armap;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class JNIPOIRequestParam
  implements Serializable
{
  public int accuracy;
  public int busiID;
  public String cookie;
  public String encrypt_sig;
  public int fakePeriod;
  public HashMap fakeReason;
  public int fakeTimes;
  public double latitude;
  public String lbsPid;
  public double lbsSig_lat;
  public double lbsSig_locationTime;
  public double lbsSig_lon;
  public String lbsSig_verifyKey;
  public double longitude;
  public long nativeGLSurfaceViewContext;
  public long nativeHandle;
  public int req_occasion;
  
  public JNIPOIRequestParam() {}
  
  public JNIPOIRequestParam(double paramDouble1, double paramDouble2, int paramInt, String paramString1, String paramString2, String paramString3, long paramLong)
  {
    this(paramDouble1, paramDouble2, paramInt, paramString1, null, paramString2, paramString3, paramLong);
  }
  
  public JNIPOIRequestParam(double paramDouble1, double paramDouble2, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    this.longitude = paramDouble1;
    this.latitude = paramDouble2;
    this.busiID = paramInt;
    this.lbsSig_verifyKey = paramString1;
    this.encrypt_sig = paramString2;
    this.cookie = paramString3;
    this.lbsPid = paramString4;
    this.nativeHandle = paramLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Param longitude:").append(this.longitude).append(", latitude:").append(this.latitude).append(", accuracy:").append(this.accuracy).append(", req_occasion:").append(this.req_occasion).append(", busiID:").append(this.busiID).append(", lbsPid:").append(this.lbsPid).append(", lbsSig_verifyKey:").append(this.lbsSig_verifyKey).append(", lbsSig_lon:").append(this.lbsSig_lon).append(", lbsSig_lat:").append(this.lbsSig_lat).append(", lbsSig_locationTime:").append(this.lbsSig_locationTime).append(", encrypt_sig:").append(this.encrypt_sig).append(", cookie:").append(this.cookie).append(", nativeHandle:").append(this.nativeHandle).append(", nativeGLSurfaceViewContext:").append(this.nativeGLSurfaceViewContext).append(", fakeTimes:").append(this.fakeTimes).append(", fakePeriod:").append(this.fakePeriod).append(", fakeReason:");
    if ((this.fakeReason != null) && (this.fakeReason.size() > 0))
    {
      Iterator localIterator = this.fakeReason.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localStringBuilder.append("[").append(localEntry.getKey()).append(":").append(localEntry.getValue()).append("]");
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.JNIPOIRequestParam
 * JD-Core Version:    0.7.0.1
 */