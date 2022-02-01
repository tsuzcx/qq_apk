package com.tencent.aelight.camera.ae.album.data;

import android.graphics.Matrix;
import android.support.annotation.NonNull;
import com.tencent.aelight.camera.aeeditor.module.clip.image.EditorPicInfo;

public class AEPhotoCropInfoWrapper
{
  public EditorPicInfo a;
  public Matrix b;
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AEPhotoCropInfoWrapper{editorPicInfo=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", matrix=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.data.AEPhotoCropInfoWrapper
 * JD-Core Version:    0.7.0.1
 */