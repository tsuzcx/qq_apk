package com.tencent.gdtad.adapter;

import android.app.Activity;
import android.content.Context;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.videoceiling.AdVideoCeiling.Params;
import com.tencent.ad.tangram.videoceiling.AdVideoCeilingAdapter;
import com.tencent.ad.tangram.views.canvas.AdCanvasData;
import com.tencent.ad.tangram.views.canvas.AdCanvasDataBuilderV2;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingData;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingFragment;
import java.lang.ref.WeakReference;

public final class GdtVideoCeilingAdapter
  implements AdVideoCeilingAdapter
{
  public AdError show(AdVideoCeiling.Params paramParams)
  {
    if ((paramParams != null) && (paramParams.isValid()) && ((paramParams.ad instanceof GdtAd)))
    {
      Object localObject = new GdtVideoData();
      ((GdtVideoData)localObject).setUrl(paramParams.videoUrl);
      ((GdtVideoData)localObject).setStartPositionMillis(paramParams.videoStartPositionMillis);
      ((GdtVideoData)localObject).setLoop(paramParams.videoLoop);
      ((GdtVideoData)localObject).setDirectPlay(paramParams.videoPlayForced);
      GdtVideoCeilingData localGdtVideoCeilingData = new GdtVideoCeilingData();
      localGdtVideoCeilingData.setAd((GdtAd)GdtAd.class.cast(paramParams.ad));
      localGdtVideoCeilingData.setWebUrl(paramParams.webUrl);
      localGdtVideoCeilingData.setVideoData((GdtVideoData)localObject);
      localGdtVideoCeilingData.setWidthHeightRatio(paramParams.widthHeightRatio);
      int i = paramParams.style;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              return new AdError(4);
            }
            localObject = AdCanvasDataBuilderV2.build((Context)paramParams.activity.get(), paramParams.ad, paramParams.autodownload);
            if ((localObject != null) && (((AdCanvasData)localObject).isValid()))
            {
              localGdtVideoCeilingData.setCanvasData((AdCanvasData)localObject);
              localGdtVideoCeilingData.setStyle(4);
            }
            else
            {
              return new AdError(4);
            }
          }
          else
          {
            localGdtVideoCeilingData.setStyle(3);
          }
        }
        else {
          localGdtVideoCeilingData.setStyle(2);
        }
      }
      else {
        localGdtVideoCeilingData.setStyle(1);
      }
      if (!localGdtVideoCeilingData.isValid())
      {
        GdtLog.d("GdtVideoCeilingAdapter", "show error");
        return new AdError(4);
      }
      GdtVideoCeilingFragment.a((Activity)paramParams.activity.get(), localGdtVideoCeilingData, paramParams.extrasForIntent);
      return new AdError(0);
    }
    GdtLog.d("GdtVideoCeilingAdapter", "show error");
    return new AdError(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtVideoCeilingAdapter
 * JD-Core Version:    0.7.0.1
 */