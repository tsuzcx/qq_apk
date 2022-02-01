package com.tencent.luggage.wxa.ku;

import com.tencent.luggage.util.a;
import com.tencent.luggage.wxa.pc.c;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadWAFileSync$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "invokeSync", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi$CallResult;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "TAG", "data", "Lorg/json/JSONObject;", "invokeSync$luggage_wechat_full_sdk_release", "toDirectByteBuffer", "Ljava/nio/ByteBuffer;", "Ljava/io/InputStream;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class v$a
{
  private final ByteBuffer a(@NotNull InputStream paramInputStream)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInputStream.available());
    if ((paramInputStream instanceof a)) {
      localByteBuffer.put(((a)paramInputStream).b());
    } else {
      localByteBuffer.put(ByteBuffer.wrap(c.b(paramInputStream)));
    }
    Intrinsics.checkExpressionValueIsNotNull(localByteBuffer, "buffer");
    return localByteBuffer;
  }
  
  /* Error */
  @NotNull
  public final com.tencent.luggage.wxa.jx.m.a a(@NotNull com.tencent.luggage.wxa.iu.b paramb, @NotNull java.lang.String paramString, @org.jetbrains.annotations.Nullable org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 86
    //   3: invokestatic 89	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_2
    //   7: ldc 90
    //   9: invokestatic 89	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_3
    //   13: ifnull +13 -> 26
    //   16: aload_3
    //   17: ldc 92
    //   19: invokevirtual 98	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore_3
    //   23: goto +5 -> 28
    //   26: aconst_null
    //   27: astore_3
    //   28: new 100	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   35: astore 5
    //   37: aload 5
    //   39: ldc 103
    //   41: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload 5
    //   47: aload_3
    //   48: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload 5
    //   54: ldc 109
    //   56: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload 5
    //   62: aload_1
    //   63: invokevirtual 115	com/tencent/luggage/wxa/iu/b:getAppId	()Ljava/lang/String;
    //   66: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload_2
    //   71: aload 5
    //   73: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 124	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: aload_3
    //   80: checkcast 126	java/lang/CharSequence
    //   83: astore 5
    //   85: aload 5
    //   87: ifnull +22 -> 109
    //   90: aload 5
    //   92: invokeinterface 129 1 0
    //   97: ifne +6 -> 103
    //   100: goto +9 -> 109
    //   103: iconst_0
    //   104: istore 4
    //   106: goto +6 -> 112
    //   109: iconst_1
    //   110: istore 4
    //   112: iload 4
    //   114: ifeq +17 -> 131
    //   117: new 131	com/tencent/luggage/wxa/jx/m$a
    //   120: dup
    //   121: ldc 133
    //   123: iconst_0
    //   124: anewarray 4	java/lang/Object
    //   127: invokespecial 136	com/tencent/luggage/wxa/jx/m$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   130: areturn
    //   131: aload_1
    //   132: invokevirtual 140	com/tencent/luggage/wxa/iu/b:A	()Lcom/tencent/mm/plugin/appbrand/appstorage/n;
    //   135: astore 5
    //   137: aload 5
    //   139: ifnull +150 -> 289
    //   142: aload 5
    //   144: ldc 142
    //   146: invokestatic 79	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   149: aload 5
    //   151: aload_3
    //   152: invokeinterface 148 2 0
    //   157: astore 5
    //   159: aload 5
    //   161: ifnull +106 -> 267
    //   164: aload 5
    //   166: checkcast 150	java/io/Closeable
    //   169: astore_3
    //   170: aconst_null
    //   171: checkcast 84	java/lang/Throwable
    //   174: astore_2
    //   175: aload_2
    //   176: astore_1
    //   177: aload_3
    //   178: checkcast 42	java/io/InputStream
    //   181: astore 5
    //   183: aload_2
    //   184: astore_1
    //   185: getstatic 155	com/tencent/luggage/wxa/ku/v:a	Lcom/tencent/luggage/wxa/ku/v$a;
    //   188: astore 6
    //   190: aload_2
    //   191: astore_1
    //   192: aload 5
    //   194: ldc 157
    //   196: invokestatic 79	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   199: aload_2
    //   200: astore_1
    //   201: aload 6
    //   203: aload 5
    //   205: invokespecial 159	com/tencent/luggage/wxa/ku/v$a:a	(Ljava/io/InputStream;)Ljava/nio/ByteBuffer;
    //   208: astore 5
    //   210: aload_2
    //   211: astore_1
    //   212: new 131	com/tencent/luggage/wxa/jx/m$a
    //   215: dup
    //   216: ldc 161
    //   218: iconst_0
    //   219: anewarray 4	java/lang/Object
    //   222: invokespecial 136	com/tencent/luggage/wxa/jx/m$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   225: ldc 163
    //   227: aload 5
    //   229: invokevirtual 166	com/tencent/luggage/wxa/jx/m$a:a	(Ljava/lang/String;Ljava/lang/Object;)Lcom/tencent/luggage/wxa/jx/m$a;
    //   232: astore 5
    //   234: aload_2
    //   235: astore_1
    //   236: aload 5
    //   238: ldc 168
    //   240: invokestatic 79	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   243: aload_3
    //   244: aload_2
    //   245: invokestatic 174	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   248: aload 5
    //   250: areturn
    //   251: astore_2
    //   252: goto +8 -> 260
    //   255: astore_2
    //   256: aload_2
    //   257: astore_1
    //   258: aload_2
    //   259: athrow
    //   260: aload_3
    //   261: aload_1
    //   262: invokestatic 174	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   265: aload_2
    //   266: athrow
    //   267: new 176	com/tencent/luggage/wxa/ku/v$a$a
    //   270: dup
    //   271: aload_1
    //   272: aload_2
    //   273: aload_3
    //   274: invokespecial 179	com/tencent/luggage/wxa/ku/v$a$a:<init>	(Lcom/tencent/luggage/wxa/iu/b;Ljava/lang/String;Ljava/lang/String;)V
    //   277: checkcast 181	kotlin/jvm/functions/Function0
    //   280: invokeinterface 185 1 0
    //   285: checkcast 131	com/tencent/luggage/wxa/jx/m$a
    //   288: areturn
    //   289: new 187	com/tencent/luggage/wxa/ku/v$a$b
    //   292: dup
    //   293: aload_1
    //   294: aload_2
    //   295: invokespecial 190	com/tencent/luggage/wxa/ku/v$a$b:<init>	(Lcom/tencent/luggage/wxa/iu/b;Ljava/lang/String;)V
    //   298: checkcast 181	kotlin/jvm/functions/Function0
    //   301: invokeinterface 185 1 0
    //   306: checkcast 131	com/tencent/luggage/wxa/jx/m$a
    //   309: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	310	0	this	a
    //   0	310	1	paramb	com.tencent.luggage.wxa.iu.b
    //   0	310	2	paramString	java.lang.String
    //   0	310	3	paramJSONObject	org.json.JSONObject
    //   104	9	4	i	int
    //   35	214	5	localObject	Object
    //   188	14	6	locala	a
    // Exception table:
    //   from	to	target	type
    //   177	183	251	finally
    //   185	190	251	finally
    //   192	199	251	finally
    //   201	210	251	finally
    //   212	234	251	finally
    //   236	243	251	finally
    //   258	260	251	finally
    //   177	183	255	java/lang/Throwable
    //   185	190	255	java/lang/Throwable
    //   192	199	255	java/lang/Throwable
    //   201	210	255	java/lang/Throwable
    //   212	234	255	java/lang/Throwable
    //   236	243	255	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.v.a
 * JD-Core Version:    0.7.0.1
 */