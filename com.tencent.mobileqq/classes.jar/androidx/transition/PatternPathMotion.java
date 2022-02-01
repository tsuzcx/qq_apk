package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import org.xmlpull.v1.XmlPullParser;

public class PatternPathMotion
  extends PathMotion
{
  private Path mOriginalPatternPath;
  private final Path mPatternPath = new Path();
  private final Matrix mTempMatrix = new Matrix();
  
  public PatternPathMotion()
  {
    this.mPatternPath.lineTo(1.0F, 0.0F);
    this.mOriginalPatternPath = this.mPatternPath;
  }
  
  @SuppressLint({"RestrictedApi"})
  public PatternPathMotion(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, Styleable.PATTERN_PATH_MOTION);
    try
    {
      paramAttributeSet = TypedArrayUtils.getNamedString(paramContext, (XmlPullParser)paramAttributeSet, "patternPathData", 0);
      if (paramAttributeSet != null)
      {
        setPatternPath(PathParser.createPathFromPathData(paramAttributeSet));
        return;
      }
      throw new RuntimeException("pathData must be supplied for patternPathMotion");
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  public PatternPathMotion(Path paramPath)
  {
    setPatternPath(paramPath);
  }
  
  private static float distance(float paramFloat1, float paramFloat2)
  {
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  public Path getPath(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat3 -= paramFloat1;
    paramFloat4 -= paramFloat2;
    float f = distance(paramFloat3, paramFloat4);
    double d = Math.atan2(paramFloat4, paramFloat3);
    this.mTempMatrix.setScale(f, f);
    this.mTempMatrix.postRotate((float)Math.toDegrees(d));
    this.mTempMatrix.postTranslate(paramFloat1, paramFloat2);
    Path localPath = new Path();
    this.mPatternPath.transform(this.mTempMatrix, localPath);
    return localPath;
  }
  
  public Path getPatternPath()
  {
    return this.mOriginalPatternPath;
  }
  
  public void setPatternPath(Path paramPath)
  {
    PathMeasure localPathMeasure = new PathMeasure(paramPath, false);
    float f1 = localPathMeasure.getLength();
    float[] arrayOfFloat = new float[2];
    localPathMeasure.getPosTan(f1, arrayOfFloat, null);
    float f3 = arrayOfFloat[0];
    f1 = arrayOfFloat[1];
    localPathMeasure.getPosTan(0.0F, arrayOfFloat, null);
    float f4 = arrayOfFloat[0];
    float f2 = arrayOfFloat[1];
    if ((f4 == f3) && (f2 == f1)) {
      throw new IllegalArgumentException("pattern must not end at the starting point");
    }
    this.mTempMatrix.setTranslate(-f4, -f2);
    f3 -= f4;
    f1 -= f2;
    f2 = 1.0F / distance(f3, f1);
    this.mTempMatrix.postScale(f2, f2);
    double d = Math.atan2(f1, f3);
    this.mTempMatrix.postRotate((float)Math.toDegrees(-d));
    paramPath.transform(this.mTempMatrix, this.mPatternPath);
    this.mOriginalPatternPath = paramPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.PatternPathMotion
 * JD-Core Version:    0.7.0.1
 */