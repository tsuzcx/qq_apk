package com.tencent.map.sdk.a;

import com.tencent.map.lib.MapLanguage;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.listener.MapLanguageChangeListener;
import java.util.List;

public final class lw$c
  implements MapLanguageChangeListener
{
  public List<hk> a;
  public List<GeoPoint> b;
  
  public lw$c(lw arg1)
  {
    if (???.t == null) {
      ???.t = new lw.b(???);
    }
    lw.b localb = ???.t;
    synchronized (localb.a)
    {
      if (!localb.a.contains(this)) {
        localb.a.add(this);
      }
      return;
    }
  }
  
  public final void onLanguageChange(MapLanguage paramMapLanguage)
  {
    if (paramMapLanguage == MapLanguage.LAN_CHINESE)
    {
      if ((this.a != null) && (this.b != null)) {
        this.c.a.a(this.a, this.b);
      }
    }
    else {
      this.c.a.s();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.lw.c
 * JD-Core Version:    0.7.0.1
 */