package com.tencent.mapsdk.rastercore.f;

import android.content.Context;
import android.graphics.PointF;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.rastercore.b.c;
import com.tencent.mapsdk.rastercore.d.a;
import com.tencent.mapsdk.rastercore.tile.MapTile;
import com.tencent.mapsdk.rastercore.tile.MapTile.MapSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a
{
  private static int a = 0;
  private static double b = 20037508.34D;
  private static int c = 0;
  private static int d = 117;
  private static int e = 3;
  private static a h = new a();
  private com.tencent.mapsdk.rastercore.tile.a.a f = null;
  private ThreadPoolExecutor g = new ThreadPoolExecutor(4, 4, 20L, TimeUnit.SECONDS, new LinkedBlockingDeque());
  
  private static PointF a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, PointF paramPointF, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    PointF localPointF = new PointF();
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt1 >= Math.pow(2.0D, paramInt8)) || (paramInt2 >= Math.pow(2.0D, paramInt8))) {
      paramPointF = null;
    }
    do
    {
      return paramPointF;
      localPointF.x = ((paramInt1 - paramInt3) * paramInt7 + paramPointF.x);
      localPointF.y = ((paramInt2 - paramInt4) * paramInt7 + paramPointF.y);
      if ((localPointF.x + paramInt7 <= 0.0F) || (localPointF.x >= paramInt5) || (localPointF.y + paramInt7 <= 0.0F)) {
        break;
      }
      paramPointF = localPointF;
    } while (localPointF.y < paramInt6);
    return null;
  }
  
  public static a a(Context paramContext)
  {
    a locala = h;
    locala.f = com.tencent.mapsdk.rastercore.tile.a.a.a();
    locala.f.a(paramContext);
    return locala;
  }
  
  public final void a(LatLng paramLatLng, double paramDouble, int paramInt)
  {
    if (paramDouble <= 0.0D) {
      break label6;
    }
    for (;;)
    {
      label6:
      return;
      if ((paramInt >= com.tencent.mapsdk.rastercore.b.a.a) && (paramInt <= 18))
      {
        double d1 = paramDouble;
        if (paramDouble > 10000.0D) {
          d1 = 10000.0D;
        }
        Object localObject1 = d.a.a(paramLatLng);
        int i3;
        int i4;
        int n;
        label95:
        int i5;
        int i6;
        Object localObject2;
        ArrayList localArrayList;
        int i;
        int i1;
        if (paramInt < 7)
        {
          paramDouble = 1.0D;
          paramDouble = d1 / (paramDouble * (b / 128.0D / Math.pow(2.0D, paramInt)));
          i3 = (int)paramDouble;
          i4 = (int)paramDouble;
          if (paramInt > 15) {
            break label591;
          }
          n = 30;
          localObject1 = d.a.a(paramLatLng);
          paramDouble = com.tencent.mapsdk.rastercore.b.a.c(paramInt);
          paramLatLng = MapTile.MapSource.QQAR;
          i5 = (int)((((c)localObject1).b() + 20037508.34D) / (256.0D * paramDouble));
          d1 = i5 * 256;
          i6 = (int)((20037508.34D - ((c)localObject1).a()) / (256.0D * paramDouble));
          localObject1 = d.a.a(new c(-20037508.34D + d1 * paramDouble, 20037508.34D - i6 * 256 * paramDouble), (c)localObject1, new PointF(i3 / 2.0F, i4 / 2.0F), paramDouble);
          localObject2 = new MapTile(i5, i6, paramInt, 0, d, paramLatLng, null);
          ((MapTile)localObject2).a((PointF)localObject1);
          localArrayList = new ArrayList();
          localArrayList.add(localObject2);
          i = 0;
          i1 = 1;
        }
        for (;;)
        {
          int i2 = i5 - i1;
          int k = 0;
          int j = i;
          i = k;
          int i7;
          int m;
          MapTile localMapTile;
          for (;;)
          {
            if (i2 <= i5 + i1)
            {
              i7 = i6 + i1;
              localObject2 = a(i2, i7, i5, i6, (PointF)localObject1, i3, i4, 256, paramInt);
              if (localObject2 == null)
              {
                m = j;
                k = i;
                if (j >= n) {}
              }
              else
              {
                k = i;
                if (localObject2 != null)
                {
                  k = i;
                  if (i == 0) {
                    k = 1;
                  }
                }
                localMapTile = new MapTile(i2, i7, paramInt, 0, d, paramLatLng, null);
                localMapTile.a((PointF)localObject2);
                localArrayList.add(localMapTile);
                m = j + 1;
                new StringBuilder("tilesCount=").append(m);
              }
              i7 = i6 - i1;
              localObject2 = a(i2, i7, i5, i6, (PointF)localObject1, i3, i4, 256, paramInt);
              if (localObject2 == null)
              {
                j = m;
                i = k;
                if (m >= n) {}
              }
              else
              {
                i = k;
                if (localObject2 != null)
                {
                  i = k;
                  if (k == 0) {
                    i = 1;
                  }
                }
                localMapTile = new MapTile(i2, i7, paramInt, 0, d, paramLatLng, null);
                localMapTile.a((PointF)localObject2);
                localArrayList.add(localMapTile);
                j = m + 1;
                new StringBuilder("tilesCount=").append(j);
              }
              i2 += 1;
              continue;
              double d2 = 1.0D - Math.abs(((c)localObject1).a() / 20037508.34D);
              paramDouble = d2;
              if (d2 >= 0.1D) {
                break;
              }
              paramDouble = 0.1D;
              break;
              label591:
              n = 40;
              break label95;
            }
          }
          i2 = i6 + i1 - 1;
          k = i;
          i = j;
          for (j = k; i2 > i6 - i1; j = k)
          {
            i7 = i5 + i1;
            localObject2 = a(i7, i2, i5, i6, (PointF)localObject1, i3, i4, 256, paramInt);
            if (localObject2 == null)
            {
              m = j;
              k = i;
              if (i >= n) {}
            }
            else
            {
              m = j;
              if (localObject2 != null)
              {
                m = j;
                if (j == 0) {
                  m = 1;
                }
              }
              localMapTile = new MapTile(i7, i2, paramInt, 0, d, paramLatLng, null);
              localMapTile.a((PointF)localObject2);
              localArrayList.add(localMapTile);
              k = i + 1;
              new StringBuilder("tilesCount=").append(k);
            }
            i = m;
            m = k;
            i7 = i5 - i1;
            localObject2 = a(i7, i2, i5, i6, (PointF)localObject1, i3, i4, 256, paramInt);
            if (localObject2 == null)
            {
              j = m;
              k = i;
              if (m >= n) {}
            }
            else
            {
              k = i;
              if (localObject2 != null)
              {
                k = i;
                if (i == 0) {
                  k = 1;
                }
              }
              localArrayList.add(new MapTile(i7, i2, paramInt, 0, d, paramLatLng, null));
              j = m + 1;
              new StringBuilder("tilesCount=").append(j);
            }
            i2 -= 1;
            i = j;
          }
          if ((j == 0) && (i >= n)) {
            break label922;
          }
          i1 += 1;
        }
        label922:
        new StringBuilder("final tilesCount=").append(i);
        if (this.g.isShutdown()) {
          break;
        }
        paramLatLng = localArrayList.iterator();
        while (paramLatLng.hasNext())
        {
          localObject1 = (MapTile)paramLatLng.next();
          this.g.execute(new a((com.tencent.mapsdk.rastercore.tile.a)((MapTile)localObject1).b().get(0)));
        }
      }
    }
  }
  
  public final void a(LatLng paramLatLng, double paramDouble, int paramInt1, int paramInt2)
  {
    if (paramDouble <= 0.0D) {
      return;
    }
    if (paramInt1 < com.tencent.mapsdk.rastercore.b.a.a) {
      paramInt1 = com.tencent.mapsdk.rastercore.b.a.a;
    }
    for (;;)
    {
      int i = paramInt2;
      if (paramInt2 > 18) {
        i = 18;
      }
      while (paramInt1 <= i)
      {
        a(paramLatLng, paramDouble, paramInt1);
        paramInt1 += 1;
      }
      break;
    }
  }
  
  final class a
    implements Runnable
  {
    private com.tencent.mapsdk.rastercore.tile.a a;
    
    public a(com.tencent.mapsdk.rastercore.tile.a parama)
    {
      this.a = parama;
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 5
      //   3: aconst_null
      //   4: astore 6
      //   6: aconst_null
      //   7: astore_2
      //   8: aload_0
      //   9: getfield 21	com/tencent/mapsdk/rastercore/f/a$a:a	Lcom/tencent/mapsdk/rastercore/tile/a;
      //   12: ifnonnull +4 -> 16
      //   15: return
      //   16: aload 5
      //   18: astore_3
      //   19: aload 6
      //   21: astore 4
      //   23: aload_0
      //   24: getfield 16	com/tencent/mapsdk/rastercore/f/a$a:b	Lcom/tencent/mapsdk/rastercore/f/a;
      //   27: invokestatic 28	com/tencent/mapsdk/rastercore/f/a:a	(Lcom/tencent/mapsdk/rastercore/f/a;)Lcom/tencent/mapsdk/rastercore/tile/a/a;
      //   30: aload_0
      //   31: getfield 21	com/tencent/mapsdk/rastercore/f/a$a:a	Lcom/tencent/mapsdk/rastercore/tile/a;
      //   34: invokevirtual 33	com/tencent/mapsdk/rastercore/tile/a/a:a	(Lcom/tencent/mapsdk/rastercore/tile/a;)Landroid/graphics/Bitmap;
      //   37: astore 7
      //   39: aload 7
      //   41: ifnull +16 -> 57
      //   44: aload_0
      //   45: getfield 16	com/tencent/mapsdk/rastercore/f/a$a:b	Lcom/tencent/mapsdk/rastercore/f/a;
      //   48: aconst_null
      //   49: aload_0
      //   50: getfield 21	com/tencent/mapsdk/rastercore/f/a$a:a	Lcom/tencent/mapsdk/rastercore/tile/a;
      //   53: invokestatic 36	com/tencent/mapsdk/rastercore/f/a:a	(Lcom/tencent/mapsdk/rastercore/f/a;[BLcom/tencent/mapsdk/rastercore/tile/a;)V
      //   56: return
      //   57: aload 5
      //   59: astore_3
      //   60: aload 6
      //   62: astore 4
      //   64: aload_0
      //   65: getfield 21	com/tencent/mapsdk/rastercore/f/a$a:a	Lcom/tencent/mapsdk/rastercore/tile/a;
      //   68: invokevirtual 42	com/tencent/mapsdk/rastercore/tile/a:e	()Lcom/tencent/mapsdk/raster/model/TileProvider;
      //   71: astore 5
      //   73: iconst_0
      //   74: istore_1
      //   75: aload_2
      //   76: astore_3
      //   77: aload_2
      //   78: astore 4
      //   80: iload_1
      //   81: invokestatic 45	com/tencent/mapsdk/rastercore/f/a:a	()I
      //   84: if_icmpge +95 -> 179
      //   87: aload_2
      //   88: astore_3
      //   89: aload_2
      //   90: astore 4
      //   92: aload 5
      //   94: aload_0
      //   95: getfield 21	com/tencent/mapsdk/rastercore/f/a$a:a	Lcom/tencent/mapsdk/rastercore/tile/a;
      //   98: invokevirtual 47	com/tencent/mapsdk/rastercore/tile/a:b	()I
      //   101: aload_0
      //   102: getfield 21	com/tencent/mapsdk/rastercore/f/a$a:a	Lcom/tencent/mapsdk/rastercore/tile/a;
      //   105: invokevirtual 50	com/tencent/mapsdk/rastercore/tile/a:c	()I
      //   108: aload_0
      //   109: getfield 21	com/tencent/mapsdk/rastercore/f/a$a:a	Lcom/tencent/mapsdk/rastercore/tile/a;
      //   112: invokevirtual 53	com/tencent/mapsdk/rastercore/tile/a:d	()I
      //   115: getstatic 59	com/tencent/mapsdk/rastercore/tile/MapTile$MapSource:QQAR	Lcom/tencent/mapsdk/rastercore/tile/MapTile$MapSource;
      //   118: iconst_2
      //   119: anewarray 4	java/lang/Object
      //   122: dup
      //   123: iconst_0
      //   124: invokestatic 60	com/tencent/mapsdk/rastercore/f/a:b	()I
      //   127: invokestatic 66	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   130: aastore
      //   131: dup
      //   132: iconst_1
      //   133: invokestatic 67	com/tencent/mapsdk/rastercore/f/a:c	()I
      //   136: invokestatic 66	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   139: aastore
      //   140: invokeinterface 73 6 0
      //   145: invokevirtual 79	com/tencent/mapsdk/raster/model/Tile:getData	()[B
      //   148: astore_2
      //   149: aload_2
      //   150: iconst_0
      //   151: aload_2
      //   152: arraylength
      //   153: invokestatic 85	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
      //   156: ifnonnull +81 -> 237
      //   159: iload_1
      //   160: sipush 200
      //   163: imul
      //   164: sipush 300
      //   167: iadd
      //   168: i2l
      //   169: invokestatic 91	java/lang/Thread:sleep	(J)V
      //   172: iload_1
      //   173: iconst_1
      //   174: iadd
      //   175: istore_1
      //   176: goto -101 -> 75
      //   179: aload_0
      //   180: getfield 16	com/tencent/mapsdk/rastercore/f/a$a:b	Lcom/tencent/mapsdk/rastercore/f/a;
      //   183: aload_2
      //   184: aload_0
      //   185: getfield 21	com/tencent/mapsdk/rastercore/f/a$a:a	Lcom/tencent/mapsdk/rastercore/tile/a;
      //   188: invokestatic 36	com/tencent/mapsdk/rastercore/f/a:a	(Lcom/tencent/mapsdk/rastercore/f/a;[BLcom/tencent/mapsdk/rastercore/tile/a;)V
      //   191: return
      //   192: astore_2
      //   193: aload_0
      //   194: getfield 16	com/tencent/mapsdk/rastercore/f/a$a:b	Lcom/tencent/mapsdk/rastercore/f/a;
      //   197: aload_3
      //   198: aload_0
      //   199: getfield 21	com/tencent/mapsdk/rastercore/f/a$a:a	Lcom/tencent/mapsdk/rastercore/tile/a;
      //   202: invokestatic 36	com/tencent/mapsdk/rastercore/f/a:a	(Lcom/tencent/mapsdk/rastercore/f/a;[BLcom/tencent/mapsdk/rastercore/tile/a;)V
      //   205: return
      //   206: astore_2
      //   207: aload_0
      //   208: getfield 16	com/tencent/mapsdk/rastercore/f/a$a:b	Lcom/tencent/mapsdk/rastercore/f/a;
      //   211: aload 4
      //   213: aload_0
      //   214: getfield 21	com/tencent/mapsdk/rastercore/f/a$a:a	Lcom/tencent/mapsdk/rastercore/tile/a;
      //   217: invokestatic 36	com/tencent/mapsdk/rastercore/f/a:a	(Lcom/tencent/mapsdk/rastercore/f/a;[BLcom/tencent/mapsdk/rastercore/tile/a;)V
      //   220: aload_2
      //   221: athrow
      //   222: astore_3
      //   223: aload_2
      //   224: astore 4
      //   226: aload_3
      //   227: astore_2
      //   228: goto -21 -> 207
      //   231: astore_3
      //   232: aload_2
      //   233: astore_3
      //   234: goto -41 -> 193
      //   237: goto -58 -> 179
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	240	0	this	a
      //   74	102	1	i	int
      //   7	177	2	arrayOfByte	byte[]
      //   192	1	2	localThrowable1	java.lang.Throwable
      //   206	18	2	localObject1	Object
      //   227	6	2	localObject2	Object
      //   18	180	3	localObject3	Object
      //   222	5	3	localObject4	Object
      //   231	1	3	localThrowable2	java.lang.Throwable
      //   233	1	3	localObject5	Object
      //   21	204	4	localObject6	Object
      //   1	92	5	localTileProvider	com.tencent.mapsdk.raster.model.TileProvider
      //   4	57	6	localObject7	Object
      //   37	3	7	localBitmap	android.graphics.Bitmap
      // Exception table:
      //   from	to	target	type
      //   23	39	192	java/lang/Throwable
      //   64	73	192	java/lang/Throwable
      //   80	87	192	java/lang/Throwable
      //   92	149	192	java/lang/Throwable
      //   23	39	206	finally
      //   64	73	206	finally
      //   80	87	206	finally
      //   92	149	206	finally
      //   149	172	222	finally
      //   149	172	231	java/lang/Throwable
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.f.a
 * JD-Core Version:    0.7.0.1
 */