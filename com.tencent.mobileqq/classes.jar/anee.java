import com.tencent.mobileqq.app.VideoBroadcastReceiver;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;

public class anee
  implements INetEngine.INetEngineListener
{
  public anee(VideoBroadcastReceiver paramVideoBroadcastReceiver) {}
  
  /* Error */
  public void onResp(com.tencent.mobileqq.transfile.NetResp paramNetResp)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_1
    //   6: ifnonnull +8 -> 14
    //   9: aconst_null
    //   10: invokestatic 26	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   13: return
    //   14: aload 4
    //   16: astore_2
    //   17: invokestatic 32	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +71 -> 91
    //   23: aload 4
    //   25: astore_2
    //   26: getstatic 37	com/tencent/mobileqq/app/VideoBroadcastReceiver:a	Ljava/lang/String;
    //   29: iconst_2
    //   30: new 39	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   37: ldc 42
    //   39: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_1
    //   43: getfield 52	com/tencent/mobileqq/transfile/NetResp:mHttpCode	I
    //   46: invokevirtual 55	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   49: ldc 57
    //   51: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_1
    //   55: getfield 60	com/tencent/mobileqq/transfile/NetResp:mErrCode	I
    //   58: invokevirtual 55	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   61: ldc 62
    //   63: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_1
    //   67: getfield 65	com/tencent/mobileqq/transfile/NetResp:mResult	I
    //   70: invokevirtual 55	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   73: ldc 67
    //   75: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_1
    //   79: getfield 70	com/tencent/mobileqq/transfile/NetResp:mErrDesc	Ljava/lang/String;
    //   82: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: aload 4
    //   93: astore_2
    //   94: aload_1
    //   95: getfield 82	com/tencent/mobileqq/transfile/NetResp:mReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   98: getfield 88	com/tencent/mobileqq/transfile/NetReq:mOutStream	Ljava/io/OutputStream;
    //   101: instanceof 90
    //   104: ifeq +97 -> 201
    //   107: aload 4
    //   109: astore_2
    //   110: aload_1
    //   111: getfield 82	com/tencent/mobileqq/transfile/NetResp:mReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   114: getfield 88	com/tencent/mobileqq/transfile/NetReq:mOutStream	Ljava/io/OutputStream;
    //   117: checkcast 90	bfxe
    //   120: astore_1
    //   121: aload_1
    //   122: ifnonnull +8 -> 130
    //   125: aload_1
    //   126: invokestatic 26	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   129: return
    //   130: aload_1
    //   131: invokevirtual 91	bfxe:toString	()Ljava/lang/String;
    //   134: astore_2
    //   135: getstatic 37	com/tencent/mobileqq/app/VideoBroadcastReceiver:a	Ljava/lang/String;
    //   138: iconst_2
    //   139: new 39	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   146: ldc 93
    //   148: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload_2
    //   152: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   161: aload_1
    //   162: invokestatic 26	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   165: return
    //   166: astore_2
    //   167: aload_3
    //   168: astore_1
    //   169: aload_2
    //   170: astore_3
    //   171: aload_1
    //   172: astore_2
    //   173: aload_3
    //   174: invokevirtual 96	java/lang/Exception:printStackTrace	()V
    //   177: aload_1
    //   178: invokestatic 26	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   181: return
    //   182: astore_3
    //   183: aload_2
    //   184: astore_1
    //   185: aload_3
    //   186: astore_2
    //   187: aload_1
    //   188: invokestatic 26	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   191: aload_2
    //   192: athrow
    //   193: astore_2
    //   194: goto -7 -> 187
    //   197: astore_3
    //   198: goto -27 -> 171
    //   201: aconst_null
    //   202: astore_1
    //   203: goto -42 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	anee
    //   0	206	1	paramNetResp	com.tencent.mobileqq.transfile.NetResp
    //   16	136	2	localObject1	Object
    //   166	4	2	localException1	java.lang.Exception
    //   172	20	2	localObject2	Object
    //   193	1	2	localObject3	Object
    //   4	170	3	localObject4	Object
    //   182	4	3	localObject5	Object
    //   197	1	3	localException2	java.lang.Exception
    //   1	107	4	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   17	23	166	java/lang/Exception
    //   26	91	166	java/lang/Exception
    //   94	107	166	java/lang/Exception
    //   110	121	166	java/lang/Exception
    //   17	23	182	finally
    //   26	91	182	finally
    //   94	107	182	finally
    //   110	121	182	finally
    //   173	177	182	finally
    //   130	161	193	finally
    //   130	161	197	java/lang/Exception
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anee
 * JD-Core Version:    0.7.0.1
 */