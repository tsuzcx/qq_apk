package com.google.android.material.animation;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;
import androidx.annotation.NonNull;

public class ImageMatrixProperty
  extends Property<ImageView, Matrix>
{
  private final Matrix a = new Matrix();
  
  public ImageMatrixProperty()
  {
    super(Matrix.class, "imageMatrixProperty");
  }
  
  @NonNull
  public Matrix a(@NonNull ImageView paramImageView)
  {
    this.a.set(paramImageView.getImageMatrix());
    return this.a;
  }
  
  public void a(@NonNull ImageView paramImageView, @NonNull Matrix paramMatrix)
  {
    paramImageView.setImageMatrix(paramMatrix);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.animation.ImageMatrixProperty
 * JD-Core Version:    0.7.0.1
 */