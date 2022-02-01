package com.tencent.biz.pubaccount.readinjoy.pts.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager.Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJReportDataCollectionManager;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyModelImpl;
import com.tencent.biz.pubaccount.readinjoy.proteus.data.Util;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/pts/data/PTSLiteDataFactory$Companion;", "", "()V", "FEEDS_TYPE_BILI_DOUBLE", "", "TAG", "", "dataBuilderMap", "", "Lcom/tencent/biz/pubaccount/readinjoy/pts/data/PTSLiteDataFactory$IPTSLiteDataJson;", "addR5ReportJson", "", "articleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "r5", "Lorg/json/JSONObject;", "bindCommonInfo", "json", "convertToPtsLiteCard", "updateReportData", "article", "Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;", "exposeTime", "", "position", "dataManager", "Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class PTSLiteDataFactory$Companion
{
  private final void a(JSONObject paramJSONObject, ArticleInfo paramArticleInfo)
  {
    Util.c((BaseArticleInfo)paramArticleInfo, paramJSONObject);
    Util.b((BaseArticleInfo)paramArticleInfo, paramJSONObject);
  }
  
  public final void a(@NotNull ArticleInfo paramArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramArticleInfo, "articleInfo");
    Object localObject3 = new JSONObject();
    Object localObject1 = localObject3;
    try
    {
      if (!TextUtils.isEmpty((CharSequence)paramArticleInfo.proteusItemsData)) {
        localObject1 = new JSONObject(paramArticleInfo.proteusItemsData);
      }
      localObject3 = (PTSLiteDataFactory.IPTSLiteDataJson)PTSLiteDataFactory.a().get(Integer.valueOf(paramArticleInfo.mFeedType));
      if (localObject3 != null)
      {
        ((PTSLiteDataFactory.IPTSLiteDataJson)localObject3).a(paramArticleInfo, (JSONObject)localObject1);
        PTSLiteDataFactory.a.a((JSONObject)localObject1, paramArticleInfo);
        paramArticleInfo.proteusItemsData = ((JSONObject)localObject1).toString();
        QLog.i("PTSLiteDataFactory", 1, "[convertToPtsLiteCard], articleInfo = " + paramArticleInfo);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("PTSLiteDataFactory", 1, "[convertToPtsLiteCard] e = " + localJSONException);
        Object localObject2 = localObject3;
      }
    }
  }
  
  public final void a(@NotNull ArticleInfo paramArticleInfo, @NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramArticleInfo, "articleInfo");
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "r5");
    PTSLiteDataFactory.IPTSLiteDataJson localIPTSLiteDataJson = (PTSLiteDataFactory.IPTSLiteDataJson)PTSLiteDataFactory.a().get(Integer.valueOf(paramArticleInfo.mFeedType));
    if (localIPTSLiteDataJson != null)
    {
      localIPTSLiteDataJson.b(paramArticleInfo, paramJSONObject);
      QLog.i("PTSLiteDataFactory", 1, "[addR5ReportJson], mFeedType = " + paramArticleInfo.mFeedType + ", r5 = " + paramJSONObject);
    }
  }
  
  public final void a(@NotNull BaseArticleInfo paramBaseArticleInfo, long paramLong, int paramInt, @NotNull RIJDataManager paramRIJDataManager)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseArticleInfo, "article");
    Intrinsics.checkParameterIsNotNull(paramRIJDataManager, "dataManager");
    if ((paramBaseArticleInfo.mFeedType == 58) && (paramBaseArticleInfo.mSubArtilceList != null) && (paramBaseArticleInfo.mSubArtilceList.size() > 0))
    {
      paramBaseArticleInfo = paramBaseArticleInfo.mSubArtilceList.iterator();
      while (paramBaseArticleInfo.hasNext())
      {
        ArticleInfo localArticleInfo = (ArticleInfo)paramBaseArticleInfo.next();
        Object localObject1 = paramRIJDataManager.a();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "dataManager.builder");
        localObject1 = ((RIJDataManager.Builder)localObject1).a();
        if (localArticleInfo == null) {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo");
        }
        Object localObject2 = paramRIJDataManager.a();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "dataManager.builder");
        int i = ((RIJDataManager.Builder)localObject2).b();
        localObject2 = paramRIJDataManager.a();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "dataManager.builder");
        int j = ((RIJDataManager.Builder)localObject2).a();
        localObject2 = paramRIJDataManager.a();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "dataManager.builder");
        boolean bool = ((RIJDataManager.Builder)localObject2).d();
        localObject2 = paramRIJDataManager.a();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "dataManager.builder");
        localObject2 = ((RIJDataManager.Builder)localObject2).a();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "dataManager.builder.readInJoyBaseAdapter");
        int k = ((ReadInJoyBaseAdapter)localObject2).getCount();
        localObject2 = paramRIJDataManager.a();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "dataManager.builder");
        localObject1 = (IReadInJoyModel)new ReadInJoyModelImpl((Context)localObject1, localArticleInfo, 46, i, j, paramInt, bool, k, null, ((RIJDataManager.Builder)localObject2).a());
        RIJReportDataCollectionManager.a((BaseArticleInfo)localArticleInfo, (IReadInJoyModel)localObject1, paramLong, paramInt, paramRIJDataManager);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.data.PTSLiteDataFactory.Companion
 * JD-Core Version:    0.7.0.1
 */