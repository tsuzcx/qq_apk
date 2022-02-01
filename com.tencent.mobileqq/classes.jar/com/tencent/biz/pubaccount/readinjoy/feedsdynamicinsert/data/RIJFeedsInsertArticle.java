package com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/data/RIJFeedsInsertArticle;", "", "()V", "actionArticleMap", "Ljava/util/SortedMap;", "Lcom/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/data/RIJFeedsInsertAction;", "Ljava/util/ArrayList;", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "Lkotlin/collections/ArrayList;", "getActionArticleMap", "()Ljava/util/SortedMap;", "setActionArticleMap", "(Ljava/util/SortedMap;)V", "seqNo", "", "getSeqNo", "()Ljava/lang/String;", "setSeqNo", "(Ljava/lang/String;)V", "toSimpleString", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJFeedsInsertArticle
{
  @Nullable
  private String jdField_a_of_type_JavaLangString;
  @Nullable
  private SortedMap<RIJFeedsInsertAction, ArrayList<ArticleInfo>> jdField_a_of_type_JavaUtilSortedMap = Collections.synchronizedSortedMap((SortedMap)new TreeMap());
  
  @Nullable
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  @Nullable
  public final SortedMap<RIJFeedsInsertAction, ArrayList<ArticleInfo>> a()
  {
    return this.jdField_a_of_type_JavaUtilSortedMap;
  }
  
  public final void a(@Nullable String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public final void a(@Nullable SortedMap<RIJFeedsInsertAction, ArrayList<ArticleInfo>> paramSortedMap)
  {
    this.jdField_a_of_type_JavaUtilSortedMap = paramSortedMap;
  }
  
  @NotNull
  public final String b()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("RIJFeedsInsertArticle(actionArticleMap=\n");
    Object localObject2 = this.jdField_a_of_type_JavaUtilSortedMap;
    if (localObject2 != null)
    {
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
        ((StringBuilder)localObject1).append('[' + (RIJFeedsInsertAction)((Map.Entry)localObject3).getKey() + ":{");
        localObject3 = ((ArrayList)((Map.Entry)localObject3).getValue()).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          ArticleInfo localArticleInfo = (ArticleInfo)((Iterator)localObject3).next();
          ((StringBuilder)localObject1).append('[' + localArticleInfo.mTitle + "     " + localArticleInfo.innerUniqueID + ']');
        }
        ((StringBuilder)localObject1).append("\n");
      }
    }
    ((StringBuilder)localObject1).append(")");
    localObject1 = ((StringBuilder)localObject1).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "simepleStringBuilder.toString()");
    return localObject1;
  }
  
  @NotNull
  public String toString()
  {
    return "RIJFeedsInsertArticle(actionArticleMap=" + this.jdField_a_of_type_JavaUtilSortedMap + ')';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data.RIJFeedsInsertArticle
 * JD-Core Version:    0.7.0.1
 */