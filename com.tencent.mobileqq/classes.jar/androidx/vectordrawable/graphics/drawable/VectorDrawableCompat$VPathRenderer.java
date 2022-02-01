package androidx.vectordrawable.graphics.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PathMeasure;
import android.graphics.Shader;
import androidx.collection.ArrayMap;
import androidx.core.content.res.ComplexColorCompat;
import java.util.ArrayList;

class VectorDrawableCompat$VPathRenderer
{
  private static final Matrix IDENTITY_MATRIX = new Matrix();
  float mBaseHeight = 0.0F;
  float mBaseWidth = 0.0F;
  private int mChangingConfigurations;
  Paint mFillPaint;
  private final Matrix mFinalPathMatrix = new Matrix();
  Boolean mIsStateful = null;
  private final Path mPath;
  private PathMeasure mPathMeasure;
  private final Path mRenderPath;
  int mRootAlpha = 255;
  final VectorDrawableCompat.VGroup mRootGroup;
  String mRootName = null;
  Paint mStrokePaint;
  final ArrayMap<String, Object> mVGTargetsMap = new ArrayMap();
  float mViewportHeight = 0.0F;
  float mViewportWidth = 0.0F;
  
  public VectorDrawableCompat$VPathRenderer()
  {
    this.mRootGroup = new VectorDrawableCompat.VGroup();
    this.mPath = new Path();
    this.mRenderPath = new Path();
  }
  
  public VectorDrawableCompat$VPathRenderer(VPathRenderer paramVPathRenderer)
  {
    this.mRootGroup = new VectorDrawableCompat.VGroup(paramVPathRenderer.mRootGroup, this.mVGTargetsMap);
    this.mPath = new Path(paramVPathRenderer.mPath);
    this.mRenderPath = new Path(paramVPathRenderer.mRenderPath);
    this.mBaseWidth = paramVPathRenderer.mBaseWidth;
    this.mBaseHeight = paramVPathRenderer.mBaseHeight;
    this.mViewportWidth = paramVPathRenderer.mViewportWidth;
    this.mViewportHeight = paramVPathRenderer.mViewportHeight;
    this.mChangingConfigurations = paramVPathRenderer.mChangingConfigurations;
    this.mRootAlpha = paramVPathRenderer.mRootAlpha;
    this.mRootName = paramVPathRenderer.mRootName;
    String str = paramVPathRenderer.mRootName;
    if (str != null) {
      this.mVGTargetsMap.put(str, this);
    }
    this.mIsStateful = paramVPathRenderer.mIsStateful;
  }
  
  private static float cross(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return paramFloat1 * paramFloat4 - paramFloat2 * paramFloat3;
  }
  
