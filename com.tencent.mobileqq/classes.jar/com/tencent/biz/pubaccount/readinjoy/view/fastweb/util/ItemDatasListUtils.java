package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.comment.CommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ArticleTopicData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.NoCommentPlaceHolderData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusRecommendItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RecommendAdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RecommendTitleData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ShareBottomData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerBigPicItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusInnerData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class ItemDatasListUtils
{
  private static int a(List<BaseData> paramList)
  {
    int i = paramList.size() - 1;
    while (i > 0)
    {
      BaseData localBaseData = (BaseData)paramList.get(i);
      if ((FastWebPTSUtils.a(localBaseData)) && (localBaseData.s != 0))
      {
        if (i < paramList.size() - 1) {
          return i + 1;
        }
        return i;
      }
      i -= 1;
    }
    return 1;
  }
  
  private static int a(List<BaseData> paramList, BaseData paramBaseData)
  {
    int i = 2;
    if (paramBaseData.s == 9) {
      i = ((RecommendAdData)paramBaseData).y;
    }
    int j = 0;
    for (int k = i; j < paramList.size(); k = i)
    {
      i = k;
      if (((BaseData)paramList.get(j)).s == 6)
      {
        k -= 1;
        i = k;
        if (k == 1) {
          return j + 1;
        }
      }
      j += 1;
    }
    return -1;
  }
  
  public static List<BaseData> a(List<BaseData> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add((BaseData)paramList.next());
    }
    return localArrayList;
  }
  
  public static void a(List<BaseData> paramList)
  {
    if (paramList == null) {
      return;
    }
    Object localObject = paramList.iterator();
    int j = 0;
    label14:
    if (((Iterator)localObject).hasNext()) {
      if (((BaseData)((Iterator)localObject).next()).s != 6) {
        break label144;
      }
    }
    label144:
    for (int i = j + 1;; i = j)
    {
      j = i;
      break label14;
      paramList = paramList.iterator();
      i = 1;
      if (!paramList.hasNext()) {
        break;
      }
      localObject = (BaseData)paramList.next();
      switch (((BaseData)localObject).s)
      {
      }
      for (;;)
      {
        break;
        localObject = (ProteusRecommendItemData)localObject;
        ((ProteusRecommendItemData)localObject).a = i;
        ((ProteusRecommendItemData)localObject).b = j;
        i += 1;
        continue;
        i += 1;
      }
    }
  }
  
  public static void a(List<BaseData> paramList, int paramInt)
  {
    if (paramList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      BaseData localBaseData = (BaseData)localIterator.next();
      if (localBaseData.s == paramInt) {
        localArrayList.add(localBaseData);
      }
    }
    paramList.removeAll(localArrayList);
  }
  
  public static void a(List<BaseData> paramList, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (FastWebShareUtils.a())
    {
      a(paramList, 19);
      a(paramList, new ShareBottomData(), null);
    }
    for (;;)
    {
      a(paramList, 21);
      return;
      a(paramList, 19);
    }
  }
  
  public static void a(List<BaseData> paramList, BaseData paramBaseData, ItemShowDispatcher paramItemShowDispatcher)
  {
    int k = 0;
    if ((paramList == null) || (paramBaseData == null)) {
      return;
    }
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < paramList.size())
      {
        if (paramBaseData.b((BaseData)paramList.get(i)))
        {
          j = 1;
          paramList.add(i, paramBaseData);
        }
      }
      else
      {
        if (j != 0) {
          break;
        }
        QLog.d("ItemDatasListUtils", 2, "insertForWeight, add in the end.");
        paramList.add(paramBaseData);
        return;
      }
      i += 1;
    }
  }
  
  public static void a(List<BaseData> paramList1, List<BaseData> paramList2)
  {
    Object localObject1 = new ArrayList();
    Object localObject2;
    if (paramList1 != null)
    {
      localObject2 = paramList1.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        BaseData localBaseData = (BaseData)((Iterator)localObject2).next();
        if ((localBaseData.s == 9) || (localBaseData.s == 10) || (localBaseData.s == 11) || (localBaseData.s == 17)) {
          ((List)localObject1).add(localBaseData);
        }
      }
      paramList1.removeAll((Collection)localObject1);
    }
    if ((paramList2 != null) && (paramList1 != null))
    {
      paramList2 = paramList2.iterator();
      label261:
      while (paramList2.hasNext())
      {
        localObject1 = (BaseData)paramList2.next();
        if ((((BaseData)localObject1).s == 10) || (((BaseData)localObject1).s == 11) || (((BaseData)localObject1).s == 17))
        {
          a(paramList1, (BaseData)localObject1, null);
        }
        else
        {
          if (((BaseData)localObject1).s == 22) {}
          for (int i = b(paramList1, (BaseData)localObject1);; i = a(paramList1, (BaseData)localObject1))
          {
            if (i <= 0) {
              break label261;
            }
            if (i < paramList1.size())
            {
              localObject2 = (BaseData)paramList1.get(i);
              if (((localObject2 instanceof RecommendTitleData)) && ((localObject1 instanceof ProteusBannerBigPicItemData))) {
                ((RecommendTitleData)localObject2).jdField_a_of_type_Boolean = ((ProteusBannerBigPicItemData)localObject1).f;
              }
            }
            paramList1.add(i, localObject1);
            break;
          }
        }
      }
    }
  }
  
  public static void a(List<BaseData> paramList1, List<BaseData> paramList2, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, SparseArray<Float> paramSparseArray, ItemShowDispatcher paramItemShowDispatcher)
  {
    Object localObject = new ArrayList();
    if (paramList1 != null)
    {
      Iterator localIterator = paramList1.iterator();
      while (localIterator.hasNext())
      {
        BaseData localBaseData = (BaseData)localIterator.next();
        if ((localBaseData.s == 7) || (localBaseData.s == 6) || (localBaseData.s == 8)) {
          ((List)localObject).add(localBaseData);
        }
      }
      paramList1.removeAll((Collection)localObject);
    }
    if (paramList2 != null)
    {
      paramList2 = new ArrayList(paramList2).iterator();
      while (paramList2.hasNext())
      {
        localObject = (BaseData)paramList2.next();
        ((BaseData)localObject).b = paramArticleInfo;
        ((BaseData)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo = paramFastWebArticleInfo;
        if ((localObject instanceof ProteusItemData)) {
          FastWebRequestUtil.a(paramArticleInfo, (ProteusItemData)localObject, 5, paramSparseArray);
        }
        a(paramList1, (BaseData)localObject, paramItemShowDispatcher);
      }
    }
  }
  
  public static void a(List<BaseData> paramList1, List<BaseData> paramList2, List<BaseData> paramList3, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, boolean paramBoolean, SparseArray<Float> paramSparseArray, ItemShowDispatcher paramItemShowDispatcher)
  {
    if ((paramList2 != null) && (!paramList2.isEmpty())) {
      a(paramList1, paramList2, paramArticleInfo, paramFastWebArticleInfo, paramSparseArray, paramItemShowDispatcher);
    }
    if (paramList3 != null)
    {
      if (!paramBoolean) {
        break label48;
      }
      b(paramList1, paramList3);
    }
    for (;;)
    {
      g(paramList1);
      h(paramList1);
      return;
      label48:
      a(paramList1, paramList3);
    }
  }
  
  public static void a(boolean paramBoolean, List<BaseData> paramList, FastWebArticleInfo paramFastWebArticleInfo, ArticleInfo paramArticleInfo)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (paramFastWebArticleInfo == null) || ((paramBoolean) && (paramFastWebArticleInfo.jdField_a_of_type_JavaUtilList == null))) {
      return;
    }
    int i = 0;
    int j = -1;
    if (i < paramList.size())
    {
      localObject = (BaseData)paramList.get(i);
      int k;
      if (FastWebPTSUtils.a((BaseData)localObject)) {
        k = i;
      }
      do
      {
        i += 1;
        j = k;
        break;
        k = j;
      } while (((BaseData)localObject).s != 15);
    }
    for (Object localObject = (ArticleTopicData)localObject;; localObject = null)
    {
      if (!paramBoolean)
      {
        if (localObject == null) {
          break;
        }
        paramList.remove(localObject);
        return;
      }
      if (localObject != null)
      {
        ((ArticleTopicData)localObject).jdField_a_of_type_JavaUtilList = paramFastWebArticleInfo.jdField_a_of_type_JavaUtilList;
        ((ArticleTopicData)localObject).b = paramArticleInfo;
        ((ArticleTopicData)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo = paramFastWebArticleInfo;
        ((ArticleTopicData)localObject).jdField_a_of_type_Boolean = false;
        return;
      }
      if (j == -1) {
        break;
      }
      localObject = new ArticleTopicData();
      ((ArticleTopicData)localObject).jdField_a_of_type_JavaUtilList = paramFastWebArticleInfo.jdField_a_of_type_JavaUtilList;
      ((ArticleTopicData)localObject).b = paramArticleInfo;
      ((ArticleTopicData)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo = paramFastWebArticleInfo;
      paramList.add(j + 1, localObject);
      return;
    }
  }
  
  private static int b(List<BaseData> paramList, BaseData paramBaseData)
  {
    int j = 0;
    if (paramBaseData.s == 22)
    {
      boolean bool = ((ProteusInnerData)paramBaseData).h();
      int n = ((ProteusInnerData)paramBaseData).y;
      int i = paramList.size() - 1;
      int k = 0;
      int m;
      if (i > 0)
      {
        paramBaseData = (BaseData)paramList.get(i);
        if ((!bool) && (n > 0))
        {
          m = k;
          if (!FastWebPTSUtils.a(paramBaseData)) {
            break label170;
          }
          m = k;
          if (paramBaseData.s == 0) {
            break label170;
          }
          k += 1;
          m = k;
          if (j != 0) {
            break label170;
          }
          m = i;
          j = k;
          k = m;
          label112:
          m = j;
          if (j != n) {
            break label156;
          }
        }
      }
      for (;;)
      {
        if ((i == -1) || (n <= 0) || (n > paramList.size())) {
          i = a(paramList);
        }
        return i;
        m = k;
        k = j;
        label156:
        i -= 1;
        j = k;
        k = m;
        break;
        label170:
        k = j;
        j = m;
        break label112;
        i = -1;
      }
    }
    return -1;
  }
  
  public static void b(List<BaseData> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((BaseData)localIterator.next()).s != 16);
      for (int i = 1; i == 0; i = 0)
      {
        paramList.add(new NoCommentPlaceHolderData());
        return;
      }
    }
  }
  
  public static void b(List<BaseData> paramList, BaseData paramBaseData, ItemShowDispatcher paramItemShowDispatcher)
  {
    if ((paramList == null) || (paramBaseData == null)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      BaseData localBaseData = (BaseData)localIterator.next();
      if (localBaseData.s == 23) {
        localArrayList.add(localBaseData);
      }
    }
    paramList.removeAll(localArrayList);
    a(paramList, paramBaseData, paramItemShowDispatcher);
  }
  
  public static void b(List<BaseData> paramList1, List<BaseData> paramList2)
  {
    Object localObject = new ArrayList();
    if (paramList1 != null)
    {
      Iterator localIterator = paramList1.iterator();
      while (localIterator.hasNext())
      {
        BaseData localBaseData = (BaseData)localIterator.next();
        if (localBaseData.s == 22) {
          ((List)localObject).add(localBaseData);
        }
      }
      paramList1.removeAll((Collection)localObject);
    }
    if (paramList2 != null)
    {
      paramList2 = paramList2.iterator();
      while (paramList2.hasNext())
      {
        localObject = (BaseData)paramList2.next();
        if (((BaseData)localObject).s == 22) {}
        for (int i = b(paramList1, (BaseData)localObject);; i = a(paramList1, (BaseData)localObject))
        {
          if (i <= 0) {
            break label151;
          }
          if (i > paramList1.size() - 1) {
            break label153;
          }
          paramList1.add(i, localObject);
          break;
        }
        label151:
        continue;
        label153:
        paramList1.add(localObject);
      }
    }
  }
  
  public static void c(List<BaseData> paramList)
  {
    if (paramList == null) {}
    BaseData localBaseData;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = paramList.iterator();
      }
      localBaseData = (BaseData)localIterator.next();
    } while (localBaseData.s != 16);
    paramList.remove(localBaseData);
  }
  
  public static void c(List<BaseData> paramList, List<CommentInfo> paramList1)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (paramList1 == null) || (paramList1.isEmpty())) {
      return;
    }
    HashMap localHashMap = new HashMap();
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      CommentInfo localCommentInfo = (CommentInfo)paramList1.next();
      localHashMap.put(localCommentInfo.commentId, localCommentInfo);
    }
    int j = 0;
    int i = 0;
    if (j < paramList.size())
    {
      paramList1 = (BaseData)paramList.get(j);
      if (paramList1.s != 12) {
        break label192;
      }
      paramList1 = (CommentData)paramList1;
      if (!localHashMap.containsKey(paramList1.a.commentId)) {
        break label192;
      }
      paramList1.a = ((CommentInfo)localHashMap.get(paramList1.a.commentId));
      i += 1;
    }
    label192:
    for (;;)
    {
      j += 1;
      break;
      QLog.d(ItemDatasListUtils.class.getSimpleName(), 2, "update comment data! size : " + i);
      return;
    }
  }
  
  public static void d(List<BaseData> paramList)
  {
    if (paramList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      BaseData localBaseData = (BaseData)localIterator.next();
      if (localBaseData.s == 22) {
        localArrayList.add(localBaseData);
      }
    }
    paramList.removeAll(localArrayList);
  }
  
  public static void e(List<BaseData> paramList)
  {
    if (paramList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      BaseData localBaseData = (BaseData)localIterator.next();
      if (localBaseData.s == 17) {
        localArrayList.add(localBaseData);
      }
    }
    paramList.removeAll(localArrayList);
  }
  
  public static void f(List<BaseData> paramList)
  {
    if (paramList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      BaseData localBaseData = (BaseData)localIterator.next();
      if ((localBaseData.s == 26) && ((localBaseData instanceof ProteusItemData)))
      {
        ProteusItemData localProteusItemData = (ProteusItemData)localBaseData;
        if ((localProteusItemData.c != null) && (TextUtils.equals(localProteusItemData.c.optString("style_ID", ""), "readinjoy_native_tag"))) {
          localArrayList.add(localBaseData);
        }
      }
    }
    paramList.removeAll(localArrayList);
  }
  
  private static void g(List<BaseData> paramList)
  {
    if (paramList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    int i = 0;
    label22:
    BaseData localBaseData;
    if (localIterator.hasNext())
    {
      localBaseData = (BaseData)localIterator.next();
      if ((localBaseData.s == 10) || (localBaseData.s == 17)) {
        localArrayList.add(localBaseData);
      }
    }
    for (;;)
    {
      break label22;
      if ((localBaseData.s == 22) && (((ProteusInnerData)localBaseData).h()))
      {
        i = 1;
        continue;
        if (i == 0) {
          break;
        }
        paramList.removeAll(localArrayList);
        return;
      }
    }
  }
  
  private static void h(List<BaseData> paramList)
  {
    if (paramList == null) {}
    label73:
    for (;;)
    {
      return;
      int i = 0;
      Object localObject;
      if (i < paramList.size())
      {
        localObject = (BaseData)paramList.get(i);
        if (((BaseData)localObject).s == 16)
        {
          localObject = (NoCommentPlaceHolderData)localObject;
          paramList.remove(i);
        }
      }
      for (;;)
      {
        if (localObject == null) {
          break label73;
        }
        paramList.add(localObject);
        return;
        i += 1;
        break;
        localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ItemDatasListUtils
 * JD-Core Version:    0.7.0.1
 */