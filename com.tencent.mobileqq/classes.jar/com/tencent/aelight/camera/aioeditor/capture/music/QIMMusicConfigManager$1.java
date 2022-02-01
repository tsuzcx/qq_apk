package com.tencent.aelight.camera.aioeditor.capture.music;

import java.util.Iterator;
import java.util.List;

class QIMMusicConfigManager$1
  implements Runnable
{
  QIMMusicConfigManager$1(QIMMusicConfigManager paramQIMMusicConfigManager, int paramInt, boolean paramBoolean, Object paramObject) {}
  
  public void run()
  {
    Iterator localIterator = QIMMusicConfigManager.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((QIMMusicConfigManager.LoadMusicStepListener)localIterator.next()).a(this.a, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.music.QIMMusicConfigManager.1
 * JD-Core Version:    0.7.0.1
 */