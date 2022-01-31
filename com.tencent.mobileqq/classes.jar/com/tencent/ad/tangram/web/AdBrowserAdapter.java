package com.tencent.ad.tangram.web;

import android.support.annotation.Keep;
import com.tencent.ad.tangram.AdError;

@Keep
public abstract interface AdBrowserAdapter
{
  public abstract AdError show(AdBrowserAdapter.Params paramParams);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.web.AdBrowserAdapter
 * JD-Core Version:    0.7.0.1
 */