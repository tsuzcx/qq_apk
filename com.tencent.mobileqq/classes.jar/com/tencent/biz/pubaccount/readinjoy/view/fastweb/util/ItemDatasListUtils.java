package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import com.tencent.biz.pubaccount.readinjoy.comment.CommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ArticleTopicData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.CommentHeaderData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.CommonBottomData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RecommendAdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RecommendData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RecommendTitleData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ItemDatasListUtils
{
  private static int a(List paramList, BaseData paramBaseData)
  {
    int i = 2;
    if (paramBaseData.d == 9) {
      i = ((RecommendAdData)paramBaseData).e;
    }
    int j = 0;
    int k = i;
    i = j;
    BaseData localBaseData;
    if (i < paramList.size())
    {
      localBaseData = (BaseData)paramList.get(i);
      if ((paramBaseData.d == 10) || (paramBaseData.d == 11))
      {
        j = k;
        if (localBaseData.d != 7) {
          break label150;
        }
      }
    }
    for (;;)
    {
      j = i;
      if (i == -1) {
        if (paramBaseData.d != 10)
        {
          j = i;
          if (paramBaseData.d != 11) {}
        }
        else
        {
          j = paramList.size();
        }
      }
      return j;
      j = k;
      if (localBaseData.d == 6)
      {
        k -= 1;
        j = k;
        if (k == 1)
        {
          i += 1;
          continue;
        }
      }
      label150:
      i += 1;
      k = j;
      break;
      i = -1;
    }
  }
  
  public static List a(List paramList)
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
  
  private static List a(List paramList, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    boolean bool = false;
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.isEmpty())) {
      return localArrayList;
    }
    localArrayList.add(new CommentHeaderData("热门评论"));
    int i = 0;
    for (;;)
    {
      if ((i >= paramList.size()) || (i >= 5))
      {
        if (!localArrayList.isEmpty())
        {
          localObject = new CommonBottomData(14);
          ((CommonBottomData)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
          ((CommonBottomData)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo = paramFastWebArticleInfo;
          if (paramList.size() > 5) {
            bool = true;
          }
          ((CommonBottomData)localObject).b = bool;
          localArrayList.add(localObject);
        }
        return localArrayList;
      }
      Object localObject = new CommentData();
      ((CommentData)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentCommentInfo = ((CommentInfo)paramList.get(i));
      ((CommentData)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
      ((CommentData)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo = paramFastWebArticleInfo;
      localArrayList.add(localObject);
      i += 1;
    }
  }
  
  public static List a(List paramList1, List paramList2, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if ((paramList1 == null) || (paramList2 == null) || (paramList2.isEmpty())) {}
    for (;;)
    {
      return paramList1;
      paramList2 = a(paramList2, paramArticleInfo, paramFastWebArticleInfo);
      if ((paramList2 != null) && (!paramList2.isEmpty()))
      {
        paramArticleInfo = new ArrayList();
        int i = 0;
        while (i < paramList1.size())
        {
          if ((((BaseData)paramList1.get(i)).d == 14) || (((BaseData)paramList1.get(i)).d == 12) || (((BaseData)paramList1.get(i)).d == 13)) {
            paramArticleInfo.add(paramList1.get(i));
          }
          i += 1;
        }
        paramList1.removeAll(paramArticleInfo);
        paramList1.addAll(paramList2);
        i = 0;
        while (i < paramList1.size())
        {
          if (((BaseData)paramList1.get(i)).d == 8)
          {
            ((CommonBottomData)paramList1.get(i)).jdField_a_of_type_Boolean = false;
            return paramList1;
          }
          i += 1;
        }
      }
    }
  }
  
  public static void a(List paramList)
  {
    Object localObject = paramList.iterator();
    int j = 0;
    if (((Iterator)localObject).hasNext()) {
      if (((BaseData)((Iterator)localObject).next()).d != 6) {
        break label141;
      }
    }
    label141:
    for (int i = j + 1;; i = j)
    {
      j = i;
      break;
      paramList = paramList.iterator();
      i = 1;
      if (paramList.hasNext())
      {
        localObject = (BaseData)paramList.next();
        switch (((BaseData)localObject).d)
        {
        }
        for (;;)
        {
          break;
          localObject = (RecommendData)localObject;
          ((RecommendData)localObject).b = i;
          ((RecommendData)localObject).c = j;
          i += 1;
          continue;
          i += 1;
        }
      }
      return;
    }
  }
  
  public static void a(List paramList1, List paramList2)
  {
    Object localObject = new ArrayList();
    Iterator localIterator = paramList1.iterator();
    while (localIterator.hasNext())
    {
      BaseData localBaseData = (BaseData)localIterator.next();
      if ((localBaseData.d == 9) || (localBaseData.d == 10) || (localBaseData.d == 11)) {
        ((List)localObject).add(localBaseData);
      }
    }
    paramList1.removeAll((Collection)localObject);
    paramList2 = paramList2.iterator();
    while (paramList2.hasNext())
    {
      localObject = (BaseData)paramList2.next();
      int i = a(paramList1, (BaseData)localObject);
      if (i > 0) {
        paramList1.add(i, localObject);
      }
    }
  }
  
  public static void a(List paramList1, List paramList2, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramList1.iterator();
    while (((Iterator)localObject).hasNext())
    {
      BaseData localBaseData = (BaseData)((Iterator)localObject).next();
      if ((localBaseData.d == 7) || (localBaseData.d == 6) || (localBaseData.d == 8)) {
        localArrayList.add(localBaseData);
      }
    }
    paramList1.removeAll(localArrayList);
    paramList1.add(new RecommendTitleData("相关阅读"));
    localArrayList = new ArrayList();
    int i = 0;
    while ((i < 6) && (i < paramList2.size()))
    {
      localArrayList.add(paramList2.get(i));
      i += 1;
    }
    paramList2 = localArrayList.iterator();
    while (paramList2.hasNext())
    {
      localObject = (BaseData)paramList2.next();
      ((BaseData)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
      ((BaseData)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo = paramFastWebArticleInfo;
    }
    ((RecommendData)localArrayList.get(localArrayList.size() - 1)).jdField_a_of_type_Boolean = true;
    paramList1.addAll(localArrayList);
    paramList1.add(new CommonBottomData(8));
  }
  
  public static void a(List paramList1, List paramList2, List paramList3, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if ((paramList2 != null) && (!paramList2.isEmpty())) {
      a(paramList1, paramList2, paramArticleInfo, paramFastWebArticleInfo);
    }
    if (paramList3 != null) {
      a(paramList1, paramList3);
    }
    b(paramList1);
  }
  
  public static void a(boolean paramBoolean, List paramList, FastWebArticleInfo paramFastWebArticleInfo, ArticleInfo paramArticleInfo)
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
      if (((BaseData)localObject).a()) {
        k = i;
      }
      do
      {
        i += 1;
        j = k;
        break;
        k = j;
      } while (((BaseData)localObject).d != 15);
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
        ((ArticleTopicData)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
        ((ArticleTopicData)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo = paramFastWebArticleInfo;
        ((ArticleTopicData)localObject).jdField_a_of_type_Boolean = false;
        return;
      }
      if (j == -1) {
        break;
      }
      localObject = new ArticleTopicData();
      ((ArticleTopicData)localObject).jdField_a_of_type_JavaUtilList = paramFastWebArticleInfo.jdField_a_of_type_JavaUtilList;
      ((ArticleTopicData)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
      ((ArticleTopicData)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo = paramFastWebArticleInfo;
      paramList.add(j + 1, localObject);
      return;
    }
  }
  
  private static List b(List paramList)
  {
    Object localObject = null;
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      BaseData localBaseData = (BaseData)paramList.get(i);
      if ((localBaseData.d == 12) || (localBaseData.d == 13) || (localBaseData.d == 14)) {
        localArrayList.add(localBaseData);
      }
      for (;;)
      {
        i += 1;
        break;
        if (localBaseData.d == 8) {
          localObject = localBaseData;
        }
      }
    }
    if ((localArrayList.size() > 0) && (localObject != null)) {
      ((CommonBottomData)localObject).jdField_a_of_type_Boolean = false;
    }
    paramList.removeAll(localArrayList);
    paramList.addAll(localArrayList);
    return paramList;
  }
  
  public static void b(List paramList1, List paramList2)
  {
    if ((paramList1 == null) || (paramList1.isEmpty()) || (paramList2 == null) || (paramList2.isEmpty())) {
      return;
    }
    HashMap localHashMap = new HashMap();
    paramList2 = paramList2.iterator();
    while (paramList2.hasNext())
    {
      CommentInfo localCommentInfo = (CommentInfo)paramList2.next();
      localHashMap.put(localCommentInfo.commentId, localCommentInfo);
    }
    int j = 0;
    int i = 0;
    if (j < paramList1.size())
    {
      paramList2 = (BaseData)paramList1.get(j);
      if (paramList2.d != 12) {
        break label192;
      }
      paramList2 = (CommentData)paramList2;
      if (!localHashMap.containsKey(paramList2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentCommentInfo.commentId)) {
        break label192;
      }
      paramList2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentCommentInfo = ((CommentInfo)localHashMap.get(paramList2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentCommentInfo.commentId));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ItemDatasListUtils
 * JD-Core Version:    0.7.0.1
 */