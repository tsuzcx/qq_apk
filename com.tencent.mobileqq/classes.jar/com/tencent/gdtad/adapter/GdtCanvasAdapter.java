package com.tencent.gdtad.adapter;

import android.app.Activity;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.views.canvas.AdCanvasAdapter;
import com.tencent.ad.tangram.views.canvas.AdCanvasAdapter.Params;
import com.tencent.ad.tangram.views.canvas.AdCanvasData;
import com.tencent.ad.tangram.views.canvas.AdCanvasDataBuilderV2;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.canvas.GdtCanvasFragment;
import java.lang.ref.WeakReference;

public final class GdtCanvasAdapter
  implements AdCanvasAdapter
{
  public AdError show(AdCanvasAdapter.Params paramParams)
  {
    if ((paramParams != null) && (paramParams.isValid()) && ((paramParams.ad instanceof GdtAd)))
    {
      Object localObject = (GdtAd)GdtAd.class.cast(paramParams.ad);
      localObject = AdCanvasDataBuilderV2.build(((Activity)paramParams.activity.get()).getApplicationContext(), (Ad)localObject, paramParams.autoDownload);
      if ((localObject != null) && (((AdCanvasData)localObject).isValid()))
      {
        GdtCanvasFragment.a((Activity)paramParams.activity.get(), (AdCanvasData)localObject, paramParams.extrasForIntent);
        return new AdError(0);
      }
      GdtLog.d("GdtCanvasAdapter", "show error");
      return new AdError(4);
    }
    GdtLog.d("GdtCanvasAdapter", "show error");
    return new AdError(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtCanvasAdapter
 * JD-Core Version:    0.7.0.1
 */