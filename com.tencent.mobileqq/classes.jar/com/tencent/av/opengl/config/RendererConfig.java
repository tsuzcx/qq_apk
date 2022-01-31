package com.tencent.av.opengl.config;

import android.text.TextUtils;
import com.tencent.av.config.ConfigBaseParser;
import com.tencent.av.config.ConfigInfo;
import com.tencent.qphone.base.util.QLog;

public class RendererConfig
  extends ConfigBaseParser
{
  public int a;
  public String a;
  public int b;
  public int c;
  
  public RendererConfig(String paramString)
  {
    super(paramString);
  }
  
  public static RendererConfig a()
  {
    Object localObject = ConfigInfo.instance().getSharpConfigPayloadFromFile();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new RendererConfig((String)localObject);
      if (((RendererConfig)localObject).a()) {}
      return localObject;
    }
    return null;
  }
  
  public boolean a()
  {
    try
    {
      this.jdField_a_of_type_Int = a("OpenGLBlowUp/IsOpen", 0);
      this.b = a("OpenGLBlowUp/width", 0);
      this.c = a("OpenGLBlowUp/level", 0);
      this.jdField_a_of_type_JavaLangString = a("OpenGLBlowUp/versionname", "");
      if (QLog.isColorLevel()) {
        QLog.i("RendererConfig", 2, "OpenGLSharpenConfig isOpen: " + this.jdField_a_of_type_Int + " width: " + this.b + " level: " + this.c + " versionName: " + this.jdField_a_of_type_JavaLangString);
      }
      return true;
    }
    catch (Exception localException) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.opengl.config.RendererConfig
 * JD-Core Version:    0.7.0.1
 */