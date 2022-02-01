package androidx.constraintlayout.motion.widget;

import android.view.View;
import android.view.View.MeasureSpec;
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintAttribute.AttributeType;
import androidx.constraintlayout.widget.ConstraintSet.Constraint;
import androidx.constraintlayout.widget.ConstraintSet.Motion;
import androidx.constraintlayout.widget.ConstraintSet.PropertySet;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

class MotionPaths
  implements Comparable<MotionPaths>
{
  static final int CARTESIAN = 2;
  public static final boolean DEBUG = false;
  static final int OFF_HEIGHT = 4;
  static final int OFF_PATH_ROTATE = 5;
  static final int OFF_POSITION = 0;
  static final int OFF_WIDTH = 3;
  static final int OFF_X = 1;
  static final int OFF_Y = 2;
  public static final boolean OLD_WAY = false;
  static final int PERPENDICULAR = 1;
  static final int SCREEN = 3;
  public static final String TAG = "MotionPaths";
  static String[] names = { "position", "x", "y", "width", "height", "pathRotate" };
  LinkedHashMap<String, ConstraintAttribute> attributes = new LinkedHashMap();
  float height;
  int mDrawPath = 0;
  Easing mKeyFrameEasing;
  int mMode = 0;
  int mPathMotionArc = Key.UNSET;
  float mPathRotate = (0.0F / 0.0F);
  float mProgress = (0.0F / 0.0F);
  double[] mTempDelta = new double[18];
  double[] mTempValue = new double[18];
  float position;
  float time;
  float width;
  float x;
  float y;
  
  public MotionPaths() {}
  
  public MotionPaths(int paramInt1, int paramInt2, KeyPosition paramKeyPosition, MotionPaths paramMotionPaths1, MotionPaths paramMotionPaths2)
  {
    int i = paramKeyPosition.mPositionType;
    if (i != 1)
    {
      if (i != 2)
      {
        initCartesian(paramKeyPosition, paramMotionPaths1, paramMotionPaths2);
        return;
      }
      initScreen(paramInt1, paramInt2, paramKeyPosition, paramMotionPaths1, paramMotionPaths2);
      return;
    }
    initPath(paramKeyPosition, paramMotionPaths1, paramMotionPaths2);
  }
  
  private boolean diff(float paramFloat1, float paramFloat2)
  {
    if ((!Float.isNaN(paramFloat1)) && (!Float.isNaN(paramFloat2))) {
      return Math.abs(paramFloat1 - paramFloat2) > 1.0E-006F;
    }
    return Float.isNaN(paramFloat1) != Float.isNaN(paramFloat2);
  }
  
  private static final float xRotate(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    return (paramFloat5 - paramFloat3) * paramFloat2 - (paramFloat6 - paramFloat4) * paramFloat1 + paramFloat3;
  }
  
  private static final float yRotate(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    return (paramFloat5 - paramFloat3) * paramFloat1 + (paramFloat6 - paramFloat4) * paramFloat2 + paramFloat4;
  }
  
  public void applyParameters(ConstraintSet.Constraint paramConstraint)
  {
    this.mKeyFrameEasing = Easing.getInterpolator(paramConstraint.motion.mTransitionEasing);
    this.mPathMotionArc = paramConstraint.motion.mPathMotionArc;
    this.mPathRotate = paramConstraint.motion.mPathRotate;
    this.mDrawPath = paramConstraint.motion.mDrawPath;
    this.mProgress = paramConstraint.propertySet.mProgress;
    Iterator localIterator = paramConstraint.mCustomConstraints.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ConstraintAttribute localConstraintAttribute = (ConstraintAttribute)paramConstraint.mCustomConstraints.get(str);
      if (localConstraintAttribute.getType() != ConstraintAttribute.AttributeType.STRING_TYPE) {
        this.attributes.put(str, localConstraintAttribute);
      }
    }
  }
  
  public int compareTo(@NonNull MotionPaths paramMotionPaths)
  {
    return Float.compare(this.position, paramMotionPaths.position);
  }
  
  void different(MotionPaths paramMotionPaths, boolean[] paramArrayOfBoolean, String[] paramArrayOfString, boolean paramBoolean)
  {
    paramArrayOfBoolean[0] |= diff(this.position, paramMotionPaths.position);
    paramArrayOfBoolean[1] |= diff(this.x, paramMotionPaths.x) | paramBoolean;
    int i = paramArrayOfBoolean[2];
    paramArrayOfBoolean[2] = (paramBoolean | diff(this.y, paramMotionPaths.y) | i);
    paramArrayOfBoolean[3] |= diff(this.width, paramMotionPaths.width);
    paramBoolean = paramArrayOfBoolean[4];
    paramArrayOfBoolean[4] = (diff(this.height, paramMotionPaths.height) | paramBoolean);
  }
  
  void fillStandard(double[] paramArrayOfDouble, int[] paramArrayOfInt)
  {
    float[] arrayOfFloat = new float[6];
    float f = this.position;
    int i = 0;
    arrayOfFloat[0] = f;
    arrayOfFloat[1] = this.x;
    arrayOfFloat[2] = this.y;
    arrayOfFloat[3] = this.width;
    arrayOfFloat[4] = this.height;
    arrayOfFloat[5] = this.mPathRotate;
    int k;
    for (int j = 0; i < paramArrayOfInt.length; j = k)
    {
      k = j;
      if (paramArrayOfInt[i] < arrayOfFloat.length)
      {
        paramArrayOfDouble[j] = arrayOfFloat[paramArrayOfInt[i]];
        k = j + 1;
      }
      i += 1;
    }
  }
  
  void getBounds(int[] paramArrayOfInt, double[] paramArrayOfDouble, float[] paramArrayOfFloat, int paramInt)
  {
    float f1 = this.x;
    f1 = this.y;
    float f2 = this.width;
    f1 = this.height;
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      float f5 = (float)paramArrayOfDouble[i];
      int j = paramArrayOfInt[i];
      float f3 = f2;
      float f4 = f1;
      if (j != 1)
      {
        f3 = f2;
        f4 = f1;
        if (j != 2) {
          if (j != 3)
          {
            if (j != 4)
            {
              f3 = f2;
              f4 = f1;
            }
            else
            {
              f4 = f5;
              f3 = f2;
            }
          }
          else
          {
            f3 = f5;
            f4 = f1;
          }
        }
      }
      i += 1;
      f2 = f3;
      f1 = f4;
    }
    paramArrayOfFloat[paramInt] = f2;
    paramArrayOfFloat[(paramInt + 1)] = f1;
  }
  
  void getCenter(int[] paramArrayOfInt, double[] paramArrayOfDouble, float[] paramArrayOfFloat, int paramInt)
  {
    float f5 = this.x;
    float f4 = this.y;
    float f3 = this.width;
    float f2 = this.height;
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      float f1 = (float)paramArrayOfDouble[i];
      int j = paramArrayOfInt[i];
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3)
          {
            if (j == 4) {
              f2 = f1;
            }
          }
          else {
            f3 = f1;
          }
        }
        else {
          f4 = f1;
        }
      }
      else {
        f5 = f1;
      }
      i += 1;
    }
    paramArrayOfFloat[paramInt] = (f5 + f3 / 2.0F + 0.0F);
    paramArrayOfFloat[(paramInt + 1)] = (f4 + f2 / 2.0F + 0.0F);
  }
  
  int getCustomData(String paramString, double[] paramArrayOfDouble, int paramInt)
  {
    paramString = (ConstraintAttribute)this.attributes.get(paramString);
    if (paramString.noOfInterpValues() == 1)
    {
      paramArrayOfDouble[paramInt] = paramString.getValueToInterpolate();
      return 1;
    }
    int j = paramString.noOfInterpValues();
    float[] arrayOfFloat = new float[j];
    paramString.getValuesToInterpolate(arrayOfFloat);
    int i = 0;
    while (i < j)
    {
      paramArrayOfDouble[paramInt] = arrayOfFloat[i];
      i += 1;
      paramInt += 1;
    }
    return j;
  }
  
  int getCustomDataCount(String paramString)
  {
    return ((ConstraintAttribute)this.attributes.get(paramString)).noOfInterpValues();
  }
  
  void getRect(int[] paramArrayOfInt, double[] paramArrayOfDouble, float[] paramArrayOfFloat, int paramInt)
  {
    float f4 = this.x;
    float f3 = this.y;
    float f5 = this.width;
    float f2 = this.height;
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      f1 = (float)paramArrayOfDouble[i];
      int j = paramArrayOfInt[i];
      float f6 = f4;
      float f7 = f3;
      float f8 = f5;
      float f9 = f2;
      if (j != 0) {
        if (j != 1)
        {
          if (j != 2)
          {
            if (j != 3)
            {
              if (j != 4)
              {
                f6 = f4;
                f7 = f3;
                f8 = f5;
                f9 = f2;
              }
              else
              {
                f6 = f4;
                f7 = f3;
                f8 = f5;
                f9 = f1;
              }
            }
            else
            {
              f6 = f4;
              f7 = f3;
              f8 = f1;
              f9 = f2;
            }
          }
          else
          {
            f6 = f4;
            f7 = f1;
            f8 = f5;
            f9 = f2;
          }
        }
        else
        {
          f9 = f2;
          f8 = f5;
          f7 = f3;
          f6 = f1;
        }
      }
      i += 1;
      f4 = f6;
      f3 = f7;
      f5 = f8;
      f2 = f9;
    }
    float f1 = f5 + f4;
    f2 += f3;
    Float.isNaN((0.0F / 0.0F));
    Float.isNaN((0.0F / 0.0F));
    i = paramInt + 1;
    paramArrayOfFloat[paramInt] = (f4 + 0.0F);
    paramInt = i + 1;
    paramArrayOfFloat[i] = (f3 + 0.0F);
    i = paramInt + 1;
    paramArrayOfFloat[paramInt] = (f1 + 0.0F);
    paramInt = i + 1;
    paramArrayOfFloat[i] = (f3 + 0.0F);
    i = paramInt + 1;
    paramArrayOfFloat[paramInt] = (f1 + 0.0F);
    paramInt = i + 1;
    paramArrayOfFloat[i] = (f2 + 0.0F);
    paramArrayOfFloat[paramInt] = (f4 + 0.0F);
    paramArrayOfFloat[(paramInt + 1)] = (f2 + 0.0F);
  }
  
  boolean hasCustomData(String paramString)
  {
    return this.attributes.containsKey(paramString);
  }
  
  void initCartesian(KeyPosition paramKeyPosition, MotionPaths paramMotionPaths1, MotionPaths paramMotionPaths2)
  {
    float f1 = paramKeyPosition.mFramePosition / 100.0F;
    this.time = f1;
    this.mDrawPath = paramKeyPosition.mDrawPath;
    if (Float.isNaN(paramKeyPosition.mPercentWidth)) {
      f2 = f1;
    } else {
      f2 = paramKeyPosition.mPercentWidth;
    }
    if (Float.isNaN(paramKeyPosition.mPercentHeight)) {
      f3 = f1;
    } else {
      f3 = paramKeyPosition.mPercentHeight;
    }
    float f7 = paramMotionPaths2.width;
    float f4 = paramMotionPaths1.width;
    float f10 = paramMotionPaths2.height;
    float f8 = paramMotionPaths1.height;
    this.position = this.time;
    float f11 = paramMotionPaths1.x;
    float f5 = f4 / 2.0F;
    float f9 = paramMotionPaths1.y;
    float f6 = f8 / 2.0F;
    float f14 = paramMotionPaths2.x;
    float f15 = f7 / 2.0F;
    float f12 = paramMotionPaths2.y;
    float f13 = f10 / 2.0F;
    f5 = f14 + f15 - (f5 + f11);
    f6 = f12 + f13 - (f9 + f6);
    float f2 = (f7 - f4) * f2;
    f7 = f2 / 2.0F;
    this.x = ((int)(f11 + f5 * f1 - f7));
    float f3 = (f10 - f8) * f3;
    f10 = f3 / 2.0F;
    this.y = ((int)(f9 + f6 * f1 - f10));
    this.width = ((int)(f4 + f2));
    this.height = ((int)(f8 + f3));
    if (Float.isNaN(paramKeyPosition.mPercentX)) {
      f2 = f1;
    } else {
      f2 = paramKeyPosition.mPercentX;
    }
    boolean bool = Float.isNaN(paramKeyPosition.mAltPercentY);
    f4 = 0.0F;
    if (bool) {
      f3 = 0.0F;
    } else {
      f3 = paramKeyPosition.mAltPercentY;
    }
    if (!Float.isNaN(paramKeyPosition.mPercentY)) {
      f1 = paramKeyPosition.mPercentY;
    }
    if (!Float.isNaN(paramKeyPosition.mAltPercentX)) {
      f4 = paramKeyPosition.mAltPercentX;
    }
    this.mMode = 2;
    this.x = ((int)(paramMotionPaths1.x + f2 * f5 + f4 * f6 - f7));
    this.y = ((int)(paramMotionPaths1.y + f5 * f3 + f6 * f1 - f10));
    this.mKeyFrameEasing = Easing.getInterpolator(paramKeyPosition.mTransitionEasing);
    this.mPathMotionArc = paramKeyPosition.mPathMotionArc;
  }
  
  void initPath(KeyPosition paramKeyPosition, MotionPaths paramMotionPaths1, MotionPaths paramMotionPaths2)
  {
    float f1 = paramKeyPosition.mFramePosition / 100.0F;
    this.time = f1;
    this.mDrawPath = paramKeyPosition.mDrawPath;
    if (Float.isNaN(paramKeyPosition.mPercentWidth)) {
      f3 = f1;
    } else {
      f3 = paramKeyPosition.mPercentWidth;
    }
    if (Float.isNaN(paramKeyPosition.mPercentHeight)) {
      f2 = f1;
    } else {
      f2 = paramKeyPosition.mPercentHeight;
    }
    float f11 = paramMotionPaths2.width;
    float f12 = paramMotionPaths1.width;
    float f5 = paramMotionPaths2.height;
    float f6 = paramMotionPaths1.height;
    this.position = this.time;
    if (!Float.isNaN(paramKeyPosition.mPercentX)) {
      f1 = paramKeyPosition.mPercentX;
    }
    float f13 = paramMotionPaths1.x;
    float f7 = paramMotionPaths1.width;
    float f4 = f7 / 2.0F;
    float f8 = paramMotionPaths1.y;
    float f9 = paramMotionPaths1.height;
    float f10 = f9 / 2.0F;
    float f16 = paramMotionPaths2.x;
    float f17 = paramMotionPaths2.width / 2.0F;
    float f14 = paramMotionPaths2.y;
    float f15 = paramMotionPaths2.height / 2.0F;
    f4 = f16 + f17 - (f4 + f13);
    f14 = f14 + f15 - (f10 + f8);
    f10 = f4 * f1;
    f12 = (f11 - f12) * f3;
    float f3 = f12 / 2.0F;
    this.x = ((int)(f13 + f10 - f3));
    f11 = f1 * f14;
    f1 = (f5 - f6) * f2;
    float f2 = f1 / 2.0F;
    this.y = ((int)(f8 + f11 - f2));
    this.width = ((int)(f7 + f12));
    this.height = ((int)(f9 + f1));
    if (Float.isNaN(paramKeyPosition.mPercentY)) {
      f1 = 0.0F;
    } else {
      f1 = paramKeyPosition.mPercentY;
    }
    f5 = -f14;
    this.mMode = 1;
    this.x = ((int)(paramMotionPaths1.x + f10 - f3));
    this.y = ((int)(paramMotionPaths1.y + f11 - f2));
    this.x += f5 * f1;
    this.y += f4 * f1;
    this.mKeyFrameEasing = Easing.getInterpolator(paramKeyPosition.mTransitionEasing);
    this.mPathMotionArc = paramKeyPosition.mPathMotionArc;
  }
  
  void initScreen(int paramInt1, int paramInt2, KeyPosition paramKeyPosition, MotionPaths paramMotionPaths1, MotionPaths paramMotionPaths2)
  {
    float f1 = paramKeyPosition.mFramePosition / 100.0F;
    this.time = f1;
    this.mDrawPath = paramKeyPosition.mDrawPath;
    if (Float.isNaN(paramKeyPosition.mPercentWidth)) {
      f2 = f1;
    } else {
      f2 = paramKeyPosition.mPercentWidth;
    }
    if (Float.isNaN(paramKeyPosition.mPercentHeight)) {
      f3 = f1;
    } else {
      f3 = paramKeyPosition.mPercentHeight;
    }
    float f15 = paramMotionPaths2.width;
    float f4 = paramMotionPaths1.width;
    float f10 = paramMotionPaths2.height;
    float f5 = paramMotionPaths1.height;
    this.position = this.time;
    float f11 = paramMotionPaths1.x;
    float f12 = f4 / 2.0F;
    float f6 = paramMotionPaths1.y;
    float f7 = f5 / 2.0F;
    float f13 = paramMotionPaths2.x;
    float f14 = f15 / 2.0F;
    float f8 = paramMotionPaths2.y;
    float f9 = f10 / 2.0F;
    float f2 = (f15 - f4) * f2;
    this.x = ((int)(f11 + (f13 + f14 - (f12 + f11)) * f1 - f2 / 2.0F));
    float f3 = (f10 - f5) * f3;
    this.y = ((int)(f6 + (f8 + f9 - (f6 + f7)) * f1 - f3 / 2.0F));
    this.width = ((int)(f4 + f2));
    this.height = ((int)(f5 + f3));
    this.mMode = 3;
    if (!Float.isNaN(paramKeyPosition.mPercentX))
    {
      paramInt1 = (int)(paramInt1 - this.width);
      this.x = ((int)(paramKeyPosition.mPercentX * paramInt1));
    }
    if (!Float.isNaN(paramKeyPosition.mPercentY))
    {
      paramInt1 = (int)(paramInt2 - this.height);
      this.y = ((int)(paramKeyPosition.mPercentY * paramInt1));
    }
    this.mKeyFrameEasing = Easing.getInterpolator(paramKeyPosition.mTransitionEasing);
    this.mPathMotionArc = paramKeyPosition.mPathMotionArc;
  }
  
  void setBounds(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.width = paramFloat3;
    this.height = paramFloat4;
  }
  
  void setDpDt(float paramFloat1, float paramFloat2, float[] paramArrayOfFloat, int[] paramArrayOfInt, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    int i = 0;
    float f5 = 0.0F;
    float f3 = 0.0F;
    float f4 = 0.0F;
    float f9;
    for (float f2 = 0.0F; i < paramArrayOfInt.length; f2 = f9)
    {
      f1 = (float)paramArrayOfDouble1[i];
      double d = paramArrayOfDouble2[i];
      int j = paramArrayOfInt[i];
      float f6 = f5;
      float f7 = f3;
      float f8 = f4;
      f9 = f2;
      if (j != 0) {
        if (j != 1)
        {
          if (j != 2)
          {
            if (j != 3)
            {
              if (j != 4)
              {
                f6 = f5;
                f7 = f3;
                f8 = f4;
                f9 = f2;
              }
              else
              {
                f6 = f5;
                f7 = f3;
                f8 = f4;
                f9 = f1;
              }
            }
            else
            {
              f6 = f5;
              f7 = f1;
              f8 = f4;
              f9 = f2;
            }
          }
          else
          {
            f6 = f5;
            f7 = f3;
            f8 = f1;
            f9 = f2;
          }
        }
        else
        {
          f9 = f2;
          f8 = f4;
          f7 = f3;
          f6 = f1;
        }
      }
      i += 1;
      f5 = f6;
      f3 = f7;
      f4 = f8;
    }
    float f1 = f5 - 0.0F * f3 / 2.0F;
    f4 -= 0.0F * f2 / 2.0F;
    paramArrayOfFloat[0] = (f1 * (1.0F - paramFloat1) + (f3 * 1.0F + f1) * paramFloat1 + 0.0F);
    paramArrayOfFloat[1] = (f4 * (1.0F - paramFloat2) + (f2 * 1.0F + f4) * paramFloat2 + 0.0F);
  }
  
  void setView(View paramView, int[] paramArrayOfInt, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double[] paramArrayOfDouble3)
  {
    float f6 = this.x;
    float f5 = this.y;
    float f4 = this.width;
    float f3 = this.height;
    if ((paramArrayOfInt.length != 0) && (this.mTempValue.length <= paramArrayOfInt[(paramArrayOfInt.length - 1)]))
    {
      i = paramArrayOfInt[(paramArrayOfInt.length - 1)] + 1;
      this.mTempValue = new double[i];
      this.mTempDelta = new double[i];
    }
    Arrays.fill(this.mTempValue, (0.0D / 0.0D));
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      this.mTempValue[paramArrayOfInt[i]] = paramArrayOfDouble1[i];
      this.mTempDelta[paramArrayOfInt[i]] = paramArrayOfDouble2[i];
      i += 1;
    }
    float f19 = (0.0F / 0.0F);
    i = 0;
    float f9 = (0.0F / 0.0F);
    float f10 = 0.0F;
    float f11 = 0.0F;
    float f7 = 0.0F;
    float f8 = 0.0F;
    double d1;
    for (;;)
    {
      paramArrayOfInt = this.mTempValue;
      if (i >= paramArrayOfInt.length) {
        break;
      }
      boolean bool = Double.isNaN(paramArrayOfInt[i]);
      d1 = 0.0D;
      float f12;
      float f13;
      float f14;
      float f15;
      float f16;
      float f17;
      float f18;
      if (bool)
      {
        f1 = f9;
        f2 = f10;
        f12 = f11;
        f13 = f7;
        f14 = f8;
        f15 = f6;
        f16 = f5;
        f17 = f4;
        f18 = f3;
        if (paramArrayOfDouble3 == null) {
          break label619;
        }
        if (paramArrayOfDouble3[i] == 0.0D)
        {
          f1 = f9;
          f2 = f10;
          f12 = f11;
          f13 = f7;
          f14 = f8;
          f15 = f6;
          f16 = f5;
          f17 = f4;
          f18 = f3;
          break label619;
        }
      }
      if (paramArrayOfDouble3 != null) {
        d1 = paramArrayOfDouble3[i];
      }
      if (!Double.isNaN(this.mTempValue[i])) {
        d1 = this.mTempValue[i] + d1;
      }
      f1 = (float)d1;
      f2 = (float)this.mTempDelta[i];
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4)
              {
                if (i != 5)
                {
                  f1 = f9;
                  f2 = f10;
                  f12 = f11;
                  f13 = f7;
                  f14 = f8;
                  f15 = f6;
                  f16 = f5;
                  f17 = f4;
                  f18 = f3;
                }
                else
                {
                  f2 = f10;
                  f12 = f11;
                  f13 = f7;
                  f14 = f8;
                  f15 = f6;
                  f16 = f5;
                  f17 = f4;
                  f18 = f3;
                }
              }
              else
              {
                f14 = f2;
                f18 = f1;
                f1 = f9;
                f2 = f10;
                f12 = f11;
                f13 = f7;
                f15 = f6;
                f16 = f5;
                f17 = f4;
              }
            }
            else
            {
              f12 = f2;
              f17 = f1;
              f1 = f9;
              f2 = f10;
              f13 = f7;
              f14 = f8;
              f15 = f6;
              f16 = f5;
              f18 = f3;
            }
          }
          else
          {
            f13 = f2;
            f16 = f1;
            f1 = f9;
            f2 = f10;
            f12 = f11;
            f14 = f8;
            f15 = f6;
            f17 = f4;
            f18 = f3;
          }
        }
        else
        {
          f15 = f1;
          f1 = f9;
          f12 = f11;
          f13 = f7;
          f14 = f8;
          f16 = f5;
          f17 = f4;
          f18 = f3;
        }
      }
      else
      {
        f18 = f3;
        f17 = f4;
        f16 = f5;
        f15 = f6;
        f14 = f8;
        f13 = f7;
        f12 = f11;
        f2 = f10;
        f1 = f9;
      }
      label619:
      i += 1;
      f9 = f1;
      f10 = f2;
      f11 = f12;
      f7 = f13;
      f8 = f14;
      f6 = f15;
      f5 = f16;
      f4 = f17;
      f3 = f18;
    }
    if (Float.isNaN(f9))
    {
      if (!Float.isNaN((0.0F / 0.0F))) {
        paramView.setRotation((0.0F / 0.0F));
      }
    }
    else
    {
      f1 = f19;
      if (Float.isNaN((0.0F / 0.0F))) {
        f1 = 0.0F;
      }
      f2 = f11 / 2.0F;
      f8 /= 2.0F;
      d1 = f1;
      double d2 = f9;
      double d3 = Math.toDegrees(Math.atan2(f7 + f8, f10 + f2));
      Double.isNaN(d2);
      Double.isNaN(d1);
      paramView.setRotation((float)(d1 + (d2 + d3)));
    }
    float f1 = f6 + 0.5F;
    int j = (int)f1;
    float f2 = f5 + 0.5F;
    int k = (int)f2;
    int m = (int)(f1 + f4);
    int n = (int)(f2 + f3);
    int i1 = m - j;
    int i2 = n - k;
    if ((i1 == paramView.getMeasuredWidth()) && (i2 == paramView.getMeasuredHeight())) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      paramView.measure(View.MeasureSpec.makeMeasureSpec(i1, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
    }
    paramView.layout(j, k, m, n);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.MotionPaths
 * JD-Core Version:    0.7.0.1
 */