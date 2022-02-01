package com.tencent.mobileqq.ar.utils;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;

public abstract class PromotionUtils$BasePromotionInfo
{
  public long g = 0L;
  public String h = "0";
  public String i = "0";
  public boolean j = true;
  public boolean k = true;
  public boolean l = false;
  
  public abstract void a(AppInterface paramAppInterface, Bundle paramBundle);
  
  public final void b(AppInterface paramAppInterface, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    this.g = paramBundle.getLong("RecoglizeMask", 0L);
    this.h = paramBundle.getString("H5Source", "0");
    this.i = paramBundle.getString("version", "0");
    this.j = (paramBundle.getBoolean("disablecloud", false) ^ true);
    this.l = paramBundle.getBoolean("is_from_h5_entry", false);
    this.k = false;
    a(paramAppInterface, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.utils.PromotionUtils.BasePromotionInfo
 * JD-Core Version:    0.7.0.1
 */