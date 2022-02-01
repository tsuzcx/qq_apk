package com.tencent.map.lib.autoconfig;

import android.util.Log;
import com.tencent.map.sdk.a.fz;
import com.tencent.map.sdk.a.hz;
import com.tencent.map.sdk.a.jg;
import com.tencent.map.sdk.a.jg.a;
import com.tencent.map.sdk.a.jg.c;
import com.tencent.map.sdk.a.jg.d;
import com.tencent.map.sdk.a.k;
import com.tencent.map.sdk.a.ln;
import com.tencent.map.sdk.a.ng;
import com.tencent.map.sdk.a.nl;
import com.tencent.map.sdk.a.oo;
import com.tencent.map.sdk.a.or;
import com.tencent.map.sdk.a.ou;
import com.tencent.map.sdk.a.pt;
import com.tencent.map.sdk.service.MapServiceManager;
import com.tencent.map.sdk.service.protocol.jce.conf.CSFileUpdateReq;
import com.tencent.map.sdk.service.protocol.jce.conf.FileUpdateReq;
import com.tencent.map.sdk.service.protocol.jce.conf.FileUpdateRsp;
import com.tencent.map.sdk.service.protocol.jce.conf.SCFileUpdateRsp;
import com.tencent.map.sdk.service.protocol.request.MapDataRequest;
import com.tencent.map.tools.net.NetResponse;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class ConfigFileDownloader
{
  private WeakReference<hz> a;
  private List<FileUpdateReq> b;
  private String c;
  private String d;
  private String e;
  private int f;
  
  private jg.c a(FileUpdateRsp paramFileUpdateRsp, String paramString, boolean paramBoolean)
  {
    if (paramFileUpdateRsp.iFileUpdated != 1) {
      return null;
    }
    String str = paramFileUpdateRsp.sName;
    Object localObject;
    if (str.equals("mapconfig")) {
      localObject = "mapconfig.dat";
    }
    for (;;)
    {
      paramString = new File(paramString + (String)localObject);
      localObject = a(paramFileUpdateRsp.sUpdateUrl, paramString);
      if (localObject == null) {
        break;
      }
      ((jg.c)localObject).a = paramFileUpdateRsp.sName;
      return localObject;
      if ((str.equals("indoormap_config")) || (str.equals("indoormap_config_premium")))
      {
        localObject = "indoormap_config.dat";
      }
      else if (str.equals("indoorpoi_icon_3d"))
      {
        localObject = "poi_icon_indoor_ex@2x.png";
      }
      else if (str.equals("closedroadstyle_normalmode"))
      {
        localObject = "style_normalmode.xml";
      }
      else
      {
        localObject = str;
        if (str.equals("closedroadstyle_trafficmode")) {
          localObject = "style_trafficmode.xml";
        }
      }
    }
    try
    {
      localObject = ou.a(paramString);
      if (!paramFileUpdateRsp.sMd5.equals(localObject))
      {
        paramString = new jg.c();
        paramString.a = paramFileUpdateRsp.sName;
        paramString.c = paramFileUpdateRsp.sMd5;
        paramString.d = ((String)localObject);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      or.b(paramString.getMessage());
      paramString = new jg.c();
      paramString.a = paramFileUpdateRsp.sName;
      return paramString;
    }
    if (paramBoolean) {}
    try
    {
      oo.a(paramString, paramString.getParent());
      paramString.delete();
      if ((this.a != null) && (this.a.get() != null)) {
        ((hz)this.a.get()).a = true;
      }
      return null;
    }
    catch (Throwable paramString)
    {
      or.b(paramString.getMessage());
      paramString = new jg.c();
      paramString.a = paramFileUpdateRsp.sName;
    }
    return paramString;
  }
  
  /* Error */
  private static jg.c a(String paramString, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: sipush 200
    //   6: istore_3
    //   7: iload_3
    //   8: istore_2
    //   9: new 136	java/net/URL
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 137	java/net/URL:<init>	(Ljava/lang/String;)V
    //   17: invokevirtual 141	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   20: checkcast 143	java/net/HttpURLConnection
    //   23: astore 5
    //   25: iload_3
    //   26: istore_2
    //   27: aload 5
    //   29: invokevirtual 147	java/net/HttpURLConnection:getResponseCode	()I
    //   32: istore_3
    //   33: iload_3
    //   34: istore_2
    //   35: aload 5
    //   37: invokevirtual 151	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   40: astore_0
    //   41: aload_1
    //   42: invokevirtual 154	java/io/File:exists	()Z
    //   45: ifne +25 -> 70
    //   48: aload_1
    //   49: invokevirtual 158	java/io/File:getParentFile	()Ljava/io/File;
    //   52: astore 6
    //   54: aload 6
    //   56: ifnull +9 -> 65
    //   59: aload 6
    //   61: invokevirtual 161	java/io/File:mkdirs	()Z
    //   64: pop
    //   65: aload_1
    //   66: invokevirtual 164	java/io/File:createNewFile	()Z
    //   69: pop
    //   70: new 166	java/io/FileOutputStream
    //   73: dup
    //   74: aload_1
    //   75: iconst_0
    //   76: invokespecial 169	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   79: astore_1
    //   80: aload_0
    //   81: aload_1
    //   82: invokestatic 174	com/tencent/map/sdk/a/on:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   85: pop2
    //   86: aload 5
    //   88: invokevirtual 177	java/net/HttpURLConnection:disconnect	()V
    //   91: aload_0
    //   92: invokestatic 180	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   95: aload_1
    //   96: invokestatic 180	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   99: aconst_null
    //   100: areturn
    //   101: astore 4
    //   103: aconst_null
    //   104: astore_1
    //   105: aconst_null
    //   106: astore_0
    //   107: aload 4
    //   109: invokestatic 186	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   112: invokestatic 108	com/tencent/map/sdk/a/or:b	(Ljava/lang/String;)V
    //   115: new 68	com/tencent/map/sdk/a/jg$c
    //   118: dup
    //   119: invokespecial 97	com/tencent/map/sdk/a/jg$c:<init>	()V
    //   122: astore 4
    //   124: aload 4
    //   126: iload_2
    //   127: putfield 188	com/tencent/map/sdk/a/jg$c:f	I
    //   130: aload_1
    //   131: invokestatic 180	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   134: aload_0
    //   135: invokestatic 180	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   138: aload 4
    //   140: areturn
    //   141: astore_1
    //   142: aconst_null
    //   143: astore_0
    //   144: aload_0
    //   145: invokestatic 180	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   148: aload 4
    //   150: invokestatic 180	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   153: aload_1
    //   154: athrow
    //   155: astore_1
    //   156: goto -12 -> 144
    //   159: astore 5
    //   161: aload_1
    //   162: astore 4
    //   164: aload 5
    //   166: astore_1
    //   167: goto -23 -> 144
    //   170: astore 4
    //   172: aload_1
    //   173: astore 5
    //   175: aload 4
    //   177: astore_1
    //   178: aload_0
    //   179: astore 4
    //   181: aload 5
    //   183: astore_0
    //   184: goto -40 -> 144
    //   187: astore 4
    //   189: aload_0
    //   190: astore_1
    //   191: iload_3
    //   192: istore_2
    //   193: aconst_null
    //   194: astore_0
    //   195: goto -88 -> 107
    //   198: astore 4
    //   200: iload_3
    //   201: istore_2
    //   202: aload_0
    //   203: astore 5
    //   205: aload_1
    //   206: astore_0
    //   207: aload 5
    //   209: astore_1
    //   210: goto -103 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	paramString	String
    //   0	213	1	paramFile	File
    //   8	194	2	i	int
    //   6	195	3	j	int
    //   1	1	4	localObject1	Object
    //   101	7	4	localException1	Exception
    //   122	41	4	localObject2	Object
    //   170	6	4	localObject3	Object
    //   179	1	4	str	String
    //   187	1	4	localException2	Exception
    //   198	1	4	localException3	Exception
    //   23	64	5	localHttpURLConnection	java.net.HttpURLConnection
    //   159	6	5	localObject4	Object
    //   173	35	5	localObject5	Object
    //   52	8	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   9	25	101	java/lang/Exception
    //   27	33	101	java/lang/Exception
    //   35	41	101	java/lang/Exception
    //   9	25	141	finally
    //   27	33	141	finally
    //   35	41	141	finally
    //   41	54	155	finally
    //   59	65	155	finally
    //   65	70	155	finally
    //   70	80	155	finally
    //   80	91	159	finally
    //   107	130	170	finally
    //   41	54	187	java/lang/Exception
    //   59	65	187	java/lang/Exception
    //   65	70	187	java/lang/Exception
    //   70	80	187	java/lang/Exception
    //   80	91	198	java/lang/Exception
  }
  
  private FileUpdateReq a(String paramString)
  {
    if ((this.b == null) || (this.b.isEmpty())) {
      return null;
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      FileUpdateReq localFileUpdateReq = (FileUpdateReq)localIterator.next();
      if (nl.a(localFileUpdateReq.sName, paramString)) {
        return localFileUpdateReq;
      }
    }
    return null;
  }
  
  private List<FileUpdateRsp> a(CSFileUpdateReq paramCSFileUpdateReq)
  {
    try
    {
      paramCSFileUpdateReq = ((MapDataRequest)((ng)MapServiceManager.getService(ng.class)).c()).configFileUpdate("4.2.8", fz.a(), fz.d, fz.b(), this.e, paramCSFileUpdateReq.toByteArray("UTF-8"));
      if ((paramCSFileUpdateReq != null) && (paramCSFileUpdateReq.data != null))
      {
        paramCSFileUpdateReq = new k(paramCSFileUpdateReq.data);
        paramCSFileUpdateReq.a("UTF-8");
        SCFileUpdateRsp localSCFileUpdateRsp = new SCFileUpdateRsp();
        localSCFileUpdateRsp.readFrom(paramCSFileUpdateReq);
        if (localSCFileUpdateRsp.iRet == 0)
        {
          paramCSFileUpdateReq = localSCFileUpdateRsp.vItems;
          return paramCSFileUpdateReq;
        }
        return null;
      }
    }
    catch (Exception paramCSFileUpdateReq)
    {
      or.b(Log.getStackTraceString(paramCSFileUpdateReq));
      return null;
    }
    return null;
  }
  
  private void a(jg.c paramc)
  {
    Object localObject1;
    if (this.a != null)
    {
      localObject1 = (hz)this.a.get();
      if (localObject1 != null) {
        break label23;
      }
    }
    label259:
    for (;;)
    {
      return;
      label23:
      localObject1 = (List)hz.b.get(((hz)localObject1).a());
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = (WeakReference[])((List)localObject1).toArray(new WeakReference[((List)localObject1).size()]))
      {
        if (localObject1 == null) {
          break label259;
        }
        int i = 0;
        for (;;)
        {
          if (i >= localObject1.length) {
            break label237;
          }
          if (localObject1[i] != null)
          {
            Object localObject2 = (ln)localObject1[i].get();
            if ((localObject2 != null) && (((ln)localObject2).b != null) && (((ln)localObject2).b.az != null))
            {
              localObject2 = ((ln)localObject2).b.aF;
              if ((localObject2 == null) || (((jg)localObject2).c == null)) {
                break;
              }
              paramc.b -= ((jg)localObject2).a;
              if (((jg)localObject2).c.f == null) {
                ((jg)localObject2).c.f = new jg.a();
              }
              if (((jg)localObject2).c.f.a == null) {
                ((jg)localObject2).c.f.a = new CopyOnWriteArraySet();
              }
              if (((jg)localObject2).c.f.a.size() <= 9) {
                ((jg)localObject2).c.f.a.add(paramc);
              }
            }
          }
          i += 1;
        }
        label237:
        break;
      }
    }
  }
  
  public List<FileUpdateRsp> downloadMapConfig(String paramString1, String paramString2, String paramString3, CSFileUpdateReq paramCSFileUpdateReq, hz paramhz)
  {
    if ((paramCSFileUpdateReq == null) || (paramhz == null)) {
      return null;
    }
    this.b = paramCSFileUpdateReq.vItems;
    this.c = paramString1;
    this.d = paramString2;
    this.a = new WeakReference(paramhz);
    this.e = paramString3;
    paramString2 = a(paramCSFileUpdateReq);
    if ((paramString2 == null) || (paramString2.isEmpty())) {
      return null;
    }
    this.f = paramString2.size();
    paramString3 = paramString2.iterator();
    while (paramString3.hasNext())
    {
      paramString1 = (FileUpdateRsp)paramString3.next();
      if ((paramString1 == null) || (paramString1.iRet != 0))
      {
        paramString1 = null;
        label120:
        if (paramString1 == null) {
          break label641;
        }
        paramString2 = a(paramString1.a);
        if (paramString2 == null) {
          break label633;
        }
      }
      label260:
      label633:
      for (paramString1.e = paramString2.iVersion;; paramString1.e = -1)
      {
        paramString1.b = System.currentTimeMillis();
        a(paramString1);
        return null;
        paramCSFileUpdateReq = paramString1.sName;
        int i;
        switch (paramCSFileUpdateReq.hashCode())
        {
        default: 
          i = -1;
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            paramString1 = null;
            break label120;
            if (!paramCSFileUpdateReq.equals("mapconfig")) {
              break label260;
            }
            i = 0;
            continue;
            if (!paramCSFileUpdateReq.equals("poi_icon")) {
              break label260;
            }
            i = 1;
            continue;
            if (!paramCSFileUpdateReq.equals("map_icon")) {
              break label260;
            }
            i = 2;
            continue;
            if (!paramCSFileUpdateReq.equals("rtt_config.json")) {
              break label260;
            }
            i = 3;
            continue;
            if (!paramCSFileUpdateReq.equals("closedroadstyle_normalmode")) {
              break label260;
            }
            i = 4;
            continue;
            if (!paramCSFileUpdateReq.equals("closedroadstyle_trafficmode")) {
              break label260;
            }
            i = 5;
            continue;
            if (!paramCSFileUpdateReq.equals("indoormap_config_premium")) {
              break label260;
            }
            i = 6;
            continue;
            if (!paramCSFileUpdateReq.equals("indoormap_config")) {
              break label260;
            }
            i = 7;
            continue;
            if (!paramCSFileUpdateReq.equals("indoorpoi_icon_3d")) {
              break label260;
            }
            i = 8;
            continue;
            if (!paramCSFileUpdateReq.equals("sdk_offline_city_ver.json")) {
              break label260;
            }
            i = 9;
          }
        }
        paramString1 = a(paramString1, this.c, false);
        break;
        paramString1 = a(paramString1, this.c, true);
        break;
        paramString1 = a(paramString1, this.d, true);
        break;
        paramString1 = a(paramString1, this.c, false);
        break;
        paramString1 = a(paramString1, this.c, false);
        break;
        paramString1 = a(paramString1, this.c, false);
        break;
        paramString1 = a(paramString1, this.c, false);
        break;
        paramString1 = a(paramString1, this.c, false);
        break;
        paramString1 = a(paramString1, this.c, false);
        break;
        paramString1 = a(paramString1, this.c, false);
        break;
      }
      label641:
      this.f -= 1;
    }
    if (this.f != 0) {
      return null;
    }
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.lib.autoconfig.ConfigFileDownloader
 * JD-Core Version:    0.7.0.1
 */