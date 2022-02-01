package com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data.RIJFeedsInsertAction;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data.RIJFeedsInsertArticle;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/RIJFeedsDynamicInsertRecordAction;", "", "()V", "feedsActionMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "getFeedsActionMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "deleteActionsByRowkey", "", "reqSource", "rowKey", "getInsertArticles", "Lkotlin/Triple;", "", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "Lcom/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/data/RIJFeedsInsertAction;", "getRecordFeedsActions", "(ILjava/lang/String;)Ljava/lang/Integer;", "recordFeedsAction", "action", "Lcom/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/RIJFeedsDynamicInsertRecordAction$ActionType;", "ActionType", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJFeedsDynamicInsertRecordAction
{
  public static final RIJFeedsDynamicInsertRecordAction.Companion a;
  @NotNull
  private static final Lazy jdField_a_of_type_KotlinLazy = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0)RIJFeedsDynamicInsertRecordAction.Companion.INSTANCE.2.INSTANCE);
  @NotNull
  private final ConcurrentHashMap<Integer, ConcurrentHashMap<String, Integer>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedsdynamicinsertRIJFeedsDynamicInsertRecordAction$Companion = new RIJFeedsDynamicInsertRecordAction.Companion(null);
  }
  
  @Nullable
  public final Integer a(int paramInt, @Nullable String paramString)
  {
    Object localObject = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localObject != null) {}
    for (localObject = (Integer)((ConcurrentHashMap)localObject).get(paramString); localObject == null; localObject = null) {
      return Integer.valueOf(RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_NONE.getActionType());
    }
    localObject = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localObject != null) {
      return (Integer)((ConcurrentHashMap)localObject).get(paramString);
    }
    return null;
  }
  
  @NotNull
  public final ConcurrentHashMap<Integer, ConcurrentHashMap<String, Integer>> a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  @Nullable
  public final Triple<List<ArticleInfo>, RIJFeedsInsertAction, String> a(int paramInt, @Nullable String paramString)
  {
    Object localObject2 = null;
    if (TextUtils.isEmpty((CharSequence)paramString)) {
      QLog.d("RIJFeedsDynamicInsertActionRecord", 1, "rowKey is null, return");
    }
    label21:
    label49:
    label178:
    for (;;)
    {
      return null;
      Object localObject3 = a(paramInt, paramString);
      Object localObject1 = RIJFeedsDynamicInsertController.a.a();
      if (localObject1 != null)
      {
        paramString = ((RIJFeedsDynamicInsertModule)localObject1).a(paramInt, paramString);
        if (paramString == null) {
          break label175;
        }
      }
      for (localObject1 = paramString.a();; localObject1 = null)
      {
        if ((localObject1 == null) || (localObject3 == null)) {
          break label178;
        }
        localObject1 = paramString.a();
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        localObject1 = ((SortedMap)localObject1).keySet().iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label21;
        }
        RIJFeedsInsertAction localRIJFeedsInsertAction = (RIJFeedsInsertAction)((Iterator)localObject1).next();
        if ((localRIJFeedsInsertAction.a().getActionType() & ((Integer)localObject3).intValue()) <= 0) {
          break;
        }
        localObject3 = paramString.a();
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = (ArrayList)((SortedMap)localObject3).get(localRIJFeedsInsertAction);
        }
        return new Triple(localObject1, localRIJFeedsInsertAction, paramString.a());
        paramString = null;
        break label49;
      }
    }
  }
  
  public final void a(int paramInt, @Nullable String paramString)
  {
    if (paramString != null)
    {
      ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
      if (localConcurrentHashMap != null) {
        paramString = (Integer)localConcurrentHashMap.remove(paramString);
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt));
  }
  
  public final void a(int paramInt, @Nullable String paramString, @NotNull RIJFeedsDynamicInsertRecordAction.ActionType paramActionType)
  {
    Intrinsics.checkParameterIsNotNull(paramActionType, "action");
    QLog.d("RIJFeedsDynamicInsertActionRecord", 1, "recordsFeedsAction, reqSource: " + paramInt + ", rowKey: " + paramString + ", action: " + paramActionType);
    if (TextUtils.isEmpty((CharSequence)paramString)) {
      QLog.i("RIJFeedsDynamicInsertActionRecord", 1, "[recordFeedsAction] record feeds action key is null");
    }
    Object localObject;
    do
    {
      ConcurrentHashMap localConcurrentHashMap;
      do
      {
        return;
        localObject = a(paramInt, paramString);
        if (localObject == null) {
          break;
        }
        int i = RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_NONE.getActionType();
        if (((Integer)localObject).intValue() == i) {
          break;
        }
        localConcurrentHashMap = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
      } while (localConcurrentHashMap == null);
      ((Map)localConcurrentHashMap).put(paramString, Integer.valueOf(((Integer)localObject).intValue() | paramActionType.getActionType()));
      return;
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt))) {
        ((Map)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).put(Integer.valueOf(paramInt), new ConcurrentHashMap());
      }
      localObject = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    } while (localObject == null);
    ((Map)localObject).put(paramString, Integer.valueOf(paramActionType.getActionType()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertRecordAction
 * JD-Core Version:    0.7.0.1
 */