package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;

public class ChainRun
  extends WidgetRun
{
  private int chainStyle;
  ArrayList<WidgetRun> widgets = new ArrayList();
  
  public ChainRun(ConstraintWidget paramConstraintWidget, int paramInt)
  {
    super(paramConstraintWidget);
    this.orientation = paramInt;
    build();
  }
  
  private void build()
  {
    Object localObject2 = this.widget;
    ConstraintWidget localConstraintWidget;
    for (Object localObject1 = ((ConstraintWidget)localObject2).getPreviousChainMember(this.orientation); localObject1 != null; localObject1 = localConstraintWidget)
    {
      localConstraintWidget = ((ConstraintWidget)localObject1).getPreviousChainMember(this.orientation);
      localObject2 = localObject1;
    }
    this.widget = ((ConstraintWidget)localObject2);
    this.widgets.add(((ConstraintWidget)localObject2).getRun(this.orientation));
    for (localObject1 = ((ConstraintWidget)localObject2).getNextChainMember(this.orientation); localObject1 != null; localObject1 = ((ConstraintWidget)localObject1).getNextChainMember(this.orientation)) {
      this.widgets.add(((ConstraintWidget)localObject1).getRun(this.orientation));
    }
    localObject1 = this.widgets.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (WidgetRun)((Iterator)localObject1).next();
      if (this.orientation == 0) {
        ((WidgetRun)localObject2).widget.horizontalChainRun = this;
      } else if (this.orientation == 1) {
        ((WidgetRun)localObject2).widget.verticalChainRun = this;
      }
    }
    int i;
    if ((this.orientation == 0) && (((ConstraintWidgetContainer)this.widget.getParent()).isRtl())) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && (this.widgets.size() > 1))
    {
      localObject1 = this.widgets;
      this.widget = ((WidgetRun)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 1)).widget;
    }
    if (this.orientation == 0) {
      i = this.widget.getHorizontalChainStyle();
    } else {
      i = this.widget.getVerticalChainStyle();
    }
    this.chainStyle = i;
  }
  
  private ConstraintWidget getFirstVisibleWidget()
  {
    int i = 0;
    while (i < this.widgets.size())
    {
      WidgetRun localWidgetRun = (WidgetRun)this.widgets.get(i);
      if (localWidgetRun.widget.getVisibility() != 8) {
        return localWidgetRun.widget;
      }
      i += 1;
    }
    return null;
  }
  
  private ConstraintWidget getLastVisibleWidget()
  {
    int i = this.widgets.size() - 1;
    while (i >= 0)
    {
      WidgetRun localWidgetRun = (WidgetRun)this.widgets.get(i);
      if (localWidgetRun.widget.getVisibility() != 8) {
        return localWidgetRun.widget;
      }
      i -= 1;
    }
    return null;
  }
  
  void apply()
  {
    Object localObject1 = this.widgets.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((WidgetRun)((Iterator)localObject1).next()).apply();
    }
    int i = this.widgets.size();
    if (i < 1) {
      return;
    }
    Object localObject2 = ((WidgetRun)this.widgets.get(0)).widget;
    localObject1 = ((WidgetRun)this.widgets.get(i - 1)).widget;
    DependencyNode localDependencyNode;
    if (this.orientation == 0)
    {
      localObject2 = ((ConstraintWidget)localObject2).mLeft;
      localObject1 = ((ConstraintWidget)localObject1).mRight;
      localDependencyNode = getTarget((ConstraintAnchor)localObject2, 0);
      i = ((ConstraintAnchor)localObject2).getMargin();
      localObject2 = getFirstVisibleWidget();
      if (localObject2 != null) {
        i = ((ConstraintWidget)localObject2).mLeft.getMargin();
      }
      if (localDependencyNode != null) {
        addTarget(this.start, localDependencyNode, i);
      }
      localObject2 = getTarget((ConstraintAnchor)localObject1, 0);
      i = ((ConstraintAnchor)localObject1).getMargin();
      localObject1 = getLastVisibleWidget();
      if (localObject1 != null) {
        i = ((ConstraintWidget)localObject1).mRight.getMargin();
      }
      if (localObject2 != null) {
        addTarget(this.end, (DependencyNode)localObject2, -i);
      }
    }
    else
    {
      localObject2 = ((ConstraintWidget)localObject2).mTop;
      localObject1 = ((ConstraintWidget)localObject1).mBottom;
      localDependencyNode = getTarget((ConstraintAnchor)localObject2, 1);
      i = ((ConstraintAnchor)localObject2).getMargin();
      localObject2 = getFirstVisibleWidget();
      if (localObject2 != null) {
        i = ((ConstraintWidget)localObject2).mTop.getMargin();
      }
      if (localDependencyNode != null) {
        addTarget(this.start, localDependencyNode, i);
      }
      localObject2 = getTarget((ConstraintAnchor)localObject1, 1);
      i = ((ConstraintAnchor)localObject1).getMargin();
      localObject1 = getLastVisibleWidget();
      if (localObject1 != null) {
        i = ((ConstraintWidget)localObject1).mBottom.getMargin();
      }
      if (localObject2 != null) {
        addTarget(this.end, (DependencyNode)localObject2, -i);
      }
    }
    this.start.updateDelegate = this;
    this.end.updateDelegate = this;
  }
  
  public void applyToWidget()
  {
    int i = 0;
    while (i < this.widgets.size())
    {
      ((WidgetRun)this.widgets.get(i)).applyToWidget();
      i += 1;
    }
  }
  
  void clear()
  {
    this.runGroup = null;
    Iterator localIterator = this.widgets.iterator();
    while (localIterator.hasNext()) {
      ((WidgetRun)localIterator.next()).clear();
    }
  }
  
  public long getWrapDimension()
  {
    int j = this.widgets.size();
    long l = 0L;
    int i = 0;
    while (i < j)
    {
      WidgetRun localWidgetRun = (WidgetRun)this.widgets.get(i);
      l = l + localWidgetRun.start.margin + localWidgetRun.getWrapDimension() + localWidgetRun.end.margin;
      i += 1;
    }
    return l;
  }
  
  void reset()
  {
    this.start.resolved = false;
    this.end.resolved = false;
  }
  
  boolean supportsWrapComputation()
  {
    int j = this.widgets.size();
    int i = 0;
    while (i < j)
    {
      if (!((WidgetRun)this.widgets.get(i)).supportsWrapComputation()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public String toString()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("ChainRun ");
    if (this.orientation == 0) {
      str = "horizontal : ";
    } else {
      str = "vertical : ";
    }
    ((StringBuilder)localObject1).append(str);
    String str = ((StringBuilder)localObject1).toString();
    localObject1 = this.widgets.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (WidgetRun)((Iterator)localObject1).next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("<");
      str = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(localObject2);
      str = localStringBuilder.toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append("> ");
      str = ((StringBuilder)localObject2).toString();
    }
    return str;
  }
  
  public void update(Dependency paramDependency)
  {
    if (this.start.resolved)
    {
      if (!this.end.resolved) {
        return;
      }
      paramDependency = this.widget.getParent();
      boolean bool;
      if ((paramDependency != null) && ((paramDependency instanceof ConstraintWidgetContainer))) {
        bool = ((ConstraintWidgetContainer)paramDependency).isRtl();
      } else {
        bool = false;
      }
      int i11 = this.end.value - this.start.value;
      int i10 = this.widgets.size();
      int i = 0;
      for (;;)
      {
        j = -1;
        if (i >= i10) {
          break;
        }
        i4 = i;
        if (((WidgetRun)this.widgets.get(i)).widget.getVisibility() != 8) {
          break label133;
        }
        i += 1;
      }
      int i4 = -1;
      label133:
      int i9 = i10 - 1;
      i = i9;
      for (;;)
      {
        i5 = j;
        if (i < 0) {
          break label188;
        }
        if (((WidgetRun)this.widgets.get(i)).widget.getVisibility() != 8) {
          break;
        }
        i -= 1;
      }
      int i5 = i;
      label188:
      int n = 0;
      int i1;
      int i7;
      int i3;
      label474:
      float f2;
      while (n < 2)
      {
        i1 = 0;
        k = 0;
        i = 0;
        m = 0;
        f1 = 0.0F;
        while (i1 < i10)
        {
          paramDependency = (WidgetRun)this.widgets.get(i1);
          if (paramDependency.widget.getVisibility() == 8)
          {
            j = k;
            i2 = i;
          }
          else
          {
            i7 = m + 1;
            j = k;
            if (i1 > 0)
            {
              j = k;
              if (i1 >= i4) {
                j = k + paramDependency.start.margin;
              }
            }
            i2 = paramDependency.dimension.value;
            if (paramDependency.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
              m = 1;
            } else {
              m = 0;
            }
            if (m != 0)
            {
              if ((this.orientation == 0) && (!paramDependency.widget.horizontalRun.dimension.resolved)) {
                return;
              }
              i6 = m;
              i3 = i2;
              k = i;
              if (this.orientation == 1)
              {
                i6 = m;
                i3 = i2;
                k = i;
                if (paramDependency.widget.verticalRun.dimension.resolved) {}
              }
            }
            else
            {
              if ((paramDependency.matchConstraintsType == 1) && (n == 0))
              {
                k = paramDependency.dimension.wrapValue;
                m = i + 1;
                i = k;
                k = m;
              }
              else
              {
                i6 = m;
                i3 = i2;
                k = i;
                if (!paramDependency.dimension.resolved) {
                  break label474;
                }
                k = i;
                i = i2;
              }
              i6 = 1;
              i3 = i;
            }
            if (i6 == 0)
            {
              m = k + 1;
              float f3 = paramDependency.widget.mWeight[this.orientation];
              i = j;
              k = m;
              f2 = f1;
              if (f3 >= 0.0F)
              {
                f2 = f1 + f3;
                i = j;
                k = m;
              }
            }
            else
            {
              i = j + i3;
              f2 = f1;
            }
            j = i;
            i2 = k;
            m = i7;
            f1 = f2;
            if (i1 < i9)
            {
              j = i;
              i2 = k;
              m = i7;
              f1 = f2;
              if (i1 < i5)
              {
                j = i + -paramDependency.end.margin;
                f1 = f2;
                m = i7;
                i2 = k;
              }
            }
          }
          i1 += 1;
          k = j;
          i = i2;
        }
        if ((k >= i11) && (i != 0))
        {
          n += 1;
        }
        else
        {
          i6 = m;
          j = i;
          break label669;
        }
      }
      int i6 = 0;
      int k = 0;
      int j = 0;
      float f1 = 0.0F;
      label669:
      int m = this.start.value;
      if (bool) {
        m = this.end.value;
      }
      i = m;
      if (k > i11) {
        if (bool) {
          i = m + (int)((k - i11) / 2.0F + 0.5F);
        } else {
          i = m - (int)((k - i11) / 2.0F + 0.5F);
        }
      }
      if (j > 0)
      {
        f2 = i11 - k;
        i1 = (int)(f2 / j + 0.5F);
        i7 = 0;
        m = 0;
        n = i;
        while (i7 < i10)
        {
          paramDependency = (WidgetRun)this.widgets.get(i7);
          if ((paramDependency.widget.getVisibility() != 8) && (paramDependency.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (!paramDependency.dimension.resolved))
          {
            if (f1 > 0.0F) {
              i = (int)(paramDependency.widget.mWeight[this.orientation] * f2 / f1 + 0.5F);
            } else {
              i = i1;
            }
            if (this.orientation == 0)
            {
              i8 = paramDependency.widget.mMatchConstraintMaxWidth;
              i3 = paramDependency.widget.mMatchConstraintMinWidth;
              if (paramDependency.matchConstraintsType == 1) {
                i2 = Math.min(i, paramDependency.dimension.wrapValue);
              } else {
                i2 = i;
              }
              i3 = Math.max(i3, i2);
              i2 = i3;
              if (i8 > 0) {
                i2 = Math.min(i8, i3);
              }
              i8 = i;
              i3 = m;
              if (i2 == i) {
                break label1065;
              }
            }
            else
            {
              i3 = paramDependency.widget.mMatchConstraintMaxHeight;
              i8 = paramDependency.widget.mMatchConstraintMinHeight;
              if (paramDependency.matchConstraintsType == 1) {
                i2 = Math.min(i, paramDependency.dimension.wrapValue);
              } else {
                i2 = i;
              }
              i2 = Math.max(i8, i2);
              if (i3 > 0) {
                i2 = Math.min(i3, i2);
              }
              i8 = i;
              i3 = m;
              if (i2 == i) {
                break label1065;
              }
            }
            i3 = m + 1;
            int i8 = i2;
            label1065:
            paramDependency.dimension.resolve(i8);
            m = i3;
          }
          i7 += 1;
        }
        if (m > 0)
        {
          i1 = j - m;
          j = 0;
          i = 0;
          while (j < i10)
          {
            paramDependency = (WidgetRun)this.widgets.get(j);
            if (paramDependency.widget.getVisibility() != 8)
            {
              k = i;
              if (j > 0)
              {
                k = i;
                if (j >= i4) {
                  k = i + paramDependency.start.margin;
                }
              }
              k += paramDependency.dimension.value;
              i = k;
              if (j < i9)
              {
                i = k;
                if (j < i5) {
                  i = k + -paramDependency.end.margin;
                }
              }
            }
            j += 1;
          }
          j = i1;
        }
        else
        {
          i = k;
        }
        if ((this.chainStyle == 2) && (m == 0))
        {
          this.chainStyle = 0;
          k = i;
          i1 = j;
          i = n;
        }
        else
        {
          k = i;
          i1 = j;
          i = n;
        }
      }
      else
      {
        i1 = j;
      }
      j = 0;
      m = 0;
      n = 0;
      if (k > i11) {
        this.chainStyle = 2;
      }
      if ((i6 > 0) && (i1 == 0) && (i4 == i5)) {
        this.chainStyle = 2;
      }
      int i2 = this.chainStyle;
      if (i2 == 1)
      {
        if (i6 > 1) {
          j = (i11 - k) / (i6 - 1);
        } else if (i6 == 1) {
          j = (i11 - k) / 2;
        } else {
          j = 0;
        }
        m = j;
        if (i1 > 0) {
          m = 0;
        }
        j = n;
        for (k = i; j < i10; k = i)
        {
          if (bool) {
            i = i10 - (j + 1);
          } else {
            i = j;
          }
          paramDependency = (WidgetRun)this.widgets.get(i);
          if (paramDependency.widget.getVisibility() == 8)
          {
            paramDependency.start.resolve(k);
            paramDependency.end.resolve(k);
            i = k;
          }
          else
          {
            i = k;
            if (j > 0) {
              if (bool) {
                i = k - m;
              } else {
                i = k + m;
              }
            }
            k = i;
            if (j > 0)
            {
              k = i;
              if (j >= i4) {
                if (bool) {
                  k = i - paramDependency.start.margin;
                } else {
                  k = i + paramDependency.start.margin;
                }
              }
            }
            if (bool) {
              paramDependency.end.resolve(k);
            } else {
              paramDependency.start.resolve(k);
            }
            n = paramDependency.dimension.value;
            i = n;
            if (paramDependency.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
            {
              i = n;
              if (paramDependency.matchConstraintsType == 1) {
                i = paramDependency.dimension.wrapValue;
              }
            }
            if (bool) {
              k -= i;
            } else {
              k += i;
            }
            if (bool) {
              paramDependency.start.resolve(k);
            } else {
              paramDependency.end.resolve(k);
            }
            paramDependency.resolved = true;
            i = k;
            if (j < i9)
            {
              i = k;
              if (j < i5) {
                if (bool) {
                  i = k - -paramDependency.end.margin;
                } else {
                  i = k + -paramDependency.end.margin;
                }
              }
            }
          }
          j += 1;
        }
      }
      if (i2 == 0)
      {
        m = (i11 - k) / (i6 + 1);
        if (i1 > 0) {
          m = 0;
        }
        while (j < i10)
        {
          if (bool) {
            k = i10 - (j + 1);
          } else {
            k = j;
          }
          paramDependency = (WidgetRun)this.widgets.get(k);
          if (paramDependency.widget.getVisibility() == 8)
          {
            paramDependency.start.resolve(i);
            paramDependency.end.resolve(i);
          }
          else
          {
            if (bool) {
              k = i - m;
            } else {
              k = i + m;
            }
            i = k;
            if (j > 0)
            {
              i = k;
              if (j >= i4) {
                if (bool) {
                  i = k - paramDependency.start.margin;
                } else {
                  i = k + paramDependency.start.margin;
                }
              }
            }
            if (bool) {
              paramDependency.end.resolve(i);
            } else {
              paramDependency.start.resolve(i);
            }
            n = paramDependency.dimension.value;
            k = n;
            if (paramDependency.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
            {
              k = n;
              if (paramDependency.matchConstraintsType == 1) {
                k = Math.min(n, paramDependency.dimension.wrapValue);
              }
            }
            if (bool) {
              k = i - k;
            } else {
              k = i + k;
            }
            if (bool) {
              paramDependency.start.resolve(k);
            } else {
              paramDependency.end.resolve(k);
            }
            i = k;
            if (j < i9)
            {
              i = k;
              if (j < i5) {
                if (bool) {
                  i = k - -paramDependency.end.margin;
                } else {
                  i = k + -paramDependency.end.margin;
                }
              }
            }
          }
          j += 1;
        }
      }
      if (i2 == 2)
      {
        if (this.orientation == 0) {
          f1 = this.widget.getHorizontalBiasPercent();
        } else {
          f1 = this.widget.getVerticalBiasPercent();
        }
        f2 = f1;
        if (bool) {
          f2 = 1.0F - f1;
        }
        j = (int)((i11 - k) * f2 + 0.5F);
        if ((j < 0) || (i1 > 0)) {
          j = 0;
        }
        if (bool)
        {
          i -= j;
          j = m;
        }
        else
        {
          i += j;
          j = m;
        }
        while (j < i10)
        {
          if (bool) {
            k = i10 - (j + 1);
          } else {
            k = j;
          }
          paramDependency = (WidgetRun)this.widgets.get(k);
          if (paramDependency.widget.getVisibility() == 8)
          {
            paramDependency.start.resolve(i);
            paramDependency.end.resolve(i);
          }
          else
          {
            k = i;
            if (j > 0)
            {
              k = i;
              if (j >= i4) {
                if (bool) {
                  k = i - paramDependency.start.margin;
                } else {
                  k = i + paramDependency.start.margin;
                }
              }
            }
            if (bool) {
              paramDependency.end.resolve(k);
            } else {
              paramDependency.start.resolve(k);
            }
            i = paramDependency.dimension.value;
            if ((paramDependency.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (paramDependency.matchConstraintsType == 1)) {
              i = paramDependency.dimension.wrapValue;
            }
            if (bool) {
              k -= i;
            } else {
              k += i;
            }
            if (bool) {
              paramDependency.start.resolve(k);
            } else {
              paramDependency.end.resolve(k);
            }
            i = k;
            if (j < i9)
            {
              i = k;
              if (j < i5) {
                if (bool) {
                  i = k - -paramDependency.end.margin;
                } else {
                  i = k + -paramDependency.end.margin;
                }
              }
            }
          }
          j += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.solver.widgets.analyzer.ChainRun
 * JD-Core Version:    0.7.0.1
 */