package com.tencent.biz.expand.utils;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/expand/utils/LocalStorageUtils;", "", "()V", "expandConfig", "Landroid/content/SharedPreferences;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class LocalStorageUtils
{
  public static final LocalStorageUtils a = new LocalStorageUtils();
  
  @JvmStatic
  @NotNull
  public static final SharedPreferences a()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication()");
    localObject = ((BaseApplicationImpl)localObject).getRuntime();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication().runtime");
    localObject = ((AppRuntime)localObject).getAccount();
    if (localObject != null) {}
    for (;;)
    {
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences((String)localObject + "_expand_local_storage", 0);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getA…e\", Context.MODE_PRIVATE)");
      return localObject;
      localObject = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.utils.LocalStorageUtils
 * JD-Core Version:    0.7.0.1
 */