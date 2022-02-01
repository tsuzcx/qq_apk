package androidx.constraintlayout.motion.widget;

import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;

class TimeCycleSplineSet$CustomSet
  extends TimeCycleSplineSet
{
  String mAttributeName = paramString.split(",")[1];
  float[] mCache;
  SparseArray<ConstraintAttribute> mConstraintAttributeList;
  float[] mTempValues;
  SparseArray<float[]> mWaveProperties = new SparseArray();
  
  public TimeCycleSplineSet$CustomSet(String paramString, SparseArray<ConstraintAttribute> paramSparseArray)
  {
    this.mConstraintAttributeList = paramSparseArray;
  }
  
  public void setPoint(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, float paramFloat3)
  {
    throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
  }
  
  public void setPoint(int paramInt1, ConstraintAttribute paramConstraintAttribute, float paramFloat1, int paramInt2, float paramFloat2)
  {
    this.mConstraintAttributeList.append(paramInt1, paramConstraintAttribute);
    this.mWaveProperties.append(paramInt1, new float[] { paramFloat1, paramFloat2 });
    this.mWaveShape = Math.max(this.mWaveShape, paramInt2);
  }
  
  public boolean setProperty(View paramView, float paramFloat, long paramLong, KeyCache paramKeyCache)
  {
    this.mCurveFit.getPos(paramFloat, this.mTempValues);
    float[] arrayOfFloat = this.mTempValues;
    paramFloat = arrayOfFloat[(arrayOfFloat.length - 2)];
    float f1 = arrayOfFloat[(arrayOfFloat.length - 1)];
    long l = this.last_time;
    if (Float.isNaN(this.last_cycle))
    {
      this.last_cycle = paramKeyCache.getFloatValue(paramView, this.mAttributeName, 0);
      if (Float.isNaN(this.last_cycle)) {
        this.last_cycle = 0.0F;
      }
    }
    double d1 = this.last_cycle;
    double d2 = paramLong - l;
    Double.isNaN(d2);
    double d3 = paramFloat;
    Double.isNaN(d3);
    Double.isNaN(d1);
    this.last_cycle = ((float)((d1 + d2 * 1.E-009D * d3) % 1.0D));
    this.last_time = paramLong;
    float f2 = calcWave(this.last_cycle);
    this.mContinue = false;
    int i = 0;
    while (i < this.mCache.length)
    {
      boolean bool2 = this.mContinue;
      boolean bool1;
      if (this.mTempValues[i] != 0.0D) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.mContinue = (bool2 | bool1);
      this.mCache[i] = (this.mTempValues[i] * f2 + f1);
      i += 1;
    }
    ((ConstraintAttribute)this.mConstraintAttributeList.valueAt(0)).setInterpolatedValue(paramView, this.mCache);
    if (paramFloat != 0.0F) {
      this.mContinue = true;
    }
    return this.mContinue;
  }
  
  public void setup(int paramInt)
  {
    int k = this.mConstraintAttributeList.size();
    int m = ((ConstraintAttribute)this.mConstraintAttributeList.valueAt(0)).noOfInterpValues();
    double[] arrayOfDouble = new double[k];
    int i = m + 2;
    this.mTempValues = new float[i];
    this.mCache = new float[m];
    double[][] arrayOfDouble1 = (double[][])Array.newInstance(Double.TYPE, new int[] { k, i });
    i = 0;
    while (i < k)
    {
      int j = this.mConstraintAttributeList.keyAt(i);
      Object localObject = (ConstraintAttribute)this.mConstraintAttributeList.valueAt(i);
      float[] arrayOfFloat = (float[])this.mWaveProperties.valueAt(i);
      double d = j;
      Double.isNaN(d);
      arrayOfDouble[i] = (d * 0.01D);
      ((ConstraintAttribute)localObject).getValuesToInterpolate(this.mTempValues);
      j = 0;
      for (;;)
      {
        localObject = this.mTempValues;
        if (j >= localObject.length) {
          break;
        }
        arrayOfDouble1[i][j] = localObject[j];
        j += 1;
      }
      arrayOfDouble1[i][m] = arrayOfFloat[0];
      arrayOfDouble1[i][(m + 1)] = arrayOfFloat[1];
      i += 1;
    }
    this.mCurveFit = CurveFit.get(paramInt, arrayOfDouble, arrayOfDouble1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.TimeCycleSplineSet.CustomSet
 * JD-Core Version:    0.7.0.1
 */