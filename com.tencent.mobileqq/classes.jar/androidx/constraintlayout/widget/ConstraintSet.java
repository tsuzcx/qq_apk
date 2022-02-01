package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ConstraintSet
{
  private static final int ALPHA = 43;
  private static final int ANIMATE_RELATIVE_TO = 64;
  private static final int BARRIER_ALLOWS_GONE_WIDGETS = 75;
  private static final int BARRIER_DIRECTION = 72;
  private static final int BARRIER_MARGIN = 73;
  private static final int BARRIER_TYPE = 1;
  public static final int BASELINE = 5;
  private static final int BASELINE_TO_BASELINE = 1;
  public static final int BOTTOM = 4;
  private static final int BOTTOM_MARGIN = 2;
  private static final int BOTTOM_TO_BOTTOM = 3;
  private static final int BOTTOM_TO_TOP = 4;
  public static final int CHAIN_PACKED = 2;
  public static final int CHAIN_SPREAD = 0;
  public static final int CHAIN_SPREAD_INSIDE = 1;
  private static final int CHAIN_USE_RTL = 71;
  private static final int CIRCLE = 61;
  private static final int CIRCLE_ANGLE = 63;
  private static final int CIRCLE_RADIUS = 62;
  private static final int CONSTRAINED_HEIGHT = 81;
  private static final int CONSTRAINED_WIDTH = 80;
  private static final int CONSTRAINT_REFERENCED_IDS = 74;
  private static final int CONSTRAINT_TAG = 77;
  private static final boolean DEBUG = false;
  private static final int DIMENSION_RATIO = 5;
  private static final int DRAW_PATH = 66;
  private static final int EDITOR_ABSOLUTE_X = 6;
  private static final int EDITOR_ABSOLUTE_Y = 7;
  private static final int ELEVATION = 44;
  public static final int END = 7;
  private static final int END_MARGIN = 8;
  private static final int END_TO_END = 9;
  private static final int END_TO_START = 10;
  private static final String ERROR_MESSAGE = "XML parser error must be within a Constraint ";
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
  private static final int HEIGHT_PERCENT = 70;
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
  private static final int MOTION_STAGGER = 79;
  private static final int ORIENTATION = 27;
  public static final int PARENT_ID = 0;
  private static final int PATH_MOTION_ARC = 76;
  private static final int PROGRESS = 68;
  public static final int RIGHT = 2;
  private static final int RIGHT_MARGIN = 28;
  private static final int RIGHT_TO_LEFT = 29;
  private static final int RIGHT_TO_RIGHT = 30;
  private static final int ROTATION = 60;
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
  private static final int TRANSITION_EASING = 65;
  private static final int TRANSITION_PATH_ROTATE = 67;
  private static final int TRANSLATION_X = 51;
  private static final int TRANSLATION_Y = 52;
  private static final int TRANSLATION_Z = 53;
  public static final int UNSET = -1;
  private static final int UNUSED = 82;
  public static final int VERTICAL = 1;
  private static final int VERTICAL_BIAS = 37;
  public static final int VERTICAL_GUIDELINE = 1;
  private static final int VERTICAL_STYLE = 42;
  private static final int VERTICAL_WEIGHT = 40;
  private static final int VIEW_ID = 38;
  private static final int[] VISIBILITY_FLAGS = { 0, 4, 8 };
  private static final int VISIBILITY_MODE = 78;
  public static final int VISIBILITY_MODE_IGNORE = 1;
  public static final int VISIBILITY_MODE_NORMAL = 0;
  public static final int VISIBLE = 0;
  private static final int WIDTH_DEFAULT = 54;
  private static final int WIDTH_MAX = 56;
  private static final int WIDTH_MIN = 58;
  private static final int WIDTH_PERCENT = 69;
  public static final int WRAP_CONTENT = -2;
  private static SparseIntArray mapToConstant = new SparseIntArray();
  private HashMap<Integer, ConstraintSet.Constraint> mConstraints = new HashMap();
  private boolean mForceId = true;
  private HashMap<String, ConstraintAttribute> mSavedAttributes = new HashMap();
  private boolean mValidate;
  
  static
  {
    mapToConstant.append(R.styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
    mapToConstant.append(R.styleable.Constraint_layout_constraintLeft_toRightOf, 26);
    mapToConstant.append(R.styleable.Constraint_layout_constraintRight_toLeftOf, 29);
    mapToConstant.append(R.styleable.Constraint_layout_constraintRight_toRightOf, 30);
    mapToConstant.append(R.styleable.Constraint_layout_constraintTop_toTopOf, 36);
    mapToConstant.append(R.styleable.Constraint_layout_constraintTop_toBottomOf, 35);
    mapToConstant.append(R.styleable.Constraint_layout_constraintBottom_toTopOf, 4);
    mapToConstant.append(R.styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
    mapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
    mapToConstant.append(R.styleable.Constraint_layout_editor_absoluteX, 6);
    mapToConstant.append(R.styleable.Constraint_layout_editor_absoluteY, 7);
    mapToConstant.append(R.styleable.Constraint_layout_constraintGuide_begin, 17);
    mapToConstant.append(R.styleable.Constraint_layout_constraintGuide_end, 18);
    mapToConstant.append(R.styleable.Constraint_layout_constraintGuide_percent, 19);
    mapToConstant.append(R.styleable.Constraint_android_orientation, 27);
    mapToConstant.append(R.styleable.Constraint_layout_constraintStart_toEndOf, 32);
    mapToConstant.append(R.styleable.Constraint_layout_constraintStart_toStartOf, 33);
    mapToConstant.append(R.styleable.Constraint_layout_constraintEnd_toStartOf, 10);
    mapToConstant.append(R.styleable.Constraint_layout_constraintEnd_toEndOf, 9);
    mapToConstant.append(R.styleable.Constraint_layout_goneMarginLeft, 13);
    mapToConstant.append(R.styleable.Constraint_layout_goneMarginTop, 16);
    mapToConstant.append(R.styleable.Constraint_layout_goneMarginRight, 14);
    mapToConstant.append(R.styleable.Constraint_layout_goneMarginBottom, 11);
    mapToConstant.append(R.styleable.Constraint_layout_goneMarginStart, 15);
    mapToConstant.append(R.styleable.Constraint_layout_goneMarginEnd, 12);
    mapToConstant.append(R.styleable.Constraint_layout_constraintVertical_weight, 40);
    mapToConstant.append(R.styleable.Constraint_layout_constraintHorizontal_weight, 39);
    mapToConstant.append(R.styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
    mapToConstant.append(R.styleable.Constraint_layout_constraintVertical_chainStyle, 42);
    mapToConstant.append(R.styleable.Constraint_layout_constraintHorizontal_bias, 20);
    mapToConstant.append(R.styleable.Constraint_layout_constraintVertical_bias, 37);
    mapToConstant.append(R.styleable.Constraint_layout_constraintDimensionRatio, 5);
    mapToConstant.append(R.styleable.Constraint_layout_constraintLeft_creator, 82);
    mapToConstant.append(R.styleable.Constraint_layout_constraintTop_creator, 82);
    mapToConstant.append(R.styleable.Constraint_layout_constraintRight_creator, 82);
    mapToConstant.append(R.styleable.Constraint_layout_constraintBottom_creator, 82);
    mapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_creator, 82);
    mapToConstant.append(R.styleable.Constraint_android_layout_marginLeft, 24);
    mapToConstant.append(R.styleable.Constraint_android_layout_marginRight, 28);
    mapToConstant.append(R.styleable.Constraint_android_layout_marginStart, 31);
    mapToConstant.append(R.styleable.Constraint_android_layout_marginEnd, 8);
    mapToConstant.append(R.styleable.Constraint_android_layout_marginTop, 34);
    mapToConstant.append(R.styleable.Constraint_android_layout_marginBottom, 2);
    mapToConstant.append(R.styleable.Constraint_android_layout_width, 23);
    mapToConstant.append(R.styleable.Constraint_android_layout_height, 21);
    mapToConstant.append(R.styleable.Constraint_android_visibility, 22);
    mapToConstant.append(R.styleable.Constraint_android_alpha, 43);
    mapToConstant.append(R.styleable.Constraint_android_elevation, 44);
    mapToConstant.append(R.styleable.Constraint_android_rotationX, 45);
    mapToConstant.append(R.styleable.Constraint_android_rotationY, 46);
    mapToConstant.append(R.styleable.Constraint_android_rotation, 60);
    mapToConstant.append(R.styleable.Constraint_android_scaleX, 47);
    mapToConstant.append(R.styleable.Constraint_android_scaleY, 48);
    mapToConstant.append(R.styleable.Constraint_android_transformPivotX, 49);
    mapToConstant.append(R.styleable.Constraint_android_transformPivotY, 50);
    mapToConstant.append(R.styleable.Constraint_android_translationX, 51);
    mapToConstant.append(R.styleable.Constraint_android_translationY, 52);
    mapToConstant.append(R.styleable.Constraint_android_translationZ, 53);
    mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_default, 54);
    mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_default, 55);
    mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_max, 56);
    mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_max, 57);
    mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_min, 58);
    mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_min, 59);
    mapToConstant.append(R.styleable.Constraint_layout_constraintCircle, 61);
    mapToConstant.append(R.styleable.Constraint_layout_constraintCircleRadius, 62);
    mapToConstant.append(R.styleable.Constraint_layout_constraintCircleAngle, 63);
    mapToConstant.append(R.styleable.Constraint_animate_relativeTo, 64);
    mapToConstant.append(R.styleable.Constraint_transitionEasing, 65);
    mapToConstant.append(R.styleable.Constraint_drawPath, 66);
    mapToConstant.append(R.styleable.Constraint_transitionPathRotate, 67);
    mapToConstant.append(R.styleable.Constraint_motionStagger, 79);
    mapToConstant.append(R.styleable.Constraint_android_id, 38);
    mapToConstant.append(R.styleable.Constraint_motionProgress, 68);
    mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_percent, 69);
    mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_percent, 70);
    mapToConstant.append(R.styleable.Constraint_chainUseRtl, 71);
    mapToConstant.append(R.styleable.Constraint_barrierDirection, 72);
    mapToConstant.append(R.styleable.Constraint_barrierMargin, 73);
    mapToConstant.append(R.styleable.Constraint_constraint_referenced_ids, 74);
    mapToConstant.append(R.styleable.Constraint_barrierAllowsGoneWidgets, 75);
    mapToConstant.append(R.styleable.Constraint_pathMotionArc, 76);
    mapToConstant.append(R.styleable.Constraint_layout_constraintTag, 77);
    mapToConstant.append(R.styleable.Constraint_visibilityMode, 78);
    mapToConstant.append(R.styleable.Constraint_layout_constrainedWidth, 80);
    mapToConstant.append(R.styleable.Constraint_layout_constrainedHeight, 81);
  }
  
  private void addAttributes(ConstraintAttribute.AttributeType paramAttributeType, String... paramVarArgs)
  {
    int i = 0;
    while (i < paramVarArgs.length)
    {
      ConstraintAttribute localConstraintAttribute;
      if (this.mSavedAttributes.containsKey(paramVarArgs[i]))
      {
        localConstraintAttribute = (ConstraintAttribute)this.mSavedAttributes.get(paramVarArgs[i]);
        if (localConstraintAttribute.getType() != paramAttributeType)
        {
          paramAttributeType = new StringBuilder();
          paramAttributeType.append("ConstraintAttribute is already a ");
          paramAttributeType.append(localConstraintAttribute.getType().name());
          throw new IllegalArgumentException(paramAttributeType.toString());
        }
      }
      else
      {
        localConstraintAttribute = new ConstraintAttribute(paramVarArgs[i], paramAttributeType);
        this.mSavedAttributes.put(paramVarArgs[i], localConstraintAttribute);
      }
      i += 1;
    }
  }
  
  private int[] convertReferenceString(View paramView, String paramString)
  {
    String[] arrayOfString = paramString.split(",");
    Context localContext = paramView.getContext();
    paramString = new int[arrayOfString.length];
    int m = 0;
    int k = 0;
    while (m < arrayOfString.length)
    {
      Object localObject = arrayOfString[m].trim();
      try
      {
        j = R.id.class.getField((String)localObject).getInt(null);
      }
      catch (Exception localException)
      {
        int j;
        label62:
        int i;
        break label62;
      }
      j = 0;
      i = j;
      if (j == 0) {
        i = localContext.getResources().getIdentifier((String)localObject, "id", localContext.getPackageName());
      }
      j = i;
      if (i == 0)
      {
        j = i;
        if (paramView.isInEditMode())
        {
          j = i;
          if ((paramView.getParent() instanceof ConstraintLayout))
          {
            localObject = ((ConstraintLayout)paramView.getParent()).getDesignInformation(0, localObject);
            j = i;
            if (localObject != null)
            {
              j = i;
              if ((localObject instanceof Integer)) {
                j = ((Integer)localObject).intValue();
              }
            }
          }
        }
      }
      paramString[k] = j;
      m += 1;
      k += 1;
    }
    paramView = paramString;
    if (k != arrayOfString.length) {
      paramView = Arrays.copyOf(paramString, k);
    }
    return paramView;
  }
  
  private void createHorizontalChain(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt5, int paramInt6, int paramInt7)
  {
    if (paramArrayOfInt.length >= 2)
    {
      if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length != paramArrayOfInt.length)) {
        throw new IllegalArgumentException("must have 2 or more widgets in a chain");
      }
      if (paramArrayOfFloat != null) {
        get(paramArrayOfInt[0]).layout.horizontalWeight = paramArrayOfFloat[0];
      }
      get(paramArrayOfInt[0]).layout.horizontalChainStyle = paramInt5;
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
          get(paramArrayOfInt[paramInt1]).layout.horizontalWeight = paramArrayOfFloat[paramInt1];
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
    ConstraintSet.Constraint localConstraint = new ConstraintSet.Constraint();
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.Constraint);
    populateConstraint(paramContext, localConstraint, paramAttributeSet);
    paramAttributeSet.recycle();
    return localConstraint;
  }
  
  private ConstraintSet.Constraint get(int paramInt)
  {
    if (!this.mConstraints.containsKey(Integer.valueOf(paramInt))) {
      this.mConstraints.put(Integer.valueOf(paramInt), new ConstraintSet.Constraint());
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
  
  private void populateConstraint(Context paramContext, ConstraintSet.Constraint paramConstraint, TypedArray paramTypedArray)
  {
    int j = paramTypedArray.getIndexCount();
    int i = 0;
    while (i < j)
    {
      int k = paramTypedArray.getIndex(i);
      if ((k != R.styleable.Constraint_android_id) && (R.styleable.Constraint_android_layout_marginStart != k) && (R.styleable.Constraint_android_layout_marginEnd != k))
      {
        paramConstraint.motion.mApply = true;
        paramConstraint.layout.mApply = true;
        paramConstraint.propertySet.mApply = true;
        paramConstraint.transform.mApply = true;
      }
      switch (mapToConstant.get(k))
      {
      default: 
        paramContext = new StringBuilder();
        paramContext.append("Unknown attribute 0x");
        paramContext.append(Integer.toHexString(k));
        paramContext.append("   ");
        paramContext.append(mapToConstant.get(k));
        Log.w("ConstraintSet", paramContext.toString());
        break;
      case 82: 
        paramContext = new StringBuilder();
        paramContext.append("unused attribute 0x");
        paramContext.append(Integer.toHexString(k));
        paramContext.append("   ");
        paramContext.append(mapToConstant.get(k));
        Log.w("ConstraintSet", paramContext.toString());
        break;
      case 81: 
        paramConstraint.layout.constrainedHeight = paramTypedArray.getBoolean(k, paramConstraint.layout.constrainedHeight);
        break;
      case 80: 
        paramConstraint.layout.constrainedWidth = paramTypedArray.getBoolean(k, paramConstraint.layout.constrainedWidth);
        break;
      case 79: 
        paramConstraint.motion.mMotionStagger = paramTypedArray.getFloat(k, paramConstraint.motion.mMotionStagger);
        break;
      case 78: 
        paramConstraint.propertySet.mVisibilityMode = paramTypedArray.getInt(k, paramConstraint.propertySet.mVisibilityMode);
        break;
      case 77: 
        paramConstraint.layout.mConstraintTag = paramTypedArray.getString(k);
        break;
      case 76: 
        paramConstraint.motion.mPathMotionArc = paramTypedArray.getInt(k, paramConstraint.motion.mPathMotionArc);
        break;
      case 75: 
        paramConstraint.layout.mBarrierAllowsGoneWidgets = paramTypedArray.getBoolean(k, paramConstraint.layout.mBarrierAllowsGoneWidgets);
        break;
      case 74: 
        paramConstraint.layout.mReferenceIdString = paramTypedArray.getString(k);
        break;
      case 73: 
        paramConstraint.layout.mBarrierMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.layout.mBarrierMargin);
        break;
      case 72: 
        paramConstraint.layout.mBarrierDirection = paramTypedArray.getInt(k, paramConstraint.layout.mBarrierDirection);
        break;
      case 71: 
        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
        break;
      case 70: 
        paramConstraint.layout.heightPercent = paramTypedArray.getFloat(k, 1.0F);
        break;
      case 69: 
        paramConstraint.layout.widthPercent = paramTypedArray.getFloat(k, 1.0F);
        break;
      case 68: 
        paramConstraint.propertySet.mProgress = paramTypedArray.getFloat(k, paramConstraint.propertySet.mProgress);
        break;
      case 67: 
        paramConstraint.motion.mPathRotate = paramTypedArray.getFloat(k, paramConstraint.motion.mPathRotate);
        break;
      case 66: 
        paramConstraint.motion.mDrawPath = paramTypedArray.getInt(k, 0);
        break;
      case 65: 
        if (paramTypedArray.peekValue(k).type == 3) {
          paramConstraint.motion.mTransitionEasing = paramTypedArray.getString(k);
        } else {
          paramConstraint.motion.mTransitionEasing = androidx.constraintlayout.motion.utils.Easing.NAMED_EASING[paramTypedArray.getInteger(k, 0)];
        }
        break;
      case 64: 
        paramConstraint.motion.mAnimateRelativeTo = lookupID(paramTypedArray, k, paramConstraint.motion.mAnimateRelativeTo);
        break;
      case 63: 
        paramConstraint.layout.circleAngle = paramTypedArray.getFloat(k, paramConstraint.layout.circleAngle);
        break;
      case 62: 
        paramConstraint.layout.circleRadius = paramTypedArray.getDimensionPixelSize(k, paramConstraint.layout.circleRadius);
        break;
      case 61: 
        paramConstraint.layout.circleConstraint = lookupID(paramTypedArray, k, paramConstraint.layout.circleConstraint);
        break;
      case 60: 
        paramConstraint.transform.rotation = paramTypedArray.getFloat(k, paramConstraint.transform.rotation);
        break;
      case 59: 
        paramConstraint.layout.heightMin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.layout.heightMin);
        break;
      case 58: 
        paramConstraint.layout.widthMin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.layout.widthMin);
        break;
      case 57: 
        paramConstraint.layout.heightMax = paramTypedArray.getDimensionPixelSize(k, paramConstraint.layout.heightMax);
        break;
      case 56: 
        paramConstraint.layout.widthMax = paramTypedArray.getDimensionPixelSize(k, paramConstraint.layout.widthMax);
        break;
      case 55: 
        paramConstraint.layout.heightDefault = paramTypedArray.getInt(k, paramConstraint.layout.heightDefault);
        break;
      case 54: 
        paramConstraint.layout.widthDefault = paramTypedArray.getInt(k, paramConstraint.layout.widthDefault);
        break;
      case 53: 
        if (Build.VERSION.SDK_INT >= 21) {
          paramConstraint.transform.translationZ = paramTypedArray.getDimension(k, paramConstraint.transform.translationZ);
        }
        break;
      case 52: 
        paramConstraint.transform.translationY = paramTypedArray.getDimension(k, paramConstraint.transform.translationY);
        break;
      case 51: 
        paramConstraint.transform.translationX = paramTypedArray.getDimension(k, paramConstraint.transform.translationX);
        break;
      case 50: 
        paramConstraint.transform.transformPivotY = paramTypedArray.getDimension(k, paramConstraint.transform.transformPivotY);
        break;
      case 49: 
        paramConstraint.transform.transformPivotX = paramTypedArray.getDimension(k, paramConstraint.transform.transformPivotX);
        break;
      case 48: 
        paramConstraint.transform.scaleY = paramTypedArray.getFloat(k, paramConstraint.transform.scaleY);
        break;
      case 47: 
        paramConstraint.transform.scaleX = paramTypedArray.getFloat(k, paramConstraint.transform.scaleX);
        break;
      case 46: 
        paramConstraint.transform.rotationY = paramTypedArray.getFloat(k, paramConstraint.transform.rotationY);
        break;
      case 45: 
        paramConstraint.transform.rotationX = paramTypedArray.getFloat(k, paramConstraint.transform.rotationX);
        break;
      case 44: 
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramConstraint.transform.applyElevation = true;
          paramConstraint.transform.elevation = paramTypedArray.getDimension(k, paramConstraint.transform.elevation);
        }
        break;
      case 43: 
        paramConstraint.propertySet.alpha = paramTypedArray.getFloat(k, paramConstraint.propertySet.alpha);
        break;
      case 42: 
        paramConstraint.layout.verticalChainStyle = paramTypedArray.getInt(k, paramConstraint.layout.verticalChainStyle);
        break;
      case 41: 
        paramConstraint.layout.horizontalChainStyle = paramTypedArray.getInt(k, paramConstraint.layout.horizontalChainStyle);
        break;
      case 40: 
        paramConstraint.layout.verticalWeight = paramTypedArray.getFloat(k, paramConstraint.layout.verticalWeight);
        break;
      case 39: 
        paramConstraint.layout.horizontalWeight = paramTypedArray.getFloat(k, paramConstraint.layout.horizontalWeight);
        break;
      case 38: 
        paramConstraint.mViewId = paramTypedArray.getResourceId(k, paramConstraint.mViewId);
        break;
      case 37: 
        paramConstraint.layout.verticalBias = paramTypedArray.getFloat(k, paramConstraint.layout.verticalBias);
        break;
      case 36: 
        paramConstraint.layout.topToTop = lookupID(paramTypedArray, k, paramConstraint.layout.topToTop);
        break;
      case 35: 
        paramConstraint.layout.topToBottom = lookupID(paramTypedArray, k, paramConstraint.layout.topToBottom);
        break;
      case 34: 
        paramConstraint.layout.topMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.layout.topMargin);
        break;
      case 33: 
        paramConstraint.layout.startToStart = lookupID(paramTypedArray, k, paramConstraint.layout.startToStart);
        break;
      case 32: 
        paramConstraint.layout.startToEnd = lookupID(paramTypedArray, k, paramConstraint.layout.startToEnd);
        break;
      case 31: 
        if (Build.VERSION.SDK_INT >= 17) {
          paramConstraint.layout.startMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.layout.startMargin);
        }
        break;
      case 30: 
        paramConstraint.layout.rightToRight = lookupID(paramTypedArray, k, paramConstraint.layout.rightToRight);
        break;
      case 29: 
        paramConstraint.layout.rightToLeft = lookupID(paramTypedArray, k, paramConstraint.layout.rightToLeft);
        break;
      case 28: 
        paramConstraint.layout.rightMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.layout.rightMargin);
        break;
      case 27: 
        paramConstraint.layout.orientation = paramTypedArray.getInt(k, paramConstraint.layout.orientation);
        break;
      case 26: 
        paramConstraint.layout.leftToRight = lookupID(paramTypedArray, k, paramConstraint.layout.leftToRight);
        break;
      case 25: 
        paramConstraint.layout.leftToLeft = lookupID(paramTypedArray, k, paramConstraint.layout.leftToLeft);
        break;
      case 24: 
        paramConstraint.layout.leftMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.layout.leftMargin);
        break;
      case 23: 
        paramConstraint.layout.mWidth = paramTypedArray.getLayoutDimension(k, paramConstraint.layout.mWidth);
        break;
      case 22: 
        paramConstraint.propertySet.visibility = paramTypedArray.getInt(k, paramConstraint.propertySet.visibility);
        paramConstraint.propertySet.visibility = VISIBILITY_FLAGS[paramConstraint.propertySet.visibility];
        break;
      case 21: 
        paramConstraint.layout.mHeight = paramTypedArray.getLayoutDimension(k, paramConstraint.layout.mHeight);
        break;
      case 20: 
        paramConstraint.layout.horizontalBias = paramTypedArray.getFloat(k, paramConstraint.layout.horizontalBias);
        break;
      case 19: 
        paramConstraint.layout.guidePercent = paramTypedArray.getFloat(k, paramConstraint.layout.guidePercent);
        break;
      case 18: 
        paramConstraint.layout.guideEnd = paramTypedArray.getDimensionPixelOffset(k, paramConstraint.layout.guideEnd);
        break;
      case 17: 
        paramConstraint.layout.guideBegin = paramTypedArray.getDimensionPixelOffset(k, paramConstraint.layout.guideBegin);
        break;
      case 16: 
        paramConstraint.layout.goneTopMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.layout.goneTopMargin);
        break;
      case 15: 
        paramConstraint.layout.goneStartMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.layout.goneStartMargin);
        break;
      case 14: 
        paramConstraint.layout.goneRightMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.layout.goneRightMargin);
        break;
      case 13: 
        paramConstraint.layout.goneLeftMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.layout.goneLeftMargin);
        break;
      case 12: 
        paramConstraint.layout.goneEndMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.layout.goneEndMargin);
        break;
      case 11: 
        paramConstraint.layout.goneBottomMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.layout.goneBottomMargin);
        break;
      case 10: 
        paramConstraint.layout.endToStart = lookupID(paramTypedArray, k, paramConstraint.layout.endToStart);
        break;
      case 9: 
        paramConstraint.layout.endToEnd = lookupID(paramTypedArray, k, paramConstraint.layout.endToEnd);
        break;
      case 8: 
        if (Build.VERSION.SDK_INT >= 17) {
          paramConstraint.layout.endMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.layout.endMargin);
        }
        break;
      case 7: 
        paramConstraint.layout.editorAbsoluteY = paramTypedArray.getDimensionPixelOffset(k, paramConstraint.layout.editorAbsoluteY);
        break;
      case 6: 
        paramConstraint.layout.editorAbsoluteX = paramTypedArray.getDimensionPixelOffset(k, paramConstraint.layout.editorAbsoluteX);
        break;
      case 5: 
        paramConstraint.layout.dimensionRatio = paramTypedArray.getString(k);
        break;
      case 4: 
        paramConstraint.layout.bottomToTop = lookupID(paramTypedArray, k, paramConstraint.layout.bottomToTop);
        break;
      case 3: 
        paramConstraint.layout.bottomToBottom = lookupID(paramTypedArray, k, paramConstraint.layout.bottomToBottom);
        break;
      case 2: 
        paramConstraint.layout.bottomMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.layout.bottomMargin);
        break;
      case 1: 
        paramConstraint.layout.baselineToBaseline = lookupID(paramTypedArray, k, paramConstraint.layout.baselineToBaseline);
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
  
  private static String[] splitString(String paramString)
  {
    paramString = paramString.toCharArray();
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    int k = 0;
    int n;
    for (int i = 0; j < paramString.length; i = n)
    {
      int m;
      if ((paramString[j] == ',') && (i == 0))
      {
        localArrayList.add(new String(paramString, k, j - k));
        m = j + 1;
        n = i;
      }
      else
      {
        m = k;
        n = i;
        if (paramString[j] == '"')
        {
          n = i ^ 0x1;
          m = k;
        }
      }
      j += 1;
      k = m;
    }
    localArrayList.add(new String(paramString, k, paramString.length - k));
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  public void addColorAttributes(String... paramVarArgs)
  {
    addAttributes(ConstraintAttribute.AttributeType.COLOR_TYPE, paramVarArgs);
  }
  
  public void addFloatAttributes(String... paramVarArgs)
  {
    addAttributes(ConstraintAttribute.AttributeType.FLOAT_TYPE, paramVarArgs);
  }
  
  public void addIntAttributes(String... paramVarArgs)
  {
    addAttributes(ConstraintAttribute.AttributeType.INT_TYPE, paramVarArgs);
  }
  
  public void addStringAttributes(String... paramVarArgs)
  {
    addAttributes(ConstraintAttribute.AttributeType.STRING_TYPE, paramVarArgs);
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
    if (paramInt3 != 0) {
      connect(paramInt3, 3, paramInt1, 4, 0);
    }
  }
  
  public void applyCustomAttributes(ConstraintLayout paramConstraintLayout)
  {
    int j = paramConstraintLayout.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = paramConstraintLayout.getChildAt(i);
      int k = localView.getId();
      if (!this.mConstraints.containsKey(Integer.valueOf(k)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("id unknown ");
        localStringBuilder.append(Debug.getName(localView));
        Log.v("ConstraintSet", localStringBuilder.toString());
      }
      else
      {
        if ((this.mForceId) && (k == -1)) {
          throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
        }
        if (this.mConstraints.containsKey(Integer.valueOf(k))) {
          ConstraintAttribute.setAttributes(localView, ((ConstraintSet.Constraint)this.mConstraints.get(Integer.valueOf(k))).mCustomConstraints);
        }
      }
      i += 1;
    }
  }
  
  public void applyTo(ConstraintLayout paramConstraintLayout)
  {
    applyToInternal(paramConstraintLayout, true);
    paramConstraintLayout.setConstraintSet(null);
    paramConstraintLayout.requestLayout();
  }
  
  public void applyToHelper(ConstraintHelper paramConstraintHelper, ConstraintWidget paramConstraintWidget, ConstraintLayout.LayoutParams paramLayoutParams, SparseArray<ConstraintWidget> paramSparseArray)
  {
    int i = paramConstraintHelper.getId();
    if (this.mConstraints.containsKey(Integer.valueOf(i)))
    {
      ConstraintSet.Constraint localConstraint = (ConstraintSet.Constraint)this.mConstraints.get(Integer.valueOf(i));
      if ((paramConstraintWidget instanceof HelperWidget)) {
        paramConstraintHelper.loadParameters(localConstraint, (HelperWidget)paramConstraintWidget, paramLayoutParams, paramSparseArray);
      }
    }
  }
  
  void applyToInternal(ConstraintLayout paramConstraintLayout, boolean paramBoolean)
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
      if (!this.mConstraints.containsKey(Integer.valueOf(k)))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("id unknown ");
        ((StringBuilder)localObject3).append(Debug.getName((View)localObject2));
        Log.w("ConstraintSet", ((StringBuilder)localObject3).toString());
      }
      else
      {
        if ((this.mForceId) && (k == -1)) {
          throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
        }
        if (k != -1) {
          if (this.mConstraints.containsKey(Integer.valueOf(k)))
          {
            ((HashSet)localObject1).remove(Integer.valueOf(k));
            localObject3 = (ConstraintSet.Constraint)this.mConstraints.get(Integer.valueOf(k));
            if ((localObject2 instanceof Barrier)) {
              ((ConstraintSet.Constraint)localObject3).layout.mHelperType = 1;
            }
            if ((((ConstraintSet.Constraint)localObject3).layout.mHelperType != -1) && (((ConstraintSet.Constraint)localObject3).layout.mHelperType == 1))
            {
              localObject4 = (Barrier)localObject2;
              ((Barrier)localObject4).setId(k);
              ((Barrier)localObject4).setType(((ConstraintSet.Constraint)localObject3).layout.mBarrierDirection);
              ((Barrier)localObject4).setMargin(((ConstraintSet.Constraint)localObject3).layout.mBarrierMargin);
              ((Barrier)localObject4).setAllowsGoneWidget(((ConstraintSet.Constraint)localObject3).layout.mBarrierAllowsGoneWidgets);
              if (((ConstraintSet.Constraint)localObject3).layout.mReferenceIds != null)
              {
                ((Barrier)localObject4).setReferencedIds(((ConstraintSet.Constraint)localObject3).layout.mReferenceIds);
              }
              else if (((ConstraintSet.Constraint)localObject3).layout.mReferenceIdString != null)
              {
                ((ConstraintSet.Constraint)localObject3).layout.mReferenceIds = convertReferenceString((View)localObject4, ((ConstraintSet.Constraint)localObject3).layout.mReferenceIdString);
                ((Barrier)localObject4).setReferencedIds(((ConstraintSet.Constraint)localObject3).layout.mReferenceIds);
              }
            }
            localObject4 = (ConstraintLayout.LayoutParams)((View)localObject2).getLayoutParams();
            ((ConstraintLayout.LayoutParams)localObject4).validate();
            ((ConstraintSet.Constraint)localObject3).applyTo((ConstraintLayout.LayoutParams)localObject4);
            if (paramBoolean) {
              ConstraintAttribute.setAttributes((View)localObject2, ((ConstraintSet.Constraint)localObject3).mCustomConstraints);
            }
            ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject4);
            if (((ConstraintSet.Constraint)localObject3).propertySet.mVisibilityMode == 0) {
              ((View)localObject2).setVisibility(((ConstraintSet.Constraint)localObject3).propertySet.visibility);
            }
            if (Build.VERSION.SDK_INT >= 17)
            {
              ((View)localObject2).setAlpha(((ConstraintSet.Constraint)localObject3).propertySet.alpha);
              ((View)localObject2).setRotation(((ConstraintSet.Constraint)localObject3).transform.rotation);
              ((View)localObject2).setRotationX(((ConstraintSet.Constraint)localObject3).transform.rotationX);
              ((View)localObject2).setRotationY(((ConstraintSet.Constraint)localObject3).transform.rotationY);
              ((View)localObject2).setScaleX(((ConstraintSet.Constraint)localObject3).transform.scaleX);
              ((View)localObject2).setScaleY(((ConstraintSet.Constraint)localObject3).transform.scaleY);
              if (!Float.isNaN(((ConstraintSet.Constraint)localObject3).transform.transformPivotX)) {
                ((View)localObject2).setPivotX(((ConstraintSet.Constraint)localObject3).transform.transformPivotX);
              }
              if (!Float.isNaN(((ConstraintSet.Constraint)localObject3).transform.transformPivotY)) {
                ((View)localObject2).setPivotY(((ConstraintSet.Constraint)localObject3).transform.transformPivotY);
              }
              ((View)localObject2).setTranslationX(((ConstraintSet.Constraint)localObject3).transform.translationX);
              ((View)localObject2).setTranslationY(((ConstraintSet.Constraint)localObject3).transform.translationY);
              if (Build.VERSION.SDK_INT >= 21)
              {
                ((View)localObject2).setTranslationZ(((ConstraintSet.Constraint)localObject3).transform.translationZ);
                if (((ConstraintSet.Constraint)localObject3).transform.applyElevation) {
                  ((View)localObject2).setElevation(((ConstraintSet.Constraint)localObject3).transform.elevation);
                }
              }
            }
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("WARNING NO CONSTRAINTS for view ");
            ((StringBuilder)localObject2).append(k);
            Log.v("ConstraintSet", ((StringBuilder)localObject2).toString());
          }
        }
      }
      i += 1;
    }
    localObject1 = ((HashSet)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (Integer)((Iterator)localObject1).next();
      localObject2 = (ConstraintSet.Constraint)this.mConstraints.get(localObject3);
      if ((((ConstraintSet.Constraint)localObject2).layout.mHelperType != -1) && (((ConstraintSet.Constraint)localObject2).layout.mHelperType == 1))
      {
        localObject4 = new Barrier(paramConstraintLayout.getContext());
        ((Barrier)localObject4).setId(((Integer)localObject3).intValue());
        if (((ConstraintSet.Constraint)localObject2).layout.mReferenceIds != null)
        {
          ((Barrier)localObject4).setReferencedIds(((ConstraintSet.Constraint)localObject2).layout.mReferenceIds);
        }
        else if (((ConstraintSet.Constraint)localObject2).layout.mReferenceIdString != null)
        {
          ((ConstraintSet.Constraint)localObject2).layout.mReferenceIds = convertReferenceString((View)localObject4, ((ConstraintSet.Constraint)localObject2).layout.mReferenceIdString);
          ((Barrier)localObject4).setReferencedIds(((ConstraintSet.Constraint)localObject2).layout.mReferenceIds);
        }
        ((Barrier)localObject4).setType(((ConstraintSet.Constraint)localObject2).layout.mBarrierDirection);
        ((Barrier)localObject4).setMargin(((ConstraintSet.Constraint)localObject2).layout.mBarrierMargin);
        ConstraintLayout.LayoutParams localLayoutParams = paramConstraintLayout.generateDefaultLayoutParams();
        ((Barrier)localObject4).validateParams();
        ((ConstraintSet.Constraint)localObject2).applyTo(localLayoutParams);
        paramConstraintLayout.addView((View)localObject4, localLayoutParams);
      }
      if (((ConstraintSet.Constraint)localObject2).layout.mIsGuideline)
      {
        localObject4 = new Guideline(paramConstraintLayout.getContext());
        ((Guideline)localObject4).setId(((Integer)localObject3).intValue());
        localObject3 = paramConstraintLayout.generateDefaultLayoutParams();
        ((ConstraintSet.Constraint)localObject2).applyTo((ConstraintLayout.LayoutParams)localObject3);
        paramConstraintLayout.addView((View)localObject4, (ViewGroup.LayoutParams)localObject3);
      }
    }
  }
  
  public void applyToLayoutParams(int paramInt, ConstraintLayout.LayoutParams paramLayoutParams)
  {
    if (this.mConstraints.containsKey(Integer.valueOf(paramInt))) {
      ((ConstraintSet.Constraint)this.mConstraints.get(Integer.valueOf(paramInt))).applyTo(paramLayoutParams);
    }
  }
  
  public void applyToWithoutCustom(ConstraintLayout paramConstraintLayout)
  {
    applyToInternal(paramConstraintLayout, false);
    paramConstraintLayout.setConstraintSet(null);
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
              ((ConstraintSet.Constraint)this.mConstraints.get(Integer.valueOf(paramInt1))).layout.verticalBias = paramFloat;
              return;
            }
            connect(paramInt1, 6, paramInt2, paramInt3, paramInt4);
            connect(paramInt1, 7, paramInt5, paramInt6, paramInt7);
            ((ConstraintSet.Constraint)this.mConstraints.get(Integer.valueOf(paramInt1))).layout.horizontalBias = paramFloat;
            return;
          }
          connect(paramInt1, 1, paramInt2, paramInt3, paramInt4);
          connect(paramInt1, 2, paramInt5, paramInt6, paramInt7);
          ((ConstraintSet.Constraint)this.mConstraints.get(Integer.valueOf(paramInt1))).layout.horizontalBias = paramFloat;
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
    ((ConstraintSet.Constraint)this.mConstraints.get(Integer.valueOf(paramInt1))).layout.horizontalBias = paramFloat;
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
    ((ConstraintSet.Constraint)this.mConstraints.get(Integer.valueOf(paramInt1))).layout.horizontalBias = paramFloat;
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
    ((ConstraintSet.Constraint)this.mConstraints.get(Integer.valueOf(paramInt1))).layout.verticalBias = paramFloat;
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
        localConstraint.layout.endToStart = -1;
        localConstraint.layout.endToEnd = -1;
        localConstraint.layout.endMargin = -1;
        localConstraint.layout.goneEndMargin = -1;
        return;
      case 6: 
        localConstraint.layout.startToEnd = -1;
        localConstraint.layout.startToStart = -1;
        localConstraint.layout.startMargin = -1;
        localConstraint.layout.goneStartMargin = -1;
        return;
      case 5: 
        localConstraint.layout.baselineToBaseline = -1;
        return;
      case 4: 
        localConstraint.layout.bottomToTop = -1;
        localConstraint.layout.bottomToBottom = -1;
        localConstraint.layout.bottomMargin = -1;
        localConstraint.layout.goneBottomMargin = -1;
        return;
      case 3: 
        localConstraint.layout.topToBottom = -1;
        localConstraint.layout.topToTop = -1;
        localConstraint.layout.topMargin = -1;
        localConstraint.layout.goneTopMargin = -1;
        return;
      case 2: 
        localConstraint.layout.rightToRight = -1;
        localConstraint.layout.rightToLeft = -1;
        localConstraint.layout.rightMargin = -1;
        localConstraint.layout.goneRightMargin = -1;
        return;
      }
      localConstraint.layout.leftToRight = -1;
      localConstraint.layout.leftToLeft = -1;
      localConstraint.layout.leftMargin = -1;
      localConstraint.layout.goneLeftMargin = -1;
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
      Object localObject = paramConstraintLayout.getChildAt(i);
      ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)((View)localObject).getLayoutParams();
      int k = ((View)localObject).getId();
      if ((this.mForceId) && (k == -1)) {
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
      }
      if (!this.mConstraints.containsKey(Integer.valueOf(k))) {
        this.mConstraints.put(Integer.valueOf(k), new ConstraintSet.Constraint());
      }
      ConstraintSet.Constraint localConstraint = (ConstraintSet.Constraint)this.mConstraints.get(Integer.valueOf(k));
      localConstraint.mCustomConstraints = ConstraintAttribute.extractAttributes(this.mSavedAttributes, (View)localObject);
      ConstraintSet.Constraint.access$000(localConstraint, k, localLayoutParams);
      localConstraint.propertySet.visibility = ((View)localObject).getVisibility();
      if (Build.VERSION.SDK_INT >= 17)
      {
        localConstraint.propertySet.alpha = ((View)localObject).getAlpha();
        localConstraint.transform.rotation = ((View)localObject).getRotation();
        localConstraint.transform.rotationX = ((View)localObject).getRotationX();
        localConstraint.transform.rotationY = ((View)localObject).getRotationY();
        localConstraint.transform.scaleX = ((View)localObject).getScaleX();
        localConstraint.transform.scaleY = ((View)localObject).getScaleY();
        float f1 = ((View)localObject).getPivotX();
        float f2 = ((View)localObject).getPivotY();
        if ((f1 != 0.0D) || (f2 != 0.0D))
        {
          localConstraint.transform.transformPivotX = f1;
          localConstraint.transform.transformPivotY = f2;
        }
        localConstraint.transform.translationX = ((View)localObject).getTranslationX();
        localConstraint.transform.translationY = ((View)localObject).getTranslationY();
        if (Build.VERSION.SDK_INT >= 21)
        {
          localConstraint.transform.translationZ = ((View)localObject).getTranslationZ();
          if (localConstraint.transform.applyElevation) {
            localConstraint.transform.elevation = ((View)localObject).getElevation();
          }
        }
      }
      if ((localObject instanceof Barrier))
      {
        localObject = (Barrier)localObject;
        localConstraint.layout.mBarrierAllowsGoneWidgets = ((Barrier)localObject).allowsGoneWidget();
        localConstraint.layout.mReferenceIds = ((Barrier)localObject).getReferencedIds();
        localConstraint.layout.mBarrierDirection = ((Barrier)localObject).getType();
        localConstraint.layout.mBarrierMargin = ((Barrier)localObject).getMargin();
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
  
  public void clone(Constraints paramConstraints)
  {
    int j = paramConstraints.getChildCount();
    this.mConstraints.clear();
    int i = 0;
    while (i < j)
    {
      View localView = paramConstraints.getChildAt(i);
      Constraints.LayoutParams localLayoutParams = (Constraints.LayoutParams)localView.getLayoutParams();
      int k = localView.getId();
      if ((this.mForceId) && (k == -1)) {
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
      }
      if (!this.mConstraints.containsKey(Integer.valueOf(k))) {
        this.mConstraints.put(Integer.valueOf(k), new ConstraintSet.Constraint());
      }
      ConstraintSet.Constraint localConstraint = (ConstraintSet.Constraint)this.mConstraints.get(Integer.valueOf(k));
      if ((localView instanceof ConstraintHelper)) {
        ConstraintSet.Constraint.access$300(localConstraint, (ConstraintHelper)localView, k, localLayoutParams);
      }
      ConstraintSet.Constraint.access$400(localConstraint, k, localLayoutParams);
      i += 1;
    }
  }
  
  public void connect(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.mConstraints.containsKey(Integer.valueOf(paramInt1))) {
      this.mConstraints.put(Integer.valueOf(paramInt1), new ConstraintSet.Constraint());
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
        ((ConstraintSet.Constraint)localObject).layout.endToEnd = paramInt3;
        ((ConstraintSet.Constraint)localObject).layout.endToStart = -1;
        return;
      }
      if (paramInt4 == 6)
      {
        ((ConstraintSet.Constraint)localObject).layout.endToStart = paramInt3;
        ((ConstraintSet.Constraint)localObject).layout.endToEnd = -1;
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
        ((ConstraintSet.Constraint)localObject).layout.startToStart = paramInt3;
        ((ConstraintSet.Constraint)localObject).layout.startToEnd = -1;
        return;
      }
      if (paramInt4 == 7)
      {
        ((ConstraintSet.Constraint)localObject).layout.startToEnd = paramInt3;
        ((ConstraintSet.Constraint)localObject).layout.startToStart = -1;
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
        ((ConstraintSet.Constraint)localObject).layout.baselineToBaseline = paramInt3;
        ((ConstraintSet.Constraint)localObject).layout.bottomToBottom = -1;
        ((ConstraintSet.Constraint)localObject).layout.bottomToTop = -1;
        ((ConstraintSet.Constraint)localObject).layout.topToTop = -1;
        ((ConstraintSet.Constraint)localObject).layout.topToBottom = -1;
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
        ((ConstraintSet.Constraint)localObject).layout.bottomToBottom = paramInt3;
        ((ConstraintSet.Constraint)localObject).layout.bottomToTop = -1;
        ((ConstraintSet.Constraint)localObject).layout.baselineToBaseline = -1;
        return;
      }
      if (paramInt4 == 3)
      {
        ((ConstraintSet.Constraint)localObject).layout.bottomToTop = paramInt3;
        ((ConstraintSet.Constraint)localObject).layout.bottomToBottom = -1;
        ((ConstraintSet.Constraint)localObject).layout.baselineToBaseline = -1;
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
        ((ConstraintSet.Constraint)localObject).layout.topToTop = paramInt3;
        ((ConstraintSet.Constraint)localObject).layout.topToBottom = -1;
        ((ConstraintSet.Constraint)localObject).layout.baselineToBaseline = -1;
        return;
      }
      if (paramInt4 == 4)
      {
        ((ConstraintSet.Constraint)localObject).layout.topToBottom = paramInt3;
        ((ConstraintSet.Constraint)localObject).layout.topToTop = -1;
        ((ConstraintSet.Constraint)localObject).layout.baselineToBaseline = -1;
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
        ((ConstraintSet.Constraint)localObject).layout.rightToLeft = paramInt3;
        ((ConstraintSet.Constraint)localObject).layout.rightToRight = -1;
        return;
      }
      if (paramInt4 == 2)
      {
        ((ConstraintSet.Constraint)localObject).layout.rightToRight = paramInt3;
        ((ConstraintSet.Constraint)localObject).layout.rightToLeft = -1;
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
      ((ConstraintSet.Constraint)localObject).layout.leftToLeft = paramInt3;
      ((ConstraintSet.Constraint)localObject).layout.leftToRight = -1;
      return;
    }
    if (paramInt4 == 2)
    {
      ((ConstraintSet.Constraint)localObject).layout.leftToRight = paramInt3;
      ((ConstraintSet.Constraint)localObject).layout.leftToLeft = -1;
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
      this.mConstraints.put(Integer.valueOf(paramInt1), new ConstraintSet.Constraint());
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
        ((ConstraintSet.Constraint)localObject).layout.endToEnd = paramInt3;
        ((ConstraintSet.Constraint)localObject).layout.endToStart = -1;
      }
      else
      {
        if (paramInt4 != 6) {
          break label219;
        }
        ((ConstraintSet.Constraint)localObject).layout.endToStart = paramInt3;
        ((ConstraintSet.Constraint)localObject).layout.endToEnd = -1;
      }
      ((ConstraintSet.Constraint)localObject).layout.endMargin = paramInt5;
      return;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("right to ");
      ((StringBuilder)localObject).append(sideToString(paramInt4));
      ((StringBuilder)localObject).append(" undefined");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    case 6: 
      if (paramInt4 == 6)
      {
        ((ConstraintSet.Constraint)localObject).layout.startToStart = paramInt3;
        ((ConstraintSet.Constraint)localObject).layout.startToEnd = -1;
      }
      else
      {
        if (paramInt4 != 7) {
          break label335;
        }
        ((ConstraintSet.Constraint)localObject).layout.startToEnd = paramInt3;
        ((ConstraintSet.Constraint)localObject).layout.startToStart = -1;
      }
      ((ConstraintSet.Constraint)localObject).layout.startMargin = paramInt5;
      return;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("right to ");
      ((StringBuilder)localObject).append(sideToString(paramInt4));
      ((StringBuilder)localObject).append(" undefined");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    case 5: 
      if (paramInt4 == 5)
      {
        ((ConstraintSet.Constraint)localObject).layout.baselineToBaseline = paramInt3;
        ((ConstraintSet.Constraint)localObject).layout.bottomToBottom = -1;
        ((ConstraintSet.Constraint)localObject).layout.bottomToTop = -1;
        ((ConstraintSet.Constraint)localObject).layout.topToTop = -1;
        ((ConstraintSet.Constraint)localObject).layout.topToBottom = -1;
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
        ((ConstraintSet.Constraint)localObject).layout.bottomToBottom = paramInt3;
        ((ConstraintSet.Constraint)localObject).layout.bottomToTop = -1;
        ((ConstraintSet.Constraint)localObject).layout.baselineToBaseline = -1;
      }
      else
      {
        if (paramInt4 != 3) {
          break label571;
        }
        ((ConstraintSet.Constraint)localObject).layout.bottomToTop = paramInt3;
        ((ConstraintSet.Constraint)localObject).layout.bottomToBottom = -1;
        ((ConstraintSet.Constraint)localObject).layout.baselineToBaseline = -1;
      }
      ((ConstraintSet.Constraint)localObject).layout.bottomMargin = paramInt5;
      return;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("right to ");
      ((StringBuilder)localObject).append(sideToString(paramInt4));
      ((StringBuilder)localObject).append(" undefined");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    case 3: 
      if (paramInt4 == 3)
      {
        ((ConstraintSet.Constraint)localObject).layout.topToTop = paramInt3;
        ((ConstraintSet.Constraint)localObject).layout.topToBottom = -1;
        ((ConstraintSet.Constraint)localObject).layout.baselineToBaseline = -1;
      }
      else
      {
        if (paramInt4 != 4) {
          break label703;
        }
        ((ConstraintSet.Constraint)localObject).layout.topToBottom = paramInt3;
        ((ConstraintSet.Constraint)localObject).layout.topToTop = -1;
        ((ConstraintSet.Constraint)localObject).layout.baselineToBaseline = -1;
      }
      ((ConstraintSet.Constraint)localObject).layout.topMargin = paramInt5;
      return;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("right to ");
      ((StringBuilder)localObject).append(sideToString(paramInt4));
      ((StringBuilder)localObject).append(" undefined");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    case 2: 
      label219:
      if (paramInt4 == 1)
      {
        ((ConstraintSet.Constraint)localObject).layout.rightToLeft = paramInt3;
        ((ConstraintSet.Constraint)localObject).layout.rightToRight = -1;
      }
      else
      {
        if (paramInt4 != 2) {
          break label817;
        }
        ((ConstraintSet.Constraint)localObject).layout.rightToRight = paramInt3;
        ((ConstraintSet.Constraint)localObject).layout.rightToLeft = -1;
      }
      label335:
      ((ConstraintSet.Constraint)localObject).layout.rightMargin = paramInt5;
      label571:
      label703:
      return;
      label817:
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("right to ");
      ((StringBuilder)localObject).append(sideToString(paramInt4));
      ((StringBuilder)localObject).append(" undefined");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    if (paramInt4 == 1)
    {
      ((ConstraintSet.Constraint)localObject).layout.leftToLeft = paramInt3;
      ((ConstraintSet.Constraint)localObject).layout.leftToRight = -1;
    }
    else
    {
      if (paramInt4 != 2) {
        break label931;
      }
      ((ConstraintSet.Constraint)localObject).layout.leftToRight = paramInt3;
      ((ConstraintSet.Constraint)localObject).layout.leftToLeft = -1;
    }
    ((ConstraintSet.Constraint)localObject).layout.leftMargin = paramInt5;
    return;
    label931:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Left to ");
    ((StringBuilder)localObject).append(sideToString(paramInt4));
    ((StringBuilder)localObject).append(" undefined");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void constrainCircle(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    ConstraintSet.Constraint localConstraint = get(paramInt1);
    localConstraint.layout.circleConstraint = paramInt2;
    localConstraint.layout.circleRadius = paramInt3;
    localConstraint.layout.circleAngle = paramFloat;
  }
  
  public void constrainDefaultHeight(int paramInt1, int paramInt2)
  {
    get(paramInt1).layout.heightDefault = paramInt2;
  }
  
  public void constrainDefaultWidth(int paramInt1, int paramInt2)
  {
    get(paramInt1).layout.widthDefault = paramInt2;
  }
  
  public void constrainHeight(int paramInt1, int paramInt2)
  {
    get(paramInt1).layout.mHeight = paramInt2;
  }
  
  public void constrainMaxHeight(int paramInt1, int paramInt2)
  {
    get(paramInt1).layout.heightMax = paramInt2;
  }
  
  public void constrainMaxWidth(int paramInt1, int paramInt2)
  {
    get(paramInt1).layout.widthMax = paramInt2;
  }
  
  public void constrainMinHeight(int paramInt1, int paramInt2)
  {
    get(paramInt1).layout.heightMin = paramInt2;
  }
  
  public void constrainMinWidth(int paramInt1, int paramInt2)
  {
    get(paramInt1).layout.widthMin = paramInt2;
  }
  
  public void constrainPercentHeight(int paramInt, float paramFloat)
  {
    get(paramInt).layout.heightPercent = paramFloat;
  }
  
  public void constrainPercentWidth(int paramInt, float paramFloat)
  {
    get(paramInt).layout.widthPercent = paramFloat;
  }
  
  public void constrainWidth(int paramInt1, int paramInt2)
  {
    get(paramInt1).layout.mWidth = paramInt2;
  }
  
  public void constrainedHeight(int paramInt, boolean paramBoolean)
  {
    get(paramInt).layout.constrainedHeight = paramBoolean;
  }
  
  public void constrainedWidth(int paramInt, boolean paramBoolean)
  {
    get(paramInt).layout.constrainedWidth = paramBoolean;
  }
  
  public void create(int paramInt1, int paramInt2)
  {
    ConstraintSet.Constraint localConstraint = get(paramInt1);
    localConstraint.layout.mIsGuideline = true;
    localConstraint.layout.orientation = paramInt2;
  }
  
  public void createBarrier(int paramInt1, int paramInt2, int paramInt3, int... paramVarArgs)
  {
    ConstraintSet.Constraint localConstraint = get(paramInt1);
    localConstraint.layout.mHelperType = 1;
    localConstraint.layout.mBarrierDirection = paramInt2;
    localConstraint.layout.mBarrierMargin = paramInt3;
    localConstraint.layout.mIsGuideline = false;
    localConstraint.layout.mReferenceIds = paramVarArgs;
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
        get(paramArrayOfInt[0]).layout.verticalWeight = paramArrayOfFloat[0];
      }
      get(paramArrayOfInt[0]).layout.verticalChainStyle = paramInt5;
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
          get(paramArrayOfInt[paramInt1]).layout.verticalWeight = paramArrayOfFloat[paramInt1];
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
  
  public void dump(MotionScene paramMotionScene, int... paramVarArgs)
  {
    Object localObject1 = this.mConstraints.keySet();
    int i = paramVarArgs.length;
    int j = 0;
    if (i != 0)
    {
      localObject1 = new HashSet();
      k = paramVarArgs.length;
      i = 0;
      while (i < k)
      {
        ((HashSet)localObject1).add(Integer.valueOf(paramVarArgs[i]));
        i += 1;
      }
      paramVarArgs = (int[])localObject1;
    }
    else
    {
      paramVarArgs = new HashSet((Collection)localObject1);
    }
    localObject1 = System.out;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramVarArgs.size());
    ((StringBuilder)localObject2).append(" constraints");
    ((PrintStream)localObject1).println(((StringBuilder)localObject2).toString());
    localObject1 = new StringBuilder();
    paramVarArgs = (Integer[])paramVarArgs.toArray(new Integer[0]);
    int k = paramVarArgs.length;
    i = j;
    while (i < k)
    {
      localObject2 = paramVarArgs[i];
      ConstraintSet.Constraint localConstraint = (ConstraintSet.Constraint)this.mConstraints.get(localObject2);
      ((StringBuilder)localObject1).append("<Constraint id=");
      ((StringBuilder)localObject1).append(localObject2);
      ((StringBuilder)localObject1).append(" \n");
      localConstraint.layout.dump(paramMotionScene, (StringBuilder)localObject1);
      ((StringBuilder)localObject1).append("/>\n");
      i += 1;
    }
    System.out.println(((StringBuilder)localObject1).toString());
  }
  
  public boolean getApplyElevation(int paramInt)
  {
    return get(paramInt).transform.applyElevation;
  }
  
  public ConstraintSet.Constraint getConstraint(int paramInt)
  {
    if (this.mConstraints.containsKey(Integer.valueOf(paramInt))) {
      return (ConstraintSet.Constraint)this.mConstraints.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public HashMap<String, ConstraintAttribute> getCustomAttributeSet()
  {
    return this.mSavedAttributes;
  }
  
  public int getHeight(int paramInt)
  {
    return get(paramInt).layout.mHeight;
  }
  
  public int[] getKnownIds()
  {
    Object localObject = this.mConstraints.keySet();
    int i = 0;
    localObject = (Integer[])((Set)localObject).toArray(new Integer[0]);
    int[] arrayOfInt = new int[localObject.length];
    while (i < arrayOfInt.length)
    {
      arrayOfInt[i] = localObject[i].intValue();
      i += 1;
    }
    return arrayOfInt;
  }
  
  public ConstraintSet.Constraint getParameters(int paramInt)
  {
    return get(paramInt);
  }
  
  public int[] getReferencedIds(int paramInt)
  {
    ConstraintSet.Constraint localConstraint = get(paramInt);
    if (localConstraint.layout.mReferenceIds == null) {
      return new int[0];
    }
    return Arrays.copyOf(localConstraint.layout.mReferenceIds, localConstraint.layout.mReferenceIds.length);
  }
  
  public int getVisibility(int paramInt)
  {
    return get(paramInt).propertySet.visibility;
  }
  
  public int getVisibilityMode(int paramInt)
  {
    return get(paramInt).propertySet.mVisibilityMode;
  }
  
  public int getWidth(int paramInt)
  {
    return get(paramInt).layout.mWidth;
  }
  
  public boolean isForceId()
  {
    return this.mForceId;
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
      localConstraint.layout.mIsGuideline = true;
    }
    this.mConstraints.put(Integer.valueOf(localConstraint.mViewId), localConstraint);
    break label86;
    label79:
    localXmlResourceParser.getName();
    for (;;)
    {
      label86:
      paramInt = localXmlResourceParser.next();
      while (paramInt == 1) {
        return;
      }
      if (paramInt == 0) {
        break label79;
      }
      if (paramInt == 2) {
        break;
      }
    }
  }
  
  public void load(Context paramContext, XmlPullParser paramXmlPullParser)
  {
    for (;;)
    {
      try
      {
        int i = paramXmlPullParser.getEventType();
        Object localObject2 = null;
        Object localObject1;
        if (i != 1) {
          if (i != 0)
          {
            if (i != 2)
            {
              if (i != 3)
              {
                localObject1 = localObject2;
                continue;
              }
              String str = paramXmlPullParser.getName();
              if ("ConstraintSet".equals(str)) {
                return;
              }
              localObject1 = localObject2;
              if (!str.equalsIgnoreCase("Constraint")) {
                continue;
              }
              this.mConstraints.put(Integer.valueOf(localObject2.mViewId), localObject2);
              localObject1 = null;
              continue;
            }
            localObject1 = paramXmlPullParser.getName();
          }
        }
        switch (((String)localObject1).hashCode())
        {
        case 1803088381: 
          if (((String)localObject1).equals("Constraint")) {
            i = 0;
          }
          break;
        case 1791837707: 
          if (((String)localObject1).equals("CustomAttribute")) {
            i = 7;
          }
          break;
        case 1331510167: 
          if (((String)localObject1).equals("Barrier")) {
            i = 2;
          }
          break;
        case -71750448: 
          if (((String)localObject1).equals("Guideline")) {
            i = 1;
          }
          break;
        case -1238332596: 
          if (((String)localObject1).equals("Transform")) {
            i = 4;
          }
          break;
        case -1269513683: 
          if (((String)localObject1).equals("PropertySet")) {
            i = 3;
          }
          break;
        case -1984451626: 
          if (((String)localObject1).equals("Motion")) {
            i = 6;
          }
          break;
        case -2025855158: 
          boolean bool = ((String)localObject1).equals("Layout");
          if (bool) {
            i = 5;
          } else {
            i = -1;
          }
          switch (i)
          {
          default: 
            localObject1 = localObject2;
            break;
          case 7: 
            if (localObject2 != null)
            {
              ConstraintAttribute.parse(paramContext, paramXmlPullParser, localObject2.mCustomConstraints);
              localObject1 = localObject2;
            }
            else
            {
              paramContext = new StringBuilder();
              paramContext.append("XML parser error must be within a Constraint ");
              paramContext.append(paramXmlPullParser.getLineNumber());
              throw new RuntimeException(paramContext.toString());
            }
            break;
          case 6: 
            if (localObject2 != null)
            {
              localObject2.motion.fillFromAttributeList(paramContext, Xml.asAttributeSet(paramXmlPullParser));
              localObject1 = localObject2;
            }
            else
            {
              paramContext = new StringBuilder();
              paramContext.append("XML parser error must be within a Constraint ");
              paramContext.append(paramXmlPullParser.getLineNumber());
              throw new RuntimeException(paramContext.toString());
            }
            break;
          case 5: 
            if (localObject2 != null)
            {
              localObject2.layout.fillFromAttributeList(paramContext, Xml.asAttributeSet(paramXmlPullParser));
              localObject1 = localObject2;
            }
            else
            {
              paramContext = new StringBuilder();
              paramContext.append("XML parser error must be within a Constraint ");
              paramContext.append(paramXmlPullParser.getLineNumber());
              throw new RuntimeException(paramContext.toString());
            }
            break;
          case 4: 
            if (localObject2 != null)
            {
              localObject2.transform.fillFromAttributeList(paramContext, Xml.asAttributeSet(paramXmlPullParser));
              localObject1 = localObject2;
            }
            else
            {
              paramContext = new StringBuilder();
              paramContext.append("XML parser error must be within a Constraint ");
              paramContext.append(paramXmlPullParser.getLineNumber());
              throw new RuntimeException(paramContext.toString());
            }
            break;
          case 3: 
            if (localObject2 != null)
            {
              localObject2.propertySet.fillFromAttributeList(paramContext, Xml.asAttributeSet(paramXmlPullParser));
              localObject1 = localObject2;
            }
            else
            {
              paramContext = new StringBuilder();
              paramContext.append("XML parser error must be within a Constraint ");
              paramContext.append(paramXmlPullParser.getLineNumber());
              throw new RuntimeException(paramContext.toString());
            }
            break;
          case 2: 
            localObject1 = fillFromAttributeList(paramContext, Xml.asAttributeSet(paramXmlPullParser));
            ((ConstraintSet.Constraint)localObject1).layout.mHelperType = 1;
            break;
          case 1: 
            localObject1 = fillFromAttributeList(paramContext, Xml.asAttributeSet(paramXmlPullParser));
            ((ConstraintSet.Constraint)localObject1).layout.mIsGuideline = true;
            ((ConstraintSet.Constraint)localObject1).layout.mApply = true;
            break;
          case 0: 
            localObject1 = fillFromAttributeList(paramContext, Xml.asAttributeSet(paramXmlPullParser));
            continue;
            paramXmlPullParser.getName();
            localObject1 = localObject2;
          }
          i = paramXmlPullParser.next();
          localObject2 = localObject1;
          continue;
          return;
        }
      }
      catch (IOException paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
      catch (XmlPullParserException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public void parseColorAttributes(ConstraintSet.Constraint paramConstraint, String paramString)
  {
    paramString = paramString.split(",");
    int i = 0;
    while (i < paramString.length)
    {
      Object localObject = paramString[i].split("=");
      if (localObject.length != 2)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" Unable to parse ");
        ((StringBuilder)localObject).append(paramString[i]);
        Log.w("ConstraintSet", ((StringBuilder)localObject).toString());
      }
      else
      {
        ConstraintSet.Constraint.access$600(paramConstraint, localObject[0], Color.parseColor(localObject[1]));
      }
      i += 1;
    }
  }
  
  public void parseFloatAttributes(ConstraintSet.Constraint paramConstraint, String paramString)
  {
    paramString = paramString.split(",");
    int i = 0;
    while (i < paramString.length)
    {
      Object localObject = paramString[i].split("=");
      if (localObject.length != 2)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" Unable to parse ");
        ((StringBuilder)localObject).append(paramString[i]);
        Log.w("ConstraintSet", ((StringBuilder)localObject).toString());
      }
      else
      {
        ConstraintSet.Constraint.access$700(paramConstraint, localObject[0], Float.parseFloat(localObject[1]));
      }
      i += 1;
    }
  }
  
  public void parseIntAttributes(ConstraintSet.Constraint paramConstraint, String paramString)
  {
    paramString = paramString.split(",");
    int i = 0;
    while (i < paramString.length)
    {
      Object localObject = paramString[i].split("=");
      if (localObject.length != 2)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" Unable to parse ");
        ((StringBuilder)localObject).append(paramString[i]);
        Log.w("ConstraintSet", ((StringBuilder)localObject).toString());
      }
      else
      {
        ConstraintSet.Constraint.access$700(paramConstraint, localObject[0], Integer.decode(localObject[1]).intValue());
      }
      i += 1;
    }
  }
  
  public void parseStringAttributes(ConstraintSet.Constraint paramConstraint, String paramString)
  {
    paramString = splitString(paramString);
    int i = 0;
    while (i < paramString.length)
    {
      String[] arrayOfString = paramString[i].split("=");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" Unable to parse ");
      localStringBuilder.append(paramString[i]);
      Log.w("ConstraintSet", localStringBuilder.toString());
      ConstraintSet.Constraint.access$800(paramConstraint, arrayOfString[0], arrayOfString[1]);
      i += 1;
    }
  }
  
  public void readFallback(ConstraintLayout paramConstraintLayout)
  {
    int j = paramConstraintLayout.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = paramConstraintLayout.getChildAt(i);
      Object localObject = (ConstraintLayout.LayoutParams)localView.getLayoutParams();
      int k = localView.getId();
      if ((this.mForceId) && (k == -1)) {
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
      }
      if (!this.mConstraints.containsKey(Integer.valueOf(k))) {
        this.mConstraints.put(Integer.valueOf(k), new ConstraintSet.Constraint());
      }
      ConstraintSet.Constraint localConstraint = (ConstraintSet.Constraint)this.mConstraints.get(Integer.valueOf(k));
      if (!localConstraint.layout.mApply)
      {
        ConstraintSet.Constraint.access$000(localConstraint, k, (ConstraintLayout.LayoutParams)localObject);
        if ((localView instanceof ConstraintHelper))
        {
          localConstraint.layout.mReferenceIds = ((ConstraintHelper)localView).getReferencedIds();
          if ((localView instanceof Barrier))
          {
            localObject = (Barrier)localView;
            localConstraint.layout.mBarrierAllowsGoneWidgets = ((Barrier)localObject).allowsGoneWidget();
            localConstraint.layout.mBarrierDirection = ((Barrier)localObject).getType();
            localConstraint.layout.mBarrierMargin = ((Barrier)localObject).getMargin();
          }
        }
        localConstraint.layout.mApply = true;
      }
      if (!localConstraint.propertySet.mApply)
      {
        localConstraint.propertySet.visibility = localView.getVisibility();
        localConstraint.propertySet.alpha = localView.getAlpha();
        localConstraint.propertySet.mApply = true;
      }
      if ((Build.VERSION.SDK_INT >= 17) && (!localConstraint.transform.mApply))
      {
        localConstraint.transform.mApply = true;
        localConstraint.transform.rotation = localView.getRotation();
        localConstraint.transform.rotationX = localView.getRotationX();
        localConstraint.transform.rotationY = localView.getRotationY();
        localConstraint.transform.scaleX = localView.getScaleX();
        localConstraint.transform.scaleY = localView.getScaleY();
        float f1 = localView.getPivotX();
        float f2 = localView.getPivotY();
        if ((f1 != 0.0D) || (f2 != 0.0D))
        {
          localConstraint.transform.transformPivotX = f1;
          localConstraint.transform.transformPivotY = f2;
        }
        localConstraint.transform.translationX = localView.getTranslationX();
        localConstraint.transform.translationY = localView.getTranslationY();
        if (Build.VERSION.SDK_INT >= 21)
        {
          localConstraint.transform.translationZ = localView.getTranslationZ();
          if (localConstraint.transform.applyElevation) {
            localConstraint.transform.elevation = localView.getElevation();
          }
        }
      }
      i += 1;
    }
  }
  
  public void readFallback(ConstraintSet paramConstraintSet)
  {
    Iterator localIterator1 = paramConstraintSet.mConstraints.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (Integer)localIterator1.next();
      int i = ((Integer)localObject).intValue();
      localObject = (ConstraintSet.Constraint)paramConstraintSet.mConstraints.get(localObject);
      if (!this.mConstraints.containsKey(Integer.valueOf(i))) {
        this.mConstraints.put(Integer.valueOf(i), new ConstraintSet.Constraint());
      }
      ConstraintSet.Constraint localConstraint = (ConstraintSet.Constraint)this.mConstraints.get(Integer.valueOf(i));
      if (!localConstraint.layout.mApply) {
        localConstraint.layout.copyFrom(((ConstraintSet.Constraint)localObject).layout);
      }
      if (!localConstraint.propertySet.mApply) {
        localConstraint.propertySet.copyFrom(((ConstraintSet.Constraint)localObject).propertySet);
      }
      if (!localConstraint.transform.mApply) {
        localConstraint.transform.copyFrom(((ConstraintSet.Constraint)localObject).transform);
      }
      if (!localConstraint.motion.mApply) {
        localConstraint.motion.copyFrom(((ConstraintSet.Constraint)localObject).motion);
      }
      Iterator localIterator2 = ((ConstraintSet.Constraint)localObject).mCustomConstraints.keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str = (String)localIterator2.next();
        if (!localConstraint.mCustomConstraints.containsKey(str)) {
          localConstraint.mCustomConstraints.put(str, ((ConstraintSet.Constraint)localObject).mCustomConstraints.get(str));
        }
      }
    }
  }
  
  public void removeAttribute(String paramString)
  {
    this.mSavedAttributes.remove(paramString);
  }
  
  public void removeFromHorizontalChain(int paramInt)
  {
    if (this.mConstraints.containsKey(Integer.valueOf(paramInt)))
    {
      ConstraintSet.Constraint localConstraint = (ConstraintSet.Constraint)this.mConstraints.get(Integer.valueOf(paramInt));
      int i = localConstraint.layout.leftToRight;
      int j = localConstraint.layout.rightToLeft;
      if ((i == -1) && (j == -1))
      {
        j = localConstraint.layout.startToEnd;
        int k = localConstraint.layout.endToStart;
        if ((j != -1) || (k != -1)) {
          if ((j != -1) && (k != -1))
          {
            connect(j, 7, k, 6, 0);
            connect(k, 6, i, 7, 0);
          }
          else if ((i != -1) || (k != -1))
          {
            if (localConstraint.layout.rightToRight != -1) {
              connect(i, 7, localConstraint.layout.rightToRight, 7, 0);
            } else if (localConstraint.layout.leftToLeft != -1) {
              connect(k, 6, localConstraint.layout.leftToLeft, 6, 0);
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
        if (localConstraint.layout.rightToRight != -1) {
          connect(i, 2, localConstraint.layout.rightToRight, 2, 0);
        } else if (localConstraint.layout.leftToLeft != -1) {
          connect(j, 1, localConstraint.layout.leftToLeft, 1, 0);
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
      int i = localConstraint.layout.topToBottom;
      int j = localConstraint.layout.bottomToTop;
      if ((i != -1) || (j != -1)) {
        if ((i != -1) && (j != -1))
        {
          connect(i, 4, j, 3, 0);
          connect(j, 3, i, 4, 0);
        }
        else if ((i != -1) || (j != -1))
        {
          if (localConstraint.layout.bottomToBottom != -1) {
            connect(i, 4, localConstraint.layout.bottomToBottom, 4, 0);
          } else if (localConstraint.layout.topToTop != -1) {
            connect(j, 3, localConstraint.layout.topToTop, 3, 0);
          }
        }
      }
    }
    clear(paramInt, 3);
    clear(paramInt, 4);
  }
  
  public void setAlpha(int paramInt, float paramFloat)
  {
    get(paramInt).propertySet.alpha = paramFloat;
  }
  
  public void setApplyElevation(int paramInt, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      get(paramInt).transform.applyElevation = paramBoolean;
    }
  }
  
  public void setBarrierType(int paramInt1, int paramInt2)
  {
    get(paramInt1).layout.mHelperType = paramInt2;
  }
  
  public void setColorValue(int paramInt1, String paramString, int paramInt2)
  {
    ConstraintSet.Constraint.access$600(get(paramInt1), paramString, paramInt2);
  }
  
  public void setDimensionRatio(int paramInt, String paramString)
  {
    get(paramInt).layout.dimensionRatio = paramString;
  }
  
  public void setEditorAbsoluteX(int paramInt1, int paramInt2)
  {
    get(paramInt1).layout.editorAbsoluteX = paramInt2;
  }
  
  public void setEditorAbsoluteY(int paramInt1, int paramInt2)
  {
    get(paramInt1).layout.editorAbsoluteY = paramInt2;
  }
  
  public void setElevation(int paramInt, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      get(paramInt).transform.elevation = paramFloat;
      get(paramInt).transform.applyElevation = true;
    }
  }
  
  public void setFloatValue(int paramInt, String paramString, float paramFloat)
  {
    ConstraintSet.Constraint.access$700(get(paramInt), paramString, paramFloat);
  }
  
  public void setForceId(boolean paramBoolean)
  {
    this.mForceId = paramBoolean;
  }
  
  public void setGoneMargin(int paramInt1, int paramInt2, int paramInt3)
  {
    ConstraintSet.Constraint localConstraint = get(paramInt1);
    switch (paramInt2)
    {
    default: 
      throw new IllegalArgumentException("unknown constraint");
    case 7: 
      localConstraint.layout.goneEndMargin = paramInt3;
      return;
    case 6: 
      localConstraint.layout.goneStartMargin = paramInt3;
      return;
    case 5: 
      throw new IllegalArgumentException("baseline does not support margins");
    case 4: 
      localConstraint.layout.goneBottomMargin = paramInt3;
      return;
    case 3: 
      localConstraint.layout.goneTopMargin = paramInt3;
      return;
    case 2: 
      localConstraint.layout.goneRightMargin = paramInt3;
      return;
    }
    localConstraint.layout.goneLeftMargin = paramInt3;
  }
  
  public void setGuidelineBegin(int paramInt1, int paramInt2)
  {
    get(paramInt1).layout.guideBegin = paramInt2;
    get(paramInt1).layout.guideEnd = -1;
    get(paramInt1).layout.guidePercent = -1.0F;
  }
  
  public void setGuidelineEnd(int paramInt1, int paramInt2)
  {
    get(paramInt1).layout.guideEnd = paramInt2;
    get(paramInt1).layout.guideBegin = -1;
    get(paramInt1).layout.guidePercent = -1.0F;
  }
  
  public void setGuidelinePercent(int paramInt, float paramFloat)
  {
    get(paramInt).layout.guidePercent = paramFloat;
    get(paramInt).layout.guideEnd = -1;
    get(paramInt).layout.guideBegin = -1;
  }
  
  public void setHorizontalBias(int paramInt, float paramFloat)
  {
    get(paramInt).layout.horizontalBias = paramFloat;
  }
  
  public void setHorizontalChainStyle(int paramInt1, int paramInt2)
  {
    get(paramInt1).layout.horizontalChainStyle = paramInt2;
  }
  
  public void setHorizontalWeight(int paramInt, float paramFloat)
  {
    get(paramInt).layout.horizontalWeight = paramFloat;
  }
  
  public void setIntValue(int paramInt1, String paramString, int paramInt2)
  {
    ConstraintSet.Constraint.access$500(get(paramInt1), paramString, paramInt2);
  }
  
  public void setMargin(int paramInt1, int paramInt2, int paramInt3)
  {
    ConstraintSet.Constraint localConstraint = get(paramInt1);
    switch (paramInt2)
    {
    default: 
      throw new IllegalArgumentException("unknown constraint");
    case 7: 
      localConstraint.layout.endMargin = paramInt3;
      return;
    case 6: 
      localConstraint.layout.startMargin = paramInt3;
      return;
    case 5: 
      throw new IllegalArgumentException("baseline does not support margins");
    case 4: 
      localConstraint.layout.bottomMargin = paramInt3;
      return;
    case 3: 
      localConstraint.layout.topMargin = paramInt3;
      return;
    case 2: 
      localConstraint.layout.rightMargin = paramInt3;
      return;
    }
    localConstraint.layout.leftMargin = paramInt3;
  }
  
  public void setReferencedIds(int paramInt, int... paramVarArgs)
  {
    get(paramInt).layout.mReferenceIds = paramVarArgs;
  }
  
  public void setRotation(int paramInt, float paramFloat)
  {
    get(paramInt).transform.rotation = paramFloat;
  }
  
  public void setRotationX(int paramInt, float paramFloat)
  {
    get(paramInt).transform.rotationX = paramFloat;
  }
  
  public void setRotationY(int paramInt, float paramFloat)
  {
    get(paramInt).transform.rotationY = paramFloat;
  }
  
  public void setScaleX(int paramInt, float paramFloat)
  {
    get(paramInt).transform.scaleX = paramFloat;
  }
  
  public void setScaleY(int paramInt, float paramFloat)
  {
    get(paramInt).transform.scaleY = paramFloat;
  }
  
  public void setStringValue(int paramInt, String paramString1, String paramString2)
  {
    ConstraintSet.Constraint.access$800(get(paramInt), paramString1, paramString2);
  }
  
  public void setTransformPivot(int paramInt, float paramFloat1, float paramFloat2)
  {
    ConstraintSet.Constraint localConstraint = get(paramInt);
    localConstraint.transform.transformPivotY = paramFloat2;
    localConstraint.transform.transformPivotX = paramFloat1;
  }
  
  public void setTransformPivotX(int paramInt, float paramFloat)
  {
    get(paramInt).transform.transformPivotX = paramFloat;
  }
  
  public void setTransformPivotY(int paramInt, float paramFloat)
  {
    get(paramInt).transform.transformPivotY = paramFloat;
  }
  
  public void setTranslation(int paramInt, float paramFloat1, float paramFloat2)
  {
    ConstraintSet.Constraint localConstraint = get(paramInt);
    localConstraint.transform.translationX = paramFloat1;
    localConstraint.transform.translationY = paramFloat2;
  }
  
  public void setTranslationX(int paramInt, float paramFloat)
  {
    get(paramInt).transform.translationX = paramFloat;
  }
  
  public void setTranslationY(int paramInt, float paramFloat)
  {
    get(paramInt).transform.translationY = paramFloat;
  }
  
  public void setTranslationZ(int paramInt, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      get(paramInt).transform.translationZ = paramFloat;
    }
  }
  
  public void setValidateOnParse(boolean paramBoolean)
  {
    this.mValidate = paramBoolean;
  }
  
  public void setVerticalBias(int paramInt, float paramFloat)
  {
    get(paramInt).layout.verticalBias = paramFloat;
  }
  
  public void setVerticalChainStyle(int paramInt1, int paramInt2)
  {
    get(paramInt1).layout.verticalChainStyle = paramInt2;
  }
  
  public void setVerticalWeight(int paramInt, float paramFloat)
  {
    get(paramInt).layout.verticalWeight = paramFloat;
  }
  
  public void setVisibility(int paramInt1, int paramInt2)
  {
    get(paramInt1).propertySet.visibility = paramInt2;
  }
  
  public void setVisibilityMode(int paramInt1, int paramInt2)
  {
    get(paramInt1).propertySet.mVisibilityMode = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.widget.ConstraintSet
 * JD-Core Version:    0.7.0.1
 */