package com.tencent.aelight.camera.aioeditor.takevideo.doodle.util;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Build;
import android.support.annotation.NonNull;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.base.DoodleItem;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;

public abstract class GestureHelper$ZoomItem
  implements DoodleItem
{
  public ValueAnimator a;
  public Matrix a;
  public PointF a;
  public SegmentKeeper a;
  private float[] a;
  public int[] a;
  public boolean d = true;
  public boolean e = false;
  public boolean f;
  public boolean g = false;
  public boolean h = false;
  public int i;
  public boolean i;
  public float j;
  public int j;
  public float k;
  public int k;
  public float l;
  public int l;
  public float m = 0.0F;
  public float n;
  public float o;
  public float p = 1.0F;
  
  public GestureHelper$ZoomItem()
  {
    this.jdField_j_of_type_Float = 1.0F;
    this.jdField_k_of_type_Float = 0.0F;
    this.jdField_l_of_type_Float = 0.0F;
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_i_of_type_Int = 0;
    this.jdField_j_of_type_Int = -1;
    this.jdField_k_of_type_Int = -1;
    this.jdField_l_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper = new SegmentKeeper();
    this.jdField_i_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfFloat = new float[9];
  }
  
  public GestureHelper$ZoomItem(@NonNull PointF paramPointF, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean)
  {
    this.jdField_j_of_type_Float = 1.0F;
    this.jdField_k_of_type_Float = 0.0F;
    this.jdField_l_of_type_Float = 0.0F;
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_i_of_type_Int = 0;
    this.jdField_j_of_type_Int = -1;
    this.jdField_k_of_type_Int = -1;
    this.jdField_l_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper = new SegmentKeeper();
    this.jdField_i_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfFloat = new float[9];
    this.jdField_a_of_type_AndroidGraphicsPointF = new PointF(paramPointF.x, paramPointF.y);
    this.jdField_j_of_type_Float = paramFloat1;
    this.jdField_k_of_type_Float = paramFloat2;
    this.jdField_l_of_type_Float = paramFloat3;
    this.m = paramFloat4;
    this.n = paramFloat5;
    this.o = paramFloat6;
    this.d = paramBoolean;
    this.jdField_i_of_type_Boolean = Build.MODEL.equals("MI 5C");
  }
  
  public GestureHelper$ZoomItem(ZoomItem paramZoomItem, float paramFloat)
  {
    this.jdField_j_of_type_Float = 1.0F;
    this.jdField_k_of_type_Float = 0.0F;
    this.jdField_l_of_type_Float = 0.0F;
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_i_of_type_Int = 0;
    this.jdField_j_of_type_Int = -1;
    this.jdField_k_of_type_Int = -1;
    this.jdField_l_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper = new SegmentKeeper();
    this.jdField_i_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfFloat = new float[9];
    this.jdField_a_of_type_AndroidGraphicsPointF = new PointF(paramZoomItem.jdField_a_of_type_AndroidGraphicsPointF.x * paramFloat, paramZoomItem.jdField_a_of_type_AndroidGraphicsPointF.y * paramFloat);
    paramZoomItem.jdField_j_of_type_Float *= paramFloat;
    this.jdField_k_of_type_Float = paramZoomItem.jdField_k_of_type_Float;
    paramZoomItem.jdField_l_of_type_Float *= paramFloat;
    paramZoomItem.m *= paramFloat;
    this.n = paramZoomItem.n;
    this.o = paramZoomItem.o;
    this.d = paramZoomItem.d;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.set(paramZoomItem.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper);
  }
  
  public float a()
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.getValues(this.jdField_a_of_type_ArrayOfFloat);
    return this.jdField_a_of_type_ArrayOfFloat[0];
  }
  
  public void a(Canvas paramCanvas) {}
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isEmpty() ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.GestureHelper.ZoomItem
 * JD-Core Version:    0.7.0.1
 */