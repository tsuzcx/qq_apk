package com.tencent.biz.pubaccount.readinjoy.webarticle;

import android.text.TextUtils;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Mustache.Compiler;
import com.samskivert.mustache.Template;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/webarticle/RIJWebTemplateFactory;", "", "()V", "TAG", "", "TPL_BASE_URL", "TPL_DIR", "TPL_NAME_INDEX", "fileMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "templateMap", "Lcom/samskivert/mustache/Template;", "createTemplate", "templateName", "getFileContent", "getFilePathFromTplName", "getTemplate", "loadFile", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJWebTemplateFactory
{
  public static final RIJWebTemplateFactory a;
  private static final HashMap<String, String> a;
  private static final HashMap<String, Template> b = new HashMap();
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyWebarticleRIJWebTemplateFactory = new RIJWebTemplateFactory();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  /* Error */
  private final void a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: checkcast 58	java/io/InputStream
    //   4: astore_2
    //   5: getstatic 64	com/tencent/common/app/BaseApplicationImpl:context	Lcom/tencent/qphone/base/util/BaseApplication;
    //   8: astore_3
    //   9: aload_3
    //   10: ifnull +101 -> 111
    //   13: aload_0
    //   14: aload_1
    //   15: invokespecial 67	com/tencent/biz/pubaccount/readinjoy/webarticle/RIJWebTemplateFactory:b	(Ljava/lang/String;)Ljava/lang/String;
    //   18: astore 4
    //   20: aload_3
    //   21: invokevirtual 73	com/tencent/qphone/base/util/BaseApplication:getAssets	()Landroid/content/res/AssetManager;
    //   24: aload 4
    //   26: invokevirtual 79	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   29: astore_3
    //   30: aload_3
    //   31: astore_2
    //   32: aload_3
    //   33: invokevirtual 83	java/io/InputStream:available	()I
    //   36: newarray byte
    //   38: astore 4
    //   40: aload_3
    //   41: astore_2
    //   42: aload_3
    //   43: aload 4
    //   45: invokevirtual 87	java/io/InputStream:read	([B)I
    //   48: pop
    //   49: aload_3
    //   50: astore_2
    //   51: getstatic 49	com/tencent/biz/pubaccount/readinjoy/webarticle/RIJWebTemplateFactory:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   54: checkcast 89	java/util/Map
    //   57: aload_1
    //   58: new 91	java/lang/String
    //   61: dup
    //   62: aload 4
    //   64: getstatic 97	kotlin/text/Charsets:UTF_8	Ljava/nio/charset/Charset;
    //   67: invokespecial 100	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
    //   70: invokeinterface 104 3 0
    //   75: pop
    //   76: aload_3
    //   77: astore_2
    //   78: ldc 106
    //   80: iconst_1
    //   81: new 108	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   88: ldc 111
    //   90: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_1
    //   94: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 125	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: aload_3
    //   104: ifnull +7 -> 111
    //   107: aload_3
    //   108: invokevirtual 128	java/io/InputStream:close	()V
    //   111: return
    //   112: astore_1
    //   113: ldc 106
    //   115: iconst_1
    //   116: new 108	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   123: ldc 130
    //   125: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload_1
    //   129: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 125	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: return
    //   139: astore_1
    //   140: aload_2
    //   141: astore_3
    //   142: aload_3
    //   143: astore_2
    //   144: ldc 106
    //   146: iconst_1
    //   147: new 108	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   154: ldc 130
    //   156: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_1
    //   160: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 125	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   169: aload_3
    //   170: ifnull -59 -> 111
    //   173: aload_3
    //   174: invokevirtual 128	java/io/InputStream:close	()V
    //   177: return
    //   178: astore_1
    //   179: ldc 106
    //   181: iconst_1
    //   182: new 108	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   189: ldc 130
    //   191: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload_1
    //   195: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 125	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   204: return
    //   205: astore_1
    //   206: aload_2
    //   207: ifnull +7 -> 214
    //   210: aload_2
    //   211: invokevirtual 128	java/io/InputStream:close	()V
    //   214: aload_1
    //   215: athrow
    //   216: astore_2
    //   217: ldc 106
    //   219: iconst_1
    //   220: new 108	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   227: ldc 130
    //   229: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: aload_2
    //   233: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   236: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokestatic 125	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   242: goto -28 -> 214
    //   245: astore_1
    //   246: goto -40 -> 206
    //   249: astore_1
    //   250: goto -108 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	RIJWebTemplateFactory
    //   0	253	1	paramString	String
    //   4	207	2	localObject1	Object
    //   216	17	2	localIOException	java.io.IOException
    //   8	166	3	localObject2	Object
    //   18	45	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   107	111	112	java/io/IOException
    //   13	30	139	java/io/IOException
    //   173	177	178	java/io/IOException
    //   13	30	205	finally
    //   210	214	216	java/io/IOException
    //   32	40	245	finally
    //   42	49	245	finally
    //   51	76	245	finally
    //   78	103	245	finally
    //   144	169	245	finally
    //   32	40	249	java/io/IOException
    //   42	49	249	java/io/IOException
    //   51	76	249	java/io/IOException
    //   78	103	249	java/io/IOException
  }
  
  private final Template b(String paramString)
  {
    try
    {
      Object localObject = a(paramString);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = Mustache.compiler().escapeHTML(false).defaultValue("").compile((String)localObject);
        Map localMap = (Map)b;
        Intrinsics.checkExpressionValueIsNotNull(localObject, "template");
        localMap.put(paramString, localObject);
        return localObject;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("RIJWebTemplateFactory", 1, "[createTemplate] t = " + paramString);
    }
    return null;
  }
  
  private final String b(String paramString)
  {
    return "rij_web/" + paramString + ".tpl";
  }
  
  @Nullable
  public final Template a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "templateName");
    Template localTemplate2 = (Template)b.get(paramString);
    Template localTemplate1 = localTemplate2;
    if (localTemplate2 == null) {
      localTemplate1 = b(paramString);
    }
    if (localTemplate1 == null) {
      QLog.e("RIJWebTemplateFactory", 1, "[getTemplate] template is null, templateName = " + paramString);
    }
    return localTemplate1;
  }
  
  @Nullable
  public final String a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "templateName");
    if (TextUtils.isEmpty((CharSequence)jdField_a_of_type_JavaUtilHashMap.get(paramString))) {
      a(paramString);
    }
    for (;;)
    {
      return (String)jdField_a_of_type_JavaUtilHashMap.get(paramString);
      QLog.i("RIJWebTemplateFactory", 1, "[getFileContent] hit cache, filePath = " + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.webarticle.RIJWebTemplateFactory
 * JD-Core Version:    0.7.0.1
 */