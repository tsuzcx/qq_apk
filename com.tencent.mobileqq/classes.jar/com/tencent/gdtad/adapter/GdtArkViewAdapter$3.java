package com.tencent.gdtad.adapter;

import android.view.View;
import com.tencent.ad.tangram.ark.AdArkAdapter.Callback;
import com.tencent.ark.ArkViewImplement.InputCallback;

class GdtArkViewAdapter$3
  implements ArkViewImplement.InputCallback
{
  GdtArkViewAdapter$3(GdtArkViewAdapter paramGdtArkViewAdapter, AdArkAdapter.Callback paramCallback) {}
  
  public void onFocusChanged(View paramView, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAdTangramArkAdArkAdapter$Callback != null) {
      this.jdField_a_of_type_ComTencentAdTangramArkAdArkAdapter$Callback.onFocusChanged(paramView, paramBoolean);
    }
  }
  
  public void onHideMenu(View paramView) {}
  
  public void onSelectChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onShowMenu(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtArkViewAdapter.3
 * JD-Core Version:    0.7.0.1
 */