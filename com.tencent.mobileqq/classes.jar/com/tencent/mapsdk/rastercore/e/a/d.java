package com.tencent.mapsdk.rastercore.e.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.raster.model.LatLngBounds.Builder;
import com.tencent.mapsdk.raster.model.PolylineOptions;
import com.tencent.mapsdk.rastercore.d.a;
import com.tencent.mapsdk.rastercore.d.f;
import com.tencent.mapsdk.rastercore.e.e;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class d
  implements e
{
  private float a = 90.0F;
  private List<LatLng> b = new ArrayList();
  private List<LatLng> c = new ArrayList();
  private f d;
  private a e;
  private boolean f = false;
  private LatLngBounds g = null;
  private boolean h = false;
  private boolean i = true;
  private int j = -16777216;
  private float k = 10.0F;
  private float l = 0.0F;
  private BitmapDescriptor m;
  private float n = 0.0F;
  private int o = -983041;
  private String p;
  
  public d(f paramf, PolylineOptions paramPolylineOptions)
  {
    this.d = paramf;
    this.e = paramf.e();
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
    paramString = b(paramContext, paramString);
    if (paramString == null) {
      return null;
    }
    if (paramString.getNinePatchChunk() == null) {
      return new BitmapDrawable(paramString);
    }
    Rect localRect = new Rect();
    byte[] arrayOfByte = paramString.getNinePatchChunk();
    localRect.left = a(arrayOfByte, 12);
    localRect.right = a(arrayOfByte, 16);
    localRect.top = a(arrayOfByte, 20);
    localRect.bottom = a(arrayOfByte, 24);
    return new NinePatchDrawable(paramContext.getResources(), paramString, paramString.getNinePatchChunk(), localRect, null);
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
    if ((paramList == null) || (paramList.size() == 0)) {
      break label13;
    }
    label13:
    while ((this.m == null) || (this.m.getBitmap() == null)) {
      return;
    }
    int i2 = this.m.getWidth();
    int i3 = this.m.getHeight();
    double d7 = a() / i3;
    double d8 = i2 * this.k / (i3 * this.a);
    double d1 = -(i2 * d7 / 2.0D);
    int i1 = 0;
    label95:
    PointF localPointF1;
    PointF localPointF2;
    if (i1 < paramList.size() - 1)
    {
      localPointF1 = (PointF)paramList.get(i1);
      localPointF2 = (PointF)paramList.get(i1 + 1);
      if ((localPointF1 != null) && (localPointF2 != null)) {
        break label176;
      }
    }
    label167:
    label176:
    for (double d2 = 0.0D;; d2 = Math.sqrt(Math.pow(localPointF1.x - localPointF2.x, 2.0D) + Math.pow(localPointF1.y - localPointF2.y, 2.0D)))
    {
      if (d2 + d1 >= this.a) {
        break label221;
      }
      d1 += d2;
      i1 += 1;
      break label95;
      break;
    }
    label221:
    double d9 = d2 / this.a;
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
      if (d4 > d9) {
        break label167;
      }
      if ((i1 == paramList.size() - 2) && (d4 + d8 > d9)) {
        break;
      }
      paramCanvas.save();
      paramCanvas.translate((float)(localPointF1.x + (localPointF2.x - localPointF1.x) * d4 / d9), (float)(localPointF1.y + (localPointF2.y - localPointF1.y) * d4 / d9));
      paramCanvas.scale((float)d7, (float)d7);
      paramCanvas.rotate((float)-d2);
      paramCanvas.drawBitmap(this.m.getBitmap(), -i2 / 2, -i3 / 2, null);
      paramCanvas.restore();
      if (1.0D + d4 > d9) {
        d3 = (d9 - d4) * this.a;
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
  
  /* Error */
  private static Bitmap b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: aload_0
    //   4: invokevirtual 294	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   7: aload_1
    //   8: invokevirtual 300	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   11: astore_0
    //   12: aload_0
    //   13: invokestatic 306	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   16: astore 12
    //   18: aload 12
    //   20: invokevirtual 179	android/graphics/Bitmap:getWidth	()I
    //   23: istore_3
    //   24: aload 12
    //   26: invokevirtual 182	android/graphics/Bitmap:getHeight	()I
    //   29: istore 9
    //   31: new 308	java/io/ByteArrayOutputStream
    //   34: dup
    //   35: invokespecial 309	java/io/ByteArrayOutputStream:<init>	()V
    //   38: astore_1
    //   39: iconst_0
    //   40: istore_2
    //   41: iload_2
    //   42: bipush 32
    //   44: if_icmpge +15 -> 59
    //   47: aload_1
    //   48: iconst_0
    //   49: invokevirtual 310	java/io/ByteArrayOutputStream:write	(I)V
    //   52: iload_2
    //   53: iconst_1
    //   54: iadd
    //   55: istore_2
    //   56: goto -15 -> 41
    //   59: iload_3
    //   60: iconst_2
    //   61: isub
    //   62: newarray int
    //   64: astore 13
    //   66: aload 12
    //   68: aload 13
    //   70: iconst_0
    //   71: iload_3
    //   72: iconst_1
    //   73: iconst_0
    //   74: iload_3
    //   75: iconst_2
    //   76: isub
    //   77: iconst_1
    //   78: invokevirtual 186	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   81: aload 13
    //   83: iconst_0
    //   84: iaload
    //   85: ldc 56
    //   87: if_icmpne +415 -> 502
    //   90: iconst_1
    //   91: istore 4
    //   93: aload 13
    //   95: aload 13
    //   97: arraylength
    //   98: iconst_1
    //   99: isub
    //   100: iaload
    //   101: ldc 56
    //   103: if_icmpne +405 -> 508
    //   106: iconst_1
    //   107: istore 5
    //   109: aload 13
    //   111: arraylength
    //   112: istore 10
    //   114: iconst_0
    //   115: istore_3
    //   116: iconst_0
    //   117: istore 7
    //   119: iconst_0
    //   120: istore_2
    //   121: iload_3
    //   122: iload 10
    //   124: if_icmpge +38 -> 162
    //   127: iload 7
    //   129: istore 6
    //   131: iload_2
    //   132: istore 8
    //   134: iload 7
    //   136: aload 13
    //   138: iload_3
    //   139: iaload
    //   140: if_icmpeq +348 -> 488
    //   143: iload_2
    //   144: iconst_1
    //   145: iadd
    //   146: istore 8
    //   148: aload_1
    //   149: iload_3
    //   150: invokestatic 312	com/tencent/mapsdk/rastercore/e/a/d:a	(Ljava/io/OutputStream;I)V
    //   153: aload 13
    //   155: iload_3
    //   156: iaload
    //   157: istore 6
    //   159: goto +329 -> 488
    //   162: iload_2
    //   163: istore_3
    //   164: iload 5
    //   166: ifeq +348 -> 514
    //   169: iload_2
    //   170: iconst_1
    //   171: iadd
    //   172: istore_3
    //   173: aload_1
    //   174: aload 13
    //   176: arraylength
    //   177: invokestatic 312	com/tencent/mapsdk/rastercore/e/a/d:a	(Ljava/io/OutputStream;I)V
    //   180: goto +334 -> 514
    //   183: iload 9
    //   185: iconst_2
    //   186: isub
    //   187: newarray int
    //   189: astore 13
    //   191: aload 12
    //   193: aload 13
    //   195: iconst_0
    //   196: iconst_1
    //   197: iconst_0
    //   198: iconst_1
    //   199: iconst_1
    //   200: iload 9
    //   202: iconst_2
    //   203: isub
    //   204: invokevirtual 186	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   207: aload 13
    //   209: iconst_0
    //   210: iaload
    //   211: ldc 56
    //   213: if_icmpne +348 -> 561
    //   216: iconst_1
    //   217: istore 5
    //   219: aload 13
    //   221: aload 13
    //   223: arraylength
    //   224: iconst_1
    //   225: isub
    //   226: iaload
    //   227: ldc 56
    //   229: if_icmpne +338 -> 567
    //   232: iconst_1
    //   233: istore 6
    //   235: aload 13
    //   237: arraylength
    //   238: istore 11
    //   240: iconst_0
    //   241: istore 7
    //   243: iconst_0
    //   244: istore 9
    //   246: iconst_0
    //   247: istore_2
    //   248: iload 7
    //   250: iload 11
    //   252: if_icmpge +41 -> 293
    //   255: iload 9
    //   257: istore 8
    //   259: iload_2
    //   260: istore 10
    //   262: iload 9
    //   264: aload 13
    //   266: iload 7
    //   268: iaload
    //   269: if_icmpeq +276 -> 545
    //   272: iload_2
    //   273: iconst_1
    //   274: iadd
    //   275: istore 10
    //   277: aload_1
    //   278: iload 7
    //   280: invokestatic 312	com/tencent/mapsdk/rastercore/e/a/d:a	(Ljava/io/OutputStream;I)V
    //   283: aload 13
    //   285: iload 7
    //   287: iaload
    //   288: istore 8
    //   290: goto +255 -> 545
    //   293: iload_2
    //   294: istore 7
    //   296: iload 6
    //   298: ifeq +275 -> 573
    //   301: iload_2
    //   302: iconst_1
    //   303: iadd
    //   304: istore 7
    //   306: aload_1
    //   307: aload 13
    //   309: arraylength
    //   310: invokestatic 312	com/tencent/mapsdk/rastercore/e/a/d:a	(Ljava/io/OutputStream;I)V
    //   313: goto +260 -> 573
    //   316: iload_2
    //   317: iload 4
    //   319: iload 5
    //   321: imul
    //   322: if_icmpge +15 -> 337
    //   325: aload_1
    //   326: iconst_1
    //   327: invokestatic 312	com/tencent/mapsdk/rastercore/e/a/d:a	(Ljava/io/OutputStream;I)V
    //   330: iload_2
    //   331: iconst_1
    //   332: iadd
    //   333: istore_2
    //   334: goto -18 -> 316
    //   337: aload_1
    //   338: invokevirtual 315	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   341: astore 13
    //   343: aload 13
    //   345: iconst_0
    //   346: iconst_1
    //   347: bastore
    //   348: aload 13
    //   350: iconst_1
    //   351: iload_3
    //   352: i2b
    //   353: bastore
    //   354: aload 13
    //   356: iconst_2
    //   357: iload 7
    //   359: i2b
    //   360: bastore
    //   361: aload 13
    //   363: iconst_3
    //   364: iload 5
    //   366: iload 4
    //   368: imul
    //   369: i2b
    //   370: bastore
    //   371: aload 12
    //   373: aload 13
    //   375: invokestatic 317	com/tencent/mapsdk/rastercore/e/a/d:a	(Landroid/graphics/Bitmap;[B)V
    //   378: aload 12
    //   380: astore_1
    //   381: aload 13
    //   383: invokestatic 323	android/graphics/NinePatch:isNinePatchChunk	([B)Z
    //   386: ifeq +56 -> 442
    //   389: aload 12
    //   391: iconst_1
    //   392: iconst_1
    //   393: aload 12
    //   395: invokevirtual 179	android/graphics/Bitmap:getWidth	()I
    //   398: iconst_2
    //   399: isub
    //   400: aload 12
    //   402: invokevirtual 182	android/graphics/Bitmap:getHeight	()I
    //   405: iconst_2
    //   406: isub
    //   407: invokestatic 327	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   410: astore_1
    //   411: aload 12
    //   413: invokevirtual 330	android/graphics/Bitmap:recycle	()V
    //   416: aload_1
    //   417: invokevirtual 334	java/lang/Object:getClass	()Ljava/lang/Class;
    //   420: ldc_w 336
    //   423: invokevirtual 342	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   426: astore 12
    //   428: aload 12
    //   430: iconst_1
    //   431: invokevirtual 348	java/lang/reflect/Field:setAccessible	(Z)V
    //   434: aload 12
    //   436: aload_1
    //   437: aload 13
    //   439: invokevirtual 352	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   442: aload_0
    //   443: invokestatic 357	com/tencent/mapsdk/rastercore/c:a	(Ljava/io/Closeable;)V
    //   446: aload_1
    //   447: areturn
    //   448: astore_0
    //   449: aload 12
    //   451: astore_0
    //   452: aload_0
    //   453: invokestatic 357	com/tencent/mapsdk/rastercore/c:a	(Ljava/io/Closeable;)V
    //   456: aconst_null
    //   457: areturn
    //   458: astore_0
    //   459: aconst_null
    //   460: astore 12
    //   462: aload_0
    //   463: astore_1
    //   464: aload 12
    //   466: invokestatic 357	com/tencent/mapsdk/rastercore/c:a	(Ljava/io/Closeable;)V
    //   469: aload_1
    //   470: athrow
    //   471: astore_1
    //   472: aload_0
    //   473: astore 12
    //   475: goto -11 -> 464
    //   478: astore_1
    //   479: goto -27 -> 452
    //   482: iload_2
    //   483: istore 4
    //   485: goto -302 -> 183
    //   488: iload_3
    //   489: iconst_1
    //   490: iadd
    //   491: istore_3
    //   492: iload 6
    //   494: istore 7
    //   496: iload 8
    //   498: istore_2
    //   499: goto -378 -> 121
    //   502: iconst_0
    //   503: istore 4
    //   505: goto -412 -> 93
    //   508: iconst_0
    //   509: istore 5
    //   511: goto -402 -> 109
    //   514: iload_3
    //   515: iconst_1
    //   516: iadd
    //   517: istore 6
    //   519: iload 6
    //   521: istore_2
    //   522: iload 4
    //   524: ifeq +8 -> 532
    //   527: iload 6
    //   529: iconst_1
    //   530: isub
    //   531: istore_2
    //   532: iload 5
    //   534: ifeq -52 -> 482
    //   537: iload_2
    //   538: iconst_1
    //   539: isub
    //   540: istore 4
    //   542: goto -359 -> 183
    //   545: iload 7
    //   547: iconst_1
    //   548: iadd
    //   549: istore 7
    //   551: iload 8
    //   553: istore 9
    //   555: iload 10
    //   557: istore_2
    //   558: goto -310 -> 248
    //   561: iconst_0
    //   562: istore 5
    //   564: goto -345 -> 219
    //   567: iconst_0
    //   568: istore 6
    //   570: goto -335 -> 235
    //   573: iload 7
    //   575: iconst_1
    //   576: iadd
    //   577: istore 8
    //   579: iload 8
    //   581: istore_2
    //   582: iload 5
    //   584: ifeq +8 -> 592
    //   587: iload 8
    //   589: iconst_1
    //   590: isub
    //   591: istore_2
    //   592: iload_2
    //   593: istore 5
    //   595: iload 6
    //   597: ifeq +8 -> 605
    //   600: iload_2
    //   601: iconst_1
    //   602: isub
    //   603: istore 5
    //   605: iconst_0
    //   606: istore_2
    //   607: goto -291 -> 316
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	610	0	paramContext	Context
    //   0	610	1	paramString	String
    //   40	567	2	i1	int
    //   23	494	3	i2	int
    //   91	450	4	i3	int
    //   107	497	5	i4	int
    //   129	467	6	i5	int
    //   117	460	7	i6	int
    //   132	459	8	i7	int
    //   29	525	9	i8	int
    //   112	444	10	i9	int
    //   238	15	11	i10	int
    //   1	473	12	localObject1	Object
    //   64	374	13	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	12	448	java/lang/Exception
    //   3	12	458	finally
    //   12	39	471	finally
    //   47	52	471	finally
    //   59	81	471	finally
    //   93	106	471	finally
    //   109	114	471	finally
    //   148	153	471	finally
    //   173	180	471	finally
    //   183	207	471	finally
    //   219	232	471	finally
    //   235	240	471	finally
    //   277	283	471	finally
    //   306	313	471	finally
    //   325	330	471	finally
    //   337	343	471	finally
    //   371	378	471	finally
    //   381	442	471	finally
    //   12	39	478	java/lang/Exception
    //   47	52	478	java/lang/Exception
    //   59	81	478	java/lang/Exception
    //   93	106	478	java/lang/Exception
    //   109	114	478	java/lang/Exception
    //   148	153	478	java/lang/Exception
    //   173	180	478	java/lang/Exception
    //   183	207	478	java/lang/Exception
    //   219	232	478	java/lang/Exception
    //   235	240	478	java/lang/Exception
    //   277	283	478	java/lang/Exception
    //   306	313	478	java/lang/Exception
    //   325	330	478	java/lang/Exception
    //   337	343	478	java/lang/Exception
    //   371	378	478	java/lang/Exception
    //   381	442	478	java/lang/Exception
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
      if (this.m != null) {
        a(paramCanvas, localArrayList);
      }
      localArrayList.clear();
      return;
      ((Paint)localObject).setStrokeJoin(Paint.Join.ROUND);
      ((Paint)localObject).setStrokeCap(Paint.Cap.ROUND);
    }
  }
  
  public boolean e()
  {
    return this.h;
  }
  
  public boolean equalsRemote(com.tencent.mapsdk.rastercore.e.c paramc)
  {
    return (equals(paramc)) || (paramc.getId().equals(getId()));
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