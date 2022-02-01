package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuBehaviour;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils.CommentReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.comment.guide.GuidePopuppWindow;
import com.tencent.biz.pubaccount.readinjoy.comment.guide.GuidePopuppWindow.OnGuideDismissListener;
import com.tencent.biz.pubaccount.readinjoy.common.ProteusSupportUtil;
import com.tencent.biz.pubaccount.readinjoy.common.RIJSocialBottomUtils;
import com.tencent.biz.pubaccount.readinjoy.common.RIJSocialBottomUtils.Companion;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.common.TimeSliceHelper;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.CommentGuideConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAladdinUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertController;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertRecordAction.ActionType;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data.RIJFeedsInsertAction;
import com.tencent.biz.pubaccount.readinjoy.logic.KandianFavoriteBroadcastReceiver;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager.AtlasCallback;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelModule;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelModule.UserLevelCallBack;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelRequestModule.UserLevelInfo;
import com.tencent.biz.pubaccount.readinjoy.proteus.wrap.ReadInjoyContext;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebDislikeUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebPTSDataConverter;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class ReadInJoyFastWebBottomSocialViewNew
  extends FrameLayout
{
  public static final String a;
  public static final String b;
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private GuidePopuppWindow jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentGuideGuidePopuppWindow;
  private KandianFavoriteBroadcastReceiver jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver;
  ReadInJoyAtlasManager.AtlasCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback = new ReadInJoyFastWebBottomSocialViewNew.6(this);
  private RIJUserLevelModule.UserLevelCallBack jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJUserLevelModule$UserLevelCallBack;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private ReadInJoyFastWebBottomSocialViewNew.DoShareClick jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew$DoShareClick = null;
  private ReadInJoyFastWebBottomSocialViewNew.OnOpenCommentEditListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew$OnOpenCommentEditListener;
  private TemplateBean jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean;
  private Container jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  private Share jdField_a_of_type_ComTencentBizWebviewpluginShare;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  private HashMap<String, ArrayList<String>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b;
  private boolean c;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131712805);
    jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131712985);
  }
  
  public ReadInJoyFastWebBottomSocialViewNew(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Boolean = false;
    c();
  }
  
  public ReadInJoyFastWebBottomSocialViewNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Boolean = false;
  }
  
  private String a()
  {
    String str = "1";
    if (this.jdField_a_of_type_Boolean) {
      str = "3";
    }
    return str;
  }
  
  private void a(int paramInt, Context paramContext, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    f(paramContext, paramArticleInfo, paramFastWebArticleInfo);
    paramArticleInfo = RIJUserLevelModule.a();
    if (paramArticleInfo != null) {
      paramArticleInfo.a(paramContext, paramInt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJUserLevelModule$UserLevelCallBack);
    }
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new ReadInjoyContext();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(paramContext);
    ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "native_article");
  }
  
  private void a(Context paramContext, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew$OnOpenCommentEditListener == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew$OnOpenCommentEditListener.a())) && ((paramContext instanceof Activity))) {
      ReadInJoyCommentUtils.a((Activity)paramContext, paramArticleInfo, null, 4, "", null, false, null, -1);
    }
    String str = new ReadInJoyCommentUtils.CommentReportR5Builder(paramArticleInfo, null).a(1).a();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(RIJQQAppInterfaceUtil.a(), ReadInJoyCommentUtils.a(paramArticleInfo), "0X800900C", "0X800900C", 0, 0, String.valueOf(paramArticleInfo.mArticleID), String.valueOf(paramArticleInfo.mStrategyId), paramArticleInfo.innerUniqueID, str, false);
    int i = (int)paramArticleInfo.mChannelID;
    if (paramFastWebArticleInfo.c()) {}
    for (paramFastWebArticleInfo = "2";; paramFastWebArticleInfo = "1")
    {
      ReportUtil.a(paramArticleInfo, "0X8008990", RIJTransMergeKanDianReport.a(paramContext, paramArticleInfo, i, paramFastWebArticleInfo).toString());
      return;
    }
  }
  
  private void a(Context paramContext, FastWebArticleInfo paramFastWebArticleInfo)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b())) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a();
    }
    ArticleInfo localArticleInfo1;
    Context localContext;
    ArticleInfo localArticleInfo2;
    int i;
    if ((paramContext != null) && (paramFastWebArticleInfo != null))
    {
      if (BiuBehaviour.b() != 1) {
        break label108;
      }
      a(bool, paramContext, paramFastWebArticleInfo);
      localArticleInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      localContext = this.jdField_a_of_type_AndroidContentContext;
      localArticleInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      i = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
      if (!paramFastWebArticleInfo.c()) {
        break label114;
      }
    }
    label108:
    label114:
    for (paramContext = "2";; paramContext = "1")
    {
      ReportUtil.a(localArticleInfo1, "0X8008991", RIJTransMergeKanDianReport.a(localContext, localArticleInfo2, i, paramContext, 0).toString());
      return;
      bool = false;
      break;
    }
  }
  
  private void a(RIJUserLevelRequestModule.UserLevelInfo paramUserLevelInfo, Context paramContext, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (paramUserLevelInfo == null) {
      return;
    }
    switch (paramUserLevelInfo.currentOpType)
    {
    default: 
      return;
    case 1: 
      g(paramContext, paramArticleInfo, paramFastWebArticleInfo);
      return;
    case 2: 
      j(paramContext, paramArticleInfo, paramFastWebArticleInfo);
      return;
    }
    h(paramContext, paramArticleInfo, paramFastWebArticleInfo);
  }
  
  private void a(ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver = new KandianFavoriteBroadcastReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback);
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("com.tencent.process.fav");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver, (IntentFilter)localObject);
    }
    Object localObject = new ArrayList();
    ((List)localObject).add(paramArticleInfo.innerUniqueID);
    ReadInJoyAtlasManager.a().a((List)localObject, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback);
  }
  
  private void a(ProteusItemData paramProteusItemData)
  {
    if ((paramProteusItemData == null) || (paramProteusItemData.c == null)) {}
    while (!paramProteusItemData.c.has("like_normalstate_image")) {
      return;
    }
    FastWebDislikeUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X80099DA", a());
  }
  
  private void a(ProteusItemData paramProteusItemData, Context paramContext, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (!a()) {
      return;
    }
    ViewBase localViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView();
    ViewFactory.findClickableViewListener(localViewBase, new ReadInJoyFastWebBottomSocialViewNew.1(this, paramProteusItemData, paramContext));
    a(localViewBase, paramContext, paramFastWebArticleInfo);
  }
  
  private void a(ViewBase paramViewBase)
  {
    if (paramViewBase.findViewBaseByName("id_biu") != null)
    {
      if (!RIJAladdinUtils.b()) {
        break label61;
      }
      paramViewBase.findViewBaseByName("id_biu").setVisibility(0);
    }
    for (;;)
    {
      if (paramViewBase.findViewBaseByName("id_share") != null)
      {
        if ((RIJAladdinUtils.b()) || (!RIJAladdinUtils.c())) {
          break;
        }
        paramViewBase.findViewBaseByName("id_share").setVisibility(0);
      }
      return;
      label61:
      paramViewBase.findViewBaseByName("id_biu").setVisibility(4);
      FastWebDislikeUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X8009A5A", a());
    }
    paramViewBase.findViewBaseByName("id_share").setVisibility(4);
  }
  
  private void a(ViewBase paramViewBase, Context paramContext, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (paramViewBase == null) {}
    do
    {
      do
      {
        return;
        paramViewBase = paramViewBase.findViewBaseByName("id_biu");
      } while (paramViewBase == null);
      paramViewBase = paramViewBase.getNativeView();
    } while (paramViewBase == null);
    paramViewBase.setOnLongClickListener(new ReadInJoyFastWebBottomSocialViewNew.7(this, paramContext, paramFastWebArticleInfo));
  }
  
  private void a(JSONObject paramJSONObject)
  {
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean.bindData(paramJSONObject);
      ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean.getViewBean());
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, "refresh error!  msg=" + paramJSONObject);
    }
  }
  
  private void a(boolean paramBoolean, Context paramContext, FastWebArticleInfo paramFastWebArticleInfo)
  {
    RIJSocialBottomUtils.a.a(18, 0, paramBoolean, paramContext, 2002, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramFastWebArticleInfo);
  }
  
  private boolean a()
  {
    String str = "";
    boolean bool;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer == null)
    {
      bool = false;
      str = "" + "mContentView is null!";
    }
    for (;;)
    {
      if (!bool) {
        QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, "isParamsValidity error!  msg=" + str);
      }
      return bool;
      bool = true;
    }
  }
  
  private boolean a(Context paramContext, ArticleInfo paramArticleInfo, GuidePopuppWindow.OnGuideDismissListener paramOnGuideDismissListener)
  {
    if (!(paramContext instanceof Activity)) {
      return false;
    }
    paramContext = (Activity)paramContext;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentGuideGuidePopuppWindow == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentGuideGuidePopuppWindow = new GuidePopuppWindow(paramContext, paramArticleInfo);
    }
    if ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentGuideGuidePopuppWindow.a(paramArticleInfo.innerUniqueID)) && (CommentGuideConfigHandler.b()))
    {
      if (this.jdField_a_of_type_AndroidViewView == null) {
        this.jdField_a_of_type_AndroidViewView = ((ViewStub)paramContext.findViewById(2131376571)).inflate();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentGuideGuidePopuppWindow.a(new ReadInJoyFastWebBottomSocialViewNew.4(this, paramOnGuideDismissListener));
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentGuideGuidePopuppWindow.a(paramArticleInfo);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentGuideGuidePopuppWindow.a(paramContext.getWindow().getDecorView());
      return true;
    }
    return false;
  }
  
  private void b(Context paramContext, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if ((paramContext instanceof FastWebActivity))
    {
      if (paramArticleInfo != null) {
        RIJFeedsDynamicInsertController.a.a(paramArticleInfo.innerUniqueID, new RIJFeedsInsertAction(RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_SHARE, 0, 0, 0), 5);
      }
      ((FastWebActivity)paramContext).a(false, true);
    }
    for (;;)
    {
      FastWebDislikeUtils.a(paramArticleInfo, "0X8009A5B", a());
      return;
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew$DoShareClick != null)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew$DoShareClick.a(paramContext, paramArticleInfo, paramFastWebArticleInfo);
      }
    }
  }
  
  private void c() {}
  
  private void c(Context paramContext, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    g(paramContext, paramArticleInfo, paramFastWebArticleInfo);
  }
  
  private void d() {}
  
  private void d(Context paramContext, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    h(paramContext, paramArticleInfo, paramFastWebArticleInfo);
  }
  
  private void e() {}
  
  private void e(Context paramContext, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    a(2, paramContext, paramArticleInfo, paramFastWebArticleInfo);
  }
  
  private void f(Context paramContext, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJUserLevelModule$UserLevelCallBack == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJUserLevelModule$UserLevelCallBack = new ReadInJoyFastWebBottomSocialViewNew.2(this, paramContext, paramArticleInfo, paramFastWebArticleInfo);
    }
  }
  
  private void g(Context paramContext, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if ((paramContext == null) || (paramArticleInfo == null) || (paramFastWebArticleInfo == null)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        RIJSocialBottomUtils.a.a(paramContext, paramArticleInfo, true);
        return;
      }
    } while (a(paramContext, paramArticleInfo, new ReadInJoyFastWebBottomSocialViewNew.3(this, paramContext, paramArticleInfo, paramFastWebArticleInfo)));
    a(paramContext, paramArticleInfo, paramFastWebArticleInfo);
  }
  
  private void h(Context paramContext, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (paramFastWebArticleInfo == null)
    {
      QLog.d("ReadInJoyFastWebBottomSocialViewNew", 2, "like click event failed");
      return;
    }
    if (paramFastWebArticleInfo.jdField_a_of_type_Boolean)
    {
      paramFastWebArticleInfo.jdField_a_of_type_Boolean = false;
      paramFastWebArticleInfo.jdField_a_of_type_Int -= 1;
      ReportUtil.b(paramArticleInfo, "0X8009765", a());
    }
    for (;;)
    {
      d();
      i(paramContext, paramArticleInfo, paramFastWebArticleInfo);
      a(paramFastWebArticleInfo.jdField_a_of_type_Int);
      ReadInJoyLogicEngineEventDispatcher.a().e();
      ReadInJoyLogicEngine.a().a(ReadInJoyUtils.a(), paramFastWebArticleInfo.jdField_a_of_type_Boolean, paramFastWebArticleInfo);
      if ((paramArticleInfo == null) || (!paramFastWebArticleInfo.jdField_a_of_type_Boolean)) {
        break;
      }
      RIJFeedsDynamicInsertController.a.a(paramArticleInfo.innerUniqueID, new RIJFeedsInsertAction(RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_LOVE, 0, 0, 0), 5);
      return;
      paramFastWebArticleInfo.jdField_a_of_type_Boolean = true;
      paramFastWebArticleInfo.jdField_a_of_type_Int += 1;
      ReportUtil.b(paramArticleInfo, "0X8009764", a());
    }
  }
  
  private void i(Context paramContext, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    setData(paramContext, paramFastWebArticleInfo, paramArticleInfo);
  }
  
  private void j(Context paramContext, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b())) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a();
    }
    int i;
    if ((paramArticleInfo != null) && (paramContext != null))
    {
      TimeSliceHelper.c(paramArticleInfo.innerUniqueID);
      if (BiuBehaviour.a() != 1) {
        break label93;
      }
      a(bool, paramContext, paramFastWebArticleInfo);
      i = (int)paramArticleInfo.mChannelID;
      if (!paramFastWebArticleInfo.c()) {
        break label99;
      }
    }
    label93:
    label99:
    for (paramFastWebArticleInfo = "2";; paramFastWebArticleInfo = "1")
    {
      ReportUtil.a(paramArticleInfo, "0X8008991", RIJTransMergeKanDianReport.a(paramContext, paramArticleInfo, i, paramFastWebArticleInfo, 0).toString());
      return;
      bool = false;
      break;
    }
  }
  
  private void k(Context paramContext, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (paramArticleInfo == null) {
      return;
    }
    if ((paramContext instanceof FastWebActivity))
    {
      QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, "enter scroll");
      ((FastWebActivity)paramContext).c();
      int i = (int)paramArticleInfo.mChannelID;
      if (paramFastWebArticleInfo.c()) {}
      for (paramFastWebArticleInfo = "2";; paramFastWebArticleInfo = "1")
      {
        ReportUtil.a(paramArticleInfo, "0X8008990", RIJTransMergeKanDianReport.a(paramContext, paramArticleInfo, i, paramFastWebArticleInfo).toString());
        return;
      }
    }
    if (this.jdField_a_of_type_Boolean)
    {
      RIJSocialBottomUtils.a.a(paramContext, paramArticleInfo, false);
      return;
    }
    if ("scroll to history location failed cuz activity or articleinfo is null" + paramContext == null) {}
    for (paramContext = "activity is null";; paramContext = "")
    {
      QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, paramContext);
      return;
    }
  }
  
  private void l(Context paramContext, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramContext == null)) {
      QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, "setFavoriteArticle but articleInfo is null.");
    }
    boolean bool;
    do
    {
      return;
      if (!paramFastWebArticleInfo.c) {}
      for (bool = true;; bool = false)
      {
        this.c = bool;
        paramFastWebArticleInfo.a(this.c);
        bool = paramFastWebArticleInfo.c;
        if (bool) {
          ReadInJoyAtlasManager.a(paramContext, false);
        }
        QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, new Object[] { "setFavoriteArticle, isFavorite = ", Boolean.valueOf(bool) });
        if (!this.jdField_b_of_type_Boolean) {
          break;
        }
        QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, "waiting for favorite result now, do not request again.");
        return;
      }
    } while (!(paramContext instanceof Activity));
    Object localObject = (Activity)paramContext;
    if (bool)
    {
      if (this.jdField_a_of_type_ComTencentBizWebviewpluginShare != null) {
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.c();
      }
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare = new Share(ReadInJoyUtils.a(), (Activity)localObject);
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramArticleInfo);
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramArticleInfo.mArticleContentUrl, 9, false);
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = true;
      new Handler(ThreadManager.getSubThreadLooper()).postDelayed(new ReadInJoyFastWebBottomSocialViewNew.5(this), 3000L);
      try
      {
        localObject = new JSONObject();
        int i = 0;
        if (bool) {
          i = 1;
        }
        ((JSONObject)localObject).put("status", i);
        ((JSONObject)localObject).put("rowkey", paramArticleInfo.innerUniqueID);
        ((JSONObject)localObject).put("source_from", a());
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009D0F", "0X8009D0F", 0, 0, "", paramArticleInfo.mArticleID + "", "", ((JSONObject)localObject).toString(), false);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          AppRuntime localAppRuntime;
          QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, "handleCollectClick error!  msg=" + localException);
        }
      }
      i(paramContext, paramArticleInfo, paramFastWebArticleInfo);
      ReadInJoyLogicEngineEventDispatcher.a().e();
      return;
      localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      ReadInJoyAtlasManager.a().a((Activity)localObject, localAppRuntime.getAccount(), 1, paramArticleInfo.innerUniqueID, (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(paramArticleInfo.innerUniqueID));
    }
  }
  
  public Map<String, Object> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("source_from", a());
    return localHashMap;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver != null)) {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew$DoShareClick = null;
  }
  
  public void a(int paramInt) {}
  
  public void a(long paramLong)
  {
    ReadInJoyLogicEngineEventDispatcher.a().e();
  }
  
  public void a(Context paramContext, FastWebArticleInfo paramFastWebArticleInfo, ArticleInfo paramArticleInfo)
  {
    setData(paramContext, paramFastWebArticleInfo, paramArticleInfo);
  }
  
  public void a(ReadInJoyFastWebBottomSocialViewNew.DoShareClick paramDoShareClick)
  {
    if (paramDoShareClick != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew$DoShareClick = paramDoShareClick;
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b() {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    e();
  }
  
  public void setData(Context paramContext, FastWebArticleInfo paramFastWebArticleInfo, ArticleInfo paramArticleInfo)
  {
    if ((paramContext == null) || (paramFastWebArticleInfo == null) || (paramArticleInfo == null))
    {
      QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, "setData error!  params is null!");
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    ProteusItemData localProteusItemData = FastWebPTSDataConverter.a(paramArticleInfo, paramFastWebArticleInfo);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext == null) {
      a(paramContext);
    }
    int i;
    if (paramFastWebArticleInfo.b()) {
      i = 0;
    }
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_Int == -1) || (i != this.jdField_a_of_type_Int))
        {
          removeAllViews();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean = localProteusItemData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean);
          addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer);
          if (!paramFastWebArticleInfo.b()) {
            continue;
          }
          i = 0;
          this.jdField_a_of_type_Int = i;
          setBackgroundColor(-1);
          a(localProteusItemData);
        }
      }
      catch (Exception localException)
      {
        QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, "setData error!  msg=" + localException);
        continue;
      }
      if (!a()) {
        break;
      }
      a(localProteusItemData.c);
      a(localProteusItemData, paramContext, paramFastWebArticleInfo);
      a(paramArticleInfo);
      setVisibility(0);
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView());
      return;
      i = 1;
      continue;
      i = 1;
    }
  }
  
  public void setData(FastWebArticleInfo paramFastWebArticleInfo, ArticleInfo paramArticleInfo)
  {
    setData(this.jdField_a_of_type_AndroidContentContext, paramFastWebArticleInfo, paramArticleInfo);
  }
  
  public void setFavoriteArticle(Context paramContext, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    l(paramContext, paramArticleInfo, paramFastWebArticleInfo);
  }
  
  public void setIsWebBottomView(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setOnOpenCommentEditListener(ReadInJoyFastWebBottomSocialViewNew.OnOpenCommentEditListener paramOnOpenCommentEditListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew$OnOpenCommentEditListener = paramOnOpenCommentEditListener;
  }
  
  public void setProteusContext(VafContext paramVafContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = paramVafContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew
 * JD-Core Version:    0.7.0.1
 */