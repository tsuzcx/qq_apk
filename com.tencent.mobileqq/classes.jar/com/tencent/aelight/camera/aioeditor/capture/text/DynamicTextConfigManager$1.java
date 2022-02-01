package com.tencent.aelight.camera.aioeditor.capture.text;

import java.util.ArrayList;
import java.util.Iterator;

class DynamicTextConfigManager$1
  implements Runnable
{
  DynamicTextConfigManager$1(DynamicTextConfigManager paramDynamicTextConfigManager, DynamicTextConfigManager.DynamicTextConfigBean paramDynamicTextConfigBean, DynamicTextConfigManager.IDynamicTextResDownloadCallback paramIDynamicTextResDownloadCallback) {}
  
  public void run()
  {
    Iterator localIterator = this.a.fontInfos.iterator();
    while (localIterator.hasNext())
    {
      DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo localDynamicTextFontInfo = (DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo)localIterator.next();
      DynamicTextConfigManager.a(this.this$0).a(localDynamicTextFontInfo, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager.1
 * JD-Core Version:    0.7.0.1
 */