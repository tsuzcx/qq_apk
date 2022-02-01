package com.tencent.biz.pubaccount.readinjoy.comment;

import android.util.SparseArray;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentViewItem;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/CommentProteusListenerUtil$Companion;", "", "()V", "TAG", "", "doReplyClick", "", "cmdStrId", "", "container", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/container/Container;", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/comment/ReadinjoyCommentListBaseAdapter;", "commentViewItem", "Lcom/tencent/biz/pubaccount/readinjoy/comment/data/CommentViewItem;", "viewBase", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "getOnClickListener", "Lcom/tencent/biz/pubaccount/readinjoy/comment/CommentProteusListenerUtil$CommentProteusOnClickListener;", "onClickListenerSparseArray", "Landroid/util/SparseArray;", "initChooseCommentTypeClickListener", "initCommentActivityClickListener", "initCommentBannerClickListener", "initCommentContentClickListener", "initCommentDotClickListener", "initCommentFlowGuideClickListener", "initCommentFollowOnClickListener", "initCommentHideButtonClickListener", "initCommentMediaClickListener", "initCommentReplyClickListener", "initDefaultClickListener", "initDeleteCommentClickListener", "initExposeCommentClickListener", "initExposeSubCommentOneClickListener", "initExposeSubCommentTwoClickListener", "initHeadMedalClickListener", "initLikeClickListener", "initOnClickListener", "initSocialAvatarOnClickListener", "putOnClickListenerIntoSparseArray", "onClickListener", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class CommentProteusListenerUtil$Companion
{
  private final CommentProteusListenerUtil.CommentProteusOnClickListener a()
  {
    return (CommentProteusListenerUtil.CommentProteusOnClickListener)new CommentProteusListenerUtil.Companion.initDefaultClickListener.1();
  }
  
  private final CommentProteusListenerUtil.CommentProteusOnClickListener a(int paramInt)
  {
    if (paramInt != 1023) {
      return null;
    }
    return (CommentProteusListenerUtil.CommentProteusOnClickListener)new CommentProteusListenerUtil.Companion.initSocialAvatarOnClickListener.1();
  }
  
  private final void a(int paramInt, CommentProteusListenerUtil.CommentProteusOnClickListener paramCommentProteusOnClickListener, SparseArray<CommentProteusListenerUtil.CommentProteusOnClickListener> paramSparseArray)
  {
    if (paramCommentProteusOnClickListener != null) {
      paramSparseArray.put(paramInt, paramCommentProteusOnClickListener);
    }
  }
  
  private final void a(int paramInt, Container paramContainer, ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, CommentViewItem paramCommentViewItem, ViewBase paramViewBase)
  {
    if (paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
    {
      paramContainer = new CommentReportR5Builder(paramCommentViewItem).a().a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyCommentUtils.a(paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8009010", "0X8009010", 0, 0, String.valueOf(paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, paramContainer, false);
    }
    if ((paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData))
    {
      paramContainer = paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      if (paramContainer == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData");
      }
      if (((CommentData)paramContainer).subCommentNum > 0)
      {
        if ((paramReadinjoyCommentListBaseAdapter instanceof ReadInJoyCommentListAdapter)) {
          ((ReadInJoyCommentListAdapter)paramReadinjoyCommentListBaseAdapter).a(paramCommentViewItem, CommentProteusUtil.a(paramCommentViewItem, -1), 1);
        }
        return;
      }
    }
    paramReadinjoyCommentListBaseAdapter.a(paramCommentViewItem);
  }
  
  private final CommentProteusListenerUtil.CommentProteusOnClickListener b(int paramInt)
  {
    if (paramInt != 1024) {
      return null;
    }
    return (CommentProteusListenerUtil.CommentProteusOnClickListener)new CommentProteusListenerUtil.Companion.initCommentFollowOnClickListener.1();
  }
  
  private final CommentProteusListenerUtil.CommentProteusOnClickListener c(int paramInt)
  {
    if (paramInt != 1002) {
      return null;
    }
    return (CommentProteusListenerUtil.CommentProteusOnClickListener)new CommentProteusListenerUtil.Companion.initLikeClickListener.1();
  }
  
  private final CommentProteusListenerUtil.CommentProteusOnClickListener d(int paramInt)
  {
    if (paramInt != 1063) {
      return null;
    }
    return (CommentProteusListenerUtil.CommentProteusOnClickListener)new CommentProteusListenerUtil.Companion.initCommentActivityClickListener.1();
  }
  
  private final CommentProteusListenerUtil.CommentProteusOnClickListener e(int paramInt)
  {
    if (paramInt != 1056) {
      return null;
    }
    return (CommentProteusListenerUtil.CommentProteusOnClickListener)new CommentProteusListenerUtil.Companion.initCommentReplyClickListener.1();
  }
  
  private final CommentProteusListenerUtil.CommentProteusOnClickListener f(int paramInt)
  {
    if (paramInt != 1060) {
      return null;
    }
    return (CommentProteusListenerUtil.CommentProteusOnClickListener)new CommentProteusListenerUtil.Companion.initDeleteCommentClickListener.1();
  }
  
  private final CommentProteusListenerUtil.CommentProteusOnClickListener g(int paramInt)
  {
    if (paramInt != 1057) {
      return null;
    }
    return (CommentProteusListenerUtil.CommentProteusOnClickListener)new CommentProteusListenerUtil.Companion.initCommentDotClickListener.1();
  }
  
  private final CommentProteusListenerUtil.CommentProteusOnClickListener h(int paramInt)
  {
    if (paramInt != 1061) {
      return null;
    }
    return (CommentProteusListenerUtil.CommentProteusOnClickListener)new CommentProteusListenerUtil.Companion.initExposeCommentClickListener.1();
  }
  
  private final CommentProteusListenerUtil.CommentProteusOnClickListener i(int paramInt)
  {
    if (paramInt != 1062) {
      return null;
    }
    return (CommentProteusListenerUtil.CommentProteusOnClickListener)new CommentProteusListenerUtil.Companion.initCommentContentClickListener.1();
  }
  
  private final CommentProteusListenerUtil.CommentProteusOnClickListener j(int paramInt)
  {
    if (paramInt != 1065) {
      return null;
    }
    return (CommentProteusListenerUtil.CommentProteusOnClickListener)new CommentProteusListenerUtil.Companion.initHeadMedalClickListener.1();
  }
  
  private final CommentProteusListenerUtil.CommentProteusOnClickListener k(int paramInt)
  {
    if (paramInt != 1073) {
      return null;
    }
    return (CommentProteusListenerUtil.CommentProteusOnClickListener)new CommentProteusListenerUtil.Companion.initCommentBannerClickListener.1();
  }
  
  private final CommentProteusListenerUtil.CommentProteusOnClickListener l(int paramInt)
  {
    if (paramInt != 1074) {
      return null;
    }
    return (CommentProteusListenerUtil.CommentProteusOnClickListener)new CommentProteusListenerUtil.Companion.initChooseCommentTypeClickListener.1();
  }
  
  private final CommentProteusListenerUtil.CommentProteusOnClickListener m(int paramInt)
  {
    if (paramInt != 1094) {
      return null;
    }
    return (CommentProteusListenerUtil.CommentProteusOnClickListener)new CommentProteusListenerUtil.Companion.initCommentFlowGuideClickListener.1();
  }
  
  private final CommentProteusListenerUtil.CommentProteusOnClickListener n(int paramInt)
  {
    if (paramInt != 1095) {
      return null;
    }
    return (CommentProteusListenerUtil.CommentProteusOnClickListener)new CommentProteusListenerUtil.Companion.initCommentMediaClickListener.1();
  }
  
  private final CommentProteusListenerUtil.CommentProteusOnClickListener o(int paramInt)
  {
    if (paramInt != 1080) {
      return null;
    }
    return (CommentProteusListenerUtil.CommentProteusOnClickListener)new CommentProteusListenerUtil.Companion.initExposeSubCommentOneClickListener.1();
  }
  
  private final CommentProteusListenerUtil.CommentProteusOnClickListener p(int paramInt)
  {
    if (paramInt != 1081) {
      return null;
    }
    return (CommentProteusListenerUtil.CommentProteusOnClickListener)new CommentProteusListenerUtil.Companion.initExposeSubCommentTwoClickListener.1();
  }
  
  private final CommentProteusListenerUtil.CommentProteusOnClickListener q(int paramInt)
  {
    if (paramInt != 1162) {
      return null;
    }
    return (CommentProteusListenerUtil.CommentProteusOnClickListener)new CommentProteusListenerUtil.Companion.initCommentHideButtonClickListener.1();
  }
  
  @NotNull
  public final CommentProteusListenerUtil.CommentProteusOnClickListener a(int paramInt, @NotNull SparseArray<CommentProteusListenerUtil.CommentProteusOnClickListener> paramSparseArray)
  {
    Intrinsics.checkParameterIsNotNull(paramSparseArray, "onClickListenerSparseArray");
    paramSparseArray = (CommentProteusListenerUtil.CommentProteusOnClickListener)paramSparseArray.get(paramInt);
    if (paramSparseArray != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CommentProteusListenerUtil", 2, "[getOnClickListener] succeed, cmdStrId = " + paramInt);
      }
      return paramSparseArray;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CommentProteusListenerUtil", 2, "[getOnClickListener] use default clickListener, cmdStrId = " + paramInt);
    }
    return ((Companion)this).a();
  }
  
  @NotNull
  public final Companion a(int paramInt, @NotNull SparseArray<CommentProteusListenerUtil.CommentProteusOnClickListener> paramSparseArray)
  {
    Intrinsics.checkParameterIsNotNull(paramSparseArray, "onClickListenerSparseArray");
    ((Companion)this).a(paramInt, ((Companion)this).a(paramInt), paramSparseArray);
    ((Companion)this).a(paramInt, ((Companion)this).c(paramInt), paramSparseArray);
    ((Companion)this).a(paramInt, ((Companion)this).d(paramInt), paramSparseArray);
    ((Companion)this).a(paramInt, ((Companion)this).e(paramInt), paramSparseArray);
    ((Companion)this).a(paramInt, ((Companion)this).f(paramInt), paramSparseArray);
    ((Companion)this).a(paramInt, ((Companion)this).g(paramInt), paramSparseArray);
    ((Companion)this).a(paramInt, ((Companion)this).h(paramInt), paramSparseArray);
    ((Companion)this).a(paramInt, ((Companion)this).i(paramInt), paramSparseArray);
    ((Companion)this).a(paramInt, ((Companion)this).j(paramInt), paramSparseArray);
    ((Companion)this).a(paramInt, ((Companion)this).k(paramInt), paramSparseArray);
    ((Companion)this).a(paramInt, ((Companion)this).l(paramInt), paramSparseArray);
    ((Companion)this).a(paramInt, ((Companion)this).m(paramInt), paramSparseArray);
    ((Companion)this).a(paramInt, ((Companion)this).n(paramInt), paramSparseArray);
    ((Companion)this).a(paramInt, ((Companion)this).o(paramInt), paramSparseArray);
    ((Companion)this).a(paramInt, ((Companion)this).p(paramInt), paramSparseArray);
    ((Companion)this).a(paramInt, ((Companion)this).q(paramInt), paramSparseArray);
    ((Companion)this).a(paramInt, ((Companion)this).b(paramInt), paramSparseArray);
    return (Companion)this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.CommentProteusListenerUtil.Companion
 * JD-Core Version:    0.7.0.1
 */