  private void drawGroupTree(VectorDrawableCompat.VGroup paramVGroup, Matrix paramMatrix, Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
  {
    paramVGroup.mStackedMatrix.set(paramMatrix);
    paramVGroup.mStackedMatrix.preConcat(paramVGroup.mLocalMatrix);
    paramCanvas.save();
    int i = 0;
    while (i < paramVGroup.mChildren.size())
    {
      paramMatrix = (VectorDrawableCompat.VObject)paramVGroup.mChildren.get(i);
      if ((paramMatrix instanceof VectorDrawableCompat.VGroup)) {
        drawGroupTree((VectorDrawableCompat.VGroup)paramMatrix, paramVGroup.mStackedMatrix, paramCanvas, paramInt1, paramInt2, paramColorFilter);
      } else if ((paramMatrix instanceof VectorDrawableCompat.VPath)) {
        drawPath(paramVGroup, (VectorDrawableCompat.VPath)paramMatrix, paramCanvas, paramInt1, paramInt2, paramColorFilter);
      }
      i += 1;
    }
    paramCanvas.restore();
  }
  
  private void drawPath(VectorDrawableCompat.VGroup paramVGroup, VectorDrawableCompat.VPath paramVPath, Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
  {
    float f2 = paramInt1 / this.mViewportWidth;
    float f3 = paramInt2 / this.mViewportHeight;
    float f1 = Math.min(f2, f3);
    paramVGroup = paramVGroup.mStackedMatrix;
    this.mFinalPathMatrix.set(paramVGroup);
    this.mFinalPathMatrix.postScale(f2, f3);
    f2 = getMatrixScale(paramVGroup);
    if (f2 == 0.0F) {
      return;
    }
    paramVPath.toPath(this.mPath);
    Object localObject = this.mPath;
    this.mRenderPath.reset();
    if (paramVPath.isClipPath())
    {
      paramColorFilter = this.mRenderPath;
      if (paramVPath.mFillRule == 0) {
        paramVGroup = Path.FillType.WINDING;
      } else {
        paramVGroup = Path.FillType.EVEN_ODD;
      }
      paramColorFilter.setFillType(paramVGroup);
      this.mRenderPath.addPath((Path)localObject, this.mFinalPathMatrix);
      paramCanvas.clipPath(this.mRenderPath);
      return;
    }
    paramVPath = (VectorDrawableCompat.VFullPath)paramVPath;
    if ((paramVPath.mTrimPathStart != 0.0F) || (paramVPath.mTrimPathEnd != 1.0F))
    {
      float f6 = paramVPath.mTrimPathStart;
      float f7 = paramVPath.mTrimPathOffset;
      float f4 = paramVPath.mTrimPathEnd;
      float f5 = paramVPath.mTrimPathOffset;
      if (this.mPathMeasure == null) {
        this.mPathMeasure = new PathMeasure();
      }
      this.mPathMeasure.setPath(this.mPath, false);
      f3 = this.mPathMeasure.getLength();
      f6 = (f6 + f7) % 1.0F * f3;
      f4 = (f4 + f5) % 1.0F * f3;
      ((Path)localObject).reset();
      if (f6 > f4)
      {
        this.mPathMeasure.getSegment(f6, f3, (Path)localObject, true);
        this.mPathMeasure.getSegment(0.0F, f4, (Path)localObject, true);
      }
      else
      {
        this.mPathMeasure.getSegment(f6, f4, (Path)localObject, true);
      }
      ((Path)localObject).rLineTo(0.0F, 0.0F);
    }
    this.mRenderPath.addPath((Path)localObject, this.mFinalPathMatrix);
    if (paramVPath.mFillColor.willDraw())
    {
      paramVGroup = paramVPath.mFillColor;
      if (this.mFillPaint == null)
      {
        this.mFillPaint = new Paint(1);
        this.mFillPaint.setStyle(Paint.Style.FILL);
      }
      localObject = this.mFillPaint;
      if (paramVGroup.isGradient())
      {
        paramVGroup = paramVGroup.getShader();
        paramVGroup.setLocalMatrix(this.mFinalPathMatrix);
        ((Paint)localObject).setShader(paramVGroup);
        ((Paint)localObject).setAlpha(Math.round(paramVPath.mFillAlpha * 255.0F));
      }
      else
      {
        ((Paint)localObject).setShader(null);
        ((Paint)localObject).setAlpha(255);
        ((Paint)localObject).setColor(VectorDrawableCompat.applyAlpha(paramVGroup.getColor(), paramVPath.mFillAlpha));
      }
      ((Paint)localObject).setColorFilter(paramColorFilter);
      Path localPath = this.mRenderPath;
      if (paramVPath.mFillRule == 0) {
        paramVGroup = Path.FillType.WINDING;
      } else {
        paramVGroup = Path.FillType.EVEN_ODD;
      }
      localPath.setFillType(paramVGroup);
      paramCanvas.drawPath(this.mRenderPath, (Paint)localObject);
    }
    if (paramVPath.mStrokeColor.willDraw())
    {
      localObject = paramVPath.mStrokeColor;
      if (this.mStrokePaint == null)
      {
        this.mStrokePaint = new Paint(1);
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
      }
      paramVGroup = this.mStrokePaint;
      if (paramVPath.mStrokeLineJoin != null) {
        paramVGroup.setStrokeJoin(paramVPath.mStrokeLineJoin);
      }
      if (paramVPath.mStrokeLineCap != null) {
        paramVGroup.setStrokeCap(paramVPath.mStrokeLineCap);
      }
      paramVGroup.setStrokeMiter(paramVPath.mStrokeMiterlimit);
      if (((ComplexColorCompat)localObject).isGradient())
      {
        localObject = ((ComplexColorCompat)localObject).getShader();
        ((Shader)localObject).setLocalMatrix(this.mFinalPathMatrix);
        paramVGroup.setShader((Shader)localObject);
        paramVGroup.setAlpha(Math.round(paramVPath.mStrokeAlpha * 255.0F));
      }
      else
      {
        paramVGroup.setShader(null);
        paramVGroup.setAlpha(255);
        paramVGroup.setColor(VectorDrawableCompat.applyAlpha(((ComplexColorCompat)localObject).getColor(), paramVPath.mStrokeAlpha));
      }
      paramVGroup.setColorFilter(paramColorFilter);
      paramVGroup.setStrokeWidth(paramVPath.mStrokeWidth * (f1 * f2));
      paramCanvas.drawPath(this.mRenderPath, paramVGroup);
    }
  }
  
  private float getMatrixScale(Matrix paramMatrix)
  {
    float[] arrayOfFloat = new float[4];
    float[] tmp7_5 = arrayOfFloat;
    tmp7_5[0] = 0.0F;
    float[] tmp11_7 = tmp7_5;
    tmp11_7[1] = 1.0F;
    float[] tmp15_11 = tmp11_7;
    tmp15_11[2] = 1.0F;
    float[] tmp19_15 = tmp15_11;
    tmp19_15[3] = 0.0F;
    tmp19_15;
    paramMatrix.mapVectors(arrayOfFloat);
    float f1 = (float)Math.hypot(arrayOfFloat[0], arrayOfFloat[1]);
    float f3 = (float)Math.hypot(arrayOfFloat[2], arrayOfFloat[3]);
    float f2 = cross(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3]);
    f3 = Math.max(f1, f3);
    f1 = 0.0F;
    if (f3 > 0.0F) {
      f1 = Math.abs(f2) / f3;
    }
    return f1;
  }
  
  public void draw(Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
  {
    drawGroupTree(this.mRootGroup, IDENTITY_MATRIX, paramCanvas, paramInt1, paramInt2, paramColorFilter);
  }
  
  public float getAlpha()
  {
    return getRootAlpha() / 255.0F;
  }
  
  public int getRootAlpha()
  {
    return this.mRootAlpha;
  }
  
  public boolean isStateful()
  {
    if (this.mIsStateful == null) {
      this.mIsStateful = Boolean.valueOf(this.mRootGroup.isStateful());
    }
    return this.mIsStateful.booleanValue();
  }
  
  public boolean onStateChanged(int[] paramArrayOfInt)
  {
    return this.mRootGroup.onStateChanged(paramArrayOfInt);
  }
  
  public void setAlpha(float paramFloat)
  {
    setRootAlpha((int)(paramFloat * 255.0F));
  }
  
  public void setRootAlpha(int paramInt)
  {
    this.mRootAlpha = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPathRenderer
 * JD-Core Version:    0.7.0.1
 */