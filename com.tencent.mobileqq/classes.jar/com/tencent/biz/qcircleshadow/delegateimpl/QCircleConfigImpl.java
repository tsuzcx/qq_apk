package com.tencent.biz.qcircleshadow.delegateimpl;

import com.tencent.biz.richframework.delegate.IConfigDelegate;
import common.config.service.QzoneConfig;

public class QCircleConfigImpl
  implements IConfigDelegate
{
  public Boolean getConfigValue(String paramString1, String paramString2, Boolean paramBoolean)
  {
    return Boolean.valueOf(QzoneConfig.getInstance().getConfig(paramString1, paramString2, paramBoolean.booleanValue()));
  }
  
  public Float getConfigValue(String paramString1, String paramString2, Float paramFloat)
  {
    return Float.valueOf(QzoneConfig.getInstance().getConfig(paramString1, paramString2, paramFloat.floatValue()));
  }
  
  public Integer getConfigValue(String paramString1, String paramString2, Integer paramInteger)
  {
    return Integer.valueOf(QzoneConfig.getInstance().getConfig(paramString1, paramString2, paramInteger.intValue()));
  }
  
  public Long getConfigValue(String paramString1, String paramString2, Long paramLong)
  {
    return Long.valueOf(QzoneConfig.getInstance().getConfig(paramString1, paramString2, paramLong.longValue()));
  }
  
  public String getConfigValue(String paramString1, String paramString2)
  {
    return getConfigValue(paramString1, paramString2, "");
  }
  
  public String getConfigValue(String paramString1, String paramString2, String paramString3)
  {
    return QzoneConfig.getInstance().getConfig(paramString1, paramString2, paramString3);
  }
  
  public void updateOneConfig(String paramString1, String paramString2, String paramString3)
  {
    QzoneConfig.getInstance().updateOneConfig(paramString1, paramString2, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.delegateimpl.QCircleConfigImpl
 * JD-Core Version:    0.7.0.1
 */