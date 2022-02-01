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
  public static final DownloadParams.DecodeHandler a;
  private int jdField_a_of_type_Int = (int)(BaseApplication.getContext().getResources().getDisplayMetrics().density * 6.0F);
  private long jdField_a_of_type_Long;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplication.getContext().getResources().getDrawable(2130838246);
  private URLDrawable.URLDrawableListener jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener = new StickerDrawableDownloader.1(this);
  private StickerDrawableDownloader.IResultListener jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterStickerDrawableDownloader$IResultListener;
  private ArrayList<URLDrawable> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ComTencentImageDownloadParams$DecodeHandler = new StickerDrawableDownloader.2();
  }
  
  @NotNull
  private URLDrawable.URLDrawableOptions a(IStickerRecEmoticon paramIStickerRecEmoticon)
  {
    Object localObject = paramIStickerRecEmoticon.a();
    paramIStickerRecEmoticon = (IStickerRecEmoticon)localObject;
    if (localObject == null) {
      paramIStickerRecEmoticon = URLDrawable.URLDrawableOptions.obtain();
    }
    localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    paramIStickerRecEmoticon.mLoadingDrawable = ((Drawable)localObject);
    paramIStickerRecEmoticon.mFailedDrawable = ((Drawable)localObject);
    paramIStickerRecEmoticon.mPlayGifImage = true;
    paramIStickerRecEmoticon.mGifRoundCorner = this.jdField_a_of_type_Int;
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
    localHashMap.put("first_sticker", String.valueOf(this.jdField_a_of_type_Boolean ^ true));
    paramURLDrawable = paramURLDrawable.getURL();
    if (paramURLDrawable != null) {
      localHashMap.put("sticker_url", paramURLDrawable.toString());
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "StickerRecImgLoad", true, paramLong, 0L, localHashMap, "");
  }
  
  public void a(StickerDrawableDownloader.IResultListener paramIResultListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterStickerDrawableDownloader$IResultListener = paramIResultListener;
  }
  
  public void a(List<IStickerRecEmoticon> paramList)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    int j = paramList.size();
    int i = 5;
    if (j < 5) {
      i = paramList.size();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    j = 0;
    this.jdField_a_of_type_Boolean = false;
    while (j < i)
    {
      IStickerRecEmoticon localIStickerRecEmoticon = (IStickerRecEmoticon)paramList.get(j);
      if (localIStickerRecEmoticon != null)
      {
        URLDrawable localURLDrawable = localIStickerRecEmoticon.a(localIStickerRecEmoticon.a(), a(localIStickerRecEmoticon));
        if (localURLDrawable != null) {
          if (((localIStickerRecEmoticon instanceof StickerRecData)) && (((StickerRecData)localIStickerRecEmoticon).e() == 3))
          {
            this.jdField_a_of_type_Boolean = true;
          }
          else
          {
            localURLDrawable.setDecodeHandler(jdField_a_of_type_ComTencentImageDownloadParams$DecodeHandler);
            localURLDrawable.setURLDrawableListener(this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener);
            if (localURLDrawable.getStatus() != 1)
            {
              this.jdField_a_of_type_JavaUtilArrayList.add(localURLDrawable);
              localURLDrawable.addHeader("my_uin", MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount());
              localURLDrawable.addHeader("emo_big", "true");
              localURLDrawable.startDownload();
            }
            else
            {
              this.jdField_a_of_type_Boolean = true;
            }
          }
        }
      }
      j += 1;
    }
    paramList = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedAdapterStickerDrawableDownloader$IResultListener;
    if (paramList != null) {
      paramList.a(this.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.StickerDrawableDownloader
 * JD-Core Version:    0.7.0.1
 */