package com.tencent.mobileqq.apollo.statistics;

import com.tencent.mobileqq.app.ThreadManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/statistics/ApolloQualityReportUtil;", "", "()V", "APOLLO_SUB_ACTION_AEKIT_ESSENTIAL_RES", "", "APOLLO_SUB_ACTION_DRESS_INFO", "APOLLO_SUB_ACTION_FACE_DATA", "APOLLO_SUB_ACTION_FIRST_FRAME", "APOLLO_SUB_ACTION_INIT_AEKIT", "APOLLO_SUB_ACTION_INIT_AEKIT_VIEW", "APOLLO_SUB_ACTION_JS_API", "APOLLO_SUB_ACTION_PAGE_EXPOSE", "APOLLO_SUB_ACTION_ROLE_INFO", "APOLLO_SUB_ACTION_USER_RES", "APOLLO_SUB_ACTION_WEB_PAGE_DETECTED_BLANK_SCREEN", "APOLLO_SUB_ACTION_WEB_PAGE_ERROR", "APOLLO_SUB_ACTION_WEB_PAGE_FINISH", "APOLLO_SUB_ACTION_WEB_PAGE_LOW_MEMORY", "APOLLO_SUB_ACTION_WEB_PAGE_SSL_ERROR", "APOLLO_SUB_ACTION_WEB_PAGE_START", "TAG", "report", "", "subActionType", "reserves", "reserves2", "reserves3", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ApolloQualityReportUtil
{
  public static final ApolloQualityReportUtil a = new ApolloQualityReportUtil();
  
  @JvmStatic
  public static final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "subActionType");
    a(paramString, null);
  }
  
  @JvmStatic
  public static final void a(@NotNull String paramString1, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "subActionType");
    a(paramString1, paramString2, null);
  }
  
  @JvmStatic
  public static final void a(@NotNull String paramString1, @Nullable String paramString2, @Nullable String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "subActionType");
    a(paramString1, paramString2, null, null);
  }
  
  @JvmStatic
  public static final void a(@NotNull String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "subActionType");
    ThreadManager.getSubThreadHandler().post((Runnable)new ApolloQualityReportUtil.report.1(paramString1, paramString2, paramString3, paramString4));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.ApolloQualityReportUtil
 * JD-Core Version:    0.7.0.1
 */