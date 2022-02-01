package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

class MotionLayout$DevModeDraw
{
  private static final int DEBUG_PATH_TICKS_PER_MS = 16;
  final int DIAMOND_SIZE = 10;
  final int GRAPH_COLOR = -13391360;
  final int KEYFRAME_COLOR = -2067046;
  final int RED_COLOR = -21965;
  final int SHADOW_COLOR = 1996488704;
  Rect mBounds = new Rect();
  DashPathEffect mDashPathEffect;
  Paint mFillPaint;
  int mKeyFrameCount;
  float[] mKeyFramePoints;
  Paint mPaint = new Paint();
  Paint mPaintGraph;
  Paint mPaintKeyframes;
  Path mPath;
  int[] mPathMode;
  float[] mPoints;
  boolean mPresentationMode = false;
  private float[] mRectangle;
  int mShadowTranslate = 1;
  Paint mTextPaint;
  
  public MotionLayout$DevModeDraw(MotionLayout paramMotionLayout)
  {
    this.mPaint.setAntiAlias(true);
    this.mPaint.setColor(-21965);
    this.mPaint.setStrokeWidth(2.0F);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaintKeyframes = new Paint();
    this.mPaintKeyframes.setAntiAlias(true);
    this.mPaintKeyframes.setColor(-2067046);
    this.mPaintKeyframes.setStrokeWidth(2.0F);
    this.mPaintKeyframes.setStyle(Paint.Style.STROKE);
    this.mPaintGraph = new Paint();
    this.mPaintGraph.setAntiAlias(true);
    this.mPaintGraph.setColor(-13391360);
    this.mPaintGraph.setStrokeWidth(2.0F);
    this.mPaintGraph.setStyle(Paint.Style.STROKE);
    this.mTextPaint = new Paint();
    this.mTextPaint.setAntiAlias(true);
    this.mTextPaint.setColor(-13391360);
    this.mTextPaint.setTextSize(paramMotionLayout.getContext().getResources().getDisplayMetrics().density * 12.0F);
    this.mRectangle = new float[8];
    this.mFillPaint = new Paint();
    this.mFillPaint.setAntiAlias(true);
    this.mDashPathEffect = new DashPathEffect(new float[] { 4.0F, 8.0F }, 0.0F);
    this.mPaintGraph.setPathEffect(this.mDashPathEffect);
    this.mKeyFramePoints = new float[100];
    this.mPathMode = new int[50];
    if (this.mPresentationMode)
    {
      this.mPaint.setStrokeWidth(8.0F);
      this.mFillPaint.setStrokeWidth(8.0F);
      this.mPaintKeyframes.setStrokeWidth(8.0F);
      this.mShadowTranslate = 4;
    }
  }
  
  private void drawBasicPath(Canvas paramCanvas)
  {
    paramCanvas.drawLines(this.mPoints, this.mPaint);
  }
  
  private void drawPathAsConfigured(Canvas paramCanvas)
  {
    int i = 0;
    int k = 0;
    int j = 0;
    while (i < this.mKeyFrameCount)
    {
      if (this.mPathMode[i] == 1) {
        k = 1;
      }
      if (this.mPathMode[i] == 2) {
        j = 1;
      }
      i += 1;
    }
    if (k != 0) {
      drawPathRelative(paramCanvas);
    }
    if (j != 0) {
      drawPathCartesian(paramCanvas);
    }
  }
  
  private void drawPathCartesian(Canvas paramCanvas)
  {
    float[] arrayOfFloat = this.mPoints;
    float f1 = arrayOfFloat[0];
    float f2 = arrayOfFloat[1];
    float f3 = arrayOfFloat[(arrayOfFloat.length - 2)];
    float f4 = arrayOfFloat[(arrayOfFloat.length - 1)];
    paramCanvas.drawLine(Math.min(f1, f3), Math.max(f2, f4), Math.max(f1, f3), Math.max(f2, f4), this.mPaintGraph);
    paramCanvas.drawLine(Math.min(f1, f3), Math.min(f2, f4), Math.min(f1, f3), Math.max(f2, f4), this.mPaintGraph);
  }
  
