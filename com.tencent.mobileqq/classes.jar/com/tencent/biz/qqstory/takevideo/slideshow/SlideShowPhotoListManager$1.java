package com.tencent.biz.qqstory.takevideo.slideshow;

import com.tencent.aelight.camera.struct.editor.MusicDownloadListener;
import com.tencent.qphone.base.util.QLog;

class SlideShowPhotoListManager$1
  extends MusicDownloadListener
{
  SlideShowPhotoListManager$1(SlideShowPhotoListManager paramSlideShowPhotoListManager) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString, boolean paramBoolean) {}
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SlideShowPhotoListManager onFinish key=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" result=");
      localStringBuilder.append(paramBoolean);
      QLog.d("SlideShowPhotoListManager", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager.1
 * JD-Core Version:    0.7.0.1
 */