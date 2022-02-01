package com.tencent.biz.pubaccount.readinjoy.webarticle;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/webarticle/DataPreloadModule$Companion;", "", "()V", "ATTRIBUTE_KEY_ROWKEY", "", "CGI_URL", "CMD_INT_ARTICLE_DETAIL", "", "CMD_STRING_ARTICLE_DETAIL", "INSTANCE", "Lcom/tencent/biz/pubaccount/readinjoy/webarticle/DataPreloadModule;", "getINSTANCE", "()Lcom/tencent/biz/pubaccount/readinjoy/webarticle/DataPreloadModule;", "REQUEST_TIME_OUT", "", "SERVICE_TYPE", "TAG", "preloadArticle", "", "articleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class DataPreloadModule$Companion
{
  @NotNull
  public final DataPreloadModule a()
  {
    return DataPreloadModule.a();
  }
  
  public final void a(@NotNull BaseArticleInfo paramBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseArticleInfo, "articleInfo");
    if (!RIJWebArticleUtil.a.g()) {
      return;
    }
    if (RIJFeedsType.a(paramBaseArticleInfo))
    {
      QLog.i("DataPreloadModule", 2, "[preloadArticle] article is video type.");
      return;
    }
    if (TextUtils.isEmpty((CharSequence)paramBaseArticleInfo.innerUniqueID))
    {
      QLog.i("DataPreloadModule", 2, "[preloadArticle] rowKey is null.");
      return;
    }
    QLog.i("DataPreloadModule", 1, "[preloadArticle] rowKey = " + paramBaseArticleInfo.innerUniqueID + ", title = " + paramBaseArticleInfo.mTitle);
    paramBaseArticleInfo = (Runnable)new DataPreloadModule.Companion.preloadArticle.runnable.1(paramBaseArticleInfo);
    ThreadManager.getSubThreadHandler().post(paramBaseArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.webarticle.DataPreloadModule.Companion
 * JD-Core Version:    0.7.0.1
 */