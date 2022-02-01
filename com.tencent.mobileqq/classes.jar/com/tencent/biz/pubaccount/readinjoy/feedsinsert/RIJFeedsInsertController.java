package com.tencent.biz.pubaccount.readinjoy.feedsinsert;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo.PackArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/feedsinsert/RIJFeedsInsertController;", "", "()V", "TAG", "", "addToListFilterDuplicate", "", "articleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;", "articleInfoList", "", "index", "", "insertArticleCallback", "Lcom/tencent/biz/pubaccount/readinjoy/feedsinsert/RIJFeedsInsertController$IInsertArticleCallback;", "getInsertArticleInfoList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "insertAfterArticleInfo", "feedsInsertInfoMap", "Ljava/util/concurrent/ConcurrentHashMap;", "getNewArticleInfoListWithInsertFeeds", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;", "insertArticleInfo", "", "IInsertArticleCallback", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJFeedsInsertController
{
  public static final RIJFeedsInsertController a = new RIJFeedsInsertController();
  
  private final ArrayList<BaseArticleInfo> a(BaseArticleInfo paramBaseArticleInfo, ConcurrentHashMap<String, ArrayList<BaseArticleInfo>> paramConcurrentHashMap)
  {
    Object localObject3 = null;
    Object localObject1;
    if (paramBaseArticleInfo != null)
    {
      localObject1 = paramBaseArticleInfo.innerUniqueID;
      if (localObject1 != null) {
        break label24;
      }
    }
    label24:
    Object localObject2;
    do
    {
      do
      {
        return localObject3;
        localObject1 = null;
        break;
        localObject2 = (ArrayList)paramConcurrentHashMap.get(paramBaseArticleInfo.innerUniqueID);
        localObject3 = localObject2;
      } while (localObject2 != null);
      localObject3 = paramBaseArticleInfo.mSubArtilceList;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        localObject1 = localObject2;
        if (((Iterator)localObject3).hasNext())
        {
          localObject2 = (ArrayList)paramConcurrentHashMap.get(((ArticleInfo)((Iterator)localObject3).next()).innerUniqueID);
          if (localObject2 != null) {
            localObject1 = localObject2;
          }
          for (;;)
          {
            break;
          }
        }
      }
      localObject3 = localObject1;
    } while (localObject1 != null);
    paramBaseArticleInfo = paramBaseArticleInfo.mNewPolymericInfo;
    if (paramBaseArticleInfo != null)
    {
      paramBaseArticleInfo = paramBaseArticleInfo.a;
      if (paramBaseArticleInfo != null)
      {
        localObject2 = paramBaseArticleInfo.iterator();
        paramBaseArticleInfo = (BaseArticleInfo)localObject1;
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = (ArrayList)paramConcurrentHashMap.get(((NewPolymericInfo.PackArticleInfo)((Iterator)localObject2).next()).g);
          if (localObject1 != null) {
            paramBaseArticleInfo = (BaseArticleInfo)localObject1;
          }
          for (;;)
          {
            break;
          }
        }
      }
    }
    for (;;)
    {
      return paramBaseArticleInfo;
      paramBaseArticleInfo = (BaseArticleInfo)localObject1;
    }
  }
  
  private final boolean a(BaseArticleInfo paramBaseArticleInfo, List<? extends BaseArticleInfo> paramList, int paramInt, RIJFeedsInsertController.IInsertArticleCallback paramIInsertArticleCallback)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)localIterator.next();
      if (TextUtils.equals((CharSequence)paramBaseArticleInfo.innerUniqueID, (CharSequence)localBaseArticleInfo.innerUniqueID))
      {
        QLog.i("RIJFeedsInsertController", 1, "[addToListFilterDuplicate] has duplicate, articleInfo = " + RIJFeedsInsertUtil.a.a(paramBaseArticleInfo));
        return false;
      }
    }
    if (paramList == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableList<com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo>");
    }
    TypeIntrinsics.asMutableList(paramList).add(paramInt, paramBaseArticleInfo);
    if (paramIInsertArticleCallback != null) {
      paramIInsertArticleCallback.a(paramBaseArticleInfo);
    }
    QLog.i("RIJFeedsInsertController", 1, "[addToListFilterDuplicate], index = " + paramInt + ", articleInfo = " + RIJFeedsInsertUtil.a.a(paramBaseArticleInfo));
    return true;
  }
  
  @NotNull
  public final List<BaseArticleInfo> a(@NotNull ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @NotNull List<? extends BaseArticleInfo> paramList, @Nullable RIJFeedsInsertController.IInsertArticleCallback paramIInsertArticleCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramReadInJoyBaseAdapter, "adapter");
    Intrinsics.checkParameterIsNotNull(paramList, "articleInfoList");
    long l = System.currentTimeMillis();
    int i = paramReadInJoyBaseAdapter.a();
    if (!RIJFeedsInsertUtil.a.a(i))
    {
      QLog.i("RIJFeedsInsertController", 1, "[getNewArticleInfoListWithInsertFeeds] channelId = " + i + ", do not insert...");
      return paramList;
    }
    paramReadInJoyBaseAdapter = ReadInJoyUtils.a();
    if (paramReadInJoyBaseAdapter == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
    }
    paramReadInJoyBaseAdapter = (ReadInJoyLogicManager)((QQAppInterface)paramReadInJoyBaseAdapter).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    label129:
    int j;
    label146:
    int k;
    if (paramReadInJoyBaseAdapter != null)
    {
      paramReadInJoyBaseAdapter = paramReadInJoyBaseAdapter.a();
      if (paramReadInJoyBaseAdapter != null)
      {
        paramReadInJoyBaseAdapter = paramReadInJoyBaseAdapter.a();
        if (paramReadInJoyBaseAdapter != null)
        {
          paramReadInJoyBaseAdapter = paramReadInJoyBaseAdapter.a(i);
          if (paramReadInJoyBaseAdapter == null) {
            break label274;
          }
          i = paramList.size() - 1;
          j = 0;
          if (j > i) {
            break label274;
          }
          Object localObject = (BaseArticleInfo)paramList.get(j);
          localObject = a.a((BaseArticleInfo)localObject, paramReadInJoyBaseAdapter);
          k = i;
          if (localObject == null) {
            break label261;
          }
          localObject = ((ArrayList)localObject).iterator();
          label193:
          if (!((Iterator)localObject).hasNext()) {
            break label257;
          }
          BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)((Iterator)localObject).next();
          RIJFeedsInsertController localRIJFeedsInsertController = a;
          Intrinsics.checkExpressionValueIsNotNull(localBaseArticleInfo, "insertArticleInfo");
          if (!localRIJFeedsInsertController.a(localBaseArticleInfo, paramList, j + 1, paramIInsertArticleCallback)) {
            break label318;
          }
          i += 1;
        }
      }
    }
    label257:
    label261:
    label274:
    label318:
    for (;;)
    {
      break label193;
      paramReadInJoyBaseAdapter = null;
      break label129;
      k = i;
      j += 1;
      i = k;
      break label146;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("RIJFeedsInsertController", 1, "[getNewArticleInfoListWithInsertFeeds], time cost = " + (System.currentTimeMillis() - l) + " ms");
      return paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.feedsinsert.RIJFeedsInsertController
 * JD-Core Version:    0.7.0.1
 */