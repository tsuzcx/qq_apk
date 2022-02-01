package com.tencent.luggage.wxa.jj;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.fo.a;
import com.tencent.luggage.wxa.qu.b;
import com.tencent.luggage.wxa.qw.ai;
import com.tencent.luggage.wxa.qw.lv;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;

public class u
{
  private static final Uri a;
  private static final u b = new u();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("content://");
    localStringBuilder.append(a.a);
    localStringBuilder.append("/");
    localStringBuilder.append("WxaAttributesTable");
    a = Uri.parse(localStringBuilder.toString());
  }
  
  @Nullable
  private s a(@Nullable String[] paramArrayOfString1, String paramString, String[] paramArrayOfString2)
  {
    paramArrayOfString2 = r.a().getContentResolver().query(a, paramArrayOfString1, paramString, paramArrayOfString2, null);
    paramString = null;
    if (paramArrayOfString2 == null) {
      return null;
    }
    paramArrayOfString1 = paramString;
    if (!paramArrayOfString2.isClosed())
    {
      paramArrayOfString1 = paramString;
      if (paramArrayOfString2.moveToFirst())
      {
        paramArrayOfString1 = new s();
        paramArrayOfString1.a(paramArrayOfString2);
      }
    }
    paramArrayOfString2.close();
    return paramArrayOfString1;
  }
  
  public static u a()
  {
    return b;
  }
  
  public s a(String paramString, String... paramVarArgs)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    long l = af.b();
    s locals = a(paramVarArgs, String.format(Locale.ENGLISH, "%s=?", new Object[] { "username" }), new String[] { paramString });
    o.d("Luggage.WxaAttrsContentResolver", "queryWithUsername username:%s, cost:%dms, columns:%s", new Object[] { paramString, Long.valueOf(af.b() - l), Arrays.toString(paramVarArgs) });
    return locals;
  }
  
  /* Error */
  public java.util.List<s> a(java.util.List<String> paramList, String... paramVarArgs)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +290 -> 291
    //   4: aload_1
    //   5: invokeinterface 145 1 0
    //   10: ifeq +6 -> 16
    //   13: goto +278 -> 291
    //   16: new 147	java/util/ArrayList
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 150	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   24: astore 5
    //   26: iconst_0
    //   27: istore_3
    //   28: iload_3
    //   29: aload 5
    //   31: invokevirtual 154	java/util/ArrayList:size	()I
    //   34: if_icmpge +38 -> 72
    //   37: aload 5
    //   39: iload_3
    //   40: getstatic 105	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   43: ldc 156
    //   45: iconst_1
    //   46: anewarray 4	java/lang/Object
    //   49: dup
    //   50: iconst_0
    //   51: aload 5
    //   53: iload_3
    //   54: invokevirtual 160	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   57: aastore
    //   58: invokestatic 115	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   61: invokevirtual 164	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   64: pop
    //   65: iload_3
    //   66: iconst_1
    //   67: iadd
    //   68: istore_3
    //   69: goto -41 -> 28
    //   72: aload 5
    //   74: ldc 166
    //   76: invokestatic 172	org/apache/commons/lang/StringUtils:join	(Ljava/util/Collection;Ljava/lang/String;)Ljava/lang/String;
    //   79: astore 5
    //   81: invokestatic 54	com/tencent/luggage/wxa/qz/r:a	()Landroid/content/Context;
    //   84: invokevirtual 60	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   87: astore 6
    //   89: getstatic 42	com/tencent/luggage/wxa/jj/u:a	Landroid/net/Uri;
    //   92: astore 7
    //   94: aload_2
    //   95: arraylength
    //   96: ifgt +204 -> 300
    //   99: aconst_null
    //   100: astore_2
    //   101: goto +3 -> 104
    //   104: aload 6
    //   106: aload 7
    //   108: aload_2
    //   109: getstatic 105	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   112: ldc 174
    //   114: iconst_2
    //   115: anewarray 4	java/lang/Object
    //   118: dup
    //   119: iconst_0
    //   120: ldc 176
    //   122: aastore
    //   123: dup
    //   124: iconst_1
    //   125: aload 5
    //   127: aastore
    //   128: invokestatic 115	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   131: aconst_null
    //   132: aconst_null
    //   133: invokevirtual 66	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   136: astore 7
    //   138: new 178	java/util/LinkedList
    //   141: dup
    //   142: invokespecial 179	java/util/LinkedList:<init>	()V
    //   145: astore_2
    //   146: aload 7
    //   148: ifnull +52 -> 200
    //   151: aload 7
    //   153: invokeinterface 75 1 0
    //   158: ifeq +42 -> 200
    //   161: new 77	com/tencent/luggage/wxa/jj/s
    //   164: dup
    //   165: invokespecial 78	com/tencent/luggage/wxa/jj/s:<init>	()V
    //   168: astore 5
    //   170: aload 5
    //   172: aload 7
    //   174: invokevirtual 81	com/tencent/luggage/wxa/jj/s:a	(Landroid/database/Cursor;)V
    //   177: aload_2
    //   178: aload 5
    //   180: invokeinterface 183 2 0
    //   185: pop
    //   186: aload 7
    //   188: invokeinterface 186 1 0
    //   193: istore 4
    //   195: iload 4
    //   197: ifne -36 -> 161
    //   200: aload 7
    //   202: ifnull +10 -> 212
    //   205: aload 7
    //   207: invokeinterface 84 1 0
    //   212: aload_2
    //   213: areturn
    //   214: astore_2
    //   215: aconst_null
    //   216: astore 6
    //   218: goto +14 -> 232
    //   221: astore_2
    //   222: aload_2
    //   223: athrow
    //   224: astore 5
    //   226: aload_2
    //   227: astore 6
    //   229: aload 5
    //   231: astore_2
    //   232: aload 7
    //   234: ifnull +25 -> 259
    //   237: aload 6
    //   239: ifnull +13 -> 252
    //   242: aload 7
    //   244: invokeinterface 84 1 0
    //   249: goto +10 -> 259
    //   252: aload 7
    //   254: invokeinterface 84 1 0
    //   259: aload_2
    //   260: athrow
    //   261: astore_2
    //   262: ldc 119
    //   264: ldc 188
    //   266: iconst_2
    //   267: anewarray 4	java/lang/Object
    //   270: dup
    //   271: iconst_0
    //   272: aload_1
    //   273: invokeinterface 189 1 0
    //   278: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   281: aastore
    //   282: dup
    //   283: iconst_1
    //   284: aload_2
    //   285: aastore
    //   286: invokestatic 196	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   289: aconst_null
    //   290: areturn
    //   291: invokestatic 202	java/util/Collections:emptyList	()Ljava/util/List;
    //   294: areturn
    //   295: astore 5
    //   297: goto -38 -> 259
    //   300: goto -196 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	this	u
    //   0	303	1	paramList	java.util.List<String>
    //   0	303	2	paramVarArgs	String[]
    //   27	42	3	i	int
    //   193	3	4	bool	boolean
    //   24	155	5	localObject1	Object
    //   224	6	5	localObject2	Object
    //   295	1	5	localThrowable	java.lang.Throwable
    //   87	151	6	localObject3	Object
    //   92	161	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   138	146	214	finally
    //   151	161	214	finally
    //   161	195	214	finally
    //   138	146	221	java/lang/Throwable
    //   151	161	221	java/lang/Throwable
    //   161	195	221	java/lang/Throwable
    //   222	224	224	finally
    //   81	99	261	java/lang/Throwable
    //   104	138	261	java/lang/Throwable
    //   205	212	261	java/lang/Throwable
    //   252	259	261	java/lang/Throwable
    //   259	261	261	java/lang/Throwable
    //   242	249	295	java/lang/Throwable
  }
  
  public boolean a(ai paramai)
  {
    if (paramai == null) {
      return false;
    }
    try
    {
      paramai = paramai.b();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("CONTENT_KEY_BATCH_SYNC_PROTO", paramai);
      r.a().getContentResolver().insert(a, localContentValues);
      return true;
    }
    catch (Exception paramai)
    {
      label42:
      break label42;
    }
    o.b("Luggage.WxaAttrsContentResolver", "batchUpdateWithProto insert failed");
    return false;
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 94	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: invokestatic 99	com/tencent/luggage/wxa/qz/af:b	()J
    //   12: lstore_2
    //   13: getstatic 105	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   16: ldc 107
    //   18: iconst_1
    //   19: anewarray 4	java/lang/Object
    //   22: dup
    //   23: iconst_0
    //   24: ldc 176
    //   26: aastore
    //   27: invokestatic 115	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   30: astore 5
    //   32: invokestatic 54	com/tencent/luggage/wxa/qz/r:a	()Landroid/content/Context;
    //   35: invokevirtual 60	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   38: getstatic 42	com/tencent/luggage/wxa/jj/u:a	Landroid/net/Uri;
    //   41: iconst_1
    //   42: anewarray 111	java/lang/String
    //   45: dup
    //   46: iconst_0
    //   47: ldc 109
    //   49: aastore
    //   50: aload 5
    //   52: iconst_1
    //   53: anewarray 111	java/lang/String
    //   56: dup
    //   57: iconst_0
    //   58: aload_1
    //   59: aastore
    //   60: aconst_null
    //   61: invokevirtual 66	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   64: astore 7
    //   66: aconst_null
    //   67: astore 5
    //   69: aload 7
    //   71: ifnull +67 -> 138
    //   74: aload 7
    //   76: invokeinterface 75 1 0
    //   81: istore 4
    //   83: iload 4
    //   85: ifeq +53 -> 138
    //   88: iconst_1
    //   89: istore 4
    //   91: goto +50 -> 141
    //   94: astore 6
    //   96: goto +12 -> 108
    //   99: astore 6
    //   101: aload 6
    //   103: astore 5
    //   105: aload 6
    //   107: athrow
    //   108: aload 7
    //   110: ifnull +25 -> 135
    //   113: aload 5
    //   115: ifnull +13 -> 128
    //   118: aload 7
    //   120: invokeinterface 84 1 0
    //   125: goto +10 -> 135
    //   128: aload 7
    //   130: invokeinterface 84 1 0
    //   135: aload 6
    //   137: athrow
    //   138: iconst_0
    //   139: istore 4
    //   141: aload 7
    //   143: ifnull +18 -> 161
    //   146: aload 7
    //   148: invokeinterface 84 1 0
    //   153: goto +8 -> 161
    //   156: astore 5
    //   158: goto +45 -> 203
    //   161: ldc 119
    //   163: ldc 233
    //   165: iconst_3
    //   166: anewarray 4	java/lang/Object
    //   169: dup
    //   170: iconst_0
    //   171: aload_1
    //   172: aastore
    //   173: dup
    //   174: iconst_1
    //   175: invokestatic 99	com/tencent/luggage/wxa/qz/af:b	()J
    //   178: lload_2
    //   179: lsub
    //   180: invokestatic 127	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   183: aastore
    //   184: dup
    //   185: iconst_2
    //   186: iload 4
    //   188: invokestatic 238	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   191: aastore
    //   192: invokestatic 138	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   195: iload 4
    //   197: ireturn
    //   198: astore 5
    //   200: iconst_0
    //   201: istore 4
    //   203: ldc 119
    //   205: ldc 233
    //   207: iconst_3
    //   208: anewarray 4	java/lang/Object
    //   211: dup
    //   212: iconst_0
    //   213: aload_1
    //   214: aastore
    //   215: dup
    //   216: iconst_1
    //   217: invokestatic 99	com/tencent/luggage/wxa/qz/af:b	()J
    //   220: lload_2
    //   221: lsub
    //   222: invokestatic 127	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   225: aastore
    //   226: dup
    //   227: iconst_2
    //   228: iload 4
    //   230: invokestatic 238	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   233: aastore
    //   234: invokestatic 138	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   237: aload 5
    //   239: athrow
    //   240: astore 5
    //   242: goto -107 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	u
    //   0	245	1	paramString	String
    //   12	209	2	l	long
    //   81	148	4	bool	boolean
    //   30	84	5	localObject1	Object
    //   156	1	5	localObject2	Object
    //   198	40	5	localObject3	Object
    //   240	1	5	localThrowable1	java.lang.Throwable
    //   94	1	6	localObject4	Object
    //   99	37	6	localThrowable2	java.lang.Throwable
    //   64	83	7	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   74	83	94	finally
    //   105	108	94	finally
    //   74	83	99	java/lang/Throwable
    //   146	153	156	finally
    //   32	66	198	finally
    //   118	125	198	finally
    //   128	135	198	finally
    //   135	138	198	finally
    //   118	125	240	java/lang/Throwable
  }
  
  public boolean a(String paramString, lv paramlv)
  {
    if (paramlv != null) {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
    }
    try
    {
      paramlv = paramlv.b();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("CONTENT_KEY_SYNC_PROTO", paramlv);
      localContentValues.put("CONTENT_KEY_APPID", paramString);
      r.a().getContentResolver().insert(a, localContentValues);
      return true;
    }
    catch (Exception paramString)
    {
      label56:
      break label56;
    }
    o.b("Luggage.WxaAttrsContentResolver", "updateAttrsWithProto insert failed");
    return false;
  }
  
  @Nullable
  public s b(String paramString, String... paramVarArgs)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    long l = af.b();
    s locals = a(paramVarArgs, String.format(Locale.ENGLISH, "%s=?", new Object[] { "appId" }), new String[] { paramString });
    o.d("Luggage.WxaAttrsContentResolver", "queryWithAppId appId:%s, cost:%dms, columns:%s", new Object[] { paramString, Long.valueOf(af.b() - l), Arrays.toString(paramVarArgs) });
    return locals;
  }
  
  public b b(String paramString)
  {
    String str = String.format("%s=?", new Object[] { "appId" });
    paramString = a(new String[] { "syncVersion" }, str, new String[] { paramString });
    if ((paramString != null) && (!TextUtils.isEmpty(paramString.u))) {
      return new b(paramString.u.getBytes(StandardCharsets.UTF_8));
    }
    return new b(new byte[0]);
  }
  
  public boolean b(String paramString, lv paramlv)
  {
    if (paramlv != null) {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
    }
    try
    {
      paramlv = paramlv.b();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("CONTENT_KEY_SYNC_PROTO", paramlv);
      localContentValues.put("CONTENT_KEY_USERNAME", paramString);
      r.a().getContentResolver().insert(a, localContentValues);
      return true;
    }
    catch (Exception paramString)
    {
      label57:
      break label57;
    }
    o.b("Luggage.WxaAttrsContentResolver", "updateAttrsWithProto insert failed");
    return false;
  }
  
  public long c(String paramString)
  {
    String str = String.format("%s=?", new Object[] { "appId" });
    paramString = a(new String[] { "syncTimeSecond" }, str, new String[] { paramString });
    if (paramString != null) {
      return paramString.t;
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jj.u
 * JD-Core Version:    0.7.0.1
 */