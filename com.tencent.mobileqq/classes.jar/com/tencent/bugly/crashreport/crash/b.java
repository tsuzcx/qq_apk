package com.tencent.bugly.crashreport.crash;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.ah;
import com.tencent.bugly.proguard.aj;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.al;
import com.tencent.bugly.proguard.am;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.k;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.r;
import com.tencent.bugly.proguard.t;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.List<Lcom.tencent.bugly.crashreport.crash.CrashDetailBean;>;
import java.util.List<Lcom.tencent.bugly.crashreport.crash.a;>;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class b
{
  private static int b = 0;
  protected e a;
  private Context c;
  private u d;
  private p e;
  private com.tencent.bugly.crashreport.common.strategy.a f;
  private com.tencent.bugly.proguard.a g;
  
  public b(int paramInt, Context paramContext, u paramu, p paramp, com.tencent.bugly.crashreport.common.strategy.a parama, com.tencent.bugly.proguard.a parama1, e parame)
  {
    b = paramInt;
    this.c = paramContext;
    this.d = paramu;
    this.e = paramp;
    this.f = parama;
    this.g = parama1;
    this.a = parame;
  }
  
  private static CrashDetailBean a(Cursor paramCursor)
  {
    if (paramCursor == null) {
      paramCursor = null;
    }
    for (;;)
    {
      return paramCursor;
      try
      {
        Object localObject = paramCursor.getBlob(paramCursor.getColumnIndex("_dt"));
        if (localObject == null) {
          return null;
        }
        long l = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
        localObject = (CrashDetailBean)z.a((byte[])localObject, CrashDetailBean.CREATOR);
        paramCursor = (Cursor)localObject;
        if (localObject != null)
        {
          ((CrashDetailBean)localObject).a = l;
          return localObject;
        }
      }
      catch (Throwable paramCursor)
      {
        if (!x.a(paramCursor)) {
          paramCursor.printStackTrace();
        }
      }
    }
    return null;
  }
  
  private CrashDetailBean a(List<a> paramList, CrashDetailBean paramCrashDetailBean)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      paramList = paramCrashDetailBean;
      return paramList;
    }
    Object localObject1 = null;
    Object localObject2 = new ArrayList(10);
    Object localObject3 = paramList.iterator();
    a locala;
    while (((Iterator)localObject3).hasNext())
    {
      locala = (a)((Iterator)localObject3).next();
      if (locala.e) {
        ((List)localObject2).add(locala);
      }
    }
    if (((List)localObject2).size() > 0)
    {
      localObject3 = b((List)localObject2);
      if ((localObject3 != null) && (((List)localObject3).size() > 0))
      {
        Collections.sort((List)localObject3);
        int i = 0;
        while (i < ((List)localObject3).size())
        {
          localObject2 = (CrashDetailBean)((List)localObject3).get(i);
          if (i == 0)
          {
            localObject1 = localObject2;
            label154:
            i += 1;
          }
          else
          {
            if (((CrashDetailBean)localObject2).s == null) {
              break label535;
            }
            localObject2 = ((CrashDetailBean)localObject2).s.split("\n");
            if (localObject2 == null) {
              break label535;
            }
            int k = localObject2.length;
            int j = 0;
            while (j < k)
            {
              locala = localObject2[j];
              if (!((CrashDetailBean)localObject1).s.contains(locala))
              {
                ((CrashDetailBean)localObject1).t += 1;
                ((CrashDetailBean)localObject1).s = (((CrashDetailBean)localObject1).s + locala + "\n");
              }
              j += 1;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        paramCrashDetailBean.j = true;
        paramCrashDetailBean.t = 0;
        paramCrashDetailBean.s = "";
        localObject1 = paramCrashDetailBean;
      }
      for (;;)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject2 = (a)paramList.next();
          if ((!((a)localObject2).e) && (!((a)localObject2).d) && (!((CrashDetailBean)localObject1).s.contains(((a)localObject2).b)))
          {
            ((CrashDetailBean)localObject1).t += 1;
            ((CrashDetailBean)localObject1).s = (((CrashDetailBean)localObject1).s + ((a)localObject2).b + "\n");
          }
        }
        paramList = (List<a>)localObject1;
        if (((CrashDetailBean)localObject1).r == paramCrashDetailBean.r) {
          break;
        }
        paramList = (List<a>)localObject1;
        if (((CrashDetailBean)localObject1).s.contains(paramCrashDetailBean.r)) {
          break;
        }
        ((CrashDetailBean)localObject1).t += 1;
        ((CrashDetailBean)localObject1).s = (((CrashDetailBean)localObject1).s + paramCrashDetailBean.r + "\n");
        return localObject1;
      }
      label535:
      break label154;
      localObject1 = null;
    }
  }
  
  /* Error */
  private static aj a(String paramString1, Context paramContext, String paramString2)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +15 -> 20
    //   8: ldc 184
    //   10: iconst_0
    //   11: anewarray 4	java/lang/Object
    //   14: invokestatic 187	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   17: pop
    //   18: aconst_null
    //   19: areturn
    //   20: ldc 189
    //   22: iconst_1
    //   23: anewarray 4	java/lang/Object
    //   26: dup
    //   27: iconst_0
    //   28: aload_2
    //   29: aastore
    //   30: invokestatic 191	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   33: pop
    //   34: new 193	java/io/File
    //   37: dup
    //   38: aload_2
    //   39: invokespecial 196	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: astore_2
    //   43: new 193	java/io/File
    //   46: dup
    //   47: aload_1
    //   48: invokevirtual 202	android/content/Context:getCacheDir	()Ljava/io/File;
    //   51: aload_0
    //   52: invokespecial 205	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   55: astore 4
    //   57: aload_2
    //   58: aload 4
    //   60: sipush 5000
    //   63: invokestatic 208	com/tencent/bugly/proguard/z:a	(Ljava/io/File;Ljava/io/File;I)Z
    //   66: ifne +15 -> 81
    //   69: ldc 210
    //   71: iconst_0
    //   72: anewarray 4	java/lang/Object
    //   75: invokestatic 187	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   78: pop
    //   79: aconst_null
    //   80: areturn
    //   81: new 212	java/io/ByteArrayOutputStream
    //   84: dup
    //   85: invokespecial 213	java/io/ByteArrayOutputStream:<init>	()V
    //   88: astore_2
    //   89: new 215	java/io/FileInputStream
    //   92: dup
    //   93: aload 4
    //   95: invokespecial 218	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   98: astore_1
    //   99: aload_1
    //   100: astore_0
    //   101: sipush 4096
    //   104: newarray byte
    //   106: astore 5
    //   108: aload_1
    //   109: astore_0
    //   110: aload_1
    //   111: aload 5
    //   113: invokevirtual 222	java/io/FileInputStream:read	([B)I
    //   116: istore_3
    //   117: iload_3
    //   118: ifle +72 -> 190
    //   121: aload_1
    //   122: astore_0
    //   123: aload_2
    //   124: aload 5
    //   126: iconst_0
    //   127: iload_3
    //   128: invokevirtual 226	java/io/ByteArrayOutputStream:write	([BII)V
    //   131: aload_1
    //   132: astore_0
    //   133: aload_2
    //   134: invokevirtual 229	java/io/ByteArrayOutputStream:flush	()V
    //   137: goto -29 -> 108
    //   140: astore_2
    //   141: aload_1
    //   142: astore_0
    //   143: aload_2
    //   144: invokestatic 81	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   147: ifne +9 -> 156
    //   150: aload_1
    //   151: astore_0
    //   152: aload_2
    //   153: invokevirtual 84	java/lang/Throwable:printStackTrace	()V
    //   156: aload_1
    //   157: ifnull +7 -> 164
    //   160: aload_1
    //   161: invokevirtual 232	java/io/FileInputStream:close	()V
    //   164: aload 4
    //   166: invokevirtual 235	java/io/File:exists	()Z
    //   169: ifeq -151 -> 18
    //   172: ldc 237
    //   174: iconst_0
    //   175: anewarray 4	java/lang/Object
    //   178: invokestatic 191	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   181: pop
    //   182: aload 4
    //   184: invokevirtual 240	java/io/File:delete	()Z
    //   187: pop
    //   188: aconst_null
    //   189: areturn
    //   190: aload_1
    //   191: astore_0
    //   192: aload_2
    //   193: invokevirtual 244	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   196: astore_2
    //   197: aload_1
    //   198: astore_0
    //   199: ldc 246
    //   201: iconst_1
    //   202: anewarray 4	java/lang/Object
    //   205: dup
    //   206: iconst_0
    //   207: aload_2
    //   208: arraylength
    //   209: invokestatic 252	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   212: aastore
    //   213: invokestatic 191	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   216: pop
    //   217: aload_1
    //   218: astore_0
    //   219: new 254	com/tencent/bugly/proguard/aj
    //   222: dup
    //   223: iconst_2
    //   224: aload 4
    //   226: invokevirtual 257	java/io/File:getName	()Ljava/lang/String;
    //   229: aload_2
    //   230: invokespecial 260	com/tencent/bugly/proguard/aj:<init>	(BLjava/lang/String;[B)V
    //   233: astore_2
    //   234: aload_1
    //   235: invokevirtual 232	java/io/FileInputStream:close	()V
    //   238: aload 4
    //   240: invokevirtual 235	java/io/File:exists	()Z
    //   243: ifeq +19 -> 262
    //   246: ldc 237
    //   248: iconst_0
    //   249: anewarray 4	java/lang/Object
    //   252: invokestatic 191	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   255: pop
    //   256: aload 4
    //   258: invokevirtual 240	java/io/File:delete	()Z
    //   261: pop
    //   262: aload_2
    //   263: areturn
    //   264: astore_0
    //   265: aload_0
    //   266: invokestatic 81	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   269: ifne -31 -> 238
    //   272: aload_0
    //   273: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   276: goto -38 -> 238
    //   279: astore_0
    //   280: aload_0
    //   281: invokestatic 81	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   284: ifne -120 -> 164
    //   287: aload_0
    //   288: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   291: goto -127 -> 164
    //   294: astore_1
    //   295: aconst_null
    //   296: astore_0
    //   297: aload_0
    //   298: ifnull +7 -> 305
    //   301: aload_0
    //   302: invokevirtual 232	java/io/FileInputStream:close	()V
    //   305: aload 4
    //   307: invokevirtual 235	java/io/File:exists	()Z
    //   310: ifeq +19 -> 329
    //   313: ldc 237
    //   315: iconst_0
    //   316: anewarray 4	java/lang/Object
    //   319: invokestatic 191	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   322: pop
    //   323: aload 4
    //   325: invokevirtual 240	java/io/File:delete	()Z
    //   328: pop
    //   329: aload_1
    //   330: athrow
    //   331: astore_0
    //   332: aload_0
    //   333: invokestatic 81	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   336: ifne -31 -> 305
    //   339: aload_0
    //   340: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   343: goto -38 -> 305
    //   346: astore_1
    //   347: goto -50 -> 297
    //   350: astore_2
    //   351: aconst_null
    //   352: astore_1
    //   353: goto -212 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	356	0	paramString1	String
    //   0	356	1	paramContext	Context
    //   0	356	2	paramString2	String
    //   116	12	3	i	int
    //   55	269	4	localFile	File
    //   106	19	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   101	108	140	java/lang/Throwable
    //   110	117	140	java/lang/Throwable
    //   123	131	140	java/lang/Throwable
    //   133	137	140	java/lang/Throwable
    //   192	197	140	java/lang/Throwable
    //   199	217	140	java/lang/Throwable
    //   219	234	140	java/lang/Throwable
    //   234	238	264	java/io/IOException
    //   160	164	279	java/io/IOException
    //   89	99	294	finally
    //   301	305	331	java/io/IOException
    //   101	108	346	finally
    //   110	117	346	finally
    //   123	131	346	finally
    //   133	137	346	finally
    //   143	150	346	finally
    //   152	156	346	finally
    //   192	197	346	finally
    //   199	217	346	finally
    //   219	234	346	finally
    //   89	99	350	java/lang/Throwable
  }
  
  private static ak a(Context paramContext, CrashDetailBean paramCrashDetailBean, com.tencent.bugly.crashreport.common.info.a parama)
  {
    boolean bool2 = true;
    if ((paramContext == null) || (paramCrashDetailBean == null) || (parama == null))
    {
      x.d("enExp args == null", new Object[0]);
      return null;
    }
    ak localak = new ak();
    Object localObject1;
    Map.Entry localEntry;
    ah localah;
    switch (paramCrashDetailBean.b)
    {
    default: 
      x.e("crash type error! %d", new Object[] { Integer.valueOf(paramCrashDetailBean.b) });
      localak.b = paramCrashDetailBean.r;
      localak.c = paramCrashDetailBean.n;
      localak.d = paramCrashDetailBean.o;
      localak.e = paramCrashDetailBean.p;
      localak.g = paramCrashDetailBean.q;
      localak.h = paramCrashDetailBean.z;
      localak.i = paramCrashDetailBean.c;
      localak.j = null;
      localak.l = paramCrashDetailBean.m;
      localak.m = paramCrashDetailBean.e;
      localak.f = paramCrashDetailBean.B;
      localak.t = com.tencent.bugly.crashreport.common.info.a.b().h();
      localak.n = null;
      if ((paramCrashDetailBean.i != null) && (paramCrashDetailBean.i.size() > 0))
      {
        localak.o = new ArrayList();
        localObject1 = paramCrashDetailBean.i.entrySet().iterator();
      }
      break;
    case 3: 
    case 7: 
    case 0: 
    case 1: 
    case 2: 
    case 4: 
    case 6: 
    case 5: 
      while (((Iterator)localObject1).hasNext())
      {
        localEntry = (Map.Entry)((Iterator)localObject1).next();
        localah = new ah();
        localah.a = ((PlugInBean)localEntry.getValue()).a;
        localah.c = ((PlugInBean)localEntry.getValue()).c;
        localah.d = ((PlugInBean)localEntry.getValue()).b;
        localah.b = parama.q();
        localak.o.add(localah);
        continue;
        if (paramCrashDetailBean.j) {}
        for (localObject1 = "203";; localObject1 = "103")
        {
          localak.a = ((String)localObject1);
          break;
        }
        if (paramCrashDetailBean.j) {}
        for (localObject1 = "208";; localObject1 = "108")
        {
          localak.a = ((String)localObject1);
          break;
        }
        if (paramCrashDetailBean.j) {}
        for (localObject1 = "200";; localObject1 = "100")
        {
          localak.a = ((String)localObject1);
          break;
        }
        if (paramCrashDetailBean.j) {}
        for (localObject1 = "201";; localObject1 = "101")
        {
          localak.a = ((String)localObject1);
          break;
        }
        if (paramCrashDetailBean.j) {}
        for (localObject1 = "202";; localObject1 = "102")
        {
          localak.a = ((String)localObject1);
          break;
        }
        if (paramCrashDetailBean.j) {}
        for (localObject1 = "204";; localObject1 = "104")
        {
          localak.a = ((String)localObject1);
          break;
        }
        if (paramCrashDetailBean.j) {}
        for (localObject1 = "206";; localObject1 = "106")
        {
          localak.a = ((String)localObject1);
          break;
        }
        if (paramCrashDetailBean.j) {}
        for (localObject1 = "207";; localObject1 = "107")
        {
          localak.a = ((String)localObject1);
          break;
        }
      }
    }
    if ((paramCrashDetailBean.h != null) && (paramCrashDetailBean.h.size() > 0))
    {
      localak.p = new ArrayList();
      localObject1 = paramCrashDetailBean.h.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localEntry = (Map.Entry)((Iterator)localObject1).next();
        localah = new ah();
        localah.a = ((PlugInBean)localEntry.getValue()).a;
        localah.c = ((PlugInBean)localEntry.getValue()).c;
        localah.d = ((PlugInBean)localEntry.getValue()).b;
        localak.p.add(localah);
      }
    }
    if (paramCrashDetailBean.j)
    {
      localak.k = paramCrashDetailBean.t;
      if ((paramCrashDetailBean.s != null) && (paramCrashDetailBean.s.length() > 0)) {
        if (localak.q == null) {
          localak.q = new ArrayList();
        }
      }
    }
    label1674:
    Object localObject3;
    boolean bool1;
    label3075:
    long l;
    boolean bool3;
    boolean bool4;
    boolean bool5;
    try
    {
      localak.q.add(new aj((byte)1, "alltimes.txt", paramCrashDetailBean.s.getBytes("utf-8")));
      int j = localak.k;
      if (localak.q != null)
      {
        i = localak.q.size();
        x.c("crashcount:%d sz:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        if (paramCrashDetailBean.w != null) {
          if (localak.q == null) {
            localak.q = new ArrayList();
          }
        }
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException4)
    {
      try
      {
        localak.q.add(new aj((byte)1, "log.txt", paramCrashDetailBean.w.getBytes("utf-8")));
        if (paramCrashDetailBean.x != null) {
          if (localak.q == null) {
            localak.q = new ArrayList();
          }
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException4)
      {
        try
        {
          localak.q.add(new aj((byte)1, "jniLog.txt", paramCrashDetailBean.x.getBytes("utf-8")));
          if (!z.a(paramCrashDetailBean.U)) {
            if (localak.q == null) {
              localak.q = new ArrayList();
            }
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException4)
        {
          try
          {
            localObject1 = new aj((byte)1, "crashInfos.txt", paramCrashDetailBean.U.getBytes("utf-8"));
            if (localObject1 != null)
            {
              x.c("attach crash infos", new Object[0]);
              localak.q.add(localObject1);
            }
            if (paramCrashDetailBean.V != null)
            {
              if (localak.q == null) {
                localak.q = new ArrayList();
              }
              localObject1 = a("backupRecord.zip", paramContext, paramCrashDetailBean.V);
              if (localObject1 != null)
              {
                x.c("attach backup record", new Object[0]);
                localak.q.add(localObject1);
              }
            }
            if ((paramCrashDetailBean.y != null) && (paramCrashDetailBean.y.length > 0))
            {
              localObject1 = new aj((byte)2, "buglylog.zip", paramCrashDetailBean.y);
              x.c("attach user log", new Object[0]);
              if (localak.q == null) {
                localak.q = new ArrayList();
              }
              localak.q.add(localObject1);
            }
            if (paramCrashDetailBean.b == 3)
            {
              if (localak.q == null) {
                localak.q = new ArrayList();
              }
              if ((paramCrashDetailBean.O == null) || (!paramCrashDetailBean.O.containsKey("BUGLY_CR_01"))) {}
            }
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException4)
          {
            try
            {
              for (;;)
              {
                localak.q.add(new aj((byte)1, "anrMessage.txt", ((String)paramCrashDetailBean.O.get("BUGLY_CR_01")).getBytes("utf-8")));
                x.c("attach anr message", new Object[0]);
                paramCrashDetailBean.O.remove("BUGLY_CR_01");
                if (paramCrashDetailBean.v != null)
                {
                  localObject1 = a("trace.zip", paramContext, paramCrashDetailBean.v);
                  if (localObject1 != null)
                  {
                    x.c("attach traces", new Object[0]);
                    localak.q.add(localObject1);
                  }
                }
                if (paramCrashDetailBean.b == 1)
                {
                  if (localak.q == null) {
                    localak.q = new ArrayList();
                  }
                  if (paramCrashDetailBean.v != null)
                  {
                    paramContext = a("tomb.zip", paramContext, paramCrashDetailBean.v);
                    if (paramContext != null)
                    {
                      x.c("attach tombs", new Object[0]);
                      localak.q.add(paramContext);
                    }
                  }
                }
                if ((parama.C == null) || (parama.C.isEmpty())) {
                  break label1674;
                }
                if (localak.q == null) {
                  localak.q = new ArrayList();
                }
                paramContext = new StringBuilder();
                localObject1 = parama.C.iterator();
                while (((Iterator)localObject1).hasNext()) {
                  paramContext.append((String)((Iterator)localObject1).next());
                }
                localUnsupportedEncodingException1 = localUnsupportedEncodingException1;
                localUnsupportedEncodingException1.printStackTrace();
                localak.q = null;
                continue;
                int i = 0;
                continue;
                localUnsupportedEncodingException2 = localUnsupportedEncodingException2;
                localUnsupportedEncodingException2.printStackTrace();
                localak.q = null;
                continue;
                localUnsupportedEncodingException3 = localUnsupportedEncodingException3;
                localUnsupportedEncodingException3.printStackTrace();
                localak.q = null;
              }
              localUnsupportedEncodingException4 = localUnsupportedEncodingException4;
              localUnsupportedEncodingException4.printStackTrace();
              Object localObject2 = null;
            }
            catch (UnsupportedEncodingException localUnsupportedEncodingException5)
            {
              for (;;)
              {
                localUnsupportedEncodingException5.printStackTrace();
                localak.q = null;
              }
              try
              {
                localak.q.add(new aj((byte)1, "martianlog.txt", paramContext.toString().getBytes("utf-8")));
                x.c("attach pageTracingList", new Object[0]);
                if ((paramCrashDetailBean.T != null) && (paramCrashDetailBean.T.length > 0))
                {
                  if (localak.q == null) {
                    localak.q = new ArrayList();
                  }
                  localak.q.add(new aj((byte)1, "userExtraByteData", paramCrashDetailBean.T));
                  x.c("attach extraData", new Object[0]);
                }
                localak.r = new HashMap();
                localak.r.put("A9", paramCrashDetailBean.C);
                localak.r.put("A11", paramCrashDetailBean.D);
                localak.r.put("A10", paramCrashDetailBean.E);
                localak.r.put("A23", paramCrashDetailBean.f);
                localak.r.put("A7", parama.g);
                localak.r.put("A6", parama.r());
                localak.r.put("A5", parama.q());
                localak.r.put("A22", parama.g());
                localak.r.put("A2", paramCrashDetailBean.G);
                localak.r.put("A1", paramCrashDetailBean.F);
                localak.r.put("A24", parama.i);
                localak.r.put("A17", paramCrashDetailBean.H);
                localak.r.put("A3", parama.j());
                localak.r.put("A16", parama.l());
                localak.r.put("A25", parama.m());
                localak.r.put("A14", parama.k());
                localak.r.put("A15", parama.v());
                localak.r.put("A13", parama.w());
                localak.r.put("A34", paramCrashDetailBean.A);
                if (parama.y != null) {
                  localak.r.put("productIdentify", parama.y);
                }
              }
              catch (UnsupportedEncodingException paramContext)
              {
                try
                {
                  localak.r.put("A26", URLEncoder.encode(paramCrashDetailBean.I, "utf-8"));
                  if (paramCrashDetailBean.b == 1)
                  {
                    localak.r.put("A27", paramCrashDetailBean.K);
                    localak.r.put("A28", paramCrashDetailBean.J);
                    localak.r.put("A29", paramCrashDetailBean.k);
                  }
                  localak.r.put("A30", paramCrashDetailBean.L);
                  localak.r.put("A18", paramCrashDetailBean.M);
                  paramContext = localak.r;
                  localObject3 = new StringBuilder();
                  if (!paramCrashDetailBean.N)
                  {
                    bool1 = true;
                    paramContext.put("A36", bool1);
                    localak.r.put("F02", parama.s);
                    localak.r.put("F03", parama.t);
                    localak.r.put("F04", parama.d());
                    localak.r.put("F05", parama.u);
                    localak.r.put("F06", parama.r);
                    localak.r.put("F08", parama.w);
                    localak.r.put("F09", parama.x);
                    localak.r.put("F10", parama.v);
                    if (paramCrashDetailBean.P >= 0) {
                      localak.r.put("C01", paramCrashDetailBean.P);
                    }
                    if (paramCrashDetailBean.Q >= 0) {
                      localak.r.put("C02", paramCrashDetailBean.Q);
                    }
                    if ((paramCrashDetailBean.R == null) || (paramCrashDetailBean.R.size() <= 0)) {
                      break label3075;
                    }
                    paramContext = paramCrashDetailBean.R.entrySet().iterator();
                    while (paramContext.hasNext())
                    {
                      localObject3 = (Map.Entry)paramContext.next();
                      localak.r.put("C03_" + (String)((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue());
                      continue;
                      paramContext = paramContext;
                      paramContext.printStackTrace();
                    }
                  }
                }
                catch (UnsupportedEncodingException paramContext)
                {
                  for (;;)
                  {
                    paramContext.printStackTrace();
                    continue;
                    bool1 = false;
                  }
                  if ((paramCrashDetailBean.S != null) && (paramCrashDetailBean.S.size() > 0))
                  {
                    paramContext = paramCrashDetailBean.S.entrySet().iterator();
                    while (paramContext.hasNext())
                    {
                      localObject3 = (Map.Entry)paramContext.next();
                      localak.r.put("C04_" + (String)((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue());
                    }
                  }
                  localak.s = null;
                  if ((paramCrashDetailBean.O != null) && (paramCrashDetailBean.O.size() > 0))
                  {
                    localak.s = paramCrashDetailBean.O;
                    x.a("setted message size %d", new Object[] { Integer.valueOf(localak.s.size()) });
                  }
                  paramContext = paramCrashDetailBean.n;
                  localObject3 = paramCrashDetailBean.c;
                  parama = parama.d();
                  l = (paramCrashDetailBean.r - paramCrashDetailBean.M) / 1000L;
                  bool3 = paramCrashDetailBean.k;
                  bool4 = paramCrashDetailBean.N;
                  bool5 = paramCrashDetailBean.j;
                  if (paramCrashDetailBean.b != 1) {
                    break label3415;
                  }
                }
              }
              bool1 = bool2;
            }
          }
        }
      }
    }
    for (;;)
    {
      x.c("%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d", new Object[] { paramContext, localObject3, parama, Long.valueOf(l), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool1), Integer.valueOf(paramCrashDetailBean.t), paramCrashDetailBean.s, Boolean.valueOf(paramCrashDetailBean.d), Integer.valueOf(localak.r.size()) });
      return localak;
      label3415:
      bool1 = false;
    }
  }
  
  private static al a(Context paramContext, List<CrashDetailBean> paramList, com.tencent.bugly.crashreport.common.info.a parama)
  {
    if ((paramContext == null) || (paramList == null) || (paramList.size() == 0) || (parama == null))
    {
      x.d("enEXPPkg args == null!", new Object[0]);
      return null;
    }
    al localal = new al();
    localal.a = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      CrashDetailBean localCrashDetailBean = (CrashDetailBean)paramList.next();
      localal.a.add(a(paramContext, localCrashDetailBean, parama));
    }
    return localal;
  }
  
  private static List<a> a(List<a> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    long l = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      a locala = (a)paramList.next();
      if ((locala.d) && (locala.b <= l - 86400000L)) {
        localArrayList.add(locala);
      }
    }
    return localArrayList;
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, CrashDetailBean paramCrashDetailBean)
  {
    com.tencent.bugly.crashreport.common.info.a locala = com.tencent.bugly.crashreport.common.info.a.b();
    if (locala == null) {
      return;
    }
    x.e("#++++++++++Record By Bugly++++++++++#", new Object[0]);
    x.e("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new Object[0]);
    x.e("# PKG NAME: %s", new Object[] { locala.c });
    x.e("# APP VER: %s", new Object[] { locala.l });
    x.e("# LAUNCH TIME: %s", new Object[] { z.a(new Date(com.tencent.bugly.crashreport.common.info.a.b().a)) });
    x.e("# CRASH TYPE: %s", new Object[] { paramString1 });
    x.e("# CRASH TIME: %s", new Object[] { paramString2 });
    x.e("# CRASH PROCESS: %s", new Object[] { paramString3 });
    x.e("# CRASH THREAD: %s", new Object[] { paramString4 });
    if (paramCrashDetailBean != null)
    {
      x.e("# REPORT ID: %s", new Object[] { paramCrashDetailBean.c });
      paramString2 = locala.h;
      if (!locala.w().booleanValue()) {
        break label392;
      }
      paramString1 = "ROOTED";
      x.e("# CRASH DEVICE: %s %s", new Object[] { paramString2, paramString1 });
      x.e("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", new Object[] { Long.valueOf(paramCrashDetailBean.C), Long.valueOf(paramCrashDetailBean.D), Long.valueOf(paramCrashDetailBean.E) });
      x.e("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", new Object[] { Long.valueOf(paramCrashDetailBean.F), Long.valueOf(paramCrashDetailBean.G), Long.valueOf(paramCrashDetailBean.H) });
      if (z.a(paramCrashDetailBean.K)) {
        break label399;
      }
      x.e("# EXCEPTION FIRED BY %s %s", new Object[] { paramCrashDetailBean.K, paramCrashDetailBean.J });
    }
    label392:
    label399:
    while (paramCrashDetailBean.b != 3)
    {
      if (!z.a(paramString5))
      {
        x.e("# CRASH STACK: ", new Object[0]);
        x.e(paramString5, new Object[0]);
      }
      x.e("#++++++++++++++++++++++++++++++++++++++++++#", new Object[0]);
      return;
      paramString1 = "UNROOT";
      break;
    }
    if (paramCrashDetailBean.O == null) {}
    for (paramString1 = "null";; paramString1 = (String)paramCrashDetailBean.O.get("BUGLY_CR_01"))
    {
      x.e("# EXCEPTION ANR MESSAGE:\n %s", new Object[] { paramString1 });
      break;
    }
  }
  
  public static void a(boolean paramBoolean, List<CrashDetailBean> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      x.c("up finish update state %b", new Object[] { Boolean.valueOf(paramBoolean) });
      Iterator localIterator = paramList.iterator();
      CrashDetailBean localCrashDetailBean;
      while (localIterator.hasNext())
      {
        localCrashDetailBean = (CrashDetailBean)localIterator.next();
        x.c("pre uid:%s uc:%d re:%b me:%b", new Object[] { localCrashDetailBean.c, Integer.valueOf(localCrashDetailBean.l), Boolean.valueOf(localCrashDetailBean.d), Boolean.valueOf(localCrashDetailBean.j) });
        localCrashDetailBean.l += 1;
        localCrashDetailBean.d = paramBoolean;
        x.c("set uid:%s uc:%d re:%b me:%b", new Object[] { localCrashDetailBean.c, Integer.valueOf(localCrashDetailBean.l), Boolean.valueOf(localCrashDetailBean.d), Boolean.valueOf(localCrashDetailBean.j) });
      }
      localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        localCrashDetailBean = (CrashDetailBean)localIterator.next();
        c.a().a(localCrashDetailBean);
      }
      x.c("update state size %d", new Object[] { Integer.valueOf(paramList.size()) });
    }
    if (!paramBoolean) {
      x.b("[crash] upload fail.", new Object[0]);
    }
  }
  
  private static a b(Cursor paramCursor)
  {
    boolean bool2 = true;
    if (paramCursor == null) {}
    for (;;)
    {
      return null;
      try
      {
        a locala = new a();
        locala.a = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
        locala.b = paramCursor.getLong(paramCursor.getColumnIndex("_tm"));
        locala.c = paramCursor.getString(paramCursor.getColumnIndex("_s1"));
        if (paramCursor.getInt(paramCursor.getColumnIndex("_up")) == 1)
        {
          bool1 = true;
          locala.d = bool1;
          if (paramCursor.getInt(paramCursor.getColumnIndex("_me")) != 1) {
            break label150;
          }
        }
        label150:
        for (boolean bool1 = bool2;; bool1 = false)
        {
          locala.e = bool1;
          locala.f = paramCursor.getInt(paramCursor.getColumnIndex("_uc"));
          return locala;
          bool1 = false;
          break;
        }
        if (x.a(paramCursor)) {}
      }
      catch (Throwable paramCursor) {}
    }
    paramCursor.printStackTrace();
    return null;
  }
  
  /* Error */
  private List<a> b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 93	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 340	java/util/ArrayList:<init>	()V
    //   9: astore 5
    //   11: invokestatic 857	com/tencent/bugly/proguard/p:a	()Lcom/tencent/bugly/proguard/p;
    //   14: ldc_w 859
    //   17: bipush 6
    //   19: anewarray 140	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: ldc 58
    //   26: aastore
    //   27: dup
    //   28: iconst_1
    //   29: ldc_w 832
    //   32: aastore
    //   33: dup
    //   34: iconst_2
    //   35: ldc_w 834
    //   38: aastore
    //   39: dup
    //   40: iconst_3
    //   41: ldc_w 841
    //   44: aastore
    //   45: dup
    //   46: iconst_4
    //   47: ldc_w 847
    //   50: aastore
    //   51: dup
    //   52: iconst_5
    //   53: ldc_w 849
    //   56: aastore
    //   57: aconst_null
    //   58: aconst_null
    //   59: aconst_null
    //   60: iconst_1
    //   61: invokevirtual 862	com/tencent/bugly/proguard/p:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/bugly/proguard/o;Z)Landroid/database/Cursor;
    //   64: astore 4
    //   66: aload 4
    //   68: astore_3
    //   69: aload_3
    //   70: ifnonnull +15 -> 85
    //   73: aload_3
    //   74: ifnull +9 -> 83
    //   77: aload_3
    //   78: invokeinterface 863 1 0
    //   83: aconst_null
    //   84: areturn
    //   85: new 146	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   92: astore 4
    //   94: aload_3
    //   95: invokeinterface 866 1 0
    //   100: ifeq +130 -> 230
    //   103: aload_3
    //   104: invokestatic 868	com/tencent/bugly/crashreport/crash/b:b	(Landroid/database/Cursor;)Lcom/tencent/bugly/crashreport/crash/a;
    //   107: astore 6
    //   109: aload 6
    //   111: ifnull +44 -> 155
    //   114: aload 5
    //   116: aload 6
    //   118: invokeinterface 119 2 0
    //   123: pop
    //   124: goto -30 -> 94
    //   127: astore 4
    //   129: aload 4
    //   131: invokestatic 81	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   134: ifne +8 -> 142
    //   137: aload 4
    //   139: invokevirtual 84	java/lang/Throwable:printStackTrace	()V
    //   142: aload_3
    //   143: ifnull +9 -> 152
    //   146: aload_3
    //   147: invokeinterface 863 1 0
    //   152: aload 5
    //   154: areturn
    //   155: aload_3
    //   156: aload_3
    //   157: ldc 58
    //   159: invokeinterface 52 2 0
    //   164: invokeinterface 62 2 0
    //   169: lstore_1
    //   170: aload 4
    //   172: ldc_w 870
    //   175: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: ldc_w 872
    //   181: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: lload_1
    //   185: invokevirtual 174	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: goto -95 -> 94
    //   192: astore 6
    //   194: ldc_w 874
    //   197: iconst_0
    //   198: anewarray 4	java/lang/Object
    //   201: invokestatic 187	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   204: pop
    //   205: goto -111 -> 94
    //   208: astore 5
    //   210: aload_3
    //   211: astore 4
    //   213: aload 5
    //   215: astore_3
    //   216: aload 4
    //   218: ifnull +10 -> 228
    //   221: aload 4
    //   223: invokeinterface 863 1 0
    //   228: aload_3
    //   229: athrow
    //   230: aload 4
    //   232: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: astore 4
    //   237: aload 4
    //   239: invokevirtual 414	java/lang/String:length	()I
    //   242: ifle +48 -> 290
    //   245: aload 4
    //   247: iconst_4
    //   248: invokevirtual 877	java/lang/String:substring	(I)Ljava/lang/String;
    //   251: astore 4
    //   253: ldc_w 879
    //   256: iconst_2
    //   257: anewarray 4	java/lang/Object
    //   260: dup
    //   261: iconst_0
    //   262: ldc_w 859
    //   265: aastore
    //   266: dup
    //   267: iconst_1
    //   268: invokestatic 857	com/tencent/bugly/proguard/p:a	()Lcom/tencent/bugly/proguard/p;
    //   271: ldc_w 859
    //   274: aload 4
    //   276: aconst_null
    //   277: aconst_null
    //   278: iconst_1
    //   279: invokevirtual 882	com/tencent/bugly/proguard/p:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/bugly/proguard/o;Z)I
    //   282: invokestatic 252	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   285: aastore
    //   286: invokestatic 187	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   289: pop
    //   290: aload_3
    //   291: ifnull +9 -> 300
    //   294: aload_3
    //   295: invokeinterface 863 1 0
    //   300: aload 5
    //   302: areturn
    //   303: astore_3
    //   304: aconst_null
    //   305: astore 4
    //   307: goto -91 -> 216
    //   310: astore 5
    //   312: aload_3
    //   313: astore 4
    //   315: aload 5
    //   317: astore_3
    //   318: goto -102 -> 216
    //   321: astore 4
    //   323: goto -194 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	326	0	this	b
    //   169	16	1	l	long
    //   1	294	3	localObject1	Object
    //   303	10	3	localObject2	Object
    //   317	1	3	localObject3	Object
    //   64	29	4	localObject4	Object
    //   127	44	4	localThrowable1	Throwable
    //   211	103	4	localObject5	Object
    //   321	1	4	localThrowable2	Throwable
    //   9	144	5	localArrayList	ArrayList
    //   208	93	5	localList	List<a>
    //   310	6	5	localObject6	Object
    //   107	10	6	locala	a
    //   192	1	6	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   85	94	127	java/lang/Throwable
    //   94	109	127	java/lang/Throwable
    //   114	124	127	java/lang/Throwable
    //   194	205	127	java/lang/Throwable
    //   230	290	127	java/lang/Throwable
    //   155	189	192	java/lang/Throwable
    //   85	94	208	finally
    //   94	109	208	finally
    //   114	124	208	finally
    //   155	189	208	finally
    //   194	205	208	finally
    //   230	290	208	finally
    //   11	66	303	finally
    //   129	142	310	finally
    //   11	66	321	java/lang/Throwable
  }
  
  /* Error */
  private List<CrashDetailBean> b(List<a> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 91 1 0
    //   10: ifne +5 -> 15
    //   13: aconst_null
    //   14: areturn
    //   15: new 146	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   22: astore 5
    //   24: aload_1
    //   25: invokeinterface 100 1 0
    //   30: astore_1
    //   31: aload_1
    //   32: invokeinterface 106 1 0
    //   37: ifeq +40 -> 77
    //   40: aload_1
    //   41: invokeinterface 110 1 0
    //   46: checkcast 112	com/tencent/bugly/crashreport/crash/a
    //   49: astore 4
    //   51: aload 5
    //   53: ldc_w 870
    //   56: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc_w 872
    //   62: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload 4
    //   67: getfield 830	com/tencent/bugly/crashreport/crash/a:a	J
    //   70: invokevirtual 174	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: goto -43 -> 31
    //   77: aload 5
    //   79: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: astore 4
    //   84: aload 4
    //   86: astore_1
    //   87: aload 4
    //   89: invokevirtual 414	java/lang/String:length	()I
    //   92: ifle +10 -> 102
    //   95: aload 4
    //   97: iconst_4
    //   98: invokevirtual 877	java/lang/String:substring	(I)Ljava/lang/String;
    //   101: astore_1
    //   102: aload 5
    //   104: iconst_0
    //   105: invokevirtual 886	java/lang/StringBuilder:setLength	(I)V
    //   108: invokestatic 857	com/tencent/bugly/proguard/p:a	()Lcom/tencent/bugly/proguard/p;
    //   111: ldc_w 859
    //   114: aconst_null
    //   115: aload_1
    //   116: aconst_null
    //   117: aconst_null
    //   118: iconst_1
    //   119: invokevirtual 862	com/tencent/bugly/proguard/p:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/bugly/proguard/o;Z)Landroid/database/Cursor;
    //   122: astore_1
    //   123: aload_1
    //   124: ifnonnull +15 -> 139
    //   127: aload_1
    //   128: ifnull +9 -> 137
    //   131: aload_1
    //   132: invokeinterface 863 1 0
    //   137: aconst_null
    //   138: areturn
    //   139: new 93	java/util/ArrayList
    //   142: dup
    //   143: invokespecial 340	java/util/ArrayList:<init>	()V
    //   146: astore 4
    //   148: aload_1
    //   149: invokeinterface 866 1 0
    //   154: ifeq +129 -> 283
    //   157: aload_1
    //   158: invokestatic 888	com/tencent/bugly/crashreport/crash/b:a	(Landroid/database/Cursor;)Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;
    //   161: astore 6
    //   163: aload 6
    //   165: ifnull +43 -> 208
    //   168: aload 4
    //   170: aload 6
    //   172: invokeinterface 119 2 0
    //   177: pop
    //   178: goto -30 -> 148
    //   181: astore 4
    //   183: aload 4
    //   185: invokestatic 81	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   188: ifne +8 -> 196
    //   191: aload 4
    //   193: invokevirtual 84	java/lang/Throwable:printStackTrace	()V
    //   196: aload_1
    //   197: ifnull +9 -> 206
    //   200: aload_1
    //   201: invokeinterface 863 1 0
    //   206: aconst_null
    //   207: areturn
    //   208: aload_1
    //   209: aload_1
    //   210: ldc 58
    //   212: invokeinterface 52 2 0
    //   217: invokeinterface 62 2 0
    //   222: lstore_2
    //   223: aload 5
    //   225: ldc_w 870
    //   228: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: ldc_w 872
    //   234: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: lload_2
    //   238: invokevirtual 174	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: goto -94 -> 148
    //   245: astore 6
    //   247: ldc_w 874
    //   250: iconst_0
    //   251: anewarray 4	java/lang/Object
    //   254: invokestatic 187	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   257: pop
    //   258: goto -110 -> 148
    //   261: astore 5
    //   263: aload_1
    //   264: astore 4
    //   266: aload 5
    //   268: astore_1
    //   269: aload 4
    //   271: ifnull +10 -> 281
    //   274: aload 4
    //   276: invokeinterface 863 1 0
    //   281: aload_1
    //   282: athrow
    //   283: aload 5
    //   285: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: astore 5
    //   290: aload 5
    //   292: invokevirtual 414	java/lang/String:length	()I
    //   295: ifle +48 -> 343
    //   298: aload 5
    //   300: iconst_4
    //   301: invokevirtual 877	java/lang/String:substring	(I)Ljava/lang/String;
    //   304: astore 5
    //   306: ldc_w 879
    //   309: iconst_2
    //   310: anewarray 4	java/lang/Object
    //   313: dup
    //   314: iconst_0
    //   315: ldc_w 859
    //   318: aastore
    //   319: dup
    //   320: iconst_1
    //   321: invokestatic 857	com/tencent/bugly/proguard/p:a	()Lcom/tencent/bugly/proguard/p;
    //   324: ldc_w 859
    //   327: aload 5
    //   329: aconst_null
    //   330: aconst_null
    //   331: iconst_1
    //   332: invokevirtual 882	com/tencent/bugly/proguard/p:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/bugly/proguard/o;Z)I
    //   335: invokestatic 252	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   338: aastore
    //   339: invokestatic 187	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   342: pop
    //   343: aload_1
    //   344: ifnull +9 -> 353
    //   347: aload_1
    //   348: invokeinterface 863 1 0
    //   353: aload 4
    //   355: areturn
    //   356: astore_1
    //   357: aconst_null
    //   358: astore 4
    //   360: goto -91 -> 269
    //   363: astore 5
    //   365: aload_1
    //   366: astore 4
    //   368: aload 5
    //   370: astore_1
    //   371: goto -102 -> 269
    //   374: astore 4
    //   376: aconst_null
    //   377: astore_1
    //   378: goto -195 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	381	0	this	b
    //   0	381	1	paramList	List<a>
    //   222	16	2	l	long
    //   49	120	4	localObject1	Object
    //   181	11	4	localThrowable1	Throwable
    //   264	103	4	localList	List<a>
    //   374	1	4	localThrowable2	Throwable
    //   22	202	5	localStringBuilder	StringBuilder
    //   261	23	5	localObject2	Object
    //   288	40	5	str	String
    //   363	6	5	localObject3	Object
    //   161	10	6	localCrashDetailBean	CrashDetailBean
    //   245	1	6	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   139	148	181	java/lang/Throwable
    //   148	163	181	java/lang/Throwable
    //   168	178	181	java/lang/Throwable
    //   247	258	181	java/lang/Throwable
    //   283	343	181	java/lang/Throwable
    //   208	242	245	java/lang/Throwable
    //   139	148	261	finally
    //   148	163	261	finally
    //   168	178	261	finally
    //   208	242	261	finally
    //   247	258	261	finally
    //   283	343	261	finally
    //   108	123	356	finally
    //   183	196	363	finally
    //   108	123	374	java/lang/Throwable
  }
  
  private static void c(List<a> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    do
    {
      return;
      StringBuilder localStringBuilder = new StringBuilder();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (a)paramList.next();
        localStringBuilder.append(" or _id").append(" = ").append(((a)localObject).a);
      }
      Object localObject = localStringBuilder.toString();
      paramList = (List<a>)localObject;
      if (((String)localObject).length() > 0) {
        paramList = ((String)localObject).substring(4);
      }
      localStringBuilder.setLength(0);
      try
      {
        x.c("deleted %s data %d", new Object[] { "t_cr", Integer.valueOf(p.a().a("t_cr", paramList, null, null, true)) });
        return;
      }
      catch (Throwable paramList) {}
    } while (x.a(paramList));
    paramList.printStackTrace();
  }
  
  private static void d(List<CrashDetailBean> paramList)
  {
    if (paramList != null) {
      try
      {
        if (paramList.size() == 0) {
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        paramList = paramList.iterator();
        Object localObject;
        while (paramList.hasNext())
        {
          localObject = (CrashDetailBean)paramList.next();
          localStringBuilder.append(" or _id").append(" = ").append(((CrashDetailBean)localObject).a);
        }
        return;
      }
      catch (Throwable paramList)
      {
        if (!x.a(paramList))
        {
          paramList.printStackTrace();
          return;
          localObject = localStringBuilder.toString();
          paramList = (List<CrashDetailBean>)localObject;
          if (((String)localObject).length() > 0) {
            paramList = ((String)localObject).substring(4);
          }
          localStringBuilder.setLength(0);
          x.c("deleted %s data %d", new Object[] { "t_cr", Integer.valueOf(p.a().a("t_cr", paramList, null, null, true)) });
        }
      }
    }
  }
  
  private static ContentValues e(CrashDetailBean paramCrashDetailBean)
  {
    int j = 1;
    if (paramCrashDetailBean == null) {}
    for (;;)
    {
      return null;
      try
      {
        ContentValues localContentValues = new ContentValues();
        if (paramCrashDetailBean.a > 0L) {
          localContentValues.put("_id", Long.valueOf(paramCrashDetailBean.a));
        }
        localContentValues.put("_tm", Long.valueOf(paramCrashDetailBean.r));
        localContentValues.put("_s1", paramCrashDetailBean.u);
        if (paramCrashDetailBean.d)
        {
          i = 1;
          localContentValues.put("_up", Integer.valueOf(i));
          if (!paramCrashDetailBean.j) {
            break label134;
          }
        }
        label134:
        for (int i = j;; i = 0)
        {
          localContentValues.put("_me", Integer.valueOf(i));
          localContentValues.put("_uc", Integer.valueOf(paramCrashDetailBean.l));
          localContentValues.put("_dt", z.a(paramCrashDetailBean));
          return localContentValues;
          i = 0;
          break;
        }
        if (x.a(paramCrashDetailBean)) {}
      }
      catch (Throwable paramCrashDetailBean) {}
    }
    paramCrashDetailBean.printStackTrace();
    return null;
  }
  
  private boolean f(CrashDetailBean paramCrashDetailBean)
  {
    try
    {
      x.c("save eup logs", new Object[0]);
      Object localObject = com.tencent.bugly.crashreport.common.info.a.b();
      String str1 = ((com.tencent.bugly.crashreport.common.info.a)localObject).e();
      String str2 = ((com.tencent.bugly.crashreport.common.info.a)localObject).l;
      String str3 = paramCrashDetailBean.A;
      Locale localLocale = Locale.US;
      localObject.getClass();
      str1 = String.format(localLocale, "#--------\npackage:%s\nversion:%s\nsdk:%s\nprocess:%s\ndate:%s\ntype:%s\nmessage:%s\nstack:\n%s\neupID:%s\n", new Object[] { str1, str2, "2.7.8", str3, z.a(new Date(paramCrashDetailBean.r)), paramCrashDetailBean.n, paramCrashDetailBean.o, paramCrashDetailBean.q, paramCrashDetailBean.c });
      paramCrashDetailBean = null;
      if (c.j == null) {
        if (Environment.getExternalStorageState().equals("mounted")) {
          paramCrashDetailBean = Environment.getExternalStorageDirectory().getAbsolutePath();
        }
      }
      for (paramCrashDetailBean = paramCrashDetailBean + "/Tencent/" + this.c.getPackageName();; paramCrashDetailBean = paramCrashDetailBean.getAbsolutePath())
      {
        paramCrashDetailBean = paramCrashDetailBean + "/euplog.txt";
        localObject = this.c;
        z.a(paramCrashDetailBean, str1, c.k);
        return true;
        localObject = new File(c.j);
        paramCrashDetailBean = (CrashDetailBean)localObject;
        if (((File)localObject).isFile()) {
          paramCrashDetailBean = ((File)localObject).getParentFile();
        }
      }
      return false;
    }
    catch (Throwable paramCrashDetailBean)
    {
      x.d("rqdp{  save error} %s", new Object[] { paramCrashDetailBean.toString() });
      if (!x.a(paramCrashDetailBean)) {
        paramCrashDetailBean.printStackTrace();
      }
    }
  }
  
  public final List<CrashDetailBean> a()
  {
    Object localObject1 = com.tencent.bugly.crashreport.common.strategy.a.a().c();
    if (localObject1 == null) {
      x.d("have not synced remote!", new Object[0]);
    }
    long l1;
    long l2;
    do
    {
      return null;
      if (!((StrategyBean)localObject1).g)
      {
        x.d("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
        x.b("[init] WARNING! Crashreport closed by server, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
        return null;
      }
      l1 = System.currentTimeMillis();
      l2 = z.b();
      localList = b();
    } while ((localList == null) || (localList.size() <= 0));
    localObject1 = new ArrayList();
    ((List)localObject1).addAll(a(localList));
    localList.removeAll((Collection)localObject1);
    Object localObject2 = localList.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (a)((Iterator)localObject2).next();
      if (((a)localObject3).b < l2 - c.g)
      {
        ((Iterator)localObject2).remove();
        ((List)localObject1).add(localObject3);
      }
      else if (((a)localObject3).d)
      {
        if (((a)localObject3).b >= l1 - 86400000L)
        {
          ((Iterator)localObject2).remove();
        }
        else if (!((a)localObject3).e)
        {
          ((Iterator)localObject2).remove();
          ((List)localObject1).add(localObject3);
        }
      }
      else if ((((a)localObject3).f >= 3L) && (((a)localObject3).b < l1 - 86400000L))
      {
        ((Iterator)localObject2).remove();
        ((List)localObject1).add(localObject3);
      }
    }
    if (((List)localObject1).size() > 0) {
      c((List)localObject1);
    }
    localObject1 = new ArrayList();
    List localList = b(localList);
    if ((localList != null) && (localList.size() > 0))
    {
      localObject2 = com.tencent.bugly.crashreport.common.info.a.b().l;
      localObject3 = localList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        CrashDetailBean localCrashDetailBean = (CrashDetailBean)((Iterator)localObject3).next();
        if (!((String)localObject2).equals(localCrashDetailBean.f))
        {
          ((Iterator)localObject3).remove();
          ((List)localObject1).add(localCrashDetailBean);
        }
      }
    }
    if (((List)localObject1).size() > 0) {
      d((List)localObject1);
    }
    return localList;
  }
  
  public final void a(CrashDetailBean paramCrashDetailBean, long paramLong, boolean paramBoolean)
  {
    boolean bool = false;
    if (c.l)
    {
      x.a("try to upload right now", new Object[0]);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramCrashDetailBean);
      if (paramCrashDetailBean.b == 7) {
        bool = true;
      }
      a(localArrayList, 3000L, paramBoolean, bool, paramBoolean);
    }
  }
  
  public final void a(final List<CrashDetailBean> paramList, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!com.tencent.bugly.crashreport.common.info.a.a(this.c).f) {}
    Object localObject1;
    do
    {
      do
      {
        return;
      } while ((this.d == null) || ((!paramBoolean3) && (!this.d.b(c.a))));
      localObject1 = this.f.c();
      if (!((StrategyBean)localObject1).g)
      {
        x.d("remote report is disable!", new Object[0]);
        x.b("[crash] server closed bugly in this app. please check your appid if is correct, and re-install it", new Object[0]);
        return;
      }
    } while ((paramList == null) || (paramList.size() == 0));
    for (;;)
    {
      try
      {
        if (!this.d.b) {
          break label200;
        }
        localObject1 = ((StrategyBean)localObject1).r;
        if (!this.d.b) {
          break label210;
        }
        str = StrategyBean.c;
        if (!this.d.b) {
          break label327;
        }
        i = 830;
        localObject2 = a(this.c, paramList, com.tencent.bugly.crashreport.common.info.a.b());
        if (localObject2 != null) {
          break label218;
        }
        x.d("create eupPkg fail!", new Object[0]);
        return;
      }
      catch (Throwable paramList)
      {
        x.e("req cr error %s", new Object[] { paramList.toString() });
      }
      if (x.b(paramList)) {
        break;
      }
      paramList.printStackTrace();
      return;
      label200:
      localObject1 = ((StrategyBean)localObject1).s;
      continue;
      label210:
      String str = StrategyBean.a;
      continue;
      label218:
      Object localObject2 = com.tencent.bugly.proguard.a.a((k)localObject2);
      if (localObject2 == null)
      {
        x.d("send encode fail!", new Object[0]);
        return;
      }
      localObject2 = com.tencent.bugly.proguard.a.a(this.c, i, (byte[])localObject2);
      if (localObject2 == null)
      {
        x.d("request package is null.", new Object[0]);
        return;
      }
      paramList = new t()
      {
        public final void a(int paramAnonymousInt) {}
        
        public final void a(int paramAnonymousInt, an paramAnonymousan, long paramAnonymousLong1, long paramAnonymousLong2, boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          paramAnonymousan = b.this;
          b.a(paramAnonymousBoolean, paramList);
        }
      };
      if (paramBoolean1)
      {
        this.d.a(b, (am)localObject2, (String)localObject1, str, paramList, paramLong, paramBoolean2);
        return;
      }
      this.d.a(b, (am)localObject2, (String)localObject1, str, paramList, false);
      return;
      label327:
      int i = 630;
    }
  }
  
  public final boolean a(CrashDetailBean paramCrashDetailBean)
  {
    return a(paramCrashDetailBean, -123456789);
  }
  
  public final boolean a(CrashDetailBean paramCrashDetailBean, int paramInt)
  {
    if (paramCrashDetailBean == null) {
      return true;
    }
    if (paramCrashDetailBean.b == 1) {}
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    for (boolean bool = true;; bool = false)
    {
      localObject1 = paramCrashDetailBean.n;
      localObject2 = paramCrashDetailBean.p;
      localObject3 = paramCrashDetailBean.q;
      long l = paramCrashDetailBean.r;
      localObject4 = paramCrashDetailBean.m;
      String str1 = paramCrashDetailBean.e;
      String str2 = paramCrashDetailBean.c;
      if (this.a == null) {
        break;
      }
      x.c("Calling 'onCrashSaving' of RQD crash listener.", new Object[0]);
      if (this.a.a(bool, (String)localObject1, (String)localObject2, (String)localObject3, paramInt, l, (String)localObject4, str1, str2, paramCrashDetailBean.A)) {
        break;
      }
      x.d("Crash listener 'onCrashSaving' return 'false' thus will not handle this crash.", new Object[0]);
      return true;
    }
    if (paramCrashDetailBean.b != 2)
    {
      localObject1 = new r();
      ((r)localObject1).b = 1;
      ((r)localObject1).c = paramCrashDetailBean.A;
      ((r)localObject1).d = paramCrashDetailBean.B;
      ((r)localObject1).e = paramCrashDetailBean.r;
      this.e.b(1);
      this.e.a((r)localObject1);
      x.b("[crash] a crash occur, handling...", new Object[0]);
    }
    for (;;)
    {
      localObject3 = b();
      localObject2 = null;
      localObject1 = localObject2;
      if (localObject3 == null) {
        break label495;
      }
      localObject1 = localObject2;
      if (((List)localObject3).size() <= 0) {
        break label495;
      }
      localObject1 = new ArrayList(10);
      localObject2 = new ArrayList(10);
      ((List)localObject1).addAll(a((List)localObject3));
      ((List)localObject3).removeAll((Collection)localObject1);
      if ((com.tencent.bugly.b.c) || (!c.d)) {
        break label495;
      }
      paramInt = 0;
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (a)((Iterator)localObject3).next();
        if (paramCrashDetailBean.u.equals(((a)localObject4).c))
        {
          if (((a)localObject4).e) {
            paramInt = 1;
          }
          ((List)localObject2).add(localObject4);
        }
      }
      x.b("[crash] a caught exception occur, handling...", new Object[0]);
    }
    if ((paramInt != 0) || (((List)localObject2).size() >= c.c))
    {
      x.a("same crash occur too much do merged!", new Object[0]);
      paramCrashDetailBean = a((List)localObject2, paramCrashDetailBean);
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (a)((Iterator)localObject2).next();
        if (((a)localObject3).a != paramCrashDetailBean.a) {
          ((List)localObject1).add(localObject3);
        }
      }
      d(paramCrashDetailBean);
      c((List)localObject1);
      x.b("[crash] save crash success. For this device crash many times, it will not upload crashes immediately", new Object[0]);
      return true;
    }
    label495:
    d(paramCrashDetailBean);
    if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
      c((List)localObject1);
    }
    x.b("[crash] save crash success", new Object[0]);
    return false;
  }
  
  public final byte[] a(List<CrashDetailBean> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    do
    {
      return null;
      try
      {
        localObject = a(this.c, paramList, com.tencent.bugly.crashreport.common.info.a.b());
        if (localObject != null) {
          break;
        }
        x.d("create eupPkg fail!", new Object[0]);
        return null;
      }
      catch (Throwable paramList) {}
    } while (x.a(paramList));
    paramList.printStackTrace();
    return null;
    Object localObject = com.tencent.bugly.proguard.a.a((k)localObject);
    if (localObject == null)
    {
      x.d("send encode fail!", new Object[0]);
      return null;
    }
    localObject = com.tencent.bugly.proguard.a.a(com.tencent.bugly.proguard.a.a(this.c, 630, (byte[])localObject));
    a(true, paramList);
    return localObject;
  }
  
  public final void b(CrashDetailBean paramCrashDetailBean)
  {
    boolean bool = true;
    e locale;
    if (this.a != null)
    {
      x.c("Calling 'onCrashHandleEnd' of RQD crash listener.", new Object[0]);
      locale = this.a;
      if (paramCrashDetailBean.b != 1) {
        break label42;
      }
    }
    for (;;)
    {
      locale.b(bool);
      return;
      label42:
      bool = false;
    }
  }
  
  public final void c(CrashDetailBean paramCrashDetailBean)
  {
    if (paramCrashDetailBean == null) {
      break label4;
    }
    label4:
    while ((this.g == null) && (this.a == null)) {
      return;
    }
    for (;;)
    {
      String str2;
      String str3;
      String str4;
      long l;
      String str1;
      Object localObject;
      Map.Entry localEntry;
      try
      {
        x.a("[crash callback] start user's callback:onCrashHandleStart()", new Object[0]);
        switch (paramCrashDetailBean.b)
        {
        case 0: 
        case 1: 
        case 2: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
          if (paramCrashDetailBean.b != 1) {
            break label517;
          }
          bool = true;
          str2 = paramCrashDetailBean.n;
          str3 = paramCrashDetailBean.p;
          str4 = paramCrashDetailBean.q;
          l = paramCrashDetailBean.r;
          if (this.a == null) {
            break label522;
          }
          x.c("Calling 'onCrashHandleStart' of RQD crash listener.", new Object[0]);
          this.a.a(bool);
          x.c("Calling 'getCrashExtraMessage' of RQD crash listener.", new Object[0]);
          str1 = this.a.b(bool, str2, str3, str4, -1234567890, l);
          if (str1 == null) {
            break label796;
          }
          localObject = new HashMap(1);
          ((Map)localObject).put("userData", str1);
          if ((localObject == null) || (((Map)localObject).size() <= 0)) {
            break label602;
          }
          paramCrashDetailBean.O = new LinkedHashMap(((Map)localObject).size());
          Iterator localIterator = ((Map)localObject).entrySet().iterator();
          if (!localIterator.hasNext()) {
            break label602;
          }
          localEntry = (Map.Entry)localIterator.next();
          if (z.a((String)localEntry.getKey())) {
            continue;
          }
          str1 = (String)localEntry.getKey();
          localObject = str1;
          if (str1.length() > 100)
          {
            localObject = str1.substring(0, 100);
            x.d("setted key length is over limit %d substring to %s", new Object[] { Integer.valueOf(100), localObject });
          }
          if ((z.a((String)localEntry.getValue())) || (((String)localEntry.getValue()).length() <= 30000)) {
            break label574;
          }
          str1 = ((String)localEntry.getValue()).substring(((String)localEntry.getValue()).length() - 30000);
          x.d("setted %s value length is over limit %d substring", new Object[] { localObject, Integer.valueOf(30000) });
          paramCrashDetailBean.O.put(localObject, str1);
          x.a("add setted key %s value size:%d", new Object[] { localObject, Integer.valueOf(str1.length()) });
          continue;
          if (x.a(paramCrashDetailBean)) {
            break label4;
          }
        }
      }
      catch (Throwable paramCrashDetailBean)
      {
        x.d("crash handle callback something wrong! %s", new Object[] { paramCrashDetailBean.getClass().getName() });
      }
      paramCrashDetailBean.printStackTrace();
      return;
      label517:
      boolean bool = false;
      continue;
      label522:
      if (this.g != null)
      {
        x.c("Calling 'onCrashHandleStart' of Bugly crash listener.", new Object[0]);
        localObject = this.g;
        str1 = paramCrashDetailBean.n;
        str1 = paramCrashDetailBean.o;
        str1 = paramCrashDetailBean.q;
        localObject = ((com.tencent.bugly.proguard.a)localObject).b();
        continue;
        label574:
        str1 = (String)localEntry.getValue();
        continue;
        label602:
        x.a("[crash callback] start user's callback:onCrashHandleStart2GetExtraDatas()", new Object[0]);
        localObject = null;
        if (this.a != null)
        {
          x.c("Calling 'getCrashExtraData' of RQD crash listener.", new Object[0]);
          localObject = this.a.a(bool, str2, str3, str4, -1234567890, l);
        }
        for (;;)
        {
          paramCrashDetailBean.T = ((byte[])localObject);
          if (localObject == null) {
            break;
          }
          if (localObject.length > 30000)
          {
            x.d("extra bytes size %d is over limit %d will drop over part", new Object[] { Integer.valueOf(localObject.length), Integer.valueOf(30000) });
            paramCrashDetailBean.T = Arrays.copyOf((byte[])localObject, 30000);
          }
          x.a("add extra bytes %d ", new Object[] { Integer.valueOf(localObject.length) });
          return;
          if (this.g != null)
          {
            x.c("Calling 'onCrashHandleStart2GetExtraDatas' of Bugly crash listener.", new Object[0]);
            localObject = this.g;
            str1 = paramCrashDetailBean.n;
            str1 = paramCrashDetailBean.o;
            str1 = paramCrashDetailBean.q;
            localObject = ((com.tencent.bugly.proguard.a)localObject).c();
          }
        }
      }
      else
      {
        localObject = null;
        continue;
        label796:
        localObject = null;
      }
    }
  }
  
  public final void d(CrashDetailBean paramCrashDetailBean)
  {
    if (paramCrashDetailBean == null) {}
    do
    {
      return;
      ContentValues localContentValues = e(paramCrashDetailBean);
      if (localContentValues != null)
      {
        long l = p.a().a("t_cr", localContentValues, null, true);
        if (l >= 0L)
        {
          x.c("insert %s success!", new Object[] { "t_cr" });
          paramCrashDetailBean.a = l;
        }
      }
    } while (!c.i);
    f(paramCrashDetailBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.crash.b
 * JD-Core Version:    0.7.0.1
 */