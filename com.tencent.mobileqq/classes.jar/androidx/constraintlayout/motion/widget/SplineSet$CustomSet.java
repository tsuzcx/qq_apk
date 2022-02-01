package androidx.constraintlayout.motion.widget;

import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;

class SplineSet$CustomSet
  extends SplineSet
{
  String mAttributeName = paramString.split(",")[1];
  SparseArray<ConstraintAttribute> mConstraintAttributeList;
  float[] mTempValues;
  
  public SplineSet$CustomSet(String paramString, SparseArray<ConstraintAttribute> paramSparseArray)
  {
    this.mConstraintAttributeList = paramSparseArray;
  }
  
  public void setPoint(int paramInt, float paramFloat)
  {
    throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
  }
  
  public void setPoint(int paramInt, ConstraintAttribute paramConstraintAttribute)
  {
    this.mConstraintAttributeList.append(paramInt, paramConstraintAttribute);
  }
  
  public void setProperty(View paramView, float paramFloat)
  {
    this.mCurveFit.getPos(paramFloat, this.mTempValues);
    ((ConstraintAttribute)this.mConstraintAttributeList.valueAt(0)).setInterpolatedValue(paramView, this.mTempValues);
  }
  
  public void setup(int paramInt)
  {
    int k = this.mConstraintAttributeList.size();
    int i = ((ConstraintAttribute)this.mConstraintAttributeList.valueAt(0)).noOfInterpValues();
    double[] arrayOfDouble = new double[k];
    this.mTempValues = new float[i];
    double[][] arrayOfDouble1 = (double[][])Array.newInstance(Double.TYPE, new int[] { k, i });
    i = 0;
    while (i < k)
    {
      int j = this.mConstraintAttributeList.keyAt(i);
      Object localObject = (ConstraintAttribute)this.mConstraintAttributeList.valueAt(i);
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
      i += 1;
    }
    this.mCurveFit = CurveFit.get(paramInt, arrayOfDouble, arrayOfDouble1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.SplineSet.CustomSet
 * JD-Core Version:    0.7.0.1
 */