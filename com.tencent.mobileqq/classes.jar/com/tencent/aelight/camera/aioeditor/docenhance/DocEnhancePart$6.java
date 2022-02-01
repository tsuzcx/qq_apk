package com.tencent.aelight.camera.aioeditor.docenhance;

import com.tencent.aelight.camera.log.AEQLog;

class DocEnhancePart$6
  implements Runnable
{
  DocEnhancePart$6(DocEnhancePart paramDocEnhancePart, String paramString) {}
  
  public void run()
  {
    DocEnhancePart.d(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AiSubLabel: ");
    localStringBuilder.append(this.a);
    AEQLog.b("DocEnhancePart", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.docenhance.DocEnhancePart.6
 * JD-Core Version:    0.7.0.1
 */