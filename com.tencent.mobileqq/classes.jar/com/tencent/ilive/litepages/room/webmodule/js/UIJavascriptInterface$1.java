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
    //   1: astore_3
    //   2: sipush 8192
    //   5: newarray byte
    //   7: astore 5
    //   9: new 45	java/io/FileInputStream
    //   12: dup
    //   13: aload_0
    //   14: getfield 18	com/tencent/ilive/litepages/room/webmodule/js/UIJavascriptInterface$1:val$saveFile	Ljava/io/File;
    //   17: invokespecial 47	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   20: astore 4
    //   22: new 49	java/io/File
    //   25: dup
    //   26: aload_0
    //   27: getfield 16	com/tencent/ilive/litepages/room/webmodule/js/UIJavascriptInterface$1:this$0	Lcom/tencent/ilive/litepages/room/webmodule/js/UIJavascriptInterface;
    //   30: invokestatic 55	com/tencent/ilive/litepages/room/webmodule/js/UIJavascriptInterface:access$100	(Lcom/tencent/ilive/litepages/room/webmodule/js/UIJavascriptInterface;)Ljava/io/File;
    //   33: aload_0
    //   34: getfield 20	com/tencent/ilive/litepages/room/webmodule/js/UIJavascriptInterface$1:val$fileName	Ljava/lang/String;
    //   37: invokespecial 58	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   40: astore 6
    //   42: new 60	java/io/FileOutputStream
    //   45: dup
    //   46: aload 6
    //   48: invokespecial 61	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   51: astore_1
    //   52: aload 4
    //   54: aload 5
    //   56: invokevirtual 67	java/io/InputStream:read	([B)I
    //   59: istore_2
    //   60: iload_2
    //   61: ifle +61 -> 122
    //   64: aload_1
    //   65: aload 5
    //   67: iconst_0
    //   68: iload_2
    //   69: invokevirtual 71	java/io/FileOutputStream:write	([BII)V
    //   72: goto -20 -> 52
    //   75: astore 5
    //   77: aload 4
    //   79: astore_3
    //   80: aload 5
    //   82: astore 4
    //   84: aload_0
    //   85: getfield 16	com/tencent/ilive/litepages/room/webmodule/js/UIJavascriptInterface$1:this$0	Lcom/tencent/ilive/litepages/room/webmodule/js/UIJavascriptInterface;
    //   88: ldc 73
    //   90: new 75	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   97: ldc 78
    //   99: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload 4
    //   104: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 93	com/tencent/ilive/litepages/room/webmodule/js/UIJavascriptInterface:access$500	(Lcom/tencent/ilive/litepages/room/webmodule/js/UIJavascriptInterface;Ljava/lang/String;Ljava/lang/String;)V
    //   113: aload_3
    //   114: invokestatic 99	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   117: aload_1
    //   118: invokestatic 99	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   121: return
    //   122: aload_0
    //   123: getfield 16	com/tencent/ilive/litepages/room/webmodule/js/UIJavascriptInterface$1:this$0	Lcom/tencent/ilive/litepages/room/webmodule/js/UIJavascriptInterface;
    //   126: invokestatic 103	com/tencent/ilive/litepages/room/webmodule/js/UIJavascriptInterface:access$200	(Lcom/tencent/ilive/litepages/room/webmodule/js/UIJavascriptInterface;)Landroid/content/Context;
    //   129: astore_3
    //   130: aload 6
    //   132: invokevirtual 106	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   135: astore 5
    //   137: new 108	com/tencent/ilive/litepages/room/webmodule/js/UIJavascriptInterface$1$2
    //   140: dup
    //   141: aload_0
    //   142: invokespecial 109	com/tencent/ilive/litepages/room/webmodule/js/UIJavascriptInterface$1$2:<init>	(Lcom/tencent/ilive/litepages/room/webmodule/js/UIJavascriptInterface$1;)V
    //   145: astore 6
    //   147: aload_3
    //   148: iconst_1
    //   149: anewarray 111	java/lang/String
    //   152: dup
    //   153: iconst_0
    //   154: aload 5
    //   156: aastore
    //   157: iconst_1
    //   158: anewarray 111	java/lang/String
    //   161: dup
    //   162: iconst_0
    //   163: ldc 113
    //   165: aastore
    //   166: aload 6
    //   168: invokestatic 119	android/media/MediaScannerConnection:scanFile	(Landroid/content/Context;[Ljava/lang/String;[Ljava/lang/String;Landroid/media/MediaScannerConnection$OnScanCompletedListener;)V
    //   171: new 121	com/tencent/ilive/litepages/room/webmodule/js/UIJavascriptInterface$1$3
    //   174: dup
    //   175: aload_0
    //   176: invokespecial 122	com/tencent/ilive/litepages/room/webmodule/js/UIJavascriptInterface$1$3:<init>	(Lcom/tencent/ilive/litepages/room/webmodule/js/UIJavascriptInterface$1;)V
    //   179: invokestatic 37	com/tencent/falco/utils/ThreadCenter:postDefaultUITask	(Ljava/lang/Runnable;)V
    //   182: aload 4
    //   184: invokestatic 99	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   187: aload_1
    //   188: invokestatic 99	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   191: return
    //   192: astore_3
    //   193: aconst_null
    //   194: astore_1
    //   195: aconst_null
    //   196: astore 4
    //   198: aload 4
    //   200: invokestatic 99	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   203: aload_1
    //   204: invokestatic 99	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   207: aload_3
    //   208: athrow
    //   209: astore_3
    //   210: aconst_null
    //   211: astore_1
    //   212: goto -14 -> 198
    //   215: astore_3
    //   216: goto -18 -> 198
    //   219: astore 5
    //   221: aload_3
    //   222: astore 4
    //   224: aload 5
    //   226: astore_3
    //   227: goto -29 -> 198
    //   230: astore 4
    //   232: aconst_null
    //   233: astore_1
    //   234: goto -150 -> 84
    //   237: astore 5
    //   239: aconst_null
    //   240: astore_1
    //   241: aload 4
    //   243: astore_3
    //   244: aload 5
    //   246: astore 4
    //   248: goto -164 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	this	1
    //   0	251	1	paramFile	File
    //   59	10	2	i	int
    //   1	147	3	localObject1	Object
    //   192	16	3	localObject2	Object
    //   209	1	3	localObject3	Object
    //   215	7	3	localObject4	Object
    //   226	18	3	localObject5	Object
    //   20	203	4	localObject6	Object
    //   230	12	4	localException1	java.lang.Exception
    //   246	1	4	localException2	java.lang.Exception
    //   7	59	5	arrayOfByte	byte[]
    //   75	6	5	localException3	java.lang.Exception
    //   135	20	5	str	String
    //   219	6	5	localObject7	Object
    //   237	8	5	localException4	java.lang.Exception
    //   40	127	6	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   52	60	75	java/lang/Exception
    //   64	72	75	java/lang/Exception
    //   122	182	75	java/lang/Exception
    //   2	22	192	finally
    //   22	52	209	finally
    //   52	60	215	finally
    //   64	72	215	finally
    //   122	182	215	finally
    //   84	113	219	finally
    //   2	22	230	java/lang/Exception
    //   22	52	237	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.webmodule.js.UIJavascriptInterface.1
 * JD-Core Version:    0.7.0.1
 */