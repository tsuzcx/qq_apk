package com.tencent.mapsdk.rastercore;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.rastercore.tile.MapTile.MapSource;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  private String a;
  private c b;
  private String c;
  
  public d(Context paramContext, b paramb, int paramInt1, int paramInt2)
  {
    String str = com.tencent.mapsdk.rastercore.f.b.a(paramContext);
    this.c = paramContext.getPackageName();
    paramContext = new StringBuilder(256);
    paramContext.append("https://confinfo.map.qq.com/confinfo?apikey=");
    paramContext.append(str);
    paramContext.append("&scene=in:");
    paramContext.append(paramInt1);
    paramContext.append(",out:");
    paramContext.append(paramInt2);
    paramContext.append("&type=2");
    this.a = paramContext.toString();
    this.b = new c(paramb, paramInt1);
  }
  
  public static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  private static String[] c(String paramString)
  {
    String[] arrayOfString = new String[2];
    try
    {
      paramString = new JSONObject(paramString);
      arrayOfString[0] = paramString.optString("version");
      arrayOfString[1] = paramString.optString("data");
      return arrayOfString;
    }
    catch (JSONException paramString) {}
    return arrayOfString;
  }
  
  public final void a()
  {
    long l1 = System.currentTimeMillis();
    a locala = d.a.a.a;
    long l2 = a.d();
    if ((l2 == -9223372036854775808L) || (l1 - l2 >= 14400000L)) {
      this.b.execute(new String[] { this.a, this.c });
    }
  }
  
  public class a
  {
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
    
    /* Error */
    public static int a(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: aconst_null
      //   3: astore 5
      //   5: invokestatic 53	com/tencent/mapsdk/rastercore/tile/a/a:a	()Lcom/tencent/mapsdk/rastercore/tile/a/a;
      //   8: invokevirtual 57	com/tencent/mapsdk/rastercore/tile/a/a:c	()Ljava/lang/String;
      //   11: astore 6
      //   13: aload 6
      //   15: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   18: ifeq +7 -> 25
      //   21: getstatic 68	com/tencent/mapsdk/rastercore/b:a	I
      //   24: ireturn
      //   25: new 70	java/lang/StringBuilder
      //   28: dup
      //   29: invokespecial 71	java/lang/StringBuilder:<init>	()V
      //   32: aload 6
      //   34: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   37: getstatic 81	java/io/File:separator	Ljava/lang/String;
      //   40: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   43: ldc 83
      //   45: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   48: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   51: astore 7
      //   53: aload_3
      //   54: astore 4
      //   56: new 77	java/io/File
      //   59: dup
      //   60: aload 7
      //   62: invokespecial 89	java/io/File:<init>	(Ljava/lang/String;)V
      //   65: astore 7
      //   67: aload_3
      //   68: astore 4
      //   70: aload 7
      //   72: invokevirtual 93	java/io/File:exists	()Z
      //   75: ifeq +146 -> 221
      //   78: aload_3
      //   79: astore 4
      //   81: aload 7
      //   83: invokevirtual 96	java/io/File:isFile	()Z
      //   86: ifeq +135 -> 221
      //   89: aload_3
      //   90: astore 4
      //   92: new 98	java/io/FileInputStream
      //   95: dup
      //   96: aload 7
      //   98: invokespecial 101	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   101: astore_3
      //   102: new 103	java/util/Properties
      //   105: dup
      //   106: invokespecial 104	java/util/Properties:<init>	()V
      //   109: astore 5
      //   111: aload 5
      //   113: aload_3
      //   114: invokevirtual 108	java/util/Properties:load	(Ljava/io/InputStream;)V
      //   117: new 70	java/lang/StringBuilder
      //   120: dup
      //   121: ldc 110
      //   123: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   126: iload_0
      //   127: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   130: ldc 116
      //   132: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   135: iload_1
      //   136: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   139: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   142: astore 4
      //   144: iload_2
      //   145: ifeq +169 -> 314
      //   148: new 70	java/lang/StringBuilder
      //   151: dup
      //   152: invokespecial 71	java/lang/StringBuilder:<init>	()V
      //   155: aload 4
      //   157: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   160: ldc 118
      //   162: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   165: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   168: astore 4
      //   170: iload_2
      //   171: ifeq +43 -> 214
      //   174: getstatic 121	com/tencent/mapsdk/rastercore/b:b	I
      //   177: istore_0
      //   178: aload 5
      //   180: aload 4
      //   182: iload_0
      //   183: invokestatic 127	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   186: invokevirtual 131	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   189: astore 5
      //   191: aload_3
      //   192: astore 4
      //   194: aload 5
      //   196: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   199: ifne +25 -> 224
      //   202: aload 5
      //   204: invokestatic 137	java/lang/Integer:parseInt	(Ljava/lang/String;)I
      //   207: istore_0
      //   208: aload_3
      //   209: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   212: iload_0
      //   213: ireturn
      //   214: getstatic 68	com/tencent/mapsdk/rastercore/b:a	I
      //   217: istore_0
      //   218: goto -40 -> 178
      //   221: aconst_null
      //   222: astore 4
      //   224: aload 4
      //   226: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   229: iload_2
      //   230: ifeq +70 -> 300
      //   233: getstatic 121	com/tencent/mapsdk/rastercore/b:b	I
      //   236: ireturn
      //   237: astore 4
      //   239: aload 5
      //   241: astore_3
      //   242: aload 4
      //   244: astore 5
      //   246: aload_3
      //   247: astore 4
      //   249: new 70	java/lang/StringBuilder
      //   252: dup
      //   253: ldc 142
      //   255: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   258: aload 6
      //   260: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   263: ldc 144
      //   265: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   268: aload 5
      //   270: invokevirtual 147	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   273: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   276: pop
      //   277: aload_3
      //   278: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   281: goto -52 -> 229
      //   284: astore 5
      //   286: aload 4
      //   288: astore_3
      //   289: aload 5
      //   291: astore 4
      //   293: aload_3
      //   294: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   297: aload 4
      //   299: athrow
      //   300: getstatic 68	com/tencent/mapsdk/rastercore/b:a	I
      //   303: ireturn
      //   304: astore 4
      //   306: goto -13 -> 293
      //   309: astore 5
      //   311: goto -65 -> 246
      //   314: goto -144 -> 170
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	317	0	paramInt1	int
      //   0	317	1	paramInt2	int
      //   0	317	2	paramBoolean	boolean
      //   1	293	3	localObject1	Object
      //   54	171	4	localObject2	Object
      //   237	6	4	localException1	Exception
      //   247	51	4	localObject3	Object
      //   304	1	4	localObject4	Object
      //   3	266	5	localObject5	Object
      //   284	6	5	localObject6	Object
      //   309	1	5	localException2	Exception
      //   11	248	6	str	String
      //   51	46	7	localObject7	Object
      // Exception table:
      //   from	to	target	type
      //   56	67	237	java/lang/Exception
      //   70	78	237	java/lang/Exception
      //   81	89	237	java/lang/Exception
      //   92	102	237	java/lang/Exception
      //   56	67	284	finally
      //   70	78	284	finally
      //   81	89	284	finally
      //   92	102	284	finally
      //   249	277	284	finally
      //   102	144	304	finally
      //   148	170	304	finally
      //   174	178	304	finally
      //   178	191	304	finally
      //   194	208	304	finally
      //   214	218	304	finally
      //   102	144	309	java/lang/Exception
      //   148	170	309	java/lang/Exception
      //   174	178	309	java/lang/Exception
      //   178	191	309	java/lang/Exception
      //   194	208	309	java/lang/Exception
      //   214	218	309	java/lang/Exception
    }
    
    /* Error */
    public static int a(String paramString, boolean paramBoolean)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: aconst_null
      //   3: astore 5
      //   5: invokestatic 53	com/tencent/mapsdk/rastercore/tile/a/a:a	()Lcom/tencent/mapsdk/rastercore/tile/a/a;
      //   8: invokevirtual 57	com/tencent/mapsdk/rastercore/tile/a/a:c	()Ljava/lang/String;
      //   11: astore 6
      //   13: aload 6
      //   15: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   18: ifne +10 -> 28
      //   21: aload_0
      //   22: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   25: ifeq +7 -> 32
      //   28: getstatic 68	com/tencent/mapsdk/rastercore/b:a	I
      //   31: ireturn
      //   32: new 70	java/lang/StringBuilder
      //   35: dup
      //   36: invokespecial 71	java/lang/StringBuilder:<init>	()V
      //   39: aload 6
      //   41: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   44: getstatic 81	java/io/File:separator	Ljava/lang/String;
      //   47: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   50: ldc 83
      //   52: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   55: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   58: astore 7
      //   60: aload_3
      //   61: astore 4
      //   63: new 77	java/io/File
      //   66: dup
      //   67: aload 7
      //   69: invokespecial 89	java/io/File:<init>	(Ljava/lang/String;)V
      //   72: astore 7
      //   74: aload_3
      //   75: astore 4
      //   77: aload 7
      //   79: invokevirtual 93	java/io/File:exists	()Z
      //   82: ifeq +127 -> 209
      //   85: aload_3
      //   86: astore 4
      //   88: aload 7
      //   90: invokevirtual 96	java/io/File:isFile	()Z
      //   93: ifeq +116 -> 209
      //   96: aload_3
      //   97: astore 4
      //   99: new 98	java/io/FileInputStream
      //   102: dup
      //   103: aload 7
      //   105: invokespecial 101	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   108: astore_3
      //   109: new 103	java/util/Properties
      //   112: dup
      //   113: invokespecial 104	java/util/Properties:<init>	()V
      //   116: astore 5
      //   118: aload 5
      //   120: aload_3
      //   121: invokevirtual 108	java/util/Properties:load	(Ljava/io/InputStream;)V
      //   124: new 70	java/lang/StringBuilder
      //   127: dup
      //   128: invokespecial 71	java/lang/StringBuilder:<init>	()V
      //   131: aload_0
      //   132: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   135: ldc 150
      //   137: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   140: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   143: astore 4
      //   145: aload 4
      //   147: astore_0
      //   148: iload_1
      //   149: ifeq +24 -> 173
      //   152: new 70	java/lang/StringBuilder
      //   155: dup
      //   156: invokespecial 71	java/lang/StringBuilder:<init>	()V
      //   159: aload 4
      //   161: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   164: ldc 118
      //   166: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   169: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   172: astore_0
      //   173: aload 5
      //   175: aload_0
      //   176: sipush 1000
      //   179: invokestatic 127	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   182: invokevirtual 131	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   185: astore 4
      //   187: aload_3
      //   188: astore_0
      //   189: aload 4
      //   191: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   194: ifne +17 -> 211
      //   197: aload 4
      //   199: invokestatic 137	java/lang/Integer:parseInt	(Ljava/lang/String;)I
      //   202: istore_2
      //   203: aload_3
      //   204: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   207: iload_2
      //   208: ireturn
      //   209: aconst_null
      //   210: astore_0
      //   211: aload_0
      //   212: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   215: sipush 1000
      //   218: ireturn
      //   219: astore_3
      //   220: aload 5
      //   222: astore_0
      //   223: aload_0
      //   224: astore 4
      //   226: new 70	java/lang/StringBuilder
      //   229: dup
      //   230: ldc 142
      //   232: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   235: aload 6
      //   237: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   240: ldc 144
      //   242: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   245: aload_3
      //   246: invokevirtual 147	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   249: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   252: pop
      //   253: aload_0
      //   254: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   257: goto -42 -> 215
      //   260: astore_0
      //   261: aload 4
      //   263: astore_3
      //   264: aload_3
      //   265: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   268: aload_0
      //   269: athrow
      //   270: astore_0
      //   271: goto -7 -> 264
      //   274: astore 4
      //   276: aload_3
      //   277: astore_0
      //   278: aload 4
      //   280: astore_3
      //   281: goto -58 -> 223
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	284	0	paramString	String
      //   0	284	1	paramBoolean	boolean
      //   202	6	2	i	int
      //   1	203	3	localFileInputStream	java.io.FileInputStream
      //   219	27	3	localException1	Exception
      //   263	18	3	localObject1	Object
      //   61	201	4	localObject2	Object
      //   274	5	4	localException2	Exception
      //   3	218	5	localProperties	java.util.Properties
      //   11	225	6	str	String
      //   58	46	7	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   63	74	219	java/lang/Exception
      //   77	85	219	java/lang/Exception
      //   88	96	219	java/lang/Exception
      //   99	109	219	java/lang/Exception
      //   63	74	260	finally
      //   77	85	260	finally
      //   88	96	260	finally
      //   99	109	260	finally
      //   226	253	260	finally
      //   109	145	270	finally
      //   152	173	270	finally
      //   173	187	270	finally
      //   189	203	270	finally
      //   109	145	274	java/lang/Exception
      //   152	173	274	java/lang/Exception
      //   173	187	274	java/lang/Exception
      //   189	203	274	java/lang/Exception
    }
    
    public static int a(byte[] paramArrayOfByte)
    {
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length != 4)) {
        throw new IllegalArgumentException("Four bytes are required for an integer.");
      }
      return paramArrayOfByte[0] & 0xFF | paramArrayOfByte[1] << 8 & 0xFF00 | paramArrayOfByte[2] << 16 & 0xFF0000 | paramArrayOfByte[3] << 24 & 0xFF000000;
    }
    
    public static PointF a(com.tencent.mapsdk.rastercore.b.c paramc1, com.tencent.mapsdk.rastercore.b.c paramc2, PointF paramPointF, double paramDouble)
    {
      PointF localPointF = new PointF();
      localPointF.x = ((float)((paramc1.b() - paramc2.b()) / paramDouble + paramPointF.x));
      localPointF.y = ((float)(paramPointF.y - (paramc1.a() - paramc2.a()) / paramDouble));
      return localPointF;
    }
    
    public static LatLng a(com.tencent.mapsdk.rastercore.b.c paramc)
    {
      float f = (float)(paramc.b() * 180.0D / 20037508.34D);
      return new LatLng((float)(57.295779513082323D * (2.0D * Math.atan(Math.exp((float)(paramc.a() * 180.0D / 20037508.34D) * 3.141592653589793D / 180.0D)) - 1.570796326794897D)), f);
    }
    
    public static com.tencent.mapsdk.rastercore.b.c a(PointF paramPointF1, com.tencent.mapsdk.rastercore.b.c paramc, PointF paramPointF2, com.tencent.mapsdk.rastercore.b.a parama)
    {
      float f1 = paramPointF1.x;
      float f2 = paramPointF2.x;
      float f3 = paramPointF1.y;
      float f4 = paramPointF2.y;
      return new com.tencent.mapsdk.rastercore.b.c(paramc.b() + (f1 - f2) * parama.d(), paramc.a() - (f3 - f4) * parama.d());
    }
    
    public static com.tencent.mapsdk.rastercore.b.c a(LatLng paramLatLng)
    {
      if (paramLatLng == null) {
        return null;
      }
      double d = paramLatLng.getLatitude();
      return new com.tencent.mapsdk.rastercore.b.c(paramLatLng.getLongitude() * 20037508.34D / 180.0D, Math.log(Math.tan((d + 90.0D) * 3.141592653589793D / 360.0D)) / 0.0174532925199433D * 20037508.34D / 180.0D);
    }
    
    public static com.tencent.mapsdk.rastercore.c.a a(float paramFloat, Point paramPoint)
    {
      com.tencent.mapsdk.rastercore.c.e locale = new com.tencent.mapsdk.rastercore.c.e();
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
    
    public static a a()
    {
      return a.a;
    }
    
    public static String a(int paramInt1, int paramInt2, int paramInt3)
    {
      StringBuilder localStringBuilder = new StringBuilder(com.tencent.mapsdk.rastercore.tile.a.a.a().c());
      localStringBuilder.append("/BingGrid").append("/").append(paramInt1).append("/").append(paramInt2).append("/").append(paramInt3).append("/");
      b(localStringBuilder.toString());
      localStringBuilder.append("bingLogo.dat");
      return localStringBuilder.toString();
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
    
    /* Error */
    public static boolean a(int paramInt)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 6
      //   3: aconst_null
      //   4: astore 4
      //   6: aconst_null
      //   7: astore 5
      //   9: invokestatic 53	com/tencent/mapsdk/rastercore/tile/a/a:a	()Lcom/tencent/mapsdk/rastercore/tile/a/a;
      //   12: invokevirtual 57	com/tencent/mapsdk/rastercore/tile/a/a:c	()Ljava/lang/String;
      //   15: astore 7
      //   17: aload 7
      //   19: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   22: ifne +11 -> 33
      //   25: aload 7
      //   27: invokestatic 259	com/tencent/mapsdk/rastercore/d$a:b	(Ljava/lang/String;)Z
      //   30: ifne +5 -> 35
      //   33: iconst_0
      //   34: ireturn
      //   35: new 70	java/lang/StringBuilder
      //   38: dup
      //   39: invokespecial 71	java/lang/StringBuilder:<init>	()V
      //   42: aload 7
      //   44: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   47: getstatic 81	java/io/File:separator	Ljava/lang/String;
      //   50: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   53: ldc 83
      //   55: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   58: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   61: astore_2
      //   62: new 103	java/util/Properties
      //   65: dup
      //   66: invokespecial 104	java/util/Properties:<init>	()V
      //   69: astore 8
      //   71: new 77	java/io/File
      //   74: dup
      //   75: aload_2
      //   76: invokespecial 89	java/io/File:<init>	(Ljava/lang/String;)V
      //   79: astore_1
      //   80: aload_1
      //   81: invokevirtual 93	java/io/File:exists	()Z
      //   84: ifeq +183 -> 267
      //   87: aload_1
      //   88: invokevirtual 96	java/io/File:isFile	()Z
      //   91: ifeq +176 -> 267
      //   94: new 98	java/io/FileInputStream
      //   97: dup
      //   98: aload_2
      //   99: invokespecial 270	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
      //   102: astore_1
      //   103: aload_1
      //   104: astore_3
      //   105: aload 8
      //   107: aload_1
      //   108: invokevirtual 108	java/util/Properties:load	(Ljava/io/InputStream;)V
      //   111: aload 8
      //   113: ldc_w 272
      //   116: iload_0
      //   117: invokestatic 127	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   120: invokevirtual 276	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   123: pop
      //   124: new 278	java/io/FileOutputStream
      //   127: dup
      //   128: aload_2
      //   129: invokespecial 279	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
      //   132: astore_2
      //   133: aload 8
      //   135: aload_2
      //   136: ldc_w 281
      //   139: invokevirtual 285	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
      //   142: aload_1
      //   143: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   146: aload_2
      //   147: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   150: iconst_1
      //   151: ireturn
      //   152: astore_2
      //   153: aconst_null
      //   154: astore_1
      //   155: aload 5
      //   157: astore 4
      //   159: aload_1
      //   160: astore_3
      //   161: new 70	java/lang/StringBuilder
      //   164: dup
      //   165: ldc 142
      //   167: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   170: aload 7
      //   172: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   175: ldc 144
      //   177: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   180: aload_2
      //   181: invokevirtual 147	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   184: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   187: pop
      //   188: aload_1
      //   189: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   192: aload 5
      //   194: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   197: iconst_0
      //   198: ireturn
      //   199: astore_1
      //   200: aconst_null
      //   201: astore_2
      //   202: aload 6
      //   204: astore 4
      //   206: aload_2
      //   207: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   210: aload 4
      //   212: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   215: aload_1
      //   216: athrow
      //   217: astore_1
      //   218: aload_3
      //   219: astore_2
      //   220: goto -14 -> 206
      //   223: astore_3
      //   224: aload_1
      //   225: astore_2
      //   226: aload_3
      //   227: astore_1
      //   228: aload 6
      //   230: astore 4
      //   232: goto -26 -> 206
      //   235: astore 4
      //   237: aload_1
      //   238: astore_3
      //   239: aload 4
      //   241: astore_1
      //   242: aload_2
      //   243: astore 4
      //   245: aload_3
      //   246: astore_2
      //   247: goto -41 -> 206
      //   250: astore_2
      //   251: goto -96 -> 155
      //   254: astore_2
      //   255: goto -100 -> 155
      //   258: astore_3
      //   259: aload_2
      //   260: astore 5
      //   262: aload_3
      //   263: astore_2
      //   264: goto -109 -> 155
      //   267: aconst_null
      //   268: astore_1
      //   269: goto -158 -> 111
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	272	0	paramInt	int
      //   79	110	1	localObject1	Object
      //   199	17	1	localObject2	Object
      //   217	8	1	localObject3	Object
      //   227	42	1	localObject4	Object
      //   61	86	2	localObject5	Object
      //   152	29	2	localException1	Exception
      //   201	46	2	localObject6	Object
      //   250	1	2	localException2	Exception
      //   254	6	2	localException3	Exception
      //   263	1	2	localObject7	Object
      //   104	115	3	localObject8	Object
      //   223	4	3	localObject9	Object
      //   238	8	3	localObject10	Object
      //   258	5	3	localException4	Exception
      //   4	227	4	localObject11	Object
      //   235	5	4	localObject12	Object
      //   243	1	4	localObject13	Object
      //   7	254	5	localObject14	Object
      //   1	228	6	localObject15	Object
      //   15	156	7	str	String
      //   69	65	8	localProperties	java.util.Properties
      // Exception table:
      //   from	to	target	type
      //   62	103	152	java/lang/Exception
      //   62	103	199	finally
      //   105	111	217	finally
      //   161	188	217	finally
      //   111	133	223	finally
      //   133	142	235	finally
      //   105	111	250	java/lang/Exception
      //   111	133	254	java/lang/Exception
      //   133	142	258	java/lang/Exception
    }
    
    /* Error */
    public static boolean a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 6
      //   3: aconst_null
      //   4: astore 10
      //   6: aconst_null
      //   7: astore 9
      //   9: invokestatic 53	com/tencent/mapsdk/rastercore/tile/a/a:a	()Lcom/tencent/mapsdk/rastercore/tile/a/a;
      //   12: invokevirtual 57	com/tencent/mapsdk/rastercore/tile/a/a:c	()Ljava/lang/String;
      //   15: astore 12
      //   17: aload 12
      //   19: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   22: ifne +11 -> 33
      //   25: aload 12
      //   27: invokestatic 259	com/tencent/mapsdk/rastercore/d$a:b	(Ljava/lang/String;)Z
      //   30: ifne +5 -> 35
      //   33: iconst_0
      //   34: ireturn
      //   35: new 70	java/lang/StringBuilder
      //   38: dup
      //   39: invokespecial 71	java/lang/StringBuilder:<init>	()V
      //   42: aload 12
      //   44: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   47: getstatic 81	java/io/File:separator	Ljava/lang/String;
      //   50: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   53: ldc 83
      //   55: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   58: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   61: astore 14
      //   63: new 103	java/util/Properties
      //   66: dup
      //   67: invokespecial 104	java/util/Properties:<init>	()V
      //   70: astore 13
      //   72: new 77	java/io/File
      //   75: dup
      //   76: aload 14
      //   78: invokespecial 89	java/io/File:<init>	(Ljava/lang/String;)V
      //   81: astore 4
      //   83: aload 4
      //   85: invokevirtual 93	java/io/File:exists	()Z
      //   88: ifeq +327 -> 415
      //   91: aload 4
      //   93: invokevirtual 96	java/io/File:isFile	()Z
      //   96: ifeq +319 -> 415
      //   99: new 98	java/io/FileInputStream
      //   102: dup
      //   103: aload 14
      //   105: invokespecial 270	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
      //   108: astore 4
      //   110: aload 4
      //   112: astore 5
      //   114: aload 10
      //   116: astore 6
      //   118: aload 4
      //   120: astore 7
      //   122: aload 13
      //   124: aload 4
      //   126: invokevirtual 108	java/util/Properties:load	(Ljava/io/InputStream;)V
      //   129: aload 4
      //   131: astore 5
      //   133: aload 10
      //   135: astore 6
      //   137: aload 4
      //   139: astore 7
      //   141: aload 4
      //   143: invokevirtual 287	java/io/FileInputStream:close	()V
      //   146: aload 4
      //   148: astore 5
      //   150: aload 10
      //   152: astore 6
      //   154: aload 4
      //   156: astore 7
      //   158: new 70	java/lang/StringBuilder
      //   161: dup
      //   162: ldc 110
      //   164: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   167: iload_0
      //   168: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   171: ldc 116
      //   173: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   176: iload_1
      //   177: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   180: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   183: astore 11
      //   185: aload 11
      //   187: astore 8
      //   189: iload_3
      //   190: ifeq +37 -> 227
      //   193: aload 4
      //   195: astore 5
      //   197: aload 10
      //   199: astore 6
      //   201: aload 4
      //   203: astore 7
      //   205: new 70	java/lang/StringBuilder
      //   208: dup
      //   209: invokespecial 71	java/lang/StringBuilder:<init>	()V
      //   212: aload 11
      //   214: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   217: ldc 118
      //   219: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   222: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   225: astore 8
      //   227: aload 4
      //   229: astore 5
      //   231: aload 10
      //   233: astore 6
      //   235: aload 4
      //   237: astore 7
      //   239: aload 13
      //   241: aload 8
      //   243: iload_2
      //   244: invokestatic 127	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   247: invokevirtual 276	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   250: pop
      //   251: aload 4
      //   253: astore 5
      //   255: aload 10
      //   257: astore 6
      //   259: aload 4
      //   261: astore 7
      //   263: new 278	java/io/FileOutputStream
      //   266: dup
      //   267: aload 14
      //   269: invokespecial 279	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
      //   272: astore 8
      //   274: aload 13
      //   276: aload 8
      //   278: ldc_w 281
      //   281: invokevirtual 285	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
      //   284: aload 8
      //   286: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   289: aload 4
      //   291: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   294: iconst_1
      //   295: ireturn
      //   296: astore 8
      //   298: aconst_null
      //   299: astore 4
      //   301: aload 9
      //   303: astore 7
      //   305: aload 4
      //   307: astore 5
      //   309: aload 7
      //   311: astore 6
      //   313: new 70	java/lang/StringBuilder
      //   316: dup
      //   317: ldc 142
      //   319: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   322: aload 12
      //   324: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   327: ldc 144
      //   329: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   332: aload 8
      //   334: invokevirtual 147	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   337: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   340: pop
      //   341: aload 7
      //   343: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   346: aload 4
      //   348: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   351: iconst_0
      //   352: ireturn
      //   353: astore 7
      //   355: aconst_null
      //   356: astore 4
      //   358: aload 6
      //   360: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   363: aload 4
      //   365: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   368: aload 7
      //   370: athrow
      //   371: astore 7
      //   373: aload 5
      //   375: astore 4
      //   377: goto -19 -> 358
      //   380: astore 7
      //   382: aload 8
      //   384: astore 6
      //   386: goto -28 -> 358
      //   389: astore 8
      //   391: aload 7
      //   393: astore 4
      //   395: aload 9
      //   397: astore 7
      //   399: goto -94 -> 305
      //   402: astore 5
      //   404: aload 8
      //   406: astore 7
      //   408: aload 5
      //   410: astore 8
      //   412: goto -107 -> 305
      //   415: aconst_null
      //   416: astore 4
      //   418: goto -272 -> 146
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	421	0	paramInt1	int
      //   0	421	1	paramInt2	int
      //   0	421	2	paramInt3	int
      //   0	421	3	paramBoolean	boolean
      //   81	336	4	localObject1	Object
      //   112	262	5	localObject2	Object
      //   402	7	5	localException1	Exception
      //   1	384	6	localObject3	Object
      //   120	222	7	localObject4	Object
      //   353	16	7	localObject5	Object
      //   371	1	7	localObject6	Object
      //   380	12	7	localObject7	Object
      //   397	10	7	localObject8	Object
      //   187	98	8	localObject9	Object
      //   296	87	8	localException2	Exception
      //   389	16	8	localException3	Exception
      //   410	1	8	localException4	Exception
      //   7	389	9	localObject10	Object
      //   4	252	10	localObject11	Object
      //   183	30	11	str1	String
      //   15	308	12	str2	String
      //   70	205	13	localProperties	java.util.Properties
      //   61	207	14	str3	String
      // Exception table:
      //   from	to	target	type
      //   63	110	296	java/lang/Exception
      //   63	110	353	finally
      //   122	129	371	finally
      //   141	146	371	finally
      //   158	185	371	finally
      //   205	227	371	finally
      //   239	251	371	finally
      //   263	274	371	finally
      //   313	341	371	finally
      //   274	284	380	finally
      //   122	129	389	java/lang/Exception
      //   141	146	389	java/lang/Exception
      //   158	185	389	java/lang/Exception
      //   205	227	389	java/lang/Exception
      //   239	251	389	java/lang/Exception
      //   263	274	389	java/lang/Exception
      //   274	284	402	java/lang/Exception
    }
    
    /* Error */
    public static boolean a(String paramString, int paramInt, boolean paramBoolean)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 8
      //   3: aconst_null
      //   4: astore_3
      //   5: aconst_null
      //   6: astore 7
      //   8: invokestatic 53	com/tencent/mapsdk/rastercore/tile/a/a:a	()Lcom/tencent/mapsdk/rastercore/tile/a/a;
      //   11: invokevirtual 57	com/tencent/mapsdk/rastercore/tile/a/a:c	()Ljava/lang/String;
      //   14: astore 9
      //   16: aload 9
      //   18: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   21: ifne +11 -> 32
      //   24: aload 9
      //   26: invokestatic 259	com/tencent/mapsdk/rastercore/d$a:b	(Ljava/lang/String;)Z
      //   29: ifne +5 -> 34
      //   32: iconst_0
      //   33: ireturn
      //   34: new 70	java/lang/StringBuilder
      //   37: dup
      //   38: invokespecial 71	java/lang/StringBuilder:<init>	()V
      //   41: aload 9
      //   43: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   46: getstatic 81	java/io/File:separator	Ljava/lang/String;
      //   49: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   52: ldc 83
      //   54: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   57: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   60: astore 11
      //   62: new 103	java/util/Properties
      //   65: dup
      //   66: invokespecial 104	java/util/Properties:<init>	()V
      //   69: astore 10
      //   71: new 77	java/io/File
      //   74: dup
      //   75: aload 11
      //   77: invokespecial 89	java/io/File:<init>	(Ljava/lang/String;)V
      //   80: astore 4
      //   82: aload 4
      //   84: invokevirtual 93	java/io/File:exists	()Z
      //   87: ifeq +266 -> 353
      //   90: aload 4
      //   92: invokevirtual 96	java/io/File:isFile	()Z
      //   95: ifeq +258 -> 353
      //   98: new 98	java/io/FileInputStream
      //   101: dup
      //   102: aload 11
      //   104: invokespecial 270	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
      //   107: astore 6
      //   109: aload_3
      //   110: astore 4
      //   112: aload 6
      //   114: astore 5
      //   116: aload 10
      //   118: aload 6
      //   120: invokevirtual 108	java/util/Properties:load	(Ljava/io/InputStream;)V
      //   123: aload_3
      //   124: astore 4
      //   126: aload 6
      //   128: astore 5
      //   130: aload 6
      //   132: invokevirtual 287	java/io/FileInputStream:close	()V
      //   135: aload 6
      //   137: astore_3
      //   138: new 70	java/lang/StringBuilder
      //   141: dup
      //   142: invokespecial 71	java/lang/StringBuilder:<init>	()V
      //   145: aload_0
      //   146: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   149: ldc 150
      //   151: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   154: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   157: astore 4
      //   159: aload 4
      //   161: astore_0
      //   162: iload_2
      //   163: ifeq +24 -> 187
      //   166: new 70	java/lang/StringBuilder
      //   169: dup
      //   170: invokespecial 71	java/lang/StringBuilder:<init>	()V
      //   173: aload 4
      //   175: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   178: ldc 118
      //   180: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   183: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   186: astore_0
      //   187: aload 10
      //   189: aload_0
      //   190: iload_1
      //   191: invokestatic 127	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   194: invokevirtual 276	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   197: pop
      //   198: new 278	java/io/FileOutputStream
      //   201: dup
      //   202: aload 11
      //   204: invokespecial 279	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
      //   207: astore_0
      //   208: aload 10
      //   210: aload_0
      //   211: ldc_w 281
      //   214: invokevirtual 285	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
      //   217: aload_3
      //   218: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   221: aload_0
      //   222: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   225: iconst_0
      //   226: ireturn
      //   227: astore_3
      //   228: aconst_null
      //   229: astore_0
      //   230: aload 7
      //   232: astore 4
      //   234: aload_0
      //   235: astore 5
      //   237: new 70	java/lang/StringBuilder
      //   240: dup
      //   241: ldc 142
      //   243: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   246: aload 9
      //   248: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   251: ldc 144
      //   253: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   256: aload_3
      //   257: invokevirtual 147	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   260: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   263: pop
      //   264: aload_0
      //   265: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   268: aload 7
      //   270: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   273: iconst_0
      //   274: ireturn
      //   275: astore_0
      //   276: aconst_null
      //   277: astore_3
      //   278: aload 8
      //   280: astore 4
      //   282: aload_3
      //   283: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   286: aload 4
      //   288: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   291: aload_0
      //   292: athrow
      //   293: astore_0
      //   294: aload 5
      //   296: astore_3
      //   297: goto -15 -> 282
      //   300: astore_0
      //   301: aload 8
      //   303: astore 4
      //   305: goto -23 -> 282
      //   308: astore 5
      //   310: aload_0
      //   311: astore 4
      //   313: aload 5
      //   315: astore_0
      //   316: goto -34 -> 282
      //   319: astore_3
      //   320: aload 6
      //   322: astore_0
      //   323: goto -93 -> 230
      //   326: astore 4
      //   328: aload_3
      //   329: astore_0
      //   330: aload 4
      //   332: astore_3
      //   333: goto -103 -> 230
      //   336: astore 5
      //   338: aload_3
      //   339: astore 4
      //   341: aload 5
      //   343: astore_3
      //   344: aload_0
      //   345: astore 7
      //   347: aload 4
      //   349: astore_0
      //   350: goto -120 -> 230
      //   353: aconst_null
      //   354: astore_3
      //   355: goto -217 -> 138
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	358	0	paramString	String
      //   0	358	1	paramInt	int
      //   0	358	2	paramBoolean	boolean
      //   4	214	3	localObject1	Object
      //   227	30	3	localException1	Exception
      //   277	20	3	localObject2	Object
      //   319	10	3	localException2	Exception
      //   332	23	3	localObject3	Object
      //   80	232	4	localObject4	Object
      //   326	5	4	localException3	Exception
      //   339	9	4	localObject5	Object
      //   114	181	5	localObject6	Object
      //   308	6	5	localObject7	Object
      //   336	6	5	localException4	Exception
      //   107	214	6	localFileInputStream	java.io.FileInputStream
      //   6	340	7	localObject8	Object
      //   1	301	8	localObject9	Object
      //   14	233	9	str1	String
      //   69	140	10	localProperties	java.util.Properties
      //   60	143	11	str2	String
      // Exception table:
      //   from	to	target	type
      //   62	109	227	java/lang/Exception
      //   62	109	275	finally
      //   116	123	293	finally
      //   130	135	293	finally
      //   237	264	293	finally
      //   138	159	300	finally
      //   166	187	300	finally
      //   187	208	300	finally
      //   208	217	308	finally
      //   116	123	319	java/lang/Exception
      //   130	135	319	java/lang/Exception
      //   138	159	326	java/lang/Exception
      //   166	187	326	java/lang/Exception
      //   187	208	326	java/lang/Exception
      //   208	217	336	java/lang/Exception
    }
    
    /* Error */
    public static boolean a(byte[] paramArrayOfByte, String paramString)
    {
      // Byte code:
      //   0: new 278	java/io/FileOutputStream
      //   3: dup
      //   4: aload_1
      //   5: invokespecial 279	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
      //   8: astore_2
      //   9: aload_2
      //   10: astore_1
      //   11: aload_2
      //   12: aload_0
      //   13: invokevirtual 293	java/io/FileOutputStream:write	([B)V
      //   16: aload_2
      //   17: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   20: iconst_1
      //   21: ireturn
      //   22: astore_3
      //   23: aconst_null
      //   24: astore_0
      //   25: aload_0
      //   26: astore_1
      //   27: new 70	java/lang/StringBuilder
      //   30: dup
      //   31: ldc_w 295
      //   34: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   37: aload_3
      //   38: invokevirtual 296	java/io/IOException:toString	()Ljava/lang/String;
      //   41: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   44: pop
      //   45: aload_0
      //   46: astore_1
      //   47: aload_3
      //   48: invokevirtual 299	java/io/IOException:printStackTrace	()V
      //   51: aload_0
      //   52: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   55: iconst_0
      //   56: ireturn
      //   57: astore_0
      //   58: aconst_null
      //   59: astore_1
      //   60: aload_1
      //   61: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   64: aload_0
      //   65: athrow
      //   66: astore_0
      //   67: goto -7 -> 60
      //   70: astore_3
      //   71: aload_2
      //   72: astore_0
      //   73: goto -48 -> 25
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	76	0	paramArrayOfByte	byte[]
      //   0	76	1	paramString	String
      //   8	64	2	localFileOutputStream	java.io.FileOutputStream
      //   22	26	3	localIOException1	IOException
      //   70	1	3	localIOException2	IOException
      // Exception table:
      //   from	to	target	type
      //   0	9	22	java/io/IOException
      //   0	9	57	finally
      //   11	16	66	finally
      //   27	45	66	finally
      //   47	51	66	finally
      //   11	16	70	java/io/IOException
    }
    
    /* Error */
    public static byte[] a(java.io.InputStream paramInputStream)
    {
      // Byte code:
      //   0: new 302	java/io/ByteArrayOutputStream
      //   3: dup
      //   4: invokespecial 303	java/io/ByteArrayOutputStream:<init>	()V
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
      //   26: invokevirtual 309	java/io/InputStream:read	([BII)I
      //   29: istore_1
      //   30: iload_1
      //   31: iconst_m1
      //   32: if_icmpeq +47 -> 79
      //   35: aload_3
      //   36: astore_2
      //   37: aload_3
      //   38: aload 4
      //   40: iconst_0
      //   41: iload_1
      //   42: invokevirtual 312	java/io/ByteArrayOutputStream:write	([BII)V
      //   45: goto -28 -> 17
      //   48: astore_2
      //   49: aload_3
      //   50: astore_0
      //   51: aload_2
      //   52: astore_3
      //   53: aload_0
      //   54: astore_2
      //   55: new 70	java/lang/StringBuilder
      //   58: dup
      //   59: ldc_w 314
      //   62: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   65: aload_3
      //   66: invokevirtual 296	java/io/IOException:toString	()Ljava/lang/String;
      //   69: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   72: pop
      //   73: aload_0
      //   74: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   77: aconst_null
      //   78: areturn
      //   79: aload_3
      //   80: astore_2
      //   81: aload_3
      //   82: invokevirtual 317	java/io/ByteArrayOutputStream:flush	()V
      //   85: aload_3
      //   86: astore_2
      //   87: aload_3
      //   88: invokevirtual 321	java/io/ByteArrayOutputStream:toByteArray	()[B
      //   91: astore_0
      //   92: aload_3
      //   93: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   96: aload_0
      //   97: areturn
      //   98: astore_0
      //   99: aconst_null
      //   100: astore_2
      //   101: aload_2
      //   102: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   105: aload_0
      //   106: athrow
      //   107: astore_0
      //   108: goto -7 -> 101
      //   111: astore_3
      //   112: aconst_null
      //   113: astore_0
      //   114: goto -61 -> 53
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	117	0	paramInputStream	java.io.InputStream
      //   29	13	1	i	int
      //   9	28	2	localObject1	Object
      //   48	4	2	localIOException1	IOException
      //   54	48	2	localObject2	Object
      //   7	86	3	localObject3	Object
      //   111	1	3	localIOException2	IOException
      //   15	24	4	arrayOfByte	byte[]
      // Exception table:
      //   from	to	target	type
      //   10	17	48	java/io/IOException
      //   19	30	48	java/io/IOException
      //   37	45	48	java/io/IOException
      //   81	85	48	java/io/IOException
      //   87	92	48	java/io/IOException
      //   0	8	98	finally
      //   10	17	107	finally
      //   19	30	107	finally
      //   37	45	107	finally
      //   55	73	107	finally
      //   81	85	107	finally
      //   87	92	107	finally
      //   0	8	111	java/io/IOException
    }
    
    /* Error */
    public static byte[] a(String paramString)
    {
      // Byte code:
      //   0: new 98	java/io/FileInputStream
      //   3: dup
      //   4: aload_0
      //   5: invokespecial 270	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
      //   8: astore_3
      //   9: new 302	java/io/ByteArrayOutputStream
      //   12: dup
      //   13: invokespecial 303	java/io/ByteArrayOutputStream:<init>	()V
      //   16: astore_2
      //   17: aload_2
      //   18: astore 5
      //   20: aload_3
      //   21: astore 4
      //   23: sipush 1024
      //   26: newarray byte
      //   28: astore 6
      //   30: aload_2
      //   31: astore 5
      //   33: aload_3
      //   34: astore 4
      //   36: aload_3
      //   37: aload 6
      //   39: invokevirtual 324	java/io/FileInputStream:read	([B)I
      //   42: istore_1
      //   43: iload_1
      //   44: ifle +67 -> 111
      //   47: aload_2
      //   48: astore 5
      //   50: aload_3
      //   51: astore 4
      //   53: aload_2
      //   54: aload 6
      //   56: iconst_0
      //   57: iload_1
      //   58: invokevirtual 312	java/io/ByteArrayOutputStream:write	([BII)V
      //   61: goto -31 -> 30
      //   64: astore 6
      //   66: aload_2
      //   67: astore 5
      //   69: aload_3
      //   70: astore 4
      //   72: new 70	java/lang/StringBuilder
      //   75: dup
      //   76: ldc_w 326
      //   79: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   82: aload_0
      //   83: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   86: ldc_w 328
      //   89: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   92: aload 6
      //   94: invokevirtual 329	java/lang/Exception:toString	()Ljava/lang/String;
      //   97: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   100: pop
      //   101: aload_3
      //   102: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   105: aload_2
      //   106: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   109: aconst_null
      //   110: areturn
      //   111: aload_2
      //   112: astore 5
      //   114: aload_3
      //   115: astore 4
      //   117: aload_2
      //   118: invokevirtual 321	java/io/ByteArrayOutputStream:toByteArray	()[B
      //   121: astore 6
      //   123: aload_3
      //   124: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   127: aload_2
      //   128: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   131: aload 6
      //   133: areturn
      //   134: astore_0
      //   135: aconst_null
      //   136: astore 5
      //   138: aconst_null
      //   139: astore_3
      //   140: aload_3
      //   141: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   144: aload 5
      //   146: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   149: aload_0
      //   150: athrow
      //   151: astore_0
      //   152: aconst_null
      //   153: astore 5
      //   155: goto -15 -> 140
      //   158: astore_0
      //   159: aload 4
      //   161: astore_3
      //   162: goto -22 -> 140
      //   165: astore 6
      //   167: aconst_null
      //   168: astore_2
      //   169: aconst_null
      //   170: astore_3
      //   171: goto -105 -> 66
      //   174: astore 6
      //   176: aconst_null
      //   177: astore_2
      //   178: goto -112 -> 66
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	181	0	paramString	String
      //   42	16	1	i	int
      //   16	162	2	localByteArrayOutputStream1	java.io.ByteArrayOutputStream
      //   8	163	3	localObject1	Object
      //   21	139	4	localObject2	Object
      //   18	136	5	localByteArrayOutputStream2	java.io.ByteArrayOutputStream
      //   28	27	6	arrayOfByte1	byte[]
      //   64	29	6	localException1	Exception
      //   121	11	6	arrayOfByte2	byte[]
      //   165	1	6	localException2	Exception
      //   174	1	6	localException3	Exception
      // Exception table:
      //   from	to	target	type
      //   23	30	64	java/lang/Exception
      //   36	43	64	java/lang/Exception
      //   53	61	64	java/lang/Exception
      //   117	123	64	java/lang/Exception
      //   0	9	134	finally
      //   9	17	151	finally
      //   23	30	158	finally
      //   36	43	158	finally
      //   53	61	158	finally
      //   72	101	158	finally
      //   117	123	158	finally
      //   0	9	165	java/lang/Exception
      //   9	17	174	java/lang/Exception
    }
    
    /* Error */
    public static int b()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: aconst_null
      //   3: astore_3
      //   4: invokestatic 53	com/tencent/mapsdk/rastercore/tile/a/a:a	()Lcom/tencent/mapsdk/rastercore/tile/a/a;
      //   7: invokevirtual 57	com/tencent/mapsdk/rastercore/tile/a/a:c	()Ljava/lang/String;
      //   10: astore 4
      //   12: aload 4
      //   14: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   17: ifeq +5 -> 22
      //   20: iconst_0
      //   21: ireturn
      //   22: new 70	java/lang/StringBuilder
      //   25: dup
      //   26: invokespecial 71	java/lang/StringBuilder:<init>	()V
      //   29: aload 4
      //   31: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   34: getstatic 81	java/io/File:separator	Ljava/lang/String;
      //   37: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   40: ldc 83
      //   42: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   45: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   48: astore 5
      //   50: aload_2
      //   51: astore_1
      //   52: new 77	java/io/File
      //   55: dup
      //   56: aload 5
      //   58: invokespecial 89	java/io/File:<init>	(Ljava/lang/String;)V
      //   61: astore 5
      //   63: aload_2
      //   64: astore_1
      //   65: aload 5
      //   67: invokevirtual 93	java/io/File:exists	()Z
      //   70: ifeq +76 -> 146
      //   73: aload_2
      //   74: astore_1
      //   75: aload 5
      //   77: invokevirtual 96	java/io/File:isFile	()Z
      //   80: ifeq +66 -> 146
      //   83: aload_2
      //   84: astore_1
      //   85: new 98	java/io/FileInputStream
      //   88: dup
      //   89: aload 5
      //   91: invokespecial 101	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   94: astore_2
      //   95: new 103	java/util/Properties
      //   98: dup
      //   99: invokespecial 104	java/util/Properties:<init>	()V
      //   102: astore_1
      //   103: aload_1
      //   104: aload_2
      //   105: invokevirtual 108	java/util/Properties:load	(Ljava/io/InputStream;)V
      //   108: aload_2
      //   109: invokevirtual 287	java/io/FileInputStream:close	()V
      //   112: aload_1
      //   113: ldc_w 272
      //   116: getstatic 332	com/tencent/mapsdk/rastercore/b:c	I
      //   119: invokestatic 127	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   122: invokevirtual 131	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   125: astore_3
      //   126: aload_2
      //   127: astore_1
      //   128: aload_3
      //   129: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   132: ifne +16 -> 148
      //   135: aload_3
      //   136: invokestatic 137	java/lang/Integer:parseInt	(Ljava/lang/String;)I
      //   139: istore_0
      //   140: aload_2
      //   141: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   144: iload_0
      //   145: ireturn
      //   146: aconst_null
      //   147: astore_1
      //   148: aload_1
      //   149: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   152: getstatic 332	com/tencent/mapsdk/rastercore/b:c	I
      //   155: ireturn
      //   156: astore_1
      //   157: aload_3
      //   158: astore_2
      //   159: aload_1
      //   160: astore_3
      //   161: aload_2
      //   162: astore_1
      //   163: new 70	java/lang/StringBuilder
      //   166: dup
      //   167: ldc 142
      //   169: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   172: aload 4
      //   174: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   177: ldc 144
      //   179: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   182: aload_3
      //   183: invokevirtual 147	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   186: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   189: pop
      //   190: aload_2
      //   191: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   194: goto -42 -> 152
      //   197: astore_3
      //   198: aload_1
      //   199: astore_2
      //   200: aload_3
      //   201: astore_1
      //   202: aload_2
      //   203: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   206: aload_1
      //   207: athrow
      //   208: astore_1
      //   209: goto -7 -> 202
      //   212: astore_3
      //   213: goto -52 -> 161
      // Local variable table:
      //   start	length	slot	name	signature
      //   139	6	0	i	int
      //   51	98	1	localObject1	Object
      //   156	4	1	localException1	Exception
      //   162	45	1	localObject2	Object
      //   208	1	1	localObject3	Object
      //   1	202	2	localObject4	Object
      //   3	180	3	localObject5	Object
      //   197	4	3	localObject6	Object
      //   212	1	3	localException2	Exception
      //   10	163	4	str	String
      //   48	42	5	localObject7	Object
      // Exception table:
      //   from	to	target	type
      //   52	63	156	java/lang/Exception
      //   65	73	156	java/lang/Exception
      //   75	83	156	java/lang/Exception
      //   85	95	156	java/lang/Exception
      //   52	63	197	finally
      //   65	73	197	finally
      //   75	83	197	finally
      //   85	95	197	finally
      //   163	190	197	finally
      //   95	126	208	finally
      //   128	140	208	finally
      //   95	126	212	java/lang/Exception
      //   128	140	212	java/lang/Exception
    }
    
    /* Error */
    public static int b(String paramString, boolean paramBoolean)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: aconst_null
      //   3: astore 5
      //   5: invokestatic 53	com/tencent/mapsdk/rastercore/tile/a/a:a	()Lcom/tencent/mapsdk/rastercore/tile/a/a;
      //   8: invokevirtual 57	com/tencent/mapsdk/rastercore/tile/a/a:c	()Ljava/lang/String;
      //   11: astore 6
      //   13: aload 6
      //   15: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   18: ifne +10 -> 28
      //   21: aload_0
      //   22: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   25: ifeq +7 -> 32
      //   28: getstatic 68	com/tencent/mapsdk/rastercore/b:a	I
      //   31: ireturn
      //   32: new 70	java/lang/StringBuilder
      //   35: dup
      //   36: invokespecial 71	java/lang/StringBuilder:<init>	()V
      //   39: aload 6
      //   41: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   44: getstatic 81	java/io/File:separator	Ljava/lang/String;
      //   47: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   50: ldc 83
      //   52: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   55: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   58: astore 7
      //   60: aload_3
      //   61: astore 4
      //   63: new 77	java/io/File
      //   66: dup
      //   67: aload 7
      //   69: invokespecial 89	java/io/File:<init>	(Ljava/lang/String;)V
      //   72: astore 7
      //   74: aload_3
      //   75: astore 4
      //   77: aload 7
      //   79: invokevirtual 93	java/io/File:exists	()Z
      //   82: ifeq +126 -> 208
      //   85: aload_3
      //   86: astore 4
      //   88: aload 7
      //   90: invokevirtual 96	java/io/File:isFile	()Z
      //   93: ifeq +115 -> 208
      //   96: aload_3
      //   97: astore 4
      //   99: new 98	java/io/FileInputStream
      //   102: dup
      //   103: aload 7
      //   105: invokespecial 101	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   108: astore_3
      //   109: new 103	java/util/Properties
      //   112: dup
      //   113: invokespecial 104	java/util/Properties:<init>	()V
      //   116: astore 5
      //   118: aload 5
      //   120: aload_3
      //   121: invokevirtual 108	java/util/Properties:load	(Ljava/io/InputStream;)V
      //   124: new 70	java/lang/StringBuilder
      //   127: dup
      //   128: invokespecial 71	java/lang/StringBuilder:<init>	()V
      //   131: aload_0
      //   132: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   135: ldc_w 334
      //   138: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   141: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   144: astore 4
      //   146: aload 4
      //   148: astore_0
      //   149: iload_1
      //   150: ifeq +24 -> 174
      //   153: new 70	java/lang/StringBuilder
      //   156: dup
      //   157: invokespecial 71	java/lang/StringBuilder:<init>	()V
      //   160: aload 4
      //   162: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   165: ldc 118
      //   167: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   170: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   173: astore_0
      //   174: aload 5
      //   176: aload_0
      //   177: iconst_0
      //   178: invokestatic 127	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   181: invokevirtual 131	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   184: astore 4
      //   186: aload_3
      //   187: astore_0
      //   188: aload 4
      //   190: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   193: ifne +17 -> 210
      //   196: aload 4
      //   198: invokestatic 137	java/lang/Integer:parseInt	(Ljava/lang/String;)I
      //   201: istore_2
      //   202: aload_3
      //   203: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   206: iload_2
      //   207: ireturn
      //   208: aconst_null
      //   209: astore_0
      //   210: aload_0
      //   211: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   214: iconst_0
      //   215: ireturn
      //   216: astore_3
      //   217: aload 5
      //   219: astore_0
      //   220: aload_0
      //   221: astore 4
      //   223: new 70	java/lang/StringBuilder
      //   226: dup
      //   227: ldc 142
      //   229: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   232: aload 6
      //   234: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   237: ldc 144
      //   239: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   242: aload_3
      //   243: invokevirtual 147	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   246: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   249: pop
      //   250: aload_0
      //   251: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   254: goto -40 -> 214
      //   257: astore_0
      //   258: aload 4
      //   260: astore_3
      //   261: aload_3
      //   262: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   265: aload_0
      //   266: athrow
      //   267: astore_0
      //   268: goto -7 -> 261
      //   271: astore 4
      //   273: aload_3
      //   274: astore_0
      //   275: aload 4
      //   277: astore_3
      //   278: goto -58 -> 220
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	281	0	paramString	String
      //   0	281	1	paramBoolean	boolean
      //   201	6	2	i	int
      //   1	202	3	localFileInputStream	java.io.FileInputStream
      //   216	27	3	localException1	Exception
      //   260	18	3	localObject1	Object
      //   61	198	4	localObject2	Object
      //   271	5	4	localException2	Exception
      //   3	215	5	localProperties	java.util.Properties
      //   11	222	6	str	String
      //   58	46	7	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   63	74	216	java/lang/Exception
      //   77	85	216	java/lang/Exception
      //   88	96	216	java/lang/Exception
      //   99	109	216	java/lang/Exception
      //   63	74	257	finally
      //   77	85	257	finally
      //   88	96	257	finally
      //   99	109	257	finally
      //   223	250	257	finally
      //   109	146	267	finally
      //   153	174	267	finally
      //   174	186	267	finally
      //   188	202	267	finally
      //   109	146	271	java/lang/Exception
      //   153	174	271	java/lang/Exception
      //   174	186	271	java/lang/Exception
      //   188	202	271	java/lang/Exception
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
    
    /* Error */
    public static boolean b(String paramString, int paramInt, boolean paramBoolean)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 8
      //   3: aconst_null
      //   4: astore_3
      //   5: aconst_null
      //   6: astore 7
      //   8: invokestatic 53	com/tencent/mapsdk/rastercore/tile/a/a:a	()Lcom/tencent/mapsdk/rastercore/tile/a/a;
      //   11: invokevirtual 57	com/tencent/mapsdk/rastercore/tile/a/a:c	()Ljava/lang/String;
      //   14: astore 9
      //   16: aload 9
      //   18: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   21: ifne +11 -> 32
      //   24: aload 9
      //   26: invokestatic 259	com/tencent/mapsdk/rastercore/d$a:b	(Ljava/lang/String;)Z
      //   29: ifne +5 -> 34
      //   32: iconst_0
      //   33: ireturn
      //   34: new 70	java/lang/StringBuilder
      //   37: dup
      //   38: invokespecial 71	java/lang/StringBuilder:<init>	()V
      //   41: aload 9
      //   43: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   46: getstatic 81	java/io/File:separator	Ljava/lang/String;
      //   49: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   52: ldc 83
      //   54: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   57: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   60: astore 11
      //   62: new 103	java/util/Properties
      //   65: dup
      //   66: invokespecial 104	java/util/Properties:<init>	()V
      //   69: astore 10
      //   71: new 77	java/io/File
      //   74: dup
      //   75: aload 11
      //   77: invokespecial 89	java/io/File:<init>	(Ljava/lang/String;)V
      //   80: astore 4
      //   82: aload 4
      //   84: invokevirtual 93	java/io/File:exists	()Z
      //   87: ifeq +267 -> 354
      //   90: aload 4
      //   92: invokevirtual 96	java/io/File:isFile	()Z
      //   95: ifeq +259 -> 354
      //   98: new 98	java/io/FileInputStream
      //   101: dup
      //   102: aload 11
      //   104: invokespecial 270	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
      //   107: astore 6
      //   109: aload_3
      //   110: astore 4
      //   112: aload 6
      //   114: astore 5
      //   116: aload 10
      //   118: aload 6
      //   120: invokevirtual 108	java/util/Properties:load	(Ljava/io/InputStream;)V
      //   123: aload_3
      //   124: astore 4
      //   126: aload 6
      //   128: astore 5
      //   130: aload 6
      //   132: invokevirtual 287	java/io/FileInputStream:close	()V
      //   135: aload 6
      //   137: astore_3
      //   138: new 70	java/lang/StringBuilder
      //   141: dup
      //   142: invokespecial 71	java/lang/StringBuilder:<init>	()V
      //   145: aload_0
      //   146: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   149: ldc_w 334
      //   152: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   155: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   158: astore 4
      //   160: aload 4
      //   162: astore_0
      //   163: iload_2
      //   164: ifeq +24 -> 188
      //   167: new 70	java/lang/StringBuilder
      //   170: dup
      //   171: invokespecial 71	java/lang/StringBuilder:<init>	()V
      //   174: aload 4
      //   176: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   179: ldc 118
      //   181: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   184: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   187: astore_0
      //   188: aload 10
      //   190: aload_0
      //   191: iload_1
      //   192: invokestatic 127	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   195: invokevirtual 276	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   198: pop
      //   199: new 278	java/io/FileOutputStream
      //   202: dup
      //   203: aload 11
      //   205: invokespecial 279	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
      //   208: astore_0
      //   209: aload 10
      //   211: aload_0
      //   212: ldc_w 281
      //   215: invokevirtual 285	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
      //   218: aload_3
      //   219: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   222: aload_0
      //   223: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   226: iconst_0
      //   227: ireturn
      //   228: astore_3
      //   229: aconst_null
      //   230: astore_0
      //   231: aload 7
      //   233: astore 4
      //   235: aload_0
      //   236: astore 5
      //   238: new 70	java/lang/StringBuilder
      //   241: dup
      //   242: ldc 142
      //   244: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   247: aload 9
      //   249: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   252: ldc 144
      //   254: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   257: aload_3
      //   258: invokevirtual 147	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   261: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   264: pop
      //   265: aload_0
      //   266: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   269: aload 7
      //   271: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   274: iconst_0
      //   275: ireturn
      //   276: astore_0
      //   277: aconst_null
      //   278: astore_3
      //   279: aload 8
      //   281: astore 4
      //   283: aload_3
      //   284: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   287: aload 4
      //   289: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   292: aload_0
      //   293: athrow
      //   294: astore_0
      //   295: aload 5
      //   297: astore_3
      //   298: goto -15 -> 283
      //   301: astore_0
      //   302: aload 8
      //   304: astore 4
      //   306: goto -23 -> 283
      //   309: astore 5
      //   311: aload_0
      //   312: astore 4
      //   314: aload 5
      //   316: astore_0
      //   317: goto -34 -> 283
      //   320: astore_3
      //   321: aload 6
      //   323: astore_0
      //   324: goto -93 -> 231
      //   327: astore 4
      //   329: aload_3
      //   330: astore_0
      //   331: aload 4
      //   333: astore_3
      //   334: goto -103 -> 231
      //   337: astore 5
      //   339: aload_3
      //   340: astore 4
      //   342: aload 5
      //   344: astore_3
      //   345: aload_0
      //   346: astore 7
      //   348: aload 4
      //   350: astore_0
      //   351: goto -120 -> 231
      //   354: aconst_null
      //   355: astore_3
      //   356: goto -218 -> 138
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	359	0	paramString	String
      //   0	359	1	paramInt	int
      //   0	359	2	paramBoolean	boolean
      //   4	215	3	localObject1	Object
      //   228	30	3	localException1	Exception
      //   278	20	3	localObject2	Object
      //   320	10	3	localException2	Exception
      //   333	23	3	localObject3	Object
      //   80	233	4	localObject4	Object
      //   327	5	4	localException3	Exception
      //   340	9	4	localObject5	Object
      //   114	182	5	localObject6	Object
      //   309	6	5	localObject7	Object
      //   337	6	5	localException4	Exception
      //   107	215	6	localFileInputStream	java.io.FileInputStream
      //   6	341	7	localObject8	Object
      //   1	302	8	localObject9	Object
      //   14	234	9	str1	String
      //   69	141	10	localProperties	java.util.Properties
      //   60	144	11	str2	String
      // Exception table:
      //   from	to	target	type
      //   62	109	228	java/lang/Exception
      //   62	109	276	finally
      //   116	123	294	finally
      //   130	135	294	finally
      //   238	265	294	finally
      //   138	160	301	finally
      //   167	188	301	finally
      //   188	209	301	finally
      //   209	218	309	finally
      //   116	123	320	java/lang/Exception
      //   130	135	320	java/lang/Exception
      //   138	160	327	java/lang/Exception
      //   167	188	327	java/lang/Exception
      //   188	209	327	java/lang/Exception
      //   209	218	337	java/lang/Exception
    }
    
    public static byte[] b(int paramInt)
    {
      return new byte[] { (byte)(paramInt & 0xFF), (byte)((0xFF00 & paramInt) >> 8), (byte)((0xFF0000 & paramInt) >> 16), (byte)((0xFF000000 & paramInt) >> 24) };
    }
    
    public static byte[] b(byte[] paramArrayOfByte)
    {
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 2)) {}
      for (;;)
      {
        return paramArrayOfByte;
        int k = 0;
        int j = paramArrayOfByte.length - 1;
        while (k < j)
        {
          int i = paramArrayOfByte[k];
          paramArrayOfByte[k] = paramArrayOfByte[j];
          paramArrayOfByte[j] = i;
          k += 1;
          j -= 1;
        }
      }
    }
    
    public static String c()
    {
      b(com.tencent.mapsdk.rastercore.tile.a.a.a().c());
      return com.tencent.mapsdk.rastercore.tile.a.a.a().c() + "/frontier.dat";
    }
    
    /* Error */
    public static long d()
    {
      // Byte code:
      //   0: invokestatic 53	com/tencent/mapsdk/rastercore/tile/a/a:a	()Lcom/tencent/mapsdk/rastercore/tile/a/a;
      //   3: invokevirtual 57	com/tencent/mapsdk/rastercore/tile/a/a:c	()Ljava/lang/String;
      //   6: astore_2
      //   7: aload_2
      //   8: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   11: ifne +10 -> 21
      //   14: aload_2
      //   15: invokestatic 259	com/tencent/mapsdk/rastercore/d$a:b	(Ljava/lang/String;)Z
      //   18: ifne +7 -> 25
      //   21: ldc2_w 349
      //   24: lreturn
      //   25: new 70	java/lang/StringBuilder
      //   28: dup
      //   29: invokespecial 71	java/lang/StringBuilder:<init>	()V
      //   32: aload_2
      //   33: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   36: getstatic 81	java/io/File:separator	Ljava/lang/String;
      //   39: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   42: ldc 83
      //   44: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   47: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   50: astore_2
      //   51: new 103	java/util/Properties
      //   54: dup
      //   55: invokespecial 104	java/util/Properties:<init>	()V
      //   58: astore 5
      //   60: new 77	java/io/File
      //   63: dup
      //   64: aload_2
      //   65: invokespecial 89	java/io/File:<init>	(Ljava/lang/String;)V
      //   68: astore_3
      //   69: aload_3
      //   70: invokevirtual 93	java/io/File:exists	()Z
      //   73: ifeq +109 -> 182
      //   76: aload_3
      //   77: invokevirtual 96	java/io/File:isFile	()Z
      //   80: ifeq +102 -> 182
      //   83: new 98	java/io/FileInputStream
      //   86: dup
      //   87: aload_2
      //   88: invokespecial 270	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
      //   91: astore_3
      //   92: aload_3
      //   93: astore_2
      //   94: aload_3
      //   95: astore 4
      //   97: aload 5
      //   99: aload_3
      //   100: invokevirtual 108	java/util/Properties:load	(Ljava/io/InputStream;)V
      //   103: aload_3
      //   104: astore_2
      //   105: aload_3
      //   106: astore 4
      //   108: aload 5
      //   110: ldc_w 352
      //   113: ldc_w 354
      //   116: invokevirtual 131	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   119: invokestatic 360	java/lang/Long:parseLong	(Ljava/lang/String;)J
      //   122: lstore_0
      //   123: aload_3
      //   124: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   127: lload_0
      //   128: lreturn
      //   129: astore_3
      //   130: aconst_null
      //   131: astore 4
      //   133: aload 4
      //   135: astore_2
      //   136: new 70	java/lang/StringBuilder
      //   139: dup
      //   140: ldc_w 362
      //   143: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   146: aload_3
      //   147: invokevirtual 329	java/lang/Exception:toString	()Ljava/lang/String;
      //   150: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   153: pop
      //   154: aload 4
      //   156: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   159: ldc2_w 349
      //   162: lreturn
      //   163: astore_2
      //   164: aconst_null
      //   165: astore_2
      //   166: aload_2
      //   167: invokestatic 140	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
      //   170: ldc2_w 349
      //   173: lreturn
      //   174: astore_3
      //   175: goto -9 -> 166
      //   178: astore_3
      //   179: goto -46 -> 133
      //   182: aconst_null
      //   183: astore_3
      //   184: goto -81 -> 103
      // Local variable table:
      //   start	length	slot	name	signature
      //   122	6	0	l	long
      //   6	130	2	localObject1	Object
      //   163	1	2	localObject2	Object
      //   165	2	2	localCloseable	Closeable
      //   68	56	3	localObject3	Object
      //   129	18	3	localException1	Exception
      //   174	1	3	localObject4	Object
      //   178	1	3	localException2	Exception
      //   183	1	3	localObject5	Object
      //   95	60	4	localObject6	Object
      //   58	51	5	localProperties	java.util.Properties
      // Exception table:
      //   from	to	target	type
      //   51	92	129	java/lang/Exception
      //   51	92	163	finally
      //   97	103	174	finally
      //   108	123	174	finally
      //   136	154	174	finally
      //   97	103	178	java/lang/Exception
      //   108	123	178	java/lang/Exception
    }
    
    static final class a
    {
      public static final d.a a = new d.a();
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Bitmap paramBitmap);
  }
  
  static final class c
    extends AsyncTask<String, Void, d.d>
  {
    private d.b a;
    private int b;
    
    public c(d.b paramb, int paramInt)
    {
      this.a = paramb;
      this.b = paramInt;
    }
    
    /* Error */
    private d.d a(String... paramVarArgs)
    {
      // Byte code:
      //   0: new 32	com/tencent/mapsdk/rastercore/d$d
      //   3: dup
      //   4: iconst_0
      //   5: invokespecial 35	com/tencent/mapsdk/rastercore/d$d:<init>	(B)V
      //   8: astore 9
      //   10: aload_1
      //   11: ifnull +1160 -> 1171
      //   14: aload_1
      //   15: arraylength
      //   16: iconst_2
      //   17: if_icmpne +1154 -> 1171
      //   20: invokestatic 41	com/tencent/mapsdk/rastercore/d/e:y	()I
      //   23: putstatic 46	com/tencent/mapsdk/rastercore/b:e	I
      //   26: aload 9
      //   28: getstatic 46	com/tencent/mapsdk/rastercore/b:e	I
      //   31: putfield 48	com/tencent/mapsdk/rastercore/d$d:a	I
      //   34: aload 9
      //   36: invokestatic 51	com/tencent/mapsdk/rastercore/d/e:w	()I
      //   39: putfield 53	com/tencent/mapsdk/rastercore/d$d:c	I
      //   42: aload 9
      //   44: invokestatic 56	com/tencent/mapsdk/rastercore/d/e:u	()I
      //   47: putfield 59	com/tencent/mapsdk/rastercore/d$d:d	I
      //   50: aload 9
      //   52: invokestatic 62	com/tencent/mapsdk/rastercore/d/e:t	()I
      //   55: putfield 63	com/tencent/mapsdk/rastercore/d$d:e	I
      //   58: aload 9
      //   60: invokestatic 66	com/tencent/mapsdk/rastercore/d/e:s	()I
      //   63: putfield 69	com/tencent/mapsdk/rastercore/d$d:f	I
      //   66: getstatic 74	com/tencent/mapsdk/rastercore/d$a$a:a	Lcom/tencent/mapsdk/rastercore/d$a;
      //   69: astore 6
      //   71: aconst_null
      //   72: astore 6
      //   74: invokestatic 79	com/tencent/mapsdk/rastercore/d$a:c	()Ljava/lang/String;
      //   77: invokestatic 82	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/lang/String;)[B
      //   80: astore 7
      //   82: aload 7
      //   84: ifnull +1081 -> 1165
      //   87: new 84	java/lang/String
      //   90: dup
      //   91: aload 7
      //   93: ldc 86
      //   95: invokespecial 89	java/lang/String:<init>	([BLjava/lang/String;)V
      //   98: astore 7
      //   100: aload 7
      //   102: astore 6
      //   104: aload 6
      //   106: invokestatic 92	com/tencent/mapsdk/rastercore/d:a	(Ljava/lang/String;)Z
      //   109: ifne +1051 -> 1160
      //   112: aload 6
      //   114: invokestatic 95	com/tencent/mapsdk/rastercore/d:b	(Ljava/lang/String;)[Ljava/lang/String;
      //   117: astore 7
      //   119: aload 7
      //   121: iconst_0
      //   122: aaload
      //   123: invokestatic 92	com/tencent/mapsdk/rastercore/d:a	(Ljava/lang/String;)Z
      //   126: ifne +1029 -> 1155
      //   129: aload 7
      //   131: iconst_0
      //   132: aaload
      //   133: invokestatic 101	java/lang/Integer:parseInt	(Ljava/lang/String;)I
      //   136: istore_2
      //   137: iload_2
      //   138: istore_3
      //   139: aload 7
      //   141: iconst_1
      //   142: aaload
      //   143: invokestatic 92	com/tencent/mapsdk/rastercore/d:a	(Ljava/lang/String;)Z
      //   146: ifne +12 -> 158
      //   149: aload 7
      //   151: iconst_1
      //   152: aaload
      //   153: invokestatic 106	com/tencent/mapsdk/rastercore/c:a	(Ljava/lang/String;)V
      //   156: iload_2
      //   157: istore_3
      //   158: new 108	java/net/URL
      //   161: dup
      //   162: new 110	java/lang/StringBuilder
      //   165: dup
      //   166: invokespecial 111	java/lang/StringBuilder:<init>	()V
      //   169: aload_1
      //   170: iconst_0
      //   171: aaload
      //   172: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   175: ldc 117
      //   177: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   180: iload_3
      //   181: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   184: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   187: invokespecial 125	java/net/URL:<init>	(Ljava/lang/String;)V
      //   190: invokevirtual 129	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   193: checkcast 131	java/net/HttpURLConnection
      //   196: astore 7
      //   198: aload 7
      //   200: ldc 133
      //   202: ldc 135
      //   204: invokevirtual 139	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   207: aload 7
      //   209: invokevirtual 142	java/net/HttpURLConnection:getResponseCode	()I
      //   212: sipush 200
      //   215: if_icmpne +956 -> 1171
      //   218: aload 7
      //   220: ldc 144
      //   222: invokevirtual 148	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   225: astore 8
      //   227: aload 8
      //   229: ifnull +108 -> 337
      //   232: aload 8
      //   234: invokevirtual 151	java/lang/String:length	()I
      //   237: ifle +100 -> 337
      //   240: aload 8
      //   242: invokevirtual 154	java/lang/String:toLowerCase	()Ljava/lang/String;
      //   245: ldc 135
      //   247: invokevirtual 158	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   250: ifeq +87 -> 337
      //   253: iconst_1
      //   254: istore_2
      //   255: iload_2
      //   256: ifeq +86 -> 342
      //   259: new 160	java/util/zip/GZIPInputStream
      //   262: dup
      //   263: aload 7
      //   265: invokevirtual 164	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   268: invokespecial 167	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
      //   271: astore 7
      //   273: new 169	org/json/JSONObject
      //   276: dup
      //   277: new 84	java/lang/String
      //   280: dup
      //   281: aload 7
      //   283: invokestatic 172	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/InputStream;)[B
      //   286: invokespecial 175	java/lang/String:<init>	([B)V
      //   289: invokespecial 176	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   292: astore 7
      //   294: aload 7
      //   296: ldc 178
      //   298: invokevirtual 181	org/json/JSONObject:optInt	(Ljava/lang/String;)I
      //   301: istore_2
      //   302: iload_2
      //   303: ifeq +49 -> 352
      //   306: aload 9
      //   308: areturn
      //   309: astore 7
      //   311: new 110	java/lang/StringBuilder
      //   314: dup
      //   315: ldc 183
      //   317: invokespecial 184	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   320: aload 7
      //   322: invokevirtual 185	java/lang/Exception:toString	()Ljava/lang/String;
      //   325: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   328: pop
      //   329: aload 7
      //   331: invokevirtual 188	java/lang/Exception:printStackTrace	()V
      //   334: goto -230 -> 104
      //   337: iconst_0
      //   338: istore_2
      //   339: goto -84 -> 255
      //   342: aload 7
      //   344: invokevirtual 164	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   347: astore 7
      //   349: goto -76 -> 273
      //   352: aload 7
      //   354: ldc 190
      //   356: invokevirtual 194	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
      //   359: astore 10
      //   361: aload 10
      //   363: ifnonnull +6 -> 369
      //   366: aload 9
      //   368: areturn
      //   369: aload 10
      //   371: ldc 196
      //   373: invokevirtual 194	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
      //   376: astore 7
      //   378: aload 7
      //   380: ifnonnull +6 -> 386
      //   383: aload 9
      //   385: areturn
      //   386: aload 9
      //   388: aload 7
      //   390: ldc 198
      //   392: sipush 1000
      //   395: invokevirtual 201	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
      //   398: putfield 48	com/tencent/mapsdk/rastercore/d$d:a	I
      //   401: aload 9
      //   403: aload 7
      //   405: ldc 203
      //   407: iconst_0
      //   408: invokevirtual 201	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
      //   411: putfield 204	com/tencent/mapsdk/rastercore/d$d:b	I
      //   414: aload 7
      //   416: ldc 206
      //   418: getstatic 207	com/tencent/mapsdk/rastercore/b:a	I
      //   421: invokevirtual 201	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
      //   424: istore 4
      //   426: getstatic 74	com/tencent/mapsdk/rastercore/d$a$a:a	Lcom/tencent/mapsdk/rastercore/d$a;
      //   429: astore 7
      //   431: aload 9
      //   433: getfield 48	com/tencent/mapsdk/rastercore/d$d:a	I
      //   436: aload 9
      //   438: getfield 204	com/tencent/mapsdk/rastercore/d$d:b	I
      //   441: iload 4
      //   443: iconst_0
      //   444: invokestatic 210	com/tencent/mapsdk/rastercore/d$a:a	(IIIZ)Z
      //   447: pop
      //   448: getstatic 74	com/tencent/mapsdk/rastercore/d$a$a:a	Lcom/tencent/mapsdk/rastercore/d$a;
      //   451: astore 7
      //   453: aload_1
      //   454: iconst_1
      //   455: aaload
      //   456: aload 9
      //   458: getfield 48	com/tencent/mapsdk/rastercore/d$d:a	I
      //   461: iconst_0
      //   462: invokestatic 213	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/lang/String;IZ)Z
      //   465: pop
      //   466: getstatic 74	com/tencent/mapsdk/rastercore/d$a$a:a	Lcom/tencent/mapsdk/rastercore/d$a;
      //   469: astore 7
      //   471: aload_1
      //   472: iconst_1
      //   473: aaload
      //   474: aload 9
      //   476: getfield 204	com/tencent/mapsdk/rastercore/d$d:b	I
      //   479: iconst_0
      //   480: invokestatic 215	com/tencent/mapsdk/rastercore/d$a:b	(Ljava/lang/String;IZ)Z
      //   483: pop
      //   484: aload 10
      //   486: ldc 217
      //   488: invokevirtual 194	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
      //   491: astore 7
      //   493: aload 7
      //   495: ifnonnull +6 -> 501
      //   498: aload 9
      //   500: areturn
      //   501: aload 9
      //   503: aload 7
      //   505: ldc 198
      //   507: sipush 1000
      //   510: invokevirtual 201	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
      //   513: putfield 59	com/tencent/mapsdk/rastercore/d$d:d	I
      //   516: aload 9
      //   518: aload 7
      //   520: ldc 203
      //   522: iconst_0
      //   523: invokevirtual 201	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
      //   526: putfield 63	com/tencent/mapsdk/rastercore/d$d:e	I
      //   529: aload 7
      //   531: ldc 206
      //   533: getstatic 218	com/tencent/mapsdk/rastercore/b:b	I
      //   536: invokevirtual 201	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
      //   539: istore 5
      //   541: aload 7
      //   543: ldc 220
      //   545: invokevirtual 223	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
      //   548: astore 7
      //   550: new 225	java/io/File
      //   553: dup
      //   554: aload 9
      //   556: getfield 59	com/tencent/mapsdk/rastercore/d$d:d	I
      //   559: aload 9
      //   561: getfield 63	com/tencent/mapsdk/rastercore/d$d:e	I
      //   564: iload 5
      //   566: invokestatic 228	com/tencent/mapsdk/rastercore/d$a:a	(III)Ljava/lang/String;
      //   569: invokespecial 229	java/io/File:<init>	(Ljava/lang/String;)V
      //   572: invokevirtual 233	java/io/File:exists	()Z
      //   575: ifne +599 -> 1174
      //   578: iconst_1
      //   579: istore_2
      //   580: iload_2
      //   581: istore_3
      //   582: iload_2
      //   583: ifne +58 -> 641
      //   586: aload 9
      //   588: getfield 59	com/tencent/mapsdk/rastercore/d$d:d	I
      //   591: aload 9
      //   593: getfield 63	com/tencent/mapsdk/rastercore/d$d:e	I
      //   596: iload 5
      //   598: invokestatic 228	com/tencent/mapsdk/rastercore/d$a:a	(III)Ljava/lang/String;
      //   601: invokestatic 82	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/lang/String;)[B
      //   604: astore 8
      //   606: aload 8
      //   608: ifnull +17 -> 625
      //   611: aload 9
      //   613: aload 8
      //   615: iconst_0
      //   616: aload 8
      //   618: arraylength
      //   619: invokestatic 239	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
      //   622: putfield 243	com/tencent/mapsdk/rastercore/d$d:g	Landroid/graphics/Bitmap;
      //   625: aload 9
      //   627: getfield 243	com/tencent/mapsdk/rastercore/d$d:g	Landroid/graphics/Bitmap;
      //   630: astore 8
      //   632: iload_2
      //   633: istore_3
      //   634: aload 8
      //   636: ifnonnull +5 -> 641
      //   639: iconst_1
      //   640: istore_3
      //   641: iload_3
      //   642: ifeq +122 -> 764
      //   645: aload 7
      //   647: ifnull +117 -> 764
      //   650: aload 7
      //   652: invokevirtual 246	java/lang/String:trim	()Ljava/lang/String;
      //   655: invokevirtual 151	java/lang/String:length	()I
      //   658: istore_2
      //   659: iload_2
      //   660: ifle +104 -> 764
      //   663: aconst_null
      //   664: astore 8
      //   666: new 108	java/net/URL
      //   669: dup
      //   670: aload 7
      //   672: invokespecial 125	java/net/URL:<init>	(Ljava/lang/String;)V
      //   675: invokevirtual 129	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   678: checkcast 131	java/net/HttpURLConnection
      //   681: astore 7
      //   683: aload 7
      //   685: ldc 248
      //   687: invokevirtual 251	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
      //   690: aload 7
      //   692: sipush 5000
      //   695: invokevirtual 255	java/net/HttpURLConnection:setConnectTimeout	(I)V
      //   698: aload 7
      //   700: invokevirtual 142	java/net/HttpURLConnection:getResponseCode	()I
      //   703: sipush 200
      //   706: if_icmpne +48 -> 754
      //   709: aload 7
      //   711: invokevirtual 164	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   714: invokestatic 172	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/InputStream;)[B
      //   717: astore 8
      //   719: aload 9
      //   721: aload 8
      //   723: iconst_0
      //   724: aload 8
      //   726: arraylength
      //   727: invokestatic 239	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
      //   730: putfield 243	com/tencent/mapsdk/rastercore/d$d:g	Landroid/graphics/Bitmap;
      //   733: aload 8
      //   735: aload 9
      //   737: getfield 59	com/tencent/mapsdk/rastercore/d$d:d	I
      //   740: aload 9
      //   742: getfield 63	com/tencent/mapsdk/rastercore/d$d:e	I
      //   745: iload 5
      //   747: invokestatic 228	com/tencent/mapsdk/rastercore/d$a:a	(III)Ljava/lang/String;
      //   750: invokestatic 258	com/tencent/mapsdk/rastercore/d$a:a	([BLjava/lang/String;)Z
      //   753: pop
      //   754: aload 7
      //   756: ifnull +8 -> 764
      //   759: aload 7
      //   761: invokevirtual 261	java/net/HttpURLConnection:disconnect	()V
      //   764: aload 10
      //   766: ldc_w 263
      //   769: invokevirtual 194	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
      //   772: astore 7
      //   774: aload 7
      //   776: ifnull +149 -> 925
      //   779: aload 7
      //   781: ldc_w 265
      //   784: invokevirtual 223	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
      //   787: astore 7
      //   789: aload 7
      //   791: invokestatic 92	com/tencent/mapsdk/rastercore/d:a	(Ljava/lang/String;)Z
      //   794: ifne +131 -> 925
      //   797: new 108	java/net/URL
      //   800: dup
      //   801: aload 7
      //   803: invokespecial 125	java/net/URL:<init>	(Ljava/lang/String;)V
      //   806: invokevirtual 129	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   809: checkcast 131	java/net/HttpURLConnection
      //   812: astore 7
      //   814: aload 7
      //   816: ldc 248
      //   818: invokevirtual 251	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
      //   821: aload 7
      //   823: sipush 5000
      //   826: invokevirtual 255	java/net/HttpURLConnection:setConnectTimeout	(I)V
      //   829: aload 7
      //   831: invokevirtual 142	java/net/HttpURLConnection:getResponseCode	()I
      //   834: sipush 200
      //   837: if_icmpne +88 -> 925
      //   840: new 160	java/util/zip/GZIPInputStream
      //   843: dup
      //   844: aload 7
      //   846: invokevirtual 164	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   849: invokespecial 167	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
      //   852: invokestatic 172	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/InputStream;)[B
      //   855: invokestatic 79	com/tencent/mapsdk/rastercore/d$a:c	()Ljava/lang/String;
      //   858: invokestatic 258	com/tencent/mapsdk/rastercore/d$a:a	([BLjava/lang/String;)Z
      //   861: pop
      //   862: getstatic 74	com/tencent/mapsdk/rastercore/d$a$a:a	Lcom/tencent/mapsdk/rastercore/d$a;
      //   865: astore 7
      //   867: invokestatic 79	com/tencent/mapsdk/rastercore/d$a:c	()Ljava/lang/String;
      //   870: invokestatic 82	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/lang/String;)[B
      //   873: astore 7
      //   875: aload 7
      //   877: ifnull +16 -> 893
      //   880: new 84	java/lang/String
      //   883: dup
      //   884: aload 7
      //   886: ldc 86
      //   888: invokespecial 89	java/lang/String:<init>	([BLjava/lang/String;)V
      //   891: astore 6
      //   893: aload 6
      //   895: invokestatic 92	com/tencent/mapsdk/rastercore/d:a	(Ljava/lang/String;)Z
      //   898: ifne +27 -> 925
      //   901: aload 6
      //   903: invokestatic 95	com/tencent/mapsdk/rastercore/d:b	(Ljava/lang/String;)[Ljava/lang/String;
      //   906: astore 6
      //   908: aload 6
      //   910: iconst_1
      //   911: aaload
      //   912: invokestatic 92	com/tencent/mapsdk/rastercore/d:a	(Ljava/lang/String;)Z
      //   915: ifne +10 -> 925
      //   918: aload 6
      //   920: iconst_1
      //   921: aaload
      //   922: invokestatic 106	com/tencent/mapsdk/rastercore/c:a	(Ljava/lang/String;)V
      //   925: getstatic 74	com/tencent/mapsdk/rastercore/d$a$a:a	Lcom/tencent/mapsdk/rastercore/d$a;
      //   928: astore 6
      //   930: aload 9
      //   932: getfield 59	com/tencent/mapsdk/rastercore/d$d:d	I
      //   935: aload 9
      //   937: getfield 63	com/tencent/mapsdk/rastercore/d$d:e	I
      //   940: iload 5
      //   942: iconst_1
      //   943: invokestatic 210	com/tencent/mapsdk/rastercore/d$a:a	(IIIZ)Z
      //   946: pop
      //   947: getstatic 74	com/tencent/mapsdk/rastercore/d$a$a:a	Lcom/tencent/mapsdk/rastercore/d$a;
      //   950: astore 6
      //   952: aload_1
      //   953: iconst_1
      //   954: aaload
      //   955: aload 9
      //   957: getfield 59	com/tencent/mapsdk/rastercore/d$d:d	I
      //   960: iconst_1
      //   961: invokestatic 213	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/lang/String;IZ)Z
      //   964: pop
      //   965: getstatic 74	com/tencent/mapsdk/rastercore/d$a$a:a	Lcom/tencent/mapsdk/rastercore/d$a;
      //   968: astore 6
      //   970: aload_1
      //   971: iconst_1
      //   972: aaload
      //   973: aload 9
      //   975: getfield 63	com/tencent/mapsdk/rastercore/d$d:e	I
      //   978: iconst_1
      //   979: invokestatic 215	com/tencent/mapsdk/rastercore/d$a:b	(Ljava/lang/String;IZ)Z
      //   982: pop
      //   983: iload 4
      //   985: aload 9
      //   987: getfield 53	com/tencent/mapsdk/rastercore/d$d:c	I
      //   990: if_icmpeq +16 -> 1006
      //   993: new 10	com/tencent/mapsdk/rastercore/d$c$1
      //   996: dup
      //   997: aload_0
      //   998: iload 4
      //   1000: invokespecial 268	com/tencent/mapsdk/rastercore/d$c$1:<init>	(Lcom/tencent/mapsdk/rastercore/d$c;I)V
      //   1003: invokevirtual 271	com/tencent/mapsdk/rastercore/d$c$1:start	()V
      //   1006: aload 9
      //   1008: iload 4
      //   1010: putfield 53	com/tencent/mapsdk/rastercore/d$d:c	I
      //   1013: iload 5
      //   1015: invokestatic 66	com/tencent/mapsdk/rastercore/d/e:s	()I
      //   1018: if_icmpeq +16 -> 1034
      //   1021: new 12	com/tencent/mapsdk/rastercore/d$c$2
      //   1024: dup
      //   1025: aload_0
      //   1026: iload 5
      //   1028: invokespecial 272	com/tencent/mapsdk/rastercore/d$c$2:<init>	(Lcom/tencent/mapsdk/rastercore/d$c;I)V
      //   1031: invokevirtual 273	com/tencent/mapsdk/rastercore/d$c$2:start	()V
      //   1034: aload 9
      //   1036: iload 5
      //   1038: putfield 69	com/tencent/mapsdk/rastercore/d$d:f	I
      //   1041: goto +130 -> 1171
      //   1044: astore 8
      //   1046: new 110	java/lang/StringBuilder
      //   1049: dup
      //   1050: ldc_w 275
      //   1053: invokespecial 184	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1056: aload 8
      //   1058: invokevirtual 185	java/lang/Exception:toString	()Ljava/lang/String;
      //   1061: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1064: pop
      //   1065: iconst_1
      //   1066: istore_3
      //   1067: goto -426 -> 641
      //   1070: aload 7
      //   1072: ifnull -308 -> 764
      //   1075: aload 7
      //   1077: invokevirtual 261	java/net/HttpURLConnection:disconnect	()V
      //   1080: goto -316 -> 764
      //   1083: astore_1
      //   1084: new 110	java/lang/StringBuilder
      //   1087: dup
      //   1088: ldc_w 277
      //   1091: invokespecial 184	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1094: aload_1
      //   1095: invokevirtual 280	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   1098: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1101: pop
      //   1102: goto +69 -> 1171
      //   1105: astore_1
      //   1106: aload 8
      //   1108: astore 7
      //   1110: aload 7
      //   1112: ifnull +8 -> 1120
      //   1115: aload 7
      //   1117: invokevirtual 261	java/net/HttpURLConnection:disconnect	()V
      //   1120: aload_1
      //   1121: athrow
      //   1122: astore 6
      //   1124: new 110	java/lang/StringBuilder
      //   1127: dup
      //   1128: ldc_w 282
      //   1131: invokespecial 184	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1134: aload 6
      //   1136: invokevirtual 185	java/lang/Exception:toString	()Ljava/lang/String;
      //   1139: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1142: pop
      //   1143: goto -218 -> 925
      //   1146: astore_1
      //   1147: goto -37 -> 1110
      //   1150: astore 8
      //   1152: goto -82 -> 1070
      //   1155: iconst_0
      //   1156: istore_2
      //   1157: goto -1020 -> 137
      //   1160: iconst_0
      //   1161: istore_3
      //   1162: goto -1004 -> 158
      //   1165: aconst_null
      //   1166: astore 6
      //   1168: goto -1064 -> 104
      //   1171: aload 9
      //   1173: areturn
      //   1174: iconst_0
      //   1175: istore_2
      //   1176: goto -596 -> 580
      //   1179: astore 7
      //   1181: aconst_null
      //   1182: astore 7
      //   1184: goto -114 -> 1070
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1187	0	this	c
      //   0	1187	1	paramVarArgs	String[]
      //   136	1040	2	i	int
      //   138	1024	3	j	int
      //   424	585	4	k	int
      //   539	498	5	m	int
      //   69	900	6	localObject1	Object
      //   1122	13	6	localException1	Exception
      //   1166	1	6	localObject2	Object
      //   80	215	7	localObject3	Object
      //   309	34	7	localException2	Exception
      //   347	769	7	localObject4	Object
      //   1179	1	7	localException3	Exception
      //   1182	1	7	localObject5	Object
      //   225	509	8	localObject6	Object
      //   1044	63	8	localException4	Exception
      //   1150	1	8	localException5	Exception
      //   8	1164	9	locald	d.d
      //   359	406	10	localJSONObject	JSONObject
      // Exception table:
      //   from	to	target	type
      //   74	82	309	java/lang/Exception
      //   87	100	309	java/lang/Exception
      //   611	625	1044	java/lang/Exception
      //   625	632	1044	java/lang/Exception
      //   158	227	1083	java/lang/Exception
      //   232	253	1083	java/lang/Exception
      //   259	273	1083	java/lang/Exception
      //   273	302	1083	java/lang/Exception
      //   342	349	1083	java/lang/Exception
      //   352	361	1083	java/lang/Exception
      //   369	378	1083	java/lang/Exception
      //   386	493	1083	java/lang/Exception
      //   501	578	1083	java/lang/Exception
      //   586	606	1083	java/lang/Exception
      //   650	659	1083	java/lang/Exception
      //   759	764	1083	java/lang/Exception
      //   925	1006	1083	java/lang/Exception
      //   1006	1034	1083	java/lang/Exception
      //   1034	1041	1083	java/lang/Exception
      //   1046	1065	1083	java/lang/Exception
      //   1075	1080	1083	java/lang/Exception
      //   1115	1120	1083	java/lang/Exception
      //   1120	1122	1083	java/lang/Exception
      //   1124	1143	1083	java/lang/Exception
      //   666	683	1105	finally
      //   764	774	1122	java/lang/Exception
      //   779	875	1122	java/lang/Exception
      //   880	893	1122	java/lang/Exception
      //   893	925	1122	java/lang/Exception
      //   683	754	1146	finally
      //   683	754	1150	java/lang/Exception
      //   666	683	1179	java/lang/Exception
    }
  }
  
  static final class d
  {
    public int a = 1000;
    public int b = 0;
    public int c = b.a;
    public int d = 1000;
    public int e = 0;
    public int f = b.b;
    public Bitmap g = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.d
 * JD-Core Version:    0.7.0.1
 */