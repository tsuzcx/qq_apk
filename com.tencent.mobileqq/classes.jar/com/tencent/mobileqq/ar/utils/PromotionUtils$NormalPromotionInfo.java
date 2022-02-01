package com.tencent.mobileqq.ar.utils;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;

public class PromotionUtils$NormalPromotionInfo
  extends PromotionUtils.BasePromotionInfo
{
  public String a = null;
  
  public void a(AppInterface paramAppInterface, Bundle paramBundle)
  {
    this.a = paramBundle.getString("PromotionDescription", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.utils.PromotionUtils.NormalPromotionInfo
 * JD-Core Version:    0.7.0.1
 */