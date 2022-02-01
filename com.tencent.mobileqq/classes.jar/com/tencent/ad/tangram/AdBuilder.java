package com.tencent.ad.tangram;

import android.support.annotation.Keep;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp.AdInfo;
import java.lang.ref.WeakReference;

@Keep
public enum AdBuilder
{
  INSTANCE;
  
  private static final String TAG = "AdBuilder";
  private WeakReference<AdBuilderAdapter> adapter;
  
  private AdBuilder() {}
  
  public Ad build(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    AdBuilderAdapter localAdBuilderAdapter = getAdapter();
    Ad localAd = null;
    if (localAdBuilderAdapter == null) {
      return null;
    }
    if (localAdBuilderAdapter != null) {
      localAd = localAdBuilderAdapter.build(paramAdInfo);
    }
    return localAd;
  }
  
  public AdBuilderAdapter getAdapter()
  {
    WeakReference localWeakReference = this.adapter;
    if (localWeakReference != null) {
      return (AdBuilderAdapter)localWeakReference.get();
    }
    return null;
  }
  
  public void setAdapter(WeakReference<AdBuilderAdapter> paramWeakReference)
  {
    this.adapter = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.AdBuilder
 * JD-Core Version:    0.7.0.1
 */