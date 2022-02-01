package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util;

import pra;

public final class RIJJumpUtils$3
  implements Runnable
{
  public RIJJumpUtils$3(String paramString1, String paramString2, String paramString3, String paramString4, pra parampra) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: iconst_1
    //   7: istore_3
    //   8: aload 7
    //   10: astore 5
    //   12: new 33	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   19: ldc 36
    //   21: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: getfield 16	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/util/RIJJumpUtils$3:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   28: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc 42
    //   33: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_0
    //   37: getfield 18	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/util/RIJJumpUtils$3:b	Ljava/lang/String;
    //   40: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: ldc 44
    //   45: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_0
    //   49: getfield 20	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/util/RIJJumpUtils$3:c	Ljava/lang/String;
    //   52: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc 46
    //   57: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: aload_0
    //   61: getfield 22	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/util/RIJJumpUtils$3:d	Ljava/lang/String;
    //   64: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: astore 4
    //   72: aload 7
    //   74: astore 5
    //   76: new 52	java/lang/String
    //   79: dup
    //   80: invokestatic 58	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   83: aload 4
    //   85: ldc 60
    //   87: aconst_null
    //   88: aconst_null
    //   89: invokestatic 66	com/tencent/biz/common/util/HttpUtil:openUrlForByte	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)[B
    //   92: invokespecial 69	java/lang/String:<init>	([B)V
    //   95: astore 8
    //   97: aload 6
    //   99: astore 4
    //   101: aload 7
    //   103: astore 5
    //   105: aload 8
    //   107: invokestatic 75	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   110: ifne +53 -> 163
    //   113: aload 6
    //   115: astore 4
    //   117: aload 7
    //   119: astore 5
    //   121: aload 8
    //   123: ldc 77
    //   125: invokevirtual 80	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   128: ifeq +35 -> 163
    //   131: aload 7
    //   133: astore 5
    //   135: aload 8
    //   137: aload 8
    //   139: ldc 82
    //   141: invokevirtual 86	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   144: invokevirtual 90	java/lang/String:substring	(I)Ljava/lang/String;
    //   147: ldc 92
    //   149: invokevirtual 96	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   152: iconst_0
    //   153: aaload
    //   154: ldc 98
    //   156: invokevirtual 96	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   159: iconst_2
    //   160: aaload
    //   161: astore 4
    //   163: aload 4
    //   165: astore 5
    //   167: new 100	org/json/JSONObject
    //   170: dup
    //   171: aload 8
    //   173: ldc 102
    //   175: invokevirtual 96	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   178: iconst_1
    //   179: aaload
    //   180: invokespecial 105	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   183: ldc 107
    //   185: invokevirtual 111	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   188: astore 6
    //   190: aload 4
    //   192: astore 5
    //   194: aload 6
    //   196: invokevirtual 117	org/json/JSONArray:length	()I
    //   199: ifle +128 -> 327
    //   202: aload 4
    //   204: astore 5
    //   206: aload 6
    //   208: iconst_0
    //   209: invokevirtual 121	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   212: ldc 123
    //   214: invokevirtual 126	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   217: ldc 128
    //   219: invokevirtual 111	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   222: astore 6
    //   224: aload 4
    //   226: astore 5
    //   228: aload 6
    //   230: invokevirtual 117	org/json/JSONArray:length	()I
    //   233: iconst_2
    //   234: if_icmplt +93 -> 327
    //   237: aload 4
    //   239: astore 5
    //   241: aload 6
    //   243: iconst_0
    //   244: invokevirtual 132	org/json/JSONArray:getInt	(I)I
    //   247: istore_1
    //   248: aload 6
    //   250: iconst_1
    //   251: invokevirtual 132	org/json/JSONArray:getInt	(I)I
    //   254: istore_2
    //   255: new 134	java/net/URL
    //   258: dup
    //   259: aload 4
    //   261: invokespecial 135	java/net/URL:<init>	(Ljava/lang/String;)V
    //   264: pop
    //   265: aload_0
    //   266: getfield 24	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/util/RIJJumpUtils$3:jdField_a_of_type_Pra	Lpra;
    //   269: ifnull +21 -> 290
    //   272: aload_0
    //   273: getfield 24	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/util/RIJJumpUtils$3:jdField_a_of_type_Pra	Lpra;
    //   276: iload_3
    //   277: aload_0
    //   278: getfield 22	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/util/RIJJumpUtils$3:d	Ljava/lang/String;
    //   281: aload 4
    //   283: iload_1
    //   284: iload_2
    //   285: invokeinterface 140 6 0
    //   290: return
    //   291: astore 6
    //   293: iconst_0
    //   294: istore_2
    //   295: iconst_0
    //   296: istore_1
    //   297: aload 5
    //   299: astore 4
    //   301: aload 6
    //   303: astore 5
    //   305: aload 5
    //   307: invokevirtual 143	java/lang/Exception:printStackTrace	()V
    //   310: iconst_0
    //   311: istore_3
    //   312: goto -47 -> 265
    //   315: astore 5
    //   317: iconst_0
    //   318: istore_2
    //   319: goto -14 -> 305
    //   322: astore 5
    //   324: goto -19 -> 305
    //   327: iconst_0
    //   328: istore_2
    //   329: iconst_0
    //   330: istore_1
    //   331: goto -76 -> 255
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	this	3
    //   247	84	1	i	int
    //   254	75	2	j	int
    //   7	305	3	bool	boolean
    //   70	230	4	localObject1	Object
    //   10	296	5	localObject2	Object
    //   315	1	5	localException1	java.lang.Exception
    //   322	1	5	localException2	java.lang.Exception
    //   4	245	6	localJSONArray	org.json.JSONArray
    //   291	11	6	localException3	java.lang.Exception
    //   1	131	7	localObject3	Object
    //   95	77	8	str	String
    // Exception table:
    //   from	to	target	type
    //   12	72	291	java/lang/Exception
    //   76	97	291	java/lang/Exception
    //   105	113	291	java/lang/Exception
    //   121	131	291	java/lang/Exception
    //   135	163	291	java/lang/Exception
    //   167	190	291	java/lang/Exception
    //   194	202	291	java/lang/Exception
    //   206	224	291	java/lang/Exception
    //   228	237	291	java/lang/Exception
    //   241	248	291	java/lang/Exception
    //   248	255	315	java/lang/Exception
    //   255	265	322	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils.3
 * JD-Core Version:    0.7.0.1
 */