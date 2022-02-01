package com.tencent.biz.qcircleshadow.local.pluginparse;

import com.tencent.biz.qcircleshadow.local.QCircleSampleInfo;
import com.tencent.biz.qcircleshadow.remoteCheck.QCirclePluginInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class QCircleBasePluginParse
  implements Callable<QCircleSampleInfo>
{
  public static final String a;
  public static final String b = jdField_a_of_type_JavaLangString + "pluginAsset/";
  protected int a;
  protected QCircleUnZip a;
  protected QCirclePluginInfo a;
  protected String c;
  protected String d;
  protected String e;
  
  static
  {
    jdField_a_of_type_JavaLangString = QCircleConstants.QCIRCLE_INNER_ROOT_PATH + "qcirclePlugin/";
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
      QCircleSampleInfo localQCircleSampleInfo = new QCircleSampleInfo();
      if (paramString.has("version")) {
        localQCircleSampleInfo.b(paramString.getInt("version"));
      }
      if (paramString.has("supportMinHostVersion")) {
        localQCircleSampleInfo.a(paramString.getInt("supportMinHostVersion"));
      }
      return localQCircleSampleInfo;
    }
    catch (JSONException paramString)
    {
      QLog.d("QCIRCLE_PLUGIN", 1, "parse json failed" + paramString.getMessage());
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
    //   28: astore_1
    //   29: new 20	java/lang/StringBuilder
    //   32: dup
    //   33: ldc 130
    //   35: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   38: astore 4
    //   40: new 136	java/io/BufferedReader
    //   43: dup
    //   44: new 138	java/io/InputStreamReader
    //   47: dup
    //   48: new 140	java/io/FileInputStream
    //   51: dup
    //   52: aload_1
    //   53: invokespecial 143	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   56: invokespecial 146	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   59: invokespecial 149	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   62: astore_2
    //   63: aload_2
    //   64: astore_1
    //   65: aload_2
    //   66: invokevirtual 152	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   69: astore_3
    //   70: aload_3
    //   71: ifnull +65 -> 136
    //   74: aload_2
    //   75: astore_1
    //   76: aload 4
    //   78: aload_3
    //   79: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc 154
    //   84: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: goto -25 -> 63
    //   91: astore_3
    //   92: aload_2
    //   93: astore_1
    //   94: ldc 102
    //   96: iconst_1
    //   97: new 20	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   104: ldc 156
    //   106: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_3
    //   110: invokevirtual 157	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   113: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 112	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   122: aload_2
    //   123: ifnull +7 -> 130
    //   126: aload_2
    //   127: invokevirtual 160	java/io/BufferedReader:close	()V
    //   130: aload 4
    //   132: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: areturn
    //   136: aload_2
    //   137: ifnull -7 -> 130
    //   140: aload_2
    //   141: invokevirtual 160	java/io/BufferedReader:close	()V
    //   144: goto -14 -> 130
    //   147: astore_1
    //   148: aload_1
    //   149: invokevirtual 163	java/io/IOException:printStackTrace	()V
    //   152: goto -22 -> 130
    //   155: astore_1
    //   156: aload_1
    //   157: invokevirtual 163	java/io/IOException:printStackTrace	()V
    //   160: goto -30 -> 130
    //   163: astore_2
    //   164: aconst_null
    //   165: astore_1
    //   166: aload_1
    //   167: ifnull +7 -> 174
    //   170: aload_1
    //   171: invokevirtual 160	java/io/BufferedReader:close	()V
    //   174: aload_2
    //   175: athrow
    //   176: astore_1
    //   177: aload_1
    //   178: invokevirtual 163	java/io/IOException:printStackTrace	()V
    //   181: goto -7 -> 174
    //   184: astore_2
    //   185: goto -19 -> 166
    //   188: astore_3
    //   189: aconst_null
    //   190: astore_2
    //   191: goto -99 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	this	QCircleBasePluginParse
    //   0	194	1	paramString	String
    //   62	79	2	localBufferedReader	java.io.BufferedReader
    //   163	12	2	localObject1	Object
    //   184	1	2	localObject2	Object
    //   190	1	2	localObject3	Object
    //   69	10	3	str	String
    //   91	19	3	localException1	java.lang.Exception
    //   188	1	3	localException2	java.lang.Exception
    //   38	93	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   65	70	91	java/lang/Exception
    //   76	88	91	java/lang/Exception
    //   140	144	147	java/io/IOException
    //   126	130	155	java/io/IOException
    //   40	63	163	finally
    //   170	174	176	java/io/IOException
    //   65	70	184	finally
    //   76	88	184	finally
    //   94	122	184	finally
    //   40	63	188	java/lang/Exception
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
      QLog.d("QCIRCLE_PLUGIN", 1, paramString3 + "unZip file failed msg:" + paramString1.getMessage());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.pluginparse.QCircleBasePluginParse
 * JD-Core Version:    0.7.0.1
 */