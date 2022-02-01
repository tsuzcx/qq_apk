package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.common.GalleryReportedUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ListenerBuilder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.OnGalleryImageClickListener;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.proteus.data.ProteusItemDataBuilder;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ArticleCommentView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.PgcSmallView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.helper.BindViewHelper;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.ComponentView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentBig;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentPgcVideo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.weaknet.ReadInJoyPTSCostHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.widget.TraceUtils;
import java.util.ArrayList;
import org.json.JSONObject;

public class PgcProteusItem
  implements ProteusItem
{
  private View a(int paramInt, Context paramContext, IReadInJoyModel paramIReadInJoyModel)
  {
    paramIReadInJoyModel = paramIReadInJoyModel.a();
    if ((paramIReadInJoyModel != null) && (paramIReadInJoyModel.mSocialFeedInfo != null) && (paramIReadInJoyModel.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo != null) && (paramIReadInJoyModel.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null) && (paramIReadInJoyModel.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (ComponentContentGridImage.a(paramIReadInJoyModel.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size(), paramIReadInJoyModel.mSocialFeedInfo.jdField_a_of_type_Int) == 1)) {
      return new ComponentContentBig(paramContext);
    }
    return new ComponentContentGridImage(paramContext);
  }
  
  private void a(Context paramContext, IReadInJoyModel paramIReadInJoyModel, int paramInt)
  {
    OnGalleryImageClickListener localOnGalleryImageClickListener = paramIReadInJoyModel.a().a().a();
    paramIReadInJoyModel = paramIReadInJoyModel.a();
    if ((paramIReadInJoyModel != null) && (localOnGalleryImageClickListener != null)) {
      localOnGalleryImageClickListener.a(paramContext, paramIReadInJoyModel, 0, paramIReadInJoyModel.innerUniqueID, 5, paramInt, 0);
    }
  }
  
  private void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, String paramString, int paramInt2, int paramInt3, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    int i = a(paramArticleInfo, paramReadInJoyBaseAdapter);
    paramReadInJoyBaseAdapter = paramReadInJoyBaseAdapter.a().a();
    if (paramReadInJoyBaseAdapter != null) {
      paramReadInJoyBaseAdapter.a(paramContext, paramArticleInfo, paramInt1, paramString, i, paramInt2, paramInt3);
    }
  }
  
  private void b(int paramInt1, IReadInJoyModel paramIReadInJoyModel, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    ArticleInfo localArticleInfo = paramIReadInJoyModel.a();
    if ((localArticleInfo != null) && (localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (ComponentContentGridImage.a(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size(), localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int) == 1))
    {
      c(paramInt1, paramIReadInJoyModel, paramNativeMiddleBodyView, paramInt2, paramContainer);
      return;
    }
    paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
    paramNativeMiddleBodyView.a(ComponentContentGridImage.a(paramIReadInJoyModel, paramInt1));
    paramNativeMiddleBodyView.setMIReadInJoyModel(paramIReadInJoyModel);
    paramNativeMiddleBodyView.setGalleryClickListener(new PgcProteusItem.5(this, paramIReadInJoyModel, paramContainer, paramInt2));
  }
  
  private void c(int paramInt1, IReadInJoyModel paramIReadInJoyModel, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    paramNativeMiddleBodyView.a().setOnClickListener(new PgcProteusItem.6(this, paramIReadInJoyModel, paramContainer, paramInt2));
    ((ComponentView)paramNativeMiddleBodyView.a()).a(paramIReadInJoyModel);
  }
  
  public int a(ArticleInfo paramArticleInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    return GalleryReportedUtils.a(paramReadInJoyBaseAdapter.a(), RIJFeedsType.a(paramArticleInfo));
  }
  
  protected View a(int paramInt, Context paramContext, IReadInJoyModel paramIReadInJoyModel, ReadInJoyMiddleBodyView paramReadInJoyMiddleBodyView)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt);
    case 34: 
    case 85: 
      paramContext = new ComponentContentGridImage(paramContext);
      if (paramReadInJoyMiddleBodyView.a())
      {
        paramContext.jdField_a_of_type_Int = paramReadInJoyMiddleBodyView.getComPaddingLeft();
        paramContext.b = paramReadInJoyMiddleBodyView.getComPaddingRight();
      }
      return paramContext;
    case 16: 
    case 20: 
    case 83: 
    case 86: 
      return new PgcSmallView(paramInt, paramContext);
    case 17: 
    case 19: 
    case 32: 
    case 84: 
      return new ComponentContentPgcVideo(paramContext);
    case 18: 
      return new ComponentContentBig(paramContext);
    case 48: 
    case 64: 
    case 65: 
      return a(paramInt, paramContext, paramIReadInJoyModel);
    case 29: 
      return new ComponentContentBig(paramContext);
    }
    return new ComponentContentBig(paramContext);
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    TraceUtils.traceBegin("PgcProteusItem.getDataJson");
    long l3 = System.currentTimeMillis();
    ProteusItemDataBuilder localProteusItemDataBuilder = new ProteusItemDataBuilder();
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramBaseArticleInfo.mSubscribeID);
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localNumberFormatException.printStackTrace();
      }
    }
    TraceUtils.traceBegin("PgcProteusItem.bindArticleComment");
    if ((paramInt != 20) && (paramInt != 16) && (paramInt != 83) && (paramInt != 86) && ((!TextUtils.isEmpty(paramBaseArticleInfo.mSummary)) || (!TextUtils.isEmpty(paramBaseArticleInfo.mTitle)) || ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaLangString != null)))) {
      localProteusItemDataBuilder.p(paramBaseArticleInfo);
    }
    TraceUtils.traceEnd();
    TraceUtils.traceBegin("PgcProteusItem.bindReadArticle");
    if ((paramInt == 34) || (paramInt == 85)) {
      localProteusItemDataBuilder.c(paramBaseArticleInfo, HardCodeUtil.a(2131707960));
    }
    TraceUtils.traceEnd();
    if (paramInt == 29) {
      localProteusItemDataBuilder.c(paramBaseArticleInfo, HardCodeUtil.a(2131707959));
    }
    TraceUtils.traceBegin("PgcProteusItem.bindTopicCapsule");
    if (paramInt != 29) {
      localProteusItemDataBuilder.A(paramBaseArticleInfo).D(paramBaseArticleInfo).B(paramBaseArticleInfo);
    }
    TraceUtils.traceEnd();
    TraceUtils.traceBegin("PgcProteusItem.bindPublicAccountFollowButton");
    TraceUtils.traceEnd();
    localProteusItemDataBuilder.a(paramBaseArticleInfo).b(paramBaseArticleInfo).r(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).d(paramBaseArticleInfo).j(paramBaseArticleInfo).i(paramBaseArticleInfo).g(paramBaseArticleInfo).k(paramBaseArticleInfo).v(paramBaseArticleInfo).w(paramBaseArticleInfo).C(paramBaseArticleInfo).a("ReadInjoy_original_cell").E(paramBaseArticleInfo).l(paramBaseArticleInfo).I(paramBaseArticleInfo).t(paramBaseArticleInfo).u(paramBaseArticleInfo);
    TraceUtils.traceBegin("PgcProteusItem.bindMiddleBody");
    localProteusItemDataBuilder.z(paramBaseArticleInfo);
    TraceUtils.traceEnd();
    TraceUtils.traceEnd();
    ReadInJoyPTSCostHelper.a("PgcProteusItem", String.valueOf(paramInt), "PgcProteusItem.getDataJson", System.currentTimeMillis() - l3);
    return localProteusItemDataBuilder.a();
  }
  
  protected void a(int paramInt1, IReadInJoyModel paramIReadInJoyModel, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    if ((paramNativeMiddleBodyView.a() == null) || (paramIReadInJoyModel.a() == null)) {
      return;
    }
    ReadInJoyBaseAdapter localReadInJoyBaseAdapter = paramIReadInJoyModel.a();
    switch (paramInt1)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt1);
    case 34: 
    case 85: 
      paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
      paramNativeMiddleBodyView.a(ComponentContentGridImage.a(paramIReadInJoyModel, paramInt1));
      paramNativeMiddleBodyView.setMIReadInJoyModel(paramIReadInJoyModel);
      paramNativeMiddleBodyView.setOnNoItemClickListener(new PgcProteusItem.3(this, paramIReadInJoyModel));
      return;
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 31: 
    case 32: 
    case 83: 
    case 84: 
    case 86: 
      paramNativeMiddleBodyView.a().setOnClickListener(new PgcProteusItem.4(this, paramIReadInJoyModel, localReadInJoyBaseAdapter));
      ((ComponentView)paramNativeMiddleBodyView.a()).a(paramIReadInJoyModel);
      return;
    case 48: 
    case 64: 
    case 65: 
      b(paramInt1, paramIReadInJoyModel, paramNativeMiddleBodyView, paramInt2, paramContainer);
      return;
    }
    ((ComponentView)paramNativeMiddleBodyView.a()).a(paramIReadInJoyModel);
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    long l = System.currentTimeMillis();
    TraceUtils.traceBegin("PgcProteusItem.bindView");
    ViewBase localViewBase = paramContainer.getVirtualView();
    c(paramInt1, paramContainer, paramIReadInJoyModel, paramInt2, localViewBase);
    b(paramIReadInJoyModel, localViewBase);
    a(paramIReadInJoyModel, localViewBase);
    b(paramInt1, paramContainer, paramIReadInJoyModel, paramInt2, localViewBase);
    a(paramInt1, paramContainer, paramIReadInJoyModel, paramInt2, localViewBase);
    TraceUtils.traceBegin("PgcProteusItem.bindView.bindJumpChannel");
    BindViewHelper.b(localViewBase, paramIReadInJoyModel);
    TraceUtils.traceEnd();
    TraceUtils.traceBegin("PgcProteusItem.bindView.bindSocialCommon");
    BindViewHelper.c(localViewBase, paramIReadInJoyModel);
    TraceUtils.traceEnd();
    TraceUtils.traceBegin("PgcProteusItem.bindView.bindFlowGuideSperator");
    BindViewHelper.d(localViewBase, paramIReadInJoyModel);
    TraceUtils.traceEnd();
    TraceUtils.traceEnd();
    ReadInJoyPTSCostHelper.a("PgcProteusItem", String.valueOf(paramInt1), "PgcProteusItem.bindView", System.currentTimeMillis() - l);
  }
  
  protected void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2, ViewBase paramViewBase)
  {
    TraceUtils.traceBegin("PgcProteusItem.bindView.socialBottomBar");
    paramViewBase = paramViewBase.findViewBaseByName("id_social_bottom");
    if (((paramInt1 == 48) || (paramInt1 == 64) || (paramInt1 == 65)) && (paramViewBase != null) && (paramViewBase.getNativeView() != null)) {
      paramViewBase.getNativeView().setOnClickListener(new PgcProteusItem.1(this, paramContainer, paramIReadInJoyModel, paramInt2));
    }
    TraceUtils.traceEnd();
  }
  
  protected void a(IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    TraceUtils.traceBegin("PgcProteusItem.bindView.bindBiuTime");
    BindViewHelper.a(paramViewBase, paramIReadInJoyModel.a());
    TraceUtils.traceEnd();
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    return false;
  }
  
  protected void b(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2, ViewBase paramViewBase)
  {
    paramViewBase = (ArticleCommentView)paramViewBase.findViewBaseByName("id_article_comment");
    TraceUtils.traceBegin("PgcProteusItem.bindView.commentView");
    if (paramViewBase != null)
    {
      if ((paramInt1 == 48) || (paramInt1 == 64) || (paramInt1 == 65)) {
        paramViewBase.setOnClickListener(new PgcProteusItem.2(this, paramContainer, paramIReadInJoyModel, paramInt2));
      }
      paramViewBase.setVisibility(0);
    }
    if ((paramViewBase != null) && (paramViewBase.isVisible())) {
      paramViewBase.a(paramIReadInJoyModel);
    }
    TraceUtils.traceEnd();
  }
  
  protected void b(IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    BindViewHelper.f(paramViewBase, paramIReadInJoyModel);
  }
  
  protected void c(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2, ViewBase paramViewBase)
  {
    TraceUtils.traceBegin("PgcProteusItem.bindView.findViewBaseByName");
    ReadInJoyMiddleBodyView localReadInJoyMiddleBodyView = (ReadInJoyMiddleBodyView)paramViewBase.findViewBaseByName("id_middle_body_content");
    TraceUtils.traceEnd();
    TraceUtils.traceBegin("PgcProteusItem.bindView.bodyviewContent");
    NativeMiddleBodyView localNativeMiddleBodyView;
    View localView;
    if (localReadInJoyMiddleBodyView != null)
    {
      localNativeMiddleBodyView = (NativeMiddleBodyView)localReadInJoyMiddleBodyView.getNativeView();
      if (localNativeMiddleBodyView.a() == null)
      {
        localView = a(paramInt1, paramContainer.getContext(), paramIReadInJoyModel, localReadInJoyMiddleBodyView);
        if ((localView == null) || (!(localView.getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
          break label136;
        }
      }
    }
    label136:
    for (paramViewBase = (RelativeLayout.LayoutParams)localView.getLayoutParams();; paramViewBase = new RelativeLayout.LayoutParams(-2, -2))
    {
      localReadInJoyMiddleBodyView.a(paramViewBase);
      if (localView != null) {
        localNativeMiddleBodyView.a(localView, paramViewBase);
      }
      TraceUtils.traceBegin("PgcProteusItem.bindView.bindBodyView");
      a(paramInt1, paramIReadInJoyModel, localNativeMiddleBodyView, paramInt2, paramContainer);
      TraceUtils.traceEnd();
      TraceUtils.traceEnd();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.PgcProteusItem
 * JD-Core Version:    0.7.0.1
 */