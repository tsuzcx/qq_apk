package com.tencent.biz.pubaccount.readinjoy.pts.lite;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/pts/lite/PTSLiteSwiperEventDispatcher$Builder;", "", "()V", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;", "getAdapter", "()Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;", "setAdapter", "(Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;)V", "articleInfoMap", "Ljava/util/HashMap;", "", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "Lkotlin/collections/HashMap;", "getArticleInfoMap", "()Ljava/util/HashMap;", "setArticleInfoMap", "(Ljava/util/HashMap;)V", "positionMap", "", "getPositionMap", "setPositionMap", "build", "Lcom/tencent/biz/pubaccount/readinjoy/pts/lite/PTSLiteSwiperEventDispatcher;", "withArticleInfoMap", "withPositionMap", "withRIJAdapter", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class PTSLiteSwiperEventDispatcher$Builder
{
  @Nullable
  private ReadInJoyBaseAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter;
  @NotNull
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  @NotNull
  private HashMap<String, ArticleInfo> b = new HashMap();
  
  @NotNull
  public final Builder a(@NotNull ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    Intrinsics.checkParameterIsNotNull(paramReadInJoyBaseAdapter, "adapter");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter = paramReadInJoyBaseAdapter;
    return this;
  }
  
  @NotNull
  public final Builder a(@NotNull HashMap<String, Integer> paramHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramHashMap, "positionMap");
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    return this;
  }
  
  @NotNull
  public final PTSLiteSwiperEventDispatcher a()
  {
    PTSLiteSwiperEventDispatcher localPTSLiteSwiperEventDispatcher = new PTSLiteSwiperEventDispatcher(null);
    PTSLiteSwiperEventDispatcher.a(localPTSLiteSwiperEventDispatcher, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter);
    PTSLiteSwiperEventDispatcher.a(localPTSLiteSwiperEventDispatcher, this.jdField_a_of_type_JavaUtilHashMap);
    PTSLiteSwiperEventDispatcher.b(localPTSLiteSwiperEventDispatcher, this.b);
    return localPTSLiteSwiperEventDispatcher;
  }
  
  @NotNull
  public final Builder b(@NotNull HashMap<String, ArticleInfo> paramHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramHashMap, "articleInfoMap");
    this.b = paramHashMap;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.lite.PTSLiteSwiperEventDispatcher.Builder
 * JD-Core Version:    0.7.0.1
 */