package com.tencent.biz.expand.flutter;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.qflutter.qflutter_native_router.NativeRouter;
import com.tencent.biz.expand.NativeNavigateUtils;
import com.tencent.biz.expand.flutter.router.BaseRouter;
import com.tencent.biz.expand.flutter.router.RouterManager;
import com.tencent.biz.expand.flutter.router.RouterManager.Companion;
import com.tencent.biz.expand.utils.LogUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/expand/flutter/ExpandFlutterUtils$initNativeRouter$1", "Lcom/qflutter/qflutter_native_router/NativeRouter;", "openNativePage", "", "nativeType", "", "url", "urlParams", "", "", "exts", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ExpandFlutterUtils$initNativeRouter$1
  implements NativeRouter
{
  public void openNativePage(@Nullable String paramString1, @Nullable String paramString2, @Nullable Map<Object, ? extends Object> paramMap1, @Nullable Map<Object, ? extends Object> paramMap2, @NotNull MethodChannel.Result paramResult)
  {
    Intrinsics.checkParameterIsNotNull(paramResult, "result");
    LogUtils localLogUtils = LogUtils.a;
    if (QLog.isColorLevel()) {
      QLog.d("ExpandFlutterUtils", 2, "native router type: " + paramString1 + ", url: " + paramString2);
    }
    if (paramString1 == null)
    {
      paramString2 = LogUtils.a;
      paramString2 = (Throwable)null;
      QLog.e("ExpandFlutterUtils", 1, "error native type: " + paramString1, paramString2);
      paramResult.error("error type", null, null);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                switch (paramString1.hashCode())
                {
                default: 
                  break;
                case 191523977: 
                  if (!paramString1.equals("withoutSchema")) {
                    break;
                  }
                }
              } while (TextUtils.isEmpty((CharSequence)paramString2));
              paramString1 = Uri.parse(paramString2);
            } while ((paramString1 == null) || (!TextUtils.equals((CharSequence)paramString1.getScheme(), (CharSequence)"mqqapi")));
            paramString2 = RouterManager.a.a().a(paramString1.getAuthority());
          } while (paramString2 == null);
          paramString2.a(paramString1, paramMap1, paramMap2);
          return;
          if (!paramString1.equals("bySchema")) {
            break;
          }
          paramString1 = BaseActivity.sTopActivity;
        } while (paramString1 == null);
        NativeNavigateUtils.a.c((Context)paramString1, paramString2);
        return;
        if (!paramString1.equals("webView")) {
          break;
        }
        paramString1 = BaseActivity.sTopActivity;
      } while (paramString1 == null);
      NativeNavigateUtils.a.b((Context)paramString1, paramString2);
      return;
      if (!paramString1.equals("miniApp")) {
        break;
      }
      paramString1 = BaseActivity.sTopActivity;
    } while (paramString1 == null);
    NativeNavigateUtils.a.a((Context)paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.flutter.ExpandFlutterUtils.initNativeRouter.1
 * JD-Core Version:    0.7.0.1
 */