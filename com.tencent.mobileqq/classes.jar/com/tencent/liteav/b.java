package com.tencent.liteav;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.os.HandlerThread;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class b
{
  private static final String a = "b";
  private int b = 300;
  private long c = 0L;
  private b.a d;
  private HandlerThread e;
  private boolean f = false;
  private ByteBuffer g = null;
  private Bitmap h = null;
  private int i = 0;
  private int j = 0;
  private WeakReference<b.b> k = null;
  
  public b(b.b paramb)
  {
    this.k = new WeakReference(paramb);
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0)
    {
      int m;
      if (paramInt1 >= 20)
      {
        m = 20;
      }
      else
      {
        m = paramInt1;
        if (paramInt1 <= 5) {
          m = 5;
        }
      }
      this.b = (1000 / m);
    }
    else
    {
      this.b = 200;
    }
    long l = paramInt2;
    if (paramInt2 > 0)
    {
      this.c = (System.currentTimeMillis() + l * 1000L);
      return;
    }
    if (paramInt2 == 0)
    {
      this.c = (System.currentTimeMillis() + 300000L);
      return;
    }
    this.c = -1L;
  }
  
  private void d()
  {
    e();
    this.e = new HandlerThread("TXImageCapturer");
    this.e.start();
    this.d = new b.a(this, this.e.getLooper(), this.b, this.c);
  }
  
  private void e()
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      ((b.a)localObject).removeCallbacksAndMessages(null);
      this.d = null;
    }
    localObject = this.e;
    if (localObject != null)
    {
      ((HandlerThread)localObject).quit();
      this.e = null;
    }
  }
  
  private void f()
  {
    i1 = 0;
    i2 = 0;
    n = 0;
    try
    {
      if ((this.k != null) && (this.f))
      {
        localObject2 = (b.b)this.k.get();
        if (localObject2 != null)
        {
          localBitmap = this.h;
          localObject1 = this.g;
          if ((localObject1 == null) && (localBitmap != null)) {
            m = localBitmap.getWidth();
          }
        }
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject2;
        Bitmap localBitmap;
        Object localObject1;
        int m;
        n = i2;
      }
    }
    catch (Error localError1)
    {
      for (;;)
      {
        label110:
        n = i1;
      }
    }
    try
    {
      n = localBitmap.getHeight();
    }
    catch (Exception localException2)
    {
      break label133;
    }
    catch (Error localError2)
    {
      break label128;
    }
    try
    {
      localObject1 = ByteBuffer.allocateDirect(m * n * 4);
      localBitmap.copyPixelsToBuffer((Buffer)localObject1);
      ((ByteBuffer)localObject1).rewind();
      this.g = ((ByteBuffer)localObject1);
      i1 = n;
      n = m;
      m = i1;
    }
    catch (Exception localException3)
    {
      break label119;
    }
    catch (Error localError3)
    {
      break label110;
    }
    i1 = n;
    n = m;
    m = i1;
    break label172;
    label119:
    i1 = n;
    n = m;
    m = i1;
    break label229;
    label128:
    n = m;
    break label170;
    label133:
    n = m;
    break label227;
    m = 0;
    if ((localBitmap != null) && (localObject1 != null)) {}
    try
    {
      ((b.b)localObject2).a(localBitmap, (ByteBuffer)localObject1, this.i, this.j);
      return;
    }
    catch (Exception localException4)
    {
      break label229;
    }
    catch (Error localError4)
    {
      label170:
      break label172;
    }
    m = 0;
    label172:
    localObject1 = a;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("bkgpush: generate bitmap pixel error ");
    ((StringBuilder)localObject2).append(n);
    ((StringBuilder)localObject2).append("*");
    ((StringBuilder)localObject2).append(m);
    TXCLog.w((String)localObject1, ((StringBuilder)localObject2).toString());
    return;
    label227:
    m = 0;
    label229:
    localObject1 = a;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("bkgpush: generate bitmap pixel exception ");
    ((StringBuilder)localObject2).append(n);
    ((StringBuilder)localObject2).append("*");
    ((StringBuilder)localObject2).append(m);
    TXCLog.w((String)localObject1, ((StringBuilder)localObject2).toString());
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.f)
    {
      TXCLog.w(a, "bkgpush: start background publish return when started");
      return;
    }
    this.f = true;
    b(paramInt1, paramInt2);
    d();
    Object localObject = this.d;
    if (localObject != null) {
      ((b.a)localObject).sendEmptyMessageDelayed(1001, this.b);
    }
    localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bkgpush: start background publish with time:");
    localStringBuilder.append((this.c - System.currentTimeMillis()) / 1000L);
    localStringBuilder.append(", interval:");
    localStringBuilder.append(this.b);
    TXCLog.w((String)localObject, localStringBuilder.toString());
  }
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3, int paramInt4)
  {
    if (this.f)
    {
      TXCLog.w(a, "bkgpush: start background publish return when started");
      return;
    }
    Object localObject = paramBitmap;
    if (paramBitmap == null) {}
    try
    {
      paramBitmap = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bkgpush: background publish img is empty, add default img ");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append("*");
      ((StringBuilder)localObject).append(paramInt4);
      TXCLog.w(paramBitmap, ((StringBuilder)localObject).toString());
      paramBitmap = new ColorDrawable(-16777216);
      localObject = Bitmap.createBitmap(paramInt3, paramInt4, Bitmap.Config.ARGB_8888);
      paramBitmap.draw(new Canvas((Bitmap)localObject));
      paramBitmap = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bkgpush: generate bitmap ");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append("*");
      localStringBuilder.append(paramInt4);
      TXCLog.w(paramBitmap, localStringBuilder.toString());
      this.h = ((Bitmap)localObject);
    }
    catch (Error paramBitmap)
    {
      TXCLog.e(a, "save bitmap failed.", paramBitmap);
    }
    catch (Exception paramBitmap)
    {
      TXCLog.e(a, "save bitmap failed.", paramBitmap);
    }
    this.i = paramInt3;
    this.j = paramInt4;
    a(paramInt1, paramInt2);
  }
  
  public boolean a()
  {
    return this.f;
  }
  
  public void b()
  {
    this.f = false;
    this.g = null;
    this.h = null;
    TXCLog.w(a, "bkgpush: stop background publish");
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.b
 * JD-Core Version:    0.7.0.1
 */