package com.tencent.gdtad.adapter;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.ad.tangram.ark.AdArkAdapter.Callback;

class GdtArkViewAdapter$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  GdtArkViewAdapter$2(GdtArkViewAdapter paramGdtArkViewAdapter, AdArkAdapter.Callback paramCallback) {}
  
  public void onGlobalLayout()
  {
    if (this.jdField_a_of_type_ComTencentAdTangramArkAdArkAdapter$Callback != null) {
      this.jdField_a_of_type_ComTencentAdTangramArkAdArkAdapter$Callback.onGlobalLayout(GdtArkViewAdapter.a(this.jdField_a_of_type_ComTencentGdtadAdapterGdtArkViewAdapter));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtArkViewAdapter.2
 * JD-Core Version:    0.7.0.1
 */