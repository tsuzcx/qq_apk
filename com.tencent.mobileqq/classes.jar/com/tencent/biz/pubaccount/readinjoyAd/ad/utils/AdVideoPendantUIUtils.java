package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ADVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.VideoItemHolder;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.net.MalformedURLException;
import java.net.URL;

public class AdVideoPendantUIUtils
{
  private static void a(ADVideoItemHolder paramADVideoItemHolder)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(-16777216);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    if (paramADVideoItemHolder.a.a.a.K != null) {}
    try
    {
      localObject = URLDrawable.getDrawable(new URL(paramADVideoItemHolder.a.a.a.K), (URLDrawable.URLDrawableOptions)localObject);
      paramADVideoItemHolder.b.setImageDrawable((Drawable)localObject);
      return;
    }
    catch (MalformedURLException paramADVideoItemHolder)
    {
      paramADVideoItemHolder.printStackTrace();
    }
  }
  
  public static void a(boolean paramBoolean1, VideoItemHolder paramVideoItemHolder, boolean paramBoolean2, View.OnClickListener paramOnClickListener)
  {
    if (!(paramVideoItemHolder instanceof ADVideoItemHolder)) {}
    for (;;)
    {
      return;
      ADVideoItemHolder localADVideoItemHolder = (ADVideoItemHolder)paramVideoItemHolder;
      if (paramBoolean1)
      {
        if (paramBoolean2)
        {
          int i = AIOUtils.a(15.0F, BaseApplication.getContext().getResources());
          int j = AIOUtils.a(202.0F, BaseApplication.getContext().getResources());
          ((ADVideoItemHolder)paramVideoItemHolder).d.setPadding(i, 0, 0, j);
        }
        localADVideoItemHolder.b.setVisibility(0);
        a(localADVideoItemHolder);
      }
      while (localADVideoItemHolder.b != null)
      {
        localADVideoItemHolder.b.setOnClickListener(paramOnClickListener);
        localADVideoItemHolder.b.setTag(localADVideoItemHolder);
        return;
        ((ADVideoItemHolder)paramVideoItemHolder).b.setVisibility(8);
      }
    }
  }
  
  public static boolean a(VideoInfo paramVideoInfo)
  {
    return (paramVideoInfo != null) && (paramVideoInfo.a != null) && (paramVideoInfo.a.t == 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdVideoPendantUIUtils
 * JD-Core Version:    0.7.0.1
 */