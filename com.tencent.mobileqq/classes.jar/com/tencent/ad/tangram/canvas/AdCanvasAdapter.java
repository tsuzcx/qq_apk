package com.tencent.ad.tangram.canvas;

import android.support.annotation.Keep;
import com.tencent.ad.tangram.AdError;

@Keep
public abstract interface AdCanvasAdapter
{
  public abstract AdError show(AdCanvasAdapter.Params paramParams);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.AdCanvasAdapter
 * JD-Core Version:    0.7.0.1
 */