package com.tencent.gdtad.adapter;

import com.tencent.ad.tangram.image.AdImageViewAdapter.Callback;
import com.tencent.ad.tangram.image.AdImageViewAdapter.Params;
import com.tencent.gdtad.views.image.GdtGifImageView.LoadListener;
import java.lang.ref.WeakReference;

class GdtImageViewBuilderAdapter$1
  implements GdtGifImageView.LoadListener
{
  GdtImageViewBuilderAdapter$1(GdtImageViewBuilderAdapter paramGdtImageViewBuilderAdapter, AdImageViewAdapter.Params paramParams) {}
  
  public void a(boolean paramBoolean)
  {
    ((AdImageViewAdapter.Callback)this.a.callback.get()).onStopLoad(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtImageViewBuilderAdapter.1
 * JD-Core Version:    0.7.0.1
 */