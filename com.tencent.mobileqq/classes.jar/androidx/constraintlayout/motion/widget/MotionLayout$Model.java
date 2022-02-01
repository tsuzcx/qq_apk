package androidx.constraintlayout.motion.widget;

import android.os.Build.VERSION;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Flow;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints.LayoutParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class MotionLayout$Model
{
  ConstraintSet mEnd = null;
  int mEndId;
  ConstraintWidgetContainer mLayoutEnd = new ConstraintWidgetContainer();
  ConstraintWidgetContainer mLayoutStart = new ConstraintWidgetContainer();
  ConstraintSet mStart = null;
  int mStartId;
  
  MotionLayout$Model(MotionLayout paramMotionLayout) {}
  
  private void debugLayout(String paramString, ConstraintWidgetContainer paramConstraintWidgetContainer)
  {
    Object localObject1 = (View)paramConstraintWidgetContainer.getCompanionWidget();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(" ");
    ((StringBuilder)localObject2).append(Debug.getName((View)localObject1));
    localObject2 = ((StringBuilder)localObject2).toString();
    paramString = new StringBuilder();
    paramString.append((String)localObject2);
    paramString.append("  ========= ");
    paramString.append(paramConstraintWidgetContainer);
    Log.v("MotionLayout", paramString.toString());
    int j = paramConstraintWidgetContainer.getChildren().size();
    int i = 0;
    while (i < j)
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject2);
      paramString.append("[");
      paramString.append(i);
      paramString.append("] ");
      String str = paramString.toString();
      ConstraintWidget localConstraintWidget = (ConstraintWidget)paramConstraintWidgetContainer.getChildren().get(i);
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      paramString = localConstraintWidget.mTop.mTarget;
      localObject1 = "_";
      if (paramString != null) {
        paramString = "T";
      } else {
        paramString = "_";
      }
      ((StringBuilder)localObject3).append(paramString);
      paramString = ((StringBuilder)localObject3).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramString);
      if (localConstraintWidget.mBottom.mTarget != null) {
        paramString = "B";
      } else {
        paramString = "_";
      }
      ((StringBuilder)localObject3).append(paramString);
      paramString = ((StringBuilder)localObject3).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramString);
      if (localConstraintWidget.mLeft.mTarget != null) {
        paramString = "L";
      } else {
        paramString = "_";
      }
      ((StringBuilder)localObject3).append(paramString);
      paramString = ((StringBuilder)localObject3).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramString);
      paramString = (String)localObject1;
      if (localConstraintWidget.mRight.mTarget != null) {
        paramString = "R";
      }
      ((StringBuilder)localObject3).append(paramString);
      localObject3 = ((StringBuilder)localObject3).toString();
      View localView = (View)localConstraintWidget.getCompanionWidget();
      localObject1 = Debug.getName(localView);
      paramString = (String)localObject1;
      if ((localView instanceof TextView))
      {
        paramString = new StringBuilder();
        paramString.append((String)localObject1);
        paramString.append("(");
        paramString.append(((TextView)localView).getText());
        paramString.append(")");
        paramString = paramString.toString();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append("  ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append(localConstraintWidget);
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append((String)localObject3);
      Log.v("MotionLayout", ((StringBuilder)localObject1).toString());
      i += 1;
    }
    paramString = new StringBuilder();
    paramString.append((String)localObject2);
    paramString.append(" done. ");
    Log.v("MotionLayout", paramString.toString());
  }
  
  private void debugLayoutParam(String paramString, ConstraintLayout.LayoutParams paramLayoutParams)
  {
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(" ");
    if (paramLayoutParams.startToStart != -1) {
      localObject1 = "SS";
    } else {
      localObject1 = "__";
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    Object localObject1 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    int i = paramLayoutParams.startToEnd;
    localObject2 = "|__";
    if (i != -1) {
      localObject1 = "|SE";
    } else {
      localObject1 = "|__";
    }
    localStringBuilder.append((String)localObject1);
    localObject1 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    if (paramLayoutParams.endToStart != -1) {
      localObject1 = "|ES";
    } else {
      localObject1 = "|__";
    }
    localStringBuilder.append((String)localObject1);
    localObject1 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    if (paramLayoutParams.endToEnd != -1) {
      localObject1 = "|EE";
    } else {
      localObject1 = "|__";
    }
    localStringBuilder.append((String)localObject1);
    localObject1 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    if (paramLayoutParams.leftToLeft != -1) {
      localObject1 = "|LL";
    } else {
      localObject1 = "|__";
    }
    localStringBuilder.append((String)localObject1);
    localObject1 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    if (paramLayoutParams.leftToRight != -1) {
      localObject1 = "|LR";
    } else {
      localObject1 = "|__";
    }
    localStringBuilder.append((String)localObject1);
    localObject1 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    if (paramLayoutParams.rightToLeft != -1) {
      localObject1 = "|RL";
    } else {
      localObject1 = "|__";
    }
    localStringBuilder.append((String)localObject1);
    localObject1 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    if (paramLayoutParams.rightToRight != -1) {
      localObject1 = "|RR";
    } else {
      localObject1 = "|__";
    }
    localStringBuilder.append((String)localObject1);
    localObject1 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    if (paramLayoutParams.topToTop != -1) {
      localObject1 = "|TT";
    } else {
      localObject1 = "|__";
    }
    localStringBuilder.append((String)localObject1);
    localObject1 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    if (paramLayoutParams.topToBottom != -1) {
      localObject1 = "|TB";
    } else {
      localObject1 = "|__";
    }
    localStringBuilder.append((String)localObject1);
    localObject1 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    if (paramLayoutParams.bottomToTop != -1) {
      localObject1 = "|BT";
    } else {
      localObject1 = "|__";
    }
    localStringBuilder.append((String)localObject1);
    localObject1 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localObject1 = localObject2;
    if (paramLayoutParams.bottomToBottom != -1) {
      localObject1 = "|BB";
    }
    localStringBuilder.append((String)localObject1);
    paramLayoutParams = localStringBuilder.toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(paramLayoutParams);
    Log.v("MotionLayout", ((StringBuilder)localObject1).toString());
  }
  
  private void debugWidget(String paramString, ConstraintWidget paramConstraintWidget)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(" ");
    Object localObject1 = paramConstraintWidget.mTop.mTarget;
    String str = "B";
    Object localObject2 = "__";
    StringBuilder localStringBuilder2;
    if (localObject1 != null)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("T");
      if (paramConstraintWidget.mTop.mTarget.mType == ConstraintAnchor.Type.TOP) {
        localObject1 = "T";
      } else {
        localObject1 = "B";
      }
      localStringBuilder2.append((String)localObject1);
      localObject1 = localStringBuilder2.toString();
    }
    else
    {
      localObject1 = "__";
    }
    localStringBuilder1.append((String)localObject1);
    localObject1 = localStringBuilder1.toString();
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append((String)localObject1);
    if (paramConstraintWidget.mBottom.mTarget != null)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("B");
      localObject1 = str;
      if (paramConstraintWidget.mBottom.mTarget.mType == ConstraintAnchor.Type.TOP) {
        localObject1 = "T";
      }
      localStringBuilder2.append((String)localObject1);
      localObject1 = localStringBuilder2.toString();
    }
    else
    {
      localObject1 = "__";
    }
    localStringBuilder1.append((String)localObject1);
    localObject1 = localStringBuilder1.toString();
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append((String)localObject1);
    localObject1 = paramConstraintWidget.mLeft.mTarget;
    str = "R";
    if (localObject1 != null)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("L");
      if (paramConstraintWidget.mLeft.mTarget.mType == ConstraintAnchor.Type.LEFT) {
        localObject1 = "L";
      } else {
        localObject1 = "R";
      }
      localStringBuilder2.append((String)localObject1);
      localObject1 = localStringBuilder2.toString();
    }
    else
    {
      localObject1 = "__";
    }
    localStringBuilder1.append((String)localObject1);
    localObject1 = localStringBuilder1.toString();
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append((String)localObject1);
    localObject1 = localObject2;
    if (paramConstraintWidget.mRight.mTarget != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("R");
      localObject1 = str;
      if (paramConstraintWidget.mRight.mTarget.mType == ConstraintAnchor.Type.LEFT) {
        localObject1 = "L";
      }
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    localStringBuilder1.append((String)localObject1);
    localObject1 = localStringBuilder1.toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" ---  ");
    ((StringBuilder)localObject2).append(paramConstraintWidget);
    Log.v("MotionLayout", ((StringBuilder)localObject2).toString());
  }
  
  private void setupConstraintWidget(ConstraintWidgetContainer paramConstraintWidgetContainer, ConstraintSet paramConstraintSet)
  {
    SparseArray localSparseArray = new SparseArray();
    Object localObject1 = new Constraints.LayoutParams(-2, -2);
    localSparseArray.clear();
    localSparseArray.put(0, paramConstraintWidgetContainer);
    localSparseArray.put(this.this$0.getId(), paramConstraintWidgetContainer);
    Object localObject2 = paramConstraintWidgetContainer.getChildren().iterator();
    ConstraintWidget localConstraintWidget;
    while (((Iterator)localObject2).hasNext())
    {
      localConstraintWidget = (ConstraintWidget)((Iterator)localObject2).next();
      localSparseArray.put(((View)localConstraintWidget.getCompanionWidget()).getId(), localConstraintWidget);
    }
    localObject2 = paramConstraintWidgetContainer.getChildren().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localConstraintWidget = (ConstraintWidget)((Iterator)localObject2).next();
      View localView = (View)localConstraintWidget.getCompanionWidget();
      paramConstraintSet.applyToLayoutParams(localView.getId(), (ConstraintLayout.LayoutParams)localObject1);
      localConstraintWidget.setWidth(paramConstraintSet.getWidth(localView.getId()));
      localConstraintWidget.setHeight(paramConstraintSet.getHeight(localView.getId()));
      if ((localView instanceof ConstraintHelper))
      {
        paramConstraintSet.applyToHelper((ConstraintHelper)localView, localConstraintWidget, (ConstraintLayout.LayoutParams)localObject1, localSparseArray);
        if ((localView instanceof androidx.constraintlayout.widget.Barrier)) {
          ((androidx.constraintlayout.widget.Barrier)localView).validateParams();
        }
      }
      if (Build.VERSION.SDK_INT >= 17) {
        ((Constraints.LayoutParams)localObject1).resolveLayoutDirection(this.this$0.getLayoutDirection());
      } else {
        ((Constraints.LayoutParams)localObject1).resolveLayoutDirection(0);
      }
      MotionLayout.access$800(this.this$0, false, localView, localConstraintWidget, (ConstraintLayout.LayoutParams)localObject1, localSparseArray);
      if (paramConstraintSet.getVisibilityMode(localView.getId()) == 1) {
        localConstraintWidget.setVisibility(localView.getVisibility());
      } else {
        localConstraintWidget.setVisibility(paramConstraintSet.getVisibility(localView.getId()));
      }
    }
    paramConstraintSet = paramConstraintWidgetContainer.getChildren().iterator();
    while (paramConstraintSet.hasNext())
    {
      localObject2 = (ConstraintWidget)paramConstraintSet.next();
      if ((localObject2 instanceof VirtualLayout))
      {
        localObject1 = (ConstraintHelper)((ConstraintWidget)localObject2).getCompanionWidget();
        localObject2 = (Helper)localObject2;
        ((ConstraintHelper)localObject1).updatePreLayout(paramConstraintWidgetContainer, (Helper)localObject2, localSparseArray);
        ((VirtualLayout)localObject2).captureWidgets();
      }
    }
  }
  
  public void build()
  {
    int m = this.this$0.getChildCount();
    this.this$0.mFrameArrayList.clear();
    int k = 0;
    int i = 0;
    int j;
    View localView;
    Object localObject1;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      localView = this.this$0.getChildAt(i);
      localObject1 = new MotionController(localView);
      this.this$0.mFrameArrayList.put(localView, localObject1);
      i += 1;
    }
    while (j < m)
    {
      localView = this.this$0.getChildAt(j);
      localObject1 = (MotionController)this.this$0.mFrameArrayList.get(localView);
      if (localObject1 != null)
      {
        Object localObject2;
        if (this.mStart != null)
        {
          localObject2 = getWidget(this.mLayoutStart, localView);
          if (localObject2 != null)
          {
            ((MotionController)localObject1).setStartState((ConstraintWidget)localObject2, this.mStart);
          }
          else if (this.this$0.mDebugPath != 0)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(Debug.getLocation());
            ((StringBuilder)localObject2).append("no widget for  ");
            ((StringBuilder)localObject2).append(Debug.getName(localView));
            ((StringBuilder)localObject2).append(" (");
            ((StringBuilder)localObject2).append(localView.getClass().getName());
            ((StringBuilder)localObject2).append(")");
            Log.e("MotionLayout", ((StringBuilder)localObject2).toString());
          }
        }
        if (this.mEnd != null)
        {
          localObject2 = getWidget(this.mLayoutEnd, localView);
          if (localObject2 != null)
          {
            ((MotionController)localObject1).setEndState((ConstraintWidget)localObject2, this.mEnd);
          }
          else if (this.this$0.mDebugPath != 0)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(Debug.getLocation());
            ((StringBuilder)localObject1).append("no widget for  ");
            ((StringBuilder)localObject1).append(Debug.getName(localView));
            ((StringBuilder)localObject1).append(" (");
            ((StringBuilder)localObject1).append(localView.getClass().getName());
            ((StringBuilder)localObject1).append(")");
            Log.e("MotionLayout", ((StringBuilder)localObject1).toString());
          }
        }
      }
      j += 1;
    }
  }
  
  void copy(ConstraintWidgetContainer paramConstraintWidgetContainer1, ConstraintWidgetContainer paramConstraintWidgetContainer2)
  {
    ArrayList localArrayList = paramConstraintWidgetContainer1.getChildren();
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramConstraintWidgetContainer1, paramConstraintWidgetContainer2);
    paramConstraintWidgetContainer2.getChildren().clear();
    paramConstraintWidgetContainer2.copy(paramConstraintWidgetContainer1, localHashMap);
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)localIterator.next();
      if ((localConstraintWidget instanceof androidx.constraintlayout.solver.widgets.Barrier)) {
        paramConstraintWidgetContainer1 = new androidx.constraintlayout.solver.widgets.Barrier();
      } else if ((localConstraintWidget instanceof Guideline)) {
        paramConstraintWidgetContainer1 = new Guideline();
      } else if ((localConstraintWidget instanceof Flow)) {
        paramConstraintWidgetContainer1 = new Flow();
      } else if ((localConstraintWidget instanceof Helper)) {
        paramConstraintWidgetContainer1 = new HelperWidget();
      } else {
        paramConstraintWidgetContainer1 = new ConstraintWidget();
      }
      paramConstraintWidgetContainer2.add(paramConstraintWidgetContainer1);
      localHashMap.put(localConstraintWidget, paramConstraintWidgetContainer1);
    }
    paramConstraintWidgetContainer1 = localArrayList.iterator();
    while (paramConstraintWidgetContainer1.hasNext())
    {
      paramConstraintWidgetContainer2 = (ConstraintWidget)paramConstraintWidgetContainer1.next();
      ((ConstraintWidget)localHashMap.get(paramConstraintWidgetContainer2)).copy(paramConstraintWidgetContainer2, localHashMap);
    }
  }
  
  ConstraintWidget getWidget(ConstraintWidgetContainer paramConstraintWidgetContainer, View paramView)
  {
    if (paramConstraintWidgetContainer.getCompanionWidget() == paramView) {
      return paramConstraintWidgetContainer;
    }
    paramConstraintWidgetContainer = paramConstraintWidgetContainer.getChildren();
    int j = paramConstraintWidgetContainer.size();
    int i = 0;
    while (i < j)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)paramConstraintWidgetContainer.get(i);
      if (localConstraintWidget.getCompanionWidget() == paramView) {
        return localConstraintWidget;
      }
      i += 1;
    }
    return null;
  }
  
  void initFrom(ConstraintWidgetContainer paramConstraintWidgetContainer, ConstraintSet paramConstraintSet1, ConstraintSet paramConstraintSet2)
  {
    this.mStart = paramConstraintSet1;
    this.mEnd = paramConstraintSet2;
    this.mLayoutStart = new ConstraintWidgetContainer();
    this.mLayoutEnd = new ConstraintWidgetContainer();
    this.mLayoutStart.setMeasurer(MotionLayout.access$200(this.this$0).getMeasurer());
    this.mLayoutEnd.setMeasurer(MotionLayout.access$300(this.this$0).getMeasurer());
    this.mLayoutStart.removeAllChildren();
    this.mLayoutEnd.removeAllChildren();
    copy(MotionLayout.access$400(this.this$0), this.mLayoutStart);
    copy(MotionLayout.access$500(this.this$0), this.mLayoutEnd);
    if (this.this$0.mTransitionLastPosition > 0.5D)
    {
      if (paramConstraintSet1 != null) {
        setupConstraintWidget(this.mLayoutStart, paramConstraintSet1);
      }
      setupConstraintWidget(this.mLayoutEnd, paramConstraintSet2);
    }
    else
    {
      setupConstraintWidget(this.mLayoutEnd, paramConstraintSet2);
      if (paramConstraintSet1 != null) {
        setupConstraintWidget(this.mLayoutStart, paramConstraintSet1);
      }
    }
    this.mLayoutStart.setRtl(MotionLayout.access$600(this.this$0));
    this.mLayoutStart.updateHierarchy();
    this.mLayoutEnd.setRtl(MotionLayout.access$700(this.this$0));
    this.mLayoutEnd.updateHierarchy();
    paramConstraintWidgetContainer = this.this$0.getLayoutParams();
    if (paramConstraintWidgetContainer != null)
    {
      if (paramConstraintWidgetContainer.width == -2)
      {
        this.mLayoutStart.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
        this.mLayoutEnd.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
      }
      if (paramConstraintWidgetContainer.height == -2)
      {
        this.mLayoutStart.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
        this.mLayoutEnd.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
      }
    }
  }
  
  public boolean isNotConfiguredWith(int paramInt1, int paramInt2)
  {
    return (paramInt1 != this.mStartId) || (paramInt2 != this.mEndId);
  }
  
  public void measure(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    MotionLayout localMotionLayout = this.this$0;
    localMotionLayout.mWidthMeasureMode = j;
    localMotionLayout.mHeightMeasureMode = k;
    int m = localMotionLayout.getOptimizationLevel();
    if (this.this$0.mCurrentState == this.this$0.getStartState())
    {
      MotionLayout.access$1200(this.this$0, this.mLayoutEnd, m, paramInt1, paramInt2);
      if (this.mStart != null) {
        MotionLayout.access$1300(this.this$0, this.mLayoutStart, m, paramInt1, paramInt2);
      }
    }
    else
    {
      if (this.mStart != null) {
        MotionLayout.access$1400(this.this$0, this.mLayoutStart, m, paramInt1, paramInt2);
      }
      MotionLayout.access$1500(this.this$0, this.mLayoutEnd, m, paramInt1, paramInt2);
    }
    if (((this.this$0.getParent() instanceof MotionLayout)) && (j == 1073741824) && (k == 1073741824)) {
      i = 0;
    } else {
      i = 1;
    }
    boolean bool1;
    if (i != 0)
    {
      localMotionLayout = this.this$0;
      localMotionLayout.mWidthMeasureMode = j;
      localMotionLayout.mHeightMeasureMode = k;
      if (localMotionLayout.mCurrentState == this.this$0.getStartState())
      {
        MotionLayout.access$1600(this.this$0, this.mLayoutEnd, m, paramInt1, paramInt2);
        if (this.mStart != null) {
          MotionLayout.access$1700(this.this$0, this.mLayoutStart, m, paramInt1, paramInt2);
        }
      }
      else
      {
        if (this.mStart != null) {
          MotionLayout.access$1800(this.this$0, this.mLayoutStart, m, paramInt1, paramInt2);
        }
        MotionLayout.access$1900(this.this$0, this.mLayoutEnd, m, paramInt1, paramInt2);
      }
      this.this$0.mStartWrapWidth = this.mLayoutStart.getWidth();
      this.this$0.mStartWrapHeight = this.mLayoutStart.getHeight();
      this.this$0.mEndWrapWidth = this.mLayoutEnd.getWidth();
      this.this$0.mEndWrapHeight = this.mLayoutEnd.getHeight();
      localMotionLayout = this.this$0;
      if ((localMotionLayout.mStartWrapWidth == this.this$0.mEndWrapWidth) && (this.this$0.mStartWrapHeight == this.this$0.mEndWrapHeight)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      localMotionLayout.mMeasureDuringTransition = bool1;
    }
    int i = this.this$0.mStartWrapWidth;
    j = this.this$0.mStartWrapHeight;
    if ((this.this$0.mWidthMeasureMode == -2147483648) || (this.this$0.mWidthMeasureMode == 0)) {
      i = (int)(this.this$0.mStartWrapWidth + this.this$0.mPostInterpolationPosition * (this.this$0.mEndWrapWidth - this.this$0.mStartWrapWidth));
    }
    if ((this.this$0.mHeightMeasureMode == -2147483648) || (this.this$0.mHeightMeasureMode == 0)) {
      j = (int)(this.this$0.mStartWrapHeight + this.this$0.mPostInterpolationPosition * (this.this$0.mEndWrapHeight - this.this$0.mStartWrapHeight));
    }
    if ((!this.mLayoutStart.isWidthMeasuredTooSmall()) && (!this.mLayoutEnd.isWidthMeasuredTooSmall())) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    boolean bool2;
    if ((!this.mLayoutStart.isHeightMeasuredTooSmall()) && (!this.mLayoutEnd.isHeightMeasuredTooSmall())) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    MotionLayout.access$2000(this.this$0, paramInt1, paramInt2, i, j, bool1, bool2);
  }
  
  public void reEvaluateState()
  {
    measure(MotionLayout.access$900(this.this$0), MotionLayout.access$1000(this.this$0));
    MotionLayout.access$1100(this.this$0);
  }
  
  public void setMeasuredId(int paramInt1, int paramInt2)
  {
    this.mStartId = paramInt1;
    this.mEndId = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.MotionLayout.Model
 * JD-Core Version:    0.7.0.1
 */