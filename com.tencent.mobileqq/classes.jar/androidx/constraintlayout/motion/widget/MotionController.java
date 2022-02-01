package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.utils.VelocityMatrix;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.ConstraintSet.Constraint;
import androidx.constraintlayout.widget.ConstraintSet.Motion;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class MotionController
{
  private static final boolean DEBUG = false;
  public static final int DRAW_PATH_AS_CONFIGURED = 4;
  public static final int DRAW_PATH_BASIC = 1;
  public static final int DRAW_PATH_CARTESIAN = 3;
  public static final int DRAW_PATH_NONE = 0;
  public static final int DRAW_PATH_RECTANGLE = 5;
  public static final int DRAW_PATH_RELATIVE = 2;
  public static final int DRAW_PATH_SCREEN = 6;
  private static final boolean FAVOR_FIXED_SIZE_VIEWS = false;
  public static final int HORIZONTAL_PATH_X = 2;
  public static final int HORIZONTAL_PATH_Y = 3;
  public static final int PATH_PERCENT = 0;
  public static final int PATH_PERPENDICULAR = 1;
  private static final String TAG = "MotionController";
  public static final int VERTICAL_PATH_X = 4;
  public static final int VERTICAL_PATH_Y = 5;
  private int MAX_DIMENSION = 4;
  String[] attributeTable;
  private CurveFit mArcSpline;
  private int[] mAttributeInterpCount;
  private String[] mAttributeNames;
  private HashMap<String, SplineSet> mAttributesMap;
  String mConstraintTag;
  private int mCurveFitType = -1;
  private HashMap<String, KeyCycleOscillator> mCycleMap;
  private MotionPaths mEndMotionPath = new MotionPaths();
  private MotionConstrainedPoint mEndPoint = new MotionConstrainedPoint();
  int mId;
  private double[] mInterpolateData;
  private int[] mInterpolateVariables;
  private double[] mInterpolateVelocity;
  private ArrayList<Key> mKeyList = new ArrayList();
  private KeyTrigger[] mKeyTriggers;
  private ArrayList<MotionPaths> mMotionPaths = new ArrayList();
  float mMotionStagger = (0.0F / 0.0F);
  private int mPathMotionArc = Key.UNSET;
  private CurveFit[] mSpline;
  float mStaggerOffset = 0.0F;
  float mStaggerScale = 1.0F;
  private MotionPaths mStartMotionPath = new MotionPaths();
  private MotionConstrainedPoint mStartPoint = new MotionConstrainedPoint();
  private HashMap<String, TimeCycleSplineSet> mTimeCycleAttributesMap;
  private float[] mValuesBuff = new float[this.MAX_DIMENSION];
  private float[] mVelocity = new float[1];
  View mView;
  
  MotionController(View paramView)
  {
    setView(paramView);
  }
  
  private float getAdjustedPosition(float paramFloat, float[] paramArrayOfFloat)
  {
    float f3 = 0.0F;
    float f4 = 1.0F;
    float f1;
    if (paramArrayOfFloat != null)
    {
      paramArrayOfFloat[0] = 1.0F;
      f1 = paramFloat;
    }
    else
    {
      f1 = paramFloat;
      if (this.mStaggerScale != 1.0D)
      {
        f2 = paramFloat;
        if (paramFloat < this.mStaggerOffset) {
          f2 = 0.0F;
        }
        paramFloat = this.mStaggerOffset;
        f1 = f2;
        if (f2 > paramFloat)
        {
          f1 = f2;
          if (f2 < 1.0D) {
            f1 = (f2 - paramFloat) * this.mStaggerScale;
          }
        }
      }
    }
    Easing localEasing = this.mStartMotionPath.mKeyFrameEasing;
    paramFloat = (0.0F / 0.0F);
    Iterator localIterator = this.mMotionPaths.iterator();
    float f2 = f3;
    while (localIterator.hasNext())
    {
      MotionPaths localMotionPaths = (MotionPaths)localIterator.next();
      if (localMotionPaths.mKeyFrameEasing != null) {
        if (localMotionPaths.time < f1)
        {
          localEasing = localMotionPaths.mKeyFrameEasing;
          f2 = localMotionPaths.time;
        }
        else if (Float.isNaN(paramFloat))
        {
          paramFloat = localMotionPaths.time;
        }
      }
    }
    f3 = f1;
    if (localEasing != null)
    {
      if (Float.isNaN(paramFloat)) {
        paramFloat = f4;
      }
      paramFloat -= f2;
      double d = (f1 - f2) / paramFloat;
      paramFloat = (float)localEasing.get(d) * paramFloat + f2;
      f3 = paramFloat;
      if (paramArrayOfFloat != null)
      {
        paramArrayOfFloat[0] = ((float)localEasing.getDiff(d));
        f3 = paramFloat;
      }
    }
    return f3;
  }
  
  private float getPreCycleDistance()
  {
    float[] arrayOfFloat = new float[2];
    float f5 = 1.0F / 99;
    double d1 = 0.0D;
    double d2 = d1;
    int i = 0;
    float f1;
    for (float f2 = 0.0F; i < 100; f2 = f1)
    {
      float f6 = i * f5;
      double d3 = f6;
      Easing localEasing = this.mStartMotionPath.mKeyFrameEasing;
      f1 = (0.0F / 0.0F);
      Iterator localIterator = this.mMotionPaths.iterator();
      float f3 = 0.0F;
      while (localIterator.hasNext())
      {
        MotionPaths localMotionPaths = (MotionPaths)localIterator.next();
        if (localMotionPaths.mKeyFrameEasing != null) {
          if (localMotionPaths.time < f6)
          {
            localEasing = localMotionPaths.mKeyFrameEasing;
            f3 = localMotionPaths.time;
          }
          else if (Float.isNaN(f1))
          {
            f1 = localMotionPaths.time;
          }
        }
      }
      if (localEasing != null)
      {
        float f4 = f1;
        if (Float.isNaN(f1)) {
          f4 = 1.0F;
        }
        f1 = f4 - f3;
        d3 = (float)localEasing.get((f6 - f3) / f1) * f1 + f3;
      }
      this.mSpline[0].getPos(d3, this.mInterpolateData);
      this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, arrayOfFloat, 0);
      f1 = f2;
      if (i > 0)
      {
        d3 = f2;
        double d4 = arrayOfFloat[1];
        Double.isNaN(d4);
        double d5 = arrayOfFloat[0];
        Double.isNaN(d5);
        d1 = Math.hypot(d2 - d4, d1 - d5);
        Double.isNaN(d3);
        f1 = (float)(d3 + d1);
      }
      d1 = arrayOfFloat[0];
      d2 = arrayOfFloat[1];
      i += 1;
    }
    return f2;
  }
  
  private void insertKey(MotionPaths paramMotionPaths)
  {
    int i = Collections.binarySearch(this.mMotionPaths, paramMotionPaths);
    if (i == 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" KeyPath positon \"");
      localStringBuilder.append(paramMotionPaths.position);
      localStringBuilder.append("\" outside of range");
      Log.e("MotionController", localStringBuilder.toString());
    }
    this.mMotionPaths.add(-i - 1, paramMotionPaths);
  }
  
  private void readView(MotionPaths paramMotionPaths)
  {
    paramMotionPaths.setBounds((int)this.mView.getX(), (int)this.mView.getY(), this.mView.getWidth(), this.mView.getHeight());
  }
  
  void addKey(Key paramKey)
  {
    this.mKeyList.add(paramKey);
  }
  
  void addKeys(ArrayList<Key> paramArrayList)
  {
    this.mKeyList.addAll(paramArrayList);
  }
  
  void buildBounds(float[] paramArrayOfFloat, int paramInt)
  {
    float f5 = 1.0F / (paramInt - 1);
    Object localObject1 = this.mAttributesMap;
    if (localObject1 != null) {
      localObject1 = (SplineSet)((HashMap)localObject1).get("translationX");
    }
    localObject1 = this.mAttributesMap;
    if (localObject1 != null) {
      localObject1 = (SplineSet)((HashMap)localObject1).get("translationY");
    }
    localObject1 = this.mCycleMap;
    if (localObject1 != null) {
      localObject1 = (KeyCycleOscillator)((HashMap)localObject1).get("translationX");
    }
    localObject1 = this.mCycleMap;
    if (localObject1 != null) {
      localObject1 = (KeyCycleOscillator)((HashMap)localObject1).get("translationY");
    }
    int i = 0;
    while (i < paramInt)
    {
      float f3 = i * f5;
      float f2 = this.mStaggerScale;
      float f4 = 0.0F;
      float f1 = f3;
      if (f2 != 1.0F)
      {
        f2 = f3;
        if (f3 < this.mStaggerOffset) {
          f2 = 0.0F;
        }
        f3 = this.mStaggerOffset;
        f1 = f2;
        if (f2 > f3)
        {
          f1 = f2;
          if (f2 < 1.0D) {
            f1 = (f2 - f3) * this.mStaggerScale;
          }
        }
      }
      double d = f1;
      localObject1 = this.mStartMotionPath.mKeyFrameEasing;
      f2 = (0.0F / 0.0F);
      Object localObject2 = this.mMotionPaths.iterator();
      f3 = f4;
      while (((Iterator)localObject2).hasNext())
      {
        MotionPaths localMotionPaths = (MotionPaths)((Iterator)localObject2).next();
        if (localMotionPaths.mKeyFrameEasing != null) {
          if (localMotionPaths.time < f1)
          {
            localObject1 = localMotionPaths.mKeyFrameEasing;
            f3 = localMotionPaths.time;
          }
          else if (Float.isNaN(f2))
          {
            f2 = localMotionPaths.time;
          }
        }
      }
      if (localObject1 != null)
      {
        f4 = f2;
        if (Float.isNaN(f2)) {
          f4 = 1.0F;
        }
        f2 = f4 - f3;
        d = (float)((Easing)localObject1).get((f1 - f3) / f2) * f2 + f3;
      }
      this.mSpline[0].getPos(d, this.mInterpolateData);
      localObject1 = this.mArcSpline;
      if (localObject1 != null)
      {
        localObject2 = this.mInterpolateData;
        if (localObject2.length > 0) {
          ((CurveFit)localObject1).getPos(d, (double[])localObject2);
        }
      }
      this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, paramArrayOfFloat, i * 2);
      i += 1;
    }
  }
  
  int buildKeyBounds(float[] paramArrayOfFloat, int[] paramArrayOfInt)
  {
    if (paramArrayOfFloat != null)
    {
      double[] arrayOfDouble = this.mSpline[0].getTimePoints();
      if (paramArrayOfInt != null)
      {
        Iterator localIterator = this.mMotionPaths.iterator();
        i = 0;
        while (localIterator.hasNext())
        {
          paramArrayOfInt[i] = ((MotionPaths)localIterator.next()).mMode;
          i += 1;
        }
      }
      int i = 0;
      int j = 0;
      while (i < arrayOfDouble.length)
      {
        this.mSpline[0].getPos(arrayOfDouble[i], this.mInterpolateData);
        this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, paramArrayOfFloat, j);
        j += 2;
        i += 1;
      }
      return j / 2;
    }
    return 0;
  }
  
  int buildKeyFrames(float[] paramArrayOfFloat, int[] paramArrayOfInt)
  {
    if (paramArrayOfFloat != null)
    {
      double[] arrayOfDouble = this.mSpline[0].getTimePoints();
      if (paramArrayOfInt != null)
      {
        Iterator localIterator = this.mMotionPaths.iterator();
        i = 0;
        while (localIterator.hasNext())
        {
          paramArrayOfInt[i] = ((MotionPaths)localIterator.next()).mMode;
          i += 1;
        }
      }
      int i = 0;
      int j = 0;
      while (i < arrayOfDouble.length)
      {
        this.mSpline[0].getPos(arrayOfDouble[i], this.mInterpolateData);
        this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, paramArrayOfFloat, j);
        j += 2;
        i += 1;
      }
      return j / 2;
    }
    return 0;
  }
  
  void buildPath(float[] paramArrayOfFloat, int paramInt)
  {
    float f6 = 1.0F / (paramInt - 1);
    Object localObject1 = this.mAttributesMap;
    KeyCycleOscillator localKeyCycleOscillator = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = (SplineSet)((HashMap)localObject1).get("translationX");
    }
    Object localObject2 = this.mAttributesMap;
    if (localObject2 == null) {
      localObject2 = null;
    } else {
      localObject2 = (SplineSet)((HashMap)localObject2).get("translationY");
    }
    Object localObject3 = this.mCycleMap;
    if (localObject3 == null) {
      localObject3 = null;
    } else {
      localObject3 = (KeyCycleOscillator)((HashMap)localObject3).get("translationX");
    }
    Object localObject4 = this.mCycleMap;
    if (localObject4 != null) {
      localKeyCycleOscillator = (KeyCycleOscillator)((HashMap)localObject4).get("translationY");
    }
    int i = 0;
    while (i < paramInt)
    {
      float f3 = i * f6;
      float f2 = this.mStaggerScale;
      float f4 = 0.0F;
      float f1 = f3;
      if (f2 != 1.0F)
      {
        f2 = f3;
        if (f3 < this.mStaggerOffset) {
          f2 = 0.0F;
        }
        f3 = this.mStaggerOffset;
        f1 = f2;
        if (f2 > f3)
        {
          f1 = f2;
          if (f2 < 1.0D) {
            f1 = (f2 - f3) * this.mStaggerScale;
          }
        }
      }
      double d = f1;
      localObject4 = this.mStartMotionPath.mKeyFrameEasing;
      f2 = (0.0F / 0.0F);
      Object localObject6 = this.mMotionPaths.iterator();
      f3 = f4;
      while (((Iterator)localObject6).hasNext())
      {
        MotionPaths localMotionPaths = (MotionPaths)((Iterator)localObject6).next();
        localObject5 = localObject4;
        f4 = f3;
        float f5 = f2;
        if (localMotionPaths.mKeyFrameEasing != null) {
          if (localMotionPaths.time < f1)
          {
            localObject5 = localMotionPaths.mKeyFrameEasing;
            f4 = localMotionPaths.time;
            f5 = f2;
          }
          else
          {
            localObject5 = localObject4;
            f4 = f3;
            f5 = f2;
            if (Float.isNaN(f2))
            {
              f5 = localMotionPaths.time;
              f4 = f3;
              localObject5 = localObject4;
            }
          }
        }
        localObject4 = localObject5;
        f3 = f4;
        f2 = f5;
      }
      if (localObject4 != null)
      {
        f4 = f2;
        if (Float.isNaN(f2)) {
          f4 = 1.0F;
        }
        f2 = f4 - f3;
        d = (float)((Easing)localObject4).get((f1 - f3) / f2) * f2 + f3;
      }
      this.mSpline[0].getPos(d, this.mInterpolateData);
      localObject4 = this.mArcSpline;
      if (localObject4 != null)
      {
        localObject5 = this.mInterpolateData;
        if (localObject5.length > 0) {
          ((CurveFit)localObject4).getPos(d, (double[])localObject5);
        }
      }
      localObject4 = this.mStartMotionPath;
      Object localObject5 = this.mInterpolateVariables;
      localObject6 = this.mInterpolateData;
      int j = i * 2;
      ((MotionPaths)localObject4).getCenter((int[])localObject5, (double[])localObject6, paramArrayOfFloat, j);
      if (localObject3 != null) {
        paramArrayOfFloat[j] += ((KeyCycleOscillator)localObject3).get(f1);
      } else if (localObject1 != null) {
        paramArrayOfFloat[j] += ((SplineSet)localObject1).get(f1);
      }
      if (localKeyCycleOscillator != null)
      {
        j += 1;
        paramArrayOfFloat[j] += localKeyCycleOscillator.get(f1);
      }
      else if (localObject2 != null)
      {
        j += 1;
        paramArrayOfFloat[j] += ((SplineSet)localObject2).get(f1);
      }
      i += 1;
    }
  }
  
  void buildRect(float paramFloat, float[] paramArrayOfFloat, int paramInt)
  {
    paramFloat = getAdjustedPosition(paramFloat, null);
    this.mSpline[0].getPos(paramFloat, this.mInterpolateData);
    this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, paramArrayOfFloat, paramInt);
  }
  
  void buildRectangles(float[] paramArrayOfFloat, int paramInt)
  {
    float f1 = 1.0F / (paramInt - 1);
    int i = 0;
    while (i < paramInt)
    {
      float f2 = getAdjustedPosition(i * f1, null);
      this.mSpline[0].getPos(f2, this.mInterpolateData);
      this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, paramArrayOfFloat, i * 8);
      i += 1;
    }
  }
  
  int getAttributeValues(String paramString, float[] paramArrayOfFloat, int paramInt)
  {
    paramString = (SplineSet)this.mAttributesMap.get(paramString);
    if (paramString == null) {
      return -1;
    }
    paramInt = 0;
    while (paramInt < paramArrayOfFloat.length)
    {
      paramArrayOfFloat[paramInt] = paramString.get(paramInt / (paramArrayOfFloat.length - 1));
      paramInt += 1;
    }
    return paramArrayOfFloat.length;
  }
  
  void getDpDt(float paramFloat1, float paramFloat2, float paramFloat3, float[] paramArrayOfFloat)
  {
    paramFloat1 = getAdjustedPosition(paramFloat1, this.mVelocity);
    Object localObject = this.mSpline;
    int i = 0;
    if (localObject != null)
    {
      localObject = localObject[0];
      double d1 = paramFloat1;
      ((CurveFit)localObject).getSlope(d1, this.mInterpolateVelocity);
      this.mSpline[0].getPos(d1, this.mInterpolateData);
      paramFloat1 = this.mVelocity[0];
      double[] arrayOfDouble;
      for (;;)
      {
        arrayOfDouble = this.mInterpolateVelocity;
        if (i >= arrayOfDouble.length) {
          break;
        }
        double d2 = arrayOfDouble[i];
        double d3 = paramFloat1;
        Double.isNaN(d3);
        arrayOfDouble[i] = (d2 * d3);
        i += 1;
      }
      localObject = this.mArcSpline;
      if (localObject != null)
      {
        arrayOfDouble = this.mInterpolateData;
        if (arrayOfDouble.length > 0)
        {
          ((CurveFit)localObject).getPos(d1, arrayOfDouble);
          this.mArcSpline.getSlope(d1, this.mInterpolateVelocity);
          this.mStartMotionPath.setDpDt(paramFloat2, paramFloat3, paramArrayOfFloat, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
        }
        return;
      }
      this.mStartMotionPath.setDpDt(paramFloat2, paramFloat3, paramArrayOfFloat, this.mInterpolateVariables, arrayOfDouble, this.mInterpolateData);
      return;
    }
    paramFloat1 = this.mEndMotionPath.x - this.mStartMotionPath.x;
    float f1 = this.mEndMotionPath.y - this.mStartMotionPath.y;
    float f2 = this.mEndMotionPath.width;
    float f3 = this.mStartMotionPath.width;
    float f4 = this.mEndMotionPath.height;
    float f5 = this.mStartMotionPath.height;
    paramArrayOfFloat[0] = (paramFloat1 * (1.0F - paramFloat2) + (f2 - f3 + paramFloat1) * paramFloat2);
    paramArrayOfFloat[1] = (f1 * (1.0F - paramFloat3) + (f4 - f5 + f1) * paramFloat3);
  }
  
  public int getDrawPath()
  {
    int i = this.mStartMotionPath.mDrawPath;
    Iterator localIterator = this.mMotionPaths.iterator();
    while (localIterator.hasNext()) {
      i = Math.max(i, ((MotionPaths)localIterator.next()).mDrawPath);
    }
    return Math.max(i, this.mEndMotionPath.mDrawPath);
  }
  
  float getFinalX()
  {
    return this.mEndMotionPath.x;
  }
  
  float getFinalY()
  {
    return this.mEndMotionPath.y;
  }
  
  MotionPaths getKeyFrame(int paramInt)
  {
    return (MotionPaths)this.mMotionPaths.get(paramInt);
  }
  
  public int getKeyFrameInfo(int paramInt, int[] paramArrayOfInt)
  {
    float[] arrayOfFloat = new float[2];
    Iterator localIterator = this.mKeyList.iterator();
    int i = 0;
    label20:
    int k;
    for (int j = 0; localIterator.hasNext(); j = k)
    {
      Object localObject = (Key)localIterator.next();
      if ((((Key)localObject).mType != paramInt) && (paramInt == -1)) {
        break label20;
      }
      paramArrayOfInt[j] = 0;
      k = j + 1;
      paramArrayOfInt[k] = ((Key)localObject).mType;
      k += 1;
      paramArrayOfInt[k] = ((Key)localObject).mFramePosition;
      float f = ((Key)localObject).mFramePosition / 100.0F;
      this.mSpline[0].getPos(f, this.mInterpolateData);
      this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, arrayOfFloat, 0);
      k += 1;
      paramArrayOfInt[k] = Float.floatToIntBits(arrayOfFloat[0]);
      int m = k + 1;
      paramArrayOfInt[m] = Float.floatToIntBits(arrayOfFloat[1]);
      k = m;
      if ((localObject instanceof KeyPosition))
      {
        localObject = (KeyPosition)localObject;
        k = m + 1;
        paramArrayOfInt[k] = ((KeyPosition)localObject).mPositionType;
        k += 1;
        paramArrayOfInt[k] = Float.floatToIntBits(((KeyPosition)localObject).mPercentX);
        k += 1;
        paramArrayOfInt[k] = Float.floatToIntBits(((KeyPosition)localObject).mPercentY);
      }
      k += 1;
      paramArrayOfInt[j] = (k - j);
      i += 1;
    }
    return i;
  }
  
  float getKeyFrameParameter(int paramInt, float paramFloat1, float paramFloat2)
  {
    float f1 = this.mEndMotionPath.x - this.mStartMotionPath.x;
    float f2 = this.mEndMotionPath.y - this.mStartMotionPath.y;
    float f6 = this.mStartMotionPath.x;
    float f7 = this.mStartMotionPath.width / 2.0F;
    float f4 = this.mStartMotionPath.y;
    float f5 = this.mStartMotionPath.height / 2.0F;
    float f3 = (float)Math.hypot(f1, f2);
    if (f3 < 1.0E-007D) {
      return (0.0F / 0.0F);
    }
    paramFloat1 -= f6 + f7;
    paramFloat2 -= f4 + f5;
    if ((float)Math.hypot(paramFloat1, paramFloat2) == 0.0F) {
      return 0.0F;
    }
    f4 = paramFloat1 * f1 + paramFloat2 * f2;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5) {
                return 0.0F;
              }
              return paramFloat2 / f2;
            }
            return paramFloat1 / f2;
          }
          return paramFloat2 / f1;
        }
        return paramFloat1 / f1;
      }
      return (float)Math.sqrt(f3 * f3 - f4 * f4);
    }
    return f4 / f3;
  }
  
  KeyPositionBase getPositionKeyframe(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    RectF localRectF1 = new RectF();
    localRectF1.left = this.mStartMotionPath.x;
    localRectF1.top = this.mStartMotionPath.y;
    localRectF1.right = (localRectF1.left + this.mStartMotionPath.width);
    localRectF1.bottom = (localRectF1.top + this.mStartMotionPath.height);
    RectF localRectF2 = new RectF();
    localRectF2.left = this.mEndMotionPath.x;
    localRectF2.top = this.mEndMotionPath.y;
    localRectF2.right = (localRectF2.left + this.mEndMotionPath.width);
    localRectF2.bottom = (localRectF2.top + this.mEndMotionPath.height);
    Iterator localIterator = this.mKeyList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Key)localIterator.next();
      if ((localObject instanceof KeyPositionBase))
      {
        localObject = (KeyPositionBase)localObject;
        if (((KeyPositionBase)localObject).intersects(paramInt1, paramInt2, localRectF1, localRectF2, paramFloat1, paramFloat2)) {
          return localObject;
        }
      }
    }
    return null;
  }
  
  void getPostLayoutDvDp(float paramFloat1, int paramInt1, int paramInt2, float paramFloat2, float paramFloat3, float[] paramArrayOfFloat)
  {
    paramFloat1 = getAdjustedPosition(paramFloat1, this.mVelocity);
    Object localObject1 = this.mAttributesMap;
    KeyCycleOscillator localKeyCycleOscillator = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = (SplineSet)((HashMap)localObject1).get("translationX");
    }
    Object localObject2 = this.mAttributesMap;
    if (localObject2 == null) {
      localObject2 = null;
    } else {
      localObject2 = (SplineSet)((HashMap)localObject2).get("translationY");
    }
    Object localObject3 = this.mAttributesMap;
    if (localObject3 == null) {
      localObject3 = null;
    } else {
      localObject3 = (SplineSet)((HashMap)localObject3).get("rotation");
    }
    Object localObject4 = this.mAttributesMap;
    if (localObject4 == null) {
      localObject4 = null;
    } else {
      localObject4 = (SplineSet)((HashMap)localObject4).get("scaleX");
    }
    Object localObject5 = this.mAttributesMap;
    if (localObject5 == null) {
      localObject5 = null;
    } else {
      localObject5 = (SplineSet)((HashMap)localObject5).get("scaleY");
    }
    Object localObject6 = this.mCycleMap;
    if (localObject6 == null) {
      localObject6 = null;
    } else {
      localObject6 = (KeyCycleOscillator)((HashMap)localObject6).get("translationX");
    }
    Object localObject7 = this.mCycleMap;
    if (localObject7 == null) {
      localObject7 = null;
    } else {
      localObject7 = (KeyCycleOscillator)((HashMap)localObject7).get("translationY");
    }
    Object localObject8 = this.mCycleMap;
    if (localObject8 == null) {
      localObject8 = null;
    } else {
      localObject8 = (KeyCycleOscillator)((HashMap)localObject8).get("rotation");
    }
    Object localObject9 = this.mCycleMap;
    if (localObject9 == null) {
      localObject9 = null;
    } else {
      localObject9 = (KeyCycleOscillator)((HashMap)localObject9).get("scaleX");
    }
    Object localObject10 = this.mCycleMap;
    if (localObject10 != null) {
      localKeyCycleOscillator = (KeyCycleOscillator)((HashMap)localObject10).get("scaleY");
    }
    localObject10 = new VelocityMatrix();
    ((VelocityMatrix)localObject10).clear();
    ((VelocityMatrix)localObject10).setRotationVelocity((SplineSet)localObject3, paramFloat1);
    ((VelocityMatrix)localObject10).setTranslationVelocity((SplineSet)localObject1, (SplineSet)localObject2, paramFloat1);
    ((VelocityMatrix)localObject10).setScaleVelocity((SplineSet)localObject4, (SplineSet)localObject5, paramFloat1);
    ((VelocityMatrix)localObject10).setRotationVelocity((KeyCycleOscillator)localObject8, paramFloat1);
    ((VelocityMatrix)localObject10).setTranslationVelocity((KeyCycleOscillator)localObject6, (KeyCycleOscillator)localObject7, paramFloat1);
    ((VelocityMatrix)localObject10).setScaleVelocity((KeyCycleOscillator)localObject9, localKeyCycleOscillator, paramFloat1);
    Object localObject11 = this.mArcSpline;
    double d1;
    if (localObject11 != null)
    {
      localObject1 = this.mInterpolateData;
      if (localObject1.length > 0)
      {
        d1 = paramFloat1;
        ((CurveFit)localObject11).getPos(d1, (double[])localObject1);
        this.mArcSpline.getSlope(d1, this.mInterpolateVelocity);
        this.mStartMotionPath.setDpDt(paramFloat2, paramFloat3, paramArrayOfFloat, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
      }
      ((VelocityMatrix)localObject10).applyTransform(paramFloat2, paramFloat3, paramInt1, paramInt2, paramArrayOfFloat);
      return;
    }
    localObject11 = this.mSpline;
    int i = 0;
    if (localObject11 != null)
    {
      paramFloat1 = getAdjustedPosition(paramFloat1, this.mVelocity);
      localObject1 = this.mSpline[0];
      d1 = paramFloat1;
      ((CurveFit)localObject1).getSlope(d1, this.mInterpolateVelocity);
      this.mSpline[0].getPos(d1, this.mInterpolateData);
      paramFloat1 = this.mVelocity[0];
      for (;;)
      {
        localObject1 = this.mInterpolateVelocity;
        if (i >= localObject1.length) {
          break;
        }
        d1 = localObject1[i];
        double d2 = paramFloat1;
        Double.isNaN(d2);
        localObject1[i] = (d1 * d2);
        i += 1;
      }
      this.mStartMotionPath.setDpDt(paramFloat2, paramFloat3, paramArrayOfFloat, this.mInterpolateVariables, (double[])localObject1, this.mInterpolateData);
      ((VelocityMatrix)localObject10).applyTransform(paramFloat2, paramFloat3, paramInt1, paramInt2, paramArrayOfFloat);
      return;
    }
    float f1 = this.mEndMotionPath.x - this.mStartMotionPath.x;
    float f2 = this.mEndMotionPath.y - this.mStartMotionPath.y;
    float f3 = this.mEndMotionPath.width;
    float f4 = this.mStartMotionPath.width;
    float f5 = this.mEndMotionPath.height;
    float f6 = this.mStartMotionPath.height;
    paramArrayOfFloat[0] = (f1 * (1.0F - paramFloat2) + (f3 - f4 + f1) * paramFloat2);
    paramArrayOfFloat[1] = (f2 * (1.0F - paramFloat3) + (f5 - f6 + f2) * paramFloat3);
    ((VelocityMatrix)localObject10).clear();
    ((VelocityMatrix)localObject10).setRotationVelocity((SplineSet)localObject3, paramFloat1);
    ((VelocityMatrix)localObject10).setTranslationVelocity((SplineSet)localObject1, (SplineSet)localObject2, paramFloat1);
    ((VelocityMatrix)localObject10).setScaleVelocity((SplineSet)localObject4, (SplineSet)localObject5, paramFloat1);
    ((VelocityMatrix)localObject10).setRotationVelocity((KeyCycleOscillator)localObject8, paramFloat1);
    ((VelocityMatrix)localObject10).setTranslationVelocity((KeyCycleOscillator)localObject6, (KeyCycleOscillator)localObject7, paramFloat1);
    ((VelocityMatrix)localObject10).setScaleVelocity((KeyCycleOscillator)localObject9, localKeyCycleOscillator, paramFloat1);
    ((VelocityMatrix)localObject10).applyTransform(paramFloat2, paramFloat3, paramInt1, paramInt2, paramArrayOfFloat);
  }
  
  float getStartX()
  {
    return this.mStartMotionPath.x;
  }
  
  float getStartY()
  {
    return this.mStartMotionPath.y;
  }
  
  public int getkeyFramePositions(int[] paramArrayOfInt, float[] paramArrayOfFloat)
  {
    Iterator localIterator = this.mKeyList.iterator();
    int i = 0;
    int j = 0;
    while (localIterator.hasNext())
    {
      Key localKey = (Key)localIterator.next();
      paramArrayOfInt[i] = (localKey.mFramePosition + localKey.mType * 1000);
      float f = localKey.mFramePosition / 100.0F;
      this.mSpline[0].getPos(f, this.mInterpolateData);
      this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, paramArrayOfFloat, j);
      j += 2;
      i += 1;
    }
    return i;
  }
  
  boolean interpolate(View paramView, float paramFloat, long paramLong, KeyCache paramKeyCache)
  {
    paramFloat = getAdjustedPosition(paramFloat, null);
    Object localObject1 = this.mAttributesMap;
    if (localObject1 != null)
    {
      localObject1 = ((HashMap)localObject1).values().iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((SplineSet)((Iterator)localObject1).next()).setProperty(paramView, paramFloat);
      }
    }
    localObject1 = this.mTimeCycleAttributesMap;
    boolean bool1;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject2 = ((HashMap)localObject1).values().iterator();
      localObject1 = null;
      bool1 = false;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (TimeCycleSplineSet)((Iterator)localObject2).next();
        if ((localObject3 instanceof TimeCycleSplineSet.PathRotate)) {
          localObject1 = (TimeCycleSplineSet.PathRotate)localObject3;
        } else {
          bool1 |= ((TimeCycleSplineSet)localObject3).setProperty(paramView, paramFloat, paramLong, paramKeyCache);
        }
      }
    }
    else
    {
      localObject1 = null;
      bool1 = false;
    }
    Object localObject2 = this.mSpline;
    int i;
    if (localObject2 != null)
    {
      localObject2 = localObject2[0];
      double d1 = paramFloat;
      ((CurveFit)localObject2).getPos(d1, this.mInterpolateData);
      this.mSpline[0].getSlope(d1, this.mInterpolateVelocity);
      localObject2 = this.mArcSpline;
      if (localObject2 != null)
      {
        localObject3 = this.mInterpolateData;
        if (localObject3.length > 0)
        {
          ((CurveFit)localObject2).getPos(d1, (double[])localObject3);
          this.mArcSpline.getSlope(d1, this.mInterpolateVelocity);
        }
      }
      this.mStartMotionPath.setView(paramView, this.mInterpolateVariables, this.mInterpolateData, this.mInterpolateVelocity, null);
      localObject2 = this.mAttributesMap;
      double d2 = d1;
      if (localObject2 != null)
      {
        localObject2 = ((HashMap)localObject2).values().iterator();
        for (;;)
        {
          d2 = d1;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject3 = (SplineSet)((Iterator)localObject2).next();
          if ((localObject3 instanceof SplineSet.PathRotate))
          {
            localObject3 = (SplineSet.PathRotate)localObject3;
            double[] arrayOfDouble = this.mInterpolateVelocity;
            ((SplineSet.PathRotate)localObject3).setPathRotate(paramView, paramFloat, arrayOfDouble[0], arrayOfDouble[1]);
          }
        }
      }
      boolean bool2 = bool1;
      if (localObject1 != null)
      {
        localObject2 = this.mInterpolateVelocity;
        bool2 = ((TimeCycleSplineSet.PathRotate)localObject1).setPathRotate(paramView, paramKeyCache, paramFloat, paramLong, localObject2[0], localObject2[1]) | bool1;
      }
      i = 1;
      for (;;)
      {
        paramKeyCache = this.mSpline;
        if (i >= paramKeyCache.length) {
          break;
        }
        paramKeyCache[i].getPos(d2, this.mValuesBuff);
        ((ConstraintAttribute)this.mStartMotionPath.attributes.get(this.mAttributeNames[(i - 1)])).setInterpolatedValue(paramView, this.mValuesBuff);
        i += 1;
      }
      if (this.mStartPoint.mVisibilityMode == 0) {
        if (paramFloat <= 0.0F) {
          paramView.setVisibility(this.mStartPoint.visibility);
        } else if (paramFloat >= 1.0F) {
          paramView.setVisibility(this.mEndPoint.visibility);
        } else if (this.mEndPoint.visibility != this.mStartPoint.visibility) {
          paramView.setVisibility(0);
        }
      }
      bool1 = bool2;
      if (this.mKeyTriggers != null)
      {
        i = 0;
        for (;;)
        {
          paramKeyCache = this.mKeyTriggers;
          bool1 = bool2;
          if (i >= paramKeyCache.length) {
            break;
          }
          paramKeyCache[i].conditionallyFire(paramFloat, paramView);
          i += 1;
        }
      }
    }
    else
    {
      float f10 = this.mStartMotionPath.x;
      float f11 = this.mEndMotionPath.x;
      float f12 = this.mStartMotionPath.x;
      float f7 = this.mStartMotionPath.y;
      float f8 = this.mEndMotionPath.y;
      float f9 = this.mStartMotionPath.y;
      float f1 = this.mStartMotionPath.width;
      float f2 = this.mEndMotionPath.width;
      float f3 = this.mStartMotionPath.width;
      float f4 = this.mStartMotionPath.height;
      float f5 = this.mEndMotionPath.height;
      float f6 = this.mStartMotionPath.height;
      f10 = f10 + (f11 - f12) * paramFloat + 0.5F;
      i = (int)f10;
      f7 = f7 + (f8 - f9) * paramFloat + 0.5F;
      int j = (int)f7;
      int k = (int)(f10 + (f1 + (f2 - f3) * paramFloat));
      int m = (int)(f7 + (f4 + (f5 - f6) * paramFloat));
      if ((this.mEndMotionPath.width != this.mStartMotionPath.width) || (this.mEndMotionPath.height != this.mStartMotionPath.height)) {
        paramView.measure(View.MeasureSpec.makeMeasureSpec(k - i, 1073741824), View.MeasureSpec.makeMeasureSpec(m - j, 1073741824));
      }
      paramView.layout(i, j, k, m);
    }
    paramKeyCache = this.mCycleMap;
    if (paramKeyCache != null)
    {
      paramKeyCache = paramKeyCache.values().iterator();
      while (paramKeyCache.hasNext())
      {
        localObject1 = (KeyCycleOscillator)paramKeyCache.next();
        if ((localObject1 instanceof KeyCycleOscillator.PathRotateSet))
        {
          localObject1 = (KeyCycleOscillator.PathRotateSet)localObject1;
          localObject2 = this.mInterpolateVelocity;
          ((KeyCycleOscillator.PathRotateSet)localObject1).setPathRotate(paramView, paramFloat, localObject2[0], localObject2[1]);
        }
        else
        {
          ((KeyCycleOscillator)localObject1).setProperty(paramView, paramFloat);
        }
      }
    }
    return bool1;
  }
  
  String name()
  {
    return this.mView.getContext().getResources().getResourceEntryName(this.mView.getId());
  }
  
  void positionKeyframe(View paramView, KeyPositionBase paramKeyPositionBase, float paramFloat1, float paramFloat2, String[] paramArrayOfString, float[] paramArrayOfFloat)
  {
    RectF localRectF1 = new RectF();
    localRectF1.left = this.mStartMotionPath.x;
    localRectF1.top = this.mStartMotionPath.y;
    localRectF1.right = (localRectF1.left + this.mStartMotionPath.width);
    localRectF1.bottom = (localRectF1.top + this.mStartMotionPath.height);
    RectF localRectF2 = new RectF();
    localRectF2.left = this.mEndMotionPath.x;
    localRectF2.top = this.mEndMotionPath.y;
    localRectF2.right = (localRectF2.left + this.mEndMotionPath.width);
    localRectF2.bottom = (localRectF2.top + this.mEndMotionPath.height);
    paramKeyPositionBase.positionAttributes(paramView, localRectF1, localRectF2, paramFloat1, paramFloat2, paramArrayOfString, paramArrayOfFloat);
  }
  
  public void setDrawPath(int paramInt)
  {
    this.mStartMotionPath.mDrawPath = paramInt;
  }
  
  void setEndState(ConstraintWidget paramConstraintWidget, ConstraintSet paramConstraintSet)
  {
    MotionPaths localMotionPaths = this.mEndMotionPath;
    localMotionPaths.time = 1.0F;
    localMotionPaths.position = 1.0F;
    readView(localMotionPaths);
    this.mEndMotionPath.setBounds(paramConstraintWidget.getX(), paramConstraintWidget.getY(), paramConstraintWidget.getWidth(), paramConstraintWidget.getHeight());
    this.mEndMotionPath.applyParameters(paramConstraintSet.getParameters(this.mId));
    this.mEndPoint.setState(paramConstraintWidget, paramConstraintSet, this.mId);
  }
  
  public void setPathMotionArc(int paramInt)
  {
    this.mPathMotionArc = paramInt;
  }
  
  void setStartCurrentState(View paramView)
  {
    MotionPaths localMotionPaths = this.mStartMotionPath;
    localMotionPaths.time = 0.0F;
    localMotionPaths.position = 0.0F;
    localMotionPaths.setBounds(paramView.getX(), paramView.getY(), paramView.getWidth(), paramView.getHeight());
    this.mStartPoint.setState(paramView);
  }
  
  void setStartState(ConstraintWidget paramConstraintWidget, ConstraintSet paramConstraintSet)
  {
    Object localObject = this.mStartMotionPath;
    ((MotionPaths)localObject).time = 0.0F;
    ((MotionPaths)localObject).position = 0.0F;
    readView((MotionPaths)localObject);
    this.mStartMotionPath.setBounds(paramConstraintWidget.getX(), paramConstraintWidget.getY(), paramConstraintWidget.getWidth(), paramConstraintWidget.getHeight());
    localObject = paramConstraintSet.getParameters(this.mId);
    this.mStartMotionPath.applyParameters((ConstraintSet.Constraint)localObject);
    this.mMotionStagger = ((ConstraintSet.Constraint)localObject).motion.mMotionStagger;
    this.mStartPoint.setState(paramConstraintWidget, paramConstraintSet, this.mId);
  }
  
  public void setView(View paramView)
  {
    this.mView = paramView;
    this.mId = paramView.getId();
    paramView = paramView.getLayoutParams();
    if ((paramView instanceof ConstraintLayout.LayoutParams)) {
      this.mConstraintTag = ((ConstraintLayout.LayoutParams)paramView).getConstraintTag();
    }
  }
  
  public void setup(int paramInt1, int paramInt2, float paramFloat, long paramLong)
  {
    new HashSet();
    Object localObject5 = new HashSet();
    Object localObject3 = new HashSet();
    HashSet localHashSet = new HashSet();
    Object localObject4 = new HashMap();
    if (this.mPathMotionArc != Key.UNSET) {
      this.mStartMotionPath.mPathMotionArc = this.mPathMotionArc;
    }
    this.mStartPoint.different(this.mEndPoint, (HashSet)localObject3);
    Object localObject1 = this.mKeyList;
    if (localObject1 != null)
    {
      localObject6 = ((ArrayList)localObject1).iterator();
      localObject1 = null;
      for (;;)
      {
        localObject2 = localObject1;
        if (!((Iterator)localObject6).hasNext()) {
          break;
        }
        localObject7 = (Key)((Iterator)localObject6).next();
        if ((localObject7 instanceof KeyPosition))
        {
          localObject2 = (KeyPosition)localObject7;
          insertKey(new MotionPaths(paramInt1, paramInt2, (KeyPosition)localObject2, this.mStartMotionPath, this.mEndMotionPath));
          if (((KeyPosition)localObject2).mCurveFit != Key.UNSET) {
            this.mCurveFitType = ((KeyPosition)localObject2).mCurveFit;
          }
        }
        else if ((localObject7 instanceof KeyCycle))
        {
          ((Key)localObject7).getAttributeNames(localHashSet);
        }
        else if ((localObject7 instanceof KeyTimeCycle))
        {
          ((Key)localObject7).getAttributeNames((HashSet)localObject5);
        }
        else if ((localObject7 instanceof KeyTrigger))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new ArrayList();
          }
          ((ArrayList)localObject2).add((KeyTrigger)localObject7);
          localObject1 = localObject2;
        }
        else
        {
          ((Key)localObject7).setInterpolation((HashMap)localObject4);
          ((Key)localObject7).getAttributeNames((HashSet)localObject3);
        }
      }
    }
    Object localObject2 = null;
    if (localObject2 != null) {
      this.mKeyTriggers = ((KeyTrigger[])((ArrayList)localObject2).toArray(new KeyTrigger[0]));
    }
    Object localObject8;
    Object localObject9;
    if (!((HashSet)localObject3).isEmpty())
    {
      this.mAttributesMap = new HashMap();
      localObject2 = ((HashSet)localObject3).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject6 = (String)((Iterator)localObject2).next();
        if (((String)localObject6).startsWith("CUSTOM,"))
        {
          localObject1 = new SparseArray();
          localObject7 = localObject6.split(",")[1];
          localObject8 = this.mKeyList.iterator();
          while (((Iterator)localObject8).hasNext())
          {
            localObject9 = (Key)((Iterator)localObject8).next();
            if (((Key)localObject9).mCustomConstraints != null)
            {
              ConstraintAttribute localConstraintAttribute = (ConstraintAttribute)((Key)localObject9).mCustomConstraints.get(localObject7);
              if (localConstraintAttribute != null) {
                ((SparseArray)localObject1).append(((Key)localObject9).mFramePosition, localConstraintAttribute);
              }
            }
          }
          localObject1 = SplineSet.makeCustomSpline((String)localObject6, (SparseArray)localObject1);
        }
        else
        {
          localObject1 = SplineSet.makeSpline((String)localObject6);
        }
        if (localObject1 != null)
        {
          ((SplineSet)localObject1).setType((String)localObject6);
          this.mAttributesMap.put(localObject6, localObject1);
        }
      }
      localObject1 = this.mKeyList;
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Key)((Iterator)localObject1).next();
          if ((localObject2 instanceof KeyAttributes)) {
            ((Key)localObject2).addValues(this.mAttributesMap);
          }
        }
      }
      this.mStartPoint.addValues(this.mAttributesMap, 0);
      this.mEndPoint.addValues(this.mAttributesMap, 100);
      localObject1 = this.mAttributesMap.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (((HashMap)localObject4).containsKey(localObject2)) {
          paramInt1 = ((Integer)((HashMap)localObject4).get(localObject2)).intValue();
        } else {
          paramInt1 = 0;
        }
        ((SplineSet)this.mAttributesMap.get(localObject2)).setup(paramInt1);
      }
    }
    if (!((HashSet)localObject5).isEmpty())
    {
      if (this.mTimeCycleAttributesMap == null) {
        this.mTimeCycleAttributesMap = new HashMap();
      }
      localObject2 = ((HashSet)localObject5).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject5 = (String)((Iterator)localObject2).next();
        if (!this.mTimeCycleAttributesMap.containsKey(localObject5))
        {
          if (((String)localObject5).startsWith("CUSTOM,"))
          {
            localObject1 = new SparseArray();
            localObject6 = localObject5.split(",")[1];
            localObject7 = this.mKeyList.iterator();
            while (((Iterator)localObject7).hasNext())
            {
              localObject8 = (Key)((Iterator)localObject7).next();
              if (((Key)localObject8).mCustomConstraints != null)
              {
                localObject9 = (ConstraintAttribute)((Key)localObject8).mCustomConstraints.get(localObject6);
                if (localObject9 != null) {
                  ((SparseArray)localObject1).append(((Key)localObject8).mFramePosition, localObject9);
                }
              }
            }
            localObject1 = TimeCycleSplineSet.makeCustomSpline((String)localObject5, (SparseArray)localObject1);
          }
          else
          {
            localObject1 = TimeCycleSplineSet.makeSpline((String)localObject5, paramLong);
          }
          if (localObject1 != null)
          {
            ((TimeCycleSplineSet)localObject1).setType((String)localObject5);
            this.mTimeCycleAttributesMap.put(localObject5, localObject1);
          }
        }
      }
      localObject1 = this.mKeyList;
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Key)((Iterator)localObject1).next();
          if ((localObject2 instanceof KeyTimeCycle)) {
            ((KeyTimeCycle)localObject2).addTimeValues(this.mTimeCycleAttributesMap);
          }
        }
      }
      localObject1 = this.mTimeCycleAttributesMap.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (((HashMap)localObject4).containsKey(localObject2)) {
          paramInt1 = ((Integer)((HashMap)localObject4).get(localObject2)).intValue();
        } else {
          paramInt1 = 0;
        }
        ((TimeCycleSplineSet)this.mTimeCycleAttributesMap.get(localObject2)).setup(paramInt1);
      }
    }
    localObject5 = new MotionPaths[this.mMotionPaths.size() + 2];
    localObject5[0] = this.mStartMotionPath;
    localObject5[(localObject5.length - 1)] = this.mEndMotionPath;
    if ((this.mMotionPaths.size() > 0) && (this.mCurveFitType == -1)) {
      this.mCurveFitType = 0;
    }
    localObject1 = this.mMotionPaths.iterator();
    paramInt1 = 1;
    while (((Iterator)localObject1).hasNext())
    {
      localObject5[paramInt1] = ((MotionPaths)((Iterator)localObject1).next());
      paramInt1 += 1;
    }
    localObject1 = new HashSet();
    localObject2 = this.mEndMotionPath.attributes.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (String)((Iterator)localObject2).next();
      if (this.mStartMotionPath.attributes.containsKey(localObject4))
      {
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("CUSTOM,");
        ((StringBuilder)localObject6).append((String)localObject4);
        if (!((HashSet)localObject3).contains(((StringBuilder)localObject6).toString())) {
          ((HashSet)localObject1).add(localObject4);
        }
      }
    }
    this.mAttributeNames = ((String[])((HashSet)localObject1).toArray(new String[0]));
    this.mAttributeInterpCount = new int[this.mAttributeNames.length];
    paramInt1 = 0;
    for (;;)
    {
      localObject1 = this.mAttributeNames;
      if (paramInt1 >= localObject1.length) {
        break;
      }
      localObject1 = localObject1[paramInt1];
      this.mAttributeInterpCount[paramInt1] = 0;
      paramInt2 = 0;
      while (paramInt2 < localObject5.length)
      {
        if (localObject5[paramInt2].attributes.containsKey(localObject1))
        {
          localObject2 = this.mAttributeInterpCount;
          localObject2[paramInt1] += ((ConstraintAttribute)localObject5[paramInt2].attributes.get(localObject1)).noOfInterpValues();
          break;
        }
        paramInt2 += 1;
      }
      paramInt1 += 1;
    }
    boolean bool;
    if (localObject5[0].mPathMotionArc != Key.UNSET) {
      bool = true;
    } else {
      bool = false;
    }
    localObject1 = new boolean[18 + this.mAttributeNames.length];
    paramInt1 = 1;
    while (paramInt1 < localObject5.length)
    {
      localObject5[paramInt1].different(localObject5[(paramInt1 - 1)], (boolean[])localObject1, this.mAttributeNames, bool);
      paramInt1 += 1;
    }
    paramInt1 = 1;
    int i;
    for (paramInt2 = 0; paramInt1 < localObject1.length; paramInt2 = i)
    {
      i = paramInt2;
      if (localObject1[paramInt1] != 0) {
        i = paramInt2 + 1;
      }
      paramInt1 += 1;
    }
    this.mInterpolateVariables = new int[paramInt2];
    localObject2 = this.mInterpolateVariables;
    this.mInterpolateData = new double[localObject2.length];
    this.mInterpolateVelocity = new double[localObject2.length];
    paramInt1 = 1;
    for (paramInt2 = 0; paramInt1 < localObject1.length; paramInt2 = i)
    {
      i = paramInt2;
      if (localObject1[paramInt1] != 0)
      {
        this.mInterpolateVariables[paramInt2] = paramInt1;
        i = paramInt2 + 1;
      }
      paramInt1 += 1;
    }
    Object localObject6 = (double[][])Array.newInstance(Double.TYPE, new int[] { localObject5.length, this.mInterpolateVariables.length });
    Object localObject7 = new double[localObject5.length];
    paramInt1 = 0;
    while (paramInt1 < localObject5.length)
    {
      localObject5[paramInt1].fillStandard(localObject6[paramInt1], this.mInterpolateVariables);
      localObject7[paramInt1] = localObject5[paramInt1].time;
      paramInt1 += 1;
    }
    paramInt1 = 0;
    for (;;)
    {
      localObject1 = this.mInterpolateVariables;
      if (paramInt1 >= localObject1.length) {
        break;
      }
      if (localObject1[paramInt1] < MotionPaths.names.length)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(MotionPaths.names[this.mInterpolateVariables[paramInt1]]);
        ((StringBuilder)localObject1).append(" [");
        localObject1 = ((StringBuilder)localObject1).toString();
        paramInt2 = 0;
        while (paramInt2 < localObject5.length)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(localObject6[paramInt2][paramInt1]);
          localObject1 = ((StringBuilder)localObject2).toString();
          paramInt2 += 1;
        }
      }
      paramInt1 += 1;
    }
    this.mSpline = new CurveFit[this.mAttributeNames.length + 1];
    paramInt1 = 0;
    for (;;)
    {
      localObject2 = this.mAttributeNames;
      if (paramInt1 >= localObject2.length) {
        break;
      }
      localObject1 = (double[][])null;
      localObject8 = localObject2[paramInt1];
      localObject2 = null;
      paramInt2 = 0;
      i = 0;
      while (paramInt2 < localObject5.length)
      {
        localObject4 = localObject2;
        int j = i;
        localObject3 = localObject1;
        if (localObject5[paramInt2].hasCustomData((String)localObject8))
        {
          localObject3 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = new double[localObject5.length];
            localObject3 = (double[][])Array.newInstance(Double.TYPE, new int[] { localObject5.length, localObject5[paramInt2].getCustomDataCount((String)localObject8) });
          }
          localObject2[i] = localObject5[paramInt2].time;
          localObject5[paramInt2].getCustomData((String)localObject8, localObject3[i], 0);
          j = i + 1;
          localObject4 = localObject2;
        }
        paramInt2 += 1;
        localObject2 = localObject4;
        i = j;
        localObject1 = localObject3;
      }
      localObject2 = Arrays.copyOf((double[])localObject2, i);
      localObject1 = (double[][])Arrays.copyOf((Object[])localObject1, i);
      localObject3 = this.mSpline;
      paramInt1 += 1;
      localObject3[paramInt1] = CurveFit.get(this.mCurveFitType, (double[])localObject2, (double[][])localObject1);
    }
    this.mSpline[0] = CurveFit.get(this.mCurveFitType, (double[])localObject7, (double[][])localObject6);
    if (localObject5[0].mPathMotionArc != Key.UNSET)
    {
      paramInt2 = localObject5.length;
      localObject1 = new int[paramInt2];
      localObject2 = new double[paramInt2];
      localObject3 = (double[][])Array.newInstance(Double.TYPE, new int[] { paramInt2, 2 });
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        localObject1[paramInt1] = localObject5[paramInt1].mPathMotionArc;
        localObject2[paramInt1] = localObject5[paramInt1].time;
        localObject3[paramInt1][0] = localObject5[paramInt1].x;
        localObject3[paramInt1][1] = localObject5[paramInt1].y;
        paramInt1 += 1;
      }
      this.mArcSpline = CurveFit.getArc((int[])localObject1, (double[])localObject2, (double[][])localObject3);
    }
    paramFloat = (0.0F / 0.0F);
    this.mCycleMap = new HashMap();
    if (this.mKeyList != null)
    {
      localObject1 = localHashSet.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = KeyCycleOscillator.makeSpline((String)localObject2);
        if (localObject3 != null)
        {
          float f = paramFloat;
          if (((KeyCycleOscillator)localObject3).variesByPath())
          {
            f = paramFloat;
            if (Float.isNaN(paramFloat)) {
              f = getPreCycleDistance();
            }
          }
          ((KeyCycleOscillator)localObject3).setType((String)localObject2);
          this.mCycleMap.put(localObject2, localObject3);
          paramFloat = f;
        }
      }
      localObject1 = this.mKeyList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Key)((Iterator)localObject1).next();
        if ((localObject2 instanceof KeyCycle)) {
          ((KeyCycle)localObject2).addCycleValues(this.mCycleMap);
        }
      }
      localObject1 = this.mCycleMap.values().iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((KeyCycleOscillator)((Iterator)localObject1).next()).setup(paramFloat);
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" start: x: ");
    localStringBuilder.append(this.mStartMotionPath.x);
    localStringBuilder.append(" y: ");
    localStringBuilder.append(this.mStartMotionPath.y);
    localStringBuilder.append(" end: x: ");
    localStringBuilder.append(this.mEndMotionPath.x);
    localStringBuilder.append(" y: ");
    localStringBuilder.append(this.mEndMotionPath.y);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.MotionController
 * JD-Core Version:    0.7.0.1
 */