package com.tencent.map.sdk.service.protocol.jce.sso;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.map.sdk.a.i;
import com.tencent.map.sdk.a.k;
import com.tencent.map.sdk.a.l;
import com.tencent.map.sdk.a.o;

public final class Header
  extends MapJceStruct
  implements Cloneable
{
  static CmdResult a;
  public long lCurrTime = 0L;
  public CmdResult stResult = null;
  public String strChannel = "";
  public String strFr = "";
  public String strImei = "";
  public String strImsi = "";
  public String strLC = "";
  public String strMachineModel = "";
  public String strMobver = "";
  public String strNettp = "";
  public String strOfflineVersion = "";
  public String strOsVersion = "";
  public String strPf = "";
  public String strSessionId = "";
  public String strSoftVersion = "";
  public String strToken = "";
  public String strUserNetType = "";
  public long uAccIp = 0L;
  
  static
  {
    if (!Header.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      return;
    }
  }
  
  public Header() {}
  
  public Header(long paramLong1, CmdResult paramCmdResult, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15)
  {
    this.lCurrTime = paramLong1;
    this.stResult = paramCmdResult;
    this.uAccIp = paramLong2;
    this.strSessionId = paramString1;
    this.strLC = paramString2;
    this.strToken = paramString3;
    this.strFr = paramString4;
    this.strPf = paramString5;
    this.strImei = paramString6;
    this.strMobver = paramString7;
    this.strNettp = paramString8;
    this.strImsi = paramString9;
    this.strOsVersion = paramString10;
    this.strSoftVersion = paramString11;
    this.strOfflineVersion = paramString12;
    this.strChannel = paramString13;
    this.strMachineModel = paramString14;
    this.strUserNetType = paramString15;
  }
  
  public final String className()
  {
    return "sosomap.Header";
  }
  
  public final Object clone()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while (b) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new i(paramStringBuilder, paramInt);
    paramStringBuilder.a(this.lCurrTime, "lCurrTime");
    paramStringBuilder.a(this.stResult, "stResult");
    paramStringBuilder.a(this.uAccIp, "uAccIp");
    paramStringBuilder.a(this.strSessionId, "strSessionId");
    paramStringBuilder.a(this.strLC, "strLC");
    paramStringBuilder.a(this.strToken, "strToken");
    paramStringBuilder.a(this.strFr, "strFr");
    paramStringBuilder.a(this.strPf, "strPf");
    paramStringBuilder.a(this.strImei, "strImei");
    paramStringBuilder.a(this.strMobver, "strMobver");
    paramStringBuilder.a(this.strNettp, "strNettp");
    paramStringBuilder.a(this.strImsi, "strImsi");
    paramStringBuilder.a(this.strOsVersion, "strOsVersion");
    paramStringBuilder.a(this.strSoftVersion, "strSoftVersion");
    paramStringBuilder.a(this.strOfflineVersion, "strOfflineVersion");
    paramStringBuilder.a(this.strChannel, "strChannel");
    paramStringBuilder.a(this.strMachineModel, "strMachineModel");
    paramStringBuilder.a(this.strUserNetType, "strUserNetType");
  }
  
  public final void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new i(paramStringBuilder, paramInt);
    paramStringBuilder.a(this.lCurrTime, true);
    paramStringBuilder.a(this.stResult, true);
    paramStringBuilder.a(this.uAccIp, true);
    paramStringBuilder.a(this.strSessionId, true);
    paramStringBuilder.a(this.strLC, true);
    paramStringBuilder.a(this.strToken, true);
    paramStringBuilder.a(this.strFr, true);
    paramStringBuilder.a(this.strPf, true);
    paramStringBuilder.a(this.strImei, true);
    paramStringBuilder.a(this.strMobver, true);
    paramStringBuilder.a(this.strNettp, true);
    paramStringBuilder.a(this.strImsi, true);
    paramStringBuilder.a(this.strOsVersion, true);
    paramStringBuilder.a(this.strSoftVersion, true);
    paramStringBuilder.a(this.strOfflineVersion, true);
    paramStringBuilder.a(this.strChannel, true);
    paramStringBuilder.a(this.strMachineModel, true);
    paramStringBuilder.a(this.strUserNetType, false);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (Header)paramObject;
    } while ((!o.a(this.lCurrTime, paramObject.lCurrTime)) || (!o.a(this.stResult, paramObject.stResult)) || (!o.a(this.uAccIp, paramObject.uAccIp)) || (!o.a(this.strSessionId, paramObject.strSessionId)) || (!o.a(this.strLC, paramObject.strLC)) || (!o.a(this.strToken, paramObject.strToken)) || (!o.a(this.strFr, paramObject.strFr)) || (!o.a(this.strPf, paramObject.strPf)) || (!o.a(this.strImei, paramObject.strImei)) || (!o.a(this.strMobver, paramObject.strMobver)) || (!o.a(this.strNettp, paramObject.strNettp)) || (!o.a(this.strImsi, paramObject.strImsi)) || (!o.a(this.strOsVersion, paramObject.strOsVersion)) || (!o.a(this.strSoftVersion, paramObject.strSoftVersion)) || (!o.a(this.strOfflineVersion, paramObject.strOfflineVersion)) || (!o.a(this.strChannel, paramObject.strChannel)) || (!o.a(this.strMachineModel, paramObject.strMachineModel)) || (!o.a(this.strUserNetType, paramObject.strUserNetType)));
    return true;
  }
  
  public final int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public final void readFrom(k paramk)
  {
    this.lCurrTime = paramk.a(this.lCurrTime, 0, true);
    if (a == null) {
      a = new CmdResult();
    }
    this.stResult = ((CmdResult)paramk.a(a, 1, false));
    this.uAccIp = paramk.a(this.uAccIp, 2, false);
    this.strSessionId = paramk.b(3, false);
    this.strLC = paramk.b(4, false);
    this.strToken = paramk.b(5, false);
    this.strFr = paramk.b(6, false);
    this.strPf = paramk.b(7, false);
    this.strImei = paramk.b(8, false);
    this.strMobver = paramk.b(9, false);
    this.strNettp = paramk.b(10, false);
    this.strImsi = paramk.b(11, false);
    this.strOsVersion = paramk.b(12, false);
    this.strSoftVersion = paramk.b(13, false);
    this.strOfflineVersion = paramk.b(14, false);
    this.strChannel = paramk.b(15, false);
    this.strMachineModel = paramk.b(16, false);
    this.strUserNetType = paramk.b(17, false);
  }
  
  public final void writeTo(l paraml)
  {
    paraml.a(this.lCurrTime, 0);
    if (this.stResult != null) {
      paraml.a(this.stResult, 1);
    }
    paraml.a(this.uAccIp, 2);
    if (this.strSessionId != null) {
      paraml.a(this.strSessionId, 3);
    }
    if (this.strLC != null) {
      paraml.a(this.strLC, 4);
    }
    if (this.strToken != null) {
      paraml.a(this.strToken, 5);
    }
    if (this.strFr != null) {
      paraml.a(this.strFr, 6);
    }
    if (this.strPf != null) {
      paraml.a(this.strPf, 7);
    }
    if (this.strImei != null) {
      paraml.a(this.strImei, 8);
    }
    if (this.strMobver != null) {
      paraml.a(this.strMobver, 9);
    }
    if (this.strNettp != null) {
      paraml.a(this.strNettp, 10);
    }
    if (this.strImsi != null) {
      paraml.a(this.strImsi, 11);
    }
    if (this.strOsVersion != null) {
      paraml.a(this.strOsVersion, 12);
    }
    if (this.strSoftVersion != null) {
      paraml.a(this.strSoftVersion, 13);
    }
    if (this.strOfflineVersion != null) {
      paraml.a(this.strOfflineVersion, 14);
    }
    if (this.strChannel != null) {
      paraml.a(this.strChannel, 15);
    }
    if (this.strMachineModel != null) {
      paraml.a(this.strMachineModel, 16);
    }
    if (this.strUserNetType != null) {
      paraml.a(this.strUserNetType, 17);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.service.protocol.jce.sso.Header
 * JD-Core Version:    0.7.0.1
 */