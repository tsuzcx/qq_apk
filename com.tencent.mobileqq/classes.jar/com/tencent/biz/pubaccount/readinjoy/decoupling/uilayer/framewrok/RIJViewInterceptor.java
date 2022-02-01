package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/RIJViewInterceptor;", "", "onBindView", "", "articleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;", "position", "", "shouldIntercept", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface RIJViewInterceptor
{
  public abstract void a(@NotNull BaseArticleInfo paramBaseArticleInfo, int paramInt);
  
  public abstract boolean a(@NotNull BaseArticleInfo paramBaseArticleInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJViewInterceptor
 * JD-Core Version:    0.7.0.1
 */