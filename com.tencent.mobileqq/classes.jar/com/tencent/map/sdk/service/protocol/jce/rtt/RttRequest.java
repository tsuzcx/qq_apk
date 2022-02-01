package com.tencent.map.sdk.service.protocol.jce.rtt;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.map.sdk.a.i;
import com.tencent.map.sdk.a.k;
import com.tencent.map.sdk.a.l;
import com.tencent.map.sdk.a.o;
import java.util.ArrayList;

public final class RttRequest
  extends MapJceStruct
  implements Cloneable
{
  static ArrayList<Integer> a;
  public ArrayList<Integer> bounds = null;
  public short zip = 0;
  public short zoom = 0;
  
  static
  {
    a = new ArrayList();
    a.add(Integer.valueOf(0));
  }
  
  public RttRequest() {}
  
  public RttRequest(ArrayList<Integer> paramArrayList, short paramShort1, short paramShort2)
  {
    this.bounds = paramArrayList;
    this.zoom = paramShort1;
    this.zip = paramShort2;
  }
  
  public final String className()
  {
    return "navsns.RttRequest";
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
    if (b) {
      return null;
    }
    throw new AssertionError();
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new i(paramStringBuilder, paramInt);
    paramStringBuilder.a(this.bounds, "bounds");
    paramStringBuilder.a(this.zoom, "zoom");
    paramStringBuilder.a(this.zip, "zip");
  }
  
  public final void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new i(paramStringBuilder, paramInt);
    paramStringBuilder.a(this.bounds, true);
    paramStringBuilder.a(this.zoom, true);
    paramStringBuilder.a(this.zip, false);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    paramObject = (RttRequest)paramObject;
    return (o.a(this.bounds, paramObject.bounds)) && (o.a(this.zoom, paramObject.zoom)) && (o.a(this.zip, paramObject.zip));
  }
  
  public final ArrayList<Integer> getBounds()
  {
    return this.bounds;
  }
  
  public final short getZip()
  {
    return this.zip;
  }
  
  public final short getZoom()
  {
    return this.zoom;
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
    this.bounds = ((ArrayList)paramk.a(a, 0, true));
    this.zoom = paramk.a(this.zoom, 1, true);
    this.zip = paramk.a(this.zip, 2, true);
  }
  
  public final void setBounds(ArrayList<Integer> paramArrayList)
  {
    this.bounds = paramArrayList;
  }
  
  public final void setZip(short paramShort)
  {
    this.zip = paramShort;
  }
  
  public final void setZoom(short paramShort)
  {
    this.zoom = paramShort;
  }
  
  public final void writeTo(l paraml)
  {
    paraml.a(this.bounds, 0);
    paraml.a(this.zoom, 1);
    paraml.a(this.zip, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.service.protocol.jce.rtt.RttRequest
 * JD-Core Version:    0.7.0.1
 */