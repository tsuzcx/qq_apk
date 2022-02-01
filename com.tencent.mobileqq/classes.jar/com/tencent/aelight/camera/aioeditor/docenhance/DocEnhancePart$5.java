package com.tencent.aelight.camera.aioeditor.docenhance;

import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class DocEnhancePart$5
  implements Runnable
{
  DocEnhancePart$5(DocEnhancePart paramDocEnhancePart) {}
  
  public void run()
  {
    DocEnhancePart localDocEnhancePart = this.this$0;
    DocEnhancePart.b(localDocEnhancePart, DocEnhancePart.a(localDocEnhancePart, localDocEnhancePart.a.a()));
    ThreadManager.getUIHandler().post(new DocEnhancePart.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.docenhance.DocEnhancePart.5
 * JD-Core Version:    0.7.0.1
 */