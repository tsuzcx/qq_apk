package com.tencent.biz.pubaccount.readinjoy.comment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.annotation.VisibleForTesting;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix.RIJBiuAndCommentAladdinUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentViewItem;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.CommentAnchor;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.OnCommentListLoadListener;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.guide.GuideHelper;
import com.tencent.biz.pubaccount.readinjoy.common.ProteusSupportUtil;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.proteus.wrap.ReadInjoyContext;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.FastWebMergeAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.WebFastAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.biz.pubaccount.readinjoyAd.ad.multiVideo.NegativeHelper;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import com.tencent.widget.HeaderViewListAdapter;
import com.tencent.widget.ListView;
import com.tencent.widget.TraceUtils;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ReadInJoyCommentListAdapter
  extends ReadinjoyCommentListBaseAdapter
  implements ReadInJoyCommentListView.RefreshCallback
{
  public static int a;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ICommentNumChangedListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentICommentNumChangedListener;
  private ReadInJoyCommentListFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment;
  private ReadInJoyCommentUtils.CommentListListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$CommentListListener;
  private ReadInJoyCommentDataManager.OnCommentListLoadListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager$OnCommentListLoadListener;
  public int b;
  private int d;
  private int e = -1;
  private int f = -1;
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  public ReadInJoyCommentListAdapter(FragmentActivity paramFragmentActivity, ReadInJoyCommentListFragment paramReadInJoyCommentListFragment, ReadInJoyCommentListView paramReadInJoyCommentListView, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramFragmentActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramFragmentActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment = paramReadInJoyCommentListFragment;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$CommentListListener = paramReadInJoyCommentListFragment;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView = paramReadInJoyCommentListView;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setRefreshCallback(this);
    this.d = paramInt;
    jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDynamicCommentProteusHelper = new DynamicCommentProteusHelper();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDynamicCommentProteusHelper.a(a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentItemHeightHelper = new ReadInJoyCommentItemHeightHelper(paramReadInJoyCommentListView, this.jdField_a_of_type_JavaUtilList, this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMultiVideoNegativeHelper = new NegativeHelper(paramFragmentActivity, null);
    paramReadInJoyCommentListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
  }
  
  public ReadInJoyCommentListAdapter(FastWebActivity paramFastWebActivity, ReadInJoyCommentListView paramReadInJoyCommentListView, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramFastWebActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramFastWebActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$CommentListListener = paramFastWebActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView = paramReadInJoyCommentListView;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setRefreshCallback(this);
    this.d = paramInt;
    jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDynamicCommentProteusHelper = new DynamicCommentProteusHelper();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDynamicCommentProteusHelper.a(a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentItemHeightHelper = new ReadInJoyCommentItemHeightHelper(paramReadInJoyCommentListView, this.jdField_a_of_type_JavaUtilList, this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMultiVideoNegativeHelper = new NegativeHelper(paramFastWebActivity, null);
    paramReadInJoyCommentListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
  }
  
  private void a(List<CommentViewItem> paramList)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.a() == null) {}
    for (;;)
    {
      return;
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.a();
      if ((((ReadInJoyCommentDataManager.CommentAnchor)localObject).jdField_a_of_type_Boolean) && (((ReadInJoyCommentDataManager.CommentAnchor)localObject).b != null) && (paramList != null))
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (CommentViewItem)paramList.next();
          if ((localObject != null) && (((CommentViewItem)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null) && (((CommentViewItem)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAnchor)) {
            ((CommentViewItem)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAnchor = false;
          }
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int i = 0;
    View localView;
    if ((paramBoolean) && (a() != null))
    {
      this.e = a().getFirstVisiblePosition();
      localView = a().getChildAt(0);
      if (localView != null) {
        break label43;
      }
    }
    for (;;)
    {
      this.f = i;
      return;
      label43:
      i = localView.getTop();
    }
  }
  
  private void b(List<CommentViewItem> paramList)
  {
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      CommentViewItem localCommentViewItem = (CommentViewItem)paramList.next();
      Object localObject = localCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      if (localObject != null)
      {
        localObject = ((BaseCommentData)localObject).commentId;
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          if (!localHashSet.contains(localObject))
          {
            this.jdField_a_of_type_JavaUtilList.add(localCommentViewItem);
            localHashSet.add(localObject);
          }
        }
      }
      for (;;)
      {
        break;
        i = 1;
        continue;
        this.jdField_a_of_type_JavaUtilList.add(localCommentViewItem);
        continue;
        this.jdField_a_of_type_JavaUtilList.add(localCommentViewItem);
      }
    }
    if (i != 0) {
      QLog.d("ReadInJoyCommentListAdapter", 1, "checkDataDuplicate | error!!! first page comment data duplicated!");
    }
  }
  
  private boolean b(int paramInt)
  {
    if ((this.c == 5) && ((paramInt == 3) || (paramInt == 2) || (paramInt == 5))) {
      this.c = paramInt;
    }
    while (this.c == paramInt) {
      return true;
    }
    return false;
  }
  
  private boolean c(int paramInt)
  {
    if ((paramInt == 2) && ((this.c == 2) || (this.c == 3))) {
      QLog.d("ReadInJoyCommentListAdapter", 1, "checkCommentCreateFeedsType");
    }
    while (this.c == paramInt) {
      return true;
    }
    return false;
  }
  
  private void j()
  {
    Looper.myQueue().addIdleHandler(new ReadInJoyCommentListAdapter.1(this));
  }
  
  public int a()
  {
    int j;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      j = -1;
      return j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label79;
      }
      CommentViewItem localCommentViewItem = (CommentViewItem)this.jdField_a_of_type_JavaUtilList.get(i);
      j = i;
      if (localCommentViewItem.jdField_a_of_type_Int == 2) {
        break;
      }
      j = i;
      if (localCommentViewItem.jdField_a_of_type_Int == 1) {
        break;
      }
      i += 1;
    }
    label79:
    return -1;
  }
  
  LayoutInflater a()
  {
    return this.jdField_a_of_type_AndroidViewLayoutInflater;
  }
  
  ReadInJoyCommentUtils.CommentComponetEventListener a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a();
    }
    return null;
  }
  
  public CommentViewItem a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (CommentViewItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public ReadInJoyCommentDataManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager;
  }
  
  public VafContext a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new ReadInjoyContext();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setCurActivity(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "comment_feeds");
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.b(this.c, 1);
      QLog.d("ReadInJoyCommentListAdapter", 2, "reloadData | feedsType " + this.c);
    }
  }
  
  @VisibleForTesting
  void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$CommentListListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$CommentListListener.b(paramInt);
    }
  }
  
  public void a(ICommentNumChangedListener paramICommentNumChangedListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentICommentNumChangedListener = paramICommentNumChangedListener;
  }
  
  public void a(CommentViewItem paramCommentViewItem)
  {
    super.a(paramCommentViewItem);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentReportManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentReportManager.a(1, paramCommentViewItem);
    }
  }
  
  public void a(CommentViewItem paramCommentViewItem, SubCommentData paramSubCommentData, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$CommentListListener != null) && (paramCommentViewItem != null) && (paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null))
    {
      String str = null;
      if (paramSubCommentData != null) {
        str = paramSubCommentData.commentId;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$CommentListListener.a(true, paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId, str);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentReportManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentReportManager.a(paramCommentViewItem, paramInt);
      }
    }
  }
  
  public void a(ReadInJoyCommentDataManager.OnCommentListLoadListener paramOnCommentListLoadListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager$OnCommentListLoadListener = paramOnCommentListLoadListener;
  }
  
  public void a(ArticleInfo paramArticleInfo, AnchorData paramAnchorData, int paramInt)
  {
    QLog.d("ReadInJoyCommentListAdapter", 2, "initArticleCommentInfoModule | articleInfo " + paramArticleInfo + "; anchorData : " + paramAnchorData + "; contentSrc : " + paramInt + " reqFeedsType Default 5 currentFeedsType " + this.c);
    a(paramArticleInfo, paramAnchorData, true, 5, paramInt);
  }
  
  public void a(ArticleInfo paramArticleInfo, AnchorData paramAnchorData, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    QLog.d("ReadInJoyCommentListAdapter", 1, "initArticleCommentInfoModule | reqFeedsType " + paramInt1 + " ; currentFeedsType " + this.c + " ; articleInfo " + paramArticleInfo + "; anchorData : " + paramAnchorData + ";feedsType ：" + paramInt1 + "; contentSrc : " + paramInt2);
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.c = paramInt1;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager = ReadInJoyCommentDataManager.a(paramArticleInfo, paramInt2);
    String str;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.b())) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.c(), paramInt1);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentReportManager = new ReadInJoyCommentReportManager(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramInt2);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.a(this);
      if ((paramAnchorData != null) && (!TextUtils.isEmpty(paramAnchorData.jdField_a_of_type_JavaLangString)))
      {
        paramArticleInfo = paramAnchorData.jdField_a_of_type_JavaLangString;
        str = paramAnchorData.b;
        if (paramAnchorData.jdField_a_of_type_Boolean) {
          break label267;
        }
      }
    }
    label267:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramArticleInfo = new ReadInJoyCommentDataManager.CommentAnchor(paramArticleInfo, str, paramBoolean, paramAnchorData.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.a(paramArticleInfo);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.b(paramInt1, 1);
      this.jdField_a_of_type_JavaUtilList.clear();
      notifyDataSetChanged();
      return;
    }
  }
  
  public void a(ListView paramListView)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.e(this.c);
      QLog.d("ReadInJoyCommentListAdapter", 2, "startLoadMore | feedsType " + this.c);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentReportManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentReportManager.b();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.b();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.c();
    }
  }
  
  public void d()
  {
    long l = 0L;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) {
      l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.a(this);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentReportManager != null) && (jdField_a_of_type_Int != 1)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentReportManager.a(l, 2);
    }
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setCurActivity(null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMultiVideoNegativeHelper != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMultiVideoNegativeHelper.b();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$CommentListListener = null;
  }
  
  public void e()
  {
    h();
  }
  
  public void f()
  {
    h();
  }
  
  public void g()
  {
    if ((a() != null) && (this.e > -1)) {
      a().setSelectionFromTop(this.e, this.f);
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = a();
    Object localObject = paramView;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null)
      {
        localObject = paramView;
        if ((paramView.getTag() instanceof String))
        {
          localObject = paramView;
          if ("non_null_convertview".equalsIgnoreCase((String)paramView.getTag()))
          {
            localObject = null;
            QLog.d("ReadInJoyCommentListAdapter", 1, "getView | first comment reset NonNullView");
          }
        }
      }
    }
    int i = getItemViewType(paramInt);
    if (i == 6)
    {
      paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.a().a(paramViewGroup, (View)localObject, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, a(paramInt));
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
    TemplateBean localTemplateBean;
    if (DynamicCommentProteusHelper.a(a(paramInt)))
    {
      localTemplateBean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDynamicCommentProteusHelper.a(a(paramInt));
      if (localObject != null) {
        break label412;
      }
    }
    label409:
    label412:
    for (paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, localTemplateBean);; paramView = (View)localObject)
    {
      DynamicCommentProteusHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, (Container)paramView, localTemplateBean, this, paramInt, i, true);
      localObject = paramView;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentReportManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentReportManager.c(paramInt);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter$OnGetViewListener != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter$OnGetViewListener.a(paramInt, (View)localObject);
      }
      paramView = (View)localObject;
      if (localObject == null)
      {
        localObject = new StringBuilder().append("getView | first comment convertview is null ; position ").append(paramInt).append(" viewtype ").append(i).append("\n commentItem: ");
        if (a(paramInt) != null)
        {
          paramView = a(paramInt).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
          label286:
          localObject = paramView;
          QLog.d("ReadInJoyCommentListAdapter", 1, (String)localObject);
          paramView = a();
          AIOUtils.a("ReadInJoyCommentListAdapter", "first comment convertview is null", new NullPointerException((String)localObject));
        }
      }
      else
      {
        localObject = paramView;
        break;
        paramView = CommentProteusUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, a(paramInt), i, true, this);
        if (localObject != null) {
          break label409;
        }
        TraceUtils.traceBegin("ReadInJoyCommentAdapter.create convertView");
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, paramView);
        TraceUtils.traceEnd();
      }
      for (;;)
      {
        CommentProteusUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, (Container)localObject, paramView, this, paramInt, i, true);
        break;
        paramView = "commentData is null";
        break label286;
      }
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView == null) {
      return;
    }
    int j = a();
    if (this.d != 1)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.smoothScrollBy(0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.smoothScrollToPosition(j);
      QLog.d("ReadInJoyCommentListAdapter", 2, "scrollToComment | contentSrc " + this.d + "; titlePos " + j);
      return;
    }
    ListAdapter localListAdapter = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getAdapter();
    Object localObject = localListAdapter;
    if ((localListAdapter instanceof HeaderViewListAdapter)) {
      localObject = ((HeaderViewListAdapter)localListAdapter).getWrappedAdapter();
    }
    if ((localObject instanceof FastWebMergeAdapter))
    {
      localObject = ((FastWebMergeAdapter)localObject).a().iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localListAdapter = (ListAdapter)((Iterator)localObject).next();
      } while (!(localListAdapter instanceof WebFastAdapter));
    }
    for (int i = localListAdapter.getCount();; i = -1)
    {
      QLog.d("ReadInJoyCommentListAdapter", 1, "scrollToComment | articleItemCnt: " + i + " titlePos : " + j);
      if (i != -1) {
        i += j;
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.smoothScrollBy(0, 0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.smoothScrollToPositionFromTop(i + 1, 0);
        return;
        i = j;
      }
    }
  }
  
  public void onClick(ViewBase paramViewBase) {}
  
  public void onCommentBlock(int paramInt, boolean paramBoolean, Pair<List<BaseCommentData>, List<BaseCommentData>> paramPair)
  {
    if ((!paramBoolean) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager == null) || (paramPair == null)) {
      return;
    }
    Object localObject = (List)paramPair.first;
    paramPair = (List)paramPair.second;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.a(this.c);
      if ((localObject != null) && (this.jdField_a_of_type_JavaUtilList != null))
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject);
        notifyDataSetChanged();
      }
    }
    if ((paramPair != null) && (paramPair.size() > 0))
    {
      paramPair = paramPair.iterator();
      while (paramPair.hasNext())
      {
        localObject = (BaseCommentData)paramPair.next();
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          paramInt = 0;
          if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
          {
            CommentViewItem localCommentViewItem = (CommentViewItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
            if ((localCommentViewItem == null) || (localCommentViewItem.jdField_a_of_type_Int != 0)) {}
            for (;;)
            {
              paramInt += 1;
              break;
              if ((localObject != null) && (localCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null) && (TextUtils.equals(localCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId, ((SubCommentData)localObject).parentCommentId))) {
                localCommentViewItem.a();
              }
            }
          }
          notifyDataSetChanged();
        }
      }
    }
    if (getCount() <= 0) {
      a(2);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentICommentNumChangedListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentICommentNumChangedListener.onUpdate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.a(this.c));
    }
    ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendSeq, false);
  }
  
  public void onCommentCreate(boolean paramBoolean, CommentViewItem paramCommentViewItem, List<CommentViewItem> paramList, int paramInt)
  {
    if (!c(paramInt)) {
      QLog.d("ReadInJoyCommentListAdapter", 1, "onCommentCreate | wrong feedstype , currentFeedsType " + this.c + ", feedsType " + paramInt);
    }
    do
    {
      return;
      if (!paramBoolean) {
        break;
      }
      this.c = 2;
      int i = 2131718160;
      if (RIJBiuAndCommentAladdinUtils.a()) {
        i = 2131718097;
      }
      QQToast.a(BaseApplication.getContext(), 2, i, 0).a();
      a(4);
      if ((paramList != null) && (paramList.size() > 0))
      {
        QLog.d("ReadInJoyCommentListAdapter", 2, "onCommentCreate commentViewItemList size " + paramList.size());
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilList.addAll(paramList);
          notifyDataSetChanged();
          j();
        }
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentICommentNumChangedListener != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentICommentNumChangedListener.onUpdate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.a(paramInt));
      }
      paramList = a().getIntent().getBundleExtra("bundle");
    } while (paramList == null);
    BaseCommentData localBaseCommentData = paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    paramCommentViewItem = "";
    if ((localBaseCommentData instanceof SubCommentData)) {
      paramCommentViewItem = ((SubCommentData)localBaseCommentData).parentCommentId;
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(true, localBaseCommentData.rowKey, localBaseCommentData.commentId, localBaseCommentData.getWholeStringContent(), localBaseCommentData.level, "onCommentSend", paramList.getInt("seq"), paramCommentViewItem);
    ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendSeq, true);
    return;
    QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131712758), 0).a();
  }
  
  public void onCommentCreate(boolean paramBoolean1, CommentViewItem paramCommentViewItem, boolean paramBoolean2, List<CommentViewItem> paramList, int paramInt)
  {
    if (!c(paramInt))
    {
      QLog.d("ReadInJoyCommentListAdapter", 1, "onCommentCreate | wrong feedstype , currentFeedsType " + this.c + ", feedsType " + paramInt);
      return;
    }
    this.c = 2;
    a(paramBoolean2);
    onCommentCreate(paramBoolean1, paramCommentViewItem, paramList, paramInt);
  }
  
  public void onCommentDelete(int paramInt1, boolean paramBoolean, CommentViewItem paramCommentViewItem, int paramInt2)
  {
    if ((!paramBoolean) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager == null)) {
      return;
    }
    if (!a(paramInt2))
    {
      QLog.d("ReadInJoyCommentListAdapter", 1, "onCommentDelete | wrong feedstype , currentFeedsType " + this.c + ", feedsType " + paramInt2);
      return;
    }
    if (paramInt1 == 1)
    {
      paramCommentViewItem = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.a(paramInt2);
      if ((paramCommentViewItem != null) && (this.jdField_a_of_type_JavaUtilList != null))
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(paramCommentViewItem);
        notifyDataSetChanged();
      }
    }
    for (;;)
    {
      if (getCount() <= 0) {
        a(2);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentICommentNumChangedListener != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentICommentNumChangedListener.onUpdate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.a(paramInt2));
      }
      ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendSeq, false);
      return;
      if ((paramInt1 == 2) && (this.jdField_a_of_type_JavaUtilList != null))
      {
        paramInt1 = 0;
        if (paramInt1 < this.jdField_a_of_type_JavaUtilList.size())
        {
          CommentViewItem localCommentViewItem = (CommentViewItem)this.jdField_a_of_type_JavaUtilList.get(paramInt1);
          if ((localCommentViewItem == null) || (localCommentViewItem.jdField_a_of_type_Int != 0)) {}
          for (;;)
          {
            paramInt1 += 1;
            break;
            if ((paramCommentViewItem != null) && (paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null) && (localCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null) && (TextUtils.equals(localCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId, ((SubCommentData)paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).parentCommentId))) {
              localCommentViewItem.a();
            }
          }
        }
        notifyDataSetChanged();
      }
    }
  }
  
  public void onCommentLikeOrDislike(boolean paramBoolean, BaseCommentData paramBaseCommentData, int paramInt1, int paramInt2) {}
  
  public void onCommentListLoad(int paramInt1, boolean paramBoolean1, List<CommentViewItem> paramList, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    if (paramInt1 != 1)
    {
      QLog.d("ReadInJoyCommentListAdapter", 1, "onCommentListLoad  | isNot first level Comment");
      return;
    }
    if (!b(paramInt3))
    {
      QLog.d("ReadInJoyCommentListAdapter", 1, "onCommentListLoad | wrong feedstype , currentFeedsType " + this.c + ", feedsType " + paramInt3);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("onCommentListLoad first comments ").append(paramBoolean1).append(" feedsType : ").append(paramInt2).append("\n commentDataListSize ");
    if (paramList != null) {}
    for (int i = paramList.size();; i = 0)
    {
      QLog.d("ReadInJoyCommentListAdapter", 1, i);
      if (paramBoolean1) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.loadMoreFail();
      }
      a(3);
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.loadingMoreComplete(paramBoolean2);
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramList != null) && (!paramList.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      b(paramList);
      a(4);
      a(paramList);
    }
    for (;;)
    {
      notifyDataSetChanged();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager$OnCommentListLoadListener != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager$OnCommentListLoadListener.onCommentListLoad(paramInt1, paramBoolean1, paramList, paramBoolean2, paramInt2, paramInt3);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentICommentNumChangedListener == null) {
        break;
      }
      long l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.a(this.c);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentICommentNumChangedListener.onUpdate(l);
      QLog.d("ReadInJoyCommentListAdapter", 2, "onCommentListLoad | mCommentNumChangedListener onUpdate feedsType " + this.c + " count : " + l);
      return;
      a(2);
    }
  }
  
  public void onCommentLoadMore(int paramInt1, boolean paramBoolean1, List<CommentViewItem> paramList, boolean paramBoolean2, int paramInt2)
  {
    if (paramInt1 != 1) {}
    do
    {
      do
      {
        return;
        if (!a(paramInt2))
        {
          QLog.d("ReadInJoyCommentListAdapter", 1, "onCommentLoadMore | wrong feedstype , currentFeedsType " + this.c + ", feedsType " + paramInt2);
          return;
        }
        if (!paramBoolean1) {
          break;
        }
      } while ((this.jdField_a_of_type_JavaUtilList == null) || (paramList == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView == null));
      this.jdField_a_of_type_JavaUtilList.size();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.loadingMoreComplete(paramBoolean2);
      notifyDataSetChanged();
      return;
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.loadingMoreComplete(paramBoolean2);
  }
  
  public void onCommentReply(boolean paramBoolean, CommentViewItem paramCommentViewItem)
  {
    if (paramCommentViewItem == null) {}
    Object localObject;
    do
    {
      return;
      if (!paramBoolean) {
        break;
      }
      QQToast.a(BaseApplication.getContext(), 2, HardCodeUtil.a(2131713079), 0).a();
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        int i = 0;
        if (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          localObject = (CommentViewItem)this.jdField_a_of_type_JavaUtilList.get(i);
          if ((localObject == null) || (((CommentViewItem)localObject).jdField_a_of_type_Int != 0) || (((CommentViewItem)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null)) {}
          for (;;)
          {
            i += 1;
            break;
            if (TextUtils.equals(((CommentViewItem)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId, ((SubCommentData)paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).parentCommentId)) {
              ((CommentViewItem)localObject).a();
            }
          }
        }
        notifyDataSetChanged();
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentICommentNumChangedListener != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentICommentNumChangedListener.onUpdate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.a(this.c));
      }
      localObject = a().getIntent().getBundleExtra("bundle");
    } while (localObject == null);
    BaseCommentData localBaseCommentData = paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    paramCommentViewItem = "";
    if ((localBaseCommentData instanceof SubCommentData)) {
      paramCommentViewItem = ((SubCommentData)localBaseCommentData).parentCommentId;
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(true, localBaseCommentData.rowKey, localBaseCommentData.commentId, localBaseCommentData.getWholeStringContent(), localBaseCommentData.level, "onCommentSend", ((Bundle)localObject).getInt("seq"), paramCommentViewItem);
    return;
    QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131712856), 0).a();
  }
  
  public void onCommentReport(int paramInt, boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((!paramBoolean) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager == null) || (this.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.a(this.c) <= 0L) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    label128:
    do
    {
      for (;;)
      {
        notifyDataSetChanged();
        if (getCount() <= 0) {
          a(2);
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentICommentNumChangedListener == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentICommentNumChangedListener.onUpdate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.a(this.c));
        return;
        if (paramInt != 1) {
          break label128;
        }
        paramString1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.a(this.c);
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(paramString1);
      }
    } while (paramInt != 2);
    paramInt = 0;
    label135:
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
    {
      paramString2 = (CommentViewItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if ((paramString2 != null) && (paramString2.jdField_a_of_type_Int == 0)) {
        break label183;
      }
    }
    for (;;)
    {
      paramInt += 1;
      break label135;
      break;
      label183:
      if ((paramString2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null) && (TextUtils.equals(paramString2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId, paramString1))) {
        paramString2.a();
      }
    }
  }
  
  public void onCommentStateError(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager$OnCommentListLoadListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager$OnCommentListLoadListener.onCommentStateError(paramInt);
    }
    while (paramInt != 1001) {
      return;
    }
    QRUtils.a(1, 2131718139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListAdapter
 * JD-Core Version:    0.7.0.1
 */