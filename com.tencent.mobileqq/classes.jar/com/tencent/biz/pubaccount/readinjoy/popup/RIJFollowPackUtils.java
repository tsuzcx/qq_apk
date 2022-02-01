package com.tencent.biz.pubaccount.readinjoy.popup;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.common.ProteusSupportUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.FollowListInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.Ox978RespCallBack;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.RvPolymericContainer;
import com.tencent.biz.pubaccount.readinjoy.proteus.wrap.ReadInjoyContext;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfos;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebPTSDataConverter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/popup/RIJFollowPackUtils;", "", "()V", "FOLLOW_AVATOR_CLICK_TYPE", "", "FOLLOW_BUTTON_CLICK_TYPE", "FOLLOW_CONTAINER_CLICK_TYPE", "TAG", "", "getTAG", "()Ljava/lang/String;", "reportInfo", "", "", "", "getReportInfo", "()Ljava/util/Map;", "setReportInfo", "(Ljava/util/Map;)V", "addButtonType", "", "recommendFollowInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/RecommendFollowInfo;", "map", "isClick", "", "addExtraReport", "r5Builder", "Lcom/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/report/RIJTransMergeKanDianReport$ReportR5Builder;", "extras", "", "addProteusFollowCards", "context", "Landroid/content/Context;", "articleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "parentLayout", "Landroid/view/ViewGroup;", "dialog", "Lcom/tencent/biz/pubaccount/readinjoy/popup/RIJBottomDialog;", "addUin", "clickFollowBtn", "followPackData", "Lcom/tencent/biz/pubaccount/readinjoy/popup/RIJFollowPackUtils$RIJFollowPackData;", "createProteusContext", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/VafContext;", "destroy", "doProteusClick", "position", "type", "getFollowReportParams", "source", "(Lcom/tencent/biz/pubaccount/readinjoy/struct/RecommendFollowInfo;ZLjava/lang/Integer;)Ljava/util/Map;", "getRecommendFollowInfo", "index", "hasReported", "bigT", "uin", "isPGC", "jump", "jump2SelfPage", "refreshProteus", "report", "reportT", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/tencent/biz/pubaccount/readinjoy/struct/RecommendFollowInfo;Ljava/util/Map;)V", "requestFollow", "setAttachData", "container", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "templateBean", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;", "updateFollowStatus", "recommendFollowInfoList", "", "RIJFollowPackData", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJFollowPackUtils
{
  public static final RIJFollowPackUtils a;
  @NotNull
  private static final String jdField_a_of_type_JavaLangString = "RIJFollowPackUtils";
  @NotNull
  private static Map<String, List<Long>> jdField_a_of_type_JavaUtilMap = (Map)new HashMap();
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyPopupRIJFollowPackUtils = new RIJFollowPackUtils();
  }
  
  private final RecommendFollowInfo a(ArticleInfo paramArticleInfo, int paramInt)
  {
    RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)null;
    RecommendFollowInfos localRecommendFollowInfos = paramArticleInfo.mRecommendFollowInfos;
    paramArticleInfo = localRecommendFollowInfo;
    if (localRecommendFollowInfos != null)
    {
      paramArticleInfo = localRecommendFollowInfo;
      if (paramInt >= 0)
      {
        paramArticleInfo = localRecommendFollowInfo;
        if (paramInt < localRecommendFollowInfos.a.size()) {
          paramArticleInfo = (RecommendFollowInfo)localRecommendFollowInfos.a.get(paramInt);
        }
      }
    }
    return paramArticleInfo;
  }
  
  private final VafContext a(Context paramContext)
  {
    ReadInjoyContext localReadInjoyContext = new ReadInjoyContext();
    localReadInjoyContext.setContext(paramContext);
    ProteusSupportUtil.a((VafContext)localReadInjoyContext, "native_article");
    return (VafContext)localReadInjoyContext;
  }
  
  private final void a(int paramInt, RecommendFollowInfo paramRecommendFollowInfo)
  {
    if (paramRecommendFollowInfo != null) {
      RIJJumpUtils.a(String.valueOf(paramRecommendFollowInfo.uin), null);
    }
  }
  
  private final void a(RIJTransMergeKanDianReport.ReportR5Builder paramReportR5Builder, Map<String, ? extends Object> paramMap)
  {
    if (paramMap != null)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        paramReportR5Builder.a((String)localEntry.getKey(), localEntry.getValue());
      }
    }
  }
  
  private final void a(RIJFollowPackUtils.RIJFollowPackData paramRIJFollowPackData, RecommendFollowInfo paramRecommendFollowInfo)
  {
    if (paramRecommendFollowInfo != null)
    {
      if (!paramRecommendFollowInfo.isFollowed) {
        break label23;
      }
      RIJJumpUtils.a(String.valueOf(paramRecommendFollowInfo.uin), null);
    }
    for (;;)
    {
      return;
      label23:
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyPopupRIJFollowPackUtils.b(paramRIJFollowPackData, paramRecommendFollowInfo);
    }
  }
  
  private final void a(RecommendFollowInfo paramRecommendFollowInfo, RIJTransMergeKanDianReport.ReportR5Builder paramReportR5Builder)
  {
    if (a(paramRecommendFollowInfo))
    {
      paramReportR5Builder.a("puin", paramRecommendFollowInfo.uin);
      return;
    }
    paramReportR5Builder.a("ugcuin", paramRecommendFollowInfo.uin);
  }
  
  private final void a(RecommendFollowInfo paramRecommendFollowInfo, Map<String, Object> paramMap, boolean paramBoolean)
  {
    int i = 2;
    if (paramBoolean)
    {
      if (paramRecommendFollowInfo.isFollowed) {}
      for (;;)
      {
        paramMap.put("click_type", Integer.valueOf(i));
        return;
        i = 1;
      }
    }
    if (paramRecommendFollowInfo.isFollowed) {}
    for (;;)
    {
      paramMap.put("button_type", Integer.valueOf(i));
      return;
      i = 1;
    }
  }
  
  private final void a(ViewBase paramViewBase, TemplateBean paramTemplateBean, ArticleInfo paramArticleInfo, RIJBottomDialog paramRIJBottomDialog)
  {
    ViewBase localViewBase = paramViewBase.findViewBaseByName("id_proteus_collection_view");
    Intrinsics.checkExpressionValueIsNotNull(localViewBase, "container.findViewBaseBy…proteus_collection_view\")");
    if ((localViewBase instanceof RvPolymericContainer))
    {
      paramViewBase = new RIJFollowPackUtils.RIJFollowPackData(paramTemplateBean, paramViewBase, paramArticleInfo);
      ((RvPolymericContainer)localViewBase).a(paramViewBase);
      paramRIJBottomDialog.a(paramViewBase);
    }
  }
  
  private final boolean a(RecommendFollowInfo paramRecommendFollowInfo)
  {
    return paramRecommendFollowInfo.type == 1;
  }
  
  private final boolean a(String paramString, long paramLong)
  {
    List localList = (List)jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localList == null)
    {
      localList = (List)new ArrayList();
      localList.add(Long.valueOf(paramLong));
      jdField_a_of_type_JavaUtilMap.put(paramString, localList);
      return false;
    }
    if ("0X800B96B".equals(paramString)) {
      return true;
    }
    if (localList.contains(Long.valueOf(paramLong))) {
      return true;
    }
    localList.add(Long.valueOf(paramLong));
    return false;
  }
  
  private final void b(RIJFollowPackUtils.RIJFollowPackData paramRIJFollowPackData, RecommendFollowInfo paramRecommendFollowInfo)
  {
    Object localObject = ReadInJoyLogicEngine.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyLogicEngine.getInstance()");
    localObject = ((ReadInJoyLogicEngine)localObject).a();
    String str1 = ReadInJoyHelper.a();
    long l = paramRecommendFollowInfo.uin;
    String str2 = paramRecommendFollowInfo.headUrl;
    paramRIJFollowPackData = (UserOperationModule.Ox978RespCallBack)new RIJFollowPackUtils.requestFollow.1(paramRecommendFollowInfo, paramRIJFollowPackData);
    if (a(paramRecommendFollowInfo)) {}
    for (int i = 1;; i = 2)
    {
      ((UserOperationModule)localObject).a(str1, l, true, str2, paramRIJFollowPackData, i);
      return;
    }
  }
  
  @NotNull
  public final String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  @NotNull
  public final Map<String, Object> a(@Nullable RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean, @Nullable Integer paramInteger)
  {
    Map localMap = (Map)new HashMap();
    if (paramInteger == null) {}
    for (int i = 18;; i = 17)
    {
      localMap.put("scene_type", Integer.valueOf(i));
      if (paramRecommendFollowInfo != null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyPopupRIJFollowPackUtils.a(paramRecommendFollowInfo, localMap, paramBoolean);
      }
      return localMap;
      if (paramInteger.intValue() != 2) {
        break;
      }
    }
  }
  
  public final void a()
  {
    jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public final void a(int paramInt1, int paramInt2, @NotNull RIJFollowPackUtils.RIJFollowPackData paramRIJFollowPackData)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJFollowPackData, "followPackData");
    RecommendFollowInfo localRecommendFollowInfo = a(paramRIJFollowPackData.a(), paramInt1);
    if (localRecommendFollowInfo != null) {}
    try
    {
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyPopupRIJFollowPackUtils.a(paramInt1, paramInt2, paramRIJFollowPackData, localRecommendFollowInfo);
      QLog.d(jdField_a_of_type_JavaLangString, 1, "doProteusClick! position=" + paramInt1 + ", type=" + paramInt2 + ", recommendFollowInfo=" + localRecommendFollowInfo);
      return;
    }
    catch (Exception paramRIJFollowPackData)
    {
      for (;;)
      {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyPopupRIJFollowPackUtils.a(paramInt1, localRecommendFollowInfo);
        QLog.d(jdField_a_of_type_JavaLangString, 1, "doProteusClick! error msg=" + paramRIJFollowPackData);
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, @NotNull RIJFollowPackUtils.RIJFollowPackData paramRIJFollowPackData, @NotNull RecommendFollowInfo paramRecommendFollowInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJFollowPackData, "followPackData");
    Intrinsics.checkParameterIsNotNull(paramRecommendFollowInfo, "recommendFollowInfo");
    Object localObject = paramRIJFollowPackData.a().mRecommendFollowInfos;
    if (localObject != null)
    {
      localObject = Integer.valueOf(((RecommendFollowInfos)localObject).b);
      switch (paramInt2)
      {
      default: 
        a(paramInt1, paramRecommendFollowInfo);
      }
    }
    for (;;)
    {
      a("0X800B96B", (Integer)localObject, paramRecommendFollowInfo, null);
      return;
      localObject = null;
      break;
      a("0X800B1A7", (Integer)localObject, paramRecommendFollowInfo, a(paramRecommendFollowInfo, true, (Integer)localObject));
      a(paramRIJFollowPackData, paramRecommendFollowInfo);
      continue;
      a(paramInt1, paramRecommendFollowInfo);
      continue;
      a("0X800B96D", (Integer)localObject, paramRecommendFollowInfo, null);
      a(paramInt1, paramRecommendFollowInfo);
    }
  }
  
  public final void a(@NotNull Context paramContext, @NotNull ArticleInfo paramArticleInfo, @NotNull ViewGroup paramViewGroup, @NotNull RIJBottomDialog paramRIJBottomDialog)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramArticleInfo, "articleInfo");
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "parentLayout");
    Intrinsics.checkParameterIsNotNull(paramRIJBottomDialog, "dialog");
    try
    {
      Object localObject = a(paramContext);
      paramContext = FastWebPTSDataConverter.a(paramArticleInfo);
      localObject = ((VafContext)localObject).getViewFactory().inflate((VafContext)localObject, paramContext);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "followCardsView");
      ViewBase localViewBase = ((Container)localObject).getVirtualView();
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "templateBean");
      ProteusSupportUtil.a(localViewBase, paramContext.getViewBean());
      paramViewGroup.addView((View)localObject);
      Intrinsics.checkExpressionValueIsNotNull(localViewBase, "container");
      a(localViewBase, paramContext, paramArticleInfo, paramRIJBottomDialog);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "addProteusFollowCards error! msg=" + paramContext);
    }
  }
  
  public final void a(@NotNull RIJFollowPackUtils.RIJFollowPackData paramRIJFollowPackData)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJFollowPackData, "followPackData");
    JSONObject localJSONObject = FastWebPTSDataConverter.a(paramRIJFollowPackData.a().mRecommendFollowInfos);
    paramRIJFollowPackData.a().bindData(localJSONObject);
    ProteusSupportUtil.a(paramRIJFollowPackData.a(), paramRIJFollowPackData.a().getViewBean());
  }
  
  public final void a(@NotNull String paramString, @Nullable Integer paramInteger, @NotNull RecommendFollowInfo paramRecommendFollowInfo, @Nullable Map<String, ? extends Object> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "reportT");
    Intrinsics.checkParameterIsNotNull(paramRecommendFollowInfo, "recommendFollowInfo");
    if (a(paramString, paramRecommendFollowInfo.uin)) {
      return;
    }
    paramInteger = RIJFollowRecommendReport.a.a(paramInteger);
    a(paramInteger, paramMap);
    a(paramRecommendFollowInfo, paramInteger);
    paramRecommendFollowInfo = RIJFollowRecommendReport.a;
    paramInteger = paramInteger.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramInteger, "r5Builder.toString()");
    paramRecommendFollowInfo.a(paramString, paramInteger);
  }
  
  public final void a(@NotNull List<? extends RecommendFollowInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "recommendFollowInfoList");
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)paramList.next();
      localRecommendFollowInfo.isFollowed = FollowListInfoModule.a(localRecommendFollowInfo.uin, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.popup.RIJFollowPackUtils
 * JD-Core Version:    0.7.0.1
 */