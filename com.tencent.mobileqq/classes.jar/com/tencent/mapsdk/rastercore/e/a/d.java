package com.tencent.mapsdk.rastercore.e.a;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.BitmapDescriptorFactory;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.raster.model.LatLngBounds.Builder;
import com.tencent.mapsdk.raster.model.PolylineOptions;
import com.tencent.mapsdk.rastercore.d.a;
import com.tencent.mapsdk.rastercore.d.c;
import com.tencent.mapsdk.rastercore.d.e;
import com.tencent.mapsdk.rastercore.e.b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class d
  implements com.tencent.mapsdk.rastercore.e.d
{
  private float a = 90.0F;
  private List<LatLng> b = new ArrayList();
  private List<LatLng> c = new ArrayList();
  private e d;
  private a e;
  private boolean f = false;
  private LatLngBounds g = null;
  private boolean h = false;
  private boolean i = true;
  private int j = -16777216;
  private float k = 10.0F;
  private float l = 0.0F;
  private String m = "";
  private float n = 0.0F;
  private int o = -983041;
  private String p;
  
  public d(e parame, PolylineOptions paramPolylineOptions)
  {
    this.d = parame;
    this.e = parame.e();
    this.p = getId();
    this.j = paramPolylineOptions.getColor();
    this.f = paramPolylineOptions.isDottedLine();
    this.h = paramPolylineOptions.isGeodesic();
    if ((this.h) || (this.f)) {
      this.b = paramPolylineOptions.getPoints();
    }
    b(paramPolylineOptions.getPoints());
    this.i = paramPolylineOptions.isVisible();
    this.k = paramPolylineOptions.getWidth();
    this.l = paramPolylineOptions.getZIndex();
    this.m = paramPolylineOptions.getArrowTexture();
    this.n = paramPolylineOptions.getEdgeWidth();
    this.o = paramPolylineOptions.getEdgeColor();
    this.a = paramPolylineOptions.getArrowGap();
  }
  
  private static int a(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[(paramInt + 0)] & 0xFF | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24;
  }
  
  protected static Drawable a(Context paramContext, String paramString)
    throws Exception
  {
    Object localObject2 = paramContext.getAssets().open(paramString);
    paramString = BitmapFactory.decodeStream((InputStream)localObject2);
    int i2 = paramString.getWidth();
    int i8 = paramString.getHeight();
    Object localObject1 = new ByteArrayOutputStream();
    int i1 = 0;
    while (i1 < 32)
    {
      ((ByteArrayOutputStream)localObject1).write(0);
      i1 += 1;
    }
    Object localObject3 = new int[i2 - 2];
    paramString.getPixels((int[])localObject3, 0, i2, 1, 0, i2 - 2, 1);
    if (localObject3[0] == -16777216)
    {
      i3 = 1;
      if (localObject3[(localObject3.length - 1)] != -16777216) {
        break label177;
      }
    }
    int i9;
    int i6;
    int i7;
    label177:
    for (int i4 = 1;; i4 = 0)
    {
      i9 = localObject3.length;
      i2 = 0;
      i6 = 0;
      for (i1 = 0; i2 < i9; i1 = i5)
      {
        i7 = i6;
        i5 = i1;
        if (i6 != localObject3[i2])
        {
          i5 = i1 + 1;
          a((OutputStream)localObject1, i2);
          i7 = localObject3[i2];
        }
        i2 += 1;
        i6 = i7;
      }
      i3 = 0;
      break;
    }
    i2 = i1;
    if (i4 != 0)
    {
      i2 = i1 + 1;
      a((OutputStream)localObject1, localObject3.length);
    }
    int i5 = i2 + 1;
    i1 = i5;
    if (i3 != 0) {
      i1 = i5 - 1;
    }
    if (i4 != 0) {}
    for (int i3 = i1 - 1;; i3 = i1)
    {
      localObject3 = new int[i8 - 2];
      paramString.getPixels((int[])localObject3, 0, 1, 0, 1, 1, i8 - 2);
      if (localObject3[0] == -16777216)
      {
        i4 = 1;
        if (localObject3[(localObject3.length - 1)] != -16777216) {
          break label359;
        }
      }
      label359:
      for (i5 = 1;; i5 = 0)
      {
        int i10 = localObject3.length;
        i6 = 0;
        i8 = 0;
        for (i1 = 0; i6 < i10; i1 = i7)
        {
          i9 = i8;
          i7 = i1;
          if (i8 != localObject3[i6])
          {
            i7 = i1 + 1;
            a((OutputStream)localObject1, i6);
            i9 = localObject3[i6];
          }
          i6 += 1;
          i8 = i9;
        }
        i4 = 0;
        break;
      }
      i6 = i1;
      if (i5 != 0)
      {
        i6 = i1 + 1;
        a((OutputStream)localObject1, localObject3.length);
      }
      i7 = i6 + 1;
      i1 = i7;
      if (i4 != 0) {
        i1 = i7 - 1;
      }
      i4 = i1;
      if (i5 != 0) {
        i4 = i1 - 1;
      }
      i1 = 0;
      while (i1 < i3 * i4)
      {
        a((OutputStream)localObject1, 1);
        i1 += 1;
      }
      localObject3 = ((ByteArrayOutputStream)localObject1).toByteArray();
      localObject3[0] = 1;
      localObject3[1] = ((byte)i2);
      localObject3[2] = ((byte)i6);
      localObject3[3] = ((byte)(i4 * i3));
      a(paramString, (byte[])localObject3);
      if (NinePatch.isNinePatchChunk((byte[])localObject3))
      {
        localObject1 = Bitmap.createBitmap(paramString, 1, 1, paramString.getWidth() - 2, paramString.getHeight() - 2);
        paramString.recycle();
        paramString = localObject1.getClass().getDeclaredField("mNinePatchChunk");
        paramString.setAccessible(true);
        paramString.set(localObject1, localObject3);
        paramString = (String)localObject1;
      }
      for (;;)
      {
        ((InputStream)localObject2).close();
        if (paramString.getNinePatchChunk() != null) {
          break;
        }
        return new BitmapDrawable(paramString);
      }
      localObject1 = new Rect();
      localObject2 = paramString.getNinePatchChunk();
      ((Rect)localObject1).left = a((byte[])localObject2, 12);
      ((Rect)localObject1).right = a((byte[])localObject2, 16);
      ((Rect)localObject1).top = a((byte[])localObject2, 20);
      ((Rect)localObject1).bottom = a((byte[])localObject2, 24);
      return new NinePatchDrawable(paramContext.getResources(), paramString, paramString.getNinePatchChunk(), (Rect)localObject1, null);
    }
  }
  
  private static void a(Bitmap paramBitmap, byte[] paramArrayOfByte)
  {
    int i2 = 0;
    int[] arrayOfInt = new int[paramBitmap.getWidth() - 2];
    paramBitmap.getPixels(arrayOfInt, 0, arrayOfInt.length, 1, paramBitmap.getHeight() - 1, arrayOfInt.length, 1);
    int i1 = 0;
    if (i1 < arrayOfInt.length)
    {
      if (-16777216 == arrayOfInt[i1]) {
        a(paramArrayOfByte, 12, i1);
      }
    }
    else
    {
      i1 = arrayOfInt.length - 1;
      label64:
      if (i1 >= 0)
      {
        if (-16777216 != arrayOfInt[i1]) {
          break label184;
        }
        a(paramArrayOfByte, 16, arrayOfInt.length - i1 - 2);
      }
      arrayOfInt = new int[paramBitmap.getHeight() - 2];
      paramBitmap.getPixels(arrayOfInt, 0, 1, paramBitmap.getWidth() - 1, 0, 1, arrayOfInt.length);
      i1 = i2;
      label121:
      if (i1 < arrayOfInt.length)
      {
        if (-16777216 != arrayOfInt[i1]) {
          break label191;
        }
        a(paramArrayOfByte, 20, i1);
      }
      i1 = arrayOfInt.length - 1;
    }
    for (;;)
    {
      if (i1 >= 0)
      {
        if (-16777216 == arrayOfInt[i1]) {
          a(paramArrayOfByte, 24, arrayOfInt.length - i1 - 2);
        }
      }
      else
      {
        return;
        i1 += 1;
        break;
        label184:
        i1 -= 1;
        break label64;
        label191:
        i1 += 1;
        break label121;
      }
      i1 -= 1;
    }
  }
  
  private void a(Canvas paramCanvas, List<PointF> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    BitmapDescriptor localBitmapDescriptor;
    do
    {
      return;
      localBitmapDescriptor = BitmapDescriptorFactory.fromAsset(this.m);
    } while ((localBitmapDescriptor == null) || (localBitmapDescriptor.getBitmap() == null));
    int i2 = localBitmapDescriptor.getWidth();
    int i3 = localBitmapDescriptor.getHeight();
    double d7 = a() / i3;
    double d1 = 0.0D;
    int i1 = 0;
    label66:
    PointF localPointF1;
    PointF localPointF2;
    if (i1 < paramList.size() - 1)
    {
      localPointF1 = (PointF)paramList.get(i1);
      localPointF2 = (PointF)paramList.get(i1 + 1);
      if ((localPointF1 != null) && (localPointF2 != null)) {
        break label147;
      }
    }
    label147:
    for (double d2 = 0.0D;; d2 = Math.sqrt(Math.pow(localPointF1.x - localPointF2.x, 2.0D) + Math.pow(localPointF1.y - localPointF2.y, 2.0D)))
    {
      if (d2 + d1 >= this.a) {
        break label192;
      }
      d1 += d2;
      i1 += 1;
      break label66;
      break;
    }
    label192:
    double d8 = d2 / this.a;
    double d5 = (this.a - d1) / this.a;
    double d6 = Math.acos((localPointF2.x - localPointF1.x) / d2) * 180.0D / 3.141592653589793D;
    double d4;
    double d3;
    if ((localPointF2.x <= localPointF1.x) && (localPointF2.y >= localPointF1.y))
    {
      d2 = 180.0D - d6 + 180.0D;
      d4 = d5;
      d3 = d1;
    }
    for (;;)
    {
      d1 = d3;
      if (d4 > d8) {
        break;
      }
      paramCanvas.save();
      paramCanvas.translate((float)(localPointF1.x + (localPointF2.x - localPointF1.x) * d4 / d8), (float)(localPointF1.y + (localPointF2.y - localPointF1.y) * d4 / d8));
      paramCanvas.scale((float)d7, (float)d7);
      paramCanvas.rotate((float)-d2);
      paramCanvas.drawBitmap(localBitmapDescriptor.getBitmap(), -i2 / 2, -i3 / 2, null);
      paramCanvas.restore();
      if (1.0D + d4 > d8) {
        d3 = (d8 - d4) * this.a;
      }
      d4 += 1.0D;
      continue;
      d3 = d1;
      d2 = d6;
      d4 = d5;
      if (localPointF2.x >= localPointF1.x)
      {
        d3 = d1;
        d2 = d6;
        d4 = d5;
        if (localPointF2.y >= localPointF1.y)
        {
          d2 = 360.0D - d6;
          d3 = d1;
          d4 = d5;
        }
      }
    }
  }
  
  private static void a(OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    paramOutputStream.write(paramInt >> 0 & 0xFF);
    paramOutputStream.write(paramInt >> 8 & 0xFF);
    paramOutputStream.write(paramInt >> 16 & 0xFF);
    paramOutputStream.write(paramInt >> 24 & 0xFF);
  }
  
  private static void a(List<LatLng> paramList1, List<LatLng> paramList2, double paramDouble)
  {
    if (paramList1.size() != 3) {}
    for (;;)
    {
      return;
      for (int i1 = 0; i1 <= 10; i1 = (int)(i1 + 1.0F))
      {
        float f1 = i1 / 10.0F;
        double d1 = f1;
        double d2 = f1;
        double d3 = ((LatLng)paramList1.get(0)).getLongitude();
        double d4 = 2.0F * f1;
        double d5 = f1;
        double d6 = ((LatLng)paramList1.get(1)).getLongitude();
        double d7 = f1 * f1;
        double d8 = ((LatLng)paramList1.get(2)).getLongitude();
        double d9 = f1;
        double d10 = f1;
        double d11 = ((LatLng)paramList1.get(0)).getLatitude();
        double d12 = 2.0F * f1;
        double d13 = f1;
        double d14 = ((LatLng)paramList1.get(1)).getLatitude();
        double d15 = f1 * f1;
        double d16 = ((LatLng)paramList1.get(2)).getLatitude();
        double d17 = f1;
        double d18 = f1;
        double d19 = 2.0F * f1;
        double d20 = f1;
        double d21 = f1 * f1;
        double d22 = f1;
        double d23 = f1;
        double d24 = 2.0F * f1;
        double d25 = f1;
        paramList2.add(new LatLng(((1.0D - d9) * (1.0D - d10) * d11 + d12 * (1.0D - d13) * d14 * paramDouble + d15 * d16) / (f1 * f1 + ((1.0D - d22) * (1.0D - d23) + d24 * (1.0D - d25) * paramDouble)), ((1.0D - d1) * (1.0D - d2) * d3 + d4 * (1.0D - d5) * d6 * paramDouble + d7 * d8) / ((1.0D - d17) * (1.0D - d18) + d19 * (1.0D - d20) * paramDouble + d21)));
      }
    }
  }
  
  private static void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[(paramInt1 + 0)] = ((byte)(paramInt2 >> 0));
    paramArrayOfByte[(paramInt1 + 1)] = ((byte)(paramInt2 >> 8));
    paramArrayOfByte[(paramInt1 + 2)] = ((byte)(paramInt2 >> 16));
    paramArrayOfByte[(paramInt1 + 3)] = ((byte)(paramInt2 >> 24));
  }
  
  private void b(List<LatLng> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    LatLngBounds.Builder localBuilder = LatLngBounds.builder();
    this.c.clear();
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      paramList = null;
      while (localIterator.hasNext())
      {
        LatLng localLatLng1 = (LatLng)localIterator.next();
        if ((localLatLng1 != null) && (!localLatLng1.equals(paramList)))
        {
          if (!this.h)
          {
            this.c.add(localLatLng1);
            localBuilder.include(localLatLng1);
          }
          for (;;)
          {
            paramList = localLatLng1;
            break;
            if (paramList != null)
            {
              if (Math.abs(localLatLng1.getLongitude() - paramList.getLongitude()) >= 0.01D) {
                break label176;
              }
              this.c.add(paramList);
              localBuilder.include(paramList);
              this.c.add(localLatLng1);
              localBuilder.include(localLatLng1);
            }
          }
          label176:
          List localList = this.c;
          double d3 = Math.abs(paramList.getLongitude() - localLatLng1.getLongitude()) * 3.141592653589793D / 180.0D;
          LatLng localLatLng2 = new LatLng((localLatLng1.getLatitude() + paramList.getLatitude()) / 2.0D, (localLatLng1.getLongitude() + paramList.getLongitude()) / 2.0D);
          localBuilder.include(paramList).include(localLatLng2).include(localLatLng1);
          if (localLatLng2.getLatitude() > 0.0D) {}
          for (int i1 = 1;; i1 = -1)
          {
            double d1 = Math.cos(0.5D * d3);
            double d2 = Math.hypot(paramList.getLongitude() - localLatLng1.getLongitude(), paramList.getLatitude() - localLatLng1.getLatitude());
            double d5 = Math.tan(d3 * 0.5D);
            d3 = localLatLng1.getLongitude() - paramList.getLongitude();
            double d4 = localLatLng1.getLatitude() - paramList.getLatitude();
            double d6 = d4 * d4 / (d3 * d3);
            d2 = (int)(d5 * (d2 * 0.5D) * i1 / Math.sqrt(d6 + 1.0D) + localLatLng2.getLatitude());
            d3 = d4 * (localLatLng2.getLatitude() - d2) / d3;
            localLatLng2 = new LatLng(d2, (int)(localLatLng2.getLongitude() + d3));
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(paramList);
            localArrayList.add(localLatLng2);
            localArrayList.add(localLatLng1);
            a(localArrayList, localList, d1);
            break;
          }
        }
      }
    }
    this.g = localBuilder.build();
  }
  
  public float a()
  {
    return this.k;
  }
  
  public void a(float paramFloat)
  {
    this.k = paramFloat;
    this.d.a(false, false);
  }
  
  public void a(int paramInt)
  {
    this.j = paramInt;
    this.d.a(false, false);
  }
  
  public void a(List<LatLng> paramList)
  {
    if ((this.h) || (this.f)) {
      this.b = paramList;
    }
    b(paramList);
    this.d.a(false, false);
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    this.d.a(false, false);
  }
  
  public int b()
  {
    return this.j;
  }
  
  public void b(boolean paramBoolean)
  {
    this.h = paramBoolean;
    this.d.a(false, false);
  }
  
  public List<LatLng> c()
  {
    if ((this.h) || (this.f)) {
      return this.b;
    }
    return this.c;
  }
  
  public boolean checkInBounds()
  {
    if (this.g == null) {}
    LatLngBounds localLatLngBounds;
    do
    {
      return false;
      localLatLngBounds = this.d.b().c();
      if (localLatLngBounds == null) {
        return true;
      }
    } while ((!localLatLngBounds.contains(this.g)) && (!this.g.intersects(localLatLngBounds)));
    return true;
  }
  
  public boolean d()
  {
    return this.f;
  }
  
  public void destroy() {}
  
  public void draw(Canvas paramCanvas)
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.c == null) || (this.c.size() == 0) || (this.k <= 0.0F)) {
      return;
    }
    Path localPath = new Path();
    Object localObject = (LatLng)this.c.get(0);
    localObject = this.d.b().a((LatLng)localObject);
    localArrayList.add(localObject);
    localPath.moveTo(((PointF)localObject).x, ((PointF)localObject).y);
    int i1 = 1;
    while (i1 < this.c.size())
    {
      localObject = (LatLng)this.c.get(i1);
      localObject = this.d.b().a((LatLng)localObject);
      localArrayList.add(localObject);
      localPath.lineTo(((PointF)localObject).x, ((PointF)localObject).y);
      i1 += 1;
    }
    localObject = new Paint();
    ((Paint)localObject).setStyle(Paint.Style.STROKE);
    if (this.f)
    {
      i1 = (int)a();
      ((Paint)localObject).setPathEffect(new DashPathEffect(new float[] { i1 * 3, i1, i1 * 3, i1 }, 1.0F));
    }
    for (;;)
    {
      ((Paint)localObject).setAntiAlias(true);
      if (this.n > 0.0F)
      {
        ((Paint)localObject).setColor(this.o);
        ((Paint)localObject).setStrokeWidth(a() + 2.0F * this.n);
        paramCanvas.drawPath(localPath, (Paint)localObject);
      }
      ((Paint)localObject).setColor(b());
      ((Paint)localObject).setStrokeWidth(a());
      paramCanvas.drawPath(localPath, (Paint)localObject);
      if ((this.m != null) && (this.m.length() > 0)) {
        a(paramCanvas, localArrayList);
      }
      localArrayList.clear();
      return;
      ((Paint)localObject).setPathEffect(new CornerPathEffect(a()));
    }
  }
  
  public boolean e()
  {
    return this.h;
  }
  
  public boolean equalsRemote(b paramb)
  {
    return (equals(paramb)) || (paramb.getId().equals(getId()));
  }
  
  public String getId()
  {
    if (this.p == null) {
      this.p = a.a("Polyline");
    }
    return this.p;
  }
  
  public float getZIndex()
  {
    return this.l;
  }
  
  public int hashCodeRemote()
  {
    return super.hashCode();
  }
  
  public boolean isVisible()
  {
    return this.i;
  }
  
  public void remove()
  {
    this.e.b(getId());
  }
  
  public void setVisible(boolean paramBoolean)
  {
    this.i = paramBoolean;
    this.e.c();
    this.d.a(false, false);
  }
  
  public void setZIndex(float paramFloat)
  {
    this.l = paramFloat;
    this.e.c();
    this.d.a(false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.e.a.d
 * JD-Core Version:    0.7.0.1
 */