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
  public PointF A;
  public float B = 1.0F;
  public float C = 0.0F;
  public float D = 0.0F;
  public float E = 0.0F;
  public Matrix F = new Matrix();
  public float G;
  public float H;
  public boolean I = true;
  public boolean J = false;
  public float K = 1.0F;
  public ValueAnimator L = null;
  public boolean M;
  public int N = 0;
  public int O = -1;
  public int[] P;
  public int Q = -1;
  public int R = -1;
  public boolean S = false;
  public boolean T = false;
  public SegmentKeeper U = new SegmentKeeper();
  public boolean V = false;
  private float[] a = new float[9];
  
  public GestureHelper$ZoomItem() {}
  
  public GestureHelper$ZoomItem(@NonNull PointF paramPointF, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean)
  {
    this.A = new PointF(paramPointF.x, paramPointF.y);
    this.B = paramFloat1;
    this.C = paramFloat2;
    this.D = paramFloat3;
    this.E = paramFloat4;
    this.G = paramFloat5;
    this.H = paramFloat6;
    this.I = paramBoolean;
    this.V = Build.MODEL.equals("MI 5C");
  }
  
  public GestureHelper$ZoomItem(ZoomItem paramZoomItem, float paramFloat)
  {
    this.A = new PointF(paramZoomItem.A.x * paramFloat, paramZoomItem.A.y * paramFloat);
    paramZoomItem.B *= paramFloat;
    this.C = paramZoomItem.C;
    paramZoomItem.D *= paramFloat;
    paramZoomItem.E *= paramFloat;
    this.G = paramZoomItem.G;
    this.H = paramZoomItem.H;
    this.I = paramZoomItem.I;
    this.U.set(paramZoomItem.U);
  }
  
  public void a(Canvas paramCanvas) {}
  
  public float d()
  {
    this.F.getValues(this.a);
    return this.a[0];
  }
  
  public boolean e()
  {
    return this.U.isEmpty() ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.GestureHelper.ZoomItem
 * JD-Core Version:    0.7.0.1
 */