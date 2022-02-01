package androidx.constraintlayout.motion.widget;

import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;

public abstract class SplineSet
{
  private static final String TAG = "SplineSet";
  private int count;
  protected CurveFit mCurveFit;
  protected int[] mTimePoints = new int[10];
  private String mType;
  protected float[] mValues = new float[10];
  
  static SplineSet makeCustomSpline(String paramString, SparseArray<ConstraintAttribute> paramSparseArray)
  {
    return new SplineSet.CustomSet(paramString, paramSparseArray);
  }
  
  static SplineSet makeSpline(String paramString)
  {
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 156108012: 
      if (paramString.equals("waveOffset")) {
        i = 10;
      }
      break;
    case 92909918: 
      if (paramString.equals("alpha")) {
        i = 0;
      }
      break;
    case 37232917: 
      if (paramString.equals("transitionPathRotate")) {
        i = 7;
      }
      break;
    case -4379043: 
      if (paramString.equals("elevation")) {
        i = 1;
      }
      break;
    case -40300674: 
      if (paramString.equals("rotation")) {
        i = 2;
      }
      break;
    case -760884509: 
      if (paramString.equals("transformPivotY")) {
        i = 6;
      }
      break;
    case -760884510: 
      if (paramString.equals("transformPivotX")) {
        i = 5;
      }
      break;
    case -797520672: 
      if (paramString.equals("waveVariesBy")) {
        i = 11;
      }
      break;
    case -908189617: 
      if (paramString.equals("scaleY")) {
        i = 9;
      }
      break;
    case -908189618: 
      if (paramString.equals("scaleX")) {
        i = 8;
      }
      break;
    case -1001078227: 
      if (paramString.equals("progress")) {
        i = 15;
      }
      break;
    case -1225497655: 
      if (paramString.equals("translationZ")) {
        i = 14;
      }
      break;
    case -1225497656: 
      if (paramString.equals("translationY")) {
        i = 13;
      }
      break;
    case -1225497657: 
      if (paramString.equals("translationX")) {
        i = 12;
      }
      break;
    case -1249320805: 
      if (paramString.equals("rotationY")) {
        i = 4;
      }
      break;
    case -1249320806: 
      if (paramString.equals("rotationX")) {
        i = 3;
      }
      break;
    }
    int i = -1;
    switch (i)
    {
    default: 
      return null;
    case 15: 
      return new SplineSet.ProgressSet();
    case 14: 
      return new SplineSet.TranslationZset();
    case 13: 
      return new SplineSet.TranslationYset();
    case 12: 
      return new SplineSet.TranslationXset();
    case 11: 
      return new SplineSet.AlphaSet();
    case 10: 
      return new SplineSet.AlphaSet();
    case 9: 
      return new SplineSet.ScaleYset();
    case 8: 
      return new SplineSet.ScaleXset();
    case 7: 
      return new SplineSet.PathRotate();
    case 6: 
      return new SplineSet.PivotYset();
    case 5: 
      return new SplineSet.PivotXset();
    case 4: 
      return new SplineSet.RotationYset();
    case 3: 
      return new SplineSet.RotationXset();
    case 2: 
      return new SplineSet.RotationSet();
    case 1: 
      return new SplineSet.ElevationSet();
    }
    return new SplineSet.AlphaSet();
  }
  
  public float get(float paramFloat)
  {
    return (float)this.mCurveFit.getPos(paramFloat, 0);
  }
  
  public CurveFit getCurveFit()
  {
    return this.mCurveFit;
  }
  
  public float getSlope(float paramFloat)
  {
    return (float)this.mCurveFit.getSlope(paramFloat, 0);
  }
  
  public void setPoint(int paramInt, float paramFloat)
  {
    Object localObject = this.mTimePoints;
    if (localObject.length < this.count + 1)
    {
      this.mTimePoints = Arrays.copyOf((int[])localObject, localObject.length * 2);
      localObject = this.mValues;
      this.mValues = Arrays.copyOf((float[])localObject, localObject.length * 2);
    }
    localObject = this.mTimePoints;
    int i = this.count;
    localObject[i] = paramInt;
    this.mValues[i] = paramFloat;
    this.count = (i + 1);
  }
  
  public abstract void setProperty(View paramView, float paramFloat);
  
  public void setType(String paramString)
  {
    this.mType = paramString;
  }
  
  public void setup(int paramInt)
  {
    int i = this.count;
    if (i == 0) {
      return;
    }
    SplineSet.Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, i - 1);
    i = 1;
    int k;
    for (int j = 1; i < this.count; j = k)
    {
      localObject = this.mTimePoints;
      k = j;
      if (localObject[(i - 1)] != localObject[i]) {
        k = j + 1;
      }
      i += 1;
    }
    Object localObject = new double[j];
    double[][] arrayOfDouble = (double[][])Array.newInstance(Double.TYPE, new int[] { j, 1 });
    i = 0;
    j = 0;
    while (i < this.count)
    {
      if (i > 0)
      {
        int[] arrayOfInt = this.mTimePoints;
        if (arrayOfInt[i] == arrayOfInt[(i - 1)]) {}
      }
      else
      {
        double d = this.mTimePoints[i];
        Double.isNaN(d);
        localObject[j] = (d * 0.01D);
        arrayOfDouble[j][0] = this.mValues[i];
        j += 1;
      }
      i += 1;
    }
    this.mCurveFit = CurveFit.get(paramInt, (double[])localObject, arrayOfDouble);
  }
  
  public String toString()
  {
    String str = this.mType;
    DecimalFormat localDecimalFormat = new DecimalFormat("##.##");
    int i = 0;
    while (i < this.count)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("[");
      localStringBuilder.append(this.mTimePoints[i]);
      localStringBuilder.append(" , ");
      localStringBuilder.append(localDecimalFormat.format(this.mValues[i]));
      localStringBuilder.append("] ");
      str = localStringBuilder.toString();
      i += 1;
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.SplineSet
 * JD-Core Version:    0.7.0.1
 */