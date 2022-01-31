package com.tencent.mapsdk.rastercore;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.rastercore.b.d;
import com.tencent.mapsdk.rastercore.b.f;
import com.tencent.mapsdk.rastercore.c.e;
import com.tencent.mapsdk.rastercore.d.h;
import com.tencent.mapsdk.rastercore.tile.MapTile.MapSource;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Stack;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

public class c
{
  private String a;
  private b b;
  
  public c(Context paramContext, a parama)
  {
    String str = com.tencent.mapsdk.rastercore.f.b.a(paramContext);
    paramContext.getPackageName();
    paramContext = new StringBuilder(256);
    paramContext.append("https://confinfo.map.qq.com/confinfo?apikey=");
    paramContext.append(str);
    paramContext.append("&type=2");
    paramContext.append("&pf=Android_2D");
    paramContext.append("&uk=");
    paramContext.append(a.b());
    this.a = paramContext.toString();
    this.b = new b(parama);
  }
  
  public static double a(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    double d4 = paramLatLng1.getLongitude();
    double d3 = paramLatLng1.getLatitude();
    double d2 = paramLatLng2.getLongitude();
    double d1 = paramLatLng2.getLatitude();
    double d5 = d4 * 0.01745329251994329D;
    double d6 = d3 * 0.01745329251994329D;
    d3 = d2 * 0.01745329251994329D;
    d4 = d1 * 0.01745329251994329D;
    d1 = Math.sin(d5);
    d2 = Math.sin(d6);
    d5 = Math.cos(d5);
    d6 = Math.cos(d6);
    double d7 = Math.sin(d3);
    double d8 = Math.sin(d4);
    d3 = Math.cos(d3);
    d4 = Math.cos(d4);
    paramLatLng1 = new double[3];
    paramLatLng2 = new double[3];
    paramLatLng1[0] = (d5 * d6);
    paramLatLng1[1] = (d6 * d1);
    paramLatLng1[2] = d2;
    paramLatLng2[0] = (d4 * d3);
    paramLatLng2[1] = (d4 * d7);
    paramLatLng2[2] = d8;
    return Math.asin(Math.sqrt((paramLatLng1[0] - paramLatLng2[0]) * (paramLatLng1[0] - paramLatLng2[0]) + (paramLatLng1[1] - paramLatLng2[1]) * (paramLatLng1[1] - paramLatLng2[1]) + (paramLatLng1[2] - paramLatLng2[2]) * (paramLatLng1[2] - paramLatLng2[2])) / 2.0D) * 12742001.579854401D;
  }
  
  public static LatLng a(f paramf)
  {
    float f = (float)(paramf.b() * 180.0D / 20037508.34D);
    return new LatLng((float)(57.295779513082323D * (2.0D * Math.atan(Math.exp((float)(paramf.a() * 180.0D / 20037508.34D) * 3.141592653589793D / 180.0D)) - 1.570796326794897D)), f);
  }
  
  public static f a(PointF paramPointF1, f paramf, PointF paramPointF2, d paramd)
  {
    float f1 = paramPointF1.x;
    float f2 = paramPointF2.x;
    float f3 = paramPointF1.y;
    float f4 = paramPointF2.y;
    return new f(paramf.b() + (f1 - f2) * paramd.d(), paramf.a() - (f3 - f4) * paramd.d());
  }
  
  public static f a(LatLng paramLatLng)
  {
    if (paramLatLng == null) {
      return null;
    }
    double d = paramLatLng.getLatitude();
    return new f(paramLatLng.getLongitude() * 20037508.34D / 180.0D, Math.log(Math.tan((d + 90.0D) * 3.141592653589793D / 360.0D)) / 0.0174532925199433D * 20037508.34D / 180.0D);
  }
  
  public static com.tencent.mapsdk.rastercore.c.a a(float paramFloat, Point paramPoint)
  {
    e locale = new e();
    locale.a(paramFloat);
    locale.a(paramPoint);
    return locale;
  }
  
  public static com.tencent.mapsdk.rastercore.c.a a(CameraPosition paramCameraPosition)
  {
    com.tencent.mapsdk.rastercore.c.c localc = new com.tencent.mapsdk.rastercore.c.c();
    localc.a(paramCameraPosition);
    return localc;
  }
  
