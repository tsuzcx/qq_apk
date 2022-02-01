package com.tencent.aelight.camera.ae.gif;

import android.text.TextUtils;
import com.tencent.aelight.camera.ae.font.AEFontManager;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager;

class AEGIFStickerListPart$9
  implements Runnable
{
  AEGIFStickerListPart$9(AEGIFStickerListPart paramAEGIFStickerListPart, String paramString) {}
  
  public void run()
  {
    String str = AEEditorResourceManager.a().a(this.a, 1);
    if (TextUtils.isEmpty(str)) {
      return;
    }
    AEFontManager.a().a(this.a, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.AEGIFStickerListPart.9
 * JD-Core Version:    0.7.0.1
 */