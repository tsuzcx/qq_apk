package com.tencent.biz.pubaccount.readinjoy.webarticle;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.webarticle.data.ArticleDetailInfo;
import com.tencent.biz.pubaccount.readinjoy.webarticle.data.ImageInfo;
import com.tencent.biz.pubaccount.readinjoy.webarticle.data.IndexInfo;
import com.tencent.biz.pubaccount.readinjoy.webarticle.data.TextInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/webarticle/RIJPageGenerator;", "", "()V", "TAG", "", "TPL_NAME_COMMENT_BAR_SCRIPT", "TPL_NAME_COOKIE_SCRIPT", "TPL_NAME_DEBUG_SCRIPT", "TPL_NAME_IMAGE", "TPL_NAME_LONG_PRESS_SCRIPT", "TPL_NAME_PREFIX_SCRIPT", "TPL_NAME_SEA_SCRIPT", "TPL_NAME_TEXT", "hitCacheList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "pageHtmlCache", "Ljava/util/concurrent/ConcurrentHashMap;", "bindHeadResource", "", "indexInfo", "Lcom/tencent/biz/pubaccount/readinjoy/webarticle/data/IndexInfo;", "bindScriptData", "generateArticleContent", "articleContentJson", "generatePageHtml", "articleDetail", "Lcom/tencent/biz/pubaccount/readinjoy/webarticle/data/ArticleDetailInfo;", "getDateFromTimeMills", "timeMillis", "", "getPageHtml", "rowKey", "getPageHtmlFromUrl", "Lcom/tencent/smtt/export/external/interfaces/WebResourceResponse;", "url", "getPageHtmlStringFromUrl", "isHitCache", "", "isPageHtmlExist", "renderTemplate", "templateName", "data", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJPageGenerator
{
  public static final RIJPageGenerator a;
  private static final ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private static final ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyWebarticleRIJPageGenerator = new RIJPageGenerator();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  private final String a(long paramLong)
  {
    Object localObject = new SimpleDateFormat("MM-dd", Locale.CHINA);
    Calendar localCalendar = Calendar.getInstance();
    Intrinsics.checkExpressionValueIsNotNull(localCalendar, "calendar");
    localCalendar.setTimeInMillis(paramLong);
    localObject = ((SimpleDateFormat)localObject).format(localCalendar.getTime());
    QLog.i("RIJPageGenerator", 1, "[getDateFromTimeMills] timeMillis = " + paramLong + ", date = " + (String)localObject);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "date");
    return localObject;
  }
  
  /* Error */
  private final String a(String paramString, Object paramObject)
  {
    // Byte code:
    //   0: invokestatic 153	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: getstatic 158	com/tencent/biz/pubaccount/readinjoy/webarticle/RIJWebTemplateFactory:a	Lcom/tencent/biz/pubaccount/readinjoy/webarticle/RIJWebTemplateFactory;
    //   7: aload_1
    //   8: invokevirtual 161	com/tencent/biz/pubaccount/readinjoy/webarticle/RIJWebTemplateFactory:a	(Ljava/lang/String;)Lcom/samskivert/mustache/Template;
    //   11: astore 5
    //   13: aload 5
    //   15: ifnull +103 -> 118
    //   18: aload 5
    //   20: aload_2
    //   21: invokevirtual 167	com/samskivert/mustache/Template:execute	(Ljava/lang/Object;)Ljava/lang/String;
    //   24: astore_2
    //   25: aload_2
    //   26: ldc 169
    //   28: invokestatic 104	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   31: ldc 118
    //   33: iconst_1
    //   34: new 120	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   41: ldc 171
    //   43: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_1
    //   47: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc 173
    //   52: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokestatic 153	java/lang/System:currentTimeMillis	()J
    //   58: lload_3
    //   59: lsub
    //   60: invokevirtual 130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   63: ldc 175
    //   65: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 142	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: aload_2
    //   75: areturn
    //   76: astore 5
    //   78: ldc 176
    //   80: astore_2
    //   81: ldc 118
    //   83: iconst_1
    //   84: new 120	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   91: ldc 178
    //   93: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_1
    //   97: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: ldc 180
    //   102: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload 5
    //   107: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 186	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   116: aload_2
    //   117: areturn
    //   118: ldc 118
    //   120: iconst_1
    //   121: new 120	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   128: ldc 188
    //   130: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload_1
    //   134: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 142	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   143: ldc 176
    //   145: areturn
    //   146: astore 5
    //   148: goto -67 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	RIJPageGenerator
    //   0	151	1	paramString	String
    //   0	151	2	paramObject	Object
    //   3	56	3	l	long
    //   11	8	5	localTemplate	com.samskivert.mustache.Template
    //   76	30	5	localMustacheException1	com.samskivert.mustache.MustacheException
    //   146	1	5	localMustacheException2	com.samskivert.mustache.MustacheException
    // Exception table:
    //   from	to	target	type
    //   18	31	76	com/samskivert/mustache/MustacheException
    //   31	74	146	com/samskivert/mustache/MustacheException
  }
  
  private final void a(IndexInfo paramIndexInfo)
  {
    String str = RIJWebTemplateFactory.a.a("prefix_script");
    if (str != null)
    {
      paramIndexInfo.setPrefixScript(str);
      str = RIJWebTemplateFactory.a.a("comment_bar_script");
      if (str == null) {
        break label115;
      }
      label31:
      paramIndexInfo.setCommentBarScript(str);
      str = RIJWebTemplateFactory.a.a("debug_script");
      if (str == null) {
        break label121;
      }
      label49:
      paramIndexInfo.setDebugScript(str);
      str = RIJWebTemplateFactory.a.a("sea_script");
      if (str == null) {
        break label127;
      }
      label67:
      paramIndexInfo.setSeaScript(str);
      str = RIJWebTemplateFactory.a.a("cookie_script");
      if (str == null) {
        break label133;
      }
      label85:
      paramIndexInfo.setCookieScript(str);
      str = RIJWebTemplateFactory.a.a("long_press_script");
      if (str == null) {
        break label139;
      }
    }
    for (;;)
    {
      paramIndexInfo.setLongPressScript(str);
      return;
      str = "";
      break;
      label115:
      str = "";
      break label31;
      label121:
      str = "";
      break label49;
      label127:
      str = "";
      break label67;
      label133:
      str = "";
      break label85;
      label139:
      str = "";
    }
  }
  
  private final String b(String paramString)
  {
    String str = (String)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (TextUtils.isEmpty((CharSequence)str)) {
      QLog.i("RIJPageGenerator", 1, "[getPageHtml] rowKey = " + paramString + ", pageHtml is empty or null.");
    }
    return str;
  }
  
  private final void b(IndexInfo paramIndexInfo)
  {
    String str = RIJWebResourceUtil.a.a("https://beaconcdn.qq.com/sdk/3.1.50/beacon_web.min.js");
    if (!TextUtils.isEmpty((CharSequence)str))
    {
      paramIndexInfo.setBeaconWebScript("<script>" + str + "</script>");
      str = RIJWebResourceUtil.a.a("https://tkd-fe.cdn-go.cn/KdDetailPage/latest/themes/default/client/article/article.css");
      if (TextUtils.isEmpty((CharSequence)str)) {
        break label159;
      }
      paramIndexInfo.setArticleCss("<style>" + str + "</style>");
    }
    for (;;)
    {
      str = RIJWebResourceUtil.a.a("https://watchspot.cdn-go.cn/article-new/latest/css/article_new.css");
      if (TextUtils.isEmpty((CharSequence)str)) {
        break label169;
      }
      paramIndexInfo.setArticleNewCss("<style>" + str + "</style>");
      return;
      paramIndexInfo.setBeaconWebScript("<script src=\"https://beaconcdn.qq.com/sdk/3.1.50/beacon_web.min.js\"></script>");
      break;
      label159:
      paramIndexInfo.setArticleCss("<link rel=\"stylesheet\" href=\"https://tkd-fe.cdn-go.cn/KdDetailPage/latest/themes/default/client/article/article.css\" type=\"text/css\" />");
    }
    label169:
    paramIndexInfo.setArticleNewCss("<link rel=\"stylesheet\" href=\"https://watchspot.cdn-go.cn/article-new/latest/css/article_new.css\" type=\"text/css\" />");
  }
  
  private final String c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONArray(paramString);
        i = 0;
        int j = paramString.length();
        if (i < j)
        {
          JSONObject localJSONObject = paramString.optJSONObject(i);
          if (localJSONObject == null) {
            break label166;
          }
          String str = localJSONObject.optString("type");
          if (Intrinsics.areEqual(str, "cnt_article")) {
            localStringBuilder.append(a("text", new TextInfo(localJSONObject)));
          } else if (Intrinsics.areEqual(str, "img_url")) {
            localStringBuilder.append(a("image", new ImageInfo(localJSONObject)));
          }
        }
      }
      catch (JSONException paramString)
      {
        QLog.e("RIJPageGenerator", 1, "[generateArticleContent] error, e = " + paramString);
        paramString = localStringBuilder.toString();
        Intrinsics.checkExpressionValueIsNotNull(paramString, "contentSb.toString()");
        return paramString;
      }
      label166:
      i += 1;
    }
  }
  
  @Nullable
  public final WebResourceResponse a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    String str1 = Uri.parse(paramString).getQueryParameter("rowkey");
    if (str1 != null) {}
    while (TextUtils.isEmpty((CharSequence)str1))
    {
      QLog.i("RIJPageGenerator", 1, "[getPageHtmlFromUrl] url = " + paramString + ", rowKey is empty.");
      return null;
      str1 = "";
    }
    String str2 = b(str1);
    if (TextUtils.isEmpty((CharSequence)str2))
    {
      QLog.i("RIJPageGenerator", 1, "[getPageHtmlFromUrl] url = " + paramString + ", pageHtml is empty.");
      return null;
    }
    if (!jdField_a_of_type_JavaUtilArrayList.contains(str1)) {
      jdField_a_of_type_JavaUtilArrayList.add(str1);
    }
    if (str2 != null)
    {
      paramString = Charsets.UTF_8;
      if (str2 == null) {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
      paramString = str2.getBytes(paramString);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).getBytes(charset)");
    }
    for (;;)
    {
      return new WebResourceResponse("text/html", "utf-8", (InputStream)new BufferedInputStream((InputStream)new ByteArrayInputStream(paramString)));
      paramString = null;
    }
  }
  
  @Nullable
  public final String a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    String str1 = Uri.parse(paramString).getQueryParameter("rowkey");
    if (str1 != null)
    {
      if (!TextUtils.isEmpty((CharSequence)str1)) {
        break label74;
      }
      QLog.i("RIJPageGenerator", 1, "[getPageHtmlFromUrl] url = " + paramString + ", rowKey is empty.");
      paramString = null;
    }
    label74:
    String str2;
    do
    {
      return paramString;
      str1 = "";
      break;
      str2 = b(str1);
      if (TextUtils.isEmpty((CharSequence)str2))
      {
        QLog.i("RIJPageGenerator", 1, "[getPageHtmlFromUrl] url = " + paramString + ", pageHtml is empty.");
        return null;
      }
      paramString = str2;
    } while (jdField_a_of_type_JavaUtilArrayList.contains(str1));
    jdField_a_of_type_JavaUtilArrayList.add(str1);
    return str2;
  }
  
  public final void a(@NotNull ArticleDetailInfo paramArticleDetailInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramArticleDetailInfo, "articleDetail");
    Object localObject = new IndexInfo();
    ((IndexInfo)localObject).setTitle(paramArticleDetailInfo.getTitle());
    ((IndexInfo)localObject).setCoverImageUrl(paramArticleDetailInfo.getCoverImageUrl());
    ((IndexInfo)localObject).setReadCount(paramArticleDetailInfo.getReadCount());
    ((IndexInfo)localObject).setPublishTime(a(paramArticleDetailInfo.getPublishTime() * 1000));
    ((IndexInfo)localObject).setAccountAvatarUrl(paramArticleDetailInfo.getAccountAvatarUrl());
    ((IndexInfo)localObject).setAccountName(paramArticleDetailInfo.getAccountName());
    ((IndexInfo)localObject).setArticleContent(c(paramArticleDetailInfo.getArticleContentJson()));
    ((IndexInfo)localObject).setPUin(paramArticleDetailInfo.getPUin());
    ((IndexInfo)localObject).setArticleId(paramArticleDetailInfo.getArticleId());
    ((IndexInfo)localObject).setRowKey(paramArticleDetailInfo.getRowKey());
    ((IndexInfo)localObject).setTags(paramArticleDetailInfo.getTags());
    ((IndexInfo)localObject).setExtendInfoJson(paramArticleDetailInfo.getExtendInfoJson());
    a((IndexInfo)localObject);
    b((IndexInfo)localObject);
    localObject = a("index", localObject);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty((CharSequence)paramArticleDetailInfo.getRowKey())))
    {
      ((Map)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).put(paramArticleDetailInfo.getRowKey(), localObject);
      return;
    }
    QLog.i("RIJPageGenerator", 1, "[generatePageHtml] failed, articleDetail = " + paramArticleDetailInfo);
  }
  
  public final boolean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowKey");
    return jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString);
  }
  
  public final boolean b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowKey");
    return (jdField_a_of_type_JavaUtilArrayList.contains(paramString)) && (a(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.webarticle.RIJPageGenerator
 * JD-Core Version:    0.7.0.1
 */