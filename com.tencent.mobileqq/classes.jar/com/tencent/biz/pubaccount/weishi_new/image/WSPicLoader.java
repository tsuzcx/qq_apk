package com.tencent.biz.pubaccount.weishi_new.image;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageDownListener;
import com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.view.RoundCornerImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
import com.tencent.mobileqq.kandian.base.image.imageloader.RIJImageOptReport;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.base.view.widget.ZImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class WSPicLoader
{
  private static volatile WSPicLoader a;
  
  @Nullable
  private WSDrawableListener a(WeakReference<WSDrawableListener> paramWeakReference)
  {
    if (paramWeakReference == null) {
      return null;
    }
    return (WSDrawableListener)paramWeakReference.get();
  }
  
  public static WSPicLoader a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new WSPicLoader();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void a(ImageRequest paramImageRequest, long paramLong, String paramString1, String paramString2)
  {
    long l = SystemClock.uptimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSuccess cost = ");
    localStringBuilder.append(l - paramLong);
    localStringBuilder.append(", hashCode:");
    int i;
    if (paramImageRequest != null) {
      i = paramImageRequest.hashCode();
    } else {
      i = 0;
    }
    localStringBuilder.append(i);
    localStringBuilder.append(",request = ");
    localStringBuilder.append(paramImageRequest);
    WSLog.b("PreloadCoverImgLog", localStringBuilder.toString());
    if (paramImageRequest != null) {
      paramLong = paramImageRequest.t;
    } else {
      paramLong = 0L;
    }
    WsBeaconReportPresenter.a().a(paramImageRequest, true, true, paramLong, paramString1, paramString2, -1);
  }
  
  public void a(Context paramContext, ImageView paramImageView, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WeishiUtils loadAvatarImage url:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", imageView:");
    localStringBuilder.append(paramImageView);
    WSLog.b("AvatarImageLog", localStringBuilder.toString());
    if (paramContext != null)
    {
      if (paramImageView == null) {
        return;
      }
      paramImageView = new WeakReference(paramImageView);
      ThreadManager.getSubThreadHandler().post(new WSPicLoader.3(this, paramImageView, paramContext, paramString));
    }
  }
  
  public void a(Context paramContext, ImageView paramImageView, String paramString, Drawable paramDrawable)
  {
    a(paramContext, paramImageView, paramString, paramDrawable, null);
  }
  
  public void a(Context paramContext, ImageView paramImageView, String paramString, Drawable paramDrawable, WSDrawableListener paramWSDrawableListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WeishiUtils loadAvatarImage url:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", imageView:");
    localStringBuilder.append(paramImageView);
    WSLog.b("AvatarImageLog", localStringBuilder.toString());
    if (paramContext != null)
    {
      if (paramImageView == null) {
        return;
      }
      paramImageView = new WeakReference(paramImageView);
      if (paramWSDrawableListener == null) {
        paramContext = null;
      } else {
        paramContext = new WeakReference(paramWSDrawableListener);
      }
      ThreadManager.getSubThreadHandler().post(new WSPicLoader.1(this, paramImageView, paramString, paramDrawable, paramContext));
    }
  }
  
  public void a(Context paramContext, WSPicOptions paramWSPicOptions)
  {
    if (paramContext != null)
    {
      if (paramWSPicOptions == null) {
        return;
      }
      Object localObject2 = paramWSPicOptions.c();
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = paramContext.getResources().getDrawable(2130842687);
      }
      localObject2 = (KandianUrlImageView)paramWSPicOptions.a();
      paramContext = WeishiUtils.c(paramWSPicOptions.b());
      if ((!TextUtils.isEmpty(paramWSPicOptions.b())) && (paramContext != null))
      {
        ((KandianUrlImageView)localObject2).setPublicAccountImageDownListener(new WSImageDownListener(paramWSPicOptions));
        ((KandianUrlImageView)localObject2).setIsRecyclerView(true);
        if ((localObject2 instanceof RoundCornerImageView))
        {
          paramWSPicOptions = (RoundCornerImageView)localObject2;
          paramWSPicOptions.setImagePlaceHolder((Drawable)localObject1);
          paramWSPicOptions.setImageSrc(paramContext);
          return;
        }
        ((KandianUrlImageView)localObject2).setImagePlaceHolder((Drawable)localObject1).setImage(paramContext);
        return;
      }
      ((KandianUrlImageView)localObject2).setImageDrawable((Drawable)localObject1);
    }
  }
  
  public void a(ImageView paramImageView, String paramString1, Drawable paramDrawable1, Drawable paramDrawable2, String paramString2)
  {
    if (paramImageView == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString1))
    {
      paramImageView.setImageDrawable(paramDrawable1);
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = paramDrawable1;
    localURLDrawableOptions.mLoadingDrawable = paramDrawable2;
    paramDrawable1 = URLDrawable.getDrawable(paramString1, localURLDrawableOptions);
    paramImageView.setImageDrawable(paramDrawable1);
    paramDrawable1.setURLDrawableListener(new WSPicLoader.4(this, paramString2, paramImageView, paramString1));
    paramDrawable1.startDownload();
    if (1 != paramDrawable1.getStatus())
    {
      paramDrawable1.restartDownload();
      return;
    }
    paramImageView = new StringBuilder();
    paramImageView.append("onLoad ~~~~~~");
    paramImageView.append(paramString2);
    WSLog.a("815", paramImageView.toString());
  }
  
  public void a(KandianUrlImageView paramKandianUrlImageView, stSimpleMetaFeed paramstSimpleMetaFeed, Drawable paramDrawable, String paramString, boolean paramBoolean, int paramInt)
  {
    paramKandianUrlImageView = new WSPicOptions(paramKandianUrlImageView, WeishiUtils.a(paramstSimpleMetaFeed, paramBoolean)).a(paramDrawable).a(paramString).a(paramInt);
    a(BaseApplicationImpl.getApplication(), paramKandianUrlImageView);
  }
  
  public void a(KandianUrlImageView paramKandianUrlImageView, stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean, String paramString, int paramInt)
  {
    paramKandianUrlImageView = new WSPicOptions(paramKandianUrlImageView, WeishiUtils.a(paramstSimpleMetaFeed, paramBoolean)).a(paramString).a(paramInt);
    a(BaseApplicationImpl.getApplication(), paramKandianUrlImageView);
  }
  
  public void a(KandianUrlImageView paramKandianUrlImageView, String paramString)
  {
    Drawable localDrawable = BaseApplicationImpl.getApplication().getApplicationContext().getResources().getDrawable(2130842798);
    paramKandianUrlImageView = new WSPicOptions(paramKandianUrlImageView, paramString).a(localDrawable).a(false);
    a(BaseApplicationImpl.getApplication(), paramKandianUrlImageView);
  }
  
  public void a(KandianUrlImageView paramKandianUrlImageView, String paramString, Drawable paramDrawable)
  {
    if (paramKandianUrlImageView == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      paramKandianUrlImageView.setImageDrawable(paramDrawable);
      return;
    }
    paramString = WeishiUtils.c(paramString);
    paramKandianUrlImageView.setIsRecyclerView(true);
    paramKandianUrlImageView.setImagePlaceHolder(paramDrawable).setImage(paramString);
  }
  
  public void a(@NonNull KandianUrlImageView paramKandianUrlImageView, @Nullable String paramString, @Nullable Drawable paramDrawable, @Nullable IPublicAccountImageDownListener paramIPublicAccountImageDownListener)
  {
    paramKandianUrlImageView = new WSPicOptions(paramKandianUrlImageView, paramString).a(paramDrawable).a(false).a(paramIPublicAccountImageDownListener);
    a(BaseApplicationImpl.getApplication(), paramKandianUrlImageView);
  }
  
  public void a(KandianUrlImageView paramKandianUrlImageView, String paramString1, Drawable paramDrawable, String paramString2, int paramInt)
  {
    paramKandianUrlImageView = new WSPicOptions(paramKandianUrlImageView, paramString1).a(paramDrawable).a(paramString2).a(paramInt);
    a(BaseApplicationImpl.getApplication(), paramKandianUrlImageView);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    URL localURL = WeishiUtils.c(paramString1);
    ImageRequest localImageRequest = new ImageRequest();
    localImageRequest.a = localURL;
    localImageRequest.b = paramInt1;
    localImageRequest.c = paramInt2;
    localImageRequest.e = true;
    long l = SystemClock.uptimeMillis();
    RIJImageOptReport.a(1, localImageRequest);
    ((IImageManager)QRoute.api(IImageManager.class)).loadImage(localImageRequest, new WSPicLoader.6(this, l, paramString1, paramString2));
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(paramString1, 0, 0, paramString2);
  }
  
  public void a(WeakReference<ImageView> paramWeakReference, Drawable paramDrawable, String paramString)
  {
    a(paramWeakReference, paramDrawable, paramString, null);
  }
  
  public void a(WeakReference<ImageView> paramWeakReference, Drawable paramDrawable, String paramString, WeakReference<WSDrawableListener> paramWeakReference1)
  {
    ThreadManager.getUIHandler().post(new WSPicLoader.2(this, paramWeakReference, paramDrawable, paramString, paramWeakReference1));
  }
  
  public void a(List<stSimpleMetaFeed> paramList, boolean paramBoolean)
  {
    a(paramList, paramBoolean, "");
  }
  
  public void a(List<stSimpleMetaFeed> paramList, boolean paramBoolean, String paramString)
  {
    if (!NetworkUtil.isWifiConnected(BaseApplication.getContext())) {
      return;
    }
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preloadImg size = ");
      localStringBuilder.append(paramList.size());
      WSLog.b("PreloadCoverImgLog", localStringBuilder.toString());
      ThreadManager.post(new WSPicLoader.5(this, new ArrayList(paramList), paramBoolean, paramString), 5, null, true);
    }
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = true;
    if (paramInt != 1)
    {
      if (paramInt == 2) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader
 * JD-Core Version:    0.7.0.1
 */