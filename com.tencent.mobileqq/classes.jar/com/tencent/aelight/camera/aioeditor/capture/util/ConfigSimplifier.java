package com.tencent.aelight.camera.aioeditor.capture.util;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ConfigSimplifier
{
  public ConfigSimplifier.ZipConfig a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.w("ConfigSimplifier_PTV", 2, "parseFilterConfigZip TextUtils.isEmpty(config) return");
      }
      return null;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        boolean bool = localJSONObject.has("pendantMD5");
        String str2 = "";
        if (bool)
        {
          paramString = localJSONObject.getString("pendantMD5");
          if (!localJSONObject.has("pendantUrl")) {
            break label158;
          }
          str1 = localJSONObject.getString("pendantUrl");
          if (localJSONObject.has("pendantName")) {
            str2 = localJSONObject.getString("pendantName");
          }
          if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(str1))) {
            return new ConfigSimplifier.ZipConfig(str2, str1, paramString);
          }
          if (QLog.isColorLevel()) {
            QLog.w("ConfigSimplifier_PTV", 2, "zipMd5 or zipUrl empty return!");
          }
          return null;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      paramString = "";
      continue;
      label158:
      String str1 = "";
    }
  }
  
  /* Error */
  public ConfigSimplifier.ZipConfig a(String paramString1, String paramString2, String paramString3, ConfigSimplifier.ConfigDownloadCallback paramConfigDownloadCallback)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 67	com/tencent/aelight/camera/aioeditor/capture/util/ConfigSimplifier:a	(Ljava/lang/String;)Lcom/tencent/aelight/camera/aioeditor/capture/util/ConfigSimplifier$ZipConfig;
    //   5: astore_1
    //   6: aload_1
    //   7: ifnonnull +5 -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: invokestatic 25	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +77 -> 92
    //   18: new 69	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   25: astore 6
    //   27: aload 6
    //   29: ldc 72
    //   31: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload 6
    //   37: aload_1
    //   38: getfield 80	com/tencent/aelight/camera/aioeditor/capture/util/ConfigSimplifier$ZipConfig:c	Ljava/lang/String;
    //   41: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload 6
    //   47: ldc 82
    //   49: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload 6
    //   55: aload_1
    //   56: getfield 85	com/tencent/aelight/camera/aioeditor/capture/util/ConfigSimplifier$ZipConfig:b	Ljava/lang/String;
    //   59: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 6
    //   65: ldc 87
    //   67: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 6
    //   73: aload_1
    //   74: getfield 89	com/tencent/aelight/camera/aioeditor/capture/util/ConfigSimplifier$ZipConfig:a	Ljava/lang/String;
    //   77: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: ldc 27
    //   83: iconst_2
    //   84: aload 6
    //   86: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   92: new 69	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   99: astore 6
    //   101: aload 6
    //   103: aload_2
    //   104: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload 6
    //   110: getstatic 101	java/io/File:separator	Ljava/lang/String;
    //   113: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload 6
    //   119: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: astore 6
    //   124: new 69	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   131: astore 7
    //   133: aload 7
    //   135: aload_2
    //   136: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload 7
    //   142: getstatic 101	java/io/File:separator	Ljava/lang/String;
    //   145: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload 7
    //   151: aload_1
    //   152: getfield 89	com/tencent/aelight/camera/aioeditor/capture/util/ConfigSimplifier$ZipConfig:a	Ljava/lang/String;
    //   155: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload 7
    //   161: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: astore 7
    //   166: new 98	java/io/File
    //   169: dup
    //   170: aload_2
    //   171: aload_3
    //   172: invokespecial 104	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   175: astore 8
    //   177: aload 8
    //   179: invokevirtual 107	java/io/File:exists	()Z
    //   182: ifeq +23 -> 205
    //   185: aload 8
    //   187: invokevirtual 110	java/io/File:delete	()Z
    //   190: pop
    //   191: invokestatic 25	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   194: ifeq +11 -> 205
    //   197: ldc 27
    //   199: iconst_2
    //   200: ldc 112
    //   202: invokestatic 33	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: new 98	java/io/File
    //   208: dup
    //   209: aload 7
    //   211: invokespecial 113	java/io/File:<init>	(Ljava/lang/String;)V
    //   214: astore 9
    //   216: aload 9
    //   218: invokevirtual 107	java/io/File:exists	()Z
    //   221: ifeq +23 -> 244
    //   224: aload 9
    //   226: invokevirtual 110	java/io/File:delete	()Z
    //   229: pop
    //   230: invokestatic 25	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   233: ifeq +11 -> 244
    //   236: ldc 27
    //   238: iconst_2
    //   239: ldc 115
    //   241: invokestatic 33	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   244: new 117	com/tencent/mobileqq/transfile/HttpNetReq
    //   247: dup
    //   248: invokespecial 118	com/tencent/mobileqq/transfile/HttpNetReq:<init>	()V
    //   251: astore 9
    //   253: aload 9
    //   255: new 120	com/tencent/aelight/camera/aioeditor/capture/util/ConfigSimplifier$1
    //   258: dup
    //   259: aload_0
    //   260: aload_2
    //   261: aload_3
    //   262: aload_1
    //   263: aload 6
    //   265: aload 7
    //   267: aload 4
    //   269: invokespecial 123	com/tencent/aelight/camera/aioeditor/capture/util/ConfigSimplifier$1:<init>	(Lcom/tencent/aelight/camera/aioeditor/capture/util/ConfigSimplifier;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/aelight/camera/aioeditor/capture/util/ConfigSimplifier$ZipConfig;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/aelight/camera/aioeditor/capture/util/ConfigSimplifier$ConfigDownloadCallback;)V
    //   272: putfield 127	com/tencent/mobileqq/transfile/HttpNetReq:mCallback	Lcom/tencent/mobileqq/transfile/INetEngineListener;
    //   275: aload 9
    //   277: aload_1
    //   278: getfield 85	com/tencent/aelight/camera/aioeditor/capture/util/ConfigSimplifier$ZipConfig:b	Ljava/lang/String;
    //   281: putfield 130	com/tencent/mobileqq/transfile/HttpNetReq:mReqUrl	Ljava/lang/String;
    //   284: aload 9
    //   286: iconst_0
    //   287: putfield 134	com/tencent/mobileqq/transfile/HttpNetReq:mHttpMethod	I
    //   290: aload 9
    //   292: aload 8
    //   294: invokevirtual 137	java/io/File:getPath	()Ljava/lang/String;
    //   297: putfield 140	com/tencent/mobileqq/transfile/HttpNetReq:mOutPath	Ljava/lang/String;
    //   300: aload 9
    //   302: invokestatic 146	com/tencent/mobileqq/transfile/NetworkCenter:getInstance	()Lcom/tencent/mobileqq/transfile/NetworkCenter;
    //   305: invokevirtual 150	com/tencent/mobileqq/transfile/NetworkCenter:getNetType	()I
    //   308: invokestatic 156	com/tencent/mobileqq/utils/NetworkUtil:getConnRetryTimes	(I)I
    //   311: putfield 159	com/tencent/mobileqq/transfile/HttpNetReq:mContinuErrorLimit	I
    //   314: invokestatic 165	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   317: invokevirtual 169	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   320: astore_2
    //   321: ldc 171
    //   323: aload_2
    //   324: invokevirtual 177	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   327: istore 5
    //   329: iload 5
    //   331: ifeq +66 -> 397
    //   334: aload_2
    //   335: checkcast 171	com/tencent/mobileqq/app/QQAppInterface
    //   338: ldc 179
    //   340: ldc 181
    //   342: invokevirtual 185	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   345: checkcast 179	com/tencent/mobileqq/transfile/api/IHttpEngineService
    //   348: aload 9
    //   350: invokeinterface 189 2 0
    //   355: invokestatic 25	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   358: ifeq +78 -> 436
    //   361: new 69	java/lang/StringBuilder
    //   364: dup
    //   365: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   368: astore_2
    //   369: aload_2
    //   370: ldc 191
    //   372: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload_2
    //   377: aload_1
    //   378: getfield 85	com/tencent/aelight/camera/aioeditor/capture/util/ConfigSimplifier$ZipConfig:b	Ljava/lang/String;
    //   381: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: ldc 193
    //   387: iconst_2
    //   388: aload_2
    //   389: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokestatic 196	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   395: aload_1
    //   396: areturn
    //   397: invokestatic 201	com/tencent/aelight/camera/aioeditor/capture/CaptureContext:a	()Lcom/tencent/common/app/AppInterface;
    //   400: ifnull +36 -> 436
    //   403: invokestatic 201	com/tencent/aelight/camera/aioeditor/capture/CaptureContext:a	()Lcom/tencent/common/app/AppInterface;
    //   406: ldc 179
    //   408: ldc 181
    //   410: invokevirtual 204	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   413: checkcast 179	com/tencent/mobileqq/transfile/api/IHttpEngineService
    //   416: aload 9
    //   418: invokeinterface 189 2 0
    //   423: aload_1
    //   424: areturn
    //   425: astore_2
    //   426: invokestatic 25	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   429: ifeq +7 -> 436
    //   432: aload_2
    //   433: invokevirtual 64	java/lang/Exception:printStackTrace	()V
    //   436: aload_1
    //   437: areturn
    //   438: astore_2
    //   439: aload_1
    //   440: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	441	0	this	ConfigSimplifier
    //   0	441	1	paramString1	String
    //   0	441	2	paramString2	String
    //   0	441	3	paramString3	String
    //   0	441	4	paramConfigDownloadCallback	ConfigSimplifier.ConfigDownloadCallback
    //   327	3	5	bool	boolean
    //   25	239	6	localObject1	Object
    //   131	135	7	localObject2	Object
    //   175	118	8	localFile	java.io.File
    //   214	203	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   92	205	425	java/lang/Exception
    //   205	244	425	java/lang/Exception
    //   244	314	425	java/lang/Exception
    //   314	329	438	java/lang/Exception
    //   334	395	438	java/lang/Exception
    //   397	423	438	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.util.ConfigSimplifier
 * JD-Core Version:    0.7.0.1
 */