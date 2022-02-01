package com.tencent.aelight.camera.aioeditor.capture.music;

import com.tencent.aelight.camera.struct.editor.MusicDownloadListener;
import com.tencent.qphone.base.util.QLog;

class CaptureComboMusic$1
  extends MusicDownloadListener
{
  CaptureComboMusic$1(CaptureComboMusic paramCaptureComboMusic) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString) {}
  
  public void a(String arg1, int paramInt)
  {
    synchronized (this.a)
    {
      this.a.f.mProgress = paramInt;
      return;
    }
  }
  
  public void a(String paramString, boolean paramBoolean) {}
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyDownloadFinish key: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", success ");
      localStringBuilder.append(paramBoolean);
      QLog.i("QQMusicDownloadListener", 2, localStringBuilder.toString());
    }
    paramString = this.a;
    if (paramBoolean) {}
    try
    {
      this.a.f.mProgress = 100;
      this.a.b();
      break label108;
      this.a.f.mProgress = -1;
      this.a.a(4);
      label108:
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.music.CaptureComboMusic.1
 * JD-Core Version:    0.7.0.1
 */