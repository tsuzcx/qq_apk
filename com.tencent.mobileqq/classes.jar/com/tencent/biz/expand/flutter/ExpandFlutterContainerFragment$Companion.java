package com.tencent.biz.expand.flutter;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.biz.expand.utils.LogUtils;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.flutter.router.PageRouter;
import com.tencent.mobileqq.flutter.router.PageRouterBuilder;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/expand/flutter/ExpandFlutterContainerFragment$Companion;", "", "()V", "DELAY_PROGRESS_UPDATE", "", "DELAY_SPLASH_GONE", "LOAD_EXIT", "", "LOAD_SUCCESS", "TAG", "", "openFlutterPage", "", "context", "Landroid/content/Context;", "entry", "pageName", "params", "", "reportSession", "", "url", "openPageInner", "pageRouter", "Lcom/tencent/mobileqq/flutter/router/PageRouter;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ExpandFlutterContainerFragment$Companion
{
  public final void a(@Nullable Context paramContext, @Nullable PageRouter paramPageRouter, @Nullable byte[] paramArrayOfByte)
  {
    if (paramPageRouter == null)
    {
      QLog.d("QFlutterPageRouter", 2, "openPage, pageRouter is null");
      return;
    }
    boolean bool = PreloadProcHitSession.a("com.tencent.mobileqq:tool");
    if (QLog.isColorLevel()) {
      QLog.d("QFlutterPageRouter", 2, "openPage: " + paramPageRouter + ", isProcessExist: " + bool);
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("entry_point", paramPageRouter.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("page_name", paramPageRouter.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("unique_id", paramPageRouter.c);
    localIntent.putExtra("params", (Serializable)paramPageRouter.jdField_a_of_type_ComTencentMobileqqFlutterRouterSerializableMap);
    localIntent.putExtra("status_bar_transparent", paramPageRouter.jdField_a_of_type_Boolean);
    localIntent.putExtra("status_text_dark", paramPageRouter.jdField_b_of_type_Boolean);
    localIntent.putExtra("preload_process", bool);
    localIntent.putExtra("open_page_time", SystemClock.elapsedRealtime());
    localIntent.putExtra("moduleId", "expand_flutter");
    localIntent.putExtra("report_session", paramArrayOfByte);
    PublicFragmentActivityForTool.b(paramContext, localIntent, ExpandFlutterContainerFragment.class);
  }
  
  public final void a(@Nullable Context paramContext, @NotNull String paramString1, @Nullable String paramString2, @Nullable Map<String, Object> paramMap, @Nullable byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "entry");
    LogUtils localLogUtils = LogUtils.a;
    if (QLog.isColorLevel()) {
      QLog.d("ExpandFlutterContainerFragment", 2, "openPage: " + paramString1 + ' ' + paramString2);
    }
    paramString1 = new PageRouterBuilder().a(paramMap).a(paramString1).b(paramString2).b(true).c(true).a();
    ((Companion)this).a(paramContext, paramString1, paramArrayOfByte);
  }
  
  public final void a(@Nullable Context paramContext, @Nullable String paramString, @Nullable Map<String, Object> paramMap, @Nullable byte[] paramArrayOfByte)
  {
    LogUtils localLogUtils = LogUtils.a;
    if (QLog.isColorLevel()) {
      QLog.d("ExpandFlutterContainerFragment", 2, "openPage: " + paramString);
    }
    paramString = new PageRouterBuilder().a(paramMap).a("qqExpandWidget").b(paramString).b(true).c(true).a();
    ((Companion)this).a(paramContext, paramString, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.flutter.ExpandFlutterContainerFragment.Companion
 * JD-Core Version:    0.7.0.1
 */