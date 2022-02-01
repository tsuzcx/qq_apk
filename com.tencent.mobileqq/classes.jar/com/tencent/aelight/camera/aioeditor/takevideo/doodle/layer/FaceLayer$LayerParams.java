package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer;

import android.graphics.PointF;
import android.support.annotation.NonNull;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.GestureHelper.ZoomItem;

public class FaceLayer$LayerParams
{
  public float a;
  public final int a;
  public final PointF a;
  public final String a;
  public final float b;
  public final int b;
  public final float c;
  public final int c;
  public final float d;
  public final int d;
  
  public FaceLayer$LayerParams(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsPointF = new PointF(paramFloat1, paramFloat2);
    this.jdField_a_of_type_Float = paramFloat3;
    this.jdField_b_of_type_Float = paramFloat4;
    this.jdField_c_of_type_Float = paramFloat5;
    this.jdField_d_of_type_Float = paramFloat6;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = 0;
  }
  
  public FaceLayer$LayerParams(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidGraphicsPointF = new PointF(paramFloat1, paramFloat2);
    this.jdField_a_of_type_Float = paramFloat3;
    this.jdField_b_of_type_Float = paramFloat4;
    this.jdField_c_of_type_Float = paramFloat5;
    this.jdField_d_of_type_Float = paramFloat6;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_d_of_type_Int = paramInt4;
  }
  
  public static LayerParams a(@NonNull LayerParams paramLayerParams)
  {
    return new LayerParams(paramLayerParams.jdField_a_of_type_AndroidGraphicsPointF.x, paramLayerParams.jdField_a_of_type_AndroidGraphicsPointF.y, paramLayerParams.jdField_a_of_type_Float, paramLayerParams.jdField_b_of_type_Float, paramLayerParams.jdField_c_of_type_Float, paramLayerParams.jdField_d_of_type_Float, paramLayerParams.jdField_a_of_type_Int, paramLayerParams.jdField_b_of_type_Int, paramLayerParams.jdField_a_of_type_JavaLangString, paramLayerParams.jdField_c_of_type_Int, paramLayerParams.jdField_d_of_type_Int);
  }
  
  public static LayerParams a(@NonNull GestureHelper.ZoomItem paramZoomItem, @NonNull LayerParams paramLayerParams)
  {
    return new LayerParams(paramZoomItem.jdField_a_of_type_AndroidGraphicsPointF.x, paramZoomItem.jdField_a_of_type_AndroidGraphicsPointF.y, paramLayerParams.jdField_a_of_type_Float, paramZoomItem.k, paramZoomItem.l, paramZoomItem.m, paramLayerParams.jdField_a_of_type_Int, paramLayerParams.jdField_b_of_type_Int, paramLayerParams.jdField_a_of_type_JavaLangString, paramLayerParams.jdField_c_of_type_Int, paramLayerParams.jdField_d_of_type_Int);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LayerParams{centerP=");
    localStringBuilder.append(this.jdField_a_of_type_AndroidGraphicsPointF);
    localStringBuilder.append(", scale=");
    localStringBuilder.append(this.jdField_a_of_type_Float);
    localStringBuilder.append(", rotate=");
    localStringBuilder.append(this.jdField_b_of_type_Float);
    localStringBuilder.append(", translateXValue=");
    localStringBuilder.append(this.jdField_c_of_type_Float);
    localStringBuilder.append(", translateYValue=");
    localStringBuilder.append(this.jdField_d_of_type_Float);
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", text='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", textColor=");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(", textSize=");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer.LayerParams
 * JD-Core Version:    0.7.0.1
 */