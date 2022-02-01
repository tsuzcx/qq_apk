package com.tencent.aelight.camera.aeeditor.module.edit;

import com.microrapid.opencv.ImageMainColorData;
import java.util.Comparator;

class AEEditorImageEditFragment$14
  implements Comparator<ImageMainColorData>
{
  AEEditorImageEditFragment$14(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public int a(ImageMainColorData paramImageMainColorData1, ImageMainColorData paramImageMainColorData2)
  {
    if (paramImageMainColorData1.area > paramImageMainColorData2.area) {
      return -1;
    }
    if (paramImageMainColorData1.area < paramImageMainColorData2.area) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImageEditFragment.14
 * JD-Core Version:    0.7.0.1
 */