  private void drawPathCartesianTicks(Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    Object localObject = this.mPoints;
    float f1 = localObject[0];
    float f2 = localObject[1];
    float f3 = localObject[(localObject.length - 2)];
    float f4 = localObject[(localObject.length - 1)];
    float f5 = Math.min(f1, f3);
    float f6 = Math.max(f2, f4);
    float f7 = paramFloat1 - Math.min(f1, f3);
    float f8 = Math.max(f2, f4) - paramFloat2;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    double d = f7 * 100.0F / Math.abs(f3 - f1);
    Double.isNaN(d);
    ((StringBuilder)localObject).append((int)(d + 0.5D) / 100.0F);
    localObject = ((StringBuilder)localObject).toString();
    getTextBounds((String)localObject, this.mTextPaint);
    paramCanvas.drawText((String)localObject, f7 / 2.0F - this.mBounds.width() / 2 + f5, paramFloat2 - 20.0F, this.mTextPaint);
    paramCanvas.drawLine(paramFloat1, paramFloat2, Math.min(f1, f3), paramFloat2, this.mPaintGraph);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    d = f8 * 100.0F / Math.abs(f4 - f2);
    Double.isNaN(d);
    ((StringBuilder)localObject).append((int)(d + 0.5D) / 100.0F);
    localObject = ((StringBuilder)localObject).toString();
    getTextBounds((String)localObject, this.mTextPaint);
    paramCanvas.drawText((String)localObject, paramFloat1 + 5.0F, f6 - (f8 / 2.0F - this.mBounds.height() / 2), this.mTextPaint);
    paramCanvas.drawLine(paramFloat1, paramFloat2, paramFloat1, Math.max(f2, f4), this.mPaintGraph);
  }
  
  private void drawPathRelative(Canvas paramCanvas)
  {
    float[] arrayOfFloat = this.mPoints;
    paramCanvas.drawLine(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[(arrayOfFloat.length - 2)], arrayOfFloat[(arrayOfFloat.length - 1)], this.mPaintGraph);
  }
  
  private void drawPathRelativeTicks(Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    Object localObject1 = this.mPoints;
    float f3 = localObject1[0];
    float f2 = localObject1[1];
    float f4 = localObject1[(localObject1.length - 2)];
    float f5 = localObject1[(localObject1.length - 1)];
    float f1 = (float)Math.hypot(f3 - f4, f2 - f5);
    f4 -= f3;
    f5 -= f2;
    float f6 = ((paramFloat1 - f3) * f4 + (paramFloat2 - f2) * f5) / (f1 * f1);
    f3 += f4 * f6;
    f2 += f6 * f5;
    localObject1 = new Path();
    ((Path)localObject1).moveTo(paramFloat1, paramFloat2);
    ((Path)localObject1).lineTo(f3, f2);
    f4 = (float)Math.hypot(f3 - paramFloat1, f2 - paramFloat2);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append((int)(f4 * 100.0F / f1) / 100.0F);
    localObject2 = ((StringBuilder)localObject2).toString();
    getTextBounds((String)localObject2, this.mTextPaint);
    paramCanvas.drawTextOnPath((String)localObject2, (Path)localObject1, f4 / 2.0F - this.mBounds.width() / 2, -20.0F, this.mTextPaint);
    paramCanvas.drawLine(paramFloat1, paramFloat2, f3, f2, this.mPaintGraph);
  }
  
  private void drawPathScreenTicks(Canvas paramCanvas, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    double d = (paramFloat1 - paramInt1 / 2) * 100.0F / (this.this$0.getWidth() - paramInt1);
    Double.isNaN(d);
    ((StringBuilder)localObject).append((int)(d + 0.5D) / 100.0F);
    localObject = ((StringBuilder)localObject).toString();
    getTextBounds((String)localObject, this.mTextPaint);
    paramCanvas.drawText((String)localObject, paramFloat1 / 2.0F - this.mBounds.width() / 2 + 0.0F, paramFloat2 - 20.0F, this.mTextPaint);
    paramCanvas.drawLine(paramFloat1, paramFloat2, Math.min(0.0F, 1.0F), paramFloat2, this.mPaintGraph);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    d = (paramFloat2 - paramInt2 / 2) * 100.0F / (this.this$0.getHeight() - paramInt2);
    Double.isNaN(d);
    ((StringBuilder)localObject).append((int)(d + 0.5D) / 100.0F);
    localObject = ((StringBuilder)localObject).toString();
    getTextBounds((String)localObject, this.mTextPaint);
    paramCanvas.drawText((String)localObject, paramFloat1 + 5.0F, 0.0F - (paramFloat2 / 2.0F - this.mBounds.height() / 2), this.mTextPaint);
    paramCanvas.drawLine(paramFloat1, paramFloat2, paramFloat1, Math.max(0.0F, 1.0F), this.mPaintGraph);
  }
  
