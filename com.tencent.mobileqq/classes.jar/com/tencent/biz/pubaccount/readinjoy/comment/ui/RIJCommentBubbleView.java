package com.tencent.biz.pubaccount.readinjoy.comment.ui;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListAdapter;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentReportManager;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils.ReportCommentDialogClickListener;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadinjoyCommentListBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData.MediaData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentViewItem;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.Label;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.dt.RIJDtParamBuilder;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelModule;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelModule.UserLevelCallBack;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil.QLog;
import com.tencent.biz.pubaccount.util.ReadInJoyShareHelperV2;
import com.tencent.biz.pubaccount.util.ReadInJoyShareHelperV2.BaseSheetItemClickProcessor;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.BubblePopupWindow.OnDismissListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.BooleanRef;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/ui/RIJCommentBubbleView;", "Landroid/view/View$OnClickListener;", "activity", "Landroid/app/Activity;", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/comment/ReadinjoyCommentListBaseAdapter;", "commentViewItem", "Lcom/tencent/biz/pubaccount/readinjoy/comment/data/CommentViewItem;", "articleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "(Landroid/app/Activity;Lcom/tencent/biz/pubaccount/readinjoy/comment/ReadinjoyCommentListBaseAdapter;Lcom/tencent/biz/pubaccount/readinjoy/comment/data/CommentViewItem;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)V", "mActivity", "mAdapter", "mAnchor", "Landroid/view/View;", "mArticleInfo", "mBubbleFirstPageView", "mBubbleSecondPageView", "mCommentViewItem", "mDismisListener", "Lcom/tencent/widget/BubblePopupWindow$OnDismissListener;", "mFirstPagePop", "Lcom/tencent/widget/BubblePopupWindow;", "mLabel", "Lcom/tencent/biz/pubaccount/readinjoy/comment/data/ReadInJoyCommentPBModule$Label;", "mSecondPagePop", "mShareHelper", "Lcom/tencent/biz/pubaccount/util/ReadInJoyShareHelperV2;", "misNeedBiu", "", "buildBubbleView", "", "isNeedBiu", "anchor", "dismissListener", "clickAuthorDelete", "", "clickBiu", "v", "clickBlockButton", "clickCopy", "clickDislike", "clickNextPage", "clickPreviousPage", "clickReportOrDelete", "clickSinkButton", "clickStickyButton", "getShareLine", "", "", "isSubComment", "(Z)[Ljava/util/List;", "initFirstPageView", "initSecondPageView", "onClick", "reportClickEventToDt", "eid", "", "actionId", "reportMenuItemClick", "action", "shareComment", "showAuthorDeleteOption", "showBlockOption", "showSecondPage", "showSinkOption", "showStickyOption", "Companion", "SheetItemClickProcessor", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJCommentBubbleView
  implements View.OnClickListener
{
  public static final RIJCommentBubbleView.Companion a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private ReadinjoyCommentListBaseAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter;
  private CommentViewItem jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem;
  private ReadInJoyCommentPBModule.Label jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule$Label;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private ReadInJoyShareHelperV2 jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2;
  private BubblePopupWindow.OnDismissListener jdField_a_of_type_ComTencentWidgetBubblePopupWindow$OnDismissListener;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private BubblePopupWindow jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
  private View c;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiRIJCommentBubbleView$Companion = new RIJCommentBubbleView.Companion(null);
  }
  
  public RIJCommentBubbleView(@NotNull Activity paramActivity, @NotNull ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, @NotNull CommentViewItem paramCommentViewItem, @NotNull ArticleInfo paramArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem = paramCommentViewItem;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter = paramReadinjoyCommentListBaseAdapter;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule$Label = new ReadInJoyCommentPBModule.Label();
    paramActivity = LayoutInflater.from((Context)this.jdField_a_of_type_AndroidAppActivity).inflate(2131560223, null);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "LayoutInflater.from(mAct…omment_bubble_view, null)");
    this.jdField_a_of_type_AndroidViewView = paramActivity;
    paramActivity = LayoutInflater.from((Context)this.jdField_a_of_type_AndroidAppActivity).inflate(2131562882, null);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "LayoutInflater.from(mAct…ble_view_next_page, null)");
    this.jdField_b_of_type_AndroidViewView = paramActivity;
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = new BubblePopupWindow(-2, -2);
    this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow = new BubblePopupWindow(-2, -2);
  }
  
  private final int a()
  {
    ActionSheet localActionSheet = ActionSheet.create((Context)this.jdField_a_of_type_AndroidAppActivity);
    localActionSheet.setMainTitle(2131718570);
    localActionSheet.addButton(2131718578, 3);
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnButtonClickListener((ActionSheet.OnButtonClickListener)new RIJCommentBubbleView.clickAuthorDelete.1(this, localActionSheet));
    localActionSheet.show();
    return 4;
  }
  
  private final int a(@NonNull View paramView)
  {
    a("share_button", "click_share");
    if (((RIJCommentBubbleView)this).jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2 == null)
    {
      paramView = paramView.getContext();
      if (paramView == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.BaseActivity");
      }
      Object localObject = (BaseActivity)paramView;
      paramView = (Activity)localObject;
      localObject = ((BaseActivity)localObject).getAppInterface();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "activity.appInterface");
      ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      BaseCommentData localBaseCommentData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      Intrinsics.checkExpressionValueIsNotNull(localBaseCommentData, "mCommentViewItem.commentData");
      this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2 = new ReadInJoyShareHelperV2(paramView, (AppInterface)localObject, (ReadInJoyShareHelperV2.BaseSheetItemClickProcessor)new RIJCommentBubbleView.SheetItemClickProcessor(this, localArticleInfo, localBaseCommentData, new WeakReference(this.jdField_a_of_type_AndroidAppActivity)));
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData))
    {
      paramView = this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mShareHelper");
      }
      paramView.a(a(false), 29, "", (BaseArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    }
    for (;;)
    {
      paramView = this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mShareHelper");
      }
      paramView.a().setRowVisibility(8, 0, 0);
      paramView = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
      }
      paramView.a();
      return 11;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof SubCommentData))
      {
        paramView = this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2;
        if (paramView == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mShareHelper");
        }
        paramView.a(a(true), 29, "", (BaseArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      }
    }
  }
  
  private final void a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
    }
    ((BubblePopupWindow)localObject1).a();
    localObject1 = this.jdField_b_of_type_AndroidViewView;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
    }
    if (((View)localObject1).getParent() != null)
    {
      localObject1 = this.jdField_b_of_type_AndroidViewView;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
      }
      localObject1 = ((View)localObject1).getParent();
      if (localObject1 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
      }
      localObject1 = (ViewGroup)localObject1;
      localObject2 = this.jdField_b_of_type_AndroidViewView;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
      }
      localObject2 = ((View)localObject2).getParent();
      if (localObject2 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
      }
      localObject2 = (ViewGroup)localObject2;
      localObject2 = this.jdField_b_of_type_AndroidViewView;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
      }
      ((ViewGroup)localObject1).removeView((View)localObject2);
    }
    localObject1 = this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
    }
    Object localObject2 = this.jdField_b_of_type_AndroidViewView;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
    }
    ((BubblePopupWindow)localObject1).a((View)localObject2);
    localObject1 = this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
    }
    ((BubblePopupWindow)localObject1).c(true);
    localObject1 = this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
    }
    ((BubblePopupWindow)localObject1).a(true);
    localObject1 = this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
    }
    localObject2 = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow$OnDismissListener;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mDismisListener");
    }
    ((BubblePopupWindow)localObject1).a((BubblePopupWindow.OnDismissListener)localObject2);
    localObject1 = this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
    }
    localObject2 = this.c;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mAnchor");
    }
    ((BubblePopupWindow)localObject1).b((View)localObject2);
  }
  
  private final void a(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter instanceof ReadInJoyCommentListAdapter)) {}
    for (int i = 1;; i = 2)
    {
      ReadInJoyCommentReportManager localReadInJoyCommentReportManager = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter.a();
      if (localReadInJoyCommentReportManager == null) {
        break;
      }
      localReadInJoyCommentReportManager.a(i, paramInt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem);
      return;
    }
  }
  
  private final void a(@NonNull View paramView)
  {
    a("copy_button", "click_copy");
    paramView = paramView.getContext().getSystemService("clipboard");
    if (paramView == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.content.ClipboardManager");
    }
    paramView = (ClipboardManager)paramView;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem.jdField_a_of_type_JavaLangCharSequence)) {
      paramView.setText(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem.jdField_a_of_type_JavaLangCharSequence);
    }
    paramView = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
    }
    paramView.a();
  }
  
  private final void a(String paramString1, String paramString2)
  {
    RIJDtParamBuilder localRIJDtParamBuilder = new RIJDtParamBuilder().f(paramString1);
    paramString1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    if (paramString1 != null) {}
    for (paramString1 = paramString1.innerUniqueID;; paramString1 = null)
    {
      VideoReport.reportEvent("clck", RIJDtParamBuilder.a(localRIJDtParamBuilder.e(paramString1).c(paramString2), null, 1, null).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).a());
      return;
    }
  }
  
  private final boolean a()
  {
    return (e()) || (c()) || (b()) || (d());
  }
  
  private final List<Integer>[] a(boolean paramBoolean)
  {
    List localList = (List)new ArrayList();
    if (!paramBoolean)
    {
      localList.add(Integer.valueOf(2));
      localList.add(Integer.valueOf(3));
    }
    localList.add(Integer.valueOf(9));
    localList.add(Integer.valueOf(10));
    localList.add(Integer.valueOf(12));
    return new List[] { localList };
  }
  
  private final int b()
  {
    a("feedback_button", "click_feedback");
    Object localObject = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
    }
    ((BubblePopupWindow)localObject).a();
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mCommentViewItem.commentData");
    if (((BaseCommentData)localObject).isMyself())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem);
      return 4;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter.a((Context)this.jdField_a_of_type_AndroidAppActivity, (ReadInJoyCommentUtils.ReportCommentDialogClickListener)new RIJCommentBubbleView.clickReportOrDelete.1(this));
    return 3;
  }
  
  private final int b(View paramView)
  {
    a("biu_button", "click_biu");
    RIJUserLevelModule.a().a(paramView.getContext(), 2, (RIJUserLevelModule.UserLevelCallBack)new RIJCommentBubbleView.clickBiu.1(this));
    paramView = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
    }
    paramView.a();
    return 1;
  }
  
  private final void b()
  {
    Object localObject1 = this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
    }
    ((BubblePopupWindow)localObject1).a();
    localObject1 = this.jdField_a_of_type_AndroidViewView;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
    }
    if (((View)localObject1).getParent() != null)
    {
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
      }
      localObject1 = ((View)localObject1).getParent();
      if (localObject1 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
      }
      localObject1 = (ViewGroup)localObject1;
      localObject2 = this.jdField_a_of_type_AndroidViewView;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
      }
      localObject2 = ((View)localObject2).getParent();
      if (localObject2 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
      }
      localObject2 = (ViewGroup)localObject2;
      localObject2 = this.jdField_a_of_type_AndroidViewView;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
      }
      ((ViewGroup)localObject1).removeView((View)localObject2);
    }
    boolean bool = this.jdField_a_of_type_Boolean;
    localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    Object localObject2 = this.c;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mAnchor");
    }
    BubblePopupWindow.OnDismissListener localOnDismissListener = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow$OnDismissListener;
    if (localOnDismissListener == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mDismisListener");
    }
    b(bool, (ArticleInfo)localObject1, (View)localObject2, localOnDismissListener);
  }
  
  private final void b(boolean paramBoolean, ArticleInfo paramArticleInfo, View paramView, BubblePopupWindow.OnDismissListener paramOnDismissListener)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
    }
    localObject = ((View)localObject).findViewById(2131380285);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mBubbleFirstPageView.findViewById(R.id.tv_copy)");
    ((TextView)localObject).setOnClickListener((View.OnClickListener)this);
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
    }
    localObject = ((View)localObject).findViewById(2131380595);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mBubbleFirstPageView.findViewById(R.id.tv_share)");
    ((TextView)localObject).setOnClickListener((View.OnClickListener)this);
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
    }
    localObject = ((View)localObject).findViewById(2131380230);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mBubbleFirstPageView.findViewById(R.id.tv_biu)");
    localObject = (TextView)localObject;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.mediaDataList != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.mediaDataList.size() > 0))
    {
      if (((BaseCommentData.MediaData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.mediaDataList.get(0)).e > 0) {
        ((TextView)localObject).setVisibility(8);
      }
    }
    else
    {
      ((TextView)localObject).setOnClickListener((View.OnClickListener)this);
      if (!paramBoolean) {
        ((TextView)localObject).setVisibility(8);
      }
      paramArticleInfo = paramArticleInfo.mSocialFeedInfo;
      if (paramArticleInfo != null)
      {
        paramArticleInfo = paramArticleInfo.a;
        if ((paramArticleInfo != null) && (paramArticleInfo.jdField_a_of_type_Boolean == true)) {
          ((TextView)localObject).setVisibility(8);
        }
      }
      paramArticleInfo = this.jdField_a_of_type_AndroidViewView;
      if (paramArticleInfo == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
      }
      paramArticleInfo = paramArticleInfo.findViewById(2131380567);
      Intrinsics.checkExpressionValueIsNotNull(paramArticleInfo, "mBubbleFirstPageView.fin…R.id.tv_report_or_delete)");
      localObject = (TextView)paramArticleInfo;
      paramArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      Intrinsics.checkExpressionValueIsNotNull(paramArticleInfo, "mCommentViewItem.commentData");
      if (!paramArticleInfo.isMyself()) {
        break label507;
      }
      paramArticleInfo = (CharSequence)"删除";
      label316:
      ((TextView)localObject).setText(paramArticleInfo);
      ((TextView)localObject).setOnClickListener((View.OnClickListener)this);
      paramArticleInfo = this.jdField_a_of_type_AndroidViewView;
      if (paramArticleInfo == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
      }
      paramArticleInfo = paramArticleInfo.findViewById(2131380315);
      Intrinsics.checkExpressionValueIsNotNull(paramArticleInfo, "mBubbleFirstPageView.findViewById(R.id.tv_dislike)");
      localObject = (TextView)paramArticleInfo;
      paramArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      Intrinsics.checkExpressionValueIsNotNull(paramArticleInfo, "mCommentViewItem.commentData");
      if (!paramArticleInfo.isDisliked()) {
        break label517;
      }
    }
    label517:
    for (paramArticleInfo = (CharSequence)HardCodeUtil.a(2131712902);; paramArticleInfo = (CharSequence)HardCodeUtil.a(2131713018))
    {
      ((TextView)localObject).setText(paramArticleInfo);
      ((TextView)localObject).setOnClickListener((View.OnClickListener)this);
      if (a())
      {
        paramArticleInfo = this.jdField_a_of_type_AndroidViewView;
        if (paramArticleInfo == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
        }
        paramArticleInfo = paramArticleInfo.findViewById(2131369795);
        Intrinsics.checkExpressionValueIsNotNull(paramArticleInfo, "mBubbleFirstPageView.findViewById(R.id.iv_right)");
        paramArticleInfo = (ImageView)paramArticleInfo;
        paramArticleInfo.setVisibility(0);
        paramArticleInfo.setOnClickListener((View.OnClickListener)this);
      }
      if (!(this.jdField_a_of_type_AndroidAppActivity instanceof FastWebActivity)) {
        break label558;
      }
      paramArticleInfo = this.jdField_a_of_type_AndroidAppActivity;
      if (paramArticleInfo != null) {
        break label530;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity");
      ((TextView)localObject).setVisibility(0);
      break;
      label507:
      paramArticleInfo = (CharSequence)"举报";
      break label316;
    }
    label530:
    paramArticleInfo = (FastWebActivity)paramArticleInfo;
    localObject = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
    }
    paramArticleInfo.a((BubblePopupWindow)localObject);
    label558:
    paramArticleInfo = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (paramArticleInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
    }
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
    }
    paramArticleInfo.a((View)localObject);
    paramArticleInfo = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (paramArticleInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
    }
    paramArticleInfo.c(true);
    paramArticleInfo = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (paramArticleInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
    }
    paramArticleInfo.b(paramView);
    paramArticleInfo = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (paramArticleInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
    }
    paramArticleInfo.a(true);
    paramArticleInfo = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (paramArticleInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
    }
    paramArticleInfo.a(paramOnDismissListener);
  }
  
  private final boolean b()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter.a()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter.b() == 3) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.level == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule$Label.c);
  }
  
  private final int c()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem);
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleFirstPageView");
    }
    localObject = ((View)localObject).findViewById(2131380315);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mBubbleFirstPageView.findViewById(R.id.tv_dislike)");
    TextView localTextView = (TextView)localObject;
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mCommentViewItem.commentData");
    if (((BaseCommentData)localObject).isDisliked())
    {
      localObject = (CharSequence)HardCodeUtil.a(2131712698);
      localTextView.setText((CharSequence)localObject);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "mCommentViewItem.commentData");
      if (!((BaseCommentData)localObject).isDisliked()) {
        break label149;
      }
    }
    label149:
    for (localObject = "click_cai";; localObject = "cancel_cai")
    {
      a("cai_button", (String)localObject);
      localObject = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mFirstPagePop");
      }
      ((BubblePopupWindow)localObject).a();
      return 5;
      localObject = (CharSequence)HardCodeUtil.a(2131712762);
      break;
    }
  }
  
  private final void c()
  {
    Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
    localObjectRef.element = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter.a();
    ActionSheet localActionSheet = ActionSheet.create((Context)this.jdField_a_of_type_AndroidAppActivity);
    localActionSheet.setMainTitle(2131718571);
    localActionSheet.addButton(2131718575, 3);
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnButtonClickListener((ActionSheet.OnButtonClickListener)new RIJCommentBubbleView.clickBlockButton.1(this, localObjectRef, localActionSheet));
    localActionSheet.show();
  }
  
  private final void c(boolean paramBoolean, ArticleInfo paramArticleInfo, View paramView, BubblePopupWindow.OnDismissListener paramOnDismissListener)
  {
    paramArticleInfo = this.jdField_b_of_type_AndroidViewView;
    if (paramArticleInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
    }
    paramArticleInfo = paramArticleInfo.findViewById(2131380232);
    Intrinsics.checkExpressionValueIsNotNull(paramArticleInfo, "mBubbleSecondPageView.findViewById(R.id.tv_block)");
    paramArticleInfo = (TextView)paramArticleInfo;
    if (d())
    {
      paramArticleInfo.setVisibility(0);
      paramArticleInfo.setOnClickListener((View.OnClickListener)this);
      paramArticleInfo = this.jdField_b_of_type_AndroidViewView;
      if (paramArticleInfo == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
      }
      paramArticleInfo = paramArticleInfo.findViewById(2131380210);
      Intrinsics.checkExpressionValueIsNotNull(paramArticleInfo, "mBubbleSecondPageView.fi…Id(R.id.tv_author_delete)");
      paramArticleInfo = (TextView)paramArticleInfo;
      if (!e()) {
        break label423;
      }
      paramArticleInfo.setVisibility(0);
      paramArticleInfo.setOnClickListener((View.OnClickListener)this);
      label110:
      paramArticleInfo = this.jdField_b_of_type_AndroidViewView;
      if (paramArticleInfo == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
      }
      paramArticleInfo = paramArticleInfo.findViewById(2131380235);
      Intrinsics.checkExpressionValueIsNotNull(paramArticleInfo, "mBubbleSecondPageView.findViewById(R.id.tv_bottom)");
      paramView = (TextView)paramArticleInfo;
      if (!c()) {
        break label447;
      }
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem.b) {
        break label437;
      }
      paramArticleInfo = (CharSequence)"取消沉底";
      label169:
      paramView.setText(paramArticleInfo);
      paramView.setVisibility(0);
      paramView.setOnClickListener((View.OnClickListener)this);
      label187:
      paramArticleInfo = this.jdField_b_of_type_AndroidViewView;
      if (paramArticleInfo == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
      }
      paramArticleInfo = paramArticleInfo.findViewById(2131380662);
      Intrinsics.checkExpressionValueIsNotNull(paramArticleInfo, "mBubbleSecondPageView.findViewById(R.id.tv_top)");
      paramView = (TextView)paramArticleInfo;
      if (!b()) {
        break label471;
      }
      paramView.setVisibility(0);
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem.jdField_a_of_type_Boolean) {
        break label461;
      }
      paramArticleInfo = (CharSequence)"取消置顶";
      label251:
      paramView.setText(paramArticleInfo);
      paramView.setOnClickListener((View.OnClickListener)this);
    }
    for (;;)
    {
      paramArticleInfo = this.jdField_b_of_type_AndroidViewView;
      if (paramArticleInfo == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
      }
      paramArticleInfo = paramArticleInfo.findViewById(2131369701);
      Intrinsics.checkExpressionValueIsNotNull(paramArticleInfo, "mBubbleSecondPageView.findViewById(R.id.iv_left)");
      paramArticleInfo = (ImageView)paramArticleInfo;
      paramArticleInfo.setVisibility(0);
      paramArticleInfo.setOnClickListener((View.OnClickListener)this);
      paramArticleInfo = this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
      if (paramArticleInfo == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
      }
      paramView = this.jdField_b_of_type_AndroidViewView;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleSecondPageView");
      }
      paramArticleInfo.a(paramView);
      paramArticleInfo = this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
      if (paramArticleInfo == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
      }
      paramArticleInfo.c(true);
      paramArticleInfo = this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
      if (paramArticleInfo == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
      }
      paramArticleInfo.a(true);
      paramArticleInfo = this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
      if (paramArticleInfo == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
      }
      paramArticleInfo.a(paramOnDismissListener);
      return;
      paramArticleInfo.setVisibility(8);
      paramArticleInfo.setOnClickListener(null);
      break;
      label423:
      paramArticleInfo.setVisibility(8);
      paramArticleInfo.setOnClickListener(null);
      break label110;
      label437:
      paramArticleInfo = (CharSequence)"沉底";
      break label169;
      label447:
      paramView.setVisibility(8);
      paramView.setOnClickListener(null);
      break label187;
      label461:
      paramArticleInfo = (CharSequence)"置顶";
      break label251;
      label471:
      paramView.setVisibility(8);
      paramView.setOnClickListener(null);
    }
  }
  
  private final boolean c()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter.a()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter.b() == 3) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.level == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule$Label.b);
  }
  
  private final int d()
  {
    Ref.BooleanRef localBooleanRef = new Ref.BooleanRef();
    boolean bool;
    if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem.jdField_a_of_type_Boolean)
    {
      bool = true;
      localBooleanRef.element = bool;
      localObject1 = new Ref.ObjectRef();
      ((Ref.ObjectRef)localObject1).element = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter.a();
      if (localBooleanRef.element) {
        break label100;
      }
      localObject2 = (ReadInJoyCommentDataManager)((Ref.ObjectRef)localObject1).element;
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      if (localObject1 == null) {
        break label95;
      }
    }
    label95:
    for (Object localObject1 = ((BaseCommentData)localObject1).commentId;; localObject1 = null)
    {
      ((ReadInJoyCommentDataManager)localObject2).c((String)localObject1, localBooleanRef.element);
      return 7;
      bool = false;
      break;
    }
    label100:
    Object localObject2 = ActionSheet.create((Context)this.jdField_a_of_type_AndroidAppActivity);
    ((ActionSheet)localObject2).setMainTitle(2131718586);
    ((ActionSheet)localObject2).addButton(2131718590, 3);
    ((ActionSheet)localObject2).addCancelButton(2131690800);
    ((ActionSheet)localObject2).setOnButtonClickListener((ActionSheet.OnButtonClickListener)new RIJCommentBubbleView.clickStickyButton.1(this, (Ref.ObjectRef)localObject1, localBooleanRef, (ActionSheet)localObject2));
    ((ActionSheet)localObject2).show();
    return -1;
  }
  
  private final boolean d()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter.a()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule$Label.d))
    {
      BaseCommentData localBaseCommentData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      Intrinsics.checkExpressionValueIsNotNull(localBaseCommentData, "mCommentViewItem.commentData");
      if (!localBaseCommentData.isMyself()) {
        return true;
      }
    }
    return false;
  }
  
  private final int e()
  {
    Ref.BooleanRef localBooleanRef = new Ref.BooleanRef();
    boolean bool;
    if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem.b)
    {
      bool = true;
      localBooleanRef.element = bool;
      localObject1 = new Ref.ObjectRef();
      ((Ref.ObjectRef)localObject1).element = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter.a();
      if (localBooleanRef.element) {
        break label100;
      }
      localObject2 = (ReadInJoyCommentDataManager)((Ref.ObjectRef)localObject1).element;
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      if (localObject1 == null) {
        break label95;
      }
    }
    label95:
    for (Object localObject1 = ((BaseCommentData)localObject1).commentId;; localObject1 = null)
    {
      ((ReadInJoyCommentDataManager)localObject2).b((String)localObject1, localBooleanRef.element);
      return 10;
      bool = false;
      break;
    }
    label100:
    Object localObject2 = ActionSheet.create((Context)this.jdField_a_of_type_AndroidAppActivity);
    ((ActionSheet)localObject2).setMainTitle(2131718581);
    ((ActionSheet)localObject2).addButton(2131718585, 3);
    ((ActionSheet)localObject2).addCancelButton(2131690800);
    ((ActionSheet)localObject2).setOnButtonClickListener((ActionSheet.OnButtonClickListener)new RIJCommentBubbleView.clickSinkButton.1(this, (Ref.ObjectRef)localObject1, localBooleanRef, (ActionSheet)localObject2));
    ((ActionSheet)localObject2).show();
    return -1;
  }
  
  private final boolean e()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter.a()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule$Label.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAuthorReply()))
    {
      BaseCommentData localBaseCommentData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      Intrinsics.checkExpressionValueIsNotNull(localBaseCommentData, "mCommentViewItem.commentData");
      if (!localBaseCommentData.isMyself()) {
        return true;
      }
    }
    return false;
  }
  
  public final void a(boolean paramBoolean, @NotNull ArticleInfo paramArticleInfo, @NotNull View paramView, @NotNull BubblePopupWindow.OnDismissListener paramOnDismissListener)
  {
    Intrinsics.checkParameterIsNotNull(paramArticleInfo, "articleInfo");
    Intrinsics.checkParameterIsNotNull(paramView, "anchor");
    Intrinsics.checkParameterIsNotNull(paramOnDismissListener, "dismissListener");
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.c = paramView;
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow$OnDismissListener = paramOnDismissListener;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    paramArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter.a();
    Intrinsics.checkExpressionValueIsNotNull(paramArticleInfo, "mAdapter.commentDataManager");
    paramArticleInfo = paramArticleInfo.a();
    Intrinsics.checkExpressionValueIsNotNull(paramArticleInfo, "mAdapter.commentDataManager.commentBubbleLabel");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule$Label = paramArticleInfo;
    LogUtil.QLog.d("RIJCommentBubbleView", 2, "buildBubbleView  | mLabel " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule$Label);
    paramBoolean = this.jdField_a_of_type_Boolean;
    paramArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    paramView = this.c;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mAnchor");
    }
    paramOnDismissListener = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow$OnDismissListener;
    if (paramOnDismissListener == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mDismisListener");
    }
    b(paramBoolean, paramArticleInfo, paramView, paramOnDismissListener);
    if (a())
    {
      paramBoolean = this.jdField_a_of_type_Boolean;
      paramArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      paramView = this.c;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mAnchor");
      }
      paramOnDismissListener = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow$OnDismissListener;
      if (paramOnDismissListener == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mDismisListener");
      }
      c(paramBoolean, paramArticleInfo, paramView, paramOnDismissListener);
      LogUtil.QLog.d("RIJCommentBubbleView", 2, "showSecondPage");
    }
  }
  
  public void onClick(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "v");
    int i = -1;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      a(i);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(paramView);
      continue;
      i = a(paramView);
      continue;
      i = b(paramView);
      continue;
      i = c();
      continue;
      i = b();
      continue;
      b();
      continue;
      a();
      continue;
      i = a();
      continue;
      i = d();
      BubblePopupWindow localBubblePopupWindow = this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
      if (localBubblePopupWindow == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
      }
      localBubblePopupWindow.a();
      continue;
      i = e();
      localBubblePopupWindow = this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
      if (localBubblePopupWindow == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
      }
      localBubblePopupWindow.a();
      continue;
      c();
      localBubblePopupWindow = this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow;
      if (localBubblePopupWindow == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mSecondPagePop");
      }
      localBubblePopupWindow.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ui.RIJCommentBubbleView
 * JD-Core Version:    0.7.0.1
 */