package com.tencent.falco.base.libapi.apm;

import android.os.Bundle;

public class APMConfiguration
{
  private Bundle extra;
  
  private APMConfiguration(APMConfiguration.Builder paramBuilder)
  {
    this.extra = APMConfiguration.Builder.access$000(paramBuilder);
  }
  
  public Bundle getExtra()
  {
    return this.extra;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.libapi.apm.APMConfiguration
 * JD-Core Version:    0.7.0.1
 */