package com.tencent.biz.expand.flutter;

import com.peterlmeng.animate_image.support.log.ILog;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/expand/flutter/ExpandFlutterUtils$animateImageLog$1", "Lcom/peterlmeng/animate_image/support/log/ILog;", "d", "", "tag", "", "s", "e", "i", "v", "w", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ExpandFlutterUtils$animateImageLog$1
  implements ILog
{
  public void a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "s");
    if (QLog.isDevelopLevel()) {
      QLog.d("Pag." + paramString1, 4, paramString2);
    }
  }
  
  public void b(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "s");
    QLog.e("Pag." + paramString1, 1, paramString2);
  }
  
  public void c(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "s");
    QLog.i("Pag." + paramString1, 1, paramString2);
  }
  
  public void d(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "s");
    if (QLog.isColorLevel()) {
      QLog.d("Pag." + paramString1, 2, paramString2);
    }
  }
  
  public void e(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "s");
    QLog.w("Pag." + paramString1, 1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.flutter.ExpandFlutterUtils.animateImageLog.1
 * JD-Core Version:    0.7.0.1
 */