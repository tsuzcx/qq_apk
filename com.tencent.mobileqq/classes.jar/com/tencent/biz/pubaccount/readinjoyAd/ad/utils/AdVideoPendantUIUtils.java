package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ADVideoItemHolder;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
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
    if (paramADVideoItemHolder.az.c.as.ay != null) {
      try
      {
        localObject = URLDrawable.getDrawable(new URL(paramADVideoItemHolder.az.c.as.ay), (URLDrawable.URLDrawableOptions)localObject);
        paramADVideoItemHolder.S.setImageDrawable((Drawable)localObject);
        return;
      }
      catch (MalformedURLException paramADVideoItemHolder)
      {
        paramADVideoItemHolder.printStackTrace();
      }
    }
  }
  
  public static void a(boolean paramBoolean1, VideoItemHolder paramVideoItemHolder, boolean paramBoolean2, View.OnClickListener paramOnClickListener)
  {
    if (!(paramVideoItemHolder instanceof ADVideoItemHolder)) {
      return;
    }
    paramVideoItemHolder = (ADVideoItemHolder)paramVideoItemHolder;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        int i = AIOUtils.b(15.0F, BaseApplication.getContext().getResources());
        int j = AIOUtils.b(202.0F, BaseApplication.getContext().getResources());
        paramVideoItemHolder.T.setPadding(i, 0, 0, j);
      }
      paramVideoItemHolder.S.setVisibility(0);
      a(paramVideoItemHolder);
    }
    else
    {
      paramVideoItemHolder.S.setVisibility(8);
    }
    if (paramVideoItemHolder.S != null)
    {
      paramVideoItemHolder.S.setOnClickListener(paramOnClickListener);
      paramVideoItemHolder.S.setTag(paramVideoItemHolder);
    }
  }
  
  public static boolean a(VideoInfo paramVideoInfo)
  {
    return (paramVideoInfo != null) && (paramVideoInfo.as != null) && (paramVideoInfo.as.ax == 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdVideoPendantUIUtils
 * JD-Core Version:    0.7.0.1
 */