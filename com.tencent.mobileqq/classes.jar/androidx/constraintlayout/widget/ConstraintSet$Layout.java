package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.widget.MotionScene;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ConstraintSet$Layout
{
  private static final int BARRIER_ALLOWS_GONE_WIDGETS = 75;
  private static final int BARRIER_DIRECTION = 72;
  private static final int BARRIER_MARGIN = 73;
  private static final int BASELINE_TO_BASELINE = 1;
  private static final int BOTTOM_MARGIN = 2;
  private static final int BOTTOM_TO_BOTTOM = 3;
  private static final int BOTTOM_TO_TOP = 4;
  private static final int CHAIN_USE_RTL = 71;
  private static final int CIRCLE = 61;
  private static final int CIRCLE_ANGLE = 63;
  private static final int CIRCLE_RADIUS = 62;
  private static final int CONSTRAINT_REFERENCED_IDS = 74;
  private static final int DIMENSION_RATIO = 5;
  private static final int EDITOR_ABSOLUTE_X = 6;
  private static final int EDITOR_ABSOLUTE_Y = 7;
  private static final int END_MARGIN = 8;
  private static final int END_TO_END = 9;
  private static final int END_TO_START = 10;
  private static final int GONE_BOTTOM_MARGIN = 11;
  private static final int GONE_END_MARGIN = 12;
  private static final int GONE_LEFT_MARGIN = 13;
  private static final int GONE_RIGHT_MARGIN = 14;
  private static final int GONE_START_MARGIN = 15;
  private static final int GONE_TOP_MARGIN = 16;
  private static final int GUIDE_BEGIN = 17;
  private static final int GUIDE_END = 18;
  private static final int GUIDE_PERCENT = 19;
  private static final int HEIGHT_PERCENT = 70;
  private static final int HORIZONTAL_BIAS = 20;
  private static final int HORIZONTAL_STYLE = 39;
  private static final int HORIZONTAL_WEIGHT = 37;
  private static final int LAYOUT_HEIGHT = 21;
  private static final int LAYOUT_WIDTH = 22;
  private static final int LEFT_MARGIN = 23;
  private static final int LEFT_TO_LEFT = 24;
  private static final int LEFT_TO_RIGHT = 25;
  private static final int ORIENTATION = 26;
  private static final int RIGHT_MARGIN = 27;
  private static final int RIGHT_TO_LEFT = 28;
  private static final int RIGHT_TO_RIGHT = 29;
  private static final int START_MARGIN = 30;
  private static final int START_TO_END = 31;
  private static final int START_TO_START = 32;
  private static final int TOP_MARGIN = 33;
  private static final int TOP_TO_BOTTOM = 34;
  private static final int TOP_TO_TOP = 35;
  public static final int UNSET = -1;
  private static final int UNUSED = 76;
  private static final int VERTICAL_BIAS = 36;
  private static final int VERTICAL_STYLE = 40;
  private static final int VERTICAL_WEIGHT = 38;
  private static final int WIDTH_PERCENT = 69;
  private static SparseIntArray mapToConstant = new SparseIntArray();
  public int baselineToBaseline = -1;
  public int bottomMargin = -1;
  public int bottomToBottom = -1;
  public int bottomToTop = -1;
  public float circleAngle = 0.0F;
  public int circleConstraint = -1;
  public int circleRadius = 0;
  public boolean constrainedHeight = false;
  public boolean constrainedWidth = false;
  public String dimensionRatio = null;
  public int editorAbsoluteX = -1;
  public int editorAbsoluteY = -1;
  public int endMargin = -1;
  public int endToEnd = -1;
  public int endToStart = -1;
  public int goneBottomMargin = -1;
  public int goneEndMargin = -1;
  public int goneLeftMargin = -1;
  public int goneRightMargin = -1;
  public int goneStartMargin = -1;
  public int goneTopMargin = -1;
  public int guideBegin = -1;
  public int guideEnd = -1;
  public float guidePercent = -1.0F;
  public int heightDefault = 0;
  public int heightMax = -1;
  public int heightMin = -1;
  public float heightPercent = 1.0F;
  public float horizontalBias = 0.5F;
  public int horizontalChainStyle = 0;
  public float horizontalWeight = -1.0F;
  public int leftMargin = -1;
  public int leftToLeft = -1;
  public int leftToRight = -1;
  public boolean mApply = false;
  public boolean mBarrierAllowsGoneWidgets = true;
  public int mBarrierDirection = -1;
  public int mBarrierMargin = 0;
  public String mConstraintTag;
  public int mHeight;
  public int mHelperType = -1;
  public boolean mIsGuideline = false;
  public String mReferenceIdString;
  public int[] mReferenceIds;
  public int mWidth;
  public int orientation = -1;
  public int rightMargin = -1;
  public int rightToLeft = -1;
  public int rightToRight = -1;
  public int startMargin = -1;
  public int startToEnd = -1;
  public int startToStart = -1;
  public int topMargin = -1;
  public int topToBottom = -1;
  public int topToTop = -1;
  public float verticalBias = 0.5F;
  public int verticalChainStyle = 0;
  public float verticalWeight = -1.0F;
  public int widthDefault = 0;
  public int widthMax = -1;
  public int widthMin = -1;
  public float widthPercent = 1.0F;
  
  static
  {
    mapToConstant.append(R.styleable.Layout_layout_constraintLeft_toLeftOf, 24);
    mapToConstant.append(R.styleable.Layout_layout_constraintLeft_toRightOf, 25);
    mapToConstant.append(R.styleable.Layout_layout_constraintRight_toLeftOf, 28);
    mapToConstant.append(R.styleable.Layout_layout_constraintRight_toRightOf, 29);
    mapToConstant.append(R.styleable.Layout_layout_constraintTop_toTopOf, 35);
    mapToConstant.append(R.styleable.Layout_layout_constraintTop_toBottomOf, 34);
    mapToConstant.append(R.styleable.Layout_layout_constraintBottom_toTopOf, 4);
    mapToConstant.append(R.styleable.Layout_layout_constraintBottom_toBottomOf, 3);
    mapToConstant.append(R.styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
    mapToConstant.append(R.styleable.Layout_layout_editor_absoluteX, 6);
    mapToConstant.append(R.styleable.Layout_layout_editor_absoluteY, 7);
    mapToConstant.append(R.styleable.Layout_layout_constraintGuide_begin, 17);
    mapToConstant.append(R.styleable.Layout_layout_constraintGuide_end, 18);
    mapToConstant.append(R.styleable.Layout_layout_constraintGuide_percent, 19);
    mapToConstant.append(R.styleable.Layout_android_orientation, 26);
    mapToConstant.append(R.styleable.Layout_layout_constraintStart_toEndOf, 31);
    mapToConstant.append(R.styleable.Layout_layout_constraintStart_toStartOf, 32);
    mapToConstant.append(R.styleable.Layout_layout_constraintEnd_toStartOf, 10);
    mapToConstant.append(R.styleable.Layout_layout_constraintEnd_toEndOf, 9);
    mapToConstant.append(R.styleable.Layout_layout_goneMarginLeft, 13);
    mapToConstant.append(R.styleable.Layout_layout_goneMarginTop, 16);
    mapToConstant.append(R.styleable.Layout_layout_goneMarginRight, 14);
    mapToConstant.append(R.styleable.Layout_layout_goneMarginBottom, 11);
    mapToConstant.append(R.styleable.Layout_layout_goneMarginStart, 15);
    mapToConstant.append(R.styleable.Layout_layout_goneMarginEnd, 12);
    mapToConstant.append(R.styleable.Layout_layout_constraintVertical_weight, 38);
    mapToConstant.append(R.styleable.Layout_layout_constraintHorizontal_weight, 37);
    mapToConstant.append(R.styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
    mapToConstant.append(R.styleable.Layout_layout_constraintVertical_chainStyle, 40);
    mapToConstant.append(R.styleable.Layout_layout_constraintHorizontal_bias, 20);
    mapToConstant.append(R.styleable.Layout_layout_constraintVertical_bias, 36);
    mapToConstant.append(R.styleable.Layout_layout_constraintDimensionRatio, 5);
    mapToConstant.append(R.styleable.Layout_layout_constraintLeft_creator, 76);
    mapToConstant.append(R.styleable.Layout_layout_constraintTop_creator, 76);
    mapToConstant.append(R.styleable.Layout_layout_constraintRight_creator, 76);
    mapToConstant.append(R.styleable.Layout_layout_constraintBottom_creator, 76);
    mapToConstant.append(R.styleable.Layout_layout_constraintBaseline_creator, 76);
    mapToConstant.append(R.styleable.Layout_android_layout_marginLeft, 23);
    mapToConstant.append(R.styleable.Layout_android_layout_marginRight, 27);
    mapToConstant.append(R.styleable.Layout_android_layout_marginStart, 30);
    mapToConstant.append(R.styleable.Layout_android_layout_marginEnd, 8);
    mapToConstant.append(R.styleable.Layout_android_layout_marginTop, 33);
    mapToConstant.append(R.styleable.Layout_android_layout_marginBottom, 2);
    mapToConstant.append(R.styleable.Layout_android_layout_width, 22);
    mapToConstant.append(R.styleable.Layout_android_layout_height, 21);
    mapToConstant.append(R.styleable.Layout_layout_constraintCircle, 61);
    mapToConstant.append(R.styleable.Layout_layout_constraintCircleRadius, 62);
    mapToConstant.append(R.styleable.Layout_layout_constraintCircleAngle, 63);
    mapToConstant.append(R.styleable.Layout_layout_constraintWidth_percent, 69);
    mapToConstant.append(R.styleable.Layout_layout_constraintHeight_percent, 70);
    mapToConstant.append(R.styleable.Layout_chainUseRtl, 71);
    mapToConstant.append(R.styleable.Layout_barrierDirection, 72);
    mapToConstant.append(R.styleable.Layout_barrierMargin, 73);
    mapToConstant.append(R.styleable.Layout_constraint_referenced_ids, 74);
    mapToConstant.append(R.styleable.Layout_barrierAllowsGoneWidgets, 75);
  }
  
  public void copyFrom(Layout paramLayout)
  {
    this.mIsGuideline = paramLayout.mIsGuideline;
    this.mWidth = paramLayout.mWidth;
    this.mApply = paramLayout.mApply;
    this.mHeight = paramLayout.mHeight;
    this.guideBegin = paramLayout.guideBegin;
    this.guideEnd = paramLayout.guideEnd;
    this.guidePercent = paramLayout.guidePercent;
    this.leftToLeft = paramLayout.leftToLeft;
    this.leftToRight = paramLayout.leftToRight;
    this.rightToLeft = paramLayout.rightToLeft;
    this.rightToRight = paramLayout.rightToRight;
    this.topToTop = paramLayout.topToTop;
    this.topToBottom = paramLayout.topToBottom;
    this.bottomToTop = paramLayout.bottomToTop;
    this.bottomToBottom = paramLayout.bottomToBottom;
    this.baselineToBaseline = paramLayout.baselineToBaseline;
    this.startToEnd = paramLayout.startToEnd;
    this.startToStart = paramLayout.startToStart;
    this.endToStart = paramLayout.endToStart;
    this.endToEnd = paramLayout.endToEnd;
    this.horizontalBias = paramLayout.horizontalBias;
    this.verticalBias = paramLayout.verticalBias;
    this.dimensionRatio = paramLayout.dimensionRatio;
    this.circleConstraint = paramLayout.circleConstraint;
    this.circleRadius = paramLayout.circleRadius;
    this.circleAngle = paramLayout.circleAngle;
    this.editorAbsoluteX = paramLayout.editorAbsoluteX;
    this.editorAbsoluteY = paramLayout.editorAbsoluteY;
    this.orientation = paramLayout.orientation;
    this.leftMargin = paramLayout.leftMargin;
    this.rightMargin = paramLayout.rightMargin;
    this.topMargin = paramLayout.topMargin;
    this.bottomMargin = paramLayout.bottomMargin;
    this.endMargin = paramLayout.endMargin;
    this.startMargin = paramLayout.startMargin;
    this.goneLeftMargin = paramLayout.goneLeftMargin;
    this.goneTopMargin = paramLayout.goneTopMargin;
    this.goneRightMargin = paramLayout.goneRightMargin;
    this.goneBottomMargin = paramLayout.goneBottomMargin;
    this.goneEndMargin = paramLayout.goneEndMargin;
    this.goneStartMargin = paramLayout.goneStartMargin;
    this.verticalWeight = paramLayout.verticalWeight;
    this.horizontalWeight = paramLayout.horizontalWeight;
    this.horizontalChainStyle = paramLayout.horizontalChainStyle;
    this.verticalChainStyle = paramLayout.verticalChainStyle;
    this.widthDefault = paramLayout.widthDefault;
    this.heightDefault = paramLayout.heightDefault;
    this.widthMax = paramLayout.widthMax;
    this.heightMax = paramLayout.heightMax;
    this.widthMin = paramLayout.widthMin;
    this.heightMin = paramLayout.heightMin;
    this.widthPercent = paramLayout.widthPercent;
    this.heightPercent = paramLayout.heightPercent;
    this.mBarrierDirection = paramLayout.mBarrierDirection;
    this.mBarrierMargin = paramLayout.mBarrierMargin;
    this.mHelperType = paramLayout.mHelperType;
    this.mConstraintTag = paramLayout.mConstraintTag;
    int[] arrayOfInt = paramLayout.mReferenceIds;
    if (arrayOfInt != null) {
      this.mReferenceIds = Arrays.copyOf(arrayOfInt, arrayOfInt.length);
    } else {
      this.mReferenceIds = null;
    }
    this.mReferenceIdString = paramLayout.mReferenceIdString;
    this.constrainedWidth = paramLayout.constrainedWidth;
    this.constrainedHeight = paramLayout.constrainedHeight;
    this.mBarrierAllowsGoneWidgets = paramLayout.mBarrierAllowsGoneWidgets;
  }
  
  public void dump(MotionScene paramMotionScene, StringBuilder paramStringBuilder)
  {
    Field[] arrayOfField = getClass().getDeclaredFields();
    paramStringBuilder.append("\n");
    int i = 0;
    while (i < arrayOfField.length)
    {
      Object localObject3 = arrayOfField[i];
      Object localObject1 = ((Field)localObject3).getName();
      if (!Modifier.isStatic(((Field)localObject3).getModifiers())) {
        try
        {
          Object localObject2 = ((Field)localObject3).get(this);
          localObject3 = ((Field)localObject3).getType();
          Class localClass = Integer.TYPE;
          if (localObject3 == localClass)
          {
            localObject2 = (Integer)localObject2;
            if (((Integer)localObject2).intValue() != -1)
            {
              localObject3 = paramMotionScene.lookUpConstraintName(((Integer)localObject2).intValue());
              paramStringBuilder.append("    ");
              paramStringBuilder.append((String)localObject1);
              paramStringBuilder.append(" = \"");
              localObject1 = localObject3;
              if (localObject3 == null) {
                localObject1 = localObject2;
              }
              paramStringBuilder.append(localObject1);
              paramStringBuilder.append("\"\n");
            }
          }
          else if (localObject3 == Float.TYPE)
          {
            localObject2 = (Float)localObject2;
            if (((Float)localObject2).floatValue() != -1.0F)
            {
              paramStringBuilder.append("    ");
              paramStringBuilder.append((String)localObject1);
              paramStringBuilder.append(" = \"");
              paramStringBuilder.append(localObject2);
              paramStringBuilder.append("\"\n");
            }
          }
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localIllegalAccessException.printStackTrace();
        }
      }
      i += 1;
    }
  }
  
  void fillFromAttributeList(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.Layout);
    this.mApply = true;
    int j = paramContext.getIndexCount();
    int i = 0;
    while (i < j)
    {
      int k = paramContext.getIndex(i);
      int m = mapToConstant.get(k);
      if (m != 80)
      {
        if (m != 81) {
          switch (m)
          {
          default: 
            switch (m)
            {
            default: 
              switch (m)
              {
              default: 
                switch (m)
                {
                default: 
                  paramAttributeSet = new StringBuilder();
                  paramAttributeSet.append("Unknown attribute 0x");
                  paramAttributeSet.append(Integer.toHexString(k));
                  paramAttributeSet.append("   ");
                  paramAttributeSet.append(mapToConstant.get(k));
                  Log.w("ConstraintSet", paramAttributeSet.toString());
                  break;
                case 77: 
                  this.mConstraintTag = paramContext.getString(k);
                  break;
                case 76: 
                  paramAttributeSet = new StringBuilder();
                  paramAttributeSet.append("unused attribute 0x");
                  paramAttributeSet.append(Integer.toHexString(k));
                  paramAttributeSet.append("   ");
                  paramAttributeSet.append(mapToConstant.get(k));
                  Log.w("ConstraintSet", paramAttributeSet.toString());
                  break;
                case 75: 
                  this.mBarrierAllowsGoneWidgets = paramContext.getBoolean(k, this.mBarrierAllowsGoneWidgets);
                  break;
                case 74: 
                  this.mReferenceIdString = paramContext.getString(k);
                  break;
                case 73: 
                  this.mBarrierMargin = paramContext.getDimensionPixelSize(k, this.mBarrierMargin);
                  break;
                case 72: 
                  this.mBarrierDirection = paramContext.getInt(k, this.mBarrierDirection);
                  break;
                case 71: 
                  Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                  break;
                case 70: 
                  this.heightPercent = paramContext.getFloat(k, 1.0F);
                  break;
                case 69: 
                  this.widthPercent = paramContext.getFloat(k, 1.0F);
                }
                break;
              case 63: 
                this.circleAngle = paramContext.getFloat(k, this.circleAngle);
                break;
              case 62: 
                this.circleRadius = paramContext.getDimensionPixelSize(k, this.circleRadius);
                break;
              case 61: 
                this.circleConstraint = ConstraintSet.access$100(paramContext, k, this.circleConstraint);
              }
              break;
            case 59: 
              this.heightMin = paramContext.getDimensionPixelSize(k, this.heightMin);
              break;
            case 58: 
              this.widthMin = paramContext.getDimensionPixelSize(k, this.widthMin);
              break;
            case 57: 
              this.heightMax = paramContext.getDimensionPixelSize(k, this.heightMax);
              break;
            case 56: 
              this.widthMax = paramContext.getDimensionPixelSize(k, this.widthMax);
              break;
            case 55: 
              this.heightDefault = paramContext.getInt(k, this.heightDefault);
              break;
            case 54: 
              this.widthDefault = paramContext.getInt(k, this.widthDefault);
            }
            break;
          case 40: 
            this.verticalChainStyle = paramContext.getInt(k, this.verticalChainStyle);
            break;
          case 39: 
            this.horizontalChainStyle = paramContext.getInt(k, this.horizontalChainStyle);
            break;
          case 38: 
            this.verticalWeight = paramContext.getFloat(k, this.verticalWeight);
            break;
          case 37: 
            this.horizontalWeight = paramContext.getFloat(k, this.horizontalWeight);
            break;
          case 36: 
            this.verticalBias = paramContext.getFloat(k, this.verticalBias);
            break;
          case 35: 
            this.topToTop = ConstraintSet.access$100(paramContext, k, this.topToTop);
            break;
          case 34: 
            this.topToBottom = ConstraintSet.access$100(paramContext, k, this.topToBottom);
            break;
          case 33: 
            this.topMargin = paramContext.getDimensionPixelSize(k, this.topMargin);
            break;
          case 32: 
            this.startToStart = ConstraintSet.access$100(paramContext, k, this.startToStart);
            break;
          case 31: 
            this.startToEnd = ConstraintSet.access$100(paramContext, k, this.startToEnd);
            break;
          case 30: 
            if (Build.VERSION.SDK_INT < 17) {
              break;
            }
            this.startMargin = paramContext.getDimensionPixelSize(k, this.startMargin);
            break;
          case 29: 
            this.rightToRight = ConstraintSet.access$100(paramContext, k, this.rightToRight);
            break;
          case 28: 
            this.rightToLeft = ConstraintSet.access$100(paramContext, k, this.rightToLeft);
            break;
          case 27: 
            this.rightMargin = paramContext.getDimensionPixelSize(k, this.rightMargin);
            break;
          case 26: 
            this.orientation = paramContext.getInt(k, this.orientation);
            break;
          case 25: 
            this.leftToRight = ConstraintSet.access$100(paramContext, k, this.leftToRight);
            break;
          case 24: 
            this.leftToLeft = ConstraintSet.access$100(paramContext, k, this.leftToLeft);
            break;
          case 23: 
            this.leftMargin = paramContext.getDimensionPixelSize(k, this.leftMargin);
            break;
          case 22: 
            this.mWidth = paramContext.getLayoutDimension(k, this.mWidth);
            break;
          case 21: 
            this.mHeight = paramContext.getLayoutDimension(k, this.mHeight);
            break;
          case 20: 
            this.horizontalBias = paramContext.getFloat(k, this.horizontalBias);
            break;
          case 19: 
            this.guidePercent = paramContext.getFloat(k, this.guidePercent);
            break;
          case 18: 
            this.guideEnd = paramContext.getDimensionPixelOffset(k, this.guideEnd);
            break;
          case 17: 
            this.guideBegin = paramContext.getDimensionPixelOffset(k, this.guideBegin);
            break;
          case 16: 
            this.goneTopMargin = paramContext.getDimensionPixelSize(k, this.goneTopMargin);
            break;
          case 15: 
            this.goneStartMargin = paramContext.getDimensionPixelSize(k, this.goneStartMargin);
            break;
          case 14: 
            this.goneRightMargin = paramContext.getDimensionPixelSize(k, this.goneRightMargin);
            break;
          case 13: 
            this.goneLeftMargin = paramContext.getDimensionPixelSize(k, this.goneLeftMargin);
            break;
          case 12: 
            this.goneEndMargin = paramContext.getDimensionPixelSize(k, this.goneEndMargin);
            break;
          case 11: 
            this.goneBottomMargin = paramContext.getDimensionPixelSize(k, this.goneBottomMargin);
            break;
          case 10: 
            this.endToStart = ConstraintSet.access$100(paramContext, k, this.endToStart);
            break;
          case 9: 
            this.endToEnd = ConstraintSet.access$100(paramContext, k, this.endToEnd);
            break;
          case 8: 
            if (Build.VERSION.SDK_INT < 17) {
              break;
            }
            this.endMargin = paramContext.getDimensionPixelSize(k, this.endMargin);
            break;
          case 7: 
            this.editorAbsoluteY = paramContext.getDimensionPixelOffset(k, this.editorAbsoluteY);
            break;
          case 6: 
            this.editorAbsoluteX = paramContext.getDimensionPixelOffset(k, this.editorAbsoluteX);
            break;
          case 5: 
            this.dimensionRatio = paramContext.getString(k);
            break;
          case 4: 
            this.bottomToTop = ConstraintSet.access$100(paramContext, k, this.bottomToTop);
            break;
          case 3: 
            this.bottomToBottom = ConstraintSet.access$100(paramContext, k, this.bottomToBottom);
            break;
          case 2: 
            this.bottomMargin = paramContext.getDimensionPixelSize(k, this.bottomMargin);
            break;
          case 1: 
            this.baselineToBaseline = ConstraintSet.access$100(paramContext, k, this.baselineToBaseline);
            break;
          }
        } else {
          this.constrainedHeight = paramContext.getBoolean(k, this.constrainedHeight);
        }
      }
      else {
        this.constrainedWidth = paramContext.getBoolean(k, this.constrainedWidth);
      }
      i += 1;
    }
    paramContext.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.widget.ConstraintSet.Layout
 * JD-Core Version:    0.7.0.1
 */