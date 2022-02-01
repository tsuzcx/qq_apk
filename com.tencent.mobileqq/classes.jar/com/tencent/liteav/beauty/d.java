package com.tencent.liteav.beauty;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.tencent.liteav.basic.c.j;
import com.tencent.liteav.basic.log.TXCLog;

public class d
  extends com.tencent.liteav.basic.module.a
  implements e
{
  protected Context a;
  protected boolean b = true;
  protected boolean c = false;
  protected int d = 0;
  protected int e = 0;
  protected int f = 1;
  protected com.tencent.liteav.basic.c.a g = null;
  protected c h;
  protected d.b i = new d.b();
  protected d.c j = null;
  f k;
  private d.d l = d.d.c;
  private long m = 0L;
  private long n = 0L;
  private long o = 0L;
  private Object p;
  private d.a q = new d.a(this);
  
  public d(Context paramContext, boolean paramBoolean)
  {
    Object localObject = (ActivityManager)paramContext.getSystemService("activity");
    TXCLog.i("TXCVideoPreprocessor", "TXCVideoPreprocessor version: VideoPreprocessor-v1.1");
    localObject = ((ActivityManager)localObject).getDeviceConfigurationInfo();
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("opengl es version ");
      localStringBuilder.append(((ConfigurationInfo)localObject).reqGlEsVersion);
      TXCLog.i("TXCVideoPreprocessor", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("set GLContext ");
      localStringBuilder.append(paramBoolean);
      TXCLog.i("TXCVideoPreprocessor", localStringBuilder.toString());
      if (((ConfigurationInfo)localObject).reqGlEsVersion > 131072)
      {
        TXCLog.i("TXCVideoPreprocessor", "This devices is OpenGlUtils.OPENGL_ES_3");
        j.a(3);
      }
      else
      {
        TXCLog.i("TXCVideoPreprocessor", "This devices is OpenGlUtils.OPENGL_ES_2");
        j.a(2);
      }
    }
    else
    {
      TXCLog.e("TXCVideoPreprocessor", "getDeviceConfigurationInfo opengl Info failed!");
    }
    this.a = paramContext;
    this.b = paramBoolean;
    this.h = new c(this.a, this.b);
    a.a().a(paramContext);
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.j == null)
    {
      this.j = new d.c(null);
      this.n = 0L;
      this.o = System.currentTimeMillis();
    }
    if ((paramInt1 == this.j.b) && (paramInt2 == this.j.c) && (paramInt3 == this.j.d))
    {
      i1 = this.d;
      if ((i1 <= 0) || (i1 == this.j.f))
      {
        i1 = this.e;
        if ((i1 <= 0) || (i1 == this.j.g))
        {
          localObject = this.g;
          if (((localObject == null) || (((((com.tencent.liteav.basic.c.a)localObject).c <= 0) || ((this.j.j != null) && (this.g.c == this.j.j.c))) && ((this.g.d <= 0) || ((this.j.j != null) && (this.g.d == this.j.j.d))) && ((this.g.a < 0) || ((this.j.j != null) && (this.g.a == this.j.j.a))) && ((this.g.b < 0) || ((this.j.j != null) && (this.g.b == this.j.j.b))))) && (this.c == this.j.e) && (this.j.h == paramInt4))
          {
            if ((paramInt4 == this.j.h) && (paramInt5 == this.j.i)) {
              break label994;
            }
            localObject = this.j;
            ((d.c)localObject).h = paramInt4;
            d.b localb = this.i;
            localb.k = paramInt4;
            ((d.c)localObject).i = paramInt5;
            localb.l = paramInt5;
            this.h.b(paramInt5);
            break label994;
          }
        }
      }
    }
    TXCLog.i("TXCVideoPreprocessor", "Init sdk");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Input widht ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" height ");
    ((StringBuilder)localObject).append(paramInt2);
    TXCLog.i("TXCVideoPreprocessor", ((StringBuilder)localObject).toString());
    localObject = this.j;
    ((d.c)localObject).b = paramInt1;
    ((d.c)localObject).c = paramInt2;
    localObject = this.g;
    int i2 = paramInt1;
    int i1 = paramInt2;
    if (localObject != null)
    {
      i2 = paramInt1;
      i1 = paramInt2;
      if (((com.tencent.liteav.basic.c.a)localObject).a >= 0)
      {
        i2 = paramInt1;
        i1 = paramInt2;
        if (this.g.b >= 0)
        {
          i2 = paramInt1;
          i1 = paramInt2;
          if (this.g.c > 0)
          {
            i2 = paramInt1;
            i1 = paramInt2;
            if (this.g.d > 0)
            {
              TXCLog.i("TXCVideoPreprocessor", "set Crop Rect; init ");
              if (paramInt1 - this.g.a > this.g.c) {
                paramInt1 = this.g.c;
              } else {
                paramInt1 -= this.g.a;
              }
              if (paramInt2 - this.g.b > this.g.d) {
                paramInt2 = this.g.d;
              } else {
                paramInt2 -= this.g.b;
              }
              localObject = this.g;
              ((com.tencent.liteav.basic.c.a)localObject).c = paramInt1;
              ((com.tencent.liteav.basic.c.a)localObject).d = paramInt2;
              i2 = ((com.tencent.liteav.basic.c.a)localObject).c;
              i1 = this.g.d;
            }
          }
        }
      }
    }
    paramInt1 = i2;
    paramInt2 = i1;
    localObject = this.j;
    ((d.c)localObject).j = this.g;
    ((d.c)localObject).d = paramInt3;
    ((d.c)localObject).a = this.b;
    ((d.c)localObject).h = paramInt4;
    ((d.c)localObject).i = paramInt5;
    ((d.c)localObject).f = this.d;
    ((d.c)localObject).g = this.e;
    if ((((d.c)localObject).f <= 0) || (this.j.g <= 0)) {
      if ((90 != this.j.d) && (270 != this.j.d))
      {
        localObject = this.j;
        ((d.c)localObject).f = paramInt1;
        ((d.c)localObject).g = paramInt2;
      }
      else
      {
        localObject = this.j;
        ((d.c)localObject).f = paramInt2;
        ((d.c)localObject).g = paramInt1;
      }
    }
    if (this.l == d.d.a)
    {
      if ((90 != this.j.d) && (270 != this.j.d))
      {
        paramInt1 = this.j.f;
        paramInt2 = this.j.g;
      }
      else
      {
        paramInt1 = this.j.g;
        paramInt2 = this.j.f;
      }
    }
    else if (this.l != d.d.b)
    {
      localObject = b(paramInt1, paramInt2, this.j.d, this.j.f, this.j.g);
      paramInt1 = (((com.tencent.liteav.basic.util.d)localObject).a + 7) / 8 * 8;
      paramInt2 = (((com.tencent.liteav.basic.util.d)localObject).b + 7) / 8 * 8;
    }
    localObject = this.j;
    ((d.c)localObject).e = this.c;
    if (!a((d.c)localObject, paramInt1, paramInt2))
    {
      TXCLog.e("TXCVideoPreprocessor", "init failed!");
      return false;
    }
    label994:
    return true;
  }
  
  private boolean a(d.c paramc, int paramInt1, int paramInt2)
  {
    this.i.d = paramc.b;
    this.i.e = paramc.c;
    this.i.m = paramc.j;
    d.b localb = this.i;
    localb.g = paramInt1;
    localb.f = paramInt2;
    localb.h = ((paramc.d + 360) % 360);
    this.i.b = paramc.f;
    this.i.c = paramc.g;
    localb = this.i;
    localb.a = 0;
    localb.j = paramc.a;
    this.i.i = paramc.e;
    this.i.k = paramc.h;
    this.i.l = paramc.i;
    if (this.h == null)
    {
      this.h = new c(this.a, paramc.a);
      this.h.a(this.f);
    }
    return this.h.a(this.i);
  }
  
  private com.tencent.liteav.basic.util.d b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i2;
    int i1;
    if (paramInt3 != 90)
    {
      i2 = paramInt4;
      i1 = paramInt5;
      if (paramInt3 != 270) {}
    }
    else
    {
      i1 = paramInt4;
      i2 = paramInt5;
    }
    paramInt4 = Math.min(i2, i1);
    paramInt5 = Math.min(paramInt1, paramInt2);
    int[] arrayOfInt = new int[3];
    int[] tmp52_50 = arrayOfInt;
    tmp52_50[0] = 720;
    int[] tmp58_52 = tmp52_50;
    tmp58_52[1] = 1080;
    int[] tmp64_58 = tmp58_52;
    tmp64_58[2] = 1280;
    tmp64_58;
    int i3 = arrayOfInt.length;
    paramInt3 = 0;
    while (paramInt3 < i3)
    {
      int i4 = arrayOfInt[paramInt3];
      if ((paramInt4 <= i4) && (paramInt5 >= i4))
      {
        float f1 = i4 * 1.0F / paramInt4;
        return new com.tencent.liteav.basic.util.d((int)(i2 * f1), (int)(f1 * i1));
      }
      paramInt3 += 1;
    }
    return new com.tencent.liteav.basic.util.d(paramInt1, paramInt2);
  }
  
  private void c()
  {
    if (this.m != 0L) {
      setStatusValue(3002, Long.valueOf(System.currentTimeMillis() - this.m));
    }
    this.n += 1L;
    long l1 = System.currentTimeMillis();
    long l2 = this.o;
    if (l1 > 2000L + l2)
    {
      double d1 = this.n;
      Double.isNaN(d1);
      double d2 = l1 - l2;
      Double.isNaN(d2);
      setStatusValue(3003, Double.valueOf(d1 * 1000.0D / d2));
      this.n = 0L;
      this.o = l1;
    }
  }
  
  private int z(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return paramInt;
        }
        return 270;
      }
      return 180;
    }
    return 90;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = this.k;
    boolean bool = false;
    if (localObject != null)
    {
      localObject = new com.tencent.liteav.basic.structs.b();
      ((com.tencent.liteav.basic.structs.b)localObject).e = paramInt2;
      ((com.tencent.liteav.basic.structs.b)localObject).f = paramInt3;
      ((com.tencent.liteav.basic.structs.b)localObject).j = 0;
      d.c localc = this.j;
      if (localc != null) {
        bool = localc.e;
      }
      ((com.tencent.liteav.basic.structs.b)localObject).i = bool;
      ((com.tencent.liteav.basic.structs.b)localObject).a = paramInt1;
      return this.k.a((com.tencent.liteav.basic.structs.b)localObject);
    }
    return 0;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong)
  {
    try
    {
      a(paramInt2, paramInt3, z(paramInt4), paramInt5, paramInt6);
      this.h.b(this.i);
      paramInt1 = this.h.a(paramInt1, paramInt5, paramLong);
      return paramInt1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int a(com.tencent.liteav.basic.structs.b paramb, int paramInt1, int paramInt2, long paramLong)
  {
    try
    {
      this.m = System.currentTimeMillis();
      a(paramb.l);
      a(paramb.g, paramb.h);
      b(paramb.i);
      a(paramb.c);
      a(paramb.d);
      if ((paramb.m != null) && (paramb.a == -1))
      {
        paramInt1 = a(paramb.m, paramb.e, paramb.f, paramb.j, paramInt1, paramInt2);
        return paramInt1;
      }
      paramInt1 = a(paramb.a, paramb.e, paramb.f, paramb.j, paramInt1, paramInt2, paramLong);
      return paramInt1;
    }
    finally {}
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    try
    {
      a(paramInt1, paramInt2, z(paramInt3), paramInt4, paramInt5);
      this.h.b(this.i);
      paramInt1 = this.h.a(paramArrayOfByte, paramInt4);
      return paramInt1;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public Object a()
  {
    try
    {
      Object localObject1 = this.p;
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public void a(float paramFloat)
  {
    try
    {
      if (this.h != null) {
        this.h.a(paramFloat);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt != this.f)
    {
      this.f = paramInt;
      c localc = this.h;
      if (localc != null) {
        localc.a(this.f);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    try
    {
      this.d = paramInt1;
      this.e = paramInt2;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    c();
    if (this.k != null)
    {
      com.tencent.liteav.basic.structs.b localb = new com.tencent.liteav.basic.structs.b();
      localb.e = paramInt2;
      localb.f = paramInt3;
      boolean bool = false;
      localb.j = 0;
      d.c localc = this.j;
      if (localc != null) {
        bool = localc.e;
      }
      localb.i = bool;
      localb.a = paramInt1;
      this.k.a(localb, paramLong);
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    try
    {
      if (this.h != null) {
        this.h.a(paramBitmap);
      }
      return;
    }
    finally
    {
      paramBitmap = finally;
      throw paramBitmap;
    }
  }
  
  public void a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if ((paramFloat1 >= 0.0F) && (paramFloat2 >= 0.0F) && (paramFloat3 >= 0.0D)) {}
    try
    {
      if (this.h != null) {
        this.h.a(paramBitmap, paramFloat1, paramFloat2, paramFloat3);
      }
      return;
    }
    finally {}
    TXCLog.e("TXCVideoPreprocessor", "WaterMark param is Error!");
  }
  
  public void a(com.tencent.liteav.basic.b.b paramb)
  {
    try
    {
      if (this.h == null)
      {
        TXCLog.e("TXCVideoPreprocessor", "setListener mDrawer is null!");
        return;
      }
      this.h.a(paramb);
      return;
    }
    finally {}
  }
  
  public void a(com.tencent.liteav.basic.c.a parama)
  {
    try
    {
      this.g = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public void a(d.d paramd)
  {
    try
    {
      this.l = paramd;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("set Process SDK performance ");
      localStringBuilder.append(paramd);
      TXCLog.i("TXCVideoPreprocessor", localStringBuilder.toString());
      return;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
  
  public void a(f paramf)
  {
    try
    {
      if (this.h == null)
      {
        TXCLog.e("TXCVideoPreprocessor", "setListener mDrawer is null!");
        return;
      }
      this.k = paramf;
      if (paramf == null) {
        this.h.a(null);
      } else {
        this.h.a(this);
      }
      return;
    }
    finally {}
  }
  
  public void a(Object paramObject)
  {
    try
    {
      this.p = paramObject;
      return;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      if (this.h != null) {
        this.h.a(paramString);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    c localc = this.h;
    if (localc != null) {
      localc.a(paramBoolean);
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    f localf = this.k;
    if (localf != null) {
      localf.b(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramLong);
    }
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    c localc = this.h;
    if (localc != null) {
      localc.a(paramArrayOfFloat);
    }
  }
  
  @TargetApi(18)
  public boolean a(String paramString, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 18) {
      return false;
    }
    c localc = this.h;
    if (localc != null) {
      localc.a(paramString, paramBoolean);
    }
    return true;
  }
  
  public void b()
  {
    try
    {
      if (this.h != null) {
        this.h.a();
      }
      this.j = null;
      return;
    }
    finally {}
  }
  
  public void b(int paramInt)
  {
    try
    {
      if (this.h != null) {
        this.h.d(paramInt);
      }
      this.q.a("beautyStyle", paramInt);
      return;
    }
    finally {}
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      this.c = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c(int paramInt)
  {
    if (paramInt > 9) {}
    try
    {
      TXCLog.e("TXCVideoPreprocessor", "Beauty value too large! set max value 9");
      int i1 = 9;
      break label38;
      i1 = paramInt;
      if (paramInt < 0)
      {
        TXCLog.e("TXCVideoPreprocessor", "Beauty < 0; set 0");
        i1 = 0;
      }
      label38:
      if (this.h != null) {
        this.h.c(i1);
      }
      this.q.a("beautyLevel", i1);
      return;
    }
    finally
    {
      label67:
      Object localObject1;
      break label67;
    }
    throw localObject1;
  }
  
  public void c(boolean paramBoolean)
  {
    try
    {
      if (this.h != null) {
        this.h.b(paramBoolean);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void d(int paramInt)
  {
    if (paramInt > 9) {}
    try
    {
      TXCLog.e("TXCVideoPreprocessor", "Brightness value too large! set max value 9");
      int i1 = 9;
      break label38;
      i1 = paramInt;
      if (paramInt < 0)
      {
        TXCLog.e("TXCVideoPreprocessor", "Brightness < 0; set 0");
        i1 = 0;
      }
      label38:
      if (this.h != null) {
        this.h.e(i1);
      }
      this.q.a("whiteLevel", i1);
      return;
    }
    finally
    {
      label67:
      Object localObject1;
      break label67;
    }
    throw localObject1;
  }
  
  public void e(int paramInt)
  {
    if (paramInt > 9) {}
    try
    {
      TXCLog.e("TXCVideoPreprocessor", "Ruddy value too large! set max value 9");
      int i1 = 9;
      break label38;
      i1 = paramInt;
      if (paramInt < 0)
      {
        TXCLog.e("TXCVideoPreprocessor", "Ruddy < 0; set 0");
        i1 = 0;
      }
      label38:
      if (this.h != null) {
        this.h.g(i1);
      }
      this.q.a("ruddyLevel", i1);
      return;
    }
    finally
    {
      label67:
      Object localObject1;
      break label67;
    }
    throw localObject1;
  }
  
  public void f(int paramInt)
  {
    int i1;
    if (paramInt > 9)
    {
      TXCLog.e("TXCVideoPreprocessor", "Brightness value too large! set max value 9");
      i1 = 9;
    }
    else
    {
      i1 = paramInt;
      if (paramInt < 0)
      {
        TXCLog.e("TXCVideoPreprocessor", "Brightness < 0; set 0");
        i1 = 0;
      }
    }
    c localc = this.h;
    if (localc != null) {
      localc.f(i1);
    }
  }
  
  public void g(int paramInt)
  {
    try
    {
      if (this.h != null) {
        this.h.h(paramInt);
      }
      this.q.a("eyeBigScale", paramInt);
      return;
    }
    finally {}
  }
  
  public void h(int paramInt)
  {
    try
    {
      if (this.h != null) {
        this.h.i(paramInt);
      }
      this.q.a("faceSlimLevel", paramInt);
      return;
    }
    finally {}
  }
  
  public void i(int paramInt)
  {
    c localc = this.h;
    if (localc != null) {
      localc.j(paramInt);
    }
    this.q.a("faceVLevel", paramInt);
  }
  
  public void j(int paramInt)
  {
    c localc = this.h;
    if (localc != null) {
      localc.k(paramInt);
    }
    this.q.a("faceShortLevel", paramInt);
  }
  
  public void k(int paramInt)
  {
    c localc = this.h;
    if (localc != null) {
      localc.l(paramInt);
    }
    this.q.a("chinLevel", paramInt);
  }
  
  public void l(int paramInt)
  {
    c localc = this.h;
    if (localc != null) {
      localc.m(paramInt);
    }
    this.q.a("noseSlimLevel", paramInt);
  }
  
  public void m(int paramInt)
  {
    c localc = this.h;
    if (localc != null) {
      localc.n(paramInt);
    }
    this.q.a("eyeLightenLevel", paramInt);
  }
  
  public void n(int paramInt)
  {
    c localc = this.h;
    if (localc != null) {
      localc.o(paramInt);
    }
    this.q.a("toothWhitenLevel", paramInt);
  }
  
  public void o(int paramInt)
  {
    c localc = this.h;
    if (localc != null) {
      localc.p(paramInt);
    }
    this.q.a("wrinkleRemoveLevel", paramInt);
  }
  
  public void p(int paramInt)
  {
    c localc = this.h;
    if (localc != null) {
      localc.q(paramInt);
    }
    this.q.a("pounchRemoveLevel", paramInt);
  }
  
  public void q(int paramInt)
  {
    c localc = this.h;
    if (localc != null) {
      localc.r(paramInt);
    }
    this.q.a("smileLinesRemoveLevel", paramInt);
  }
  
  public void r(int paramInt)
  {
    c localc = this.h;
    if (localc != null) {
      localc.s(paramInt);
    }
    this.q.a("foreheadLevel", paramInt);
  }
  
  public void s(int paramInt)
  {
    c localc = this.h;
    if (localc != null) {
      localc.t(paramInt);
    }
    this.q.a("eyeDistanceLevel", paramInt);
  }
  
  public void setID(String paramString)
  {
    super.setID(paramString);
    setStatusValue(3001, this.q.a());
  }
  
  public void t(int paramInt)
  {
    c localc = this.h;
    if (localc != null) {
      localc.u(paramInt);
    }
    this.q.a("eyeAngleLevel", paramInt);
  }
  
  public void u(int paramInt)
  {
    c localc = this.h;
    if (localc != null) {
      localc.v(paramInt);
    }
    this.q.a("mouthShapeLevel", paramInt);
  }
  
  public void v(int paramInt)
  {
    c localc = this.h;
    if (localc != null) {
      localc.w(paramInt);
    }
    this.q.a("noseWingLevel", paramInt);
  }
  
  public void w(int paramInt)
  {
    c localc = this.h;
    if (localc != null) {
      localc.x(paramInt);
    }
    this.q.a("nosePositionLevel", paramInt);
  }
  
  public void x(int paramInt)
  {
    c localc = this.h;
    if (localc != null) {
      localc.y(paramInt);
    }
    this.q.a("lipsThicknessLevel", paramInt);
  }
  
  public void y(int paramInt)
  {
    c localc = this.h;
    if (localc != null) {
      localc.z(paramInt);
    }
    this.q.a("faceBeautyLevel", paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.beauty.d
 * JD-Core Version:    0.7.0.1
 */