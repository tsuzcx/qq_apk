package com.tencent.biz.expand.flutter;

import com.peterlmeng.animate_image.renderer.IRenderWorkerFactory;
import com.peterlmeng.animate_image.renderer.RenderWorker;
import com.peterlmeng.animate_image.renderer.RenderWorkerFactory;
import com.peterlmeng.animate_image.renderer.RenderWorkerFactory.CreateRenderWorkerParams;
import com.tencent.biz.expand.flutter.apng.ApngDrawableWrapper;
import com.tencent.biz.expand.utils.LogUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/expand/flutter/ExpandFlutterUtils$apngRenderFactory$1", "Lcom/peterlmeng/animate_image/renderer/IRenderWorkerFactory;", "create", "Lcom/peterlmeng/animate_image/renderer/RenderWorker;", "params", "Lcom/peterlmeng/animate_image/renderer/RenderWorkerFactory$CreateRenderWorkerParams;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ExpandFlutterUtils$apngRenderFactory$1
  implements IRenderWorkerFactory
{
  @NotNull
  public RenderWorker create(@Nullable RenderWorkerFactory.CreateRenderWorkerParams paramCreateRenderWorkerParams)
  {
    try
    {
      Object localObject = LogUtils.a;
      if (QLog.isDevelopLevel()) {
        QLog.d("ExpandFlutterUtils", 4, "vashDev IRenderWorkerFactory: create(" + paramCreateRenderWorkerParams + ')');
      }
      localObject = RenderWorkerFactory.newCanvasConsumerAnimatorRenderWorker(paramCreateRenderWorkerParams, ApngDrawableWrapper.a);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "RenderWorkerFactory.newC…DrawableWrapper.sFactory)");
      return localObject;
    }
    catch (Exception localException)
    {
      LogUtils localLogUtils = LogUtils.a;
      QLog.e("ExpandFlutterUtils", 1, "vashDev IRenderWorkerFactory: create(" + paramCreateRenderWorkerParams + ") error!", (Throwable)localException);
      throw ((Throwable)localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.flutter.ExpandFlutterUtils.apngRenderFactory.1
 * JD-Core Version:    0.7.0.1
 */