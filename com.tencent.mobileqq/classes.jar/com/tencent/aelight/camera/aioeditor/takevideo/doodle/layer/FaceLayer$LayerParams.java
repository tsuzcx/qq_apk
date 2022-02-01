package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer;

import android.graphics.PointF;
import android.support.annotation.NonNull;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.GestureHelper.ZoomItem;

public class FaceLayer$LayerParams
{
  public final PointF a;
  public float b;
  public final float c;
  public final float d;
  public final float e;
  public final int f;
  public final int g;
  public final String h;
  public final int i;
  public final int j;
  
  public FaceLayer$LayerParams(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, int paramInt1, int paramInt2)
  {
    this.a = new PointF(paramFloat1, paramFloat2);
    this.b = paramFloat3;
    this.c = paramFloat4;
    this.d = paramFloat5;
    this.e = paramFloat6;
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = "";
    this.i = -1;
    this.j = 0;
  }
  
  public FaceLayer$LayerParams(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4)
  {
    this.a = new PointF(paramFloat1, paramFloat2);
    this.b = paramFloat3;
    this.c = paramFloat4;
    this.d = paramFloat5;
    this.e = paramFloat6;
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = paramString;
    this.i = paramInt3;
    this.j = paramInt4;
  }
  
  public static LayerParams a(@NonNull LayerParams paramLayerParams)
  {
    return new LayerParams(paramLayerParams.a.x, paramLayerParams.a.y, paramLayerParams.b, paramLayerParams.c, paramLayerParams.d, paramLayerParams.e, paramLayerParams.f, paramLayerParams.g, paramLayerParams.h, paramLayerParams.i, paramLayerParams.j);
  }
  
  public static LayerParams a(@NonNull GestureHelper.ZoomItem paramZoomItem, @NonNull LayerParams paramLayerParams)
  {
    return new LayerParams(paramZoomItem.A.x, paramZoomItem.A.y, paramLayerParams.b, paramZoomItem.C, paramZoomItem.D, paramZoomItem.E, paramLayerParams.f, paramLayerParams.g, paramLayerParams.h, paramLayerParams.i, paramLayerParams.j);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LayerParams{centerP=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", scale=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", rotate=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", translateXValue=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", translateYValue=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", text='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", textColor=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", textSize=");
    localStringBuilder.append(this.j);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer.LayerParams
 * JD-Core Version:    0.7.0.1
 */