package com.tencent.hippy.qq.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.io.File;

@QAPI(process={"all"})
public abstract interface IHippySetting
  extends QRouteApi
{
  public abstract File getHippyFileByType(String paramString);
  
  public abstract File getModuleFile(String paramString);
  
  public abstract File getModuleFile(String paramString, int paramInt);
  
  public abstract File getModuleIndex(String paramString, int paramInt);
  
  public abstract long getModuleIndexFileLength(String paramString, int paramInt);
  
  public abstract int getModuleVersion(String paramString);
  
  public abstract void setModuleVersion(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.api.IHippySetting
 * JD-Core Version:    0.7.0.1
 */