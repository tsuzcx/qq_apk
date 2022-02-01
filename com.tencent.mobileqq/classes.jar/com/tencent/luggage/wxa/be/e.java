package com.tencent.luggage.wxa.be;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.media.CamcorderProfile;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.luggage.wxa.f.h;
import com.tencent.luggage.wxa.f.q;
import com.tencent.luggage.wxa.g.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class e
  implements d
{
  protected h a;
  protected d.a b;
  protected i c = null;
  private String d;
  private int e;
  private int f;
  private int g;
  private boolean h;
  private Point i;
  private Point j;
  private CamcorderProfile k;
  private d.c l;
  private d.b m;
  private d.e n;
  private d.f o;
  private Point p = new Point(0, 0);
  private float[] q;
  
  public e() {}
  
  public e(Context paramContext)
  {
    this.a = new h(paramContext, false);
    m();
  }
  
  public View a()
  {
    return this.a;
  }
  
  public void a(float paramFloat)
  {
    this.a.setDisplayRatio(paramFloat);
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.f = paramInt1;
    try
    {
      this.k = CamcorderProfile.get(this.e, 5);
    }
    catch (RuntimeException localRuntimeException)
    {
      o.c("MicroMsg.LuggageRecordView", "get 720p camcorder profile fail, try to get default high profile", new Object[] { localRuntimeException });
      this.k = CamcorderProfile.get(this.e, 1);
    }
    CamcorderProfile localCamcorderProfile = this.k;
    localCamcorderProfile.videoBitRate = paramInt2;
    localCamcorderProfile.videoFrameRate = paramInt3;
    localCamcorderProfile.audioBitRate = paramInt4;
    localCamcorderProfile.audioSampleRate = paramInt5;
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    h localh = this.a;
    if (localh == null) {
      return;
    }
    localh.a(paramMotionEvent);
  }
  
  public void a(d.a parama)
  {
    this.b = parama;
    h localh = this.a;
    if (localh != null)
    {
      boolean bool;
      if (parama != null) {
        bool = true;
      } else {
        bool = false;
      }
      localh.setScanning(bool);
    }
  }
  
  public void a(d.b paramb)
  {
    this.m = paramb;
  }
  
  public void a(d.c paramc)
  {
    this.l = paramc;
  }
  
  public void a(d.e parame, boolean paramBoolean)
  {
    if (paramBoolean) {
      c(1);
    }
    this.n = parame;
    if (paramBoolean)
    {
      t.a(new e.2(this), 100L);
      return;
    }
    this.a.d();
  }
  
  public void a(d.f paramf)
  {
    this.o = paramf;
    this.a.e();
  }
  
  protected void a(h paramh, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    paramh = this.c;
    if (paramh != null) {
      paramh.a(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    }
    paramh = this.b;
    if (paramh != null) {
      paramh.a(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  public void a(String paramString)
  {
    o.d("MicroMsg.LuggageRecordView", "setVideoFilePath: %s", new Object[] { paramString });
    this.d = paramString;
  }
  
  public void a(ByteBuffer paramByteBuffer, d.d paramd)
  {
    if ((paramd == null) && (paramByteBuffer == null))
    {
      paramByteBuffer = this.c;
      if (paramByteBuffer != null)
      {
        paramByteBuffer.b();
        this.c = null;
      }
      return;
    }
    if (this.c == null)
    {
      this.c = new i();
      this.c.a(com.tencent.luggage.wxa.g.b.a(g()), this.p.x, this.p.y);
      this.c.a(new e.3(this, paramd, paramByteBuffer));
      this.c.a();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.setFacing(paramBoolean ^ true);
  }
  
  public void b()
  {
    this.a.a();
  }
  
  public void b(int paramInt)
  {
    this.a.setPreviewSizeLimit(paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    this.a.setClipVideoSize(paramBoolean);
  }
  
  public boolean b(float paramFloat)
  {
    if (this.a == null) {
      return false;
    }
    float[] arrayOfFloat = this.q;
    if (arrayOfFloat != null)
    {
      if (arrayOfFloat.length == 0) {
        return false;
      }
      int i1 = 0;
      for (;;)
      {
        arrayOfFloat = this.q;
        if ((i1 >= arrayOfFloat.length) || (arrayOfFloat[i1] == paramFloat)) {
          break;
        }
        i1 += 1;
      }
      if (i1 == this.q.length) {
        return false;
      }
      this.a.setForceZoomTargetRatio(paramFloat);
      return true;
    }
    return false;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public void c(int paramInt)
  {
    int i2 = 0;
    int i1;
    if (paramInt != 1)
    {
      i1 = i2;
      if (paramInt != 2) {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            i1 = i2;
          } else {
            i1 = 2;
          }
        }
        else {
          i1 = 3;
        }
      }
    }
    else
    {
      i1 = 1;
    }
    this.a.setFlash(i1);
  }
  
  public void c(boolean paramBoolean)
  {
    this.h = paramBoolean;
    if (this.h)
    {
      h localh = this.a;
      if ((localh != null) && (localh.c()))
      {
        this.i = a.a(n().x, n().y, com.tencent.luggage.wxa.g.b.a(g()), this.a.getDisplayRatio());
        this.j = a.a(o().x, o().y, com.tencent.luggage.wxa.g.b.a(g()), this.a.getDisplayRatio());
      }
    }
  }
  
  public void d(int paramInt)
  {
    o.d("MicroMsg.LuggageRecordView", "setRGBSizeLimit: %s", new Object[] { Integer.valueOf(paramInt) });
    this.g = paramInt;
  }
  
  public boolean d()
  {
    return this.a.a(this.d, this.f, 500000000, true, this.k, true);
  }
  
  public void e() {}
  
  public Point f()
  {
    o.d("MicroMsg.LuggageRecordView", "getDrawSizePoint : %s", new Object[] { this.p.toString() });
    return this.p;
  }
  
  public int g()
  {
    return this.a.getCameraOrientation();
  }
  
  public void h()
  {
    if (this.a.getFacing() == 0)
    {
      this.a.setFacing(1);
      return;
    }
    this.a.setFacing(0);
  }
  
  public float[] i()
  {
    h localh = this.a;
    if (localh == null) {
      return new float[0];
    }
    if (this.q == null) {
      this.q = localh.getSupportZoomRatios();
    }
    return this.q;
  }
  
  public void j()
  {
    this.a.i();
  }
  
  public Bitmap k()
  {
    Object localObject1 = this.a.getCurrentFrameData();
    if (localObject1 == null)
    {
      o.d("MicroMsg.LuggageRecordView", "getCurrentFramePicture sourceData is null");
      return null;
    }
    int i1 = this.a.getPreviewSize().a();
    int i2 = this.a.getPreviewSize().b();
    localObject1 = new YuvImage((byte[])localObject1, 17, i1, i2, null);
    Object localObject2 = new ByteArrayOutputStream();
    ((YuvImage)localObject1).compressToJpeg(new Rect(0, 0, i1, i2), 100, (OutputStream)localObject2);
    localObject1 = ((ByteArrayOutputStream)localObject2).toByteArray();
    localObject1 = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length);
    localObject2 = com.tencent.luggage.wxa.qz.b.a((Bitmap)localObject1, this.a.getCameraOrientation());
    o.d("MicroMsg.LuggageRecordView", "bitmap recycle %s", new Object[] { localObject1 });
    ((Bitmap)localObject1).recycle();
    return localObject2;
  }
  
  public void l()
  {
    o.d("MicroMsg.LuggageRecordView", "release: cameraview stop now");
    this.a.b();
    this.i = null;
    this.j = null;
    i locali = this.c;
    if (locali != null) {
      locali.b();
    }
  }
  
  protected void m()
  {
    this.a.a(new e.1(this));
    this.a.setAutoFocus(true);
  }
  
  public Point n()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return null;
    }
    localObject = ((h)localObject).getPictureSize();
    if (localObject == null) {
      return null;
    }
    int i1 = com.tencent.luggage.wxa.g.b.a(g());
    try
    {
      if (this.i != null) {
        break label154;
      }
      if ((i1 != 0) && (i1 != 180)) {
        return new Point(((q)localObject).b(), ((q)localObject).a());
      }
      return new Point(((q)localObject).a(), ((q)localObject).b());
    }
    catch (Exception localException)
    {
      o.b("MicroMsg.LuggageRecordView", "getPictureSize: %s", new Object[] { localException.getMessage() });
      return null;
    }
    localObject = new Point(this.i.y, this.i.x);
    for (;;)
    {
      localObject = new Point(this.i.x, this.i.y);
      return localObject;
      label154:
      if (i1 != 0) {
        if (i1 != 180) {
          break;
        }
      }
    }
  }
  
  public Point o()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return null;
    }
    localObject = ((h)localObject).getPreviewSize();
    if (localObject == null) {
      return null;
    }
    int i1 = com.tencent.luggage.wxa.g.b.a(g());
    try
    {
      if (this.j != null) {
        break label154;
      }
      if ((i1 != 0) && (i1 != 180)) {
        return new Point(((q)localObject).b(), ((q)localObject).a());
      }
      return new Point(((q)localObject).a(), ((q)localObject).b());
    }
    catch (Exception localException)
    {
      o.b("MicroMsg.LuggageRecordView", "getPreviewSize: %s", new Object[] { localException.getMessage() });
      return null;
    }
    localObject = new Point(this.j.y, this.j.x);
    for (;;)
    {
      localObject = new Point(this.j.x, this.j.y);
      return localObject;
      label154:
      if (i1 != 0) {
        if (i1 != 180) {
          break;
        }
      }
    }
  }
  
  public boolean p()
  {
    return this.a.getFacing() == 1;
  }
  
  protected void q()
  {
    Object localObject = this.a.getPreviewSize();
    int i1 = com.tencent.luggage.wxa.g.b.a(g());
    Point localPoint = this.p;
    localPoint.y = this.g;
    localPoint.x = (((q)localObject).a() * this.g / ((q)localObject).b());
    if ((com.tencent.luggage.wxa.g.b.a(this.a.getCameraOrientation()) == 90) || (com.tencent.luggage.wxa.g.b.a(this.a.getCameraOrientation()) == 270))
    {
      int i2 = this.p.y;
      localObject = this.p;
      ((Point)localObject).y = ((Point)localObject).x;
      this.p.x = i2;
    }
    localObject = this.c;
    if (localObject != null) {
      ((i)localObject).a(i1, this.p.x, this.p.y);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.be.e
 * JD-Core Version:    0.7.0.1
 */