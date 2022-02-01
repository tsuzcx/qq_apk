package com.tencent.ilive.litepages.room.webmodule.js;

import com.tencent.falco.base.libapi.http.DownloadCallback;
import com.tencent.falco.utils.ThreadCenter;
import java.io.File;

class UIJavascriptInterface$1
  implements DownloadCallback
{
  UIJavascriptInterface$1(UIJavascriptInterface paramUIJavascriptInterface, File paramFile, String paramString) {}
  
  public void onFail(int paramInt)
  {
    ThreadCenter.postDefaultUITask(new UIJavascriptInterface.1.1(this));
  }
  
  public void onProgress(long paramLong1, long paramLong2, int paramInt) {}
  
  /* Error */
  public void onSuccess(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: sipush 8192
    //   6: newarray byte
    //   8: astore 4
    //   10: new 45	java/io/FileInputStream
    //   13: dup
    //   14: aload_0
    //   15: getfield 18	com/tencent/ilive/litepages/room/webmodule/js/UIJavascriptInterface$1:val$saveFile	Ljava/io/File;
    //   18: invokespecial 47	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   21: astore_3
    //   22: new 49	java/io/File
    //   25: dup
    //   26: aload_0
    //   27: getfield 16	com/tencent/ilive/litepages/room/webmodule/js/UIJavascriptInterface$1:this$0	Lcom/tencent/ilive/litepages/room/webmodule/js/UIJavascriptInterface;
    //   30: invokestatic 55	com/tencent/ilive/litepages/room/webmodule/js/UIJavascriptInterface:access$100	(Lcom/tencent/ilive/litepages/room/webmodule/js/UIJavascriptInterface;)Ljava/io/File;
    //   33: aload_0
    //   34: getfield 20	com/tencent/ilive/litepages/room/webmodule/js/UIJavascriptInterface$1:val$fileName	Ljava/lang/String;
    //   37: invokespecial 58	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   40: astore 5
    //   42: new 60	java/io/FileOutputStream
    //   45: dup
    //   46: aload 5
    //   48: invokespecial 61	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   51: astore_1
    //   52: aload_3
    //   53: aload 4
    //   55: invokevirtual 67	java/io/InputStream:read	([B)I
    //   58: istore_2
    //   59: iload_2
    //   60: ifle +14 -> 74
    //   63: aload_1
    //   64: aload 4
    //   66: iconst_0
    //   67: iload_2
    //   68: invokevirtual 71	java/io/FileOutputStream:write	([BII)V
    //   71: goto -19 -> 52
    //   74: aload_0
    //   75: getfield 16	com/tencent/ilive/litepages/room/webmodule/js/UIJavascriptInterface$1:this$0	Lcom/tencent/ilive/litepages/room/webmodule/js/UIJavascriptInterface;
    //   78: invokestatic 75	com/tencent/ilive/litepages/room/webmodule/js/UIJavascriptInterface:access$200	(Lcom/tencent/ilive/litepages/room/webmodule/js/UIJavascriptInterface;)Landroid/content/Context;
    //   81: astore 4
    //   83: aload 5
    //   85: invokevirtual 79	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   88: astore 5
    //   90: new 81	com/tencent/ilive/litepages/room/webmodule/js/UIJavascriptInterface$1$2
    //   93: dup
    //   94: aload_0
    //   95: invokespecial 82	com/tencent/ilive/litepages/room/webmodule/js/UIJavascriptInterface$1$2:<init>	(Lcom/tencent/ilive/litepages/room/webmodule/js/UIJavascriptInterface$1;)V
    //   98: astore 6
    //   100: aload 4
    //   102: iconst_1
    //   103: anewarray 84	java/lang/String
    //   106: dup
    //   107: iconst_0
    //   108: aload 5
    //   110: aastore
    //   111: iconst_1
    //   112: anewarray 84	java/lang/String
    //   115: dup
    //   116: iconst_0
    //   117: ldc 86
    //   119: aastore
    //   120: aload 6
    //   122: invokestatic 92	android/media/MediaScannerConnection:scanFile	(Landroid/content/Context;[Ljava/lang/String;[Ljava/lang/String;Landroid/media/MediaScannerConnection$OnScanCompletedListener;)V
    //   125: new 94	com/tencent/ilive/litepages/room/webmodule/js/UIJavascriptInterface$1$3
    //   128: dup
    //   129: aload_0
    //   130: invokespecial 95	com/tencent/ilive/litepages/room/webmodule/js/UIJavascriptInterface$1$3:<init>	(Lcom/tencent/ilive/litepages/room/webmodule/js/UIJavascriptInterface$1;)V
    //   133: invokestatic 37	com/tencent/falco/utils/ThreadCenter:postDefaultUITask	(Ljava/lang/Runnable;)V
    //   136: aload_3
    //   137: invokestatic 101	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   140: goto +103 -> 243
    //   143: astore 5
    //   145: aload_3
    //   146: astore 4
    //   148: aload 5
    //   150: astore_3
    //   151: goto +105 -> 256
    //   154: astore 4
    //   156: goto +20 -> 176
    //   159: astore 5
    //   161: aconst_null
    //   162: astore_1
    //   163: aload_3
    //   164: astore 4
    //   166: aload 5
    //   168: astore_3
    //   169: goto +87 -> 256
    //   172: astore 4
    //   174: aconst_null
    //   175: astore_1
    //   176: goto +20 -> 196
    //   179: astore_3
    //   180: aconst_null
    //   181: astore 4
    //   183: aload 4
    //   185: astore_1
    //   186: goto +70 -> 256
    //   189: astore 4
    //   191: aconst_null
    //   192: astore_1
    //   193: aload 5
    //   195: astore_3
    //   196: aload_0
    //   197: getfield 16	com/tencent/ilive/litepages/room/webmodule/js/UIJavascriptInterface$1:this$0	Lcom/tencent/ilive/litepages/room/webmodule/js/UIJavascriptInterface;
    //   200: astore 5
    //   202: new 103	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   209: astore 6
    //   211: aload 6
    //   213: ldc 106
    //   215: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload 6
    //   221: aload 4
    //   223: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload 5
    //   229: ldc 115
    //   231: aload 6
    //   233: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 122	com/tencent/ilive/litepages/room/webmodule/js/UIJavascriptInterface:access$500	(Lcom/tencent/ilive/litepages/room/webmodule/js/UIJavascriptInterface;Ljava/lang/String;Ljava/lang/String;)V
    //   239: aload_3
    //   240: invokestatic 101	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   243: aload_1
    //   244: invokestatic 101	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   247: return
    //   248: astore 5
    //   250: aload_3
    //   251: astore 4
    //   253: aload 5
    //   255: astore_3
    //   256: aload 4
    //   258: invokestatic 101	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   261: aload_1
    //   262: invokestatic 101	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   265: goto +5 -> 270
    //   268: aload_3
    //   269: athrow
    //   270: goto -2 -> 268
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	this	1
    //   0	273	1	paramFile	File
    //   58	10	2	i	int
    //   21	148	3	localObject1	Object
    //   179	1	3	localObject2	Object
    //   195	74	3	localObject3	Object
    //   8	139	4	localObject4	Object
    //   154	1	4	localException1	java.lang.Exception
    //   164	1	4	localObject5	Object
    //   172	1	4	localException2	java.lang.Exception
    //   181	3	4	localObject6	Object
    //   189	33	4	localException3	java.lang.Exception
    //   251	6	4	localObject7	Object
    //   1	108	5	localObject8	Object
    //   143	6	5	localObject9	Object
    //   159	35	5	localObject10	Object
    //   200	28	5	localUIJavascriptInterface	UIJavascriptInterface
    //   248	6	5	localObject11	Object
    //   98	134	6	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   52	59	143	finally
    //   63	71	143	finally
    //   74	136	143	finally
    //   52	59	154	java/lang/Exception
    //   63	71	154	java/lang/Exception
    //   74	136	154	java/lang/Exception
    //   22	52	159	finally
    //   22	52	172	java/lang/Exception
    //   3	22	179	finally
    //   3	22	189	java/lang/Exception
    //   196	239	248	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.webmodule.js.UIJavascriptInterface.1
 * JD-Core Version:    0.7.0.1
 */