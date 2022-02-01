package com.tencent.luggage.wxa.fv;

import com.tencent.luggage.wxa.dd.b.b;
import com.tencent.luggage.wxa.dd.b.c;
import com.tencent.luggage.wxa.dd.d;
import com.tencent.luggage.wxa.dd.d.b;
import com.tencent.luggage.wxa.dd.d.c;
import com.tencent.luggage.wxa.dd.d.d;
import com.tencent.luggage.wxa.fq.g.c;
import com.tencent.luggage.wxa.qw.dt;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxaapi.TdiAuthErrCode;
import com.tencent.luggage.wxaapi.TdiAuthListener;
import java.io.IOException;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/tdi/LoginByWechatOpenSDKOauth;", "Lcom/tencent/luggage/login/account/IWxaAccountManager$ILogin;", "tdiAuthBuffer", "", "tdiAuthListener", "Lcom/tencent/luggage/wxaapi/TdiAuthListener;", "([BLcom/tencent/luggage/wxaapi/TdiAuthListener;)V", "TAG", "", "wxaAccountLoginCallback", "Lcom/tencent/luggage/login/account/IWxaAccountManager$ILoginCallback;", "END_CALL", "", "tdiAuthErrCode", "Lcom/tencent/luggage/wxaapi/TdiAuthErrCode;", "tdiAuthErrMsg", "getWCProbeWaid", "login", "callback", "Companion", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class f
  implements b.b
{
  public static final f.a a = new f.a(null);
  private final String b;
  private b.c c;
  private final byte[] d;
  private final TdiAuthListener e;
  
  private f(byte[] paramArrayOfByte, TdiAuthListener paramTdiAuthListener)
  {
    this.d = paramArrayOfByte;
    this.e = paramTdiAuthListener;
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("Luggage.LoginByWechatOpenSDKOauth[");
    paramArrayOfByte.append(hashCode());
    paramArrayOfByte.append(']');
    this.b = paramArrayOfByte.toString();
  }
  
  /* Error */
  private final String a()
  {
    // Byte code:
    //   0: invokestatic 97	com/tencent/luggage/wxa/qz/r:a	()Landroid/content/Context;
    //   3: astore_1
    //   4: aload_1
    //   5: ldc 99
    //   7: invokestatic 105	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   10: aload_1
    //   11: invokevirtual 111	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   14: ldc 113
    //   16: invokestatic 119	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   19: aconst_null
    //   20: aconst_null
    //   21: aconst_null
    //   22: aconst_null
    //   23: invokevirtual 125	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   26: checkcast 127	java/io/Closeable
    //   29: astore_3
    //   30: aconst_null
    //   31: checkcast 92	java/lang/Throwable
    //   34: astore_2
    //   35: aload_2
    //   36: astore_1
    //   37: aload_3
    //   38: checkcast 129	android/database/Cursor
    //   41: astore 4
    //   43: aload 4
    //   45: ifnull +43 -> 88
    //   48: aload_2
    //   49: astore_1
    //   50: aload 4
    //   52: invokeinterface 133 1 0
    //   57: ifeq +31 -> 88
    //   60: aload_2
    //   61: astore_1
    //   62: aload 4
    //   64: aload 4
    //   66: ldc 135
    //   68: invokeinterface 139 2 0
    //   73: invokeinterface 143 2 0
    //   78: astore 4
    //   80: aload_3
    //   81: aload_2
    //   82: invokestatic 149	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   85: aload 4
    //   87: areturn
    //   88: aload_2
    //   89: astore_1
    //   90: getstatic 155	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   93: astore 4
    //   95: aload_3
    //   96: aload_2
    //   97: invokestatic 149	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   100: aconst_null
    //   101: areturn
    //   102: astore_2
    //   103: goto +8 -> 111
    //   106: astore_2
    //   107: aload_2
    //   108: astore_1
    //   109: aload_2
    //   110: athrow
    //   111: aload_3
    //   112: aload_1
    //   113: invokestatic 149	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   116: aload_2
    //   117: athrow
    //   118: astore_1
    //   119: aload_0
    //   120: getfield 87	com/tencent/luggage/wxa/fv/f:b	Ljava/lang/String;
    //   123: astore_2
    //   124: new 64	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   131: astore_3
    //   132: aload_3
    //   133: ldc 157
    //   135: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload_3
    //   140: aload_1
    //   141: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload_2
    //   146: aload_3
    //   147: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 165	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: aconst_null
    //   154: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	f
    //   3	110	1	localObject1	Object
    //   118	23	1	localThrowable1	java.lang.Throwable
    //   34	63	2	localThrowable2	java.lang.Throwable
    //   102	1	2	localObject2	Object
    //   106	11	2	localThrowable3	java.lang.Throwable
    //   123	23	2	str	String
    //   29	118	3	localObject3	Object
    //   41	53	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   37	43	102	finally
    //   50	60	102	finally
    //   62	80	102	finally
    //   90	95	102	finally
    //   109	111	102	finally
    //   37	43	106	java/lang/Throwable
    //   50	60	106	java/lang/Throwable
    //   62	80	106	java/lang/Throwable
    //   90	95	106	java/lang/Throwable
    //   0	35	118	java/lang/Throwable
    //   80	85	118	java/lang/Throwable
    //   95	100	118	java/lang/Throwable
    //   111	118	118	java/lang/Throwable
  }
  
  private final void a(TdiAuthErrCode paramTdiAuthErrCode, String paramString)
  {
    int i = g.a[paramTdiAuthErrCode.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        localObject = this.c;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("wxaAccountLoginCallback");
        }
        ((b.c)localObject).a((d)d.c.b);
      }
      else
      {
        localObject = this.c;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("wxaAccountLoginCallback");
        }
        ((b.c)localObject).a((d)d.b.b);
      }
    }
    else
    {
      localObject = this.c;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("wxaAccountLoginCallback");
      }
      ((b.c)localObject).a((d)d.d.b);
    }
    Object localObject = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("END_CALL, errCode:");
    localStringBuilder.append(paramTdiAuthErrCode);
    localStringBuilder.append(" tdiAuthErrMsg:");
    localStringBuilder.append(paramString);
    o.d((String)localObject, localStringBuilder.toString());
    localObject = this.e;
    if (localObject != null) {
      ((TdiAuthListener)localObject).onAuthFinish(paramTdiAuthErrCode, paramString);
    }
  }
  
  @ExperimentalUnsignedTypes
  public void a(@NotNull b.c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "callback");
    this.c = paramc;
    try
    {
      localObject1 = new dt();
      ((dt)localObject1).a(this.d);
      localObject2 = a();
      Object localObject3 = this.b;
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("login with host_appid:");
      ((StringBuilder)localObject4).append(g.c.a.a());
      ((StringBuilder)localObject4).append(", ilink_appid:");
      ((StringBuilder)localObject4).append(((dt)localObject1).b);
      ((StringBuilder)localObject4).append(", ilink_auth_code:");
      ((StringBuilder)localObject4).append(((dt)localObject1).a);
      ((StringBuilder)localObject4).append(", lkid:");
      ((StringBuilder)localObject4).append((String)localObject2);
      o.d((String)localObject3, ((StringBuilder)localObject4).toString());
      localObject3 = e.a;
      localObject4 = g.c.a.a();
      String str = ((dt)localObject1).b;
      Intrinsics.checkExpressionValueIsNotNull(str, "pb.ilink_appid");
      ((e)localObject3).a((String)localObject4, str);
      a.c.a(false);
      a.c.a((Function1)new f.b(this, (String)localObject2, (dt)localObject1, paramc));
      return;
    }
    catch (IOException paramc)
    {
      Object localObject1 = this.b;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("login with invalid buffer, parse exception:");
      ((StringBuilder)localObject2).append(paramc);
      o.b((String)localObject1, ((StringBuilder)localObject2).toString());
      a(this, TdiAuthErrCode.WechatTdi_Auth_Err_InvalidArgs, null, 2, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fv.f
 * JD-Core Version:    0.7.0.1
 */