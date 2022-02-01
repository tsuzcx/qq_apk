package com.tencent.luggage.wxa.hh;

import android.annotation.TargetApi;
import android.media.MediaMetadataRetriever;

@TargetApi(16)
public class b
  extends MediaMetadataRetriever
{
  /* Error */
  public void setDataSource(android.content.Context paramContext, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 24	android/net/Uri:getScheme	()Ljava/lang/String;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnull +30 -> 36
    //   9: aload_3
    //   10: ldc 26
    //   12: invokevirtual 32	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15: ifne +21 -> 36
    //   18: aload_3
    //   19: ldc 34
    //   21: invokevirtual 32	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   24: ifne +12 -> 36
    //   27: aload_3
    //   28: ldc 36
    //   30: invokevirtual 32	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   33: ifeq +124 -> 157
    //   36: aload_2
    //   37: ldc 38
    //   39: invokestatic 44	com/tencent/luggage/wxa/rt/k:a	(Landroid/net/Uri;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   42: astore 5
    //   44: aconst_null
    //   45: astore_3
    //   46: aload_0
    //   47: aload 5
    //   49: invokevirtual 50	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   52: invokevirtual 53	com/tencent/luggage/wxa/hh/b:setDataSource	(Ljava/io/FileDescriptor;)V
    //   55: aload 5
    //   57: ifnull +8 -> 65
    //   60: aload 5
    //   62: invokevirtual 56	android/os/ParcelFileDescriptor:close	()V
    //   65: return
    //   66: astore 4
    //   68: goto +11 -> 79
    //   71: astore 4
    //   73: aload 4
    //   75: astore_3
    //   76: aload 4
    //   78: athrow
    //   79: aload 5
    //   81: ifnull +20 -> 101
    //   84: aload_3
    //   85: ifnull +11 -> 96
    //   88: aload 5
    //   90: invokevirtual 56	android/os/ParcelFileDescriptor:close	()V
    //   93: goto +8 -> 101
    //   96: aload 5
    //   98: invokevirtual 56	android/os/ParcelFileDescriptor:close	()V
    //   101: aload 4
    //   103: athrow
    //   104: astore_3
    //   105: new 58	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   112: astore 4
    //   114: aload 4
    //   116: ldc 61
    //   118: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload 4
    //   124: aload_2
    //   125: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload 4
    //   131: ldc 70
    //   133: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload 4
    //   139: aload_3
    //   140: invokevirtual 73	java/io/IOException:getMessage	()Ljava/lang/String;
    //   143: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: ldc 75
    //   149: aload 4
    //   151: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 84	com/tencent/luggage/wxa/ry/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: aload_0
    //   158: aload_1
    //   159: aload_2
    //   160: invokespecial 86	android/media/MediaMetadataRetriever:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   163: return
    //   164: astore_3
    //   165: goto -64 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	b
    //   0	168	1	paramContext	android.content.Context
    //   0	168	2	paramUri	android.net.Uri
    //   4	81	3	localObject1	java.lang.Object
    //   104	36	3	localIOException	java.io.IOException
    //   164	1	3	localThrowable1	java.lang.Throwable
    //   66	1	4	localObject2	java.lang.Object
    //   71	31	4	localThrowable2	java.lang.Throwable
    //   112	38	4	localStringBuilder	java.lang.StringBuilder
    //   42	55	5	localParcelFileDescriptor	android.os.ParcelFileDescriptor
    // Exception table:
    //   from	to	target	type
    //   46	55	66	finally
    //   76	79	66	finally
    //   46	55	71	java/lang/Throwable
    //   36	44	104	java/io/IOException
    //   60	65	104	java/io/IOException
    //   88	93	104	java/io/IOException
    //   96	101	104	java/io/IOException
    //   101	104	104	java/io/IOException
    //   88	93	164	java/lang/Throwable
  }
  
  /* Error */
  public void setDataSource(java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 38
    //   3: invokestatic 90	com/tencent/luggage/wxa/rt/k:a	(Ljava/lang/String;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   6: astore 4
    //   8: aconst_null
    //   9: astore_2
    //   10: aload_0
    //   11: aload 4
    //   13: invokevirtual 50	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   16: invokevirtual 53	com/tencent/luggage/wxa/hh/b:setDataSource	(Ljava/io/FileDescriptor;)V
    //   19: aload 4
    //   21: ifnull +8 -> 29
    //   24: aload 4
    //   26: invokevirtual 56	android/os/ParcelFileDescriptor:close	()V
    //   29: return
    //   30: astore_3
    //   31: goto +8 -> 39
    //   34: astore_3
    //   35: aload_3
    //   36: astore_2
    //   37: aload_3
    //   38: athrow
    //   39: aload 4
    //   41: ifnull +20 -> 61
    //   44: aload_2
    //   45: ifnull +11 -> 56
    //   48: aload 4
    //   50: invokevirtual 56	android/os/ParcelFileDescriptor:close	()V
    //   53: goto +8 -> 61
    //   56: aload 4
    //   58: invokevirtual 56	android/os/ParcelFileDescriptor:close	()V
    //   61: aload_3
    //   62: athrow
    //   63: astore_2
    //   64: new 58	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   71: astore_3
    //   72: aload_3
    //   73: ldc 92
    //   75: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_3
    //   80: aload_1
    //   81: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload_3
    //   86: ldc 70
    //   88: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload_3
    //   93: aload_2
    //   94: invokevirtual 73	java/io/IOException:getMessage	()Ljava/lang/String;
    //   97: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: ldc 75
    //   103: aload_3
    //   104: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 84	com/tencent/luggage/wxa/ry/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: aload_0
    //   111: aload_1
    //   112: invokespecial 94	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   115: return
    //   116: astore_2
    //   117: goto -56 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	b
    //   0	120	1	paramString	java.lang.String
    //   9	36	2	localObject1	java.lang.Object
    //   63	31	2	localIOException	java.io.IOException
    //   116	1	2	localThrowable1	java.lang.Throwable
    //   30	1	3	localObject2	java.lang.Object
    //   34	28	3	localThrowable2	java.lang.Throwable
    //   71	33	3	localStringBuilder	java.lang.StringBuilder
    //   6	51	4	localParcelFileDescriptor	android.os.ParcelFileDescriptor
    // Exception table:
    //   from	to	target	type
    //   10	19	30	finally
    //   37	39	30	finally
    //   10	19	34	java/lang/Throwable
    //   0	8	63	java/io/IOException
    //   24	29	63	java/io/IOException
    //   48	53	63	java/io/IOException
    //   56	61	63	java/io/IOException
    //   61	63	63	java/io/IOException
    //   48	53	116	java/lang/Throwable
  }
  
  /* Error */
  public void setDataSource(java.lang.String paramString, java.util.Map<java.lang.String, java.lang.String> paramMap)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 99	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   4: invokevirtual 24	android/net/Uri:getScheme	()Ljava/lang/String;
    //   7: astore_3
    //   8: aload_3
    //   9: ifnull +30 -> 39
    //   12: aload_3
    //   13: ldc 26
    //   15: invokevirtual 32	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   18: ifne +21 -> 39
    //   21: aload_3
    //   22: ldc 34
    //   24: invokevirtual 32	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   27: ifne +12 -> 39
    //   30: aload_3
    //   31: ldc 36
    //   33: invokevirtual 32	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   36: ifeq +124 -> 160
    //   39: aload_1
    //   40: ldc 38
    //   42: invokestatic 90	com/tencent/luggage/wxa/rt/k:a	(Ljava/lang/String;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   45: astore 5
    //   47: aconst_null
    //   48: astore_3
    //   49: aload_0
    //   50: aload 5
    //   52: invokevirtual 50	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   55: invokevirtual 53	com/tencent/luggage/wxa/hh/b:setDataSource	(Ljava/io/FileDescriptor;)V
    //   58: aload 5
    //   60: ifnull +8 -> 68
    //   63: aload 5
    //   65: invokevirtual 56	android/os/ParcelFileDescriptor:close	()V
    //   68: return
    //   69: astore 4
    //   71: goto +11 -> 82
    //   74: astore 4
    //   76: aload 4
    //   78: astore_3
    //   79: aload 4
    //   81: athrow
    //   82: aload 5
    //   84: ifnull +20 -> 104
    //   87: aload_3
    //   88: ifnull +11 -> 99
    //   91: aload 5
    //   93: invokevirtual 56	android/os/ParcelFileDescriptor:close	()V
    //   96: goto +8 -> 104
    //   99: aload 5
    //   101: invokevirtual 56	android/os/ParcelFileDescriptor:close	()V
    //   104: aload 4
    //   106: athrow
    //   107: astore_3
    //   108: new 58	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   115: astore 4
    //   117: aload 4
    //   119: ldc 61
    //   121: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload 4
    //   127: aload_1
    //   128: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload 4
    //   134: ldc 70
    //   136: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload 4
    //   142: aload_3
    //   143: invokevirtual 73	java/io/IOException:getMessage	()Ljava/lang/String;
    //   146: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: ldc 75
    //   152: aload 4
    //   154: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 84	com/tencent/luggage/wxa/ry/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: aload_0
    //   161: aload_1
    //   162: aload_2
    //   163: invokespecial 101	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;Ljava/util/Map;)V
    //   166: return
    //   167: astore_3
    //   168: goto -64 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	b
    //   0	171	1	paramString	java.lang.String
    //   0	171	2	paramMap	java.util.Map<java.lang.String, java.lang.String>
    //   7	81	3	localObject1	java.lang.Object
    //   107	36	3	localIOException	java.io.IOException
    //   167	1	3	localThrowable1	java.lang.Throwable
    //   69	1	4	localObject2	java.lang.Object
    //   74	31	4	localThrowable2	java.lang.Throwable
    //   115	38	4	localStringBuilder	java.lang.StringBuilder
    //   45	55	5	localParcelFileDescriptor	android.os.ParcelFileDescriptor
    // Exception table:
    //   from	to	target	type
    //   49	58	69	finally
    //   79	82	69	finally
    //   49	58	74	java/lang/Throwable
    //   39	47	107	java/io/IOException
    //   63	68	107	java/io/IOException
    //   91	96	107	java/io/IOException
    //   99	104	107	java/io/IOException
    //   104	107	107	java/io/IOException
    //   91	96	167	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hh.b
 * JD-Core Version:    0.7.0.1
 */