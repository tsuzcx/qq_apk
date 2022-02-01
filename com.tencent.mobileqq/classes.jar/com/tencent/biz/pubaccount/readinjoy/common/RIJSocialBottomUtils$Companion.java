package com.tencent.biz.pubaccount.readinjoy.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.OnDataChangeListener;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasCommentFragment;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule.FastWebArticleRichReqCallback;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew.DoShareClick;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ArticleTopicData.TopicInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/common/RIJSocialBottomUtils$Companion;", "", "()V", "TAG", "", "articleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "bottomSocialView", "Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyFastWebBottomSocialViewNew;", "bottomViewHeight", "", "callBack", "Lcom/tencent/biz/pubaccount/readinjoy/common/RIJSocialBottomUtils$CommentAndLikeCallBack;", "fastWebInfo", "Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebArticleInfo;", "hasRepeatRequest", "", "observer", "Lcom/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyObserver;", "getObserver", "()Lcom/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyObserver;", "setObserver", "(Lcom/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyObserver;)V", "webViewLayout", "Landroid/view/ViewGroup;", "addSocialBottomView", "", "activity", "Landroid/app/Activity;", "contentView", "Landroid/view/View;", "doShareClick", "Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyFastWebBottomSocialViewNew$DoShareClick;", "webInfo", "viewGroup", "adjustWebViewMargin", "isVisibile", "canShowSocialBottomView", "isWxArticle", "destroy", "generateArticleInfoForBiu", "originArticleinfo", "initBottomData", "bundle", "Landroid/os/Bundle;", "initParams", "openBiuActivity", "from", "biuState", "fastBiu", "context", "Landroid/content/Context;", "requestCode", "openCommentListFragment", "openCommentEdit", "refreshBottomView", "repeatRequest", "needRequest", "requestCommentNum", "callback", "requestLikeStatus", "webModule", "Lcom/tencent/biz/pubaccount/readinjoy/model/FastWebModule;", "Lcom/tencent/biz/pubaccount/readinjoy/model/FastWebModule$FastWebArticleRichReqCallback;", "setSocialBottomViewStatus", "isFirstInit", "originUrl", "currentUrl", "showSocialBottomView", "syncCommentAndLike", "syncWebInfoCache", "updateWebInfoCache", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJSocialBottomUtils$Companion
{
  private final ArticleInfo a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    List localList = null;
    if (paramArticleInfo == null) {
      return null;
    }
    ArticleInfo localArticleInfo = new ArticleInfo();
    if (paramFastWebArticleInfo != null) {
      localList = paramFastWebArticleInfo.jdField_a_of_type_JavaUtilList;
    }
    if ((localList != null) && (paramFastWebArticleInfo.jdField_a_of_type_JavaUtilList.size() > 0)) {
      localArticleInfo.businessId = ((ArticleTopicData.TopicInfo)paramFastWebArticleInfo.jdField_a_of_type_JavaUtilList.get(0)).a;
    }
    localArticleInfo.innerUniqueID = paramArticleInfo.innerUniqueID;
    localArticleInfo.mRecommendSeq = paramArticleInfo.mRecommendSeq;
    localArticleInfo.mAlgorithmID = paramArticleInfo.mAlgorithmID;
    localArticleInfo.mChannelID = paramArticleInfo.mChannelID;
    localArticleInfo.mStrategyId = paramArticleInfo.mStrategyId;
    localArticleInfo.mTitle = paramArticleInfo.mTitle;
    localArticleInfo.mSubscribeName = paramArticleInfo.mSubscribeName;
    localArticleInfo.mFirstPagePicUrl = paramArticleInfo.mFirstPagePicUrl;
    localArticleInfo.mArticleID = paramArticleInfo.mArticleID;
    localArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
    localArticleInfo.mSocialFeedInfo.a = new SocializeFeedsInfo.BiuInfo();
    localArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
    localArticleInfo.mSocialFeedInfo.a.b = Long.valueOf(1L);
    localArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_JavaUtilList = ((List)new ArrayList());
    return localArticleInfo;
  }
  
  private final void a(Activity paramActivity, View paramView, ReadInJoyFastWebBottomSocialViewNew.DoShareClick paramDoShareClick, FastWebArticleInfo paramFastWebArticleInfo, ArticleInfo paramArticleInfo)
  {
    if ((paramView instanceof ViewGroup))
    {
      RIJSocialBottomUtils.a(((Companion)this).a((ViewGroup)paramView, paramActivity, paramFastWebArticleInfo, paramArticleInfo, paramDoShareClick));
      if (RIJSocialBottomUtils.a() != null) {}
    }
    else
    {
      return;
    }
    RIJSocialBottomUtils.a(new RIJSocialBottomUtils.CommentAndLikeCallBack(paramArticleInfo.innerUniqueID, RIJSocialBottomUtils.a(), paramArticleInfo, paramFastWebArticleInfo));
    ((Companion)this).a(paramArticleInfo, paramFastWebArticleInfo, RIJSocialBottomUtils.a());
  }
  
  private final void a(boolean paramBoolean, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if ((paramBoolean) && (!RIJSocialBottomUtils.a()))
    {
      ThreadManager.getSubThreadHandler().postDelayed((Runnable)new RIJSocialBottomUtils.Companion.repeatRequest.1(paramArticleInfo, paramFastWebArticleInfo), 1000L);
      RIJSocialBottomUtils.a(true);
    }
  }
  
  private final void b()
  {
    Object localObject2 = null;
    Object localObject1 = ReadInJoyLogicEngine.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "ReadInJoyLogicEngine.getInstance()");
    FastWebModule localFastWebModule = ((ReadInJoyLogicEngine)localObject1).a();
    if (localFastWebModule != null)
    {
      localObject1 = RIJSocialBottomUtils.a();
      if (localObject1 != null) {
        localObject1 = ((ArticleInfo)localObject1).innerUniqueID;
      }
    }
    for (localObject1 = localFastWebModule.a((String)localObject1);; localObject1 = null)
    {
      if (localObject1 != null)
      {
        Object localObject3 = RIJSocialBottomUtils.a();
        if (localObject3 != null) {
          ((FastWebArticleInfo)localObject3).jdField_a_of_type_Boolean = ((FastWebArticleInfo)localObject1).jdField_a_of_type_Boolean;
        }
        localObject3 = RIJSocialBottomUtils.a();
        if (localObject3 != null) {
          ((FastWebArticleInfo)localObject3).jdField_a_of_type_Int = ((FastWebArticleInfo)localObject1).jdField_a_of_type_Int;
        }
        localObject3 = RIJSocialBottomUtils.a();
        if (localObject3 != null) {
          ((FastWebArticleInfo)localObject3).c = ((FastWebArticleInfo)localObject1).c;
        }
        localObject3 = RIJSocialBottomUtils.a();
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((ArticleInfo)localObject3).innerUniqueID;
        }
        localFastWebModule.a((String)localObject1, RIJSocialBottomUtils.a());
      }
      return;
      localObject1 = null;
      break;
    }
  }
  
  private final void c()
  {
    RIJSocialBottomUtils.a((ArticleInfo)null);
    RIJSocialBottomUtils.a((FastWebArticleInfo)null);
    RIJSocialBottomUtils.a((ReadInJoyFastWebBottomSocialViewNew)null);
    RIJSocialBottomUtils.a((RIJSocialBottomUtils.CommentAndLikeCallBack)null);
    RIJSocialBottomUtils.a((ViewGroup)null);
  }
  
  private final void d()
  {
    Object localObject = ReadInJoyLogicEngine.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyLogicEngine.getInstance()");
    FastWebModule localFastWebModule = ((ReadInJoyLogicEngine)localObject).a();
    if ((RIJSocialBottomUtils.a() != null) && (RIJSocialBottomUtils.a() != null) && (localFastWebModule != null))
    {
      localObject = RIJSocialBottomUtils.a();
      if (localObject == null) {
        break label53;
      }
    }
    label53:
    for (localObject = ((ArticleInfo)localObject).innerUniqueID;; localObject = null)
    {
      localFastWebModule.a((String)localObject, RIJSocialBottomUtils.a());
      return;
    }
  }
  
  @NotNull
  public final ReadInJoyObserver a()
  {
    return RIJSocialBottomUtils.a();
  }
  
  @Nullable
  public final ReadInJoyFastWebBottomSocialViewNew a(@NotNull ViewGroup paramViewGroup, @NotNull Activity paramActivity, @NotNull FastWebArticleInfo paramFastWebArticleInfo, @NotNull ArticleInfo paramArticleInfo, @Nullable ReadInJoyFastWebBottomSocialViewNew.DoShareClick paramDoShareClick)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "viewGroup");
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramFastWebArticleInfo, "webInfo");
    Intrinsics.checkParameterIsNotNull(paramArticleInfo, "articleInfo");
    try
    {
      if ((paramViewGroup instanceof RelativeLayout))
      {
        paramArticleInfo.mArticleContentUrl = paramFastWebArticleInfo.t;
        Object localObject = paramActivity.getResources();
        if (localObject != null)
        {
          float f = ((Resources)localObject).getDimension(2131298853);
          localObject = new RelativeLayout.LayoutParams(-1, (int)f);
          ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
          RIJSocialBottomUtils.a(paramViewGroup);
          RIJSocialBottomUtils.a((int)f);
          ((Companion)this).a(true);
          ReadInJoyFastWebBottomSocialViewNew localReadInJoyFastWebBottomSocialViewNew = new ReadInJoyFastWebBottomSocialViewNew((Context)paramActivity);
          localReadInJoyFastWebBottomSocialViewNew.setIsWebBottomView(true);
          localReadInJoyFastWebBottomSocialViewNew.setLayoutParams((ViewGroup.LayoutParams)localObject);
          paramViewGroup.addView((View)localReadInJoyFastWebBottomSocialViewNew);
          ((Companion)this).b();
          localReadInJoyFastWebBottomSocialViewNew.setData((Context)paramActivity, paramFastWebArticleInfo, paramArticleInfo);
          localReadInJoyFastWebBottomSocialViewNew.a(paramDoShareClick);
          QLog.d("RIJSocialBottomUtils", 1, "addSocialBottomView!");
          ReadInJoyLogicEngineEventDispatcher.a().a(((Companion)this).a());
          return localReadInJoyFastWebBottomSocialViewNew;
        }
      }
    }
    catch (Exception paramViewGroup)
    {
      QLog.d("RIJSocialBottomUtils", 1, "addSocialBottomView error!  msg=" + paramViewGroup);
    }
    return null;
  }
  
  public final void a()
  {
    Object localObject = RIJSocialBottomUtils.a();
    if (localObject != null) {
      ((ReadInJoyFastWebBottomSocialViewNew)localObject).a();
    }
    localObject = ReadInJoyLogicEngine.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyLogicEngine.getInstance()");
    localObject = ((ReadInJoyLogicEngine)localObject).a();
    if (localObject != null) {
      ((FastWebModule)localObject).a(RIJSocialBottomUtils.a());
    }
    ReadInJoyLogicEngineEventDispatcher.a().b(((Companion)this).a());
    ReadInJoyCommentDataManager.a(RIJSocialBottomUtils.a(), 10).g();
    localObject = RIJSocialBottomUtils.a();
    if (localObject != null) {
      ((RIJSocialBottomUtils.CommentAndLikeCallBack)localObject).a((ReadInJoyFastWebBottomSocialViewNew)null);
    }
    ((Companion)this).c();
  }
  
  public final void a(int paramInt1, int paramInt2, boolean paramBoolean, @NotNull Context paramContext, int paramInt3, @Nullable ArticleInfo paramArticleInfo, @Nullable FastWebArticleInfo paramFastWebArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if (!(paramContext instanceof Activity)) {
      return;
    }
    paramArticleInfo = ((Companion)this).a(paramArticleInfo, paramFastWebArticleInfo);
    paramFastWebArticleInfo = new Intent(paramContext, ReadInJoyDeliverBiuActivity.class);
    paramFastWebArticleInfo.putExtra("arg_article_info", (Parcelable)paramArticleInfo);
    paramFastWebArticleInfo.putExtra("biu_src", 100);
    paramFastWebArticleInfo.putExtra("arg_from_type", paramInt1);
    paramFastWebArticleInfo.putExtra("arg_biu_state", paramInt2);
    paramFastWebArticleInfo.putExtra("feedsType", 1);
    paramFastWebArticleInfo.putExtra("fast_biu_type", paramBoolean);
    paramFastWebArticleInfo.putExtra("should_show_dialog", true);
    paramFastWebArticleInfo.putExtra("is_modified_biu", false);
    paramFastWebArticleInfo.putExtra("modified_feeds_id", 0);
    ((Activity)paramContext).startActivityForResult(paramFastWebArticleInfo, paramInt3);
    ((Activity)paramContext).overridePendingTransition(0, 0);
  }
  
  public final void a(@NotNull Context paramContext, @NotNull ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramArticleInfo, "articleInfo");
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("source", 10);
      localBundle.putParcelable("articleInfo", (Parcelable)paramArticleInfo);
      int i = UIUtils.c(paramContext);
      if (i > 0) {
        localBundle.putInt("comment_layout_height", i * 2 / 3);
      }
      ReadInJoyAtlasCommentFragment.a(paramContext, paramArticleInfo.innerUniqueID, paramArticleInfo.mTitle, null, paramArticleInfo.mFirstPagePicUrl, null, paramBoolean, false, localBundle);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.d("RIJSocialBottomUtils", 1, "openCommentListFragment error!  msg=" + paramContext);
    }
  }
  
  public final void a(@NotNull Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramBundle, "bundle");
    try
    {
      RIJSocialBottomUtils.a((ArticleInfo)paramBundle.getParcelable("articleinfo"));
      RIJSocialBottomUtils.a((FastWebArticleInfo)paramBundle.getParcelable("fastwebinfo"));
      return;
    }
    catch (Throwable paramBundle)
    {
      QLog.i(ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.a, 1, "initData error!  msg=" + paramBundle);
    }
  }
  
  public final void a(@Nullable Bundle paramBundle, @Nullable Activity paramActivity, @Nullable View paramView, @Nullable ReadInJoyFastWebBottomSocialViewNew.DoShareClick paramDoShareClick)
  {
    boolean bool = false;
    if (paramBundle == null) {}
    do
    {
      do
      {
        return;
        if (paramBundle.getInt("article_source", 0) == 1) {
          bool = true;
        }
      } while (!((Companion)this).a(bool));
      ((Companion)this).a(paramBundle);
    } while ((paramActivity == null) || (paramView == null) || (RIJSocialBottomUtils.a() == null) || (RIJSocialBottomUtils.a() == null));
    paramBundle = (Companion)this;
    FastWebArticleInfo localFastWebArticleInfo = RIJSocialBottomUtils.a();
    if (localFastWebArticleInfo == null) {
      Intrinsics.throwNpe();
    }
    ArticleInfo localArticleInfo = RIJSocialBottomUtils.a();
    if (localArticleInfo == null) {
      Intrinsics.throwNpe();
    }
    paramBundle.a(paramActivity, paramView, paramDoShareClick, localFastWebArticleInfo, localArticleInfo);
  }
  
  public final void a(@NotNull FastWebModule paramFastWebModule, @NotNull ArticleInfo paramArticleInfo, @NotNull FastWebArticleInfo paramFastWebArticleInfo, @Nullable FastWebModule.FastWebArticleRichReqCallback paramFastWebArticleRichReqCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramFastWebModule, "webModule");
    Intrinsics.checkParameterIsNotNull(paramArticleInfo, "articleInfo");
    Intrinsics.checkParameterIsNotNull(paramFastWebArticleInfo, "webInfo");
    paramFastWebModule.a(paramArticleInfo, paramFastWebArticleInfo, paramFastWebArticleRichReqCallback, false);
    QLog.d("RIJSocialBottomUtils", 1, "requestLikeStatus!");
  }
  
  public final void a(@NotNull ArticleInfo paramArticleInfo, @Nullable RIJSocialBottomUtils.CommentAndLikeCallBack paramCommentAndLikeCallBack)
  {
    Intrinsics.checkParameterIsNotNull(paramArticleInfo, "articleInfo");
    paramArticleInfo = ReadInJoyCommentDataManager.a(paramArticleInfo, 10);
    if (paramArticleInfo != null)
    {
      paramArticleInfo.b(5, 1);
      paramArticleInfo.a((ReadInJoyCommentDataManager.OnDataChangeListener)paramCommentAndLikeCallBack);
      QLog.d("RIJSocialBottomUtils", 1, "requestCommentNum!");
    }
  }
  
  public final void a(@Nullable ArticleInfo paramArticleInfo, @Nullable FastWebArticleInfo paramFastWebArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramFastWebArticleInfo == null)) {
      return;
    }
    if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()))
    {
      ReadInJoyFastWebBottomSocialViewNew localReadInJoyFastWebBottomSocialViewNew = RIJSocialBottomUtils.a();
      if (localReadInJoyFastWebBottomSocialViewNew != null) {
        localReadInJoyFastWebBottomSocialViewNew.setData(paramFastWebArticleInfo, paramArticleInfo);
      }
    }
    for (;;)
    {
      ((Companion)this).d();
      return;
      ThreadManager.getUIHandler().post((Runnable)new RIJSocialBottomUtils.Companion.refreshBottomView.1(paramFastWebArticleInfo, paramArticleInfo));
    }
  }
  
  public final void a(@NotNull ArticleInfo paramArticleInfo, @NotNull FastWebArticleInfo paramFastWebArticleInfo, @Nullable RIJSocialBottomUtils.CommentAndLikeCallBack paramCommentAndLikeCallBack)
  {
    boolean bool = true;
    Intrinsics.checkParameterIsNotNull(paramArticleInfo, "articleInfo");
    Intrinsics.checkParameterIsNotNull(paramFastWebArticleInfo, "webInfo");
    Object localObject = ReadInJoyLogicEngine.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyLogicEngine.getInstance()");
    localObject = ((ReadInJoyLogicEngine)localObject).a();
    if (localObject != null)
    {
      ((Companion)this).a((FastWebModule)localObject, paramArticleInfo, paramFastWebArticleInfo, (FastWebModule.FastWebArticleRichReqCallback)paramCommentAndLikeCallBack);
      ((Companion)this).a(paramArticleInfo, paramCommentAndLikeCallBack);
      bool = false;
    }
    for (;;)
    {
      ((Companion)this).a(bool, paramArticleInfo, paramFastWebArticleInfo);
      return;
      QLog.d("RIJSocialBottomUtils", 1, "syncCommentAndLike, webModule is null!");
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    label88:
    Object localObject1;
    for (;;)
    {
      try
      {
        ViewGroup localViewGroup = RIJSocialBottomUtils.a();
        if (localViewGroup == null) {
          break label88;
        }
        localViewGroup = (ViewGroup)localViewGroup.findViewById(2131381873);
        if (localViewGroup == null) {
          break label93;
        }
        localObject2 = localViewGroup.getLayoutParams();
        if ((localObject2 instanceof FrameLayout.LayoutParams))
        {
          localObject2 = localViewGroup.getLayoutParams();
          if (localObject2 != null) {
            break;
          }
          throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
      }
      catch (Exception localException)
      {
        QLog.d("RIJSocialBottomUtils", 1, "adjustMarginBottom error!  msg = " + localException);
      }
      return;
      localObject1 = null;
      continue;
      label93:
      localObject2 = null;
    }
    Object localObject2 = (FrameLayout.LayoutParams)localObject2;
    if (paramBoolean) {}
    for (int i = RIJSocialBottomUtils.a();; i = 0)
    {
      ((FrameLayout.LayoutParams)localObject2).bottomMargin = i;
      localObject1.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      return;
    }
  }
  
  public final void a(boolean paramBoolean, @Nullable String paramString1, @Nullable String paramString2)
  {
    int i = 0;
    boolean bool;
    ReadInJoyFastWebBottomSocialViewNew localReadInJoyFastWebBottomSocialViewNew;
    if (paramBoolean)
    {
      bool = true;
      ((Companion)this).a(bool);
      localReadInJoyFastWebBottomSocialViewNew = RIJSocialBottomUtils.a();
      if (localReadInJoyFastWebBottomSocialViewNew != null) {
        if (!bool) {
          break label149;
        }
      }
    }
    for (;;)
    {
      localReadInJoyFastWebBottomSocialViewNew.setVisibility(i);
      QLog.d("RIJSocialBottomUtils", 1, "setSocialBottomViewStatus, isFirstInit=" + paramBoolean + ", show=" + bool + ", originUrl=" + paramString1 + ", currentUrl=" + paramString2);
      return;
      if ((TextUtils.isEmpty((CharSequence)paramString1)) || (TextUtils.isEmpty((CharSequence)paramString2)))
      {
        bool = false;
        break;
      }
      if (StringsKt.equals$default(paramString1, paramString2, false, 2, null))
      {
        bool = true;
        break;
      }
      bool = false;
      break;
      label149:
      i = 8;
    }
  }
  
  public final boolean a(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        ReadInJoyHelper.f();
        int i = Aladdin.getConfig(442).getIntegerFromString("can_add_social_bottom", 0);
        if (i != 1) {
          continue;
        }
        bool = true;
      }
      catch (Exception localException)
      {
        QLog.d("RIJSocialBottomUtils", 1, "canShowSocialBottomView error!  msg=" + localException);
        boolean bool = false;
        continue;
      }
      QLog.d("RIJSocialBottomUtils", 1, "canShowSocialBottomView, isWxArticle=" + paramBoolean + " ,switchOpen=" + bool);
      if ((!paramBoolean) || (!bool)) {
        break label111;
      }
      return true;
      bool = false;
    }
    label111:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.RIJSocialBottomUtils.Companion
 * JD-Core Version:    0.7.0.1
 */