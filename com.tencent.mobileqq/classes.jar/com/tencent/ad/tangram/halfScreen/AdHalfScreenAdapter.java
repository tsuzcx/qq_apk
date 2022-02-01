package com.tencent.ad.tangram.halfScreen;

import android.support.annotation.Keep;
import com.tencent.ad.tangram.AdError;

@Keep
public abstract interface AdHalfScreenAdapter
{
  public abstract AdError show(AdHalfScreenAdapter.Params paramParams);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.halfScreen.AdHalfScreenAdapter
 * JD-Core Version:    0.7.0.1
 */