  public static com.tencent.mapsdk.rastercore.c.a a(LatLngBounds paramLatLngBounds, int paramInt1, int paramInt2, int paramInt3)
  {
    com.tencent.mapsdk.rastercore.c.b localb = new com.tencent.mapsdk.rastercore.c.b();
    localb.a(paramLatLngBounds);
    localb.c(paramInt3);
    localb.a(paramInt1);
    localb.b(paramInt2);
    return localb;
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Stack localStack = new Stack();
    localStack.push(paramString);
    while (!localStack.isEmpty())
    {
      File localFile = new File((String)localStack.peek());
      if (localFile.exists())
      {
        if (localFile.isDirectory())
        {
          paramString = localFile.listFiles();
          if ((paramString == null) || (paramString.length == 0))
          {
            localFile.delete();
            localStack.pop();
          }
          else
          {
            int j = paramString.length;
            int i = 0;
            label96:
            if (i < j)
            {
              localFile = paramString[i];
              if (!localFile.isDirectory()) {
                break label131;
              }
              localStack.push(localFile.getAbsolutePath());
            }
            for (;;)
            {
              i += 1;
              break label96;
              break;
              label131:
              localFile.delete();
            }
          }
        }
        else
        {
          localFile.delete();
          localStack.pop();
        }
      }
      else {
        localStack.pop();
      }
    }
    return true;
  }
  
  /* Error */
  public static byte[] a(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 237	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 238	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: astore_2
    //   10: sipush 4096
    //   13: newarray byte
    //   15: astore 4
    //   17: aload_3
    //   18: astore_2
    //   19: aload_0
    //   20: aload 4
    //   22: iconst_0
    //   23: aload 4
    //   25: arraylength
    //   26: invokevirtual 244	java/io/InputStream:read	([BII)I
    //   29: istore_1
    //   30: iload_1
    //   31: iconst_m1
    //   32: if_icmpeq +46 -> 78
    //   35: aload_3
    //   36: astore_2
    //   37: aload_3
    //   38: aload 4
    //   40: iconst_0
    //   41: iload_1
    //   42: invokevirtual 248	java/io/ByteArrayOutputStream:write	([BII)V
    //   45: goto -28 -> 17
    //   48: astore_2
    //   49: aload_3
    //   50: astore_0
    //   51: aload_2
    //   52: astore_3
    //   53: aload_0
    //   54: astore_2
    //   55: new 32	java/lang/StringBuilder
    //   58: dup
    //   59: ldc 250
    //   61: invokespecial 251	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   64: aload_3
    //   65: invokevirtual 252	java/io/IOException:toString	()Ljava/lang/String;
    //   68: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload_0
    //   73: invokestatic 254	com/tencent/mapsdk/rastercore/c:a	(Ljava/io/Closeable;)V
    //   76: aconst_null
    //   77: areturn
    //   78: aload_3
    //   79: astore_2
    //   80: aload_3
    //   81: invokevirtual 257	java/io/ByteArrayOutputStream:flush	()V
    //   84: aload_3
    //   85: astore_2
    //   86: aload_3
    //   87: invokevirtual 261	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   90: astore_0
    //   91: aload_3
    //   92: invokestatic 254	com/tencent/mapsdk/rastercore/c:a	(Ljava/io/Closeable;)V
    //   95: aload_0
    //   96: areturn
    //   97: astore_0
    //   98: aconst_null
    //   99: astore_2
    //   100: aload_2
    //   101: invokestatic 254	com/tencent/mapsdk/rastercore/c:a	(Ljava/io/Closeable;)V
    //   104: aload_0
    //   105: athrow
    //   106: astore_0
    //   107: goto -7 -> 100
    //   110: astore_3
    //   111: aconst_null
    //   112: astore_0
    //   113: goto -60 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	paramInputStream	java.io.InputStream
    //   29	13	1	i	int
    //   9	28	2	localObject1	Object
    //   48	4	2	localIOException1	IOException
    //   54	47	2	localObject2	Object
    //   7	85	3	localObject3	Object
    //   110	1	3	localIOException2	IOException
    //   15	24	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   10	17	48	java/io/IOException
    //   19	30	48	java/io/IOException
    //   37	45	48	java/io/IOException
    //   80	84	48	java/io/IOException
    //   86	91	48	java/io/IOException
    //   0	8	97	finally
    //   10	17	106	finally
    //   19	30	106	finally
    //   37	45	106	finally
    //   55	72	106	finally
    //   80	84	106	finally
    //   86	91	106	finally
    //   0	8	110	java/io/IOException
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      paramString = new File(paramString);
      if ((paramString.exists()) && (paramString.isDirectory())) {
        return true;
      }
      if ((paramString.exists()) && (paramString.isFile())) {
        paramString.delete();
      }
      boolean bool = paramString.mkdirs();
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public final void a()
  {
    this.b.execute(new String[] { this.a });
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean);
  }
  
