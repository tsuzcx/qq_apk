package com.tencent.comic.api.plugin;

import com.tencent.comic.api.IQQComicPluginUtil;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.concurrent.ConcurrentHashMap;

public class HitRateHelper
{
  private static final ConcurrentHashMap<Integer, HitRateHelper> i = new ConcurrentHashMap();
  public PreloadProcHitPluginSession a = null;
  private final int b;
  private final int c;
  private boolean d = false;
  private boolean e = false;
  private int f = 0;
  private int g = 0;
  private String h = null;
  
  public HitRateHelper(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    c();
  }
  
  public static HitRateHelper a(int paramInt)
  {
    return (HitRateHelper)i.get(Integer.valueOf(paramInt));
  }
  
  private void b()
  {
    if (!this.d) {
      return;
    }
    ((IQQComicPluginUtil)QRoute.api(IQQComicPluginUtil.class)).reportHitRate(this.e ^ true, this.b, this.c, this.f, this.h, String.valueOf(this.g));
    c();
  }
  
  private void c()
  {
    this.d = false;
    this.e = false;
    this.f = 0;
    this.h = null;
    this.g = 0;
  }
  
  public void a()
  {
    if (!this.d) {
      return;
    }
    this.e = true;
    b();
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    HitRateHelper localHitRateHelper = (HitRateHelper)i.get(Integer.valueOf(this.b));
    if ((localHitRateHelper != null) && (localHitRateHelper.d)) {
      localHitRateHelper.b();
    }
    this.d = true;
    this.f = paramInt1;
    this.h = paramString;
    this.g = paramInt2;
    i.put(Integer.valueOf(this.b), this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.comic.api.plugin.HitRateHelper
 * JD-Core Version:    0.7.0.1
 */