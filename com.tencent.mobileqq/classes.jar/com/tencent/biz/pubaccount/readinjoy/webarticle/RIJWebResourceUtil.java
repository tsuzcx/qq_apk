package com.tencent.biz.pubaccount.readinjoy.webarticle;

import android.text.TextUtils;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/webarticle/RIJWebResourceUtil;", "", "()V", "ARTICLE_CSS_URL", "", "ARTICLE_NEW_CSS_URL", "BEACON_WEB_SCRIPT_URL", "CSS_EXT", "DEFAULT_ARTICLE_CSS", "DEFAULT_ARTICLE_NEW_CSS", "DEFAULT_BEACON_WEB_SCRIPT", "JS_EXT", "RES_BID", "TAG", "fileMap", "Ljava/util/concurrent/ConcurrentHashMap;", "resourceUrlList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getFileContent", "filePath", "getResDir", "getWebResourceContent", "url", "getWebResourceResponse", "Lcom/tencent/smtt/export/external/interfaces/WebResourceResponse;", "isResourceUrlIntercept", "", "loadFile", "", "preloadResource", "forceLoad", "updateResourceOfflinePkg", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJWebResourceUtil
{
  public static final RIJWebResourceUtil a;
  private static final ArrayList<String> jdField_a_of_type_JavaUtilArrayList = CollectionsKt.arrayListOf(new String[] { "https://tkd-fe.cdn-go.cn/KdDetailPage/latest/themes/default/client/article/article.css", "https://watchspot.cdn-go.cn/article-new/latest/css/article_new.css", "https://beaconcdn.qq.com/sdk/3.1.50/beacon_web.min.js", "https://watchspot.cdn-go.cn/article-new/latest/css/article_related_card_new.css", "https://watchspot.cdn-go.cn/article-new/latest/css/article_recommend_new.css" });
  private static final ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyWebarticleRIJWebResourceUtil = new RIJWebResourceUtil();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  private final String a()
  {
    return OfflineEnvHelper.a("3948") + "3948";
  }
  
  /* Error */
  private final void a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: checkcast 118	java/lang/CharSequence
    //   4: invokestatic 124	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +12 -> 19
    //   10: ldc 126
    //   12: iconst_1
    //   13: ldc 128
    //   15: invokestatic 134	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: return
    //   19: aconst_null
    //   20: checkcast 136	java/io/InputStream
    //   23: astore 5
    //   25: new 138	java/io/File
    //   28: dup
    //   29: aload_1
    //   30: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: astore 6
    //   35: aload 5
    //   37: astore_2
    //   38: aload 5
    //   40: astore_3
    //   41: aload 5
    //   43: astore 4
    //   45: aload 6
    //   47: invokevirtual 144	java/io/File:exists	()Z
    //   50: ifne +39 -> 89
    //   53: aload 5
    //   55: astore_2
    //   56: aload 5
    //   58: astore_3
    //   59: aload 5
    //   61: astore 4
    //   63: ldc 126
    //   65: iconst_1
    //   66: new 85	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   73: ldc 146
    //   75: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_1
    //   79: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokestatic 134	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   88: return
    //   89: aload 5
    //   91: astore_2
    //   92: aload 5
    //   94: astore_3
    //   95: aload 5
    //   97: astore 4
    //   99: new 148	java/io/FileInputStream
    //   102: dup
    //   103: aload 6
    //   105: invokespecial 151	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   108: checkcast 136	java/io/InputStream
    //   111: astore 5
    //   113: aload 5
    //   115: astore_2
    //   116: aload 5
    //   118: astore_3
    //   119: aload 5
    //   121: astore 4
    //   123: aload 5
    //   125: invokevirtual 155	java/io/InputStream:available	()I
    //   128: newarray byte
    //   130: astore 6
    //   132: aload 5
    //   134: astore_2
    //   135: aload 5
    //   137: astore_3
    //   138: aload 5
    //   140: astore 4
    //   142: aload 5
    //   144: aload 6
    //   146: invokevirtual 159	java/io/InputStream:read	([B)I
    //   149: pop
    //   150: aload 5
    //   152: astore_2
    //   153: aload 5
    //   155: astore_3
    //   156: aload 5
    //   158: astore 4
    //   160: getstatic 60	com/tencent/biz/pubaccount/readinjoy/webarticle/RIJWebResourceUtil:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   163: checkcast 161	java/util/Map
    //   166: aload_1
    //   167: new 62	java/lang/String
    //   170: dup
    //   171: aload 6
    //   173: getstatic 167	kotlin/text/Charsets:UTF_8	Ljava/nio/charset/Charset;
    //   176: invokespecial 170	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
    //   179: invokeinterface 174 3 0
    //   184: pop
    //   185: aload 5
    //   187: astore_2
    //   188: aload 5
    //   190: astore_3
    //   191: aload 5
    //   193: astore 4
    //   195: ldc 126
    //   197: iconst_1
    //   198: new 85	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   205: ldc 176
    //   207: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload_1
    //   211: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 134	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: aload 5
    //   222: invokevirtual 179	java/io/InputStream:close	()V
    //   225: return
    //   226: astore_1
    //   227: ldc 126
    //   229: iconst_1
    //   230: new 85	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   237: ldc 181
    //   239: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload_1
    //   243: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   246: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokestatic 134	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   252: return
    //   253: astore_3
    //   254: aload_2
    //   255: astore_1
    //   256: ldc 126
    //   258: iconst_1
    //   259: new 85	java/lang/StringBuilder
    //   262: dup
    //   263: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   266: ldc 181
    //   268: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: aload_3
    //   272: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokestatic 134	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   281: aload_2
    //   282: ifnull -264 -> 18
    //   285: aload_2
    //   286: invokevirtual 179	java/io/InputStream:close	()V
    //   289: return
    //   290: astore_1
    //   291: ldc 126
    //   293: iconst_1
    //   294: new 85	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   301: ldc 181
    //   303: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload_1
    //   307: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   310: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokestatic 134	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   316: return
    //   317: astore_2
    //   318: aload_3
    //   319: astore_1
    //   320: ldc 126
    //   322: iconst_1
    //   323: new 85	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   330: ldc 186
    //   332: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload_2
    //   336: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   339: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokestatic 134	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   345: aload_3
    //   346: ifnull -328 -> 18
    //   349: aload_3
    //   350: invokevirtual 179	java/io/InputStream:close	()V
    //   353: return
    //   354: astore_1
    //   355: ldc 126
    //   357: iconst_1
    //   358: new 85	java/lang/StringBuilder
    //   361: dup
    //   362: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   365: ldc 181
    //   367: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: aload_1
    //   371: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   374: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 134	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   380: return
    //   381: astore_2
    //   382: aload 4
    //   384: astore_1
    //   385: aload_1
    //   386: ifnull +7 -> 393
    //   389: aload_1
    //   390: invokevirtual 179	java/io/InputStream:close	()V
    //   393: aload_2
    //   394: athrow
    //   395: astore_1
    //   396: ldc 126
    //   398: iconst_1
    //   399: new 85	java/lang/StringBuilder
    //   402: dup
    //   403: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   406: ldc 181
    //   408: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: aload_1
    //   412: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   415: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: invokestatic 134	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   421: goto -28 -> 393
    //   424: astore_2
    //   425: goto -40 -> 385
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	428	0	this	RIJWebResourceUtil
    //   0	428	1	paramString	String
    //   37	249	2	localInputStream1	InputStream
    //   317	19	2	localThrowable	java.lang.Throwable
    //   381	13	2	localObject1	Object
    //   424	1	2	localObject2	Object
    //   40	151	3	localInputStream2	InputStream
    //   253	97	3	localIOException	java.io.IOException
    //   43	340	4	localInputStream3	InputStream
    //   23	198	5	localInputStream4	InputStream
    //   33	139	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   220	225	226	java/io/IOException
    //   45	53	253	java/io/IOException
    //   63	88	253	java/io/IOException
    //   99	113	253	java/io/IOException
    //   123	132	253	java/io/IOException
    //   142	150	253	java/io/IOException
    //   160	185	253	java/io/IOException
    //   195	220	253	java/io/IOException
    //   285	289	290	java/io/IOException
    //   45	53	317	java/lang/Throwable
    //   63	88	317	java/lang/Throwable
    //   99	113	317	java/lang/Throwable
    //   123	132	317	java/lang/Throwable
    //   142	150	317	java/lang/Throwable
    //   160	185	317	java/lang/Throwable
    //   195	220	317	java/lang/Throwable
    //   349	353	354	java/io/IOException
    //   45	53	381	finally
    //   63	88	381	finally
    //   99	113	381	finally
    //   123	132	381	finally
    //   142	150	381	finally
    //   160	185	381	finally
    //   195	220	381	finally
    //   389	393	395	java/io/IOException
    //   256	281	424	finally
    //   320	345	424	finally
  }
  
  private final boolean a(String paramString)
  {
    return jdField_a_of_type_JavaUtilArrayList.contains(paramString);
  }
  
  private final String b(String paramString)
  {
    if (TextUtils.isEmpty((CharSequence)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString))) {
      a(paramString);
    }
    for (;;)
    {
      return (String)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      QLog.i("RIJWebResourceUtil", 1, "[getFileContent] hit cache, filePath = " + paramString);
    }
  }
  
  @Nullable
  public final WebResourceResponse a(@NotNull String paramString)
  {
    Object localObject = null;
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    if (!RIJWebArticleUtil.a.f()) {}
    String str;
    do
    {
      do
      {
        return null;
      } while (!a(paramString));
      str = paramString.substring(StringsKt.lastIndexOf$default((CharSequence)paramString, '/', 0, false, 6, null) + 1, paramString.length());
      Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      paramString = paramString.substring(StringsKt.lastIndexOf$default((CharSequence)paramString, ".", 0, false, 6, null) + 1, paramString.length());
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    } while ((!StringsKt.equals(paramString, "css", true)) && (!StringsKt.equals(paramString, "js", true)));
    if (StringsKt.equals(paramString, "css", true)) {}
    for (paramString = "text/css";; paramString = "text/javascript")
    {
      str = b(a() + '/' + str);
      if (TextUtils.isEmpty((CharSequence)str)) {
        break;
      }
      if (str == null) {
        break label239;
      }
      localObject = Charsets.UTF_8;
      if (str != null) {
        break label193;
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
    label193:
    localObject = str.getBytes((Charset)localObject);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "(this as java.lang.String).getBytes(charset)");
    label239:
    for (;;)
    {
      return new WebResourceResponse(paramString, "utf-8", (InputStream)new BufferedInputStream((InputStream)new ByteArrayInputStream((byte[])localObject)));
    }
  }
  
  @Nullable
  public final String a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    if (a(paramString))
    {
      paramString = paramString.substring(StringsKt.lastIndexOf$default((CharSequence)paramString, '/', 0, false, 6, null) + 1, paramString.length());
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      paramString = b(a() + '/' + paramString);
      if (!TextUtils.isEmpty((CharSequence)paramString)) {
        return paramString;
      }
    }
    return "";
  }
  
  public final void a()
  {
    ThreadManager.excute((Runnable)RIJWebResourceUtil.updateResourceOfflinePkg.runnable.1.a, 128, null, true);
  }
  
  public final void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0))
    {
      QLog.i("RIJWebResourceUtil", 1, "[preloadResource] do not preload, forceLoad = " + paramBoolean + ", size = " + jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
      return;
    }
    ThreadManager.excute((Runnable)RIJWebResourceUtil.preloadResource.runnable.1.a, 64, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.webarticle.RIJWebResourceUtil
 * JD-Core Version:    0.7.0.1
 */