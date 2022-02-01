package com.tencent.av.opengl.config;

import com.tencent.av.business.config.ConfigManager;
import com.tencent.av.config.ConfigBaseParser;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class RendererConfig
{
  public int a;
  public String a;
  public int b;
  public int c;
  
  public static RendererConfig a()
  {
    ConfigBaseParser localConfigBaseParser = ConfigManager.a(BaseApplicationImpl.getContext());
    if (!localConfigBaseParser.a())
    {
      RendererConfig localRendererConfig = new RendererConfig();
      if (localRendererConfig.a(localConfigBaseParser)) {}
      return localRendererConfig;
    }
    return null;
  }
  
  public boolean a(ConfigBaseParser paramConfigBaseParser)
  {
    try
    {
      this.jdField_a_of_type_Int = paramConfigBaseParser.a("OpenGLBlowUp/IsOpen", 0);
      this.b = paramConfigBaseParser.a("OpenGLBlowUp/width", 0);
      this.c = paramConfigBaseParser.a("OpenGLBlowUp/level", 0);
      this.jdField_a_of_type_JavaLangString = paramConfigBaseParser.a("OpenGLBlowUp/versionname", "");
      if (QLog.isColorLevel()) {
        QLog.i("RendererConfig", 2, "OpenGLSharpenConfig isOpen: " + this.jdField_a_of_type_Int + " width: " + this.b + " level: " + this.c + " versionName: " + this.jdField_a_of_type_JavaLangString);
      }
      return true;
    }
    catch (Exception paramConfigBaseParser) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.config.RendererConfig
 * JD-Core Version:    0.7.0.1
 */