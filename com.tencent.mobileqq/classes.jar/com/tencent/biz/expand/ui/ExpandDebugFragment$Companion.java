package com.tencent.biz.expand.ui;

import android.os.Bundle;
import com.tencent.biz.expand.provider.AppRuntimeProvider;
import com.tencent.biz.expand.provider.AppRuntimeProviderImpl;
import com.tencent.biz.expand.utils.LogUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/expand/ui/ExpandDebugFragment$Companion;", "", "()V", "TAG", "", "createApngDrawable", "Lcom/tencent/image/URLDrawable;", "name", "url", "width", "", "height", "newInstance", "Lcom/tencent/biz/expand/ui/ExpandDebugFragment;", "activity", "Lcom/tencent/mobileqq/app/BaseActivity;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ExpandDebugFragment$Companion
{
  @NotNull
  public final ExpandDebugFragment a(@NotNull BaseActivity paramBaseActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseActivity, "activity");
    Bundle localBundle = new Bundle();
    paramBaseActivity = new ExpandDebugFragment((AppRuntimeProvider)new AppRuntimeProviderImpl(paramBaseActivity));
    paramBaseActivity.setArguments(localBundle);
    return paramBaseActivity;
  }
  
  @NotNull
  public final URLDrawable a(@NotNull String paramString1, @NotNull String paramString2, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "name");
    Intrinsics.checkParameterIsNotNull(paramString2, "url");
    Object localObject = LogUtils.a;
    if (QLog.isColorLevel()) {
      QLog.d("ExpandDebugFragment", 2, '[' + paramString1 + "] createApngDrawable() " + paramString2);
    }
    localObject = URLDrawable.URLDrawableOptions.obtain();
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramInt1;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramInt2;
    }
    ((URLDrawable.URLDrawableOptions)localObject).mUseApngImage = true;
    ((URLDrawable.URLDrawableOptions)localObject).mExtraInfo = new Bundle();
    if (StringsKt.startsWith$default(paramString2, "/", false, 2, null)) {}
    for (localObject = URLDrawable.getDrawable(new File(paramString2), (URLDrawable.URLDrawableOptions)localObject);; localObject = URLDrawable.getDrawable(paramString2, (URLDrawable.URLDrawableOptions)localObject))
    {
      ((URLDrawable)localObject).setURLDrawableListener((URLDrawable.URLDrawableListener)new ExpandDebugFragment.Companion.createApngDrawable.2(paramString1, paramString2));
      ((URLDrawable)localObject).setDownloadListener((URLDrawable.DownloadListener)new ExpandDebugFragment.Companion.createApngDrawable.3(paramString1, paramString2));
      Intrinsics.checkExpressionValueIsNotNull(localObject, "urlDrawable");
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.ui.ExpandDebugFragment.Companion
 * JD-Core Version:    0.7.0.1
 */