  private void drawRectangle(Canvas paramCanvas, MotionController paramMotionController)
  {
    this.mPath.reset();
    int i = 0;
    while (i <= 50)
    {
      paramMotionController.buildRect(i / 50, this.mRectangle, 0);
      Path localPath = this.mPath;
      float[] arrayOfFloat = this.mRectangle;
      localPath.moveTo(arrayOfFloat[0], arrayOfFloat[1]);
      localPath = this.mPath;
      arrayOfFloat = this.mRectangle;
      localPath.lineTo(arrayOfFloat[2], arrayOfFloat[3]);
      localPath = this.mPath;
      arrayOfFloat = this.mRectangle;
      localPath.lineTo(arrayOfFloat[4], arrayOfFloat[5]);
      localPath = this.mPath;
      arrayOfFloat = this.mRectangle;
      localPath.lineTo(arrayOfFloat[6], arrayOfFloat[7]);
      this.mPath.close();
      i += 1;
    }
    this.mPaint.setColor(1140850688);
    paramCanvas.translate(2.0F, 2.0F);
    paramCanvas.drawPath(this.mPath, this.mPaint);
    paramCanvas.translate(-2.0F, -2.0F);
    this.mPaint.setColor(-65536);
    paramCanvas.drawPath(this.mPath, this.mPaint);
  }
  
  private void drawTicks(Canvas paramCanvas, int paramInt1, int paramInt2, MotionController paramMotionController)
  {
    int i;
    int j;
    if (paramMotionController.mView != null)
    {
      i = paramMotionController.mView.getWidth();
      j = paramMotionController.mView.getHeight();
    }
    else
    {
      i = 0;
      j = 0;
    }
    int k = 1;
    while (k < paramInt2 - 1)
    {
      if ((paramInt1 != 4) || (this.mPathMode[(k - 1)] != 0))
      {
        Object localObject = this.mKeyFramePoints;
        int m = k * 2;
        float f2 = localObject[m];
        float f1 = localObject[(m + 1)];
        this.mPath.reset();
        this.mPath.moveTo(f2, f1 + 10.0F);
        this.mPath.lineTo(f2 + 10.0F, f1);
        this.mPath.lineTo(f2, f1 - 10.0F);
        this.mPath.lineTo(f2 - 10.0F, f1);
        this.mPath.close();
        m = k - 1;
        paramMotionController.getKeyFrame(m);
        if (paramInt1 == 4)
        {
          localObject = this.mPathMode;
          if (localObject[m] == 1) {
            drawPathRelativeTicks(paramCanvas, f2 - 0.0F, f1 - 0.0F);
          }
          for (;;)
          {
            break;
            if (localObject[m] == 2) {
              drawPathCartesianTicks(paramCanvas, f2 - 0.0F, f1 - 0.0F);
            } else if (localObject[m] == 3) {
              drawPathScreenTicks(paramCanvas, f2 - 0.0F, f1 - 0.0F, i, j);
            }
          }
          paramCanvas.drawPath(this.mPath, this.mFillPaint);
        }
        if (paramInt1 == 2) {
          drawPathRelativeTicks(paramCanvas, f2 - 0.0F, f1 - 0.0F);
        }
        if (paramInt1 == 3) {
          drawPathCartesianTicks(paramCanvas, f2 - 0.0F, f1 - 0.0F);
        }
        if (paramInt1 == 6) {
          drawPathScreenTicks(paramCanvas, f2 - 0.0F, f1 - 0.0F, i, j);
        }
        paramCanvas.drawPath(this.mPath, this.mFillPaint);
      }
      k += 1;
    }
    paramMotionController = this.mPoints;
    if (paramMotionController.length > 1)
    {
      paramCanvas.drawCircle(paramMotionController[0], paramMotionController[1], 8.0F, this.mPaintKeyframes);
      paramMotionController = this.mPoints;
      paramCanvas.drawCircle(paramMotionController[(paramMotionController.length - 2)], paramMotionController[(paramMotionController.length - 1)], 8.0F, this.mPaintKeyframes);
    }
  }
  
