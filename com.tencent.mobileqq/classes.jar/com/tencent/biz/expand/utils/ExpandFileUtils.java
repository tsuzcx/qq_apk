package com.tencent.biz.expand.utils;

import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/expand/utils/ExpandFileUtils;", "", "()V", "TAG", "", "validateFile", "", "filepath", "expectedMd5", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ExpandFileUtils
{
  public static final ExpandFileUtils a = new ExpandFileUtils();
  
  @JvmStatic
  public static final boolean a(@NotNull String paramString1, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "filepath");
    if (!new File(paramString1).exists())
    {
      paramString2 = LogUtils.a;
      if (QLog.isColorLevel()) {
        QLog.d("Expand.FileUtils", 2, "validateFile() " + paramString1 + " not exists!");
      }
      return false;
    }
    String str = PortalUtils.a(paramString1);
    if (str != null) {}
    while (!StringsKt.equals(str, paramString2, true))
    {
      LogUtils localLogUtils = LogUtils.a;
      if (QLog.isColorLevel()) {
        QLog.d("Expand.FileUtils", 2, "validateFile() " + paramString1 + " md5 not match expect " + paramString2 + ", actually " + str + '!');
      }
      return false;
      str = "(null)";
    }
    paramString2 = LogUtils.a;
    if (QLog.isColorLevel()) {
      QLog.d("Expand.FileUtils", 2, "validateFile() " + paramString1 + " success!");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.utils.ExpandFileUtils
 * JD-Core Version:    0.7.0.1
 */