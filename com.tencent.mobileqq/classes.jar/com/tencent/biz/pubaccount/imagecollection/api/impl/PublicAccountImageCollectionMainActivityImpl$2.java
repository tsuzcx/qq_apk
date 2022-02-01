package com.tencent.biz.pubaccount.imagecollection.api.impl;

import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;
import com.tencent.util.VersionUtils;

class PublicAccountImageCollectionMainActivityImpl$2
  implements View.OnSystemUiVisibilityChangeListener
{
  PublicAccountImageCollectionMainActivityImpl$2(PublicAccountImageCollectionMainActivityImpl paramPublicAccountImageCollectionMainActivityImpl) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if (paramInt == 4102) {
      return;
    }
    if (VersionUtils.e()) {
      this.a.getWindow().getDecorView().setSystemUiVisibility(4102);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl.2
 * JD-Core Version:    0.7.0.1
 */