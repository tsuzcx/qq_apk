package com.tencent.ad.tangram.video;

import android.support.annotation.Keep;
import java.lang.ref.WeakReference;

@Keep
public enum AdVideo
{
  INSTANCE;
  
  private WeakReference<AdVideoAdapter> adapter;
  
  private AdVideo() {}
  
  private AdVideoAdapter getAdapter()
  {
    WeakReference localWeakReference = INSTANCE.adapter;
    if (localWeakReference != null) {
      return (AdVideoAdapter)localWeakReference.get();
    }
    return null;
  }
  
  public AdVideo.CodecCapability getHEVCMaxCapability(int paramInt)
  {
    Object localObject = getAdapter();
    if (localObject != null) {
      localObject = ((AdVideoAdapter)localObject).getHEVCMaxCapability(paramInt);
    } else {
      localObject = null;
    }
    if ((localObject != null) && (((AdVideo.CodecCapability)localObject).isValid())) {
      return localObject;
    }
    return null;
  }
  
  public void setAdapter(WeakReference<AdVideoAdapter> paramWeakReference)
  {
    INSTANCE.adapter = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.video.AdVideo
 * JD-Core Version:    0.7.0.1
 */