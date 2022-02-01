package com.tencent.luggage.wxa.eu;

import android.os.SystemClock;
import com.tencent.luggage.wxa.pd.l;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rt.i;
import com.tencent.luggage.wxa.rt.k;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.appcache.d.a;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.page.a;
import com.tencent.mm.plugin.appbrand.page.at;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;
import java.io.FileNotFoundException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/standalone_ext/page/MPPageScriptProviderXWebCodeCacheImpl;", "Lcom/tencent/mm/plugin/appbrand/page/MPPageScriptProviderDefaultImpl;", "renderer", "Lcom/tencent/luggage/standalone_ext/page/MPPageViewRendererStandaloneXWebImpl;", "(Lcom/tencent/luggage/standalone_ext/page/MPPageViewRendererStandaloneXWebImpl;)V", "checkScriptSerialized", "", "scriptName", "scriptSource", "onScriptCodeCacheProvided", "", "name", "provideScript", "resourceName", "runProfiled", "R", "logName", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "contentMD5", "fileMD5", "stripParentFilePath", "urlEncode", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public class b
  extends at
{
  public static final b.a a = new b.a(null);
  private static final String[] d = { "app-wxss.js", "page-frame.html" };
  private final c b;
  
  static
  {
    l.a("//XWEB_SCRIPT:");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(com.tencent.luggage.wxa.en.d.a.a());
    ((StringBuilder)localObject).append("/page");
    localObject = ((StringBuilder)localObject).toString();
    if (k.h((String)localObject)) {
      k.d((String)localObject, true);
    }
  }
  
  public b(@NotNull c paramc)
  {
    super((a)paramc);
    this.b = paramc;
  }
  
  private final String a(String paramString1, String paramString2)
  {
    Object localObject3 = d(paramString2);
    Object localObject1 = com.tencent.luggage.wxa.dq.d.b;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "IAppBrandComponentWxaSha…U.SCRIPTS_LIB_FOR_WEBVIEW");
    Object localObject4;
    int i;
    if (ArraysKt.contains((Object[])localObject1, paramString1))
    {
      if (Intrinsics.areEqual(paramString1, "WAWebview.js"))
      {
        localObject1 = a;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(b.a.a(a));
        ((StringBuilder)localObject1).append('/');
        localObject2 = a;
        localObject4 = this.b.m();
        Intrinsics.checkExpressionValueIsNotNull(localObject4, "renderer.libReader");
        ((StringBuilder)localObject1).append(((b.a)localObject2).a((n)localObject4));
        localObject1 = ((StringBuilder)localObject1).toString();
        k.g((String)localObject1);
      }
      else
      {
        return null;
      }
    }
    else
    {
      localObject1 = this.b.n();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "renderer.runtime");
      if (!d.a.a(((com.tencent.luggage.wxa.ed.d)localObject1).ab())) {
        return null;
      }
      if ((!ArraysKt.contains(d, paramString1)) && (!StringsKt.endsWith$default(paramString1, "page-frame.js", false, 2, null))) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0) {
        return null;
      }
      localObject1 = a;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(b.a.a(a));
      ((StringBuilder)localObject1).append('/');
      localObject2 = a;
      localObject4 = this.b.o();
      Intrinsics.checkExpressionValueIsNotNull(localObject4, "renderer.appId");
      ((StringBuilder)localObject1).append(((b.a)localObject2).a((String)localObject4, this.b.q()));
      localObject1 = ((StringBuilder)localObject1).toString();
      k.g((String)localObject1);
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append('/');
    ((StringBuilder)localObject2).append((String)localObject3);
    ((StringBuilder)localObject2).append('-');
    ((StringBuilder)localObject2).append(c(paramString1));
    localObject2 = ((StringBuilder)localObject2).toString();
    label920:
    for (;;)
    {
      try
      {
        boolean bool = k.h((String)localObject2);
        if (!bool) {
          break label920;
        }
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("check serialized file md5 script[");
        ((StringBuilder)localObject4).append(paramString1);
        ((StringBuilder)localObject4).append("] appId[");
        ((StringBuilder)localObject4).append(this.b.o());
        ((StringBuilder)localObject4).append(']');
        localObject4 = ((StringBuilder)localObject4).toString();
        long l = SystemClock.elapsedRealtime();
        String str = e((String)localObject2);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("runProfiled:");
        localStringBuilder.append((String)localObject4);
        localStringBuilder.append(" cost ");
        localStringBuilder.append(SystemClock.elapsedRealtime() - l);
        localStringBuilder.append("ms");
        o.d("Luggage.WXA.MPPageScriptProviderXWebCodeCacheImpl", localStringBuilder.toString());
        if ((Intrinsics.areEqual(str, localObject3) ^ true))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("serialize script[");
          ((StringBuilder)localObject3).append(paramString1);
          ((StringBuilder)localObject3).append("] appId[");
          ((StringBuilder)localObject3).append(this.b.o());
          ((StringBuilder)localObject3).append(']');
          localObject3 = ((StringBuilder)localObject3).toString();
          l = SystemClock.elapsedRealtime();
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append((String)localObject2);
          ((StringBuilder)localObject4).append(".utf16");
          k.i(((StringBuilder)localObject4).toString());
          localObject4 = Charsets.UTF_8;
          if (paramString2 != null)
          {
            paramString2 = paramString2.getBytes((Charset)localObject4);
            Intrinsics.checkExpressionValueIsNotNull(paramString2, "(this as java.lang.String).getBytes(charset)");
            k.b((String)localObject2, paramString2);
            paramString2 = new StringBuilder();
            paramString2.append("runProfiled:");
            paramString2.append((String)localObject3);
            paramString2.append(" cost ");
            paramString2.append(SystemClock.elapsedRealtime() - l);
            paramString2.append("ms");
            o.d("Luggage.WXA.MPPageScriptProviderXWebCodeCacheImpl", paramString2.toString());
            paramString2 = (String)localObject2;
            localObject1 = new i((String)localObject1).s();
            if (localObject1 == null) {
              localObject1 = new i[0];
            }
            int j = localObject1.length;
            i = 0;
            if (i < j)
            {
              localObject2 = localObject1[i];
              Intrinsics.checkExpressionValueIsNotNull(localObject2, "file");
              localObject3 = ((i)localObject2).l();
              Intrinsics.checkExpressionValueIsNotNull(localObject3, "file.absolutePath");
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append(paramString2);
              ((StringBuilder)localObject4).append(".cachedata");
              if (StringsKt.startsWith$default((String)localObject3, ((StringBuilder)localObject4).toString(), false, 2, null)) {
                localObject1 = localObject2;
              } else {
                i += 1;
              }
            }
            else
            {
              localObject1 = null;
            }
            if (localObject1 != null) {
              b(paramString1);
            }
            return paramString2;
          }
          throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
      }
      catch (FileNotFoundException paramString2)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("checkScriptSerialized appId[");
        ((StringBuilder)localObject1).append(this.b.o());
        ((StringBuilder)localObject1).append("] scriptName[");
        ((StringBuilder)localObject1).append(paramString1);
        ((StringBuilder)localObject1).append("] e=");
        ((StringBuilder)localObject1).append(paramString2);
        o.b("Luggage.WXA.MPPageScriptProviderXWebCodeCacheImpl", ((StringBuilder)localObject1).toString());
        return null;
      }
      paramString2 = (String)localObject2;
    }
  }
  
  private final String c(@NotNull String paramString)
  {
    paramString = URLEncoder.encode(paramString, "UTF-8");
    Intrinsics.checkExpressionValueIsNotNull(paramString, "URLEncoder.encode(this, \"UTF-8\")");
    return paramString;
  }
  
  /* Error */
  private final String d(@NotNull String paramString)
  {
    // Byte code:
    //   0: getstatic 247	kotlin/text/Charsets:UTF_8	Ljava/nio/charset/Charset;
    //   3: astore_2
    //   4: aload_1
    //   5: ifnull +83 -> 88
    //   8: aload_1
    //   9: aload_2
    //   10: invokevirtual 251	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   13: astore_1
    //   14: aload_1
    //   15: ldc 253
    //   17: invokestatic 134	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   20: new 307	java/io/ByteArrayInputStream
    //   23: dup
    //   24: aload_1
    //   25: invokespecial 310	java/io/ByteArrayInputStream:<init>	([B)V
    //   28: checkcast 312	java/io/Closeable
    //   31: astore_3
    //   32: aconst_null
    //   33: checkcast 305	java/lang/Throwable
    //   36: astore_2
    //   37: aload_2
    //   38: astore_1
    //   39: aload_3
    //   40: checkcast 307	java/io/ByteArrayInputStream
    //   43: checkcast 314	java/io/InputStream
    //   46: sipush 16384
    //   49: invokestatic 319	com/tencent/luggage/wxa/gl/c:a	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   52: astore 4
    //   54: aload_2
    //   55: astore_1
    //   56: aload 4
    //   58: ldc_w 321
    //   61: invokestatic 134	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   64: aload_3
    //   65: aload_2
    //   66: invokestatic 327	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   69: aload 4
    //   71: areturn
    //   72: astore_2
    //   73: goto +8 -> 81
    //   76: astore_2
    //   77: aload_2
    //   78: astore_1
    //   79: aload_2
    //   80: athrow
    //   81: aload_3
    //   82: aload_1
    //   83: invokestatic 327	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   86: aload_2
    //   87: athrow
    //   88: new 280	kotlin/TypeCastException
    //   91: dup
    //   92: ldc_w 282
    //   95: invokespecial 283	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	b
    //   0	99	1	paramString	String
    //   3	63	2	localObject1	Object
    //   72	1	2	localObject2	Object
    //   76	11	2	localThrowable	java.lang.Throwable
    //   31	51	3	localCloseable	java.io.Closeable
    //   52	18	4	str	String
    // Exception table:
    //   from	to	target	type
    //   39	54	72	finally
    //   56	64	72	finally
    //   79	81	72	finally
    //   39	54	76	java/lang/Throwable
    //   56	64	76	java/lang/Throwable
  }
  
  private final String e(@NotNull String paramString)
  {
    return af.c(paramString);
  }
  
  private final String f(@NotNull String paramString)
  {
    int i = StringsKt.lastIndexOf$default((CharSequence)paramString, '/', 0, false, 6, null);
    if (i > 0)
    {
      int j = paramString.length();
      if (paramString != null)
      {
        paramString = paramString.substring(i, j);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return paramString;
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
    return paramString;
  }
  
  @Nullable
  public final String a(@Nullable String paramString)
  {
    Object localObject = (CharSequence)paramString;
    int i;
    if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return null;
    }
    localObject = super.a(paramString);
    if (localObject != null)
    {
      String str = a(paramString, (String)localObject);
      if (str != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("provideScript use XWEBScript appId[");
        localStringBuilder.append(this.b.o());
        localStringBuilder.append("] name[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("], path[");
        localStringBuilder.append(f(str));
        localStringBuilder.append(']');
        o.d("Luggage.WXA.MPPageScriptProviderXWebCodeCacheImpl", localStringBuilder.toString());
        paramString = new ac(3, 0, (WebView)this.b.b());
        paramString.a(str, l.a());
        paramString.a((String)localObject);
        return paramString.toString();
      }
      return localObject;
    }
    return null;
  }
  
  public void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.eu.b
 * JD-Core Version:    0.7.0.1
 */