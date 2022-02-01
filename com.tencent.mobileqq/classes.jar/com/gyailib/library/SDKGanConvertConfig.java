package com.gyailib.library;

import android.text.TextUtils;
import java.util.List;

public class SDKGanConvertConfig
{
  private boolean createOutTexture = true;
  private String kernelClPath;
  private List<String> postProcessBlobNames;
  private boolean postProcessEnable = true;
  private String postProcessFunc;
  private boolean preProcessEnable = true;
  private String preProcessFunc;
  
  public String getKernelClPath()
  {
    return this.kernelClPath;
  }
  
  public String getPostProcessBlobNames()
  {
    return TextUtils.join(" ", this.postProcessBlobNames);
  }
  
  public String getPostProcessFunc()
  {
    return this.postProcessFunc;
  }
  
  public String getPreProcessFunc()
  {
    return this.preProcessFunc;
  }
  
  public boolean isCreateOutTexture()
  {
    return this.createOutTexture;
  }
  
  public boolean isPostProcessEnable()
  {
    return this.postProcessEnable;
  }
  
  public boolean isPreProcessEnable()
  {
    return this.preProcessEnable;
  }
  
  public void setCreateOutTexture(boolean paramBoolean)
  {
    this.createOutTexture = paramBoolean;
  }
  
  public void setKernelClPath(String paramString)
  {
    this.kernelClPath = paramString;
  }
  
  public void setPostProcessBlobNames(List<String> paramList)
  {
    this.postProcessBlobNames = paramList;
  }
  
  public void setPostProcessEnable(boolean paramBoolean)
  {
    this.postProcessEnable = paramBoolean;
  }
  
  public void setPostProcessFunc(String paramString)
  {
    this.postProcessFunc = paramString;
  }
  
  public void setPreProcessEnable(boolean paramBoolean)
  {
    this.preProcessEnable = paramBoolean;
  }
  
  public void setPreProcessFunc(String paramString)
  {
    this.preProcessFunc = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.gyailib.library.SDKGanConvertConfig
 * JD-Core Version:    0.7.0.1
 */