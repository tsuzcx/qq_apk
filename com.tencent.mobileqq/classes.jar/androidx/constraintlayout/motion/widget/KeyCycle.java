package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintAttribute.AttributeType;
import androidx.constraintlayout.widget.R.styleable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class KeyCycle
  extends Key
{
  public static final int KEY_TYPE = 4;
  static final String NAME = "KeyCycle";
  private static final String TAG = "KeyCycle";
  private float mAlpha = (0.0F / 0.0F);
  private int mCurveFit = 0;
  private float mElevation = (0.0F / 0.0F);
  private float mProgress = (0.0F / 0.0F);
  private float mRotation = (0.0F / 0.0F);
  private float mRotationX = (0.0F / 0.0F);
  private float mRotationY = (0.0F / 0.0F);
  private float mScaleX = (0.0F / 0.0F);
  private float mScaleY = (0.0F / 0.0F);
  private String mTransitionEasing = null;
  private float mTransitionPathRotate = (0.0F / 0.0F);
  private float mTranslationX = (0.0F / 0.0F);
  private float mTranslationY = (0.0F / 0.0F);
  private float mTranslationZ = (0.0F / 0.0F);
  private float mWaveOffset = 0.0F;
  private float mWavePeriod = (0.0F / 0.0F);
  private int mWaveShape = -1;
  private int mWaveVariesBy = -1;
  
  public KeyCycle()
  {
    this.mType = 4;
    this.mCustomConstraints = new HashMap();
  }
  
  public void addCycleValues(HashMap<String, KeyCycleOscillator> paramHashMap)
  {
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (str.startsWith("CUSTOM"))
      {
        Object localObject = str.substring(7);
        localObject = (ConstraintAttribute)this.mCustomConstraints.get(localObject);
        if ((localObject != null) && (((ConstraintAttribute)localObject).getType() == ConstraintAttribute.AttributeType.FLOAT_TYPE)) {
          ((KeyCycleOscillator)paramHashMap.get(str)).setPoint(this.mFramePosition, this.mWaveShape, this.mWaveVariesBy, this.mWavePeriod, this.mWaveOffset, ((ConstraintAttribute)localObject).getValueToInterpolate(), (ConstraintAttribute)localObject);
        }
      }
      float f = getValue(str);
      if (!Float.isNaN(f)) {
        ((KeyCycleOscillator)paramHashMap.get(str)).setPoint(this.mFramePosition, this.mWaveShape, this.mWaveVariesBy, this.mWavePeriod, this.mWaveOffset, f);
      }
    }
  }
  
  public void addValues(HashMap<String, SplineSet> paramHashMap)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("add ");
    ((StringBuilder)localObject1).append(paramHashMap.size());
    ((StringBuilder)localObject1).append(" values");
    Debug.logStack("KeyCycle", ((StringBuilder)localObject1).toString(), 2);
    localObject1 = paramHashMap.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      String str = (String)((Iterator)localObject1).next();
      Object localObject2 = (SplineSet)paramHashMap.get(str);
      int i = -1;
      switch (str.hashCode())
      {
      default: 
        break;
      case 156108012: 
        if (str.equals("waveOffset")) {
          i = 11;
        }
        break;
      case 92909918: 
        if (str.equals("alpha")) {
          i = 0;
        }
        break;
      case 37232917: 
        if (str.equals("transitionPathRotate")) {
          i = 5;
        }
        break;
      case -4379043: 
        if (str.equals("elevation")) {
          i = 1;
        }
        break;
      case -40300674: 
        if (str.equals("rotation")) {
          i = 2;
        }
        break;
      case -908189617: 
        if (str.equals("scaleY")) {
          i = 7;
        }
        break;
      case -908189618: 
        if (str.equals("scaleX")) {
          i = 6;
        }
        break;
      case -1001078227: 
        if (str.equals("progress")) {
          i = 12;
        }
        break;
      case -1225497655: 
        if (str.equals("translationZ")) {
          i = 10;
        }
        break;
      case -1225497656: 
        if (str.equals("translationY")) {
          i = 9;
        }
        break;
      case -1225497657: 
        if (str.equals("translationX")) {
          i = 8;
        }
        break;
      case -1249320805: 
        if (str.equals("rotationY")) {
          i = 4;
        }
        break;
      case -1249320806: 
        if (str.equals("rotationX")) {
          i = 3;
        }
        break;
      }
      switch (i)
      {
      default: 
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("  UNKNOWN  ");
        ((StringBuilder)localObject2).append(str);
        Log.v("WARNING KeyCycle", ((StringBuilder)localObject2).toString());
        break;
      case 12: 
        ((SplineSet)localObject2).setPoint(this.mFramePosition, this.mProgress);
        break;
      case 11: 
        ((SplineSet)localObject2).setPoint(this.mFramePosition, this.mWaveOffset);
        break;
      case 10: 
        ((SplineSet)localObject2).setPoint(this.mFramePosition, this.mTranslationZ);
        break;
      case 9: 
        ((SplineSet)localObject2).setPoint(this.mFramePosition, this.mTranslationY);
        break;
      case 8: 
        ((SplineSet)localObject2).setPoint(this.mFramePosition, this.mTranslationX);
        break;
      case 7: 
        ((SplineSet)localObject2).setPoint(this.mFramePosition, this.mScaleY);
        break;
      case 6: 
        ((SplineSet)localObject2).setPoint(this.mFramePosition, this.mScaleX);
        break;
      case 5: 
        ((SplineSet)localObject2).setPoint(this.mFramePosition, this.mTransitionPathRotate);
        break;
      case 4: 
        ((SplineSet)localObject2).setPoint(this.mFramePosition, this.mRotationY);
        break;
      case 3: 
        ((SplineSet)localObject2).setPoint(this.mFramePosition, this.mRotationX);
        break;
      case 2: 
        ((SplineSet)localObject2).setPoint(this.mFramePosition, this.mRotation);
        break;
      case 1: 
        ((SplineSet)localObject2).setPoint(this.mFramePosition, this.mElevation);
        break;
      case 0: 
        ((SplineSet)localObject2).setPoint(this.mFramePosition, this.mAlpha);
      }
    }
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
    if (!Float.isNaN(this.mScaleX)) {
      paramHashSet.add("scaleX");
    }
    if (!Float.isNaN(this.mScaleY)) {
      paramHashSet.add("scaleY");
    }
    if (!Float.isNaN(this.mTransitionPathRotate)) {
      paramHashSet.add("transitionPathRotate");
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
  
  public float getValue(String paramString)
  {
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 156108012: 
      if (paramString.equals("waveOffset")) {
        i = 11;
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
        i = 12;
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("  UNKNOWN  ");
      localStringBuilder.append(paramString);
      Log.v("WARNING! KeyCycle", localStringBuilder.toString());
      return (0.0F / 0.0F);
    case 12: 
      return this.mProgress;
    case 11: 
      return this.mWaveOffset;
    case 10: 
      return this.mTranslationZ;
    case 9: 
      return this.mTranslationY;
    case 8: 
      return this.mTranslationX;
    case 7: 
      return this.mScaleY;
    case 6: 
      return this.mScaleX;
    case 5: 
      return this.mTransitionPathRotate;
    case 4: 
      return this.mRotationY;
    case 3: 
      return this.mRotationX;
    case 2: 
      return this.mRotation;
    case 1: 
      return this.mElevation;
    }
    return this.mAlpha;
  }
  
  public void load(Context paramContext, AttributeSet paramAttributeSet)
  {
    KeyCycle.Loader.access$000(this, paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.KeyCycle));
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
    case 184161818: 
      if (paramString.equals("wavePeriod")) {
        i = 14;
      }
      break;
    case 156108012: 
      if (paramString.equals("waveOffset")) {
        i = 15;
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
    case 15: 
      this.mWaveOffset = toFloat(paramObject);
      return;
    case 14: 
      this.mWavePeriod = toFloat(paramObject);
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
 * Qualified Name:     androidx.constraintlayout.motion.widget.KeyCycle
 * JD-Core Version:    0.7.0.1
 */