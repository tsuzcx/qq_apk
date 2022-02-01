package com.tencent.biz.pubaccount.weishi_new.image;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.weishi_new.download.wsapp.WSFallKeyPicMonitor;
import com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.view.RoundCornerImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.api.IBitmapCache;
import com.tencent.mobileqq.kandian.base.image.api.ICloseableBitmap;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
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
  public static Bitmap a(URL paramURL, ImageView paramImageView)
  {
    if ((paramURL != null) && (paramImageView.getWidth() > 0))
    {
      ImageRequest localImageRequest = new ImageRequest();
      localImageRequest.jdField_a_of_type_JavaNetURL = paramURL;
      localImageRequest.jdField_a_of_type_Int = paramImageView.getWidth();
      localImageRequest.jdField_b_of_type_Int = paramImageView.getHeight();
      paramURL = ((IBitmapCache)QRoute.api(IBitmapCache.class)).getCloseableBitmapFromCache(localImageRequest.a());
      if (paramURL != null) {
        return paramURL.a();
      }
    }
    return null;
  }
  
  public static void a(Context paramContext, ImageView paramImageView, String paramString)
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
      ThreadManager.getSubThreadHandler().post(new WSPicLoader.6(paramImageView, paramContext, paramString));
    }
  }
  
  public static void a(Context paramContext, ImageView paramImageView, String paramString, Drawable paramDrawable)
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
      paramContext = new WeakReference(paramImageView);
      ThreadManager.getSubThreadHandler().post(new WSPicLoader.4(paramContext, paramString, paramDrawable));
    }
  }
  
  public static void a(Context paramContext, KandianUrlImageView paramKandianUrlImageView, URL paramURL, Drawable paramDrawable, String paramString, int paramInt)
  {
    if ((paramContext != null) && (paramKandianUrlImageView != null))
    {
      Object localObject = a(paramURL, paramKandianUrlImageView);
      if (localObject != null)
      {
        paramKandianUrlImageView.setImageBitmap((Bitmap)localObject);
        if (paramURL != null) {
          paramContext = paramURL.toString();
        } else {
          paramContext = "";
        }
        WSFallKeyPicMonitor.b(1, paramContext);
        return;
      }
      localObject = paramDrawable;
      if (paramDrawable == null) {
        localObject = paramContext.getResources().getDrawable(2130841770);
      }
      if (paramURL == null)
      {
        paramKandianUrlImageView.setImageDrawable((Drawable)localObject);
        return;
      }
      paramContext = (String)paramKandianUrlImageView.getTag();
      if ((!TextUtils.isEmpty(paramContext)) && (!TextUtils.equals(paramContext, paramURL.toString()))) {
        paramKandianUrlImageView.setImageDrawable((Drawable)localObject);
      }
      paramKandianUrlImageView.setTag(paramURL.toString());
      paramKandianUrlImageView.setIsRecyclerView(true);
      if ((paramKandianUrlImageView instanceof RoundCornerImageView))
      {
        paramContext = (RoundCornerImageView)paramKandianUrlImageView;
        paramContext.setImagePlaceHolder((Drawable)localObject);
        paramContext.setImageSrc(paramURL);
      }
      else
      {
        paramKandianUrlImageView.setImagePlaceHolder((Drawable)localObject).setImage(paramURL);
      }
      paramKandianUrlImageView.setPublicAccountImageDownListener(new WSPicLoader.2(paramString, paramKandianUrlImageView, paramInt));
    }
  }
  
  public static void a(ImageView paramImageView, String paramString, Drawable paramDrawable)
  {
    if (paramImageView == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      paramImageView.setImageDrawable(paramDrawable);
      return;
    }
    Object localObject = a(WeishiUtils.a(paramString), paramImageView);
    if (localObject != null)
    {
      paramImageView.setImageBitmap((Bitmap)localObject);
      return;
    }
    localObject = (String)paramImageView.getTag();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.equals((CharSequence)localObject, paramString))) {
      paramImageView.setImageDrawable(paramDrawable);
    }
    paramImageView.setTag(paramString);
    paramString = WeishiUtils.a(paramString);
    localObject = new ImageRequest();
    ((ImageRequest)localObject).jdField_a_of_type_JavaNetURL = paramString;
    ((ImageRequest)localObject).jdField_a_of_type_Int = paramImageView.getWidth();
    ((ImageRequest)localObject).jdField_b_of_type_Int = paramImageView.getHeight();
    ((IImageManager)QRoute.api(IImageManager.class)).loadImage((ImageRequest)localObject, new WSPicLoader.1(paramImageView, paramDrawable));
  }
  
  public static void a(ImageView paramImageView, String paramString1, Drawable paramDrawable1, Drawable paramDrawable2, String paramString2)
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
    paramDrawable1.setURLDrawableListener(new WSPicLoader.7(paramString2, paramImageView, paramString1));
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
  
  public static void a(KandianUrlImageView paramKandianUrlImageView, stSimpleMetaFeed paramstSimpleMetaFeed, Drawable paramDrawable, String paramString, boolean paramBoolean, int paramInt)
  {
    paramstSimpleMetaFeed = WeishiUtils.a(WeishiUtils.a(paramstSimpleMetaFeed, paramBoolean));
    a(BaseApplicationImpl.getApplication(), paramKandianUrlImageView, paramstSimpleMetaFeed, paramDrawable, paramString, paramInt);
  }
  
  public static void a(KandianUrlImageView paramKandianUrlImageView, stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean, String paramString, int paramInt)
  {
    paramstSimpleMetaFeed = WeishiUtils.a(WeishiUtils.a(paramstSimpleMetaFeed, paramBoolean));
    a(BaseApplicationImpl.getApplication(), paramKandianUrlImageView, paramstSimpleMetaFeed, null, paramString, paramInt);
  }
  
  public static void a(KandianUrlImageView paramKandianUrlImageView, String paramString)
  {
    if ((paramKandianUrlImageView != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramString = WeishiUtils.a(paramString);
      paramKandianUrlImageView.setImagePlaceHolder(BaseApplicationImpl.getApplication().getApplicationContext().getResources().getDrawable(2130841881)).setImage(paramString);
    }
  }
  
  public static void a(KandianUrlImageView paramKandianUrlImageView, String paramString, Drawable paramDrawable)
  {
    if (paramKandianUrlImageView == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      paramKandianUrlImageView.setImageDrawable(paramDrawable);
      return;
    }
    paramString = WeishiUtils.a(paramString);
    Bitmap localBitmap = a(paramString, paramKandianUrlImageView);
    if (localBitmap != null)
    {
      paramKandianUrlImageView.setImageBitmap(localBitmap);
      return;
    }
    paramKandianUrlImageView.setIsRecyclerView(true);
    paramKandianUrlImageView.setImagePlaceHolder(paramDrawable).setImage(paramString);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3)
  {
    URL localURL = WeishiUtils.a(paramString1);
    ImageRequest localImageRequest = new ImageRequest();
    localImageRequest.jdField_a_of_type_JavaNetURL = localURL;
    localImageRequest.jdField_a_of_type_Int = paramInt1;
    localImageRequest.jdField_b_of_type_Int = paramInt2;
    localImageRequest.jdField_b_of_type_Boolean = true;
    long l = SystemClock.uptimeMillis();
    ((IImageManager)QRoute.api(IImageManager.class)).loadImage(localImageRequest, new WSPicLoader.9(l, paramString1, paramString2));
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(paramString1, 0, 0, paramString2, 0);
  }
  
  public static void a(WeakReference<ImageView> paramWeakReference, Drawable paramDrawable, String paramString)
  {
    ThreadManager.getUIHandler().post(new WSPicLoader.5(paramWeakReference, paramDrawable, paramString));
  }
  
  public static void a(List<stSimpleMetaFeed> paramList, boolean paramBoolean)
  {
    a(paramList, paramBoolean, "");
  }
  
  public static void a(List<stSimpleMetaFeed> paramList, boolean paramBoolean, String paramString)
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
      ThreadManager.post(new WSPicLoader.8(new ArrayList(paramList), paramBoolean, paramString), 5, null, true);
    }
  }
  
  public static boolean a(int paramInt)
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
  
  private static void b(ImageRequest paramImageRequest, long paramLong, String paramString1, String paramString2)
  {
    long l2 = SystemClock.uptimeMillis() - paramLong;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSuccess cost = ");
    localStringBuilder.append(l2);
    localStringBuilder.append(", hashCode:");
    int j = 0;
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
      paramLong = paramImageRequest.f;
    } else {
      paramLong = 0L;
    }
    int i = j;
    if (paramImageRequest != null) {
      i = paramImageRequest.d;
    }
    boolean bool = a(i);
    long l1;
    if (paramImageRequest != null) {
      l1 = paramImageRequest.i;
    } else {
      l1 = 0L;
    }
    WsBeaconReportPresenter.a().a(true, true, bool, l2, paramLong, l1, paramString1, paramString2, -1);
  }
  
  private static void b(URL paramURL, long paramLong, String paramString, KandianUrlImageView paramKandianUrlImageView, int paramInt)
  {
    String str = paramURL.toString();
    WSFallKeyPicMonitor.b(1, str);
    ThreadManager.executeOnSubThread(new WSPicLoader.3(paramURL, paramLong, paramKandianUrlImageView, str, paramString, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader
 * JD-Core Version:    0.7.0.1
 */