  static final class b
    extends AsyncTask<String, Void, Boolean>
  {
    private c.a a;
    
    public b(c.a parama)
    {
      this.a = parama;
    }
    
    private Boolean a(String... paramVarArgs)
    {
      if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
      for (;;)
      {
        try
        {
          paramVarArgs = (HttpURLConnection)new URL(paramVarArgs[0]).openConnection();
          paramVarArgs.setRequestProperty("Accept-Encoding", "gzip");
          if (paramVarArgs.getResponseCode() == 200)
          {
            String str = paramVarArgs.getHeaderField("Content-Encoding");
            if ((str != null) && (str.length() > 0) && (str.toLowerCase().contains("gzip")))
            {
              i = 1;
              if (i != 0)
              {
                paramVarArgs = new GZIPInputStream(paramVarArgs.getInputStream());
                paramVarArgs = new String(c.a(paramVarArgs));
                new StringBuilder("TencentConfigChecker Response:").append(paramVarArgs);
                paramVarArgs = new JSONObject(paramVarArgs);
                if (paramVarArgs.optInt("error") != 0) {
                  return Boolean.valueOf(false);
                }
              }
              else
              {
                paramVarArgs = paramVarArgs.getInputStream();
                continue;
              }
              paramVarArgs = paramVarArgs.optJSONObject("info");
              if (paramVarArgs == null) {
                return Boolean.valueOf(false);
              }
              paramVarArgs = paramVarArgs.optJSONObject("raster");
              if (paramVarArgs == null) {
                return Boolean.valueOf(false);
              }
              int n = paramVarArgs.optInt("style", 1000);
              int i1 = paramVarArgs.optInt("version", b.a);
              int i2 = paramVarArgs.optInt("sat", b.c);
              int i3 = paramVarArgs.optInt("cur", b.b);
              paramVarArgs = com.tencent.mapsdk.rastercore.f.a.a();
              paramVarArgs.a("tencent_style", n);
              paramVarArgs.a("tencent_version", i1);
              paramVarArgs.a("sat_version", i2);
              paramVarArgs.a("tencent_clean_cache_version", i3);
              final boolean bool1;
              if (h.c() != i3)
              {
                bool1 = true;
                if (h.d() != i2)
                {
                  bool2 = true;
                  new Thread()
                  {
                    public final void run()
                    {
                      if (bool1) {
                        com.tencent.mapsdk.rastercore.tile.a.a.a().a(MapTile.MapSource.TENCENT);
                      }
                      if (bool2) {
                        com.tencent.mapsdk.rastercore.tile.a.a.a().a(MapTile.MapSource.SATELLITE);
                      }
                    }
                  }.start();
                  if (i1 == h.b()) {
                    continue;
                  }
                  i = 1;
                  if (n == h.a()) {
                    continue;
                  }
                  j = 1;
                  if (i3 == h.c()) {
                    continue;
                  }
                  k = 1;
                  if (i2 == h.d()) {
                    continue;
                  }
                  m = 1;
                  h.a(n, i1, i3, i2);
                  return Boolean.valueOf(m | i | j | k);
                }
              }
              else
              {
                bool1 = false;
                continue;
              }
              final boolean bool2 = false;
              continue;
              i = 0;
              continue;
              int j = 0;
              continue;
              int k = 0;
              continue;
              int m = 0;
              continue;
            }
          }
          else
          {
            return Boolean.valueOf(false);
          }
        }
        catch (Exception paramVarArgs)
        {
          new StringBuilder("check version got error:").append(paramVarArgs.getMessage());
        }
        int i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.c
 * JD-Core Version:    0.7.0.1
 */