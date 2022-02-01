package com.google.android.material.imageview;

import android.annotation.TargetApi;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.shape.MaterialShapeDrawable;

@TargetApi(21)
class ShapeableImageView$OutlineProvider
  extends ViewOutlineProvider
{
  private final Rect b = new Rect();
  
  ShapeableImageView$OutlineProvider(ShapeableImageView paramShapeableImageView) {}
  
  public void getOutline(View paramView, Outline paramOutline)
  {
    if (ShapeableImageView.a(this.a) == null) {
      return;
    }
    if (ShapeableImageView.b(this.a) == null)
    {
      paramView = this.a;
      ShapeableImageView.a(paramView, new MaterialShapeDrawable(ShapeableImageView.a(paramView)));
    }
    ShapeableImageView.c(this.a).round(this.b);
    ShapeableImageView.b(this.a).setBounds(this.b);
    ShapeableImageView.b(this.a).getOutline(paramOutline);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.imageview.ShapeableImageView.OutlineProvider
 * JD-Core Version:    0.7.0.1
 */