package com.tencent.biz.publicAccountImageCollection;

import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;
import com.tencent.util.VersionUtils;

class PublicAccountImageCollectionMainActivity$2
  implements View.OnSystemUiVisibilityChangeListener
{
  PublicAccountImageCollectionMainActivity$2(PublicAccountImageCollectionMainActivity paramPublicAccountImageCollectionMainActivity) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if (paramInt == 4102) {}
    while (!VersionUtils.e()) {
      return;
    }
    this.a.getWindow().getDecorView().setSystemUiVisibility(4102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity.2
 * JD-Core Version:    0.7.0.1
 */