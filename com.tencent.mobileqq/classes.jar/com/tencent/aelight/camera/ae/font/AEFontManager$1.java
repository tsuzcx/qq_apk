package com.tencent.aelight.camera.ae.font;

import com.tencent.aelight.camera.aeeditor.data.AEEditorDownloadResBean;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

class AEFontManager$1
  implements Runnable
{
  AEFontManager$1(AEFontManager paramAEFontManager) {}
  
  public void run()
  {
    AEQLog.b("AEFontManager", "[preDownloadAndRegisterGifFonts] run");
    Iterator localIterator = AEEditorResourceManager.a().a().values().iterator();
    while (localIterator.hasNext())
    {
      AEEditorDownloadResBean localAEEditorDownloadResBean = (AEEditorDownloadResBean)localIterator.next();
      if (AEEditorResourceManager.a().a(localAEEditorDownloadResBean)) {
        AEFontManager.a(this.this$0, localAEEditorDownloadResBean);
      } else if (localAEEditorDownloadResBean.getPreDownload() == 1) {
        AEEditorResourceManager.a().a(localAEEditorDownloadResBean, new AEFontManager.1.1(this, localAEEditorDownloadResBean));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.font.AEFontManager.1
 * JD-Core Version:    0.7.0.1
 */