package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Flow;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Grouping
{
  private static final boolean DEBUG = false;
  private static final boolean DEBUG_GROUPING = false;
  
  public static WidgetGroup findDependents(ConstraintWidget paramConstraintWidget, int paramInt, ArrayList<WidgetGroup> paramArrayList, WidgetGroup paramWidgetGroup)
  {
    int i;
    if (paramInt == 0) {
      i = paramConstraintWidget.horizontalGroup;
    } else {
      i = paramConstraintWidget.verticalGroup;
    }
    int k = 0;
    int j;
    if ((i != -1) && ((paramWidgetGroup == null) || (i != paramWidgetGroup.id)))
    {
      j = 0;
      for (;;)
      {
        localObject = paramWidgetGroup;
        if (j >= paramArrayList.size()) {
          break;
        }
        localObject = (WidgetGroup)paramArrayList.get(j);
        if (((WidgetGroup)localObject).getId() == i)
        {
          if (paramWidgetGroup != null)
          {
            paramWidgetGroup.moveTo(paramInt, (WidgetGroup)localObject);
            paramArrayList.remove(paramWidgetGroup);
          }
          break;
        }
        j += 1;
      }
    }
    Object localObject = paramWidgetGroup;
    if (i != -1) {
      return paramWidgetGroup;
    }
    paramWidgetGroup = (WidgetGroup)localObject;
    if (localObject == null)
    {
      paramWidgetGroup = (WidgetGroup)localObject;
      if ((paramConstraintWidget instanceof HelperWidget))
      {
        j = ((HelperWidget)paramConstraintWidget).findGroupInDependents(paramInt);
        paramWidgetGroup = (WidgetGroup)localObject;
        if (j != -1)
        {
          i = 0;
          for (;;)
          {
            paramWidgetGroup = (WidgetGroup)localObject;
            if (i >= paramArrayList.size()) {
              break;
            }
            paramWidgetGroup = (WidgetGroup)paramArrayList.get(i);
            if (paramWidgetGroup.getId() == j) {
              break;
            }
            i += 1;
          }
        }
      }
      localObject = paramWidgetGroup;
      if (paramWidgetGroup == null) {
        localObject = new WidgetGroup(paramInt);
      }
      paramArrayList.add(localObject);
      paramWidgetGroup = (WidgetGroup)localObject;
    }
    if (paramWidgetGroup.add(paramConstraintWidget))
    {
      if ((paramConstraintWidget instanceof Guideline))
      {
        localObject = (Guideline)paramConstraintWidget;
        ConstraintAnchor localConstraintAnchor = ((Guideline)localObject).getAnchor();
        i = k;
        if (((Guideline)localObject).getOrientation() == 0) {
          i = 1;
        }
        localConstraintAnchor.findDependents(i, paramArrayList, paramWidgetGroup);
      }
      if (paramInt == 0)
      {
        paramConstraintWidget.horizontalGroup = paramWidgetGroup.getId();
        paramConstraintWidget.mLeft.findDependents(paramInt, paramArrayList, paramWidgetGroup);
        paramConstraintWidget.mRight.findDependents(paramInt, paramArrayList, paramWidgetGroup);
      }
      else
      {
        paramConstraintWidget.verticalGroup = paramWidgetGroup.getId();
        paramConstraintWidget.mTop.findDependents(paramInt, paramArrayList, paramWidgetGroup);
        paramConstraintWidget.mBaseline.findDependents(paramInt, paramArrayList, paramWidgetGroup);
        paramConstraintWidget.mBottom.findDependents(paramInt, paramArrayList, paramWidgetGroup);
      }
      paramConstraintWidget.mCenter.findDependents(paramInt, paramArrayList, paramWidgetGroup);
    }
    return paramWidgetGroup;
  }
  
  private static WidgetGroup findGroup(ArrayList<WidgetGroup> paramArrayList, int paramInt)
  {
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      WidgetGroup localWidgetGroup = (WidgetGroup)paramArrayList.get(i);
      if (paramInt == localWidgetGroup.id) {
        return localWidgetGroup;
      }
      i += 1;
    }
    return null;
  }
  
  public static boolean simpleSolvingPass(ConstraintWidgetContainer paramConstraintWidgetContainer, BasicMeasure.Measurer paramMeasurer)
  {
    ArrayList localArrayList = paramConstraintWidgetContainer.getChildren();
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      localObject1 = (ConstraintWidget)localArrayList.get(i);
      if (!validInGroup(paramConstraintWidgetContainer.getHorizontalDimensionBehaviour(), paramConstraintWidgetContainer.getVerticalDimensionBehaviour(), ((ConstraintWidget)localObject1).getHorizontalDimensionBehaviour(), ((ConstraintWidget)localObject1).getVerticalDimensionBehaviour())) {
        return false;
      }
      if ((localObject1 instanceof Flow)) {
        return false;
      }
      i += 1;
    }
    if (paramConstraintWidgetContainer.mMetrics != null)
    {
      localObject1 = paramConstraintWidgetContainer.mMetrics;
      ((Metrics)localObject1).grouping += 1L;
    }
    i = 0;
    Object localObject7 = null;
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject5 = null;
    Object localObject11;
    for (Object localObject4 = null; i < j; localObject4 = localObject11)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)localArrayList.get(i);
      if (!validInGroup(paramConstraintWidgetContainer.getHorizontalDimensionBehaviour(), paramConstraintWidgetContainer.getVerticalDimensionBehaviour(), localConstraintWidget.getHorizontalDimensionBehaviour(), localConstraintWidget.getVerticalDimensionBehaviour())) {
        ConstraintWidgetContainer.measure(localConstraintWidget, paramMeasurer, paramConstraintWidgetContainer.mMeasure, BasicMeasure.Measure.SELF_DIMENSIONS);
      }
      bool = localConstraintWidget instanceof Guideline;
      Object localObject9 = localObject7;
      Object localObject8 = localObject3;
      if (bool)
      {
        localObject10 = (Guideline)localConstraintWidget;
        localObject6 = localObject3;
        if (((Guideline)localObject10).getOrientation() == 0)
        {
          localObject6 = localObject3;
          if (localObject3 == null) {
            localObject6 = new ArrayList();
          }
          ((ArrayList)localObject6).add(localObject10);
        }
        localObject9 = localObject7;
        localObject8 = localObject6;
        if (((Guideline)localObject10).getOrientation() == 1)
        {
          localObject3 = localObject7;
          if (localObject7 == null) {
            localObject3 = new ArrayList();
          }
          ((ArrayList)localObject3).add(localObject10);
          localObject8 = localObject6;
          localObject9 = localObject3;
        }
      }
      localObject3 = localObject1;
      localObject6 = localObject2;
      if ((localConstraintWidget instanceof HelperWidget)) {
        if ((localConstraintWidget instanceof Barrier))
        {
          localObject10 = (Barrier)localConstraintWidget;
          localObject7 = localObject1;
          if (((Barrier)localObject10).getOrientation() == 0)
          {
            localObject7 = localObject1;
            if (localObject1 == null) {
              localObject7 = new ArrayList();
            }
            ((ArrayList)localObject7).add(localObject10);
          }
          localObject3 = localObject7;
          localObject6 = localObject2;
          if (((Barrier)localObject10).getOrientation() == 1)
          {
            localObject6 = localObject2;
            if (localObject2 == null) {
              localObject6 = new ArrayList();
            }
            ((ArrayList)localObject6).add(localObject10);
            localObject3 = localObject7;
          }
        }
        else
        {
          localObject7 = (HelperWidget)localConstraintWidget;
          localObject3 = localObject1;
          if (localObject1 == null) {
            localObject3 = new ArrayList();
          }
          ((ArrayList)localObject3).add(localObject7);
          localObject6 = localObject2;
          if (localObject2 == null) {
            localObject6 = new ArrayList();
          }
          ((ArrayList)localObject6).add(localObject7);
        }
      }
      Object localObject10 = localObject5;
      if (localConstraintWidget.mLeft.mTarget == null)
      {
        localObject10 = localObject5;
        if (localConstraintWidget.mRight.mTarget == null)
        {
          localObject10 = localObject5;
          if (!bool)
          {
            localObject10 = localObject5;
            if (!(localConstraintWidget instanceof Barrier))
            {
              localObject1 = localObject5;
              if (localObject5 == null) {
                localObject1 = new ArrayList();
              }
              ((ArrayList)localObject1).add(localConstraintWidget);
              localObject10 = localObject1;
            }
          }
        }
      }
      localObject11 = localObject4;
      if (localConstraintWidget.mTop.mTarget == null)
      {
        localObject11 = localObject4;
        if (localConstraintWidget.mBottom.mTarget == null)
        {
          localObject11 = localObject4;
          if (localConstraintWidget.mBaseline.mTarget == null)
          {
            localObject11 = localObject4;
            if (!bool)
            {
              localObject11 = localObject4;
              if (!(localConstraintWidget instanceof Barrier))
              {
                localObject1 = localObject4;
                if (localObject4 == null) {
                  localObject1 = new ArrayList();
                }
                ((ArrayList)localObject1).add(localConstraintWidget);
                localObject11 = localObject1;
              }
            }
          }
        }
      }
      i += 1;
      localObject7 = localObject9;
      localObject1 = localObject3;
      localObject3 = localObject8;
      localObject2 = localObject6;
      localObject5 = localObject10;
    }
    Object localObject6 = new ArrayList();
    if (localObject7 != null)
    {
      paramMeasurer = ((ArrayList)localObject7).iterator();
      while (paramMeasurer.hasNext()) {
        findDependents((Guideline)paramMeasurer.next(), 0, (ArrayList)localObject6, null);
      }
    }
    if (localObject1 != null)
    {
      paramMeasurer = ((ArrayList)localObject1).iterator();
      while (paramMeasurer.hasNext())
      {
        localObject1 = (HelperWidget)paramMeasurer.next();
        localObject7 = findDependents((ConstraintWidget)localObject1, 0, (ArrayList)localObject6, null);
        ((HelperWidget)localObject1).addDependents((ArrayList)localObject6, 0, (WidgetGroup)localObject7);
        ((WidgetGroup)localObject7).cleanup((ArrayList)localObject6);
      }
    }
    paramMeasurer = paramConstraintWidgetContainer.getAnchor(ConstraintAnchor.Type.LEFT);
    if (paramMeasurer.getDependents() != null)
    {
      paramMeasurer = paramMeasurer.getDependents().iterator();
      while (paramMeasurer.hasNext()) {
        findDependents(((ConstraintAnchor)paramMeasurer.next()).mOwner, 0, (ArrayList)localObject6, null);
      }
    }
    paramMeasurer = paramConstraintWidgetContainer.getAnchor(ConstraintAnchor.Type.RIGHT);
    if (paramMeasurer.getDependents() != null)
    {
      paramMeasurer = paramMeasurer.getDependents().iterator();
      while (paramMeasurer.hasNext()) {
        findDependents(((ConstraintAnchor)paramMeasurer.next()).mOwner, 0, (ArrayList)localObject6, null);
      }
    }
    paramMeasurer = paramConstraintWidgetContainer.getAnchor(ConstraintAnchor.Type.CENTER);
    if (paramMeasurer.getDependents() != null)
    {
      paramMeasurer = paramMeasurer.getDependents().iterator();
      while (paramMeasurer.hasNext()) {
        findDependents(((ConstraintAnchor)paramMeasurer.next()).mOwner, 0, (ArrayList)localObject6, null);
      }
    }
    if (localObject5 != null)
    {
      paramMeasurer = localObject5.iterator();
      while (paramMeasurer.hasNext()) {
        findDependents((ConstraintWidget)paramMeasurer.next(), 0, (ArrayList)localObject6, null);
      }
    }
    if (localObject3 != null)
    {
      paramMeasurer = ((ArrayList)localObject3).iterator();
      while (paramMeasurer.hasNext()) {
        findDependents((Guideline)paramMeasurer.next(), 1, (ArrayList)localObject6, null);
      }
    }
    if (localObject2 != null)
    {
      paramMeasurer = ((ArrayList)localObject2).iterator();
      while (paramMeasurer.hasNext())
      {
        localObject1 = (HelperWidget)paramMeasurer.next();
        localObject2 = findDependents((ConstraintWidget)localObject1, 1, (ArrayList)localObject6, null);
        ((HelperWidget)localObject1).addDependents((ArrayList)localObject6, 1, (WidgetGroup)localObject2);
        ((WidgetGroup)localObject2).cleanup((ArrayList)localObject6);
      }
    }
    paramMeasurer = paramConstraintWidgetContainer.getAnchor(ConstraintAnchor.Type.TOP);
    if (paramMeasurer.getDependents() != null)
    {
      paramMeasurer = paramMeasurer.getDependents().iterator();
      while (paramMeasurer.hasNext()) {
        findDependents(((ConstraintAnchor)paramMeasurer.next()).mOwner, 1, (ArrayList)localObject6, null);
      }
    }
    paramMeasurer = paramConstraintWidgetContainer.getAnchor(ConstraintAnchor.Type.BASELINE);
    if (paramMeasurer.getDependents() != null)
    {
      paramMeasurer = paramMeasurer.getDependents().iterator();
      while (paramMeasurer.hasNext()) {
        findDependents(((ConstraintAnchor)paramMeasurer.next()).mOwner, 1, (ArrayList)localObject6, null);
      }
    }
    paramMeasurer = paramConstraintWidgetContainer.getAnchor(ConstraintAnchor.Type.BOTTOM);
    if (paramMeasurer.getDependents() != null)
    {
      paramMeasurer = paramMeasurer.getDependents().iterator();
      while (paramMeasurer.hasNext()) {
        findDependents(((ConstraintAnchor)paramMeasurer.next()).mOwner, 1, (ArrayList)localObject6, null);
      }
    }
    paramMeasurer = paramConstraintWidgetContainer.getAnchor(ConstraintAnchor.Type.CENTER);
    if (paramMeasurer.getDependents() != null)
    {
      paramMeasurer = paramMeasurer.getDependents().iterator();
      while (paramMeasurer.hasNext()) {
        findDependents(((ConstraintAnchor)paramMeasurer.next()).mOwner, 1, (ArrayList)localObject6, null);
      }
    }
    if (localObject4 != null)
    {
      paramMeasurer = localObject4.iterator();
      while (paramMeasurer.hasNext()) {
        findDependents((ConstraintWidget)paramMeasurer.next(), 1, (ArrayList)localObject6, null);
      }
    }
    i = 0;
    while (i < j)
    {
      localObject1 = (ConstraintWidget)localArrayList.get(i);
      if (((ConstraintWidget)localObject1).oppositeDimensionsTied())
      {
        paramMeasurer = findGroup((ArrayList)localObject6, ((ConstraintWidget)localObject1).horizontalGroup);
        localObject1 = findGroup((ArrayList)localObject6, ((ConstraintWidget)localObject1).verticalGroup);
        if ((paramMeasurer != null) && (localObject1 != null))
        {
          paramMeasurer.moveTo(0, (WidgetGroup)localObject1);
          ((WidgetGroup)localObject1).setOrientation(2);
          ((ArrayList)localObject6).remove(paramMeasurer);
        }
      }
      i += 1;
    }
    if (((ArrayList)localObject6).size() <= 1) {
      return false;
    }
    if (paramConstraintWidgetContainer.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)
    {
      localObject2 = ((ArrayList)localObject6).iterator();
      paramMeasurer = null;
      i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (WidgetGroup)((Iterator)localObject2).next();
        if (((WidgetGroup)localObject1).getOrientation() != 1)
        {
          ((WidgetGroup)localObject1).setAuthoritative(false);
          j = ((WidgetGroup)localObject1).measureWrap(paramConstraintWidgetContainer.getSystem(), 0);
          if (j > i)
          {
            paramMeasurer = (BasicMeasure.Measurer)localObject1;
            i = j;
          }
        }
      }
      if (paramMeasurer != null)
      {
        paramConstraintWidgetContainer.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        paramConstraintWidgetContainer.setWidth(i);
        paramMeasurer.setAuthoritative(true);
        localObject1 = paramMeasurer;
        break label1566;
      }
    }
    localObject1 = null;
    label1566:
    if (paramConstraintWidgetContainer.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)
    {
      localObject3 = ((ArrayList)localObject6).iterator();
      paramMeasurer = null;
      i = 0;
      while (((Iterator)localObject3).hasNext())
      {
        localObject2 = (WidgetGroup)((Iterator)localObject3).next();
        if (((WidgetGroup)localObject2).getOrientation() != 0)
        {
          ((WidgetGroup)localObject2).setAuthoritative(false);
          j = ((WidgetGroup)localObject2).measureWrap(paramConstraintWidgetContainer.getSystem(), 1);
          if (j > i)
          {
            paramMeasurer = (BasicMeasure.Measurer)localObject2;
            i = j;
          }
        }
      }
      if (paramMeasurer != null)
      {
        paramConstraintWidgetContainer.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        paramConstraintWidgetContainer.setHeight(i);
        paramMeasurer.setAuthoritative(true);
        break label1676;
      }
    }
    paramMeasurer = null;
    label1676:
    boolean bool = false;
    if ((localObject1 != null) || (paramMeasurer != null)) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean validInGroup(ConstraintWidget.DimensionBehaviour paramDimensionBehaviour1, ConstraintWidget.DimensionBehaviour paramDimensionBehaviour2, ConstraintWidget.DimensionBehaviour paramDimensionBehaviour3, ConstraintWidget.DimensionBehaviour paramDimensionBehaviour4)
  {
    int i;
    if ((paramDimensionBehaviour3 != ConstraintWidget.DimensionBehaviour.FIXED) && (paramDimensionBehaviour3 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && ((paramDimensionBehaviour3 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) || (paramDimensionBehaviour1 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT))) {
      i = 0;
    } else {
      i = 1;
    }
    int j;
    if ((paramDimensionBehaviour4 != ConstraintWidget.DimensionBehaviour.FIXED) && (paramDimensionBehaviour4 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && ((paramDimensionBehaviour4 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) || (paramDimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT))) {
      j = 0;
    } else {
      j = 1;
    }
    if (i == 0) {
      return j != 0;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.solver.widgets.analyzer.Grouping
 * JD-Core Version:    0.7.0.1
 */