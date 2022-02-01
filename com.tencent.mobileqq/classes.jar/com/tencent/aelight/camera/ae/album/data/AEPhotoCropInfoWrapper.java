package com.tencent.aelight.camera.ae.album.data;

import android.graphics.Matrix;
import android.support.annotation.NonNull;
import com.tencent.aelight.camera.aeeditor.module.clip.image.EditorPicInfo;

public class AEPhotoCropInfoWrapper
{
  public Matrix a;
  public EditorPicInfo a;
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AEPhotoCropInfoWrapper{editorPicInfo=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageEditorPicInfo);
    localStringBuilder.append(", matrix=");
    localStringBuilder.append(this.jdField_a_of_type_AndroidGraphicsMatrix);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.data.AEPhotoCropInfoWrapper
 * JD-Core Version:    0.7.0.1
 */