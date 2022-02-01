package com.tencent.aelight.camera.aioeditor.capture.paster;

import com.tencent.aelight.camera.aioeditor.shortvideo.PtvTemplateManager.IPtvTemplateDownloadListener;
import com.tencent.aelight.camera.struct.editor.PtvTemplateInfo;

class CaptureComboPtvTemplate$1
  implements PtvTemplateManager.IPtvTemplateDownloadListener
{
  CaptureComboPtvTemplate$1(CaptureComboPtvTemplate paramCaptureComboPtvTemplate) {}
  
  public void a(PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    synchronized (CaptureComboPtvTemplate.a(this.a))
    {
      if (paramPtvTemplateInfo.a.equals(CaptureComboPtvTemplate.a(this.a).a))
      {
        CaptureComboPtvTemplate.a(this.a).h = true;
        CaptureComboPtvTemplate.a(this.a, paramInt * 1.0F / 100.0F);
        CaptureComboPtvTemplate.a(this.a, 1);
      }
      return;
    }
  }
  
  public void a(PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean)
  {
    synchronized (CaptureComboPtvTemplate.a(this.a))
    {
      if (paramPtvTemplateInfo.a.equals(CaptureComboPtvTemplate.a(this.a).a))
      {
        CaptureComboPtvTemplate.a(this.a).h = false;
        CaptureComboPtvTemplate.a(this.a).g = paramBoolean;
      }
      if (paramBoolean)
      {
        if (CaptureComboPtvTemplate.a(this.a).a.equals(paramPtvTemplateInfo.a))
        {
          CaptureComboPtvTemplate.a(this.a, 3);
          CaptureComboPtvTemplate.a(this.a, 1.0F);
          this.a.b();
        }
      }
      else
      {
        this.a.a(4);
        CaptureComboPtvTemplate.a(this.a, 2);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.paster.CaptureComboPtvTemplate.1
 * JD-Core Version:    0.7.0.1
 */