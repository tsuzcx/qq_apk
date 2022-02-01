package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.proteus.data.ProteusItemDataBuilder;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.PgcSmallView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyVideoView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.helper.BindViewHelper;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeVideoView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.ComponentView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage;
import com.tencent.biz.pubaccount.readinjoy.srtUtils.ShortWithLongContentUtil;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.IReadInJoyListItemAutoPlayCallback;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.QShareUtils;
import com.tencent.biz.pubaccount.util.ReadInJoyShareHelperV2;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class PgcShortContentProteusItem
  extends PgcProteusItem
{
  private QShareUtils jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesQShareUtils;
  private ReadInJoyShareHelperV2 jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2;
  
  private List<Integer> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(13));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(3));
    localArrayList.add(Integer.valueOf(9));
    localArrayList.add(Integer.valueOf(10));
    return localArrayList;
  }
  
  private void a(View paramView, String paramString)
  {
    if ((paramView instanceof VideoView))
    {
      Object localObject = (VideoView)paramView;
      long l = ((VideoView)localObject).getPercentage();
      int i;
      if (((VideoView)localObject).isMute()) {
        i = 0;
      }
      try
      {
        for (;;)
        {
          localObject = RIJJumpUtils.a(paramString, l, i);
          if (QLog.isColorLevel()) {
            QLog.i("PgcShortContentProteusItem", 1, " STR_ID_SHORT_CONTENT_VIDEO_JUMP_CLICK jump, percentage=" + l + ",mute=" + i + ",oldScheme=" + paramString + ",newScheme=" + (String)localObject);
          }
          RIJJumpUtils.a(paramView.getContext(), (String)localObject, null);
          return;
          i = 1;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("PgcShortContentProteusItem", 1, "buildNewScheme exception, e=" + localException.getMessage());
          String str = paramString;
        }
      }
    }
    QLog.e("PgcShortContentProteusItem", 1, "handleJumpScheme failed, view is not VideoView");
  }
  
  private void a(ArticleInfo paramArticleInfo)
  {
    String str = RIJTransMergeKanDianReport.a(paramArticleInfo);
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, paramArticleInfo.mSubscribeID, "0X800AB52", "0X800AB52", 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, str, false);
  }
  
  private void a(ViewBase paramViewBase, IReadInJoyModel paramIReadInJoyModel, Container paramContainer)
  {
    Object localObject = (ReadInJoyVideoView)paramViewBase.findViewBaseByName("id_pgc_short_content_video_view");
    if (localObject == null) {}
    ViewBase localViewBase;
    NativeVideoView localNativeVideoView;
    ViewBean localViewBean;
    do
    {
      return;
      localViewBase = paramViewBase.findViewBaseByName("id_pgc_short_content_video_audio_icon");
      paramViewBase = paramViewBase.findViewBaseByName("id_pgc_float_contain");
      localNativeVideoView = ((ReadInJoyVideoView)localObject).a();
      localViewBean = paramIReadInJoyModel.a().mProteusTemplateBean.getViewBean().findViewFromChild("id_pgc_short_content_video_audio_icon");
    } while ((localViewBase == null) || (paramViewBase == null) || (localNativeVideoView == null) || (localViewBean == null));
    localViewBase.setVisibility(8);
    paramViewBase.setVisibility(0);
    localNativeVideoView.needInterceptGlobalLayoutChanged = true;
    localNativeVideoView.setMute(true);
    localViewBean.putMapValue("pgc_video_content_audio_icon", "video_audio_mute");
    localViewBase.bindDynamicValue(localViewBean);
    localObject = ((ReadInJoyVideoView)localObject).a();
    PgcShortContentProteusItem.6 local6 = new PgcShortContentProteusItem.6(this);
    PgcShortContentProteusItem.Bool localBool = new PgcShortContentProteusItem.Bool(this, true);
    if ((IReadInJoyListItemAutoPlayCallback)paramContainer.getTag(2131376584) == null) {
      paramContainer.setTag(2131376584, new PgcShortContentProteusItem.7(this, (View)localObject, localBool, localNativeVideoView));
    }
    localNativeVideoView.setOnCheckShownListener(local6);
    if (localObject != null) {
      ((View)localObject).addOnAttachStateChangeListener(new PgcShortContentProteusItem.9(this, paramIReadInJoyModel, localNativeVideoView, localBool, new PgcShortContentProteusItem.8(this, localNativeVideoView, localViewBean, localViewBase)));
    }
    localNativeVideoView.setOnProgressChangedListener(new PgcShortContentProteusItem.10(this, paramViewBase));
    localNativeVideoView.setVideoPlayListener(new PgcShortContentProteusItem.11(this, localNativeVideoView, localViewBase, paramViewBase));
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt != 109) && (paramInt != 133) && (paramInt != 134);
  }
  
  private void c(IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2 = paramIReadInJoyModel.a().a();
    this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2 = new ReadInJoyShareHelperV2((Activity)localObject2, (AppInterface)localObject1, new PgcShortContentProteusItem.PgcShortContentProteusItemSheetClickProcessor(this, paramIReadInJoyModel.a(), new WeakReference(localObject2)));
    paramViewBase.getNativeView().addOnAttachStateChangeListener(new PgcShortContentProteusItem.12(this));
    localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2.a().getIntent();
    if ((localObject1 != null) && (TextUtils.isEmpty(((Intent)localObject1).getStringExtra("big_brother_source_key")))) {
      ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_feeds_kandian");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2.a().setActionSheetTitle(HardCodeUtil.a(2131713537));
    if (paramViewBase.getName().equals("id_share_button_style_a"))
    {
      paramViewBase = this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2;
      localObject1 = a();
      localObject2 = paramIReadInJoyModel.a().mOriginalUrl;
      paramIReadInJoyModel = paramIReadInJoyModel.a();
      paramViewBase.a(new List[] { localObject1 }, 22, (String)localObject2, paramIReadInJoyModel);
      return;
    }
    paramViewBase = this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2;
    localObject1 = a();
    localObject2 = paramIReadInJoyModel.a().mOriginalUrl;
    paramIReadInJoyModel = paramIReadInJoyModel.a();
    paramViewBase.a(new List[] { localObject1 }, 13, (String)localObject2, paramIReadInJoyModel);
  }
  
  protected View a(int paramInt, Context paramContext, IReadInJoyModel paramIReadInJoyModel, ReadInJoyMiddleBodyView paramReadInJoyMiddleBodyView)
  {
    paramIReadInJoyModel = paramIReadInJoyModel.a();
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt);
    case 111: 
      return new PgcShortContentProteusItem.1(this, paramContext, paramIReadInJoyModel);
    case 110: 
      return new PgcShortContentProteusItem.2(this, paramContext, paramIReadInJoyModel);
    case 132: 
      return new PgcSmallView(132, paramContext);
    }
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    ProteusItemDataBuilder localProteusItemDataBuilder = new ProteusItemDataBuilder();
    label259:
    for (;;)
    {
      try
      {
        long l = Long.parseLong(paramBaseArticleInfo.mSubscribeID);
        localNumberFormatException1.printStackTrace();
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        try
        {
          ReadInJoyUserInfoModule.a(l, null);
          localProteusItemDataBuilder.a(paramBaseArticleInfo, l);
          if ((paramInt != 20) && (paramInt != 16) && (paramInt != 83) && (paramInt != 86) && ((!TextUtils.isEmpty(paramBaseArticleInfo.mSummary)) || (!TextUtils.isEmpty(paramBaseArticleInfo.mTitle)) || ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaLangString != null)))) {
            localProteusItemDataBuilder.p(paramBaseArticleInfo);
          }
          if ((paramInt == 34) || (paramInt == 85)) {
            localProteusItemDataBuilder.c(paramBaseArticleInfo, HardCodeUtil.a(2131707961));
          }
          localProteusItemDataBuilder.i(paramBaseArticleInfo);
          if (a(paramInt)) {
            localProteusItemDataBuilder.z(paramBaseArticleInfo);
          }
          localProteusItemDataBuilder.a(paramBaseArticleInfo).b(paramBaseArticleInfo).r(paramBaseArticleInfo).e(paramBaseArticleInfo).d(paramBaseArticleInfo).j(paramBaseArticleInfo).g(paramBaseArticleInfo).k(paramBaseArticleInfo).v(paramBaseArticleInfo).w(paramBaseArticleInfo).a("ReadInjoy_pgc_shortcontent_cell").E(paramBaseArticleInfo).l(paramBaseArticleInfo).I(paramBaseArticleInfo).t(paramBaseArticleInfo).u(paramBaseArticleInfo);
          if (paramInt == 133) {
            localProteusItemDataBuilder.Q(paramBaseArticleInfo);
          }
          localProteusItemDataBuilder.C(paramBaseArticleInfo);
          return localProteusItemDataBuilder.a();
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          break label259;
        }
        localNumberFormatException1 = localNumberFormatException1;
        l = 0L;
      }
    }
  }
  
  protected void a(int paramInt1, IReadInJoyModel paramIReadInJoyModel, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    if ((paramNativeMiddleBodyView.a() == null) || (paramIReadInJoyModel.a() == null)) {}
    for (;;)
    {
      return;
      ReadInJoyBaseAdapter localReadInJoyBaseAdapter = paramIReadInJoyModel.a();
      switch (paramInt1)
      {
      default: 
        return;
      case 110: 
        ShortWithLongContentUtil.a(paramIReadInJoyModel.a());
        paramNativeMiddleBodyView.a().setOnClickListener(new PgcShortContentProteusItem.4(this, paramIReadInJoyModel, paramContainer, localReadInJoyBaseAdapter));
        ((ComponentView)paramNativeMiddleBodyView.a()).a(paramIReadInJoyModel);
        return;
      case 111: 
        ShortWithLongContentUtil.a(paramIReadInJoyModel.a());
        paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
        paramContainer = ComponentContentGridImage.a(paramIReadInJoyModel, paramInt1);
        paramNativeMiddleBodyView.setMIReadInJoyModel(paramIReadInJoyModel);
        paramNativeMiddleBodyView.a(paramContainer);
        paramNativeMiddleBodyView.setOnNoItemClickListener(new PgcShortContentProteusItem.3(this, paramIReadInJoyModel));
        return;
      }
      paramNativeMiddleBodyView = (PgcSmallView)paramNativeMiddleBodyView.a();
      ShortWithLongContentUtil.a(paramIReadInJoyModel.a());
      paramNativeMiddleBodyView.a(paramIReadInJoyModel);
      try
      {
        if ((paramIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_Boolean) && (paramIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$LongContentInfo != null))
        {
          paramNativeMiddleBodyView.setOnClickListener(new PgcShortContentProteusItem.5(this, paramIReadInJoyModel, paramNativeMiddleBodyView, paramContainer));
          return;
        }
      }
      catch (NullPointerException paramIReadInJoyModel)
      {
        QLog.e("PgcShortContentProteusItem", 1, paramIReadInJoyModel.toString());
      }
    }
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    BindViewHelper.f(localViewBase, paramIReadInJoyModel);
    BindViewHelper.e(localViewBase, paramIReadInJoyModel);
    BindViewHelper.a(localViewBase, paramIReadInJoyModel.a());
    BindViewHelper.c(localViewBase, paramIReadInJoyModel);
    c(paramInt1, paramContainer, paramIReadInJoyModel, paramInt2, localViewBase);
    b(paramInt1, paramContainer, paramIReadInJoyModel, paramInt2, localViewBase);
    a(paramInt1, paramContainer, paramIReadInJoyModel, paramInt2, localViewBase);
    BindViewHelper.b(localViewBase, paramIReadInJoyModel);
    BindViewHelper.d(localViewBase, paramIReadInJoyModel);
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
    {
    }
    for (;;)
    {
      return super.a(paramInt, paramContainer, paramIReadInJoyModel, paramViewBase);
      paramViewBase.setOnClickListener(new PgcShortContentProteusItem.13(this, paramIReadInJoyModel));
      return true;
      paramViewBase.setOnClickListener(new PgcShortContentProteusItem.14(this, paramViewBase, paramIReadInJoyModel));
      continue;
      paramViewBase.setOnClickListener(new PgcShortContentProteusItem.15(this, paramIReadInJoyModel, paramViewBase));
    }
  }
  
  protected void c(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2, ViewBase paramViewBase)
  {
    super.c(paramInt1, paramContainer, paramIReadInJoyModel, paramInt2, paramViewBase);
    if (paramInt1 == 133) {}
    try
    {
      a(paramViewBase, paramIReadInJoyModel, paramContainer);
      return;
    }
    catch (NullPointerException paramContainer)
    {
      QLog.e("PgcShortContentProteusItem", 1, paramContainer.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.PgcShortContentProteusItem
 * JD-Core Version:    0.7.0.1
 */