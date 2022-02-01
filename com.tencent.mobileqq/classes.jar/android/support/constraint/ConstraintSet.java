package android.support.constraint;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ConstraintSet
{
  private static final int ALPHA = 43;
  public static final int BASELINE = 5;
  private static final int BASELINE_TO_BASELINE = 1;
  public static final int BOTTOM = 4;
  private static final int BOTTOM_MARGIN = 2;
  private static final int BOTTOM_TO_BOTTOM = 3;
  private static final int BOTTOM_TO_TOP = 4;
  public static final int CHAIN_PACKED = 2;
  public static final int CHAIN_SPREAD = 0;
  public static final int CHAIN_SPREAD_INSIDE = 1;
  private static final boolean DEBUG = false;
  private static final int DIMENSION_RATIO = 5;
  private static final int EDITOR_ABSOLUTE_X = 6;
  private static final int EDITOR_ABSOLUTE_Y = 7;
  private static final int ELEVATION = 44;
  public static final int END = 7;
  private static final int END_MARGIN = 8;
  private static final int END_TO_END = 9;
  private static final int END_TO_START = 10;
  public static final int GONE = 8;
  private static final int GONE_BOTTOM_MARGIN = 11;
  private static final int GONE_END_MARGIN = 12;
  private static final int GONE_LEFT_MARGIN = 13;
  private static final int GONE_RIGHT_MARGIN = 14;
  private static final int GONE_START_MARGIN = 15;
  private static final int GONE_TOP_MARGIN = 16;
  private static final int GUIDE_BEGIN = 17;
  private static final int GUIDE_END = 18;
  private static final int GUIDE_PERCENT = 19;
  private static final int HEIGHT_DEFAULT = 55;
  private static final int HEIGHT_MAX = 57;
  private static final int HEIGHT_MIN = 59;
  public static final int HORIZONTAL = 0;
  private static final int HORIZONTAL_BIAS = 20;
  public static final int HORIZONTAL_GUIDELINE = 0;
  private static final int HORIZONTAL_STYLE = 41;
  private static final int HORIZONTAL_WEIGHT = 39;
  public static final int INVISIBLE = 4;
  private static final int LAYOUT_HEIGHT = 21;
  private static final int LAYOUT_VISIBILITY = 22;
  private static final int LAYOUT_WIDTH = 23;
  public static final int LEFT = 1;
  private static final int LEFT_MARGIN = 24;
  private static final int LEFT_TO_LEFT = 25;
  private static final int LEFT_TO_RIGHT = 26;
  public static final int MATCH_CONSTRAINT = 0;
  public static final int MATCH_CONSTRAINT_SPREAD = 0;
  public static final int MATCH_CONSTRAINT_WRAP = 1;
  private static final int ORIENTATION = 27;
  public static final int PARENT_ID = 0;
  public static final int RIGHT = 2;
  private static final int RIGHT_MARGIN = 28;
  private static final int RIGHT_TO_LEFT = 29;
  private static final int RIGHT_TO_RIGHT = 30;
  private static final int ROTATION_X = 45;
  private static final int ROTATION_Y = 46;
  private static final int SCALE_X = 47;
  private static final int SCALE_Y = 48;
  public static final int START = 6;
  private static final int START_MARGIN = 31;
  private static final int START_TO_END = 32;
  private static final int START_TO_START = 33;
  private static final String TAG = "ConstraintSet";
  public static final int TOP = 3;
  private static final int TOP_MARGIN = 34;
  private static final int TOP_TO_BOTTOM = 35;
  private static final int TOP_TO_TOP = 36;
  private static final int TRANSFORM_PIVOT_X = 49;
  private static final int TRANSFORM_PIVOT_Y = 50;
  private static final int TRANSLATION_X = 51;
  private static final int TRANSLATION_Y = 52;
  private static final int TRANSLATION_Z = 53;
  public static final int UNSET = -1;
  private static final int UNUSED = 60;
  public static final int VERTICAL = 1;
  private static final int VERTICAL_BIAS = 37;
  public static final int VERTICAL_GUIDELINE = 1;
  private static final int VERTICAL_STYLE = 42;
  private static final int VERTICAL_WEIGHT = 40;
  private static final int VIEW_ID = 38;
  private static final int[] VISIBILITY_FLAGS = { 0, 4, 8 };
  public static final int VISIBLE = 0;
  private static final int WIDTH_DEFAULT = 54;
  private static final int WIDTH_MAX = 56;
  private static final int WIDTH_MIN = 58;
  public static final int WRAP_CONTENT = -2;
  private static SparseIntArray mapToConstant = new SparseIntArray();
  private HashMap<Integer, ConstraintSet.Constraint> mConstraints = new HashMap();
  
  static
  {
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintLeft_toLeftOf, 25);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintLeft_toRightOf, 26);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintRight_toLeftOf, 29);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintRight_toRightOf, 30);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintTop_toTopOf, 36);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintTop_toBottomOf, 35);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintBottom_toTopOf, 4);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintBottom_toBottomOf, 3);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintBaseline_toBaselineOf, 1);
    mapToConstant.append(R.styleable.ConstraintSet_layout_editor_absoluteX, 6);
    mapToConstant.append(R.styleable.ConstraintSet_layout_editor_absoluteY, 7);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintGuide_begin, 17);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintGuide_end, 18);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintGuide_percent, 19);
    mapToConstant.append(R.styleable.ConstraintSet_android_orientation, 27);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintStart_toEndOf, 32);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintStart_toStartOf, 33);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintEnd_toStartOf, 10);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintEnd_toEndOf, 9);
    mapToConstant.append(R.styleable.ConstraintSet_layout_goneMarginLeft, 13);
    mapToConstant.append(R.styleable.ConstraintSet_layout_goneMarginTop, 16);
    mapToConstant.append(R.styleable.ConstraintSet_layout_goneMarginRight, 14);
    mapToConstant.append(R.styleable.ConstraintSet_layout_goneMarginBottom, 11);
    mapToConstant.append(R.styleable.ConstraintSet_layout_goneMarginStart, 15);
    mapToConstant.append(R.styleable.ConstraintSet_layout_goneMarginEnd, 12);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintVertical_weight, 40);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintHorizontal_weight, 39);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintHorizontal_chainStyle, 41);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintVertical_chainStyle, 42);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintHorizontal_bias, 20);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintVertical_bias, 37);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintDimensionRatio, 5);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintLeft_creator, 60);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintTop_creator, 60);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintRight_creator, 60);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintBottom_creator, 60);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintBaseline_creator, 60);
    mapToConstant.append(R.styleable.ConstraintSet_android_layout_marginLeft, 24);
    mapToConstant.append(R.styleable.ConstraintSet_android_layout_marginRight, 28);
    mapToConstant.append(R.styleable.ConstraintSet_android_layout_marginStart, 31);
    mapToConstant.append(R.styleable.ConstraintSet_android_layout_marginEnd, 8);
    mapToConstant.append(R.styleable.ConstraintSet_android_layout_marginTop, 34);
    mapToConstant.append(R.styleable.ConstraintSet_android_layout_marginBottom, 2);
    mapToConstant.append(R.styleable.ConstraintSet_android_layout_width, 23);
    mapToConstant.append(R.styleable.ConstraintSet_android_layout_height, 21);
    mapToConstant.append(R.styleable.ConstraintSet_android_visibility, 22);
    mapToConstant.append(R.styleable.ConstraintSet_android_alpha, 43);
    mapToConstant.append(R.styleable.ConstraintSet_android_elevation, 44);
    mapToConstant.append(R.styleable.ConstraintSet_android_rotationX, 45);
    mapToConstant.append(R.styleable.ConstraintSet_android_rotationY, 46);
    mapToConstant.append(R.styleable.ConstraintSet_android_scaleX, 47);
    mapToConstant.append(R.styleable.ConstraintSet_android_scaleY, 48);
    mapToConstant.append(R.styleable.ConstraintSet_android_transformPivotX, 49);
    mapToConstant.append(R.styleable.ConstraintSet_android_transformPivotY, 50);
    mapToConstant.append(R.styleable.ConstraintSet_android_translationX, 51);
    mapToConstant.append(R.styleable.ConstraintSet_android_translationY, 52);
    mapToConstant.append(R.styleable.ConstraintSet_android_translationZ, 53);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintWidth_default, 54);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintHeight_default, 55);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintWidth_max, 56);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintHeight_max, 57);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintWidth_min, 58);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintHeight_min, 59);
    mapToConstant.append(R.styleable.ConstraintSet_android_id, 38);
  }
  
  private void createHorizontalChain(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt5, int paramInt6, int paramInt7)
  {
    if (paramArrayOfInt.length >= 2)
    {
      if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length != paramArrayOfInt.length)) {
        throw new IllegalArgumentException("must have 2 or more widgets in a chain");
      }
      if (paramArrayOfFloat != null) {
        get(paramArrayOfInt[0]).verticalWeight = paramArrayOfFloat[0];
      }
      get(paramArrayOfInt[0]).horizontalChainStyle = paramInt5;
      connect(paramArrayOfInt[0], paramInt6, paramInt1, paramInt2, -1);
      paramInt1 = 1;
      while (paramInt1 < paramArrayOfInt.length)
      {
        paramInt2 = paramArrayOfInt[paramInt1];
        paramInt2 = paramArrayOfInt[paramInt1];
        paramInt5 = paramInt1 - 1;
        connect(paramInt2, paramInt6, paramArrayOfInt[paramInt5], paramInt7, -1);
        connect(paramArrayOfInt[paramInt5], paramInt7, paramArrayOfInt[paramInt1], paramInt6, -1);
        if (paramArrayOfFloat != null) {
          get(paramArrayOfInt[paramInt1]).horizontalWeight = paramArrayOfFloat[paramInt1];
        }
        paramInt1 += 1;
      }
      connect(paramArrayOfInt[(paramArrayOfInt.length - 1)], paramInt7, paramInt3, paramInt4, -1);
      return;
    }
    paramArrayOfInt = new IllegalArgumentException("must have 2 or more widgets in a chain");
    for (;;)
    {
      throw paramArrayOfInt;
    }
  }
  
  private ConstraintSet.Constraint fillFromAttributeList(Context paramContext, AttributeSet paramAttributeSet)
  {
    ConstraintSet.Constraint localConstraint = new ConstraintSet.Constraint(null);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintSet);
    populateConstraint(localConstraint, paramContext);
    paramContext.recycle();
    return localConstraint;
  }
  
  private ConstraintSet.Constraint get(int paramInt)
  {
    if (!this.mConstraints.containsKey(Integer.valueOf(paramInt))) {
      this.mConstraints.put(Integer.valueOf(paramInt), new ConstraintSet.Constraint(null));
    }
    return (ConstraintSet.Constraint)this.mConstraints.get(Integer.valueOf(paramInt));
  }
  
  private static int lookupID(TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    int i = paramTypedArray.getResourceId(paramInt1, paramInt2);
    paramInt2 = i;
    if (i == -1) {
      paramInt2 = paramTypedArray.getInt(paramInt1, -1);
    }
    return paramInt2;
  }
  
  private void populateConstraint(ConstraintSet.Constraint paramConstraint, TypedArray paramTypedArray)
  {
    int j = paramTypedArray.getIndexCount();
    int i = 0;
    while (i < j)
    {
      int k = paramTypedArray.getIndex(i);
      int m = mapToConstant.get(k);
      StringBuilder localStringBuilder;
      if (m != 60)
      {
        switch (m)
        {
        default: 
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unknown attribute 0x");
          localStringBuilder.append(Integer.toHexString(k));
          localStringBuilder.append("   ");
          localStringBuilder.append(mapToConstant.get(k));
          Log.w("ConstraintSet", localStringBuilder.toString());
          break;
        case 53: 
          paramConstraint.translationZ = paramTypedArray.getFloat(k, paramConstraint.translationZ);
          break;
        case 52: 
          paramConstraint.translationY = paramTypedArray.getFloat(k, paramConstraint.translationY);
          break;
        case 51: 
          paramConstraint.translationX = paramTypedArray.getFloat(k, paramConstraint.translationX);
          break;
        case 50: 
          paramConstraint.transformPivotY = paramTypedArray.getFloat(k, paramConstraint.transformPivotY);
          break;
        case 49: 
          paramConstraint.transformPivotX = paramTypedArray.getFloat(k, paramConstraint.transformPivotX);
          break;
        case 48: 
          paramConstraint.scaleY = paramTypedArray.getFloat(k, paramConstraint.scaleY);
          break;
        case 47: 
          paramConstraint.scaleX = paramTypedArray.getFloat(k, paramConstraint.scaleX);
          break;
        case 46: 
          paramConstraint.rotationY = paramTypedArray.getFloat(k, paramConstraint.rotationY);
          break;
        case 45: 
          paramConstraint.rotationX = paramTypedArray.getFloat(k, paramConstraint.rotationX);
          break;
        case 44: 
          paramConstraint.applyElevation = true;
          paramConstraint.elevation = paramTypedArray.getFloat(k, paramConstraint.elevation);
          break;
        case 43: 
          paramConstraint.alpha = paramTypedArray.getFloat(k, paramConstraint.alpha);
          break;
        case 42: 
          paramConstraint.verticalChainStyle = paramTypedArray.getInt(k, paramConstraint.verticalChainStyle);
          break;
        case 41: 
          paramConstraint.horizontalChainStyle = paramTypedArray.getInt(k, paramConstraint.horizontalChainStyle);
          break;
        case 40: 
          paramConstraint.verticalWeight = paramTypedArray.getFloat(k, paramConstraint.verticalWeight);
          break;
        case 39: 
          paramConstraint.horizontalWeight = paramTypedArray.getFloat(k, paramConstraint.horizontalWeight);
          break;
        case 38: 
          paramConstraint.mViewId = paramTypedArray.getResourceId(k, paramConstraint.mViewId);
          break;
        case 37: 
          paramConstraint.verticalBias = paramTypedArray.getFloat(k, paramConstraint.verticalBias);
          break;
        case 36: 
          paramConstraint.topToTop = lookupID(paramTypedArray, k, paramConstraint.topToTop);
          break;
        case 35: 
          paramConstraint.topToBottom = lookupID(paramTypedArray, k, paramConstraint.topToBottom);
          break;
        case 34: 
          paramConstraint.topMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.topMargin);
          break;
        case 33: 
          paramConstraint.startToStart = lookupID(paramTypedArray, k, paramConstraint.startToStart);
          break;
        case 32: 
          paramConstraint.startToEnd = lookupID(paramTypedArray, k, paramConstraint.startToEnd);
          break;
        case 31: 
          paramConstraint.startMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.startMargin);
          break;
        case 30: 
          paramConstraint.rightToRight = lookupID(paramTypedArray, k, paramConstraint.rightToRight);
          break;
        case 29: 
          paramConstraint.rightToLeft = lookupID(paramTypedArray, k, paramConstraint.rightToLeft);
          break;
        case 28: 
          paramConstraint.rightMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.rightMargin);
          break;
        case 27: 
          paramConstraint.orientation = paramTypedArray.getInt(k, paramConstraint.orientation);
          break;
        case 26: 
          paramConstraint.leftToRight = lookupID(paramTypedArray, k, paramConstraint.leftToRight);
          break;
        case 25: 
          paramConstraint.leftToLeft = lookupID(paramTypedArray, k, paramConstraint.leftToLeft);
          break;
        case 24: 
          paramConstraint.leftMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.leftMargin);
          break;
        case 23: 
          paramConstraint.mWidth = paramTypedArray.getLayoutDimension(k, paramConstraint.mWidth);
          break;
        case 22: 
          paramConstraint.visibility = paramTypedArray.getInt(k, paramConstraint.visibility);
          paramConstraint.visibility = VISIBILITY_FLAGS[paramConstraint.visibility];
          break;
        case 21: 
          paramConstraint.mHeight = paramTypedArray.getLayoutDimension(k, paramConstraint.mHeight);
          break;
        case 20: 
          paramConstraint.horizontalBias = paramTypedArray.getFloat(k, paramConstraint.horizontalBias);
          break;
        case 19: 
          paramConstraint.guidePercent = paramTypedArray.getFloat(k, paramConstraint.guidePercent);
          break;
        case 18: 
          paramConstraint.guideEnd = paramTypedArray.getDimensionPixelOffset(k, paramConstraint.guideEnd);
          break;
        case 17: 
          paramConstraint.guideBegin = paramTypedArray.getDimensionPixelOffset(k, paramConstraint.guideBegin);
          break;
        case 16: 
          paramConstraint.goneTopMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.goneTopMargin);
          break;
        case 15: 
          paramConstraint.goneStartMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.goneStartMargin);
          break;
        case 14: 
          paramConstraint.goneRightMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.goneRightMargin);
          break;
        case 13: 
          paramConstraint.goneLeftMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.goneLeftMargin);
          break;
        case 12: 
          paramConstraint.goneEndMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.goneEndMargin);
          break;
        case 11: 
          paramConstraint.goneBottomMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.goneBottomMargin);
          break;
        case 10: 
          paramConstraint.endToStart = lookupID(paramTypedArray, k, paramConstraint.endToStart);
          break;
        case 9: 
          paramConstraint.bottomToTop = lookupID(paramTypedArray, k, paramConstraint.endToEnd);
          break;
        case 8: 
          paramConstraint.endMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.endMargin);
          break;
        case 7: 
          paramConstraint.editorAbsoluteY = paramTypedArray.getDimensionPixelOffset(k, paramConstraint.editorAbsoluteY);
          break;
        case 6: 
          paramConstraint.editorAbsoluteX = paramTypedArray.getDimensionPixelOffset(k, paramConstraint.editorAbsoluteX);
          break;
        case 5: 
          paramConstraint.dimensionRatio = paramTypedArray.getString(k);
          break;
        case 4: 
          paramConstraint.bottomToTop = lookupID(paramTypedArray, k, paramConstraint.bottomToTop);
          break;
        case 3: 
          paramConstraint.bottomToBottom = lookupID(paramTypedArray, k, paramConstraint.bottomToBottom);
          break;
        case 2: 
          paramConstraint.bottomMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.bottomMargin);
          break;
        case 1: 
          paramConstraint.baselineToBaseline = lookupID(paramTypedArray, k, paramConstraint.baselineToBaseline);
          break;
        }
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("unused attribute 0x");
        localStringBuilder.append(Integer.toHexString(k));
        localStringBuilder.append("   ");
        localStringBuilder.append(mapToConstant.get(k));
        Log.w("ConstraintSet", localStringBuilder.toString());
      }
      i += 1;
    }
  }
  
  private String sideToString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "undefined";
    case 7: 
      return "end";
    case 6: 
      return "start";
    case 5: 
      return "baseline";
    case 4: 
      return "bottom";
    case 3: 
      return "top";
    case 2: 
      return "right";
    }
    return "left";
  }
  
  public void addToHorizontalChain(int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if (paramInt2 == 0) {
      i = 1;
    } else {
      i = 2;
    }
    connect(paramInt1, 1, paramInt2, i, 0);
    if (paramInt3 == 0) {
      i = 2;
    } else {
      i = 1;
    }
    connect(paramInt1, 2, paramInt3, i, 0);
    if (paramInt2 != 0) {
      connect(paramInt2, 2, paramInt1, 1, 0);
    }
    if (paramInt3 != 0) {
      connect(paramInt3, 1, paramInt1, 2, 0);
    }
  }
  
  public void addToHorizontalChainRTL(int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if (paramInt2 == 0) {
      i = 6;
    } else {
      i = 7;
    }
    connect(paramInt1, 6, paramInt2, i, 0);
    if (paramInt3 == 0) {
      i = 7;
    } else {
      i = 6;
    }
    connect(paramInt1, 7, paramInt3, i, 0);
    if (paramInt2 != 0) {
      connect(paramInt2, 7, paramInt1, 6, 0);
    }
    if (paramInt3 != 0) {
      connect(paramInt3, 6, paramInt1, 7, 0);
    }
  }
  
  public void addToVerticalChain(int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if (paramInt2 == 0) {
      i = 3;
    } else {
      i = 4;
    }
    connect(paramInt1, 3, paramInt2, i, 0);
    if (paramInt3 == 0) {
      i = 4;
    } else {
      i = 3;
    }
    connect(paramInt1, 4, paramInt3, i, 0);
    if (paramInt2 != 0) {
      connect(paramInt2, 4, paramInt1, 3, 0);
    }
    if (paramInt2 != 0) {
      connect(paramInt3, 3, paramInt1, 4, 0);
    }
  }
  
  public void applyTo(ConstraintLayout paramConstraintLayout)
  {
    applyToInternal(paramConstraintLayout);
    paramConstraintLayout.setConstraintSet(null);
  }
  
  void applyToInternal(ConstraintLayout paramConstraintLayout)
  {
    int j = paramConstraintLayout.getChildCount();
    Object localObject1 = new HashSet(this.mConstraints.keySet());
    int i = 0;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    while (i < j)
    {
      localObject2 = paramConstraintLayout.getChildAt(i);
      int k = ((View)localObject2).getId();
      if (this.mConstraints.containsKey(Integer.valueOf(k)))
      {
        ((HashSet)localObject1).remove(Integer.valueOf(k));
        localObject3 = (ConstraintSet.Constraint)this.mConstraints.get(Integer.valueOf(k));
        localObject4 = (ConstraintLayout.LayoutParams)((View)localObject2).getLayoutParams();
        ((ConstraintSet.Constraint)localObject3).applyTo((ConstraintLayout.LayoutParams)localObject4);
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        ((View)localObject2).setVisibility(((ConstraintSet.Constraint)localObject3).visibility);
        if (Build.VERSION.SDK_INT >= 17)
        {
          ((View)localObject2).setAlpha(((ConstraintSet.Constraint)localObject3).alpha);
          ((View)localObject2).setRotationX(((ConstraintSet.Constraint)localObject3).rotationX);
          ((View)localObject2).setRotationY(((ConstraintSet.Constraint)localObject3).rotationY);
          ((View)localObject2).setScaleX(((ConstraintSet.Constraint)localObject3).scaleX);
          ((View)localObject2).setScaleY(((ConstraintSet.Constraint)localObject3).scaleY);
          ((View)localObject2).setPivotX(((ConstraintSet.Constraint)localObject3).transformPivotX);
          ((View)localObject2).setPivotY(((ConstraintSet.Constraint)localObject3).transformPivotY);
          ((View)localObject2).setTranslationX(((ConstraintSet.Constraint)localObject3).translationX);
          ((View)localObject2).setTranslationY(((ConstraintSet.Constraint)localObject3).translationY);
          if (Build.VERSION.SDK_INT >= 21)
          {
            ((View)localObject2).setTranslationZ(((ConstraintSet.Constraint)localObject3).translationZ);
            if (((ConstraintSet.Constraint)localObject3).applyElevation) {
              ((View)localObject2).setElevation(((ConstraintSet.Constraint)localObject3).elevation);
            }
          }
        }
      }
      i += 1;
    }
    localObject1 = ((HashSet)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = (Integer)((Iterator)localObject1).next();
      localObject2 = (ConstraintSet.Constraint)this.mConstraints.get(localObject4);
      if (((ConstraintSet.Constraint)localObject2).mIsGuideline)
      {
        localObject3 = new Guideline(paramConstraintLayout.getContext());
        ((Guideline)localObject3).setId(((Integer)localObject4).intValue());
        localObject4 = paramConstraintLayout.generateDefaultLayoutParams();
        ((ConstraintSet.Constraint)localObject2).applyTo((ConstraintLayout.LayoutParams)localObject4);
        paramConstraintLayout.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      }
    }
  }
  
  public void center(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat)
  {
    if (paramInt4 >= 0)
    {
      if (paramInt7 >= 0)
      {
        if ((paramFloat > 0.0F) && (paramFloat <= 1.0F))
        {
          if ((paramInt3 != 1) && (paramInt3 != 2))
          {
            if ((paramInt3 != 6) && (paramInt3 != 7))
            {
              connect(paramInt1, 3, paramInt2, paramInt3, paramInt4);
              connect(paramInt1, 4, paramInt5, paramInt6, paramInt7);
              ((ConstraintSet.Constraint)this.mConstraints.get(Integer.valueOf(paramInt1))).verticalBias = paramFloat;
              return;
            }
            connect(paramInt1, 6, paramInt2, paramInt3, paramInt4);
            connect(paramInt1, 7, paramInt5, paramInt6, paramInt7);
            ((ConstraintSet.Constraint)this.mConstraints.get(Integer.valueOf(paramInt1))).horizontalBias = paramFloat;
            return;
          }
          connect(paramInt1, 1, paramInt2, paramInt3, paramInt4);
          connect(paramInt1, 2, paramInt5, paramInt6, paramInt7);
          ((ConstraintSet.Constraint)this.mConstraints.get(Integer.valueOf(paramInt1))).horizontalBias = paramFloat;
          return;
        }
        throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
      }
      throw new IllegalArgumentException("margin must be > 0");
    }
    throw new IllegalArgumentException("margin must be > 0");
  }
  
  public void centerHorizontally(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      center(paramInt1, 0, 1, 0, 0, 2, 0, 0.5F);
      return;
    }
    center(paramInt1, paramInt2, 2, 0, paramInt2, 1, 0, 0.5F);
  }
  
  public void centerHorizontally(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat)
  {
    connect(paramInt1, 1, paramInt2, paramInt3, paramInt4);
    connect(paramInt1, 2, paramInt5, paramInt6, paramInt7);
    ((ConstraintSet.Constraint)this.mConstraints.get(Integer.valueOf(paramInt1))).horizontalBias = paramFloat;
  }
  
  public void centerHorizontallyRtl(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      center(paramInt1, 0, 6, 0, 0, 7, 0, 0.5F);
      return;
    }
    center(paramInt1, paramInt2, 7, 0, paramInt2, 6, 0, 0.5F);
  }
  
  public void centerHorizontallyRtl(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat)
  {
    connect(paramInt1, 6, paramInt2, paramInt3, paramInt4);
    connect(paramInt1, 7, paramInt5, paramInt6, paramInt7);
    ((ConstraintSet.Constraint)this.mConstraints.get(Integer.valueOf(paramInt1))).horizontalBias = paramFloat;
  }
  
  public void centerVertically(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      center(paramInt1, 0, 3, 0, 0, 4, 0, 0.5F);
      return;
    }
    center(paramInt1, paramInt2, 4, 0, paramInt2, 3, 0, 0.5F);
  }
  
  public void centerVertically(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat)
  {
    connect(paramInt1, 3, paramInt2, paramInt3, paramInt4);
    connect(paramInt1, 4, paramInt5, paramInt6, paramInt7);
    ((ConstraintSet.Constraint)this.mConstraints.get(Integer.valueOf(paramInt1))).verticalBias = paramFloat;
  }
  
  public void clear(int paramInt)
  {
    this.mConstraints.remove(Integer.valueOf(paramInt));
  }
  
  public void clear(int paramInt1, int paramInt2)
  {
    if (this.mConstraints.containsKey(Integer.valueOf(paramInt1)))
    {
      ConstraintSet.Constraint localConstraint = (ConstraintSet.Constraint)this.mConstraints.get(Integer.valueOf(paramInt1));
      switch (paramInt2)
      {
      default: 
        throw new IllegalArgumentException("unknown constraint");
      case 7: 
        localConstraint.endToStart = -1;
        localConstraint.endToEnd = -1;
        localConstraint.endMargin = -1;
        localConstraint.goneEndMargin = -1;
        return;
      case 6: 
        localConstraint.startToEnd = -1;
        localConstraint.startToStart = -1;
        localConstraint.startMargin = -1;
        localConstraint.goneStartMargin = -1;
        return;
      case 5: 
        localConstraint.baselineToBaseline = -1;
        return;
      case 4: 
        localConstraint.bottomToTop = -1;
        localConstraint.bottomToBottom = -1;
        localConstraint.bottomMargin = -1;
        localConstraint.goneBottomMargin = -1;
        return;
      case 3: 
        localConstraint.topToBottom = -1;
        localConstraint.topToTop = -1;
        localConstraint.topMargin = -1;
        localConstraint.goneTopMargin = -1;
        return;
      case 2: 
        localConstraint.rightToRight = -1;
        localConstraint.rightToLeft = -1;
        localConstraint.rightMargin = -1;
        localConstraint.goneRightMargin = -1;
        return;
      }
      localConstraint.leftToRight = -1;
      localConstraint.leftToLeft = -1;
      localConstraint.leftMargin = -1;
      localConstraint.goneLeftMargin = -1;
    }
  }
  
  public void clone(Context paramContext, int paramInt)
  {
    clone((ConstraintLayout)LayoutInflater.from(paramContext).inflate(paramInt, null));
  }
  
  public void clone(ConstraintLayout paramConstraintLayout)
  {
    int j = paramConstraintLayout.getChildCount();
    this.mConstraints.clear();
    int i = 0;
    while (i < j)
    {
      View localView = paramConstraintLayout.getChildAt(i);
      ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)localView.getLayoutParams();
      int k = localView.getId();
      if (!this.mConstraints.containsKey(Integer.valueOf(k))) {
        this.mConstraints.put(Integer.valueOf(k), new ConstraintSet.Constraint(null));
      }
      ConstraintSet.Constraint localConstraint = (ConstraintSet.Constraint)this.mConstraints.get(Integer.valueOf(k));
      ConstraintSet.Constraint.access$100(localConstraint, k, localLayoutParams);
      localConstraint.visibility = localView.getVisibility();
      if (Build.VERSION.SDK_INT >= 17)
      {
        localConstraint.alpha = localView.getAlpha();
        localConstraint.rotationX = localView.getRotationX();
        localConstraint.rotationY = localView.getRotationY();
        localConstraint.scaleX = localView.getScaleX();
        localConstraint.scaleY = localView.getScaleY();
        localConstraint.transformPivotX = localView.getPivotX();
        localConstraint.transformPivotY = localView.getPivotY();
        localConstraint.translationX = localView.getTranslationX();
        localConstraint.translationY = localView.getTranslationY();
        if (Build.VERSION.SDK_INT >= 21)
        {
          localConstraint.translationZ = localView.getTranslationZ();
          if (localConstraint.applyElevation) {
            localConstraint.elevation = localView.getElevation();
          }
        }
      }
      i += 1;
    }
  }
  
  public void clone(ConstraintSet paramConstraintSet)
  {
    this.mConstraints.clear();
    Iterator localIterator = paramConstraintSet.mConstraints.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      this.mConstraints.put(localInteger, ((ConstraintSet.Constraint)paramConstraintSet.mConstraints.get(localInteger)).clone());
    }
  }
  
  public void connect(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.mConstraints.containsKey(Integer.valueOf(paramInt1))) {
      this.mConstraints.put(Integer.valueOf(paramInt1), new ConstraintSet.Constraint(null));
    }
    Object localObject = (ConstraintSet.Constraint)this.mConstraints.get(Integer.valueOf(paramInt1));
    switch (paramInt2)
    {
    default: 
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(sideToString(paramInt2));
      ((StringBuilder)localObject).append(" to ");
      ((StringBuilder)localObject).append(sideToString(paramInt4));
      ((StringBuilder)localObject).append(" unknown");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    case 7: 
      if (paramInt4 == 7)
      {
        ((ConstraintSet.Constraint)localObject).endToEnd = paramInt3;
        ((ConstraintSet.Constraint)localObject).endToStart = -1;
        return;
      }
      if (paramInt4 == 6)
      {
        ((ConstraintSet.Constraint)localObject).endToStart = paramInt3;
        ((ConstraintSet.Constraint)localObject).endToEnd = -1;
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("right to ");
      ((StringBuilder)localObject).append(sideToString(paramInt4));
      ((StringBuilder)localObject).append(" undefined");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    case 6: 
      if (paramInt4 == 6)
      {
        ((ConstraintSet.Constraint)localObject).startToStart = paramInt3;
        ((ConstraintSet.Constraint)localObject).startToEnd = -1;
        return;
      }
      if (paramInt4 == 7)
      {
        ((ConstraintSet.Constraint)localObject).startToEnd = paramInt3;
        ((ConstraintSet.Constraint)localObject).startToStart = -1;
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("right to ");
      ((StringBuilder)localObject).append(sideToString(paramInt4));
      ((StringBuilder)localObject).append(" undefined");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    case 5: 
      if (paramInt4 == 5)
      {
        ((ConstraintSet.Constraint)localObject).baselineToBaseline = paramInt3;
        ((ConstraintSet.Constraint)localObject).bottomToBottom = -1;
        ((ConstraintSet.Constraint)localObject).bottomToTop = -1;
        ((ConstraintSet.Constraint)localObject).topToTop = -1;
        ((ConstraintSet.Constraint)localObject).topToBottom = -1;
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("right to ");
      ((StringBuilder)localObject).append(sideToString(paramInt4));
      ((StringBuilder)localObject).append(" undefined");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    case 4: 
      if (paramInt4 == 4)
      {
        ((ConstraintSet.Constraint)localObject).bottomToBottom = paramInt3;
        ((ConstraintSet.Constraint)localObject).bottomToTop = -1;
        ((ConstraintSet.Constraint)localObject).baselineToBaseline = -1;
        return;
      }
      if (paramInt4 == 3)
      {
        ((ConstraintSet.Constraint)localObject).bottomToTop = paramInt3;
        ((ConstraintSet.Constraint)localObject).bottomToBottom = -1;
        ((ConstraintSet.Constraint)localObject).baselineToBaseline = -1;
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("right to ");
      ((StringBuilder)localObject).append(sideToString(paramInt4));
      ((StringBuilder)localObject).append(" undefined");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    case 3: 
      if (paramInt4 == 3)
      {
        ((ConstraintSet.Constraint)localObject).topToTop = paramInt3;
        ((ConstraintSet.Constraint)localObject).topToBottom = -1;
        ((ConstraintSet.Constraint)localObject).baselineToBaseline = -1;
        return;
      }
      if (paramInt4 == 4)
      {
        ((ConstraintSet.Constraint)localObject).topToBottom = paramInt3;
        ((ConstraintSet.Constraint)localObject).topToTop = -1;
        ((ConstraintSet.Constraint)localObject).baselineToBaseline = -1;
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("right to ");
      ((StringBuilder)localObject).append(sideToString(paramInt4));
      ((StringBuilder)localObject).append(" undefined");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    case 2: 
      if (paramInt4 == 1)
      {
        ((ConstraintSet.Constraint)localObject).rightToLeft = paramInt3;
        ((ConstraintSet.Constraint)localObject).rightToRight = -1;
        return;
      }
      if (paramInt4 == 2)
      {
        ((ConstraintSet.Constraint)localObject).rightToRight = paramInt3;
        ((ConstraintSet.Constraint)localObject).rightToLeft = -1;
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("right to ");
      ((StringBuilder)localObject).append(sideToString(paramInt4));
      ((StringBuilder)localObject).append(" undefined");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    if (paramInt4 == 1)
    {
      ((ConstraintSet.Constraint)localObject).leftToLeft = paramInt3;
      ((ConstraintSet.Constraint)localObject).leftToRight = -1;
      return;
    }
    if (paramInt4 == 2)
    {
      ((ConstraintSet.Constraint)localObject).leftToRight = paramInt3;
      ((ConstraintSet.Constraint)localObject).leftToLeft = -1;
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("left to ");
    ((StringBuilder)localObject).append(sideToString(paramInt4));
    ((StringBuilder)localObject).append(" undefined");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void connect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (!this.mConstraints.containsKey(Integer.valueOf(paramInt1))) {
      this.mConstraints.put(Integer.valueOf(paramInt1), new ConstraintSet.Constraint(null));
    }
    Object localObject = (ConstraintSet.Constraint)this.mConstraints.get(Integer.valueOf(paramInt1));
    switch (paramInt2)
    {
    default: 
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(sideToString(paramInt2));
      ((StringBuilder)localObject).append(" to ");
      ((StringBuilder)localObject).append(sideToString(paramInt4));
      ((StringBuilder)localObject).append(" unknown");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    case 7: 
      if (paramInt4 == 7)
      {
        ((ConstraintSet.Constraint)localObject).endToEnd = paramInt3;
        ((ConstraintSet.Constraint)localObject).endToStart = -1;
      }
      else
      {
        if (paramInt4 != 6) {
          break label204;
        }
        ((ConstraintSet.Constraint)localObject).endToStart = paramInt3;
        ((ConstraintSet.Constraint)localObject).endToEnd = -1;
      }
      ((ConstraintSet.Constraint)localObject).endMargin = paramInt5;
      return;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("right to ");
      ((StringBuilder)localObject).append(sideToString(paramInt4));
      ((StringBuilder)localObject).append(" undefined");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    case 6: 
      if (paramInt4 == 6)
      {
        ((ConstraintSet.Constraint)localObject).startToStart = paramInt3;
        ((ConstraintSet.Constraint)localObject).startToEnd = -1;
      }
      else
      {
        if (paramInt4 != 7) {
          break label305;
        }
        ((ConstraintSet.Constraint)localObject).startToEnd = paramInt3;
        ((ConstraintSet.Constraint)localObject).startToStart = -1;
      }
      ((ConstraintSet.Constraint)localObject).startMargin = paramInt5;
      return;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("right to ");
      ((StringBuilder)localObject).append(sideToString(paramInt4));
      ((StringBuilder)localObject).append(" undefined");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    case 5: 
      if (paramInt4 == 5)
      {
        ((ConstraintSet.Constraint)localObject).baselineToBaseline = paramInt3;
        ((ConstraintSet.Constraint)localObject).bottomToBottom = -1;
        ((ConstraintSet.Constraint)localObject).bottomToTop = -1;
        ((ConstraintSet.Constraint)localObject).topToTop = -1;
        ((ConstraintSet.Constraint)localObject).topToBottom = -1;
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("right to ");
      ((StringBuilder)localObject).append(sideToString(paramInt4));
      ((StringBuilder)localObject).append(" undefined");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    case 4: 
      if (paramInt4 == 4)
      {
        ((ConstraintSet.Constraint)localObject).bottomToBottom = paramInt3;
        ((ConstraintSet.Constraint)localObject).bottomToTop = -1;
        ((ConstraintSet.Constraint)localObject).baselineToBaseline = -1;
      }
      else
      {
        if (paramInt4 != 3) {
          break label505;
        }
        ((ConstraintSet.Constraint)localObject).bottomToTop = paramInt3;
        ((ConstraintSet.Constraint)localObject).bottomToBottom = -1;
        ((ConstraintSet.Constraint)localObject).baselineToBaseline = -1;
      }
      ((ConstraintSet.Constraint)localObject).bottomMargin = paramInt5;
      return;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("right to ");
      ((StringBuilder)localObject).append(sideToString(paramInt4));
      ((StringBuilder)localObject).append(" undefined");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    case 3: 
      if (paramInt4 == 3)
      {
        ((ConstraintSet.Constraint)localObject).topToTop = paramInt3;
        ((ConstraintSet.Constraint)localObject).topToBottom = -1;
        ((ConstraintSet.Constraint)localObject).baselineToBaseline = -1;
      }
      else
      {
        if (paramInt4 != 4) {
          break label616;
        }
        ((ConstraintSet.Constraint)localObject).topToBottom = paramInt3;
        ((ConstraintSet.Constraint)localObject).topToTop = -1;
        ((ConstraintSet.Constraint)localObject).baselineToBaseline = -1;
      }
      ((ConstraintSet.Constraint)localObject).topMargin = paramInt5;
      return;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("right to ");
      ((StringBuilder)localObject).append(sideToString(paramInt4));
      ((StringBuilder)localObject).append(" undefined");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    case 2: 
      label204:
      label505:
      if (paramInt4 == 1)
      {
        ((ConstraintSet.Constraint)localObject).rightToLeft = paramInt3;
        ((ConstraintSet.Constraint)localObject).rightToRight = -1;
      }
      else
      {
        if (paramInt4 != 2) {
          break label715;
        }
        ((ConstraintSet.Constraint)localObject).rightToRight = paramInt3;
        ((ConstraintSet.Constraint)localObject).rightToLeft = -1;
      }
      label305:
      label616:
      ((ConstraintSet.Constraint)localObject).rightMargin = paramInt5;
      return;
      label715:
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("right to ");
      ((StringBuilder)localObject).append(sideToString(paramInt4));
      ((StringBuilder)localObject).append(" undefined");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    if (paramInt4 == 1)
    {
      ((ConstraintSet.Constraint)localObject).leftToLeft = paramInt3;
      ((ConstraintSet.Constraint)localObject).leftToRight = -1;
    }
    else
    {
      if (paramInt4 != 2) {
        break label814;
      }
      ((ConstraintSet.Constraint)localObject).leftToRight = paramInt3;
      ((ConstraintSet.Constraint)localObject).leftToLeft = -1;
    }
    ((ConstraintSet.Constraint)localObject).leftMargin = paramInt5;
    return;
    label814:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Left to ");
    ((StringBuilder)localObject).append(sideToString(paramInt4));
    ((StringBuilder)localObject).append(" undefined");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void constrainDefaultHeight(int paramInt1, int paramInt2)
  {
    get(paramInt1).heightDefault = paramInt2;
  }
  
  public void constrainDefaultWidth(int paramInt1, int paramInt2)
  {
    get(paramInt1).widthDefault = paramInt2;
  }
  
  public void constrainHeight(int paramInt1, int paramInt2)
  {
    get(paramInt1).mHeight = paramInt2;
  }
  
  public void constrainMaxHeight(int paramInt1, int paramInt2)
  {
    get(paramInt1).heightMax = paramInt2;
  }
  
  public void constrainMaxWidth(int paramInt1, int paramInt2)
  {
    get(paramInt1).widthMax = paramInt2;
  }
  
  public void constrainMinHeight(int paramInt1, int paramInt2)
  {
    get(paramInt1).heightMin = paramInt2;
  }
  
  public void constrainMinWidth(int paramInt1, int paramInt2)
  {
    get(paramInt1).widthMin = paramInt2;
  }
  
  public void constrainWidth(int paramInt1, int paramInt2)
  {
    get(paramInt1).mWidth = paramInt2;
  }
  
  public void create(int paramInt1, int paramInt2)
  {
    ConstraintSet.Constraint localConstraint = get(paramInt1);
    localConstraint.mIsGuideline = true;
    localConstraint.orientation = paramInt2;
  }
  
  public void createHorizontalChain(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt5)
  {
    createHorizontalChain(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramArrayOfFloat, paramInt5, 1, 2);
  }
  
  public void createHorizontalChainRtl(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt5)
  {
    createHorizontalChain(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramArrayOfFloat, paramInt5, 6, 7);
  }
  
  public void createVerticalChain(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt5)
  {
    if (paramArrayOfInt.length >= 2)
    {
      if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length != paramArrayOfInt.length)) {
        throw new IllegalArgumentException("must have 2 or more widgets in a chain");
      }
      if (paramArrayOfFloat != null) {
        get(paramArrayOfInt[0]).verticalWeight = paramArrayOfFloat[0];
      }
      get(paramArrayOfInt[0]).verticalChainStyle = paramInt5;
      connect(paramArrayOfInt[0], 3, paramInt1, paramInt2, 0);
      paramInt1 = 1;
      while (paramInt1 < paramArrayOfInt.length)
      {
        paramInt2 = paramArrayOfInt[paramInt1];
        paramInt2 = paramArrayOfInt[paramInt1];
        paramInt5 = paramInt1 - 1;
        connect(paramInt2, 3, paramArrayOfInt[paramInt5], 4, 0);
        connect(paramArrayOfInt[paramInt5], 4, paramArrayOfInt[paramInt1], 3, 0);
        if (paramArrayOfFloat != null) {
          get(paramArrayOfInt[paramInt1]).verticalWeight = paramArrayOfFloat[paramInt1];
        }
        paramInt1 += 1;
      }
      connect(paramArrayOfInt[(paramArrayOfInt.length - 1)], 4, paramInt3, paramInt4, 0);
      return;
    }
    paramArrayOfInt = new IllegalArgumentException("must have 2 or more widgets in a chain");
    for (;;)
    {
      throw paramArrayOfInt;
    }
  }
  
  public boolean getApplyElevation(int paramInt)
  {
    return get(paramInt).applyElevation;
  }
  
  public void load(Context paramContext, int paramInt)
  {
    XmlResourceParser localXmlResourceParser = paramContext.getResources().getXml(paramInt);
    try
    {
      paramInt = localXmlResourceParser.getEventType();
    }
    catch (IOException paramContext)
    {
      String str;
      ConstraintSet.Constraint localConstraint;
      paramContext.printStackTrace();
      return;
    }
    catch (XmlPullParserException paramContext)
    {
      paramContext.printStackTrace();
    }
    str = localXmlResourceParser.getName();
    localConstraint = fillFromAttributeList(paramContext, Xml.asAttributeSet(localXmlResourceParser));
    if (str.equalsIgnoreCase("Guideline")) {
      localConstraint.mIsGuideline = true;
    }
    this.mConstraints.put(Integer.valueOf(localConstraint.mViewId), localConstraint);
    break label83;
    label76:
    localXmlResourceParser.getName();
    for (;;)
    {
      label83:
      paramInt = localXmlResourceParser.next();
      while (paramInt == 1) {
        return;
      }
      if (paramInt == 0) {
        break label76;
      }
      if (paramInt == 2) {
        break;
      }
    }
  }
  
  public void removeFromHorizontalChain(int paramInt)
  {
    if (this.mConstraints.containsKey(Integer.valueOf(paramInt)))
    {
      ConstraintSet.Constraint localConstraint = (ConstraintSet.Constraint)this.mConstraints.get(Integer.valueOf(paramInt));
      int i = localConstraint.leftToRight;
      int j = localConstraint.rightToLeft;
      if ((i == -1) && (j == -1))
      {
        j = localConstraint.startToEnd;
        int k = localConstraint.endToStart;
        if ((j != -1) || (k != -1)) {
          if ((j != -1) && (k != -1))
          {
            connect(j, 7, k, 6, 0);
            connect(k, 6, i, 7, 0);
          }
          else if ((i != -1) || (k != -1))
          {
            if (localConstraint.rightToRight != -1) {
              connect(i, 7, localConstraint.rightToRight, 7, 0);
            } else if (localConstraint.leftToLeft != -1) {
              connect(k, 6, localConstraint.leftToLeft, 6, 0);
            }
          }
        }
        clear(paramInt, 6);
        clear(paramInt, 7);
        return;
      }
      if ((i != -1) && (j != -1))
      {
        connect(i, 2, j, 1, 0);
        connect(j, 1, i, 2, 0);
      }
      else if ((i != -1) || (j != -1))
      {
        if (localConstraint.rightToRight != -1) {
          connect(i, 2, localConstraint.rightToRight, 2, 0);
        } else if (localConstraint.leftToLeft != -1) {
          connect(j, 1, localConstraint.leftToLeft, 1, 0);
        }
      }
      clear(paramInt, 1);
      clear(paramInt, 2);
    }
  }
  
  public void removeFromVerticalChain(int paramInt)
  {
    if (this.mConstraints.containsKey(Integer.valueOf(paramInt)))
    {
      ConstraintSet.Constraint localConstraint = (ConstraintSet.Constraint)this.mConstraints.get(Integer.valueOf(paramInt));
      int i = localConstraint.topToBottom;
      int j = localConstraint.bottomToTop;
      if ((i != -1) || (j != -1)) {
        if ((i != -1) && (j != -1))
        {
          connect(i, 4, j, 3, 0);
          connect(j, 3, i, 4, 0);
        }
        else if ((i != -1) || (j != -1))
        {
          if (localConstraint.bottomToBottom != -1) {
            connect(i, 4, localConstraint.bottomToBottom, 4, 0);
          } else if (localConstraint.topToTop != -1) {
            connect(j, 3, localConstraint.topToTop, 3, 0);
          }
        }
      }
    }
    clear(paramInt, 3);
    clear(paramInt, 4);
  }
  
  public void setAlpha(int paramInt, float paramFloat)
  {
    get(paramInt).alpha = paramFloat;
  }
  
  public void setApplyElevation(int paramInt, boolean paramBoolean)
  {
    get(paramInt).applyElevation = paramBoolean;
  }
  
  public void setDimensionRatio(int paramInt, String paramString)
  {
    get(paramInt).dimensionRatio = paramString;
  }
  
  public void setElevation(int paramInt, float paramFloat)
  {
    get(paramInt).elevation = paramFloat;
    get(paramInt).applyElevation = true;
  }
  
  public void setGoneMargin(int paramInt1, int paramInt2, int paramInt3)
  {
    ConstraintSet.Constraint localConstraint = get(paramInt1);
    switch (paramInt2)
    {
    default: 
      throw new IllegalArgumentException("unknown constraint");
    case 7: 
      localConstraint.goneEndMargin = paramInt3;
      return;
    case 6: 
      localConstraint.goneStartMargin = paramInt3;
      return;
    case 5: 
      throw new IllegalArgumentException("baseline does not support margins");
    case 4: 
      localConstraint.goneBottomMargin = paramInt3;
      return;
    case 3: 
      localConstraint.goneTopMargin = paramInt3;
      return;
    case 2: 
      localConstraint.goneRightMargin = paramInt3;
      return;
    }
    localConstraint.goneLeftMargin = paramInt3;
  }
  
  public void setGuidelineBegin(int paramInt1, int paramInt2)
  {
    get(paramInt1).guideBegin = paramInt2;
    get(paramInt1).guideEnd = -1;
    get(paramInt1).guidePercent = -1.0F;
  }
  
  public void setGuidelineEnd(int paramInt1, int paramInt2)
  {
    get(paramInt1).guideEnd = paramInt2;
    get(paramInt1).guideBegin = -1;
    get(paramInt1).guidePercent = -1.0F;
  }
  
  public void setGuidelinePercent(int paramInt, float paramFloat)
  {
    get(paramInt).guidePercent = paramFloat;
    get(paramInt).guideEnd = -1;
    get(paramInt).guideBegin = -1;
  }
  
  public void setHorizontalBias(int paramInt, float paramFloat)
  {
    get(paramInt).horizontalBias = paramFloat;
  }
  
  public void setHorizontalChainStyle(int paramInt1, int paramInt2)
  {
    get(paramInt1).horizontalChainStyle = paramInt2;
  }
  
  public void setHorizontalWeight(int paramInt, float paramFloat)
  {
    get(paramInt).horizontalWeight = paramFloat;
  }
  
  public void setMargin(int paramInt1, int paramInt2, int paramInt3)
  {
    ConstraintSet.Constraint localConstraint = get(paramInt1);
    switch (paramInt2)
    {
    default: 
      throw new IllegalArgumentException("unknown constraint");
    case 7: 
      localConstraint.endMargin = paramInt3;
      return;
    case 6: 
      localConstraint.startMargin = paramInt3;
      return;
    case 5: 
      throw new IllegalArgumentException("baseline does not support margins");
    case 4: 
      localConstraint.bottomMargin = paramInt3;
      return;
    case 3: 
      localConstraint.topMargin = paramInt3;
      return;
    case 2: 
      localConstraint.rightMargin = paramInt3;
      return;
    }
    localConstraint.leftMargin = paramInt3;
  }
  
  public void setRotationX(int paramInt, float paramFloat)
  {
    get(paramInt).rotationX = paramFloat;
  }
  
  public void setRotationY(int paramInt, float paramFloat)
  {
    get(paramInt).rotationY = paramFloat;
  }
  
  public void setScaleX(int paramInt, float paramFloat)
  {
    get(paramInt).scaleX = paramFloat;
  }
  
  public void setScaleY(int paramInt, float paramFloat)
  {
    get(paramInt).scaleY = paramFloat;
  }
  
  public void setTransformPivot(int paramInt, float paramFloat1, float paramFloat2)
  {
    ConstraintSet.Constraint localConstraint = get(paramInt);
    localConstraint.transformPivotY = paramFloat2;
    localConstraint.transformPivotX = paramFloat1;
  }
  
  public void setTransformPivotX(int paramInt, float paramFloat)
  {
    get(paramInt).transformPivotX = paramFloat;
  }
  
  public void setTransformPivotY(int paramInt, float paramFloat)
  {
    get(paramInt).transformPivotY = paramFloat;
  }
  
  public void setTranslation(int paramInt, float paramFloat1, float paramFloat2)
  {
    ConstraintSet.Constraint localConstraint = get(paramInt);
    localConstraint.translationX = paramFloat1;
    localConstraint.translationY = paramFloat2;
  }
  
  public void setTranslationX(int paramInt, float paramFloat)
  {
    get(paramInt).translationX = paramFloat;
  }
  
  public void setTranslationY(int paramInt, float paramFloat)
  {
    get(paramInt).translationY = paramFloat;
  }
  
  public void setTranslationZ(int paramInt, float paramFloat)
  {
    get(paramInt).translationZ = paramFloat;
  }
  
  public void setVerticalBias(int paramInt, float paramFloat)
  {
    get(paramInt).verticalBias = paramFloat;
  }
  
  public void setVerticalChainStyle(int paramInt1, int paramInt2)
  {
    get(paramInt1).verticalChainStyle = paramInt2;
  }
  
  public void setVerticalWeight(int paramInt, float paramFloat)
  {
    get(paramInt).verticalWeight = paramFloat;
  }
  
  public void setVisibility(int paramInt1, int paramInt2)
  {
    get(paramInt1).visibility = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.constraint.ConstraintSet
 * JD-Core Version:    0.7.0.1
 */