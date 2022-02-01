package com.tencent.av.smallscreen.config;

import com.tencent.av.config.api.IConfigParser;
import com.tencent.qphone.base.util.QLog;

public class SmallScreenConfigParser
{
  public int a = 0;
  public int b = 0;
  public int c = -1;
  public int d = 0;
  public int e = 0;
  
  public boolean a(IConfigParser paramIConfigParser)
  {
    try
    {
      this.a = paramIConfigParser.getIntValue("sharp/small_window/version", 0);
      this.b = paramIConfigParser.getIntValue("sharp/small_window/close_flag", 0);
      this.c = paramIConfigParser.getIntValue("sharp/small_window/use_textureview", -1);
      this.d = paramIConfigParser.getIntValue("sharp/small_window/close_video", 0);
      this.e = paramIConfigParser.getIntValue("sharp/small_window/close_audio", 0);
      if (QLog.isColorLevel())
      {
        paramIConfigParser = new StringBuilder();
        paramIConfigParser.append("value_version = ");
        paramIConfigParser.append(this.a);
        paramIConfigParser.append(" , value_close_flag = ");
        paramIConfigParser.append(this.b);
        paramIConfigParser.append(" , value_use_textureview = ");
        paramIConfigParser.append(this.c);
        paramIConfigParser.append(" ,value_close_video = ");
        paramIConfigParser.append(this.d);
        paramIConfigParser.append(" , value_close_audio = ");
        paramIConfigParser.append(this.e);
        QLog.d("SmallScreenConfigParser", 2, paramIConfigParser.toString());
      }
      return true;
    }
    catch (Exception paramIConfigParser)
    {
      label171:
      break label171;
    }
    if (QLog.isColorLevel()) {
      QLog.e("SmallScreenConfigParser", 2, "parseConfig --> Error");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.smallscreen.config.SmallScreenConfigParser
 * JD-Core Version:    0.7.0.1
 */