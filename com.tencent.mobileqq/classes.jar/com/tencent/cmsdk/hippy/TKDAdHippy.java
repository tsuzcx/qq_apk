package com.tencent.cmsdk.hippy;

import com.tencent.cmsdk.hippy.api.ITKDAdModule;

public class TKDAdHippy
{
  ITKDAdModule itkdAdModule;
  
  public static TKDAdHippy getInstance()
  {
    return TKDAdHippy.Holder.access$000();
  }
  
  public ITKDAdModule getTKDAdModule()
  {
    return this.itkdAdModule;
  }
  
  public void setITkdAdModule(ITKDAdModule paramITKDAdModule)
  {
    if (paramITKDAdModule != null) {
      this.itkdAdModule = paramITKDAdModule;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.cmsdk.hippy.TKDAdHippy
 * JD-Core Version:    0.7.0.1
 */