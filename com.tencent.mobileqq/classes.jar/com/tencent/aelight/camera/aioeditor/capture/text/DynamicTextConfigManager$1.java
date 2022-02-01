package com.tencent.aelight.camera.aioeditor.capture.text;

import java.util.ArrayList;
import java.util.Iterator;

class DynamicTextConfigManager$1
  implements Runnable
{
  DynamicTextConfigManager$1(DynamicTextConfigManager paramDynamicTextConfigManager, DynamicTextConfigManager.DynamicTextConfigBean paramDynamicTextConfigBean, DynamicTextConfigManager.IDynamicTextResDownloadCallback paramIDynamicTextResDownloadCallback) {}
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager$DynamicTextConfigBean.fontInfos.iterator();
    while (localIterator.hasNext())
    {
      DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo localDynamicTextFontInfo = (DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo)localIterator.next();
      DynamicTextConfigManager.a(this.this$0).a(localDynamicTextFontInfo, this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager$IDynamicTextResDownloadCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager.1
 * JD-Core Version:    0.7.0.1
 */