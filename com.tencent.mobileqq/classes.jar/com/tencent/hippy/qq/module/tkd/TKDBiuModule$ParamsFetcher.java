package com.tencent.hippy.qq.module.tkd;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/hippy/qq/module/tkd/TKDBiuModule$ParamsFetcher;", "", "onGetParams", "", "articleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "adTag", "", "biuType", "sourceUrl", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface TKDBiuModule$ParamsFetcher
{
  public abstract void onGetParams(@NotNull ArticleInfo paramArticleInfo, int paramInt1, int paramInt2, @NotNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.tkd.TKDBiuModule.ParamsFetcher
 * JD-Core Version:    0.7.0.1
 */