package com.tencent.beacon.core.event;

import java.io.Serializable;
import java.util.Map;

public class RDBean
  implements Serializable
{
  public static final String TP_DN = "DN";
  public static final String TP_HO = "HO";
  public static final String TP_IP = "IP";
  public static final String TP_UA = "UA";
  private static final long serialVersionUID = 1L;
  private String apn = "";
  private long cid = -1L;
  private long elapse;
  private Map<String, String> emap;
  private String en;
  private boolean eventResult = true;
  private boolean immediatelyUpload;
  private long size;
  private String srcIp = "";
  private long tm;
  private String tp;
  
  public String getApn()
  {
    return this.apn;
  }
  
  public long getCid()
  {
    try
    {
      long l = this.cid;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public Map<String, String> getEMap()
  {
    try
    {
      Map localMap = this.emap;
      return localMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String getEN()
  {
    try
    {
      String str = this.en;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long getElapse()
  {
    return this.elapse;
  }
  
  public long getSize()
  {
    return this.size;
  }
  
  public String getSrcIp()
  {
    return this.srcIp;
  }
  
  public long getTM()
  {
    try
    {
      long l = this.tm;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String getTP()
  {
    try
    {
      String str = this.tp;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isEventResult()
  {
    return this.eventResult;
  }
  
  public boolean isImmediatelyUpload()
  {
    return this.immediatelyUpload;
  }
  
  public void setApn(String paramString)
  {
    this.apn = paramString;
  }
  
  public void setCid(long paramLong)
  {
    try
    {
      this.cid = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setEMap(Map<String, String> paramMap)
  {
    try
    {
      this.emap = paramMap;
      return;
    }
    finally
    {
      paramMap = finally;
      throw paramMap;
    }
  }
  
  public void setEN(String paramString)
  {
    try
    {
      this.en = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setElapse(long paramLong)
  {
    this.elapse = paramLong;
  }
  
  public void setEventResult(boolean paramBoolean)
  {
    this.eventResult = paramBoolean;
  }
  
  public void setImmediatelyUpload(boolean paramBoolean)
  {
    this.immediatelyUpload = paramBoolean;
  }
  
  public void setSize(long paramLong)
  {
    this.size = paramLong;
  }
  
  public void setSrcIp(String paramString)
  {
    this.srcIp = paramString;
  }
  
  public void setTM(long paramLong)
  {
    try
    {
      this.tm = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setTP(String paramString)
  {
    try
    {
      this.tp = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.event.RDBean
 * JD-Core Version:    0.7.0.1
 */