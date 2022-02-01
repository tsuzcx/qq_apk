package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.res.Configuration;
import android.support.annotation.UiThread;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.pubaccount.readinjoy.channelbanner.RIJChannelBannerModule.ChannelBannerInfo;
import com.tencent.biz.pubaccount.readinjoy.feedsinsert.RIJFeedsInsertController.IInsertArticleCallback;
import com.tencent.biz.pubaccount.readinjoy.model.ColumnInfoForSelfPage;
import com.tencent.biz.pubaccount.readinjoy.model.DiandianTopConfig;
import com.tencent.biz.pubaccount.readinjoy.model.RIJCoinInfoModule.UserCoinInfo;
import com.tencent.biz.pubaccount.readinjoy.model.RIJCommentReportModule.CommentReportInfo;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.FollowingMember;
import com.tencent.biz.pubaccount.readinjoy.struct.InterestLabelInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KingMomentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import com.tencent.biz.pubaccount.subscript.SubscriptionFeed;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyTabObserver;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import tencent.im.oidb.cmd0xbd6.oidb_cmd0xbd6.RspBody;

public class ReadInJoyLogicEngineEventDispatcher
{
  private static ReadInJoyLogicEngineEventDispatcher jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngineEventDispatcher = null;
  private final CopyOnWriteArrayList<ReadInJoyObserver> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  
  public static ReadInJoyLogicEngineEventDispatcher a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngineEventDispatcher == null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngineEventDispatcher = new ReadInJoyLogicEngineEventDispatcher();
      }
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngineEventDispatcher;
    }
    finally {}
  }
  
  public void a()
  {
    ??? = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    ReadInJoyObserver localReadInJoyObserver;
    do
    {
      if (!((Iterator)???).hasNext()) {
        break;
      }
      localReadInJoyObserver = (ReadInJoyObserver)((Iterator)???).next();
    } while (!(localReadInJoyObserver instanceof ReadInJoyTabObserver));
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
      {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
        if (localReadInJoyObserver != null) {
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localReadInJoyObserver);
        }
        return;
      }
      Object localObject2 = null;
    }
  }
  
  public void a(float paramFloat, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramFloat, paramInt);
      }
    }
  }
  
  public void a(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).f(paramInt);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramInt1, paramInt2);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramInt1, paramInt2, paramInt3);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, ColumnInfoForSelfPage paramColumnInfoForSelfPage)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramInt1, paramInt2, paramInt3, paramBoolean, paramColumnInfoForSelfPage);
      }
    }
  }
  
  public void a(int paramInt, long paramLong, String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramInt, paramLong, paramString);
      }
    }
  }
  
  public void a(int paramInt1, long paramLong, String paramString1, int paramInt2, String paramString2, String paramString3)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramInt1, paramLong, paramString1, paramInt2, paramString2, paramString3);
      }
    }
  }
  
  public void a(int paramInt1, long paramLong, List<Long> paramList, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramInt1, paramLong, paramList, paramInt2, paramInt3, paramBoolean);
      }
    }
  }
  
  public void a(int paramInt, SelectPositionModule.PositionData paramPositionData)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList).iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramInt, paramPositionData);
      }
    }
  }
  
  public void a(int paramInt, ArticleInfo paramArticleInfo, String paramString1, String paramString2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramInt, paramArticleInfo, paramString1, paramString2);
      }
    }
  }
  
  public void a(int paramInt, KingMomentInfo paramKingMomentInfo)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramInt, paramKingMomentInfo);
      }
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramInt, paramObject);
      }
    }
  }
  
  public void a(int paramInt, List<Long> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramInt, paramList);
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean, List<ChannelCoverInfo> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramInt, paramBoolean, paramList);
      }
    }
  }
  
  public void a(long paramLong, int paramInt, String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramLong, paramInt, paramString);
      }
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramLong, paramBoolean);
      }
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramConfiguration);
      }
    }
  }
  
  public void a(View paramView)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramView);
      }
    }
  }
  
  public void a(@NonNull RIJXTabRedDotInfo paramRIJXTabRedDotInfo)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramRIJXTabRedDotInfo);
      }
    }
  }
  
  public void a(ReadInJoyLogicEngineEventDispatcher.ForEachObserverJob paramForEachObserverJob)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        paramForEachObserverJob.a((ReadInJoyObserver)localIterator.next());
      }
    }
  }
  
  public void a(ReadInJoyObserver paramReadInJoyObserver)
  {
    if (paramReadInJoyObserver == null) {}
    while (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramReadInJoyObserver)) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramReadInJoyObserver);
      return;
    }
  }
  
  public void a(ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramArticleInfo, paramBoolean);
      }
    }
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramBaseArticleInfo);
      }
    }
  }
  
  public void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList).iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramTabChannelCoverInfo);
      }
    }
  }
  
  public void a(TopBannerInfo paramTopBannerInfo)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramTopBannerInfo);
      }
    }
  }
  
  public void a(AbsListView paramAbsListView)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramAbsListView);
      }
    }
  }
  
  public void a(Long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramLong);
      }
    }
  }
  
  public void a(Object paramObject, int paramInt, boolean paramBoolean, String... paramVarArgs)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramObject, paramInt, paramBoolean, paramVarArgs);
      }
    }
  }
  
  public void a(String paramString)
  {
    a(new ReadInJoyLogicEngineEventDispatcher.1(this, paramString));
  }
  
  public void a(String paramString, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).e(paramString, paramInt);
      }
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramString, paramInt1, paramInt2);
      }
    }
  }
  
  public void a(String paramString1, int paramInt1, long paramLong, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramString1, paramInt1, paramLong, paramString2, paramInt2, paramString3, paramString4);
      }
    }
  }
  
  public void a(String paramString1, int paramInt, oidb_cmd0xbd6.RspBody paramRspBody, String paramString2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramString1, paramInt, paramRspBody, paramString2);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).b(paramString1, paramString2, paramInt);
      }
    }
  }
  
  public void a(String paramString, List<ArticleInfo> paramList, RIJFeedsInsertController.IInsertArticleCallback paramIInsertArticleCallback)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramString, paramList, paramIInsertArticleCallback);
      }
    }
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramArrayList);
      }
    }
  }
  
  public void a(List<InterestLabelInfo> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).b(paramList);
      }
    }
  }
  
  public void a(List<String> paramList, List<TopicInfo> paramList1)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramList, paramList1);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).d(paramBoolean);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, List<Long> paramList, List<ArticleInfo> paramList1)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramBoolean, paramInt, paramLong, paramList, paramList1);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, SparseArray<ChannelInfo> paramSparseArray)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramBoolean, paramInt, paramSparseArray);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramBoolean, paramInt, paramString);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString, RIJCoinInfoModule.UserCoinInfo paramUserCoinInfo)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramBoolean, paramInt, paramString, paramUserCoinInfo);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString, RIJCommentReportModule.CommentReportInfo paramCommentReportInfo)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramBoolean, paramInt, paramString, paramCommentReportInfo);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramBoolean, paramInt1, paramString1, paramString2, paramInt2);
      }
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, String paramString1, String paramString2, boolean paramBoolean2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramBoolean1, paramInt, paramString1, paramString2, paramBoolean2);
      }
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramBoolean1, paramInt, paramList, paramBoolean2);
      }
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, List<RecommendFollowInfo> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramBoolean, paramLong, paramList);
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    try
    {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        if (localIterator.hasNext()) {
          ((ReadInJoyObserver)localIterator.next()).a(paramBoolean, paramString);
        }
      }
    }
    finally {}
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramBoolean, paramString1, paramString2, paramString3, paramInt1, paramInt2);
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2, String paramString5)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramBoolean, paramString1, paramString2, paramString3, paramInt1, paramString4, paramInt2, paramString5);
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramBoolean, paramString1, paramString2, paramString3, paramString4, paramInt);
      }
    }
  }
  
  public void a(boolean paramBoolean, List<DiandianTopConfig> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).d(paramBoolean, paramList);
      }
    }
  }
  
  @Deprecated
  public void a(boolean paramBoolean1, List<FollowingMember> paramList, long paramLong, boolean paramBoolean2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).b(paramBoolean1, paramList, paramLong, paramBoolean2);
      }
    }
  }
  
  public void a(boolean paramBoolean, List<Long> paramList, List<ArticleInfo> paramList1)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramBoolean, paramList, paramList1);
      }
    }
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).c();
      }
    }
  }
  
  public void b(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).b(paramInt);
      }
    }
  }
  
  public void b(int paramInt, List<Long> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).c(paramInt, paramList);
      }
    }
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).b(paramLong, paramBoolean);
      }
    }
  }
  
  public void b(ReadInJoyObserver paramReadInJoyObserver)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramReadInJoyObserver);
      return;
    }
  }
  
  public void b(String paramString)
  {
    a(new ReadInJoyLogicEngineEventDispatcher.2(this, paramString));
  }
  
  public void b(String paramString, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).f(paramString, paramInt);
      }
    }
  }
  
  public void b(List<SubscriptionFeed> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a_(paramList);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList).iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).b(paramBoolean);
      }
    }
  }
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).b(paramBoolean1, paramInt, paramList, paramBoolean2);
      }
    }
  }
  
  public void b(boolean paramBoolean, List<ChannelInfo> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).e(paramBoolean, paramList);
      }
    }
  }
  
  public void b(boolean paramBoolean1, List<FollowingMember> paramList, long paramLong, boolean paramBoolean2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramBoolean1, paramList, paramLong, paramBoolean2);
      }
    }
  }
  
  public void c()
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).aj_();
      }
    }
  }
  
  public void c(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).c(paramInt);
      }
    }
  }
  
  public void c(int paramInt, List<Long> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).b(paramInt, paramList);
      }
    }
  }
  
  public void c(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramString);
      }
    }
  }
  
  public void c(String paramString, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).g(paramString, paramInt);
      }
    }
  }
  
  public void c(List<TagInfo> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).c(paramList);
      }
    }
  }
  
  @UiThread
  public void c(boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramBoolean);
      }
    }
  }
  
  public void c(boolean paramBoolean, List<ChannelInfo> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).f(paramBoolean, paramList);
      }
    }
  }
  
  public void c(boolean paramBoolean1, List<FollowingMember> paramList, long paramLong, boolean paramBoolean2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).c(paramBoolean1, paramList, paramLong, paramBoolean2);
      }
    }
  }
  
  public void d()
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).i();
      }
    }
  }
  
  public void d(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).h(paramInt);
      }
    }
  }
  
  public void d(int paramInt, List<RIJChannelBannerModule.ChannelBannerInfo> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).d(paramInt, paramList);
      }
    }
  }
  
  public void d(boolean paramBoolean, List<Integer> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).g(paramBoolean, paramList);
      }
    }
  }
  
  public void e()
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).z_();
      }
    }
  }
  
  public void e(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).i(paramInt);
      }
    }
  }
  
  public void e(boolean paramBoolean, List<TabChannelCoverInfo> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList).iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramBoolean, paramList);
      }
    }
  }
  
  public void f()
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).o();
      }
    }
  }
  
  public void f(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).d(paramInt);
      }
    }
  }
  
  public void f(boolean paramBoolean, List<ChannelCoverInfo> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).b(paramBoolean, paramList);
      }
    }
  }
  
  public void g()
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).j();
      }
    }
  }
  
  public void g(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).g(paramInt);
      }
    }
  }
  
  public void g(boolean paramBoolean, List<ChannelCoverInfo> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).c(paramBoolean, paramList);
      }
    }
  }
  
  public void h()
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).k();
      }
    }
  }
  
  public void h(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList).iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).f_(paramInt);
      }
    }
  }
  
  public void h(boolean paramBoolean, List<ChannelCoverInfo> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).h(paramBoolean, paramList);
      }
    }
  }
  
  public void i()
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).l();
      }
    }
  }
  
  public void j()
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).m();
      }
    }
  }
  
  public void k()
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).n();
      }
    }
  }
  
  public void l()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      ((ReadInJoyObserver)localIterator.next()).p();
    }
  }
  
  public void m()
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).q();
      }
    }
  }
  
  public void n()
  {
    try
    {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        if (localIterator.hasNext()) {
          ((ReadInJoyObserver)localIterator.next()).b();
        }
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher
 * JD-Core Version:    0.7.0.1
 */