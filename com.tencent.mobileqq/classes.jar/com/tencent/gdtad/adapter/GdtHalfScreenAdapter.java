package com.tencent.gdtad.adapter;

import android.app.Activity;
import android.content.Context;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.halfScreen.AdHalfScreenAdapter;
import com.tencent.ad.tangram.halfScreen.AdHalfScreenAdapter.Params;
import com.tencent.ad.tangram.views.canvas.AdCanvasData;
import com.tencent.ad.tangram.views.canvas.AdCanvasDataBuilderV2;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.jsbridge.GdtBaseHalfScreenFragmentForJs;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.halfScreen.GdtBaseHalfScreenFragment;
import java.lang.ref.WeakReference;

public class GdtHalfScreenAdapter
  implements AdHalfScreenAdapter
{
  public AdError show(AdHalfScreenAdapter.Params paramParams)
  {
    if ((paramParams != null) && (paramParams.isValid()) && ((paramParams.ad instanceof GdtAd)))
    {
      Object localObject = null;
      if (paramParams.style == 2)
      {
        AdCanvasData localAdCanvasData = AdCanvasDataBuilderV2.build((Context)paramParams.activity.get(), paramParams.ad, paramParams.autodownload);
        if (localAdCanvasData != null)
        {
          localObject = localAdCanvasData;
          if (localAdCanvasData.isValid()) {}
        }
        else
        {
          return new AdError(4);
        }
      }
      GdtBaseHalfScreenFragment.a((Activity)paramParams.activity.get(), GdtBaseHalfScreenFragmentForJs.class, paramParams.ad, localObject, paramParams.webUrl, paramParams.style, paramParams.extrasForIntent);
      return new AdError(0);
    }
    GdtLog.d("GdtHalfScreenAdapter", "show error");
    return new AdError(4);
  }
  
  public AdError showWithoutAd(AdHalfScreenAdapter.Params paramParams)
  {
    if (paramParams == null)
    {
      GdtLog.d("GdtHalfScreenAdapter", "showWithoutAd error");
      return new AdError(4);
    }
    GdtBaseHalfScreenFragment.a((Activity)paramParams.activity.get(), GdtBaseHalfScreenFragmentForJs.class, paramParams.webUrl, paramParams.extrasForIntent);
    return new AdError(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtHalfScreenAdapter
 * JD-Core Version:    0.7.0.1
 */