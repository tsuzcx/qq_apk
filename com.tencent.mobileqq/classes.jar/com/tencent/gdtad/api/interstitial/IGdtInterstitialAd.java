package com.tencent.gdtad.api.interstitial;

import android.app.Activity;
import android.content.Intent;
import org.json.JSONObject;

public abstract interface IGdtInterstitialAd
{
  public abstract void a(Activity paramActivity, int paramInt, Intent paramIntent);
  
  public abstract void a(JSONObject paramJSONObject);
  
  public abstract boolean a(Activity paramActivity);
  
  public abstract void b(Activity paramActivity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.IGdtInterstitialAd
 * JD-Core Version:    0.7.0.1
 */