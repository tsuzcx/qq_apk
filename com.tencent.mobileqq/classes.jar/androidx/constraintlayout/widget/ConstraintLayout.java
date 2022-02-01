package androidx.constraintlayout.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstraintLayout
  extends ViewGroup
{
  private static final boolean DEBUG = false;
  private static final boolean DEBUG_DRAW_CONSTRAINTS = false;
  public static final int DESIGN_INFO_ID = 0;
  private static final boolean MEASURE = false;
  private static final String TAG = "ConstraintLayout";
  private static final boolean USE_CONSTRAINTS_HELPER = true;
  public static final String VERSION = "ConstraintLayout-2.0.4";
  SparseArray<View> mChildrenByIds = new SparseArray();
  private ArrayList<ConstraintHelper> mConstraintHelpers = new ArrayList(4);
  protected ConstraintLayoutStates mConstraintLayoutSpec = null;
  private ConstraintSet mConstraintSet = null;
  private int mConstraintSetId = -1;
  private ConstraintsChangedListener mConstraintsChangedListener;
  private HashMap<String, Integer> mDesignIds = new HashMap();
  protected boolean mDirtyHierarchy = true;
  private int mLastMeasureHeight = -1;
  int mLastMeasureHeightMode = 0;
  int mLastMeasureHeightSize = -1;
  private int mLastMeasureWidth = -1;
  int mLastMeasureWidthMode = 0;
  int mLastMeasureWidthSize = -1;
  protected ConstraintWidgetContainer mLayoutWidget = new ConstraintWidgetContainer();
  private int mMaxHeight = 2147483647;
  private int mMaxWidth = 2147483647;
  ConstraintLayout.Measurer mMeasurer = new ConstraintLayout.Measurer(this, this);
  private Metrics mMetrics;
  private int mMinHeight = 0;
  private int mMinWidth = 0;
  private int mOnMeasureHeightMeasureSpec = 0;
  private int mOnMeasureWidthMeasureSpec = 0;
  private int mOptimizationLevel = 257;
  private SparseArray<ConstraintWidget> mTempMapIdToWidget = new SparseArray();
  
  public ConstraintLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    init(null, 0, 0);
  }
  
  public ConstraintLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramAttributeSet, 0, 0);
  }
  
  public ConstraintLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramAttributeSet, paramInt, 0);
  }
  
  @TargetApi(21)
  public ConstraintLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    init(paramAttributeSet, paramInt1, paramInt2);
  }
  
  private int getPaddingWidth()
  {
    int j = getPaddingLeft();
    int i = 0;
    j = Math.max(0, j) + Math.max(0, getPaddingRight());
    if (Build.VERSION.SDK_INT >= 17)
    {
      i = Math.max(0, getPaddingStart());
      i = Math.max(0, getPaddingEnd()) + i;
    }
    if (i > 0) {
      j = i;
    }
    return j;
  }
  
  private final ConstraintWidget getTargetWidget(int paramInt)
  {
    if (paramInt == 0) {
      return this.mLayoutWidget;
    }
    View localView2 = (View)this.mChildrenByIds.get(paramInt);
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView2 = findViewById(paramInt);
      localView1 = localView2;
      if (localView2 != null)
      {
        localView1 = localView2;
        if (localView2 != this)
        {
          localView1 = localView2;
          if (localView2.getParent() == this)
          {
            onViewAdded(localView2);
            localView1 = localView2;
          }
        }
      }
    }
    if (localView1 == this) {
      return this.mLayoutWidget;
    }
    if (localView1 == null) {
      return null;
    }
    return ((ConstraintLayout.LayoutParams)localView1.getLayoutParams()).widget;
  }
  
  private void init(AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    this.mLayoutWidget.setCompanionWidget(this);
    this.mLayoutWidget.setMeasurer(this.mMeasurer);
    this.mChildrenByIds.put(getId(), this);
    this.mConstraintSet = null;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout, paramInt1, paramInt2);
      paramInt2 = paramAttributeSet.getIndexCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        int i = paramAttributeSet.getIndex(paramInt1);
        if (i == R.styleable.ConstraintLayout_Layout_android_minWidth)
        {
          this.mMinWidth = paramAttributeSet.getDimensionPixelOffset(i, this.mMinWidth);
        }
        else if (i == R.styleable.ConstraintLayout_Layout_android_minHeight)
        {
          this.mMinHeight = paramAttributeSet.getDimensionPixelOffset(i, this.mMinHeight);
        }
        else if (i == R.styleable.ConstraintLayout_Layout_android_maxWidth)
        {
          this.mMaxWidth = paramAttributeSet.getDimensionPixelOffset(i, this.mMaxWidth);
        }
        else if (i == R.styleable.ConstraintLayout_Layout_android_maxHeight)
        {
          this.mMaxHeight = paramAttributeSet.getDimensionPixelOffset(i, this.mMaxHeight);
        }
        else if (i == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel)
        {
          this.mOptimizationLevel = paramAttributeSet.getInt(i, this.mOptimizationLevel);
        }
        else if (i == R.styleable.ConstraintLayout_Layout_layoutDescription)
        {
          i = paramAttributeSet.getResourceId(i, 0);
          if (i == 0) {
            break label292;
          }
        }
        try
        {
          parseLayoutDescription(i);
        }
        catch (Resources.NotFoundException localNotFoundException1)
        {
          label229:
          break label229;
        }
        this.mConstraintLayoutSpec = null;
        break label292;
        if (i == R.styleable.ConstraintLayout_Layout_constraintSet) {
          i = paramAttributeSet.getResourceId(i, 0);
        }
        try
        {
          this.mConstraintSet = new ConstraintSet();
          this.mConstraintSet.load(getContext(), i);
        }
        catch (Resources.NotFoundException localNotFoundException2)
        {
          label281:
          break label281;
        }
        this.mConstraintSet = null;
        this.mConstraintSetId = i;
        label292:
        paramInt1 += 1;
      }
      paramAttributeSet.recycle();
    }
    else
    {
      this.mLayoutWidget.setOptimizationLevel(this.mOptimizationLevel);
      return;
    }
  }
  
  private void markHierarchyDirty()
  {
    this.mDirtyHierarchy = true;
    this.mLastMeasureWidth = -1;
    this.mLastMeasureHeight = -1;
    this.mLastMeasureWidthSize = -1;
    this.mLastMeasureHeightSize = -1;
    this.mLastMeasureWidthMode = 0;
    this.mLastMeasureHeightMode = 0;
  }
  
  private void setChildrenConstraints()
  {
    boolean bool = isInEditMode();
    int j = getChildCount();
    int i = 0;
    Object localObject1;
    while (i < j)
    {
      localObject1 = getViewWidget(getChildAt(i));
      if (localObject1 != null) {
        ((ConstraintWidget)localObject1).reset();
      }
      i += 1;
    }
    Object localObject3;
    if (bool)
    {
      i = 0;
      while (i < j)
      {
        localObject3 = getChildAt(i);
        try
        {
          localObject2 = getResources().getResourceName(((View)localObject3).getId());
          setDesignInformation(0, localObject2, Integer.valueOf(((View)localObject3).getId()));
          k = ((String)localObject2).indexOf('/');
          localObject1 = localObject2;
          if (k != -1) {
            localObject1 = ((String)localObject2).substring(k + 1);
          }
          getTargetWidget(((View)localObject3).getId()).setDebugName((String)localObject1);
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          Object localObject2;
          int k;
          label138:
          break label138;
        }
        i += 1;
      }
    }
    else
    {
      if (this.mConstraintSetId != -1)
      {
        i = 0;
        while (i < j)
        {
          localObject1 = getChildAt(i);
          if ((((View)localObject1).getId() == this.mConstraintSetId) && ((localObject1 instanceof Constraints))) {
            this.mConstraintSet = ((Constraints)localObject1).getConstraintSet();
          }
          i += 1;
        }
      }
      localObject1 = this.mConstraintSet;
      if (localObject1 != null) {
        ((ConstraintSet)localObject1).applyToInternal(this, true);
      }
      this.mLayoutWidget.removeAllChildren();
      k = this.mConstraintHelpers.size();
      if (k > 0)
      {
        i = 0;
        while (i < k)
        {
          ((ConstraintHelper)this.mConstraintHelpers.get(i)).updatePreLayout(this);
          i += 1;
        }
      }
      i = 0;
      while (i < j)
      {
        localObject1 = getChildAt(i);
        if ((localObject1 instanceof Placeholder)) {
          ((Placeholder)localObject1).updatePreLayout(this);
        }
        i += 1;
      }
      this.mTempMapIdToWidget.clear();
      this.mTempMapIdToWidget.put(0, this.mLayoutWidget);
      this.mTempMapIdToWidget.put(getId(), this.mLayoutWidget);
      i = 0;
      while (i < j)
      {
        localObject1 = getChildAt(i);
        localObject2 = getViewWidget((View)localObject1);
        this.mTempMapIdToWidget.put(((View)localObject1).getId(), localObject2);
        i += 1;
      }
      i = 0;
      while (i < j)
      {
        localObject1 = getChildAt(i);
        localObject2 = getViewWidget((View)localObject1);
        if (localObject2 != null)
        {
          localObject3 = (ConstraintLayout.LayoutParams)((View)localObject1).getLayoutParams();
          this.mLayoutWidget.add((ConstraintWidget)localObject2);
          applyConstraintsFromLayoutParams(bool, (View)localObject1, (ConstraintWidget)localObject2, (ConstraintLayout.LayoutParams)localObject3, this.mTempMapIdToWidget);
        }
        i += 1;
      }
      return;
    }
  }
  
  private boolean updateHierarchy()
  {
    int j = getChildCount();
    boolean bool2 = false;
    int i = 0;
    boolean bool1;
    for (;;)
    {
      bool1 = bool2;
      if (i >= j) {
        break;
      }
      if (getChildAt(i).isLayoutRequested())
      {
        bool1 = true;
        break;
      }
      i += 1;
    }
    if (bool1) {
      setChildrenConstraints();
    }
    return bool1;
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    if (Build.VERSION.SDK_INT < 14) {
      onViewAdded(paramView);
    }
  }
  
  protected void applyConstraintsFromLayoutParams(boolean paramBoolean, View paramView, ConstraintWidget paramConstraintWidget, ConstraintLayout.LayoutParams paramLayoutParams, SparseArray<ConstraintWidget> paramSparseArray)
  {
    paramLayoutParams.validate();
    paramLayoutParams.helped = false;
    paramConstraintWidget.setVisibility(paramView.getVisibility());
    if (paramLayoutParams.isInPlaceholder)
    {
      paramConstraintWidget.setInPlaceholder(true);
      paramConstraintWidget.setVisibility(8);
    }
    paramConstraintWidget.setCompanionWidget(paramView);
    if ((paramView instanceof ConstraintHelper)) {
      ((ConstraintHelper)paramView).resolveRtl(paramConstraintWidget, this.mLayoutWidget.isRtl());
    }
    int i;
    int j;
    float f;
    if (paramLayoutParams.isGuideline)
    {
      paramView = (androidx.constraintlayout.solver.widgets.Guideline)paramConstraintWidget;
      i = paramLayoutParams.resolvedGuideBegin;
      j = paramLayoutParams.resolvedGuideEnd;
      f = paramLayoutParams.resolvedGuidePercent;
      if (Build.VERSION.SDK_INT < 17)
      {
        i = paramLayoutParams.guideBegin;
        j = paramLayoutParams.guideEnd;
        f = paramLayoutParams.guidePercent;
      }
      if (f != -1.0F)
      {
        paramView.setGuidePercent(f);
        return;
      }
      if (i != -1)
      {
        paramView.setGuideBegin(i);
        return;
      }
      if (j != -1) {
        paramView.setGuideEnd(j);
      }
    }
    else
    {
      j = paramLayoutParams.resolvedLeftToLeft;
      i = paramLayoutParams.resolvedLeftToRight;
      int m = paramLayoutParams.resolvedRightToLeft;
      int k = paramLayoutParams.resolvedRightToRight;
      int i1 = paramLayoutParams.resolveGoneLeftMargin;
      int n = paramLayoutParams.resolveGoneRightMargin;
      f = paramLayoutParams.resolvedHorizontalBias;
      if (Build.VERSION.SDK_INT < 17)
      {
        k = paramLayoutParams.leftToLeft;
        m = paramLayoutParams.leftToRight;
        int i2 = paramLayoutParams.rightToLeft;
        int i3 = paramLayoutParams.rightToRight;
        i1 = paramLayoutParams.goneLeftMargin;
        n = paramLayoutParams.goneRightMargin;
        f = paramLayoutParams.horizontalBias;
        j = k;
        i = m;
        if (k == -1)
        {
          j = k;
          i = m;
          if (m == -1) {
            if (paramLayoutParams.startToStart != -1)
            {
              j = paramLayoutParams.startToStart;
              i = m;
            }
            else
            {
              j = k;
              i = m;
              if (paramLayoutParams.startToEnd != -1)
              {
                i = paramLayoutParams.startToEnd;
                j = k;
              }
            }
          }
        }
        m = i2;
        k = i3;
        if (i2 == -1)
        {
          m = i2;
          k = i3;
          if (i3 == -1) {
            if (paramLayoutParams.endToStart != -1)
            {
              m = paramLayoutParams.endToStart;
              k = i3;
            }
            else
            {
              m = i2;
              k = i3;
              if (paramLayoutParams.endToEnd != -1)
              {
                k = paramLayoutParams.endToEnd;
                m = i2;
              }
            }
          }
        }
      }
      if (paramLayoutParams.circleConstraint != -1)
      {
        paramView = (ConstraintWidget)paramSparseArray.get(paramLayoutParams.circleConstraint);
        if (paramView != null) {
          paramConstraintWidget.connectCircularConstraint(paramView, paramLayoutParams.circleAngle, paramLayoutParams.circleRadius);
        }
      }
      else
      {
        if (j != -1)
        {
          paramView = (ConstraintWidget)paramSparseArray.get(j);
          if (paramView != null) {
            paramConstraintWidget.immediateConnect(ConstraintAnchor.Type.LEFT, paramView, ConstraintAnchor.Type.LEFT, paramLayoutParams.leftMargin, i1);
          }
        }
        else if (i != -1)
        {
          paramView = (ConstraintWidget)paramSparseArray.get(i);
          if (paramView != null) {
            paramConstraintWidget.immediateConnect(ConstraintAnchor.Type.LEFT, paramView, ConstraintAnchor.Type.RIGHT, paramLayoutParams.leftMargin, i1);
          }
        }
        if (m != -1)
        {
          paramView = (ConstraintWidget)paramSparseArray.get(m);
          if (paramView != null) {
            paramConstraintWidget.immediateConnect(ConstraintAnchor.Type.RIGHT, paramView, ConstraintAnchor.Type.LEFT, paramLayoutParams.rightMargin, n);
          }
        }
        else if (k != -1)
        {
          paramView = (ConstraintWidget)paramSparseArray.get(k);
          if (paramView != null) {
            paramConstraintWidget.immediateConnect(ConstraintAnchor.Type.RIGHT, paramView, ConstraintAnchor.Type.RIGHT, paramLayoutParams.rightMargin, n);
          }
        }
        if (paramLayoutParams.topToTop != -1)
        {
          paramView = (ConstraintWidget)paramSparseArray.get(paramLayoutParams.topToTop);
          if (paramView != null) {
            paramConstraintWidget.immediateConnect(ConstraintAnchor.Type.TOP, paramView, ConstraintAnchor.Type.TOP, paramLayoutParams.topMargin, paramLayoutParams.goneTopMargin);
          }
        }
        else if (paramLayoutParams.topToBottom != -1)
        {
          paramView = (ConstraintWidget)paramSparseArray.get(paramLayoutParams.topToBottom);
          if (paramView != null) {
            paramConstraintWidget.immediateConnect(ConstraintAnchor.Type.TOP, paramView, ConstraintAnchor.Type.BOTTOM, paramLayoutParams.topMargin, paramLayoutParams.goneTopMargin);
          }
        }
        if (paramLayoutParams.bottomToTop != -1)
        {
          paramView = (ConstraintWidget)paramSparseArray.get(paramLayoutParams.bottomToTop);
          if (paramView != null) {
            paramConstraintWidget.immediateConnect(ConstraintAnchor.Type.BOTTOM, paramView, ConstraintAnchor.Type.TOP, paramLayoutParams.bottomMargin, paramLayoutParams.goneBottomMargin);
          }
        }
        else if (paramLayoutParams.bottomToBottom != -1)
        {
          paramView = (ConstraintWidget)paramSparseArray.get(paramLayoutParams.bottomToBottom);
          if (paramView != null) {
            paramConstraintWidget.immediateConnect(ConstraintAnchor.Type.BOTTOM, paramView, ConstraintAnchor.Type.BOTTOM, paramLayoutParams.bottomMargin, paramLayoutParams.goneBottomMargin);
          }
        }
        if (paramLayoutParams.baselineToBaseline != -1)
        {
          paramView = (View)this.mChildrenByIds.get(paramLayoutParams.baselineToBaseline);
          paramSparseArray = (ConstraintWidget)paramSparseArray.get(paramLayoutParams.baselineToBaseline);
          if ((paramSparseArray != null) && (paramView != null) && ((paramView.getLayoutParams() instanceof ConstraintLayout.LayoutParams)))
          {
            paramView = (ConstraintLayout.LayoutParams)paramView.getLayoutParams();
            paramLayoutParams.needsBaseline = true;
            paramView.needsBaseline = true;
            paramConstraintWidget.getAnchor(ConstraintAnchor.Type.BASELINE).connect(paramSparseArray.getAnchor(ConstraintAnchor.Type.BASELINE), 0, -1, true);
            paramConstraintWidget.setHasBaseline(true);
            paramView.widget.setHasBaseline(true);
            paramConstraintWidget.getAnchor(ConstraintAnchor.Type.TOP).reset();
            paramConstraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).reset();
          }
        }
        if (f >= 0.0F) {
          paramConstraintWidget.setHorizontalBiasPercent(f);
        }
        if (paramLayoutParams.verticalBias >= 0.0F) {
          paramConstraintWidget.setVerticalBiasPercent(paramLayoutParams.verticalBias);
        }
      }
      if ((paramBoolean) && ((paramLayoutParams.editorAbsoluteX != -1) || (paramLayoutParams.editorAbsoluteY != -1))) {
        paramConstraintWidget.setOrigin(paramLayoutParams.editorAbsoluteX, paramLayoutParams.editorAbsoluteY);
      }
      if (!paramLayoutParams.horizontalDimensionFixed)
      {
        if (paramLayoutParams.width == -1)
        {
          if (paramLayoutParams.constrainedWidth) {
            paramConstraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
          } else {
            paramConstraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
          }
          paramConstraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).mMargin = paramLayoutParams.leftMargin;
          paramConstraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).mMargin = paramLayoutParams.rightMargin;
        }
        else
        {
          paramConstraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
          paramConstraintWidget.setWidth(0);
        }
      }
      else
      {
        paramConstraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        paramConstraintWidget.setWidth(paramLayoutParams.width);
        if (paramLayoutParams.width == -2) {
          paramConstraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
        }
      }
      if (!paramLayoutParams.verticalDimensionFixed)
      {
        if (paramLayoutParams.height == -1)
        {
          if (paramLayoutParams.constrainedHeight) {
            paramConstraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
          } else {
            paramConstraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
          }
          paramConstraintWidget.getAnchor(ConstraintAnchor.Type.TOP).mMargin = paramLayoutParams.topMargin;
          paramConstraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).mMargin = paramLayoutParams.bottomMargin;
        }
        else
        {
          paramConstraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
          paramConstraintWidget.setHeight(0);
        }
      }
      else
      {
        paramConstraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        paramConstraintWidget.setHeight(paramLayoutParams.height);
        if (paramLayoutParams.height == -2) {
          paramConstraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
        }
      }
      paramConstraintWidget.setDimensionRatio(paramLayoutParams.dimensionRatio);
      paramConstraintWidget.setHorizontalWeight(paramLayoutParams.horizontalWeight);
      paramConstraintWidget.setVerticalWeight(paramLayoutParams.verticalWeight);
      paramConstraintWidget.setHorizontalChainStyle(paramLayoutParams.horizontalChainStyle);
      paramConstraintWidget.setVerticalChainStyle(paramLayoutParams.verticalChainStyle);
      paramConstraintWidget.setHorizontalMatchStyle(paramLayoutParams.matchConstraintDefaultWidth, paramLayoutParams.matchConstraintMinWidth, paramLayoutParams.matchConstraintMaxWidth, paramLayoutParams.matchConstraintPercentWidth);
      paramConstraintWidget.setVerticalMatchStyle(paramLayoutParams.matchConstraintDefaultHeight, paramLayoutParams.matchConstraintMinHeight, paramLayoutParams.matchConstraintMaxHeight, paramLayoutParams.matchConstraintPercentHeight);
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof ConstraintLayout.LayoutParams;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    Object localObject = this.mConstraintHelpers;
    int j;
    int i;
    if (localObject != null)
    {
      j = ((ArrayList)localObject).size();
      if (j > 0)
      {
        i = 0;
        while (i < j)
        {
          ((ConstraintHelper)this.mConstraintHelpers.get(i)).updatePreDraw(this);
          i += 1;
        }
      }
    }
    super.dispatchDraw(paramCanvas);
    if (isInEditMode())
    {
      j = getChildCount();
      float f1 = getWidth();
      float f2 = getHeight();
      i = 0;
      while (i < j)
      {
        localObject = getChildAt(i);
        if (((View)localObject).getVisibility() != 8)
        {
          localObject = ((View)localObject).getTag();
          if ((localObject != null) && ((localObject instanceof String)))
          {
            localObject = ((String)localObject).split(",");
            if (localObject.length == 4)
            {
              int m = Integer.parseInt(localObject[0]);
              int i1 = Integer.parseInt(localObject[1]);
              int n = Integer.parseInt(localObject[2]);
              int k = Integer.parseInt(localObject[3]);
              m = (int)(m / 1080.0F * f1);
              i1 = (int)(i1 / 1920.0F * f2);
              n = (int)(n / 1080.0F * f1);
              k = (int)(k / 1920.0F * f2);
              localObject = new Paint();
              ((Paint)localObject).setColor(-65536);
              float f3 = m;
              float f4 = i1;
              float f5 = m + n;
              paramCanvas.drawLine(f3, f4, f5, f4, (Paint)localObject);
              float f6 = i1 + k;
              paramCanvas.drawLine(f5, f4, f5, f6, (Paint)localObject);
              paramCanvas.drawLine(f5, f6, f3, f6, (Paint)localObject);
              paramCanvas.drawLine(f3, f6, f3, f4, (Paint)localObject);
              ((Paint)localObject).setColor(-16711936);
              paramCanvas.drawLine(f3, f4, f5, f6, (Paint)localObject);
              paramCanvas.drawLine(f3, f6, f5, f4, (Paint)localObject);
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public void fillMetrics(Metrics paramMetrics)
  {
    this.mMetrics = paramMetrics;
    this.mLayoutWidget.fillMetrics(paramMetrics);
  }
  
  public void forceLayout()
  {
    markHierarchyDirty();
    super.forceLayout();
  }
  
  protected ConstraintLayout.LayoutParams generateDefaultLayoutParams()
  {
    return new ConstraintLayout.LayoutParams(-2, -2);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new ConstraintLayout.LayoutParams(paramLayoutParams);
  }
  
  public ConstraintLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ConstraintLayout.LayoutParams(getContext(), paramAttributeSet);
  }
  
  public Object getDesignInformation(int paramInt, Object paramObject)
  {
    if ((paramInt == 0) && ((paramObject instanceof String)))
    {
      paramObject = (String)paramObject;
      HashMap localHashMap = this.mDesignIds;
      if ((localHashMap != null) && (localHashMap.containsKey(paramObject))) {
        return this.mDesignIds.get(paramObject);
      }
    }
    return null;
  }
  
  public int getMaxHeight()
  {
    return this.mMaxHeight;
  }
  
  public int getMaxWidth()
  {
    return this.mMaxWidth;
  }
  
  public int getMinHeight()
  {
    return this.mMinHeight;
  }
  
  public int getMinWidth()
  {
    return this.mMinWidth;
  }
  
  public int getOptimizationLevel()
  {
    return this.mLayoutWidget.getOptimizationLevel();
  }
  
  public View getViewById(int paramInt)
  {
    return (View)this.mChildrenByIds.get(paramInt);
  }
  
  public final ConstraintWidget getViewWidget(View paramView)
  {
    if (paramView == this) {
      return this.mLayoutWidget;
    }
    if (paramView == null) {
      return null;
    }
    return ((ConstraintLayout.LayoutParams)paramView.getLayoutParams()).widget;
  }
  
  protected boolean isRtl()
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i >= 17)
    {
      if ((getContext().getApplicationInfo().flags & 0x400000) != 0) {
        i = 1;
      } else {
        i = 0;
      }
      bool1 = bool2;
      if (i != 0)
      {
        bool1 = bool2;
        if (1 == getLayoutDirection()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void loadLayoutDescription(int paramInt)
  {
    if (paramInt != 0) {}
    try
    {
      this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, paramInt);
      return;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label22:
      break label22;
    }
    this.mConstraintLayoutSpec = null;
    return;
    this.mConstraintLayoutSpec = null;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = getChildCount();
    paramBoolean = isInEditMode();
    paramInt2 = 0;
    paramInt1 = 0;
    while (paramInt1 < paramInt3)
    {
      View localView = getChildAt(paramInt1);
      ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)localView.getLayoutParams();
      ConstraintWidget localConstraintWidget = localLayoutParams.widget;
      if (((localView.getVisibility() != 8) || (localLayoutParams.isGuideline) || (localLayoutParams.isHelper) || (localLayoutParams.isVirtualGroup) || (paramBoolean)) && (!localLayoutParams.isInPlaceholder))
      {
        paramInt4 = localConstraintWidget.getX();
        int i = localConstraintWidget.getY();
        int j = localConstraintWidget.getWidth() + paramInt4;
        int k = localConstraintWidget.getHeight() + i;
        localView.layout(paramInt4, i, j, k);
        if ((localView instanceof Placeholder))
        {
          localView = ((Placeholder)localView).getContent();
          if (localView != null)
          {
            localView.setVisibility(0);
            localView.layout(paramInt4, i, j, k);
          }
        }
      }
      paramInt1 += 1;
    }
    paramInt3 = this.mConstraintHelpers.size();
    if (paramInt3 > 0)
    {
      paramInt1 = paramInt2;
      while (paramInt1 < paramInt3)
      {
        ((ConstraintHelper)this.mConstraintHelpers.get(paramInt1)).updatePostLayout(this);
        paramInt1 += 1;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (!this.mDirtyHierarchy)
    {
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        if (getChildAt(i).isLayoutRequested())
        {
          this.mDirtyHierarchy = true;
          break;
        }
        i += 1;
      }
    }
    if (!this.mDirtyHierarchy)
    {
      if ((this.mOnMeasureWidthMeasureSpec == paramInt1) && (this.mOnMeasureHeightMeasureSpec == paramInt2))
      {
        resolveMeasuredDimension(paramInt1, paramInt2, this.mLayoutWidget.getWidth(), this.mLayoutWidget.getHeight(), this.mLayoutWidget.isWidthMeasuredTooSmall(), this.mLayoutWidget.isHeightMeasuredTooSmall());
        return;
      }
      if ((this.mOnMeasureWidthMeasureSpec == paramInt1) && (View.MeasureSpec.getMode(paramInt1) == 1073741824) && (View.MeasureSpec.getMode(paramInt2) == -2147483648) && (View.MeasureSpec.getMode(this.mOnMeasureHeightMeasureSpec) == -2147483648) && (View.MeasureSpec.getSize(paramInt2) >= this.mLayoutWidget.getHeight()))
      {
        this.mOnMeasureWidthMeasureSpec = paramInt1;
        this.mOnMeasureHeightMeasureSpec = paramInt2;
        resolveMeasuredDimension(paramInt1, paramInt2, this.mLayoutWidget.getWidth(), this.mLayoutWidget.getHeight(), this.mLayoutWidget.isWidthMeasuredTooSmall(), this.mLayoutWidget.isHeightMeasuredTooSmall());
        return;
      }
    }
    this.mOnMeasureWidthMeasureSpec = paramInt1;
    this.mOnMeasureHeightMeasureSpec = paramInt2;
    this.mLayoutWidget.setRtl(isRtl());
    if (this.mDirtyHierarchy)
    {
      this.mDirtyHierarchy = false;
      if (updateHierarchy()) {
        this.mLayoutWidget.updateHierarchy();
      }
    }
    resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, paramInt1, paramInt2);
    resolveMeasuredDimension(paramInt1, paramInt2, this.mLayoutWidget.getWidth(), this.mLayoutWidget.getHeight(), this.mLayoutWidget.isWidthMeasuredTooSmall(), this.mLayoutWidget.isHeightMeasuredTooSmall());
  }
  
  public void onViewAdded(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      super.onViewAdded(paramView);
    }
    Object localObject = getViewWidget(paramView);
    if (((paramView instanceof Guideline)) && (!(localObject instanceof androidx.constraintlayout.solver.widgets.Guideline)))
    {
      localObject = (ConstraintLayout.LayoutParams)paramView.getLayoutParams();
      ((ConstraintLayout.LayoutParams)localObject).widget = new androidx.constraintlayout.solver.widgets.Guideline();
      ((ConstraintLayout.LayoutParams)localObject).isGuideline = true;
      ((androidx.constraintlayout.solver.widgets.Guideline)((ConstraintLayout.LayoutParams)localObject).widget).setOrientation(((ConstraintLayout.LayoutParams)localObject).orientation);
    }
    if ((paramView instanceof ConstraintHelper))
    {
      localObject = (ConstraintHelper)paramView;
      ((ConstraintHelper)localObject).validateParams();
      ((ConstraintLayout.LayoutParams)paramView.getLayoutParams()).isHelper = true;
      if (!this.mConstraintHelpers.contains(localObject)) {
        this.mConstraintHelpers.add(localObject);
      }
    }
    this.mChildrenByIds.put(paramView.getId(), paramView);
    this.mDirtyHierarchy = true;
  }
  
  public void onViewRemoved(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      super.onViewRemoved(paramView);
    }
    this.mChildrenByIds.remove(paramView.getId());
    ConstraintWidget localConstraintWidget = getViewWidget(paramView);
    this.mLayoutWidget.remove(localConstraintWidget);
    this.mConstraintHelpers.remove(paramView);
    this.mDirtyHierarchy = true;
  }
  
  protected void parseLayoutDescription(int paramInt)
  {
    this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, paramInt);
  }
  
  public void removeView(View paramView)
  {
    super.removeView(paramView);
    if (Build.VERSION.SDK_INT < 14) {
      onViewRemoved(paramView);
    }
  }
  
  public void requestLayout()
  {
    markHierarchyDirty();
    super.requestLayout();
  }
  
  protected void resolveMeasuredDimension(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = this.mMeasurer.paddingHeight;
    paramInt3 += this.mMeasurer.paddingWidth;
    paramInt4 += i;
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramInt1 = resolveSizeAndState(paramInt3, paramInt1, 0);
      paramInt3 = resolveSizeAndState(paramInt4, paramInt2, 0);
      paramInt2 = Math.min(this.mMaxWidth, paramInt1 & 0xFFFFFF);
      paramInt3 = Math.min(this.mMaxHeight, paramInt3 & 0xFFFFFF);
      paramInt1 = paramInt2;
      if (paramBoolean1) {
        paramInt1 = paramInt2 | 0x1000000;
      }
      paramInt2 = paramInt3;
      if (paramBoolean2) {
        paramInt2 = paramInt3 | 0x1000000;
      }
      setMeasuredDimension(paramInt1, paramInt2);
      this.mLastMeasureWidth = paramInt1;
      this.mLastMeasureHeight = paramInt2;
      return;
    }
    setMeasuredDimension(paramInt3, paramInt4);
    this.mLastMeasureWidth = paramInt3;
    this.mLastMeasureHeight = paramInt4;
  }
  
  protected void resolveSystem(ConstraintWidgetContainer paramConstraintWidgetContainer, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = View.MeasureSpec.getMode(paramInt2);
    int i1 = View.MeasureSpec.getSize(paramInt2);
    int j = View.MeasureSpec.getMode(paramInt3);
    int m = View.MeasureSpec.getSize(paramInt3);
    int k = Math.max(0, getPaddingTop());
    int i3 = Math.max(0, getPaddingBottom());
    int n = k + i3;
    int i2 = getPaddingWidth();
    this.mMeasurer.captureLayoutInfos(paramInt2, paramInt3, k, i3, i2, n);
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramInt2 = Math.max(0, getPaddingStart());
      paramInt3 = Math.max(0, getPaddingEnd());
      if ((paramInt2 <= 0) && (paramInt3 <= 0)) {
        paramInt2 = Math.max(0, getPaddingLeft());
      } else if (isRtl()) {
        paramInt2 = paramInt3;
      }
    }
    else
    {
      paramInt2 = Math.max(0, getPaddingLeft());
    }
    paramInt3 = i1 - i2;
    m -= n;
    setSelfDimensionBehaviour(paramConstraintWidgetContainer, i, paramInt3, j, m);
    paramConstraintWidgetContainer.measure(paramInt1, i, paramInt3, j, m, this.mLastMeasureWidth, this.mLastMeasureHeight, paramInt2, k);
  }
  
  public void setConstraintSet(ConstraintSet paramConstraintSet)
  {
    this.mConstraintSet = paramConstraintSet;
  }
  
  public void setDesignInformation(int paramInt, Object paramObject1, Object paramObject2)
  {
    if ((paramInt == 0) && ((paramObject1 instanceof String)) && ((paramObject2 instanceof Integer)))
    {
      if (this.mDesignIds == null) {
        this.mDesignIds = new HashMap();
      }
      String str = (String)paramObject1;
      paramInt = str.indexOf("/");
      paramObject1 = str;
      if (paramInt != -1) {
        paramObject1 = str.substring(paramInt + 1);
      }
      paramInt = ((Integer)paramObject2).intValue();
      this.mDesignIds.put(paramObject1, Integer.valueOf(paramInt));
    }
  }
  
  public void setId(int paramInt)
  {
    this.mChildrenByIds.remove(getId());
    super.setId(paramInt);
    this.mChildrenByIds.put(getId(), this);
  }
  
  public void setMaxHeight(int paramInt)
  {
    if (paramInt == this.mMaxHeight) {
      return;
    }
    this.mMaxHeight = paramInt;
    requestLayout();
  }
  
  public void setMaxWidth(int paramInt)
  {
    if (paramInt == this.mMaxWidth) {
      return;
    }
    this.mMaxWidth = paramInt;
    requestLayout();
  }
  
  public void setMinHeight(int paramInt)
  {
    if (paramInt == this.mMinHeight) {
      return;
    }
    this.mMinHeight = paramInt;
    requestLayout();
  }
  
  public void setMinWidth(int paramInt)
  {
    if (paramInt == this.mMinWidth) {
      return;
    }
    this.mMinWidth = paramInt;
    requestLayout();
  }
  
  public void setOnConstraintsChanged(ConstraintsChangedListener paramConstraintsChangedListener)
  {
    this.mConstraintsChangedListener = paramConstraintsChangedListener;
    ConstraintLayoutStates localConstraintLayoutStates = this.mConstraintLayoutSpec;
    if (localConstraintLayoutStates != null) {
      localConstraintLayoutStates.setOnConstraintsChanged(paramConstraintsChangedListener);
    }
  }
  
  public void setOptimizationLevel(int paramInt)
  {
    this.mOptimizationLevel = paramInt;
    this.mLayoutWidget.setOptimizationLevel(paramInt);
  }
  
  protected void setSelfDimensionBehaviour(ConstraintWidgetContainer paramConstraintWidgetContainer, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = this.mMeasurer.paddingHeight;
    int j = this.mMeasurer.paddingWidth;
    Object localObject1 = ConstraintWidget.DimensionBehaviour.FIXED;
    Object localObject2 = ConstraintWidget.DimensionBehaviour.FIXED;
    int k = getChildCount();
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour;
    if (paramInt1 != -2147483648)
    {
      if (paramInt1 != 0) {
        if (paramInt1 == 1073741824) {}
      }
      do
      {
        paramInt2 = 0;
        break;
        paramInt2 = Math.min(this.mMaxWidth - j, paramInt2);
        break;
        localDimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        localObject1 = localDimensionBehaviour;
      } while (k != 0);
      paramInt2 = Math.max(0, this.mMinWidth);
      localObject1 = localDimensionBehaviour;
    }
    else
    {
      localDimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
      localObject1 = localDimensionBehaviour;
      if (k == 0)
      {
        paramInt2 = Math.max(0, this.mMinWidth);
        localObject1 = localDimensionBehaviour;
      }
    }
    if (paramInt3 != -2147483648)
    {
      if (paramInt3 != 0) {
        if (paramInt3 == 1073741824) {}
      }
      do
      {
        paramInt4 = 0;
        break;
        paramInt4 = Math.min(this.mMaxHeight - i, paramInt4);
        break;
        localDimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        localObject2 = localDimensionBehaviour;
      } while (k != 0);
      paramInt4 = Math.max(0, this.mMinHeight);
      localObject2 = localDimensionBehaviour;
    }
    else
    {
      localDimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
      localObject2 = localDimensionBehaviour;
      if (k == 0)
      {
        paramInt4 = Math.max(0, this.mMinHeight);
        localObject2 = localDimensionBehaviour;
      }
    }
    if ((paramInt2 != paramConstraintWidgetContainer.getWidth()) || (paramInt4 != paramConstraintWidgetContainer.getHeight())) {
      paramConstraintWidgetContainer.invalidateMeasures();
    }
    paramConstraintWidgetContainer.setX(0);
    paramConstraintWidgetContainer.setY(0);
    paramConstraintWidgetContainer.setMaxWidth(this.mMaxWidth - j);
    paramConstraintWidgetContainer.setMaxHeight(this.mMaxHeight - i);
    paramConstraintWidgetContainer.setMinWidth(0);
    paramConstraintWidgetContainer.setMinHeight(0);
    paramConstraintWidgetContainer.setHorizontalDimensionBehaviour((ConstraintWidget.DimensionBehaviour)localObject1);
    paramConstraintWidgetContainer.setWidth(paramInt2);
    paramConstraintWidgetContainer.setVerticalDimensionBehaviour((ConstraintWidget.DimensionBehaviour)localObject2);
    paramConstraintWidgetContainer.setHeight(paramInt4);
    paramConstraintWidgetContainer.setMinWidth(this.mMinWidth - j);
    paramConstraintWidgetContainer.setMinHeight(this.mMinHeight - i);
  }
  
  public void setState(int paramInt1, int paramInt2, int paramInt3)
  {
    ConstraintLayoutStates localConstraintLayoutStates = this.mConstraintLayoutSpec;
    if (localConstraintLayoutStates != null) {
      localConstraintLayoutStates.updateConstraints(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.widget.ConstraintLayout
 * JD-Core Version:    0.7.0.1
 */