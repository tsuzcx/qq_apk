package com.tencent.map.sdk.service.protocol.jce.sso;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.map.sdk.a.i;
import com.tencent.map.sdk.a.k;
import com.tencent.map.sdk.a.l;
import com.tencent.map.sdk.a.o;
import java.util.ArrayList;
import java.util.Collection;

public final class Package
  extends MapJceStruct
  implements Cloneable
{
  static byte[] a;
  static byte[] b;
  static ArrayList<Tag> c;
  public byte[] busiBuff = null;
  public byte cEncodeType = 0;
  public int eCmd = 0;
  public byte[] head = null;
  public int iSeqNo = 0;
  public String sAppId = "";
  public short shVer = 0;
  public String strSubCmd = "";
  public String uin = "";
  public ArrayList<Tag> vTag = null;
  
  public Package() {}
  
  public Package(short paramShort, int paramInt1, String paramString1, int paramInt2, byte paramByte, String paramString2, String paramString3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, ArrayList<Tag> paramArrayList)
  {
    this.shVer = paramShort;
    this.eCmd = paramInt1;
    this.strSubCmd = paramString1;
    this.iSeqNo = paramInt2;
    this.cEncodeType = paramByte;
    this.sAppId = paramString2;
    this.uin = paramString3;
    this.head = paramArrayOfByte1;
    this.busiBuff = paramArrayOfByte2;
    this.vTag = paramArrayList;
  }
  
  public final String className()
  {
    return "sosomap.Package";
  }
  
  public final Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label7:
      break label7;
    }
    if (d) {
      return null;
    }
    throw new AssertionError();
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new i(paramStringBuilder, paramInt);
    paramStringBuilder.a(this.shVer, "shVer");
    paramStringBuilder.a(this.eCmd, "eCmd");
    paramStringBuilder.a(this.strSubCmd, "strSubCmd");
    paramStringBuilder.a(this.iSeqNo, "iSeqNo");
    paramStringBuilder.a(this.cEncodeType, "cEncodeType");
    paramStringBuilder.a(this.sAppId, "sAppId");
    paramStringBuilder.a(this.uin, "uin");
    paramStringBuilder.a(this.head, "head");
    paramStringBuilder.a(this.busiBuff, "busiBuff");
    paramStringBuilder.a(this.vTag, "vTag");
  }
  
  public final void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new i(paramStringBuilder, paramInt);
    paramStringBuilder.a(this.shVer, true);
    paramStringBuilder.a(this.eCmd, true);
    paramStringBuilder.a(this.strSubCmd, true);
    paramStringBuilder.a(this.iSeqNo, true);
    paramStringBuilder.a(this.cEncodeType, true);
    paramStringBuilder.a(this.sAppId, true);
    paramStringBuilder.a(this.uin, true);
    paramStringBuilder.a(this.head, true);
    paramStringBuilder.a(this.busiBuff, true);
    paramStringBuilder.a(this.vTag, false);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    paramObject = (Package)paramObject;
    return (o.a(this.shVer, paramObject.shVer)) && (o.a(this.eCmd, paramObject.eCmd)) && (o.a(this.strSubCmd, paramObject.strSubCmd)) && (o.a(this.iSeqNo, paramObject.iSeqNo)) && (o.a(this.cEncodeType, paramObject.cEncodeType)) && (o.a(this.sAppId, paramObject.sAppId)) && (o.a(this.uin, paramObject.uin)) && (o.a(this.head, paramObject.head)) && (o.a(this.busiBuff, paramObject.busiBuff)) && (o.a(this.vTag, paramObject.vTag));
  }
  
  public final byte[] getBusiBuff()
  {
    return this.busiBuff;
  }
  
  public final byte[] getHead()
  {
    return this.head;
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
    this.shVer = paramk.a(this.shVer, 0, true);
    this.eCmd = paramk.a(this.eCmd, 1, true);
    this.strSubCmd = paramk.b(2, true);
    this.iSeqNo = paramk.a(this.iSeqNo, 3, false);
    this.cEncodeType = paramk.a(this.cEncodeType, 4, false);
    this.sAppId = paramk.b(5, false);
    this.uin = paramk.b(6, false);
    Object localObject;
    if (a == null)
    {
      localObject = new byte[1];
      a = (byte[])localObject;
      localObject[0] = 0;
    }
    this.head = paramk.c(7, false);
    if (b == null)
    {
      localObject = new byte[1];
      b = (byte[])localObject;
      localObject[0] = 0;
    }
    this.busiBuff = paramk.c(8, false);
    if (c == null)
    {
      c = new ArrayList();
      localObject = new Tag();
      c.add(localObject);
    }
    this.vTag = ((ArrayList)paramk.a(c, 9, false));
  }
  
  public final void writeTo(l paraml)
  {
    paraml.a(this.shVer, 0);
    paraml.a(this.eCmd, 1);
    paraml.a(this.strSubCmd, 2);
    paraml.a(this.iSeqNo, 3);
    paraml.a(this.cEncodeType, 4);
    Object localObject = this.sAppId;
    if (localObject != null) {
      paraml.a((String)localObject, 5);
    }
    localObject = this.uin;
    if (localObject != null) {
      paraml.a((String)localObject, 6);
    }
    localObject = this.head;
    if (localObject != null) {
      paraml.a((byte[])localObject, 7);
    }
    localObject = this.busiBuff;
    if (localObject != null) {
      paraml.a((byte[])localObject, 8);
    }
    localObject = this.vTag;
    if (localObject != null) {
      paraml.a((Collection)localObject, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.service.protocol.jce.sso.Package
 * JD-Core Version:    0.7.0.1
 */