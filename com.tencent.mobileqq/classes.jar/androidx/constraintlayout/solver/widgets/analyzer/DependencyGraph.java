package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class DependencyGraph
{
  private static final boolean USE_GROUPS = true;
  private ConstraintWidgetContainer container;
  private ConstraintWidgetContainer mContainer;
  ArrayList<RunGroup> mGroups = new ArrayList();
  private BasicMeasure.Measure mMeasure = new BasicMeasure.Measure();
  private BasicMeasure.Measurer mMeasurer = null;
  private boolean mNeedBuildGraph = true;
  private boolean mNeedRedoMeasures = true;
  private ArrayList<WidgetRun> mRuns = new ArrayList();
  private ArrayList<RunGroup> runGroups = new ArrayList();
  
  public DependencyGraph(ConstraintWidgetContainer paramConstraintWidgetContainer)
  {
    this.container = paramConstraintWidgetContainer;
    this.mContainer = paramConstraintWidgetContainer;
  }
  
  private void applyGroup(DependencyNode paramDependencyNode1, int paramInt1, int paramInt2, DependencyNode paramDependencyNode2, ArrayList<RunGroup> paramArrayList, RunGroup paramRunGroup)
  {
    Object localObject1 = paramDependencyNode1.run;
    if ((((WidgetRun)localObject1).runGroup == null) && (localObject1 != this.container.horizontalRun))
    {
      if (localObject1 == this.container.verticalRun) {
        return;
      }
      paramDependencyNode1 = paramRunGroup;
      if (paramRunGroup == null)
      {
        paramDependencyNode1 = new RunGroup((WidgetRun)localObject1, paramInt2);
        paramArrayList.add(paramDependencyNode1);
      }
      ((WidgetRun)localObject1).runGroup = paramDependencyNode1;
      paramDependencyNode1.add((WidgetRun)localObject1);
      paramRunGroup = ((WidgetRun)localObject1).start.dependencies.iterator();
      Object localObject2;
      while (paramRunGroup.hasNext())
      {
        localObject2 = (Dependency)paramRunGroup.next();
        if ((localObject2 instanceof DependencyNode)) {
          applyGroup((DependencyNode)localObject2, paramInt1, 0, paramDependencyNode2, paramArrayList, paramDependencyNode1);
        }
      }
      paramRunGroup = ((WidgetRun)localObject1).end.dependencies.iterator();
      while (paramRunGroup.hasNext())
      {
        localObject2 = (Dependency)paramRunGroup.next();
        if ((localObject2 instanceof DependencyNode)) {
          applyGroup((DependencyNode)localObject2, paramInt1, 1, paramDependencyNode2, paramArrayList, paramDependencyNode1);
        }
      }
      if ((paramInt1 == 1) && ((localObject1 instanceof VerticalWidgetRun)))
      {
        paramRunGroup = ((VerticalWidgetRun)localObject1).baseline.dependencies.iterator();
        while (paramRunGroup.hasNext())
        {
          localObject2 = (Dependency)paramRunGroup.next();
          if ((localObject2 instanceof DependencyNode)) {
            applyGroup((DependencyNode)localObject2, paramInt1, 2, paramDependencyNode2, paramArrayList, paramDependencyNode1);
          }
        }
      }
      paramRunGroup = ((WidgetRun)localObject1).start.targets.iterator();
      while (paramRunGroup.hasNext())
      {
        localObject2 = (DependencyNode)paramRunGroup.next();
        if (localObject2 == paramDependencyNode2) {
          paramDependencyNode1.dual = true;
        }
        applyGroup((DependencyNode)localObject2, paramInt1, 0, paramDependencyNode2, paramArrayList, paramDependencyNode1);
      }
      paramRunGroup = ((WidgetRun)localObject1).end.targets.iterator();
      while (paramRunGroup.hasNext())
      {
        localObject2 = (DependencyNode)paramRunGroup.next();
        if (localObject2 == paramDependencyNode2) {
          paramDependencyNode1.dual = true;
        }
        applyGroup((DependencyNode)localObject2, paramInt1, 1, paramDependencyNode2, paramArrayList, paramDependencyNode1);
      }
      if ((paramInt1 == 1) && ((localObject1 instanceof VerticalWidgetRun))) {
        paramRunGroup = ((VerticalWidgetRun)localObject1).baseline.targets.iterator();
      }
    }
    for (;;)
    {
      if (paramRunGroup.hasNext()) {
        localObject1 = (DependencyNode)paramRunGroup.next();
      }
      try
      {
        applyGroup((DependencyNode)localObject1, paramInt1, 2, paramDependencyNode2, paramArrayList, paramDependencyNode1);
      }
      catch (Throwable paramDependencyNode1)
      {
        break label491;
      }
    }
    return;
    label491:
    for (;;)
    {
      throw paramDependencyNode1;
    }
  }
  
  private boolean basicMeasureWidgets(ConstraintWidgetContainer paramConstraintWidgetContainer)
  {
    Iterator localIterator = paramConstraintWidgetContainer.mChildren.iterator();
    while (localIterator.hasNext())
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)localIterator.next();
      Object localObject2 = localConstraintWidget.mListDimensionBehaviors[0];
      ConstraintWidget.DimensionBehaviour localDimensionBehaviour = localConstraintWidget.mListDimensionBehaviors[1];
      if (localConstraintWidget.getVisibility() == 8)
      {
        localConstraintWidget.measured = true;
      }
      else
      {
        if ((localConstraintWidget.mMatchConstraintPercentWidth < 1.0F) && (localObject2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)) {
          localConstraintWidget.mMatchConstraintDefaultWidth = 2;
        }
        if ((localConstraintWidget.mMatchConstraintPercentHeight < 1.0F) && (localDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)) {
          localConstraintWidget.mMatchConstraintDefaultHeight = 2;
        }
        if (localConstraintWidget.getDimensionRatio() > 0.0F) {
          if ((localObject2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && ((localDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || (localDimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED)))
          {
            localConstraintWidget.mMatchConstraintDefaultWidth = 3;
          }
          else if ((localDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && ((localObject2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || (localObject2 == ConstraintWidget.DimensionBehaviour.FIXED)))
          {
            localConstraintWidget.mMatchConstraintDefaultHeight = 3;
          }
          else if ((localObject2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (localDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT))
          {
            if (localConstraintWidget.mMatchConstraintDefaultWidth == 0) {
              localConstraintWidget.mMatchConstraintDefaultWidth = 3;
            }
            if (localConstraintWidget.mMatchConstraintDefaultHeight == 0) {
              localConstraintWidget.mMatchConstraintDefaultHeight = 3;
            }
          }
        }
        Object localObject1 = localObject2;
        if (localObject2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
        {
          localObject1 = localObject2;
          if (localConstraintWidget.mMatchConstraintDefaultWidth == 1) {
            if (localConstraintWidget.mLeft.mTarget != null)
            {
              localObject1 = localObject2;
              if (localConstraintWidget.mRight.mTarget != null) {}
            }
            else
            {
              localObject1 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            }
          }
        }
        localObject2 = localObject1;
        if ((localDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (localConstraintWidget.mMatchConstraintDefaultHeight == 1) && ((localConstraintWidget.mTop.mTarget == null) || (localConstraintWidget.mBottom.mTarget == null))) {
          localObject1 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        } else {
          localObject1 = localDimensionBehaviour;
        }
        localConstraintWidget.horizontalRun.dimensionBehavior = ((ConstraintWidget.DimensionBehaviour)localObject2);
        localConstraintWidget.horizontalRun.matchConstraintsType = localConstraintWidget.mMatchConstraintDefaultWidth;
        localConstraintWidget.verticalRun.dimensionBehavior = ((ConstraintWidget.DimensionBehaviour)localObject1);
        localConstraintWidget.verticalRun.matchConstraintsType = localConstraintWidget.mMatchConstraintDefaultHeight;
        int i;
        int j;
        if (((localObject2 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) && (localObject2 != ConstraintWidget.DimensionBehaviour.FIXED) && (localObject2 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) || ((localObject1 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) && (localObject1 != ConstraintWidget.DimensionBehaviour.FIXED) && (localObject1 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)))
        {
          if ((localObject2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && ((localObject1 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || (localObject1 == ConstraintWidget.DimensionBehaviour.FIXED)))
          {
            if (localConstraintWidget.mMatchConstraintDefaultWidth == 3)
            {
              if (localObject1 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                measure(localConstraintWidget, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0);
              }
              i = localConstraintWidget.getHeight();
              j = (int)(i * localConstraintWidget.mDimensionRatio + 0.5F);
              measure(localConstraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, j, ConstraintWidget.DimensionBehaviour.FIXED, i);
              localConstraintWidget.horizontalRun.dimension.resolve(localConstraintWidget.getWidth());
              localConstraintWidget.verticalRun.dimension.resolve(localConstraintWidget.getHeight());
              localConstraintWidget.measured = true;
              continue;
            }
            if (localConstraintWidget.mMatchConstraintDefaultWidth == 1)
            {
              measure(localConstraintWidget, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, (ConstraintWidget.DimensionBehaviour)localObject1, 0);
              localConstraintWidget.horizontalRun.dimension.wrapValue = localConstraintWidget.getWidth();
              continue;
            }
            if (localConstraintWidget.mMatchConstraintDefaultWidth == 2)
            {
              if ((paramConstraintWidgetContainer.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.FIXED) || (paramConstraintWidgetContainer.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT))
              {
                i = (int)(localConstraintWidget.mMatchConstraintPercentWidth * paramConstraintWidgetContainer.getWidth() + 0.5F);
                j = localConstraintWidget.getHeight();
                measure(localConstraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i, (ConstraintWidget.DimensionBehaviour)localObject1, j);
                localConstraintWidget.horizontalRun.dimension.resolve(localConstraintWidget.getWidth());
                localConstraintWidget.verticalRun.dimension.resolve(localConstraintWidget.getHeight());
                localConstraintWidget.measured = true;
              }
            }
            else if ((localConstraintWidget.mListAnchors[0].mTarget == null) || (localConstraintWidget.mListAnchors[1].mTarget == null))
            {
              measure(localConstraintWidget, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, (ConstraintWidget.DimensionBehaviour)localObject1, 0);
              localConstraintWidget.horizontalRun.dimension.resolve(localConstraintWidget.getWidth());
              localConstraintWidget.verticalRun.dimension.resolve(localConstraintWidget.getHeight());
              localConstraintWidget.measured = true;
              continue;
            }
          }
          float f2;
          float f1;
          if ((localObject1 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && ((localObject2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || (localObject2 == ConstraintWidget.DimensionBehaviour.FIXED)))
          {
            if (localConstraintWidget.mMatchConstraintDefaultHeight == 3)
            {
              if (localObject2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                measure(localConstraintWidget, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0);
              }
              i = localConstraintWidget.getWidth();
              f2 = localConstraintWidget.mDimensionRatio;
              f1 = f2;
              if (localConstraintWidget.getDimensionRatioSide() == -1) {
                f1 = 1.0F / f2;
              }
              j = (int)(i * f1 + 0.5F);
              measure(localConstraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i, ConstraintWidget.DimensionBehaviour.FIXED, j);
              localConstraintWidget.horizontalRun.dimension.resolve(localConstraintWidget.getWidth());
              localConstraintWidget.verticalRun.dimension.resolve(localConstraintWidget.getHeight());
              localConstraintWidget.measured = true;
              continue;
            }
            if (localConstraintWidget.mMatchConstraintDefaultHeight == 1)
            {
              measure(localConstraintWidget, (ConstraintWidget.DimensionBehaviour)localObject2, 0, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0);
              localConstraintWidget.verticalRun.dimension.wrapValue = localConstraintWidget.getHeight();
              continue;
            }
            if (localConstraintWidget.mMatchConstraintDefaultHeight == 2)
            {
              if ((paramConstraintWidgetContainer.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.FIXED) || (paramConstraintWidgetContainer.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT))
              {
                f1 = localConstraintWidget.mMatchConstraintPercentHeight;
                i = localConstraintWidget.getWidth();
                j = (int)(f1 * paramConstraintWidgetContainer.getHeight() + 0.5F);
                measure(localConstraintWidget, (ConstraintWidget.DimensionBehaviour)localObject2, i, ConstraintWidget.DimensionBehaviour.FIXED, j);
                localConstraintWidget.horizontalRun.dimension.resolve(localConstraintWidget.getWidth());
                localConstraintWidget.verticalRun.dimension.resolve(localConstraintWidget.getHeight());
                localConstraintWidget.measured = true;
              }
            }
            else if ((localConstraintWidget.mListAnchors[2].mTarget == null) || (localConstraintWidget.mListAnchors[3].mTarget == null))
            {
              measure(localConstraintWidget, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, (ConstraintWidget.DimensionBehaviour)localObject1, 0);
              localConstraintWidget.horizontalRun.dimension.resolve(localConstraintWidget.getWidth());
              localConstraintWidget.verticalRun.dimension.resolve(localConstraintWidget.getHeight());
              localConstraintWidget.measured = true;
              continue;
            }
          }
          if ((localObject2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (localObject1 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)) {
            if ((localConstraintWidget.mMatchConstraintDefaultWidth != 1) && (localConstraintWidget.mMatchConstraintDefaultHeight != 1))
            {
              if ((localConstraintWidget.mMatchConstraintDefaultHeight == 2) && (localConstraintWidget.mMatchConstraintDefaultWidth == 2) && ((paramConstraintWidgetContainer.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.FIXED) || (paramConstraintWidgetContainer.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.FIXED)) && ((paramConstraintWidgetContainer.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.FIXED) || (paramConstraintWidgetContainer.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.FIXED)))
              {
                f1 = localConstraintWidget.mMatchConstraintPercentWidth;
                f2 = localConstraintWidget.mMatchConstraintPercentHeight;
                i = (int)(f1 * paramConstraintWidgetContainer.getWidth() + 0.5F);
                j = (int)(f2 * paramConstraintWidgetContainer.getHeight() + 0.5F);
                measure(localConstraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i, ConstraintWidget.DimensionBehaviour.FIXED, j);
                localConstraintWidget.horizontalRun.dimension.resolve(localConstraintWidget.getWidth());
                localConstraintWidget.verticalRun.dimension.resolve(localConstraintWidget.getHeight());
                localConstraintWidget.measured = true;
              }
            }
            else
            {
              measure(localConstraintWidget, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0);
              localConstraintWidget.horizontalRun.dimension.wrapValue = localConstraintWidget.getWidth();
              localConstraintWidget.verticalRun.dimension.wrapValue = localConstraintWidget.getHeight();
            }
          }
        }
        else
        {
          i = localConstraintWidget.getWidth();
          int k;
          if (localObject2 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT)
          {
            i = paramConstraintWidgetContainer.getWidth();
            j = localConstraintWidget.mLeft.mMargin;
            k = localConstraintWidget.mRight.mMargin;
            localObject2 = ConstraintWidget.DimensionBehaviour.FIXED;
            i = i - j - k;
          }
          j = localConstraintWidget.getHeight();
          if (localObject1 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT)
          {
            j = paramConstraintWidgetContainer.getHeight();
            k = localConstraintWidget.mTop.mMargin;
            int m = localConstraintWidget.mBottom.mMargin;
            localObject1 = ConstraintWidget.DimensionBehaviour.FIXED;
            j = j - k - m;
          }
          measure(localConstraintWidget, (ConstraintWidget.DimensionBehaviour)localObject2, i, (ConstraintWidget.DimensionBehaviour)localObject1, j);
          localConstraintWidget.horizontalRun.dimension.resolve(localConstraintWidget.getWidth());
          localConstraintWidget.verticalRun.dimension.resolve(localConstraintWidget.getHeight());
          localConstraintWidget.measured = true;
        }
      }
    }
    return false;
  }
  
  private int computeWrap(ConstraintWidgetContainer paramConstraintWidgetContainer, int paramInt)
  {
    int j = this.mGroups.size();
    long l = 0L;
    int i = 0;
    while (i < j)
    {
      l = Math.max(l, ((RunGroup)this.mGroups.get(i)).computeWrapSize(paramConstraintWidgetContainer, paramInt));
      i += 1;
    }
    return (int)l;
  }
  
  private void displayGraph()
  {
    Object localObject = this.mRuns.iterator();
    for (String str = "digraph {\n"; ((Iterator)localObject).hasNext(); str = generateDisplayGraph((WidgetRun)((Iterator)localObject).next(), str)) {}
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("\n}\n");
    str = ((StringBuilder)localObject).toString();
    localObject = System.out;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("content:<<\n");
    localStringBuilder.append(str);
    localStringBuilder.append("\n>>");
    ((PrintStream)localObject).println(localStringBuilder.toString());
  }
  
  private void findGroup(WidgetRun paramWidgetRun, int paramInt, ArrayList<RunGroup> paramArrayList)
  {
    Object localObject = paramWidgetRun.start.dependencies.iterator();
    Dependency localDependency;
    while (((Iterator)localObject).hasNext())
    {
      localDependency = (Dependency)((Iterator)localObject).next();
      if ((localDependency instanceof DependencyNode)) {
        applyGroup((DependencyNode)localDependency, paramInt, 0, paramWidgetRun.end, paramArrayList, null);
      } else if ((localDependency instanceof WidgetRun)) {
        applyGroup(((WidgetRun)localDependency).start, paramInt, 0, paramWidgetRun.end, paramArrayList, null);
      }
    }
    localObject = paramWidgetRun.end.dependencies.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localDependency = (Dependency)((Iterator)localObject).next();
      if ((localDependency instanceof DependencyNode)) {
        applyGroup((DependencyNode)localDependency, paramInt, 1, paramWidgetRun.start, paramArrayList, null);
      } else if ((localDependency instanceof WidgetRun)) {
        applyGroup(((WidgetRun)localDependency).end, paramInt, 1, paramWidgetRun.start, paramArrayList, null);
      }
    }
    if (paramInt == 1)
    {
      paramWidgetRun = ((VerticalWidgetRun)paramWidgetRun).baseline.dependencies.iterator();
      while (paramWidgetRun.hasNext())
      {
        localObject = (Dependency)paramWidgetRun.next();
        if ((localObject instanceof DependencyNode)) {
          applyGroup((DependencyNode)localObject, paramInt, 2, null, paramArrayList, null);
        }
      }
    }
  }
  
  private String generateChainDisplayGraph(ChainRun paramChainRun, String paramString)
  {
    int i = paramChainRun.orientation;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("cluster_");
    ((StringBuilder)localObject1).append(paramChainRun.widget.getDebugName());
    localObject1 = ((StringBuilder)localObject1).toString();
    if (i == 0)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("_h");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("_v");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("subgraph ");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" {\n");
    localObject1 = ((StringBuilder)localObject2).toString();
    Iterator localIterator = paramChainRun.widgets.iterator();
    WidgetRun localWidgetRun;
    for (paramChainRun = ""; localIterator.hasNext(); paramChainRun = generateDisplayGraph(localWidgetRun, paramChainRun))
    {
      localWidgetRun = (WidgetRun)localIterator.next();
      localObject2 = localWidgetRun.widget.getDebugName();
      if (i == 0)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append("_HORIZONTAL");
        localObject2 = localStringBuilder.toString();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append("_VERTICAL");
        localObject2 = localStringBuilder.toString();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(";\n");
      localObject1 = localStringBuilder.toString();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("}\n");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(paramChainRun);
    ((StringBuilder)localObject2).append((String)localObject1);
    return ((StringBuilder)localObject2).toString();
  }
  
  private String generateDisplayGraph(WidgetRun paramWidgetRun, String paramString)
  {
    Object localObject2 = paramWidgetRun.start;
    DependencyNode localDependencyNode = paramWidgetRun.end;
    if ((!(paramWidgetRun instanceof HelperReferences)) && (((DependencyNode)localObject2).dependencies.isEmpty()) && ((localDependencyNode.dependencies.isEmpty() & ((DependencyNode)localObject2).targets.isEmpty())) && (localDependencyNode.targets.isEmpty())) {
      return paramString;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(nodeDefinition(paramWidgetRun));
    paramString = ((StringBuilder)localObject1).toString();
    boolean bool2 = isCenteredConnection((DependencyNode)localObject2, localDependencyNode);
    paramString = generateDisplayNode(localDependencyNode, bool2, generateDisplayNode((DependencyNode)localObject2, bool2, paramString));
    boolean bool1 = paramWidgetRun instanceof VerticalWidgetRun;
    localObject1 = paramString;
    if (bool1) {
      localObject1 = generateDisplayNode(((VerticalWidgetRun)paramWidgetRun).baseline, bool2, paramString);
    }
    if (!(paramWidgetRun instanceof HorizontalWidgetRun))
    {
      bool2 = paramWidgetRun instanceof ChainRun;
      if ((!bool2) || (((ChainRun)paramWidgetRun).orientation != 0))
      {
        if (!bool1)
        {
          paramString = (String)localObject1;
          if (!bool2) {
            break label938;
          }
          paramString = (String)localObject1;
          if (((ChainRun)paramWidgetRun).orientation != 1) {
            break label938;
          }
        }
        localDimensionBehaviour = paramWidgetRun.widget.getVerticalDimensionBehaviour();
        if ((localDimensionBehaviour != ConstraintWidget.DimensionBehaviour.FIXED) && (localDimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT))
        {
          paramString = (String)localObject1;
          if (localDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            break label938;
          }
          paramString = (String)localObject1;
          if (paramWidgetRun.widget.getDimensionRatio() <= 0.0F) {
            break label938;
          }
          paramString = paramWidgetRun.widget.getDebugName();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("\n");
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append("_VERTICAL -> ");
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append("_HORIZONTAL;\n");
          ((StringBuilder)localObject2).toString();
          paramString = (String)localObject1;
          break label938;
        }
        if ((!((DependencyNode)localObject2).targets.isEmpty()) && (localDependencyNode.targets.isEmpty()))
        {
          paramString = new StringBuilder();
          paramString.append("\n");
          paramString.append(localDependencyNode.name());
          paramString.append(" -> ");
          paramString.append(((DependencyNode)localObject2).name());
          paramString.append("\n");
          paramString = paramString.toString();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(paramString);
          paramString = ((StringBuilder)localObject2).toString();
          break label938;
        }
        paramString = (String)localObject1;
        if (!((DependencyNode)localObject2).targets.isEmpty()) {
          break label938;
        }
        paramString = (String)localObject1;
        if (localDependencyNode.targets.isEmpty()) {
          break label938;
        }
        paramString = new StringBuilder();
        paramString.append("\n");
        paramString.append(((DependencyNode)localObject2).name());
        paramString.append(" -> ");
        paramString.append(localDependencyNode.name());
        paramString.append("\n");
        paramString = paramString.toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(paramString);
        paramString = ((StringBuilder)localObject2).toString();
        break label938;
      }
    }
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour = paramWidgetRun.widget.getHorizontalDimensionBehaviour();
    if ((localDimensionBehaviour != ConstraintWidget.DimensionBehaviour.FIXED) && (localDimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT))
    {
      paramString = (String)localObject1;
      if (localDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
      {
        paramString = (String)localObject1;
        if (paramWidgetRun.widget.getDimensionRatio() > 0.0F)
        {
          paramString = paramWidgetRun.widget.getDebugName();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("\n");
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append("_HORIZONTAL -> ");
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append("_VERTICAL;\n");
          ((StringBuilder)localObject2).toString();
          paramString = (String)localObject1;
        }
      }
    }
    else if ((!((DependencyNode)localObject2).targets.isEmpty()) && (localDependencyNode.targets.isEmpty()))
    {
      paramString = new StringBuilder();
      paramString.append("\n");
      paramString.append(localDependencyNode.name());
      paramString.append(" -> ");
      paramString.append(((DependencyNode)localObject2).name());
      paramString.append("\n");
      paramString = paramString.toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(paramString);
      paramString = ((StringBuilder)localObject2).toString();
    }
    else
    {
      paramString = (String)localObject1;
      if (((DependencyNode)localObject2).targets.isEmpty())
      {
        paramString = (String)localObject1;
        if (!localDependencyNode.targets.isEmpty())
        {
          paramString = new StringBuilder();
          paramString.append("\n");
          paramString.append(((DependencyNode)localObject2).name());
          paramString.append(" -> ");
          paramString.append(localDependencyNode.name());
          paramString.append("\n");
          paramString = paramString.toString();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(paramString);
          paramString = ((StringBuilder)localObject2).toString();
        }
      }
    }
    label938:
    if ((paramWidgetRun instanceof ChainRun)) {
      return generateChainDisplayGraph((ChainRun)paramWidgetRun, paramString);
    }
    return paramString;
  }
  
  private String generateDisplayNode(DependencyNode paramDependencyNode, boolean paramBoolean, String paramString)
  {
    Iterator localIterator = paramDependencyNode.targets.iterator();
    Object localObject;
    for (String str = paramString; localIterator.hasNext(); str = ((StringBuilder)localObject).toString())
    {
      paramString = (DependencyNode)localIterator.next();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("\n");
      ((StringBuilder)localObject).append(paramDependencyNode.name());
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" -> ");
      localStringBuilder.append(paramString.name());
      localObject = localStringBuilder.toString();
      if ((paramDependencyNode.margin <= 0) && (!paramBoolean))
      {
        paramString = (String)localObject;
        if (!(paramDependencyNode.run instanceof HelperReferences)) {}
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append((String)localObject);
        paramString.append("[");
        localObject = paramString.toString();
        paramString = (String)localObject;
        if (paramDependencyNode.margin > 0)
        {
          paramString = new StringBuilder();
          paramString.append((String)localObject);
          paramString.append("label=\"");
          paramString.append(paramDependencyNode.margin);
          paramString.append("\"");
          localObject = paramString.toString();
          paramString = (String)localObject;
          if (paramBoolean)
          {
            paramString = new StringBuilder();
            paramString.append((String)localObject);
            paramString.append(",");
            paramString = paramString.toString();
          }
        }
        localObject = paramString;
        if (paramBoolean)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(" style=dashed ");
          localObject = ((StringBuilder)localObject).toString();
        }
        paramString = (String)localObject;
        if ((paramDependencyNode.run instanceof HelperReferences))
        {
          paramString = new StringBuilder();
          paramString.append((String)localObject);
          paramString.append(" style=bold,color=gray ");
          paramString = paramString.toString();
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("]");
        paramString = ((StringBuilder)localObject).toString();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("\n");
      paramString = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(paramString);
    }
    return str;
  }
  
  private boolean isCenteredConnection(DependencyNode paramDependencyNode1, DependencyNode paramDependencyNode2)
  {
    Iterator localIterator = paramDependencyNode1.targets.iterator();
    boolean bool2 = false;
    int i = 0;
    while (localIterator.hasNext()) {
      if ((DependencyNode)localIterator.next() != paramDependencyNode2) {
        i += 1;
      }
    }
    paramDependencyNode2 = paramDependencyNode2.targets.iterator();
    int j = 0;
    while (paramDependencyNode2.hasNext()) {
      if ((DependencyNode)paramDependencyNode2.next() != paramDependencyNode1) {
        j += 1;
      }
    }
    boolean bool1 = bool2;
    if (i > 0)
    {
      bool1 = bool2;
      if (j > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void measure(ConstraintWidget paramConstraintWidget, ConstraintWidget.DimensionBehaviour paramDimensionBehaviour1, int paramInt1, ConstraintWidget.DimensionBehaviour paramDimensionBehaviour2, int paramInt2)
  {
    BasicMeasure.Measure localMeasure = this.mMeasure;
    localMeasure.horizontalBehavior = paramDimensionBehaviour1;
    localMeasure.verticalBehavior = paramDimensionBehaviour2;
    localMeasure.horizontalDimension = paramInt1;
    localMeasure.verticalDimension = paramInt2;
    this.mMeasurer.measure(paramConstraintWidget, localMeasure);
    paramConstraintWidget.setWidth(this.mMeasure.measuredWidth);
    paramConstraintWidget.setHeight(this.mMeasure.measuredHeight);
    paramConstraintWidget.setHasBaseline(this.mMeasure.measuredHasBaseline);
    paramConstraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
  }
  
  private String nodeDefinition(WidgetRun paramWidgetRun)
  {
    boolean bool = paramWidgetRun instanceof VerticalWidgetRun;
    int i;
    if (bool) {
      i = 1;
    } else {
      i = 0;
    }
    String str = paramWidgetRun.widget.getDebugName();
    if (i == 0) {
      localObject2 = paramWidgetRun.widget.getHorizontalDimensionBehaviour();
    } else {
      localObject2 = paramWidgetRun.widget.getVerticalDimensionBehaviour();
    }
    RunGroup localRunGroup = paramWidgetRun.runGroup;
    if (i == 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append("_HORIZONTAL");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append("_VERTICAL");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(" [shape=none, label=<");
    Object localObject1 = ((StringBuilder)localObject3).toString();
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append("<TABLE BORDER=\"0\" CELLSPACING=\"0\" CELLPADDING=\"2\">");
    localObject1 = ((StringBuilder)localObject3).toString();
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append("  <TR>");
    localObject1 = ((StringBuilder)localObject3).toString();
    if (i == 0)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append("    <TD ");
      localObject3 = ((StringBuilder)localObject3).toString();
      localObject1 = localObject3;
      if (paramWidgetRun.start.resolved)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject3);
        ((StringBuilder)localObject1).append(" BGCOLOR=\"green\"");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(" PORT=\"LEFT\" BORDER=\"1\">L</TD>");
      localObject1 = ((StringBuilder)localObject3).toString();
    }
    else
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append("    <TD ");
      localObject3 = ((StringBuilder)localObject3).toString();
      localObject1 = localObject3;
      if (paramWidgetRun.start.resolved)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject3);
        ((StringBuilder)localObject1).append(" BGCOLOR=\"green\"");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(" PORT=\"TOP\" BORDER=\"1\">T</TD>");
      localObject1 = ((StringBuilder)localObject3).toString();
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append("    <TD BORDER=\"1\" ");
    localObject3 = ((StringBuilder)localObject3).toString();
    if ((paramWidgetRun.dimension.resolved) && (!paramWidgetRun.widget.measured))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject3);
      ((StringBuilder)localObject1).append(" BGCOLOR=\"green\" ");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else if ((paramWidgetRun.dimension.resolved) && (paramWidgetRun.widget.measured))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject3);
      ((StringBuilder)localObject1).append(" BGCOLOR=\"lightgray\" ");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = localObject3;
      if (!paramWidgetRun.dimension.resolved)
      {
        localObject1 = localObject3;
        if (paramWidgetRun.widget.measured)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject3);
          ((StringBuilder)localObject1).append(" BGCOLOR=\"yellow\" ");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
    }
    localObject3 = localObject1;
    if (localObject2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("style=\"dashed\"");
      localObject3 = ((StringBuilder)localObject2).toString();
    }
    if (localRunGroup != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" [");
      ((StringBuilder)localObject1).append(localRunGroup.groupIndex + 1);
      ((StringBuilder)localObject1).append("/");
      ((StringBuilder)localObject1).append(RunGroup.index);
      ((StringBuilder)localObject1).append("]");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = "";
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject3);
    ((StringBuilder)localObject2).append(">");
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" </TD>");
    localObject1 = ((StringBuilder)localObject2).toString();
    if (i == 0)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("    <TD ");
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = localObject2;
      if (paramWidgetRun.end.resolved)
      {
        paramWidgetRun = new StringBuilder();
        paramWidgetRun.append((String)localObject2);
        paramWidgetRun.append(" BGCOLOR=\"green\"");
        localObject1 = paramWidgetRun.toString();
      }
      paramWidgetRun = new StringBuilder();
      paramWidgetRun.append((String)localObject1);
      paramWidgetRun.append(" PORT=\"RIGHT\" BORDER=\"1\">R</TD>");
      paramWidgetRun = paramWidgetRun.toString();
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("    <TD ");
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = localObject2;
      if (bool)
      {
        localObject1 = localObject2;
        if (((VerticalWidgetRun)paramWidgetRun).baseline.resolved)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append(" BGCOLOR=\"green\"");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(" PORT=\"BASELINE\" BORDER=\"1\">b</TD>");
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("    <TD ");
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = localObject2;
      if (paramWidgetRun.end.resolved)
      {
        paramWidgetRun = new StringBuilder();
        paramWidgetRun.append((String)localObject2);
        paramWidgetRun.append(" BGCOLOR=\"green\"");
        localObject1 = paramWidgetRun.toString();
      }
      paramWidgetRun = new StringBuilder();
      paramWidgetRun.append((String)localObject1);
      paramWidgetRun.append(" PORT=\"BOTTOM\" BORDER=\"1\">B</TD>");
      paramWidgetRun = paramWidgetRun.toString();
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramWidgetRun);
    ((StringBuilder)localObject1).append("  </TR></TABLE>");
    paramWidgetRun = ((StringBuilder)localObject1).toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramWidgetRun);
    ((StringBuilder)localObject1).append(">];\n");
    return ((StringBuilder)localObject1).toString();
  }
  
  public void buildGraph()
  {
    buildGraph(this.mRuns);
    this.mGroups.clear();
    RunGroup.index = 0;
    findGroup(this.container.horizontalRun, 0, this.mGroups);
    findGroup(this.container.verticalRun, 1, this.mGroups);
    this.mNeedBuildGraph = false;
  }
  
  public void buildGraph(ArrayList<WidgetRun> paramArrayList)
  {
    paramArrayList.clear();
    this.mContainer.horizontalRun.clear();
    this.mContainer.verticalRun.clear();
    paramArrayList.add(this.mContainer.horizontalRun);
    paramArrayList.add(this.mContainer.verticalRun);
    Iterator localIterator = this.mContainer.mChildren.iterator();
    Object localObject1 = null;
    while (localIterator.hasNext())
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)localIterator.next();
      if ((localConstraintWidget instanceof Guideline))
      {
        paramArrayList.add(new GuidelineReference(localConstraintWidget));
      }
      else
      {
        Object localObject2;
        if (localConstraintWidget.isInHorizontalChain())
        {
          if (localConstraintWidget.horizontalChainRun == null) {
            localConstraintWidget.horizontalChainRun = new ChainRun(localConstraintWidget, 0);
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new HashSet();
          }
          ((HashSet)localObject2).add(localConstraintWidget.horizontalChainRun);
          localObject1 = localObject2;
        }
        else
        {
          paramArrayList.add(localConstraintWidget.horizontalRun);
        }
        if (localConstraintWidget.isInVerticalChain())
        {
          if (localConstraintWidget.verticalChainRun == null) {
            localConstraintWidget.verticalChainRun = new ChainRun(localConstraintWidget, 1);
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new HashSet();
          }
          ((HashSet)localObject2).add(localConstraintWidget.verticalChainRun);
        }
        else
        {
          paramArrayList.add(localConstraintWidget.verticalRun);
          localObject2 = localObject1;
        }
        localObject1 = localObject2;
        if ((localConstraintWidget instanceof HelperWidget))
        {
          paramArrayList.add(new HelperReferences(localConstraintWidget));
          localObject1 = localObject2;
        }
      }
    }
    if (localObject1 != null) {
      paramArrayList.addAll((Collection)localObject1);
    }
    localObject1 = paramArrayList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((WidgetRun)((Iterator)localObject1).next()).clear();
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      localObject1 = (WidgetRun)paramArrayList.next();
      if (((WidgetRun)localObject1).widget != this.mContainer) {
        ((WidgetRun)localObject1).apply();
      }
    }
  }
  
  public void defineTerminalWidgets(ConstraintWidget.DimensionBehaviour paramDimensionBehaviour1, ConstraintWidget.DimensionBehaviour paramDimensionBehaviour2)
  {
    if (this.mNeedBuildGraph)
    {
      buildGraph();
      Iterator localIterator = this.container.mChildren.iterator();
      int i = 0;
      Object localObject;
      while (localIterator.hasNext())
      {
        localObject = (ConstraintWidget)localIterator.next();
        ((ConstraintWidget)localObject).isTerminalWidget[0] = true;
        ((ConstraintWidget)localObject).isTerminalWidget[1] = true;
        if ((localObject instanceof Barrier)) {
          i = 1;
        }
      }
      if (i == 0)
      {
        localIterator = this.mGroups.iterator();
        while (localIterator.hasNext())
        {
          localObject = (RunGroup)localIterator.next();
          boolean bool1;
          if (paramDimensionBehaviour1 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          boolean bool2;
          if (paramDimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
            bool2 = true;
          } else {
            bool2 = false;
          }
          ((RunGroup)localObject).defineTerminalWidgets(bool1, bool2);
        }
      }
    }
  }
  
  public boolean directMeasure(boolean paramBoolean)
  {
    boolean bool2 = paramBoolean & true;
    boolean bool3 = this.mNeedBuildGraph;
    paramBoolean = false;
    if ((bool3) || (this.mNeedRedoMeasures))
    {
      localObject1 = this.container.mChildren.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ConstraintWidget)((Iterator)localObject1).next();
        ((ConstraintWidget)localObject2).measured = false;
        ((ConstraintWidget)localObject2).horizontalRun.reset();
        ((ConstraintWidget)localObject2).verticalRun.reset();
      }
      localObject1 = this.container;
      ((ConstraintWidgetContainer)localObject1).measured = false;
      ((ConstraintWidgetContainer)localObject1).horizontalRun.reset();
      this.container.verticalRun.reset();
      this.mNeedRedoMeasures = false;
    }
    if (basicMeasureWidgets(this.mContainer)) {
      return false;
    }
    this.container.setX(0);
    this.container.setY(0);
    Object localObject1 = this.container.getDimensionBehaviour(0);
    Object localObject2 = this.container.getDimensionBehaviour(1);
    if (this.mNeedBuildGraph) {
      buildGraph();
    }
    int k = this.container.getX();
    int j = this.container.getY();
    this.container.horizontalRun.start.resolve(k);
    this.container.verticalRun.start.resolve(j);
    measureWidgets();
    boolean bool1;
    if ((localObject1 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || (localObject2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT))
    {
      bool1 = bool2;
      if (bool2)
      {
        localObject3 = this.mRuns.iterator();
        do
        {
          bool1 = bool2;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
        } while (((WidgetRun)((Iterator)localObject3).next()).supportsWrapComputation());
        bool1 = false;
      }
      if ((bool1) && (localObject1 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT))
      {
        this.container.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        localObject3 = this.container;
        ((ConstraintWidgetContainer)localObject3).setWidth(computeWrap((ConstraintWidgetContainer)localObject3, 0));
        this.container.horizontalRun.dimension.resolve(this.container.getWidth());
      }
      if ((bool1) && (localObject2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT))
      {
        this.container.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        localObject3 = this.container;
        ((ConstraintWidgetContainer)localObject3).setHeight(computeWrap((ConstraintWidgetContainer)localObject3, 1));
        this.container.verticalRun.dimension.resolve(this.container.getHeight());
      }
    }
    int i;
    if ((this.container.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.FIXED) && (this.container.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT))
    {
      bool1 = false;
    }
    else
    {
      i = this.container.getWidth() + k;
      this.container.horizontalRun.end.resolve(i);
      this.container.horizontalRun.dimension.resolve(i - k);
      measureWidgets();
      if ((this.container.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.FIXED) || (this.container.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT))
      {
        i = this.container.getHeight() + j;
        this.container.verticalRun.end.resolve(i);
        this.container.verticalRun.dimension.resolve(i - j);
      }
      measureWidgets();
      i = 1;
    }
    Object localObject3 = this.mRuns.iterator();
    WidgetRun localWidgetRun;
    while (((Iterator)localObject3).hasNext())
    {
      localWidgetRun = (WidgetRun)((Iterator)localObject3).next();
      if ((localWidgetRun.widget != this.container) || (localWidgetRun.resolved)) {
        localWidgetRun.applyToWidget();
      }
    }
    localObject3 = this.mRuns.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localWidgetRun = (WidgetRun)((Iterator)localObject3).next();
      if ((i != 0) || (localWidgetRun.widget != this.container))
      {
        if ((!localWidgetRun.start.resolved) || ((!localWidgetRun.end.resolved) && (!(localWidgetRun instanceof GuidelineReference)))) {
          break label753;
        }
        if ((!localWidgetRun.dimension.resolved) && (!(localWidgetRun instanceof ChainRun)) && (!(localWidgetRun instanceof GuidelineReference))) {
          break label753;
        }
      }
    }
    paramBoolean = true;
    label753:
    this.container.setHorizontalDimensionBehaviour((ConstraintWidget.DimensionBehaviour)localObject1);
    this.container.setVerticalDimensionBehaviour((ConstraintWidget.DimensionBehaviour)localObject2);
    return paramBoolean;
  }
  
  public boolean directMeasureSetup(boolean paramBoolean)
  {
    if (this.mNeedBuildGraph)
    {
      Object localObject = this.container.mChildren.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ConstraintWidget localConstraintWidget = (ConstraintWidget)((Iterator)localObject).next();
        localConstraintWidget.measured = false;
        localConstraintWidget.horizontalRun.dimension.resolved = false;
        localConstraintWidget.horizontalRun.resolved = false;
        localConstraintWidget.horizontalRun.reset();
        localConstraintWidget.verticalRun.dimension.resolved = false;
        localConstraintWidget.verticalRun.resolved = false;
        localConstraintWidget.verticalRun.reset();
      }
      localObject = this.container;
      ((ConstraintWidgetContainer)localObject).measured = false;
      ((ConstraintWidgetContainer)localObject).horizontalRun.dimension.resolved = false;
      this.container.horizontalRun.resolved = false;
      this.container.horizontalRun.reset();
      this.container.verticalRun.dimension.resolved = false;
      this.container.verticalRun.resolved = false;
      this.container.verticalRun.reset();
      buildGraph();
    }
    if (basicMeasureWidgets(this.mContainer)) {
      return false;
    }
    this.container.setX(0);
    this.container.setY(0);
    this.container.horizontalRun.start.resolve(0);
    this.container.verticalRun.start.resolve(0);
    return true;
  }
  
  public boolean directMeasureWithOrientation(boolean paramBoolean, int paramInt)
  {
    boolean bool2 = paramBoolean & true;
    Object localObject1 = this.container;
    paramBoolean = false;
    localObject1 = ((ConstraintWidgetContainer)localObject1).getDimensionBehaviour(0);
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour = this.container.getDimensionBehaviour(1);
    int j = this.container.getX();
    int k = this.container.getY();
    WidgetRun localWidgetRun;
    if ((bool2) && ((localObject1 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || (localDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)))
    {
      localObject2 = this.mRuns.iterator();
      do
      {
        bool1 = bool2;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localWidgetRun = (WidgetRun)((Iterator)localObject2).next();
      } while ((localWidgetRun.orientation != paramInt) || (localWidgetRun.supportsWrapComputation()));
      boolean bool1 = false;
      if (paramInt == 0)
      {
        if ((bool1) && (localObject1 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT))
        {
          this.container.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
          localObject2 = this.container;
          ((ConstraintWidgetContainer)localObject2).setWidth(computeWrap((ConstraintWidgetContainer)localObject2, 0));
          this.container.horizontalRun.dimension.resolve(this.container.getWidth());
        }
      }
      else if ((bool1) && (localDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT))
      {
        this.container.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        localObject2 = this.container;
        ((ConstraintWidgetContainer)localObject2).setHeight(computeWrap((ConstraintWidgetContainer)localObject2, 1));
        this.container.verticalRun.dimension.resolve(this.container.getHeight());
      }
    }
    if (paramInt == 0)
    {
      if ((this.container.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.FIXED) || (this.container.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT))
      {
        i = this.container.getWidth() + j;
        this.container.horizontalRun.end.resolve(i);
        this.container.horizontalRun.dimension.resolve(i - j);
        break label409;
      }
    }
    else {
      if ((this.container.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.FIXED) || (this.container.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT)) {
        break label367;
      }
    }
    int i = 0;
    break label411;
    label367:
    i = this.container.getHeight() + k;
    this.container.verticalRun.end.resolve(i);
    this.container.verticalRun.dimension.resolve(i - k);
    label409:
    i = 1;
    label411:
    measureWidgets();
    Object localObject2 = this.mRuns.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localWidgetRun = (WidgetRun)((Iterator)localObject2).next();
      if ((localWidgetRun.orientation == paramInt) && ((localWidgetRun.widget != this.container) || (localWidgetRun.resolved))) {
        localWidgetRun.applyToWidget();
      }
    }
    localObject2 = this.mRuns.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localWidgetRun = (WidgetRun)((Iterator)localObject2).next();
      if ((localWidgetRun.orientation == paramInt) && ((i != 0) || (localWidgetRun.widget != this.container)))
      {
        if ((!localWidgetRun.start.resolved) || (!localWidgetRun.end.resolved)) {
          break label603;
        }
        if ((!(localWidgetRun instanceof ChainRun)) && (!localWidgetRun.dimension.resolved)) {
          break label603;
        }
      }
    }
    paramBoolean = true;
    label603:
    this.container.setHorizontalDimensionBehaviour((ConstraintWidget.DimensionBehaviour)localObject1);
    this.container.setVerticalDimensionBehaviour(localDimensionBehaviour);
    return paramBoolean;
  }
  
  public void invalidateGraph()
  {
    this.mNeedBuildGraph = true;
  }
  
  public void invalidateMeasures()
  {
    this.mNeedRedoMeasures = true;
  }
  
  public void measureWidgets()
  {
    Iterator localIterator = this.container.mChildren.iterator();
    while (localIterator.hasNext())
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)localIterator.next();
      if (!localConstraintWidget.measured)
      {
        Object localObject = localConstraintWidget.mListDimensionBehaviors;
        int k = 0;
        localObject = localObject[0];
        ConstraintWidget.DimensionBehaviour localDimensionBehaviour = localConstraintWidget.mListDimensionBehaviors[1];
        int i = localConstraintWidget.mMatchConstraintDefaultWidth;
        int m = localConstraintWidget.mMatchConstraintDefaultHeight;
        if ((localObject != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && ((localObject != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) || (i != 1))) {
          i = 0;
        } else {
          i = 1;
        }
        int j;
        if (localDimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)
        {
          j = k;
          if (localDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
          {
            j = k;
            if (m != 1) {}
          }
        }
        else
        {
          j = 1;
        }
        boolean bool1 = localConstraintWidget.horizontalRun.dimension.resolved;
        boolean bool2 = localConstraintWidget.verticalRun.dimension.resolved;
        if ((bool1) && (bool2))
        {
          measure(localConstraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, localConstraintWidget.horizontalRun.dimension.value, ConstraintWidget.DimensionBehaviour.FIXED, localConstraintWidget.verticalRun.dimension.value);
          localConstraintWidget.measured = true;
        }
        else if ((bool1) && (j != 0))
        {
          measure(localConstraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, localConstraintWidget.horizontalRun.dimension.value, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, localConstraintWidget.verticalRun.dimension.value);
          if (localDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
          {
            localConstraintWidget.verticalRun.dimension.wrapValue = localConstraintWidget.getHeight();
          }
          else
          {
            localConstraintWidget.verticalRun.dimension.resolve(localConstraintWidget.getHeight());
            localConstraintWidget.measured = true;
          }
        }
        else if ((bool2) && (i != 0))
        {
          measure(localConstraintWidget, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, localConstraintWidget.horizontalRun.dimension.value, ConstraintWidget.DimensionBehaviour.FIXED, localConstraintWidget.verticalRun.dimension.value);
          if (localObject == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
          {
            localConstraintWidget.horizontalRun.dimension.wrapValue = localConstraintWidget.getWidth();
          }
          else
          {
            localConstraintWidget.horizontalRun.dimension.resolve(localConstraintWidget.getWidth());
            localConstraintWidget.measured = true;
          }
        }
        if ((localConstraintWidget.measured) && (localConstraintWidget.verticalRun.baselineDimension != null)) {
          localConstraintWidget.verticalRun.baselineDimension.resolve(localConstraintWidget.getBaselineDistance());
        }
      }
    }
  }
  
  public void setMeasurer(BasicMeasure.Measurer paramMeasurer)
  {
    this.mMeasurer = paramMeasurer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.solver.widgets.analyzer.DependencyGraph
 * JD-Core Version:    0.7.0.1
 */