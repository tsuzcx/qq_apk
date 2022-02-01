package com.tencent.mobileqq.app;

import anvl;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import java.io.File;
import java.net.URL;

public class ConfigHandler$9
  implements Runnable
{
  public ConfigHandler$9(anvl paramanvl, String paramString, File paramFile) {}
  
  public void run()
  {
    try
    {
      HttpDownloadUtil.a(this.this$0.app, new URL(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_JavaIoFile);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler.9
 * JD-Core Version:    0.7.0.1
 */