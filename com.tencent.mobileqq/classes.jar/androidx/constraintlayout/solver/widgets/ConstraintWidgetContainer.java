package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measurer;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyGraph;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

public class ConstraintWidgetContainer
  extends WidgetContainer
{
  private static final boolean DEBUG = false;
  static final boolean DEBUG_GRAPH = false;
  private static final boolean DEBUG_LAYOUT = false;
  private static final int MAX_ITERATIONS = 8;
  BasicMeasure mBasicMeasureSolver = new BasicMeasure(this);
  int mDebugSolverPassCount = 0;
  public DependencyGraph mDependencyGraph = new DependencyGraph(this);
  public boolean mGroupsWrapOptimized = false;
  private boolean mHeightMeasuredTooSmall = false;
  ChainHead[] mHorizontalChainsArray = new ChainHead[4];
  int mHorizontalChainsSize = 0;
  public boolean mHorizontalWrapOptimized = false;
  private boolean mIsRtl = false;
  protected BasicMeasure.Measurer mMeasurer = null;
  public Metrics mMetrics;
  private int mOptimizationLevel = 263;
  int mPaddingBottom;
  int mPaddingLeft;
  int mPaddingRight;
  int mPaddingTop;
  public boolean mSkipSolver = false;
  protected LinearSystem mSystem = new LinearSystem();
  ChainHead[] mVerticalChainsArray = new ChainHead[4];
  int mVerticalChainsSize = 0;
  public boolean mVerticalWrapOptimized = false;
  private boolean mWidthMeasuredTooSmall = false;
  public int mWrapFixedHeight = 0;
  public int mWrapFixedWidth = 0;
  
  public ConstraintWidgetContainer() {}
  
  public ConstraintWidgetContainer(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public ConstraintWidgetContainer(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
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
    addToSolver(paramLinearSystem);
    int k = this.mChildren.size();
    int i = 0;
    int j = 0;
    ConstraintWidget localConstraintWidget;
    while (i < k)
    {
      localConstraintWidget = (ConstraintWidget)this.mChildren.get(i);
      localConstraintWidget.setInBarrier(0, false);
      localConstraintWidget.setInBarrier(1, false);
      if ((localConstraintWidget instanceof Barrier)) {
        j = 1;
      }
      i += 1;
    }
    if (j != 0)
    {
      i = 0;
      while (i < k)
      {
        localConstraintWidget = (ConstraintWidget)this.mChildren.get(i);
        if ((localConstraintWidget instanceof Barrier)) {
          ((Barrier)localConstraintWidget).markWidgets();
        }
        i += 1;
      }
    }
    i = 0;
    while (i < k)
    {
      localConstraintWidget = (ConstraintWidget)this.mChildren.get(i);
      if (localConstraintWidget.addFirst()) {
        localConstraintWidget.addToSolver(paramLinearSystem);
      }
      i += 1;
    }
    i = 0;
    while (i < k)
    {
      localConstraintWidget = (ConstraintWidget)this.mChildren.get(i);
      if ((localConstraintWidget instanceof ConstraintWidgetContainer))
      {
        ConstraintWidget.DimensionBehaviour localDimensionBehaviour1 = localConstraintWidget.mListDimensionBehaviors[0];
        ConstraintWidget.DimensionBehaviour localDimensionBehaviour2 = localConstraintWidget.mListDimensionBehaviors[1];
        if (localDimensionBehaviour1 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          localConstraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        }
        if (localDimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          localConstraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        }
        localConstraintWidget.addToSolver(paramLinearSystem);
        if (localDimensionBehaviour1 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          localConstraintWidget.setHorizontalDimensionBehaviour(localDimensionBehaviour1);
        }
        if (localDimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          localConstraintWidget.setVerticalDimensionBehaviour(localDimensionBehaviour2);
        }
      }
      else
      {
        Optimizer.checkMatchParent(this, paramLinearSystem, localConstraintWidget);
        if (!localConstraintWidget.addFirst()) {
          localConstraintWidget.addToSolver(paramLinearSystem);
        }
      }
      i += 1;
    }
    if (this.mHorizontalChainsSize > 0) {
      Chain.applyChainConstraints(this, paramLinearSystem, 0);
    }
    if (this.mVerticalChainsSize > 0) {
      Chain.applyChainConstraints(this, paramLinearSystem, 1);
    }
    return true;
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
    int i2 = Math.max(0, getWidth());
    int i3 = Math.max(0, getHeight());
    this.mWidthMeasuredTooSmall = false;
    this.mHeightMeasuredTooSmall = false;
    if ((!optimizeFor(64)) && (!optimizeFor(128))) {
      i = 0;
    } else {
      i = 1;
    }
    Object localObject = this.mSystem;
    ((LinearSystem)localObject).graphOptimizer = false;
    ((LinearSystem)localObject).newgraphOptimizer = false;
    if ((this.mOptimizationLevel != 0) && (i != 0)) {
      ((LinearSystem)localObject).newgraphOptimizer = true;
    }
    localObject = this.mListDimensionBehaviors[1];
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour = this.mListDimensionBehaviors[0];
    ArrayList localArrayList = this.mChildren;
    int m;
    if ((getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) {
      m = 0;
    } else {
      m = 1;
    }
    resetChains();
    int i4 = this.mChildren.size();
    int i = 0;
    while (i < i4)
    {
      ConstraintWidget localConstraintWidget1 = (ConstraintWidget)this.mChildren.get(i);
      if ((localConstraintWidget1 instanceof WidgetContainer)) {
        ((WidgetContainer)localConstraintWidget1).layout();
      }
      i += 1;
    }
    int j = 0;
    boolean bool2 = true;
    i = 0;
    while (bool2)
    {
      int i1 = j + 1;
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
        PrintStream localPrintStream = System.out;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("EXCEPTION : ");
        localStringBuilder.append(localException);
        localPrintStream.println(localStringBuilder.toString());
      }
      if (bool1)
      {
        updateChildrenFromSolver(this.mSystem, Optimizer.flags);
      }
      else
      {
        updateFromSolver(this.mSystem);
        j = 0;
        while (j < i4)
        {
          ((ConstraintWidget)this.mChildren.get(j)).updateFromSolver(this.mSystem);
          j += 1;
        }
      }
      if ((m != 0) && (i1 < 8) && (Optimizer.flags[2] != 0))
      {
        k = 0;
        int n = 0;
        j = 0;
        while (k < i4)
        {
          ConstraintWidget localConstraintWidget2 = (ConstraintWidget)this.mChildren.get(k);
          n = Math.max(n, localConstraintWidget2.mX + localConstraintWidget2.getWidth());
          j = Math.max(j, localConstraintWidget2.mY + localConstraintWidget2.getHeight());
          k += 1;
        }
        k = Math.max(this.mMinWidth, n);
        j = Math.max(this.mMinHeight, j);
        if ((localDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (getWidth() < k))
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
        if ((localObject == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (getHeight() < j))
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
      int k = i;
      if (i == 0)
      {
        bool2 = bool1;
        j = i;
        if (this.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)
        {
          bool2 = bool1;
          j = i;
          if (i2 > 0)
          {
            bool2 = bool1;
            j = i;
            if (getWidth() > i2)
            {
              this.mWidthMeasuredTooSmall = true;
              this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
              setWidth(i2);
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
          if (i3 > 0)
          {
            bool3 = bool2;
            k = j;
            if (getHeight() > i3)
            {
              this.mHeightMeasuredTooSmall = true;
              this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.FIXED;
              setHeight(i3);
              bool2 = true;
              i = 1;
              break label878;
            }
          }
        }
      }
      bool2 = bool3;
      i = k;
      label878:
      j = i1;
    }
    this.mChildren = ((ArrayList)localArrayList);
    if (i != 0)
    {
      this.mListDimensionBehaviors[0] = localDimensionBehaviour;
      this.mListDimensionBehaviors[1] = localObject;
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
    LinearSystem.OPTIMIZED_ENGINE = Optimizer.enabled(paramInt, 256);
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
    updateFromSolver(paramLinearSystem);
    int j = this.mChildren.size();
    while (i < j)
    {
      ((ConstraintWidget)this.mChildren.get(i)).updateFromSolver(paramLinearSystem);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
 * JD-Core Version:    0.7.0.1
 */