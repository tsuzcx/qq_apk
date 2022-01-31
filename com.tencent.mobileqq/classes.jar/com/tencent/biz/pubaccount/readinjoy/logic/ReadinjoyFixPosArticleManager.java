package com.tencent.biz.pubaccount.readinjoy.logic;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import lrf;
import lrg;
import mqq.os.MqqHandler;

public class ReadinjoyFixPosArticleManager
{
  private static volatile ReadinjoyFixPosArticleManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadinjoyFixPosArticleManager;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private lrg jdField_a_of_type_Lrg = new lrg(this, 1);
  
  private int a(int paramInt1, List paramList, int paramInt2)
  {
    paramInt1 = 0;
    while (paramInt1 < paramList.size())
    {
      if (paramInt2 == 0)
      {
        paramList = (BaseArticleInfo)paramList.get(paramInt1);
        paramInt2 = paramInt1;
        if (paramList != null)
        {
          paramInt2 = paramInt1;
          if (paramList.mGroupId != -1L)
          {
            paramInt2 = paramInt1;
            if (paramList.mGroupCount != 1L)
            {
              QLog.d("ReadinjoyFixPosArticleManager", 2, "position " + paramInt1 + " is group article , groupCount : " + paramList.mGroupCount + ", nowGroupIndex : " + paramList.mFeedIndexInGroup + ", groupID : " + paramList.mGroupId);
              paramInt2 = paramInt1 + (int)(paramList.mGroupCount - paramList.mFeedIndexInGroup);
            }
          }
        }
        return paramInt2;
      }
      paramInt2 -= 1;
      paramInt1 += 1;
    }
    return -1;
  }
  
  private static int a(long paramLong)
  {
    return (int)(-paramLong & 0xFFFFFFFF);
  }
  
  public static ReadinjoyFixPosArticleManager a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadinjoyFixPosArticleManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadinjoyFixPosArticleManager == null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadinjoyFixPosArticleManager = new ReadinjoyFixPosArticleManager();
      }
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadinjoyFixPosArticleManager;
    }
    finally {}
  }
  
  public static boolean a(long paramLong)
  {
    return paramLong <= 0L;
  }
  
  private static long b(int paramInt1, int paramInt2)
  {
    return -(paramInt1 << 32 | paramInt2);
  }
  
  private void b(int paramInt)
  {
    QLog.d("ReadinjoyFixPosArticleManager", 1, "on async data refresh , channelID  : " + paramInt);
    ReadInJoyBaseAdapter localReadInJoyBaseAdapter = (ReadInJoyBaseAdapter)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if ((localReadInJoyBaseAdapter == null) || (localReadInJoyBaseAdapter.isEmpty())) {}
    ArrayList localArrayList;
    Object localObject;
    do
    {
      return;
      localArrayList = new ArrayList();
      localObject = localReadInJoyBaseAdapter.a().iterator();
      while (((Iterator)localObject).hasNext())
      {
        BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)((Iterator)localObject).next();
        if (!a(Long.valueOf(localBaseArticleInfo.mRecommendSeq).longValue())) {
          localArrayList.add(localBaseArticleInfo);
        }
      }
      localObject = a(paramInt, localArrayList, localArrayList, 3);
    } while (localObject == localArrayList);
    ThreadManager.getUIHandler().post(new lrf(this, localReadInJoyBaseAdapter, (List)localObject));
  }
  
  public ArticleInfo a(int paramInt, long paramLong)
  {
    return (ArticleInfo)this.jdField_a_of_type_Lrg.a(paramInt, a(paramLong));
  }
  
  public List a(int paramInt1, List paramList1, List paramList2, int paramInt2)
  {
    if (paramList1 == null) {
      return null;
    }
    if (paramInt2 != 2) {
      this.jdField_a_of_type_Lrg.a(paramInt1);
    }
    if (!this.jdField_a_of_type_Lrg.a(paramInt1))
    {
      QLog.d("ReadinjoyFixPosArticleManager", 1, "has no fix article , give up insert !");
      return paramList1;
    }
    QLog.d("ReadinjoyFixPosArticleManager", 1, "insertFixPosArticles type : " + paramInt2 + ", channelID : " + paramInt1);
    int j;
    if (paramInt2 == 2)
    {
      paramInt2 = 0;
      if (paramInt2 < paramList2.size())
      {
        long l = ((BaseArticleInfo)paramList2.get(paramInt2)).mRecommendSeq;
        if (!a(l)) {}
        for (;;)
        {
          paramInt2 += 1;
          break;
          i = a(l);
          j = paramInt2 - i;
          localArrayList1 = (ArrayList)this.jdField_a_of_type_Lrg.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
          localArrayList2 = (ArrayList)this.jdField_a_of_type_Lrg.b.get(Integer.valueOf(paramInt1));
          if ((localArrayList1 != null) && (localArrayList2 != null))
          {
            int k = localArrayList1.indexOf(Integer.valueOf(i));
            if (k >= 0)
            {
              localArrayList2.set(k, Integer.valueOf(j));
              QLog.d("ReadinjoyFixPosArticleManager", 1, "fix offset when loadMore, expect : " + i + ", now : " + paramInt2 + ", offset : " + j);
            }
          }
        }
      }
    }
    paramList2 = (ArrayList)this.jdField_a_of_type_Lrg.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
    ArrayList localArrayList1 = (ArrayList)this.jdField_a_of_type_Lrg.b.get(Integer.valueOf(paramInt1));
    ArrayList localArrayList2 = (ArrayList)this.jdField_a_of_type_Lrg.c.get(Integer.valueOf(paramInt1));
    if ((paramList2 == null) || (localArrayList1 == null) || (localArrayList2 == null))
    {
      QLog.d("ReadinjoyFixPosArticleManager", 1, "ad article or positions is empty ! return ori data ");
      return paramList1;
    }
    ArrayList localArrayList3 = new ArrayList(paramList1);
    int i = Math.min(paramList2.size(), localArrayList2.size());
    paramInt2 = 0;
    if (paramInt2 < i)
    {
      j = ((Integer)paramList2.get(paramInt2)).intValue();
      j = ((Integer)localArrayList1.get(paramInt2)).intValue() + j;
      if (paramList1.size() < j + 1) {
        QLog.d("ReadinjoyFixPosArticleManager", 1, "expect insert into " + j + ", but article size is not enough");
      }
      for (;;)
      {
        paramInt2 += 1;
        break;
        j = a(paramInt1, localArrayList3, j);
        if (j == -1)
        {
          QLog.d("ReadinjoyFixPosArticleManager", 1, "find real position is error ! ");
        }
        else
        {
          QLog.d("ReadinjoyFixPosArticleManager", 1, "insert article , position : " + j + ", expectIndex : " + paramList2.get(paramInt2) + ", fakeSeq : " + b(1, ((Integer)paramList2.get(paramInt2)).intValue()));
          localArrayList3.add(j, ReadInJoyLogicEngine.a().a(paramInt1, b(1, ((Integer)paramList2.get(paramInt2)).intValue())));
        }
      }
    }
    return localArrayList3;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt));
    this.jdField_a_of_type_Lrg.d(paramInt);
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (!a(paramLong)) {
      return;
    }
    int i = a(paramLong);
    this.jdField_a_of_type_Lrg.a(paramInt, i);
  }
  
  public void a(int paramInt, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), paramReadInJoyBaseAdapter);
    this.jdField_a_of_type_Lrg.c(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.logic.ReadinjoyFixPosArticleManager
 * JD-Core Version:    0.7.0.1
 */