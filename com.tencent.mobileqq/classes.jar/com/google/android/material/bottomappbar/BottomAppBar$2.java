package com.google.android.material.bottomappbar;

import androidx.annotation.NonNull;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.shape.MaterialShapeDrawable;

class BottomAppBar$2
  implements TransformationCallback<FloatingActionButton>
{
  BottomAppBar$2(BottomAppBar paramBottomAppBar) {}
  
  public void a(@NonNull FloatingActionButton paramFloatingActionButton)
  {
    MaterialShapeDrawable localMaterialShapeDrawable = BottomAppBar.a(this.a);
    float f;
    if (paramFloatingActionButton.getVisibility() == 0) {
      f = paramFloatingActionButton.getScaleY();
    } else {
      f = 0.0F;
    }
    localMaterialShapeDrawable.p(f);
  }
  
  public void b(@NonNull FloatingActionButton paramFloatingActionButton)
  {
    float f1 = paramFloatingActionButton.getTranslationX();
    if (BottomAppBar.a(this.a).b() != f1)
    {
      BottomAppBar.a(this.a).b(f1);
      BottomAppBar.a(this.a).invalidateSelf();
    }
    float f2 = -paramFloatingActionButton.getTranslationY();
    f1 = 0.0F;
    f2 = Math.max(0.0F, f2);
    if (BottomAppBar.a(this.a).c() != f2)
    {
      BottomAppBar.a(this.a).c(f2);
      BottomAppBar.a(this.a).invalidateSelf();
    }
    MaterialShapeDrawable localMaterialShapeDrawable = BottomAppBar.a(this.a);
    if (paramFloatingActionButton.getVisibility() == 0) {
      f1 = paramFloatingActionButton.getScaleY();
    }
    localMaterialShapeDrawable.p(f1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.bottomappbar.BottomAppBar.2
 * JD-Core Version:    0.7.0.1
 */