package com.tencent.mapsdk.rastercore.c;

import com.tencent.mapsdk.rastercore.d.e;
import com.tencent.tencentmap.mapsdk.map.CancelableCallback;

public abstract class a
{
  protected boolean a = true;
  protected long b = 1000L;
  protected CancelableCallback c = null;
  
  public final void a(long paramLong)
  {
    this.b = paramLong;
  }
  
  public abstract void a(e parame);
  
  public final void a(CancelableCallback paramCancelableCallback)
  {
    this.c = paramCancelableCallback;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.a = false;
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.c.a
 * JD-Core Version:    0.7.0.1
 */