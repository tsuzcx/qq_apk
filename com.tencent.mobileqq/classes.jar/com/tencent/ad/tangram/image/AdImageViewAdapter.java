package com.tencent.ad.tangram.image;

import android.support.annotation.Keep;
import android.view.View;

@Keep
public abstract interface AdImageViewAdapter
{
  public abstract View buildImageView(AdImageViewAdapter.Params paramParams);
  
  public abstract void buildImageView(AdImageViewAdapter.Params paramParams, View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.image.AdImageViewAdapter
 * JD-Core Version:    0.7.0.1
 */