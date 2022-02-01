package com.tencent.aelight.camera.aioeditor.shortvideo;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

class QIMPtvTemplateManager$3
  implements Runnable
{
  QIMPtvTemplateManager$3(QIMPtvTemplateManager paramQIMPtvTemplateManager) {}
  
  public void run()
  {
    boolean bool1 = PtvFilterSoLoad.a();
    boolean bool2 = NetworkUtil.isNetSupport(BaseApplication.getContext());
    int j = BaseApplicationImpl.sProcessId;
    int i = 1;
    if (j == 1) {
      i = 0;
    }
    if ((bool1) && (bool2) && (i != 0))
    {
      QIMPtvTemplateManager localQIMPtvTemplateManager = this.this$0;
      localQIMPtvTemplateManager.a(localQIMPtvTemplateManager.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager.3
 * JD-Core Version:    0.7.0.1
 */