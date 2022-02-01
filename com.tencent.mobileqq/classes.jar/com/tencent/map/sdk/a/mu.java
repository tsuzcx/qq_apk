package com.tencent.map.sdk.a;

import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorInfo;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class mu
  extends io
  implements gi
{
  private static AtomicInteger h = new AtomicInteger(1);
  public final String L = String.valueOf(h.incrementAndGet());
  protected boolean M = false;
  protected IndoorInfo N;
  
  public final void a(IndoorBuilding paramIndoorBuilding)
  {
    IndoorInfo localIndoorInfo = this.N;
    if (localIndoorInfo != null) {
      this.M = localIndoorInfo.toString().equals(paramIndoorBuilding.toString());
    }
    d();
  }
  
  public abstract void h();
  
  public boolean m()
  {
    return false;
  }
  
  public boolean p()
  {
    return false;
  }
  
  public final IndoorInfo q()
  {
    return this.N;
  }
  
  public final void r()
  {
    if (this.N != null) {
      this.M = false;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.mu
 * JD-Core Version:    0.7.0.1
 */