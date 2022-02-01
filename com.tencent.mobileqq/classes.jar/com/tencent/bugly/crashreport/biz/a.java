package com.tencent.bugly.crashreport.biz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.am;
import com.tencent.bugly.proguard.k;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.t;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.bugly.crashreport.biz.UserInfoBean;>;

public final class a
{
  private Context a;
  private long b;
  private int c;
  private boolean d = true;
  
  public a(Context paramContext, boolean paramBoolean)
  {
    this.a = paramContext;
    this.d = paramBoolean;
  }
  
  private static ContentValues a(UserInfoBean paramUserInfoBean)
  {
    if (paramUserInfoBean == null) {
      return null;
    }
    try
    {
      ContentValues localContentValues = new ContentValues();
      if (paramUserInfoBean.a > 0L) {
        localContentValues.put("_id", Long.valueOf(paramUserInfoBean.a));
      }
      localContentValues.put("_tm", Long.valueOf(paramUserInfoBean.e));
      localContentValues.put("_ut", Long.valueOf(paramUserInfoBean.f));
      localContentValues.put("_tp", Integer.valueOf(paramUserInfoBean.b));
      localContentValues.put("_pc", paramUserInfoBean.c);
      localContentValues.put("_dt", z.a(paramUserInfoBean));
      return localContentValues;
    }
    catch (Throwable paramUserInfoBean)
    {
      if (!x.a(paramUserInfoBean)) {
        paramUserInfoBean.printStackTrace();
      }
    }
    return null;
  }
  
