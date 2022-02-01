package com.tencent.aelight.camera.aeeditor.module.clip.image;

import android.graphics.Rect;

class AEEditorClipMaskView$3
  implements Runnable
{
  AEEditorClipMaskView$3(AEEditorClipMaskView paramAEEditorClipMaskView, Rect paramRect, float paramFloat) {}
  
  public void run()
  {
    AEEditorClipMaskView localAEEditorClipMaskView = this.this$0;
    AEEditorClipMaskView.a(localAEEditorClipMaskView, AEEditorClipMaskView.e(localAEEditorClipMaskView), this.a);
    int i = AEEditorClipMaskView.f(this.this$0);
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return;
          }
          AEEditorClipMaskView.g(this.this$0).b.a(this.b, this.a.left, this.a.top);
          return;
        }
        AEEditorClipMaskView.g(this.this$0).b.a(this.b, this.a.right, this.a.top);
        return;
      }
      AEEditorClipMaskView.g(this.this$0).b.a(this.b, this.a.left, this.a.bottom);
      return;
    }
    AEEditorClipMaskView.g(this.this$0).b.a(this.b, this.a.right, this.a.bottom);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.clip.image.AEEditorClipMaskView.3
 * JD-Core Version:    0.7.0.1
 */