package com.tencent.map.sdk.a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.map.sdk.engine.jni.callbacks.TileOverlayCallback;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import java.io.File;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.microedition.khronos.opengles.GL10;

public class ix
  extends mu
  implements TileOverlayCallback
{
  static final String h;
  public int i;
  public Map<String, Integer> j = new Hashtable();
  public iy k;
  TileOverlayOptions l;
  public ny<iu> m;
  private qg n;
  private BlockingQueue<Runnable> o;
  private qf p = new ix.1(this);
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder("%s");
    localStringBuilder.append(File.separatorChar);
    localStringBuilder.append("%d-%d-%d");
    h = localStringBuilder.toString();
  }
  
  public ix(iy paramiy, TileOverlayOptions paramTileOverlayOptions)
  {
    this.k = paramiy;
    this.l = paramTileOverlayOptions;
    paramiy = this.k;
    int i1 = -1;
    if ((paramiy != null) && (this.l != null))
    {
      this.m = l();
      paramiy = this.k;
      boolean bool = this.l.isBetterQuality();
      if (paramiy.a != null) {
        i1 = paramiy.a.a(this, bool);
      }
      this.i = i1;
      "zl create tileOverlay:".concat(String.valueOf(this));
      paramiy = new StringBuilder("id:");
      paramiy.append(this.i);
      paramiy.toString();
      os.a();
      a(this.l.getZIndex());
      return;
    }
    this.i = -1;
  }
  
  private void k()
  {
    ny localny = this.m;
    if (localny == null) {
      return;
    }
    if ((localny instanceof ob))
    {
      localny = ((ob)localny).a(0);
      if ((localny instanceof og)) {
        localny.a();
      }
      localny = ((ob)this.m).a(1);
      if ((localny instanceof oe)) {
        ((oe)localny).b();
      }
    }
    else if ((localny instanceof og))
    {
      localny.a();
    }
    this.j.clear();
  }
  
  private ny<iu> l()
  {
    if (this.k == null) {
      return null;
    }
    og.a locala = new og.a();
    locala.a = this.l.getMaxMemoryCacheSize();
    locala.b = new ix.a((byte)0);
    if (!TextUtils.isEmpty(this.k.c))
    {
      Object localObject1 = this.l;
      if ((localObject1 != null) && (!TextUtils.isEmpty(((TileOverlayOptions)localObject1).getDiskCacheDir())))
      {
        localObject1 = new oe.c();
        if (!TextUtils.isEmpty(g())) {
          ((oe.c)localObject1).a();
        }
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(g());
        ((StringBuilder)localObject2).append(this.l.getDiskCacheDir());
        localObject2 = ((StringBuilder)localObject2).toString();
        ((oe.c)localObject1).a = new File(this.k.c);
        ((oe.c)localObject1).b = ((String)localObject2);
        ((of.c)localObject1).h = -1;
        ((of.c)localObject1).i = new it();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.k.c);
        localStringBuilder.append(File.separator);
        localStringBuilder.append((String)localObject2);
        ((oe.c)localObject1).c = new iv(localStringBuilder.toString());
        return oc.a(iu.class, new ny.a[] { locala, localObject1 });
      }
    }
    return oc.a(iu.class, new ny.a[] { locala });
  }
  
  public final void a(int paramInt)
  {
    if (this.k != null)
    {
      if (this.i < 0) {
        return;
      }
      int i1 = paramInt;
      if (paramInt < 0) {
        i1 = 0;
      }
      paramInt = e(i1);
      this.k.a(this.i, paramInt);
    }
  }
  
  public final void a(String paramString)
  {
    if (this.l != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      this.l.diskCacheDir(paramString);
      this.m = l();
    }
  }
  
  public final void a(GL10 paramGL10) {}
  
  public final boolean a()
  {
    return false;
  }
  
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void b()
  {
    if (this.k != null)
    {
      if (this.i < 0) {
        return;
      }
      k();
      Object localObject = this.n;
      if (localObject != null)
      {
        ((qg)localObject).a();
        this.n = null;
      }
      localObject = this.k;
      int i1 = this.i;
      if (((iy)localObject).a != null)
      {
        ((iy)localObject).b.remove(Integer.valueOf(i1));
        localObject = ((iy)localObject).a;
        if (((pf)localObject).b != 0L)
        {
          if (((pf)localObject).f == null) {
            return;
          }
          ((pf)localObject).f.a(new pf.26((pf)localObject, i1));
        }
      }
    }
  }
  
  public final void c() {}
  
  public final void d() {}
  
  protected int e(int paramInt)
  {
    return paramInt + 100;
  }
  
  public final qg e()
  {
    if (this.n == null)
    {
      this.n = new qg();
      this.o = new LinkedBlockingQueue();
      this.n.a(this.p);
      this.n.b = new ThreadPoolExecutor(16, 32, 0L, TimeUnit.MILLISECONDS, this.o, new ix.b(this));
    }
    return this.n;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof ix)) {
      return false;
    }
    return this.i == ((ix)paramObject).i;
  }
  
  public final void f()
  {
    if (this.k != null)
    {
      if (this.i < 0) {
        return;
      }
      k();
      Object localObject = this.k;
      int i1 = this.i;
      if (((iy)localObject).a != null)
      {
        localObject = ((iy)localObject).a;
        if ((((pf)localObject).b != 0L) && (((pf)localObject).f != null)) {
          ((pf)localObject).f.a(new pf.27((pf)localObject, i1));
        }
      }
      localObject = this.o;
      if (localObject != null) {
        ((BlockingQueue)localObject).clear();
      }
    }
  }
  
  protected String g()
  {
    return "/tile/";
  }
  
  public final void h() {}
  
  public int hashCode()
  {
    return this.L.hashCode();
  }
  
  public Bitmap onLoadTile(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    Object localObject1 = this.l;
    if (localObject1 != null)
    {
      if (((TileOverlayOptions)localObject1).getTileProvider() == null) {
        return null;
      }
      localObject1 = om.b(this.l.getVersionInfo());
      Object localObject2 = h;
      int i2 = 0;
      localObject1 = String.format((String)localObject2, new Object[] { localObject1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      os.e();
      int i1 = os.d();
      os.d();
      os.d();
      os.d();
      localObject2 = (iu)oc.a(this.m).b((String)localObject1, iu.class);
      if (localObject2 != null)
      {
        i1 = os.e();
        os.g();
      }
      "get from cache of cacheId:".concat(String.valueOf(localObject1));
      "cacheCount:".concat(String.valueOf(i1));
      os.a();
      if (localObject2 != null)
      {
        this.j.remove(localObject1);
        return ((ok)localObject2).b;
      }
      localObject2 = (Integer)this.j.get(localObject1);
      if ((localObject2 != null) && (((Integer)localObject2).intValue() > 10))
      {
        paramArrayOfByte = this.j.entrySet().iterator();
        paramInt1 = i2;
        while (paramArrayOfByte.hasNext())
        {
          paramInt2 = paramInt1;
          if (((Integer)((Map.Entry)paramArrayOfByte.next()).getValue()).intValue() > 10) {
            paramInt2 = paramInt1 + 1;
          }
          paramInt1 = paramInt2;
          if (paramInt2 > 50)
          {
            or.b("超过50个瓦片请求大于10次，重新加载TileOverlay");
            f();
          }
        }
        return null;
      }
      Map localMap = this.j;
      if (localObject2 == null) {
        i1 = 0;
      } else {
        i1 = ((Integer)localObject2).intValue() + 1;
      }
      localMap.put(localObject1, Integer.valueOf(i1));
      localObject1 = new StringBuilder(128);
      ((StringBuilder)localObject1).append("tileOverlay://getTile/");
      ((StringBuilder)localObject1).append(this.i);
      ((StringBuilder)localObject1).append("?x=");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append("&y=");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append("&z=");
      ((StringBuilder)localObject1).append(paramInt3);
      localObject1 = ((StringBuilder)localObject1).toString().getBytes();
      System.arraycopy(localObject1, 0, paramArrayOfByte, 0, localObject1.length);
    }
    return null;
  }
  
  public void onWriteTile(int paramInt1, int paramInt2, int paramInt3, String paramString, byte[] paramArrayOfByte) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.ix
 * JD-Core Version:    0.7.0.1
 */