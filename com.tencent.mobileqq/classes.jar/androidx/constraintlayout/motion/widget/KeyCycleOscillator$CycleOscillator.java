package androidx.constraintlayout.motion.widget;

import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.motion.utils.Oscillator;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintAttribute.AttributeType;
import java.lang.reflect.Array;
import java.util.HashMap;

class KeyCycleOscillator$CycleOscillator
{
  private static final String TAG = "CycleOscillator";
  static final int UNSET = -1;
  CurveFit mCurveFit;
  public HashMap<String, ConstraintAttribute> mCustomConstraints = new HashMap();
  float[] mOffset;
  Oscillator mOscillator = new Oscillator();
  float mPathLength;
  float[] mPeriod;
  double[] mPosition;
  float[] mScale;
  double[] mSplineSlopeCache;
  double[] mSplineValueCache;
  float[] mValues;
  private final int mVariesBy;
  int mWaveShape;
  
  KeyCycleOscillator$CycleOscillator(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mWaveShape = paramInt1;
    this.mVariesBy = paramInt2;
    this.mOscillator.setType(paramInt1);
    this.mValues = new float[paramInt3];
    this.mPosition = new double[paramInt3];
    this.mPeriod = new float[paramInt3];
    this.mOffset = new float[paramInt3];
    this.mScale = new float[paramInt3];
  }
  
  private ConstraintAttribute get(String paramString, ConstraintAttribute.AttributeType paramAttributeType)
  {
    if (this.mCustomConstraints.containsKey(paramString))
    {
      paramString = (ConstraintAttribute)this.mCustomConstraints.get(paramString);
      if (paramString.getType() == paramAttributeType) {
        return paramString;
      }
      paramAttributeType = new StringBuilder();
      paramAttributeType.append("ConstraintAttribute is already a ");
      paramAttributeType.append(paramString.getType().name());
      throw new IllegalArgumentException(paramAttributeType.toString());
    }
    paramAttributeType = new ConstraintAttribute(paramString, paramAttributeType);
    this.mCustomConstraints.put(paramString, paramAttributeType);
    return paramAttributeType;
  }
  
  public double getSlope(float paramFloat)
  {
    Object localObject = this.mCurveFit;
    if (localObject != null)
    {
      d1 = paramFloat;
      ((CurveFit)localObject).getSlope(d1, this.mSplineSlopeCache);
      this.mCurveFit.getPos(d1, this.mSplineValueCache);
    }
    else
    {
      localObject = this.mSplineSlopeCache;
      localObject[0] = 0.0D;
      localObject[1] = 0.0D;
    }
    localObject = this.mOscillator;
    double d2 = paramFloat;
    double d1 = ((Oscillator)localObject).getValue(d2);
    d2 = this.mOscillator.getSlope(d2);
    localObject = this.mSplineSlopeCache;
    return localObject[0] + d1 * localObject[1] + d2 * this.mSplineValueCache[1];
  }
  
  public double getValues(float paramFloat)
  {
    Object localObject = this.mCurveFit;
    if (localObject != null)
    {
      ((CurveFit)localObject).getPos(paramFloat, this.mSplineValueCache);
    }
    else
    {
      localObject = this.mSplineValueCache;
      localObject[0] = this.mOffset[0];
      localObject[1] = this.mValues[0];
    }
    return this.mSplineValueCache[0] + this.mOscillator.getValue(paramFloat) * this.mSplineValueCache[1];
  }
  
  public void setPoint(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    double[] arrayOfDouble = this.mPosition;
    double d = paramInt2;
    Double.isNaN(d);
    arrayOfDouble[paramInt1] = (d / 100.0D);
    this.mPeriod[paramInt1] = paramFloat1;
    this.mOffset[paramInt1] = paramFloat2;
    this.mValues[paramInt1] = paramFloat3;
  }
  
  public void setup(float paramFloat)
  {
    this.mPathLength = paramFloat;
    double[][] arrayOfDouble = (double[][])Array.newInstance(Double.TYPE, new int[] { this.mPosition.length, 2 });
    Object localObject = this.mValues;
    this.mSplineValueCache = new double[localObject.length + 1];
    this.mSplineSlopeCache = new double[localObject.length + 1];
    if (this.mPosition[0] > 0.0D) {
      this.mOscillator.addPoint(0.0D, this.mPeriod[0]);
    }
    localObject = this.mPosition;
    int i = localObject.length - 1;
    if (localObject[i] < 1.0D) {
      this.mOscillator.addPoint(1.0D, this.mPeriod[i]);
    }
    i = 0;
    while (i < arrayOfDouble.length)
    {
      arrayOfDouble[i][0] = this.mOffset[i];
      int j = 0;
      for (;;)
      {
        localObject = this.mValues;
        if (j >= localObject.length) {
          break;
        }
        arrayOfDouble[j][1] = localObject[j];
        j += 1;
      }
      this.mOscillator.addPoint(this.mPosition[i], this.mPeriod[i]);
      i += 1;
    }
    this.mOscillator.normalize();
    localObject = this.mPosition;
    if (localObject.length > 1)
    {
      this.mCurveFit = CurveFit.get(0, (double[])localObject, arrayOfDouble);
      return;
    }
    this.mCurveFit = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.KeyCycleOscillator.CycleOscillator
 * JD-Core Version:    0.7.0.1
 */