  private void drawTranslation(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramCanvas.drawRect(paramFloat1, paramFloat2, paramFloat3, paramFloat4, this.mPaintGraph);
    paramCanvas.drawLine(paramFloat1, paramFloat2, paramFloat3, paramFloat4, this.mPaintGraph);
  }
  
  public void draw(Canvas paramCanvas, HashMap<View, MotionController> paramHashMap, int paramInt1, int paramInt2)
  {
    if (paramHashMap != null)
    {
      if (paramHashMap.size() == 0) {
        return;
      }
      paramCanvas.save();
      Object localObject;
      if ((!this.this$0.isInEditMode()) && ((paramInt2 & 0x1) == 2))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.this$0.getContext().getResources().getResourceName(MotionLayout.access$000(this.this$0)));
        ((StringBuilder)localObject).append(":");
        ((StringBuilder)localObject).append(this.this$0.getProgress());
        localObject = ((StringBuilder)localObject).toString();
        paramCanvas.drawText((String)localObject, 10.0F, this.this$0.getHeight() - 30, this.mTextPaint);
        paramCanvas.drawText((String)localObject, 11.0F, this.this$0.getHeight() - 29, this.mPaint);
      }
      paramHashMap = paramHashMap.values().iterator();
      while (paramHashMap.hasNext())
      {
        localObject = (MotionController)paramHashMap.next();
        int j = ((MotionController)localObject).getDrawPath();
        int i = j;
        if (paramInt2 > 0)
        {
          i = j;
          if (j == 0) {
            i = 1;
          }
        }
        if (i != 0)
        {
          this.mKeyFrameCount = ((MotionController)localObject).buildKeyFrames(this.mKeyFramePoints, this.mPathMode);
          if (i >= 1)
          {
            j = paramInt1 / 16;
            float[] arrayOfFloat = this.mPoints;
            if ((arrayOfFloat == null) || (arrayOfFloat.length != j * 2))
            {
              this.mPoints = new float[j * 2];
              this.mPath = new Path();
            }
            int k = this.mShadowTranslate;
            paramCanvas.translate(k, k);
            this.mPaint.setColor(1996488704);
            this.mFillPaint.setColor(1996488704);
            this.mPaintKeyframes.setColor(1996488704);
            this.mPaintGraph.setColor(1996488704);
            ((MotionController)localObject).buildPath(this.mPoints, j);
            drawAll(paramCanvas, i, this.mKeyFrameCount, (MotionController)localObject);
            this.mPaint.setColor(-21965);
            this.mPaintKeyframes.setColor(-2067046);
            this.mFillPaint.setColor(-2067046);
            this.mPaintGraph.setColor(-13391360);
            j = this.mShadowTranslate;
            paramCanvas.translate(-j, -j);
            drawAll(paramCanvas, i, this.mKeyFrameCount, (MotionController)localObject);
            if (i == 5) {
              drawRectangle(paramCanvas, (MotionController)localObject);
            }
          }
        }
      }
      paramCanvas.restore();
    }
  }
  
  public void drawAll(Canvas paramCanvas, int paramInt1, int paramInt2, MotionController paramMotionController)
  {
    if (paramInt1 == 4) {
      drawPathAsConfigured(paramCanvas);
    }
    if (paramInt1 == 2) {
      drawPathRelative(paramCanvas);
    }
    if (paramInt1 == 3) {
      drawPathCartesian(paramCanvas);
    }
    drawBasicPath(paramCanvas);
    drawTicks(paramCanvas, paramInt1, paramInt2, paramMotionController);
  }
  
  void getTextBounds(String paramString, Paint paramPaint)
  {
    paramPaint.getTextBounds(paramString, 0, paramString.length(), this.mBounds);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.MotionLayout.DevModeDraw
 * JD-Core Version:    0.7.0.1
 */