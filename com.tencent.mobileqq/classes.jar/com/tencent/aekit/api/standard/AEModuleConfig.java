package com.tencent.aekit.api.standard;

import android.content.SharedPreferences;
import com.tencent.ttpic.filter.aifilter.NetworkRequest;

public class AEModuleConfig
{
  private int authMode;
  private boolean debugMode;
  private boolean enableDataReport;
  private boolean enableDefaultBasic3;
  private boolean enableDumpFilterParams;
  private boolean enableProfiler;
  private boolean enableReducedMeidaLibrary;
  private boolean enableResourceCheck;
  private boolean enableSoLoadCheck = true;
  private boolean isFramebufferFetchEnable;
  private boolean isLoadSo;
  private String license;
  private int licenseInitType;
  private String lutDir;
  private String modelDir;
  private NetworkRequest networkRequest;
  private SharedPreferences preferences;
  private String soDir;
  private boolean strictMode;
  
  private AEModuleConfig(AEModuleConfig.Builder paramBuilder)
  {
    this.isLoadSo = AEModuleConfig.Builder.access$000(paramBuilder);
    this.lutDir = AEModuleConfig.Builder.access$100(paramBuilder);
    this.modelDir = AEModuleConfig.Builder.access$200(paramBuilder);
    this.enableDefaultBasic3 = AEModuleConfig.Builder.access$300(paramBuilder);
    this.soDir = AEModuleConfig.Builder.access$400(paramBuilder);
    this.license = AEModuleConfig.Builder.access$500(paramBuilder);
    this.licenseInitType = AEModuleConfig.Builder.access$600(paramBuilder);
    this.preferences = AEModuleConfig.Builder.access$700(paramBuilder);
    this.isFramebufferFetchEnable = AEModuleConfig.Builder.access$800(paramBuilder);
    this.debugMode = AEModuleConfig.Builder.access$900(paramBuilder);
    this.strictMode = AEModuleConfig.Builder.access$1000(paramBuilder);
    this.enableResourceCheck = AEModuleConfig.Builder.access$1100(paramBuilder);
    this.enableDataReport = AEModuleConfig.Builder.access$1200(paramBuilder);
    this.enableProfiler = AEModuleConfig.Builder.access$1300(paramBuilder);
    this.enableDumpFilterParams = AEModuleConfig.Builder.access$1400(paramBuilder);
    this.enableReducedMeidaLibrary = AEModuleConfig.Builder.access$1500(paramBuilder);
    this.networkRequest = AEModuleConfig.Builder.access$1600(paramBuilder);
    this.authMode = AEModuleConfig.Builder.access$1700(paramBuilder);
    this.enableSoLoadCheck = AEModuleConfig.Builder.access$1800(paramBuilder);
  }
  
  public static AEModuleConfig.Builder newBuilder()
  {
    return new AEModuleConfig.Builder();
  }
  
  public int getAuthMode()
  {
    return this.authMode;
  }
  
  public boolean getIsLoadSo()
  {
    return this.isLoadSo;
  }
  
  public String getLicense()
  {
    return this.license;
  }
  
  public int getLicenseInitType()
  {
    return this.licenseInitType;
  }
  
  public String getLutDir()
  {
    return this.lutDir;
  }
  
  public String getModelDir()
  {
    return this.modelDir;
  }
  
  public NetworkRequest getNetworkRequest()
  {
    return this.networkRequest;
  }
  
  public SharedPreferences getPreferences()
  {
    return this.preferences;
  }
  
  public String getSoDir()
  {
    return this.soDir;
  }
  
  public boolean isDebugMode()
  {
    return this.debugMode;
  }
  
  public boolean isEnableDataReport()
  {
    return this.enableDataReport;
  }
  
  public boolean isEnableDefaultBasic3()
  {
    return this.enableDefaultBasic3;
  }
  
  public boolean isEnableDumpFilterParams()
  {
    return this.enableDumpFilterParams;
  }
  
  public boolean isEnableProfiler()
  {
    return this.enableProfiler;
  }
  
  public boolean isEnableReducedMeidaLibrary()
  {
    return this.enableReducedMeidaLibrary;
  }
  
  public boolean isEnableResourceCheck()
  {
    return this.enableResourceCheck;
  }
  
  public boolean isEnableSoLoadCheck()
  {
    return this.enableSoLoadCheck;
  }
  
  public boolean isFramebufferFetchEnable()
  {
    return this.isFramebufferFetchEnable;
  }
  
  public boolean isStrictMode()
  {
    return this.strictMode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.aekit.api.standard.AEModuleConfig
 * JD-Core Version:    0.7.0.1
 */