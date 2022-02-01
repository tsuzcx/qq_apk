package com.tencent.av.opengl.config;

import com.tencent.av.business.config.ConfigManager;
import com.tencent.av.config.api.IConfigParser;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class RendererConfig
{
  public int a;
  public int b;
  public int c;
  public String d;
  
  public static RendererConfig a()
  {
    IConfigParser localIConfigParser = ConfigManager.c(BaseApplication.getContext());
    if (!localIConfigParser.isEmpty())
    {
      RendererConfig localRendererConfig = new RendererConfig();
      localRendererConfig.a(localIConfigParser);
      return localRendererConfig;
    }
    return null;
  }
  
  public boolean a(IConfigParser paramIConfigParser)
  {
    try
    {
      this.a = paramIConfigParser.getIntValue("OpenGLBlowUp/IsOpen", 0);
      this.b = paramIConfigParser.getIntValue("OpenGLBlowUp/width", 0);
      this.c = paramIConfigParser.getIntValue("OpenGLBlowUp/level", 0);
      this.d = paramIConfigParser.getStringValue("OpenGLBlowUp/versionname", "");
      if (QLog.isColorLevel())
      {
        paramIConfigParser = new StringBuilder();
        paramIConfigParser.append("OpenGLSharpenConfig isOpen: ");
        paramIConfigParser.append(this.a);
        paramIConfigParser.append(" width: ");
        paramIConfigParser.append(this.b);
        paramIConfigParser.append(" level: ");
        paramIConfigParser.append(this.c);
        paramIConfigParser.append(" versionName: ");
        paramIConfigParser.append(this.d);
        QLog.i("RendererConfig", 2, paramIConfigParser.toString());
      }
      return true;
    }
    catch (Exception paramIConfigParser) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.config.RendererConfig
 * JD-Core Version:    0.7.0.1
 */