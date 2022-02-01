package androidx.constraintlayout.motion.widget;

import android.annotation.TargetApi;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public abstract class KeyCycleOscillator
{
  private static final String TAG = "KeyCycleOscillator";
  private CurveFit mCurveFit;
  protected ConstraintAttribute mCustom;
  private KeyCycleOscillator.CycleOscillator mCycleOscillator;
  private String mType;
  public int mVariesBy = 0;
  ArrayList<KeyCycleOscillator.WavePoint> mWavePoints = new ArrayList();
  private int mWaveShape = 0;
  
  static KeyCycleOscillator makeSpline(String paramString)
  {
    if (paramString.startsWith("CUSTOM")) {
      return new KeyCycleOscillator.CustomSet();
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 156108012: 
      if (paramString.equals("waveOffset")) {
        i = 8;
      }
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
    case -797520672: 
      if (paramString.equals("waveVariesBy")) {
        i = 9;
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
        i = 13;
      }
      break;
    case -1225497655: 
      if (paramString.equals("translationZ")) {
        i = 12;
      }
      break;
    case -1225497656: 
      if (paramString.equals("translationY")) {
        i = 11;
      }
      break;
    case -1225497657: 
      if (paramString.equals("translationX")) {
        i = 10;
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
    switch (i)
    {
    default: 
      return null;
    case 13: 
      return new KeyCycleOscillator.ProgressSet();
    case 12: 
      return new KeyCycleOscillator.TranslationZset();
    case 11: 
      return new KeyCycleOscillator.TranslationYset();
    case 10: 
      return new KeyCycleOscillator.TranslationXset();
    case 9: 
      return new KeyCycleOscillator.AlphaSet();
    case 8: 
      return new KeyCycleOscillator.AlphaSet();
    case 7: 
      return new KeyCycleOscillator.ScaleYset();
    case 6: 
      return new KeyCycleOscillator.ScaleXset();
    case 5: 
      return new KeyCycleOscillator.PathRotateSet();
    case 4: 
      return new KeyCycleOscillator.RotationYset();
    case 3: 
      return new KeyCycleOscillator.RotationXset();
    case 2: 
      return new KeyCycleOscillator.RotationSet();
    case 1: 
      return new KeyCycleOscillator.ElevationSet();
    }
    return new KeyCycleOscillator.AlphaSet();
  }
  
  public float get(float paramFloat)
  {
    return (float)this.mCycleOscillator.getValues(paramFloat);
  }
  
  public CurveFit getCurveFit()
  {
    return this.mCurveFit;
  }
  
  public float getSlope(float paramFloat)
  {
    return (float)this.mCycleOscillator.getSlope(paramFloat);
  }
  
  public void setPoint(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.mWavePoints.add(new KeyCycleOscillator.WavePoint(paramInt1, paramFloat1, paramFloat2, paramFloat3));
    if (paramInt3 != -1) {
      this.mVariesBy = paramInt3;
    }
    this.mWaveShape = paramInt2;
  }
  
  public void setPoint(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, ConstraintAttribute paramConstraintAttribute)
  {
    this.mWavePoints.add(new KeyCycleOscillator.WavePoint(paramInt1, paramFloat1, paramFloat2, paramFloat3));
    if (paramInt3 != -1) {
      this.mVariesBy = paramInt3;
    }
    this.mWaveShape = paramInt2;
    this.mCustom = paramConstraintAttribute;
  }
  
  public abstract void setProperty(View paramView, float paramFloat);
  
  public void setType(String paramString)
  {
    this.mType = paramString;
  }
  
  @TargetApi(19)
  public void setup(float paramFloat)
  {
    int i = this.mWavePoints.size();
    if (i == 0) {
      return;
    }
    Collections.sort(this.mWavePoints, new KeyCycleOscillator.1(this));
    double[] arrayOfDouble = new double[i];
    double[][] arrayOfDouble1 = (double[][])Array.newInstance(Double.TYPE, new int[] { i, 2 });
    this.mCycleOscillator = new KeyCycleOscillator.CycleOscillator(this.mWaveShape, this.mVariesBy, i);
    Iterator localIterator = this.mWavePoints.iterator();
    i = 0;
    while (localIterator.hasNext())
    {
      KeyCycleOscillator.WavePoint localWavePoint = (KeyCycleOscillator.WavePoint)localIterator.next();
      double d = localWavePoint.mPeriod;
      Double.isNaN(d);
      arrayOfDouble[i] = (d * 0.01D);
      arrayOfDouble1[i][0] = localWavePoint.mValue;
      arrayOfDouble1[i][1] = localWavePoint.mOffset;
      this.mCycleOscillator.setPoint(i, localWavePoint.mPosition, localWavePoint.mPeriod, localWavePoint.mOffset, localWavePoint.mValue);
      i += 1;
    }
    this.mCycleOscillator.setup(paramFloat);
    this.mCurveFit = CurveFit.get(0, arrayOfDouble, arrayOfDouble1);
  }
  
  public String toString()
  {
    String str = this.mType;
    DecimalFormat localDecimalFormat = new DecimalFormat("##.##");
    Iterator localIterator = this.mWavePoints.iterator();
    while (localIterator.hasNext())
    {
      KeyCycleOscillator.WavePoint localWavePoint = (KeyCycleOscillator.WavePoint)localIterator.next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("[");
      localStringBuilder.append(localWavePoint.mPosition);
      localStringBuilder.append(" , ");
      localStringBuilder.append(localDecimalFormat.format(localWavePoint.mValue));
      localStringBuilder.append("] ");
      str = localStringBuilder.toString();
    }
    return str;
  }
  
  public boolean variesByPath()
  {
    return this.mVariesBy == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.KeyCycleOscillator
 * JD-Core Version:    0.7.0.1
 */