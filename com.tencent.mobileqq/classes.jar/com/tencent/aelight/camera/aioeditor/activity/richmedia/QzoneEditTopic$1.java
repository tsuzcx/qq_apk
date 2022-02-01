package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import com.tencent.aelight.camera.struct.editor.MusicDownloadListener;
import com.tencent.qphone.base.util.QLog;

class QzoneEditTopic$1
  extends MusicDownloadListener
{
  QzoneEditTopic$1(QzoneEditTopic paramQzoneEditTopic) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString, boolean paramBoolean) {}
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      QzoneEditTopic.a(this.a, true);
      QzoneEditTopic.a(this.a);
      return;
    }
    paramString = new StringBuilder();
    paramString.append("download music fail");
    paramString.append(paramInt);
    QLog.i("EditPicQzComment", 2, paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneEditTopic.1
 * JD-Core Version:    0.7.0.1
 */