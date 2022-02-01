package androidx.constraintlayout.motion.widget;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintAttribute.AttributeType;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.ConstraintSet.Constraint;
import androidx.constraintlayout.widget.ConstraintSet.Motion;
import androidx.constraintlayout.widget.ConstraintSet.PropertySet;
import androidx.constraintlayout.widget.ConstraintSet.Transform;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

class MotionConstrainedPoint
  implements Comparable<MotionConstrainedPoint>
{
  static final int CARTESIAN = 2;
  public static final boolean DEBUG = false;
  static final int PERPENDICULAR = 1;
  public static final String TAG = "MotionPaths";
  static String[] names = { "position", "x", "y", "width", "height", "pathRotate" };
  private float alpha = 1.0F;
  private boolean applyElevation = false;
  LinkedHashMap<String, ConstraintAttribute> attributes = new LinkedHashMap();
  private float elevation = 0.0F;
  private float height;
  private int mDrawPath = 0;
  private Easing mKeyFrameEasing;
  int mMode = 0;
  private float mPathRotate = (0.0F / 0.0F);
  private float mPivotX = (0.0F / 0.0F);
  private float mPivotY = (0.0F / 0.0F);
  private float mProgress = (0.0F / 0.0F);
  double[] mTempDelta = new double[18];
  double[] mTempValue = new double[18];
  int mVisibilityMode = 0;
  private float position;
  private float rotation = 0.0F;
  private float rotationX = 0.0F;
  public float rotationY = 0.0F;
  private float scaleX = 1.0F;
  private float scaleY = 1.0F;
  private float translationX = 0.0F;
  private float translationY = 0.0F;
  private float translationZ = 0.0F;
  int visibility;
  private float width;
  private float x;
  private float y;
  
  private boolean diff(float paramFloat1, float paramFloat2)
  {
    if ((!Float.isNaN(paramFloat1)) && (!Float.isNaN(paramFloat2))) {
      return Math.abs(paramFloat1 - paramFloat2) > 1.0E-006F;
    }
    return Float.isNaN(paramFloat1) != Float.isNaN(paramFloat2);
  }
  
  public void addValues(HashMap<String, SplineSet> paramHashMap, int paramInt)
  {
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      Object localObject2 = (SplineSet)paramHashMap.get(localObject1);
      int i = -1;
      switch (((String)localObject1).hashCode())
      {
      default: 
        break;
      case 92909918: 
        if (((String)localObject1).equals("alpha")) {
          i = 0;
        }
        break;
      case 37232917: 
        if (((String)localObject1).equals("transitionPathRotate")) {
          i = 7;
        }
        break;
      case -4379043: 
        if (((String)localObject1).equals("elevation")) {
          i = 1;
        }
        break;
      case -40300674: 
        if (((String)localObject1).equals("rotation")) {
          i = 2;
        }
        break;
      case -760884509: 
        if (((String)localObject1).equals("transformPivotY")) {
          i = 6;
        }
        break;
      case -760884510: 
        if (((String)localObject1).equals("transformPivotX")) {
          i = 5;
        }
        break;
      case -908189617: 
        if (((String)localObject1).equals("scaleY")) {
          i = 10;
        }
        break;
      case -908189618: 
        if (((String)localObject1).equals("scaleX")) {
          i = 9;
        }
        break;
      case -1001078227: 
        if (((String)localObject1).equals("progress")) {
          i = 8;
        }
        break;
      case -1225497655: 
        if (((String)localObject1).equals("translationZ")) {
          i = 13;
        }
        break;
      case -1225497656: 
        if (((String)localObject1).equals("translationY")) {
          i = 12;
        }
        break;
      case -1225497657: 
        if (((String)localObject1).equals("translationX")) {
          i = 11;
        }
        break;
      case -1249320805: 
        if (((String)localObject1).equals("rotationY")) {
          i = 4;
        }
        break;
      case -1249320806: 
        if (((String)localObject1).equals("rotationX")) {
          i = 3;
        }
        break;
      }
      float f1 = 1.0F;
      float f3 = 0.0F;
      float f4 = 0.0F;
      float f5 = 0.0F;
      float f6 = 0.0F;
      float f7 = 0.0F;
      float f8 = 0.0F;
      float f9 = 0.0F;
      float f10 = 0.0F;
      float f11 = 0.0F;
      float f12 = 0.0F;
      float f2 = 0.0F;
      Object localObject3;
      switch (i)
      {
      default: 
        if (((String)localObject1).startsWith("CUSTOM"))
        {
          localObject3 = localObject1.split(",")[1];
          if (this.attributes.containsKey(localObject3))
          {
            localObject3 = (ConstraintAttribute)this.attributes.get(localObject3);
            if ((localObject2 instanceof SplineSet.CustomSet)) {
              ((SplineSet.CustomSet)localObject2).setPoint(paramInt, (ConstraintAttribute)localObject3);
            }
          }
        }
        break;
      case 13: 
        if (Float.isNaN(this.translationZ)) {
          f1 = f2;
        } else {
          f1 = this.translationZ;
        }
        ((SplineSet)localObject2).setPoint(paramInt, f1);
        break;
      case 12: 
        if (Float.isNaN(this.translationY)) {
          f1 = f3;
        } else {
          f1 = this.translationY;
        }
        ((SplineSet)localObject2).setPoint(paramInt, f1);
        break;
      case 11: 
        if (Float.isNaN(this.translationX)) {
          f1 = f4;
        } else {
          f1 = this.translationX;
        }
        ((SplineSet)localObject2).setPoint(paramInt, f1);
        break;
      case 10: 
        if (!Float.isNaN(this.scaleY)) {
          f1 = this.scaleY;
        }
        ((SplineSet)localObject2).setPoint(paramInt, f1);
        break;
      case 9: 
        if (!Float.isNaN(this.scaleX)) {
          f1 = this.scaleX;
        }
        ((SplineSet)localObject2).setPoint(paramInt, f1);
        break;
      case 8: 
        if (Float.isNaN(this.mProgress)) {
          f1 = f5;
        } else {
          f1 = this.mProgress;
        }
        ((SplineSet)localObject2).setPoint(paramInt, f1);
        break;
      case 7: 
        if (Float.isNaN(this.mPathRotate)) {
          f1 = f6;
        } else {
          f1 = this.mPathRotate;
        }
        ((SplineSet)localObject2).setPoint(paramInt, f1);
        break;
      case 6: 
        if (Float.isNaN(this.mPivotY)) {
          f1 = f7;
        } else {
          f1 = this.mPivotY;
        }
        ((SplineSet)localObject2).setPoint(paramInt, f1);
        break;
      case 5: 
        if (Float.isNaN(this.mPivotX)) {
          f1 = f8;
        } else {
          f1 = this.mPivotX;
        }
        ((SplineSet)localObject2).setPoint(paramInt, f1);
        break;
      case 4: 
        if (Float.isNaN(this.rotationY)) {
          f1 = f9;
        } else {
          f1 = this.rotationY;
        }
        ((SplineSet)localObject2).setPoint(paramInt, f1);
        break;
      case 3: 
        if (Float.isNaN(this.rotationX)) {
          f1 = f10;
        } else {
          f1 = this.rotationX;
        }
        ((SplineSet)localObject2).setPoint(paramInt, f1);
        break;
      case 2: 
        if (Float.isNaN(this.rotation)) {
          f1 = f11;
        } else {
          f1 = this.rotation;
        }
        ((SplineSet)localObject2).setPoint(paramInt, f1);
        break;
      case 1: 
        if (Float.isNaN(this.elevation)) {
          f1 = f12;
        } else {
          f1 = this.elevation;
        }
        ((SplineSet)localObject2).setPoint(paramInt, f1);
        break;
      case 0: 
        if (!Float.isNaN(this.alpha)) {
          f1 = this.alpha;
        }
        ((SplineSet)localObject2).setPoint(paramInt, f1);
        continue;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(" splineSet not a CustomSet frame = ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(", value");
        localStringBuilder.append(((ConstraintAttribute)localObject3).getValueToInterpolate());
        localStringBuilder.append(localObject2);
        Log.e("MotionPaths", localStringBuilder.toString());
        continue;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("UNKNOWN customName ");
        ((StringBuilder)localObject1).append((String)localObject3);
        Log.e("MotionPaths", ((StringBuilder)localObject1).toString());
        continue;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("UNKNOWN spline ");
        ((StringBuilder)localObject2).append((String)localObject1);
        Log.e("MotionPaths", ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  public void applyParameters(View paramView)
  {
    this.visibility = paramView.getVisibility();
    float f;
    if (paramView.getVisibility() != 0) {
      f = 0.0F;
    } else {
      f = paramView.getAlpha();
    }
    this.alpha = f;
    this.applyElevation = false;
    if (Build.VERSION.SDK_INT >= 21) {
      this.elevation = paramView.getElevation();
    }
    this.rotation = paramView.getRotation();
    this.rotationX = paramView.getRotationX();
    this.rotationY = paramView.getRotationY();
    this.scaleX = paramView.getScaleX();
    this.scaleY = paramView.getScaleY();
    this.mPivotX = paramView.getPivotX();
    this.mPivotY = paramView.getPivotY();
    this.translationX = paramView.getTranslationX();
    this.translationY = paramView.getTranslationY();
    if (Build.VERSION.SDK_INT >= 21) {
      this.translationZ = paramView.getTranslationZ();
    }
  }
  
  public void applyParameters(ConstraintSet.Constraint paramConstraint)
  {
    this.mVisibilityMode = paramConstraint.propertySet.mVisibilityMode;
    this.visibility = paramConstraint.propertySet.visibility;
    float f;
    if ((paramConstraint.propertySet.visibility != 0) && (this.mVisibilityMode == 0)) {
      f = 0.0F;
    } else {
      f = paramConstraint.propertySet.alpha;
    }
    this.alpha = f;
    this.applyElevation = paramConstraint.transform.applyElevation;
    this.elevation = paramConstraint.transform.elevation;
    this.rotation = paramConstraint.transform.rotation;
    this.rotationX = paramConstraint.transform.rotationX;
    this.rotationY = paramConstraint.transform.rotationY;
    this.scaleX = paramConstraint.transform.scaleX;
    this.scaleY = paramConstraint.transform.scaleY;
    this.mPivotX = paramConstraint.transform.transformPivotX;
    this.mPivotY = paramConstraint.transform.transformPivotY;
    this.translationX = paramConstraint.transform.translationX;
    this.translationY = paramConstraint.transform.translationY;
    this.translationZ = paramConstraint.transform.translationZ;
    this.mKeyFrameEasing = Easing.getInterpolator(paramConstraint.motion.mTransitionEasing);
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
  
  public int compareTo(MotionConstrainedPoint paramMotionConstrainedPoint)
  {
    return Float.compare(this.position, paramMotionConstrainedPoint.position);
  }
  
  void different(MotionConstrainedPoint paramMotionConstrainedPoint, HashSet<String> paramHashSet)
  {
    if (diff(this.alpha, paramMotionConstrainedPoint.alpha)) {
      paramHashSet.add("alpha");
    }
    if (diff(this.elevation, paramMotionConstrainedPoint.elevation)) {
      paramHashSet.add("elevation");
    }
    int i = this.visibility;
    int j = paramMotionConstrainedPoint.visibility;
    if ((i != j) && (this.mVisibilityMode == 0) && ((i == 0) || (j == 0))) {
      paramHashSet.add("alpha");
    }
    if (diff(this.rotation, paramMotionConstrainedPoint.rotation)) {
      paramHashSet.add("rotation");
    }
    if ((!Float.isNaN(this.mPathRotate)) || (!Float.isNaN(paramMotionConstrainedPoint.mPathRotate))) {
      paramHashSet.add("transitionPathRotate");
    }
    if ((!Float.isNaN(this.mProgress)) || (!Float.isNaN(paramMotionConstrainedPoint.mProgress))) {
      paramHashSet.add("progress");
    }
    if (diff(this.rotationX, paramMotionConstrainedPoint.rotationX)) {
      paramHashSet.add("rotationX");
    }
    if (diff(this.rotationY, paramMotionConstrainedPoint.rotationY)) {
      paramHashSet.add("rotationY");
    }
    if (diff(this.mPivotX, paramMotionConstrainedPoint.mPivotX)) {
      paramHashSet.add("transformPivotX");
    }
    if (diff(this.mPivotY, paramMotionConstrainedPoint.mPivotY)) {
      paramHashSet.add("transformPivotY");
    }
    if (diff(this.scaleX, paramMotionConstrainedPoint.scaleX)) {
      paramHashSet.add("scaleX");
    }
    if (diff(this.scaleY, paramMotionConstrainedPoint.scaleY)) {
      paramHashSet.add("scaleY");
    }
    if (diff(this.translationX, paramMotionConstrainedPoint.translationX)) {
      paramHashSet.add("translationX");
    }
    if (diff(this.translationY, paramMotionConstrainedPoint.translationY)) {
      paramHashSet.add("translationY");
    }
    if (diff(this.translationZ, paramMotionConstrainedPoint.translationZ)) {
      paramHashSet.add("translationZ");
    }
  }
  
  void different(MotionConstrainedPoint paramMotionConstrainedPoint, boolean[] paramArrayOfBoolean, String[] paramArrayOfString)
  {
    paramArrayOfBoolean[0] |= diff(this.position, paramMotionConstrainedPoint.position);
    paramArrayOfBoolean[1] |= diff(this.x, paramMotionConstrainedPoint.x);
    paramArrayOfBoolean[2] |= diff(this.y, paramMotionConstrainedPoint.y);
    paramArrayOfBoolean[3] |= diff(this.width, paramMotionConstrainedPoint.width);
    int i = paramArrayOfBoolean[4];
    paramArrayOfBoolean[4] = (diff(this.height, paramMotionConstrainedPoint.height) | i);
  }
  
  void fillStandard(double[] paramArrayOfDouble, int[] paramArrayOfInt)
  {
    float[] arrayOfFloat = new float[18];
    float f = this.position;
    int i = 0;
    arrayOfFloat[0] = f;
    arrayOfFloat[1] = this.x;
    arrayOfFloat[2] = this.y;
    arrayOfFloat[3] = this.width;
    arrayOfFloat[4] = this.height;
    arrayOfFloat[5] = this.alpha;
    arrayOfFloat[6] = this.elevation;
    arrayOfFloat[7] = this.rotation;
    arrayOfFloat[8] = this.rotationX;
    arrayOfFloat[9] = this.rotationY;
    arrayOfFloat[10] = this.scaleX;
    arrayOfFloat[11] = this.scaleY;
    arrayOfFloat[12] = this.mPivotX;
    arrayOfFloat[13] = this.mPivotY;
    arrayOfFloat[14] = this.translationX;
    arrayOfFloat[15] = this.translationY;
    arrayOfFloat[16] = this.translationZ;
    arrayOfFloat[17] = this.mPathRotate;
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
  
  boolean hasCustomData(String paramString)
  {
    return this.attributes.containsKey(paramString);
  }
  
  void setBounds(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.width = paramFloat3;
    this.height = paramFloat4;
  }
  
  public void setState(View paramView)
  {
    setBounds(paramView.getX(), paramView.getY(), paramView.getWidth(), paramView.getHeight());
    applyParameters(paramView);
  }
  
  public void setState(ConstraintWidget paramConstraintWidget, ConstraintSet paramConstraintSet, int paramInt)
  {
    setBounds(paramConstraintWidget.getX(), paramConstraintWidget.getY(), paramConstraintWidget.getWidth(), paramConstraintWidget.getHeight());
    applyParameters(paramConstraintSet.getParameters(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.MotionConstrainedPoint
 * JD-Core Version:    0.7.0.1
 */