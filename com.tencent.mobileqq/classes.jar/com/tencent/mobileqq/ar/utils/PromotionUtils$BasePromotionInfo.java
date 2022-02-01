package com.tencent.mobileqq.ar.utils;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;

public abstract class PromotionUtils$BasePromotionInfo
{
  public long a;
  public boolean a;
  public boolean b = true;
  public boolean c = false;
  public String g = "0";
  public String h = "0";
  
  public PromotionUtils$BasePromotionInfo()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public abstract void a(AppInterface paramAppInterface, Bundle paramBundle);
  
  public final void b(AppInterface paramAppInterface, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    this.jdField_a_of_type_Long = paramBundle.getLong("RecoglizeMask", 0L);
    this.g = paramBundle.getString("H5Source", "0");
    this.h = paramBundle.getString("version", "0");
    if (!paramBundle.getBoolean("disablecloud", false)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.c = paramBundle.getBoolean("is_from_h5_entry", false);
      this.b = false;
      a(paramAppInterface, paramBundle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.utils.PromotionUtils.BasePromotionInfo
 * JD-Core Version:    0.7.0.1
 */