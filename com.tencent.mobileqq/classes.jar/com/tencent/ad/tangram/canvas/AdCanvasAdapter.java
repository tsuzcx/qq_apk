package com.tencent.ad.tangram.canvas;

import android.content.Context;
import android.support.annotation.Keep;
import com.tencent.ad.tangram.AdError;
import java.lang.ref.WeakReference;

@Keep
public abstract interface AdCanvasAdapter
{
  public abstract int getQueueLength(WeakReference<Context> paramWeakReference);
  
  public abstract AdError show(AdCanvasAdapter.Params paramParams);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.AdCanvasAdapter
 * JD-Core Version:    0.7.0.1
 */