package com.tencent.aelight.camera.aeeditor.module.edit;

import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.tavcut.view.ext.OnViewDragListener;

class AEEditorImagePagerAdapter$2
  implements OnViewDragListener
{
  AEEditorImagePagerAdapter$2(AEEditorImagePagerAdapter paramAEEditorImagePagerAdapter) {}
  
  public void onDrag(float paramFloat1, float paramFloat2)
  {
    String str = AEEditorImagePagerAdapter.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDrag--- dx = ");
    localStringBuilder.append(paramFloat1);
    localStringBuilder.append(", dy = ");
    localStringBuilder.append(paramFloat2);
    Logger.d(str, localStringBuilder.toString());
    if (AEEditorImagePagerAdapter.a(this.a) != null) {
      AEEditorImagePagerAdapter.a(this.a).a(paramFloat1, paramFloat2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImagePagerAdapter.2
 * JD-Core Version:    0.7.0.1
 */