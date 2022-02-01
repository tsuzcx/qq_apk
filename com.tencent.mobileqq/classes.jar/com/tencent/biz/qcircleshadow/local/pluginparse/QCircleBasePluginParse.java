package com.tencent.biz.qcircleshadow.local.pluginparse;

import com.tencent.biz.qcircleshadow.local.QCircleSampleInfo;
import com.tencent.biz.qcircleshadow.remoteCheck.QCirclePluginInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public abstract class QCircleBasePluginParse
  implements Callable<QCircleSampleInfo>
{
  public static final String a;
  public static final String b;
  protected int a;
  protected QCircleUnZip a;
  protected QCirclePluginInfo a;
  protected String c;
  protected String d;
  protected String e;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QCircleConstants.QCIRCLE_INNER_ROOT_PATH);
    localStringBuilder.append("qcirclePlugin/");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append("pluginAsset/");
    b = localStringBuilder.toString();
  }
  
  public QCircleBasePluginParse(String paramString, QCirclePluginInfo paramQCirclePluginInfo)
  {
    this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo = paramQCirclePluginInfo;
    this.e = paramString;
    this.c = paramQCirclePluginInfo.pluginZipPath;
    this.d = paramQCirclePluginInfo.pluginManagerPath;
    this.jdField_a_of_type_Int = paramQCirclePluginInfo.version;
    this.jdField_a_of_type_ComTencentBizQcircleshadowLocalPluginparseQCircleUnZip = new QCircleUnZip();
  }
  
  protected QCircleSampleInfo a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      localObject = new QCircleSampleInfo();
      if (paramString.has("version")) {
        ((QCircleSampleInfo)localObject).b(paramString.getInt("version"));
      }
      if (paramString.has("supportMinHostVersion")) {
        ((QCircleSampleInfo)localObject).a(paramString.getInt("supportMinHostVersion"));
      }
      return localObject;
    }
    catch (JSONException paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parse json failed");
      ((StringBuilder)localObject).append(paramString.getMessage());
      QLog.d("QCIRCLE_PLUGIN", 1, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  /* Error */
  protected String a(String paramString)
  {
    // Byte code:
    //   0: ldc 119
    //   2: invokestatic 125	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   5: checkcast 119	com/tencent/mobileqq/qqcommon/api/IFileUtilsApi
    //   8: aload_1
    //   9: invokeinterface 128 2 0
    //   14: ifne +6 -> 20
    //   17: ldc 130
    //   19: areturn
    //   20: new 132	java/io/File
    //   23: dup
    //   24: aload_1
    //   25: invokespecial 133	java/io/File:<init>	(Ljava/lang/String;)V
    //   28: astore_2
    //   29: aconst_null
    //   30: astore_3
    //   31: aconst_null
    //   32: astore_1
    //   33: new 20	java/lang/StringBuilder
    //   36: dup
    //   37: ldc 130
    //   39: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   42: astore 4
    //   44: new 136	java/io/BufferedReader
    //   47: dup
    //   48: new 138	java/io/InputStreamReader
    //   51: dup
    //   52: new 140	java/io/FileInputStream
    //   55: dup
    //   56: aload_2
    //   57: invokespecial 143	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   60: invokespecial 146	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   63: invokespecial 149	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   66: astore_2
    //   67: aload_2
    //   68: invokevirtual 152	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   71: astore_1
    //   72: aload_1
    //   73: ifnull +21 -> 94
    //   76: aload 4
    //   78: aload_1
    //   79: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload 4
    //   85: ldc 154
    //   87: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: goto -24 -> 67
    //   94: aload_2
    //   95: invokevirtual 157	java/io/BufferedReader:close	()V
    //   98: goto +88 -> 186
    //   101: astore_1
    //   102: aload_1
    //   103: invokevirtual 160	java/io/IOException:printStackTrace	()V
    //   106: goto +80 -> 186
    //   109: astore_1
    //   110: aload_2
    //   111: astore_3
    //   112: aload_1
    //   113: astore_2
    //   114: aload_3
    //   115: astore_1
    //   116: goto +76 -> 192
    //   119: astore_3
    //   120: goto +12 -> 132
    //   123: astore_2
    //   124: goto +68 -> 192
    //   127: astore_1
    //   128: aload_3
    //   129: astore_2
    //   130: aload_1
    //   131: astore_3
    //   132: aload_2
    //   133: astore_1
    //   134: new 20	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   141: astore 5
    //   143: aload_2
    //   144: astore_1
    //   145: aload 5
    //   147: ldc 162
    //   149: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload_2
    //   154: astore_1
    //   155: aload 5
    //   157: aload_3
    //   158: invokevirtual 163	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   161: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload_2
    //   166: astore_1
    //   167: ldc 107
    //   169: iconst_1
    //   170: aload 5
    //   172: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokestatic 112	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   178: aload_2
    //   179: ifnull +7 -> 186
    //   182: aload_2
    //   183: invokevirtual 157	java/io/BufferedReader:close	()V
    //   186: aload 4
    //   188: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: areturn
    //   192: aload_1
    //   193: ifnull +15 -> 208
    //   196: aload_1
    //   197: invokevirtual 157	java/io/BufferedReader:close	()V
    //   200: goto +8 -> 208
    //   203: astore_1
    //   204: aload_1
    //   205: invokevirtual 160	java/io/IOException:printStackTrace	()V
    //   208: goto +5 -> 213
    //   211: aload_2
    //   212: athrow
    //   213: goto -2 -> 211
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	this	QCircleBasePluginParse
    //   0	216	1	paramString	String
    //   28	86	2	localObject1	Object
    //   123	1	2	localObject2	Object
    //   129	83	2	localObject3	Object
    //   30	85	3	localObject4	Object
    //   119	10	3	localException	java.lang.Exception
    //   131	27	3	str	String
    //   42	145	4	localStringBuilder1	StringBuilder
    //   141	30	5	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   94	98	101	java/io/IOException
    //   182	186	101	java/io/IOException
    //   67	72	109	finally
    //   76	91	109	finally
    //   67	72	119	java/lang/Exception
    //   76	91	119	java/lang/Exception
    //   44	67	123	finally
    //   134	143	123	finally
    //   145	153	123	finally
    //   155	165	123	finally
    //   167	178	123	finally
    //   44	67	127	java/lang/Exception
    //   196	200	203	java/io/IOException
  }
  
  protected HashMap<String, String> a(InputStream paramInputStream)
  {
    long l = System.currentTimeMillis();
    Object localObject1 = XmlPullParserFactory.newInstance();
    ((XmlPullParserFactory)localObject1).setNamespaceAware(true);
    localObject1 = ((XmlPullParserFactory)localObject1).newPullParser();
    ((XmlPullParser)localObject1).setInput(paramInputStream, "UTF-8");
    int i = ((XmlPullParser)localObject1).getEventType();
    paramInputStream = new HashMap();
    while (i != 1)
    {
      if (i == 2)
      {
        String str = ((XmlPullParser)localObject1).getName();
        Object localObject2;
        if ("qcirclePlugin".equals(str))
        {
          str = ((XmlPullParser)localObject1).nextText();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("parseInfoXml# specialKey:qcirclePlugin value:");
          ((StringBuilder)localObject2).append(str);
          QLog.i("QCIRCLE_PLUGIN", 1, ((StringBuilder)localObject2).toString());
          paramInputStream.put("qcircle-plugin", str);
        }
        else if ("qcirclePluginManager".equals(str))
        {
          str = ((XmlPullParser)localObject1).nextText();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("parseInfoXml# specialKey:qcirclePluginManager value:");
          ((StringBuilder)localObject2).append(str);
          QLog.i("QCIRCLE_PLUGIN", 1, ((StringBuilder)localObject2).toString());
          paramInputStream.put("qcircle-pluginmanager", str);
        }
        else if (!"pluginInfo".equals(str))
        {
          localObject2 = ((XmlPullParser)localObject1).nextText();
          paramInputStream.put(str, localObject2);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("parseInfoXml# key:");
          localStringBuilder.append(str);
          localStringBuilder.append(" value:");
          localStringBuilder.append((String)localObject2);
          QLog.i("QCIRCLE_PLUGIN", 1, localStringBuilder.toString());
        }
      }
      i = ((XmlPullParser)localObject1).next();
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("parseInfoXml cost:");
    ((StringBuilder)localObject1).append(System.currentTimeMillis() - l);
    QLog.i("QCIRCLE_PLUGIN", 1, ((StringBuilder)localObject1).toString());
    if ((paramInputStream.containsKey("qcircle-plugin")) && (paramInputStream.containsKey("qcircle-pluginmanager")))
    {
      QLog.i("QCIRCLE_PLUGIN", 1, "parseInfoXml get info success");
      return paramInputStream;
    }
    return null;
  }
  
  protected void a(InputStream paramInputStream)
  {
    if (paramInputStream != null) {
      try
      {
        paramInputStream.close();
        return;
      }
      catch (IOException paramInputStream)
      {
        paramInputStream.printStackTrace();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("closeInputStream#exception:");
        localStringBuilder.append(paramInputStream.toString());
        QLog.e("QCIRCLE_PLUGIN", 1, localStringBuilder.toString());
      }
    }
  }
  
  protected boolean a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_ComTencentBizQcircleshadowLocalPluginparseQCircleUnZip.a(paramString1, new File(paramString2), paramString3);
      return bool;
    }
    catch (IOException paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString3);
      paramString2.append("unZip file failed msg:");
      paramString2.append(paramString1.getMessage());
      QLog.d("QCIRCLE_PLUGIN", 1, paramString2.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.pluginparse.QCircleBasePluginParse
 * JD-Core Version:    0.7.0.1
 */