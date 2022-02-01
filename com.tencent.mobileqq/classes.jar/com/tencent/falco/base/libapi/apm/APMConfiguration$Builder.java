package com.tencent.falco.base.libapi.apm;

import android.os.Bundle;

public class APMConfiguration$Builder
{
  private Bundle extra;
  
  public APMConfiguration build()
  {
    return new APMConfiguration(this, null);
  }
  
  public Builder extra(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      this.extra = new Bundle();
      this.extra.putAll(paramBundle);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.libapi.apm.APMConfiguration.Builder
 * JD-Core Version:    0.7.0.1
 */