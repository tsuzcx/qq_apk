package com.google.android.material.transition.platform;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;

public class MaterialContainerTransformSharedElementCallback$ShapeableViewShapeProvider
  implements MaterialContainerTransformSharedElementCallback.ShapeProvider
{
  @Nullable
  public ShapeAppearanceModel a(@NonNull View paramView)
  {
    if ((paramView instanceof Shapeable)) {
      return ((Shapeable)paramView).a();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.ShapeableViewShapeProvider
 * JD-Core Version:    0.7.0.1
 */