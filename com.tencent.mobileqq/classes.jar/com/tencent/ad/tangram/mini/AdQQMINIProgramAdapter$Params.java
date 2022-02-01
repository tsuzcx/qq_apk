package com.tencent.ad.tangram.mini;

import android.content.Context;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import java.lang.ref.WeakReference;

@Keep
public final class AdQQMINIProgramAdapter$Params
{
  public Ad ad;
  public WeakReference<Context> context;
  
  public boolean isValid()
  {
    Object localObject = this.context;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      localObject = this.ad;
      if ((localObject != null) && (((Ad)localObject).isValid()) && (!TextUtils.isEmpty(this.ad.getUrlForLandingPage()))) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.mini.AdQQMINIProgramAdapter.Params
 * JD-Core Version:    0.7.0.1
 */