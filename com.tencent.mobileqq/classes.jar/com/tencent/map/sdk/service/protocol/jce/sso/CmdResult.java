package com.tencent.map.sdk.service.protocol.jce.sso;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.map.sdk.a.i;
import com.tencent.map.sdk.a.k;
import com.tencent.map.sdk.a.l;
import com.tencent.map.sdk.a.o;

public final class CmdResult
  extends MapJceStruct
  implements Cloneable
{
  public int iErrCode = 0;
  public int iSubErrCode = 0;
  public String strErrDesc = "";
  
  public CmdResult() {}
  
  public CmdResult(int paramInt1, String paramString, int paramInt2)
  {
    this.iErrCode = paramInt1;
    this.strErrDesc = paramString;
    this.iSubErrCode = paramInt2;
  }
  
  public final String className()
  {
    return "sosomap.CmdResult";
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
    if (a) {
      return null;
    }
    throw new AssertionError();
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new i(paramStringBuilder, paramInt);
    paramStringBuilder.a(this.iErrCode, "iErrCode");
    paramStringBuilder.a(this.strErrDesc, "strErrDesc");
    paramStringBuilder.a(this.iSubErrCode, "iSubErrCode");
  }
  
  public final void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new i(paramStringBuilder, paramInt);
    paramStringBuilder.a(this.iErrCode, true);
    paramStringBuilder.a(this.strErrDesc, true);
    paramStringBuilder.a(this.iSubErrCode, false);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    paramObject = (CmdResult)paramObject;
    return (o.a(this.iErrCode, paramObject.iErrCode)) && (o.a(this.strErrDesc, paramObject.strErrDesc)) && (o.a(this.iSubErrCode, paramObject.iSubErrCode));
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
    this.iErrCode = paramk.a(this.iErrCode, 0, true);
    this.strErrDesc = paramk.b(1, true);
    this.iSubErrCode = paramk.a(this.iSubErrCode, 2, false);
  }
  
  public final void writeTo(l paraml)
  {
    paraml.a(this.iErrCode, 0);
    paraml.a(this.strErrDesc, 1);
    paraml.a(this.iSubErrCode, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.service.protocol.jce.sso.CmdResult
 * JD-Core Version:    0.7.0.1
 */