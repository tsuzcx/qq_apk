package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measurer;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyGraph;
import androidx.constraintlayout.solver.widgets.analyzer.Direct;
import androidx.constraintlayout.solver.widgets.analyzer.Grouping;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class ConstraintWidgetContainer
  extends WidgetContainer
{
  private static final boolean DEBUG = false;
  static final boolean DEBUG_GRAPH = false;
  private static final boolean DEBUG_LAYOUT = false;
  private static final int MAX_ITERATIONS = 8;
  static int mycounter;
  private WeakReference<ConstraintAnchor> horizontalWrapMax = null;
  private WeakReference<ConstraintAnchor> horizontalWrapMin = null;
  BasicMeasure mBasicMeasureSolver = new BasicMeasure(this);
  int mDebugSolverPassCount = 0;
  public DependencyGraph mDependencyGraph = new DependencyGraph(this);
  public boolean mGroupsWrapOptimized = false;
  private boolean mHeightMeasuredTooSmall = false;
  ChainHead[] mHorizontalChainsArray = new ChainHead[4];
  public int mHorizontalChainsSize = 0;
  public boolean mHorizontalWrapOptimized = false;
  private boolean mIsRtl = false;
  public BasicMeasure.Measure mMeasure = new BasicMeasure.Measure();
  protected BasicMeasure.Measurer mMeasurer = null;
  public Metrics mMetrics;
  private int mOptimizationLevel = 257;
  int mPaddingBottom;
  int mPaddingLeft;
  int mPaddingRight;
  int mPaddingTop;
  public boolean mSkipSolver = false;
  protected LinearSystem mSystem = new LinearSystem();
  ChainHead[] mVerticalChainsArray = new ChainHead[4];
  public int mVerticalChainsSize = 0;
  public boolean mVerticalWrapOptimized = false;
  private boolean mWidthMeasuredTooSmall = false;
  public int mWrapFixedHeight = 0;
  public int mWrapFixedWidth = 0;
  private WeakReference<ConstraintAnchor> verticalWrapMax = null;
  private WeakReference<ConstraintAnchor> verticalWrapMin = null;
  
  public ConstraintWidgetContainer() {}
  
  public ConstraintWidgetContainer(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public ConstraintWidgetContainer(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public ConstraintWidgetContainer(String paramString, int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    setDebugName(paramString);
  }
  
  private void addHorizontalChain(ConstraintWidget paramConstraintWidget)
  {
    int i = this.mHorizontalChainsSize;
    ChainHead[] arrayOfChainHead = this.mHorizontalChainsArray;
    if (i + 1 >= arrayOfChainHead.length) {
      this.mHorizontalChainsArray = ((ChainHead[])Arrays.copyOf(arrayOfChainHead, arrayOfChainHead.length * 2));
    }
    this.mHorizontalChainsArray[this.mHorizontalChainsSize] = new ChainHead(paramConstraintWidget, 0, isRtl());
    this.mHorizontalChainsSize += 1;
  }
  
  private void addMaxWrap(ConstraintAnchor paramConstraintAnchor, SolverVariable paramSolverVariable)
  {
    paramConstraintAnchor = this.mSystem.createObjectVariable(paramConstraintAnchor);
    this.mSystem.addGreaterThan(paramSolverVariable, paramConstraintAnchor, 0, 5);
  }
  
  private void addMinWrap(ConstraintAnchor paramConstraintAnchor, SolverVariable paramSolverVariable)
  {
    paramConstraintAnchor = this.mSystem.createObjectVariable(paramConstraintAnchor);
    this.mSystem.addGreaterThan(paramConstraintAnchor, paramSolverVariable, 0, 5);
  }
  
  private void addVerticalChain(ConstraintWidget paramConstraintWidget)
  {
    int i = this.mVerticalChainsSize;
    ChainHead[] arrayOfChainHead = this.mVerticalChainsArray;
    if (i + 1 >= arrayOfChainHead.length) {
      this.mVerticalChainsArray = ((ChainHead[])Arrays.copyOf(arrayOfChainHead, arrayOfChainHead.length * 2));
    }
    this.mVerticalChainsArray[this.mVerticalChainsSize] = new ChainHead(paramConstraintWidget, 1, isRtl());
    this.mVerticalChainsSize += 1;
  }
  
  public static boolean measure(ConstraintWidget paramConstraintWidget, BasicMeasure.Measurer paramMeasurer, BasicMeasure.Measure paramMeasure, int paramInt)
  {
    if (paramMeasurer == null) {
      return false;
    }
    paramMeasure.horizontalBehavior = paramConstraintWidget.getHorizontalDimensionBehaviour();
    paramMeasure.verticalBehavior = paramConstraintWidget.getVerticalDimensionBehaviour();
    paramMeasure.horizontalDimension = paramConstraintWidget.getWidth();
    paramMeasure.verticalDimension = paramConstraintWidget.getHeight();
    paramMeasure.measuredNeedsSolverPass = false;
    paramMeasure.measureStrategy = paramInt;
    if (paramMeasure.horizontalBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    int i;
    if (paramMeasure.verticalBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
      i = 1;
    } else {
      i = 0;
    }
    int m;
    if ((paramInt != 0) && (paramConstraintWidget.mDimensionRatio > 0.0F)) {
      m = 1;
    } else {
      m = 0;
    }
    int k;
    if ((i != 0) && (paramConstraintWidget.mDimensionRatio > 0.0F)) {
      k = 1;
    } else {
      k = 0;
    }
    int j = paramInt;
    if (paramInt != 0)
    {
      j = paramInt;
      if (paramConstraintWidget.hasDanglingDimension(0))
      {
        j = paramInt;
        if (paramConstraintWidget.mMatchConstraintDefaultWidth == 0)
        {
          j = paramInt;
          if (m == 0)
          {
            paramMeasure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if ((i != 0) && (paramConstraintWidget.mMatchConstraintDefaultHeight == 0)) {
              paramMeasure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            j = 0;
          }
        }
      }
    }
    paramInt = i;
    if (i != 0)
    {
      paramInt = i;
      if (paramConstraintWidget.hasDanglingDimension(1))
      {
        paramInt = i;
        if (paramConstraintWidget.mMatchConstraintDefaultHeight == 0)
        {
          paramInt = i;
          if (k == 0)
          {
            paramMeasure.verticalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if ((j != 0) && (paramConstraintWidget.mMatchConstraintDefaultWidth == 0)) {
              paramMeasure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            paramInt = 0;
          }
        }
      }
    }
    if (paramConstraintWidget.isResolvedHorizontally())
    {
      paramMeasure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
      j = 0;
    }
    if (paramConstraintWidget.isResolvedVertically())
    {
      paramMeasure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
      paramInt = 0;
    }
    if (m != 0) {
      if (paramConstraintWidget.mResolvedMatchConstraintDefault[0] == 4)
      {
        paramMeasure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
      }
      else if (paramInt == 0)
      {
        if (paramMeasure.verticalBehavior == ConstraintWidget.DimensionBehaviour.FIXED)
        {
          paramInt = paramMeasure.verticalDimension;
        }
        else
        {
          paramMeasure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
          paramMeasurer.measure(paramConstraintWidget, paramMeasure);
          paramInt = paramMeasure.measuredHeight;
        }
        paramMeasure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        if ((paramConstraintWidget.mDimensionRatioSide != 0) && (paramConstraintWidget.mDimensionRatioSide != -1)) {
          paramMeasure.horizontalDimension = ((int)(paramConstraintWidget.getDimensionRatio() / paramInt));
        } else {
          paramMeasure.horizontalDimension = ((int)(paramConstraintWidget.getDimensionRatio() * paramInt));
        }
      }
    }
    if (k != 0) {
      if (paramConstraintWidget.mResolvedMatchConstraintDefault[1] == 4)
      {
        paramMeasure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
      }
      else if (j == 0)
      {
        if (paramMeasure.horizontalBehavior == ConstraintWidget.DimensionBehaviour.FIXED)
        {
          paramInt = paramMeasure.horizontalDimension;
        }
        else
        {
          paramMeasure.verticalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
          paramMeasurer.measure(paramConstraintWidget, paramMeasure);
          paramInt = paramMeasure.measuredWidth;
        }
        paramMeasure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        if ((paramConstraintWidget.mDimensionRatioSide != 0) && (paramConstraintWidget.mDimensionRatioSide != -1)) {
          paramMeasure.verticalDimension = ((int)(paramInt * paramConstraintWidget.getDimensionRatio()));
        } else {
          paramMeasure.verticalDimension = ((int)(paramInt / paramConstraintWidget.getDimensionRatio()));
        }
      }
    }
    paramMeasurer.measure(paramConstraintWidget, paramMeasure);
    paramConstraintWidget.setWidth(paramMeasure.measuredWidth);
    paramConstraintWidget.setHeight(paramMeasure.measuredHeight);
    paramConstraintWidget.setHasBaseline(paramMeasure.measuredHasBaseline);
    paramConstraintWidget.setBaselineDistance(paramMeasure.measuredBaseline);
    paramMeasure.measureStrategy = BasicMeasure.Measure.SELF_DIMENSIONS;
    return paramMeasure.measuredNeedsSolverPass;
  }
  
  private void resetChains()
  {
    this.mHorizontalChainsSize = 0;
    this.mVerticalChainsSize = 0;
  }
  
  void addChain(ConstraintWidget paramConstraintWidget, int paramInt)
  {
    if (paramInt == 0)
    {
      addHorizontalChain(paramConstraintWidget);
      return;
    }
    if (paramInt == 1) {
      addVerticalChain(paramConstraintWidget);
    }
  }
  
  public boolean addChildrenToSolver(LinearSystem paramLinearSystem)
  {
    boolean bool = optimizeFor(64);
    addToSolver(paramLinearSystem, bool);
    int k = this.mChildren.size();
    int i = 0;
    int j = 0;
    Object localObject1;
    while (i < k)
    {
      localObject1 = (ConstraintWidget)this.mChildren.get(i);
      ((ConstraintWidget)localObject1).setInBarrier(0, false);
      ((ConstraintWidget)localObject1).setInBarrier(1, false);
      if ((localObject1 instanceof Barrier)) {
        j = 1;
      }
      i += 1;
    }
    if (j != 0)
    {
      i = 0;
      while (i < k)
      {
        localObject1 = (ConstraintWidget)this.mChildren.get(i);
        if ((localObject1 instanceof Barrier)) {
          ((Barrier)localObject1).markWidgets();
        }
        i += 1;
      }
    }
    i = 0;
    while (i < k)
    {
      localObject1 = (ConstraintWidget)this.mChildren.get(i);
      if (((ConstraintWidget)localObject1).addFirst()) {
        ((ConstraintWidget)localObject1).addToSolver(paramLinearSystem, bool);
      }
      i += 1;
    }
    Object localObject2;
    if (LinearSystem.USE_DEPENDENCY_ORDERING)
    {
      localObject1 = new HashSet();
      i = 0;
      while (i < k)
      {
        localObject2 = (ConstraintWidget)this.mChildren.get(i);
        if (!((ConstraintWidget)localObject2).addFirst()) {
          ((HashSet)localObject1).add(localObject2);
        }
        i += 1;
      }
      if (getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
        i = 0;
      } else {
        i = 1;
      }
      addChildrenToSolverByDependency(this, paramLinearSystem, (HashSet)localObject1, i, false);
      localObject1 = ((HashSet)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ConstraintWidget)((Iterator)localObject1).next();
        Optimizer.checkMatchParent(this, paramLinearSystem, (ConstraintWidget)localObject2);
        ((ConstraintWidget)localObject2).addToSolver(paramLinearSystem, bool);
      }
    }
    i = 0;
    while (i < k)
    {
      localObject1 = (ConstraintWidget)this.mChildren.get(i);
      if ((localObject1 instanceof ConstraintWidgetContainer))
      {
        localObject2 = localObject1.mListDimensionBehaviors[0];
        ConstraintWidget.DimensionBehaviour localDimensionBehaviour = localObject1.mListDimensionBehaviors[1];
        if (localObject2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          ((ConstraintWidget)localObject1).setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        }
        if (localDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          ((ConstraintWidget)localObject1).setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        }
        ((ConstraintWidget)localObject1).addToSolver(paramLinearSystem, bool);
        if (localObject2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          ((ConstraintWidget)localObject1).setHorizontalDimensionBehaviour((ConstraintWidget.DimensionBehaviour)localObject2);
        }
        if (localDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          ((ConstraintWidget)localObject1).setVerticalDimensionBehaviour(localDimensionBehaviour);
        }
      }
      else
      {
        Optimizer.checkMatchParent(this, paramLinearSystem, (ConstraintWidget)localObject1);
        if (!((ConstraintWidget)localObject1).addFirst()) {
          ((ConstraintWidget)localObject1).addToSolver(paramLinearSystem, bool);
        }
      }
      i += 1;
    }
    if (this.mHorizontalChainsSize > 0) {
      Chain.applyChainConstraints(this, paramLinearSystem, null, 0);
    }
    if (this.mVerticalChainsSize > 0) {
      Chain.applyChainConstraints(this, paramLinearSystem, null, 1);
    }
    return true;
  }
  
  public void addHorizontalWrapMaxVariable(ConstraintAnchor paramConstraintAnchor)
  {
    WeakReference localWeakReference = this.horizontalWrapMax;
    if ((localWeakReference == null) || (localWeakReference.get() == null) || (paramConstraintAnchor.getFinalValue() > ((ConstraintAnchor)this.horizontalWrapMax.get()).getFinalValue())) {
      this.horizontalWrapMax = new WeakReference(paramConstraintAnchor);
    }
  }
  
  public void addHorizontalWrapMinVariable(ConstraintAnchor paramConstraintAnchor)
  {
    WeakReference localWeakReference = this.horizontalWrapMin;
    if ((localWeakReference == null) || (localWeakReference.get() == null) || (paramConstraintAnchor.getFinalValue() > ((ConstraintAnchor)this.horizontalWrapMin.get()).getFinalValue())) {
      this.horizontalWrapMin = new WeakReference(paramConstraintAnchor);
    }
  }
  
  void addVerticalWrapMaxVariable(ConstraintAnchor paramConstraintAnchor)
  {
    WeakReference localWeakReference = this.verticalWrapMax;
    if ((localWeakReference == null) || (localWeakReference.get() == null) || (paramConstraintAnchor.getFinalValue() > ((ConstraintAnchor)this.verticalWrapMax.get()).getFinalValue())) {
      this.verticalWrapMax = new WeakReference(paramConstraintAnchor);
    }
  }
  
  void addVerticalWrapMinVariable(ConstraintAnchor paramConstraintAnchor)
  {
    WeakReference localWeakReference = this.verticalWrapMin;
    if ((localWeakReference == null) || (localWeakReference.get() == null) || (paramConstraintAnchor.getFinalValue() > ((ConstraintAnchor)this.verticalWrapMin.get()).getFinalValue())) {
      this.verticalWrapMin = new WeakReference(paramConstraintAnchor);
    }
  }
  
  public void defineTerminalWidgets()
  {
    this.mDependencyGraph.defineTerminalWidgets(getHorizontalDimensionBehaviour(), getVerticalDimensionBehaviour());
  }
  
  public boolean directMeasure(boolean paramBoolean)
  {
    return this.mDependencyGraph.directMeasure(paramBoolean);
  }
  
  public boolean directMeasureSetup(boolean paramBoolean)
  {
    return this.mDependencyGraph.directMeasureSetup(paramBoolean);
  }
  
  public boolean directMeasureWithOrientation(boolean paramBoolean, int paramInt)
  {
    return this.mDependencyGraph.directMeasureWithOrientation(paramBoolean, paramInt);
  }
  
  public void fillMetrics(Metrics paramMetrics)
  {
    this.mMetrics = paramMetrics;
    this.mSystem.fillMetrics(paramMetrics);
  }
  
  public ArrayList<Guideline> getHorizontalGuidelines()
  {
    ArrayList localArrayList = new ArrayList();
    int j = this.mChildren.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = (ConstraintWidget)this.mChildren.get(i);
      if ((localObject instanceof Guideline))
      {
        localObject = (Guideline)localObject;
        if (((Guideline)localObject).getOrientation() == 0) {
          localArrayList.add(localObject);
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public BasicMeasure.Measurer getMeasurer()
  {
    return this.mMeasurer;
  }
  
  public int getOptimizationLevel()
  {
    return this.mOptimizationLevel;
  }
  
  public LinearSystem getSystem()
  {
    return this.mSystem;
  }
  
  public String getType()
  {
    return "ConstraintLayout";
  }
  
  public ArrayList<Guideline> getVerticalGuidelines()
  {
    ArrayList localArrayList = new ArrayList();
    int j = this.mChildren.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = (ConstraintWidget)this.mChildren.get(i);
      if ((localObject instanceof Guideline))
      {
        localObject = (Guideline)localObject;
        if (((Guideline)localObject).getOrientation() == 1) {
          localArrayList.add(localObject);
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public boolean handlesInternalConstraints()
  {
    return false;
  }
  
  public void invalidateGraph()
  {
    this.mDependencyGraph.invalidateGraph();
  }
  
  public void invalidateMeasures()
  {
    this.mDependencyGraph.invalidateMeasures();
  }
  
  public boolean isHeightMeasuredTooSmall()
  {
    return this.mHeightMeasuredTooSmall;
  }
  
  public boolean isRtl()
  {
    return this.mIsRtl;
  }
  
  public boolean isWidthMeasuredTooSmall()
  {
    return this.mWidthMeasuredTooSmall;
  }
  
  public void layout()
  {
    this.mX = 0;
    this.mY = 0;
    this.mWidthMeasuredTooSmall = false;
    this.mHeightMeasuredTooSmall = false;
    int i4 = this.mChildren.size();
    int j = Math.max(0, getWidth());
    int k = Math.max(0, getHeight());
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour1 = this.mListDimensionBehaviors[1];
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour2 = this.mListDimensionBehaviors[0];
    Object localObject1 = this.mMetrics;
    if (localObject1 != null) {
      ((Metrics)localObject1).layouts += 1L;
    }
    int i;
    Object localObject2;
    Object localObject3;
    int m;
    if (Optimizer.enabled(this.mOptimizationLevel, 1))
    {
      Direct.solvingPass(this, getMeasurer());
      i = 0;
      while (i < i4)
      {
        localObject1 = (ConstraintWidget)this.mChildren.get(i);
        if ((((ConstraintWidget)localObject1).isMeasureRequested()) && (!(localObject1 instanceof Guideline)) && (!(localObject1 instanceof Barrier)) && (!(localObject1 instanceof VirtualLayout)) && (!((ConstraintWidget)localObject1).isInVirtualLayout()))
        {
          localObject2 = ((ConstraintWidget)localObject1).getDimensionBehaviour(0);
          localObject3 = ((ConstraintWidget)localObject1).getDimensionBehaviour(1);
          if ((localObject2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (((ConstraintWidget)localObject1).mMatchConstraintDefaultWidth != 1) && (localObject3 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (((ConstraintWidget)localObject1).mMatchConstraintDefaultHeight != 1)) {
            m = 1;
          } else {
            m = 0;
          }
          if (m == 0)
          {
            localObject2 = new BasicMeasure.Measure();
            measure((ConstraintWidget)localObject1, this.mMeasurer, (BasicMeasure.Measure)localObject2, BasicMeasure.Measure.SELF_DIMENSIONS);
          }
        }
        i += 1;
      }
    }
    int n;
    if ((i4 > 2) && ((localDimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || (localDimensionBehaviour1 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) && (Optimizer.enabled(this.mOptimizationLevel, 1024)) && (Grouping.simpleSolvingPass(this, getMeasurer())))
    {
      i = j;
      if (localDimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
        if ((j < getWidth()) && (j > 0))
        {
          setWidth(j);
          this.mWidthMeasuredTooSmall = true;
          i = j;
        }
        else
        {
          i = getWidth();
        }
      }
      j = k;
      if (localDimensionBehaviour1 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
        if ((k < getHeight()) && (k > 0))
        {
          setHeight(k);
          this.mHeightMeasuredTooSmall = true;
          j = k;
        }
        else
        {
          j = getHeight();
        }
      }
      m = i;
      i = 1;
      n = j;
    }
    else
    {
      i = 0;
      n = k;
      m = j;
    }
    if ((!optimizeFor(64)) && (!optimizeFor(128))) {
      j = 0;
    } else {
      j = 1;
    }
    localObject1 = this.mSystem;
    ((LinearSystem)localObject1).graphOptimizer = false;
    ((LinearSystem)localObject1).newgraphOptimizer = false;
    if ((this.mOptimizationLevel != 0) && (j != 0)) {
      ((LinearSystem)localObject1).newgraphOptimizer = true;
    }
    localObject1 = this.mChildren;
    int i1;
    if ((getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    resetChains();
    j = 0;
    while (j < i4)
    {
      localObject2 = (ConstraintWidget)this.mChildren.get(j);
      if ((localObject2 instanceof WidgetContainer)) {
        ((WidgetContainer)localObject2).layout();
      }
      j += 1;
    }
    boolean bool4 = optimizeFor(64);
    j = 0;
    boolean bool2 = true;
    while (bool2)
    {
      int i3 = j + 1;
      boolean bool1 = bool2;
      try
      {
        this.mSystem.reset();
        bool1 = bool2;
        resetChains();
        bool1 = bool2;
        createObjectVariables(this.mSystem);
        j = 0;
        while (j < i4)
        {
          bool1 = bool2;
          ((ConstraintWidget)this.mChildren.get(j)).createObjectVariables(this.mSystem);
          j += 1;
        }
        bool1 = bool2;
        bool2 = addChildrenToSolver(this.mSystem);
        bool1 = bool2;
        if (this.verticalWrapMin != null)
        {
          bool1 = bool2;
          if (this.verticalWrapMin.get() != null)
          {
            bool1 = bool2;
            addMinWrap((ConstraintAnchor)this.verticalWrapMin.get(), this.mSystem.createObjectVariable(this.mTop));
            bool1 = bool2;
            this.verticalWrapMin = null;
          }
        }
        bool1 = bool2;
        if (this.verticalWrapMax != null)
        {
          bool1 = bool2;
          if (this.verticalWrapMax.get() != null)
          {
            bool1 = bool2;
            addMaxWrap((ConstraintAnchor)this.verticalWrapMax.get(), this.mSystem.createObjectVariable(this.mBottom));
            bool1 = bool2;
            this.verticalWrapMax = null;
          }
        }
        bool1 = bool2;
        if (this.horizontalWrapMin != null)
        {
          bool1 = bool2;
          if (this.horizontalWrapMin.get() != null)
          {
            bool1 = bool2;
            addMinWrap((ConstraintAnchor)this.horizontalWrapMin.get(), this.mSystem.createObjectVariable(this.mLeft));
            bool1 = bool2;
            this.horizontalWrapMin = null;
          }
        }
        bool1 = bool2;
        if (this.horizontalWrapMax != null)
        {
          bool1 = bool2;
          if (this.horizontalWrapMax.get() != null)
          {
            bool1 = bool2;
            addMaxWrap((ConstraintAnchor)this.horizontalWrapMax.get(), this.mSystem.createObjectVariable(this.mRight));
            bool1 = bool2;
            this.horizontalWrapMax = null;
          }
        }
        bool1 = bool2;
        if (bool2)
        {
          bool1 = bool2;
          this.mSystem.minimize();
          bool1 = bool2;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localObject3 = System.out;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("EXCEPTION : ");
        localStringBuilder.append(localException);
        ((PrintStream)localObject3).println(localStringBuilder.toString());
      }
      if (bool1)
      {
        updateChildrenFromSolver(this.mSystem, Optimizer.flags);
      }
      else
      {
        updateFromSolver(this.mSystem, bool4);
        j = 0;
        while (j < i4)
        {
          ((ConstraintWidget)this.mChildren.get(j)).updateFromSolver(this.mSystem, bool4);
          j += 1;
        }
      }
      if ((i1 != 0) && (i3 < 8) && (Optimizer.flags[2] != 0))
      {
        k = 0;
        int i2 = 0;
        j = 0;
        while (k < i4)
        {
          ConstraintWidget localConstraintWidget = (ConstraintWidget)this.mChildren.get(k);
          i2 = Math.max(i2, localConstraintWidget.mX + localConstraintWidget.getWidth());
          j = Math.max(j, localConstraintWidget.mY + localConstraintWidget.getHeight());
          k += 1;
        }
        k = Math.max(this.mMinWidth, i2);
        j = Math.max(this.mMinHeight, j);
        if ((localDimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (getWidth() < k))
        {
          setWidth(k);
          this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
          bool1 = true;
          i = 1;
        }
        else
        {
          bool1 = false;
        }
        if ((localDimensionBehaviour1 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (getHeight() < j))
        {
          setHeight(j);
          this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
          bool1 = true;
          i = 1;
        }
      }
      else
      {
        bool1 = false;
      }
      j = Math.max(this.mMinWidth, getWidth());
      if (j > getWidth())
      {
        setWidth(j);
        this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
        bool1 = true;
        i = 1;
      }
      j = Math.max(this.mMinHeight, getHeight());
      if (j > getHeight())
      {
        setHeight(j);
        this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.FIXED;
        bool1 = true;
        i = 1;
      }
      boolean bool3 = bool1;
      k = i;
      if (i == 0)
      {
        bool2 = bool1;
        j = i;
        if (this.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)
        {
          bool2 = bool1;
          j = i;
          if (m > 0)
          {
            bool2 = bool1;
            j = i;
            if (getWidth() > m)
            {
              this.mWidthMeasuredTooSmall = true;
              this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
              setWidth(m);
              bool2 = true;
              j = 1;
            }
          }
        }
        bool3 = bool2;
        k = j;
        if (this.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)
        {
          bool3 = bool2;
          k = j;
          if (n > 0)
          {
            bool3 = bool2;
            k = j;
            if (getHeight() > n)
            {
              this.mHeightMeasuredTooSmall = true;
              this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.FIXED;
              setHeight(n);
              bool2 = true;
              i = 1;
              break label1485;
            }
          }
        }
      }
      bool2 = bool3;
      i = k;
      label1485:
      j = i3;
    }
    this.mChildren = ((ArrayList)localObject1);
    if (i != 0)
    {
      this.mListDimensionBehaviors[0] = localDimensionBehaviour2;
      this.mListDimensionBehaviors[1] = localDimensionBehaviour1;
    }
    resetSolverVariables(this.mSystem.getCache());
  }
  
  public long measure(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    this.mPaddingLeft = paramInt8;
    this.mPaddingTop = paramInt9;
    return this.mBasicMeasureSolver.solverMeasure(this, paramInt1, paramInt8, paramInt9, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
  }
  
  public boolean optimizeFor(int paramInt)
  {
    return (this.mOptimizationLevel & paramInt) == paramInt;
  }
  
  public void reset()
  {
    this.mSystem.reset();
    this.mPaddingLeft = 0;
    this.mPaddingRight = 0;
    this.mPaddingTop = 0;
    this.mPaddingBottom = 0;
    this.mSkipSolver = false;
    super.reset();
  }
  
  public void setMeasurer(BasicMeasure.Measurer paramMeasurer)
  {
    this.mMeasurer = paramMeasurer;
    this.mDependencyGraph.setMeasurer(paramMeasurer);
  }
  
  public void setOptimizationLevel(int paramInt)
  {
    this.mOptimizationLevel = paramInt;
    LinearSystem localLinearSystem = this.mSystem;
    LinearSystem.USE_DEPENDENCY_ORDERING = optimizeFor(512);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mPaddingLeft = paramInt1;
    this.mPaddingTop = paramInt2;
    this.mPaddingRight = paramInt3;
    this.mPaddingBottom = paramInt4;
  }
  
  public void setRtl(boolean paramBoolean)
  {
    this.mIsRtl = paramBoolean;
  }
  
  public void updateChildrenFromSolver(LinearSystem paramLinearSystem, boolean[] paramArrayOfBoolean)
  {
    int i = 0;
    paramArrayOfBoolean[2] = false;
    boolean bool = optimizeFor(64);
    updateFromSolver(paramLinearSystem, bool);
    int j = this.mChildren.size();
    while (i < j)
    {
      ((ConstraintWidget)this.mChildren.get(i)).updateFromSolver(paramLinearSystem, bool);
      i += 1;
    }
  }
  
  public void updateFromRuns(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.updateFromRuns(paramBoolean1, paramBoolean2);
    int j = this.mChildren.size();
    int i = 0;
    while (i < j)
    {
      ((ConstraintWidget)this.mChildren.get(i)).updateFromRuns(paramBoolean1, paramBoolean2);
      i += 1;
    }
  }
  
  public void updateHierarchy()
  {
    this.mBasicMeasureSolver.updateHierarchy(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
 * JD-Core Version:    0.7.0.1
 */