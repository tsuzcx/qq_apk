package com.tencent.biz.pubaccount.weishi_new.util;

import cooperation.qzone.LocalMultiProcConfig;
import uxn;

public class QzoneVerticalVideoPluginApk$2
  implements Runnable
{
  public QzoneVerticalVideoPluginApk$2(uxn paramuxn) {}
  
  public void run()
  {
    LocalMultiProcConfig.putLong("sp_weishi_update_plugin", "query_plugin_last_time", System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.QzoneVerticalVideoPluginApk.2
 * JD-Core Version:    0.7.0.1
 */