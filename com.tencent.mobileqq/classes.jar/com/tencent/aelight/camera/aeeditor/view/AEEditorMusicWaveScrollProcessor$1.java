package com.tencent.aelight.camera.aeeditor.view;

import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

class AEEditorMusicWaveScrollProcessor$1
  implements GestureDetector.OnGestureListener
{
  AEEditorMusicWaveScrollProcessor$1(AEEditorMusicWaveScrollProcessor paramAEEditorMusicWaveScrollProcessor) {}
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) == 0.0F;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    if (AEEditorMusicWaveScrollProcessor.f(this.a) != null) {
      AEEditorMusicWaveScrollProcessor.f(this.a).a();
    }
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent arg1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    synchronized (this.a)
    {
      AEEditorMusicWaveScrollProcessor.a(this.a, AEEditorMusicWaveScrollProcessor.a(this.a) + paramFloat1);
      if (AEEditorMusicWaveScrollProcessor.a(this.a) < AEEditorMusicWaveScrollProcessor.b(this.a))
      {
        ??? = this.a;
        AEEditorMusicWaveScrollProcessor.a(???, AEEditorMusicWaveScrollProcessor.b(???));
      }
      if (AEEditorMusicWaveScrollProcessor.a(this.a) > AEEditorMusicWaveScrollProcessor.c(this.a))
      {
        ??? = this.a;
        AEEditorMusicWaveScrollProcessor.a(???, AEEditorMusicWaveScrollProcessor.c(???));
      }
      paramFloat1 = AEEditorMusicWaveScrollProcessor.a(this.a);
      paramFloat2 = AEEditorMusicWaveScrollProcessor.d(this.a);
      ??? = this.a;
      AEEditorMusicWaveScrollProcessor.b(???, AEEditorMusicWaveScrollProcessor.a(???));
      if (a(paramFloat1 - paramFloat2, 0.0F)) {
        return true;
      }
      if (AEEditorMusicWaveScrollProcessor.e(this.a) != null) {
        AEEditorMusicWaveScrollProcessor.e(this.a).a();
      }
      if (AEEditorMusicWaveScrollProcessor.f(this.a) != null) {
        AEEditorMusicWaveScrollProcessor.f(this.a).a(this.a.g(), this.a.h());
      }
      return true;
    }
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.AEEditorMusicWaveScrollProcessor.1
 * JD-Core Version:    0.7.0.1
 */