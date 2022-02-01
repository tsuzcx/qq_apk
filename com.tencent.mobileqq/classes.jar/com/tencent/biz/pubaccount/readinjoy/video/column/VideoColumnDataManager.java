package com.tencent.biz.pubaccount.readinjoy.video.column;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.PlayerHelper;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.PlayerHelper.Companion;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.VideoItemHolder;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/column/VideoColumnDataManager;", "", "fromType", "", "(I)V", "dataMap", "", "", "Lorg/json/JSONObject;", "getFromType", "()I", "requestingList", "", "addData", "", "topicId", "json", "convertColumnJson", "columnInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;", "disablePreload", "", "videoFromType", "fetchVideoColumnList", "videoInfo", "Lcom/tencent/biz/pubaccount/VideoInfo;", "rowKey", "getColumnDataInfo", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "data", "getUrlJumpInfo", "urlJumpInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/UrlJumpInfo;", "makeReqBody", "Lcom/tencent/mobileqq/WebSsoBody$WebSsoRequestBody;", "onCenterViewChange", "viewHolder", "Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/VideoItemHolder;", "removeRequest", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VideoColumnDataManager
{
  public static final VideoColumnDataManager.Companion a;
  private final int jdField_a_of_type_Int;
  private final List<String> jdField_a_of_type_JavaUtilList;
  private final Map<String, JSONObject> jdField_a_of_type_JavaUtilMap;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoColumnVideoColumnDataManager$Companion = new VideoColumnDataManager.Companion(null);
  }
  
  public VideoColumnDataManager(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilMap = ((Map)new LinkedHashMap());
    this.jdField_a_of_type_JavaUtilList = ((List)new ArrayList());
  }
  
  private final WebSsoBody.WebSsoRequestBody a(String paramString1, String paramString2)
  {
    JSONObject localJSONObject2 = new JSONObject().put("uint32_topic_basic", 1).put("uint32_topic_ext", 1).put("uint32_topic_isfans", 1).put("uint32_article_basic", 2).put("uint32_article_play", 1).put("uint32_article_like", 1).put("uint32_article_comment", 1).put("uint32_article_islike", 1).put("uint32_topic_guide", 1);
    JSONObject localJSONObject1 = new JSONObject();
    paramString2 = new JSONArray((Collection)CollectionsKt.arrayListOf(new String[] { paramString2 }));
    localJSONObject1.put("str_topicid", paramString1).put("uint32_size", 6).put("msg_option", localJSONObject2).put("rpt_top_rowkey", paramString2).put("is_public", 0);
    paramString1 = new JSONObject();
    paramString1.put("body", localJSONObject1);
    paramString2 = new WebSsoBody.WebSsoRequestBody();
    paramString2.type.set(0);
    paramString2.data.set(paramString1.toString());
    return paramString2;
  }
  
  private final String a(UrlJumpInfo paramUrlJumpInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramUrlJumpInfo != null) {
      localJSONObject.put("uint32_jump_type", paramUrlJumpInfo.jdField_a_of_type_Int).put("bytes_jump_schema", paramUrlJumpInfo.jdField_c_of_type_JavaLangString).put("bytes_jump_bundle", paramUrlJumpInfo.jdField_b_of_type_JavaLangString).put("bytes_jump_url", paramUrlJumpInfo.jdField_a_of_type_JavaLangString).put("bytes_clipboard_info", paramUrlJumpInfo.jdField_d_of_type_JavaLangString).put("bytes_common_data", paramUrlJumpInfo.jdField_e_of_type_JavaLangString);
    }
    paramUrlJumpInfo = localJSONObject.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramUrlJumpInfo, "json.toString()");
    return paramUrlJumpInfo;
  }
  
  private final String a(String paramString)
  {
    paramString = (JSONObject)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      return paramString.toString();
    }
    return null;
  }
  
  private final void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null) || (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString1)) || (this.jdField_a_of_type_JavaUtilList.contains(paramString1))) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = RIJQQAppInterfaceUtil.a();
    } while (localQQAppInterface == null);
    this.jdField_a_of_type_JavaUtilList.add(paramString1);
    ThreadManagerV2.executeOnSubThread((Runnable)new VideoColumnDataManager.fetchVideoColumnList.2(this, paramString1, paramString2, localQQAppInterface));
  }
  
  private final boolean a(int paramInt)
  {
    boolean bool = false;
    if ((Aladdin.getConfig(350).getIntegerFromString("disable_preload", 0) == 1) || (!ReadInJoyHelper.f(paramInt)) || (!PlayerHelper.a.a())) {
      bool = true;
    }
    return bool;
  }
  
  @Nullable
  public final String a(@NotNull VideoColumnInfo paramVideoColumnInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoColumnInfo, "columnInfo");
    return new JSONObject().put("uint32_column_id", paramVideoColumnInfo.jdField_a_of_type_Int).put("bytes_column_name", paramVideoColumnInfo.jdField_b_of_type_JavaLangString).put("bytes_column_icon_url", paramVideoColumnInfo.jdField_c_of_type_JavaLangString).put("uint32_subscribe_count", paramVideoColumnInfo.jdField_c_of_type_Int).put("uint32_is_subscribed", paramVideoColumnInfo.jdField_a_of_type_Boolean).put("bytes_app_name", paramVideoColumnInfo.g).put("bytes_app_icon_url", paramVideoColumnInfo.h).put("subscribe_jump_info", a(paramVideoColumnInfo.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo)).put("app_jump_info", a(paramVideoColumnInfo.jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo)).put("default_jump_info", a(paramVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo)).put("uint32_style", paramVideoColumnInfo.jdField_e_of_type_Int).put("bytes_from_txt", paramVideoColumnInfo.i).put("uint64_last_update_time", paramVideoColumnInfo.jdField_a_of_type_Long).put("uint32_video_count", paramVideoColumnInfo.jdField_b_of_type_Int).put("bytes_column_card_bg_url", paramVideoColumnInfo.jdField_d_of_type_JavaLangString).put("bytes_column_card_bg_color", paramVideoColumnInfo.jdField_e_of_type_JavaLangString).put("bytes_column_card_icon_url", paramVideoColumnInfo.jdField_f_of_type_JavaLangString).put("bytes_column_name_color", paramVideoColumnInfo.j).put("uin32_column_card_bg_style", paramVideoColumnInfo.jdField_d_of_type_Int).put("uint32_update_count", paramVideoColumnInfo.jdField_f_of_type_Int).toString();
  }
  
  public final void a(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    if (a(this.jdField_a_of_type_Int)) {}
    VideoColumnInfo localVideoColumnInfo;
    do
    {
      return;
      localVideoColumnInfo = paramVideoInfo.a;
    } while (localVideoColumnInfo == null);
    a(String.valueOf(localVideoColumnInfo.jdField_a_of_type_Int), paramVideoInfo.g);
  }
  
  public final void a(@Nullable VideoItemHolder paramVideoItemHolder)
  {
    if (a(this.jdField_a_of_type_Int)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (paramVideoItemHolder == null);
        paramVideoItemHolder = paramVideoItemHolder.a;
      } while (paramVideoItemHolder == null);
      paramVideoItemHolder = paramVideoItemHolder.a;
    } while (paramVideoItemHolder == null);
    VideoColumnInfo localVideoColumnInfo = paramVideoItemHolder.a;
    if (localVideoColumnInfo != null) {
      a(String.valueOf(localVideoColumnInfo.jdField_a_of_type_Int), paramVideoItemHolder.g);
    }
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "topicId");
    this.jdField_a_of_type_JavaUtilList.remove(paramString);
  }
  
  public final void a(@NotNull String paramString, @NotNull Function1<? super String, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "topicId");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    String str2 = a(paramString);
    if (str2 != null) {}
    for (String str1 = str2;; str1 = "")
    {
      paramFunction1.invoke(str1);
      if (str2 == null) {
        QLog.e("VideoColumnDataManager", 1, "getColumnInfo error, waitingData: " + this.jdField_a_of_type_JavaUtilList.contains(paramString));
      }
      return;
    }
  }
  
  public final void a(@NotNull String paramString, @NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "topicId");
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "json");
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilMap.put(paramString, paramJSONObject);
    } while (!QLog.isColorLevel());
    QLog.d("VideoColumnDataManager", 2, "topicId: " + paramString + ", data: " + paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.column.VideoColumnDataManager
 * JD-Core Version:    0.7.0.1
 */