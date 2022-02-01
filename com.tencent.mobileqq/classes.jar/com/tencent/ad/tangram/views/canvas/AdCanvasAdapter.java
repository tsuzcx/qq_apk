package com.tencent.ad.tangram.views.canvas;

import android.support.annotation.Keep;
import com.tencent.ad.tangram.AdError;

@Keep
public abstract interface AdCanvasAdapter
{
  public abstract AdError show(AdCanvasAdapter.Params paramParams);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.AdCanvasAdapter
 * JD-Core Version:    0.7.0.1
 */