package com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload;

import android.text.TextUtils;

class AdMaterialResManager$1
  extends AdMaterialObserver
{
  AdMaterialResManager$1(AdMaterialResManager paramAdMaterialResManager) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      AdMaterialResManager.a(this.a, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.AdMaterialResManager.1
 * JD-Core Version:    0.7.0.1
 */