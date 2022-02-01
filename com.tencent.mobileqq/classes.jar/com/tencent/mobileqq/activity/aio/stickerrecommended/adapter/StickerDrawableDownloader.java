package com.tencent.mobileqq.activity.aio.stickerrecommended.adapter;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecData;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

public class StickerDrawableDownloader
{
  public static final DownloadParams.DecodeHandler a = new StickerDrawableDownloader.2();
  private ArrayList<URLDrawable> b = new ArrayList(5);
  private boolean c;
  private long d;
  private int e = (int)(BaseApplication.getContext().getResources().getDisplayMetrics().density * 6.0F);
  private Drawable f = BaseApplication.getContext().getResources().getDrawable(2130838305);
  private StickerDrawableDownloader.IResultListener g;
  private URLDrawable.URLDrawableListener h = new StickerDrawableDownloader.1(this);
  
  @NotNull
  private URLDrawable.URLDrawableOptions a(IStickerRecEmoticon paramIStickerRecEmoticon)
  {
    Object localObject = paramIStickerRecEmoticon.c();
    paramIStickerRecEmoticon = (IStickerRecEmoticon)localObject;
    if (localObject == null) {
      paramIStickerRecEmoticon = URLDrawable.URLDrawableOptions.obtain();
    }
    localObject = this.f;
    paramIStickerRecEmoticon.mLoadingDrawable = ((Drawable)localObject);
    paramIStickerRecEmoticon.mFailedDrawable = ((Drawable)localObject);
    paramIStickerRecEmoticon.mPlayGifImage = true;
    paramIStickerRecEmoticon.mGifRoundCorner = this.e;
    return paramIStickerRecEmoticon;
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    paramURLDrawable = paramURLDrawable.getURL();
    if (paramURLDrawable != null) {
      localHashMap.put("sticker_url", paramURLDrawable.toString());
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "StickerRecImgLoad", false, 0L, 0L, localHashMap, "");
  }
  
  private void a(URLDrawable paramURLDrawable, long paramLong)
  {
    if (paramURLDrawable == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("first_sticker", String.valueOf(this.c ^ true));
    paramURLDrawable = paramURLDrawable.getURL();
    if (paramURLDrawable != null) {
      localHashMap.put("sticker_url", paramURLDrawable.toString());
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "StickerRecImgLoad", true, paramLong, 0L, localHashMap, "");
  }
  
  public void a(StickerDrawableDownloader.IResultListener paramIResultListener)
  {
    this.g = paramIResultListener;
  }
  
  public void a(List<IStickerRecEmoticon> paramList)
  {
    this.d = System.currentTimeMillis();
    int j = paramList.size();
    int i = 5;
    if (j < 5) {
      i = paramList.size();
    }
    this.b.clear();
    j = 0;
    this.c = false;
    while (j < i)
    {
      IStickerRecEmoticon localIStickerRecEmoticon = (IStickerRecEmoticon)paramList.get(j);
      if (localIStickerRecEmoticon != null)
      {
        URLDrawable localURLDrawable = localIStickerRecEmoticon.a(localIStickerRecEmoticon.k(), a(localIStickerRecEmoticon));
        if (localURLDrawable != null) {
          if (((localIStickerRecEmoticon instanceof StickerRecData)) && (((StickerRecData)localIStickerRecEmoticon).s() == 3))
          {
            this.c = true;
          }
          else
          {
            localURLDrawable.setDecodeHandler(a);
            localURLDrawable.setURLDrawableListener(this.h);
            if (localURLDrawable.getStatus() != 1)
            {
              this.b.add(localURLDrawable);
              localURLDrawable.addHeader("my_uin", MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount());
              localURLDrawable.addHeader("emo_big", "true");
              localURLDrawable.startDownload();
            }
            else
            {
              this.c = true;
            }
          }
        }
      }
      j += 1;
    }
    paramList = this.g;
    if (paramList != null) {
      paramList.a(this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.StickerDrawableDownloader
 * JD-Core Version:    0.7.0.1
 */