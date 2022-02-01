package com.tencent.aelight.camera.aioeditor.takevideo.view.widget;

import android.view.View;
import android.view.View.OnLayoutChangeListener;

class EditControlButtonLayout$1
  implements View.OnLayoutChangeListener
{
  EditControlButtonLayout$1(EditControlButtonLayout paramEditControlButtonLayout) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((paramInt1 == paramInt5) && (paramInt3 == paramInt7) && (paramInt2 == paramInt6) && (paramInt4 == paramInt8)) {
      paramInt1 = 0;
    } else {
      paramInt1 = 1;
    }
    if (paramInt1 != 0) {
      EditControlButtonLayout.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.view.widget.EditControlButtonLayout.1
 * JD-Core Version:    0.7.0.1
 */