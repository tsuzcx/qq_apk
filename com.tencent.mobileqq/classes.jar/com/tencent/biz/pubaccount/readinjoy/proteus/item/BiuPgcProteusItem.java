package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.common.ArticleInfoHelper;
import com.tencent.biz.pubaccount.readinjoy.common.GalleryReportedUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ListenerBuilder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.OnGalleryImageClickListener;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.proteus.data.ProteusItemDataBuilder;
import com.tencent.biz.pubaccount.readinjoy.proteus.data.Util;
import com.tencent.biz.pubaccount.readinjoy.proteus.utils.RIJBiuCardUtil;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.BiuCommentView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.PgcSmallView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.SummaryView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.helper.BindViewHelper;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.ComponentView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentBig;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentPgcVideo;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPGCShortContentBig;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;
import org.json.JSONObject;

public class BiuPgcProteusItem
  implements ProteusItem
{
  private void a(Context paramContext, IReadInJoyModel paramIReadInJoyModel, int paramInt)
  {
    OnGalleryImageClickListener localOnGalleryImageClickListener = paramIReadInJoyModel.a().a().a();
    paramIReadInJoyModel = paramIReadInJoyModel.a();
    if ((paramIReadInJoyModel != null) && (localOnGalleryImageClickListener != null)) {
      localOnGalleryImageClickListener.a(paramContext, paramIReadInJoyModel, 0, paramIReadInJoyModel.innerUniqueID, 6, paramInt, 0);
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
  
  private void a(ViewBase paramViewBase, IReadInJoyModel paramIReadInJoyModel)
  {
    if ((paramViewBase == null) || (paramIReadInJoyModel == null) || (paramIReadInJoyModel.a() == null)) {}
    do
    {
      return;
      paramViewBase = paramViewBase.findViewBaseByName("id_middle_body_wrapper");
    } while ((paramViewBase == null) || (paramViewBase.getNativeView() == null));
    ReadInJoyBaseAdapter localReadInJoyBaseAdapter = paramIReadInJoyModel.a();
    paramViewBase.getNativeView().setOnClickListener(new BiuPgcProteusItem.7(this, localReadInJoyBaseAdapter, paramIReadInJoyModel));
  }
  
  private View b(int paramInt, Context paramContext, IReadInJoyModel paramIReadInJoyModel)
  {
    paramIReadInJoyModel = paramIReadInJoyModel.a();
    if ((paramIReadInJoyModel != null) && (paramIReadInJoyModel.mSocialFeedInfo != null) && (paramIReadInJoyModel.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo != null) && (paramIReadInJoyModel.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a != null) && (paramIReadInJoyModel.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a.size() > 0) && (ComponentContentGridImage.a(paramIReadInJoyModel.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a.size(), paramIReadInJoyModel.mSocialFeedInfo.jdField_a_of_type_Int) == 1)) {
      return new ComponentContentBig(paramContext);
    }
    return new ComponentContentGridImage(paramContext);
  }
  
  private void b(int paramInt1, IReadInJoyModel paramIReadInJoyModel, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    ArticleInfo localArticleInfo = paramIReadInJoyModel.a();
    if ((localArticleInfo != null) && (localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a.size() > 0) && (ComponentContentGridImage.a(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a.size(), localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int) == 1))
    {
      c(paramInt1, paramIReadInJoyModel, paramNativeMiddleBodyView, paramInt2, paramContainer);
      return;
    }
    if ((paramNativeMiddleBodyView.a() instanceof ComponentContentGridImage))
    {
      paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
      paramNativeMiddleBodyView.a(ComponentContentGridImage.a(paramIReadInJoyModel, paramInt1));
      paramNativeMiddleBodyView.setMIReadInJoyModel(paramIReadInJoyModel);
      paramNativeMiddleBodyView.setGalleryClickListener(new BiuPgcProteusItem.5(this, paramIReadInJoyModel, paramContainer, paramInt2));
      return;
    }
    QLog.e("BiuPgcProteusItem", 1, "[bindGalleryBodyView] unexpected item: " + paramInt1 + " " + paramIReadInJoyModel.a());
  }
  
  private void c(int paramInt1, IReadInJoyModel paramIReadInJoyModel, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    if (!(paramNativeMiddleBodyView.a() instanceof AdapterView)) {
      paramNativeMiddleBodyView.a().setOnClickListener(new BiuPgcProteusItem.6(this, paramIReadInJoyModel, paramContainer, paramInt2));
    }
    ((ComponentView)paramNativeMiddleBodyView.a()).a(paramIReadInJoyModel);
  }
  
  public int a(ArticleInfo paramArticleInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    return GalleryReportedUtils.a(paramReadInJoyBaseAdapter.a(), RIJFeedsType.a(paramArticleInfo));
  }
  
  protected View a(int paramInt, Context paramContext, IReadInJoyModel paramIReadInJoyModel)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt);
    case 35: 
    case 114: 
      return new ComponentContentGridImage(paramContext);
    case 49: 
    case 62: 
    case 63: 
      return b(paramInt, paramContext, paramIReadInJoyModel);
    case 10: 
    case 12: 
    case 94: 
    case 95: 
      return new PgcSmallView(paramInt, paramContext);
    case 11: 
    case 28: 
      return new ComponentContentPgcVideo(paramContext);
    case 27: 
      return new ComponentContentBig(paramContext);
    case 113: 
      return new ComponentPGCShortContentBig(paramContext);
    case 33: 
      return new ComponentContentBig(paramContext);
    }
    return null;
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    ProteusItemDataBuilder localProteusItemDataBuilder = new ProteusItemDataBuilder();
    long l2 = 0L;
    long l1 = l2;
    if (paramBaseArticleInfo.mSocialFeedInfo != null)
    {
      l1 = l2;
      if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser != null) {
        l1 = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.a;
      }
    }
    if ((paramInt == 35) && (!paramBaseArticleInfo.isPGCShortContent())) {
      localProteusItemDataBuilder.c(paramBaseArticleInfo, HardCodeUtil.a(2131701230));
    }
    if (paramInt == 33) {
      localProteusItemDataBuilder.c(paramBaseArticleInfo, HardCodeUtil.a(2131701231));
    }
    if (paramInt != 33) {
      localProteusItemDataBuilder.A(paramBaseArticleInfo).D(paramBaseArticleInfo).B(paramBaseArticleInfo);
    }
    if ((paramInt != 10) && (paramInt != 12) && (paramInt != 94) && (paramInt != 95))
    {
      localProteusItemDataBuilder.o(paramBaseArticleInfo);
      localProteusItemDataBuilder.a(paramBaseArticleInfo).b(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).f(paramBaseArticleInfo).g(paramBaseArticleInfo).a(paramBaseArticleInfo, "Biu了").k(paramBaseArticleInfo).i(paramBaseArticleInfo).j(paramBaseArticleInfo).n(paramBaseArticleInfo).m(paramBaseArticleInfo).C(paramBaseArticleInfo).r(paramBaseArticleInfo).v(paramBaseArticleInfo).w(paramBaseArticleInfo).G(paramBaseArticleInfo).E(paramBaseArticleInfo).s(paramBaseArticleInfo).l(paramBaseArticleInfo).I(paramBaseArticleInfo).t(paramBaseArticleInfo).u(paramBaseArticleInfo);
      if (paramInt != 112) {
        localProteusItemDataBuilder.z(paramBaseArticleInfo);
      }
      if ((paramInt != 10) && (paramInt != 12) && (paramInt != 94) && (paramInt != 95)) {
        break label315;
      }
      localProteusItemDataBuilder.a("ReadInjoy_biu_small_pgc_cell");
    }
    for (;;)
    {
      return localProteusItemDataBuilder.a();
      if ((!paramBaseArticleInfo.mSocialFeedInfo.a()) || (ArticleInfoHelper.b(paramBaseArticleInfo))) {
        break;
      }
      localProteusItemDataBuilder.o(paramBaseArticleInfo);
      break;
      label315:
      if (RIJBiuCardUtil.a((ArticleInfo)paramBaseArticleInfo)) {
        localProteusItemDataBuilder.a("RIJ_biu_small_single_img_cell");
      } else {
        localProteusItemDataBuilder.a("RIJ_biu_cell");
      }
    }
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
    case 35: 
    case 114: 
      paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
      paramNativeMiddleBodyView.a(ComponentContentGridImage.a(paramIReadInJoyModel, paramInt1));
      paramNativeMiddleBodyView.setMIReadInJoyModel(paramIReadInJoyModel);
      paramNativeMiddleBodyView.setOnNoItemClickListener(new BiuPgcProteusItem.3(this, paramIReadInJoyModel));
      return;
    case 10: 
    case 11: 
    case 12: 
    case 27: 
    case 28: 
    case 33: 
    case 94: 
    case 95: 
    case 112: 
    case 113: 
      if ((paramNativeMiddleBodyView.a() instanceof AdapterView))
      {
        AIOUtils.a("BiuPgcProteusItem", "", new IllegalArgumentException(" adapterViewType " + paramInt1 + " articleInfo : " + paramIReadInJoyModel.a()));
        return;
      }
      paramNativeMiddleBodyView.a().setOnClickListener(new BiuPgcProteusItem.4(this, localReadInJoyBaseAdapter, paramIReadInJoyModel));
      ((ComponentView)paramNativeMiddleBodyView.a()).a(paramIReadInJoyModel);
      return;
    }
    b(paramInt1, paramIReadInJoyModel, paramNativeMiddleBodyView, paramInt2, paramContainer);
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    ReadInJoyMiddleBodyView localReadInJoyMiddleBodyView = (ReadInJoyMiddleBodyView)localViewBase.findViewBaseByName("id_middle_body_content");
    NativeMiddleBodyView localNativeMiddleBodyView;
    View localView;
    if (localReadInJoyMiddleBodyView != null)
    {
      localNativeMiddleBodyView = (NativeMiddleBodyView)localReadInJoyMiddleBodyView.getNativeView();
      if (localNativeMiddleBodyView.a() == null)
      {
        localView = a(paramInt1, paramContainer.getContext(), paramIReadInJoyModel);
        if ((localView instanceof PgcSmallView))
        {
          QLog.d("BiuPgcProteusItem", 2, "bindView | setTitleCustomStyle");
          ((PgcSmallView)localView).setTitleCustomStyle(localReadInJoyMiddleBodyView.a(), localReadInJoyMiddleBodyView.b(), localReadInJoyMiddleBodyView.d(), localReadInJoyMiddleBodyView.c());
        }
        if ((localView == null) || (!(localView.getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
          break label356;
        }
      }
    }
    label356:
    for (Object localObject = (RelativeLayout.LayoutParams)localView.getLayoutParams();; localObject = new RelativeLayout.LayoutParams(-2, -2))
    {
      localReadInJoyMiddleBodyView.a((RelativeLayout.LayoutParams)localObject);
      if (localView != null) {
        localNativeMiddleBodyView.a(localView, (RelativeLayout.LayoutParams)localObject);
      }
      a(paramInt1, paramIReadInJoyModel, localNativeMiddleBodyView, paramInt2, paramContainer);
      BindViewHelper.f(localViewBase, paramIReadInJoyModel);
      localObject = (BiuCommentView)localViewBase.findViewBaseByName("id_biu_comment");
      if (localObject != null) {
        ((BiuCommentView)localObject).a(paramIReadInJoyModel);
      }
      localObject = (SummaryView)localViewBase.findViewBaseByName("id_summary");
      if (localObject != null)
      {
        ((SummaryView)localObject).a(paramIReadInJoyModel);
        if ((paramInt1 == 49) || (paramInt1 == 62) || (paramInt1 == 63)) {
          ((SummaryView)localObject).setOnClickListener(new BiuPgcProteusItem.1(this, paramContainer, paramIReadInJoyModel, paramInt2));
        }
      }
      localObject = localViewBase.findViewBaseByName("id_social_bottom");
      if (((paramInt1 == 49) || (paramInt1 == 62) || (paramInt1 == 63)) && (localObject != null) && (((ViewBase)localObject).getNativeView() != null)) {
        ((ViewBase)localObject).getNativeView().setOnClickListener(new BiuPgcProteusItem.2(this, paramContainer, paramIReadInJoyModel, paramInt2));
      }
      BindViewHelper.a(localViewBase, paramIReadInJoyModel.a());
      a(localViewBase, paramIReadInJoyModel);
      Util.a(localViewBase, paramIReadInJoyModel);
      Util.b(localViewBase, paramIReadInJoyModel);
      BindViewHelper.b(localViewBase, paramIReadInJoyModel);
      BindViewHelper.c(localViewBase, paramIReadInJoyModel);
      BindViewHelper.d(localViewBase, paramIReadInJoyModel);
      return;
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.BiuPgcProteusItem
 * JD-Core Version:    0.7.0.1
 */