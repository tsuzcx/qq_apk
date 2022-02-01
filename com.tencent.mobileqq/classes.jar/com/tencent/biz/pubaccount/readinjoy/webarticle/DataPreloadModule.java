package com.tencent.biz.pubaccount.readinjoy.webarticle;

import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyEngineModule;
import com.tencent.biz.pubaccount.readinjoy.protocol.RIJPBFieldUtils;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyOidbHelper;
import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager;
import com.tencent.biz.pubaccount.readinjoy.webarticle.data.ArticleDetailInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xf24.oidb_cmd0xf24.RspBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/webarticle/DataPreloadModule;", "Lcom/tencent/biz/pubaccount/readinjoy/model/ReadInJoyEngineModule;", "msfService", "Lcom/tencent/biz/pubaccount/readinjoy/protocol/ReadInJoyMSFService;", "(Lcom/tencent/biz/pubaccount/readinjoy/protocol/ReadInJoyMSFService;)V", "articleDetailCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/biz/pubaccount/readinjoy/webarticle/data/ArticleDetailInfo;", "requestList", "", "kotlin.jvm.PlatformType", "", "getUrlWithToken", "url", "handleArticleDetailCgiResponse", "", "result", "handleArticleDetailResponsePkg", "req", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "res", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "data", "", "isAbleToPreload", "", "rowKey", "isArticleDetailAvailable", "articleDetail", "onReceive", "requestArticleDetailByCgi", "requestArticleDetailInWebProcess", "unInitialize", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class DataPreloadModule
  extends ReadInJoyEngineModule
{
  public static final DataPreloadModule.Companion a;
  @NotNull
  private static final DataPreloadModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyWebarticleDataPreloadModule;
  private final Set<String> jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet((Set)new HashSet());
  private final ConcurrentHashMap<String, ArticleDetailInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyWebarticleDataPreloadModule$Companion = new DataPreloadModule.Companion(null);
    ReadInJoyMSFService localReadInJoyMSFService = ReadInJoyMSFService.a();
    Intrinsics.checkExpressionValueIsNotNull(localReadInJoyMSFService, "ReadInJoyMSFService.getInstance()");
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyWebarticleDataPreloadModule = new DataPreloadModule(localReadInJoyMSFService);
  }
  
  public DataPreloadModule(@NotNull ReadInJoyMSFService paramReadInJoyMSFService)
  {
    super(paramReadInJoyMSFService);
  }
  
  private final String a(String paramString)
  {
    Object localObject = ReadInJoyUtils.a();
    String str = ReadInJoyUtils.a();
    localObject = ((AppRuntime)localObject).getManager(2);
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type mqq.manager.TicketManager");
    }
    localObject = ((TicketManager)localObject).getSkey(str);
    str = paramString;
    if (localObject != null)
    {
      str = HtmlOffline.a(paramString, "g_tk=" + ReadInJoyWebDataManager.a((String)localObject));
      Intrinsics.checkExpressionValueIsNotNull(str, "HtmlOffline.addParamToUr…ger.getCSRFToken(skey)}\")");
    }
    if (QLog.isColorLevel()) {
      QLog.i("DataPreloadModule", 1, "[getUrlWithToken] res = " + str);
    }
    return str;
  }
  
  private final boolean a(ArticleDetailInfo paramArticleDetailInfo)
  {
    if (TextUtils.isEmpty((CharSequence)paramArticleDetailInfo.getRowKey()))
    {
      QLog.i("DataPreloadModule", 1, "[isArticleDetailAvailable] rowKey is empty.");
      return false;
    }
    if (TextUtils.isEmpty((CharSequence)paramArticleDetailInfo.getTitle()))
    {
      QLog.i("DataPreloadModule", 1, "[isArticleDetailAvailable] title is empty, rowKey = " + paramArticleDetailInfo.getRowKey());
      return false;
    }
    if (TextUtils.isEmpty((CharSequence)paramArticleDetailInfo.getArticleContentJson()))
    {
      QLog.i("DataPreloadModule", 1, "[isArticleDetailAvailable] articleContentJson is empty. rowKey = " + paramArticleDetailInfo.getRowKey());
      return false;
    }
    return true;
  }
  
  private final boolean a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilSet.contains(paramString)) {}
    while (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
      return false;
    }
    return true;
  }
  
  private final void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xf24.RspBody localRspBody = new oidb_cmd0xf24.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, (MessageMicro)localRspBody);
    if (paramToServiceMsg != null)
    {
      paramToServiceMsg = paramToServiceMsg.getAttribute("attribute_key_rowKey");
      if (paramToServiceMsg == null) {}
    }
    while (paramToServiceMsg == null)
    {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
      paramToServiceMsg = "";
    }
    paramFromServiceMsg = (String)paramToServiceMsg;
    QLog.i("DataPreloadModule", 1, "[handleArticleDetailResponsePkg] requestRowKey = " + paramFromServiceMsg + ", result = " + i);
    this.jdField_a_of_type_JavaUtilSet.remove(paramFromServiceMsg);
    if (i == 0)
    {
      paramToServiceMsg = new ArticleDetailInfo();
      if (!RIJPBFieldUtils.a(localRspBody.over_length)) {
        break label168;
      }
      QLog.i("DataPreloadModule", 1, "[handleArticleDetailResponsePkg] requestRowKey = " + paramFromServiceMsg + ", isOverLength.");
      b(paramFromServiceMsg);
    }
    label168:
    do
    {
      return;
      paramFromServiceMsg = RIJPBFieldUtils.a(localRspBody.rowkey, "");
      Intrinsics.checkExpressionValueIsNotNull(paramFromServiceMsg, "RIJPBFieldUtils.toString(rspBody.rowkey, \"\")");
      paramToServiceMsg.setRowKey(paramFromServiceMsg);
      paramToServiceMsg.setArticleId(RIJPBFieldUtils.a(localRspBody.article_id));
      paramFromServiceMsg = RIJPBFieldUtils.a(localRspBody.title, "");
      Intrinsics.checkExpressionValueIsNotNull(paramFromServiceMsg, "RIJPBFieldUtils.toString(rspBody.title, \"\")");
      paramToServiceMsg.setTitle(paramFromServiceMsg);
      paramFromServiceMsg = RIJPBFieldUtils.a(localRspBody.cover_image_url, "");
      Intrinsics.checkExpressionValueIsNotNull(paramFromServiceMsg, "RIJPBFieldUtils.toString…Body.cover_image_url, \"\")");
      paramToServiceMsg.setCoverImageUrl(paramFromServiceMsg);
      paramToServiceMsg.setReadCount(RIJPBFieldUtils.a(localRspBody.read_count));
      paramToServiceMsg.setPublishTime(RIJPBFieldUtils.a(localRspBody.publish_time));
      paramToServiceMsg.setPUin(RIJPBFieldUtils.a(localRspBody.puin));
      paramFromServiceMsg = RIJPBFieldUtils.a(localRspBody.account_avatar_url, "");
      Intrinsics.checkExpressionValueIsNotNull(paramFromServiceMsg, "RIJPBFieldUtils.toString…y.account_avatar_url, \"\")");
      paramToServiceMsg.setAccountAvatarUrl(paramFromServiceMsg);
      paramFromServiceMsg = RIJPBFieldUtils.a(localRspBody.account_name, "");
      Intrinsics.checkExpressionValueIsNotNull(paramFromServiceMsg, "RIJPBFieldUtils.toString(rspBody.account_name, \"\")");
      paramToServiceMsg.setAccountName(paramFromServiceMsg);
      paramFromServiceMsg = RIJPBFieldUtils.a(localRspBody.json_article_content, "");
      Intrinsics.checkExpressionValueIsNotNull(paramFromServiceMsg, "RIJPBFieldUtils.toString…json_article_content, \"\")");
      paramToServiceMsg.setArticleContentJson(paramFromServiceMsg);
      paramFromServiceMsg = RIJPBFieldUtils.a(localRspBody.json_extend_info, "");
      Intrinsics.checkExpressionValueIsNotNull(paramFromServiceMsg, "RIJPBFieldUtils.toString…ody.json_extend_info, \"\")");
      paramToServiceMsg.setExtendInfoJson(paramFromServiceMsg);
      paramFromServiceMsg = RIJPBFieldUtils.a(localRspBody.tags, "");
      Intrinsics.checkExpressionValueIsNotNull(paramFromServiceMsg, "RIJPBFieldUtils.toString(rspBody.tags, \"\")");
      paramToServiceMsg.setTags(paramFromServiceMsg);
      paramToServiceMsg.setOverLength(RIJPBFieldUtils.a(localRspBody.over_length));
      QLog.i("DataPreloadModule", 1, "[handleArticleDetailResponsePkg] articleDetailInfo = " + paramToServiceMsg);
    } while (!a(paramToServiceMsg));
    ((Map)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).put(paramToServiceMsg.getRowKey(), paramToServiceMsg);
    RIJPageGenerator.a.a(paramToServiceMsg);
    RIJWebResourceUtil.a(RIJWebResourceUtil.a, false, 1, null);
  }
  
  private final void b(String paramString)
  {
    paramString = (Runnable)new DataPreloadModule.requestArticleDetailByCgi.runnable.1(this, paramString);
    ThreadManager.getSubThreadHandler().post(paramString);
  }
  
  private final void c(String paramString)
  {
    QLog.i("DataPreloadModule", 1, "[handleArticleDetailCgiResponse] result = " + paramString);
    ArticleDetailInfo localArticleDetailInfo;
    if (!TextUtils.isEmpty((CharSequence)paramString)) {
      localArticleDetailInfo = new ArticleDetailInfo();
    }
    try
    {
      paramString = new JSONObject(paramString);
      String str = paramString.optString("rowkey", "");
      Intrinsics.checkExpressionValueIsNotNull(str, "json.optString(\"rowkey\", \"\")");
      localArticleDetailInfo.setRowKey(str);
      localArticleDetailInfo.setArticleId(paramString.optLong("article_id", 0L));
      str = paramString.optString("title", "");
      Intrinsics.checkExpressionValueIsNotNull(str, "json.optString(\"title\", \"\")");
      localArticleDetailInfo.setTitle(str);
      str = paramString.optString("cover_image_url", "");
      Intrinsics.checkExpressionValueIsNotNull(str, "json.optString(\"cover_image_url\", \"\")");
      localArticleDetailInfo.setCoverImageUrl(str);
      localArticleDetailInfo.setReadCount(paramString.optLong("read_count", 0L));
      localArticleDetailInfo.setPublishTime(paramString.optLong("publish_time", 0L));
      localArticleDetailInfo.setPUin(paramString.optLong("puin", 0L));
      str = paramString.optString("account_avatar_url", "");
      Intrinsics.checkExpressionValueIsNotNull(str, "json.optString(\"account_avatar_url\", \"\")");
      localArticleDetailInfo.setAccountAvatarUrl(str);
      str = paramString.optString("account_name", "");
      Intrinsics.checkExpressionValueIsNotNull(str, "json.optString(\"account_name\", \"\")");
      localArticleDetailInfo.setAccountName(str);
      str = paramString.optString("json_article_content", "");
      Intrinsics.checkExpressionValueIsNotNull(str, "json.optString(\"json_article_content\", \"\")");
      localArticleDetailInfo.setArticleContentJson(str);
      str = paramString.optString("json_extend_info", "");
      Intrinsics.checkExpressionValueIsNotNull(str, "json.optString(\"json_extend_info\", \"\")");
      localArticleDetailInfo.setExtendInfoJson(str);
      paramString = paramString.optString("tags", "");
      Intrinsics.checkExpressionValueIsNotNull(paramString, "json.optString(\"tags\", \"\")");
      localArticleDetailInfo.setTags(paramString);
      QLog.i("DataPreloadModule", 1, "[handleArticleDetailCgiResponse] articleDetailInfo = " + localArticleDetailInfo);
      if (a(localArticleDetailInfo))
      {
        ((Map)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).put(localArticleDetailInfo.getRowKey(), localArticleDetailInfo);
        RIJPageGenerator.a.a(localArticleDetailInfo);
        RIJWebResourceUtil.a(RIJWebResourceUtil.a, false, 1, null);
      }
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("DataPreloadModule", 1, "[handleArticleDetailCgiResponse] e = " + paramString);
    }
  }
  
  public void a(@Nullable ToServiceMsg paramToServiceMsg, @Nullable FromServiceMsg paramFromServiceMsg, @Nullable Object paramObject)
  {
    CharSequence localCharSequence = (CharSequence)"OidbSvc.0xf24";
    if (paramFromServiceMsg != null) {}
    for (String str = paramFromServiceMsg.getServiceCmd();; str = null)
    {
      if (TextUtils.equals(localCharSequence, (CharSequence)str)) {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowKey");
    paramString = (Runnable)new DataPreloadModule.requestArticleDetailInWebProcess.runnable.1(this, paramString);
    ThreadManager.getSubThreadHandler().post(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.webarticle.DataPreloadModule
 * JD-Core Version:    0.7.0.1
 */