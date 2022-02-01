package com.tencent.aelight.camera.aioeditor.capture.view;

import com.tencent.aelight.camera.struct.editor.MusicDownloadListener;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.util.WeakReferenceHandler;

class TransitionProviderView$1
  extends MusicDownloadListener
{
  TransitionProviderView$1(TransitionProviderView paramTransitionProviderView) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString, boolean paramBoolean) {}
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if ((paramBoolean) && (this.a.d != null) && (this.a.d.getLocalPath().equals(paramString))) {
      this.a.e.sendEmptyMessage(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.TransitionProviderView.1
 * JD-Core Version:    0.7.0.1
 */