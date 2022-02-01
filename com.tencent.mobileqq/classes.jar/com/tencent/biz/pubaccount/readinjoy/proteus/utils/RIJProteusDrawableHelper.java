package com.tencent.biz.pubaccount.readinjoy.proteus.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ImageCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil.DrawableCallBack;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil.DrawableHelper;
import com.tencent.biz.pubaccount.util.api.IPublicAccountHttpDownloader;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/proteus/utils/RIJProteusDrawableHelper;", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/utils/DrawableUtil$DrawableHelper;", "()V", "getDrawable", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "path", "", "loading", "failed", "getDrawableFromNet", "width", "", "height", "drawableCallBack", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/utils/DrawableUtil$DrawableCallBack;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJProteusDrawableHelper
  implements DrawableUtil.DrawableHelper
{
  @Nullable
  public Drawable getDrawable(@NotNull Context paramContext, @Nullable String paramString, @Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if (paramString == null) {
      return null;
    }
    if (StringsKt.startsWith$default(paramString, "http", false, 2, null))
    {
      paramContext = URLDrawable.URLDrawableOptions.obtain();
      paramContext.mLoadingDrawable = paramDrawable1;
      paramContext.mFailedDrawable = paramDrawable2;
      return (Drawable)URLDrawable.getDrawable(((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(paramString, 3), paramContext);
    }
    paramDrawable1 = ImageCommon.getDrawableResourceId(paramString);
    if (paramDrawable1 != null) {
      try
      {
        paramContext = paramContext.getResources().getDrawable(paramDrawable1.intValue());
        return paramContext;
      }
      catch (Exception paramContext)
      {
        QLog.d("Q.readinjoy.proteus", 2, "getDrawable: cant find in resources dir, do nothing");
        QLog.e("Q.readinjoy.proteus", 1, (Throwable)paramContext, new Object[0]);
      }
    }
    QLog.e("Q.readinjoy.proteus", 2, "getDrawable: cant find path :" + paramString);
    return null;
  }
  
  @Nullable
  public Drawable getDrawableFromNet(@NotNull Context paramContext, @NotNull String paramString, @Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, int paramInt1, int paramInt2, @NotNull DrawableUtil.DrawableCallBack paramDrawableCallBack)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    Intrinsics.checkParameterIsNotNull(paramDrawableCallBack, "drawableCallBack");
    if (StringsKt.startsWith$default(paramString, "http", false, 2, null))
    {
      paramContext = URLDrawable.URLDrawableOptions.obtain();
      paramContext.mLoadingDrawable = paramDrawable1;
      paramContext.mFailedDrawable = paramDrawable2;
      paramContext.mRequestWidth = paramInt1;
      paramContext.mRequestHeight = paramInt2;
      paramContext = URLDrawable.getDrawable(((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(paramString, 3), paramContext);
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "drawable");
      paramContext.setCallback((Drawable.Callback)new RIJProteusDrawableHelper.getDrawableFromNet.1(paramDrawableCallBack, paramContext));
      paramContext.setURLDrawableListener((URLDrawable.URLDrawableListener)new RIJProteusDrawableHelper.getDrawableFromNet.2(paramString, paramDrawableCallBack));
      paramContext.setDownloadListener((URLDrawable.DownloadListener)new RIJProteusDrawableHelper.getDrawableFromNet.3(paramString, paramDrawableCallBack, paramContext));
      QLog.i("Q.readinjoy.proteus", 1, "getDrawable: :" + paramString);
      paramDrawableCallBack.onCallBack(true, (Drawable)paramContext);
      if (paramContext.getStatus() != 1)
      {
        paramContext.startDownload();
        QLog.i("Q.readinjoy.proteus", 1, "getDrawable: :" + paramString + "  startDownload ");
      }
      return (Drawable)paramContext;
    }
    return getDrawable(paramContext, paramString, paramDrawable1, paramDrawable2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.utils.RIJProteusDrawableHelper
 * JD-Core Version:    0.7.0.1
 */