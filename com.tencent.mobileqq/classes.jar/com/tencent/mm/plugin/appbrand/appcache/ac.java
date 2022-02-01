package com.tencent.mm.plugin.appbrand.appcache;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.luggage.wxa.fo.a;
import com.tencent.luggage.wxa.jj.s.f;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import java.util.Arrays;
import java.util.Locale;

public class ac
  implements g
{
  private static final ac a = new ac();
  private static final Uri b;
  private static final Uri c;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("content://");
    localStringBuilder.append(a.a);
    localStringBuilder.append("/");
    localStringBuilder.append("AppBrandWxaPkgManifestRecord");
    b = Uri.parse(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("content://");
    localStringBuilder.append(a.a);
    localStringBuilder.append("/");
    localStringBuilder.append("WxaPluginCodeVersionInfo");
    c = Uri.parse(localStringBuilder.toString());
  }
  
  public static ac a()
  {
    return a;
  }
  
  public Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5)
  {
    return r.a().getContentResolver().query(b, paramArrayOfString1, paramString2, paramArrayOfString2, paramString5);
  }
  
  public ab a(String paramString, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    l = af.b();
    try
    {
      localObject6 = new StringBuilder();
      arrayOfString1 = ab.l;
      j = arrayOfString1.length;
      i = 0;
    }
    finally
    {
      String[] arrayOfString2;
      try
      {
        String[] arrayOfString1;
        int j;
        int i;
        ((StringBuilder)localObject6).append(arrayOfString1[i]);
        ((StringBuilder)localObject6).append("=? and ");
        i += 1;
      }
      finally
      {
        for (;;)
        {
          Object localObject6;
          break label319;
          ((StringBuilder)localObject6).append("1=1");
          boolean bool = d.a.b(paramInt2);
          if (bool) {
            paramInt1 = 1;
          }
          try
          {
            if (!af.a(paramVarArgs)) {
              break label377;
            }
            Object localObject2 = null;
            localObject6 = a("AppBrandWxaPkgManifestRecord", (String[])localObject2, ((StringBuilder)localObject6).toString(), new String[] { paramString, String.valueOf(paramInt1), String.valueOf(paramInt2) }, null, null, null);
            if (localObject6 == null)
            {
              o.d("Luggage.WxaPkgResolver", "|runProfiled| getManifest(appId:%s, version:%s, type:%d, columns:%s) cost:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Arrays.toString(paramVarArgs), Long.valueOf(af.b() - l) });
              return null;
            }
            if (!((Cursor)localObject6).moveToFirst()) {
              break label384;
            }
            localObject2 = new ab();
            ((ab)localObject2).a((Cursor)localObject6);
            ((ab)localObject2).b = paramString;
            ((ab)localObject2).c = paramInt1;
            try
            {
              ((ab)localObject2).h = paramInt2;
              ((Cursor)localObject6).close();
              o.d("Luggage.WxaPkgResolver", "|runProfiled| getManifest(appId:%s, version:%s, type:%d, columns:%s) cost:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Arrays.toString(paramVarArgs), Long.valueOf(af.b() - l) });
              return localObject2;
            }
            finally
            {
              break label319;
            }
          }
          finally {}
        }
        localObject5 = finally;
        o.d("Luggage.WxaPkgResolver", "|runProfiled| getManifest(appId:%s, version:%s, type:%d, columns:%s) cost:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Arrays.toString(paramVarArgs), Long.valueOf(af.b() - l) });
        break label374;
      }
    }
    if (i >= j) {}
  }
  
  public ab a(String paramString, int paramInt, String... paramVarArgs)
  {
    boolean bool = af.c(paramString);
    Object localObject2 = null;
    if (bool) {
      return null;
    }
    if (d.a.a(paramInt)) {}
    for (Object localObject1 = "version desc";; localObject1 = "createTime desc")
    {
      break;
      if (!d.a.b(paramInt)) {
        break label159;
      }
    }
    if (af.a(paramVarArgs)) {
      paramVarArgs = null;
    }
    localObject1 = a("AppBrandWxaPkgManifestRecord", paramVarArgs, String.format(Locale.US, "%s=? and %s=?", new Object[] { "appId", "debugType" }), new String[] { paramString, String.valueOf(paramInt) }, null, null, (String)localObject1);
    if (localObject1 == null) {
      return null;
    }
    paramVarArgs = localObject2;
    if (((Cursor)localObject1).moveToFirst())
    {
      paramVarArgs = new ab();
      paramVarArgs.a((Cursor)localObject1);
      paramVarArgs.b = paramString;
      paramVarArgs.h = paramInt;
    }
    ((Cursor)localObject1).close();
    return paramVarArgs;
    label159:
    paramString = new StringBuilder();
    paramString.append("Illegal pkgType ");
    paramString.append(paramInt);
    paramString = new RuntimeException(paramString.toString());
    for (;;)
    {
      throw paramString;
    }
  }
  
  /* Error */
  public String a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 61	com/tencent/luggage/wxa/qz/r:a	()Landroid/content/Context;
    //   3: invokevirtual 67	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnonnull +27 -> 35
    //   11: ldc 107
    //   13: ldc 192
    //   15: iconst_2
    //   16: anewarray 4	java/lang/Object
    //   19: dup
    //   20: iconst_0
    //   21: aload_1
    //   22: aastore
    //   23: dup
    //   24: iconst_1
    //   25: iload_2
    //   26: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   29: aastore
    //   30: invokestatic 194	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   33: aconst_null
    //   34: areturn
    //   35: getstatic 52	com/tencent/mm/plugin/appbrand/appcache/ac:c	Landroid/net/Uri;
    //   38: astore 4
    //   40: getstatic 197	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   43: ldc 169
    //   45: iconst_2
    //   46: anewarray 4	java/lang/Object
    //   49: dup
    //   50: iconst_0
    //   51: ldc 199
    //   53: aastore
    //   54: dup
    //   55: iconst_1
    //   56: ldc 201
    //   58: aastore
    //   59: invokestatic 177	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   62: astore 5
    //   64: aload_3
    //   65: aload 4
    //   67: iconst_1
    //   68: anewarray 99	java/lang/String
    //   71: dup
    //   72: iconst_0
    //   73: ldc 203
    //   75: aastore
    //   76: aload 5
    //   78: iconst_2
    //   79: anewarray 99	java/lang/String
    //   82: dup
    //   83: iconst_0
    //   84: aload_1
    //   85: aastore
    //   86: dup
    //   87: iconst_1
    //   88: iload_2
    //   89: invokestatic 103	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   92: aastore
    //   93: aconst_null
    //   94: invokevirtual 73	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   97: astore 6
    //   99: aload 6
    //   101: ifnull +120 -> 221
    //   104: aload 6
    //   106: invokeinterface 136 1 0
    //   111: ifeq +110 -> 221
    //   114: aload 6
    //   116: iconst_0
    //   117: invokeinterface 206 2 0
    //   122: astore_3
    //   123: goto +50 -> 173
    //   126: astore_3
    //   127: aconst_null
    //   128: astore 5
    //   130: goto +14 -> 144
    //   133: astore_3
    //   134: aload_3
    //   135: athrow
    //   136: astore 4
    //   138: aload_3
    //   139: astore 5
    //   141: aload 4
    //   143: astore_3
    //   144: aload 6
    //   146: ifnull +25 -> 171
    //   149: aload 5
    //   151: ifnull +13 -> 164
    //   154: aload 6
    //   156: invokeinterface 151 1 0
    //   161: goto +10 -> 171
    //   164: aload 6
    //   166: invokeinterface 151 1 0
    //   171: aload_3
    //   172: athrow
    //   173: aload 6
    //   175: ifnull +10 -> 185
    //   178: aload 6
    //   180: invokeinterface 151 1 0
    //   185: aload_3
    //   186: areturn
    //   187: astore_3
    //   188: ldc 107
    //   190: ldc 208
    //   192: iconst_3
    //   193: anewarray 4	java/lang/Object
    //   196: dup
    //   197: iconst_0
    //   198: aload_1
    //   199: aastore
    //   200: dup
    //   201: iconst_1
    //   202: iload_2
    //   203: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   206: aastore
    //   207: dup
    //   208: iconst_2
    //   209: aload_3
    //   210: aastore
    //   211: invokestatic 194	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   214: aconst_null
    //   215: areturn
    //   216: astore 4
    //   218: goto -47 -> 171
    //   221: aconst_null
    //   222: astore_3
    //   223: goto -50 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	this	ac
    //   0	226	1	paramString	String
    //   0	226	2	paramInt	int
    //   6	117	3	localObject1	Object
    //   126	1	3	localObject2	Object
    //   133	6	3	localThrowable1	java.lang.Throwable
    //   143	43	3	localObject3	Object
    //   187	23	3	localThrowable2	java.lang.Throwable
    //   222	1	3	localObject4	Object
    //   38	28	4	localUri	Uri
    //   136	6	4	localObject5	Object
    //   216	1	4	localThrowable3	java.lang.Throwable
    //   62	88	5	localObject6	Object
    //   97	82	6	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   104	123	126	finally
    //   104	123	133	java/lang/Throwable
    //   134	136	136	finally
    //   35	99	187	java/lang/Throwable
    //   164	171	187	java/lang/Throwable
    //   171	173	187	java/lang/Throwable
    //   178	185	187	java/lang/Throwable
    //   154	161	216	java/lang/Throwable
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("CONTENT_KEY_ACTION", "ACTION_UPDATE_PLUGINCODE_LIST");
      localContentValues.put("CONTENT_KEY_PLUGINCODE_LIST", paramString);
      r.a().getContentResolver().insert(b, localContentValues);
      return;
    }
    catch (Exception paramString)
    {
      o.a("Luggage.WxaPkgResolver", paramString, "updatePluginCodeList", new Object[0]);
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("CONTENT_KEY_ACTION", "ACTION_SET_PLUGIN_STRING_VERSION");
      localContentValues.put("CONTENT_KEY_PLUGIN_APPID", paramString1);
      localContentValues.put("CONTENT_KEY_PLUGIN_APP_VERSION", Integer.valueOf(paramInt));
      localContentValues.put("CONTENT_KEY_PLUGIN_APP_STRING_VERSION", paramString2);
      r.a().getContentResolver().insert(c, localContentValues);
      return;
    }
    catch (Exception paramString1)
    {
      o.a("Luggage.WxaPkgResolver", paramString1, "setPluginStringVersion", new Object[0]);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString3)) {
      return;
    }
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("CONTENT_KEY_ACTION", "ACTION_UPDATE_PKG_INFO");
      localContentValues.put("CONTENT_KEY_APPID", paramString1);
      localContentValues.put("CONTENT_KEY_MODULE_NAME", paramString2);
      localContentValues.put("CONTENT_KEY_PKG_VERSION", Integer.valueOf(paramInt1));
      localContentValues.put("CONTENT_KEY_CODE_TYPE", Integer.valueOf(paramInt2));
      localContentValues.put("CONTENT_KEY_PKGINFO_LIST", paramString3);
      r.a().getContentResolver().insert(b, localContentValues);
      return;
    }
    catch (Exception paramString1)
    {
      o.a("Luggage.WxaPkgResolver", paramString1, "updatePkgInfoList", new Object[0]);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3)
  {
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("CONTENT_KEY_ACTION", "ACIION_UPDATE_WITHOUT_PLUGINCODE_INFO");
      localContentValues.put("CONTENT_KEY_APPID", paramString1);
      localContentValues.put("CONTENT_KEY_MODULE_NAME", paramString2);
      localContentValues.put("CONTENT_KEY_PKG_VERSION", Integer.valueOf(paramInt1));
      localContentValues.put("CONTENT_KEY_CODE_TYPE", Integer.valueOf(paramInt2));
      localContentValues.put("CONTENT_KEY_PKG_VERSION_MD5", paramString3);
      localContentValues.put("CONTENT_KEY_PKG_TYPE", Integer.valueOf(paramInt3));
      r.a().getContentResolver().insert(b, localContentValues);
      return;
    }
    catch (Exception localException)
    {
      o.a("Luggage.WxaPkgResolver", localException, "updateWithoutPluginCodeInfo, appId[%s] module[%s], version[%d], codeType[%d], md5[%s], pkgType[%d]", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString3, Integer.valueOf(paramInt3) });
    }
  }
  
  public boolean a(ab paramab)
  {
    boolean bool = false;
    if (paramab == null) {
      return false;
    }
    try
    {
      paramab = paramab.b();
      paramab.put("CONTENT_KEY_ACTION", "ACTION_INSERT_OR_UPDATE_MANIFEST");
      paramab = r.a().getContentResolver().insert(b, paramab);
      if (paramab != null) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramab)
    {
      o.a("Luggage.WxaPkgResolver", paramab, "insertOrUpdate", new Object[0]);
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2)
  {
    o.d("Luggage.WxaPkgResolver", "deleteModuleList appId:%s, pkgType:%d, pkgVersion:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("CONTENT_KEY_ACTION", "ACTION_DELETE_MODULE_LIST");
      localContentValues.put("CONTENT_KEY_APPID", paramString);
      localContentValues.put("CONTENT_KEY_PKG_TYPE", Integer.valueOf(paramInt1));
      localContentValues.put("CONTENT_KEY_PKG_VERSION", Integer.valueOf(paramInt2));
      r.a().getContentResolver().update(b, localContentValues, null, null);
      return true;
    }
    catch (Exception localException)
    {
      o.b("Luggage.WxaPkgResolver", "deleteModuleList failed, appId:%s, pkgType:%d, pkgVersion:%d, exception:%s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localException });
    }
    return true;
  }
  
  public boolean a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    o.d("Luggage.WxaPkgResolver", "updateModuleList appId:%s, pkgType:%d, pkgVersion:%d", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("CONTENT_KEY_ACTION", "ACTION_UPDATE_MODULE_LIST");
      localContentValues.put("CONTENT_KEY_APPID", paramString1);
      localContentValues.put("CONTENT_KEY_PKG_TYPE", Integer.valueOf(paramInt1));
      localContentValues.put("CONTENT_KEY_PKG_VERSION", Integer.valueOf(paramInt2));
      localContentValues.put("CONTENT_KEY_MODULE_LIST_JSON", paramString2);
      r.a().getContentResolver().insert(b, localContentValues);
      return true;
    }
    catch (Exception paramString2)
    {
      o.b("Luggage.WxaPkgResolver", "updateModuleList failed appId:%s, pkgType:%d, pkgVersion:%d, exception:%s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
    }
    return false;
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString3)) {
        return false;
      }
      try
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("CONTENT_KEY_ACTION", "ACTION_FLUSH_WXA_DEBUG_PKG_INFO");
        localContentValues.put("CONTENT_KEY_APPID", paramString1);
        localContentValues.put("CONTENT_KEY_PKG_TYPE", Integer.valueOf(paramInt));
        localContentValues.put("CONTENT_KEY_PKG_VERSION_MD5", paramString3);
        localContentValues.put("CONTENT_KEY_PKG_DOWNLOAD_URL", paramString2);
        paramString2 = r.a().getContentResolver().insert(b, localContentValues);
        return paramString2 != null;
      }
      catch (Exception paramString2)
      {
        o.a("Luggage.WxaPkgResolver", paramString2, "flushWxaDebugAppVersionInfo appId[%s] type[%d] md5p[%s]", new Object[] { paramString1, Integer.valueOf(paramInt), paramString3 });
      }
    }
    return false;
  }
  
  public boolean a(String paramString, s.f paramf, int paramInt)
  {
    if ((!af.c(paramString)) && (paramf != null)) {}
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("CONTENT_KEY_ACTION", "ACTION_FLUSH_WXA_PKG_VERSION_INFO");
      localContentValues.put("CONTENT_KEY_WXA_VERSION_INFO_JSON", paramf.a());
      localContentValues.put("CONTENT_KEY_APPID", paramString);
      localContentValues.put("CONTENT_KEY_PKG_TYPE", Integer.valueOf(paramInt));
      r.a().getContentResolver().insert(b, localContentValues);
      return true;
    }
    catch (Exception paramString)
    {
      label83:
      break label83;
    }
    o.b("Luggage.WxaPkgResolver", "setExtInfo fail");
    return false;
    o.b("Luggage.WxaPkgResolver", "flushWxaAppVersionInfoV2, args invalid appId = %s, vInfo = %s", new Object[] { paramString, paramf });
    return false;
  }
  
  public final boolean b(ab paramab)
  {
    boolean bool = false;
    if (paramab == null) {
      return false;
    }
    paramab = paramab.b();
    paramab.put("CONTENT_KEY_ACTION", "ACTION_UPDATE_MANIFEST");
    StringBuilder localStringBuilder = new StringBuilder();
    String[] arrayOfString = ab.l;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(arrayOfString[i]);
      localStringBuilder.append(" = ? AND ");
      i += 1;
    }
    localStringBuilder.append(" 1=1 ");
    arrayOfString = new String[ab.l.length];
    i = 0;
    while (i < arrayOfString.length)
    {
      arrayOfString[i] = paramab.getAsString(ab.l[i]);
      i += 1;
    }
    if (r.a().getContentResolver().update(b, paramab, localStringBuilder.toString(), arrayOfString) > 0) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ac
 * JD-Core Version:    0.7.0.1
 */