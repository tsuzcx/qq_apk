package com.tencent.bugly.crashreport.crash;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.ah;
import com.tencent.bugly.proguard.aj;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.al;
import com.tencent.bugly.proguard.am;
import com.tencent.bugly.proguard.k;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.r;
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
  protected f a;
  private Context c;
  private u d;
  private p e;
  private com.tencent.bugly.crashreport.common.strategy.a f;
  private com.tencent.bugly.proguard.a g;
  
  public b(int paramInt, Context paramContext, u paramu, p paramp, com.tencent.bugly.crashreport.common.strategy.a parama, com.tencent.bugly.proguard.a parama1, f paramf)
  {
    b = paramInt;
    this.c = paramContext;
    this.d = paramu;
    this.e = paramp;
    this.f = parama;
    this.g = parama1;
    this.a = paramf;
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
    //   8: ldc 182
    //   10: iconst_0
    //   11: anewarray 4	java/lang/Object
    //   14: invokestatic 185	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   17: pop
    //   18: aconst_null
    //   19: areturn
    //   20: ldc 187
    //   22: iconst_1
    //   23: anewarray 4	java/lang/Object
    //   26: dup
    //   27: iconst_0
    //   28: aload_2
    //   29: aastore
    //   30: invokestatic 189	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   33: pop
    //   34: new 191	java/io/File
    //   37: dup
    //   38: aload_2
    //   39: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: astore_2
    //   43: new 191	java/io/File
    //   46: dup
    //   47: aload_1
    //   48: invokevirtual 200	android/content/Context:getCacheDir	()Ljava/io/File;
    //   51: aload_0
    //   52: invokespecial 203	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   55: astore 4
    //   57: aload_2
    //   58: aload 4
    //   60: sipush 5000
    //   63: invokestatic 206	com/tencent/bugly/proguard/z:a	(Ljava/io/File;Ljava/io/File;I)Z
    //   66: ifne +15 -> 81
    //   69: ldc 208
    //   71: iconst_0
    //   72: anewarray 4	java/lang/Object
    //   75: invokestatic 185	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   78: pop
    //   79: aconst_null
    //   80: areturn
    //   81: new 210	java/io/ByteArrayOutputStream
    //   84: dup
    //   85: invokespecial 211	java/io/ByteArrayOutputStream:<init>	()V
    //   88: astore_2
    //   89: new 213	java/io/FileInputStream
    //   92: dup
    //   93: aload 4
    //   95: invokespecial 216	java/io/FileInputStream:<init>	(Ljava/io/File;)V
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
    //   113: invokevirtual 220	java/io/FileInputStream:read	([B)I
    //   116: istore_3
    //   117: iload_3
    //   118: ifle +72 -> 190
    //   121: aload_1
    //   122: astore_0
    //   123: aload_2
    //   124: aload 5
    //   126: iconst_0
    //   127: iload_3
    //   128: invokevirtual 224	java/io/ByteArrayOutputStream:write	([BII)V
    //   131: aload_1
    //   132: astore_0
    //   133: aload_2
    //   134: invokevirtual 227	java/io/ByteArrayOutputStream:flush	()V
    //   137: goto -29 -> 108
    //   140: astore_2
    //   141: aload_1
    //   142: astore_0
    //   143: aload_2
    //   144: invokestatic 79	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   147: ifne +9 -> 156
    //   150: aload_1
    //   151: astore_0
    //   152: aload_2
    //   153: invokevirtual 82	java/lang/Throwable:printStackTrace	()V
    //   156: aload_1
    //   157: ifnull +7 -> 164
    //   160: aload_1
    //   161: invokevirtual 230	java/io/FileInputStream:close	()V
    //   164: aload 4
    //   166: invokevirtual 233	java/io/File:exists	()Z
    //   169: ifeq -151 -> 18
    //   172: ldc 235
    //   174: iconst_0
    //   175: anewarray 4	java/lang/Object
    //   178: invokestatic 189	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   181: pop
    //   182: aload 4
    //   184: invokevirtual 238	java/io/File:delete	()Z
    //   187: pop
    //   188: aconst_null
    //   189: areturn
    //   190: aload_1
    //   191: astore_0
    //   192: aload_2
    //   193: invokevirtual 242	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   196: astore_2
    //   197: aload_1
    //   198: astore_0
    //   199: ldc 244
    //   201: iconst_1
    //   202: anewarray 4	java/lang/Object
    //   205: dup
    //   206: iconst_0
    //   207: aload_2
    //   208: arraylength
    //   209: invokestatic 250	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   212: aastore
    //   213: invokestatic 189	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   216: pop
    //   217: aload_1
    //   218: astore_0
    //   219: new 252	com/tencent/bugly/proguard/aj
    //   222: dup
    //   223: iconst_2
    //   224: aload 4
    //   226: invokevirtual 255	java/io/File:getName	()Ljava/lang/String;
    //   229: aload_2
    //   230: invokespecial 258	com/tencent/bugly/proguard/aj:<init>	(BLjava/lang/String;[B)V
    //   233: astore_2
    //   234: aload_1
    //   235: invokevirtual 230	java/io/FileInputStream:close	()V
    //   238: aload 4
    //   240: invokevirtual 233	java/io/File:exists	()Z
    //   243: ifeq +19 -> 262
    //   246: ldc 235
    //   248: iconst_0
    //   249: anewarray 4	java/lang/Object
    //   252: invokestatic 189	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   255: pop
    //   256: aload 4
    //   258: invokevirtual 238	java/io/File:delete	()Z
    //   261: pop
    //   262: aload_2
    //   263: areturn
    //   264: astore_0
    //   265: aload_0
    //   266: invokestatic 79	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   269: ifne -31 -> 238
    //   272: aload_0
    //   273: invokevirtual 259	java/io/IOException:printStackTrace	()V
    //   276: goto -38 -> 238
    //   279: astore_0
    //   280: aload_0
    //   281: invokestatic 79	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   284: ifne -120 -> 164
    //   287: aload_0
    //   288: invokevirtual 259	java/io/IOException:printStackTrace	()V
    //   291: goto -127 -> 164
    //   294: astore_1
    //   295: aconst_null
    //   296: astore_0
    //   297: aload_0
    //   298: ifnull +7 -> 305
    //   301: aload_0
    //   302: invokevirtual 230	java/io/FileInputStream:close	()V
    //   305: aload 4
    //   307: invokevirtual 233	java/io/File:exists	()Z
    //   310: ifeq +19 -> 329
    //   313: ldc 235
    //   315: iconst_0
    //   316: anewarray 4	java/lang/Object
    //   319: invokestatic 189	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   322: pop
    //   323: aload 4
    //   325: invokevirtual 238	java/io/File:delete	()Z
    //   328: pop
    //   329: aload_1
    //   330: athrow
    //   331: astore_0
    //   332: aload_0
    //   333: invokestatic 79	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   336: ifne -31 -> 305
    //   339: aload_0
    //   340: invokevirtual 259	java/io/IOException:printStackTrace	()V
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
      x.c("libInfo %s", new Object[] { localak.o });
      if ((paramCrashDetailBean.h != null) && (paramCrashDetailBean.h.size() > 0))
      {
        localak.p = new ArrayList();
        localObject1 = paramCrashDetailBean.h.entrySet().iterator();
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
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
        ah localah = new ah();
        localah.a = ((PlugInBean)localEntry.getValue()).a;
        localah.b = ((PlugInBean)localEntry.getValue()).c;
        localah.c = ((PlugInBean)localEntry.getValue()).b;
        localak.p.add(localah);
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
    if (paramCrashDetailBean.j)
    {
      localak.k = paramCrashDetailBean.t;
      if ((paramCrashDetailBean.s != null) && (paramCrashDetailBean.s.length() > 0)) {
        if (localak.q == null) {
          localak.q = new ArrayList();
        }
      }
    }
    label1577:
    Object localObject3;
    boolean bool1;
    label2978:
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
          if (!z.a(paramCrashDetailBean.V)) {
            if (localak.q == null) {
              localak.q = new ArrayList();
            }
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException4)
        {
          try
          {
            localObject1 = new aj((byte)1, "crashInfos.txt", paramCrashDetailBean.V.getBytes("utf-8"));
            if (localObject1 != null)
            {
              x.c("attach crash infos", new Object[0]);
              localak.q.add(localObject1);
            }
            if (paramCrashDetailBean.W != null)
            {
              if (localak.q == null) {
                localak.q = new ArrayList();
              }
              localObject1 = a("backupRecord.zip", paramContext, paramCrashDetailBean.W);
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
              x.c("crashBean.anrMessages:%s", new Object[] { paramCrashDetailBean.P });
              if ((paramCrashDetailBean.P == null) || (!paramCrashDetailBean.P.containsKey("BUGLY_CR_01"))) {}
            }
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException4)
          {
            try
            {
              for (;;)
              {
                if (!TextUtils.isEmpty((CharSequence)paramCrashDetailBean.P.get("BUGLY_CR_01")))
                {
                  localak.q.add(new aj((byte)1, "anrMessage.txt", ((String)paramCrashDetailBean.P.get("BUGLY_CR_01")).getBytes("utf-8")));
                  x.c("attach anr message", new Object[0]);
                }
                paramCrashDetailBean.P.remove("BUGLY_CR_01");
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
                if ((parama.D == null) || (parama.D.isEmpty())) {
                  break label1577;
                }
                if (localak.q == null) {
                  localak.q = new ArrayList();
                }
                paramContext = new StringBuilder();
                localObject1 = parama.D.iterator();
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
                if ((paramCrashDetailBean.U != null) && (paramCrashDetailBean.U.length > 0))
                {
                  if (localak.q == null) {
                    localak.q = new ArrayList();
                  }
                  localak.q.add(new aj((byte)1, "userExtraByteData", paramCrashDetailBean.U));
                  x.c("attach extraData", new Object[0]);
                }
                localak.r = new HashMap();
                localak.r.put("A9", paramCrashDetailBean.C);
                localak.r.put("A11", paramCrashDetailBean.D);
                localak.r.put("A10", paramCrashDetailBean.E);
                localak.r.put("A23", paramCrashDetailBean.f);
                localak.r.put("A7", parama.h);
                localak.r.put("A6", parama.r());
                localak.r.put("A5", parama.q());
                localak.r.put("A22", parama.g());
                localak.r.put("A2", paramCrashDetailBean.G);
                localak.r.put("A1", paramCrashDetailBean.F);
                localak.r.put("A24", parama.j);
                localak.r.put("A17", paramCrashDetailBean.H);
                localak.r.put("A3", parama.j());
                localak.r.put("A16", parama.l());
                localak.r.put("A25", parama.m());
                localak.r.put("A14", parama.k());
                localak.r.put("A15", parama.v());
                localak.r.put("A13", parama.w());
                localak.r.put("A34", paramCrashDetailBean.A);
                if (parama.z != null) {
                  localak.r.put("productIdentify", parama.z);
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
                    localak.r.put("F02", parama.t);
                    localak.r.put("F03", parama.u);
                    localak.r.put("F04", parama.d());
                    localak.r.put("F05", parama.v);
                    localak.r.put("F06", parama.s);
                    localak.r.put("F08", parama.x);
                    localak.r.put("F09", parama.y);
                    localak.r.put("F10", parama.w);
                    if (paramCrashDetailBean.Q >= 0) {
                      localak.r.put("C01", paramCrashDetailBean.Q);
                    }
                    if (paramCrashDetailBean.R >= 0) {
                      localak.r.put("C02", paramCrashDetailBean.R);
                    }
                    if ((paramCrashDetailBean.S == null) || (paramCrashDetailBean.S.size() <= 0)) {
                      break label2978;
                    }
                    paramContext = paramCrashDetailBean.S.entrySet().iterator();
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
                  if ((paramCrashDetailBean.T != null) && (paramCrashDetailBean.T.size() > 0))
                  {
                    paramContext = paramCrashDetailBean.T.entrySet().iterator();
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
                    break label3318;
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
      label3318:
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
    x.e("# APP VER: %s", new Object[] { locala.m });
    x.e("# SDK VER: %s", new Object[] { locala.g });
    x.e("# LAUNCH TIME: %s", new Object[] { z.a(new Date(com.tencent.bugly.crashreport.common.info.a.b().a)) });
    x.e("# CRASH TYPE: %s", new Object[] { paramString1 });
    x.e("# CRASH TIME: %s", new Object[] { paramString2 });
    x.e("# CRASH PROCESS: %s", new Object[] { paramString3 });
    x.e("# CRASH THREAD: %s", new Object[] { paramString4 });
    if (paramCrashDetailBean != null)
    {
      x.e("# REPORT ID: %s", new Object[] { paramCrashDetailBean.c });
      paramString2 = locala.i;
      if (!locala.w().booleanValue()) {
        break label411;
      }
      paramString1 = "ROOTED";
      x.e("# CRASH DEVICE: %s %s", new Object[] { paramString2, paramString1 });
      x.e("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", new Object[] { Long.valueOf(paramCrashDetailBean.C), Long.valueOf(paramCrashDetailBean.D), Long.valueOf(paramCrashDetailBean.E) });
      x.e("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", new Object[] { Long.valueOf(paramCrashDetailBean.F), Long.valueOf(paramCrashDetailBean.G), Long.valueOf(paramCrashDetailBean.H) });
      if (z.a(paramCrashDetailBean.K)) {
        break label418;
      }
      x.e("# EXCEPTION FIRED BY %s %s", new Object[] { paramCrashDetailBean.K, paramCrashDetailBean.J });
    }
    label411:
    label418:
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
    if (paramCrashDetailBean.P == null) {}
    for (paramString1 = "null";; paramString1 = (String)paramCrashDetailBean.P.get("BUGLY_CR_01"))
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
    //   1: astore_2
    //   2: new 91	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 342	java/util/ArrayList:<init>	()V
    //   9: astore 4
    //   11: invokestatic 869	com/tencent/bugly/proguard/p:a	()Lcom/tencent/bugly/proguard/p;
    //   14: ldc_w 871
    //   17: bipush 6
    //   19: anewarray 138	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: ldc 56
    //   26: aastore
    //   27: dup
    //   28: iconst_1
    //   29: ldc_w 844
    //   32: aastore
    //   33: dup
    //   34: iconst_2
    //   35: ldc_w 846
    //   38: aastore
    //   39: dup
    //   40: iconst_3
    //   41: ldc_w 853
    //   44: aastore
    //   45: dup
    //   46: iconst_4
    //   47: ldc_w 859
    //   50: aastore
    //   51: dup
    //   52: iconst_5
    //   53: ldc_w 861
    //   56: aastore
    //   57: aconst_null
    //   58: aconst_null
    //   59: aconst_null
    //   60: iconst_1
    //   61: invokevirtual 874	com/tencent/bugly/proguard/p:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/bugly/proguard/o;Z)Landroid/database/Cursor;
    //   64: astore_3
    //   65: aload_3
    //   66: astore_2
    //   67: aload_2
    //   68: ifnonnull +15 -> 83
    //   71: aload_2
    //   72: ifnull +9 -> 81
    //   75: aload_2
    //   76: invokeinterface 875 1 0
    //   81: aconst_null
    //   82: areturn
    //   83: aload_2
    //   84: invokeinterface 878 1 0
    //   89: istore_1
    //   90: iload_1
    //   91: ifgt +15 -> 106
    //   94: aload_2
    //   95: ifnull +9 -> 104
    //   98: aload_2
    //   99: invokeinterface 875 1 0
    //   104: aconst_null
    //   105: areturn
    //   106: new 144	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   113: astore_3
    //   114: aload_3
    //   115: ldc_w 880
    //   118: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: ldc_w 882
    //   124: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: iconst_0
    //   129: istore_1
    //   130: aload_2
    //   131: invokeinterface 885 1 0
    //   136: ifeq +119 -> 255
    //   139: aload_2
    //   140: invokestatic 887	com/tencent/bugly/crashreport/crash/b:b	(Landroid/database/Cursor;)Lcom/tencent/bugly/crashreport/crash/a;
    //   143: astore 5
    //   145: aload 5
    //   147: ifnull +41 -> 188
    //   150: aload 4
    //   152: aload 5
    //   154: invokeinterface 117 2 0
    //   159: pop
    //   160: goto -30 -> 130
    //   163: astore_3
    //   164: aload_3
    //   165: invokestatic 79	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   168: ifne +7 -> 175
    //   171: aload_3
    //   172: invokevirtual 82	java/lang/Throwable:printStackTrace	()V
    //   175: aload_2
    //   176: ifnull +9 -> 185
    //   179: aload_2
    //   180: invokeinterface 875 1 0
    //   185: aload 4
    //   187: areturn
    //   188: aload_3
    //   189: aload_2
    //   190: aload_2
    //   191: ldc 56
    //   193: invokeinterface 50 2 0
    //   198: invokeinterface 60 2 0
    //   203: invokevirtual 172	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   206: ldc_w 889
    //   209: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: iload_1
    //   214: iconst_1
    //   215: iadd
    //   216: istore_1
    //   217: goto -87 -> 130
    //   220: astore 5
    //   222: ldc_w 891
    //   225: iconst_0
    //   226: anewarray 4	java/lang/Object
    //   229: invokestatic 185	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   232: pop
    //   233: goto -103 -> 130
    //   236: astore 4
    //   238: aload_2
    //   239: astore_3
    //   240: aload 4
    //   242: astore_2
    //   243: aload_3
    //   244: ifnull +9 -> 253
    //   247: aload_3
    //   248: invokeinterface 875 1 0
    //   253: aload_2
    //   254: athrow
    //   255: aload_3
    //   256: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: ldc_w 889
    //   262: invokevirtual 157	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   265: ifeq +116 -> 381
    //   268: new 144	java/lang/StringBuilder
    //   271: dup
    //   272: aload_3
    //   273: iconst_0
    //   274: aload_3
    //   275: ldc_w 889
    //   278: invokevirtual 894	java/lang/StringBuilder:lastIndexOf	(Ljava/lang/String;)I
    //   281: invokevirtual 898	java/lang/StringBuilder:substring	(II)Ljava/lang/String;
    //   284: invokespecial 704	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   287: astore_3
    //   288: aload_3
    //   289: ldc_w 900
    //   292: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: aload_3
    //   297: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: astore 5
    //   302: aload_3
    //   303: iconst_0
    //   304: invokevirtual 903	java/lang/StringBuilder:setLength	(I)V
    //   307: iload_1
    //   308: ifle +40 -> 348
    //   311: ldc_w 905
    //   314: iconst_2
    //   315: anewarray 4	java/lang/Object
    //   318: dup
    //   319: iconst_0
    //   320: ldc_w 871
    //   323: aastore
    //   324: dup
    //   325: iconst_1
    //   326: invokestatic 869	com/tencent/bugly/proguard/p:a	()Lcom/tencent/bugly/proguard/p;
    //   329: ldc_w 871
    //   332: aload 5
    //   334: aconst_null
    //   335: aconst_null
    //   336: iconst_1
    //   337: invokevirtual 908	com/tencent/bugly/proguard/p:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/bugly/proguard/o;Z)I
    //   340: invokestatic 250	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   343: aastore
    //   344: invokestatic 185	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   347: pop
    //   348: aload_2
    //   349: ifnull +9 -> 358
    //   352: aload_2
    //   353: invokeinterface 875 1 0
    //   358: aload 4
    //   360: areturn
    //   361: astore_2
    //   362: aconst_null
    //   363: astore_3
    //   364: goto -121 -> 243
    //   367: astore 4
    //   369: aload_2
    //   370: astore_3
    //   371: aload 4
    //   373: astore_2
    //   374: goto -131 -> 243
    //   377: astore_3
    //   378: goto -214 -> 164
    //   381: goto -93 -> 288
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	384	0	this	b
    //   89	219	1	i	int
    //   1	352	2	localObject1	Object
    //   361	9	2	localObject2	Object
    //   373	1	2	localObject3	Object
    //   64	51	3	localObject4	Object
    //   163	26	3	localThrowable1	Throwable
    //   239	132	3	localObject5	Object
    //   377	1	3	localThrowable2	Throwable
    //   9	177	4	localArrayList	ArrayList
    //   236	123	4	localList	List<a>
    //   367	5	4	localObject6	Object
    //   143	10	5	locala	a
    //   220	1	5	localThrowable3	Throwable
    //   300	33	5	str	String
    // Exception table:
    //   from	to	target	type
    //   83	90	163	java/lang/Throwable
    //   106	128	163	java/lang/Throwable
    //   130	145	163	java/lang/Throwable
    //   150	160	163	java/lang/Throwable
    //   222	233	163	java/lang/Throwable
    //   255	288	163	java/lang/Throwable
    //   288	307	163	java/lang/Throwable
    //   311	348	163	java/lang/Throwable
    //   188	213	220	java/lang/Throwable
    //   83	90	236	finally
    //   106	128	236	finally
    //   130	145	236	finally
    //   150	160	236	finally
    //   188	213	236	finally
    //   222	233	236	finally
    //   255	288	236	finally
    //   288	307	236	finally
    //   311	348	236	finally
    //   11	65	361	finally
    //   164	175	367	finally
    //   11	65	377	java/lang/Throwable
  }
  
  /* Error */
  private List<CrashDetailBean> b(List<a> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 89 1 0
    //   10: ifne +5 -> 15
    //   13: aconst_null
    //   14: areturn
    //   15: new 144	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   22: astore_3
    //   23: aload_3
    //   24: ldc_w 880
    //   27: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc_w 882
    //   33: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload_1
    //   38: invokeinterface 98 1 0
    //   43: astore_1
    //   44: aload_1
    //   45: invokeinterface 104 1 0
    //   50: ifeq +29 -> 79
    //   53: aload_3
    //   54: aload_1
    //   55: invokeinterface 108 1 0
    //   60: checkcast 110	com/tencent/bugly/crashreport/crash/a
    //   63: getfield 842	com/tencent/bugly/crashreport/crash/a:a	J
    //   66: invokevirtual 172	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   69: ldc_w 889
    //   72: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: goto -32 -> 44
    //   79: aload_3
    //   80: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: ldc_w 889
    //   86: invokevirtual 157	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   89: ifeq +348 -> 437
    //   92: new 144	java/lang/StringBuilder
    //   95: dup
    //   96: aload_3
    //   97: iconst_0
    //   98: aload_3
    //   99: ldc_w 889
    //   102: invokevirtual 894	java/lang/StringBuilder:lastIndexOf	(Ljava/lang/String;)I
    //   105: invokevirtual 898	java/lang/StringBuilder:substring	(II)Ljava/lang/String;
    //   108: invokespecial 704	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   111: astore_3
    //   112: aload_3
    //   113: ldc_w 900
    //   116: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload_3
    //   121: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: astore_1
    //   125: aload_3
    //   126: iconst_0
    //   127: invokevirtual 903	java/lang/StringBuilder:setLength	(I)V
    //   130: invokestatic 869	com/tencent/bugly/proguard/p:a	()Lcom/tencent/bugly/proguard/p;
    //   133: ldc_w 871
    //   136: aconst_null
    //   137: aload_1
    //   138: aconst_null
    //   139: aconst_null
    //   140: iconst_1
    //   141: invokevirtual 874	com/tencent/bugly/proguard/p:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/bugly/proguard/o;Z)Landroid/database/Cursor;
    //   144: astore_1
    //   145: aload_1
    //   146: ifnonnull +15 -> 161
    //   149: aload_1
    //   150: ifnull +9 -> 159
    //   153: aload_1
    //   154: invokeinterface 875 1 0
    //   159: aconst_null
    //   160: areturn
    //   161: new 91	java/util/ArrayList
    //   164: dup
    //   165: invokespecial 342	java/util/ArrayList:<init>	()V
    //   168: astore 5
    //   170: aload_3
    //   171: ldc_w 880
    //   174: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: ldc_w 882
    //   180: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: iconst_0
    //   185: istore_2
    //   186: aload_1
    //   187: invokeinterface 885 1 0
    //   192: ifeq +118 -> 310
    //   195: aload_1
    //   196: invokestatic 911	com/tencent/bugly/crashreport/crash/b:a	(Landroid/database/Cursor;)Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;
    //   199: astore 4
    //   201: aload 4
    //   203: ifnull +40 -> 243
    //   206: aload 5
    //   208: aload 4
    //   210: invokeinterface 117 2 0
    //   215: pop
    //   216: goto -30 -> 186
    //   219: astore_3
    //   220: aload_3
    //   221: invokestatic 79	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   224: ifne +7 -> 231
    //   227: aload_3
    //   228: invokevirtual 82	java/lang/Throwable:printStackTrace	()V
    //   231: aload_1
    //   232: ifnull +9 -> 241
    //   235: aload_1
    //   236: invokeinterface 875 1 0
    //   241: aconst_null
    //   242: areturn
    //   243: aload_3
    //   244: aload_1
    //   245: aload_1
    //   246: ldc 56
    //   248: invokeinterface 50 2 0
    //   253: invokeinterface 60 2 0
    //   258: invokevirtual 172	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   261: ldc_w 889
    //   264: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: iload_2
    //   269: iconst_1
    //   270: iadd
    //   271: istore_2
    //   272: goto -86 -> 186
    //   275: astore 4
    //   277: ldc_w 891
    //   280: iconst_0
    //   281: anewarray 4	java/lang/Object
    //   284: invokestatic 185	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   287: pop
    //   288: goto -102 -> 186
    //   291: astore 4
    //   293: aload_1
    //   294: astore_3
    //   295: aload 4
    //   297: astore_1
    //   298: aload_3
    //   299: ifnull +9 -> 308
    //   302: aload_3
    //   303: invokeinterface 875 1 0
    //   308: aload_1
    //   309: athrow
    //   310: aload_3
    //   311: astore 4
    //   313: aload_3
    //   314: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: ldc_w 889
    //   320: invokevirtual 157	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   323: ifeq +24 -> 347
    //   326: new 144	java/lang/StringBuilder
    //   329: dup
    //   330: aload_3
    //   331: iconst_0
    //   332: aload_3
    //   333: ldc_w 889
    //   336: invokevirtual 894	java/lang/StringBuilder:lastIndexOf	(Ljava/lang/String;)I
    //   339: invokevirtual 898	java/lang/StringBuilder:substring	(II)Ljava/lang/String;
    //   342: invokespecial 704	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   345: astore 4
    //   347: aload 4
    //   349: ldc_w 900
    //   352: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: aload 4
    //   358: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: astore_3
    //   362: iload_2
    //   363: ifle +39 -> 402
    //   366: ldc_w 905
    //   369: iconst_2
    //   370: anewarray 4	java/lang/Object
    //   373: dup
    //   374: iconst_0
    //   375: ldc_w 871
    //   378: aastore
    //   379: dup
    //   380: iconst_1
    //   381: invokestatic 869	com/tencent/bugly/proguard/p:a	()Lcom/tencent/bugly/proguard/p;
    //   384: ldc_w 871
    //   387: aload_3
    //   388: aconst_null
    //   389: aconst_null
    //   390: iconst_1
    //   391: invokevirtual 908	com/tencent/bugly/proguard/p:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/bugly/proguard/o;Z)I
    //   394: invokestatic 250	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   397: aastore
    //   398: invokestatic 185	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   401: pop
    //   402: aload_1
    //   403: ifnull +9 -> 412
    //   406: aload_1
    //   407: invokeinterface 875 1 0
    //   412: aload 5
    //   414: areturn
    //   415: astore_1
    //   416: aconst_null
    //   417: astore_3
    //   418: goto -120 -> 298
    //   421: astore 4
    //   423: aload_1
    //   424: astore_3
    //   425: aload 4
    //   427: astore_1
    //   428: goto -130 -> 298
    //   431: astore_3
    //   432: aconst_null
    //   433: astore_1
    //   434: goto -214 -> 220
    //   437: goto -325 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	440	0	this	b
    //   0	440	1	paramList	List<a>
    //   185	178	2	i	int
    //   22	149	3	localStringBuilder	StringBuilder
    //   219	25	3	localThrowable1	Throwable
    //   294	131	3	localObject1	Object
    //   431	1	3	localThrowable2	Throwable
    //   199	10	4	localCrashDetailBean	CrashDetailBean
    //   275	1	4	localThrowable3	Throwable
    //   291	5	4	localObject2	Object
    //   311	46	4	localObject3	Object
    //   421	5	4	localObject4	Object
    //   168	245	5	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   161	184	219	java/lang/Throwable
    //   186	201	219	java/lang/Throwable
    //   206	216	219	java/lang/Throwable
    //   277	288	219	java/lang/Throwable
    //   313	347	219	java/lang/Throwable
    //   347	362	219	java/lang/Throwable
    //   366	402	219	java/lang/Throwable
    //   243	268	275	java/lang/Throwable
    //   161	184	291	finally
    //   186	201	291	finally
    //   206	216	291	finally
    //   243	268	291	finally
    //   277	288	291	finally
    //   313	347	291	finally
    //   347	362	291	finally
    //   366	402	291	finally
    //   130	145	415	finally
    //   220	231	421	finally
    //   130	145	431	java/lang/Throwable
  }
  
  private static void c(List<a> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    do
    {
      return;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("_id in ").append("(");
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((StringBuilder)localObject).append(((a)paramList.next()).a).append(",");
      }
      paramList = new StringBuilder(((StringBuilder)localObject).substring(0, ((StringBuilder)localObject).lastIndexOf(",")));
      paramList.append(")");
      localObject = paramList.toString();
      paramList.setLength(0);
      try
      {
        x.c("deleted %s data %d", new Object[] { "t_cr", Integer.valueOf(p.a().a("t_cr", (String)localObject, null, null, true)) });
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
  
  private static ContentValues f(CrashDetailBean paramCrashDetailBean)
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
  
  private boolean g(CrashDetailBean paramCrashDetailBean)
  {
    try
    {
      x.c("save eup logs", new Object[0]);
      Object localObject = com.tencent.bugly.crashreport.common.info.a.b();
      String str1 = ((com.tencent.bugly.crashreport.common.info.a)localObject).e();
      String str2 = ((com.tencent.bugly.crashreport.common.info.a)localObject).m;
      String str3 = paramCrashDetailBean.A;
      str1 = String.format(Locale.US, "#--------\npackage:%s\nversion:%s\nsdk:%s\nprocess:%s\ndate:%s\ntype:%s\nmessage:%s\nstack:\n%s\neupID:%s\n", new Object[] { str1, str2, ((com.tencent.bugly.crashreport.common.info.a)localObject).g, str3, z.a(new Date(paramCrashDetailBean.r)), paramCrashDetailBean.n, paramCrashDetailBean.o, paramCrashDetailBean.q, paramCrashDetailBean.c });
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
      if (!((StrategyBean)localObject1).f)
      {
        x.d("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
        x.b("[init] WARNING! Crashreport closed by server, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
        return null;
      }
      l1 = System.currentTimeMillis();
      l2 = z.b();
      localList = b();
      x.c("Size of crash list loaded from DB: %s", new Object[] { Integer.valueOf(localList.size()) });
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
      localObject2 = com.tencent.bugly.crashreport.common.info.a.b().m;
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
  
  public final void a(List<CrashDetailBean> paramList, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!com.tencent.bugly.crashreport.common.info.a.a(this.c).f) {}
    Object localObject1;
    String str;
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.d == null) || ((!paramBoolean3) && (!this.d.b(c.a))));
        localObject1 = this.f.c();
        if (!((StrategyBean)localObject1).f)
        {
          x.d("remote report is disable!", new Object[0]);
          x.b("[crash] server closed bugly in this app. please check your appid if is correct, and re-install it", new Object[0]);
          return;
        }
      } while ((paramList == null) || (paramList.size() == 0));
      try
      {
        localObject1 = ((StrategyBean)localObject1).r;
        str = StrategyBean.c;
        localObject2 = a(this.c, paramList, com.tencent.bugly.crashreport.common.info.a.b());
        if (localObject2 != null) {
          break;
        }
        x.d("create eupPkg fail!", new Object[0]);
        return;
      }
      catch (Throwable paramList)
      {
        x.e("req cr error %s", new Object[] { paramList.toString() });
      }
    } while (x.b(paramList));
    paramList.printStackTrace();
    return;
    Object localObject2 = com.tencent.bugly.proguard.a.a((k)localObject2);
    if (localObject2 == null)
    {
      x.d("send encode fail!", new Object[0]);
      return;
    }
    localObject2 = com.tencent.bugly.proguard.a.a(this.c, 830, (byte[])localObject2);
    if (localObject2 == null)
    {
      x.d("request package is null.", new Object[0]);
      return;
    }
    paramList = new b.1(this, paramList);
    if (paramBoolean1)
    {
      this.d.a(b, (am)localObject2, (String)localObject1, str, paramList, paramLong, paramBoolean2);
      return;
    }
    this.d.a(b, (am)localObject2, (String)localObject1, str, paramList, false);
  }
  
  public final boolean a(CrashDetailBean paramCrashDetailBean)
  {
    return b(paramCrashDetailBean);
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
  
  public final boolean b(CrashDetailBean paramCrashDetailBean)
  {
    Object localObject2 = null;
    if (paramCrashDetailBean == null) {
      return true;
    }
    Object localObject1;
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
      Object localObject3 = b();
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((List)localObject3).size() > 0)
        {
          localObject1 = new ArrayList(10);
          localObject2 = new ArrayList(10);
          ((List)localObject1).addAll(a((List)localObject3));
          ((List)localObject3).removeAll((Collection)localObject1);
          Object localObject4;
          String str;
          if (((List)localObject3).size() > 20L)
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("_id in ").append("(");
            ((StringBuilder)localObject4).append("SELECT _id").append(" FROM t_cr").append(" order by _id").append(" limit 5");
            ((StringBuilder)localObject4).append(")");
            str = ((StringBuilder)localObject4).toString();
            ((StringBuilder)localObject4).setLength(0);
          }
          try
          {
            x.c("deleted first record %s data %d", new Object[] { "t_cr", Integer.valueOf(p.a().a("t_cr", str, null, null, true)) });
            if ((!com.tencent.bugly.b.c) && (c.d))
            {
              localObject3 = ((List)localObject3).iterator();
              i = 0;
              while (((Iterator)localObject3).hasNext())
              {
                localObject4 = (a)((Iterator)localObject3).next();
                int j = i;
                if (paramCrashDetailBean.u.equals(((a)localObject4).c))
                {
                  if (((a)localObject4).e) {
                    i = 1;
                  }
                  ((List)localObject2).add(localObject4);
                  j = i;
                }
                i = j;
                continue;
                x.b("[crash] a caught exception occur, handling...", new Object[0]);
              }
            }
          }
          catch (Throwable localThrowable)
          {
            int i;
            for (;;)
            {
              if (!x.a(localThrowable)) {
                localThrowable.printStackTrace();
              }
            }
            if ((i != 0) || (((List)localObject2).size() >= c.c))
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
              e(paramCrashDetailBean);
              c((List)localObject1);
              x.b("[crash] save crash success. For this device crash many times, it will not upload crashes immediately", new Object[0]);
              return true;
            }
          }
        }
      }
    }
    e(paramCrashDetailBean);
    if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
      c((List)localObject1);
    }
    x.b("[crash] save crash success", new Object[0]);
    return false;
  }
  
  public final void c(CrashDetailBean paramCrashDetailBean)
  {
    boolean bool = true;
    f localf;
    switch (paramCrashDetailBean.b)
    {
    case 2: 
    default: 
      if (this.a != null)
      {
        x.c("Calling 'onCrashHandleEnd' of RQD crash listener.", new Object[0]);
        localf = this.a;
        if (paramCrashDetailBean.b != 1) {
          break label106;
        }
      }
      break;
    }
    for (;;)
    {
      localf.b(bool);
      return;
      if (c.a().o()) {
        break;
      }
      return;
      if (c.a().n()) {
        break;
      }
      return;
      if (c.a().n()) {
        break;
      }
      return;
      label106:
      bool = false;
    }
  }
  
  public final void d(CrashDetailBean paramCrashDetailBean)
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
      boolean bool;
      String str2;
      String str3;
      String str4;
      long l;
      String str1;
      Object localObject1;
      Object localObject2;
      Object localObject3;
      try
      {
        switch (paramCrashDetailBean.b)
        {
        case 0: 
          if (!c.a().n()) {
            break;
          }
        case 2: 
        case 7: 
          if (paramCrashDetailBean.b != 1) {
            break label944;
          }
          bool = true;
          str2 = paramCrashDetailBean.n;
          str3 = paramCrashDetailBean.p;
          str4 = paramCrashDetailBean.q;
          l = paramCrashDetailBean.r;
          if (this.a == null) {
            break label564;
          }
          x.c("Calling 'onCrashHandleStart' of RQD crash listener.", new Object[0]);
          this.a.a(bool);
          x.c("Calling 'getCrashExtraMessage' of RQD crash listener.", new Object[0]);
          str1 = this.a.b(bool, str2, str3, str4, -1234567890, l);
          if (str1 == null) {
            break label937;
          }
          localObject1 = new HashMap(1);
          ((Map)localObject1).put("userData", str1);
          if ((localObject1 == null) || (((Map)localObject1).size() <= 0)) {
            break label644;
          }
          paramCrashDetailBean.O = new LinkedHashMap(((Map)localObject1).size());
          localObject2 = ((Map)localObject1).entrySet().iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label644;
          }
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          if (z.a((String)((Map.Entry)localObject3).getKey())) {
            continue;
          }
          str1 = (String)((Map.Entry)localObject3).getKey();
          localObject1 = str1;
          if (str1.length() > 100)
          {
            localObject1 = str1.substring(0, 100);
            x.d("setted key length is over limit %d substring to %s", new Object[] { Integer.valueOf(100), localObject1 });
          }
          if ((z.a((String)((Map.Entry)localObject3).getValue())) || (((String)((Map.Entry)localObject3).getValue()).length() <= 30000)) {
            break label616;
          }
          str1 = ((String)((Map.Entry)localObject3).getValue()).substring(((String)((Map.Entry)localObject3).getValue()).length() - 30000);
          x.d("setted %s value length is over limit %d substring", new Object[] { localObject1, Integer.valueOf(30000) });
          paramCrashDetailBean.O.put(localObject1, str1);
          x.a("add setted key %s value size:%d", new Object[] { localObject1, Integer.valueOf(str1.length()) });
          continue;
          if (x.a(paramCrashDetailBean)) {
            break;
          }
        }
      }
      catch (Throwable paramCrashDetailBean)
      {
        x.d("crash handle callback something wrong! %s", new Object[] { paramCrashDetailBean.getClass().getName() });
      }
      paramCrashDetailBean.printStackTrace();
      return;
      if (!c.a().o())
      {
        return;
        if (!c.a().n())
        {
          return;
          if (!c.a().p())
          {
            return;
            if (!c.a().q())
            {
              return;
              label644:
              label937:
              label944:
              if (!c.a().r())
              {
                return;
                label564:
                if (this.g != null)
                {
                  x.c("Calling 'onCrashHandleStart' of Bugly crash listener.", new Object[0]);
                  localObject1 = this.g;
                  str1 = paramCrashDetailBean.n;
                  str1 = paramCrashDetailBean.o;
                  str1 = paramCrashDetailBean.q;
                  localObject1 = ((com.tencent.bugly.proguard.a)localObject1).b();
                  continue;
                  label616:
                  str1 = (String)((Map.Entry)localObject3).getValue();
                  continue;
                  x.a("[crash callback] start user's callback:onCrashHandleStart2GetExtraDatas()", new Object[0]);
                  localObject1 = null;
                  if (this.a != null)
                  {
                    x.c("Calling 'getCrashExtraData' of RQD crash listener.", new Object[0]);
                    localObject1 = this.a.a(bool, str2, str3, str4, -1234567890, l);
                  }
                  for (;;)
                  {
                    paramCrashDetailBean.U = ((byte[])localObject1);
                    if (localObject1 != null)
                    {
                      if (localObject1.length > 30000)
                      {
                        x.d("extra bytes size %d is over limit %d will drop over part", new Object[] { Integer.valueOf(localObject1.length), Integer.valueOf(30000) });
                        paramCrashDetailBean.U = Arrays.copyOf((byte[])localObject1, 30000);
                      }
                      x.a("add extra bytes %d ", new Object[] { Integer.valueOf(localObject1.length) });
                    }
                    if (this.a == null) {
                      break;
                    }
                    x.c("Calling 'onCrashSaving' of RQD crash listener.", new Object[0]);
                    localObject1 = this.a;
                    str1 = paramCrashDetailBean.o;
                    str1 = paramCrashDetailBean.m;
                    localObject2 = paramCrashDetailBean.e;
                    localObject3 = paramCrashDetailBean.c;
                    String str5 = paramCrashDetailBean.A;
                    paramCrashDetailBean = paramCrashDetailBean.B;
                    if (((f)localObject1).a(bool, str2, str3, str4, -1234567890, l, str1, (String)localObject2, (String)localObject3, str5)) {
                      break;
                    }
                    x.d("Crash listener 'onCrashSaving' return 'false' thus will not handle this crash.", new Object[0]);
                    return;
                    if (this.g != null)
                    {
                      x.c("Calling 'onCrashHandleStart2GetExtraDatas' of Bugly crash listener.", new Object[0]);
                      localObject1 = this.g;
                      str1 = paramCrashDetailBean.n;
                      str1 = paramCrashDetailBean.o;
                      str1 = paramCrashDetailBean.q;
                      localObject1 = ((com.tencent.bugly.proguard.a)localObject1).c();
                    }
                  }
                }
                else
                {
                  localObject1 = null;
                  continue;
                  localObject1 = null;
                  continue;
                  return;
                  bool = false;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final void e(CrashDetailBean paramCrashDetailBean)
  {
    if (paramCrashDetailBean == null) {}
    do
    {
      return;
      ContentValues localContentValues = f(paramCrashDetailBean);
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
    g(paramCrashDetailBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.crash.b
 * JD-Core Version:    0.7.0.1
 */