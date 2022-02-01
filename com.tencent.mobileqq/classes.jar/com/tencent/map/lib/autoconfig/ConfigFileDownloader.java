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
    Object localObject2 = paramFileUpdateRsp.sName;
    if (((String)localObject2).equals("mapconfig")) {
      localObject1 = "mapconfig.dat";
    } else if ((!((String)localObject2).equals("indoormap_config")) && (!((String)localObject2).equals("indoormap_config_premium")))
    {
      if (((String)localObject2).equals("indoorpoi_icon_3d"))
      {
        localObject1 = "poi_icon_indoor_ex@2x.png";
      }
      else if (((String)localObject2).equals("closedroadstyle_normalmode"))
      {
        localObject1 = "style_normalmode.xml";
      }
      else
      {
        localObject1 = localObject2;
        if (((String)localObject2).equals("closedroadstyle_trafficmode")) {
          localObject1 = "style_trafficmode.xml";
        }
      }
    }
    else {
      localObject1 = "indoormap_config.dat";
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append((String)localObject1);
    paramString = new File(((StringBuilder)localObject2).toString());
    Object localObject1 = a(paramFileUpdateRsp.sUpdateUrl, paramString);
    if (localObject1 != null)
    {
      ((jg.c)localObject1).a = paramFileUpdateRsp.sName;
      return localObject1;
    }
    try
    {
      localObject1 = ou.a(paramString);
      if (!paramFileUpdateRsp.sMd5.equals(localObject1))
      {
        paramString = new jg.c();
        paramString.a = paramFileUpdateRsp.sName;
        paramString.c = paramFileUpdateRsp.sMd5;
        paramString.d = ((String)localObject1);
        return paramString;
      }
      if (paramBoolean) {
        try
        {
          oo.a(paramString, paramString.getParent());
          paramString.delete();
        }
        catch (Throwable paramString)
        {
          or.b(paramString.getMessage());
          paramString = new jg.c();
          paramString.a = paramFileUpdateRsp.sName;
          return paramString;
        }
      }
      paramFileUpdateRsp = this.a;
      if ((paramFileUpdateRsp != null) && (paramFileUpdateRsp.get() != null)) {
        ((hz)this.a.get()).a = true;
      }
      return null;
    }
    catch (Exception paramString)
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
    //   3: aconst_null
    //   4: astore 6
    //   6: sipush 200
    //   9: istore_3
    //   10: iload_3
    //   11: istore_2
    //   12: new 136	java/net/URL
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 137	java/net/URL:<init>	(Ljava/lang/String;)V
    //   20: invokevirtual 141	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   23: checkcast 143	java/net/HttpURLConnection
    //   26: astore_0
    //   27: iload_3
    //   28: istore_2
    //   29: aload_0
    //   30: invokevirtual 147	java/net/HttpURLConnection:getResponseCode	()I
    //   33: istore_3
    //   34: iload_3
    //   35: istore_2
    //   36: aload_0
    //   37: invokevirtual 151	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   40: astore 5
    //   42: aload_1
    //   43: invokevirtual 154	java/io/File:exists	()Z
    //   46: ifne +25 -> 71
    //   49: aload_1
    //   50: invokevirtual 158	java/io/File:getParentFile	()Ljava/io/File;
    //   53: astore 4
    //   55: aload 4
    //   57: ifnull +9 -> 66
    //   60: aload 4
    //   62: invokevirtual 161	java/io/File:mkdirs	()Z
    //   65: pop
    //   66: aload_1
    //   67: invokevirtual 164	java/io/File:createNewFile	()Z
    //   70: pop
    //   71: new 166	java/io/FileOutputStream
    //   74: dup
    //   75: aload_1
    //   76: iconst_0
    //   77: invokespecial 169	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   80: astore_1
    //   81: aload 5
    //   83: aload_1
    //   84: invokestatic 174	com/tencent/map/sdk/a/on:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   87: pop2
    //   88: aload_0
    //   89: invokevirtual 177	java/net/HttpURLConnection:disconnect	()V
    //   92: aload 5
    //   94: invokestatic 180	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   97: aload_1
    //   98: invokestatic 180	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   101: aconst_null
    //   102: areturn
    //   103: astore_0
    //   104: aload_1
    //   105: astore 4
    //   107: goto +12 -> 119
    //   110: astore 4
    //   112: goto +20 -> 132
    //   115: astore_0
    //   116: aconst_null
    //   117: astore 4
    //   119: aload 5
    //   121: astore_1
    //   122: aload_0
    //   123: astore 5
    //   125: goto +76 -> 201
    //   128: astore 4
    //   130: aconst_null
    //   131: astore_1
    //   132: aload 5
    //   134: astore_0
    //   135: iload_3
    //   136: istore_2
    //   137: goto +23 -> 160
    //   140: astore 5
    //   142: aconst_null
    //   143: astore_0
    //   144: aload 4
    //   146: astore_1
    //   147: aload_0
    //   148: astore 4
    //   150: goto +51 -> 201
    //   153: astore 4
    //   155: aconst_null
    //   156: astore_1
    //   157: aload 6
    //   159: astore_0
    //   160: aload 4
    //   162: invokestatic 186	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   165: invokestatic 120	com/tencent/map/sdk/a/or:b	(Ljava/lang/String;)V
    //   168: new 86	com/tencent/map/sdk/a/jg$c
    //   171: dup
    //   172: invokespecial 97	com/tencent/map/sdk/a/jg$c:<init>	()V
    //   175: astore 4
    //   177: aload 4
    //   179: iload_2
    //   180: putfield 188	com/tencent/map/sdk/a/jg$c:f	I
    //   183: aload_0
    //   184: invokestatic 180	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   187: aload_1
    //   188: invokestatic 180	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   191: aload 4
    //   193: areturn
    //   194: astore 5
    //   196: aload_1
    //   197: astore 4
    //   199: aload_0
    //   200: astore_1
    //   201: aload_1
    //   202: invokestatic 180	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   205: aload 4
    //   207: invokestatic 180	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   210: aload 5
    //   212: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	paramString	String
    //   0	213	1	paramFile	File
    //   11	169	2	i	int
    //   9	127	3	j	int
    //   1	105	4	localFile	File
    //   110	1	4	localException1	Exception
    //   117	1	4	localObject1	Object
    //   128	17	4	localException2	Exception
    //   148	1	4	str	String
    //   153	8	4	localException3	Exception
    //   175	31	4	localObject2	Object
    //   40	93	5	localObject3	Object
    //   140	1	5	localObject4	Object
    //   194	17	5	localObject5	Object
    //   4	154	6	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   81	92	103	finally
    //   81	92	110	java/lang/Exception
    //   42	55	115	finally
    //   60	66	115	finally
    //   66	71	115	finally
    //   71	81	115	finally
    //   42	55	128	java/lang/Exception
    //   60	66	128	java/lang/Exception
    //   66	71	128	java/lang/Exception
    //   71	81	128	java/lang/Exception
    //   12	27	140	finally
    //   29	34	140	finally
    //   36	42	140	finally
    //   12	27	153	java/lang/Exception
    //   29	34	153	java/lang/Exception
    //   36	42	153	java/lang/Exception
    //   160	183	194	finally
  }
  
  private FileUpdateReq a(String paramString)
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return null;
      }
      localObject = this.b.iterator();
      while (((Iterator)localObject).hasNext())
      {
        FileUpdateReq localFileUpdateReq = (FileUpdateReq)((Iterator)localObject).next();
        if (nl.a(localFileUpdateReq.sName, paramString)) {
          return localFileUpdateReq;
        }
      }
    }
    return null;
  }
  
  private List<FileUpdateRsp> a(CSFileUpdateReq paramCSFileUpdateReq)
  {
    try
    {
      paramCSFileUpdateReq = ((MapDataRequest)((ng)MapServiceManager.getService(ng.class)).c()).configFileUpdate("4.2.8", fz.a(), fz.d, fz.b(), this.e, paramCSFileUpdateReq.toByteArray("UTF-8"));
      if (paramCSFileUpdateReq != null)
      {
        if (paramCSFileUpdateReq.data == null) {
          return null;
        }
        paramCSFileUpdateReq = new k(paramCSFileUpdateReq.data);
        paramCSFileUpdateReq.a("UTF-8");
        SCFileUpdateRsp localSCFileUpdateRsp = new SCFileUpdateRsp();
        localSCFileUpdateRsp.readFrom(paramCSFileUpdateReq);
        if (localSCFileUpdateRsp.iRet == 0)
        {
          paramCSFileUpdateReq = localSCFileUpdateRsp.vItems;
          return paramCSFileUpdateReq;
        }
      }
      return null;
    }
    catch (Exception paramCSFileUpdateReq)
    {
      or.b(Log.getStackTraceString(paramCSFileUpdateReq));
    }
    return null;
  }
  
  private void a(jg.c paramc)
  {
    Object localObject1 = this.a;
    if (localObject1 != null)
    {
      localObject1 = (hz)((WeakReference)localObject1).get();
      if (localObject1 == null) {
        return;
      }
      localObject1 = (List)hz.b.get(((hz)localObject1).a());
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = (WeakReference[])((List)localObject1).toArray(new WeakReference[((List)localObject1).size()]);
      }
      if (localObject1 == null) {
        return;
      }
      int i = 0;
      while (i < localObject1.length)
      {
        if (localObject1[i] != null)
        {
          Object localObject2 = (ln)localObject1[i].get();
          if ((localObject2 != null) && (((ln)localObject2).b != null) && (((ln)localObject2).b.az != null))
          {
            localObject2 = ((ln)localObject2).b.aF;
            if (localObject2 != null)
            {
              if (((jg)localObject2).c == null) {
                return;
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
            else
            {
              return;
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public List<FileUpdateRsp> downloadMapConfig(String paramString1, String paramString2, String paramString3, CSFileUpdateReq paramCSFileUpdateReq, hz paramhz)
  {
    if (paramCSFileUpdateReq != null)
    {
      if (paramhz == null) {
        return null;
      }
      this.b = paramCSFileUpdateReq.vItems;
      this.c = paramString1;
      this.d = paramString2;
      this.a = new WeakReference(paramhz);
      this.e = paramString3;
      paramString2 = a(paramCSFileUpdateReq);
      if (paramString2 != null)
      {
        if (paramString2.isEmpty()) {
          return null;
        }
        this.f = paramString2.size();
        paramString3 = paramString2.iterator();
        while (paramString3.hasNext())
        {
          paramString1 = (FileUpdateRsp)paramString3.next();
          if ((paramString1 != null) && (paramString1.iRet == 0))
          {
            paramCSFileUpdateReq = paramString1.sName;
            switch (paramCSFileUpdateReq.hashCode())
            {
            default: 
              break;
            case 1590879768: 
              if (paramCSFileUpdateReq.equals("indoormap_config")) {
                i = 7;
              }
              break;
            case 1366209438: 
              if (paramCSFileUpdateReq.equals("mapconfig")) {
                i = 0;
              }
              break;
            case 1221876167: 
              if (paramCSFileUpdateReq.equals("rtt_config.json")) {
                i = 3;
              }
              break;
            case 1217119024: 
              if (paramCSFileUpdateReq.equals("indoormap_config_premium")) {
                i = 6;
              }
              break;
            case 451944782: 
              if (paramCSFileUpdateReq.equals("poi_icon")) {
                i = 1;
              }
              break;
            case 178735484: 
              if (paramCSFileUpdateReq.equals("map_icon")) {
                i = 2;
              }
              break;
            case -752505210: 
              if (paramCSFileUpdateReq.equals("closedroadstyle_trafficmode")) {
                i = 5;
              }
              break;
            case -810824476: 
              if (paramCSFileUpdateReq.equals("closedroadstyle_normalmode")) {
                i = 4;
              }
              break;
            case -1319508241: 
              if (paramCSFileUpdateReq.equals("indoorpoi_icon_3d")) {
                i = 8;
              }
              break;
            case -2042251002: 
              if (paramCSFileUpdateReq.equals("sdk_offline_city_ver.json")) {
                i = 9;
              }
              break;
            }
            int i = -1;
            switch (i)
            {
            default: 
              break;
            case 9: 
              paramString1 = a(paramString1, this.c, false);
              break;
            case 8: 
              paramString1 = a(paramString1, this.c, false);
              break;
            case 7: 
              paramString1 = a(paramString1, this.c, false);
              break;
            case 6: 
              paramString1 = a(paramString1, this.c, false);
              break;
            case 5: 
              paramString1 = a(paramString1, this.c, false);
              break;
            case 4: 
              paramString1 = a(paramString1, this.c, false);
              break;
            case 3: 
              paramString1 = a(paramString1, this.c, false);
              break;
            case 2: 
              paramString1 = a(paramString1, this.d, true);
              break;
            case 1: 
              paramString1 = a(paramString1, this.c, true);
              break;
            case 0: 
              paramString1 = a(paramString1, this.c, false);
              break;
            }
          }
          paramString1 = null;
          if (paramString1 != null)
          {
            paramString2 = a(paramString1.a);
            if (paramString2 != null) {
              paramString1.e = paramString2.iVersion;
            } else {
              paramString1.e = -1;
            }
            paramString1.b = System.currentTimeMillis();
            a(paramString1);
            return null;
          }
          this.f -= 1;
        }
        if (this.f != 0) {
          return null;
        }
        return paramString2;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.lib.autoconfig.ConfigFileDownloader
 * JD-Core Version:    0.7.0.1
 */