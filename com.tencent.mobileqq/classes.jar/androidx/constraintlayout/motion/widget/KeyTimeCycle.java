package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R.styleable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class KeyTimeCycle
  extends Key
{
  public static final int KEY_TYPE = 3;
  static final String NAME = "KeyTimeCycle";
  private static final String TAG = "KeyTimeCycle";
  private float mAlpha = (0.0F / 0.0F);
  private int mCurveFit = -1;
  private float mElevation = (0.0F / 0.0F);
  private float mProgress = (0.0F / 0.0F);
  private float mRotation = (0.0F / 0.0F);
  private float mRotationX = (0.0F / 0.0F);
  private float mRotationY = (0.0F / 0.0F);
  private float mScaleX = (0.0F / 0.0F);
  private float mScaleY = (0.0F / 0.0F);
  private String mTransitionEasing;
  private float mTransitionPathRotate = (0.0F / 0.0F);
  private float mTranslationX = (0.0F / 0.0F);
  private float mTranslationY = (0.0F / 0.0F);
  private float mTranslationZ = (0.0F / 0.0F);
  private float mWaveOffset = 0.0F;
  private CurveFit mWaveOffsetSpline;
  private float mWavePeriod = (0.0F / 0.0F);
  private CurveFit mWavePeriodSpline;
  private int mWaveShape = 0;
  
  public KeyTimeCycle()
  {
    this.mType = 3;
    this.mCustomConstraints = new HashMap();
  }
  
  public void addTimeValues(HashMap<String, TimeCycleSplineSet> paramHashMap)
  {
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (String)localIterator.next();
      Object localObject1 = (TimeCycleSplineSet)paramHashMap.get(localObject2);
      boolean bool = ((String)localObject2).startsWith("CUSTOM");
      int i = 7;
      if (bool)
      {
        localObject2 = ((String)localObject2).substring(7);
        localObject2 = (ConstraintAttribute)this.mCustomConstraints.get(localObject2);
        if (localObject2 != null) {
          ((TimeCycleSplineSet.CustomSet)localObject1).setPoint(this.mFramePosition, (ConstraintAttribute)localObject2, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        }
      }
      else
      {
        switch (((String)localObject2).hashCode())
        {
        default: 
          break;
        case 92909918: 
          if (((String)localObject2).equals("alpha")) {
            i = 0;
          }
          break;
        case 37232917: 
          if (((String)localObject2).equals("transitionPathRotate")) {
            i = 5;
          }
          break;
        case -4379043: 
          if (((String)localObject2).equals("elevation")) {
            i = 1;
          }
          break;
        case -40300674: 
          if (((String)localObject2).equals("rotation")) {
            i = 2;
          }
          break;
        case -908189617: 
          if (!((String)localObject2).equals("scaleY")) {
            break;
          }
          break;
        case -908189618: 
          if (((String)localObject2).equals("scaleX")) {
            i = 6;
          }
          break;
        case -1001078227: 
          if (((String)localObject2).equals("progress")) {
            i = 11;
          }
          break;
        case -1225497655: 
          if (((String)localObject2).equals("translationZ")) {
            i = 10;
          }
          break;
        case -1225497656: 
          if (((String)localObject2).equals("translationY")) {
            i = 9;
          }
          break;
        case -1225497657: 
          if (((String)localObject2).equals("translationX")) {
            i = 8;
          }
          break;
        case -1249320805: 
          if (((String)localObject2).equals("rotationY")) {
            i = 4;
          }
          break;
        case -1249320806: 
          if (((String)localObject2).equals("rotationX")) {
            i = 3;
          }
          break;
        }
        i = -1;
        switch (i)
        {
        default: 
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("UNKNOWN addValues \"");
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append("\"");
          Log.e("KeyTimeCycles", ((StringBuilder)localObject1).toString());
          break;
        case 11: 
          if (!Float.isNaN(this.mProgress)) {
            ((TimeCycleSplineSet)localObject1).setPoint(this.mFramePosition, this.mProgress, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
          }
          break;
        case 10: 
          if (!Float.isNaN(this.mTranslationZ)) {
            ((TimeCycleSplineSet)localObject1).setPoint(this.mFramePosition, this.mTranslationZ, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
          }
          break;
        case 9: 
          if (!Float.isNaN(this.mTranslationY)) {
            ((TimeCycleSplineSet)localObject1).setPoint(this.mFramePosition, this.mTranslationY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
          }
          break;
        case 8: 
          if (!Float.isNaN(this.mTranslationX)) {
            ((TimeCycleSplineSet)localObject1).setPoint(this.mFramePosition, this.mTranslationX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
          }
          break;
        case 7: 
          if (!Float.isNaN(this.mScaleY)) {
            ((TimeCycleSplineSet)localObject1).setPoint(this.mFramePosition, this.mScaleY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
          }
          break;
        case 6: 
          if (!Float.isNaN(this.mScaleX)) {
            ((TimeCycleSplineSet)localObject1).setPoint(this.mFramePosition, this.mScaleX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
          }
          break;
        case 5: 
          if (!Float.isNaN(this.mTransitionPathRotate)) {
            ((TimeCycleSplineSet)localObject1).setPoint(this.mFramePosition, this.mTransitionPathRotate, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
          }
          break;
        case 4: 
          if (!Float.isNaN(this.mRotationY)) {
            ((TimeCycleSplineSet)localObject1).setPoint(this.mFramePosition, this.mRotationY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
          }
          break;
        case 3: 
          if (!Float.isNaN(this.mRotationX)) {
            ((TimeCycleSplineSet)localObject1).setPoint(this.mFramePosition, this.mRotationX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
          }
          break;
        case 2: 
          if (!Float.isNaN(this.mRotation)) {
            ((TimeCycleSplineSet)localObject1).setPoint(this.mFramePosition, this.mRotation, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
          }
          break;
        case 1: 
          if (!Float.isNaN(this.mElevation)) {
            ((TimeCycleSplineSet)localObject1).setPoint(this.mFramePosition, this.mElevation, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
          }
          break;
        case 0: 
          if (!Float.isNaN(this.mAlpha)) {
            ((TimeCycleSplineSet)localObject1).setPoint(this.mFramePosition, this.mAlpha, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
          }
          break;
        }
      }
    }
  }
  
  public void addValues(HashMap<String, SplineSet> paramHashMap)
  {
    throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
  }
  
  public void getAttributeNames(HashSet<String> paramHashSet)
  {
    if (!Float.isNaN(this.mAlpha)) {
      paramHashSet.add("alpha");
    }
    if (!Float.isNaN(this.mElevation)) {
      paramHashSet.add("elevation");
    }
    if (!Float.isNaN(this.mRotation)) {
      paramHashSet.add("rotation");
    }
    if (!Float.isNaN(this.mRotationX)) {
      paramHashSet.add("rotationX");
    }
    if (!Float.isNaN(this.mRotationY)) {
      paramHashSet.add("rotationY");
    }
    if (!Float.isNaN(this.mTranslationX)) {
      paramHashSet.add("translationX");
    }
    if (!Float.isNaN(this.mTranslationY)) {
      paramHashSet.add("translationY");
    }
    if (!Float.isNaN(this.mTranslationZ)) {
      paramHashSet.add("translationZ");
    }
    if (!Float.isNaN(this.mTransitionPathRotate)) {
      paramHashSet.add("transitionPathRotate");
    }
    if (!Float.isNaN(this.mScaleX)) {
      paramHashSet.add("scaleX");
    }
    if (!Float.isNaN(this.mScaleY)) {
      paramHashSet.add("scaleY");
    }
    if (!Float.isNaN(this.mProgress)) {
      paramHashSet.add("progress");
    }
    if (this.mCustomConstraints.size() > 0)
    {
      Iterator localIterator = this.mCustomConstraints.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("CUSTOM,");
        localStringBuilder.append(str);
        paramHashSet.add(localStringBuilder.toString());
      }
    }
  }
  
  int getCurveFit()
  {
    return this.mCurveFit;
  }
  
  public void load(Context paramContext, AttributeSet paramAttributeSet)
  {
    KeyTimeCycle.Loader.read(this, paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.KeyTimeCycle));
  }
  
  public void setInterpolation(HashMap<String, Integer> paramHashMap)
  {
    if (this.mCurveFit == -1) {
      return;
    }
    if (!Float.isNaN(this.mAlpha)) {
      paramHashMap.put("alpha", Integer.valueOf(this.mCurveFit));
    }
    if (!Float.isNaN(this.mElevation)) {
      paramHashMap.put("elevation", Integer.valueOf(this.mCurveFit));
    }
    if (!Float.isNaN(this.mRotation)) {
      paramHashMap.put("rotation", Integer.valueOf(this.mCurveFit));
    }
    if (!Float.isNaN(this.mRotationX)) {
      paramHashMap.put("rotationX", Integer.valueOf(this.mCurveFit));
    }
    if (!Float.isNaN(this.mRotationY)) {
      paramHashMap.put("rotationY", Integer.valueOf(this.mCurveFit));
    }
    if (!Float.isNaN(this.mTranslationX)) {
      paramHashMap.put("translationX", Integer.valueOf(this.mCurveFit));
    }
    if (!Float.isNaN(this.mTranslationY)) {
      paramHashMap.put("translationY", Integer.valueOf(this.mCurveFit));
    }
    if (!Float.isNaN(this.mTranslationZ)) {
      paramHashMap.put("translationZ", Integer.valueOf(this.mCurveFit));
    }
    if (!Float.isNaN(this.mTransitionPathRotate)) {
      paramHashMap.put("transitionPathRotate", Integer.valueOf(this.mCurveFit));
    }
    if (!Float.isNaN(this.mScaleX)) {
      paramHashMap.put("scaleX", Integer.valueOf(this.mCurveFit));
    }
    if (!Float.isNaN(this.mScaleX)) {
      paramHashMap.put("scaleY", Integer.valueOf(this.mCurveFit));
    }
    if (!Float.isNaN(this.mProgress)) {
      paramHashMap.put("progress", Integer.valueOf(this.mCurveFit));
    }
    if (this.mCustomConstraints.size() > 0)
    {
      Iterator localIterator = this.mCustomConstraints.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("CUSTOM,");
        localStringBuilder.append(str);
        paramHashMap.put(localStringBuilder.toString(), Integer.valueOf(this.mCurveFit));
      }
    }
  }
  
  public void setValue(String paramString, Object paramObject)
  {
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 1317633238: 
      if (paramString.equals("mTranslationZ")) {
        i = 13;
      }
      break;
    case 579057826: 
      if (paramString.equals("curveFit")) {
        i = 1;
      }
      break;
    case 92909918: 
      if (paramString.equals("alpha")) {
        i = 0;
      }
      break;
    case 37232917: 
      if (paramString.equals("transitionPathRotate")) {
        i = 10;
      }
      break;
    case -4379043: 
      if (paramString.equals("elevation")) {
        i = 2;
      }
      break;
    case -40300674: 
      if (paramString.equals("rotation")) {
        i = 4;
      }
      break;
    case -908189617: 
      if (paramString.equals("scaleY")) {
        i = 8;
      }
      break;
    case -908189618: 
      if (paramString.equals("scaleX")) {
        i = 7;
      }
      break;
    case -1001078227: 
      if (paramString.equals("progress")) {
        i = 3;
      }
      break;
    case -1225497656: 
      if (paramString.equals("translationY")) {
        i = 12;
      }
      break;
    case -1225497657: 
      if (paramString.equals("translationX")) {
        i = 11;
      }
      break;
    case -1249320805: 
      if (paramString.equals("rotationY")) {
        i = 6;
      }
      break;
    case -1249320806: 
      if (paramString.equals("rotationX")) {
        i = 5;
      }
      break;
    case -1812823328: 
      if (paramString.equals("transitionEasing")) {
        i = 9;
      }
      break;
    }
    int i = -1;
    switch (i)
    {
    default: 
      return;
    case 13: 
      this.mTranslationZ = toFloat(paramObject);
      return;
    case 12: 
      this.mTranslationY = toFloat(paramObject);
      return;
    case 11: 
      this.mTranslationX = toFloat(paramObject);
      return;
    case 10: 
      this.mTransitionPathRotate = toFloat(paramObject);
      return;
    case 9: 
      this.mTransitionEasing = paramObject.toString();
      return;
    case 8: 
      this.mScaleY = toFloat(paramObject);
      return;
    case 7: 
      this.mScaleX = toFloat(paramObject);
      return;
    case 6: 
      this.mRotationY = toFloat(paramObject);
      return;
    case 5: 
      this.mRotationX = toFloat(paramObject);
      return;
    case 4: 
      this.mRotation = toFloat(paramObject);
      return;
    case 3: 
      this.mProgress = toFloat(paramObject);
      return;
    case 2: 
      this.mElevation = toFloat(paramObject);
      return;
    case 1: 
      this.mCurveFit = toInt(paramObject);
      return;
    }
    this.mAlpha = toFloat(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.KeyTimeCycle
 * JD-Core Version:    0.7.0.1
 */