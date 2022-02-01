package com.tencent.biz.pubaccount.readinjoy.comment;

import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentViewItem;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.OnCommentListLoadListener;
import com.tencent.biz.pubaccount.readinjoy.common.ProteusSupportUtil;
import com.tencent.biz.pubaccount.readinjoy.proteus.wrap.ReadInjoyContext;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadInJoySecondCommentListAdapter
  extends ReadinjoyCommentListBaseAdapter
  implements ReadInJoyCommentListView.RefreshCallback
{
  private int jdField_a_of_type_Int;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ICommentNumChangedListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentICommentNumChangedListener;
  private ReadInJoySecondCommentListFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment;
  private ReadInJoyCommentDataManager.OnCommentListLoadListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager$OnCommentListLoadListener;
  private String jdField_a_of_type_JavaLangString;
  private int b = 0;
  
  public ReadInJoySecondCommentListAdapter(FragmentActivity paramFragmentActivity, ReadInJoyCommentListView paramReadInJoyCommentListView, ReadInJoySecondCommentListFragment paramReadInJoySecondCommentListFragment, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramFragmentActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramFragmentActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView = paramReadInJoyCommentListView;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setRefreshCallback(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment = paramReadInJoySecondCommentListFragment;
    this.b = paramInt;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDynamicCommentProteusHelper = new DynamicCommentProteusHelper();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDynamicCommentProteusHelper.a(a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentItemHeightHelper = new ReadInJoyCommentItemHeightHelper(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, this.jdField_a_of_type_JavaUtilList, this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
  }
  
  private void a(List<CommentViewItem> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        CommentViewItem localCommentViewItem = (CommentViewItem)paramList.next();
        if ((localCommentViewItem.a instanceof CommentData)) {
          localCommentViewItem.a.isAnchor = false;
        }
      }
    }
  }
  
  LayoutInflater a()
  {
    return this.jdField_a_of_type_AndroidViewLayoutInflater;
  }
  
  ReadInJoyCommentUtils.CommentComponetEventListener a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a();
    }
    return null;
  }
  
  public CommentViewItem a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
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
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    QLog.d("ReadInJoySecondCommentListAdapter", 1, new Object[] { "onDestroy article=", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo });
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentReportManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentReportManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a());
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.a(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.e();
    }
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentReportManager = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentICommentNumChangedListener = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager$OnCommentListLoadListener = null;
  }
  
  public void a(ICommentNumChangedListener paramICommentNumChangedListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentICommentNumChangedListener = paramICommentNumChangedListener;
  }
  
  public void a(CommentViewItem paramCommentViewItem)
  {
    super.a(paramCommentViewItem);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentReportManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentReportManager.a(2, paramCommentViewItem);
    }
  }
  
  public void a(ReadInJoyCommentDataManager.OnCommentListLoadListener paramOnCommentListLoadListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager$OnCommentListLoadListener = paramOnCommentListLoadListener;
  }
  
  public void a(ListView paramListView)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentReportManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentReportManager.d();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.c(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(String paramString1, String paramString2, ArticleInfo paramArticleInfo, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager = ReadInJoyCommentDataManager.a(paramArticleInfo);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentReportManager = new ReadInJoyCommentReportManager(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramInt);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.a(this);
      this.jdField_a_of_type_JavaUtilList.clear();
      paramArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.a(paramString1);
      a(paramArticleInfo);
      this.jdField_a_of_type_JavaUtilList.addAll(paramArticleInfo);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.a(paramString1, paramString2);
      notifyDataSetChanged();
    }
    QLog.d("ReadInJoySecondCommentListAdapter", 1, new Object[] { "initCommentData article=", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "mCommentDataManager=", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager });
  }
  
  public boolean a(int paramInt)
  {
    return true;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.e();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new ReadInjoyContext();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "comment_feeds");
    }
    Object localObject1 = paramView;
    if (paramView != null)
    {
      localObject1 = paramView;
      if (paramView.getTag() != null)
      {
        localObject1 = paramView;
        if ((paramView.getTag() instanceof String))
        {
          localObject1 = paramView;
          if ("non_null_convertview".equalsIgnoreCase((String)paramView.getTag()))
          {
            localObject1 = null;
            QLog.d("ReadInJoySecondCommentListAdapter", 1, "getView | sub comment reset NonNullView");
          }
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager == null) {
      QLog.w("ReadInJoySecondCommentListAdapter", 1, "getView | mCommentDataManager is null, article=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    }
    int i = getItemViewType(paramInt);
    label259:
    label308:
    Object localObject2;
    switch (i)
    {
    case 1: 
    case 2: 
    default: 
      paramView = (View)localObject1;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentReportManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentReportManager.d(paramInt);
      }
      if (paramView == null)
      {
        localObject1 = new StringBuilder().append("getView | sub comment convertview is null ; position ").append(paramInt).append(" viewtype ").append(i).append("\n commentItem: ");
        if (a(paramInt) != null)
        {
          paramView = a(paramInt).a;
          localObject1 = paramView;
          QLog.d("ReadInJoySecondCommentListAdapter", 1, (String)localObject1);
          QLog.d("ReadInJoySecondCommentListAdapter", 1, (String)localObject1);
          paramView = a();
          AIOUtils.a("ReadInJoySecondCommentListAdapter", "sub comment convertview is null", new NullPointerException((String)localObject1));
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
        }
      }
      break;
    case 3: 
      if (localObject1 == null)
      {
        localObject2 = new ReadinjoyCommentViewHolder.ReplyNumTitleHolder();
        localObject1 = ((ReadinjoyCommentViewHolder.ReplyNumTitleHolder)localObject2).a(this, paramInt, (View)localObject1, paramViewGroup);
      }
      for (;;)
      {
        paramView = (View)localObject1;
        if (localObject2 == null) {
          break;
        }
        ((ReadinjoyCommentViewHolder.ReplyNumTitleHolder)localObject2).a(this, paramInt);
        paramView = (View)localObject1;
        break;
        localObject2 = (ReadinjoyCommentViewHolder.ReplyNumTitleHolder)((View)localObject1).getTag();
      }
    case 0: 
    case 4: 
    case 5: 
      if (DynamicCommentProteusHelper.a(a(paramInt)))
      {
        localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDynamicCommentProteusHelper.a(a(paramInt));
        if ((localObject1 != null) && ((localObject1 instanceof Container))) {
          break label545;
        }
      }
      break;
    }
    label545:
    for (paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, (TemplateBean)localObject2);; paramView = (View)localObject1)
    {
      DynamicCommentProteusHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, (Container)paramView, (TemplateBean)localObject2, this, paramInt, i, true);
      break;
      localObject2 = CommentProteusUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, a(paramInt), i, false, this);
      if ((localObject1 == null) || (!(localObject1 instanceof Container))) {}
      for (paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, (TemplateBean)localObject2);; paramView = (View)localObject1)
      {
        CommentProteusUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, (Container)paramView, (TemplateBean)localObject2, this, paramInt, i, false);
        break;
        paramView = "commentData is null";
        break label259;
        break label308;
      }
    }
  }
  
  public void onCommentBlock(int paramInt, boolean paramBoolean, Pair<List<BaseCommentData>, List<BaseCommentData>> paramPair)
  {
    if ((!paramBoolean) || (paramPair == null)) {}
    for (;;)
    {
      return;
      paramPair = (List)paramPair.second;
      if (paramInt == 1) {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.c();
        }
      }
      while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentICommentNumChangedListener != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager != null))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentICommentNumChangedListener.onUpdate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.a());
        return;
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager != null) && (paramPair != null) && (paramPair.size() > 0))
        {
          paramPair = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.b(this.jdField_a_of_type_JavaLangString);
          if (!paramPair.isEmpty())
          {
            this.jdField_a_of_type_JavaUtilList.clear();
            this.jdField_a_of_type_JavaUtilList.addAll(paramPair);
            notifyDataSetChanged();
          }
        }
      }
    }
  }
  
  public void onCommentCreate(boolean paramBoolean, CommentViewItem paramCommentViewItem, List<CommentViewItem> paramList, int paramInt) {}
  
  public void onCommentCreate(boolean paramBoolean1, CommentViewItem paramCommentViewItem, boolean paramBoolean2, List<CommentViewItem> paramList, int paramInt) {}
  
  public void onCommentDelete(int paramInt1, boolean paramBoolean, CommentViewItem paramCommentViewItem, int paramInt2)
  {
    if (!paramBoolean) {}
    for (;;)
    {
      return;
      if (!a(paramInt2))
      {
        QLog.d("ReadInJoySecondCommentListAdapter", 1, "onCommentDelete | wrong firstFeedsType");
        return;
      }
      if (paramInt1 == 1) {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.c();
        }
      }
      while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentICommentNumChangedListener != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager != null))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentICommentNumChangedListener.onUpdate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.a());
        return;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager != null)
        {
          paramCommentViewItem = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.b(this.jdField_a_of_type_JavaLangString);
          if (!paramCommentViewItem.isEmpty())
          {
            this.jdField_a_of_type_JavaUtilList.clear();
            this.jdField_a_of_type_JavaUtilList.addAll(paramCommentViewItem);
            notifyDataSetChanged();
          }
        }
      }
    }
  }
  
  public void onCommentLikeOrDislike(boolean paramBoolean, BaseCommentData paramBaseCommentData, int paramInt1, int paramInt2) {}
  
  public void onCommentListLoad(int paramInt1, boolean paramBoolean1, List<CommentViewItem> paramList, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    if ((paramInt1 != 2) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager == null)) {}
    do
    {
      return;
      QLog.d("ReadInJoySecondCommentListAdapter", 1, "onCommentListLoad sub comments " + paramBoolean1 + " flowType : " + paramInt2);
      if (!a(paramInt3))
      {
        QLog.d("ReadInJoySecondCommentListAdapter", 1, "onCommentListLoad | wrong firstFeedsType");
        return;
      }
    } while ((!paramBoolean1) || (this.jdField_a_of_type_JavaUtilList == null) || (paramList == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView == null));
    a(paramList);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.loadingMoreComplete(paramBoolean2);
    notifyDataSetChanged();
  }
  
  public void onCommentLoadMore(int paramInt1, boolean paramBoolean1, List<CommentViewItem> paramList, boolean paramBoolean2, int paramInt2)
  {
    if ((paramInt1 != 2) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager == null)) {}
    do
    {
      do
      {
        return;
        QLog.d("ReadInJoySecondCommentListAdapter", 1, "onCommentLoadMore sub comments " + paramBoolean1);
        if (!a(paramInt2))
        {
          QLog.d("ReadInJoySecondCommentListAdapter", 1, "onCommentLoadMore | wrong firstFeedsType");
          return;
        }
        if (!paramBoolean1) {
          break;
        }
      } while ((this.jdField_a_of_type_JavaUtilList == null) || (paramList == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView == null));
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.loadingMoreComplete(paramBoolean2);
      return;
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.loadMoreFail();
  }
  
  public void onCommentReply(boolean paramBoolean, CommentViewItem paramCommentViewItem)
  {
    if (paramBoolean)
    {
      QQToast.a(BaseApplication.getContext(), 2, HardCodeUtil.a(2131712945), 0).a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager != null) {}
      for (paramCommentViewItem = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.b(this.jdField_a_of_type_JavaLangString);; paramCommentViewItem = new ArrayList())
      {
        if ((!paramCommentViewItem.isEmpty()) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null))
        {
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilList.addAll(paramCommentViewItem);
          notifyDataSetChanged();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.smoothScrollBy(0, 0);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setSelection(0);
        }
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentICommentNumChangedListener != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager != null)) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentICommentNumChangedListener.onUpdate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.a());
        }
        return;
      }
    }
    QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131712797), 0).a();
  }
  
  public void onCommentReport(int paramInt, boolean paramBoolean, String paramString1, String paramString2)
  {
    if (!paramBoolean) {}
    for (;;)
    {
      return;
      if (paramInt == 1) {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.c();
        }
      }
      while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentICommentNumChangedListener != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager != null))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentICommentNumChangedListener.onUpdate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.a());
        return;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager != null)
        {
          paramString1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.b(this.jdField_a_of_type_JavaLangString);
          if (!paramString1.isEmpty())
          {
            this.jdField_a_of_type_JavaUtilList.clear();
            this.jdField_a_of_type_JavaUtilList.addAll(paramString1);
            notifyDataSetChanged();
          }
        }
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
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoySecondCommentListAdapter
 * JD-Core Version:    0.7.0.1
 */