package com.tencent.mobileqq.app.compact;

import com.tencent.mobileqq.pluginsdk.PluginRuntime;

class DFPluginOatService$1
  implements Runnable
{
  DFPluginOatService$1(DFPluginOatService paramDFPluginOatService) {}
  
  public void run()
  {
    try
    {
      DFPluginOatService.a(this.this$0);
      Runtime.getRuntime().exit(-1);
      return;
    }
    catch (Exception localException)
    {
      PluginRuntime.handleCrash(localException, "sample_feature.apk", this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.compact.DFPluginOatService.1
 * JD-Core Version:    0.7.0.1
 */