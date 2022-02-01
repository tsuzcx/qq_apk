package com.tencent.biz.pubaccount.readinjoy.comment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentViewItem;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommonCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.OnDataChangeListener;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.guide.GuideHelper;
import com.tencent.biz.pubaccount.readinjoy.comment.ui.RIJCommentBubbleView;
import com.tencent.biz.pubaccount.readinjoy.comment.ui.ReadInJoyCommentLikeView.OnLikeStateChangeLinstener;
import com.tencent.biz.pubaccount.readinjoy.comment.ui.ReadInJoyCommentPopUpWindow.OnCommentTypeChangedListener;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJCreateArticleInfoForBiu;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.multiVideo.NegativeHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.BubblePopupWindow.OnDismissListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ReadinjoyCommentListBaseAdapter
  extends BaseAdapter
  implements ReadInJoyCommentDataManager.OnDataChangeListener, ReadInJoyCommentLikeView.OnLikeStateChangeLinstener, ReadInJoyCommentPopUpWindow.OnCommentTypeChangedListener
{
  protected DynamicCommentProteusHelper a;
  protected ReadInJoyCommentItemHeightHelper.OnScrollYOffsetListener a;
  protected ReadInJoyCommentItemHeightHelper a;
  protected ReadInJoyCommentListView a;
  protected ReadInJoyCommentReportManager a;
  protected ReadinjoyCommentListBaseAdapter.OnGetViewListener a;
  protected CommonCommentData a;
  protected ReadInJoyCommentDataManager a;
  protected ArticleInfo a;
  protected VafContext a;
  protected NegativeHelper a;
  BaseActivity a;
  protected AbsListView.OnScrollListener a;
  protected List<CommentViewItem> a;
  protected boolean a;
  protected int c = -1;
  
  public ReadinjoyCommentListBaseAdapter()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new ReadinjoyCommentListBaseAdapter.1(this);
  }
  
  private int a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentItemHeightHelper == null) {
      return 0;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(0) != null) {}
    for (int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(0).getTop();; i = 0)
    {
      int j = 0;
      while (j < paramInt)
      {
        int k = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentItemHeightHelper.a(j);
        j += 1;
        i = k + i;
      }
      QLog.d("ReadinjoyCommentListBaseAdapter", 2, "calculateScrollYOffsetHeight | firstVisiblePos " + paramInt + " totalHeight " + i);
      return i;
    }
  }
  
  private void b(String paramString, int paramInt1, int paramInt2)
  {
    paramInt2 = 1;
    QLog.d("ReadinjoyCommentListBaseAdapter", 2, new Object[] { "comment id : ", paramString, " like state change, new state : ", Integer.valueOf(paramInt1) });
    ReadInJoyCommentReportManager localReadInJoyCommentReportManager;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.b(paramString, paramInt1);
      paramString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.a(paramString);
      if ((paramString != null) && (!paramString.isAd)) {
        notifyDataSetChanged();
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentReportManager != null)
      {
        localReadInJoyCommentReportManager = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentReportManager;
        if (!(this instanceof ReadInJoyCommentListAdapter)) {
          break label103;
        }
      }
    }
    label103:
    for (paramInt1 = paramInt2;; paramInt1 = 2)
    {
      localReadInJoyCommentReportManager.a(paramInt1, paramString);
      return;
    }
  }
  
  abstract LayoutInflater a();
  
  protected View a()
  {
    View localView = new View(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localView.setLayoutParams(new LinearLayout.LayoutParams(0, 0));
    localView.setTag("non_null_convertview");
    QLog.d("ReadinjoyCommentListBaseAdapter", 1, "createNotNullView");
    return localView;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return getView(paramInt, paramView, paramViewGroup);
  }
  
  public ReadInJoyCommentListView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView;
  }
  
  public ReadInJoyCommentReportManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentReportManager;
  }
  
  abstract ReadInJoyCommentUtils.CommentComponetEventListener a();
  
  public CommentViewItem a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadinjoyCommentListBaseAdapter", 2, String.format("Click more button in  commentLineId is :" + paramString + "     mViewState is :" + paramInt, new Object[0]));
    }
    Object localObject = "";
    if (paramString.contains("-")) {
      localObject = paramString.split("-")[1];
    }
    boolean bool = ((String)localObject).contains(":");
    String str = localObject.split(":")[0];
    if (((String)localObject).contains(":")) {}
    for (paramString = localObject.split(":")[1];; paramString = "")
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        CommentViewItem localCommentViewItem = (CommentViewItem)((Iterator)localObject).next();
        BaseCommentData localBaseCommentData = localCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
        if (localBaseCommentData != null) {
          if ((bool) && ((localBaseCommentData instanceof SubCommentData)))
          {
            SubCommentData localSubCommentData = (SubCommentData)localCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
            if ((localBaseCommentData.commentId.equals(paramString)) && (localSubCommentData.parentCommentId.equals(str)))
            {
              localBaseCommentData.maxLine = 100;
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentReportManager.a(str, paramString, localCommentViewItem.b);
              return null;
            }
          }
          else if ((bool) && ((localCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)) && (paramInt == 1))
          {
            if ((localBaseCommentData.commentId.equals(str)) && (((CommentData)localCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).subCommentNum > 0))
            {
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentReportManager.b(str, paramString, localCommentViewItem.b);
              return localCommentViewItem;
            }
          }
          else if ((!bool) && (localBaseCommentData.commentId.equals(str)))
          {
            localBaseCommentData.maxLine = 100;
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentReportManager.a(str, localCommentViewItem.b);
            return null;
          }
        }
      }
      return null;
    }
  }
  
  public abstract ReadInJoyCommentDataManager a();
  
  public VafContext a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  }
  
  public BaseActivity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  }
  
  public void a(Activity paramActivity, View paramView, CommentViewItem paramCommentViewItem, BubblePopupWindow.OnDismissListener paramOnDismissListener)
  {
    new RIJCommentBubbleView(paramActivity, this, paramCommentViewItem, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo).a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramView, paramOnDismissListener);
    RIJTransMergeKanDianReport.a("0X800824A");
  }
  
  public void a(Context paramContext, ReadInJoyCommentUtils.ReportCommentDialogClickListener paramReportCommentDialogClickListener)
  {
    if (paramContext == null) {
      return;
    }
    ActionSheet localActionSheet = ActionSheet.create(paramContext);
    localActionSheet.setMainTitle(2131718158);
    int[] arrayOfInt = new int[7];
    int[] tmp27_25 = arrayOfInt;
    tmp27_25[0] = 2131718151;
    int[] tmp33_27 = tmp27_25;
    tmp33_27[1] = 2131718152;
    int[] tmp39_33 = tmp33_27;
    tmp39_33[2] = 2131718153;
    int[] tmp45_39 = tmp39_33;
    tmp45_39[3] = 2131718154;
    int[] tmp51_45 = tmp45_39;
    tmp51_45[4] = 2131718155;
    int[] tmp57_51 = tmp51_45;
    tmp57_51[5] = 2131718156;
    int[] tmp63_57 = tmp57_51;
    tmp63_57[6] = 2131718157;
    tmp63_57;
    int i = 0;
    while (i < arrayOfInt.length)
    {
      localActionSheet.addButton(arrayOfInt[i]);
      i += 1;
    }
    localActionSheet.addCancelButton(2131690800);
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
    localActionSheet.setOnButtonClickListener(new ReadinjoyCommentListBaseAdapter.4(this, localActionSheet, arrayOfInt, paramContext, paramReportCommentDialogClickListener));
  }
  
  public void a(Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData != null)
    {
      paramIntent.putExtra("arg_common_comment_info", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
      QLog.d("ReadinjoyCommentListBaseAdapter", 2, "readToBiuActivity   commonCommentData :" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.toString());
    }
  }
  
  public void a(ReadInJoyCommentItemHeightHelper.OnScrollYOffsetListener paramOnScrollYOffsetListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentItemHeightHelper$OnScrollYOffsetListener = paramOnScrollYOffsetListener;
  }
  
  public void a(ReadinjoyCommentListBaseAdapter.OnGetViewListener paramOnGetViewListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter$OnGetViewListener = paramOnGetViewListener;
  }
  
  public void a(CommentViewItem paramCommentViewItem)
  {
    BaseCommentData localBaseCommentData = paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    int j = 4;
    int i;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getAdTag() == -1)) {
        break label110;
      }
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getAdTag();
      if (!TextUtils.isEmpty(localBaseCommentData.nickName)) {
        break label214;
      }
    }
    label214:
    for (paramCommentViewItem = "";; paramCommentViewItem = localBaseCommentData.nickName)
    {
      paramCommentViewItem = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131718150) + paramCommentViewItem;
      ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, localBaseCommentData, i, paramCommentViewItem, null, false, a(), -1, this.jdField_a_of_type_Boolean);
      return;
      label110:
      if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5)) || (RIJFeedsType.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
      {
        i = 2;
        break;
      }
      i = j;
      if (!ReadInJoyDeliverBiuActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
        break;
      }
      i = j;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null) {
        break;
      }
      i = j;
      if (!ReadInJoyDeliverBiuActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int)) {
        break;
      }
      i = 9;
      break;
    }
  }
  
  public void a(CommonCommentData paramCommonCommentData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData = paramCommonCommentData;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    RIJUserLevelModule.a().a(a(), 3, new ReadinjoyCommentListBaseAdapter.3(this, paramString, paramInt1, paramInt2));
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.a();
    }
    return false;
  }
  
  public boolean a(int paramInt)
  {
    return paramInt == this.c;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public void b(int paramInt)
  {
    QLog.d("ReadinjoyCommentListBaseAdapter", 1, "onCommentTypeChanged | changeToType " + paramInt);
    this.c = paramInt;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager != null)
    {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.a(paramInt));
        notifyDataSetChanged();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.a().a(false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentReportManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentReportManager.b(paramInt);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.resetFooterView();
    }
  }
  
  public void b(CommentViewItem paramCommentViewItem)
  {
    if ((paramCommentViewItem == null) || (paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null)) {}
    for (;;)
    {
      return;
      if ((paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAuthorReply()) && (!TextUtils.isEmpty(paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.ksHomePage))) {
        ReadInJoyCommentUtils.b(paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.ksHomePage, BaseActivity.sTopActivity);
      }
      while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentReportManager != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentReportManager.b(paramCommentViewItem);
        return;
        ReadInJoyCommentUtils.a(paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.uin, BaseActivity.sTopActivity, paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      }
    }
  }
  
  public abstract void c();
  
  public void c(CommentViewItem paramCommentViewItem)
  {
    ActionSheet localActionSheet = ActionSheet.create(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localActionSheet.setMainTitle(2131718185);
    localActionSheet.addButton(2131718184, 3);
    localActionSheet.addCancelButton(2131690800);
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
    localActionSheet.setOnButtonClickListener(new ReadinjoyCommentListBaseAdapter.2(this, paramCommentViewItem, localActionSheet));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentReportManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentReportManager.a(paramCommentViewItem);
    }
  }
  
  public void d(CommentViewItem paramCommentViewItem)
  {
    QLog.d("ReadinjoyCommentListBaseAdapter", 1, "start showBiuComponent");
    if ((paramCommentViewItem == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)) {}
    do
    {
      return;
      Object localObject = ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
      int i = ((Integer)((Pair)localObject).first).intValue();
      int j = ((Integer)((Pair)localObject).second).intValue();
      localObject = paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      String str1 = ((BaseCommentData)localObject).getWholeStringContent();
      String str2 = ((BaseCommentData)localObject).uin;
      localObject = RIJCreateArticleInfoForBiu.a(new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ReadInJoyDeliverBiuActivity.class), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, i, str1, Long.valueOf(str2).longValue(), ((BaseCommentData)localObject).nickName, 0, j);
      a((Intent)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(0, 0);
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentReportManager == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentReportManager.c(paramCommentViewItem);
  }
  
  public void e(CommentViewItem paramCommentViewItem)
  {
    int j = 1;
    if (paramCommentViewItem == null) {}
    label72:
    do
    {
      return;
      BaseCommentData localBaseCommentData = paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      if (!localBaseCommentData.isDisliked()) {
        break;
      }
      localObject = HardCodeUtil.a(2131712814);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, (CharSequence)localObject, 0).a();
      localObject = a();
      if (localObject != null)
      {
        String str = localBaseCommentData.commentId;
        if (!localBaseCommentData.isDisliked()) {
          break label121;
        }
        i = 0;
        ((ReadInJoyCommentDataManager)localObject).a(str, i);
      }
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentReportManager == null);
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentReportManager;
    if ((this instanceof ReadInJoyCommentListAdapter)) {}
    for (int i = j;; i = 2)
    {
      ((ReadInJoyCommentReportManager)localObject).b(i, paramCommentViewItem);
      return;
      localObject = HardCodeUtil.a(2131712911);
      break;
      label121:
      i = 1;
      break label72;
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return -1;
    }
    CommentViewItem localCommentViewItem = (CommentViewItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localCommentViewItem == null) {
      return -1;
    }
    if (DynamicCommentProteusHelper.a(localCommentViewItem)) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDynamicCommentProteusHelper.a(localCommentViewItem);
    }
    return ((CommentViewItem)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int;
  }
  
  public int getViewTypeCount()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDynamicCommentProteusHelper != null) {}
    for (int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDynamicCommentProteusHelper.a();; i = 0) {
      return i + 8;
    }
  }
  
  public void i()
  {
    int i = 2;
    if (this.c == 2) {
      i = 3;
    }
    QLog.d("ReadinjoyCommentListBaseAdapter", 1, "onChangeCommentTypeClick | curType " + this.c + "; changeToType " + i);
    this.c = i;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager != null)
    {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.a(i));
        notifyDataSetChanged();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentDataManager.a().a(false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentReportManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentReportManager.b(i);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.resetFooterView();
    }
    if ((i == 3) && ((this instanceof ReadInJoyCommentListAdapter))) {
      ((ReadInJoyCommentListAdapter)this).g();
    }
  }
  
  public void onClick(ViewBase paramViewBase) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadinjoyCommentListBaseAdapter
 * JD-Core Version:    0.7.0.1
 */