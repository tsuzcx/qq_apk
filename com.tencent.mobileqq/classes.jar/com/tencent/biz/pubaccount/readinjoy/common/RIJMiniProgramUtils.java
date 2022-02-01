package com.tencent.biz.pubaccount.readinjoy.common;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJMiniProgrameReporter;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.common.app.BaseApplicationImpl;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/common/RIJMiniProgramUtils;", "", "()V", "clickMiniProgrameCard", "", "articleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "fromPage", "", "schema", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJMiniProgramUtils
{
  public static final RIJMiniProgramUtils a = new RIJMiniProgramUtils();
  
  public final void a(@Nullable ArticleInfo paramArticleInfo, int paramInt, @Nullable String paramString)
  {
    Object localObject = null;
    RIJMiniProgrameReporter localRIJMiniProgrameReporter;
    if (paramString != null) {
      if (paramString != null)
      {
        ReadInJoyUtils.b((Context)BaseApplicationImpl.getContext(), paramString + "&appscene=" + 2103);
        localRIJMiniProgrameReporter = RIJMiniProgrameReporter.a;
        if (paramArticleInfo == null) {
          break label154;
        }
        paramString = paramArticleInfo.miniProgramName;
        label60:
        localRIJMiniProgrameReporter.a(paramString);
        localRIJMiniProgrameReporter = RIJMiniProgrameReporter.a;
        if (paramArticleInfo == null) {
          break label159;
        }
        paramString = paramArticleInfo.miniAppMovieName;
        label80:
        localRIJMiniProgrameReporter.b(paramString);
        localRIJMiniProgrameReporter = RIJMiniProgrameReporter.a;
        if (paramArticleInfo == null) {
          break label164;
        }
      }
    }
    label154:
    label159:
    label164:
    for (paramString = paramArticleInfo.miniRowKey;; paramString = null)
    {
      localRIJMiniProgrameReporter.c(paramString);
      RIJMiniProgrameReporter.a.a(paramInt);
      localRIJMiniProgrameReporter = RIJMiniProgrameReporter.a;
      paramString = localObject;
      if (paramArticleInfo != null) {
        paramString = paramArticleInfo.getSubscribeUin();
      }
      localRIJMiniProgrameReporter.d(paramString);
      return;
      if (paramArticleInfo != null)
      {
        paramString = paramArticleInfo.mArticleContentUrl;
        break;
      }
      paramString = null;
      break;
      paramString = null;
      break label60;
      paramString = null;
      break label80;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.RIJMiniProgramUtils
 * JD-Core Version:    0.7.0.1
 */