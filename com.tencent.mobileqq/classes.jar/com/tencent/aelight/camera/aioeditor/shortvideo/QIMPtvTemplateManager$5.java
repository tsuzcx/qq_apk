package com.tencent.aelight.camera.aioeditor.shortvideo;

import com.tencent.aelight.camera.aioeditor.capture.music.CaptureConfigUpdateObserver;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;

class QIMPtvTemplateManager$5
  implements Runnable
{
  QIMPtvTemplateManager$5(QIMPtvTemplateManager paramQIMPtvTemplateManager, File paramFile) {}
  
  public void run()
  {
    List localList = this.this$0.a(this.a);
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, String.format("rebuildTemplateInfos, templateInfos[%s]", new Object[] { localList }));
    }
    if (localList != null) {
      synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
      {
        this.this$0.jdField_a_of_type_JavaUtilList.clear();
        this.this$0.jdField_a_of_type_JavaUtilList.addAll(localList);
        if (this.this$0.a() != null) {
          this.this$0.a().notifyObservers(CaptureConfigUpdateObserver.class, 3, true, null);
        }
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("QIMPtvTemplateManager", 4, String.format("rebuildTemplateInfos, [%s] finished", new Object[] { Integer.valueOf(hashCode()) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager.5
 * JD-Core Version:    0.7.0.1
 */