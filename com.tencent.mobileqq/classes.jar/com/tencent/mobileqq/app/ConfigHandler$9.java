package com.tencent.mobileqq.app;

import com.tencent.mobileqq.utils.HttpDownloadUtil;
import java.io.File;
import java.net.URL;

class ConfigHandler$9
  implements Runnable
{
  ConfigHandler$9(ConfigHandler paramConfigHandler, String paramString, File paramFile) {}
  
  public void run()
  {
    try
    {
      HttpDownloadUtil.download(this.this$0.a, new URL(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_JavaIoFile);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler.9
 * JD-Core Version:    0.7.0.1
 */