package androidx.constraintlayout.helper.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View.MeasureSpec;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.constraintlayout.widget.ConstraintSet.Constraint;
import androidx.constraintlayout.widget.R.styleable;

public class Flow
  extends androidx.constraintlayout.widget.VirtualLayout
{
  public static final int CHAIN_PACKED = 2;
  public static final int CHAIN_SPREAD = 0;
  public static final int CHAIN_SPREAD_INSIDE = 1;
  public static final int HORIZONTAL = 0;
  public static final int HORIZONTAL_ALIGN_CENTER = 2;
  public static final int HORIZONTAL_ALIGN_END = 1;
  public static final int HORIZONTAL_ALIGN_START = 0;
  private static final String TAG = "Flow";
  public static final int VERTICAL = 1;
  public static final int VERTICAL_ALIGN_BASELINE = 3;
  public static final int VERTICAL_ALIGN_BOTTOM = 1;
  public static final int VERTICAL_ALIGN_CENTER = 2;
  public static final int VERTICAL_ALIGN_TOP = 0;
  public static final int WRAP_ALIGNED = 2;
  public static final int WRAP_CHAIN = 1;
  public static final int WRAP_NONE = 0;
  private androidx.constraintlayout.solver.widgets.Flow mFlow;
  
  public Flow(Context paramContext)
  {
    super(paramContext);
  }
  
  public Flow(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public Flow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void init(AttributeSet paramAttributeSet)
  {
    super.init(paramAttributeSet);
    this.mFlow = new androidx.constraintlayout.solver.widgets.Flow();
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int j = paramAttributeSet.getIndexCount();
      int i = 0;
      while (i < j)
      {
        int k = paramAttributeSet.getIndex(i);
        if (k == R.styleable.ConstraintLayout_Layout_android_orientation) {
          this.mFlow.setOrientation(paramAttributeSet.getInt(k, 0));
        } else if (k == R.styleable.ConstraintLayout_Layout_android_padding) {
          this.mFlow.setPadding(paramAttributeSet.getDimensionPixelSize(k, 0));
        } else if (k == R.styleable.ConstraintLayout_Layout_android_paddingStart)
        {
          if (Build.VERSION.SDK_INT >= 17) {
            this.mFlow.setPaddingStart(paramAttributeSet.getDimensionPixelSize(k, 0));
          }
        }
        else if (k == R.styleable.ConstraintLayout_Layout_android_paddingEnd)
        {
          if (Build.VERSION.SDK_INT >= 17) {
            this.mFlow.setPaddingEnd(paramAttributeSet.getDimensionPixelSize(k, 0));
          }
        }
        else if (k == R.styleable.ConstraintLayout_Layout_android_paddingLeft) {
          this.mFlow.setPaddingLeft(paramAttributeSet.getDimensionPixelSize(k, 0));
        } else if (k == R.styleable.ConstraintLayout_Layout_android_paddingTop) {
          this.mFlow.setPaddingTop(paramAttributeSet.getDimensionPixelSize(k, 0));
        } else if (k == R.styleable.ConstraintLayout_Layout_android_paddingRight) {
          this.mFlow.setPaddingRight(paramAttributeSet.getDimensionPixelSize(k, 0));
        } else if (k == R.styleable.ConstraintLayout_Layout_android_paddingBottom) {
          this.mFlow.setPaddingBottom(paramAttributeSet.getDimensionPixelSize(k, 0));
        } else if (k == R.styleable.ConstraintLayout_Layout_flow_wrapMode) {
          this.mFlow.setWrapMode(paramAttributeSet.getInt(k, 0));
        } else if (k == R.styleable.ConstraintLayout_Layout_flow_horizontalStyle) {
          this.mFlow.setHorizontalStyle(paramAttributeSet.getInt(k, 0));
        } else if (k == R.styleable.ConstraintLayout_Layout_flow_verticalStyle) {
          this.mFlow.setVerticalStyle(paramAttributeSet.getInt(k, 0));
        } else if (k == R.styleable.ConstraintLayout_Layout_flow_firstHorizontalStyle) {
          this.mFlow.setFirstHorizontalStyle(paramAttributeSet.getInt(k, 0));
        } else if (k == R.styleable.ConstraintLayout_Layout_flow_lastHorizontalStyle) {
          this.mFlow.setLastHorizontalStyle(paramAttributeSet.getInt(k, 0));
        } else if (k == R.styleable.ConstraintLayout_Layout_flow_firstVerticalStyle) {
          this.mFlow.setFirstVerticalStyle(paramAttributeSet.getInt(k, 0));
        } else if (k == R.styleable.ConstraintLayout_Layout_flow_lastVerticalStyle) {
          this.mFlow.setLastVerticalStyle(paramAttributeSet.getInt(k, 0));
        } else if (k == R.styleable.ConstraintLayout_Layout_flow_horizontalBias) {
          this.mFlow.setHorizontalBias(paramAttributeSet.getFloat(k, 0.5F));
        } else if (k == R.styleable.ConstraintLayout_Layout_flow_firstHorizontalBias) {
          this.mFlow.setFirstHorizontalBias(paramAttributeSet.getFloat(k, 0.5F));
        } else if (k == R.styleable.ConstraintLayout_Layout_flow_lastHorizontalBias) {
          this.mFlow.setLastHorizontalBias(paramAttributeSet.getFloat(k, 0.5F));
        } else if (k == R.styleable.ConstraintLayout_Layout_flow_firstVerticalBias) {
          this.mFlow.setFirstVerticalBias(paramAttributeSet.getFloat(k, 0.5F));
        } else if (k == R.styleable.ConstraintLayout_Layout_flow_lastVerticalBias) {
          this.mFlow.setLastVerticalBias(paramAttributeSet.getFloat(k, 0.5F));
        } else if (k == R.styleable.ConstraintLayout_Layout_flow_verticalBias) {
          this.mFlow.setVerticalBias(paramAttributeSet.getFloat(k, 0.5F));
        } else if (k == R.styleable.ConstraintLayout_Layout_flow_horizontalAlign) {
          this.mFlow.setHorizontalAlign(paramAttributeSet.getInt(k, 2));
        } else if (k == R.styleable.ConstraintLayout_Layout_flow_verticalAlign) {
          this.mFlow.setVerticalAlign(paramAttributeSet.getInt(k, 2));
        } else if (k == R.styleable.ConstraintLayout_Layout_flow_horizontalGap) {
          this.mFlow.setHorizontalGap(paramAttributeSet.getDimensionPixelSize(k, 0));
        } else if (k == R.styleable.ConstraintLayout_Layout_flow_verticalGap) {
          this.mFlow.setVerticalGap(paramAttributeSet.getDimensionPixelSize(k, 0));
        } else if (k == R.styleable.ConstraintLayout_Layout_flow_maxElementsWrap) {
          this.mFlow.setMaxElementsWrap(paramAttributeSet.getInt(k, -1));
        }
        i += 1;
      }
      paramAttributeSet.recycle();
    }
    this.mHelperWidget = this.mFlow;
    validateParams();
  }
  
  public void loadParameters(ConstraintSet.Constraint paramConstraint, HelperWidget paramHelperWidget, ConstraintLayout.LayoutParams paramLayoutParams, SparseArray<ConstraintWidget> paramSparseArray)
  {
    super.loadParameters(paramConstraint, paramHelperWidget, paramLayoutParams, paramSparseArray);
    if ((paramHelperWidget instanceof androidx.constraintlayout.solver.widgets.Flow))
    {
      paramConstraint = (androidx.constraintlayout.solver.widgets.Flow)paramHelperWidget;
      if (paramLayoutParams.orientation != -1) {
        paramConstraint.setOrientation(paramLayoutParams.orientation);
      }
    }
  }
  
  @SuppressLint({"WrongCall"})
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    onMeasure(this.mFlow, paramInt1, paramInt2);
  }
  
  public void onMeasure(androidx.constraintlayout.solver.widgets.VirtualLayout paramVirtualLayout, int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (paramVirtualLayout != null)
    {
      paramVirtualLayout.measure(i, paramInt1, j, paramInt2);
      setMeasuredDimension(paramVirtualLayout.getMeasuredWidth(), paramVirtualLayout.getMeasuredHeight());
      return;
    }
    setMeasuredDimension(0, 0);
  }
  
  public void resolveRtl(ConstraintWidget paramConstraintWidget, boolean paramBoolean)
  {
    this.mFlow.applyRtl(paramBoolean);
  }
  
  public void setFirstHorizontalBias(float paramFloat)
  {
    this.mFlow.setFirstHorizontalBias(paramFloat);
    requestLayout();
  }
  
  public void setFirstHorizontalStyle(int paramInt)
  {
    this.mFlow.setFirstHorizontalStyle(paramInt);
    requestLayout();
  }
  
  public void setFirstVerticalBias(float paramFloat)
  {
    this.mFlow.setFirstVerticalBias(paramFloat);
    requestLayout();
  }
  
  public void setFirstVerticalStyle(int paramInt)
  {
    this.mFlow.setFirstVerticalStyle(paramInt);
    requestLayout();
  }
  
  public void setHorizontalAlign(int paramInt)
  {
    this.mFlow.setHorizontalAlign(paramInt);
    requestLayout();
  }
  
  public void setHorizontalBias(float paramFloat)
  {
    this.mFlow.setHorizontalBias(paramFloat);
    requestLayout();
  }
  
  public void setHorizontalGap(int paramInt)
  {
    this.mFlow.setHorizontalGap(paramInt);
    requestLayout();
  }
  
  public void setHorizontalStyle(int paramInt)
  {
    this.mFlow.setHorizontalStyle(paramInt);
    requestLayout();
  }
  
  public void setMaxElementsWrap(int paramInt)
  {
    this.mFlow.setMaxElementsWrap(paramInt);
    requestLayout();
  }
  
  public void setOrientation(int paramInt)
  {
    this.mFlow.setOrientation(paramInt);
    requestLayout();
  }
  
  public void setPadding(int paramInt)
  {
    this.mFlow.setPadding(paramInt);
    requestLayout();
  }
  
  public void setPaddingBottom(int paramInt)
  {
    this.mFlow.setPaddingBottom(paramInt);
    requestLayout();
  }
  
  public void setPaddingLeft(int paramInt)
  {
    this.mFlow.setPaddingLeft(paramInt);
    requestLayout();
  }
  
  public void setPaddingRight(int paramInt)
  {
    this.mFlow.setPaddingRight(paramInt);
    requestLayout();
  }
  
  public void setPaddingTop(int paramInt)
  {
    this.mFlow.setPaddingTop(paramInt);
    requestLayout();
  }
  
  public void setVerticalAlign(int paramInt)
  {
    this.mFlow.setVerticalAlign(paramInt);
    requestLayout();
  }
  
  public void setVerticalBias(float paramFloat)
  {
    this.mFlow.setVerticalBias(paramFloat);
    requestLayout();
  }
  
  public void setVerticalGap(int paramInt)
  {
    this.mFlow.setVerticalGap(paramInt);
    requestLayout();
  }
  
  public void setVerticalStyle(int paramInt)
  {
    this.mFlow.setVerticalStyle(paramInt);
    requestLayout();
  }
  
  public void setWrapMode(int paramInt)
  {
    this.mFlow.setWrapMode(paramInt);
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.helper.widget.Flow
 * JD-Core Version:    0.7.0.1
 */