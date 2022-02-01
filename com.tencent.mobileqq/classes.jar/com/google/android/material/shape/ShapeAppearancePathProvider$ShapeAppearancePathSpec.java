package com.google.android.material.shape;

import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

final class ShapeAppearancePathProvider$ShapeAppearancePathSpec
{
  @NonNull
  public final ShapeAppearanceModel a;
  @NonNull
  public final Path b;
  @NonNull
  public final RectF c;
  @Nullable
  public final ShapeAppearancePathProvider.PathListener d;
  public final float e;
  
  ShapeAppearancePathProvider$ShapeAppearancePathSpec(@NonNull ShapeAppearanceModel paramShapeAppearanceModel, float paramFloat, RectF paramRectF, @Nullable ShapeAppearancePathProvider.PathListener paramPathListener, Path paramPath)
  {
    this.d = paramPathListener;
    this.a = paramShapeAppearanceModel;
    this.e = paramFloat;
    this.c = paramRectF;
    this.b = paramPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.shape.ShapeAppearancePathProvider.ShapeAppearancePathSpec
 * JD-Core Version:    0.7.0.1
 */