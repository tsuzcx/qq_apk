package com.tencent.mapsdk.rastercore.tile;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.mapsdk.rastercore.d.e;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnErrorListener;
import java.util.concurrent.Callable;

public final class d
  implements Callable<Bitmap>
{
  private a a;
  private Bitmap b = null;
  private a c;
  
  public d(a parama, a parama1)
  {
    this.a = parama;
    this.c = parama1;
  }
  
  private Bitmap d()
    throws Exception
  {
    if (this.a != null) {
      this.a.b(this);
    }
    try
    {
      this.b = f();
      Bitmap localBitmap = this.b;
      return localBitmap;
    }
    finally
    {
      e();
    }
  }
  
  private void e()
  {
    if (this.a != null) {
      this.a.a(this);
    }
    this.a = null;
    if ((this.b != null) && (!this.b.isRecycled())) {
      this.b.recycle();
    }
    this.b = null;
  }
  
  private Bitmap f()
  {
    int i = 0;
    StringBuilder localStringBuilder = null;
    label406:
    label409:
    for (;;)
    {
      if (i < 4)
      {
        Object localObject4 = localStringBuilder;
        Object localObject1;
        for (;;)
        {
          byte[] arrayOfByte;
          try
          {
            arrayOfByte = this.c.g();
            localObject1 = localStringBuilder;
            if (arrayOfByte == null) {}
          }
          catch (Exception localException1) {}
          try
          {
            localObject1 = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length);
            if (localObject1 == null) {}
          }
          catch (Exception localException5)
          {
            Exception localException2 = localException4;
            Object localObject3 = localException5;
            continue;
            continue;
            i += 1;
          }
          try
          {
            if (arrayOfByte.length < 2097152)
            {
              localStringBuilder = new StringBuilder();
              try
              {
                com.tencent.mapsdk.rastercore.tile.a.a.a().a(arrayOfByte, this.c);
                if (localObject1 == null) {
                  continue;
                }
                localObject4 = localObject1;
                ((Bitmap)localObject1).setDensity(e.B());
                return localObject1;
              }
              catch (Throwable localThrowable)
              {
                if (TencentMap.getErrorListener() == null) {
                  break label406;
                }
              }
              TencentMap.getErrorListener().collectErrorInfo("TileNetFetcher downLoad function occured exception when call CacheManager Put,the downloaded data length-" + arrayOfByte.length + ";tileInfo:x=" + this.c.b() + ",y=" + this.c.c() + "z=" + this.c.d() + ";CacheManager Put execute path:" + localStringBuilder.toString() + ";exceptionInfo:" + localThrowable.toString());
              break label406;
            }
            else
            {
              if (TencentMap.getErrorListener() == null) {
                continue;
              }
              TencentMap.getErrorListener().collectErrorInfo("TileNetFetcher downLoad function,the downloaded data length-" + arrayOfByte.length + ";tileInfo:x=" + this.c.b() + ",y=" + this.c.c() + "z=" + this.c.d());
              continue;
            }
            try
            {
              new StringBuilder("decoder bitmap error:").append(localException3.getMessage());
            }
            catch (Exception localException4)
            {
              for (;;)
              {
                Object localObject2;
                Object localObject5 = localException1;
                localException2 = localException4;
              }
            }
          }
          catch (Exception localException3) {}
        }
        if (i == 0)
        {
          localObject5 = localObject1;
          Thread.sleep(300L);
          localObject2 = localObject1;
        }
        else if (i == 1)
        {
          localObject5 = localObject1;
          Thread.sleep(500L);
          localObject2 = localObject1;
          break label409;
          new StringBuilder("Error occured:").append(localException1.getMessage());
          localObject2 = localObject5;
        }
        else
        {
          localObject2 = localException1;
          if (i == 2)
          {
            localObject5 = localException1;
            Thread.sleep(700L);
            localObject2 = localException1;
          }
        }
      }
      else
      {
        this.c.e();
        return localObject2;
      }
    }
  }
  
  public final Bitmap a()
  {
    return this.b;
  }
  
  public final String b()
  {
    if (this.c != null) {
      return this.c.toString();
    }
    return "";
  }
  
  public final void c()
  {
    if (this.b != null) {
      this.b.recycle();
    }
    this.b = null;
  }
  
  public static abstract interface a
  {
    public abstract void a(d paramd);
    
    public abstract void b(d paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.tile.d
 * JD-Core Version:    0.7.0.1
 */