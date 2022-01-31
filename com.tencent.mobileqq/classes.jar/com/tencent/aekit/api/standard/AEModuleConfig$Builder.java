package com.tencent.aekit.api.standard;

import android.content.SharedPreferences;

public class AEModuleConfig$Builder
{
  private boolean debugMode;
  private boolean enableDataReport = true;
  private boolean enableDefaultBasic3 = true;
  private boolean enableDumpFilterParams = false;
  private boolean enableProfiler = false;
  private boolean enableReducedMeidaLibrary = false;
  private boolean enableResourceCheck;
  private boolean isFramebufferFetchEnable = true;
  private boolean isLoadSo = true;
  private String license;
  private int licenseInitType;
  private String lutDir;
  private String modelDir;
  private SharedPreferences preferences;
  private String soDir;
  private boolean strictMode;
  
  public AEModuleConfig build()
  {
    return new AEModuleConfig(this, null);
  }
  
  public Builder setEnableDataReport(boolean paramBoolean)
  {
    this.enableDataReport = paramBoolean;
    return this;
  }
  
  public Builder setEnableDebug(boolean paramBoolean)
  {
    this.debugMode = paramBoolean;
    return this;
  }
  
  public Builder setEnableDefaultBasic3(boolean paramBoolean)
  {
    this.enableDefaultBasic3 = paramBoolean;
    return this;
  }
  
  public Builder setEnableDumpFilterParams(boolean paramBoolean)
  {
    this.enableDumpFilterParams = paramBoolean;
    return this;
  }
  
  public Builder setEnableProfiler(boolean paramBoolean)
  {
    this.enableProfiler = paramBoolean;
    return this;
  }
  
  public Builder setEnableReducedMeidaLibrary(boolean paramBoolean)
  {
    this.enableReducedMeidaLibrary = paramBoolean;
    return this;
  }
  
  public Builder setEnableResourceCheck(boolean paramBoolean)
  {
    this.enableResourceCheck = paramBoolean;
    return this;
  }
  
  public Builder setEnableStrcitMode(boolean paramBoolean)
  {
    this.strictMode = paramBoolean;
    return this;
  }
  
  public Builder setFramebufferFetchEnable(boolean paramBoolean)
  {
    this.isFramebufferFetchEnable = paramBoolean;
    return this;
  }
  
  public Builder setLicense(String paramString)
  {
    return setLicense(paramString, 0);
  }
  
  public Builder setLicense(String paramString, int paramInt)
  {
    this.license = paramString;
    this.licenseInitType = paramInt;
    return this;
  }
  
  public Builder setLoadSo(boolean paramBoolean)
  {
    this.isLoadSo = paramBoolean;
    return this;
  }
  
  public Builder setLutDir(String paramString)
  {
    this.lutDir = paramString;
    return this;
  }
  
  public Builder setModelDir(String paramString)
  {
    this.modelDir = paramString;
    return this;
  }
  
  public Builder setPreferences(SharedPreferences paramSharedPreferences)
  {
    this.preferences = paramSharedPreferences;
    return this;
  }
  
  public Builder setSoDir(String paramString)
  {
    this.soDir = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.aekit.api.standard.AEModuleConfig.Builder
 * JD-Core Version:    0.7.0.1
 */