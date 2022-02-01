package com.tencent.luggage.wxa.kz;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public abstract class a
  extends com.tencent.luggage.wxa.jx.a<c>
{
  /* Error */
  private boolean a(@NonNull String paramString, @NonNull java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aload 6
    //   8: astore 4
    //   10: aload 7
    //   12: astore 5
    //   14: new 20	com/tencent/luggage/wxa/rt/i
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 23	com/tencent/luggage/wxa/rt/i:<init>	(Ljava/lang/String;)V
    //   22: astore_1
    //   23: aload 6
    //   25: astore 4
    //   27: aload 7
    //   29: astore 5
    //   31: aload_1
    //   32: invokevirtual 27	com/tencent/luggage/wxa/rt/i:g	()Lcom/tencent/luggage/wxa/rt/i;
    //   35: invokevirtual 31	com/tencent/luggage/wxa/rt/i:u	()Z
    //   38: pop
    //   39: aload 6
    //   41: astore 4
    //   43: aload 7
    //   45: astore 5
    //   47: aload_1
    //   48: invokestatic 37	com/tencent/luggage/wxa/rt/k:b	(Lcom/tencent/luggage/wxa/rt/i;)Ljava/io/OutputStream;
    //   51: astore_1
    //   52: aload_1
    //   53: astore 4
    //   55: aload_1
    //   56: astore 5
    //   58: sipush 4096
    //   61: newarray byte
    //   63: astore 6
    //   65: aload_1
    //   66: astore 4
    //   68: aload_1
    //   69: astore 5
    //   71: aload_2
    //   72: aload 6
    //   74: iconst_0
    //   75: aload 6
    //   77: arraylength
    //   78: invokevirtual 43	java/io/InputStream:read	([BII)I
    //   81: istore_3
    //   82: iload_3
    //   83: iconst_m1
    //   84: if_icmpeq +20 -> 104
    //   87: aload_1
    //   88: astore 4
    //   90: aload_1
    //   91: astore 5
    //   93: aload_1
    //   94: aload 6
    //   96: iconst_0
    //   97: iload_3
    //   98: invokevirtual 49	java/io/OutputStream:write	([BII)V
    //   101: goto -36 -> 65
    //   104: aload_1
    //   105: astore 4
    //   107: aload_1
    //   108: astore 5
    //   110: aload_1
    //   111: invokevirtual 52	java/io/OutputStream:flush	()V
    //   114: aload_1
    //   115: invokestatic 57	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   118: aload_2
    //   119: invokestatic 57	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   122: iconst_1
    //   123: ireturn
    //   124: astore_1
    //   125: goto +34 -> 159
    //   128: astore_1
    //   129: aload 5
    //   131: astore 4
    //   133: ldc 59
    //   135: ldc 61
    //   137: iconst_1
    //   138: anewarray 63	java/lang/Object
    //   141: dup
    //   142: iconst_0
    //   143: aload_1
    //   144: aastore
    //   145: invokestatic 68	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   148: aload 5
    //   150: invokestatic 57	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   153: aload_2
    //   154: invokestatic 57	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   157: iconst_0
    //   158: ireturn
    //   159: aload 4
    //   161: invokestatic 57	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   164: aload_2
    //   165: invokestatic 57	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   168: goto +5 -> 173
    //   171: aload_1
    //   172: athrow
    //   173: goto -2 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	a
    //   0	176	1	paramString	String
    //   0	176	2	paramInputStream	java.io.InputStream
    //   81	17	3	i	int
    //   8	152	4	localObject1	Object
    //   12	137	5	localObject2	Object
    //   4	91	6	arrayOfByte	byte[]
    //   1	43	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   14	23	124	finally
    //   31	39	124	finally
    //   47	52	124	finally
    //   58	65	124	finally
    //   71	82	124	finally
    //   93	101	124	finally
    //   110	114	124	finally
    //   133	148	124	finally
    //   14	23	128	java/lang/Exception
    //   31	39	128	java/lang/Exception
    //   47	52	128	java/lang/Exception
    //   58	65	128	java/lang/Exception
    //   71	82	128	java/lang/Exception
    //   93	101	128	java/lang/Exception
    //   110	114	128	java/lang/Exception
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = paramJSONObject.optString("filePath", "");
    if (af.c(paramJSONObject))
    {
      paramc.a(paramInt, b("fail filePath invalid"));
      return;
    }
    paramJSONObject = new a.1(this, paramc, paramJSONObject, paramInt);
    a.a locala = (a.a)paramc.a(a.a.class);
    if (locala == null)
    {
      o.c("MicroMsg.AppBrand.BaseJsApiSaveToPhotosAlbum", "NULL permissionInterface with appId:%s, run directly", new Object[] { paramc.getAppId() });
      paramJSONObject.run();
      return;
    }
    locala.a(paramc.getContext(), paramJSONObject, new a.2(this, paramc, paramInt));
  }
  
  abstract boolean a(String paramString);
  
  @NonNull
  abstract String c(String paramString);
  
  abstract void d(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kz.a
 * JD-Core Version:    0.7.0.1
 */