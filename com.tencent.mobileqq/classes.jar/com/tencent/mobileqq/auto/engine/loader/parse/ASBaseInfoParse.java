package com.tencent.mobileqq.auto.engine.loader.parse;

import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine;
import com.tencent.mobileqq.auto.engine.loader.ASPluginBean;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class ASBaseInfoParse
  implements IPluginParse<ASPluginBean>
{
  protected String a;
  protected String b;
  protected String c;
  protected ASPluginBean d;
  protected int e;
  protected ASPluginInfoUnZip f;
  
  public ASBaseInfoParse(ASPluginBean paramASPluginBean)
  {
    this.d = paramASPluginBean;
    this.c = paramASPluginBean.getType();
    this.a = paramASPluginBean.getPluginZipPath();
    this.b = paramASPluginBean.getPluginMangerApkPath();
    this.e = paramASPluginBean.getVersionCode();
    this.f = new ASPluginInfoUnZip(paramASPluginBean);
  }
  
  private String b()
  {
    return ((IAppSettingApi)QRoute.api(IAppSettingApi.class)).getSubVersion();
  }
  
  public int a()
  {
    String[] arrayOfString = b().split("\\.");
    if ((arrayOfString != null) && (arrayOfString.length >= 3))
    {
      StringBuilder localStringBuilder = new StringBuilder(arrayOfString[0]);
      if (arrayOfString[1].length() == 1)
      {
        localStringBuilder.append("0");
        localStringBuilder.append(arrayOfString[1]);
      }
      else
      {
        localStringBuilder.append(arrayOfString[1]);
      }
      if (arrayOfString[2].length() == 1)
      {
        localStringBuilder.append("0");
        localStringBuilder.append(arrayOfString[2]);
      }
      else
      {
        localStringBuilder.append(arrayOfString[2]);
      }
      return Integer.parseInt(localStringBuilder.toString());
    }
    return 2147483647;
  }
  
  /* Error */
  protected String a(String paramString)
  {
    // Byte code:
    //   0: ldc 107
    //   2: invokestatic 63	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   5: checkcast 107	com/tencent/mobileqq/qqcommon/api/IFileUtilsApi
    //   8: aload_1
    //   9: invokeinterface 111 2 0
    //   14: ifne +6 -> 20
    //   17: ldc 113
    //   19: areturn
    //   20: new 115	java/io/File
    //   23: dup
    //   24: aload_1
    //   25: invokespecial 116	java/io/File:<init>	(Ljava/lang/String;)V
    //   28: astore_2
    //   29: aconst_null
    //   30: astore_3
    //   31: aconst_null
    //   32: astore_1
    //   33: new 78	java/lang/StringBuilder
    //   36: dup
    //   37: ldc 113
    //   39: invokespecial 81	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   42: astore 4
    //   44: new 118	java/io/BufferedReader
    //   47: dup
    //   48: new 120	java/io/InputStreamReader
    //   51: dup
    //   52: new 122	java/io/FileInputStream
    //   55: dup
    //   56: aload_2
    //   57: invokespecial 125	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   60: invokespecial 128	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   63: invokespecial 131	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   66: astore_2
    //   67: aload_2
    //   68: invokevirtual 134	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   71: astore_1
    //   72: aload_1
    //   73: ifnull +21 -> 94
    //   76: aload 4
    //   78: aload_1
    //   79: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload 4
    //   85: ldc 136
    //   87: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: goto -24 -> 67
    //   94: aload_2
    //   95: invokevirtual 139	java/io/BufferedReader:close	()V
    //   98: goto +102 -> 200
    //   101: astore_1
    //   102: aload_1
    //   103: invokevirtual 142	java/io/IOException:printStackTrace	()V
    //   106: goto +94 -> 200
    //   109: astore_1
    //   110: aload_2
    //   111: astore_3
    //   112: aload_1
    //   113: astore_2
    //   114: aload_3
    //   115: astore_1
    //   116: goto +90 -> 206
    //   119: astore_3
    //   120: goto +12 -> 132
    //   123: astore_2
    //   124: goto +82 -> 206
    //   127: astore_1
    //   128: aload_3
    //   129: astore_2
    //   130: aload_1
    //   131: astore_3
    //   132: aload_2
    //   133: astore_1
    //   134: aload_0
    //   135: getfield 24	com/tencent/mobileqq/auto/engine/loader/parse/ASBaseInfoParse:d	Lcom/tencent/mobileqq/auto/engine/loader/ASPluginBean;
    //   138: invokevirtual 145	com/tencent/mobileqq/auto/engine/loader/ASPluginBean:getBusinessKey	()Ljava/lang/String;
    //   141: invokestatic 149	com/tencent/mobileqq/auto/engine/loader/ASDynamicEngine:a	(Ljava/lang/String;)Ljava/lang/String;
    //   144: astore 5
    //   146: aload_2
    //   147: astore_1
    //   148: new 78	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   155: astore 6
    //   157: aload_2
    //   158: astore_1
    //   159: aload 6
    //   161: ldc 152
    //   163: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload_2
    //   168: astore_1
    //   169: aload 6
    //   171: aload_3
    //   172: invokevirtual 155	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   175: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload_2
    //   180: astore_1
    //   181: aload 5
    //   183: iconst_1
    //   184: aload 6
    //   186: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 160	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   192: aload_2
    //   193: ifnull +7 -> 200
    //   196: aload_2
    //   197: invokevirtual 139	java/io/BufferedReader:close	()V
    //   200: aload 4
    //   202: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: areturn
    //   206: aload_1
    //   207: ifnull +15 -> 222
    //   210: aload_1
    //   211: invokevirtual 139	java/io/BufferedReader:close	()V
    //   214: goto +8 -> 222
    //   217: astore_1
    //   218: aload_1
    //   219: invokevirtual 142	java/io/IOException:printStackTrace	()V
    //   222: goto +5 -> 227
    //   225: aload_2
    //   226: athrow
    //   227: goto -2 -> 225
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	230	0	this	ASBaseInfoParse
    //   0	230	1	paramString	String
    //   28	86	2	localObject1	Object
    //   123	1	2	localObject2	Object
    //   129	97	2	localObject3	Object
    //   30	85	3	localObject4	Object
    //   119	10	3	localException	java.lang.Exception
    //   131	41	3	str1	String
    //   42	159	4	localStringBuilder1	StringBuilder
    //   144	38	5	str2	String
    //   155	30	6	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   94	98	101	java/io/IOException
    //   196	200	101	java/io/IOException
    //   67	72	109	finally
    //   76	91	109	finally
    //   67	72	119	java/lang/Exception
    //   76	91	119	java/lang/Exception
    //   44	67	123	finally
    //   134	146	123	finally
    //   148	157	123	finally
    //   159	167	123	finally
    //   169	179	123	finally
    //   181	192	123	finally
    //   44	67	127	java/lang/Exception
    //   210	214	217	java/io/IOException
  }
  
  protected boolean a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      boolean bool = this.f.b(paramString1, new File(paramString2));
      return bool;
    }
    catch (IOException paramString1)
    {
      paramString2 = ASDynamicEngine.a(this.d.getBusinessKey());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString3);
      localStringBuilder.append("unZip file failed msg:");
      localStringBuilder.append(paramString1.getMessage());
      QLog.d(paramString2, 1, localStringBuilder.toString());
    }
    return false;
  }
  
  protected ASPluginBean b(String paramString)
  {
    try
    {
      localObject1 = new JSONObject(paramString);
      paramString = new ASPluginBean();
      if (((JSONObject)localObject1).has("version")) {
        paramString.setVersionCode(((JSONObject)localObject1).getInt("version"));
      }
      if (((JSONObject)localObject1).has("supportMinHostVersion")) {
        paramString.setSupportMinHostVersion(((JSONObject)localObject1).getInt("supportMinHostVersion"));
      }
      if (((JSONObject)localObject1).has("UUID"))
      {
        localObject1 = ((JSONObject)localObject1).getString("UUID");
        paramString.setUUid((String)localObject1);
        localObject2 = ASDynamicEngine.a(this.d.getBusinessKey());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("parse json hasUUId：");
        localStringBuilder.append((String)localObject1);
        QLog.d((String)localObject2, 1, localStringBuilder.toString());
      }
      return paramString;
    }
    catch (JSONException paramString)
    {
      Object localObject1 = ASDynamicEngine.a(this.d.getBusinessKey());
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("parse json failed");
      ((StringBuilder)localObject2).append(paramString.getMessage());
      QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.loader.parse.ASBaseInfoParse
 * JD-Core Version:    0.7.0.1
 */