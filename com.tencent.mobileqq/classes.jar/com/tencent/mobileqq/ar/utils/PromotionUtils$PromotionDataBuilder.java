package com.tencent.mobileqq.ar.utils;

import android.os.Bundle;

public class PromotionUtils$PromotionDataBuilder
{
  private Bundle a;
  
  public PromotionUtils$PromotionDataBuilder(Bundle paramBundle)
  {
    this.a = paramBundle;
  }
  
  public Bundle a()
  {
    return this.a;
  }
  
  public void a(long paramLong)
  {
    this.a.putLong("downloadItems", paramLong);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.putBoolean("NoLimitParams", paramBoolean);
  }
  
  public void b(long paramLong)
  {
    this.a.putLong("recognitionMask", paramLong);
  }
  
  public void b(boolean paramBoolean)
  {
    this.a.putBoolean("arTransferPromotion", paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.utils.PromotionUtils.PromotionDataBuilder
 * JD-Core Version:    0.7.0.1
 */