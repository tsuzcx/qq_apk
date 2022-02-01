package com.tencent.biz.pubaccount.util;

import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReportR5BuilderExtensionsKt;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.util.URLUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/util/ReadInJoyShareHelperV2$ShareReport;", "", "()V", "action", "", "from", "isSharing", "", "modelNew", "shareArticle", "Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;", "getShareArticle", "()Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;", "setShareArticle", "(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)V", "uinType", "", "getUinType", "()Ljava/lang/String;", "setUinType", "(Ljava/lang/String;)V", "url", "doReport", "", "r5", "reportClick", "reportExp", "articleInfo", "reportResult", "success", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyShareHelperV2$ShareReport
{
  private static int jdField_a_of_type_Int;
  @Nullable
  private static BaseArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  public static final ShareReport a;
  private static String jdField_a_of_type_JavaLangString = "";
  private static boolean jdField_a_of_type_Boolean;
  private static int jdField_b_of_type_Int;
  @NotNull
  private static String jdField_b_of_type_JavaLangString = "";
  private static int c = VideoReporter.a();
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2$ShareReport = new ShareReport();
  }
  
  @Nullable
  public final BaseArticleInfo a()
  {
    return jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  }
  
  public final void a(int paramInt)
  {
    jdField_b_of_type_Int = paramInt;
    jdField_a_of_type_Boolean = true;
    jdField_b_of_type_JavaLangString = "";
    Object localObject = new RIJTransMergeKanDianReport.ReportR5Builder();
    ReportR5BuilderExtensionsKt.a((RIJTransMergeKanDianReport.ReportR5Builder)localObject, "from", Integer.valueOf(jdField_a_of_type_Int));
    ReportR5BuilderExtensionsKt.a((RIJTransMergeKanDianReport.ReportR5Builder)localObject, "kandian_mode_new", Integer.valueOf(c));
    ReportR5BuilderExtensionsKt.a((RIJTransMergeKanDianReport.ReportR5Builder)localObject, "share_unit", Integer.valueOf(ReadInJoyShareHelperV2.a.a(paramInt)));
    localObject = ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "r5.build()");
    a("0X800AD76", (String)localObject);
  }
  
  public final void a(int paramInt, @Nullable String paramString, @Nullable BaseArticleInfo paramBaseArticleInfo)
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    jdField_a_of_type_Int = paramInt;
    if (paramString != null) {}
    for (;;)
    {
      jdField_a_of_type_JavaLangString = paramString;
      paramString = new RIJTransMergeKanDianReport.ReportR5Builder();
      ReportR5BuilderExtensionsKt.a(paramString, "from", Integer.valueOf(paramInt));
      ReportR5BuilderExtensionsKt.a(paramString, "kandian_mode_new", Integer.valueOf(c));
      paramString = paramString.a();
      Intrinsics.checkExpressionValueIsNotNull(paramString, "r5.build()");
      a("0X800AD75", paramString);
      return;
      paramString = "";
    }
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    jdField_b_of_type_JavaLangString = paramString;
  }
  
  public final void a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "action");
    Intrinsics.checkParameterIsNotNull(paramString2, "r5");
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if ((Intrinsics.areEqual(jdField_a_of_type_JavaLangString, "") ^ true))
    {
      localObject3 = URLUtil.a(jdField_a_of_type_JavaLangString);
      localObject1 = localObject2;
      if (((Map)localObject3).containsKey("rowkey")) {
        localObject1 = String.valueOf(((Map)localObject3).get("rowkey"));
      }
    }
    localObject2 = (QQAppInterface)null;
    Object localObject3 = BaseApplicationImpl.sApplication;
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "BaseApplicationImpl.sApplication");
    if ((((BaseApplicationImpl)localObject3).getRuntime() instanceof QQAppInterface))
    {
      localObject2 = BaseApplicationImpl.sApplication;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "BaseApplicationImpl.sApplication");
      localObject2 = ((BaseApplicationImpl)localObject2).getRuntime();
      if (localObject2 == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
      }
      localObject2 = (QQAppInterface)localObject2;
    }
    for (;;)
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent((AppInterface)localObject2, "", paramString1, paramString1, 0, 0, "", (String)localObject1, "", paramString2, false);
      return;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    int i = 0;
    Object localObject;
    if (jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = false;
      localObject = new RIJTransMergeKanDianReport.ReportR5Builder();
      ReportR5BuilderExtensionsKt.a((RIJTransMergeKanDianReport.ReportR5Builder)localObject, "from", Integer.valueOf(jdField_a_of_type_Int));
      ReportR5BuilderExtensionsKt.a((RIJTransMergeKanDianReport.ReportR5Builder)localObject, "share_unit", Integer.valueOf(ReadInJoyShareHelperV2.a.a(jdField_b_of_type_Int)));
      ReportR5BuilderExtensionsKt.a((RIJTransMergeKanDianReport.ReportR5Builder)localObject, "kandian_mode_new", Integer.valueOf(c));
      if ((jdField_b_of_type_Int == 72) || (jdField_b_of_type_Int == 2)) {
        ReportR5BuilderExtensionsKt.a((RIJTransMergeKanDianReport.ReportR5Builder)localObject, "is_group", jdField_b_of_type_JavaLangString);
      }
      if (!paramBoolean) {
        break label119;
      }
    }
    for (;;)
    {
      ReportR5BuilderExtensionsKt.a((RIJTransMergeKanDianReport.ReportR5Builder)localObject, "result", Integer.valueOf(i));
      localObject = ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).a();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "r5.build()");
      a("0X800AD77", (String)localObject);
      return;
      label119:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ReadInJoyShareHelperV2.ShareReport
 * JD-Core Version:    0.7.0.1
 */