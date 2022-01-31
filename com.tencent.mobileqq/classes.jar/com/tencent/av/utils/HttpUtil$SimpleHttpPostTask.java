package com.tencent.av.utils;

import android.os.AsyncTask;

public class HttpUtil$SimpleHttpPostTask
  extends AsyncTask
{
  String a;
  String b;
  String c;
  
  public HttpUtil$SimpleHttpPostTask(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  /* Error */
  protected String a(java.lang.Void... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 15	com/tencent/av/utils/HttpUtil$SimpleHttpPostTask:a	Ljava/lang/String;
    //   4: aload_0
    //   5: getfield 17	com/tencent/av/utils/HttpUtil$SimpleHttpPostTask:b	Ljava/lang/String;
    //   8: aload_0
    //   9: getfield 19	com/tencent/av/utils/HttpUtil$SimpleHttpPostTask:c	Ljava/lang/String;
    //   12: invokestatic 30	com/tencent/av/utils/HttpUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   15: astore_1
    //   16: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +28 -> 47
    //   22: ldc 38
    //   24: iconst_2
    //   25: new 40	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   32: ldc 43
    //   34: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_1
    //   38: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 55	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   47: aload_1
    //   48: areturn
    //   49: astore_2
    //   50: aconst_null
    //   51: astore_1
    //   52: aload_2
    //   53: invokevirtual 58	org/apache/http/client/ClientProtocolException:printStackTrace	()V
    //   56: aload_1
    //   57: areturn
    //   58: astore_2
    //   59: aconst_null
    //   60: astore_1
    //   61: aload_2
    //   62: invokevirtual 59	java/lang/Exception:printStackTrace	()V
    //   65: aload_1
    //   66: areturn
    //   67: astore_2
    //   68: goto -7 -> 61
    //   71: astore_2
    //   72: goto -20 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	SimpleHttpPostTask
    //   0	75	1	paramVarArgs	java.lang.Void[]
    //   49	4	2	localClientProtocolException1	org.apache.http.client.ClientProtocolException
    //   58	4	2	localException1	java.lang.Exception
    //   67	1	2	localException2	java.lang.Exception
    //   71	1	2	localClientProtocolException2	org.apache.http.client.ClientProtocolException
    // Exception table:
    //   from	to	target	type
    //   0	16	49	org/apache/http/client/ClientProtocolException
    //   0	16	58	java/lang/Exception
    //   16	47	67	java/lang/Exception
    //   16	47	71	org/apache/http/client/ClientProtocolException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.utils.HttpUtil.SimpleHttpPostTask
 * JD-Core Version:    0.7.0.1
 */