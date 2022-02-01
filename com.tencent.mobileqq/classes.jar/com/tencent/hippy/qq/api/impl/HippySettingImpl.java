package com.tencent.hippy.qq.api.impl;

import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.update.HippyQQFileUtil;
import com.tencent.hippy.qq.update.UpdateSetting;
import java.io.File;

public class HippySettingImpl
  implements IHippySetting
{
  public File getHippyFileByType(String paramString)
  {
    return HippyQQFileUtil.getHippyFileByType(paramString);
  }
  
  public File getModuleFile(String paramString)
  {
    return HippyQQFileUtil.getModuleFile(paramString);
  }
  
  public File getModuleFile(String paramString, int paramInt)
  {
    return HippyQQFileUtil.getModuleFile(paramString, paramInt);
  }
  
  public File getModuleIndex(String paramString, int paramInt)
  {
    return HippyQQFileUtil.getModuleIndex(paramString, paramInt);
  }
  
  public int getModuleVersion(String paramString)
  {
    return UpdateSetting.getInstance().getModuleVersion(paramString);
  }
  
  public void setModuleVersion(String paramString, int paramInt)
  {
    UpdateSetting.getInstance().setModuleVersion(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.api.impl.HippySettingImpl
 * JD-Core Version:    0.7.0.1
 */