package androidx.constraintlayout.motion.widget;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.text.DecimalFormat;

public abstract class TimeCycleSplineSet
{
  private static final int CURVE_OFFSET = 2;
  private static final int CURVE_PERIOD = 1;
  private static final int CURVE_VALUE = 0;
  private static final String TAG = "SplineSet";
  private static float VAL_2PI = 6.283186F;
  private int count;
  float last_cycle = (0.0F / 0.0F);
  long last_time;
  private float[] mCache = new float[3];
  protected boolean mContinue = false;
  protected CurveFit mCurveFit;
  protected int[] mTimePoints = new int[10];
  private String mType;
  protected float[][] mValues = (float[][])Array.newInstance(Float.TYPE, new int[] { 10, 3 });
  protected int mWaveShape = 0;
  
  static TimeCycleSplineSet makeCustomSpline(String paramString, SparseArray<ConstraintAttribute> paramSparseArray)
  {
    return new TimeCycleSplineSet.CustomSet(paramString, paramSparseArray);
  }
  
  static TimeCycleSplineSet makeSpline(String paramString, long paramLong)
  {
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 92909918: 
      if (paramString.equals("alpha")) {
        i = 0;
      }
      break;
    case 37232917: 
      if (paramString.equals("transitionPathRotate")) {
        i = 5;
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
    case -908189617: 
      if (paramString.equals("scaleY")) {
        i = 7;
      }
      break;
    case -908189618: 
      if (paramString.equals("scaleX")) {
        i = 6;
      }
      break;
    case -1001078227: 
      if (paramString.equals("progress")) {
        i = 11;
      }
      break;
    case -1225497655: 
      if (paramString.equals("translationZ")) {
        i = 10;
      }
      break;
    case -1225497656: 
      if (paramString.equals("translationY")) {
        i = 9;
      }
      break;
    case -1225497657: 
      if (paramString.equals("translationX")) {
        i = 8;
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
    case 11: 
      paramString = new TimeCycleSplineSet.ProgressSet();
      break;
    case 10: 
      paramString = new TimeCycleSplineSet.TranslationZset();
      break;
    case 9: 
      paramString = new TimeCycleSplineSet.TranslationYset();
      break;
    case 8: 
      paramString = new TimeCycleSplineSet.TranslationXset();
      break;
    case 7: 
      paramString = new TimeCycleSplineSet.ScaleYset();
      break;
    case 6: 
      paramString = new TimeCycleSplineSet.ScaleXset();
      break;
    case 5: 
      paramString = new TimeCycleSplineSet.PathRotate();
      break;
    case 4: 
      paramString = new TimeCycleSplineSet.RotationYset();
      break;
    case 3: 
      paramString = new TimeCycleSplineSet.RotationXset();
      break;
    case 2: 
      paramString = new TimeCycleSplineSet.RotationSet();
      break;
    case 1: 
      paramString = new TimeCycleSplineSet.ElevationSet();
      break;
    case 0: 
      paramString = new TimeCycleSplineSet.AlphaSet();
    }
    paramString.setStartTime(paramLong);
    return paramString;
  }
  
  protected float calcWave(float paramFloat)
  {
    switch (this.mWaveShape)
    {
    default: 
      return (float)Math.sin(paramFloat * VAL_2PI);
    case 6: 
      paramFloat = 1.0F - Math.abs(paramFloat * 4.0F % 4.0F - 2.0F);
      paramFloat *= paramFloat;
    case 5: 
    case 4: 
    case 3: 
    case 2: 
      for (;;)
      {
        return 1.0F - paramFloat;
        return (float)Math.cos(paramFloat * VAL_2PI);
        paramFloat = (paramFloat * 2.0F + 1.0F) % 2.0F;
        continue;
        return (paramFloat * 2.0F + 1.0F) % 2.0F - 1.0F;
        paramFloat = Math.abs(paramFloat);
      }
    }
    return Math.signum(paramFloat * VAL_2PI);
  }
  
  public float get(float paramFloat, long paramLong, View paramView, KeyCache paramKeyCache)
  {
    this.mCurveFit.getPos(paramFloat, this.mCache);
    float[] arrayOfFloat = this.mCache;
    paramFloat = arrayOfFloat[1];
    boolean bool = false;
    if (paramFloat == 0.0F)
    {
      this.mContinue = false;
      return arrayOfFloat[2];
    }
    if (Float.isNaN(this.last_cycle))
    {
      this.last_cycle = paramKeyCache.getFloatValue(paramView, this.mType, 0);
      if (Float.isNaN(this.last_cycle)) {
        this.last_cycle = 0.0F;
      }
    }
    long l = this.last_time;
    double d1 = this.last_cycle;
    double d2 = paramLong - l;
    Double.isNaN(d2);
    double d3 = paramFloat;
    Double.isNaN(d3);
    Double.isNaN(d1);
    this.last_cycle = ((float)((d1 + d2 * 1.E-009D * d3) % 1.0D));
    paramKeyCache.setFloatValue(paramView, this.mType, 0, this.last_cycle);
    this.last_time = paramLong;
    float f1 = this.mCache[0];
    float f2 = calcWave(this.last_cycle);
    float f3 = this.mCache[2];
    if ((f1 != 0.0F) || (paramFloat != 0.0F)) {
      bool = true;
    }
    this.mContinue = bool;
    return f2 * f1 + f3;
  }
  
  public CurveFit getCurveFit()
  {
    return this.mCurveFit;
  }
  
  public void setPoint(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, float paramFloat3)
  {
    Object localObject = this.mTimePoints;
    int i = this.count;
    localObject[i] = paramInt1;
    localObject = this.mValues;
    localObject[i][0] = paramFloat1;
    localObject[i][1] = paramFloat2;
    localObject[i][2] = paramFloat3;
    this.mWaveShape = Math.max(this.mWaveShape, paramInt2);
    this.count += 1;
  }
  
  public abstract boolean setProperty(View paramView, float paramFloat, long paramLong, KeyCache paramKeyCache);
  
  protected void setStartTime(long paramLong)
  {
    this.last_time = paramLong;
  }
  
  public void setType(String paramString)
  {
    this.mType = paramString;
  }
  
  public void setup(int paramInt)
  {
    int i = this.count;
    if (i == 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Error no points added to ");
      ((StringBuilder)localObject1).append(this.mType);
      Log.e("SplineSet", ((StringBuilder)localObject1).toString());
      return;
    }
    TimeCycleSplineSet.Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, i - 1);
    int j = 1;
    int k;
    for (i = 0;; i = k)
    {
      localObject1 = this.mTimePoints;
      if (j >= localObject1.length) {
        break;
      }
      k = i;
      if (localObject1[j] != localObject1[(j - 1)]) {
        k = i + 1;
      }
      j += 1;
    }
    j = i;
    if (i == 0) {
      j = 1;
    }
    Object localObject1 = new double[j];
    double[][] arrayOfDouble = (double[][])Array.newInstance(Double.TYPE, new int[] { j, 3 });
    i = 0;
    j = 0;
    while (i < this.count)
    {
      Object localObject2;
      if (i > 0)
      {
        localObject2 = this.mTimePoints;
        if (localObject2[i] == localObject2[(i - 1)]) {}
      }
      else
      {
        double d = this.mTimePoints[i];
        Double.isNaN(d);
        localObject1[j] = (d * 0.01D);
        localObject2 = arrayOfDouble[j];
        float[][] arrayOfFloat = this.mValues;
        localObject2[0] = arrayOfFloat[i][0];
        arrayOfDouble[j][1] = arrayOfFloat[i][1];
        arrayOfDouble[j][2] = arrayOfFloat[i][2];
        j += 1;
      }
      i += 1;
    }
    this.mCurveFit = CurveFit.get(paramInt, (double[])localObject1, arrayOfDouble);
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
 * Qualified Name:     androidx.constraintlayout.motion.widget.TimeCycleSplineSet
 * JD-Core Version:    0.7.0.1
 */