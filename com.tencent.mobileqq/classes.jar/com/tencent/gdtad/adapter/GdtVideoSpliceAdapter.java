package com.tencent.gdtad.adapter;

import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.videoceiling.AdVideoSpliceAdapter;
import com.tencent.ad.tangram.videoceiling.AdVideoSpliceAdapter.Params;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.videoimax.TransitionContext;

public class GdtVideoSpliceAdapter
  implements AdVideoSpliceAdapter
{
  public AdError show(AdVideoSpliceAdapter.Params paramParams)
  {
    if ((paramParams != null) && (paramParams.isValid()) && ((paramParams.ad instanceof GdtAd)))
    {
      GdtLog.b("GdtVideoSpliceAdapter", "show");
      new TransitionContext(paramParams).b();
      return new AdError(0);
    }
    GdtLog.d("GdtVideoSpliceAdapter", "show error");
    return new AdError(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtVideoSpliceAdapter
 * JD-Core Version:    0.7.0.1
 */