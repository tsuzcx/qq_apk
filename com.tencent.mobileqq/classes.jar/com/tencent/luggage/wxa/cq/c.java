package com.tencent.luggage.wxa.cq;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.dc.g;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rt.i;
import java.io.ByteArrayOutputStream;
import java.io.File;
import okhttp3.RequestBody;
import org.apache.commons.io.IOUtils;

final class c
{
  static String a(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      int i = Math.round(840.0F);
      int j = Math.round(672.0F);
      float f = i / j;
      Object localObject;
      if (paramBitmap.getHeight() / paramBitmap.getWidth() >= f) {
        localObject = new c.1(f);
      } else {
        localObject = new c.2(f);
      }
      paramBitmap = ((c.a)localObject).b(paramBitmap);
      paramBitmap = b(new c.3(j, i).b(paramBitmap));
      if (paramBitmap == null)
      {
        o.b("Luggage.HttpUploadImg", "bytes is null, return");
        return "";
      }
      return a(paramBitmap);
    }
    o.b("Luggage.HttpUploadImg", "bitmap is null, return");
    return "";
  }
  
  public static String a(i parami)
  {
    if ((parami != null) && (parami.j())) {
      return a(RequestBody.create(g.b, new File(parami.l())));
    }
    o.b("Luggage.HttpUploadImg", "file is null, return");
    return "";
  }
  
  /* Error */
  private static String a(RequestBody paramRequestBody)
  {
    // Byte code:
    //   0: ldc 62
    //   2: astore 4
    //   4: new 105	okhttp3/Request$Builder
    //   7: dup
    //   8: invokespecial 108	okhttp3/Request$Builder:<init>	()V
    //   11: ldc 110
    //   13: invokevirtual 114	okhttp3/Request$Builder:url	(Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   16: aload_0
    //   17: invokevirtual 118	okhttp3/Request$Builder:post	(Lokhttp3/RequestBody;)Lokhttp3/Request$Builder;
    //   20: invokevirtual 122	okhttp3/Request$Builder:build	()Lokhttp3/Request;
    //   23: astore_3
    //   24: aconst_null
    //   25: astore_1
    //   26: aconst_null
    //   27: astore_2
    //   28: aconst_null
    //   29: astore_0
    //   30: invokestatic 126	com/tencent/luggage/wxa/dc/g:cgiClient	()Lokhttp3/OkHttpClient;
    //   33: aload_3
    //   34: invokevirtual 132	okhttp3/OkHttpClient:newCall	(Lokhttp3/Request;)Lokhttp3/Call;
    //   37: invokeinterface 138 1 0
    //   42: astore_3
    //   43: aload_3
    //   44: astore_0
    //   45: aload_3
    //   46: astore_1
    //   47: aload_3
    //   48: astore_2
    //   49: new 140	org/json/JSONObject
    //   52: dup
    //   53: aload_3
    //   54: invokevirtual 146	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   57: invokevirtual 151	okhttp3/ResponseBody:string	()Ljava/lang/String;
    //   60: invokespecial 152	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   63: astore 5
    //   65: aload_3
    //   66: astore_0
    //   67: aload_3
    //   68: astore_1
    //   69: aload_3
    //   70: astore_2
    //   71: ldc 53
    //   73: ldc 154
    //   75: iconst_1
    //   76: anewarray 4	java/lang/Object
    //   79: dup
    //   80: iconst_0
    //   81: aload 5
    //   83: aastore
    //   84: invokestatic 158	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   87: aload_3
    //   88: astore_0
    //   89: aload_3
    //   90: astore_1
    //   91: aload_3
    //   92: astore_2
    //   93: aload 5
    //   95: ldc 159
    //   97: invokevirtual 163	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   100: astore 5
    //   102: aload 5
    //   104: astore_0
    //   105: aload_3
    //   106: ifnull +78 -> 184
    //   109: aload_3
    //   110: astore_1
    //   111: aload 5
    //   113: astore 4
    //   115: aload_1
    //   116: invokevirtual 166	okhttp3/Response:close	()V
    //   119: aload 4
    //   121: areturn
    //   122: astore_1
    //   123: goto +63 -> 186
    //   126: astore_2
    //   127: aload_1
    //   128: astore_0
    //   129: ldc 53
    //   131: ldc 62
    //   133: iconst_1
    //   134: anewarray 4	java/lang/Object
    //   137: dup
    //   138: iconst_0
    //   139: aload_2
    //   140: aastore
    //   141: invokestatic 169	com/tencent/luggage/wxa/qz/o:h	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   144: aload 4
    //   146: astore_0
    //   147: aload_1
    //   148: ifnull +36 -> 184
    //   151: goto -36 -> 115
    //   154: astore_1
    //   155: aload_2
    //   156: astore_0
    //   157: ldc 53
    //   159: ldc 62
    //   161: iconst_1
    //   162: anewarray 4	java/lang/Object
    //   165: dup
    //   166: iconst_0
    //   167: aload_1
    //   168: aastore
    //   169: invokestatic 169	com/tencent/luggage/wxa/qz/o:h	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   172: aload 4
    //   174: astore_0
    //   175: aload_2
    //   176: ifnull +8 -> 184
    //   179: aload_2
    //   180: astore_1
    //   181: goto -66 -> 115
    //   184: aload_0
    //   185: areturn
    //   186: aload_0
    //   187: ifnull +7 -> 194
    //   190: aload_0
    //   191: invokevirtual 166	okhttp3/Response:close	()V
    //   194: goto +5 -> 199
    //   197: aload_1
    //   198: athrow
    //   199: goto -2 -> 197
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	paramRequestBody	RequestBody
    //   25	91	1	localObject1	Object
    //   122	26	1	localObject2	Object
    //   154	14	1	localJSONException	org.json.JSONException
    //   180	18	1	localObject3	Object
    //   27	66	2	localObject4	Object
    //   126	54	2	localIOException	java.io.IOException
    //   23	87	3	localObject5	Object
    //   2	171	4	localObject6	Object
    //   63	49	5	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   30	43	122	finally
    //   49	65	122	finally
    //   71	87	122	finally
    //   93	102	122	finally
    //   129	144	122	finally
    //   157	172	122	finally
    //   30	43	126	java/io/IOException
    //   49	65	126	java/io/IOException
    //   71	87	126	java/io/IOException
    //   93	102	126	java/io/IOException
    //   30	43	154	org/json/JSONException
    //   49	65	154	org/json/JSONException
    //   71	87	154	org/json/JSONException
    //   93	102	154	org/json/JSONException
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    return a(RequestBody.create(g.b, paramArrayOfByte));
  }
  
  private static byte[] b(@NonNull Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 70, localByteArrayOutputStream);
    paramBitmap = localByteArrayOutputStream.toByteArray();
    IOUtils.closeQuietly(localByteArrayOutputStream);
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cq.c
 * JD-Core Version:    0.7.0.1
 */