  private static UserInfoBean a(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return null;
    }
    try
    {
      byte[] arrayOfByte = paramCursor.getBlob(paramCursor.getColumnIndex("_dt"));
      if (arrayOfByte == null) {
        return null;
      }
      long l = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
      paramCursor = (UserInfoBean)z.a(arrayOfByte, UserInfoBean.CREATOR);
      if (paramCursor != null) {
        paramCursor.a = l;
      }
      return paramCursor;
    }
    catch (Throwable paramCursor)
    {
      if (!x.a(paramCursor)) {
        paramCursor.printStackTrace();
      }
    }
    return null;
  }
  
  private static void a(List<UserInfoBean> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while ((i < paramList.size()) && (i < 50))
      {
        localObject = (UserInfoBean)paramList.get(i);
        localStringBuilder.append(" or _id");
        localStringBuilder.append(" = ");
        localStringBuilder.append(((UserInfoBean)localObject).a);
        i += 1;
      }
      Object localObject = localStringBuilder.toString();
      paramList = (List<UserInfoBean>)localObject;
      if (((String)localObject).length() > 0) {
        paramList = ((String)localObject).substring(4);
      }
      localStringBuilder.setLength(0);
      try
      {
        x.c("[Database] deleted %s data %d", new Object[] { "t_ui", Integer.valueOf(p.a().a("t_ui", paramList, null, null, true)) });
        return;
      }
      catch (Throwable paramList)
      {
        if (!x.a(paramList)) {
          paramList.printStackTrace();
        }
      }
    }
  }
  
  private void c()
  {
    try
    {
      bool = this.d;
      if (!bool) {
        return;
      }
      localObject1 = u.a();
      if (localObject1 == null) {
        return;
      }
      localObject3 = com.tencent.bugly.crashreport.common.strategy.a.a();
      if (localObject3 == null) {
        return;
      }
      if (((com.tencent.bugly.crashreport.common.strategy.a)localObject3).b())
      {
        bool = ((u)localObject1).b(1001);
        if (!bool) {
          return;
        }
      }
      localObject1 = com.tencent.bugly.crashreport.common.info.a.a(this.a).d;
      localObject4 = new ArrayList();
      localObject3 = a((String)localObject1);
      if (localObject3 == null) {
        break label413;
      }
      m = ((List)localObject3).size() - 20;
      if (m <= 0) {
        break label256;
      }
      i = 0;
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        Object localObject3;
        Object localObject4;
        int m;
        int j;
        int k;
        label256:
        Object localObject5;
        label413:
        label425:
        u localu;
        for (;;)
        {
          throw localObject2;
        }
        label675:
        k += 1;
        continue;
        int i = j;
        continue;
        i = 0;
        continue;
        label692:
        i += 1;
        continue;
        label699:
        i = 1;
        continue;
        label704:
        i = 2;
        continue;
        label709:
        boolean bool = false;
      }
    }
    if (i < ((List)localObject3).size() - 1)
    {
      j = i + 1;
      k = j;
      if (k < ((List)localObject3).size()) {
        if (((UserInfoBean)((List)localObject3).get(i)).e > ((UserInfoBean)((List)localObject3).get(k)).e)
        {
          localObject1 = (UserInfoBean)((List)localObject3).get(i);
          ((List)localObject3).set(i, ((List)localObject3).get(k));
          ((List)localObject3).set(k, localObject1);
          break label675;
          while (i < m)
          {
            ((List)localObject4).add(((List)localObject3).get(i));
            i += 1;
          }
          localObject1 = ((List)localObject3).iterator();
          i = 0;
          while (((Iterator)localObject1).hasNext())
          {
            localObject5 = (UserInfoBean)((Iterator)localObject1).next();
            if (((UserInfoBean)localObject5).f != -1L)
            {
              ((Iterator)localObject1).remove();
              if (((UserInfoBean)localObject5).e < z.b()) {
                ((List)localObject4).add(localObject5);
              }
            }
            if (((UserInfoBean)localObject5).e > System.currentTimeMillis() - 600000L)
            {
              if ((((UserInfoBean)localObject5).b == 1) || (((UserInfoBean)localObject5).b == 4)) {
                break label692;
              }
              if (((UserInfoBean)localObject5).b == 3) {
                break label692;
              }
            }
          }
          localObject1 = localObject3;
          if (i <= 15) {
            break label699;
          }
          x.d("[UserInfo] Upload user info too many times in 10 min: %d", new Object[] { Integer.valueOf(i) });
          i = 0;
          localObject1 = localObject3;
          break label425;
          localObject1 = new ArrayList();
          break label699;
          if (((List)localObject4).size() > 0) {
            a((List)localObject4);
          }
          if ((i != 0) && (((List)localObject1).size() != 0))
          {
            x.c("[UserInfo] Upload user info(size: %d)", new Object[] { Integer.valueOf(((List)localObject1).size()) });
            if (this.c != 1) {
              break label704;
            }
            i = 1;
            localObject3 = com.tencent.bugly.proguard.a.a((List)localObject1, i);
            if (localObject3 == null)
            {
              x.d("[UserInfo] Failed to create UserInfoPackage.", new Object[0]);
              return;
            }
            localObject3 = com.tencent.bugly.proguard.a.a((k)localObject3);
            if (localObject3 == null)
            {
              x.d("[UserInfo] Failed to encode data.", new Object[0]);
              return;
            }
            localObject3 = com.tencent.bugly.proguard.a.a(this.a, 840, (byte[])localObject3);
            if (localObject3 == null)
            {
              x.d("[UserInfo] Request package is null.", new Object[0]);
              return;
            }
            localObject1 = new a.1(this, (List)localObject1);
            localObject4 = com.tencent.bugly.crashreport.common.strategy.a.a().c().q;
            localObject5 = StrategyBean.b;
            localu = u.a();
            if (this.c != 1) {
              break label709;
            }
            bool = true;
            localu.a(1001, (am)localObject3, (String)localObject4, (String)localObject5, (t)localObject1, bool);
            return;
          }
          x.c("[UserInfo] There is no user info in local database.", new Object[0]);
          return;
        }
      }
    }
  }
  
  /* Error */
  public final List<UserInfoBean> a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 306	com/tencent/bugly/proguard/z:a	(Ljava/lang/String;)Z
    //   4: ifeq +8 -> 12
    //   7: aconst_null
    //   8: astore_1
    //   9: goto +37 -> 46
    //   12: new 158	java/lang/StringBuilder
    //   15: dup
    //   16: ldc_w 308
    //   19: invokespecial 311	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: astore 4
    //   24: aload 4
    //   26: aload_1
    //   27: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 4
    //   33: ldc_w 313
    //   36: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 4
    //   42: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: astore_1
    //   46: invokestatic 146	com/tencent/bugly/proguard/p:a	()Lcom/tencent/bugly/proguard/p;
    //   49: ldc 148
    //   51: aconst_null
    //   52: aload_1
    //   53: aconst_null
    //   54: aconst_null
    //   55: iconst_1
    //   56: invokevirtual 316	com/tencent/bugly/proguard/p:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/bugly/proguard/o;Z)Landroid/database/Cursor;
    //   59: astore 4
    //   61: aload 4
    //   63: ifnonnull +17 -> 80
    //   66: aload 4
    //   68: ifnull +10 -> 78
    //   71: aload 4
    //   73: invokeinterface 319 1 0
    //   78: aconst_null
    //   79: areturn
    //   80: aload 4
    //   82: astore_1
    //   83: new 158	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   90: astore 6
    //   92: aload 4
    //   94: astore_1
    //   95: new 219	java/util/ArrayList
    //   98: dup
    //   99: invokespecial 220	java/util/ArrayList:<init>	()V
    //   102: astore 5
    //   104: aload 4
    //   106: astore_1
    //   107: aload 4
    //   109: invokeinterface 322 1 0
    //   114: ifeq +106 -> 220
    //   117: aload 4
    //   119: astore_1
    //   120: aload 4
    //   122: invokestatic 324	com/tencent/bugly/crashreport/biz/a:a	(Landroid/database/Cursor;)Lcom/tencent/bugly/crashreport/biz/UserInfoBean;
    //   125: astore 7
    //   127: aload 7
    //   129: ifnull +19 -> 148
    //   132: aload 4
    //   134: astore_1
    //   135: aload 5
    //   137: aload 7
    //   139: invokeinterface 228 2 0
    //   144: pop
    //   145: goto -41 -> 104
    //   148: aload 4
    //   150: astore_1
    //   151: aload 4
    //   153: aload 4
    //   155: ldc 34
    //   157: invokeinterface 99 2 0
    //   162: invokeinterface 107 2 0
    //   167: lstore_2
    //   168: aload 4
    //   170: astore_1
    //   171: aload 6
    //   173: ldc 165
    //   175: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload 4
    //   181: astore_1
    //   182: aload 6
    //   184: ldc 171
    //   186: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload 4
    //   192: astore_1
    //   193: aload 6
    //   195: lload_2
    //   196: invokevirtual 174	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: goto -96 -> 104
    //   203: aload 4
    //   205: astore_1
    //   206: ldc_w 326
    //   209: iconst_0
    //   210: anewarray 4	java/lang/Object
    //   213: invokestatic 260	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   216: pop
    //   217: goto -113 -> 104
    //   220: aload 4
    //   222: astore_1
    //   223: aload 6
    //   225: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: astore 6
    //   230: aload 4
    //   232: astore_1
    //   233: aload 6
    //   235: invokevirtual 183	java/lang/String:length	()I
    //   238: ifle +52 -> 290
    //   241: aload 4
    //   243: astore_1
    //   244: aload 6
    //   246: iconst_4
    //   247: invokevirtual 187	java/lang/String:substring	(I)Ljava/lang/String;
    //   250: astore 6
    //   252: aload 4
    //   254: astore_1
    //   255: ldc_w 328
    //   258: iconst_2
    //   259: anewarray 4	java/lang/Object
    //   262: dup
    //   263: iconst_0
    //   264: ldc 148
    //   266: aastore
    //   267: dup
    //   268: iconst_1
    //   269: invokestatic 146	com/tencent/bugly/proguard/p:a	()Lcom/tencent/bugly/proguard/p;
    //   272: ldc 148
    //   274: aload 6
    //   276: aconst_null
    //   277: aconst_null
    //   278: iconst_1
    //   279: invokevirtual 196	com/tencent/bugly/proguard/p:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/bugly/proguard/o;Z)I
    //   282: invokestatic 63	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   285: aastore
    //   286: invokestatic 260	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   289: pop
    //   290: aload 4
    //   292: ifnull +10 -> 302
    //   295: aload 4
    //   297: invokeinterface 319 1 0
    //   302: aload 5
    //   304: areturn
    //   305: astore 5
    //   307: goto +15 -> 322
    //   310: astore_1
    //   311: aconst_null
    //   312: astore 4
    //   314: goto +49 -> 363
    //   317: astore 5
    //   319: aconst_null
    //   320: astore 4
    //   322: aload 4
    //   324: astore_1
    //   325: aload 5
    //   327: invokestatic 89	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   330: ifne +11 -> 341
    //   333: aload 4
    //   335: astore_1
    //   336: aload 5
    //   338: invokevirtual 92	java/lang/Throwable:printStackTrace	()V
    //   341: aload 4
    //   343: ifnull +10 -> 353
    //   346: aload 4
    //   348: invokeinterface 319 1 0
    //   353: aconst_null
    //   354: areturn
    //   355: astore 5
    //   357: aload_1
    //   358: astore 4
    //   360: aload 5
    //   362: astore_1
    //   363: aload 4
    //   365: ifnull +10 -> 375
    //   368: aload 4
    //   370: invokeinterface 319 1 0
    //   375: goto +5 -> 380
    //   378: aload_1
    //   379: athrow
    //   380: goto -2 -> 378
    //   383: astore_1
    //   384: goto -181 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	387	0	this	a
    //   0	387	1	paramString	String
    //   167	29	2	l	long
    //   22	347	4	localObject1	Object
    //   102	201	5	localArrayList	ArrayList
    //   305	1	5	localThrowable1	Throwable
    //   317	20	5	localThrowable2	Throwable
    //   355	6	5	localObject2	Object
    //   90	185	6	localObject3	Object
    //   125	13	7	localUserInfoBean	UserInfoBean
    // Exception table:
    //   from	to	target	type
    //   83	92	305	java/lang/Throwable
    //   95	104	305	java/lang/Throwable
    //   107	117	305	java/lang/Throwable
    //   120	127	305	java/lang/Throwable
    //   135	145	305	java/lang/Throwable
    //   206	217	305	java/lang/Throwable
    //   223	230	305	java/lang/Throwable
    //   233	241	305	java/lang/Throwable
    //   244	252	305	java/lang/Throwable
    //   255	290	305	java/lang/Throwable
    //   0	7	310	finally
    //   12	46	310	finally
    //   46	61	310	finally
    //   0	7	317	java/lang/Throwable
    //   12	46	317	java/lang/Throwable
    //   46	61	317	java/lang/Throwable
    //   83	92	355	finally
    //   95	104	355	finally
    //   107	117	355	finally
    //   120	127	355	finally
    //   135	145	355	finally
    //   151	168	355	finally
    //   171	179	355	finally
    //   182	190	355	finally
    //   193	200	355	finally
    //   206	217	355	finally
    //   223	230	355	finally
    //   233	241	355	finally
    //   244	252	355	finally
    //   255	290	355	finally
    //   325	333	355	finally
    //   336	341	355	finally
    //   151	168	383	java/lang/Throwable
    //   171	179	383	java/lang/Throwable
    //   182	190	383	java/lang/Throwable
    //   193	200	383	java/lang/Throwable
  }
  
  public final void a()
  {
    this.b = (z.b() + 86400000L);
    w.a().a(new a.b(this), this.b - System.currentTimeMillis() + 5000L);
  }
  
  public final void a(int paramInt, boolean paramBoolean, long paramLong)
  {
    Object localObject = com.tencent.bugly.crashreport.common.strategy.a.a();
    int i = 0;
    if ((localObject != null) && (!((com.tencent.bugly.crashreport.common.strategy.a)localObject).c().g) && (paramInt != 1) && (paramInt != 3))
    {
      x.e("UserInfo is disable", new Object[0]);
      return;
    }
    if ((paramInt == 1) || (paramInt == 3)) {
      this.c += 1;
    }
    localObject = com.tencent.bugly.crashreport.common.info.a.a(this.a);
    UserInfoBean localUserInfoBean = new UserInfoBean();
    localUserInfoBean.b = paramInt;
    localUserInfoBean.c = ((com.tencent.bugly.crashreport.common.info.a)localObject).d;
    localUserInfoBean.d = ((com.tencent.bugly.crashreport.common.info.a)localObject).f();
    localUserInfoBean.e = System.currentTimeMillis();
    localUserInfoBean.f = -1L;
    localUserInfoBean.n = ((com.tencent.bugly.crashreport.common.info.a)localObject).m;
    if (paramInt == 1) {
      i = 1;
    }
    localUserInfoBean.o = i;
    localUserInfoBean.l = ((com.tencent.bugly.crashreport.common.info.a)localObject).a();
    localUserInfoBean.m = ((com.tencent.bugly.crashreport.common.info.a)localObject).s;
    localUserInfoBean.g = ((com.tencent.bugly.crashreport.common.info.a)localObject).t;
    localUserInfoBean.h = ((com.tencent.bugly.crashreport.common.info.a)localObject).u;
    localUserInfoBean.i = ((com.tencent.bugly.crashreport.common.info.a)localObject).v;
    localUserInfoBean.k = ((com.tencent.bugly.crashreport.common.info.a)localObject).w;
    localUserInfoBean.r = ((com.tencent.bugly.crashreport.common.info.a)localObject).z();
    localUserInfoBean.s = ((com.tencent.bugly.crashreport.common.info.a)localObject).E();
    localUserInfoBean.p = ((com.tencent.bugly.crashreport.common.info.a)localObject).F();
    localUserInfoBean.q = ((com.tencent.bugly.crashreport.common.info.a)localObject).G();
    w.a().a(new a.a(this, localUserInfoBean, paramBoolean), 0L);
  }
  
  public final void b()
  {
    w localw = w.a();
    if (localw != null) {
      localw.a(new a.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.bugly.crashreport.biz.a
 * JD-Core Version:    0.7.0.1
 */