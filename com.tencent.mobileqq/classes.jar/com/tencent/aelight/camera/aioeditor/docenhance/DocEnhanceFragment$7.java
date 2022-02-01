package com.tencent.aelight.camera.aioeditor.docenhance;

import android.graphics.Matrix;
import android.widget.ImageView;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.widget.ScaleGestureDetector;
import com.tencent.widget.ScaleGestureDetector.OnScaleGestureListener;

class DocEnhanceFragment$7
  implements ScaleGestureDetector.OnScaleGestureListener
{
  float a;
  float b;
  
  DocEnhanceFragment$7(DocEnhanceFragment paramDocEnhanceFragment) {}
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doScale---scaleFactor=");
    localStringBuilder.append(paramFloat1);
    localStringBuilder.append(", focusX=");
    localStringBuilder.append(paramFloat2);
    localStringBuilder.append(", focusY=");
    localStringBuilder.append(paramFloat3);
    AEQLog.a("DocEnhanceFragment", localStringBuilder.toString());
    DocEnhanceFragment.d(this.c).postTranslate(paramFloat2 - this.a, paramFloat3 - this.b);
    DocEnhanceFragment.d(this.c).postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
    DocEnhanceFragment.g(this.c);
    DocEnhanceFragment.b(this.c).setImageMatrix(DocEnhanceFragment.d(this.c));
    DocEnhanceFragment.b(this.c).invalidate();
    this.a = paramFloat2;
    this.b = paramFloat3;
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f1 = paramScaleGestureDetector.getScaleFactor();
    DocEnhanceFragment.d(this.c).getValues(DocEnhanceFragment.c(this.c));
    float f2 = DocEnhanceFragment.c(this.c)[0];
    a(Math.min(DocEnhanceFragment.e(this.c) / f2, Math.max(DocEnhanceFragment.f(this.c) / f2, f1)), paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
    return true;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.a = paramScaleGestureDetector.getFocusX();
    this.b = paramScaleGestureDetector.getFocusY();
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.docenhance.DocEnhanceFragment.7
 * JD-Core Version:    0.7.0.1
 */