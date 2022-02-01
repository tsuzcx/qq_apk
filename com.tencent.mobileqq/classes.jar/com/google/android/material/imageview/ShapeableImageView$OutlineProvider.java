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
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  
  ShapeableImageView$OutlineProvider(ShapeableImageView paramShapeableImageView) {}
  
  public void getOutline(View paramView, Outline paramOutline)
  {
    if (ShapeableImageView.a(this.jdField_a_of_type_ComGoogleAndroidMaterialImageviewShapeableImageView) == null) {
      return;
    }
    if (ShapeableImageView.a(this.jdField_a_of_type_ComGoogleAndroidMaterialImageviewShapeableImageView) == null)
    {
      paramView = this.jdField_a_of_type_ComGoogleAndroidMaterialImageviewShapeableImageView;
      ShapeableImageView.a(paramView, new MaterialShapeDrawable(ShapeableImageView.a(paramView)));
    }
    ShapeableImageView.a(this.jdField_a_of_type_ComGoogleAndroidMaterialImageviewShapeableImageView).round(this.jdField_a_of_type_AndroidGraphicsRect);
    ShapeableImageView.a(this.jdField_a_of_type_ComGoogleAndroidMaterialImageviewShapeableImageView).setBounds(this.jdField_a_of_type_AndroidGraphicsRect);
    ShapeableImageView.a(this.jdField_a_of_type_ComGoogleAndroidMaterialImageviewShapeableImageView).getOutline(paramOutline);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.imageview.ShapeableImageView.OutlineProvider
 * JD-Core Version:    0.7.0.1
 */