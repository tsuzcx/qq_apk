package com.tencent.gdtad.adapter;

import android.content.Context;
import android.view.View;
import com.tencent.ad.tangram.image.AdImageViewAdapter;
import com.tencent.ad.tangram.image.AdImageViewAdapter.Params;
import com.tencent.gdtad.views.image.GdtGifImageView;
import java.lang.ref.WeakReference;

public class GdtImageViewBuilderAdapter
  implements AdImageViewAdapter
{
  public View buildImageView(AdImageViewAdapter.Params paramParams)
  {
    if ((paramParams != null) && (paramParams.isValid()))
    {
      WeakReference localWeakReference = new WeakReference(new GdtImageViewBuilderAdapter.1(this, paramParams));
      return new GdtGifImageView((Context)paramParams.context.get(), paramParams.url, paramParams.gaussianUrl, localWeakReference, paramParams.isOnlyLoadGaussianUrl);
    }
    return null;
  }
  
  public void buildImageView(AdImageViewAdapter.Params paramParams, View paramView)
  {
    if ((paramView != null) && (paramParams != null) && (paramParams.isValid()))
    {
      WeakReference localWeakReference = new WeakReference(new GdtImageViewBuilderAdapter.2(this, paramParams));
      ((GdtGifImageView)paramView).a(paramParams.url, localWeakReference);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtImageViewBuilderAdapter
 * JD-Core Version:    0.7.0.1
 */